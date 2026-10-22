package com.larus.bmhome.instruction.handler;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.bean.PageType;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.doubletab.IChatDoubleTabAbility;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d0 extends i {
    public final com.larus.bmhome.instruction.p j;
    public com.larus.bmhome.instruction.n k;

    public d0(com.larus.bmhome.instruction.p r2) {
        Intrinsics.checkNotNullParameter(r2, "instructionCoreAbility");
        super(r2);
        this.j = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.handler.m
    public final void a(com.larus.bmhome.instruction.n r44) {
        Intrinsics.checkNotNullParameter(r44, "inputData");
        this.k = r44;
        String r3 = "";
        Object r4 = null;
        if (r44.c == false) goto L19;
        com.larus.bmhome.instruction.p r2 = this.j;
        aq8.e r1 = r44.b;
        if (r1 == null) goto L10;
        String r5 = r1.a;
        if (r5 == null) goto L10;
        r3 = r5;
    L10:
        if (r1 == null) goto L12;
        Map<String, String> r27 = r1.e;
    L13:
        if (r1 == null) goto L15;
        r4 = r1.h;
    L15:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "prompt");
        ICoreInputAbility.OnSendParams r6 = new ICoreInputAbility.OnSendParams(r3, "", null, null, null, null, null, null, 0, false, "", false, false, false, null, null, null, null, false, null, r27, null, r4, null, null, null, null, null, null, s1a.d.a(r2.a).a(ChatPageContext.class), null, null, null, -542392128, 1, null);
        n r7 = r2.d;
        if (r7 == null) goto L18;
        r7.E0(r6);
    L18:
        FLogger.a.i("InstructionCoreHandler", "sendTextMessage prompt:".concat(r3));
        return;
    L12:
        r27 = null;
        goto L13
    L19:
        com.larus.bmhome.instruction.g r8 = (com.larus.bmhome.instruction.g) this.f.getValue();
        if (r8 == null) goto L22;
        r8.A1();
    L22:
        ci8.d r9 = ci8.e.a(d());
        if (r9 == null) goto L25;
        r9.f0(PageType.Chat.getType());
    L25:
        IChatDoubleTabAbility r10 = (IChatDoubleTabAbility) this.d.getValue();
        if (r10 == null) goto L28;
        r10.f0(0);
    L28:
        g1 r11 = (g1) this.i.getValue();
        if (r11 == null) goto L36;
        g1 r12 = (g1) this.i.getValue();
        if (r12 == null) goto L34;
        String r13 = r12.uM();
        if (r13 == null) goto L34;
    L35:
        r11.b2(r13);
    L34:
        r13 = "";
    L36:
        com.larus.bmhome.instruction.h r14 = (com.larus.bmhome.instruction.h) this.e.getValue();
        if (r14 == null) goto L45;
        com.larus.bmhome.instruction.n r15 = this.k;
        if (r15 == null) goto L43;
        aq8.e r16 = r15.b;
        if (r16 == null) goto L43;
        Map<String, String> r17 = r16.e;
    L44:
        r14.qz(r17, "handleFillMsg");
    L43:
        r17 = null;
    L45:
        ICoreInputAbility r18 = c();
        if (r18 == null) goto L69;
        com.larus.bmhome.instruction.n r19 = this.k;
        if (r19 == null) goto L55;
        aq8.e r20 = r19.b;
        if (r20 == null) goto L55;
        String r21 = r20.a;
        if (r21 == null) goto L55;
        String r22 = r21;
    L57:
        if (r19 == null) goto L61;
        aq8.e r23 = r19.b;
        if (r23 == null) goto L61;
        Integer r110 = r23.b;
    L62:
        if (r19 == null) goto L66;
        aq8.e r24 = r19.b;
        if (r24 == null) goto L66;
        r4 = r24.c;
    L66:
        ICoreInputAbility.b.d(r18, r22, false, true, r110, r4, false, 34);
        return;
    L61:
        r110 = null;
    L55:
        r22 = "";
        goto L57
    }
}
