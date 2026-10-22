package com.larus.uaigc.avatar.instruction;

import android.content.Context;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import wa8.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i extends up8.b {
    public boolean l;
    public com.larus.bmhome.actionbar.model.f m;
    public com.larus.bmhome.actionbar.model.e n;

    public final boolean a() {
        return true;
    }

    public int getType() {
        return 12;
    }

    public final String g() {
        Object r1 = null;
        if (this.n != null) goto L5;
        return null;
    L5:
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        com.larus.bmhome.actionbar.model.e r2 = this.n;
        boolean r3 = false;
        if (r2 == null) goto L21;
        List r4 = r2.c;
        if (r4 == null) goto L21;
        ArrayList r5 = new ArrayList();
        Iterator r6 = r4.iterator();
    L11:
        if (r6.hasNext() == false) goto L22;
        Object r7 = r6.next();
        Integer r8 = ((com.larus.bmhome.actionbar.model.f) r7).h;
        if (r8 != null) goto L16;
    L18:
        boolean r9 = false;
    L19:
        if (r9 == false) goto L11;
        r5.add(r7);
        goto L11
    L16:
        if (r8.intValue() != 1) goto L18;
        r9 = true;
    L22:
        r0.element = r5;
        if (r5 != null) goto L25;
    L26:
        r3 = true;
    L27:
        if (r3 == false) goto L32;
        com.larus.bmhome.actionbar.model.f r10 = this.m;
        if (r10 == null) goto L31;
        ArrayList r11 = new ArrayList();
        r11.add(new com.larus.bmhome.actionbar.model.f(r10.a, r10.c, r10.e, r10.f, null, 1, 74));
        r0.element = r11;
        goto L32
    L31:
        return null;
    L32:
        com.larus.bmhome.actionbar.model.e r12 = this.n;
        if (r12 == null) goto L35;
        com.larus.bmhome.actionbar.model.e r13 = new com.larus.bmhome.actionbar.model.e(r12.a, r12.b, (List) r0.element, r12.d, r12.e);
    L46:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L38
        Object r15 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(com.larus.bmhome.actionbar.model.e.Companion.serializer()), r13));     // Catch: Throwable -> L38
    L41:
        if (Result.isFailure-impl(r15) == true) goto L45;
        r1 = r15;
    L45:
        return (String) r1;
    L38:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    L35:
        r13 = null;
        goto L46
    L25:
        if (r5.isEmpty() == false) goto L27;
    L21:
        r5 = null;
        goto L22
    }

    public i() {
    }

    public final AbsInstructionWidget e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new DigitalAvatarTemplateListSelectorWidget(r2);
    }

    public final a0 n(String r5) {
        boolean r0 = false;
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        Object r6 = Result.constructor-impl((com.larus.bmhome.actionbar.model.e) xt7.d.b.c(com.larus.bmhome.actionbar.model.e.Companion.serializer(), r5));     // Catch: Throwable -> L14
    L16:
        Throwable r4 = Result.exceptionOrNull-impl(r6);
        if (r4 != null) goto L28;
        com.larus.bmhome.actionbar.model.e r7 = (com.larus.bmhome.actionbar.model.e) r6;
        List r8 = r7.b;
        if (r8 == null) goto L25;
        w r9 = (w) CollectionsKt.firstOrNull(r8);
        if (r9 == null) goto L25;
        if (r9.j != true) goto L25;
        r0 = true;
    L25:
        this.l = r0;
        this.n = r7;
        return new a0(Boolean.TRUE, "");
    L28:
        return new a0(Boolean.FALSE, r4.getMessage());
    L14:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new a0(Boolean.FALSE, "image list selector is empty template");
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void k(String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "defaultStateTemplate");
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L5
        Object r14 = Result.constructor-impl((com.larus.bmhome.actionbar.model.e) xt7.d.b.c(com.larus.bmhome.actionbar.model.e.Companion.serializer(), r11));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r14) == false) goto L10;
        r14 = null;
    L10:
        com.larus.bmhome.actionbar.model.e r15 = (com.larus.bmhome.actionbar.model.e) r14;
        if (r15 != null) goto L13;
        return;
    L13:
        List r16 = r15.c;
        if (r16 == null) goto L29;
        Iterator r17 = r16.iterator();
    L17:
        if (r17.hasNext() == false) goto L29;
        com.larus.bmhome.actionbar.model.f r1 = (com.larus.bmhome.actionbar.model.f) r17.next();
        com.larus.bmhome.actionbar.model.e r2 = this.n;
        if (r2 == null) goto L17;
        List r3 = r2.c;
        if (r3 == null) goto L17;
        Iterator r4 = r3.iterator();
    L24:
        if (r4.hasNext() == false) goto L17;
        com.larus.bmhome.actionbar.model.f r5 = (com.larus.bmhome.actionbar.model.f) r4.next();
        if (r5.a == r1.a) goto L27;
        r5.h = 0;
        goto L24
    L27:
        r5.h = 1;
    L29:
        com.larus.bmhome.actionbar.model.f r18 = r15.e;
        if (r18 == null) goto L47;
        long r6 = r18.a;
        g1 r7 = r18.e;
        g1 r8 = r18.f;
        this.m = new com.larus.bmhome.actionbar.model.f(r6, r18.c, r7, r8, null, 1, 74);
        return;
    L47:
        return;
    L5:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
