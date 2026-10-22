package com.ss.bduploader;

/* JADX INFO: loaded from: classes6.dex */
public interface BDVideoUploaderListener {
    public static final int EndTimeUploadStage1 = 1001;
    public static final int EndTimeUploadStage2 = 1002;
    public static final int EndTimeUploadStage3 = 1003;
    public static final int EndTimeUploadStage4 = 1004;
    public static final int EndTimeUploadStage5 = 1005;

    String getStringFromExtern(int r1);

    void onLog(int r1, int r2, String r3);

    void onNotify(int r1, long r2, BDVideoInfo r4);

    void onUploadVideoStage(int r1, long r2);

    int videoUploadCheckNetState(int r1, int r2);
}
