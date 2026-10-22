package com.larksuite.framework.section.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d {
    public final com.larksuite.framework.section.c a;
    public long b;

    public d(com.larksuite.framework.section.c r3) {
        Intrinsics.checkNotNullParameter(r3, "dispatcher");
        this.a = r3;
        this.b = 0;
    }

    public static void a(d r5, com.ss.android.lark.todo.impl.features.detail.viewmodel.a r6) {
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "action");
        if ((System.currentTimeMillis() - r5.b) <= 1000) goto L6;
        r5.b = System.currentTimeMillis();
        r5.a.a(r6);
        return;
    }
}
