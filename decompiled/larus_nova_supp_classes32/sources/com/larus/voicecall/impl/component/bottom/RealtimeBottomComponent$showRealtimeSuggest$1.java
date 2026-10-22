package com.larus.voicecall.impl.component.bottom;

import com.larus.av_call.view.VoiceCallBottomLayout;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.bottom.RealtimeBottomComponent$showRealtimeSuggest$1", f = "RealtimeBottomComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeBottomComponent$showRealtimeSuggest$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $showFrom;
    int label;
    final /* synthetic */ RealtimeBottomComponent this$0;

    public RealtimeBottomComponent$showRealtimeSuggest$1(RealtimeBottomComponent r1, String r2, Continuation<? super RealtimeBottomComponent$showRealtimeSuggest$1> r3) {
        this.this$0 = r1;
        this.$showFrom = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new RealtimeBottomComponent$showRealtimeSuggest$1(this.this$0, this.$showFrom, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r2);
        VoiceCallBottomLayout r3 = this.this$0.M;
        if (r3 == null) goto L8;
        r3.Z8(this.$showFrom);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
