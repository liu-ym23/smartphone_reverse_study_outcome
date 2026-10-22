package com.google.common.util.concurrent;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class k {
    public static /* synthetic */ boolean a(Unsafe r5, o r10, long r11, Object r12, Object r13) {
    L3:
        if (r5.compareAndSwapObject(r10, r11, r12, r13) == true) goto L4;
        if (r5.getObject(r10, r11) == r12) goto L3;
        return false;
    L4:
        return true;
    }
}
