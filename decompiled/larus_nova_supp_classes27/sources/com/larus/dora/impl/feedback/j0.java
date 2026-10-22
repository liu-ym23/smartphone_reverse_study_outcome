package com.larus.dora.impl.feedback;

import android.content.res.ColorStateList;
import androidx.core.content.ContextCompat;
import com.larus.dora.impl.databinding.DoragFeedbackFragmentBinding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j0<T> implements FlowCollector {
    public final /* synthetic */ DoraGFeedbackFragment a;

    public j0(DoraGFeedbackFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r2, Continuation r3) {
        if (((Boolean) r2).booleanValue() == false) goto L5;
        DoragFeedbackFragmentBinding r4 = this.a.f;
        Intrinsics.checkNotNull(r4);
        r4.b.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this.a.requireContext(), 2131105539)));
    L7:
        return Unit.INSTANCE;
    L5:
        DoragFeedbackFragmentBinding r5 = this.a.f;
        Intrinsics.checkNotNull(r5);
        r5.b.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this.a.requireContext(), 2131105594)));
        goto L7
    }
}
