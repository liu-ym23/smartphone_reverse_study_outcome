package com.lynx.serval.svg.model;

/* JADX INFO: loaded from: classes2.dex */
public class PaintRef {
    public static final int PAINT_COLOR = 1;
    public static final int PAINT_IRI = 2;
    public static final int PAINT_NONE = 0;
    public long mColor;
    public String mIri;
    public float mOpacity;
    public int mType;

    public PaintRef(int r5, long r10, float r11, String r12) {
        this.mType = r5;
        this.mColor = r10;
        this.mOpacity = r11;
        this.mIri = r12;
    }
}
