package com.larus.bmhome.chat.layout.holder.helper;

import android.view.View;
import com.larus.audio.ttsV2.TtsGuideDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.model.repo.x1$b;
import com.larus.bmhome.utils.FormatSource;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.tts.TtsScene;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.helper.MarkDownSelectHelper$onSelectText$messageMenu$2$1", f = "MarkDownSelectHelper.kt", i = {}, l = {580}, m = "invokeSuspend", n = {}, s = {})
public final class MarkDownSelectHelper$onSelectText$messageMenu$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $botModel;
    final /* synthetic */ Function0<Boolean> $canPerformAction;
    final /* synthetic */ String $chatType;
    final /* synthetic */ String $clickFrom;
    final /* synthetic */ String $clickModule;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ Message $data;
    final /* synthetic */ View $markdownView;
    final /* synthetic */ by7.e $trackNode;
    int label;

    public MarkDownSelectHelper$onSelectText$messageMenu$2$1(View r1, BotModel r2, Message r3, String r4, String r5, String r6, Function0<Boolean> r7, by7.e r8, String r9, Continuation<? super MarkDownSelectHelper$onSelectText$messageMenu$2$1> r10) {
        this.$markdownView = r1;
        this.$botModel = r2;
        this.$data = r3;
        this.$chatType = r4;
        this.$conversationId = r5;
        this.$clickFrom = r6;
        this.$canPerformAction = r7;
        this.$trackNode = r8;
        this.$clickModule = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new MarkDownSelectHelper$onSelectText$messageMenu$2$1(this.$markdownView, this.$botModel, this.$data, this.$chatType, this.$conversationId, this.$clickFrom, this.$canPerformAction, this.$trackNode, this.$clickModule, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r30) {
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        by7.e r13 = null;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r30);
    L17:
        BotModel r1 = this.$botModel;
        if (r1 == null) goto L20;
        String r14 = r1.getBotId();
    L22:
        if (Intrinsics.areEqual(this.$clickFrom, "long_press_answer") == false) goto L24;
        String r2 = "long_press_and_choose_text";
    L25:
        String r16 = r2;
        String r3 = this.$data.getConversationId();
        if (r3 == null) goto L28;
        Long r17 = StringsKt.toLongOrNull(r3);
    L29:
        boolean r4 = com.larus.bmhome.chat.bean.d.f0(this.$data);
        if (this.$canPerformAction == null) goto L32;
        r13 = this.$trackNode;
    L32:
        tx9.c0.G(r14, this.$chatType, r16, r17, null, null, null, null, null, null, this.$clickModule, Boxing.boxBoolean(r4), null, r13, 409568);
        return Unit.INSTANCE;
    L28:
        r17 = null;
        goto L29
    L24:
        r2 = this.$clickFrom;
        goto L25
    L20:
        r14 = null;
        goto L22
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r30);
        TtsGuideDelegate.b.a("choose_play");
        RepoDispatcher.a.getClass();
        com.larus.bmhome.chat.model.repo.x1 r5 = RepoDispatcher.d.d.d;
        CustomMarkdownTextView r6 = this.$markdownView;
        String r7 = r6.M4(r6.getMarkdownContent(), FormatSource.TTS);
        BotModel r8 = this.$botModel;
        if (r8 == null) goto L11;
        String r9 = r8.getBotId();
    L12:
        if (r9 != null) goto L14;
        r9 = "";
    L14:
        TtsScene r10 = TtsScene.Manual_Selector;
        Message r11 = this.$data;
        String r15 = this.$chatType;
        String r18 = this.$conversationId;
        this.label = 1;
        if (x1$b.a(r5, r11, r7, r9, r15, false, null, r10, r18, this, 96) != r12) goto L17;
        return r12;
    L11:
        r9 = null;
        goto L12
    }
}
