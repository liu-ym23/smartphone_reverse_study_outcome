package com.bytedance.frameworks.baselib.network;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f4663a = null;

    static {
        int[] r5 = new int[TTDelayStateManager$AppStartState.values().length];
        f4663a = r5;
        r5[TTDelayStateManager$AppStartState.ColdStart.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L10:
        f4663a[TTDelayStateManager$AppStartState.HotStart.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L12:
        f4663a[TTDelayStateManager$AppStartState.WarmStart.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
        return;
    }
}
