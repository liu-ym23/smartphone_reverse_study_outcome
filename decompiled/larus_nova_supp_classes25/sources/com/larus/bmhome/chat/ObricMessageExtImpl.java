package com.larus.bmhome.chat;

import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.holder.progressloading.LoadingType;
import com.larus.bmhome.chat.layout.holder.progressloading.h;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.model.strategy.ChatSendStrategy;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.setting.UserSettingCacheManager;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.ClientControllerParam;
import com.larus.im.bean.message.Message;
import com.larus.platform.IObricMessageExtService;
import com.larus.platform.service.AccountService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016JZ\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u001cH\u0016J8\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00152\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0016J,\u0010$\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u000f2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0018\u0010)\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0015H\u0016J\u0012\u0010*\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0018\u0010-\u001a\u00020(2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u0015H\u0016J\u0014\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001cH\u0016J2\u00100\u001a\u00020\r2\b\u00101\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001cH\u0016¨\u00063"}, d2 = {"Lcom/larus/bmhome/chat/ObricMessageExtImpl;", "Lcom/larus/platform/IObricMessageExtService;", "<init>", "()V", "isImageGeneratingMsg", "", "msg", "Lcom/larus/im/bean/message/Message;", "getClientControlParamsFromChatSendStrategy", "Lcom/larus/im/bean/message/ClientControllerParam;", "bot", "Lcom/larus/im/bean/bot/BotModel;", "notifyOnSendStart", "", "localMessageId", "", "notifySetScene", "msgId", "scene", "notifyOnSend", "botConversationType", "", "botType", "isOwnerBot", "isImmerseStyle", "isImmersiveBackgroundDynamic", "botId", "sendMessageTrackExtMap", "", "notifyOnStartSendMsg", "localSendMsgId", "cvsId", "contentType", "batchRequests", "", "Lcom/larus/im/bean/message/MessageRequest;", "notifyOnSdkSendMsg", "messageRequest", "sendFuncChannel", "isDeepthink", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "notifyOnSendMsgOnScreen", "tryCreateTask", "conv", "Lcom/larus/im/bean/conversation/Conversation;", "isSwitchOpen", "switchType", "generateGroupIdExt", "addSceneToMessageExt", "localMsgId", "ext", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ObricMessageExtImpl implements IObricMessageExtService {
    public ObricMessageExtImpl() {
    }

    public final Map<String, String> d() {
        ConcurrentHashMap r0 = com.larus.bmhome.utils.v3.a;
        return com.larus.bmhome.utils.v3.b();
    }

    public final ClientControllerParam b(BotModel r6) {
        int r0 = ChatSendStrategy.e;
        UserSettingCacheManager.a.getClass();
        boolean r1 = UserSettingCacheManager.a();
        String r2 = null;
        if (r6 == null) goto L7;
        SpeakerVoice r3 = r6.getVoiceType();
        if (r3 == null) goto L7;
        String r4 = r3.getId();
    L8:
        if (r6 == null) goto L16;
        String r5 = r6.getCallerName();
        if (r5 == null) goto L16;
        if ((!StringsKt.isBlank(r5)) == true) goto L15;
        r5 = null;
    L15:
        if (r5 == null) goto L16;
    L17:
        if (r6 == null) goto L22;
        SpeakerVoice r7 = r6.getVoiceType();
        if (r7 == null) goto L22;
        r2 = r7.getLanguageCode();
    L22:
        return new ClientControllerParam(r1, r2, r4, r5);
    L16:
        r5 = AccountService.a.getNickname();
    L7:
        r4 = null;
        goto L8
    }

    public final void f(String r3) {
        Intrinsics.checkNotNullParameter(r3, "msgId");
        Intrinsics.checkNotNullParameter("edit", "scene");
        ChatControlTrace.b.Ma(r3, "edit");
    }

    public final void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "localMessageId");
        ChatControlTrace.b.getClass();
        ChatControlTrace.X(r2);
    }

    public final boolean i(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        if (com.larus.bmhome.chat.bean.d.o0(r3) == true) goto L7;
        if (h.c(r3) == true) goto L7;
    L11:
        return false;
    L7:
        if (h.a(r3) == LoadingType.TEXT_PROGRESS_LOADING) goto L11;
        if (com.larus.bmhome.chat.bean.d.N0(r3) == true) goto L11;
        return true;
    }

    public final void k(wc9.e r2) {
        com.larus.bmhome.utils.v3.f(r2, null, null);
    }

    public final ReplyOption a(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        return com.larus.bmhome.instruction.c.a.a(r2, r3);
    }

    public final void j(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "localMessageId");
        com.larus.bmhome.chat.trace.appreciable.f.a.getClass();
        com.larus.bmhome.chat.trace.appreciable.f.j(r2, r3);
    }

    public final void e(String r2, String r3, Map<String, String> r4) {
        RepoDispatcherDelegate.b.e().u1().r(r2, r3, r4);
    }

    public final void l(String r4, yc9.f0 r5, ReplyOption r6) {
        Intrinsics.checkNotNullParameter(r5, "messageRequest");
        Intrinsics.checkNotNullParameter("replaceTextOnModify", "sendFuncChannel");
        com.larus.bmhome.chat.trace.appreciable.f r0 = com.larus.bmhome.chat.trace.appreciable.f.a;
        int r2 = r5.e;
        String r7 = r5.f;
        if (r6 == null) goto L5;
        ModelItemIdentity r8 = r6.getModel();
    L6:
        r0.getClass();
        com.larus.bmhome.chat.trace.appreciable.f.h(r4, r2, r7, "replaceTextOnModify", r8);
        return;
    L5:
        r8 = null;
        goto L6
    }

    public final void h(String r52, String r53, int r54, List r55) {
        Intrinsics.checkNotNullParameter(r52, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r53, "cvsId");
        Intrinsics.checkNotNullParameter("edit", "scene");
        if (r55 == null) goto L9;
        List r0 = r55;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        yc9.f0 r5 = (yc9.f0) r1.next();
        r4.add(new Message(null, null, null, 0, 0, null, r5.e, false, null, r5.f, null, null, null, r5.r, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, r5.s, null, 0, null, null, null, 2147474879, 31, null));
        goto L6
    L8:
        ArrayList r6 = r4;
    L10:
        com.larus.bmhome.chat.trace.appreciable.f.l(com.larus.bmhome.chat.trace.appreciable.f.a, r52, r53, "edit", r54, r6, null, null, null, 224);
        return;
    L9:
        r6 = null;
        goto L10
    }

    public final void c(Message r12, int r13, int r14, boolean r15, boolean r16, boolean r17, String r18, Map<String, String> r19) {
        Intrinsics.checkNotNullParameter(r12, "msg");
        ChatControlTrace.U(ChatControlTrace.b, r12, r13, r14, r15, r16, r17, r18, r19, 256);
    }
}
