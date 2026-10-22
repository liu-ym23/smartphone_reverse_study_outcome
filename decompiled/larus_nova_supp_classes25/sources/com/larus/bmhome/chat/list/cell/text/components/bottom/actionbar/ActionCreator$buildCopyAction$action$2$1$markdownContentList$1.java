package com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar;

import android.content.Context;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.ActionCreator$buildCopyAction$action$2$1$markdownContentList$1", f = "ActionCreator.kt", i = {}, l = {1042}, m = "invokeSuspend", n = {}, s = {})
public final class ActionCreator$buildCopyAction$action$2$1$markdownContentList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends lw8.l>>, Object> {
    final /* synthetic */ BotModel $bot;
    final /* synthetic */ Message $msg;
    int label;
    final /* synthetic */ z this$0;

    public ActionCreator$buildCopyAction$action$2$1$markdownContentList$1(z r1, Message r2, BotModel r3, Continuation<? super ActionCreator$buildCopyAction$action$2$1$markdownContentList$1> r4) {
        this.this$0 = r1;
        this.$msg = r2;
        this.$bot = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ActionCreator$buildCopyAction$action$2$1$markdownContentList$1(this.this$0, this.$msg, this.$bot, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<? extends lw8.l>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L13:
        List r7 = (List) r6;
        if (r7 == null) goto L16;
        return r7;
    L16:
        return CollectionsKt.emptyList();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        com.larus.bmhome.chat.layout.holder.helper.s0 r8 = ILegacyChatUiServiceDelegate.b.X8();
        if (r8 == null) goto L16;
        Context r2 = this.this$0.c;
        Message r3 = this.$msg;
        BotModel r4 = this.$bot;
        this.label = 1;
        r6 = com.larus.bmhome.chat.layout.holder.helper.s0.a.b(r8, r2, r3, r4, this);
        if (r6 != r0) goto L13;
        return r0;
    }
}
