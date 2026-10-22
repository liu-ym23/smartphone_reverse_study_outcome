package com.larus.platform.spi;

import android.content.Context;
import android.os.Bundle;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import gr9.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cJ\u0010\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&J\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H¦@¢\u0006\u0002\u0010\u0006J0\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003H¦@¢\u0006\u0002\u0010\u000eJh\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u0016H&¨\u0006\u001d"}, d2 = {"Lcom/larus/platform/spi/IAIChatConversationService;", "", "getSubConversationList", "", "Lcom/larus/platform/model/search/SubConversationSimplifyModel;", "fetchSubConversationList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createLocalBotSubConv", "Lcom/larus/im/bean/conversation/Conversation;", "botId", "", "conv", "msgList", "Lcom/larus/im/bean/message/Message;", "(Ljava/lang/String;Lcom/larus/im/bean/conversation/Conversation;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gotoSubConversation", "", "context", "Landroid/content/Context;", "enterMethod", "previousPage", "needTryLocalFirst", "", "extraParams", "Landroid/os/Bundle;", "autoSendParams", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "openKeyboardInNonLocalConv", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface IAIChatConversationService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0096A¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nH\u0096A¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nH\u0096\u0001J[\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u0018H\u0096\u0001¨\u0006\u001e"}, d2 = {"Lcom/larus/platform/spi/IAIChatConversationService$Companion;", "Lcom/larus/platform/spi/IAIChatConversationService;", "<init>", "()V", "createLocalBotSubConv", "Lcom/larus/im/bean/conversation/Conversation;", "botId", "", "conv", "msgList", "", "Lcom/larus/im/bean/message/Message;", "(Ljava/lang/String;Lcom/larus/im/bean/conversation/Conversation;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchSubConversationList", "Lcom/larus/platform/model/search/SubConversationSimplifyModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSubConversationList", "gotoSubConversation", "", "context", "Landroid/content/Context;", "enterMethod", "previousPage", "needTryLocalFirst", "", "extraParams", "Landroid/os/Bundle;", "autoSendParams", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "openKeyboardInNonLocalConv", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class Companion implements IAIChatConversationService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ IAIChatConversationService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.platform.spi.IAIChatConversationService
        public final Object a(String r2, e r3, List r4, ContinuationImpl r5) {
            return this.b.a(r2, r3, r4, r5);
        }

        @Override // com.larus.platform.spi.IAIChatConversationService
        public final void b(Context r12, String r13, e r14, String r15, String r16, boolean r17, Bundle r18, ICoreInputAbility.OnSendParams r19, boolean r20) {
            Intrinsics.checkNotNullParameter(r12, "context");
            Intrinsics.checkNotNullParameter(r13, "botId");
            this.b.b(r12, r13, r14, r15, r16, r17, r18, r19, r20);
        }

        @Override // com.larus.platform.spi.IAIChatConversationService
        public final Object c(Continuation<? super List<b>> r2) {
            return this.b.c(r2);
        }

        @Override // com.larus.platform.spi.IAIChatConversationService
        public final List<b> d() {
            return this.b.d();
        }

        private Companion() {
            IAIChatConversationService r0 = (IAIChatConversationService) ServiceManager.get().getService(IAIChatConversationService.class);
            if (r0 != null) goto L5;
            r0 = IAIChatConversationServiceEmpty.b;
        L5:
            this.b = r0;
        }
    }

    public static final class a {
        public static /* synthetic */ void a(Companion r13, Context r14, String r15, e r16, String r17, String r18, Bundle r19, int r20) {
            if ((r20 & 4) == 0) goto L5;
            e r6 = null;
        L7:
            if ((r20 & 8) == 0) goto L9;
            String r7 = "";
        L11:
            if ((r20 & 16) == 0) goto L13;
            String r8 = "";
        L15:
            if ((r20 & 32) == 0) goto L17;
            boolean r9 = false;
        L19:
            if ((r20 & 64) == 0) goto L21;
            Bundle r10 = null;
        L23:
            if ((r20 & 256) == 0) goto L25;
            boolean r12 = true;
        L26:
            r13.b(r14, r15, r6, r7, r8, r9, r10, null, r12);
            return;
        L25:
            r12 = false;
            goto L26
        L21:
            r10 = r19;
            goto L23
        L17:
            r9 = true;
            goto L19
        L13:
            r8 = r18;
            goto L15
        L9:
            r7 = r17;
            goto L11
        L5:
            r6 = r16;
            goto L7
        }
    }

    static {
        a = Companion.c;
    }

    Object a(String r1, e r2, List r3, ContinuationImpl r4);

    void b(Context r1, String r2, e r3, String r4, String r5, boolean r6, Bundle r7, ICoreInputAbility.OnSendParams r8, boolean r9);

    Object c(Continuation<? super List<b>> r1);

    List<b> d();
}
