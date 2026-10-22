package com.larus.dora.impl.nl.notification_rule.ui;

import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.utils.x1;
import com.larus.dora.impl.databinding.LarusDoraFragmentAddRuleInputBinding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l<T> implements FlowCollector {
    public final /* synthetic */ AddRuleInputFragment a;

    public l(AddRuleInputFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r3, Continuation r4) {
        Integer r5 = (Integer) r3;
        x1 r6 = this.a.f;
        if (r6 == null) goto L5;
        r6.a(true);
    L5:
        AddRuleInputFragment r7 = this.a;
        if (r7.getContext() == null) goto L24;
        LarusDoraFragmentAddRuleInputBinding r0 = r7.d;
        if (r0 == null) goto L13;
        ConstraintLayout r1 = r0.h;
        if (r1 == null) goto L13;
        r1.setBackgroundResource(2131240416);
    L13:
        LarusDoraFragmentAddRuleInputBinding r8 = r7.d;
        if (r8 == null) goto L24;
        TextView r9 = r8.d;
        if (r9 == null) goto L24;
        if (r5 != null) goto L19;
    L21:
        r9.setText(2131902256);
    L22:
        r9.setVisibility(0);
        goto L24
    L19:
        if (r5.intValue() == 0) goto L21;
        r9.setText(r5.intValue());
    L24:
        return Unit.INSTANCE;
    }
}
