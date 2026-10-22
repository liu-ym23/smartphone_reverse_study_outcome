package com.larus.platform;

import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.ClientControllerParam;
import com.larus.im.bean.message.Message;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;
import yc9.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016JZ\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u001cH\u0016J8\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00152\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0016J,\u0010$\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u000f2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0018\u0010)\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0015H\u0016J\u0012\u0010*\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0018\u0010-\u001a\u00020(2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u0015H\u0016J\u0014\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001cH\u0016J2\u00100\u001a\u00020\r2\b\u00101\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001cH\u0016¨\u00063"}, d2 = {"Lcom/larus/platform/ObricMessageExtServiceNoop;", "Lcom/larus/platform/IObricMessageExtService;", "<init>", "()V", "isImageGeneratingMsg", "", "msg", "Lcom/larus/im/bean/message/Message;", "getClientControlParamsFromChatSendStrategy", "Lcom/larus/im/bean/message/ClientControllerParam;", "bot", "Lcom/larus/im/bean/bot/BotModel;", "notifyOnSendStart", "", "localMessageId", "", "notifySetScene", "msgId", "scene", "notifyOnSend", "botConversationType", "", "botType", "isOwnerBot", "isImmerseStyle", "isImmersiveBackgroundDynamic", "botId", "sendMessageTrackExtMap", "", "notifyOnStartSendMsg", "localSendMsgId", "cvsId", "contentType", "batchRequests", "", "Lcom/larus/im/bean/message/MessageRequest;", "notifyOnSdkSendMsg", "messageRequest", "sendFuncChannel", "isDeepthink", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "notifyOnSendMsgOnScreen", "tryCreateTask", "conv", "Lcom/larus/im/bean/conversation/Conversation;", "isSwitchOpen", "switchType", "generateGroupIdExt", "addSceneToMessageExt", "localMsgId", "ext", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ObricMessageExtServiceNoop implements IObricMessageExtService {
    public ObricMessageExtServiceNoop() {
    }

    @Override // com.larus.platform.IObricMessageExtService
    public final void c(Message r1, int r2, int r3, boolean r4, boolean r5, boolean r6, String r7, Map<String, String> r8) {
        Intrinsics.checkNotNullParameter(r1, "msg");
    }

    @Override // com.larus.platform.IObricMessageExtService
    public final void e(String r1, String r2, Map<String, String> r3) {
    }

    @Override // com.larus.platform.IObricMessageExtService
    public final void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        Intrinsics.checkNotNullParameter("edit", "scene");
    }

    @Override // com.larus.platform.IObricMessageExtService
    public final void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "localMessageId");
    }

    @Override // com.larus.platform.IObricMessageExtService
    public final void h(String r1, String r2, int r3, List r4) {
        Intrinsics.checkNotNullParameter(r1, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        Intrinsics.checkNotNullParameter("edit", "scene");
    }

    @Override // com.larus.platform.IObricMessageExtService
    public final boolean i(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        return false;
    }

    @Override // com.larus.platform.IObricMessageExtService
    public final void j(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "localMessageId");
    }

    @Override // com.larus.platform.IObricMessageExtService
    public final void k(e r1) {
    }

    @Override // com.larus.platform.IObricMessageExtService
    public final void l(String r1, f0 r2, ReplyOption r3) {
        Intrinsics.checkNotNullParameter(r2, "messageRequest");
        Intrinsics.checkNotNullParameter("replaceTextOnModify", "sendFuncChannel");
    }

    @Override // com.larus.platform.IObricMessageExtService
    public final Map<String, String> d() {
        return MapsKt.emptyMap();
    }

    @Override // com.larus.platform.IObricMessageExtService
    public final ClientControllerParam b(BotModel r8) {
        return new ClientControllerParam(false, null, null, null, 15, null);
    }

    @Override // com.larus.platform.IObricMessageExtService
    public final ReplyOption a(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        return new ReplyOption(new ModelItemIdentity(null, null), null, null);
    }
}
