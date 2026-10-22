package com.larus.dora.impl.device.ota;

import d49.c$g;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.ota.DoraOTAManagement$listenerDoraLink$4$onDoraLinkStateChanged$1", f = "DoraOTAManagement.kt", i = {}, l = {309}, m = "invokeSuspend", n = {}, s = {})
public final class DoraOTAManagement$listenerDoraLink$4$onDoraLinkStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public static final class a<T> implements FlowCollector {
        public static final a<T> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object emit(Object r2, Continuation r3) {
            d49.c r4 = (d49.c) r2;
            g49.d.d("DoraOTAManagement", "next state " + r4);
            if ((r4 instanceof c$g) == false) goto L6;
            g49.d.d("DoraOTAManagement", "checkUpdates when restart");
            DoraOTAManagement r5 = DoraOTAManagement.a;
            DoraOTAManagement.m(OTAUpdateFrom.DoraLinkStateChanged.getScene());
        L6:
            return Unit.INSTANCE;
        }
    }

    public DoraOTAManagement$listenerDoraLink$4$onDoraLinkStateChanged$1(Continuation<? super DoraOTAManagement$listenerDoraLink$4$onDoraLinkStateChanged$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraOTAManagement$listenerDoraLink$4$onDoraLinkStateChanged$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r4);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        StateFlowImpl r5 = DoraOTAManagement.e;
        FlowCollector r2 = a.a;
        this.label = 1;
        if (r5.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
