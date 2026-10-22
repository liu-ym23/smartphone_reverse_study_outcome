package com.bytedance.android.ec.common.impl.sku;

import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ SkuPanelFragment a;

    public h(SkuPanelFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        rg.a r11 = (rg.a) r10;
        if (r11 != null) goto L6;
        return;
    L6:
        if (this.a.getFragmentManager() != null) goto L18;
    L14:
        Function0 r12 = (Function0) r11.b;
        if (r12 == null) goto L20;
        Unit r13 = (Unit) r12.invoke();
        return;
    L20:
        return;
    L18:
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L14;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L14
    }
}
