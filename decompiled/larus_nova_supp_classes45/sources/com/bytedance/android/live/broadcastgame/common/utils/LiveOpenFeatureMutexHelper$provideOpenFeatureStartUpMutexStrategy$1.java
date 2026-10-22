package com.bytedance.android.live.broadcastgame.common.utils;

import com.bytedance.android.live.broadcastgame.api.model.u;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(c = "com.bytedance.android.live.broadcastgame.common.utils.LiveOpenFeatureMutexHelper$provideOpenFeatureStartUpMutexStrategy$1", f = "LiveOpenFeatureMutexHelper.kt", i = {}, l = {189}, m = "invokeSuspend", n = {}, s = {})
final class LiveOpenFeatureMutexHelper$provideOpenFeatureStartUpMutexStrategy$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Function0<? extends Boolean>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ u $gameItem;
    private /* synthetic */ Object L$0;
    int label;

    public LiveOpenFeatureMutexHelper$provideOpenFeatureStartUpMutexStrategy$1(u r1, Continuation r2) {
        this.$gameItem = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "completion");
        LiveOpenFeatureMutexHelper$provideOpenFeatureStartUpMutexStrategy$1 r0 = new LiveOpenFeatureMutexHelper$provideOpenFeatureStartUpMutexStrategy$1(this.$gameItem, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        SequenceScope r7 = (SequenceScope) this.L$0;
        List r2 = CollectionsKt.mutableListOf(new Function0[]{new AnonymousClass1(this)});
        this.label = 1;
        if (r7.yieldAll(r2, this) != r0) goto L12;
        return r0;
    }
}
