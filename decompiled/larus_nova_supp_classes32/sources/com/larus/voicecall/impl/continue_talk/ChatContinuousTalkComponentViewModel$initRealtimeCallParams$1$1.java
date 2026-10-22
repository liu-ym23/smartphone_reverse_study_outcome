package com.larus.voicecall.impl.continue_talk;

import android.content.Context;
import com.larus.audio.call.common.ContextKt;
import com.larus.voicecall.impl.util.EarphoneChecker;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponentViewModel$initRealtimeCallParams$1$1", f = "ChatContinuousTalkComponentViewModel.kt", i = {}, l = {334}, m = "invokeSuspend", n = {}, s = {})
public final class ChatContinuousTalkComponentViewModel$initRealtimeCallParams$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ ChatContinuousTalkComponentViewModel this$0;

    public ChatContinuousTalkComponentViewModel$initRealtimeCallParams$1$1(Context r1, ChatContinuousTalkComponentViewModel r2, Continuation<? super ChatContinuousTalkComponentViewModel$initRealtimeCallParams$1$1> r3) {
        this.$context = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatContinuousTalkComponentViewModel$initRealtimeCallParams$1$1(this.$context, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L20:
        ChatContinuousTalkComponentViewModel.access$setEarChecker$p(this.this$0, new EarphoneChecker(this.$context));
    L22:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        RealtimeCallUtil.a.getClass();
        RealtimeCallUtil.r = false;
        if (RealtimeCallUtil.v == false) goto L22;
        Context r5 = this.$context;
        this.label = 1;
        com.larus.audio.call.g r2 = com.larus.audio.call.f.a;
        Object r6 = ContextKt.a(r5, this);
        if (r6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        r6 = Unit.INSTANCE;
    L15:
        if (r6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        r6 = Unit.INSTANCE;
    L18:
        if (r6 != r0) goto L20;
        return r0;
    }
}
