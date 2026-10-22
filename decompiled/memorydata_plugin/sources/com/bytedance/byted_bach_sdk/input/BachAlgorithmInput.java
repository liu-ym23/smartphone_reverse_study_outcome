package com.bytedance.byted_bach_sdk.input;

/* JADX INFO: loaded from: classes.dex */
public interface BachAlgorithmInput {
    public static final int BGR8 = 2;
    public static final int BGRA8 = 1;
    public static final int BITMAP_INPUT = 1;
    public static final int BYTE_ARRAY_INPUT = 4;
    public static final int BYTE_BUFFER_INPUT = 2;
    public static final int FEATURE_INPUT = 6;
    public static final int GENERAL_INPUT = 5;
    public static final int GRAY8 = 4;
    public static final int MULTI_INPUT = 3;
    public static final int RGB8 = 3;
    public static final int RGBA8 = 0;

    Object getInput();

    int getInputType();
}
