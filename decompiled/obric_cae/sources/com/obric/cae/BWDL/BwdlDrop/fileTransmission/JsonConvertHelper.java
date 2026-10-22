package com.obric.cae.BWDL.BwdlDrop.fileTransmission;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.AsyncTask;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropConstant;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropDeviceManager;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropSession;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropUtils;
import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropDatabase;
import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropProvider;
import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropShareItem;
import com.obric.cae.log.CaeLog;
import com.sdk.bwdl.BWDLDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class JsonConvertHelper {
    private static final String TAG = "JsonConvertHelper";

    public static class FileProcessingTask extends AsyncTask<JSONArray, Void, List<BwdlDropShareItem>> {
        private final Context mContext;
        private BwdlDropDatabase mDataBase;
        private final BwdlDropSession mSession;
        private final List<BwdlDropShareItem> mShareItemList;

        public FileProcessingTask(Context r8, List<BwdlDropShareItem> r10, BwdlDropSession r11) {
            Context r12 = r8.getApplicationContext();
            this.mContext = r12;
            this.mShareItemList = r10;
            this.mSession = r11;
            this.mDataBase = new BwdlDropDatabase(r12);
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ List<BwdlDropShareItem> doInBackground(JSONArray[] r8) {
            return doInBackground2(r8);
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onPostExecute(List<BwdlDropShareItem> r8) {
            onPostExecute2(r8);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        public List<BwdlDropShareItem> doInBackground2(JSONArray... r13) {
            int r8 = 0;
            JSONArray r14 = r13[0];
            ArrayList r10 = new ArrayList();
        L10:
        L7:
            e = move-exception;
            CaeLog.d(JsonConvertHelper.TAG, "exception:" + e.getMessage());
        L9:
            return r10;
        L4:
            if (r8 >= r14.length()) goto L9;
            JSONObject r11 = (JSONObject) r14.get(r8);     // Catch: Exception -> L7
            String r12 = r11.getString(BwdlDropConstant.FILE_NAME);     // Catch: Exception -> L7
            String r15 = r11.getString(BwdlDropConstant.MIME_TYPE);     // Catch: Exception -> L7
            long r16 = r11.getLong(BwdlDropConstant.FILE_SIZE);     // Catch: Exception -> L7
            r10.add(new BwdlDropShareItem(this.mContext, BwdlDropUtils.ObtainFileUri(this.mContext, r12, r15), r15, r16, null));     // Catch: Exception -> L7
            r8 = r8 + 1;
            goto L10
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        public void onPostExecute2(List<BwdlDropShareItem> r8) {
            if (r8 == null) goto L5;
            this.mShareItemList.addAll(r8);
            this.mSession.setShareItemList(this.mShareItemList);
            this.mDataBase.storeShareInfoToDB(this.mSession);
            this.mDataBase.updateSessionInfoFieldToDB(this.mSession, BwdlDropProvider.BwdlDropEntry.STATUS, 1);
            return;
        }
    }

    public JsonConvertHelper() {
    }

    public static JSONObject buildSendNotify(String r8) {
        JSONObject r10 = new JSONObject();
        r10.put(BwdlDropConstant.SENDER_NAME, r8);     // Catch: JSONException -> L5
    L7:
        return r10;
    L5:
        e = move-exception;
        CaeLog.d(TAG, "exception:" + e.getMessage());
        goto L7
    }

    public static JSONObject buildSendRequest(BwdlDropSession r8, String r10) {
        JSONObject r11 = new JSONObject();
        JSONArray r12 = new JSONArray();
        List<BwdlDropShareItem> r13 = r8.getShareItemList();
        r11.put(BwdlDropConstant.SENDER_NAME, r10);     // Catch: JSONException -> L9
        r11.put(BwdlDropConstant.FILE_COUNT, r8.getFileCount());     // Catch: JSONException -> L9
        r11.put(BwdlDropConstant.TOTAL_SIZE, r8.getFileTotalSize());     // Catch: JSONException -> L9
        Iterator<BwdlDropShareItem> r14 = r13.iterator();     // Catch: JSONException -> L9
    L5:
        if (r14.hasNext() == false) goto L7;
        BwdlDropShareItem r15 = r14.next();     // Catch: JSONException -> L9
        JSONObject r16 = new JSONObject();     // Catch: JSONException -> L9
        r16.put(BwdlDropConstant.FILE_NAME, r15.getFileName());     // Catch: JSONException -> L9
        r16.put(BwdlDropConstant.MIME_TYPE, r15.getMimeType());     // Catch: JSONException -> L9
        r16.put(BwdlDropConstant.FILE_SIZE, r15.getSize());     // Catch: JSONException -> L9
        r12.put(r16);     // Catch: JSONException -> L9
        goto L5
    L7:
        r11.put(BwdlDropConstant.FILE, r12);     // Catch: JSONException -> L9
    L11:
        CaeLog.d(TAG, "json:" + r11.toString());
        return r11;
    L9:
        e = move-exception;
        CaeLog.d(TAG, "exception:" + e.getMessage());
        goto L11
    }

    public static JSONObject buildSendResponse(String r8, String r10) {
        JSONObject r11 = new JSONObject();
        r11.put(BwdlDropConstant.TASK_ID, r8);     // Catch: JSONException -> L5
        r11.put("type", 1);     // Catch: JSONException -> L5
        r11.put("reason", r10);     // Catch: JSONException -> L5
    L7:
        return r11;
    L5:
        e = move-exception;
        CaeLog.d(TAG, "exception:" + e.getMessage());
        goto L7
    }

    public static JSONObject buildTransferError(String r8, int r10, String r11) {
        JSONObject r12 = new JSONObject();
        r12.put(BwdlDropConstant.TASK_ID, r8);     // Catch: JSONException -> L5
        r12.put("type", r10);     // Catch: JSONException -> L5
        r12.put("reason", r11);     // Catch: JSONException -> L5
    L7:
        return r12;
    L5:
        e = move-exception;
        CaeLog.d(TAG, "exception:" + e.getMessage());
        goto L7
    }

    public static JSONObject buildTransferSuccess(String r8) {
        JSONObject r10 = new JSONObject();
        r10.put(BwdlDropConstant.TASK_ID, r8);     // Catch: JSONException -> L5
        r10.put("type", 1);     // Catch: JSONException -> L5
    L7:
        return r10;
    L5:
        e = move-exception;
        CaeLog.d(TAG, "exception:" + e.getMessage());
        goto L7
    }

    public static BwdlDropSession parseFileShareRequest(Context r11, JSONObject r12, BwdlDropDeviceManager r13) {
        CopyOnWriteArrayList r8 = new CopyOnWriteArrayList();
        BWDLDevice r14 = r13.getControlLinkDevice();
        BwdlDropSession r10 = null;
        if (r14 == null) goto L5;
        String r15 = ((BluetoothDevice) r14.getDeviceInfo()).getAddress();
    L7:
        if (r12 != null) goto L20;
        CaeLog.e(TAG, "jsonObject is null!!!!!");
        return null;
    L20:
        long r16 = r12.getLong(BwdlDropConstant.TOTAL_SIZE);     // Catch: JSONException -> L15
        String r17 = r12.getString(BwdlDropConstant.SENDER_NAME);     // Catch: JSONException -> L15
        int r18 = r12.getInt(BwdlDropConstant.FILE_COUNT);     // Catch: JSONException -> L15
        JSONArray r19 = r12.getJSONArray(BwdlDropConstant.FILE);     // Catch: JSONException -> L15
        BwdlDropSession r110 = new BwdlDropSession(r11, r8, r18, r16);     // Catch: JSONException -> L15
        r110.setRemoteDeviceInfo(r15, r17);     // Catch: JSONException -> L13
        r110.setDirection(1);     // Catch: JSONException -> L13
        new FileProcessingTask(r11, r8, r110).execute(new JSONArray[]{r19});     // Catch: JSONException -> L13
        return r110;
    L13:
        e = e;
        r10 = r110;
    L16:
        CaeLog.d(TAG, "exception:" + e.getMessage());
        return r10;
    L15:
        e = e;
        goto L16
    L5:
        r15 = null;
        goto L7
    }

    public static String parseFileShareResp(JSONObject r8) {
        r8.getInt("type");     // Catch: JSONException -> L4
        return r8.getString("reason");
    L4:
        e = move-exception;
        CaeLog.d(TAG, "exception:" + e.getMessage());
        return null;
    }

    public static String parseTransferStatus(JSONObject r8) {
        r8.getString(BwdlDropConstant.TASK_ID);     // Catch: JSONException -> L13
        int r10 = r8.getInt("type");     // Catch: JSONException -> L13
        if (r10 != 2) goto L6;
    L11:
        String r11 = r8.getString("reason");     // Catch: JSONException -> L13
    L19:
        return r11;
    L6:
        if (r10 == 3) goto L11;
        if (r10 != 1) goto L18;
        r11 = BwdlDropConstant.REASON_TRANSFER_COMPLETE;
        goto L19
    L18:
        return null;
    L13:
        e = move-exception;
        CaeLog.d(TAG, "exception:" + e.getMessage());
        return null;
    }
}
