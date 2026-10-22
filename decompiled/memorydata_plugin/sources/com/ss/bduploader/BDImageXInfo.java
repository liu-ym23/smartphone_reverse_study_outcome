package com.ss.bduploader;

/* JADX INFO: loaded from: classes6.dex */
public class BDImageXInfo {
    public String mEncryptionMeta;
    public BDImageXE2EEncryptionInfo mEnd2EndEncryption;
    public long mErrorCode;
    public String mErrorMsg;
    public int mFileIndex;
    public String mImageTosKey;
    public String mMetaInfo;
    public long mProgress;

    public BDImageXInfo(String r2, long r3, int r5, String r6, String r7, BDImageXE2EEncryptionInfo r8) {
        this.mFileIndex = -1;
        this.mImageTosKey = r2;
        this.mProgress = r3;
        this.mErrorCode = r3;
        this.mFileIndex = r5;
        this.mMetaInfo = r6;
        this.mEncryptionMeta = r7;
        this.mEnd2EndEncryption = r8;
    }
}
