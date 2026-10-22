package com.larus.bmhome.chat.component.trace;

import com.larus.bmhome.chat.immerse.ChatImmersFragment;
import com.larus.common.apphost.AppHost;
import de8.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class l implements Function0 {
    public final /* synthetic */ ChatTraceComponent a;

    public /* synthetic */ l(ChatTraceComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatTraceComponent r0 = this.a;
        int r1 = ChatTraceComponent.L;
        if (r0.X2() == true) goto L28;
        c r2 = r0.f1();
        boolean r3 = false;
        if (r2 != null) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L28;
        if (Intrinsics.areEqual(AppHost.a.a().getCurrentActivity(), a.getActivity(r0)) == false) goto L28;
        com.larus.bmhome.chat.component.immerse.a r5 = (com.larus.bmhome.chat.component.immerse.a) r0.l.getValue();
        if (r5 == null) goto L16;
        ChatImmersFragment r6 = r5.Z5();
    L18:
        if ((r6 instanceof ChatImmersFragment) == true) goto L21;
        r6 = null;
    L21:
        if (r6 != null) goto L23;
    L25:
        if (r3 == false) goto L28;
        r0.DF("slide_in_immersive", null);
        goto L28
    L23:
        if (r6.C != true) goto L25;
        r3 = true;
        goto L25
    L16:
        r6 = null;
        goto L18
    L7:
        if (r2.C() != true) goto L9;
        r4 = true;
    L28:
        return Unit.INSTANCE;
    }
}
