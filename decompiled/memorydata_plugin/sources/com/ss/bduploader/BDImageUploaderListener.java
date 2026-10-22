package com.ss.bduploader;

/* JADX INFO: loaded from: classes6.dex */
public interface BDImageUploaderListener {
    int imageUploadCheckNetState(int r1, int r2);

    void onLog(int r1, int r2, String r3);

    void onNotify(int r1, long r2, BDImageInfo r4);
}
