package com.larus.bmhome;

import android.content.Context;
import android.os.Bundle;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.helper.ChatRouterHelper;
import com.larus.bmhome.chat.model.ConversationListModel;
import com.larus.bmhome.chat.model.t0;
import com.larus.im.service.r;
import com.larus.platform.spi.IAIChatConversationService;
import gr9.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0096@¢\u0006\u0002\u0010\bJ0\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0096@¢\u0006\u0002\u0010\u0010JZ\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u0018H\u0016¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/AIChatConversationServiceImpl;", "Lcom/larus/platform/spi/IAIChatConversationService;", "<init>", "()V", "getSubConversationList", "", "Lcom/larus/platform/model/search/SubConversationSimplifyModel;", "fetchSubConversationList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createLocalBotSubConv", "Lcom/larus/im/bean/conversation/Conversation;", "botId", "", "conv", "msgList", "Lcom/larus/im/bean/message/Message;", "(Ljava/lang/String;Lcom/larus/im/bean/conversation/Conversation;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gotoSubConversation", "", "context", "Landroid/content/Context;", "enterMethod", "previousPage", "needTryLocalFirst", "", "extraParams", "Landroid/os/Bundle;", "autoSendParams", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "openKeyboardInNonLocalConv", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class AIChatConversationServiceImpl implements IAIChatConversationService {

    public static final class a {
    }

    static {
    }

    public AIChatConversationServiceImpl() {
    }

    public final List<b> d() {
        ConversationListModel.a.getClass();
        return ConversationListModel.u;
    }

    public final Object c(Continuation<? super List<b>> r4) {
        ConversationListModel.a.getClass();
        kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r4), 1);
        r0.C();
        ((r) ConversationListModel.d.getValue()).getSubConversationList(new t0(r0));
        Object r1 = r0.B();
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L5:
        return r1;
    }

    public final Object a(String r8, wc9.e r9, List r10, ContinuationImpl r11) {
        return ChatRouterHelper.e(ChatRouterHelper.a, r8, r9, r10, null, r11, 24);
    }

    public final void b(Context r27, String r28, wc9.e r29, String r30, String r31, boolean r32, Bundle r33, ICoreInputAbility.OnSendParams r34, boolean r35) {
        Intrinsics.checkNotNullParameter(r27, "context");
        Intrinsics.checkNotNullParameter(r28, "botId");
        ChatRouterHelper.h(r27, r28, r29, null, r30, r31, null, null, null, null, null, null, null, false, r32, false, r35, null, r34, null, r33, null, false, null, null, 32030664);
    }
}
