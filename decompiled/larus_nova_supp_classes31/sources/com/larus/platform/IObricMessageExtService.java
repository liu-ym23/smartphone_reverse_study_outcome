package com.larus.platform;

import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.conversation.BotConversationType;
import com.larus.im.bean.message.ClientControllerParam;
import com.larus.im.bean.message.Message;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;
import yc9.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 12\u00020\u0001:\u00011J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH&J^\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\r2\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u001aH&J<\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\u00132\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 H&J,\u0010\"\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010&H&J\u0018\u0010'\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0013H&J\u0012\u0010(\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010*H&J\u0018\u0010+\u001a\u00020&2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u0013H&J\u0014\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u001aH&J8\u0010.\u001a\u00020\u000b2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0016\b\u0002\u00100\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u001aH&¨\u00062"}, d2 = {"Lcom/larus/platform/IObricMessageExtService;", "", "isImageGeneratingMsg", "", "msg", "Lcom/larus/im/bean/message/Message;", "getClientControlParamsFromChatSendStrategy", "Lcom/larus/im/bean/message/ClientControllerParam;", "bot", "Lcom/larus/im/bean/bot/BotModel;", "notifyOnSendStart", "", "localMessageId", "", "notifySetScene", "msgId", "scene", "notifyOnSend", "botConversationType", "", "botType", "isOwnerBot", "isImmerseStyle", "isImmersiveBackgroundDynamic", "botId", "sendMessageTrackExtMap", "", "notifyOnStartSendMsg", "localSendMsgId", "cvsId", "contentType", "batchRequests", "", "Lcom/larus/im/bean/message/MessageRequest;", "notifyOnSdkSendMsg", "messageRequest", "sendFuncChannel", "isDeepthink", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "notifyOnSendMsgOnScreen", "tryCreateTask", "conv", "Lcom/larus/im/bean/conversation/Conversation;", "isSwitchOpen", "switchType", "generateGroupIdExt", "addSceneToMessageExt", "localMsgId", "ext", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface IObricMessageExtService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nH\u0096\u0001J\u0015\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\nH\u0096\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0096\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0096\u0001J-\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J]\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\nH\u0096\u0001J\u0019\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0018H\u0096\u0001J\u0011\u0010)\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0007H\u0096\u0001J9\u0010*\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00182\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010.H\u0096\u0001J\u0019\u0010/\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0096\u0001J\u0013\u00100\u001a\u00020\u00052\b\u00101\u001a\u0004\u0018\u000102H\u0096\u0001¨\u00063"}, d2 = {"Lcom/larus/platform/IObricMessageExtService$Companion;", "Lcom/larus/platform/IObricMessageExtService;", "<init>", "()V", "addSceneToMessageExt", "", "localMsgId", "", "msgId", "ext", "", "generateGroupIdExt", "getClientControlParamsFromChatSendStrategy", "Lcom/larus/im/bean/message/ClientControllerParam;", "bot", "Lcom/larus/im/bean/bot/BotModel;", "isImageGeneratingMsg", "", "msg", "Lcom/larus/im/bean/message/Message;", "isSwitchOpen", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "botId", "switchType", "", "notifyOnSdkSendMsg", "localSendMsgId", "messageRequest", "Lcom/larus/im/bean/message/MessageRequest;", "sendFuncChannel", "isDeepthink", "notifyOnSend", "botConversationType", "botType", "isOwnerBot", "isImmerseStyle", "isImmersiveBackgroundDynamic", "sendMessageTrackExtMap", "notifyOnSendMsgOnScreen", "localMessageId", "contentType", "notifyOnSendStart", "notifyOnStartSendMsg", "cvsId", "scene", "batchRequests", "", "notifySetScene", "tryCreateTask", "conv", "Lcom/larus/im/bean/conversation/Conversation;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class Companion implements IObricMessageExtService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ IObricMessageExtService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.platform.IObricMessageExtService
        public final ReplyOption a(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "botId");
            return this.b.a(r2, r3);
        }

        @Override // com.larus.platform.IObricMessageExtService
        public final ClientControllerParam b(BotModel r2) {
            return this.b.b(r2);
        }

        @Override // com.larus.platform.IObricMessageExtService
        public final void c(Message r11, @BotConversationType int r12, int r13, boolean r14, boolean r15, boolean r16, String r17, Map<String, String> r18) {
            Intrinsics.checkNotNullParameter(r11, "msg");
            this.b.c(r11, r12, r13, r14, r15, r16, r17, r18);
        }

        @Override // com.larus.platform.IObricMessageExtService
        public final Map<String, String> d() {
            return this.b.d();
        }

        @Override // com.larus.platform.IObricMessageExtService
        public final void e(String r2, String r3, Map<String, String> r4) {
            this.b.e(r2, r3, r4);
        }

        @Override // com.larus.platform.IObricMessageExtService
        public final void f(String r3) {
            Intrinsics.checkNotNullParameter(r3, "msgId");
            Intrinsics.checkNotNullParameter("edit", "scene");
            this.b.f(r3);
        }

        @Override // com.larus.platform.IObricMessageExtService
        public final void g(String r2) {
            Intrinsics.checkNotNullParameter(r2, "localMessageId");
            this.b.g(r2);
        }

        @Override // com.larus.platform.IObricMessageExtService
        public final void h(String r3, String r4, int r5, List r6) {
            Intrinsics.checkNotNullParameter(r3, "localSendMsgId");
            Intrinsics.checkNotNullParameter(r4, "cvsId");
            Intrinsics.checkNotNullParameter("edit", "scene");
            this.b.h(r3, r4, r5, r6);
        }

        @Override // com.larus.platform.IObricMessageExtService
        public final boolean i(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            return this.b.i(r2);
        }

        @Override // com.larus.platform.IObricMessageExtService
        public final void j(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "localMessageId");
            this.b.j(r2, r3);
        }

        @Override // com.larus.platform.IObricMessageExtService
        public final void k(e r2) {
            this.b.k(r2);
        }

        @Override // com.larus.platform.IObricMessageExtService
        public final void l(String r3, f0 r4, ReplyOption r5) {
            Intrinsics.checkNotNullParameter(r4, "messageRequest");
            Intrinsics.checkNotNullParameter("replaceTextOnModify", "sendFuncChannel");
            this.b.l(r3, r4, r5);
        }

        private Companion() {
            IObricMessageExtService r0 = (IObricMessageExtService) ServiceManager.get().getService(IObricMessageExtService.class);
            if (r0 != null) goto L5;
            r0 = new ObricMessageExtServiceNoop();
        L5:
            this.b = r0;
        }
    }

    static {
        a = Companion.c;
    }

    ReplyOption a(String r1, int r2);

    ClientControllerParam b(BotModel r1);

    void c(Message r1, @BotConversationType int r2, int r3, boolean r4, boolean r5, boolean r6, String r7, Map<String, String> r8);

    Map<String, String> d();

    void e(String r1, String r2, Map<String, String> r3);

    void f(String r1);

    void g(String r1);

    void h(String r1, String r2, int r3, List r4);

    boolean i(Message r1);

    void j(String r1, int r2);

    void k(e r1);

    void l(String r1, f0 r2, ReplyOption r3);
}
