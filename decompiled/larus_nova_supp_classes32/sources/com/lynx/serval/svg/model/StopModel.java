package com.lynx.serval.svg.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class StopModel {
    public long mColor;
    public float mOffset;
    public float mStopOpacity;

    public String toString() {
        return "StopModel{mOffset=" + this.mOffset + ", mColor=" + this.mColor + ", mStopOpacity=" + this.mStopOpacity + '}';
    }

    public StopModel(float r1, long r2, float r4) {
        this.mOffset = r1;
        this.mColor = r2;
        this.mStopOpacity = r4;
    }
}
