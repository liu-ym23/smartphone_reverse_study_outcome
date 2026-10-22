package com.lynx.serval.svg.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class StrokePaintModel extends PaintRef {
    public float[] mStrokeDashArray;
    public float mStrokeDashOffset;
    public int mStrokeLineCap;
    public int mStrokeLineJoin;
    public float mStrokeMiterLimit;
    public int mVectorEffect;
    public float mWith;

    public StrokePaintModel(int r8, String r9, long r10, float r12, float r13, int r14, int r15, float r16, float r17, float[] r18, int r19) {
        super(r8, r10, r13, r9);
        this.mWith = r12;
        this.mStrokeLineCap = r14;
        this.mStrokeLineJoin = r15;
        this.mStrokeMiterLimit = r16;
        this.mStrokeDashOffset = r17;
        this.mStrokeDashArray = r18;
        this.mVectorEffect = r19;
    }
}
