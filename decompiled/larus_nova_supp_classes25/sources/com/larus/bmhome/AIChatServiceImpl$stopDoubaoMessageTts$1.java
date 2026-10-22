package com.larus.bmhome;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
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
@DebugMetadata(c = "com.larus.bmhome.AIChatServiceImpl$stopDoubaoMessageTts$1", f = "AIChatServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AIChatServiceImpl$stopDoubaoMessageTts$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $botModel;
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ Message $message;
    int label;
    final /* synthetic */ AIChatServiceImpl this$0;

    public AIChatServiceImpl$stopDoubaoMessageTts$1(AIChatServiceImpl r1, Message r2, Fragment r3, BotModel r4, Continuation<? super AIChatServiceImpl$stopDoubaoMessageTts$1> r5) {
        this.this$0 = r1;
        this.$message = r2;
        this.$fragment = r3;
        this.$botModel = r4;
        super(1, r5);
    }

    public final Continuation<Unit> create(Continuation<?> r8) {
        return new AIChatServiceImpl$stopDoubaoMessageTts$1(this.this$0, this.$message, this.$fragment, this.$botModel, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r8);
        AIChatServiceImpl.j(this.this$0, this.$message, "0", "other_close", this.$fragment, this.$botModel);
        RepoDispatcher.a.getClass();
        RepoDispatcher.d.d.d.i6("long_press_play", true);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
