package com.bytedance.byted_bach_sdk.buffer;

/* JADX INFO: loaded from: classes.dex */
public class BachTensorResult {
    public static final int DataFormat_NCHW = 0;
    public static final int DataFormat_NHWC = 1;
    public int batch;
    public int channel;
    public int data_type;
    public int format;
    public float fraction;
    public int height;
    private long m_nativeHandle;
    public String name;
    private byte[] raw_data;
    public int width;

    static {
        System.loadLibrary("bach-sdk-jni");
    }

    private BachTensorResult(int r3, int r4, int r5, int r6, int r7, int r8, int r9, String r10) {
        this.width = 0;
        this.height = 0;
        this.batch = 0;
        this.channel = 0;
        this.format = 0;
        this.data_type = 0;
        this.fraction = 0.0f;
        this.name = "";
        this.m_nativeHandle = 0;
        this.width = r3;
        this.height = r4;
        this.batch = r5;
        this.channel = r6;
        this.format = r7;
        this.data_type = r8;
        this.fraction = r9;
        this.name = r10;
    }

    private native byte[] nativeGetTensorData(long r1);

    public byte[] getRawData() {
        if (this.raw_data != null) goto L6;
        this.raw_data = nativeGetTensorData(this.m_nativeHandle);
    L6:
        return this.raw_data;
    }
}
