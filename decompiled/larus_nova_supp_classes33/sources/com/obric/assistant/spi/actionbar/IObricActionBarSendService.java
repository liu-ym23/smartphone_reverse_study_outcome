package com.obric.assistant.spi.actionbar;

import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.cell.slot.MessageInBoxBottomExtWidgetSlotCell;
import com.larus.im.bean.message.Message;
import gd8.g;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\u0003H&J\u001e\u0010\t\u001a\u00020\n2\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H&J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\fH&J*\u0010\r\u001a\u00020\n2\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0003H&J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u0003H&J&\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u0003H&J!\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u001bJ2\u0010\u001c\u001a\u00020\n2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005H&J%\u0010\u001f\u001a\u0004\u0018\u00010 2\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fH&¢\u0006\u0002\u0010!J\u0012\u0010\"\u001a\u00020 2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H&J\u001c\u0010#\u001a\u0004\u0018\u00010\u00032\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\b\u001a\u00020\u0003H&J$\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020%2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00012\u0006\u0010)\u001a\u00020*H&J\u0010\u0010+\u001a\u00020\n2\u0006\u0010$\u001a\u00020%H&J\u0010\u0010,\u001a\u00020\n2\u0006\u0010$\u001a\u00020%H&J\b\u0010-\u001a\u00020 H&J\u0010\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020 H&J\u0012\u00100\u001a\u00020 2\b\u00101\u001a\u0004\u0018\u00010\u0003H&J\u0012\u00102\u001a\u00020 2\b\u00103\u001a\u0004\u0018\u000104H&J\u0010\u00105\u001a\u00020 2\u0006\u00106\u001a\u00020\u0001H&J\u0018\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u000108H&¨\u00069"}, d2 = {"Lcom/obric/assistant/spi/actionbar/IObricActionBarSendService;", "", "replaceContentOnSend", "", "extra", "", "content", "onSendParams", "sendScene", "updateMessageExtOnSendAudioMessage", "", "createPhoneOperationMessageExt", "", "addMessageExt", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "getContentPrefix", "getObricUserInputWithFormat", "replyFormat", "userInput", "getObricEffectiveActionBarInput", "actionBarKey", "sourceInputContent", "onSuggestSelectorClick", "itemStatus", "", "displayText", "(Ljava/lang/Integer;Ljava/lang/String;)V", "setSendAudioMessageExt", "fromExt", "toExt", "isSameScene", "", "(Ljava/util/Map;)Ljava/lang/Boolean;", "isAssistantActionBar", "modifyContent", "message", "Lcom/larus/im/bean/message/Message;", "reSendMessage", "replyMessage", "chatMessageAbility", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "setConfirmMessage", "setTaskCardMessage", "isRestrictInstructionInputHeight", "setRestrictInstructionInputHeight", "isRestrict", "isAudioMessage", "messageId", "isPhoneOperationSwitch", "replyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "isActionBarShowInFront", "segment", "getPhoneOperationMenuConfig", "Lkotlin/Pair;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricActionBarSendService {
    boolean a(String r1);

    boolean b(Object r1);

    void c(Message r1, g r2, MessageInBoxBottomExtWidgetSlotCell r3);

    void d(Map<String, String> r1, Map<String, String> r2);

    String e(String r1, String r2, String r3);

    Pair<String, String> f();

    Boolean g(Map<String, String> r1);

    void i(Map<String, String> r1, e r2);

    boolean isAudioMessage(String r1);

    void k(boolean r1);

    void l(Message r1);

    String m(String r1);

    String n(String r1, String r2);

    void o(Message r1);

    boolean p();

    void r(Map<String, String> r1);

    void s(Integer r1, String r2);

    boolean u(ReplyOption r1);

    Map<String, String> v();

    String w(Message r1, String r2);

    String x(Map<String, String> r1, String r2, Object r3, String r4);
}
