package com.bytedance.assem.arch.extensions;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f3932a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f3933b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f3934c = null;
    public static final /* synthetic */ int[] d = null;

    static {
        int[] r5 = new int[Lifecycle.Event.values().length];
        f3932a = r5;
        Lifecycle.Event r10 = Lifecycle.Event.ON_DESTROY;
        r5[r10.ordinal()] = 1;
        int[] r11 = new int[Lifecycle.Event.values().length];
        f3933b = r11;
        r11[r10.ordinal()] = 1;
        int[] r12 = new int[Lifecycle.Event.values().length];
        f3934c = r12;
        r12[r10.ordinal()] = 1;
        int[] r13 = new int[Lifecycle.Event.values().length];
        d = r13;
        r13[r10.ordinal()] = 1;
    }
}
