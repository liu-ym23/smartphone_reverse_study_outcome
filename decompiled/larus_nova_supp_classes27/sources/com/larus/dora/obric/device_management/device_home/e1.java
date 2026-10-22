package com.larus.dora.obric.device_management.device_home;

import com.larus.dora.impl.databinding.LarusDoraPageObricDeviceHomeBinding;
import com.obric.oui.text.OTextView;
import kotlin.Function;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class e1 implements FlowCollector, FunctionAdapter {
    public final /* synthetic */ DoraObricDeviceHomeFragment a;

    public e1(DoraObricDeviceHomeFragment r1) {
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
        return new AdaptedFunctionReference(2, this.a, DoraObricDeviceHomeFragment.class, "renderOtaHomeCard", "renderOtaHomeCard(Lcom/larus/dora/impl/ota/g2/G2OtaHomeCardState;)V", 4);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    public final Object emit(Object r6, Continuation r7) {
        com.larus.dora.impl.ota.g2.h0 r8 = (com.larus.dora.impl.ota.g2.h0) r6;
        DoraObricDeviceHomeFragment r9 = this.a;
        LarusDoraPageObricDeviceHomeBinding r0 = r9.f;
        if (r0 == null) goto L7;
        if (r8 != null) goto L6;
        com.larus.utils.e1.o(r0.K);
        goto L7
    L6:
        r0.L.setText(r9.getString(2131903625, new Object[]{r8.b()}));
        OTextView r10 = r0.J;
        Intrinsics.checkNotNullParameter(r8.a(), "action");
        r10.setText(2131903623);
        com.larus.utils.e1.x(r0.K);
    L7:
        Unit r11 = Unit.INSTANCE;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return r11;
    }
}
