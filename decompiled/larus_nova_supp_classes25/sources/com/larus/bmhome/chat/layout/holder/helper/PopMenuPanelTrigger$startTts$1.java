package com.larus.bmhome.chat.layout.holder.helper;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.x1$b;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.utils.FormatSource;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.AccountService;
import com.larus.tts.TtsScene;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.helper.PopMenuPanelTrigger$startTts$1", f = "PopMenuPanelTrigger.kt", i = {}, l = {286, 295}, m = "invokeSuspend", n = {}, s = {})
public final class PopMenuPanelTrigger$startTts$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $bot;
    final /* synthetic */ Message $messageForTts;
    final /* synthetic */ com.larus.bmhome.chat.model.repo.x1 $reader;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PopMenuPanelTrigger this$0;

    public PopMenuPanelTrigger$startTts$1(BotModel r1, com.larus.bmhome.chat.model.repo.x1 r2, PopMenuPanelTrigger r3, Message r4, Continuation<? super PopMenuPanelTrigger$startTts$1> r5) {
        this.$bot = r1;
        this.$reader = r2;
        this.this$0 = r3;
        this.$messageForTts = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        PopMenuPanelTrigger$startTts$1 r6 = new PopMenuPanelTrigger$startTts$1(this.$bot, this.$reader, this.this$0, this.$messageForTts, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
    L62:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r14);
        CoroutineScope r1 = (CoroutineScope) this.L$0;
        if (ve8.c.c(this.$bot) == false) goto L62;
        FLogger r2 = FLogger.a;
        r2.i("PopMenuPanelTrigger", "[TTS] should show tts loading or other state toast, should: " + this.$reader.n6() + '.');
        PopMenuPanelTrigger r3 = this.this$0;
        r3.i(this.$messageForTts, r3.f, "1", "other_open");
        com.larus.bmhome.chat.api.q0.a r4 = this.this$0.f;
        String r5 = null;
        if (r4 == null) goto L17;
        com.larus.bmhome.chat.component.cvs.y r6 = r4.u0();
        if (r6 == null) goto L17;
        wc9.e r7 = r6.h();
    L18:
        ChatControlTrace r8 = ChatControlTrace.b;
        if (r7 == null) goto L21;
        Integer r9 = r7.v;
    L22:
        BotModel r10 = this.$bot;
        if (r10 == null) goto L25;
        Integer r12 = r10.getBotType();
    L26:
        BotModel r13 = this.$bot;
        if (r13 == null) goto L31;
        BotCreatorInfo r15 = r13.getBotCreatorInfo();
        if (r15 == null) goto L31;
        String r16 = r15.getId();
    L32:
        String r17 = r8.g(r9, r12, Intrinsics.areEqual(r16, AccountService.a.getUserId()));
        PopMenuPanelTrigger r18 = this.this$0;
        Message r19 = this.$messageForTts;
        r18.getClass();
        if (com.larus.im.bean.message.a.d0(r19) == false) goto L35;
    L40:
        boolean r20 = true;
    L41:
        if (r20 == false) goto L58;
        CustomMarkdownTextView r21 = this.this$0.d;
        if (r21 == null) goto L46;
        lw8.l r22 = r21.getMarkdownContent();
        if (r22 == null) goto L46;
    L50:
        int r23 = com.larus.bmhome.utils.s2.a;
        String r24 = com.larus.bmhome.utils.s2.b(r22, FormatSource.TTS, 4);
        BotModel r25 = this.$bot;
        if (r25 == null) goto L53;
        r5 = r25.getBotId();
    L53:
        if (r5 != null) goto L55;
        r5 = "";
    L55:
        TtsScene r26 = TtsScene.Manual_LongPress;
        com.larus.bmhome.chat.model.repo.x1 r27 = this.$reader;
        Message r28 = this.$messageForTts;
        this.label = 1;
        if (x1$b.a(r27, r28, r24, r5, r17, false, null, r26, null, this, 352) != r11) goto L62;
        return r11;
    L46:
        r22 = this.this$0.j;
        if (r22 != null) goto L50;
        r2.w("PopMenuPanelTrigger", "[TTS] skip rendered content tts: empty markdown, msgId=" + this.$messageForTts.getMessageId());
        return Unit.INSTANCE;
    L58:
        com.larus.bmhome.chat.model.repo.x1 r29 = this.$reader;
        Message r30 = this.$messageForTts;
        TtsScene r31 = TtsScene.Manual_LongPress;
        this.label = 2;
        if (x1$b.b(r29, r30, null, false, "long_press_play", r17, r31, this, 22) != r11) goto L62;
        return r11;
    L35:
        if (com.larus.im.bean.message.a.y0(r19) == true) goto L37;
    L39:
        r20 = false;
        goto L41
    L37:
        if (com.larus.bmhome.chat.bean.d.j0(r19) == false) goto L39;
    L31:
        r16 = null;
        goto L32
    L25:
        r12 = null;
        goto L26
    L21:
        r9 = null;
    L17:
        r7 = null;
        goto L18
    }
}
