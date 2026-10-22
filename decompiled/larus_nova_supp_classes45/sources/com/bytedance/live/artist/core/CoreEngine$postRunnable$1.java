package com.bytedance.live.artist.core;

import com.bytedance.android.live.base.api.ActivityType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, ActivityType.LIVE_BROADCAST_BEFORE_ACTIVITY_CLASS})
@DebugMetadata(c = "com.bytedance.live.artist.core.CoreEngine$postRunnable$1", f = "CoreEngine.kt", i = {0}, l = {123}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class CoreEngine$postRunnable$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Runnable $runnable;
    Object L$0;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ CoreEngine this$0;

    public CoreEngine$postRunnable$1(CoreEngine r1, Runnable r2, Continuation r3) {
        this.this$0 = r1;
        this.$runnable = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        CoreEngine$postRunnable$1 r0 = new CoreEngine$postRunnable$1(this.this$0, this.$runnable, r5);
        r0.p$ = (CoroutineScope) r4;
        return r0;
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CoroutineScope r6 = this.p$;
        CoreEngine r3 = this.this$0;
        Runnable r4 = this.$runnable;
        this.L$0 = r6;
        this.label = 1;
        if (r3.c(r4, this) != r0) goto L12;
        return r0;
    }
}
