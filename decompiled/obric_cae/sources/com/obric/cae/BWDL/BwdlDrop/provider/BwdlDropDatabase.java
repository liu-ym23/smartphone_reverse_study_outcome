package com.obric.cae.BWDL.BwdlDrop.provider;

import android.content.Context;
import android.net.Uri;
import android.os.Process;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropSession;
import com.obric.cae.log.CaeLog;
import com.obric.cae.utils.CaeProviderUtils;
import defpackage.b;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class BwdlDropDatabase {
    private static final String SHARE_ITEM_SELECTION = "Uri =? AND Timestamp =?";
    private static final String TAG = "BwdlDropDatabase";
    private static final String TIMESTAMP_SELECTION = "Timestamp =? ";
    private Context mContext;

    public class InsertShareInfoThread extends Thread {
        private final boolean mIsMultiple;
        private String mRemoteDeviceMac;
        private final BwdlDropSession mSession;
        private BwdlDropShareItem mShareItem;
        private List<BwdlDropShareItem> mShareItemList;
        final /* synthetic */ BwdlDropDatabase this$0;

        public InsertShareInfoThread(BwdlDropDatabase r8, BwdlDropSession r10) {
            this.this$0 = r8;
            super("Insert ShareInfo Thread");
            this.mShareItemList = new CopyOnWriteArrayList();
            this.mSession = r10;
            this.mRemoteDeviceMac = r10.getRemoteDeviceMac();
            this.mIsMultiple = r10.getMultipleFlag();
        }

        private void insertMultipleShare() {
            Iterator<BwdlDropShareItem> r8 = this.mShareItemList.iterator();
        L4:
            if (r8.hasNext() == false) goto L6;
            BwdlDropShareItem r10 = r8.next();
            CaeProviderUtils.caeEntryClass r11 = new CaeProviderUtils.caeEntryClass();
            BwdlDropProvider.BwdlDropDbEntry r12 = new BwdlDropProvider.BwdlDropDbEntry();
            r12.Uri = r10.getUri().toString();
            r12.Total_Size = r10.getSize();
            r12.Timestamp = this.mSession.getTimestamp();
            r12.Position = 0;
            r12.MAC = this.mSession.getRemoteDeviceMac();
            r12.File_Name = r10.getFileName();
            r12.Mime_Type = r10.getMimeType();
            r12.Direction = this.mSession.getDirection();
            r12.Remote_Device_name = this.mSession.getRemoteDeviceName();
            r12.Status = 0;
            r11.setData(r12);
            CaeProviderUtils.saveToDatabase(BwdlDropDatabase.access$000(this.this$0), BwdlDropProvider.BWDL_DROP_URI, r11);
            goto L4
        }

        private void insertSingleShare() {
            CaeProviderUtils.caeEntryClass r8 = new CaeProviderUtils.caeEntryClass();
            BwdlDropProvider.BwdlDropDbEntry r10 = new BwdlDropProvider.BwdlDropDbEntry();
            r10.Uri = this.mShareItem.getUri().toString();
            r10.Total_Size = this.mShareItem.getSize();
            r10.Timestamp = this.mSession.getTimestamp();
            r10.Position = 0;
            r10.MAC = this.mSession.getRemoteDeviceMac();
            r10.File_Name = this.mShareItem.getFileName();
            r10.Mime_Type = this.mShareItem.getMimeType();
            r10.Direction = this.mSession.getDirection();
            r10.Remote_Device_name = this.mSession.getRemoteDeviceName();
            r10.Status = 0;
            r8.setData(r10);
            CaeProviderUtils.saveToDatabase(BwdlDropDatabase.access$000(this.this$0), BwdlDropProvider.BWDL_DROP_URI, r8);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            if (this.mRemoteDeviceMac != null) goto L7;
            CaeLog.e(BwdlDropDatabase.TAG, "Target device is null!");
            return;
        L7:
            if (this.mIsMultiple == false) goto L9;
            this.mShareItemList = this.mSession.getShareItemList();
            insertMultipleShare();
            return;
        L9:
            this.mShareItem = this.mSession.getShareItemList().get(0);
            insertSingleShare();
        }
    }

    public BwdlDropDatabase(Context r8) {
        this.mContext = r8;
    }

    public static /* synthetic */ Context access$000(BwdlDropDatabase r8) {
        return r8.mContext;
    }

    public String queryShareInfoField(Uri r8, long r10, String r11) {
        b.o("queryShareInfoField: ", r11, TAG);
        return CaeProviderUtils.queryDatabaseKeyValue(this.mContext, BwdlDropProvider.BWDL_DROP_URI, SHARE_ITEM_SELECTION, new String[]{r8.toString(), Long.toString(r10)}, r11);
    }

    public List<Map<String, String>> queryShareInfoItem(long r8) {
        CaeLog.d(TAG, "queryShareInfoItem: " + r8);
        return CaeProviderUtils.queryDatabaseEntryList(this.mContext, BwdlDropProvider.BWDL_DROP_URI, TIMESTAMP_SELECTION, new String[]{Long.toString(r8)});
    }

    public void storeShareInfoToDB(BwdlDropSession r8) {
        CaeLog.d(TAG, "storeShareInfoToDB");
        new InsertShareInfoThread(this, r8).start();
    }

    public void updateSessionInfoFieldToDB(BwdlDropSession r11, String r12, Object r13) {
        CaeLog.d(TAG, "updateSessionInfoFieldToDB: " + r12 + " updateValue:" + r13);
        List<BwdlDropShareItem> r8 = r11.getShareItemList();
        long r10 = r11.getTimestamp();
        if (r8 != null) goto L5;
    L12:
        CaeLog.d(TAG, "mShareItemList is empty");
        return;
    L5:
        if (r8.isEmpty() == true) goto L12;
        Iterator<BwdlDropShareItem> r14 = r8.iterator();
    L9:
        if (r14.hasNext() == false) goto L11;
        CaeProviderUtils.updateDatabaseKeyType(this.mContext, BwdlDropProvider.BWDL_DROP_URI, SHARE_ITEM_SELECTION, new String[]{r14.next().getUri().toString(), Long.toString(r10)}, new String[]{r12}, new String[]{r13.toString()});
        goto L9
    }

    public void updateShareInfoFieldToDB(Uri r8, long r10, String r11, Object r12) {
        CaeLog.d(TAG, "updateShareInfoFieldToDB: " + r11 + " updateValue:" + r12);
        CaeProviderUtils.updateDatabaseKeyType(this.mContext, BwdlDropProvider.BWDL_DROP_URI, SHARE_ITEM_SELECTION, new String[]{r8.toString(), Long.toString(r10)}, new String[]{r11}, new String[]{r12.toString()});
    }
}
