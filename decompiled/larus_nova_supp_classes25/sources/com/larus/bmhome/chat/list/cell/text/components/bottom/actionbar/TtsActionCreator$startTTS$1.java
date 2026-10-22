package com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.Message;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.TtsActionCreator$startTTS$1", f = "ActionCreator.kt", i = {}, l = {1342, 1343, 1345}, m = "invokeSuspend", n = {}, s = {})
final class TtsActionCreator$startTTS$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $msg;
    int label;
    final /* synthetic */ d2 this$0;

    public TtsActionCreator$startTTS$1(d2 r1, Message r2, Continuation<? super TtsActionCreator$startTTS$1> r3) {
        this.this$0 = r1;
        this.$msg = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new TtsActionCreator$startTTS$1(this.this$0, this.$msg, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 == 3) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r10);
    L38:
        return Unit.INSTANCE;
    L11:
        ResultKt.throwOnFailure(r10);
    L31:
        d2 r11 = this.this$0;
        Message r2 = this.$msg;
        this.label = 2;
        if (d2.a(r11, r2, this) != r0) goto L38;
        return r0;
    L12:
        ResultKt.throwOnFailure(r10);
        com.larus.bmhome.chat.api.q0.a r12 = this.this$0.c;
        SpeakerVoice r3 = null;
        if (r12 == null) goto L17;
        com.larus.bmhome.chat.component.cvs.y r13 = r12.u0();
        if (r13 == null) goto L17;
        BotModel r14 = r13.j0();
    L19:
        if (ve8.c.c(r14) == false) goto L38;
        d2 r15 = this.this$0;
        r15.d(this.$msg, r15.c, "1", "other_open");
        com.larus.bmhome.chat.api.q0.a r16 = this.this$0.c;
        if (r16 == null) goto L27;
        com.larus.bmhome.chat.component.cvs.y r17 = r16.u0();
        if (r17 == null) goto L27;
        BotModel r18 = r17.j0();
        if (r18 == null) goto L27;
        r3 = r18.getVoiceType();
    L27:
        if (r3 != null) goto L34;
        this.label = 1;
        if (DelayKt.delay(500, this) != r0) goto L31;
        return r0;
    L34:
        d2 r19 = this.this$0;
        Message r4 = this.$msg;
        this.label = 3;
        if (d2.a(r19, r4, this) != r0) goto L38;
        return r0;
    L17:
        r14 = null;
        goto L19
    }
}
