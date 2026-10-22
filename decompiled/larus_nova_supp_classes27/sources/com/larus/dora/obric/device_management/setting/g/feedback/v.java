package com.larus.dora.obric.device_management.setting.g.feedback;

import android.widget.Button;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class v<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGFeedbackFragment a;

    public v(DoraObricGFeedbackFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r4, Continuation r5) {
        boolean r6 = ((Boolean) r4).booleanValue();
        Button r7 = this.a.x;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("submitButton");
        r7 = null;
    L5:
        DoraObricGFeedbackFragment r0 = this.a;
        if (r6 == false) goto L8;
        int r8 = r0.aa0();
    L9:
        r7.setBackground(r0.ea0(r8, 24));
        return Unit.INSTANCE;
    L8:
        r8 = v19.c.a(2130972124, r0.requireContext(), 2131103204);
        goto L9
    }
}
