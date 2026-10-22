package com.larus.platform.spi;

import android.content.Context;
import android.os.Bundle;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.tencent.open.log.TraceLevel;
import gr9.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0096@¢\u0006\u0002\u0010\bJ0\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0096@¢\u0006\u0002\u0010\u0010JZ\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u0018H\u0016¨\u0006\u001e"}, d2 = {"Lcom/larus/platform/spi/IAIChatConversationServiceEmpty;", "Lcom/larus/platform/spi/IAIChatConversationService;", "<init>", "()V", "getSubConversationList", "", "Lcom/larus/platform/model/search/SubConversationSimplifyModel;", "fetchSubConversationList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createLocalBotSubConv", "Lcom/larus/im/bean/conversation/Conversation;", "botId", "", "conv", "msgList", "Lcom/larus/im/bean/message/Message;", "(Ljava/lang/String;Lcom/larus/im/bean/conversation/Conversation;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gotoSubConversation", "", "context", "Landroid/content/Context;", "enterMethod", "previousPage", "needTryLocalFirst", "", "extraParams", "Landroid/os/Bundle;", "autoSendParams", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "openKeyboardInNonLocalConv", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
final class IAIChatConversationServiceEmpty implements IAIChatConversationService {
    public static final IAIChatConversationServiceEmpty b = null;

    static {
        b = new IAIChatConversationServiceEmpty();
    }

    private IAIChatConversationServiceEmpty() {
    }

    @Override // com.larus.platform.spi.IAIChatConversationService
    public final Object a(String r1, e r2, List r3, ContinuationImpl r4) {
        return null;
    }

    @Override // com.larus.platform.spi.IAIChatConversationService
    public final void b(Context r1, String r2, e r3, String r4, String r5, boolean r6, Bundle r7, ICoreInputAbility.OnSendParams r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "botId");
    }

    @Override // com.larus.platform.spi.IAIChatConversationService
    public final Object c(Continuation<? super List<b>> r1) {
        return null;
    }

    @Override // com.larus.platform.spi.IAIChatConversationService
    public final List<b> d() {
        return null;
    }
}
