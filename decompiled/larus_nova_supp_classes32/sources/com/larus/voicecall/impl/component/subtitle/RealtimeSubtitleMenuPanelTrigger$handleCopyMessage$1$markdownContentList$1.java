package com.larus.voicecall.impl.component.subtitle;

import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.chat.layout.holder.helper.s0;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lcom/larus/business/markdown/api/model/MarkdownContent;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.subtitle.RealtimeSubtitleMenuPanelTrigger$handleCopyMessage$1$markdownContentList$1", f = "RealtimeSubtitleMenuPanelTrigger.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeSubtitleMenuPanelTrigger$handleCopyMessage$1$markdownContentList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends lw8.l>>, Object> {
    final /* synthetic */ Message $msg;
    int label;
    final /* synthetic */ k0 this$0;

    public RealtimeSubtitleMenuPanelTrigger$handleCopyMessage$1$markdownContentList$1(k0 r1, Message r2, Continuation<? super RealtimeSubtitleMenuPanelTrigger$handleCopyMessage$1$markdownContentList$1> r3) {
        this.this$0 = r1;
        this.$msg = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RealtimeSubtitleMenuPanelTrigger$handleCopyMessage$1$markdownContentList$1(this.this$0, this.$msg, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<? extends lw8.l>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r76) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r76);
        Object r3 = r76;
    L22:
        return (List) r3;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r76);
        s0 r4 = ILegacyChatUiServiceDelegate.b.X8();
        if (r4 == null) goto L20;
        k0 r5 = this.this$0;
        FragmentActivity r6 = r5.a;
        Message r7 = this.$msg;
        BotModel r8 = r5.f;
        if (r8 != null) goto L16;
        BotInfoCache r9 = BotInfoCache.INSTANCE;
        String r10 = this.$msg.getConversationId();
        if (r10 != null) goto L15;
        r10 = NameKeys.UnloadStrategy_No_Strategy;
    L15:
        r8 = new BotModel(r9.getBotId(r10), null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
    L16:
        this.label = 1;
        r3 = s0.a.b(r4, r6, r7, r8, this);
        if (r3 != r1) goto L22;
        return r1;
    L20:
        return null;
    }
}
