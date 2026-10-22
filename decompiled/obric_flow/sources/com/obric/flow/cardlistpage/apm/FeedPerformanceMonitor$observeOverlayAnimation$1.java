package com.obric.flow.cardlistpage.apm;

import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.g;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.apm.FeedPerformanceMonitor$observeOverlayAnimation$1", f = "FeedPerformanceMonitor.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
final class FeedPerformanceMonitor$observeOverlayAnimation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ d this$0;

    public FeedPerformanceMonitor$observeOverlayAnimation$1(d r5, Continuation<? super FeedPerformanceMonitor$observeOverlayAnimation$1> r10) {
        this.this$0 = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new FeedPerformanceMonitor$observeOverlayAnimation$1(this.this$0, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        Intrinsics.checkNotNullParameter("APM_PerformanceMonitor", "tag");
        Intrinsics.checkNotNullParameter("FeedPerformanceMonitor started tracking overlay animation", "msg");
        org.koin.core.a r12 = su.a.f22013b;
        if (r12 == null) goto L16;
        ((ju.b) r12.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("APM_PerformanceMonitor", "FeedPerformanceMonitor started tracking overlay animation");
        Ref.BooleanRef r13 = new Ref.BooleanRef();
        final d r14 = this.this$0;
        g r15 = SnapshotStateKt.snapshotFlow(new AnonymousClass1(r14));
        a r16 = new a(r13, this.this$0);
        this.label = 1;
        if (r15.collect(r16, this) != r5) goto L14;
        return r5;
    L16:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((FeedPerformanceMonitor$observeOverlayAnimation$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
