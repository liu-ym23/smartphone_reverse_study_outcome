package com.obric.cae.BWDL.BwdlDrop.fileTransmission;

import android.content.Context;
import android.net.Uri;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropConstant;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropDeviceManager;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropEventHandler;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropManager;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropSession;
import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropDatabase;
import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropProvider;
import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropShareItem;
import com.obric.cae.log.CaeLog;
import com.sdk.bwdl.BWDLDevice;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FileTransfer {
    private static final String TAG = "FileTransfer";
    private BwdlDropManager mBwdlDropManager;
    private Context mContext;
    private BwdlDropDatabase mDatabase;
    private BwdlDropDeviceManager mDeviceManager;
    private BwdlDropEventHandler mEventHandler;
    private BwdlDropSession mSession;

    public FileTransfer(Context r8, BwdlDropDeviceManager r10) {
        this.mContext = r8;
        this.mBwdlDropManager = BwdlDropManager.getInstance(r8);
        this.mDeviceManager = r10;
        this.mSession = r10.getBwdlDropSession();
        this.mDatabase = new BwdlDropDatabase(this.mContext);
        this.mEventHandler = this.mBwdlDropManager.getEventHandler();
    }

    private boolean SendFile() {
        CaeLog.d(TAG, "SendFile");
        SocketChannel r8 = null;
        if (this.mBwdlDropManager.getSession() == null) goto L5;
        List<BwdlDropShareItem> r10 = this.mBwdlDropManager.getSession().getShareItemList();
    L6:
        BWDLDevice r11 = this.mDeviceManager.getDataLinkDevice();
        if (r11 != null) goto L9;
    L11:
        boolean r12 = false;
        if (r8 == null) goto L59;
        if (r10 == null) goto L59;
        if (this.mSession == null) goto L59;
        long r13 = System.currentTimeMillis();
        Iterator<BwdlDropShareItem> r14 = r10.iterator();
        long r15 = 0;
        long r16 = 0;
    L19:
        if (r14.hasNext() == false) goto L53;
        BwdlDropShareItem r17 = r14.next();
        Uri r18 = r17.getUri();
        if (this.mSession.isCancel() == true) goto L53;
        FileInputStream r19 = r17.getFileInputStream();     // Catch: IOException -> L49
        if (r19 == null) goto L25;
        FileChannel r20 = r19.getChannel();     // Catch: IOException -> L49
        r8.configureBlocking(true);     // Catch: IOException -> L49
        long r110 = r20.size();     // Catch: IOException -> L49
        StringBuilder r21 = new StringBuilder();     // Catch: IOException -> L49
        r21.append("file size：");     // Catch: IOException -> L47
        r21.append(r110);     // Catch: IOException -> L47
        r21.append(" uri:");     // Catch: IOException -> L47
        r21.append(r18);     // Catch: IOException -> L47
        CaeLog.d(TAG, r21.toString());     // Catch: IOException -> L47
        long r22 = r15;
    L30:
        if (r22 == r110) goto L34;
        if (r22 < r110) goto L34;
        FileChannel r111 = r20;
        r15 = r22;
        boolean r23 = false;
        boolean r112 = true;
        int r25 = 5;
    L65:
        r111.force(r23);     // Catch: IOException -> L45
        r12 = false;
    L45:
        e = e;
    L52:
        CaeLog.d(TAG, e.toString());
        this.mBwdlDropManager.sendTransferFailForUser(BwdlDropConstant.REASON_USER_INTERRUPT, this.mSession);
    L55:
        if (this.mSession.getFileTotalSize() != r16) goto L57;
        CaeLog.d(TAG, "Transfer success, total time time：" + (System.currentTimeMillis() - r13));
        int r24 = r25;
        this.mSession.setState(r24);
        this.mSession.notifyObserversStatusChange(r24);
    L58:
        return r112;
    L57:
        CaeLog.d(TAG, "Transfer interrupt");
        this.mSession.setState(r25);
        this.mSession.notifyObserversStatusChange(4);
    L34:
        Uri r26 = r18;
        r25 = 5;
        r111 = r20;
        r112 = true;
        long r27 = r20.transferTo(r22, Math.min(20971520, r110 - r22), r8);     // Catch: IOException -> L45
        if (r27 <= 0) goto L38;
        r15 = r22 + r27;     // Catch: IOException -> L45
        this.mSession.notifyObserversProgressChanged(r16 + r15);     // Catch: IOException -> L45
        this.mDatabase.updateShareInfoFieldToDB(r26, this.mSession.getTimestamp(), BwdlDropProvider.BwdlDropEntry.POSITION, Long.valueOf(r15));     // Catch: IOException -> L45
        if (this.mSession.isCancel() == true) goto L41;
        r22 = r15;
        r20 = r111;
        r18 = r26;
    L41:
        r23 = false;
        goto L65
    L38:
        r16 = r16 + r22;     // Catch: IOException -> L45
        CaeLog.d(TAG, "file transfer success:" + r26.toString());     // Catch: IOException -> L45
        this.mDatabase.updateShareInfoFieldToDB(r26, this.mSession.getTimestamp(), BwdlDropProvider.BwdlDropEntry.STATUS, 5);     // Catch: IOException -> L45
        r15 = 0;
    L47:
        e = e;
        r112 = true;
    L51:
        r25 = 5;
        goto L52
    L25:
        CaeLog.d(TAG, "fileInputStream == null!");     // Catch: IOException -> L49
        return r12;
    L49:
        e = e;
        r112 = true;
    L53:
        r112 = true;
        r25 = 5;
    L59:
        CaeLog.d(TAG, "send file err! socketChannel:" + r8 + " mSession:" + this.mSession);
        this.mSession.notifyObserversStatusChange(4);
        return false;
    L9:
        if (r11.getConnectivityType() != BWDLInnerConstant.ConnectivityType.SocketChannel) goto L11;
        r8 = (SocketChannel) r11.getDeviceInfo();
        goto L11
    L5:
        r10 = null;
        goto L6
    }

    public void execute() {
        SendFile();
    }
}
