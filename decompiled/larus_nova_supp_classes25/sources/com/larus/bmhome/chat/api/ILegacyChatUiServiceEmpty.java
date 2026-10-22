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
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import wh8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000Ì\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ*\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016JE\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00122*\u0010\u0013\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00150\u0014\"\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0015H\u0016¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J8\u0010\u001b\u001a\u00020\u00052\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u000bH\u0016J@\u0010#\u001a\u00020\u00052\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u000b2\u0006\u0010$\u001a\u00020\u0005H\u0016J\u0012\u0010%\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010'H\u0016Jå\u0001\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020*2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020!2\u0006\u00102\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u00010!2\u0006\u00104\u001a\u0002052\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0019072\u001e\u00108\u001a\u001a\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0019092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00190;2\u0006\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020\u00052\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010\u00142\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0016¢\u0006\u0002\u0010DJ\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010E\u001a\u00020\u0019H\u0016J\u0012\u0010F\u001a\u00020!2\b\u0010G\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010H\u001a\u00020\u00192\u0006\u0010I\u001a\u00020JH\u0016J\u0010\u0010K\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020.H\u0016J\u0012\u0010L\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010M\u001a\u00020\u0005H\u0016J\b\u0010N\u001a\u00020\u0019H\u0016J\n\u0010O\u001a\u0004\u0018\u00010PH\u0016J\n\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\n\u0010S\u001a\u0004\u0018\u00010TH\u0016J\n\u0010U\u001a\u0004\u0018\u00010VH\u0016J\n\u0010W\u001a\u0004\u0018\u00010XH\u0016J\u0018\u0010Y\u001a\u0002052\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]H\u0016J\n\u0010^\u001a\u0004\u0018\u00010_H\u0016J\n\u0010`\u001a\u0004\u0018\u00010aH\u0016J\n\u0010b\u001a\u0004\u0018\u00010cH\u0016Jm\u0010d\u001a\u0004\u0018\u00010e2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020i2$\u0010j\u001a \u0012\u0004\u0012\u00020e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190k2\b\u0010l\u001a\u0004\u0018\u00010!2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020n0;2\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020rH\u0016¢\u0006\u0002\u0010sJ\u0018\u0010t\u001a\u00020\u00192\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020!H\u0016J\u0018\u0010x\u001a\u00020\u00192\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020!H\u0016J8\u0010y\u001a\b\u0012\u0002\b\u0003\u0018\u00010z2\u0006\u0010Z\u001a\u00020[2\u0006\u0010{\u001a\u00020!2\u0018\u0010|\u001a\u0014\u0012\u0004\u0012\u00020~\u0012\u0004\u0012\u00020\u007f\u0012\u0004\u0012\u00020\u00190}H\u0016J\u0014\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u00012\u0006\u0010Z\u001a\u00020[H\u0016J\f\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u0016J\f\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0016J\f\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0016JH\u0010\u0088\u0001\u001a\u00020\u00192\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u000b2\u0007\u0010\u008d\u0001\u001a\u00020\u000bH\u0016J:\u0010\u008e\u0001\u001a\u00020\u00192\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010n2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010]2\u0007\u0010\u0091\u0001\u001a\u00020\u000b2\u0007\u0010\u0092\u0001\u001a\u00020\u000b2\u0007\u0010\u0093\u0001\u001a\u00020\u000bH\u0016¨\u0006\u0094\u0001"}, d2 = {"Lcom/larus/bmhome/chat/api/ILegacyChatUiServiceEmpty;", "Lcom/larus/bmhome/chat/api/ILegacyChatUiService;", "<init>", "()V", "realtimeCallEnabled", "", "editPos", "Lcom/larus/platform/model/EditPos;", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "conversationId", "", "(Lcom/larus/platform/model/EditPos;Lcom/larus/im/bean/bot/BotModel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enableSilence", "isEditable", "isContinuousTalk", "shouldCloseInstruction", "messageSendExt", "", "param", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Ljava/util/Map;", "getImgAttachInstructExt", "musicPlayerPausing", "", "pausing", "insertMultiQuestionReferenceFromInstruction", "extra", "", "message", "Lcom/larus/im/bean/message/Message;", "searchIndex", "", "scene", "insertMultiQuestionReference", "isReferenceAction", "isRecording", "adapter", "Lcom/larus/bmhome/list/ICoreMessageListAdapter;", "buildFullScreenEditTextView", "activity", "Landroidx/fragment/app/FragmentActivity;", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "imeHeight", "isImmerse", "bgImgColor", "voiceInputContent", "", "onClickSend", "Lkotlin/Function1;", "onUpdateInputText", "Lkotlin/Function3;", "onFold", "Lkotlin/Function0;", "inModify", "forceDarkMode", "targetContainer", "Landroid/view/ViewGroup;", "enableSetFullEditBackground", "inputFilters", "Landroid/text/InputFilter;", "fullInputBoxMobParams", "(Landroidx/fragment/app/FragmentActivity;Lcom/larus/im/bean/bot/BotModel;Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;Lcom/larus/ui/arch/context/external/VContext;Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;IZLjava/lang/Integer;Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;ZZLandroid/view/ViewGroup;Z[Landroid/text/InputFilter;Ljava/util/Map;)V", "stopRecording", "getSelectIndex", "parentMessageId", "startRealtimeCallD", "bean", "Lcom/larus/voicecall/api/bean/StartCallPayLoadBean;", "trackOnClickCallSpeakIcon", "isShowGpt4InputHintAndAnsweringText", "hasSubBenefitsFromStore", "invokeAppletSaveClick", "getWidgetCardClickHelper", "Lcom/larus/bmhome/chat/layout/holder/helper/api/WidgetCardClickHelper;", "observerManager", "Lcom/larus/bmhome/chat/api/ILegacyMessageObserver;", "containerAppreciableTrace", "Lcom/larus/bmhome/chat/api/IContainerAppreciableTrace;", "conversationListModel", "Lcom/larus/bmhome/chat/api/IConversationListModel;", "conversationFragmentAbility", "Lcom/larus/bmhome/chat/api/IConversationFragmentAbility;", "getConversationBrief", "context", "Landroid/content/Context;", "conversationData", "Lcom/larus/bmhome/chat/model/api/ConversationData;", "instructionSwitchHelper", "Lcom/larus/bmhome/instruction/IInstructionSwitch;", "pluginManagerDelegate", "Lcom/larus/bmhome/chat/auth/api/IPluginManager;", "messageCopyHelper", "Lcom/larus/bmhome/chat/layout/holder/helper/IMessageCopyHelper;", "createMessageAdapter", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "loader", "Lcom/larus/bmhome/social/page/datasource/prefetch/IPagingAutoLoader;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "msgActionCallback", "Lkotlin/Function4;", "immerseBgColor", "hostFragment", "Landroidx/fragment/app/Fragment;", "componentFeature", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "provider", "Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;", "(Lcom/larus/bmhome/social/page/datasource/prefetch/IPagingAutoLoader;Lcom/larus/bmhome/chat/ChatParam;Lkotlin/jvm/functions/Function4;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;)Lcom/larus/bmhome/chat/api/MessageAdapter;", "stubMessageList", "viewStub", "Landroid/view/ViewStub;", "id", "stubNestedScrollList", "createAwemeRecommendAdapterForWidget", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "coverWidth", "mobCardShow", "Lkotlin/Function2;", "Lcom/larus/bmhome/video/Content;", "Landroid/view/View;", "createSearchBoxView", "Lcom/larus/bmhome/chat/api/ISearchListBox;", "markdownSelectHelper", "Lcom/larus/bmhome/chat/api/IMarkDownSelectHelper;", "chatSendTrace", "Lcom/larus/bmhome/chat/api/IChatSendTrace;", "messageCellTrace", "Lcom/larus/bmhome/chat/api/IMessageCellTrace;", "mobDeepSearchButtonShoww", "currentPage", "previousPage", "messageId", "botId", "enterMethod", "handleConversationClick", "fragment", "data", "enterFrom", "currentPageName", "argPosition", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ILegacyChatUiServiceEmpty implements ILegacyChatUiService {
    public static final ILegacyChatUiServiceEmpty a = null;

    static {
        a = new ILegacyChatUiServiceEmpty();
    }

    private ILegacyChatUiServiceEmpty() {
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final void A8(b3a.c r2) {
        Intrinsics.checkNotNullParameter(r2, "bean");
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final boolean C8(wq8.b r1) {
        return false;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final boolean D8(String r1) {
        return false;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final hc8.b E8() {
        return null;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final z F8() {
        return null;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final void G8() {
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final cf8.c H8() {
        return null;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final com.larus.bmhome.instruction.i I8() {
        return null;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final CharSequence J8(Context r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "conversationData");
        return "";
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final v K8() {
        return null;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final void L8(FragmentActivity r3, BotModel r4, de8.c r5, t1a.b r6, com.larus.bmhome.chat.component.cvs.y r7, int r8, boolean r9, Integer r10, CharSequence r11, v2 r12, x2 r13, y2 r14, boolean r15, boolean r16, ViewGroup r17, boolean r18, InputFilter[] r19, Map r20) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r6, "vContext");
        Intrinsics.checkNotNullParameter(r11, "voiceInputContent");
        Intrinsics.checkNotNullParameter(r12, "onClickSend");
        Intrinsics.checkNotNullParameter(r13, "onUpdateInputText");
        Intrinsics.checkNotNullParameter(r14, "onFold");
        Intrinsics.checkNotNullParameter(r20, "fullInputBoxMobParams");
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final boolean M8(Map r1, Message r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "extra");
        return false;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final y N8() {
        return null;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final boolean O8(Map r1, Message r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "extra");
        return false;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final q0 P8(com.larus.bmhome.chat.deepsearch.component.f r2, ChatParam r3, com.larus.bmhome.chat.deepsearch.component.d r4, com.larus.bmhome.chat.deepsearch.component.e r5, ComponentFeature r6, com.larus.bmhome.chat.deepsearch.component.g r7) {
        Intrinsics.checkNotNullParameter(r2, "loader");
        Intrinsics.checkNotNullParameter(r3, "chatParam");
        Intrinsics.checkNotNullParameter(r4, "msgActionCallback");
        Intrinsics.checkNotNullParameter(r5, "hostFragment");
        Intrinsics.checkNotNullParameter(r6, "componentFeature");
        Intrinsics.checkNotNullParameter(r7, "provider");
        return null;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final void Q8(ViewStub r2) {
        Intrinsics.checkNotNullParameter(r2, "viewStub");
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final void R8(Fragment r1, a r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter("chat_list", "enterFrom");
        Intrinsics.checkNotNullParameter(r3, "currentPageName");
        Intrinsics.checkNotNullParameter(r4, "argPosition");
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final void T8(boolean r1) {
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final boolean U8(String r1) {
        return false;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final t V8() {
        return null;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final RecyclerView.Adapter W8(Context r1, int r2, com.larus.bmhome.chat.markdown.ugc.c r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r3, "mobCardShow");
        return null;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final com.larus.bmhome.chat.layout.holder.helper.s0 X8() {
        return null;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final int d(String r1) {
        return 0;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final boolean isRecording() {
        return false;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final boolean p8() {
        return false;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final boolean q8() {
        return false;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final a0 r8() {
        return null;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final c0 s8(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return null;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final void stopRecording() {
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final s t8() {
        return null;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final String u8(t1a.b r2) {
        Intrinsics.checkNotNullParameter(r2, "vContext");
        return "";
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final void w8(String r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter("feedback", "enterMethod");
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final void x8(ViewStub r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "viewStub");
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final boolean y8(BotModel r1, String r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        return false;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final w z8() {
        return null;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final Map<String, String> B8() {
        return MapsKt.emptyMap();
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final Map<String, String> S8(Pair<String, String>... r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
        return MapsKt.emptyMap();
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final Object v8(EditPos r1, BotModel r2, String r3, Continuation<? super Boolean> r4) {
        return Boxing.boxBoolean(false);
    }
}
