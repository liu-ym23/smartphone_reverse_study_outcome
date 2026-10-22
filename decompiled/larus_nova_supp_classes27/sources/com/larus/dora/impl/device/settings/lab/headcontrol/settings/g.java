package com.larus.dora.impl.device.settings.lab.headcontrol.settings;

import android.content.Context;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.dora.impl.databinding.LarusDoraPageHeadControlSettingsBinding;
import kotlin.Function;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class g implements FlowCollector, FunctionAdapter {
    public final /* synthetic */ HeadControlSettingsFragment a;

    public g(HeadControlSettingsFragment r1) {
        this.a = r1;
    }

    public final boolean equals(Object r3) {
        if ((r3 instanceof FlowCollector) == true) goto L5;
        return false;
    L5:
        if ((r3 instanceof FunctionAdapter) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
    }

    public final Function<?> getFunctionDelegate() {
        return new AdaptedFunctionReference(2, this.a, HeadControlSettingsFragment.class, "renderBehaviorAwareBanner", "renderBehaviorAwareBanner(Z)V", 4);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    public final Object emit(Object r8, Continuation r9) {
        boolean r10 = ((Boolean) r8).booleanValue();
        final HeadControlSettingsFragment r11 = this.a;
        LarusDoraPageHeadControlSettingsBinding r0 = r11.f;
        if (r0 == null) goto L19;
        ConstraintLayout r1 = r0.c;
        if (r1 == null) goto L19;
        TextView r2 = r0.e;
        if (r2 == null) goto L19;
        TextView r3 = r0.d;
        if (r3 == null) goto L19;
        if (r10 == true) goto L15;
        r1.setVisibility(8);
        r3.setOnClickListener(null);
        goto L19
    L15:
        Context r12 = r11.getContext();
        if (r12 == null) goto L19;
        r1.setVisibility(0);
        r1.setBackgroundColor(v19.c.a(2130970496, r11.requireContext(), 2131102512));
        r2.setText(r12.getString(2131902596));
        r2.setTextColor(HeadControlSettingsFragment.i);
        r3.setText(r12.getString(2131902035));
        r3.setVisibility(0);
        r3.setOnClickListener(new e(r11));
    L19:
        Unit r13 = Unit.INSTANCE;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return r13;
    }
}
