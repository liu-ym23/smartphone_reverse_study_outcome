package com.larus.audio.call.plugins;

import com.larus.im.service.audio.cmd.TriggerMode;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class y implements Function2 {
    public final /* synthetic */ com.larus.audio.call.arch.c a;

    public /* synthetic */ y(com.larus.audio.call.arch.c r1) {
        this.a = r1;
    }

    public final Object invoke(Object r7, Object r8) {
        com.larus.audio.call.arch.c r0 = this.a;
        String r9 = (String) r7;
        String r10 = (String) r8;
        if (r9 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        String r2 = null;
        if (r1 == true) goto L12;
    L15:
        LinkedHashMap r3 = new LinkedHashMap();
        ouc.g0 r11 = ouc.k.c(r9);
        Intrinsics.checkNotNullParameter("trigger_event", "key");
        Intrinsics.checkNotNullParameter(r11, "element");
        ouc.i r12 = (ouc.i) r3.put("trigger_event", r11);
        ouc.g0 r13 = ouc.k.c(r10);
        Intrinsics.checkNotNullParameter("enter_method", "key");
        Intrinsics.checkNotNullParameter(r13, "element");
        ouc.i r14 = (ouc.i) r3.put("enter_method", r13);
        ouc.d0 r15 = new ouc.d0(r3);
    L16:
        id9.d r16 = r0.j();
        if (r16 == null) goto L23;
        TriggerMode r4 = TriggerMode.HANGUP;
        if (r15 == null) goto L21;
        r2 = r15.toString();
    L21:
        r16.p(r4, r2);
    L23:
        return Unit.INSTANCE;
    L12:
        if (com.larus.audio.call.util.p.a(r10) == true) goto L15;
        r15 = null;
        goto L16
    L5:
        if (r9.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
