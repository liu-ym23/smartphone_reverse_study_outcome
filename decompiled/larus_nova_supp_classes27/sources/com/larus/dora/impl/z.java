package com.larus.dora.impl;

import com.bytedance.crash.d;
import com.larus.common_ui.dialog.CommonDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class z implements com.larus.common_ui.dialog.u {
    public final /* synthetic */ Function1<Boolean, Unit> a;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        Function1<Boolean, Unit> r0 = this.a;
        if (r0 == null) goto L5;
        r0.invoke(Boolean.FALSE);
    L5:
        CommonDialog r1 = DoraPreWakeUpTask.o;
        if (r1 == null) goto L16;
        r1.dismiss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L17;
        d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L17:
        return;
    }

    public z(l r1) {
        this.a = r1;
    }
}
