package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.bmhome.actionbar.model.i0;
import com.larus.bmhome.actionbar.model.w;
import cq8.a0;
import cq8.r0;
import cq8.s0;
import cq8.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class r extends com.larus.bmhome.instruction.core.impl.base.b {
    public i0 p;

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
        return 7;
    }

    public r() {
        super("TabSelectorController");
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        i0 r0 = this.p;
        Object r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        List r2 = r0.a;
        boolean r3 = false;
        if (r2 == null) goto L19;
        ArrayList r4 = new ArrayList();
        Iterator r5 = r2.iterator();
    L9:
        if (r5.hasNext() == false) goto L20;
        Object r6 = r5.next();
        Integer r7 = ((w) r6).s;
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
    L20:
        if (r4 != null) goto L22;
    L23:
        r3 = true;
    L24:
        if (r3 == false) goto L27;
        return null;
    L27:
        if (this.p == null) goto L29;
        i0 r9 = new i0(r4);
    L40:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L32
        Object r11 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(i0.Companion.serializer()), r9));     // Catch: Throwable -> L32
    L35:
        if (Result.isFailure-impl(r11) == true) goto L39;
        r1 = r11;
    L39:
        return (String) r1;
    L32:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    L29:
        r9 = null;
        goto L40
    L22:
        if (r4.isEmpty() == false) goto L24;
    L19:
        r4 = null;
        goto L20
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        String r1 = getWidgetId();
        com.larus.bmhome.instruction.core.impl.base.b.C0015b r2 = this.o;
        i0 r3 = this.p;
        com.larus.bmhome.actionbar.model.u r0 = this.b;
        if (r0 == null) goto L9;
        String r4 = r0.c;
        if (r4 == null) goto L9;
        if ((!StringsKt.isBlank(r4)) == false) goto L9;
    L10:
        String r5 = r4;
        com.larus.bmhome.actionbar.model.u r6 = this.b;
        if (r6 == null) goto L13;
        boolean r7 = Intrinsics.areEqual(r6.f, Boolean.TRUE);
    L15:
        return new r0(r1, r2, r3, r5, r7);
    L13:
        r7 = false;
    L9:
        r4 = null;
        goto L10
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        if ((r3 instanceof s0) == false) goto L6;
        p(((s0) r3).c);
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
        Object r6 = Result.constructor-impl((i0) xt7.d.b.c(i0.Companion.serializer(), r5));     // Catch: Throwable -> L14
    L16:
        Throwable r4 = Result.exceptionOrNull-impl(r6);
        if (r4 != null) goto L34;
        i0 r7 = (i0) r6;
        if (r7 == null) goto L21;
        List r8 = r7.a;
    L22:
        List r9 = r8;
        if (r9 != null) goto L25;
    L28:
        if (r0 == true) goto L30;
        this.p = r7;
        return new wa8.a0(Boolean.TRUE, "");
    L30:
        return new wa8.a0(Boolean.FALSE, "tab option list is empty");
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
        return new wa8.a0(Boolean.FALSE, "tab selector is empty template");
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public void onEvent(com.larus.bmhome.instruction.core.impl.base.d r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if ((r4 instanceof com.larus.bmhome.instruction.core.impl.base.j) == false) goto L24;
        com.larus.bmhome.instruction.core.impl.base.j r5 = (com.larus.bmhome.instruction.core.impl.base.j) r4;
        String r0 = r5.c.d;
        boolean r1 = false;
        if (r0 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L13;
        Long r6 = 1L;
    L21:
        if (r6 == null) goto L25;
        p(r6.longValue());
        return;
    L25:
        return;
    L13:
        String r7 = r5.c.getLyrics();
        if (r7 != null) goto L16;
    L17:
        r1 = true;
    L18:
        if (r1 == true) goto L20;
        r6 = 2L;
        goto L21
    L20:
        r6 = null;
        goto L21
    L16:
        if (StringsKt.isBlank(r7) == false) goto L18;
    L7:
        if (StringsKt.isBlank(r0) == true) goto L10;
        r2 = false;
        goto L11
    }

    public final void p(long r18) {
        i0 r1 = this.p;
        i0 r2 = null;
        if (r1 == null) goto L5;
        List r3 = r1.a;
    L6:
        if (r3 != null) goto L9;
        r3 = CollectionsKt.emptyList();
    L9:
        if (r3.isEmpty() == false) goto L11;
        return;
    L11:
        List r4 = r3;
        boolean r5 = false;
        boolean r6 = true;
        if ((r4 instanceof Collection) == true) goto L14;
    L16:
        Iterator r7 = r4.iterator();
    L18:
        if (r7.hasNext() == false) goto L28;
        Long r8 = ((w) r7.next()).a;
        if (r8 != null) goto L23;
    L25:
        boolean r9 = false;
    L26:
        if (r9 == false) goto L18;
        boolean r10 = false;
    L29:
        if (r10 == false) goto L31;
        return;
    L31:
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r12 = r4.iterator();
    L33:
        if (r12.hasNext() == false) goto L43;
        w r13 = (w) r12.next();
        Long r14 = r13.a;
        if (r14 != null) goto L38;
    L40:
        int r15 = 0;
    L41:
        r11.add(w.a(r13, null, null, Integer.valueOf(r15), null, null, null, 8126463));
        goto L33
    L38:
        if (r14.longValue() != r18) goto L40;
        r15 = 1;
        goto L41
    L43:
        if (r3.size() != r11.size()) goto L63;
        List r16 = CollectionsKt.zip(r4, r11);
        if ((r16 instanceof Collection) == true) goto L48;
    L50:
        Iterator r17 = r16.iterator();
    L52:
        if (r17.hasNext() == false) goto L62;
        Pair r19 = (Pair) r17.next();
        w r20 = (w) r19.component1();
        w r21 = (w) r19.component2();
        if (Intrinsics.areEqual(r20.a, r21.a) == true) goto L56;
    L59:
        boolean r22 = true;
    L60:
        if (r22 == false) goto L52;
        r5 = true;
        goto L62
    L56:
        if (Intrinsics.areEqual(r20.s, r21.s) == false) goto L59;
        r22 = false;
    L62:
        r6 = r5;
        goto L63
    L48:
        if (r16.isEmpty() == false) goto L50;
    L63:
        if (r6 == true) goto L66;
        return;
    L66:
        if (this.p == null) goto L68;
        r2 = new i0(r11);
    L68:
        this.p = r2;
        if (r2 == null) goto L71;
        o(new com.larus.bmhome.instruction.core.impl.base.k.p(r2));
    L71:
        j();
        return;
    L23:
        if (r8.longValue() != r18) goto L25;
        r9 = true;
    L28:
        r10 = true;
        goto L29
    L14:
        if (r4.isEmpty() == false) goto L16;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "defaultStateTemplate");
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L5
        Object r8 = Result.constructor-impl((i0) xt7.d.b.c(i0.Companion.serializer(), r5));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r8) == false) goto L10;
        r8 = null;
    L10:
        i0 r9 = (i0) r8;
        if (r9 != null) goto L13;
        return;
    L13:
        List r10 = r9.a;
        if (r10 == null) goto L29;
        Iterator r11 = r10.iterator();
    L17:
        if (r11.hasNext() == false) goto L44;
        w r12 = (w) r11.next();
        i0 r0 = this.p;
        if (r0 == null) goto L17;
        List r1 = r0.a;
        if (r1 == null) goto L17;
        Iterator r2 = r1.iterator();
    L24:
        if (r2.hasNext() == false) goto L17;
        w r3 = (w) r2.next();
        if (Intrinsics.areEqual(r3.a, r12.a) == true) goto L27;
        r3.s = 0;
        goto L24
    L27:
        r3.s = 1;
        goto L24
    L44:
        return;
    L29:
        return;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
