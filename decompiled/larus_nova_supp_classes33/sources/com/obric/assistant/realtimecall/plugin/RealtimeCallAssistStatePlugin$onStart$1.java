package com.obric.assistant.realtimecall.plugin;

import com.larus.audio.call.plugins.c1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.multitask.ObricRealtimeCallStateProducerServiceDelegate;
import com.obric.assistant.state.api.v2.core.IObricStateDispatcherService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.realtimecall.plugin.RealtimeCallAssistStatePlugin$onStart$1", f = "RealtimeCallAssistStatePlugin.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeCallAssistStatePlugin$onStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RealtimeCallAssistStatePlugin this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ RealtimeCallAssistStatePlugin a;

        public a(RealtimeCallAssistStatePlugin r1) {
            this.a = r1;
        }

        public final Object emit(Object r7, Continuation r8) {
            Pair r9 = (Pair) r7;
            int r10 = ((Number) r9.component1()).intValue();
            int r11 = ((Number) r9.component2()).intValue();
            RealtimeCallAssistStatePlugin r0 = this.a;
            String r1 = r0.k3();
            FLogger.a.i(r0.f, "onRealtimeCallUiStateChange, prev=" + r10 + ", current=" + r11 + ", cvsId: " + r0.getContext().params().G + ", " + r0.getContext().params().l.c);
            IObricStateDispatcherService r2 = (IObricStateDispatcherService) ServiceManager.get().getService(IObricStateDispatcherService.class);
            if (r2 == null) goto L6;
            r2.d(r10, r11, r1);
        L6:
            if (r11 != 14) goto L8;
        L10:
            ObricRealtimeCallStateProducerServiceDelegate.b.a(r0.j3(), r0.k3(), r11);
        L12:
            return Unit.INSTANCE;
        L8:
            if (r11 == 15) goto L10;
            goto L10
        }
    }

    public RealtimeCallAssistStatePlugin$onStart$1(RealtimeCallAssistStatePlugin r1, Continuation<? super RealtimeCallAssistStatePlugin$onStart$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RealtimeCallAssistStatePlugin$onStart$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MutableSharedFlow r6 = this.this$0.getContext().b(Reflection.getOrCreateKotlinClass(c1.class), null).i1();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
