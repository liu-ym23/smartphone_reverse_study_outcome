package com.larus.bmhome;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.model.repo.x1;
import com.larus.bmhome.chat.model.repo.x1$b;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.tts.TtsScene;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.AIChatServiceImpl$startDoubaoMessageTts$1", f = "AIChatServiceImpl.kt", i = {}, l = {1180}, m = "invokeSuspend", n = {}, s = {})
final class AIChatServiceImpl$startDoubaoMessageTts$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $bot;
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ Message $message;
    final /* synthetic */ String $ttsContent;
    int label;
    final /* synthetic */ AIChatServiceImpl this$0;

    public AIChatServiceImpl$startDoubaoMessageTts$1(AIChatServiceImpl r1, Message r2, Fragment r3, BotModel r4, String r5, Continuation<? super AIChatServiceImpl$startDoubaoMessageTts$1> r6) {
        this.this$0 = r1;
        this.$message = r2;
        this.$fragment = r3;
        this.$bot = r4;
        this.$ttsContent = r5;
        super(1, r6);
    }

    public final Continuation<Unit> create(Continuation<?> r9) {
        return new AIChatServiceImpl$startDoubaoMessageTts$1(this.this$0, this.$message, this.$fragment, this.$bot, this.$ttsContent, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        RepoDispatcher.a.getClass();
        x1 r3 = RepoDispatcher.d.d.d;
        if (r3 == null) goto L11;
        FLogger.a.i("AIChatServiceImpl", "[TTS] should show loading toast: " + r3.n6() + '.');
        AIChatServiceImpl.j(this.this$0, this.$message, "1", "other_open", this.$fragment, this.$bot);
        Message r4 = this.$message;
        String r5 = this.$ttsContent;
        String r16 = this.$bot.getBotId();
        if (r16 != null) goto L15;
        r16 = "";
    L15:
        String r6 = r16;
        AIChatServiceImpl r17 = this.this$0;
        Fragment r2 = this.$fragment;
        BotModel r7 = this.$bot;
        r17.getClass();
        String r8 = AIChatServiceImpl.m(r2, r7);
        TtsScene r10 = TtsScene.Manual_LongPress;
        this.label = 1;
        if (x1$b.a(r3, r4, r5, r6, r8, false, null, r10, null, this, 352) != r0) goto L19;
        return r0;
    L11:
        return Unit.INSTANCE;
    }
}
