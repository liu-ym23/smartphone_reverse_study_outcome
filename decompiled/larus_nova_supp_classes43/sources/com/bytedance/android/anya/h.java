package com.bytedance.android.anya;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@AnyaDSL
public abstract class h<STATE extends MVIState<?>, CONTEXT extends h<STATE, CONTEXT>> {
    public h() {
    }

    public static int a(t0 r0) {
        return ((com.bytedance.android.anya.internal.u) r0).c().size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object b(u r0) {
        return ((com.bytedance.android.anya.internal.c) r0).c();
    }
}
