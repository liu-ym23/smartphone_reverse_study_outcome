package com.larus.bmhome.view.actionbar.segment;

import com.larus.bmhome.view.actionbar.segment.vm.LikeBotViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.segment.LikeBotSegmentHolder$bind$3$1", f = "LikeBotSegment.kt", i = {}, l = {218}, m = "invokeSuspend", n = {}, s = {})
final class LikeBotSegmentHolder$bind$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ t1a.b $vContext;
    final /* synthetic */ LikeBotViewModel $vm;
    int label;
    final /* synthetic */ LikeBotSegmentHolder this$0;

    public LikeBotSegmentHolder$bind$3$1(LikeBotSegmentHolder r1, LikeBotViewModel r2, t1a.b r3, Continuation<? super LikeBotSegmentHolder$bind$3$1> r4) {
        this.this$0 = r1;
        this.$vm = r2;
        this.$vContext = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new LikeBotSegmentHolder$bind$3$1(this.this$0, this.$vm, this.$vContext, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 != 0) goto L5;
        ResultKt.throwOnFailure(r3);
        FLogger.a.i("ComponentViewModel", "animation start ");
        this.this$0.getClass();
        throw null;
    L5:
        if (r0 != 1) goto L9;
        ResultKt.throwOnFailure(r3);
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
