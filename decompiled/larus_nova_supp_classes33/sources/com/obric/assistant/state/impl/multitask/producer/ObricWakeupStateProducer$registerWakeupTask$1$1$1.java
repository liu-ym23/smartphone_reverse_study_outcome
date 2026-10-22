package com.obric.assistant.state.impl.multitask.producer;

import aha.v;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.activityresult.ActivityProxyRequestStoreKt;
import com.obric.assistant.state.impl.v2.utils.CoroutineExtKt;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import com.obric.capabilitykit.common.ErrorCode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.ObricWakeupStateProducer$registerWakeupTask$1$1$1", f = "ObricWakeupStateProducer.kt", i = {}, l = {ErrorCode.APP_VERSION_TOO_LOW}, m = "invokeSuspend", n = {}, s = {})
final class ObricWakeupStateProducer$registerWakeupTask$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObricWakeupStateProducer.b $task;
    final /* synthetic */ String $wakeupId;
    final /* synthetic */ String $wakeupSource;
    int label;
    final /* synthetic */ ObricWakeupStateProducer this$0;

    public ObricWakeupStateProducer$registerWakeupTask$1$1$1(ObricWakeupStateProducer r1, String r2, String r3, ObricWakeupStateProducer.b r4, Continuation<? super ObricWakeupStateProducer$registerWakeupTask$1$1$1> r5) {
        this.this$0 = r1;
        this.$wakeupId = r2;
        this.$wakeupSource = r3;
        this.$task = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ObricWakeupStateProducer$registerWakeupTask$1$1$1(this.this$0, this.$wakeupId, this.$wakeupSource, this.$task, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        ObricWakeupStateProducer r12 = this.this$0;
        String r2 = this.$wakeupId;
        String r3 = this.$wakeupSource;
        ObricWakeupStateProducer.b r5 = this.$task;
        Object r6 = r12.c;
        monitor-enter(r6);
    L24:
        th = move-exception;
        throw th;
    L14:
        if (r12.b.get(r2) == r5) goto L17;
        monitor-exit(r6);
    L23:
        return Unit.INSTANCE;
    L17:
        ObricWakeupStateProducer.b r13 = r12.b.remove(r2);     // Catch: Throwable -> L24
        monitor-exit(r6);
        FLogger.a.i("ObricWakeupStateProducer", "dispatchWakeupEnd, wakeupId=" + r2 + ", wakeupSource=" + r3);
        TaskFlowDslKt.c(r5.a, new v.a(r2, r3, MapsKt.mapOf(new Pair[]{TuplesKt.to("end_reason", "timeout"), TuplesKt.to("timeout_ms", Long.valueOf(ActivityProxyRequestStoreKt.PROXY_CREATE_TIMEOUT_MS))})));
        Job r14 = r5.b.getAndSet(null);
        if (r14 == null) goto L23;
        Job.DefaultImpls.cancel$default(r14, null, 1, null);
        goto L23
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        this.label = 1;
        if (CoroutineExtKt.a(ActivityProxyRequestStoreKt.PROXY_CREATE_TIMEOUT_MS, this) != r0) goto L11;
        return r0;
    }
}
