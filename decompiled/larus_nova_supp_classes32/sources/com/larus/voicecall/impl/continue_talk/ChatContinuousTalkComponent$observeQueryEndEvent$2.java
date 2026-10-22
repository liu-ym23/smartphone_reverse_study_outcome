package com.larus.voicecall.impl.continue_talk;

import com.larus.voicecall.impl.databinding.LarusLayoutContinuousBottomContainerBinding;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "it", NameKeys.UnloadStrategy_No_Strategy}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponent$observeQueryEndEvent$2", f = "ChatContinuousTalkComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatContinuousTalkComponent$observeQueryEndEvent$2 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ ChatContinuousTalkComponent this$0;

    public ChatContinuousTalkComponent$observeQueryEndEvent$2(ChatContinuousTalkComponent r1, Continuation<? super ChatContinuousTalkComponent$observeQueryEndEvent$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ChatContinuousTalkComponent$observeQueryEndEvent$2 r0 = new ChatContinuousTalkComponent$observeQueryEndEvent$2(this.this$0, r4);
        r0.I$0 = ((Number) r3).intValue();
        return r0;
    }

    public final Object invoke(int r1, Continuation<? super Unit> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r2);
        if (this.I$0 < 0) goto L12;
        LarusLayoutContinuousBottomContainerBinding r3 = this.this$0.n;
        if (r3 == null) goto L12;
        ChatContinuousTalkLayout r4 = r3.d;
        if (r4 == null) goto L12;
        int r0 = ChatContinuousTalkLayout.e;
        r4.b.i.removeCallbacks(r4.d);
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
