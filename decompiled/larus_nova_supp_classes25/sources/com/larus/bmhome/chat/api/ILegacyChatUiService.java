package com.larus.bmhome.chat.api;

import android.content.Context;
import android.text.InputFilter;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.v2;
import com.larus.bmhome.chat.component.bottom.core.x2;
import com.larus.bmhome.chat.component.bottom.core.y2;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.EditPos;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import wh8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Deprecated(message = "some difficult handled apis ")
@Metadata(d1 = {"\u0000Ê\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ.\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&JE\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00102*\u0010\u0011\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00130\u0012\"\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0013H&¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010H&J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003H&J:\u0010\u0019\u001a\u00020\u00032\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\tH&JD\u0010!\u001a\u00020\u00032\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\"\u001a\u00020\u0003H&J\u0012\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010%H&Jï\u0001\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020(2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u00032\b\u00101\u001a\u0004\u0018\u00010\u001f2\u0006\u00102\u001a\u0002032\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0017052\u001e\u00106\u001a\u001a\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0017072\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u0017092\u0006\u0010:\u001a\u00020\u00032\b\b\u0002\u0010;\u001a\u00020\u00032\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\b\b\u0002\u0010>\u001a\u00020\u00032\u0010\b\u0002\u0010?\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\u00122\u0014\b\u0002\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0010H&¢\u0006\u0002\u0010BJ\b\u0010#\u001a\u00020\u0003H&J\b\u0010C\u001a\u00020\u0017H&J\u0012\u0010D\u001a\u00020\u001f2\b\u0010E\u001a\u0004\u0018\u00010\tH&J\u0010\u0010F\u001a\u00020\u00172\u0006\u0010G\u001a\u00020HH&J\u0010\u0010I\u001a\u00020\t2\u0006\u0010+\u001a\u00020,H&J\u0012\u0010J\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010K\u001a\u00020\u0003H&J\b\u0010L\u001a\u00020\u0017H&J\n\u0010M\u001a\u0004\u0018\u00010NH&J\n\u0010O\u001a\u0004\u0018\u00010PH&J\n\u0010Q\u001a\u0004\u0018\u00010RH&J\n\u0010S\u001a\u0004\u0018\u00010TH&J\n\u0010U\u001a\u0004\u0018\u00010VH&J\u0018\u0010W\u001a\u0002032\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[H&J\n\u0010\\\u001a\u0004\u0018\u00010]H&J\n\u0010^\u001a\u0004\u0018\u00010_H&J\n\u0010`\u001a\u0004\u0018\u00010aH&Jq\u0010b\u001a\u0004\u0018\u00010c2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020g2&\b\u0002\u0010h\u001a \u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00170i2\n\b\u0002\u0010j\u001a\u0004\u0018\u00010\u001f2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020l092\u0006\u0010m\u001a\u00020n2\u0006\u0010o\u001a\u00020pH&¢\u0006\u0002\u0010qJ\u0018\u0010r\u001a\u00020\u00172\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020\u001fH&J\u0018\u0010v\u001a\u00020\u00172\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020\u001fH&J8\u0010w\u001a\b\u0012\u0002\b\u0003\u0018\u00010x2\u0006\u0010X\u001a\u00020Y2\u0006\u0010y\u001a\u00020\u001f2\u0018\u0010z\u001a\u0014\u0012\u0004\u0012\u00020|\u0012\u0004\u0012\u00020}\u0012\u0004\u0012\u00020\u00170{H&J\u0012\u0010~\u001a\u0004\u0018\u00010\u007f2\u0006\u0010X\u001a\u00020YH&J\f\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001H&J\f\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001H&J\f\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001H&JR\u0010\u0086\u0001\u001a\u00020\u00172\u000b\b\u0002\u0010\u0087\u0001\u001a\u0004\u0018\u00010\t2\u000b\b\u0002\u0010\u0088\u0001\u001a\u0004\u0018\u00010\t2\u000b\b\u0002\u0010\u0089\u0001\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u000b\b\u0002\u0010\u008a\u0001\u001a\u0004\u0018\u00010\t2\u0007\u0010\u008b\u0001\u001a\u00020\tH&J:\u0010\u008c\u0001\u001a\u00020\u00172\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010l2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010[2\u0007\u0010\u008f\u0001\u001a\u00020\t2\u0007\u0010\u0090\u0001\u001a\u00020\t2\u0007\u0010\u0091\u0001\u001a\u00020\tH&¨\u0006\u0092\u0001"}, d2 = {"Lcom/larus/bmhome/chat/api/ILegacyChatUiService;", "", "realtimeCallEnabled", "", "editPos", "Lcom/larus/platform/model/EditPos;", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "conversationId", "", "(Lcom/larus/platform/model/EditPos;Lcom/larus/im/bean/bot/BotModel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enableSilence", "isEditable", "isContinuousTalk", "shouldCloseInstruction", "messageSendExt", "", "param", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Ljava/util/Map;", "getImgAttachInstructExt", "musicPlayerPausing", "", "pausing", "insertMultiQuestionReferenceFromInstruction", "extra", "", "message", "Lcom/larus/im/bean/message/Message;", "searchIndex", "", "scene", "insertMultiQuestionReference", "isReferenceAction", "isRecording", "adapter", "Lcom/larus/bmhome/list/ICoreMessageListAdapter;", "buildFullScreenEditTextView", "activity", "Landroidx/fragment/app/FragmentActivity;", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "imeHeight", "isImmerse", "bgImgColor", "voiceInputContent", "", "onClickSend", "Lkotlin/Function1;", "onUpdateInputText", "Lkotlin/Function3;", "onFold", "Lkotlin/Function0;", "inModify", "forceDarkMode", "targetContainer", "Landroid/view/ViewGroup;", "enableSetFullEditBackground", "inputFilters", "Landroid/text/InputFilter;", "fullInputBoxMobParams", "(Landroidx/fragment/app/FragmentActivity;Lcom/larus/im/bean/bot/BotModel;Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;Lcom/larus/ui/arch/context/external/VContext;Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;IZLjava/lang/Integer;Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;ZZLandroid/view/ViewGroup;Z[Landroid/text/InputFilter;Ljava/util/Map;)V", "stopRecording", "getSelectIndex", "parentMessageId", "startRealtimeCallD", "bean", "Lcom/larus/voicecall/api/bean/StartCallPayLoadBean;", "trackOnClickCallSpeakIcon", "isShowGpt4InputHintAndAnsweringText", "hasSubBenefitsFromStore", "invokeAppletSaveClick", "getWidgetCardClickHelper", "Lcom/larus/bmhome/chat/layout/holder/helper/api/WidgetCardClickHelper;", "observerManager", "Lcom/larus/bmhome/chat/api/ILegacyMessageObserver;", "containerAppreciableTrace", "Lcom/larus/bmhome/chat/api/IContainerAppreciableTrace;", "conversationListModel", "Lcom/larus/bmhome/chat/api/IConversationListModel;", "conversationFragmentAbility", "Lcom/larus/bmhome/chat/api/IConversationFragmentAbility;", "getConversationBrief", "context", "Landroid/content/Context;", "conversationData", "Lcom/larus/bmhome/chat/model/api/ConversationData;", "instructionSwitchHelper", "Lcom/larus/bmhome/instruction/IInstructionSwitch;", "pluginManagerDelegate", "Lcom/larus/bmhome/chat/auth/api/IPluginManager;", "messageCopyHelper", "Lcom/larus/bmhome/chat/layout/holder/helper/IMessageCopyHelper;", "createMessageAdapter", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "loader", "Lcom/larus/bmhome/social/page/datasource/prefetch/IPagingAutoLoader;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "msgActionCallback", "Lkotlin/Function4;", "immerseBgColor", "hostFragment", "Landroidx/fragment/app/Fragment;", "componentFeature", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "provider", "Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;", "(Lcom/larus/bmhome/social/page/datasource/prefetch/IPagingAutoLoader;Lcom/larus/bmhome/chat/ChatParam;Lkotlin/jvm/functions/Function4;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;)Lcom/larus/bmhome/chat/api/MessageAdapter;", "stubMessageList", "viewStub", "Landroid/view/ViewStub;", "id", "stubNestedScrollList", "createAwemeRecommendAdapterForWidget", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "coverWidth", "mobCardShow", "Lkotlin/Function2;", "Lcom/larus/bmhome/video/Content;", "Landroid/view/View;", "createSearchBoxView", "Lcom/larus/bmhome/chat/api/ISearchListBox;", "markdownSelectHelper", "Lcom/larus/bmhome/chat/api/IMarkDownSelectHelper;", "chatSendTrace", "Lcom/larus/bmhome/chat/api/IChatSendTrace;", "messageCellTrace", "Lcom/larus/bmhome/chat/api/IMessageCellTrace;", "mobDeepSearchButtonShoww", "currentPage", "previousPage", "messageId", "botId", "enterMethod", "handleConversationClick", "fragment", "data", "enterFrom", "currentPageName", "argPosition", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface ILegacyChatUiService {
    void A8(b3a.c r1);

    Map<String, String> B8();

    boolean C8(wq8.b r1);

    boolean D8(String r1);

    hc8.b E8();

    z F8();

    void G8();

    cf8.c H8();

    com.larus.bmhome.instruction.i I8();

    CharSequence J8(Context r1, a r2);

    v K8();

    void L8(FragmentActivity r1, BotModel r2, de8.c r3, t1a.b r4, com.larus.bmhome.chat.component.cvs.y r5, int r6, boolean r7, Integer r8, CharSequence r9, v2 r10, x2 r11, y2 r12, boolean r13, boolean r14, ViewGroup r15, boolean r16, InputFilter[] r17, Map r18);

    boolean M8(Map r1, Message r2, int r3);

    y N8();

    boolean O8(Map r1, Message r2, int r3, boolean r4);

    q0 P8(com.larus.bmhome.chat.deepsearch.component.f r1, ChatParam r2, com.larus.bmhome.chat.deepsearch.component.d r3, com.larus.bmhome.chat.deepsearch.component.e r4, ComponentFeature r5, com.larus.bmhome.chat.deepsearch.component.g r6);

    void Q8(ViewStub r1);

    void R8(Fragment r1, a r2, String r3, String r4);

    Map<String, String> S8(Pair<String, String>... r1);

    void T8(boolean r1);

    boolean U8(String r1);

    t V8();

    RecyclerView.Adapter W8(Context r1, int r2, com.larus.bmhome.chat.markdown.ugc.c r3);

    com.larus.bmhome.chat.layout.holder.helper.s0 X8();

    int d(String r1);

    boolean isRecording();

    boolean p8();

    boolean q8();

    a0 r8();

    c0 s8(Context r1);

    void stopRecording();

    s t8();

    String u8(t1a.b r1);

    Object v8(EditPos r1, BotModel r2, String r3, Continuation<? super Boolean> r4);

    void w8(String r1, String r2, String r3, String r4);

    void x8(ViewStub r1, int r2);

    boolean y8(BotModel r1, String r2, boolean r3, boolean r4);

    w z8();
}
