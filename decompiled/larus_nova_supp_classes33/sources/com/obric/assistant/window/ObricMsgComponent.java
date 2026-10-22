package com.obric.assistant.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.view.AbstractMessageBoxContainerView;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.common_ui.view.GradientMaskView;
import com.larus.im.bean.message.Message;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.impl.MessageApiImpl;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.base.interact.IObserveToken;
import com.obric.assistant.state.api.multitask.state.ObricInteractionStateType;
import com.obric.assistant.view.WindowFadingLayout;
import com.obric.assistant.window.materials.MaterialSceneType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000¼\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\b\u008d\u0001\u0099\u0001\u009c\u0001\u009f\u0001\u0018\u0000 Î\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0002Î\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\n\u0010\u0095\u0001\u001a\u00030\u0091\u0001H\u0002J\n\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0002J\n\u0010¡\u0001\u001a\u00030\u0097\u0001H\u0002J\n\u0010¢\u0001\u001a\u00030\u0097\u0001H\u0002J\n\u0010£\u0001\u001a\u00030\u0097\u0001H\u0002J\u0013\u0010¤\u0001\u001a\u00030\u0097\u00012\u0007\u0010¥\u0001\u001a\u00020mH\u0002J\u0017\u0010¦\u0001\u001a\u00030\u0097\u00012\u000b\b\u0002\u0010¥\u0001\u001a\u0004\u0018\u00010mH\u0002J\u0014\u0010§\u0001\u001a\u00030\u0097\u00012\b\u0010¨\u0001\u001a\u00030©\u0001H\u0002J\n\u0010ª\u0001\u001a\u00030\u0097\u0001H\u0016J\u0013\u0010«\u0001\u001a\u00030\u0097\u00012\u0007\u0010¬\u0001\u001a\u00020RH\u0016J\n\u0010\u00ad\u0001\u001a\u00030\u0097\u0001H\u0002J\u0013\u0010®\u0001\u001a\u00030\u0097\u00012\u0007\u0010¬\u0001\u001a\u00020RH\u0002J\u0013\u0010¯\u0001\u001a\u00030\u0097\u00012\u0007\u0010¬\u0001\u001a\u00020RH\u0002J\u0015\u0010°\u0001\u001a\u0005\u0018\u00010±\u00012\u0007\u0010¬\u0001\u001a\u00020RH\u0002J\n\u0010²\u0001\u001a\u00030\u0097\u0001H\u0016J&\u0010³\u0001\u001a\u00030\u0097\u00012\u0007\u0010´\u0001\u001a\u00020C2\u0007\u0010¬\u0001\u001a\u00020R2\b\u0010µ\u0001\u001a\u00030¶\u0001H\u0016J\t\u0010·\u0001\u001a\u00020\u000bH\u0002J\t\u0010¸\u0001\u001a\u00020\u000bH\u0002J\t\u0010¹\u0001\u001a\u00020\u000bH\u0002J\t\u0010º\u0001\u001a\u00020\u000bH\u0002J\u0015\u0010»\u0001\u001a\u00030\u0097\u00012\t\b\u0002\u0010¼\u0001\u001a\u00020qH\u0002J\n\u0010½\u0001\u001a\u00030\u0097\u0001H\u0016J\n\u0010¾\u0001\u001a\u00030\u0097\u0001H\u0016J\u0013\u0010¿\u0001\u001a\u00030\u0097\u00012\u0007\u0010À\u0001\u001a\u00020\u0003H\u0016J\u0015\u0010Á\u0001\u001a\u00030\u0097\u00012\t\u0010Â\u0001\u001a\u0004\u0018\u00010mH\u0002J\n\u0010Ã\u0001\u001a\u00030\u0097\u0001H\u0002J\n\u0010Ä\u0001\u001a\u00030\u0097\u0001H\u0016J\n\u0010Å\u0001\u001a\u00030\u0097\u0001H\u0016J\u0016\u0010Æ\u0001\u001a\u00030\u0097\u00012\n\u0010¨\u0001\u001a\u0005\u0018\u00010©\u0001H\u0016J\u0013\u0010Ç\u0001\u001a\u00030\u0097\u00012\u0007\u0010È\u0001\u001a\u00020qH\u0016J\u0014\u0010É\u0001\u001a\u00030\u0097\u00012\b\u0010Ê\u0001\u001a\u00030Ë\u0001H\u0016J\n\u0010Ì\u0001\u001a\u00030Í\u0001H\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0015\u001a\u0004\b\"\u0010#R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0015\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0015\u001a\u0004\b,\u0010-R\u001d\u0010/\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0015\u001a\u0004\b1\u00102R\u001d\u00104\u001a\u0004\u0018\u0001058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0015\u001a\u0004\b6\u00107R\u001d\u00109\u001a\u0004\u0018\u00010:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0015\u001a\u0004\b;\u0010<R\u0016\u0010>\u001a\u0004\u0018\u00010?8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u001d\u0010B\u001a\u0004\u0018\u00010C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010\u0015\u001a\u0004\bD\u0010ER\u001d\u0010G\u001a\u0004\u0018\u00010H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010\u0015\u001a\u0004\bI\u0010JR\u001d\u0010L\u001a\u0004\u0018\u00010M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\u0015\u001a\u0004\bN\u0010OR\u001d\u0010Q\u001a\u0004\u0018\u00010R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u0010\u0015\u001a\u0004\bS\u0010TR\u0016\u0010V\u001a\u0004\u0018\u00010M8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bW\u0010OR\u001d\u0010X\u001a\u0004\u0018\u00010M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010\u0015\u001a\u0004\bY\u0010OR\u0016\u0010[\u001a\u0004\u0018\u00010\\8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b]\u0010^R\u0016\u0010_\u001a\u0004\u0018\u00010`8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0016\u0010c\u001a\u0004\u0018\u00010C8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bd\u0010ER\u0016\u0010e\u001a\u0004\u0018\u00010C8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bf\u0010ER\u001d\u0010g\u001a\u0004\u0018\u00010R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bi\u0010\u0015\u001a\u0004\bh\u0010TR\u0016\u0010j\u001a\u0004\u0018\u00010R8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bk\u0010TR\u0010\u0010l\u001a\u0004\u0018\u00010mX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020qX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020qX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010s\u001a\b\u0012\u0002\b\u0003\u0018\u00010tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020vX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010w\u001a\u00020x8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b{\u0010\u0015\u001a\u0004\by\u0010zR\u001c\u0010|\u001a\u00020}8BX\u0082\u0084\u0002¢\u0006\r\n\u0005\b\u0080\u0001\u0010\u0015\u001a\u0004\b~\u0010\u007fR\u0018\u0010\u0081\u0001\u001a\u00030\u0082\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0010\u0010\u0085\u0001\u001a\u00030\u0086\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0087\u0001\u001a\u00030\u0088\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u008b\u0001\u0010\u0015\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0013\u0010\u008c\u0001\u001a\u00030\u008d\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008e\u0001R\u0011\u0010\u008f\u0001\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0092\u0001\u001a\u00030\u0091\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0013\u0010\u0098\u0001\u001a\u00030\u0099\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u009a\u0001R\u0013\u0010\u009b\u0001\u001a\u00030\u009c\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u009d\u0001R\u0013\u0010\u009e\u0001\u001a\u00030\u009f\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010 \u0001¨\u0006Ï\u0001"}, d2 = {"Lcom/obric/assistant/window/ObricMsgComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility$ChangeListener;", "Lcom/larus/im/bean/conversation/Conversation;", "Lcom/obric/assistant/interaction/base/interact/IObserveToken;", "Lcom/obric/assistant/window/ability/IObricMsgAbility;", "Lcom/obric/assistant/callback/IChatStyleChangedCallback;", "Lcom/obric/assistant/ability/chat/messagelist/IObricMessageListAbility;", "<init>", "()V", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "conversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "conversationAbility$delegate", "Lkotlin/Lazy;", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateAbility$delegate", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "clickTalkAbility", "Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "getClickTalkAbility", "()Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "clickTalkAbility$delegate", "specialInputAbility", "Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "getSpecialInputAbility", "()Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "specialInputAbility$delegate", "topFloatingButtonAbility", "Lcom/larus/bmhome/ability/IChatTopFloatingButtonAbility;", "getTopFloatingButtonAbility", "()Lcom/larus/bmhome/ability/IChatTopFloatingButtonAbility;", "topFloatingButtonAbility$delegate", "bottomFloatingButtonAbility", "Lcom/larus/bmhome/chat/component/bottom/floating/IChatBottomFloatingAbility;", "getBottomFloatingButtonAbility", "()Lcom/larus/bmhome/chat/component/bottom/floating/IChatBottomFloatingAbility;", "bottomFloatingButtonAbility$delegate", "chatInputUiCoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUiCoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUiCoreAbility$delegate", "shareAbility", "Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "getShareAbility", "()Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "shareAbility$delegate", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "chatRoot", "Landroid/view/ViewGroup;", "getChatRoot", "()Landroid/view/ViewGroup;", "chatRoot$delegate", "messageList", "Landroidx/recyclerview/widget/RecyclerView;", "getMessageList", "()Landroidx/recyclerview/widget/RecyclerView;", "messageList$delegate", "input", "Landroid/widget/FrameLayout;", "getInput", "()Landroid/widget/FrameLayout;", "input$delegate", "splitter", "Landroid/view/View;", "getSplitter", "()Landroid/view/View;", "splitter$delegate", "bottomLayout", "getBottomLayout", "messageListParent", "getMessageListParent", "messageListParent$delegate", "fastButtonIcon", "Landroid/widget/ImageView;", "getFastButtonIcon", "()Landroid/widget/ImageView;", "inputUiContract", "Lcom/larus/bmhome/ability/ChatInputUiContract;", "getInputUiContract", "()Lcom/larus/bmhome/ability/ChatInputUiContract;", "actionBarContainer", "getActionBarContainer", "inputAreaContainer", "getInputAreaContainer", "inputAreaContainerBg", "getInputAreaContainerBg", "inputAreaContainerBg$delegate", "shareLayout", "getShareLayout", "messageObserverConversationId", "", "messageListBottomMargin", "lastMessageListWidth", "isVisibleMessageBoxWidthUpdatePending", "", "pendingRefreshVisibleCardsOnAdapterChanged", "observedMessageListAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "latestKnownServerIndex", "", "portraitMessageListStrategy", "Lcom/obric/assistant/window/strategies/PortraitMessageListStrategy;", "getPortraitMessageListStrategy", "()Lcom/obric/assistant/window/strategies/PortraitMessageListStrategy;", "portraitMessageListStrategy$delegate", "landscapeMessageListStrategy", "Lcom/obric/assistant/window/strategies/LandscapeMessageListStrategy;", "getLandscapeMessageListStrategy", "()Lcom/obric/assistant/window/strategies/LandscapeMessageListStrategy;", "landscapeMessageListStrategy$delegate", "strategy", "Lcom/obric/assistant/window/strategies/api/BaseMessageListStrategy;", "getStrategy", "()Lcom/obric/assistant/window/strategies/api/BaseMessageListStrategy;", "maxRadius", "", "messageListTopFading", "Lcom/obric/assistant/view/WindowFadingLayout;", "getMessageListTopFading", "()Lcom/obric/assistant/view/WindowFadingLayout;", "messageListTopFading$delegate", "messageChildAttachListener", "com/obric/assistant/window/ObricMsgComponent$messageChildAttachListener$1", "Lcom/obric/assistant/window/ObricMsgComponent$messageChildAttachListener$1;", "autoIncreaseHelperBinding", "autoIncreaseHelperDelegate", "Lcom/obric/assistant/window/animation/ObricPageAutoIncreaseHelper;", "autoIncreaseHelper", "getAutoIncreaseHelper", "()Lcom/obric/assistant/window/animation/ObricPageAutoIncreaseHelper;", "createAutoIncreaseHelper", "recreateAutoIncreaseHelperIfNeeded", "", "messageListAdapterObserver", "com/obric/assistant/window/ObricMsgComponent$messageListAdapterObserver$1", "Lcom/obric/assistant/window/ObricMsgComponent$messageListAdapterObserver$1;", "selectModeCallback", "com/obric/assistant/window/ObricMsgComponent$selectModeCallback$1", "Lcom/obric/assistant/window/ObricMsgComponent$selectModeCallback$1;", "changeListener", "com/obric/assistant/window/ObricMsgComponent$changeListener$1", "Lcom/obric/assistant/window/ObricMsgComponent$changeListener$1;", "hideBackToLastViewedButton", "ensureMessageListAdapterObserver", "unregisterMessageListAdapterObserver", "consumePendingRefreshVisibleCards", "enterMethod", "updateItemOnDisplay", "checkCloseClickTalk", "msg", "Lcom/larus/im/bean/message/Message;", "onCreate", "onViewCreated", "view", "scheduleUpdateVisibleMessageBoxWidth", "scheduleUpdateMessageBoxWidth", "updateMessageBoxWidth", "findMessageBox", "Lcom/larus/bmhome/chat/layout/item/BaseMessageBox;", "initMessageList", "setLatestMessageBottomInset", "parent", "outRect", "Landroid/graphics/Rect;", "getInputAreaContainerVerticalPadding", "getActionBarContainerHeight", "getInputAreaContainerBgHeight", "getShareLayoutOccupiedHeight", "updateShareLayoutBottomMargin", "isSelectMode", "invalidateLatestMessageBottomInset", "onDestroy", "onChange", "new", "initLatestKnownServerIndex", "conversationId", "unregisterMessageObserver", "addItemDecoration", "interruptMoveAction", "onSendMessage", "onChatStyleChanged", "isChatWindow", "onPageStateChanged", "pageState", "Lcom/obric/assistant/data/ObricFloatChatPageState;", "getAutoDismissDelegate", "Lcom/obric/assistant/util/IAutoDismissDelegate;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMsgComponent extends BaseContentWidget implements com.larus.bmhome.chat.component.cvs.y.a<wc9.e>, IObserveToken, xha.b, hca.b, saa.a {
    public static final /* synthetic */ int T = 0;
    public final Lazy A;
    public final Lazy B;
    public String C;
    public final int D;
    public int E;
    public boolean F;
    public boolean G;
    public RecyclerView.Adapter<?> H;
    public long I;
    public final Lazy J;
    public final Lazy K;
    public final float L;
    public final Lazy M;
    public final ObricMsgComponent$messageChildAttachListener$1 N;
    public va8.l O;
    public yha.t P;
    public final ObricMsgComponent$messageListAdapterObserver$1 Q;
    public final b R;
    public final ObricMsgComponent$changeListener$1 S;
    public int m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b implements hca.e {
        public final /* synthetic */ ObricMsgComponent a;

        public b(ObricMsgComponent r1) {
            this.a = r1;
        }

        public final void onSelectModeChanged(boolean r5) {
            ObricMsgComponent r0 = this.a;
            int r1 = ObricMsgComponent.T;
            r0.H3(r5);
            this.a.P00();
            com.obric.assistant.util.p r2 = this.a.h3().c;
            r2.getClass();
            FLogger.a.i("AutoDismissDelegate", "onMessageSelectModeChanged active:" + r5);
            com.obric.assistant.util.p.u(r2, ObricInteractionStateType.MESSAGE_SELECT_MODE_ACTIVE, r5);
        }
    }

    public static final class c implements Function0<com.larus.bmhome.chat.component.cvs.y> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.cvs.y.class));
        }
    }

    public static final class d implements Function0<laa.d> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.d.class));
        }
    }

    public static final class e implements Function0<va8.m> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.m.class));
        }
    }

    public static final class f implements Function0<maa.e> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(maa.e.class));
        }
    }

    public static final class g implements Function0<laa.j> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.j.class));
        }
    }

    public static final class h implements Function0<va8.w> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.w.class));
        }
    }

    public static final class i implements Function0<ld8.n> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ld8.n.class));
        }
    }

    public static final class j implements Function0<va8.o> {
        public final /* synthetic */ AttachReceiver a;

        public j(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.o.class));
        }
    }

    public static final class k implements Function0<IChatMessageShareAbility> {
        public final /* synthetic */ AttachReceiver a;

        public k(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(IChatMessageShareAbility.class));
        }
    }

    static {
    }

    public final void r2(boolean r1) {
    }

    public final WindowFadingLayout B3() {
        return (WindowFadingLayout) this.M.getValue();
    }

    public final void D3() {
        this.I = Long.MIN_VALUE;
        String r0 = this.C;
        if (r0 != null) goto L5;
        return;
    L5:
        com.larus.im.d.e().unregisterOnMessageChangedObserver(r0, this.S);
        this.C = null;
    }

    /* JADX WARN: Type inference failed for: r1v12, types: [com.obric.assistant.window.m] */
    @Override // xha.b
    public final void Gi() {
        FLogger.a.i("ObricMsgComponent", "init message list");
        FrameLayout r0 = (FrameLayout) this.A.getValue();
        if (r0 == null) goto L12;
        ViewGroup.LayoutParams r4 = r0.getLayoutParams();
        if (r4 == null) goto L11;
        ViewGroup.LayoutParams r5 = (ConstraintLayout.LayoutParams) r4;
        ((ConstraintLayout.LayoutParams) r5).topToBottom = 2131381268;
        ((ConstraintLayout.LayoutParams) r5).bottomToBottom = 0;
        ((ConstraintLayout.LayoutParams) r5).bottomToTop = -1;
        FrameLayout r6 = (FrameLayout) this.A.getValue();
        if (r6 == null) goto L9;
        r6.setLayoutParams(r5);
    L9:
        r0.setLayoutParams(r5);
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L12:
        View r1 = (View) this.z.getValue();
        if (r1 == null) goto L19;
        ConstraintLayout.LayoutParams r7 = r1.getLayoutParams();
        if (r7 == null) goto L18;
        ConstraintLayout.LayoutParams r8 = r7;
        r8.topToTop = 0;
        r8.topToBottom = -1;
        r8.bottomToTop = 2131375324;
        r8.verticalChainStyle = 2;
        r8.verticalBias = 1.0f;
        r1.setLayoutParams(r8);
        goto L19
    L18:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L19:
        final RecyclerView r2 = z3();
        if (r2 != null) goto L22;
        return;
    L22:
        ViewParent r3 = r2.getParent();
        ImageView r9 = null;
        if ((r3 instanceof ViewGroup) == false) goto L25;
        ViewGroup r10 = (ViewGroup) r3;
    L26:
        if (r10 != null) goto L29;
        return;
    L29:
        if (Intrinsics.areEqual(r10, B3()) == true) goto L31;
        int r11 = r10.indexOfChild(r2);
        ViewGroup.LayoutParams r12 = r2.getLayoutParams();
        r10.removeView(r2);
        B3().removeAllViews();
        B3().addView(r2, new FrameLayout.LayoutParams(-1, -1));
        r10.addView(B3(), r11, r12);
    L31:
        WindowFadingLayout r13 = B3();
        int r14 = aia.f.a;
        r13.setBottomFadeHeight(c7.b(132));
        ViewParent r15 = B3().getParent();
        if ((r15 instanceof ViewGroup) == false) goto L34;
        ViewGroup r16 = (ViewGroup) r15;
    L36:
        if (r16 == null) goto L38;
        r16.setPadding(r16.getPaddingLeft(), r16.getPaddingTop(), r16.getPaddingRight(), c7.b(16));
    L38:
        WindowFadingLayout r17 = B3();
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        if (r18 == null) goto L50;
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
        r19.topMargin = c7.b(16);
        r17.setLayoutParams(r19);
        final ?? r20 = new m(this, r2);
        r2.addOnScrollListener(new ObricMsgComponent$initMessageList$5(r20));
        r2.addOnLayoutChangeListener(new n(r20));
        r2.post(new p(this, r2));
        ld8.n r21 = (ld8.n) this.t.getValue();
        if (r21 == null) goto L43;
        r9 = r21.G50();
    L43:
        if (r9 == null) goto L45;
        Lazy r22 = bia.g.a;
        bia.g.a(r9, true, MaterialSceneType.FLOATING_BG);
    L45:
        RecyclerView r23 = z3();
        if (r23 == null) goto L51;
        r23.setVerticalScrollBarEnabled(false);
        return;
    L51:
        return;
    L50:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L34:
        r16 = null;
        goto L36
    L25:
        r10 = null;
        goto L26
    }

    public final yha.t h3() {
        yha.t r0 = this.P;
        if (r0 != null) goto L6;
        va8.l r1 = m3();
        this.O = r1;
        yha.t r2 = new yha.t(r1, (laa.d) this.o.getValue(), new com.obric.assistant.window.d(this), new o(this));
        this.P = r2;
        return r2;
    L6:
        return r0;
    }

    public final va8.l m3() {
        va8.m r0 = (va8.m) this.p.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.iX();
    }

    public final va8.c p3() {
        va8.o r0 = (va8.o) this.u.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Uv();
    }

    public final RecyclerView z3() {
        return (RecyclerView) this.x.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v41, types: [com.obric.assistant.window.ObricMsgComponent$messageChildAttachListener$1] */
    /* JADX WARN: Type inference failed for: r0v42, types: [com.obric.assistant.window.ObricMsgComponent$messageListAdapterObserver$1] */
    /* JADX WARN: Type inference failed for: r0v44, types: [com.obric.assistant.window.ObricMsgComponent$changeListener$1] */
    public ObricMsgComponent() {
        this.m = 2131379994;
        this.n = LazyKt.lazy(new c(this));
        this.o = LazyKt.lazy(new d(this));
        this.p = LazyKt.lazy(new e(this));
        this.q = LazyKt.lazy(new f(this));
        this.r = LazyKt.lazy(new g(this));
        this.s = LazyKt.lazy(new h(this));
        this.t = LazyKt.lazy(new i(this));
        this.u = LazyKt.lazy(new j(this));
        this.v = LazyKt.lazy(new k(this));
        this.w = LazyKt.lazy(new u(this));
        this.x = LazyKt.lazy(new v(this));
        this.y = LazyKt.lazy(new w(this));
        this.z = LazyKt.lazy(new x(this));
        this.A = LazyKt.lazy(new com.obric.assistant.window.e(this));
        this.B = LazyKt.lazy(new com.obric.assistant.window.f(this));
        this.D = i5.J();
        this.I = Long.MIN_VALUE;
        this.J = LazyKt.lazy(new com.obric.assistant.window.g(this));
        this.K = LazyKt.lazy(new com.obric.assistant.window.h(this));
        this.L = i5.Q();
        this.M = LazyKt.lazy(new com.obric.assistant.window.i(this));
        this.N = new ObricMsgComponent$messageChildAttachListener$1(this);
        this.Q = new ObricMsgComponent$messageListAdapterObserver$1(this);
        this.R = new b(this);
        this.S = new ObricMsgComponent$changeListener$1(this);
    }

    public final void E3() {
        RecyclerView r0 = z3();
        if (r0 == null) goto L44;
        RecyclerView.Adapter r1 = r0.getAdapter();
        if (r1 == null) goto L48;
        RecyclerView r2 = z3();
        LinearLayoutManager r3 = null;
        if (r2 == null) goto L10;
        RecyclerView.LayoutManager r4 = r2.getLayoutManager();
    L12:
        if ((r4 instanceof LinearLayoutManager) == false) goto L14;
        r3 = (LinearLayoutManager) r4;
    L14:
        if (r3 != null) goto L16;
        return;
    L16:
        int r5 = r3.findFirstVisibleItemPosition();
        int r6 = r3.findLastVisibleItemPosition();
        if (r5 == (-1)) goto L45;
        if (r6 == (-1)) goto L49;
        boolean r7 = false;
        IntRange r8 = RangesKt.until(0, r1.getItemCount());
        if (r5 > r6) goto L46;
        int r9 = r8.getFirst();
        if (r5 > r8.getLast()) goto L26;
        if (r9 > r5) goto L26;
        boolean r10 = true;
    L27:
        if (r10 == false) goto L47;
        int r11 = r8.getFirst();
        if (r6 > r8.getLast()) goto L32;
        if (r11 > r6) goto L32;
        boolean r12 = true;
    L33:
        if (r12 == false) goto L50;
        RecyclerView r13 = z3();
        if (r13 != null) goto L38;
    L40:
        if (r7 == false) goto L42;
        return;
    L42:
        r1.notifyItemRangeChanged(r5 + 1, r6 - r5);
        return;
    L38:
        if (r13.isComputingLayout() != true) goto L40;
        r7 = true;
        goto L40
    L50:
        return;
    L32:
        r12 = false;
        goto L33
    L47:
        return;
    L26:
        r10 = false;
        goto L27
    L46:
        return;
    L49:
        return;
    L45:
        return;
    L10:
        r4 = null;
        goto L12
    L48:
        return;
    }

    @Override // xha.b
    public final void P00() {
        RecyclerView r0 = z3();
        if (r0 == null) goto L6;
        r0.post(new com.obric.assistant.window.j(this));
        return;
    }

    public final void Y2() {
        RecyclerView r0 = z3();
        if (r0 == null) goto L14;
        RecyclerView.Adapter<?> r1 = r0.getAdapter();
        if (r1 == null) goto L15;
        RecyclerView.Adapter<?> r2 = this.H;
        if (r2 != r1) goto L10;
        return;
    L10:
        if (r2 == null) goto L12;
        r2.unregisterAdapterDataObserver(this.Q);
    L12:
        this.H = r1;
        r1.registerAdapterDataObserver(this.Q);
        return;
    L15:
        return;
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        com.larus.bmhome.chat.component.cvs.y r0 = (com.larus.bmhome.chat.component.cvs.y) this.n.getValue();
        if (r0 == null) goto L5;
        String r1 = r0.Y1();
    L6:
        C3(r1);
        com.larus.bmhome.chat.component.cvs.y r2 = (com.larus.bmhome.chat.component.cvs.y) this.n.getValue();
        if (r2 == null) goto L9;
        com.larus.bmhome.chat.component.cvs.y.b.b(r2, this);
    L9:
        IAssistantInteractionServiceKt.getInteractionStateService().setAutoIncreaseWindowObserver(this, new q(this));
        laa.d r3 = (laa.d) this.o.getValue();
        if (r3 == null) goto L12;
        r3.HU(this);
    L12:
        IChatMessageShareAbility r4 = (IChatMessageShareAbility) this.v.getValue();
        if (r4 == null) goto L16;
        r4.kN(this.R);
        return;
    L16:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onDestroy() {
        D3();
        com.larus.bmhome.chat.component.cvs.y r0 = (com.larus.bmhome.chat.component.cvs.y) this.n.getValue();
        if (r0 == null) goto L5;
        r0.lQ(this);
    L5:
        IAssistantInteractionServiceKt.getInteractionStateService().removeAutoIncreaseWindowObserver(this);
        laa.d r1 = (laa.d) this.o.getValue();
        if (r1 == null) goto L8;
        r1.AN(this);
    L8:
        IChatMessageShareAbility r2 = (IChatMessageShareAbility) this.v.getValue();
        if (r2 == null) goto L11;
        r2.cG(this.R);
    L11:
        RecyclerView r3 = z3();
        if (r3 == null) goto L14;
        r3.removeOnChildAttachStateChangeListener(this.N);
    L14:
        RecyclerView.Adapter<?> r4 = this.H;
        if (r4 == null) goto L17;
        r4.unregisterAdapterDataObserver(this.Q);
    L17:
        this.H = null;
        yha.t r5 = this.P;
        if (r5 == null) goto L20;
        r5.j();
    L20:
        this.O = null;
        this.P = null;
    }

    @Override // xha.b
    public final void ti() {
        h3();
        FLogger.a.i("ObricPageAutoIncreaseHelper", "interruptMoveAction");
    }

    @Override // xha.b
    public final yha.t u30() {
        return h3();
    }

    @Override // xha.b
    public final void yg() {
        yha.t r0 = h3();
        if (r0.d != Long.MAX_VALUE) goto L5;
        r0.d = xg9.b.a().getLong("last_msg_create_time", Long.MAX_VALUE);
    L5:
        r0.w();
    }

    public final int U2() {
        return this.m;
    }

    public final void C3(String r6) {
        this.I = Long.MIN_VALUE;
        MessageApiImpl r0 = MessageApiImpl.a;
        Message r1 = MessageApiImpl.c();
        if (r1 != null) goto L5;
        return;
    L5:
        if (r6 != null) goto L7;
    L9:
        Long r7 = Long.valueOf(r1.getServerIndex());
        if (r7.longValue() == (-1)) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == true) goto L16;
        r7 = null;
    L16:
        if (r7 == null) goto L19;
        this.I = r7.longValue();
        return;
    L19:
        return;
    L12:
        r2 = false;
        goto L13
    L7:
        if (Intrinsics.areEqual(r1.getConversationId(), r6) == true) goto L9;
    }

    @Override // xha.b
    public final void F1(Message r2) {
        h3().q(null);
    }

    public final void G3(View r3) {
        com.larus.bmhome.chat.layout.item.i r1 = null;
        if ((r3 instanceof AbstractMessageBoxContainerView) == false) goto L5;
        AbstractMessageBoxContainerView r0 = (AbstractMessageBoxContainerView) r3;
    L6:
        if (r0 == null) goto L13;
        View r2 = r0.getBoxView();
        if (r2 == null) goto L13;
        if ((r2 instanceof com.larus.bmhome.chat.layout.item.i) == false) goto L15;
        r1 = (com.larus.bmhome.chat.layout.item.i) r2;
    L15:
        if (r1 != null) goto L18;
        return;
    L18:
        if (s1a.a.d(this) == false) goto L20;
        eia.o r4 = (dia.c) this.K.getValue();
    L21:
        r4.c(r1);
        return;
    L20:
        r4 = (dia.g) this.J.getValue();
    L13:
        if ((r3 instanceof com.larus.bmhome.chat.layout.item.i) == false) goto L15;
        r1 = (com.larus.bmhome.chat.layout.item.i) r3;
        goto L15
    L5:
        r0 = null;
        goto L6
    }

    public final void H3(boolean r6) {
        if (s1a.a.e(this) == true) goto L5;
        return;
    L5:
        ViewGroup r0 = (ViewGroup) this.w.getValue();
        ViewGroup.MarginLayoutParams r1 = null;
        if (r0 == null) goto L12;
        View r2 = r0.findViewById(2131386095);
        if (r2 == null) goto L12;
        if ((r2 instanceof ViewStub) == true) goto L12;
    L13:
        if (r2 != null) goto L15;
        return;
    L15:
        boolean r3 = false;
        if (r6 == false) goto L22;
        int r7 = aia.d.a;
        ViewGroup r8 = (ViewGroup) this.w.getValue();
        va8.l r4 = m3();
        if (r4 == null) goto L20;
        FrameLayout r5 = r4.z8();
    L21:
        int r9 = RangesKt.coerceAtLeast(aia.d.a(r8, r5), 56);
    L23:
        ViewGroup.LayoutParams r10 = r2.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L26;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
    L27:
        if (r11 != null) goto L29;
    L31:
        if (r3 == false) goto L33;
        return;
    L33:
        ViewGroup.LayoutParams r12 = r2.getLayoutParams();
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == false) goto L36;
        r1 = (ViewGroup.MarginLayoutParams) r12;
    L36:
        if (r1 != null) goto L38;
        return;
    L38:
        r1.bottomMargin = r9;
        r2.setLayoutParams(r1);
        return;
    L29:
        if (r11.bottomMargin != r9) goto L31;
        r3 = true;
        goto L31
    L26:
        r11 = null;
        goto L27
    L20:
        r5 = null;
        goto L21
    L22:
        r9 = 0;
    L12:
        r2 = null;
        goto L13
    }

    public final void X2(int r1) {
        this.m = r1;
    }

    public final void c(Object r4) {
        wc9.e r5 = (wc9.e) r4;
        Intrinsics.checkNotNullParameter(r5, "new");
        if (ic8.n.v(r5) == true) goto L5;
        D3();
        return;
    L5:
        if (Intrinsics.areEqual(this.C, r5.a) == true) goto L11;
        D3();
        C3(r5.a);
        com.larus.im.d.e().registerOnMessageChangedObserver(r5.a, this.S);
        this.C = r5.a;
        return;
    }

    public final void onViewCreated(View r8) {
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r8, "view");
        FLogger r9 = FLogger.a;
        r9.i("ObricMsgComponent", "onViewCreated, " + hashCode());
        yha.t r0 = this.P;
        if (r0 != null) goto L5;
    L7:
        va8.l r2 = this.O;
        if (r0 == null) goto L10;
        r0.j();
    L10:
        va8.l r1 = m3();
        this.O = r1;
        this.P = new yha.t(r1, (laa.d) this.o.getValue(), new com.obric.assistant.window.d(this), new o(this));
        StringBuilder r3 = new StringBuilder("recreateAutoIncreaseHelperIfNeeded, previousBinding=");
        r3.append(r2);
        r3.append(", currentBinding=");
        r3.append(this.O);
        r3.append(", messageList=");
        va8.l r4 = this.O;
        if (r4 == null) goto L13;
        RecyclerView r5 = r4.getMessageList();
    L14:
        r3.append(r5);
        r9.i("ObricMsgComponent", r3.toString());
    L15:
        Y2();
        RecyclerView r10 = z3();
        if (r10 == null) goto L18;
        r10.addOnChildAttachStateChangeListener(this.N);
    L18:
        RecyclerView r11 = z3();
        if (r11 == null) goto L21;
        r11.addOnLayoutChangeListener(new t(this));
    L21:
        RecyclerView r12 = z3();
        if (r12 != null) goto L25;
        return;
    L25:
        if (this.F == true) goto L30;
        this.F = true;
        r12.post(new l(this));
        return;
    L30:
        return;
    L13:
        r5 = null;
        goto L14
    L5:
        if (this.O == null) goto L7;
        goto L7
    }

    public final void x1(ObricFloatChatPageState r3) {
        Intrinsics.checkNotNullParameter(r3, "pageState");
        Intrinsics.checkNotNullParameter(r3, "pageState");
        yha.t r1 = h3();
        Intrinsics.checkNotNullParameter(r3, "pageState");
        r1.c.o(r3);
        ObricFloatChatPageData.Companion.getClass();
        if ((r3 instanceof vda.a) == false) goto L5;
    L12:
        h3().v("");
        return;
    L5:
        if ((r3 instanceof vda.b) == false) goto L9;
        if (ObricFloatChatPageData.a.e(r3) == true) goto L12;
    L9:
        if ((r3 instanceof vda.d) == true) goto L12;
        if ((r3 instanceof vda.f) == true) goto L12;
    }

    public final void wM(ViewGroup r8, View r9, Rect r10) {
        Intrinsics.checkNotNullParameter(r8, "parent");
        Intrinsics.checkNotNullParameter(r9, "view");
        Intrinsics.checkNotNullParameter(r10, "outRect");
        if ((r8 instanceof RecyclerView) == true) goto L6;
        return;
    L6:
        if (((RecyclerView) r8).getChildAdapterPosition(r9) == 0) goto L8;
        return;
    L8:
        if (s1a.a.d(this) == true) goto L10;
        int r11 = this.D;
    L11:
        IChatMessageShareAbility r12 = (IChatMessageShareAbility) this.v.getValue();
        boolean r0 = true;
        if (r12 != null) goto L14;
    L16:
        boolean r13 = false;
    L17:
        ConstraintLayout r2 = null;
        if (r13 == false) goto L62;
        ViewGroup r3 = (ViewGroup) this.w.getValue();
        if (r3 == null) goto L26;
        View r4 = r3.findViewById(2131386095);
        if (r4 == null) goto L26;
        if ((r4 instanceof ViewStub) == true) goto L26;
    L27:
        if (r4 != null) goto L30;
    L34:
        int r1 = 0;
    L130:
        if (r13 == true) goto L133;
        int r14 = aia.f.a;
        r1 = RangesKt.coerceAtLeast(((r11 + r1) + 56) - c7.b(16), 0);
    L133:
        r10.bottom = r1;
        return;
    L30:
        if (r4.getVisibility() != 0) goto L32;
        boolean r5 = true;
    L33:
        if (r5 == false) goto L34;
        Integer r6 = Integer.valueOf(r4.getHeight());
        if (r6.intValue() <= 0) goto L38;
        boolean r7 = true;
    L39:
        if (r7 == true) goto L42;
        r6 = null;
    L42:
        if (r6 != null) goto L52;
        r6 = Integer.valueOf(r4.getMeasuredHeight());
        if (r6.intValue() > 0) goto L48;
        r0 = false;
    L48:
        if (r0 == true) goto L51;
        r6 = null;
    L51:
        if (r6 != null) goto L52;
        int r15 = 0;
    L54:
        ViewGroup.LayoutParams r16 = r4.getLayoutParams();
        if ((r16 instanceof ViewGroup.MarginLayoutParams) == false) goto L57;
        r2 = (ViewGroup.MarginLayoutParams) r16;
    L57:
        if (r2 == null) goto L59;
        int r17 = ((ViewGroup.MarginLayoutParams) r2).bottomMargin;
    L60:
        r1 = r15 + r17;
        goto L130
    L59:
        r17 = 0;
    L52:
        r15 = r6.intValue();
        goto L54
    L38:
        r7 = false;
        goto L39
    L32:
        r5 = false;
    L26:
        r4 = null;
        goto L27
    L62:
        if (s1a.a.d(this) == true) goto L94;
        com.larus.bmhome.chat.component.bottom.core.a r18 = p3();
        if (r18 == null) goto L67;
        GradientMaskView r19 = r18.a();
    L68:
        if (r19 == null) goto L94;
        if (r19.getVisibility() != 0) goto L73;
        boolean r20 = true;
    L74:
        if (r20 == false) goto L94;
        Integer r21 = Integer.valueOf(r19.getHeight());
        if (r21.intValue() <= 0) goto L79;
        boolean r22 = true;
    L80:
        if (r22 == true) goto L83;
        r21 = null;
    L83:
        if (r21 == null) goto L85;
        int r23 = r21.intValue();
    L95:
        View r24 = (View) this.B.getValue();
        if (r24 != null) goto L99;
    L122:
        int r25 = 0;
    L123:
        int r26 = r23 + r25;
        com.larus.bmhome.chat.component.bottom.core.a r27 = p3();
        if (r27 == null) goto L126;
        r2 = r27.h();
    L126:
        if (r2 != null) goto L128;
        int r28 = 0;
    L129:
        r1 = r28 + r26;
        goto L130
    L128:
        r28 = r2.getPaddingTop() + r2.getPaddingBottom();
        goto L129
    L99:
        if (r24.getVisibility() != 0) goto L101;
        boolean r29 = true;
    L102:
        if (r29 == false) goto L122;
        Integer r30 = Integer.valueOf(r24.getHeight());
        if (r30.intValue() <= 0) goto L107;
        boolean r31 = true;
    L108:
        if (r31 == true) goto L111;
        r30 = null;
    L111:
        if (r30 == null) goto L113;
        r25 = r30.intValue();
        goto L123
    L113:
        Integer r32 = Integer.valueOf(r24.getMeasuredHeight());
        if (r32.intValue() > 0) goto L117;
        r0 = false;
    L117:
        if (r0 == true) goto L120;
        r32 = null;
    L120:
        if (r32 == null) goto L122;
        r25 = r32.intValue();
        goto L123
    L107:
        r31 = false;
        goto L108
    L101:
        r29 = false;
        goto L102
    L85:
        Integer r33 = Integer.valueOf(r19.getMeasuredHeight());
        if (r33.intValue() <= 0) goto L88;
        boolean r34 = true;
    L89:
        if (r34 == true) goto L92;
        r33 = null;
    L92:
        if (r33 == null) goto L94;
        r23 = r33.intValue();
        goto L95
    L88:
        r34 = false;
        goto L89
    L79:
        r22 = false;
        goto L80
    L73:
        r20 = false;
        goto L74
    L67:
        r19 = null;
    L94:
        r23 = 0;
        goto L95
    L14:
        if (r12.H1() != true) goto L16;
        r13 = true;
        goto L17
    L10:
        int r35 = aia.f.a;
        r11 = c7.b(4);
        goto L11
    }
}
