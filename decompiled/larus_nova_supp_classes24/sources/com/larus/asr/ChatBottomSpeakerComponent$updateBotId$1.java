package com.larus.asr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.asr.ChatBottomSpeakerComponent$updateBotId$1", f = "ChatBottomSpeakerComponent.kt", i = {}, l = {1523, 1525}, m = "invokeSuspend", n = {}, s = {})
final class ChatBottomSpeakerComponent$updateBotId$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ wc9.e $conversation;
    Object L$0;
    int label;
    final /* synthetic */ ChatBottomSpeakerComponent this$0;

    public ChatBottomSpeakerComponent$updateBotId$1(ChatBottomSpeakerComponent r1, wc9.e r2, Continuation<? super ChatBottomSpeakerComponent$updateBotId$1> r3) {
        this.this$0 = r1;
        this.$conversation = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatBottomSpeakerComponent$updateBotId$1(this.this$0, this.$conversation, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ChatBottomSpeakerComponent r2 = (ChatBottomSpeakerComponent) this.L$0;
        ResultKt.throwOnFailure(r9);
    L27:
        String r10 = (String) CollectionsKt.getOrNull((List) r9, 0);
    L28:
        r2.u = r10;
        FLogger.a.i("ChatBottomSpeakerComponent", "[updateBotId] botId=" + this.this$0.u + ", after invoke conversation.botIdList()");
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r2 = (ChatBottomSpeakerComponent) this.L$0;
        ResultKt.throwOnFailure(r9);
    L16:
        Object r11 = CollectionsKt.getOrNull((List) r9, 0);
        if (o0.d((String) r11) == true) goto L20;
        r11 = null;
    L20:
        r10 = (String) r11;
        if (r10 != null) goto L28;
        r10 = this.this$0.u;
        goto L28
    L10:
        ResultKt.throwOnFailure(r9);
        FLogger.a.i("ChatBottomSpeakerComponent", "[updateBotId] botId=" + this.this$0.u + ", before invoke conversation.botIdList()");
        ChatBottomSpeakerComponent r12 = this.this$0;
        if (com.larus.platform.service.z2.a.enableOptAsrNullableBotId() == false) goto L23;
        wc9.e r3 = this.$conversation;
        this.L$0 = r12;
        this.label = 1;
        Object r4 = ic8.n.c(r3, this);
        if (r4 != r0) goto L15;
        return r0;
    L15:
        r2 = r12;
        r9 = r4;
        goto L16
    L23:
        wc9.e r5 = this.$conversation;
        this.L$0 = r12;
        this.label = 2;
        Object r6 = ic8.n.c(r5, this);
        if (r6 != r0) goto L26;
        return r0;
    L26:
        r2 = r12;
        r9 = r6;
        goto L27
    }
}
