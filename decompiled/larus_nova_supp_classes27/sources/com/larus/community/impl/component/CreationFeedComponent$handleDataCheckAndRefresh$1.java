package com.larus.community.impl.component;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.component.CreationFeedComponent$handleDataCheckAndRefresh$1", f = "CreationFeedComponent.kt", i = {}, l = {1366, 1368}, m = "invokeSuspend", n = {}, s = {})
final class CreationFeedComponent$handleDataCheckAndRefresh$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isHotLaunch;
    final /* synthetic */ Long $smoothScrollDuration;
    int label;
    final /* synthetic */ CreationFeedComponent this$0;

    public CreationFeedComponent$handleDataCheckAndRefresh$1(CreationFeedComponent r1, boolean r2, Long r3, Continuation<? super CreationFeedComponent$handleDataCheckAndRefresh$1> r4) {
        this.this$0 = r1;
        this.$isHotLaunch = r2;
        this.$smoothScrollDuration = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CreationFeedComponent$handleDataCheckAndRefresh$1(this.this$0, this.$isHotLaunch, this.$smoothScrollDuration, r5);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r5);
    L19:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
    L14:
        if (((Boolean) r5).booleanValue() == false) goto L19;
        CreationFeedComponent r6 = this.this$0;
        Long r2 = this.$smoothScrollDuration;
        this.label = 2;
        if (CreationFeedComponent.h3(r6, r2, this) != r0) goto L19;
        return r0;
    L10:
        ResultKt.throwOnFailure(r5);
        CreationFeedComponent r7 = this.this$0;
        int r3 = CreationFeedComponent.K;
        CreationFeedViewModel r8 = r7.C3();
        boolean r4 = this.$isHotLaunch;
        this.label = 1;
        r5 = r8.checkCurrentData(r4, this);
        if (r5 != r0) goto L14;
        return r0;
    }
}
