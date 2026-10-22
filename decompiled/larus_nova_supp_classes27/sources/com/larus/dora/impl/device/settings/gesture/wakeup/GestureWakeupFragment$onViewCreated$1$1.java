package com.larus.dora.impl.device.settings.gesture.wakeup;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class GestureWakeupFragment$onViewCreated$1$1<T> implements FlowCollector {
    public final /* synthetic */ GestureWakeupFragment a;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ GestureWakeupFragment a;

        public a(GestureWakeupFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            h r4 = (h) r2;
            if (r4 == null) goto L8;
            GestureWakeupType r5 = r4.getType();
            if (r5 == null) goto L8;
            GestureWakeupFragment.W90(this.a, r4.b, r5);
        L8:
            return Unit.INSTANCE;
        }
    }

    public GestureWakeupFragment$onViewCreated$1$1(GestureWakeupFragment r1) {
        this.a = r1;
    }

    public final Object a(boolean r5, Continuation<? super Unit> r6) {
        if ((r6 instanceof GestureWakeupFragment$onViewCreated$1$1$emit$1) == false) goto L7;
        GestureWakeupFragment$onViewCreated$1$1$emit$1 r0 = (GestureWakeupFragment$onViewCreated$1$1$emit$1) r6;
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
    L20:
        throw new KotlinNothingValueException();
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        if (r5 == true) goto L22;
        s r8 = s.a;
        Application r9 = AppHost.a.getApplication();
        r8.getClass();
        s.b(r9, 2131904037, false);
        GestureWakeupFragment r10 = this.a;
        int r11 = GestureWakeupFragment.i;
        d1<h> r12 = r10.X90().getGestureWakeupStateFlow();
        a r13 = new a(this.a);
        r0.label = 1;
        if (r12.collect(r13, r0) != r2) goto L20;
        return r2;
    L22:
        return Unit.INSTANCE;
    L7:
        r0 = new GestureWakeupFragment$onViewCreated$1$1$emit$1(this, r6);
        goto L8
    }

    public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
        return a(((Boolean) r1).booleanValue(), r2);
    }
}
