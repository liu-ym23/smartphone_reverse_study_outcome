package com.bytedance.byted_bach_sdk.buffer;

/* JADX INFO: loaded from: classes.dex */
public class BachGraphicsInfo {
    public byte[] data;
    public int format;
    public int height;
    public int image_height;
    public int image_width;
    public float[] matrix;
    public int width;

    private BachGraphicsInfo(int r1, int r2, int r3, int r4, int r5, float[] r6, byte[] r7) {
        this.image_width = r1;
        this.image_height = r2;
        this.width = r3;
        this.height = r4;
        this.format = r5;
        this.matrix = r6;
        this.data = r7;
    }
}
