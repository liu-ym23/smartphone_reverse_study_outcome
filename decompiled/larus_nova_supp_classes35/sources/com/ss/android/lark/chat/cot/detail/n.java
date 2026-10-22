package com.ss.android.lark.chat.cot.detail;

import android.content.DialogInterface;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.ss.android.lark.biz.im.extension.panel.drag.DragPanel;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n implements DialogInterface.OnClickListener {
    public final /* synthetic */ CotDetailSheet a;

    public n(CotDetailSheet r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r4, int r5) {
        CotDetailSheet r6 = this.a;
        if (r6.t == false) goto L5;
        return;
    L5:
        if (r6.a.isFinishing() == false) goto L7;
        return;
    L7:
        if (r6.a.isDestroyed() == false) goto L35;
        return;
    L35:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L16
        Function0<Unit> r1 = r6.g;     // Catch: Throwable -> L16
        if (r1 == null) goto L13;
        r1.invoke();     // Catch: Throwable -> L16
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L14:
        Object r3 = Result.constructor-impl(r2);     // Catch: Throwable -> L16
    L19:
        if (Result.isSuccess-impl(r3) == false) goto L26;
        Unit r7 = (Unit) r3;
        LKUIDialog r8 = r6.l;
        if (r8 == null) goto L23;
        CotDetailSheet.a(r8);
    L23:
        r6.l = null;
        DragPanel r9 = r6.k;
        if (r9 == null) goto L26;
        r9.dismiss();
    L26:
        Throwable r10 = Result.exceptionOrNull-impl(r3);
        if (r10 == null) goto L39;
        com.ss.android.lark.chat.cot.f.b("detail_stop", "send stop command failed, messageId=" + r6.c, r10);
        LKUIDialog r11 = r6.l;
        if (r11 == null) goto L31;
        CotDetailSheet.a(r11);
    L31:
        r6.l = null;
        DragPanel r12 = r6.k;
        if (r12 == null) goto L40;
        r12.dismiss();
        return;
    L40:
        return;
    L39:
        return;
    L13:
        r2 = null;
    L16:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }
}
