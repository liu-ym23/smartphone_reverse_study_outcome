package com.lynx.serval.svg.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class GradientModel {
    public static int GRADIENT_SPREAD_PAD = 0;
    public static int GRADIENT_SPREAD_REFLECT = 1;
    public static int GRADIENT_SPREAD_REPEAT = 2;
    public static int GRADIENT_TYPE_OBJECT_BOUNDING_BOX = 1;
    public static int GRADIENT_TYPE_USE_SPACE_ON_USE;
    public int mSpreadMode;
    public StopModel[] mStopModels;
    public float[] mTransform;
    public int mType;

    public GradientModel() {
        this.mType = GRADIENT_TYPE_OBJECT_BOUNDING_BOX;
    }
}
