package com.lynx.serval.svg.model;

/* JADX INFO: loaded from: classes2.dex */
public class StrokePaintModel extends PaintRef {
    public float[] mStrokeDashArray;
    public float mStrokeDashOffset;
    public int mStrokeLineCap;
    public int mStrokeLineJoin;
    public float mStrokeMiterLimit;
    public float mWith;

    public StrokePaintModel(int r10, String r11, long r12, float r13, float r14, int r15, int r16, float r17, float r18, float[] r19) {
        super(r10, r12, r14, r11);
        this.mWith = r13;
        this.mStrokeLineCap = r15;
        this.mStrokeLineJoin = r16;
        this.mStrokeMiterLimit = r17;
        this.mStrokeDashOffset = r18;
        this.mStrokeDashArray = r19;
    }
}
