package com.larus.camera.impl;

import com.larus.camera.api.params.InputParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public /* synthetic */ class FlowCameraImpl$b {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[InputParam.InitialImageEditMode.values().length];
        r0[InputParam.InitialImageEditMode.MARK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r0[InputParam.InitialImageEditMode.CROP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r0[InputParam.InitialImageEditMode.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        a = r0;
    }
}
