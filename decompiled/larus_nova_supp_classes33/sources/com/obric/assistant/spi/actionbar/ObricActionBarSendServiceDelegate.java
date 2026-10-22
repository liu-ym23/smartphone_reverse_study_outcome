package com.obric.assistant.spi.actionbar;

import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.cell.slot.MessageInBoxBottomExtWidgetSlotCell;
import com.larus.im.bean.message.Message;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import gd8.g;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0001J\u0015\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\fH\u0096\u0001J\u0013\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\bH\u0096\u0001J'\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\bH\u0096\u0001J\u001d\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\bH\u0096\u0001J\u0019\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0016H\u0096\u0001J\u0011\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0096\u0001J\u0013\u0010\u001b\u001a\u00020\u00182\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0096\u0001J\u0013\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\bH\u0096\u0001J\u0013\u0010\u001e\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0001J\t\u0010!\u001a\u00020\u0018H\u0096\u0001J&\u0010\"\u001a\u0004\u0018\u00010\u00182\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\fH\u0096\u0001¢\u0006\u0002\u0010#J\u001d\u0010$\u001a\u0004\u0018\u00010\b2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\bH\u0096\u0001J\"\u0010(\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010\bH\u0096\u0001¢\u0006\u0002\u0010,J#\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u00010\u001a2\u0006\u00100\u001a\u000201H\u0096\u0001J=\u00102\u001a\u0004\u0018\u00010\b2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u00103\u001a\u0004\u0018\u00010\u001a2\u0006\u0010'\u001a\u00020\bH\u0096\u0001J\u0011\u00104\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0096\u0001J\u0011\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0018H\u0096\u0001J3\u00107\u001a\u00020\u00052\u0014\u00108\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\f2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096\u0001J\u0011\u0010:\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0096\u0001J\u001f\u0010;\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0096\u0001¨\u0006<"}, d2 = {"Lcom/obric/assistant/spi/actionbar/ObricActionBarSendServiceDelegate;", "Lcom/obric/assistant/spi/actionbar/IObricActionBarSendService;", "<init>", "()V", "addMessageExt", "", "extra", "", "", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "createPhoneOperationMessageExt", "", "getContentPrefix", "content", "getObricEffectiveActionBarInput", "actionBarKey", "sourceInputContent", "userInput", "getObricUserInputWithFormat", "replyFormat", "getPhoneOperationMenuConfig", "Lkotlin/Pair;", "isActionBarShowInFront", "", "segment", "", "isAssistantActionBar", "isAudioMessage", "messageId", "isPhoneOperationSwitch", "replyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "isRestrictInstructionInputHeight", "isSameScene", "(Ljava/util/Map;)Ljava/lang/Boolean;", "modifyContent", "message", "Lcom/larus/im/bean/message/Message;", "sendScene", "onSuggestSelectorClick", "itemStatus", "", "displayText", "(Ljava/lang/Integer;Ljava/lang/String;)V", "reSendMessage", "replyMessage", "chatMessageAbility", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "replaceContentOnSend", "onSendParams", "setConfirmMessage", "setRestrictInstructionInputHeight", "isRestrict", "setSendAudioMessageExt", "fromExt", "toExt", "setTaskCardMessage", "updateMessageExtOnSendAudioMessage", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricActionBarSendServiceDelegate implements IObricActionBarSendService {
    public static final ObricActionBarSendServiceDelegate b = null;
    public final /* synthetic */ IObricActionBarSendService a;

    static {
        b = new ObricActionBarSendServiceDelegate();
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final boolean a(String r2) {
        return this.a.a(r2);
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final boolean b(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "segment");
        return this.a.b(r2);
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final void c(Message r2, g r3, MessageInBoxBottomExtWidgetSlotCell r4) {
        Intrinsics.checkNotNullParameter(r2, "replyMessage");
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        this.a.c(r2, r3, r4);
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final void d(Map<String, String> r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "toExt");
        this.a.d(r2, r3);
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final String e(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "userInput");
        return this.a.e(r2, r3, r4);
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final Pair<String, String> f() {
        return this.a.f();
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final Boolean g(Map<String, String> r2) {
        return this.a.g(r2);
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final void i(Map<String, String> r2, e r3) {
        this.a.i(r2, r3);
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final boolean isAudioMessage(String r2) {
        return this.a.isAudioMessage(r2);
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final void k(boolean r2) {
        this.a.k(r2);
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final void l(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        this.a.l(r2);
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final String m(String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        return this.a.m(r2);
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final String n(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "userInput");
        return this.a.n(r2, r3);
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final void o(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        this.a.o(r2);
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final boolean p() {
        return this.a.p();
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final void r(Map<String, String> r2) {
        this.a.r(r2);
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final void s(Integer r2, String r3) {
        this.a.s(r2, r3);
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final boolean u(ReplyOption r2) {
        return this.a.u(r2);
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final Map<String, String> v() {
        return this.a.v();
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final String w(Message r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "sendScene");
        return this.a.w(r2, r3);
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final String x(Map<String, String> r2, String r3, Object r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "sendScene");
        return this.a.x(r2, r3, r4, r5);
    }

    private ObricActionBarSendServiceDelegate() {
        IObricActionBarSendService r0 = (IObricActionBarSendService) ServiceManager.get().getService(IObricActionBarSendService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultObricActionBarSendService();
    L5:
        this.a = r0;
    }
}
