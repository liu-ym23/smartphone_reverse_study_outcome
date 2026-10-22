package com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.actionbar.MessageActionBarAlign;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
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
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.AnswerActionGenerator$buildCopyAction$3$1", f = "AnswerActionGenerator.kt", i = {}, l = {683}, m = "invokeSuspend", n = {}, s = {})
final class AnswerActionGenerator$buildCopyAction$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $bot;
    final /* synthetic */ z $creator;
    final /* synthetic */ CustomMarkdownTextView $markdownTextView;
    final /* synthetic */ rs8.h $messageActionBar;
    final /* synthetic */ MessageActionBarAlign $messageActionBarAlign;
    final /* synthetic */ Message $msg;
    int label;
    final /* synthetic */ w1 this$0;

    public AnswerActionGenerator$buildCopyAction$3$1(rs8.h r1, w1 r2, z r3, Message r4, BotModel r5, MessageActionBarAlign r6, CustomMarkdownTextView r7, Continuation<? super AnswerActionGenerator$buildCopyAction$3$1> r8) {
        this.$messageActionBar = r1;
        this.this$0 = r2;
        this.$creator = r3;
        this.$msg = r4;
        this.$bot = r5;
        this.$messageActionBarAlign = r6;
        this.$markdownTextView = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AnswerActionGenerator$buildCopyAction$3$1(this.$messageActionBar, this.this$0, this.$creator, this.$msg, this.$bot, this.$messageActionBarAlign, this.$markdownTextView, r11);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L11:
        int r10 = com.larus.utils.l0.a;
        final rs8.h r2 = this.$messageActionBar;
        final w1 r3 = this.this$0;
        final z r4 = this.$creator;
        final Message r5 = this.$msg;
        final BotModel r6 = this.$bot;
        final MessageActionBarAlign r7 = this.$messageActionBarAlign;
        final CustomMarkdownTextView r8 = this.$markdownTextView;
        com.larus.utils.l0.b(new x1(r2, r3, r4, r5, r6, r7, r8));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        this.label = 1;
        if (DelayKt.delay(2000, this) != r0) goto L11;
        return r0;
    }
}
