package com.larus.uaigc.instruction;

import android.content.Context;
import com.larus.bmhome.actionbar.model.p1;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class u extends up8.b {
    public p1 l;
    public int m;
    public boolean n;

    public final boolean a() {
        return true;
    }

    public int getType() {
        return 8;
    }

    public final int i() {
        return 4;
    }

    public final void k(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "defaultStateTemplate");
    }

    public final String g() {
        Object r1 = null;
        if (this.l == null) goto L26;
        com.larus.bmhome.view.actionbar.edit.c r0 = ((up8.b) this).c;
        if (r0 == null) goto L7;
        p1 r2 = r0.getChosenMsgInstruction();
    L9:
        if (Intrinsics.areEqual(r2, this.l) == false) goto L11;
    L13:
        this.n = false;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L16
        Object r4 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(p1.Companion.serializer()), this.l));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r4) == true) goto L22;
        r1 = r4;
    L22:
        String r5 = (String) r1;
        FLogger.a.i("MsgInstructionController", "collectData result is " + r5);
        return r5;
    L16:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L11:
        if (this.n == true) goto L13;
        return null;
    L7:
        r2 = null;
        goto L9
    L26:
        return null;
    }

    public u() {
    }

    public final AbsInstructionWidget e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new MsgInstructionWidget(r2);
    }

    public final void m(Map<String, ?> r5) {
        Intrinsics.checkNotNullParameter(r5, "instructionDefaultParams");
        p1 r0 = this.l;
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
        FLogger.a.d("MsgInstructionController", "onReStoreComponentStateByDefaultParams: select:" + r11);
        this.n = Intrinsics.areEqual(r11, r3);
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
        this.l = (p1) r4;
        FLogger.a.i("MsgInstructionController", "msgInstructionItem is " + this.l);
        return new wa8.a0(Boolean.TRUE, "");
    L20:
        return new wa8.a0(Boolean.FALSE, r2.getMessage());
    L13:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L10:
        return new wa8.a0(Boolean.FALSE, "feature selector is empty template");
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void q(Integer r1) {
        if (r1 == null) goto L4;
        int r2 = r1.intValue();
    L5:
        this.m = r2;
        return;
    L4:
        r2 = 0;
        goto L5
    }
}
