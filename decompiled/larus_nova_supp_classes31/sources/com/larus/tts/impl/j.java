package com.larus.tts.impl;

import com.larus.bmhome.auth.b;
import com.larus.bmhome.auth.c1;
import com.larus.common.apphost.AppHost;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class j implements Function1 {
    public final /* synthetic */ ChatTitleTtsComponent a;

    public /* synthetic */ j(ChatTitleTtsComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5) {
        ChatTitleTtsComponent r0 = this.a;
        c1 r6 = (c1) r5;
        int r1 = ChatTitleTtsComponent.v;
        boolean r2 = false;
        if (r6 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L11;
        return Unit.INSTANCE;
    L11:
        if (AppHost.a.isOversea() == false) goto L21;
        b r7 = (b) r6.d;
        if (r7 == null) goto L16;
        r2 = Intrinsics.areEqual(r7.k(), Boolean.TRUE);
    L16:
        if (r2 == false) goto L22;
        r0.M9();
        return Unit.INSTANCE;
    L22:
        return Unit.INSTANCE;
    L21:
        return Unit.INSTANCE;
    L5:
        if (r6.b != 2) goto L7;
        r3 = true;
        goto L8
    }
}
