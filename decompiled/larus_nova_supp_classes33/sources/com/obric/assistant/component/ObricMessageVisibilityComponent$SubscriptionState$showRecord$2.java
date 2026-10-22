package com.obric.assistant.component;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.ObricMessageVisibilityComponent$SubscriptionState$showRecord$2", f = "ObricMessageVisibilityComponent.kt", i = {}, l = {451}, m = "invokeSuspend", n = {}, s = {})
final class ObricMessageVisibilityComponent$SubscriptionState$showRecord$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObricMessageVisibilityComponent.c $snapshot;
    final /* synthetic */ Long $visibleDurationMs;
    int label;
    final /* synthetic */ ObricMessageVisibilityComponent.b this$0;
    final /* synthetic */ ObricMessageVisibilityComponent this$1;

    public ObricMessageVisibilityComponent$SubscriptionState$showRecord$2(Long r1, ObricMessageVisibilityComponent.b r2, ObricMessageVisibilityComponent.c r3, ObricMessageVisibilityComponent r4, Continuation<? super ObricMessageVisibilityComponent$SubscriptionState$showRecord$2> r5) {
        this.$visibleDurationMs = r1;
        this.this$0 = r2;
        this.$snapshot = r3;
        this.this$1 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ObricMessageVisibilityComponent$SubscriptionState$showRecord$2(this.$visibleDurationMs, this.this$0, this.$snapshot, this.this$1, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        final ObricMessageVisibilityComponent.d r7 = this.this$0.d.get(this.$snapshot.b);
        if (r7 == null) goto L14;
        ObricMessageVisibilityComponent r2 = this.this$1;
        int r3 = ObricMessageVisibilityComponent.w;
        if (r2.U2() == false) goto L18;
        final ObricMessageVisibilityComponent.b r4 = this.this$0;
        final String r5 = "visible_for_" + this.$visibleDurationMs;
        r4.getClass();
        r4.d("onMessageVisibleFor", new b3(r4, r7, r5));
        return Unit.INSTANCE;
    L18:
        return Unit.INSTANCE;
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        long r8 = this.$visibleDurationMs.longValue();
        this.label = 1;
        if (DelayKt.delay(r8, this) != r0) goto L11;
        return r0;
    }
}
