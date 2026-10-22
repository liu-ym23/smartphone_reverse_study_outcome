package com.ss.bduploader;

/* JADX INFO: loaded from: classes6.dex */
public class BDImageInfo {
    public String mEncryptionMeta;
    public long mErrorCode;
    public String mErrorMsg;
    public int mFileIndex;
    public String mImageTosKey;
    public String mMetaInfo;
    public long mProgress;

    public BDImageInfo(String r2, long r3, String r5, int r6, String r7, String r8) {
        this.mFileIndex = -1;
        this.mImageTosKey = r2;
        this.mProgress = r3;
        this.mErrorCode = r3;
        this.mErrorMsg = r5;
        this.mFileIndex = r6;
        this.mMetaInfo = r7;
        this.mEncryptionMeta = r8;
    }
}
