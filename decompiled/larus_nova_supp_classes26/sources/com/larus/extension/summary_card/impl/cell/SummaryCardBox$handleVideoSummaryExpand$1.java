package com.larus.extension.summary_card.impl.cell;

import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.UserSettingRepoDelegate;
import com.larus.bmhome.chat.model.repo.x1;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.tts.TtsScene;
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
@DebugMetadata(c = "com.larus.extension.summary_card.impl.cell.SummaryCardBox$handleVideoSummaryExpand$1", f = "SummaryCardBox.kt", i = {}, l = {932}, m = "invokeSuspend", n = {}, s = {})
public final class SummaryCardBox$handleVideoSummaryExpand$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $bot;
    final /* synthetic */ Message $data;
    int label;
    final /* synthetic */ SummaryCardBox this$0;

    public SummaryCardBox$handleVideoSummaryExpand$1(SummaryCardBox r1, Message r2, BotModel r3, Continuation<? super SummaryCardBox$handleVideoSummaryExpand$1> r4) {
        this.this$0 = r1;
        this.$data = r2;
        this.$bot = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SummaryCardBox$handleVideoSummaryExpand$1(this.this$0, this.$data, this.$bot, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L28:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        CustomMarkdownTextView r16 = this.this$0.w;
        if (r16 == null) goto L28;
        Message r4 = this.$data;
        BotModel r2 = this.$bot;
        int r3 = UserSettingRepoDelegate.b.a(r4.getConversationId());
        if (r3 >= 0) goto L17;
        wc9.e r5 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r5 != null) goto L15;
    L19:
        boolean r6 = false;
    L20:
        if (r6 == false) goto L28;
        x1 r7 = zh8.a.a.getReceiver().c();
        String r8 = st8.b.a.a(r16, r16.getMarkdownContent());
        String r17 = r2.getBotId();
        if (r17 != null) goto L24;
        r17 = "";
    L24:
        TtsScene r10 = TtsScene.Manual_Other;
        this.label = 1;
        if (x1.b.a(r7, r4, r8, r17, null, true, null, r10, null, this, 320) != r0) goto L28;
        return r0;
    L15:
        if (r5.i != true) goto L19;
    L18:
        r6 = true;
        goto L20
    L17:
        if (r3 != 1) goto L19;
        goto L18
    }
}
