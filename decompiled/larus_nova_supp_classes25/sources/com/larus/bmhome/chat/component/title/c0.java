package com.larus.bmhome.chat.component.title;

import com.larus.im.bean.conversation.IconImage;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class c0 implements Function2 {
    public /* synthetic */ c0() {
    }

    public final Object invoke(Object r4, Object r5) {
        e r6 = (e) r4;
        e r7 = (e) r5;
        int r0 = ChatTitleComponent.P1;
        Boolean r1 = null;
        if (r6 == null) goto L5;
        String r2 = r6.a;
    L6:
        if (r7 == null) goto L8;
        String r3 = r7.a;
    L10:
        if (Intrinsics.areEqual(r2, r3) == false) goto L35;
        if (r6 == null) goto L13;
        String r8 = r6.c;
    L14:
        if (r7 == null) goto L16;
        String r9 = r7.c;
    L18:
        if (Intrinsics.areEqual(r8, r9) == false) goto L35;
        if (r7 == null) goto L21;
        IconImage r10 = r7.b;
    L22:
        if (r6 == null) goto L24;
        IconImage r11 = r6.b;
    L26:
        if (Intrinsics.areEqual(r10, r11) == false) goto L35;
        if (r6 == null) goto L29;
        Boolean r12 = Boolean.valueOf(r6.g());
    L30:
        if (r7 == null) goto L33;
        r1 = Boolean.valueOf(r7.g());
    L33:
        if (Intrinsics.areEqual(r12, r1) == false) goto L35;
        boolean r13 = true;
    L37:
        return Boolean.valueOf(r13);
    L29:
        r12 = null;
        goto L30
    L24:
        r11 = null;
        goto L26
    L21:
        r10 = null;
        goto L22
    L16:
        r9 = null;
        goto L18
    L13:
        r8 = null;
    L35:
        r13 = false;
        goto L37
    L8:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
