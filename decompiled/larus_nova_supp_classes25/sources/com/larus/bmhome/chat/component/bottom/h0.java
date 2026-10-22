package com.larus.bmhome.chat.component.bottom;

import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.ui.arch.component.internal.attach.Attachable;
import de8.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tx9.x3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class h0 implements Function1 {
    public final /* synthetic */ ChatBottomComponent a;

    public /* synthetic */ h0(ChatBottomComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r7) {
        ChatBottomComponent r0 = this.a;
        Attachable r8 = (Attachable) r7;
        int r1 = ChatBottomComponent.L0;
        Intrinsics.checkNotNullParameter(r8, "$this$attach");
        r8.component(r0, new a0());
        r8.component(r0, new e0());
        r8.contentComponent(r0, new f0());
        r8.contentComponent(r0, new g0());
        r8.contentComponent(r0, new i0());
        com.larus.bmhome.chat.api.e0 r2 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r2 == null) goto L5;
        LaunchInfo r3 = r2.a;
    L6:
        if (r3 == null) goto L8;
        String r4 = r3.W();
    L10:
        if (rs8.a.a() == true) goto L22;
        c r5 = r0.f1();
        if (r5 == null) goto L14;
        String r6 = r5.f();
    L16:
        if (Intrinsics.areEqual(r6, r4) == false) goto L22;
        if (AppHost.a.isPlugin() == false) goto L21;
        r8.contentComponent(r0, new k0());
    L25:
        r8.contentComponent(r0, new l0());
        r8.contentComponent(r0, new m0());
        r8.component(r0, new n0());
        r8.contentComponent(r0, new b0());
        r8.contentComponent(r0, new c0());
        r8.contentComponent(r0, new d0());
        return Unit.INSTANCE;
    L21:
        x3.a("action_bar", "instruction_input_component_not_attached", null);
        goto L25
    L14:
        r6 = null;
    L22:
        if (r3 != null) goto L24;
        x3.a("action_bar", "instruction_input_component_not_attached_fixed", null);
    L24:
        r8.contentComponent(r0, new j0());
        goto L25
    L8:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }
}
