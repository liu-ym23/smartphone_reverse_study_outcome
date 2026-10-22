package com.larus.tts.impl;

import com.larus.bmhome.chat.component.list.u7;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import xa8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class i implements Function1 {
    public final /* synthetic */ ChatTitleTtsComponent a;

    public /* synthetic */ i(ChatTitleTtsComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r6) {
        ChatTitleTtsComponent r0 = this.a;
        Boolean r7 = (Boolean) r6;
        int r1 = ChatTitleTtsComponent.v;
        u7 r2 = (u7) r0.l.getValue();
        if (r2 == null) goto L27;
        boolean r3 = true;
        if (r7.booleanValue() == true) goto L26;
        com.larus.platform.api.g0 r4 = r0.Y2();
        if (r4 == null) goto L13;
        lq9.q r5 = r4.getEarphoneState();
        if (r5 == null) goto L13;
        if (r5.a != true) goto L13;
        boolean r8 = true;
    L14:
        if (r8 == false) goto L25;
        com.larus.platform.api.g0 r9 = r0.Y2();
        if (r9 == null) goto L22;
        lq9.q r10 = r9.getEarphoneState();
        if (r10 == null) goto L22;
        if (r10.b != true) goto L22;
        boolean r11 = true;
    L23:
        if (r11 == false) goto L25;
    L22:
        r11 = false;
    L25:
        r3 = false;
    L13:
        r8 = false;
    L26:
        r2.A5(r3);
    L27:
        d r12 = (d) r0.m.getValue();
        if (r12 == null) goto L31;
        Intrinsics.checkNotNull(r7);
        r12.HE(r7.booleanValue());
    L31:
        return Unit.INSTANCE;
    }
}
