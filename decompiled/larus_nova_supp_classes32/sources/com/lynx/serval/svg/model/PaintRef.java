package com.lynx.serval.svg.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class PaintRef {
    public static final int PAINT_COLOR = 1;
    public static final int PAINT_IRI = 2;
    public static final int PAINT_NONE = 0;
    public long mColor;
    public String mIri;
    public float mOpacity;
    public int mType;

    public PaintRef(int r1, long r2, float r4, String r5) {
        this.mType = r1;
        this.mColor = r2;
        this.mOpacity = r4;
        this.mIri = r5;
    }
}
