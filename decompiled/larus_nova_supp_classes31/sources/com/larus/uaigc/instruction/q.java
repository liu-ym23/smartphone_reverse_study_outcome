package com.larus.uaigc.instruction;

import android.content.Context;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class q extends up8.b {
    public com.larus.bmhome.actionbar.model.h l;

    public final boolean a() {
        return true;
    }

    public int getType() {
        return 8;
    }

    public final int i() {
        return 6;
    }

    public final String g() {
        com.larus.bmhome.actionbar.model.h r0 = this.l;
        Object r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        List r2 = r0.e;
        boolean r3 = false;
        if (r2 == null) goto L20;
        ArrayList r4 = new ArrayList();
        Iterator r5 = r2.iterator();
    L9:
        if (r5.hasNext() == false) goto L19;
        Object r6 = r5.next();
        Integer r7 = ((com.larus.bmhome.actionbar.model.w) r6).s;
        if (r7 != null) goto L14;
    L16:
        boolean r8 = false;
    L17:
        if (r8 == false) goto L9;
        r4.add(r6);
        goto L9
    L14:
        if (r7.intValue() != 1) goto L16;
        r8 = true;
        goto L17
    L19:
        ArrayList r11 = r4;
    L21:
        if (r11 != null) goto L23;
    L24:
        r3 = true;
    L25:
        if (r3 == false) goto L27;
        return null;
    L27:
        com.larus.bmhome.actionbar.model.h r9 = this.l;
        if (r9 == null) goto L30;
        com.larus.bmhome.actionbar.model.h r10 = com.larus.bmhome.actionbar.model.h.a(r9, null, null, null, r11, null, null, 4079);
    L41:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L33
        Object r13 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(com.larus.bmhome.actionbar.model.h.Companion.serializer()), r10));     // Catch: Throwable -> L33
    L36:
        if (Result.isFailure-impl(r13) == true) goto L40;
        r1 = r13;
    L40:
        return (String) r1;
    L33:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    L30:
        r10 = null;
        goto L41
    L23:
        if (r11.isEmpty() == false) goto L25;
    L20:
        r11 = null;
        goto L21
    }

    public q() {
    }

    public final AbsInstructionWidget e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new DropFeatureSelectorWidget(r2);
    }

    public final void m(Map<String, ?> r6) {
        Intrinsics.checkNotNullParameter(r6, "instructionDefaultParams");
        Object r7 = r6.get(String.valueOf(getType()));
        if ((r7 instanceof Map) == false) goto L5;
        Map r8 = (Map) r7;
    L6:
        if (r8 == null) goto L8;
        Object r9 = r8.get(String.valueOf(6));
    L10:
        if ((r9 instanceof Map) == false) goto L12;
        Map r10 = (Map) r9;
    L13:
        if (r10 == null) goto L16;
        Object r0 = r10.get(null);
        if (r0 == null) goto L16;
    L20:
        if ((r0 instanceof Map) == false) goto L22;
        Map r1 = (Map) r0;
    L23:
        if (r1 == null) goto L43;
        Object r11 = r1.get("default_select_id");
        if (r11 == null) goto L52;
        com.larus.bmhome.actionbar.model.h r2 = this.l;
        if (r2 == null) goto L53;
        List r3 = r2.e;
        if (r3 == null) goto L54;
        Iterator r4 = r3.iterator();
    L32:
        if (r4.hasNext() == false) goto L55;
        com.larus.bmhome.actionbar.model.w r5 = (com.larus.bmhome.actionbar.model.w) r4.next();
        Long r12 = r5.a;
        if (r12 == null) goto L36;
        String r13 = r12.toString();
    L38:
        if (Intrinsics.areEqual(r13, r11) == true) goto L39;
        r5.s = 0;
        goto L32
    L39:
        r5.s = 1;
        com.larus.bmhome.view.actionbar.edit.c r14 = ((up8.b) this).c;
        if (r14 == null) goto L32;
        r14.setImageStyleRadioSelected(true);
        goto L32
    L36:
        r13 = null;
        goto L38
    L55:
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L43:
        return;
    L22:
        r1 = null;
    L16:
        if (r10 == null) goto L18;
        r0 = r10.get("match_all_id");
        goto L20
    L18:
        r0 = null;
        goto L20
    L12:
        r10 = null;
        goto L13
    L8:
        r9 = null;
        goto L10
    L5:
        r8 = null;
        goto L6
    }

    public final wa8.a0 n(String r5) {
        boolean r0 = true;
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        Object r6 = Result.constructor-impl((com.larus.bmhome.actionbar.model.h) xt7.d.b.c(com.larus.bmhome.actionbar.model.h.Companion.serializer(), r5));     // Catch: Throwable -> L14
    L16:
        Throwable r4 = Result.exceptionOrNull-impl(r6);
        if (r4 != null) goto L34;
        com.larus.bmhome.actionbar.model.h r7 = (com.larus.bmhome.actionbar.model.h) r6;
        if (r7 == null) goto L21;
        List r8 = r7.e;
    L22:
        List r9 = r8;
        if (r9 != null) goto L25;
    L28:
        if (r0 == true) goto L30;
        this.l = r7;
        return new wa8.a0(Boolean.TRUE, "");
    L30:
        return new wa8.a0(Boolean.FALSE, "drop down box parse empty");
    L25:
        if (r9.isEmpty() == true) goto L28;
        r0 = false;
        goto L28
    L21:
        r8 = null;
        goto L22
    L34:
        return new wa8.a0(Boolean.FALSE, r4.getMessage());
    L14:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new wa8.a0(Boolean.FALSE, "style feature selector box is empty template");
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void k(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "defaultStateTemplate");
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L5
        Object r8 = Result.constructor-impl((com.larus.bmhome.actionbar.model.h) xt7.d.b.c(com.larus.bmhome.actionbar.model.h.Companion.serializer(), r5));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r8) == false) goto L10;
        r8 = null;
    L10:
        com.larus.bmhome.actionbar.model.h r9 = (com.larus.bmhome.actionbar.model.h) r8;
        if (r9 != null) goto L13;
        return;
    L13:
        List r10 = r9.e;
        if (r10 == null) goto L31;
        Iterator r11 = r10.iterator();
    L17:
        if (r11.hasNext() == false) goto L48;
        com.larus.bmhome.actionbar.model.w r12 = (com.larus.bmhome.actionbar.model.w) r11.next();
        com.larus.bmhome.actionbar.model.h r0 = this.l;
        if (r0 == null) goto L17;
        List r1 = r0.e;
        if (r1 == null) goto L17;
        Iterator r2 = r1.iterator();
    L24:
        if (r2.hasNext() == false) goto L17;
        com.larus.bmhome.actionbar.model.w r3 = (com.larus.bmhome.actionbar.model.w) r2.next();
        if (Intrinsics.areEqual(r3.a, r12.a) == true) goto L27;
        r3.s = 0;
        goto L24
    L27:
        r3.s = 1;
        com.larus.bmhome.view.actionbar.edit.c r4 = ((up8.b) this).c;
        if (r4 == null) goto L24;
        r4.setImageStyleRadioSelected(true);
        goto L24
    L48:
        return;
    L31:
        return;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
