package com.larus.bmhome.instruction.core.impl.controller;

import cq8.a0;
import cq8.y;
import cq8.z0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d extends com.larus.bmhome.instruction.core.impl.base.b {
    public com.larus.bmhome.actionbar.model.c p;
    public boolean q;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        return true;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 0;
    }

    public d() {
        super("CommandController");
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        String r1 = getWidgetId();
        com.larus.bmhome.instruction.core.impl.base.b.C0015b r2 = this.o;
        com.larus.bmhome.actionbar.model.c r3 = this.p;
        boolean r0 = false;
        if (r3 != null) goto L5;
        boolean r4 = false;
    L15:
        return new cq8.i(r1, r2, r3, r4, p());
    L5:
        Integer r5 = r3.i;
        if (r5 != null) goto L9;
    L13:
        r4 = r0;
        goto L15
    L9:
        if (r5.intValue() != 1) goto L13;
        if (Intrinsics.areEqual(r3.d, "gaokao_query_choice") == false) goto L13;
        r0 = true;
        goto L13
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        com.larus.bmhome.actionbar.model.c r0 = this.p;
        Object r1 = null;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (this.q == true) goto L18;
        return null;
    L18:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L10
        Object r3 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(com.larus.bmhome.actionbar.model.c.Companion.serializer()), r0));     // Catch: Throwable -> L10
    L13:
        if (Result.isFailure-impl(r3) == true) goto L17;
        r1 = r3;
    L17:
        return (String) r1;
    L10:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public final z0 p() {
        com.larus.bmhome.instruction.core.impl.base.c r0 = this.c;
        String r1 = null;
        if (r0 == null) goto L9;
        aq8.d r2 = r0.a;
        if (r2 == null) goto L9;
        dq8.h r3 = r2.a;
        if (r3 == null) goto L9;
        String r4 = r3.getBotId();
    L10:
        com.larus.bmhome.instruction.core.impl.base.c r5 = this.c;
        if (r5 == null) goto L17;
        aq8.d r6 = r5.a;
        if (r6 == null) goto L17;
        dq8.h r7 = r6.a;
        if (r7 == null) goto L17;
        String r8 = r7.getConversationId();
    L18:
        com.larus.bmhome.instruction.core.impl.base.c r9 = this.c;
        if (r9 == null) goto L25;
        aq8.d r10 = r9.a;
        if (r10 == null) goto L25;
        dq8.h r11 = r10.a;
        if (r11 == null) goto L25;
        String r12 = r11.getChatType();
    L26:
        com.larus.bmhome.instruction.core.impl.base.c r13 = this.c;
        if (r13 == null) goto L33;
        aq8.d r14 = r13.a;
        if (r14 == null) goto L33;
        dq8.h r15 = r14.a;
        if (r15 == null) goto L33;
        String r16 = r15.getTemplateType();
    L34:
        com.larus.bmhome.instruction.core.impl.base.c r17 = this.c;
        if (r17 == null) goto L43;
        aq8.d r18 = r17.a;
        if (r18 == null) goto L43;
        dq8.h r19 = r18.a;
        if (r19 == null) goto L43;
        Integer r20 = r19.getInstructionType();
        if (r20 == null) goto L43;
        String r21 = r20.toString();
    L44:
        com.larus.bmhome.instruction.core.impl.base.c r22 = this.c;
        if (r22 == null) goto L51;
        aq8.d r23 = r22.a;
        if (r23 == null) goto L51;
        dq8.h r24 = r23.a;
        if (r24 == null) goto L51;
        String r25 = r24.a();
    L52:
        com.larus.bmhome.instruction.core.impl.base.c r26 = this.c;
        if (r26 == null) goto L59;
        aq8.d r27 = r26.a;
        if (r27 == null) goto L59;
        dq8.h r28 = r27.a;
        if (r28 == null) goto L59;
        String r110 = r28.b();
    L60:
        com.larus.bmhome.instruction.core.impl.base.c r29 = this.c;
        if (r29 == null) goto L67;
        aq8.d r30 = r29.a;
        if (r30 == null) goto L67;
        dq8.h r31 = r30.a;
        if (r31 == null) goto L67;
        Boolean r111 = r31.isCreationActionBar();
    L68:
        com.larus.bmhome.actionbar.model.u r32 = this.b;
        if (r32 == null) goto L75;
        String r33 = r32.c;
        if (r33 == null) goto L75;
        if ((!StringsKt.isBlank(r33)) == false) goto L75;
        String r112 = r33;
    L76:
        com.larus.bmhome.instruction.core.impl.base.c r34 = this.c;
        if (r34 == null) goto L84;
        aq8.d r35 = r34.a;
        if (r35 == null) goto L84;
        dq8.h r36 = r35.a;
        if (r36 == null) goto L84;
        r1 = r36.c();
    L84:
        return new z0(r4, r8, r12, r16, r1, r21, r25, r110, r111, r112);
    L75:
        r112 = null;
    L67:
        r111 = null;
    L59:
        r110 = null;
    L51:
        r25 = null;
    L43:
        r21 = null;
    L33:
        r16 = null;
    L25:
        r12 = null;
    L17:
        r8 = null;
    L9:
        r4 = null;
        goto L10
    }

    public final void q() {
        com.larus.bmhome.actionbar.model.c r0 = this.p;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.q == false) goto L7;
        int r1 = 1;
    L8:
        r0.i = r1;
        return;
    L7:
        r1 = 0;
        goto L8
    }

    public final void r() {
        com.larus.bmhome.actionbar.model.c r0 = this.p;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.d;
    L7:
        if (Intrinsics.areEqual(r2, "gaokao_query_choice") == true) goto L9;
        return;
    L9:
        HashMap r3 = r0.c;
        if (r3 == null) goto L12;
        r1 = (String) r3.get("placeholder");
    L12:
        if (r1 != null) goto L14;
        r1 = "";
    L14:
        Integer r4 = r0.i;
        if (r4 != null) goto L18;
    L25:
        Integer r5 = r0.i;
        if (r5 != null) goto L29;
    L30:
        o(new com.larus.bmhome.instruction.core.impl.base.k.d(getWidgetId()));
        return;
    L29:
        if (r5.intValue() != 1) goto L30;
        return;
    L18:
        if (r4.intValue() != 1) goto L25;
        if (r1.length() <= 0) goto L22;
        boolean r6 = true;
    L23:
        if (r6 == false) goto L25;
        o(new com.larus.bmhome.instruction.core.impl.base.k.c(getWidgetId(), r1));
        return;
    L22:
        r6 = false;
        goto L23
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r6) {
        Intrinsics.checkNotNullParameter(r6, "action");
        if ((r6 instanceof cq8.h) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(((cq8.h) r6).b, getWidgetId()) == false) goto L7;
        com.larus.bmhome.instruction.core.impl.base.e r7 = this.d;
        if ((r7 instanceof com.larus.bmhome.instruction.core.impl.base.b) == false) goto L12;
        com.larus.bmhome.instruction.core.impl.base.b r8 = (com.larus.bmhome.instruction.core.impl.base.b) r7;
    L14:
        if (r8 == null) goto L30;
        List<com.larus.bmhome.instruction.core.impl.base.e> r9 = r8.f;
        if (r9 == null) goto L30;
        ArrayList r2 = new ArrayList();
        Iterator r10 = ((ArrayList) r9).iterator();
    L19:
        if (r10.hasNext() == false) goto L23;
        Object r3 = r10.next();
        if ((r3 instanceof d) == false) goto L19;
        r2.add(r3);
        goto L19
    L23:
        Iterator r11 = r2.iterator();
    L25:
        if (r11.hasNext() == false) goto L31;
        d r4 = (d) r11.next();
        if (Intrinsics.areEqual(r4.getWidgetId(), getWidgetId()) == true) goto L28;
        r4.q = false;
        r4.q();
        r4.r();
        r4.j();
        goto L25
    L28:
        r4.q = true;
        r4.q();
        r4.r();
        r4.j();
    L31:
        com.larus.bmhome.actionbar.model.c r12 = this.p;
        if (r12 == null) goto L78;
        String r0 = r12.d;
        if (r0 != null) goto L36;
        return;
    L36:
        switch(r0.hashCode()) {
            case -1732143341: goto L60;
            case -1391384679: goto L56;
            case -916614717: goto L52;
            case -369428202: goto L48;
            case 675262186: goto L44;
            case 893571170: goto L40;
            case 1031694963: goto L38;
            default: goto L86;
        };
    L38:
        r0.equals("gaokao_query_choice");
        return;
    L86:
        return;
    L40:
        if (r0.equals("sync_calendar") == false) goto L87;
        o(new com.larus.bmhome.instruction.core.impl.base.k.f(dq8.i.e.b));
        return;
    L87:
        return;
    L44:
        if (r0.equals("send_user_message") == false) goto L88;
        o(new com.larus.bmhome.instruction.core.impl.base.k.f(new dq8.i.c(r12)));
        return;
    L88:
        return;
    L48:
        if (r0.equals("gaokao_preference") == false) goto L89;
        o(new com.larus.bmhome.instruction.core.impl.base.k.f(new dq8.i.a(getWidgetId(), r12)));
        return;
    L89:
        return;
    L52:
        if (r0.equals("paste_url") == false) goto L90;
        o(new com.larus.bmhome.instruction.core.impl.base.k.f(dq8.i.b.b));
        return;
    L90:
        return;
    L56:
        if (r0.equals("universal_camera") == false) goto L91;
        o(new com.larus.bmhome.instruction.core.impl.base.k.f(new dq8.i.f(getWidgetId(), r12, p())));
        return;
    L91:
        return;
    L60:
        if (r0.equals("single_file") == false) goto L92;
        o(new com.larus.bmhome.instruction.core.impl.base.k.f(new dq8.i.d(r12)));
        return;
    L92:
        return;
    L78:
        return;
    L30:
        this.q = true;
        q();
        r();
        j();
        goto L31
    L12:
        r8 = null;
        goto L14
    L7:
        if (this.q == false) goto L76;
        this.q = false;
        q();
        r();
        j();
        return;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r11) {
        boolean r0 = false;
        if (r11 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        Object r12 = Result.constructor-impl((com.larus.bmhome.actionbar.model.c) xt7.d.b.c(com.larus.bmhome.actionbar.model.c.Companion.serializer(), r11));     // Catch: Throwable -> L14
    L16:
        Throwable r4 = Result.exceptionOrNull-impl(r12);
        if (r4 != null) goto L48;
        com.larus.bmhome.actionbar.model.c r13 = (com.larus.bmhome.actionbar.model.c) r12;
        String r5 = null;
        if (r13 == null) goto L21;
        String r6 = r13.b;
    L22:
        if (r6 != null) goto L24;
    L27:
        boolean r7 = true;
    L28:
        if (r7 == true) goto L30;
        if (r13 == null) goto L34;
        r5 = r13.d;
    L34:
        if (CollectionsKt.contains(SetsKt.setOf(new String[]{"send_user_message", "sync_calendar", "universal_camera", "gaokao_preference", "gaokao_query_choice", "single_file", "paste_url"}), r5) == false) goto L36;
        this.p = r13;
        if (r13 == null) goto L45;
        Integer r14 = r13.i;
        if (r14 == null) goto L45;
        if (r14.intValue() != 1) goto L45;
        r0 = true;
    L45:
        this.q = r0;
        q();
        r();
        return new wa8.a0(Boolean.TRUE, "");
    L36:
        return new wa8.a0(Boolean.FALSE, "not support command type");
    L30:
        return new wa8.a0(Boolean.FALSE, "display text is empty");
    L24:
        if (r6.length() == 0) goto L27;
        r7 = false;
        goto L28
    L21:
        r6 = null;
        goto L22
    L48:
        return new wa8.a0(Boolean.FALSE, r4.getMessage());
    L14:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new wa8.a0(Boolean.FALSE, "command template is empty");
    L5:
        if (r11.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "defaultStateTemplate");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl((com.larus.bmhome.actionbar.model.c) xt7.d.b.c(com.larus.bmhome.actionbar.model.c.Companion.serializer(), r2));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r5) == false) goto L10;
        r5 = null;
    L10:
        com.larus.bmhome.actionbar.model.c r6 = (com.larus.bmhome.actionbar.model.c) r5;
        if (r6 != null) goto L13;
        return;
    L13:
        this.p = r6;
        this.q = true;
        q();
        r();
        return;
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
