package com.ss.bduploader;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class BDVideoInfo {
    public String mCallbackArgs;
    public String mCoverUri;
    public String mEncryptionMeta;
    public long mErrorCode;
    public String mErrorMsg;
    public long mFileIndex;
    public JSONObject mLog;
    public String mMid;
    public long mProgress;
    public String mTosKey;
    public String mVideoId;
    public String mVideoMediaInfo;

    public static class AIGCMeta {
        public String ContentProducer;
        public String ContentPropagator;
        public String Label;

        public AIGCMeta(String r1, String r2, String r3) {
            this.Label = r1;
            this.ContentProducer = r2;
            this.ContentPropagator = r3;
        }
    }

    public BDVideoInfo(String r3, String r4, long r5, int r7, String r8, String r9, String r10, String r11, String r12) {
        this.mFileIndex = 0;
        this.mVideoId = r3;
        this.mCoverUri = r4;
        long r6 = r7;
        this.mProgress = r6;
        this.mFileIndex = r5;
        this.mErrorCode = r6;
        this.mErrorMsg = r8;
        this.mTosKey = r9;
        this.mVideoMediaInfo = r10;
        this.mEncryptionMeta = r11;
        this.mCallbackArgs = r12;
        this.mLog = null;
    }

    public BDVideoInfo(String r11, String r12, long r13, String r15, String r16, String r17, String r18) {
        this(r11, r12, r13, r15, r16, r17, r18, null);
    }

    public BDVideoInfo(String r3, String r4, long r5, String r7, String r8, String r9, String r10, String r11) {
        this.mFileIndex = 0;
        this.mVideoId = r3;
        this.mCoverUri = r4;
        this.mProgress = r5;
        this.mErrorCode = r5;
        this.mErrorMsg = r7;
        this.mTosKey = r8;
        this.mVideoMediaInfo = r9;
        this.mEncryptionMeta = r10;
        this.mCallbackArgs = r11;
        this.mLog = null;
    }
}
