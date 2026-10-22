package com.bytedance.android.live.broadcastgame.common.utils;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lkotlin/Function0;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.live.broadcastgame.common.utils.LiveOpenFeatureMutexHelper$checkIfExclude$mutexStrategies$1", f = "LiveOpenFeatureMutexHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LiveOpenFeatureMutexHelper$checkIfExclude$mutexStrategies$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Function0<? extends Boolean>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public LiveOpenFeatureMutexHelper$checkIfExclude$mutexStrategies$1(Continuation r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "completion");
        LiveOpenFeatureMutexHelper$checkIfExclude$mutexStrategies$1 r0 = new LiveOpenFeatureMutexHelper$checkIfExclude$mutexStrategies$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        SequenceScope r3 = (SequenceScope) this.L$0;
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
