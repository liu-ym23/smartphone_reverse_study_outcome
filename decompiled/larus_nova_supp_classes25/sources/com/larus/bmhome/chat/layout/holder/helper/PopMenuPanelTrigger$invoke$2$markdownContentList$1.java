package com.larus.bmhome.chat.layout.holder.helper;

import android.content.Context;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.helper.PopMenuPanelTrigger$invoke$2$markdownContentList$1", f = "PopMenuPanelTrigger.kt", i = {}, l = {578}, m = "invokeSuspend", n = {}, s = {})
public final class PopMenuPanelTrigger$invoke$2$markdownContentList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends lw8.l>>, Object> {
    final /* synthetic */ BotModel $currentBot;
    int label;
    final /* synthetic */ PopMenuPanelTrigger this$0;

    public PopMenuPanelTrigger$invoke$2$markdownContentList$1(PopMenuPanelTrigger r1, BotModel r2, Continuation<? super PopMenuPanelTrigger$invoke$2$markdownContentList$1> r3) {
        this.this$0 = r1;
        this.$currentBot = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PopMenuPanelTrigger$invoke$2$markdownContentList$1(this.this$0, this.$currentBot, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<? extends lw8.l>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r77) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r77);
        return r77;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r77);
        MessageCopyHelper r1 = MessageCopyHelper.a;
        Context r2 = this.this$0.a.requireContext();
        Message r3 = this.this$0.d();
        BotModel r4 = this.$currentBot;
        if (r4 != null) goto L14;
        BotInfoCache r5 = BotInfoCache.INSTANCE;
        String r8 = this.this$0.d().getConversationId();
        if (r8 != null) goto L13;
        r8 = "";
    L13:
        r4 = new BotModel(r5.getBotId(r8), null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
    L14:
        LongClickSource r6 = this.this$0.k;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        int r9 = p1.a[r6.ordinal()];
        if (r9 != 1) goto L17;
        TargetDataSource r10 = TargetDataSource.ALL;
    L25:
        this.label = 1;
        Object r11 = r1.g(r2, r3, r4, r10, this);
        if (r11 != r7) goto L29;
        return r7;
    L29:
        return r11;
    L17:
        if (r9 != 2) goto L19;
        r10 = TargetDataSource.Thinking;
        goto L25
    L19:
        if (r9 != 3) goto L22;
        r10 = TargetDataSource.Content;
        goto L25
    L22:
        throw new NoWhenBranchMatchedException();
    }
}
