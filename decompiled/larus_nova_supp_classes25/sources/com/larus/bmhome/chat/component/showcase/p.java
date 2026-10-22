package com.larus.bmhome.chat.component.showcase;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class p implements Function2 {
    public /* synthetic */ p() {
    }

    public final Object invoke(Object r4, Object r5) {
        e r6 = (e) r4;
        e r7 = (e) r5;
        int r0 = ChatPlaybackComponent.x;
        String r1 = null;
        if (r6 == null) goto L5;
        String r2 = r6.a;
    L6:
        if (r7 == null) goto L8;
        String r3 = r7.a;
    L10:
        if (Intrinsics.areEqual(r2, r3) == false) goto L27;
        if (r6 == null) goto L13;
        Integer r8 = r6.j;
    L14:
        if (r7 == null) goto L16;
        Integer r9 = r7.j;
    L18:
        if (Intrinsics.areEqual(r8, r9) == false) goto L27;
        if (r6 == null) goto L21;
        String r10 = r6.r;
    L22:
        if (r7 == null) goto L25;
        r1 = r7.r;
    L25:
        if (Intrinsics.areEqual(r10, r1) == false) goto L27;
        boolean r11 = true;
    L29:
        return Boolean.valueOf(r11);
    L21:
        r10 = null;
        goto L22
    L16:
        r9 = null;
        goto L18
    L13:
        r8 = null;
    L27:
        r11 = false;
        goto L29
    L8:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
