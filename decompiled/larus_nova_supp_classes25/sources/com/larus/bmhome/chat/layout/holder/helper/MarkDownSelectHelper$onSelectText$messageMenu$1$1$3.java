package com.larus.bmhome.chat.layout.holder.helper;

import android.view.View;
import com.larus.audio.ttsV2.TtsGuideDelegate;
import com.larus.bmhome.chat.api.SelectionRangeType;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.helper.MarkDownSelectHelper$onSelectText$messageMenu$1$1$3", f = "MarkDownSelectHelper.kt", i = {}, l = {192}, m = "invokeSuspend", n = {}, s = {})
public final class MarkDownSelectHelper$onSelectText$messageMenu$1$1$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.chat.api.q0 $adapter;
    final /* synthetic */ BotModel $botModel;
    final /* synthetic */ String $clickFrom;
    final /* synthetic */ Message $data;
    final /* synthetic */ View $markdownView;
    final /* synthetic */ com.larus.bmhome.chat.api.q0 $this_run;
    final /* synthetic */ Ref.ObjectRef<String> $wClickFrom;
    final /* synthetic */ Ref.ObjectRef<SelectionRangeType> $wSelectionRangeType;
    int label;

    public MarkDownSelectHelper$onSelectText$messageMenu$1$1$3(com.larus.bmhome.chat.api.q0 r1, BotModel r2, View r3, com.larus.bmhome.chat.api.q0 r4, Message r5, String r6, Ref.ObjectRef<String> r7, Ref.ObjectRef<SelectionRangeType> r8, Continuation<? super MarkDownSelectHelper$onSelectText$messageMenu$1$1$3> r9) {
        this.$adapter = r1;
        this.$botModel = r2;
        this.$markdownView = r3;
        this.$this_run = r4;
        this.$data = r5;
        this.$clickFrom = r6;
        this.$wClickFrom = r7;
        this.$wSelectionRangeType = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new MarkDownSelectHelper$onSelectText$messageMenu$1$1$3(this.$adapter, this.$botModel, this.$markdownView, this.$this_run, this.$data, this.$clickFrom, this.$wClickFrom, this.$wSelectionRangeType, r12);
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
        String r13 = null;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r30);
    L32:
        BotModel r1 = this.$botModel;
        if (r1 == null) goto L35;
        String r14 = r1.getBotId();
    L37:
        if (Intrinsics.areEqual(this.$clickFrom, "long_press_answer") == false) goto L39;
        String r2 = "long_press_and_choose_text";
    L40:
        String r16 = r2;
        String r3 = this.$data.getConversationId();
        if (r3 == null) goto L43;
        Long r17 = StringsKt.toLongOrNull(r3);
    L44:
        ChatControlTrace r4 = ChatControlTrace.b;
        wc9.e r5 = (wc9.e) this.$adapter.A7().invoke();
        if (r5 == null) goto L47;
        Integer r6 = r5.v;
    L48:
        BotModel r7 = this.$botModel;
        if (r7 == null) goto L51;
        Integer r8 = r7.getBotType();
    L52:
        BotModel r9 = this.$botModel;
        if (r9 == null) goto L57;
        BotCreatorInfo r10 = r9.getBotCreatorInfo();
        if (r10 == null) goto L57;
        r13 = r10.getId();
    L57:
        tx9.c0.G(r14, r4.g(r6, r8, Intrinsics.areEqual(r13, AccountService.a.getUserId())), r16, r17, null, null, null, null, null, null, r4.jb(this.$markdownView), Boxing.boxBoolean(com.larus.bmhome.chat.bean.d.f0(this.$data)), null, null, 933856);
        return Unit.INSTANCE;
    L51:
        r8 = null;
        goto L52
    L47:
        r6 = null;
        goto L48
    L43:
        r17 = null;
        goto L44
    L39:
        r2 = this.$clickFrom;
        goto L40
    L35:
        r14 = null;
        goto L37
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r30);
        FLogger.a.i("MarkDownSelectHelper", "[TTS] read tts from markdown selector");
        TtsGuideDelegate.b.a("choose_play");
        ChatControlTrace r11 = ChatControlTrace.b;
        wc9.e r15 = (wc9.e) this.$adapter.A7().invoke();
        if (r15 == null) goto L11;
        Integer r18 = r15.v;
    L12:
        BotModel r19 = this.$botModel;
        if (r19 == null) goto L15;
        Integer r20 = r19.getBotType();
    L16:
        BotModel r21 = this.$botModel;
        if (r21 == null) goto L21;
        BotCreatorInfo r22 = r21.getBotCreatorInfo();
        if (r22 == null) goto L21;
        String r23 = r22.getId();
    L22:
        String r24 = r11.g(r18, r20, Intrinsics.areEqual(r23, AccountService.a.getUserId()));
        RepoDispatcher.a.getClass();
        com.larus.bmhome.chat.model.repo.x1 r25 = RepoDispatcher.d.d.d;
        CustomMarkdownTextView r26 = this.$markdownView;
        String r27 = r26.M4(r26.getMarkdownContent(), FormatSource.TTS);
        com.larus.bmhome.chat.component.cvs.y r28 = this.$this_run.getProvider().u0();
        if (r28 == null) goto L26;
        String r29 = r28.getBotId();
        if (r29 == null) goto L26;
    L29:
        JSONObject r31 = new JSONObject();
        Ref.ObjectRef<String> r32 = this.$wClickFrom;
        Ref.ObjectRef<SelectionRangeType> r33 = this.$wSelectionRangeType;
        r31.put("click_from", r32.element);
        r31.put("select_range", ((SelectionRangeType) r33.element).getValue());
        TtsScene r34 = TtsScene.Manual_Selector;
        Message r35 = this.$data;
        this.label = 1;
        if (x1$b.a(r25, r35, r27, r29, r24, false, r31, r34, null, this, 288) != r12) goto L32;
        return r12;
    L26:
        r29 = this.$this_run.getChatParam().b;
        if (r29 != null) goto L29;
        r29 = "";
    L21:
        r23 = null;
        goto L22
    L15:
        r20 = null;
        goto L16
    L11:
        r18 = null;
        goto L12
    }
}
