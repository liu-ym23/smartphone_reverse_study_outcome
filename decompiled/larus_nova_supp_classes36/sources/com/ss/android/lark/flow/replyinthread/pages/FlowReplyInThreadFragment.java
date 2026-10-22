package com.ss.android.lark.flow.replyinthread.pages;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.extension.chat_window.TitleBarActionKey;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollScene;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.MessageListAnimationContainer;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.CoreMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.Channel;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.flow.chat.databinding.FragmentFlowReplyInThreadDetailBinding;
import com.ss.android.lark.flow.chat.statistics.perf.DoubaoReplyLatencyTracker$markTracePageInvisible$1;
import com.ss.android.lark.flow.chat.statistics.perf.DoubaoReplyLatencyTracker$onThreadPageDestroyed$$inlined$discardByPredicate$1;
import com.ss.android.lark.flow.chat.statistics.perf.DoubaoReplyLatencyTracker$onThreadPageDestroyed$$inlined$discardByPredicate$2;
import com.ss.android.lark.flow.chat.statistics.perf.DoubaoReplyLatencyTracker$onThreadPageDestroyed$$inlined$discardByPredicate$3;
import com.ss.android.lark.flow.replyinthread.pages.viewmodel.CardVisitorReplyInThreadViewModel;
import com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel;
import com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowReplyInThreadViewModel;
import com.ss.android.lark.flow.replyinthread.pages.viewmodel.MergeForwardReplyInThreadViewModel;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.threaddetail.view.StatisticKeyboardDetectorLayout;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.SequencesKt;
import l3c.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000Î\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010M\u001a\u0004\u0018\u00010NH\u0016J\n\u0010O\u001a\u0004\u0018\u00010NH\u0016J\n\u0010P\u001a\u0004\u0018\u00010QH\u0016J\u0010\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Q0EH\u0016J\b\u0010S\u001a\u00020TH\u0016J\u000e\u0010U\u001a\u00020V2\u0006\u00106\u001a\u000207J\u0012\u0010W\u001a\u00020V2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\u0012\u0010Z\u001a\u00020V2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J&\u0010[\u001a\u0004\u0018\u00010\\2\u0006\u0010]\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010`2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\b\u0010a\u001a\u00020VH\u0016J\b\u0010b\u001a\u00020VH\u0016J\b\u0010c\u001a\u00020VH\u0016J\b\u0010d\u001a\u00020VH\u0016J\u001a\u0010e\u001a\u00020V2\u0006\u0010f\u001a\u00020\\2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\b\u0010g\u001a\u00020?H\u0016J\n\u0010h\u001a\u00020V*\u00020iJ\n\u0010j\u001a\u00020V*\u00020iJ\u0010\u0010k\u001a\u00020V2\u0006\u0010\u001e\u001a\u00020lH\u0002J\b\u0010m\u001a\u00020VH\u0002J\f\u0010n\u001a\b\u0012\u0004\u0012\u00020p0oJ\f\u0010q\u001a\b\u0012\u0004\u0012\u00020r0oJ%\u0010s\u001a\u0002Ht\"\b\b\u0000\u0010t*\u00020u2\f\u0010v\u001a\b\u0012\u0004\u0012\u0002Ht0wH\u0016¢\u0006\u0002\u0010xJ\b\u0010y\u001a\u00020zH\u0016J\b\u0010{\u001a\u00020?H\u0016J\b\u0010|\u001a\u00020}H\u0016J\b\u0010~\u001a\u00020\u007fH\u0016J\u001b\u0010\u0080\u0001\u001a\u00020V2\u0010\u0010\u0081\u0001\u001a\u000b\u0012\u0004\u0012\u00020V\u0018\u00010\u0082\u0001H\u0016J\u0012\u0010\u0083\u0001\u001a\u00020V2\u0007\u0010\u0084\u0001\u001a\u00020QH\u0016J\t\u0010\u0085\u0001\u001a\u00020?H\u0016J\t\u0010\u0086\u0001\u001a\u00020?H\u0016J\t\u0010\u0087\u0001\u001a\u00020?H\u0016J\t\u0010\u0088\u0001\u001a\u00020?H\u0016J\u0010\u0010\u0089\u0001\u001a\t\u0012\u0005\u0012\u00030\u008a\u00010oH\u0016J\n\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0016J\f\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0016J\t\u0010\u008f\u0001\u001a\u00020?H\u0016J\n\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0002J\t\u0010\u0092\u0001\u001a\u00020VH\u0002J\u0013\u0010\u0093\u0001\u001a\u00020V2\b\u0010\u0094\u0001\u001a\u00030\u008c\u0001H\u0002J\u0015\u0010\u0095\u0001\u001a\u00020V2\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001H\u0002R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u001d\u001a\u0004\b$\u0010%R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u001d\u001a\u0004\b)\u0010*R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u001d\u001a\u0004\b.\u0010/R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u001d\u001a\u0004\b3\u00104R\u000e\u00106\u001a\u000207X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010D\u001a\b\u0012\u0004\u0012\u00020?0E¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\"\u0010H\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020L\u0018\u00010J0IX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0098\u0001"}, d2 = {"Lcom/ss/android/lark/flow/replyinthread/pages/FlowReplyInThreadFragment;", "Lcom/ss/android/lark/base/frame/FrameFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "Lcom/ss/android/lark/flow/replyinthread/pages/dep/ReplyInThreadActionDependency;", "<init>", "()V", "chatAppContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "getChatAppContainer", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "setChatAppContainer", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;)V", "pluginFactory", "Lcom/ss/android/lark/biz/im/api/page/plugin/PluginFactory;", "getPluginFactory", "()Lcom/ss/android/lark/biz/im/api/page/plugin/PluginFactory;", "setPluginFactory", "(Lcom/ss/android/lark/biz/im/api/page/plugin/PluginFactory;)V", "configuratorFactory", "Lcom/ss/android/lark/biz/im/api/page/configurator/ConfiguratorFactory;", "getConfiguratorFactory", "()Lcom/ss/android/lark/biz/im/api/page/configurator/ConfiguratorFactory;", "setConfiguratorFactory", "(Lcom/ss/android/lark/biz/im/api/page/configurator/ConfiguratorFactory;)V", "componentAdaptService", "Lcom/ss/android/lark/biz/officesdk/im/component/IOfficeComponentAdaptService;", "getComponentAdaptService", "()Lcom/ss/android/lark/biz/officesdk/im/component/IOfficeComponentAdaptService;", "componentAdaptService$delegate", "Lkotlin/Lazy;", "messageListComponent", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/CoreMessageListComponent;", "privateDescriptionHandler", "Lcom/ss/android/lark/flow/replyinthread/pages/private_description/FlowReplyInThreadPrivateDescriptionHandler;", "dispatcher", "Lcom/ss/android/lark/platform/dispatcher/CompositeDispatcherImpl;", "getDispatcher", "()Lcom/ss/android/lark/platform/dispatcher/CompositeDispatcherImpl;", "dispatcher$delegate", "replyViewModel", "Lcom/ss/android/lark/flow/replyinthread/pages/viewmodel/FlowReplyInThreadViewModel;", "getReplyViewModel", "()Lcom/ss/android/lark/flow/replyinthread/pages/viewmodel/FlowReplyInThreadViewModel;", "replyViewModel$delegate", "cardViewModel", "Lcom/ss/android/lark/flow/replyinthread/pages/viewmodel/CardVisitorReplyInThreadViewModel;", "getCardViewModel", "()Lcom/ss/android/lark/flow/replyinthread/pages/viewmodel/CardVisitorReplyInThreadViewModel;", "cardViewModel$delegate", "mergeForwardViewModel", "Lcom/ss/android/lark/flow/replyinthread/pages/viewmodel/MergeForwardReplyInThreadViewModel;", "getMergeForwardViewModel", "()Lcom/ss/android/lark/flow/replyinthread/pages/viewmodel/MergeForwardReplyInThreadViewModel;", "mergeForwardViewModel$delegate", "pageInfo", "Lcom/ss/android/lark/replyinthread/pages/ThreadPageInfo;", "pageConfig", "Lcom/ss/android/lark/flow/replyinthread/pages/config/IReplyInThreadPageConfig;", "viewModel", "Lcom/ss/android/lark/flow/replyinthread/pages/viewmodel/FlowBaseReplyInThreadViewModel;", "binding", "Lcom/ss/android/lark/flow/chat/databinding/FragmentFlowReplyInThreadDetailBinding;", "replyInputComponentCreated", "", "keyboardComponent", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/base/IKeyboardComponent;", "lastReplyInputVisibility", "", "onViewCreatedCalled", "Landroidx/lifecycle/MutableLiveData;", "getOnViewCreatedCalled", "()Landroidx/lifecycle/MutableLiveData;", "closePageObserver", "Landroidx/lifecycle/Observer;", "Lkotlin/Pair;", "Lcom/ss/android/lark/flow/replyinthread/pages/viewmodel/FlowBaseReplyInThreadViewModel$ClosePageInfo;", "", "getSelfChatter", "Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", "getP2pChatter", "getThreadTopic", "Lcom/ss/android/lark/biz/im/api/ThreadTopic;", "getThreadTopicLiveData", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "initArgs", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onActivityCreated", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "onStop", "onDestroy", "onDestroyView", "onViewCreated", "view", "handleBack", "initViewModels", "Lcom/ss/android/lark/scaffold/ScaffoldScope;", "initComponents", "initPrivateDescriptionHandler", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent;", "updateReplyInputVisibility", "configuratorTypes", "", "Lcom/ss/android/lark/biz/im/api/page/configurator/ConfiguratorType;", "pluginTypes", "Lcom/ss/android/lark/biz/im/api/page/plugin/PluginType;", "getViewModel", "T", "Landroidx/lifecycle/ViewModel;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "getContext", "Landroid/content/Context;", "isFakeThreadTopic", "getViewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "getLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onUpdatePushThreadTopic", "callback", "Lkotlin/Function0;", "onThreadTopicUpdate", "threadTopic", "showChatName", "isInChat", "isThreadClosed", "needShowKeyBoard", "rightActionKey", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/TitleBarActionKey;", "getOriginMergeForwardId", "", "getParentMergeForwardMessage", "Lcom/ss/android/lark/chat/entity/message/Message;", "isFromChat", "getMsgListComponentParam", "Lcom/ss/android/lark/chat/spec/messagelist/MessageListSpec;", "hideThreadFeedCard", "closePageWithConfirmDialog", INotificationHitPoint.NoticeType.MESSAGE, "tryInitChatParamUtils", "chat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowReplyInThreadFragment extends Hilt_FlowReplyInThreadFragment implements d0c.c, zhb.a {
    public static final /* synthetic */ int y = 0;

    @Inject
    public v f;

    @Inject
    public qya.a g;

    @Inject
    public pya.a h;
    public final Lazy i;
    public CoreMessageListComponent j;
    public com.ss.android.lark.flow.replyinthread.pages.private_description.a k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public com.ss.android.lark.replyinthread.pages.f p;
    public yhb.b q;
    public FlowBaseReplyInThreadViewModel r;
    public FragmentFlowReplyInThreadDetailBinding s;
    public boolean t;
    public IKeyboardComponent u;
    public int v;
    public final MutableLiveData<Boolean> w;
    public final a x;

    public static final class a<T> implements Observer {
        public final /* synthetic */ FlowReplyInThreadFragment a;

        /* JADX INFO: renamed from: com.ss.android.lark.flow.replyinthread.pages.FlowReplyInThreadFragment$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0058a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[FlowBaseReplyInThreadViewModel.ClosePageInfo.values().length];
                r0[FlowBaseReplyInThreadViewModel.ClosePageInfo.INIT_DATA_INVALIDATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
            L21:
                r0[FlowBaseReplyInThreadViewModel.ClosePageInfo.THREAD_IS_DELETE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
            L31:
                r0[FlowBaseReplyInThreadViewModel.ClosePageInfo.GET_THREAD_IS_FORBIDDEN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
            L23:
                r0[FlowBaseReplyInThreadViewModel.ClosePageInfo.REMOTE_BY_OTHERS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
            L25:
                r0[FlowBaseReplyInThreadViewModel.ClosePageInfo.THREAD_IS_RECALLED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
            L19:
                r0[FlowBaseReplyInThreadViewModel.ClosePageInfo.NORMAL_FINISH_HIDE_FEED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
            L27:
                r0[FlowBaseReplyInThreadViewModel.ClosePageInfo.GROUP_IS_DISSOLVED_REMOTE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
            L10:
                a = r0;
            }
        }

        public a(FlowReplyInThreadFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Pair r4 = (Pair) r3;
            if (r4 == null) goto L21;
            FlowBaseReplyInThreadViewModel.ClosePageInfo r5 = (FlowBaseReplyInThreadViewModel.ClosePageInfo) r4.getFirst();
            switch(C0058a.a[r5.ordinal()]) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                default: goto L8;
            };
        L9:
            FlowReplyInThreadFragment.V90(this.a);
            FlowReplyInThreadFragment r6 = this.a;
            FlowReplyInThreadFragment.T90(r6, UIUtils.getString(r6.requireContext(), 2131891822));
            return;
        L10:
            FlowReplyInThreadFragment.V90(this.a);
            zab.a.a(this.a);
            return;
        L11:
            FlowReplyInThreadFragment.V90(this.a);
            FlowReplyInThreadFragment r7 = this.a;
            FlowReplyInThreadFragment.T90(r7, UIUtils.getString(r7.requireContext(), 2131890433));
            return;
        L12:
            FlowReplyInThreadFragment.V90(this.a);
            FlowReplyInThreadFragment r8 = this.a;
            FlowReplyInThreadFragment.T90(r8, UIUtils.getString(r8.requireContext(), 2131892053));
            return;
        L13:
            FlowReplyInThreadFragment.V90(this.a);
            FlowReplyInThreadFragment r9 = this.a;
            FlowReplyInThreadFragment.T90(r9, UIUtils.getString(r9.requireContext(), 2131890433));
            return;
        L14:
            FlowToast.c(this.a.requireContext(), 2131891886);
            zab.a.a(this.a);
            return;
        L8:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ FlowReplyInThreadFragment a;
        public final /* synthetic */ View b;

        public b(FlowReplyInThreadFragment r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r5) {
            Boolean r6 = (Boolean) r5;
            FlowBaseReplyInThreadViewModel r0 = this.a.r;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r0 = null;
        L5:
            r0.getChatData().observe(this.a.getViewLifecycleOwner(), new g(this.a));
            if (r6.booleanValue() == false) goto L9;
            final FlowReplyInThreadFragment r7 = this.a;
            i.a(r7, this.b, new FlowReplyInThreadFragment$onViewCreated$1$2(r7));
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ FlowReplyInThreadFragment a;

        public static final class a implements View.OnLayoutChangeListener {
            public final /* synthetic */ FlowReplyInThreadFragment a;

            public a(FlowReplyInThreadFragment r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
                r1.removeOnLayoutChangeListener(this);
                CoreMessageListComponent r10 = this.a.j;
                if (r10 == null) goto L6;
                r10.MH(ScrollScene.KEYBOARD);
                return;
            }
        }

        public c(FlowReplyInThreadFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IKeyboardComponent r0 = this.a.u;     // Catch: Throwable -> L10
            if (r0 == null) goto L5;
            r0.I();     // Catch: Throwable -> L10
        L5:
            FragmentFlowReplyInThreadDetailBinding r1 = this.a.s;     // Catch: Throwable -> L10
            if (r1 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("binding");     // Catch: Throwable -> L10
            r1 = null;
        L8:
            r1.f.addOnLayoutChangeListener(new a(this.a));     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L14;
            return;
        L14:
            throw th;
        }
    }

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    @Override // zhb.a
    public final boolean A00() {
        FlowBaseReplyInThreadViewModel r0 = this.r;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L6:
        return r0.showChatName();
    }

    @Override // zhb.a
    public final boolean E80() {
        FlowBaseReplyInThreadViewModel r0 = this.r;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L6:
        return r0.isFakeThreadTopic();
    }

    @Override // zhb.a
    public final String J20() {
        FlowBaseReplyInThreadViewModel r0 = this.r;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L6:
        return r0.getOriginMergeForwardId();
    }

    @Override // zhb.a
    public final ChatChatter N0() {
        FlowBaseReplyInThreadViewModel r0 = this.r;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L6:
        return (ChatChatter) r0.getSelfChatterData().getValue();
    }

    @Override // zhb.a
    public final ThreadTopic N1() {
        FlowBaseReplyInThreadViewModel r0 = this.r;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L6:
        return (ThreadTopic) r0.getThreadTopicLiveData().getValue();
    }

    public final v W90() {
        v r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("chatAppContainer");
        return null;
    }

    public final com.ss.android.lark.platform.dispatcher.b X90() {
        return (com.ss.android.lark.platform.dispatcher.b) this.l.getValue();
    }

    public final void Y90() {
        FlowBaseReplyInThreadViewModel r0 = this.r;
        FragmentFlowReplyInThreadDetailBinding r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L6:
        if (r0.canReply() == true) goto L8;
    L10:
        int r2 = 8;
    L12:
        if (this.v != 8) goto L14;
        boolean r4 = true;
    L15:
        this.v = r2;
        FragmentFlowReplyInThreadDetailBinding r5 = this.s;
        if (r5 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L18:
        r5.d.setVisibility(r2);
        FragmentFlowReplyInThreadDetailBinding r6 = this.s;
        if (r6 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L21:
        r6.e.setVisibility(r2);
        if (r2 != 8) goto L39;
        IKeyboardComponent r3 = this.u;
        if (r3 == null) goto L26;
        r3.hideKeyboard();
    L26:
        KeyboardUtils.hideKeyboard(requireActivity());
        FragmentFlowReplyInThreadDetailBinding r7 = this.s;
        if (r7 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L30:
        MessageListAnimationContainer r8 = r1.f;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if (r9 == null) goto L38;
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r9;
        r10.bottomMargin = 0;
        r8.setLayoutParams(r10);
        CoreMessageListComponent r11 = this.j;
        if (r11 == null) goto L46;
        RecyclerView r12 = r11.getRecyclerView();
        if (r12 == null) goto L47;
        r12.invalidateItemDecorations();
        return;
    L47:
        return;
    L46:
        return;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L29:
        r1 = r7;
        goto L30
    L39:
        if (r4 == false) goto L49;
        FragmentFlowReplyInThreadDetailBinding r13 = this.s;
        if (r13 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L44:
        r1.d.post(new c(this));
        return;
    L43:
        r1 = r13;
        goto L44
    L49:
        return;
    L14:
        r4 = false;
        goto L15
    L8:
        if (this.t == false) goto L10;
        r2 = 0;
        goto L12
    }

    @Override // zhb.a
    public final Message b90() {
        FlowBaseReplyInThreadViewModel r0 = this.r;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L6:
        return r0.getParentMergeForwardMessage();
    }

    @Override // zhb.a
    public final ChatChatter g7() {
        FlowBaseReplyInThreadViewModel r0 = this.r;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L6:
        return (ChatChatter) r0.getP2pChatterData().getValue();
    }

    @Override // zhb.a
    public final boolean hE() {
        FlowBaseReplyInThreadViewModel r0 = this.r;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L6:
        return r0.needShowKeyBoard();
    }

    @Override // zhb.a
    public final boolean io() {
        FlowBaseReplyInThreadViewModel r0 = this.r;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L6:
        return r0.isThreadClosed();
    }

    public final void onDestroyView() {
        com.ss.android.lark.flow.replyinthread.pages.private_description.a r0 = this.k;
        if (r0 != null) goto L5;
    L11:
        this.k = null;
        super/*com.ss.android.lark.base.fragment.BaseFragment*/.onDestroyView();
        return;
    L5:
        if (r0.g == false) goto L7;
        r0.c.w8(r0.f);
        r0.g = false;
    L7:
        com.ss.android.lark.flow.replyinthread.pages.private_description.b r2 = r0.e;
        if (r2 == null) goto L10;
        r0.a.l(r2);
    L10:
        r0.e = null;
        r0.d = null;
        goto L11
    }

    @Override // zhb.a
    public final boolean q8() {
        FlowBaseReplyInThreadViewModel r0 = this.r;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L6:
        return r0.inChat();
    }

    @Override // zhb.a
    public final List<TitleBarActionKey> sr() {
        yhb.b r0 = this.q;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("pageConfig");
        r0 = null;
    L6:
        return r0.a();
    }

    @Inject
    public FlowReplyInThreadFragment() {
        this.i = LazyKt.lazy(FlowReplyInThreadFragment$componentAdaptService$2.INSTANCE);
        this.l = LazyKt.lazy(LazyThreadSafetyMode.NONE, FlowReplyInThreadFragment$dispatcher$2.INSTANCE);
        Function0<ViewModelProvider.Factory> r0 = new FlowReplyInThreadFragment$replyViewModel$2(this);
        final Function0<Fragment> r1 = new FlowReplyInThreadFragment$special$$inlined$viewModels$default$1(this);
        this.m = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FlowReplyInThreadViewModel.class), new FlowReplyInThreadFragment$special$$inlined$viewModels$default$2(r1), r0);
        Function0<ViewModelProvider.Factory> r2 = new FlowReplyInThreadFragment$cardViewModel$2(this);
        final Function0<Fragment> r3 = new FlowReplyInThreadFragment$special$$inlined$viewModels$default$4(this);
        this.n = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CardVisitorReplyInThreadViewModel.class), new FlowReplyInThreadFragment$special$$inlined$viewModels$default$5(r3), r2);
        Function0<ViewModelProvider.Factory> r4 = new FlowReplyInThreadFragment$mergeForwardViewModel$2(this);
        final Function0<Fragment> r5 = new FlowReplyInThreadFragment$special$$inlined$viewModels$default$7(this);
        this.o = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MergeForwardReplyInThreadViewModel.class), new FlowReplyInThreadFragment$special$$inlined$viewModels$default$8(r5), r4);
        this.w = new MutableLiveData(Boolean.FALSE);
        this.x = new a(this);
    }

    @Override // zhb.a
    public final boolean Pr() {
        return Intrinsics.areEqual(requireArguments().getString("key_params_thread_source_type"), "chat");
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    @Override // com.ss.android.lark.flow.replyinthread.pages.Hilt_FlowReplyInThreadFragment, zhb.a
    public Context getContext() {
        return requireActivity();
    }

    public final boolean l1() {
        return X90().f();
    }

    public final void onDestroy() {
        super/*com.ss.android.lark.base.fragment.BaseFragment*/.onDestroy();
        eza.a r0 = (eza.a) this.i.getValue();
        if (r0 == null) goto L5;
        r0.p(this);
    L5:
        FlowBaseReplyInThreadViewModel r1 = this.r;
        FlowBaseReplyInThreadViewModel r2 = null;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1 = null;
    L8:
        r1.getClosePageInfo().removeObserver(this.x);
        FlowBaseReplyInThreadViewModel r3 = this.r;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L11:
        final String r4 = r3.getChatBundle().getChatId();
        final String r5 = "";
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        FlowBaseReplyInThreadViewModel r6 = this.r;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L18:
        String r7 = r2.getThreadId();
        if (r7 == null) goto L22;
        r5 = r7;
    L22:
        com.ss.android.lark.flow.chat.statistics.perf.a r8 = com.ss.android.lark.flow.chat.statistics.perf.a.a;
        Intrinsics.checkNotNullParameter(r4, "chatId");
        Intrinsics.checkNotNullParameter(r5, "threadId");
        boolean r9 = true;
        if (r4.length() != 0) goto L25;
        boolean r10 = true;
    L26:
        if (r10 == false) goto L28;
        return;
    L28:
        if (r5.length() == 0) goto L31;
        r9 = false;
    L31:
        if (r9 == true) goto L36;
        CollectionsKt.removeAll(com.ss.android.lark.flow.chat.statistics.perf.a.d.values(), new DoubaoReplyLatencyTracker$onThreadPageDestroyed$$inlined$discardByPredicate$1(r4, r5));
        CollectionsKt.removeAll(com.ss.android.lark.flow.chat.statistics.perf.a.e.values(), new DoubaoReplyLatencyTracker$onThreadPageDestroyed$$inlined$discardByPredicate$2(r4, r5));
        CollectionsKt.removeAll(com.ss.android.lark.flow.chat.statistics.perf.a.f.values(), new DoubaoReplyLatencyTracker$onThreadPageDestroyed$$inlined$discardByPredicate$3(r4, r5));
        return;
    L36:
        return;
    L25:
        r10 = false;
        goto L26
    L17:
        r2 = r6;
        goto L18
    }

    public final void onStart() {
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onStart();
        FlowBaseReplyInThreadViewModel r0 = this.r;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.recordStartTime();
    }

    public final void onStop() {
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onStop();
        FlowBaseReplyInThreadViewModel r0 = this.r;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.sendTimeDuration();
        FlowBaseReplyInThreadViewModel r1 = this.r;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1 = null;
    L8:
        String r2 = r1.getChatBundle().getChatId();
        String r3 = "";
        if (r2 != null) goto L11;
        r2 = "";
    L11:
        FlowBaseReplyInThreadViewModel r4 = this.r;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r4 = null;
    L14:
        String r5 = r4.getThreadId();
        if (r5 == null) goto L18;
        r3 = r5;
    L18:
        com.ss.android.lark.flow.chat.statistics.perf.a r6 = com.ss.android.lark.flow.chat.statistics.perf.a.a;
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r3, "threadId");
        if (r2.length() != 0) goto L21;
        boolean r7 = true;
    L22:
        if (r7 == false) goto L24;
        return;
    L24:
        if (r3.length() != 0) goto L26;
        boolean r8 = true;
    L27:
        if (r8 == true) goto L57;
        Iterator<T> r9 = com.ss.android.lark.flow.chat.statistics.perf.a.c.values().iterator();
    L31:
        if (r9.hasNext() == false) goto L35;
        com.ss.android.lark.flow.chat.statistics.perf.a.C0039a r10 = (com.ss.android.lark.flow.chat.statistics.perf.a.C0039a) r9.next();
        if (Intrinsics.areEqual(r10.b, r2) == false) goto L31;
        r10.e = true;
        goto L31
    L35:
        Iterator r11 = SequencesKt.sequence(new DoubaoReplyLatencyTracker$markTracePageInvisible$1(null)).iterator();
    L37:
        if (r11.hasNext() == false) goto L58;
        com.ss.android.lark.flow.chat.statistics.perf.a.b r12 = (com.ss.android.lark.flow.chat.statistics.perf.a.b) r11.next();
        Intrinsics.checkNotNull(r12);
        if (Intrinsics.areEqual(r12.a, r2) == true) goto L41;
    L43:
        boolean r13 = false;
    L44:
        if (r13 == false) goto L37;
        r12.k = true;
        goto L37
    L41:
        if (Intrinsics.areEqual(r12.c, r3) == false) goto L43;
        r13 = true;
        goto L44
    L58:
        return;
    L57:
        return;
    L26:
        r8 = false;
        goto L27
    L21:
        r7 = false;
        goto L22
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m481provideComponent() {
        return provideComponent();
    }

    public static final /* synthetic */ Context U90(FlowReplyInThreadFragment r0) {
        return ((BaseFragment) r0).mContext;
    }

    public static final void V90(FlowReplyInThreadFragment r3) {
        FlowBaseReplyInThreadViewModel r0 = r3.r;
        FlowBaseReplyInThreadViewModel r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        int r2 = r0.getFeedCardType();
        FlowBaseReplyInThreadViewModel r4 = r3.r;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L9:
        String r5 = r1.getThreadId();
        if (r2 == (-1)) goto L13;
        w4b.m r6 = ChatCoreModule.a().getFeedDependency();
        new Channel(Channel.Type.CHAT, r5);
        r6.g();
        return;
    L13:
        return;
    L8:
        r1 = r4;
        goto L9
    }

    @Override // zhb.a
    public final void cg(Function0<Unit> r2) {
        FlowBaseReplyInThreadViewModel r0 = this.r;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.onUpdatePushThreadTopic(r2);
    }

    @Override // zhb.a
    public final <T extends ViewModel> T getViewModel(Class<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "clazz");
        if (Intrinsics.areEqual(r4, FlowReplyInThreadViewModel.class) == false) goto L6;
        FlowReplyInThreadViewModel r5 = (FlowReplyInThreadViewModel) this.m.getValue();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type T of com.ss.android.lark.flow.replyinthread.pages.FlowReplyInThreadFragment.getViewModel");
        return r5;
    L6:
        if (Intrinsics.areEqual(r4, CardVisitorReplyInThreadViewModel.class) == false) goto L9;
        CardVisitorReplyInThreadViewModel r6 = (CardVisitorReplyInThreadViewModel) this.n.getValue();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type T of com.ss.android.lark.flow.replyinthread.pages.FlowReplyInThreadFragment.getViewModel");
        return r6;
    L9:
        if (Intrinsics.areEqual(r4, MergeForwardReplyInThreadViewModel.class) == false) goto L13;
        MergeForwardReplyInThreadViewModel r7 = (MergeForwardReplyInThreadViewModel) this.o.getValue();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type T of com.ss.android.lark.flow.replyinthread.pages.FlowReplyInThreadFragment.getViewModel");
        return r7;
    L13:
        throw new IllegalArgumentException("view model not support, " + r4);
    }

    public final void onActivityCreated(Bundle r3) {
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onActivityCreated(r3);
        FlowBaseReplyInThreadViewModel r4 = this.r;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r4 = null;
    L5:
        r4.getClosePageInfo().observe(getViewLifecycleOwner(), this.x);
    }

    public final void onCreate(Bundle r7) {
        super/*com.ss.android.lark.base.fragment.BaseFragment*/.onCreate(r7);
        eza.a r8 = (eza.a) this.i.getValue();
        if (r8 == null) goto L5;
        r8.o(this);
    L5:
        com.ss.android.lark.flow.chat.statistics.perf.a.g();
        final OnBackPressedDispatcher r0 = requireActivity().getOnBackPressedDispatcher();
        OnBackPressedDispatcherKt.addCallback$default(r0, this, false, new AnonymousClass1(this, r0), 2, null);
    }

    @Override // zhb.a
    public final void w9(ThreadTopic r2) {
        Intrinsics.checkNotNullParameter(r2, "threadTopic");
        FlowBaseReplyInThreadViewModel r0 = this.r;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.getThreadTopicLiveData().setValue(r2);
        Y90();
        CoreMessageListComponent r3 = this.j;
        if (r3 == null) goto L11;
        IMessageListViewModel r4 = r3.E0().f();
        if (r4 == null) goto L12;
        r4.notifyDataChange();
        return;
    L12:
        return;
    }

    public static final void T90(FlowReplyInThreadFragment r3, String r4) {
        r3.getClass();
        new UDDialogBuilder(r3.requireActivity()).title(r4).titleBold(true).titleLineCount(2).addActionButton(2131391777, 2131891628, new com.ss.android.lark.flow.replyinthread.pages.b(r3)).cancelable(false).show().setOnKeyListener(new com.ss.android.lark.flow.replyinthread.pages.a(r3));
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super/*com.ss.android.lark.base.fragment.BaseFragment*/.onViewCreated(r6, r7);
        com.ss.android.lark.replyinthread.pages.f r8 = this.p;
        FlowBaseReplyInThreadViewModel r1 = null;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
        r8 = null;
    L5:
        int r9 = r8.getType();
        if (r9 != 1) goto L8;
        yhb.b r10 = new yhb.a(this);
    L12:
        this.q = r10;
        FlowBaseReplyInThreadViewModel r11 = r10.a1();
        this.r = r11;
        if (r11 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r11 = null;
    L15:
        com.ss.android.lark.replyinthread.pages.f r4 = this.p;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("pageInfo");
        r4 = null;
    L18:
        r11.onCreate(r4);
        FlowBaseReplyInThreadViewModel r12 = this.r;
        if (r12 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L22:
        com.ss.android.lark.chat.chatwindow.chat.v2.extension.b.b(r1.getInitDataReady(), getViewLifecycleOwner(), new b(this, r6));
        com.ss.android.lark.insets.f r13 = WindowInsetsUtils.b(this);
        r13.k(true);
        r13.r(true);
        return;
    L21:
        r1 = r12;
        goto L22
    L8:
        if (r9 == 2) goto L10;
        r10 = new yhb.d(W90(), this);
        goto L12
    L10:
        r10 = new yhb.c(this);
        goto L12
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        StatisticKeyboardDetectorLayout r12 = r9.inflate(2131561196, r10, false);
        int r13 = 2131373023;
        FrameLayout r2 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131373023);
        if (r2 == null) goto L24;
        r13 = 2131373025;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131373025);
        if (r3 == null) goto L24;
        r13 = 2131376828;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131376828);
        if (r4 == null) goto L24;
        r13 = 2131376833;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131376833);
        if (r5 == null) goto L24;
        r13 = 2131378077;
        if (((LinearLayout) ViewBindings.findChildViewById(r12, 2131378077)) == null) goto L24;
        r13 = 2131379993;
        if (((RelativeLayout) ViewBindings.findChildViewById(r12, 2131379993)) == null) goto L24;
        r13 = 2131380364;
        MessageListAnimationContainer r6 = ViewBindings.findChildViewById(r12, 2131380364);
        if (r6 == null) goto L24;
        r13 = 2131384356;
        if (((TextView) ViewBindings.findChildViewById(r12, 2131384356)) == null) goto L24;
        StatisticKeyboardDetectorLayout r14 = r12;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131388600);
        if (r7 == null) goto L22;
        this.s = new FragmentFlowReplyInThreadDetailBinding(r14, r2, r3, r4, r5, r6, r7);
        return r14;
    L22:
        r13 = 2131388600;
    L24:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}
