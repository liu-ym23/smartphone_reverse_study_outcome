package obric.flow.miniappwidget;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "obric.flow.miniappwidget.MiniAppHostedWidgetKt$launchSafely$1", f = "MiniAppHostedWidget.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {})
final class MiniAppHostedWidgetKt$launchSafely$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public MiniAppHostedWidgetKt$launchSafely$1(Function1<? super Continuation<? super Unit>, ? extends Object> r5, Continuation<? super MiniAppHostedWidgetKt$launchSafely$1> r10) {
        this.$block = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new MiniAppHostedWidgetKt$launchSafely$1(this.$block, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L11;
        if (r11 != 1) goto L10;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L7
    L22:
    L19:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r5);
        Function1<Continuation<? super Unit>, Object> r12 = this.$block;     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        if (r12.invoke(this) != r10) goto L22;
        return r10;
    L7:
        th = move-exception;
        Intrinsics.checkNotNullParameter("MiniAppHostedWidget", "tag");
        Intrinsics.checkNotNullParameter("async dispatch failed", "msg");
        Intrinsics.checkNotNullParameter(th, "t");
        org.koin.core.a r13 = su.a.f22013b;
        if (r13 == null) goto L21;
        ((ju.b) r13.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("MiniAppHostedWidget", "async dispatch failed", th);
        goto L19
    L21:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((MiniAppHostedWidgetKt$launchSafely$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
