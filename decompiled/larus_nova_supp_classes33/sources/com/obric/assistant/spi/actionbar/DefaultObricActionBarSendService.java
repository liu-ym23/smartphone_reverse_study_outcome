package com.obric.assistant.spi.actionbar;

import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.cell.slot.MessageInBoxBottomExtWidgetSlotCell;
import com.larus.im.bean.message.Message;
import gd8.g;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u001e\u0010\f\u001a\u00020\r2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H\u0016J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000fH\u0016J(\u0010\u0010\u001a\u00020\r2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J!\u0010\u001a\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u001eJ2\u0010\u001f\u001a\u00020\r2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007H\u0016J%\u0010\"\u001a\u0004\u0018\u00010#2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010$J\u0012\u0010%\u001a\u00020#2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010&\u001a\u0004\u0018\u00010\u00052\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\"\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020(2\b\u0010+\u001a\u0004\u0018\u00010\n2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\r2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010/\u001a\u00020\r2\u0006\u0010'\u001a\u00020(H\u0016J\b\u00100\u001a\u00020#H\u0016J\u0010\u00101\u001a\u00020\r2\u0006\u00102\u001a\u00020#H\u0016J\u0012\u00103\u001a\u00020#2\b\u00104\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u00105\u001a\u00020#2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0010\u00108\u001a\u00020#2\u0006\u00109\u001a\u00020\nH\u0016J\u0016\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010;H\u0016¨\u0006<"}, d2 = {"Lcom/obric/assistant/spi/actionbar/DefaultObricActionBarSendService;", "Lcom/obric/assistant/spi/actionbar/IObricActionBarSendService;", "<init>", "()V", "replaceContentOnSend", "", "extra", "", "content", "onSendParams", "", "sendScene", "updateMessageExtOnSendAudioMessage", "", "createPhoneOperationMessageExt", "", "addMessageExt", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "getContentPrefix", "getObricUserInputWithFormat", "replyFormat", "userInput", "getObricEffectiveActionBarInput", "actionBarKey", "sourceInputContent", "onSuggestSelectorClick", "itemStatus", "", "displayText", "(Ljava/lang/Integer;Ljava/lang/String;)V", "setSendAudioMessageExt", "fromExt", "toExt", "isSameScene", "", "(Ljava/util/Map;)Ljava/lang/Boolean;", "isAssistantActionBar", "modifyContent", "message", "Lcom/larus/im/bean/message/Message;", "reSendMessage", "replyMessage", "chatMessageAbility", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "setConfirmMessage", "setTaskCardMessage", "isRestrictInstructionInputHeight", "setRestrictInstructionInputHeight", "isRestrict", "isAudioMessage", "messageId", "isPhoneOperationSwitch", "replyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "isActionBarShowInFront", "segment", "getPhoneOperationMenuConfig", "Lkotlin/Pair;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricActionBarSendService implements IObricActionBarSendService {
    public DefaultObricActionBarSendService() {
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final boolean a(String r1) {
        return false;
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final boolean b(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "segment");
        return true;
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final void c(Message r1, g r2, MessageInBoxBottomExtWidgetSlotCell r3) {
        Intrinsics.checkNotNullParameter(r1, "replyMessage");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final void d(Map<String, String> r1, Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "toExt");
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final String e(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "userInput");
        return null;
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final Pair<String, String> f() {
        return null;
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final Boolean g(Map<String, String> r1) {
        return null;
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final void i(Map<String, String> r1, e r2) {
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final boolean isAudioMessage(String r1) {
        return false;
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final void k(boolean r1) {
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final void l(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final String m(String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        return null;
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final String n(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "userInput");
        return null;
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final void o(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final boolean p() {
        return false;
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final void r(Map<String, String> r1) {
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final void s(Integer r1, String r2) {
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final boolean u(ReplyOption r1) {
        return false;
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final String w(Message r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "sendScene");
        return null;
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final String x(Map<String, String> r1, String r2, Object r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "sendScene");
        return null;
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarSendService
    public final Map<String, String> v() {
        return MapsKt.emptyMap();
    }
}
