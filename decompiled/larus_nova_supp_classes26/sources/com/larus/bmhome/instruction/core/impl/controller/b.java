package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.bmhome.actionbar.model.w;
import cq8.a0;
import cq8.y;
import cq8.z0;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends com.larus.bmhome.instruction.core.impl.base.b {
    public com.larus.bmhome.actionbar.model.a p;
    public boolean q;

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 16;
    }

    public b() {
        super("ButtonRouterController");
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        com.larus.bmhome.actionbar.model.a r0 = this.p;
        if (r0 == null) goto L28;
        String r2 = null;
        if (r0 == null) goto L7;
        String r1 = r0.b;
    L9:
        if (r1 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == true) goto L29;
        com.larus.bmhome.actionbar.model.a r4 = this.p;
        if (r4 == null) goto L19;
        r2 = r4.c;
    L19:
        if (r2 != null) goto L21;
    L24:
        boolean r5 = true;
    L25:
        if (r5 == true) goto L30;
        return true;
    L30:
        return false;
    L21:
        if (r2.length() == 0) goto L24;
        r5 = false;
        goto L25
    L29:
        return false;
    L11:
        if (r1.length() == 0) goto L14;
        r3 = false;
        goto L15
    L7:
        r1 = null;
        goto L9
    L28:
        return false;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        return new cq8.c(getWidgetId(), this.o, this.p, p());
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        com.larus.bmhome.actionbar.model.a r0 = this.p;
        Object r1 = null;
        if (r0 != null) goto L15;
        return null;
    L15:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        Object r3 = Result.constructor-impl(xt7.d.b.a(com.larus.bmhome.actionbar.model.a.Companion.serializer(), r0));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r3) == true) goto L14;
        r1 = r3;
    L14:
        return (String) r1;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final z0 p() {
        com.larus.bmhome.instruction.core.impl.base.c r0 = this.c;
        if (r0 == null) goto L9;
        aq8.d r1 = r0.a;
        if (r1 == null) goto L9;
        dq8.h r2 = r1.a;
        if (r2 == null) goto L9;
        String r3 = r2.getBotId();
    L10:
        com.larus.bmhome.instruction.core.impl.base.c r4 = this.c;
        if (r4 == null) goto L17;
        aq8.d r5 = r4.a;
        if (r5 == null) goto L17;
        dq8.h r6 = r5.a;
        if (r6 == null) goto L17;
        String r7 = r6.getConversationId();
    L18:
        com.larus.bmhome.instruction.core.impl.base.c r8 = this.c;
        if (r8 == null) goto L25;
        aq8.d r9 = r8.a;
        if (r9 == null) goto L25;
        dq8.h r10 = r9.a;
        if (r10 == null) goto L25;
        String r11 = r10.getChatType();
    L26:
        com.larus.bmhome.instruction.core.impl.base.c r12 = this.c;
        if (r12 == null) goto L33;
        aq8.d r13 = r12.a;
        if (r13 == null) goto L33;
        dq8.h r14 = r13.a;
        if (r14 == null) goto L33;
        String r15 = r14.getTemplateType();
    L34:
        com.larus.bmhome.instruction.core.impl.base.c r16 = this.c;
        if (r16 == null) goto L41;
        aq8.d r17 = r16.a;
        if (r17 == null) goto L41;
        dq8.h r18 = r17.a;
        if (r18 == null) goto L41;
        String r19 = r18.c();
    L42:
        com.larus.bmhome.instruction.core.impl.base.c r20 = this.c;
        if (r20 == null) goto L51;
        aq8.d r21 = r20.a;
        if (r21 == null) goto L51;
        dq8.h r22 = r21.a;
        if (r22 == null) goto L51;
        Integer r23 = r22.getInstructionType();
        if (r23 == null) goto L51;
        String r24 = r23.toString();
    L52:
        com.larus.bmhome.instruction.core.impl.base.c r25 = this.c;
        if (r25 == null) goto L59;
        aq8.d r26 = r25.a;
        if (r26 == null) goto L59;
        dq8.h r27 = r26.a;
        if (r27 == null) goto L59;
        String r28 = r27.a();
    L60:
        com.larus.bmhome.instruction.core.impl.base.c r29 = this.c;
        if (r29 == null) goto L67;
        aq8.d r30 = r29.a;
        if (r30 == null) goto L67;
        dq8.h r31 = r30.a;
        if (r31 == null) goto L67;
        String r110 = r31.b();
    L68:
        com.larus.bmhome.instruction.core.impl.base.c r32 = this.c;
        if (r32 == null) goto L75;
        aq8.d r33 = r32.a;
        if (r33 == null) goto L75;
        dq8.h r34 = r33.a;
        if (r34 == null) goto L75;
        Boolean r111 = r34.isCreationActionBar();
    L76:
        com.larus.bmhome.actionbar.model.u r35 = this.b;
        if (r35 == null) goto L86;
        String r36 = r35.c;
        if (r36 == null) goto L86;
        if (r36.length() <= 0) goto L83;
        boolean r37 = true;
    L84:
        if (r37 == false) goto L86;
        String r112 = r36;
    L88:
        return new z0(r3, r7, r11, r15, r19, r24, r28, r110, r111, r112);
    L83:
        r37 = false;
    L86:
        r112 = null;
    L75:
        r111 = null;
    L67:
        r110 = null;
    L59:
        r28 = null;
    L51:
        r24 = null;
    L41:
        r19 = null;
    L33:
        r15 = null;
    L25:
        r11 = null;
    L17:
        r7 = null;
    L9:
        r3 = null;
        goto L10
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void l(Map<String, ?> r2) {
        Intrinsics.checkNotNullParameter(r2, "instructionDefaultParams");
        Intrinsics.checkNotNullParameter(r2, "instructionDefaultParams");
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r13) {
        Intrinsics.checkNotNullParameter(r13, "action");
        boolean r1 = true;
        if ((r13 instanceof cq8.e) == false) goto L14;
        if (Intrinsics.areEqual(((cq8.e) r13).b, getWidgetId()) == true) goto L7;
        return;
    L7:
        if (this.q == true) goto L63;
        com.larus.bmhome.actionbar.model.a r14 = this.p;
        if (r14 == null) goto L64;
        this.q = true;
        o(new com.larus.bmhome.instruction.core.impl.base.k.b(new dq8.b(getWidgetId(), r14, p())));
        return;
    L64:
        return;
    L63:
        return;
    L14:
        if ((r13 instanceof cq8.b) == false) goto L33;
        if (Intrinsics.areEqual(((cq8.b) r13).b, getWidgetId()) == false) goto L65;
        com.larus.bmhome.actionbar.model.a r5 = this.p;
        if (r5 == null) goto L66;
        String r4 = getWidgetId();
        com.larus.bmhome.actionbar.model.a r2 = this.p;
        if (r2 == null) goto L30;
        List r3 = r2.j;
        if (r3 == null) goto L30;
        w r6 = (w) CollectionsKt.firstOrNull(r3);
        if (r6 == null) goto L30;
        Map r7 = r6.q;
        if (r7 == null) goto L30;
        String r8 = (String) r7.get("selected_id");
    L31:
        o(new com.larus.bmhome.instruction.core.impl.base.k.a(new dq8.a(r4, r5, r8, p(), this.o)));
        return;
    L30:
        r8 = null;
        goto L31
    L66:
        return;
    L65:
        return;
    L33:
        if ((r13 instanceof cq8.d) == false) goto L62;
        cq8.d r15 = (cq8.d) r13;
        if (Intrinsics.areEqual(r15.b, getWidgetId()) == false) goto L67;
        com.larus.bmhome.actionbar.model.a r0 = this.p;
        if (r0 == null) goto L68;
        String r9 = r15.d;
        String r10 = r15.c;
        if (r10 != null) goto L43;
    L56:
        List r16 = CollectionsKt.emptyList();
    L57:
        r0.j = r16;
        j();
        return;
    L43:
        if (r9 != null) goto L45;
    L50:
        r1 = false;
    L51:
        if (r1 == false) goto L56;
        Map r11 = MapsKt.createMapBuilder();
        r11.put("selected_id", r10);
        r11.put("selected_name", r9);
        Map<String, String> r17 = r15.f;
        if (r17 == null) goto L55;
        r11.putAll(r17);
    L55:
        Unit r18 = Unit.INSTANCE;
        r16 = CollectionsKt.listOf(new w(null, r9, null, null, 0, MapsKt.toMutableMap(MapsKt.build(r11)), null, 8323069));
        goto L57
    L45:
        if (r9.length() <= 0) goto L47;
        boolean r12 = true;
    L48:
        if (r12 != true) goto L50;
    L47:
        r12 = false;
        goto L48
    L68:
        return;
    L67:
        return;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r5) {
        boolean r0 = true;
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        Object r6 = Result.constructor-impl((com.larus.bmhome.actionbar.model.a) xt7.d.b.c(com.larus.bmhome.actionbar.model.a.Companion.serializer(), r5));     // Catch: Throwable -> L14
    L16:
        Throwable r4 = Result.exceptionOrNull-impl(r6);
        if (r4 != null) goto L42;
        com.larus.bmhome.actionbar.model.a r7 = (com.larus.bmhome.actionbar.model.a) r6;
        if (r7 == null) goto L21;
        String r8 = r7.b;
    L22:
        if (r8 != null) goto L24;
    L27:
        boolean r9 = true;
    L28:
        if (r9 == true) goto L40;
        String r10 = r7.c;
        if (r10 != null) goto L32;
    L35:
        if (r0 == true) goto L40;
        this.p = r7;
        return new wa8.a0(Boolean.TRUE, "");
    L32:
        if (r10.length() == 0) goto L35;
        r0 = false;
    L40:
        return new wa8.a0(Boolean.FALSE, "ButtonRouter info is required displayText=" + r7.b + " schema=" + r7.c);
    L24:
        if (r8.length() == 0) goto L27;
        r9 = false;
        goto L28
    L21:
        r8 = null;
        goto L22
    L42:
        return new wa8.a0(Boolean.FALSE, "Failed to parse button router template: " + r4.getMessage());
    L14:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new wa8.a0(Boolean.FALSE, "Button router template is empty");
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "defaultStateTemplate");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl((com.larus.bmhome.actionbar.model.a) xt7.d.b.c(com.larus.bmhome.actionbar.model.a.Companion.serializer(), r2));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r5) == false) goto L10;
        r5 = null;
    L10:
        com.larus.bmhome.actionbar.model.a r6 = (com.larus.bmhome.actionbar.model.a) r5;
        if (r6 != null) goto L13;
        return;
    L13:
        this.p = r6;
        return;
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
