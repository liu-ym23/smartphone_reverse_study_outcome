package com.ss.bduploader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdinstall.Api;
import com.ss.bduploader.net.BDUploadDNSParser;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class BDObjectUploader extends BDAbstractUpload implements Handler.Callback {
    public static final int BDUploadReaderTypeAndroidMedia = 2;
    public static final int BDUploadReaderTypeCallBack = 1;
    public static final int BDUploadReaderTypeFilePath = 0;
    public static final int DataTransportProtocolGQuic = 2;
    public static final int DataTransportProtocolHttpVersion1 = 0;
    public static final int DataTransportProtocolHttpVersion2 = 1;
    public static final int IsClose = 5;
    public static final int IsComplete = 3;
    public static final int IsFail = 2;
    public static final int IsInit = 0;
    public static final int IsStart = 1;
    public static final int IsStop = 4;
    public static final int KeIsAuthorization = 15;
    public static final int KeIsGetRedirectLocation = 14;
    public static final int KeyIsAliveMaxFailTime = 22;
    public static final int KeyIsApplyAuth = 83;
    public static final int KeyIsAuthType = 416;
    public static final int KeyIsBackupNetworkType = 404;
    public static final int KeyIsCommitAuth = 84;
    public static final int KeyIsDataTransportProtocol = 411;
    public static final int KeyIsEnableCommitUpload = 401;
    public static final int KeyIsEnableExternDNS = 21;
    public static final int KeyIsEnableGatewayForObject = 87;
    public static final int KeyIsEnableGcmEnc = 444;
    public static final int KeyIsEnableHttps = 19;
    public static final int KeyIsEnableKeepAlive = 20;
    public static final int KeyIsEnablePostMethod = 23;
    public static final int KeyIsExtra = 58;
    public static final int KeyIsFileRetryCount = 6;
    public static final int KeyIsFileUploadDomain = 2;
    public static final int KeyIsGatewayThreshold = 88;
    public static final int KeyIsGetAlgorithm = 52;
    public static final int KeyIsGetCoverUrI = 12;
    public static final int KeyIsGetCoverUrl = 11;
    public static final int KeyIsGetDNSIp = 75;
    public static final int KeyIsGetEncryptionMeta = 407;
    public static final int KeyIsGetImageMeta = 410;
    public static final int KeyIsGetImageURI = 409;
    public static final int KeyIsGetLog = 100;
    public static final int KeyIsGetObjectId = 51;
    public static final int KeyIsGetSecretKey = 50;
    public static final int KeyIsGetVersion = 53;
    public static final int KeyIsGetVideoId = 10;
    public static final int KeyIsLogCallback = 78;
    public static final int KeyIsMainNetworkType = 403;
    public static final int KeyIsMaxFailTime = 13;
    public static final int KeyIsMediaDataReader = 201;
    public static final int KeyIsMetaInfoParams = 61;
    public static final int KeyIsObjectType = 54;
    public static final int KeyIsPathName = 0;
    public static final int KeyIsPlainObjectId = 59;
    public static final int KeyIsPolicyParams = 55;
    public static final int KeyIsPreUpload = 80;
    public static final int KeyIsPreUploadApply = 419;
    public static final int KeyIsPreUploadEncryptionMode = 74;
    public static final int KeyIsRouteWeight = 408;
    public static final int KeyIsSDKConfigFileDir = 417;
    public static final int KeyIsSDKContextFileDir = 418;
    public static final int KeyIsScenesTag = 85;
    public static final int KeyIsServerParameter = 16;
    public static final int KeyIsSetApplyHost = 46;
    public static final int KeyIsSetCustomConfig = 63;
    public static final int KeyIsSetDeviceID = 66;
    public static final int KeyIsSetOpenBoe = 67;
    public static final int KeyIsSetProcessAction = 65;
    public static final int KeyIsSetReaderType = 81;
    public static final int KeyIsSetRegionName = 47;
    public static final int KeyIsSetSpaceName = 45;
    public static final int KeyIsSetSpeedTestThresh = 406;
    public static final int KeyIsSetSpeedTestValue = 405;
    public static final int KeyIsSetTraceId = 69;
    public static final int KeyIsSetTranTimeOutUnit = 64;
    public static final int KeyIsSetfileNum = 71;
    public static final int KeyIsSliceRetryCount = 5;
    public static final int KeyIsSliceSize = 8;
    public static final int KeyIsSliceThreshold = 402;
    public static final int KeyIsSliceTimeout = 7;
    public static final int KeyIsSocketNum = 9;
    public static final int KeyIsSourceMd5 = 57;
    public static final int KeyIsTcpOpenTimeOutMilliSec = 24;
    public static final int KeyIsTopAccessKey = 42;
    public static final int KeyIsTopSecretKey = 43;
    public static final int KeyIsTopSessionToken = 44;
    public static final int KeyIsUploadCookie = 4;
    public static final int KeyIsUserName = 1;
    public static final int KeyIsVideoUploadDomain = 3;
    public static final int MessageIsCallBackStage = 103;
    public static final int MsgIsComplete = 0;
    public static final int MsgIsFail = 2;
    public static final int MsgIsSingleObjectComplete = 6;
    public static final int MsgIsSingleObjectFail = 7;
    public static final int MsgIsUpdateProgress = 1;
    public static final int MsgIsUploadCancel = 3;
    public static final int NetworkTypeNone = -1;
    public static final int NetworkTypeOwn = 0;
    public static final int NetworkTypeTTNet = 1;
    public static final int UploadFunctionTypeEncryption = 1;
    public static final int UploadFunctionTypeGetMedia = 2;
    public static final int UploadFunctionTypeNoProcess = 0;
    public static final int keyIsConfigString = 56;
    private static final int mInnerUploaderType = 2;
    private BDObjectUploaderAbstractListener mAbstractListener;
    private long mEndTime;
    private long mHandle;
    private Handler mHandler;
    private BDObjectUploaderListener mListener;
    private int mObjectNum;
    private final ReentrantReadWriteLock.ReadLock mReadLock;
    private final ReentrantReadWriteLock mReadWritedLock;
    private long mStartTime;
    private int mState;
    private final ReentrantReadWriteLock.WriteLock mWriteLock;

    public static class LogInfo {
        private int code;
        private String info;

        public LogInfo(int r1, String r2) {
            this.code = r1;
            this.info = r2;
        }

        public int getCode() {
            return this.code;
        }

        public String getInfo() {
            return this.info;
        }
    }

    public BDObjectUploader() {
        this.mState = -1;
        this.mObjectNum = 0;
        this.mHandler = null;
        this.mReadWritedLock = new ReentrantReadWriteLock();
        this.mListener = null;
        this.mAbstractListener = null;
        this.mHandle = _create(2);     // Catch: Throwable -> L5
    L6:
        long r4 = this.mHandle;
        if (r4 == 0) goto L15;
        _setIntValue(r4, 421, BDUploadUtil.mEnableNativeLog.booleanValue() ? 1 : 0);
        if (Looper.myLooper() == null) goto L11;
        Handler r1 = new Handler(this);
    L12:
        this.mHandler = r1;
        this.mReadLock = this.mReadWritedLock.readLock();
        this.mWriteLock = this.mReadWritedLock.writeLock();
        this.mState = 0;
        getDNSIP();
        return;
    L11:
        r1 = new Handler(Looper.getMainLooper(), this);
        goto L12
    L15:
        throw new Exception("create native uploader fail");
    L5:
        this.mHandle = 0;
        goto L6
    }

    private static native void _allowContinueUpload(long r0);

    private static native void _cancelUpload(long r0);

    private static native void _close(long r0);

    private final native long _create(int r1);

    private static native long _getLongValue(long r0, int r2);

    private static native String _getStrByKeyAndIndex(long r0, int r2, int r3);

    private static native String _getStringValue(long r0, int r2);

    private static native void _mergeUpload(long r0);

    private static native void _setFileData(long r0, int r2, byte[][] r3);

    private static native void _setFileName(long r0, int r2, String[] r3);

    private static native void _setFileNum(long r0, int r2);

    private static native void _setFilePaths(long r0, int r2, String[] r3);

    private static native void _setFileStoreKeys(long r0, int r2, String[] r3);

    private static native void _setInt64Value(long r0, int r2, long r3);

    private static native void _setIntValue(long r0, int r2, int r3);

    private static native void _setObject(long r0, int r2, Object r3);

    private static native void _setSpecifiedContentType(long r0, int r2, String[] r3);

    private static native void _setStringValue(long r0, int r2, String r3);

    private static native void _start(long r0);

    private static native void _stop(long r0);

    private void allowMergeUpload() {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _mergeUpload(r0);
    }

    public static boolean isError() {
        return IsErrored;
    }

    private void setContextDir(String r5) {
        if (this.mHandle == 0) goto L8;
        if (r5 == null) goto L9;
        String r6 = r5 + File.separator + BDUploadUtil.SpeedTestcontextDir;
        BDUploadUtil.createDir(r6);
        _setStringValue(this.mHandle, 418, r6);
        return;
    L9:
        return;
    }

    private void setDiskResumeDir(String r5) {
        if (this.mHandle == 0) goto L8;
        if (r5 == null) goto L9;
        String r6 = r5 + File.separator + BDUploadUtil.DiskResumeConfigDir;
        BDUploadUtil.createDir(r6);
        _setStringValue(this.mHandle, 303, r6);
        return;
    L9:
        return;
    }

    private void setMediaDataReader(BDMediaDataReader r5, int r6, int r7) {
        BDMediaDataReader r8 = (BDMediaDataReader) ZeusTransformUtils.wrapperContextForParams(r5, BDMediaDataReader.class, "com.obric.memorydata.plugin");
        if (this.mHandle == 0) goto L9;
        if (r8 == null) goto L10;
        if (r6 <= 0) goto L11;
        setMediaDataReader(r8, r6);
        _setIntValue(this.mHandle, 81, r7);
        return;
    L11:
        return;
    L10:
        return;
    }

    private void setPreUploadEncryptionMode(int r5) {
        if (this.mHandle != 0) goto L6;
        return;
    L6:
        if (r5 != 2) goto L12;
        String r0 = UUID.randomUUID().toString();
        if (r0 == null) goto L12;
        if (r0.length() <= 0) goto L12;
        _setStringValue(this.mHandle, 420, r0);
    L12:
        _setIntValue(this.mHandle, 74, r5);
    }

    public void SetExtraParams(JSONObject r5) {
        if (this.mHandle == 0) goto L8;
        if (r5 == null) goto L9;
        setStringValue(61, r5.toString());
        return;
    L9:
        return;
    }

    public void addLogToManager(String r11) {
        String r2 = UUID.randomUUID().toString();
        if (r2 != null) goto L5;
    L6:
        r2 = "invalid_uuid";
    L27:
        JSONObject r3 = new JSONObject(r11);     // Catch: Exception -> L9
        r3.put("dns_version", BDUploadResolver.mDNSVersion);     // Catch: Exception -> L9
        r3.put("main_dns_type", BDUploadDNSParser.mGlobalMainType);     // Catch: Exception -> L9
        r3.put("main_back_type", BDUploadDNSParser.mGlobalBackType);     // Catch: Exception -> L9
        r3.put("back_delayed_time", BDUploadDNSParser.mGlobalBackUpDelayedTime);     // Catch: Exception -> L9
        r3.put("expired_time", BDUploadDNSParser.mGlobalDefaultExpiredTime);     // Catch: Exception -> L9
        r3.put(Api.KEY_UUID, r2);     // Catch: Exception -> L9
        r3.remove("event");     // Catch: Exception -> L9
        r3.put("event", "bd_image_upload_all");     // Catch: Exception -> L9
    L10:
        if (r3 != null) goto L25;
    L23:
        UploadEventManager.instance.addEvent(r3);
        return;
    L25:
        JSONArray r12 = r3.getJSONArray("image_array");     // Catch: Exception -> L22
        if (r12 == null) goto L23;
        r3.remove("image_array");     // Catch: Exception -> L22
        int r0 = 0;
    L14:
        if (r0 >= r12.length()) goto L23;
        JSONObject r4 = new JSONObject(r3.toString());     // Catch: Exception -> L22
        r4.remove("event");     // Catch: Exception -> L22
        r4.put("event", "bd_image_upload_single");     // Catch: Exception -> L22
        JSONObject r5 = r12.getJSONObject(r0);     // Catch: Exception -> L22
        Iterator<String> r6 = r5.keys();     // Catch: Exception -> L22
    L18:
        if (r6.hasNext() == false) goto L20;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L22
        r4.put(r7, r5.get(r7));     // Catch: Exception -> L22
        goto L18
    L20:
        r4.put(Api.KEY_UUID, r2);     // Catch: Exception -> L22
        UploadEventManager.instance.addEvent(r4);     // Catch: Exception -> L22
        r0 = r0 + 1;
    L22:
        Log.e("ttmn", "get object_array failed");
    L9:
        r3 = null;
        goto L10
    L5:
        if (r2.length() > 0) goto L27;
        goto L6
    }

    public void allowContinueUpload() {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _allowContinueUpload(r0);
    }

    public void cancelUpload() {
        this.mWriteLock.lock();
        long r0 = this.mHandle;
        if (r0 != 0) goto L6;
    L4:
        this.mWriteLock.unlock();
        return;
    L6:
        _cancelUpload(r0);
        goto L4
    }

    public int checkNet(int r1, int r2) {
        BDObjectUploaderListener r0 = this.mListener;
        if (r0 != null) goto L5;
        return 1;
    L5:
        return r0.objectUploadCheckNetState(r1, r2);
    }

    public void close() {
        this.mWriteLock.lock();
        long r0 = this.mHandle;     // Catch: Throwable -> L8
        if (r0 == 0) goto L6;
        _close(r0);     // Catch: Throwable -> L8
        this.mHandle = 0;     // Catch: Throwable -> L8
        this.mState = 5;     // Catch: Throwable -> L8
        this.mHandler.removeCallbacksAndMessages(null);     // Catch: Throwable -> L8
    L6:
        this.mWriteLock.unlock();
        return;
    L8:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public String getDNSIP() {
        return BDUploadUtil.getDNSServerIP();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r5) {
        int r0 = r5.what;
        if (ZeusTransformUtils.instanceOf(r5.obj, LogInfo.class) == false) goto L7;
        LogInfo r6 = (LogInfo) ZeusTransformUtils.preCheckCast(r5.obj, LogInfo.class, "com.obric.memorydata.plugin");
        onLogInfoSync(r0, r6.getCode(), r6.getInfo());
        return true;
    L7:
        if (this.mListener != null) goto L9;
        return true;
    L9:
        BDObjectInfo r7 = (BDObjectInfo) ZeusTransformUtils.preCheckCast(r5.obj, BDObjectInfo.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L12;
        long r1 = r7.mProgress;
    L13:
        this.mListener.onNotify(r0, r1, r7);
        return true;
    L12:
        r1 = 0;
        goto L13
    }

    public void onLogInfo(int r3, int r4, String r5) {
        if (this.mState == 1) goto L5;
        return;
    L5:
        LogInfo r0 = new LogInfo(r4, r5);
        Message r2 = this.mHandler.obtainMessage();
        r2.what = r3;
        r2.obj = r0;
        r2.sendToTarget();
    }

    public void onLogInfoSync(int r4, int r5, String r6) {
        if (this.mListener != null) goto L5;
        return;
    L5:
        if (r4 != 103) goto L9;
        long r0 = new Date().getTime();
        BDObjectUploaderAbstractListener r2 = this.mAbstractListener;
        if (r2 == null) goto L9;
        r2.onUploadStage(r5, r0);
    L9:
        this.mListener.onLog(r4, r5, r6);
    }

    public void onNotify(int r9, long r10, int r12, String r13) {
        if (this.mState == 1) goto L5;
        return;
    L5:
        BDObjectInfo r14 = null;
        int r5 = (int) r10;
        if (r9 == 0) goto L25;
        if (r9 != 1) goto L9;
        r14 = new BDObjectInfo(null, r12, r5, null, null);
    L31:
        Message r8 = this.mHandler.obtainMessage();
        r8.what = r9;
        r8.obj = r14;
        r8.sendToTarget();
        return;
    L9:
        if (r9 == 2) goto L19;
        if (r9 != 3) goto L12;
    L18:
        addLogToManager(_getStringValue(this.mHandle, 100));
        this.mState = 2;
        goto L31
    L12:
        if (r9 != 6) goto L14;
        this.mEndTime = System.currentTimeMillis();
        r14 = new BDObjectInfo(_getStrByKeyAndIndex(this.mHandle, 409, r5), 0, r5, _getStrByKeyAndIndex(this.mHandle, 410, r5), _getStrByKeyAndIndex(this.mHandle, 407, r5));
        goto L31
    L14:
        if (r9 != 7) goto L31;
        r14 = new BDObjectInfo(null, r12, r5, null, null);
        goto L31
    L19:
        String r11 = getDNSIP();
        if (r11 == null) goto L18;
        if (r11.isEmpty() == true) goto L18;
        setStringValue(75, r11);
        goto L18
    L25:
        String r15 = getDNSIP();
        if (r15 != null) goto L28;
    L30:
        addLogToManager(_getStringValue(this.mHandle, 100));
        this.mState = 3;
        goto L31
    L28:
        if (r15.isEmpty() == true) goto L30;
        setStringValue(75, r15);
        goto L30
    }

    public void setAbstractListener(BDObjectUploaderAbstractListener r1) {
        this.mAbstractListener = r1;
    }

    public void setAuthType(int r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, 416, r5);
    }

    public void setConfig(TreeMap<String, Object> r5) {
        if (this.mHandle == 0) goto L10;
        if (r5 == null) goto L12;
        String r6 = BDUploadUtil.mapToString(r5);
        if (r6 == null) goto L11;
        setStringValue(56, r6);
        return;
    L11:
        return;
    L12:
        return;
    }

    public void setCustomConfig(TreeMap<String, Object> r5) {
        if (this.mHandle == 0) goto L21;
        if (r5 == null) goto L22;
        JSONObject r6 = BDUploadUtil.mapToJSON(r5);
        if (r6 != null) goto L9;
        return;
    L9:
        JSONObject r0 = new JSONObject();
        r0.put("custom_config", r6);     // Catch: Throwable -> L15
        String r7 = r0.toString();     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r7) == true) goto L20;
        setStringValue(63, r7);
        return;
    L20:
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    L22:
        return;
    }

    public void setCustomHttpHeaders(TreeMap<String, Object> r5) {
        if (this.mHandle == 0) goto L10;
        if (r5 == null) goto L12;
        String r6 = BDUploadUtil.mapToString(r5);
        if (r6 == null) goto L11;
        setStringValue(BDAbstractUpload.KeyIsCustomHttpHeaders, r6);
        return;
    L11:
        return;
    L12:
        return;
    }

    public void setCustomNetworkTimeoutParams(int r5, int r6, int r7, int r8, int r9) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, 422, r5);
        _setIntValue(this.mHandle, 423, r6);
        _setIntValue(this.mHandle, 424, r7);
        _setIntValue(this.mHandle, 425, r8);
        _setIntValue(this.mHandle, BDAbstractUpload.KeyIsSDKRetryPolicy, r9);
    }

    public void setDataTransportProtocol(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 411, r5);
        return;
    L9:
        return;
    }

    public void setDiskResumeOption(int r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, 302, r5);
    }

    public void setDiskResumeUniqueKey(String r5) {
        if (this.mHandle == 0) goto L10;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.isEmpty() == true) goto L12;
        _setStringValue(this.mHandle, 301, r5);
        return;
    L12:
        return;
    }

    public void setEnableBigFile(long r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, 87, 1);
        _setInt64Value(this.mHandle, 88, r5);
    }

    public void setEnableCommitUpload(boolean r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, 401, r5 ? 1 : 0);
    }

    public void setEnableGcmEnc(boolean r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, 444, r5 ? 1 : 0);
    }

    public void setEnableHttps(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 19, r5);
        return;
    L9:
        return;
    }

    public void setEnableLogCallBack(boolean r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L6;
        return;
    L6:
        if (r5 == false) goto L8;
        int r6 = 1;
    L9:
        _setIntValue(r0, 78, r6);
        return;
    L8:
        r6 = 0;
        goto L9
    }

    public void setFileData(int r5, byte[][] r6) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L9;
        if (r6 == null) goto L10;
        if (r5 <= 0) goto L11;
        _setFileData(r0, r5, r6);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setFileName(int r5, String[] r6) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L9;
        if (r6 == null) goto L10;
        if (r5 <= 0) goto L11;
        _setFileName(r0, r5, r6);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setFilePath(int r5, String[] r6) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L9;
        if (r6 == null) goto L10;
        if (r5 <= 0) goto L11;
        this.mObjectNum = r5;
        _setFilePaths(r0, r5, r6);
        _setIntValue(this.mHandle, 81, 0);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setFileRetryCount(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 6, r5);
        return;
    L9:
        return;
    }

    public void setHandler(Handler r1) {
        this.mHandler = r1;
    }

    public void setListener(BDObjectUploaderListener r3) {
        this.mListener = (BDObjectUploaderListener) ZeusTransformUtils.wrapperContextForParams(r3, BDObjectUploaderListener.class, "com.obric.memorydata.plugin");
    }

    public void setMaxConcurrentFileNum(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 400, r5);
        return;
    L9:
        return;
    }

    public void setMaxFailTime(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 13, r5);
        return;
    L9:
        return;
    }

    public void setMediaDataReader(BDMediaDataReader r5, int r6) {
        BDMediaDataReader r7 = (BDMediaDataReader) ZeusTransformUtils.wrapperContextForParams(r5, BDMediaDataReader.class, "com.obric.memorydata.plugin");
        long r0 = this.mHandle;
        if (r0 == 0) goto L9;
        if (r7 == null) goto L10;
        if (r6 <= 0) goto L11;
        _setIntValue(r0, 71, r6);
        _setIntValue(this.mHandle, 81, 2);
        _setObject(this.mHandle, 201, r7);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setNetworkType(int r5, int r6) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, r5, r6);
    }

    public void setObjectType(String r2) {
        setStringValue(54, r2);
    }

    public void setOpenBoe(boolean r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L6;
        return;
    L6:
        if (r5 == false) goto L8;
        int r6 = 1;
    L9:
        _setIntValue(r0, 67, r6);
        return;
    L8:
        r6 = 0;
        goto L9
    }

    public void setPolicyParams(TreeMap<String, Object> r5) {
        if (this.mHandle == 0) goto L10;
        if (r5 == null) goto L12;
        String r6 = BDUploadUtil.mapToString(r5);
        if (r6 == null) goto L11;
        setStringValue(55, r6);
        return;
    L11:
        return;
    L12:
        return;
    }

    public void setPreUpload(boolean r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, 80, r5 ? 1 : 0);
    }

    public void setPreheatUploader(boolean r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, 419, r5 ? 1 : 0);
    }

    public void setProcessActionType(int r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, 65, r5);
    }

    public void setQueryAuth(String r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 == null) goto L9;
        _setStringValue(r0, 15, r5);
        return;
    L9:
        return;
    }

    public void setRWTimeout(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 7, r5);
        return;
    L9:
        return;
    }

    public void setSDKConfigDir(String r5) {
        if (this.mHandle == 0) goto L8;
        if (r5 == null) goto L9;
        BDUploadUtil.createDir(r5);
        _setStringValue(this.mHandle, 417, r5);
        setContextDir(r5);
        return;
    L9:
        return;
    }

    public void setSDKMaxRetryCount(int r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, BDAbstractUpload.KeyIsSDKMaxRetryCount, r5);
    }

    public void setSDKMaxRetryTimeout(int r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, BDAbstractUpload.KeyIsSDKMaxRetryTimeout, r5);
    }

    public void setScenesTag(String r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 == null) goto L9;
        _setStringValue(r0, 85, r5);
        return;
    L9:
        return;
    }

    public void setServerParameter(String r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 == null) goto L9;
        _setStringValue(r0, 16, r5);
        return;
    L9:
        return;
    }

    public void setSliceRetryCount(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 5, r5);
        return;
    L9:
        return;
    }

    public void setSliceSize(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 <= 0) goto L9;
        _setIntValue(r0, 8, r5);
        return;
    L9:
        return;
    }

    public void setSliceThreshold(int r5) {
        long r0 = this.mHandle;
        if (r0 != 0) goto L5;
        return;
    L5:
        _setIntValue(r0, 402, r5);
    }

    public void setSocketNum(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(r0, 9, r5);
        return;
    L9:
        return;
    }

    public void setSpaceName(String r2) {
        setStringValue(45, r2);
    }

    public void setSpecifiedContentType(int r5, String[] r6) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L9;
        if (r6 == null) goto L10;
        if (r5 <= 0) goto L11;
        _setSpecifiedContentType(r0, r5, r6);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setStringValue(int r5, String r6) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r6 == null) goto L9;
        _setStringValue(r0, r5, r6);
        return;
    L9:
        return;
    }

    public void setTopAccessKey(String r2) {
        setStringValue(42, r2);
    }

    public void setTopSecretKey(String r2) {
        setStringValue(43, r2);
    }

    public void setTopSessionToken(String r2) {
        setStringValue(44, r2);
    }

    public void setTraceId(String r5) {
        if (this.mHandle == 0) goto L10;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.isEmpty() == true) goto L12;
        _setStringValue(this.mHandle, 69, r5);
        return;
    L12:
        return;
    }

    public void setTranTimeOutUnit(int r5) {
        long r0 = this.mHandle;
        if (r0 == 0) goto L8;
        if (r5 <= 0) goto L9;
        _setIntValue(r0, 64, r5);
        return;
    L9:
        return;
    }

    public void setUploadDomain(String r5) {
        if (this.mHandle == 0) goto L8;
        if (r5 == null) goto L9;
        setStringValue(46, r5);
        return;
    L9:
        return;
    }

    public void start() {
        this.mReadLock.lock();
        if (BDUploadUtil.sdkConfigDir != null) goto L5;
    L15:
    L12:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L8:
        if (this.mHandle == 0) goto L10;
        this.mState = 1;     // Catch: Throwable -> L12
        this.mStartTime = System.currentTimeMillis();     // Catch: Throwable -> L12
        _start(this.mHandle);     // Catch: Throwable -> L12
    L10:
        this.mReadLock.unlock();
        return;
    L5:
        if (BDUploadUtil.sdkConfigDir.length() <= 0) goto L15;
        setContextDir(BDUploadUtil.sdkConfigDir);
        setDiskResumeDir(BDUploadUtil.sdkConfigDir);
        goto L15
    }

    public void stop() {
        this.mWriteLock.lock();
    L8:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L4:
        if (this.mHandle == 0) goto L6;
        Log.e("ttmn", "before java stop");     // Catch: Throwable -> L8
        _stop(this.mHandle);     // Catch: Throwable -> L8
        addLogToManager(_getStringValue(this.mHandle, 100));     // Catch: Throwable -> L8
        this.mState = 4;     // Catch: Throwable -> L8
        Log.e("ttmn", "after java stop");     // Catch: Throwable -> L8
    L6:
        this.mWriteLock.unlock();
    }
}
