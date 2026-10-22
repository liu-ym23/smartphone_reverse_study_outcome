package com.obric.cae.BWDL.BwdlDrop.fileTransmission;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropConstant;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropDeviceManager;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropManager;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropSession;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropUtils;
import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropDatabase;
import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropProvider;
import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropShareItem;
import com.obric.cae.log.CaeLog;
import com.sdk.bwdl.BWDLDevice;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import defpackage.b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FileReceiver {
    private static final String TAG = "FileReceiver";
    private BwdlDropManager mBwdlDropManager;
    private Context mContext;
    private BwdlDropDatabase mDatabase;
    private BwdlDropDeviceManager mDeviceManager;
    private BwdlDropSession mSession;

    public static class ScanFileAsyncTask extends AsyncTask<String, Void, String> {
        private Context mContext;

        public ScanFileAsyncTask(Context r8) {
            this.mContext = r8;
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ String doInBackground(String[] r8) {
            return doInBackground2(r8);
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onPostExecute(String r8) {
            onPostExecute2(r8);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        public String doInBackground2(String... r8) {
            String r10 = r8[0];
            return Paths.get(BwdlDropUtils.obtainReceiveDirectoryPath(r10), new String[]{r10}).toString();
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        public void onPostExecute2(String r8) {
            MediaScannerConnection.scanFile(this.mContext, new String[]{r8}, null, null);
        }
    }

    public FileReceiver(Context r8, BwdlDropDeviceManager r10) {
        this.mContext = r8;
        this.mBwdlDropManager = BwdlDropManager.getInstance(r8);
        this.mDeviceManager = r10;
        this.mSession = r10.getBwdlDropSession();
        this.mDatabase = new BwdlDropDatabase(this.mContext);
    }

    private void deleteIncompleteFile(String r8) {
        b.o("deleteIncompleteFile: ", r8, TAG);
        if (r8 != null) goto L5;
        return;
    L5:
        String r10 = Paths.get(BwdlDropUtils.obtainReceiveDirectoryPath(r8), new String[]{r8}).toString();
        File r11 = new File(r10);
        if (r11.exists() == true) goto L8;
        StringBuilder r12 = new StringBuilder("File does not exist: ");
    L12:
        r12.append(r10);
        CaeLog.d(TAG, r12.toString());
        return;
    L8:
        if (r11.delete() == false) goto L10;
        r12 = new StringBuilder("Deleted incomplete file: ");
        goto L12
    L10:
        CaeLog.e(TAG, "Failed to delete incomplete file: " + r10);
    }

    private FileOutputStream obtainFileOutputStream(String r8) {
        File r10 = Paths.get(BwdlDropUtils.obtainReceiveDirectoryPath(r8), new String[]{r8}).toFile();     // Catch: IOException -> L8
        File r11 = r10.getParentFile();     // Catch: IOException -> L8
        if (r11.exists() == true) goto L6;
        r11.mkdirs();     // Catch: IOException -> L8
    L6:
        r10.createNewFile();     // Catch: IOException -> L8
        CaeLog.d(TAG, "receive files: " + r10.toString());     // Catch: IOException -> L8
        return new FileOutputStream(r10);
    L8:
        e = move-exception;
        CaeLog.e(TAG, e.getMessage());
        return null;
    }

    private boolean receiveFile() {
        Log.d(TAG, "receive file");
        long r8 = System.currentTimeMillis();
        BwdlDropSession r10 = this.mSession;
        boolean r11 = false;
        if (r10 != null) goto L5;
        return false;
    L5:
        List<BwdlDropShareItem> r12 = r10.getShareItemList();
        BWDLDevice r13 = this.mDeviceManager.getDataLinkDevice();
        String r14 = null;
        if (r13 != null) goto L8;
    L10:
        SocketChannel r15 = null;
    L12:
        if (r15 != null) goto L15;
        CaeLog.d(TAG, "socketChannel == null");
        this.mSession.notifyObserversStatusChange(4);
        return false;
    L15:
        Iterator<BwdlDropShareItem> r16 = r12.iterator();
        long r17 = 0;
        long r18 = 0;
    L17:
        if (r16.hasNext() == false) goto L46;
        BwdlDropShareItem r19 = r16.next();
        long r110 = r19.getSize();
        String r111 = r19.getFileName();
        Uri r20 = r19.getUri();
        CaeLog.d(TAG, "fileUri:" + r20.toString() + " size:" + r110);
        if (this.mSession.isCancel() == true) goto L20;
        FileChannel r112 = obtainFileOutputStream(r111).getChannel();     // Catch: IOException -> L43
        long r21 = r17;
    L23:
        if (r21 < r110) goto L27;
        if (r21 == r110) goto L27;
        boolean r113 = r11;
        SocketChannel r25 = r15;
        String r28 = r111;
        r17 = r21;
        int r29 = 5;
    L55:
        r112.force(r113);     // Catch: IOException -> L41
        if (r28 == null) goto L39;
        new ScanFileAsyncTask(this.mContext).execute(new String[]{r28});     // Catch: IOException -> L41
    L39:
        r11 = r113;
        r15 = r25;
        r14 = r28;
    L41:
        e = e;
    L45:
        CaeLog.d(TAG, e.toString());
        this.mBwdlDropManager.sendTransferFailForUser(BwdlDropConstant.REASON_USER_INTERRUPT, this.mSession);
        r14 = r28;
    L48:
        if (this.mSession.getFileTotalSize() != r18) goto L50;
        CaeLog.d(TAG, "ReceiveFile done, receive time：" + (System.currentTimeMillis() - r8));
        this.mSession.notifyObserversStatusChange(r29);
        return true;
    L50:
        CaeLog.d(TAG, "ReceiveFile interrupt");
        this.mSession.notifyObserversStatusChange(4);
        deleteIncompleteFile(r14);
        return true;
    L27:
        r25 = r15;
        long r26 = r110;
        r28 = r111;
        r29 = 5;
        long r22 = r112.transferFrom(r25, r21, Math.min(20971520, r110 - r21));     // Catch: IOException -> L41
        if (r22 <= 0) goto L31;
        long r23 = r21 + r22;     // Catch: IOException -> L41
        this.mSession.notifyObserversProgressChanged(r18 + r23);     // Catch: IOException -> L41
        this.mDatabase.updateShareInfoFieldToDB(r20, this.mSession.getTimestamp(), BwdlDropProvider.BwdlDropEntry.POSITION, Long.valueOf(r23));     // Catch: IOException -> L41
        if (this.mSession.isCancel() == true) goto L34;
        r21 = r23;
        r15 = r25;
        r110 = r26;
        r111 = r28;
        r11 = false;
        goto L23
    L34:
        r17 = r23;
    L35:
        r113 = false;
        goto L55
    L31:
        r18 = r18 + r21;     // Catch: IOException -> L41
        CaeLog.d(TAG, "file receive success:" + r20.toString());     // Catch: IOException -> L41
        this.mDatabase.updateShareInfoFieldToDB(r20, this.mSession.getTimestamp(), BwdlDropProvider.BwdlDropEntry.STATUS, 5);     // Catch: IOException -> L41
        r17 = 0;
    L43:
        e = e;
        r28 = r111;
        r29 = 5;
        goto L45
    L20:
        r14 = r111;
    L46:
        r29 = 5;
        goto L48
    L8:
        if (r13.getConnectivityType() != BWDLInnerConstant.ConnectivityType.SocketChannel) goto L10;
        r15 = (SocketChannel) r13.getDeviceInfo();
        goto L12
    }

    public void execute() {
        receiveFile();
    }
}
