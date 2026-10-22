package com.larus.dora.obric.device_management.setting.g.gesture;

import com.larus.dora.obric.utils.DoraObricToastUtils;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class t<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGGestureSettingsFragment a;

    public t(DoraObricGGestureSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r1, Continuation r2) {
        Unit r3 = (Unit) r1;
        g49.d.d("DoraObricGGestureSettingsFragment", "showOtaTooLowToast");
        WeakReference<com.obric.oui.toast.f> r4 = DoraObricToastUtils.a;
        DoraObricToastUtils.e(this.a.requireContext(), 2131901985);
        return Unit.INSTANCE;
    }
}
