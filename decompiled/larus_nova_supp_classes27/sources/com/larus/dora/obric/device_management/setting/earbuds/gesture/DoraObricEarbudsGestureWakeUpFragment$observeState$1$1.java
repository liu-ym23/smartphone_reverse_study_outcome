package com.larus.dora.obric.device_management.setting.earbuds.gesture;

import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupType;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraObricEarbudsGestureWakeUpFragment$observeState$1$1<T> implements FlowCollector {
    public final /* synthetic */ DoraObricEarbudsGestureWakeUpFragment a;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ DoraObricEarbudsGestureWakeUpFragment a;

        public a(DoraObricEarbudsGestureWakeUpFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            com.larus.dora.impl.device.settings.gesture.wakeup.h r4 = (com.larus.dora.impl.device.settings.gesture.wakeup.h) r2;
            if (r4 == null) goto L8;
            GestureWakeupType r5 = r4.getType();
            if (r5 == null) goto L8;
            DoraObricEarbudsGestureWakeUpFragment.W90(this.a, r4.b, r5);
        L8:
            return Unit.INSTANCE;
        }
    }

    public DoraObricEarbudsGestureWakeUpFragment$observeState$1$1(DoraObricEarbudsGestureWakeUpFragment r1) {
        this.a = r1;
    }

    public final Object a(boolean r5, Continuation<? super Unit> r6) {
        if ((r6 instanceof DoraObricEarbudsGestureWakeUpFragment$observeState$1$1$emit$1) == false) goto L7;
        DoraObricEarbudsGestureWakeUpFragment$observeState$1$1$emit$1 r0 = (DoraObricEarbudsGestureWakeUpFragment$observeState$1$1$emit$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L12;
        ResultKt.throwOnFailure(r7);
    L23:
        throw new KotlinNothingValueException();
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        if (r5 == true) goto L25;
        FragmentActivity r8 = this.a.getActivity();
        if (r8 == null) goto L19;
        DoraObricEarbudsGestureWakeUpFragment r9 = this.a;
        Handler r4 = com.obric.oui.toast.f.n;
        com.obric.oui.toast.f.a.a(r8, r9.getString(2131904037));
    L19:
        DoraObricEarbudsGestureWakeUpFragment r10 = this.a;
        int r11 = DoraObricEarbudsGestureWakeUpFragment.p;
        d1<com.larus.dora.impl.device.settings.gesture.wakeup.h> r12 = r10.Y90().getGestureWakeupStateFlow();
        a r13 = new a(this.a);
        r0.label = 1;
        if (r12.collect(r13, r0) != r2) goto L23;
        return r2;
    L25:
        return Unit.INSTANCE;
    L7:
        r0 = new DoraObricEarbudsGestureWakeUpFragment$observeState$1$1$emit$1(this, r6);
        goto L8
    }

    public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
        return a(((Boolean) r1).booleanValue(), r2);
    }
}
