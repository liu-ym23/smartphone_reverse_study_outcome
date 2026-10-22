package com.larus.dora.impl.nl.notification_rule.ui;

import android.widget.ProgressBar;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.larus.dora.impl.databinding.LarusDoraFragmentAddRuleInputBinding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i<T> implements FlowCollector {
    public final /* synthetic */ AddRuleInputFragment a;

    public i(AddRuleInputFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r2, Continuation r3) {
        boolean r4 = ((Boolean) r2).booleanValue();
        LarusDoraFragmentAddRuleInputBinding r5 = this.a.d;
        if (r5 == null) goto L7;
        LinearLayoutCompat r6 = r5.f;
        if (r6 == null) goto L7;
        r6.setEnabled(!r4);
    L7:
        LarusDoraFragmentAddRuleInputBinding r7 = this.a.d;
        if (r7 == null) goto L16;
        ProgressBar r8 = r7.g;
        if (r8 == null) goto L16;
        if (r4 == false) goto L13;
        int r9 = 0;
    L14:
        r8.setVisibility(r9);
        goto L16
    L13:
        r9 = 8;
    L16:
        return Unit.INSTANCE;
    }
}
