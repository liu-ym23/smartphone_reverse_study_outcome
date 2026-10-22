package com.larus.bmhome.instruction.handler;

import com.larus.bmhome.chat.trace.ChatControlTrace;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class z extends i {
    public com.larus.bmhome.instruction.n j;

    public z(com.larus.bmhome.instruction.p r2) {
        Intrinsics.checkNotNullParameter(r2, "instructionCoreAbility");
        super(r2);
    }

    @Override // com.larus.bmhome.instruction.handler.m
    public final void a(com.larus.bmhome.instruction.n r14) {
        Intrinsics.checkNotNullParameter(r14, "inputData");
        this.j = r14;
        if (r14.c == false) goto L36;
        HashMap r2 = new HashMap();
        ChatControlTrace r15 = ChatControlTrace.b;
        com.larus.bmhome.chat.component.cvs.y r0 = b();
        String r1 = null;
        if (r0 == null) goto L9;
        wc9.e r3 = r0.h();
        if (r3 == null) goto L9;
        String r4 = r3.a;
    L10:
        r15.sb(r4, "action_bar");
        zb8.e r5 = (zb8.e) this.g.getValue();
        if (r5 == null) goto L37;
        com.larus.bmhome.instruction.n r6 = this.j;
        if (r6 == null) goto L18;
        aq8.e r7 = r6.b;
        if (r7 == null) goto L18;
        String r8 = r7.a;
        if (r8 == null) goto L18;
    L19:
        String r9 = r8;
        if (r6 == null) goto L24;
        aq8.e r10 = r6.b;
        if (r10 == null) goto L24;
        Map<String, String> r11 = r10.e;
    L25:
        if (r6 == null) goto L29;
        aq8.e r12 = r6.b;
        if (r12 == null) goto L29;
        String r13 = r12.g;
    L30:
        if (r6 == null) goto L34;
        aq8.e r16 = r6.b;
        if (r16 == null) goto L34;
        r1 = r16.h;
    L34:
        zb8.e.a.b(r5, "message_sug_action", r2, new zb8.a(r9, r13, r1, r11, null, null, 48), null, null, false, 120);
        return;
    L29:
        r13 = null;
    L24:
        r11 = null;
    L18:
        r8 = "";
        goto L19
    L37:
        return;
    L9:
        r4 = null;
        goto L10
    }
}
