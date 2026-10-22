package com.qualcomm.qti.qesdk;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import com.qualcomm.qti.qesdkIntf.IQesdkCallBack;
import com.qualcomm.qti.qesdkIntf.IQesdkEventCallBack;
import com.qualcomm.qti.qesdkIntf.IQesdkFunctionType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class QesdkNative extends QesdkBase {
    private static final String LICENSE_FILE_NAME = "license.qti";
    private static final String LOG_TAG = "Qesdk Sdk";
    private static QesdkPlatVersion platLibVersion;

    public class QesdkNativeTaskResultHandler extends QesdkBase.QesdkBaseTaskResultHandler {
        final /* synthetic */ QesdkNative this$0;

        public QesdkNativeTaskResultHandler(QesdkNative r8, int r10, String r11) {
            this.this$0 = r8;
            super(r8, r10, r11);
        }

        @Override // com.qualcomm.qti.qesdk.QesdkBase.QesdkBaseTaskResultHandler
        public void handleReturnResponse(QesdkBase.QesdkFunctionTypeCallbackWrapper r8, QesdkOutputDataParser r10, IQesdkFunctionType r11) {
            QesdkUtils.LOG.w(QesdkNative.LOG_TAG, "erroneous result.");
        }
    }

    public static class QesdkPlatVersion {
        private int major;
        private int minor;
        private int patch;

        public QesdkPlatVersion(int r8, int r10, int r11) {
            this.major = r8;
            this.minor = r10;
            this.patch = r11;
        }

        public int getMajor() {
            return this.major;
        }

        public int getMinor() {
            return this.minor;
        }

        public int getPatch() {
            return this.patch;
        }

        public void setMajor(int r8) {
            this.major = r8;
        }

        public void setMinor(int r8) {
            this.minor = r8;
        }

        public void setPatch(int r8) {
            this.patch = r8;
        }
    }

    private QesdkNative(Context r8) {
        super(r8);
    }

    private void cleanUpTaskPool() {
        ThreadPoolExecutor r8 = this.execTaskPool;
        if (r8 == null) goto L5;
        r8.shutdown();
    L5:
        QesdkUtils.QesdkThreadPoolStats r10 = this.mStats;
        if (r10 == null) goto L9;
        r10.terminate();
        return;
    }

    private native int deInit(int r8, int r10, int r11);

    public static QesdkNative getInstance(Context r8) {
        return new QesdkNative(r8);
    }

    public static native void getPlatformVersion(QesdkPlatVersion r8);

    private native HashMap<Pair<String, Integer>, String[]> getServiceAPI();

    private native String getStruct(String r8, int r10, String r11);

    private native int getTransactionId();

    private native String getVector(String r8, int r10, String r11);

    private native String getVectorType(String r8, int r10, String r11);

    private native int init(String r8, int r10, int r11);

    private native String isApiAvailable(int r8, int r10, int r11, int r12, String r13);

    private void onAsyncResult(String r8, int r10, int r11) {
        if (r8.equals("completecleanupnotify") == false) goto L7;
        if (r10 != 0) goto L7;
        if (r11 != 0) goto L7;
        completeCleanUp();
    L7:
        if (r10 > 0) goto L9;
        return;
    L9:
        new QesdkNativeTaskResultHandler(this, r11, r8).run();
    }

    private void onEvent(int r8, int[] r10) {
        if (r8 != 0) goto L9;
        Iterator<Map.Entry<Pair<Integer, Integer>, IQesdkEventCallBack>> r11 = this.opcode_subsys_callback_map.entrySet().iterator();
    L5:
        if (r11.hasNext() == false) goto L29;
        IQesdkEventCallBack r12 = r11.next().getValue();
        if (r12 == null) goto L5;
        r12.onEvent(r8, r10);
        goto L5
    L29:
        return;
    L9:
        int r13 = 0;
    L11:
        if (r13 >= r10.length) goto L16;
        IQesdkEventCallBack r14 = this.opcode_subsys_callback_map.get(new Pair(Integer.valueOf(r8), Integer.valueOf(r10[r13])));
        int[] r15 = {r10[r13]};
        if (r14 == null) goto L15;
        r14.onEvent(r8, r15);
    L15:
        r13 = r13 + 1;
        goto L11
    L16:
        IQesdkEventCallBack r16 = this.opcode_subsys_callback_map.get(new Pair(0, 0));
        if (r16 == null) goto L28;
        r16.onEvent(r8, r10);
        return;
    }

    private native String performTask(String r8, int r10, int r11);

    private Bundle performTaskCommon(int r15, IQesdkFunctionType r16, Bundle r17, QesdkBase.CallType r18, IQesdkCallBack r19) {
        Bundle r8 = new Bundle();
        if (r16 != null) goto L6;
        QesdkUtils.LOG.e(LOG_TAG, "Api type is null, it cannot be null");
        r8.putInt("status", -1);
        return r8;
    L6:
        int r10 = r16.getNumberOfArgs();
        int r11 = r17.size();
        if (r10 != r11) goto L9;
    L12:
        String r12 = r16.getFunctionName();
        if (platLibVersion.getMajor() < 3) goto L15;
        StringBuilder r13 = android.aimedia.a.k(r12, "?version=");
        r13.append(r16.getFunctionVersion());
        r12 = r13.toString();
    L15:
        String r14 = isApiAvailable(this.sessionId, Integer.decode(r16.getOpCode()).intValue(), r16.getSSId(), r10, r12);
        if (r14 != null) goto L18;
    L42:
        QesdkUtils.LOG.e(LOG_TAG, "api not found.");
        r8.putInt("status", -6);
        return r8;
    L18:
        if (r14.equals("") == true) goto L42;
        int r110 = getTransactionId();
        if (r110 > 0) goto L44;
        QesdkUtils.LOG.e(LOG_TAG, "Failed to get transac id: " + r110);
        r8.putInt("status", -1);
        return r8;
    L44:
        String r20 = buildTaskInputData(r16, r17, new JSONArray(r14), r18, r110);
        if (r20 != null) goto L30;
        QesdkUtils.LOG.e(LOG_TAG, "Failed to build input data.");
        r8.putInt("status", -2);
        return r8;
    L30:
        if (r18 != QesdkBase.CallType.ASYNC) goto L32;
        this.mTaskMap.put(Integer.valueOf(r110), new QesdkBase.QesdkFunctionTypeCallbackWrapper(this, r16, null, r19));
        QesdkUtils.QesdkTimer r21 = this.mQesdkTimer;
        String r22 = "PerformTaskAsync SDK time taken to build southBoundData";
    L33:
        r21.stop(LOG_TAG, r22);
        String r23 = performTask(r20, r110, this.sessionId);
        this.mQesdkTimer.start();
        if (buildSyncResponse(r8, new QesdkOutputDataParser(r23), r16) == false) goto L37;
        r8.putInt("status", 0);
        this.mQesdkTimer.stop(LOG_TAG, "Get sync response SDK time taken");
        return r8;
    L37:
        int r24 = r8.getInt("status");
        r8.clear();
        r8.putInt("status", r24);
        this.mQesdkTimer.stop(LOG_TAG, "Get sync response SDK time taken");
        return r8;
    L32:
        r21 = this.mQesdkTimer;
        r22 = "PerformTask SDK time taken to build southBoundData";
    L39:
        e = move-exception;
        QesdkUtils.LOG.e(LOG_TAG, e.getMessage());
        r8.putInt("status", -1);
        return r8;
    L9:
        if ((r10 - 2) == r11) goto L12;
        QesdkUtils.LOG.e(LOG_TAG, "Api description and arguments don't match!");
        r8.putInt("status", -2);
        return r8;
    }

    public static void setVersion(QesdkPlatVersion r8) {
        platLibVersion = r8;
    }

    @Override // com.qualcomm.qti.qesdk.QesdkBase
    public synchronized HashMap<Pair<String, Integer>, String[]> APIdetailsInternal() {
        monitor-enter(this);
        HashMap<Pair<String, Integer>, String[]> r8 = getServiceAPI();     // Catch: Throwable -> L6 Throwable -> L8
    L11:
        monitor-exit(this);
        return r8;
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "getService API not supported: " + e.getMessage());     // Catch: Throwable -> L6
        r8 = null;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdk
    public Bundle PerformSingleTask(int r8, QesdkFunctionInfo r10, Bundle r11) {
        this.mQesdkTimer.start();
        return performTaskCommon(r8, r10, r11, QesdkBase.CallType.SYNC, null);
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdk
    public Bundle PerformSingleTaskAsync(int r8, QesdkFunctionInfo r10, Bundle r11, IQesdkCallBack r12) {
        this.mQesdkTimer.start();
        if (r12 != null) goto L7;
        Bundle r13 = new Bundle();
        r13.putInt("status", -1);
        return r13;
    L7:
        return performTaskCommon(r8, r10, r11, QesdkBase.CallType.ASYNC, r12);
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdk
    public Bundle PerformTask(int r8, IQesdkFunctionType r10, Bundle r11) {
        this.mQesdkTimer.start();
        return performTaskCommon(r8, r10, r11, QesdkBase.CallType.SYNC, null);
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdk
    public Bundle PerformTaskAsync(int r8, IQesdkFunctionType r10, Bundle r11, IQesdkCallBack r12) {
        this.mQesdkTimer.start();
        if (r12 != null) goto L7;
        Bundle r13 = new Bundle();
        r13.putInt("status", -1);
        return r13;
    L7:
        return performTaskCommon(r8, r10, r11, QesdkBase.CallType.ASYNC, r12);
    }

    @Override // com.qualcomm.qti.qesdk.QesdkBase
    public synchronized void completeCleanUp() {
        monitor-enter(this);
        this.isSessionInit = false;     // Catch: Throwable -> L7
        this.sessionId = 0;     // Catch: Throwable -> L7
        QesdkBase.mQesdkFwkEventCb = null;     // Catch: Throwable -> L7
        this.mTaskMap.clear();     // Catch: Throwable -> L7
        cleanUpTaskPool();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.qualcomm.qti.qesdk.QesdkBase
    public synchronized int deinitInternal(int r8, int r10) {
        monitor-enter(this);
        int r11 = deInit(this.sessionId, r8, r10);     // Catch: Throwable -> L13
        if (r11 != 1) goto L6;
        this.opcode_subsys_callback_map.clear();     // Catch: Throwable -> L13
        completeCleanUp();     // Catch: Throwable -> L13
        r11 = 0;
    L6:
        this.opcode_subsys_callback_map.remove(new Pair(Integer.valueOf(r8), Integer.valueOf(r10)));     // Catch: Throwable -> L13
        if (r11 != 0) goto L11;
        if (r8 != 0) goto L11;
        if (r10 != 0) goto L11;
        this.isGlobalInit = false;     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return r11;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.qualcomm.qti.qesdk.QesdkBase
    public JSONObject getStruct(IQesdkFunctionType r8, String r10) {
        String r11 = getStruct(r8.getOpCode(), r8.getSSId(), r10);     // Catch: Throwable -> L5
    L14:
        return new JSONObject(r11);
    L9:
        e = move-exception;
        defpackage.a.k(e, new StringBuilder("improperly formatted struct: "), LOG_TAG);
        return null;
    L5:
        e = move-exception;
        Log.e(LOG_TAG, "Structure not supported: " + e.getMessage());
        r11 = null;
        goto L14
    }

    @Override // com.qualcomm.qti.qesdkIntf.IQesdk
    public String getSupportedApis() {
        return null;
    }

    @Override // com.qualcomm.qti.qesdk.QesdkBase
    public JSONObject getVector(IQesdkFunctionType r8, String r10) {
        String r11 = getVector(r8.getOpCode(), r8.getSSId(), r10);     // Catch: Throwable -> L5
    L14:
        return new JSONObject(r11);
    L9:
        e = move-exception;
        defpackage.a.k(e, new StringBuilder("improperly formatted vector: "), LOG_TAG);
        return null;
    L5:
        e = move-exception;
        Log.e(LOG_TAG, "Vector not supported: " + e.getMessage());
        r11 = null;
        goto L14
    }

    @Override // com.qualcomm.qti.qesdk.QesdkBase
    public String getVectorType(IQesdkFunctionType r8, String r10) {
        return getVectorType(r8.getOpCode(), r8.getSSId(), r10);
    }

    @Override // com.qualcomm.qti.qesdk.QesdkBase
    public synchronized int initInternal(String r8, int r10, int r11) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (platLibVersion != null) goto L8;
        monitor-exit(this);
        return -3;
    L8:
        int r12 = init(r8, r10, r11);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r12;
    }
}
