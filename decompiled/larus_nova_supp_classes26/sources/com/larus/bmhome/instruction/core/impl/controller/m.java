package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.bmhome.actionbar.model.p1;
import com.larus.im.internal.delegate.c0;
import cq8.a0;
import cq8.i0;
import cq8.j0;
import cq8.y;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m extends com.larus.bmhome.instruction.core.impl.base.b {
    public p1 p;
    public int q;
    public boolean r;
    public boolean s;

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        return true;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 8;
    }

    public m() {
        super("MsgInstructionController");
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        return new j0(getWidgetId(), this.o, this.p, this.q);
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        Object r1 = null;
        if (this.p != null) goto L5;
        return null;
    L5:
        if (this.r == false) goto L7;
    L9:
        this.s = false;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        Object r2 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(p1.Companion.serializer()), this.p));     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r2) == true) goto L18;
        r1 = r2;
    L18:
        String r3 = (String) r1;
        c0.b.i("MsgInstructionController", "collectData result is " + r3);
        return r3;
    L12:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L7:
        if (this.s == true) goto L9;
        return null;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void h(Integer r1) {
        if (r1 == null) goto L4;
        int r2 = r1.intValue();
    L5:
        this.q = r2;
        return;
    L4:
        r2 = 0;
        goto L5
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void l(Map<String, ?> r5) {
        Intrinsics.checkNotNullParameter(r5, "instructionDefaultParams");
        p1 r0 = this.p;
        Map r1 = null;
        if (r0 == null) goto L7;
        Integer r2 = r0.a;
        if (r2 == null) goto L7;
        String r3 = r2.toString();
    L8:
        Object r6 = r5.get(String.valueOf(getType()));
        if ((r6 instanceof Map) == false) goto L11;
        Map r7 = (Map) r6;
    L12:
        if (r7 == null) goto L14;
        Object r8 = r7.get(String.valueOf(4));
    L16:
        if ((r8 instanceof Map) == false) goto L18;
        Map r9 = (Map) r8;
    L19:
        if (r9 == null) goto L21;
        Object r10 = r9.get("match_all_id");
    L23:
        if ((r10 instanceof Map) == false) goto L25;
        r1 = (Map) r10;
    L25:
        if (r1 == null) goto L30;
        Object r11 = r1.get("default_select_id");
        if (r11 == null) goto L31;
        c0.b.i("MsgInstructionController", "onRestoreComponentStateByDefaultParams: select:" + r11);
        this.s = Intrinsics.areEqual(r11, r3);
        return;
    L31:
        return;
    L30:
        return;
    L21:
        r10 = null;
        goto L23
    L18:
        r9 = null;
        goto L19
    L14:
        r8 = null;
        goto L16
    L11:
        r7 = null;
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        if (Intrinsics.areEqual(r3.a(), getWidgetId()) == true) goto L6;
        return;
    L6:
        if ((r3 instanceof i0) == false) goto L9;
        this.r = ((i0) r3).c;
        return;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        Object r4 = Result.constructor-impl((p1) xt7.d.b.c(p1.Companion.serializer(), r3));     // Catch: Throwable -> L13
    L15:
        Throwable r2 = Result.exceptionOrNull-impl(r4);
        if (r2 != null) goto L20;
        this.p = (p1) r4;
        c0.b.i("MsgInstructionController", "msgInstructionItem is " + this.p);
        return new wa8.a0(Boolean.TRUE, "");
    L20:
        return new wa8.a0(Boolean.FALSE, r2.getMessage());
    L13:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L10:
        return new wa8.a0(Boolean.FALSE, "msg instruction is empty template");
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }
}
