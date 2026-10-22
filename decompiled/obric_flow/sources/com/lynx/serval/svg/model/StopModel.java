package com.lynx.serval.svg.model;

/* JADX INFO: loaded from: classes2.dex */
public class StopModel {
    public long mColor;
    public float mOffset;
    public float mStopOpacity;

    public StopModel(float r5, long r10, float r11) {
        this.mOffset = r5;
        this.mColor = r10;
        this.mStopOpacity = r11;
    }

    public String toString() {
        return "StopModel{mOffset=" + this.mOffset + ", mColor=" + this.mColor + ", mStopOpacity=" + this.mStopOpacity + '}';
    }
}
