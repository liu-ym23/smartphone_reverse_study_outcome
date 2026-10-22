package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.core.data.LoadingStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class n2 {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LoadingStatus.values().length];
        a = r0;
        r0[LoadingStatus.LOADING.ordinal()] = 1;
        r0[LoadingStatus.SUCCESS.ordinal()] = 2;
        r0[LoadingStatus.ERROR.ordinal()] = 3;
    }
}
