package com.bytedance.android.live.recharge.exchange.dialog;

import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.live.recharge.model.ExchangeType;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public AbsCashExchangeDialog a;

    public final void b() {
        AppCompatDialog r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L11;
        DialogLancet.handleBlockedDialogShow(r0);
        return;
    L11:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
    L8:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(AbsCashExchangeDialog r2) {
        this.a = r2;
        if (r2 == 0) goto L6;
        r2.setCancelable(false);
        r2.setCanceledOnTouchOutside(false);
        r2.setOnDismissListener(new d(this));
        return;
    }

    public final void a(ExchangeType r12, k r13, long r14, String r15, boolean r16, Map<String, String> r17, zv0.e r18) {
        Intrinsics.checkNotNullParameter(r12, "type");
        Intrinsics.checkNotNullParameter(r17, "extraMap");
        AbsCashExchangeDialog r1 = this.a;
        if (r1 == null) goto L6;
        r1.I0(r12, r13, r14, r15, r16, r17, r18);
        return;
    }
}
