package com.larus.business.multitask_management.impl;

import com.bytedance.crash.d;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.u;
import com.larus.multitask_management.api.data.TaskType;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kl9.x;
import kotlin.Result;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;
import tx9.h2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class MultiTaskHostAbilityImpl$b implements u {
    public final /* synthetic */ kl9.u a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Ref.ObjectRef<CommonDialog> c;
    public final /* synthetic */ i<Boolean> d;

    public final void cancel() {
        kl9.u r0 = this.a;
        String r1 = r0.a;
        String r2 = r0.t;
        String r3 = r0.v;
        String r4 = r0.u;
        TaskType r5 = r0.f;
        if (r5 == null) goto L5;
        Integer r6 = Integer.valueOf(r5.getValue());
    L6:
        String r7 = String.valueOf(r6);
        kl9.u r8 = this.a;
        x r9 = r8.i;
        String r10 = "";
        if (r9 == null) goto L10;
        String r11 = r9.a;
        if (r11 == null) goto L10;
    L11:
        String r12 = r8.c;
        if (r12 == null) goto L15;
        r10 = r12;
    L15:
        h2.c(r1, r2, r3, r4, r11, r7, r10, Integer.valueOf(this.b + 1), "cancel");
        CommonDialog r13 = (CommonDialog) this.c.element;
        if (r13 == null) goto L24;
        r13.dismiss();     // Catch: Exception -> L19
    L19:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r14 = DialogFragmentLancet.sLastShowStack;
        if (r14 == null) goto L24;
        d.d(r14, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L24:
        if (this.d.isActive() == false) goto L29;
        i<Boolean> r15 = this.d;
        Result.Companion r16 = Result.Companion;
        r15.resumeWith(Result.constructor-impl(Boolean.FALSE));
        return;
    L29:
        return;
    L10:
        r11 = "";
        goto L11
    L5:
        r6 = null;
        goto L6
    }

    public MultiTaskHostAbilityImpl$b(kl9.u r1, int r2, Ref.ObjectRef r3, j r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
