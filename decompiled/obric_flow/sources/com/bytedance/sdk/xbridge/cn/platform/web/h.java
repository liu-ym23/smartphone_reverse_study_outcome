package com.bytedance.sdk.xbridge.cn.platform.web;

import com.bytedance.sdk.xbridge.cn.registry.core.annotation.DefaultType;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f7423a = null;

    static {
        int[] r5 = new int[DefaultType.values().length];
        r5[DefaultType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r5[DefaultType.LONG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r5[DefaultType.INT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        f7423a = r5;
    }
}
