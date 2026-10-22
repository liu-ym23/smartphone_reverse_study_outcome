package com.larus.suggest.impl;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class d implements Function2 {
    public /* synthetic */ d() {
    }

    public final Object invoke(Object r4, Object r5) {
        e r6 = (e) r4;
        e r7 = (e) r5;
        Integer r0 = null;
        if (r6 == null) goto L5;
        String r1 = r6.a;
    L6:
        if (r7 == null) goto L8;
        String r2 = r7.a;
    L10:
        if (Intrinsics.areEqual(r1, r2) == false) goto L19;
        if (r6 == null) goto L13;
        Integer r8 = r6.j;
    L14:
        if (r7 == null) goto L17;
        r0 = r7.j;
    L17:
        if (Intrinsics.areEqual(r8, r0) == false) goto L19;
        boolean r9 = true;
    L21:
        return Boolean.valueOf(r9);
    L13:
        r8 = null;
    L19:
        r9 = false;
        goto L21
    L8:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }
}
