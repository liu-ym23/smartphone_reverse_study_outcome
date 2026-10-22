package com.larus.bmhome.chat.component.list;

import com.larus.im.bean.conversation.IconImage;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class g5 implements Function2 {
    public /* synthetic */ g5() {
    }

    public final Object invoke(Object r4, Object r5) {
        wc9.e r6 = (wc9.e) r4;
        wc9.e r7 = (wc9.e) r5;
        int r0 = ChatListComponent.W3;
        IconImage r1 = null;
        if (r6 == null) goto L5;
        String r2 = r6.a;
    L6:
        if (r7 == null) goto L8;
        String r3 = r7.a;
    L10:
        if (Intrinsics.areEqual(r2, r3) == false) goto L19;
        if (r6 == null) goto L13;
        IconImage r8 = r6.b;
    L14:
        if (r7 == null) goto L17;
        r1 = r7.b;
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
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
