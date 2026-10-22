package com.bytedance.android.ec.core.arch.lifecycle;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class h {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[Lifecycle.State.values().length];
        a = r0;
        Lifecycle.State r1 = Lifecycle.State.CREATED;
        r0[r1.ordinal()] = 1;
        Lifecycle.State r10 = Lifecycle.State.STARTED;
        r0[r10.ordinal()] = 2;
        Lifecycle.State r11 = Lifecycle.State.RESUMED;
        r0[r11.ordinal()] = 3;
        int[] r12 = new int[Lifecycle.State.values().length];
        b = r12;
        r12[r1.ordinal()] = 1;
        r12[r10.ordinal()] = 2;
        r12[r11.ordinal()] = 3;
    }
}
