package com.obric.widget.host.runtime;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/widget/host/runtime/PrefetchedWidgetPayload;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.widget.host.runtime.WidgetPayloadPrefetchCoordinator$getOrStartPrefetch$3$deferred$1", f = "WidgetPayloadPrefetchCoordinator.kt", i = {0}, l = {68}, m = "invokeSuspend", n = {"startElapsed"}, s = {"J$0"})
public final class WidgetPayloadPrefetchCoordinator$getOrStartPrefetch$3$deferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PrefetchedWidgetPayload>, Object> {
    final /* synthetic */ WidgetPayloadCacheKey $key;
    final /* synthetic */ Function1<Continuation<? super String>, Object> $request;
    final /* synthetic */ String $source;
    long J$0;
    int label;
    final /* synthetic */ WidgetPayloadPrefetchCoordinator this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetPayloadPrefetchCoordinator$getOrStartPrefetch$3$deferred$1(Function1<? super Continuation<? super String>, ? extends Object> r5, String r10, WidgetPayloadPrefetchCoordinator r11, WidgetPayloadCacheKey r12, Continuation<? super WidgetPayloadPrefetchCoordinator$getOrStartPrefetch$3$deferred$1> r13) {
        this.$request = r5;
        this.$source = r10;
        this.this$0 = r11;
        this.$key = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new WidgetPayloadPrefetchCoordinator$getOrStartPrefetch$3$deferred$1(this.$request, this.$source, this.this$0, this.$key, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super PrefetchedWidgetPayload> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L12;
        if (r11 != 1) goto L11;
        long r12 = this.J$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L8
    L17:
        PrefetchedWidgetPayload r13 = new PrefetchedWidgetPayload((String) r10, this.$source, SystemClock.elapsedRealtime() - r12, SystemClock.elapsedRealtime());     // Catch: Throwable -> L8
        WidgetPayloadPrefetchCoordinator r14 = this.this$0;     // Catch: Throwable -> L8
        WidgetPayloadCacheKey r15 = this.$key;     // Catch: Throwable -> L8
        String r16 = r13.getPayload();     // Catch: Throwable -> L8
        if (r16 != null) goto L20;
    L23:
        WidgetPayloadPrefetchCoordinator.access$getInFlight$p(this.this$0).remove(this.$key);
        return r13;
    L20:
        if (StringsKt.isBlank(r16) == true) goto L23;
        WidgetPayloadPrefetchCoordinator.access$getCache$p(r14).put(r15, r13);     // Catch: Throwable -> L8
        goto L23
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r10);
        long r17 = SystemClock.elapsedRealtime();
        Function1<Continuation<? super String>, Object> r18 = this.$request;     // Catch: Throwable -> L8
        this.J$0 = r17;     // Catch: Throwable -> L8
        this.label = 1;     // Catch: Throwable -> L8
        r10 = r18.invoke(this);     // Catch: Throwable -> L8
        if (r10 != r5) goto L16;
        return r5;
    L16:
        r12 = r17;
    L8:
        th = move-exception;
        WidgetPayloadPrefetchCoordinator.access$getInFlight$p(this.this$0).remove(this.$key);
        throw th;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super PrefetchedWidgetPayload> r10) {
        return ((WidgetPayloadPrefetchCoordinator$getOrStartPrefetch$3$deferred$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
