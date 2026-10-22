package com.larus.bmhome.chat.component.list;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class h5 implements Function2 {
    public /* synthetic */ h5() {
    }

    public final Object invoke(Object r3, Object r4) {
        wc9.e r5 = (wc9.e) r3;
        wc9.e r6 = (wc9.e) r4;
        int r0 = ChatListComponent.W3;
        Integer r1 = null;
        if (r5 == null) goto L5;
        String r7 = r5.a;
    L6:
        if (r6 == null) goto L8;
        String r2 = r6.a;
    L10:
        if (Intrinsics.areEqual(r7, r2) == false) goto L19;
        if (r6 == null) goto L13;
        Integer r8 = r6.l;
    L14:
        if (r6 == null) goto L17;
        r1 = r6.m;
    L17:
        if (Intrinsics.areEqual(r8, r1) == false) goto L19;
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
        r7 = null;
        goto L6
    }
}
