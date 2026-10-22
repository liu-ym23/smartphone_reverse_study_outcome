package com.ss.bduploader;

import android.util.Log;
import com.ss.bduploader.util.BDUrlDispatch;
import com.ss.bduploader.util.CustomVerify;

/* JADX INFO: loaded from: classes6.dex */
public class BDAbstractUpload {
    protected static boolean IsErrored = false;
    public static final int KeyIsBatchSessionKey = 420;
    public static final int KeyIsCustomHttpHeaders = 430;
    public static final int KeyIsDiskResumeDir = 303;
    public static final int KeyIsDiskResumeOption = 302;
    public static final int KeyIsDiskResumeUniqueKey = 301;
    public static final int KeyIsEnableNativeLog = 421;
    public static final int KeyIsRetryStatesDir = 433;
    public static final int KeyIsRetryStatesOption = 434;
    public static final int KeyIsSDKMaxRetryCount = 426;
    public static final int KeyIsSDKMaxRetryTimeout = 428;
    public static final int KeyIsSDKRetryPolicy = 427;
    public static final int KeyIsSocketConnectTimeout = 422;
    public static final int KeyIsSocketReadTimeout = 423;
    public static final int KeyIsSocketWriteTimeout = 424;
    public static final int KeyIsTotalRequestTimeout = 425;
    public static final int KeyIsXQuicLibAvailable = 429;
    public static final int NetworkTypeNone = -1;
    public static final int NetworkTypeOwn = 0;
    public static final int NetworkTypeProxy = 4;
    public static final int NetworkTypeTTNet = 1;
    public static final int SDKRetryPolicyMaxFailTime = 0;
    public static final int SDKRetryPolicyMaxRetryCount = 1;
    public static StringBuffer mErrorMsg;

    static {
        mErrorMsg = new StringBuffer("error:");
        StringBuffer r0 = new StringBuffer("error:");
        mErrorMsg = r0;
        if (BDUploadUtil.initInternal(r0) == true) goto L6;
        IsErrored = true;
        return;
    }

    public BDAbstractUpload() {
        StringBuffer r1 = new StringBuffer("error:");
        mErrorMsg = r1;
        BDUploadUtil.initInternal(r1);
    }

    public int doVerify(byte[][] r1, String r2, String r3) {
        return CustomVerify.doVerify(r1, r2, r3);
    }

    public String getDispatchByUrl(String r1, String r2) {
        if (BDUploadUtil.mEnableDisaptch.booleanValue() == true) goto L7;
        Log.d("ttmn", "enableDispatch is:" + BDUploadUtil.mEnableDisaptch);
        return null;
    L7:
        return BDUrlDispatch.inst().getDispatchUrl(r1, r2);
    }

    public String getStringFromExtern(int r1) {
        return "";
    }

    public String intelligentInterface(int r2, String r3) {
        Log.d("ttmn", "IntelligentInterface:" + r2 + r3);
        return "testIntelligentInterface return";
    }
}
