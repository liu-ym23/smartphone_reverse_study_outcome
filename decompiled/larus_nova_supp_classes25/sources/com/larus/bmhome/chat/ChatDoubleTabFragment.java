package com.larus.bmhome.chat;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.keva.Keva;
import com.google.android.material.tabs.TabLayout;
import com.larus.bmhome.chat.bean.PageType;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.doubletab.IChatDoubleTabAbility;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.databinding.LarusPageChatDoubleTabBinding;
import com.larus.bmhome.instruction.g;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.bmhome.view.DoubleColumnTitle;
import com.larus.bmhome.view.title.ChatTitleTwoTab;
import com.larus.bmhome.view.title.ChatTitleTwoTabAdapt;
import com.larus.bmhome.view.utils.SwipingControlVm;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.BaseConstraintLayout;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.platform.model.RecommendFrom;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.uaigc.bean.chat.template.TemplateViewModel;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.chat.IObricChatUIService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0013\u0018\u0000 \u008a\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0002\u008a\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010G\u001a\u00020\u001e2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\b\u0010J\u001a\u00020\u001eH\u0016J\b\u0010K\u001a\u00020\u001eH\u0016J\b\u0010L\u001a\u00020MH\u0016J\b\u0010N\u001a\u00020\u001eH\u0002J&\u0010O\u001a\u0004\u0018\u00010\u001a2\u0006\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010S2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u001a\u0010T\u001a\u00020\u001e2\u0006\u0010U\u001a\u00020\u001a2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\b\u0010V\u001a\u00020\u001eH\u0002J\b\u0010W\u001a\u00020\u001eH\u0002J\u000e\u0010X\u001a\u00020\u001e2\u0006\u0010Y\u001a\u00020ZJ\b\u0010[\u001a\u00020\u0015H\u0016J\u001e\u0010\\\u001a\u00020\u001e2\u0006\u0010]\u001a\u00020I2\u0006\u0010^\u001a\u00020>2\u0006\u0010_\u001a\u00020>J\u000f\u0010`\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0002\u0010aJ \u0010b\u001a\u00020\u001e2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020>2\u0006\u0010f\u001a\u00020\u0015H\u0002J\u0010\u0010g\u001a\u00020h2\u0006\u0010c\u001a\u00020dH\u0002J\u0010\u0010i\u001a\u00020\u000f2\u0006\u0010R\u001a\u00020SH\u0002J\b\u0010j\u001a\u00020\u001eH\u0016J\u000e\u0010k\u001a\u00020\u001e2\u0006\u0010l\u001a\u00020\u0013J\u0014\u0010m\u001a\u00020\u001e2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dJ\b\u0010o\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010p\u001a\u00020\u001e2\u0006\u0010q\u001a\u00020\u0015H\u0016J\u0012\u0010r\u001a\u00020\u001e2\b\u0010s\u001a\u0004\u0018\u00010\u0015H\u0016J4\u0010t\u001a\u00020\u001e2\u0006\u0010u\u001a\u00020M2\u0014\u0010v\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020x\u0018\u00010w2\f\u0010y\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J\b\u0010z\u001a\u00020@H\u0016J\u0018\u0010{\u001a\u00020\u001e2\u0006\u0010|\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010}\u001a\u00020\u001eH\u0016J\b\u0010~\u001a\u00020\u001eH\u0016J\b\u0010\u007f\u001a\u00020\u001eH\u0016J\u0018\u0010\u0080\u0001\u001a\u00020\u001e2\r\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J\t\u0010\u0082\u0001\u001a\u00020>H\u0016J\t\u0010\u0083\u0001\u001a\u00020>H\u0016J\u0012\u0010\u0084\u0001\u001a\u00020\u001e2\u0007\u0010\u0085\u0001\u001a\u00020>H\u0016J\u000b\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0015H\u0016J\u000b\u0010\u0087\u0001\u001a\u0004\u0018\u00010<H\u0002J\t\u0010\u0088\u0001\u001a\u00020MH\u0002J\t\u0010\u0089\u0001\u001a\u00020\u0015H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010 \u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0004\u0012\u00020\u001e\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b.\u0010/R\u001b\u00102\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00101\u001a\u0004\b4\u00105R\u0013\u00107\u001a\u0004\u0018\u0001088F¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010?\u001a\u0004\u0018\u00010@8F¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0016\u0010C\u001a\u0004\u0018\u00010D8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bE\u0010F¨\u0006\u008b\u0001"}, d2 = {"Lcom/larus/bmhome/chat/ChatDoubleTabFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/bmhome/chat/IChatLeave;", "Lcom/larus/bmhome/chat/share/IChatPageShareable;", "Lcom/larus/ui/arch/component/internal/attach/ChatFragmentComponentDelegate;", "Lcom/larus/chat/api/IInputViewSlot;", "Lcom/larus/bmhome/chat/component/doubletab/IChatDoubleTabAbility;", "Lcom/larus/bmhome/chat/ITraceFragment;", "<init>", "()V", "onBackPressCallBack", "Landroidx/activity/OnBackPressedCallback;", "binding", "Lcom/larus/bmhome/databinding/LarusPageChatDoubleTabBinding;", "titleBar", "Lcom/larus/platform/api/IChatTitle;", "onAddBotChangedListener", "Lcom/larus/bmhome/chat/event/OnAddBotChangedListener;", "onParentAddBotChangedListener", "Lcom/larus/bmhome/chat/event/OnParentAddBotChangedListener;", "conversationId", "", "title", "chatTwoTitle", "Lcom/larus/bmhome/view/title/ChatTitleTwoTab;", "viewStub", "Landroid/view/View;", "mobPreviousPageName", "parentOnBackClickListener", "Lkotlin/Function0;", "", "onPauseBeforeCall", "onResumeBeforeCall", "Lkotlin/Function1;", "Lcom/larus/common_ui/widget/BaseConstraintLayout;", "getOnResumeBeforeCall", "()Lkotlin/jvm/functions/Function1;", "setOnResumeBeforeCall", "(Lkotlin/jvm/functions/Function1;)V", "onBackFromChatTabInterceptor", "getOnBackFromChatTabInterceptor", "()Lkotlin/jvm/functions/Function0;", "setOnBackFromChatTabInterceptor", "(Lkotlin/jvm/functions/Function0;)V", "swipingControl", "Lcom/larus/bmhome/view/utils/SwipingControlVm;", "getSwipingControl", "()Lcom/larus/bmhome/view/utils/SwipingControlVm;", "swipingControl$delegate", "Lkotlin/Lazy;", "templateViewModel", "Lcom/larus/uaigc/bean/chat/template/TemplateViewModel;", "getTemplateViewModel", "()Lcom/larus/uaigc/bean/chat/template/TemplateViewModel;", "templateViewModel$delegate", "chatListMessage", "Landroidx/recyclerview/widget/RecyclerView;", "getChatListMessage", "()Landroidx/recyclerview/widget/RecyclerView;", "conversationPage", "Lcom/larus/im/bean/bot/ConversationPage;", "defaultTab", "", "chatFragment", "Landroidx/fragment/app/Fragment;", "getChatFragment", "()Landroidx/fragment/app/Fragment;", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onDestroyView", "autoLogEnterPage", "", "performBack", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "enableSwiping", "disableSwiping", "attachAbility", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "getCurrentPageName", "onResult", "bundle", "requestCode", "resultCode", "setupTitle", "()Lkotlin/Unit;", "onImageTemplateChoose", "templatePrompt", "Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateInfo;", "position", "enterFrom", "getSendMessageTrackExtMap", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$SendMessageTrackExtMap;", "generateTitileBarTwoPage", "onPause", "setParentAddBotChangedListener", "parentAddBotChangedListener", "setParentOnBackClickListener", "listener", "getTitle", "leaveChat", "methodName", "reportEnterPage", "pageName", "onMessageShareMode", "shareMode", "ext", "", "", "onCloseClick", "findChatFragment", "attachInputView", "inputView", "beginVoice", "endVoice", "textInputSend", "subscribePause", "pauseCallback", "getCurTabIndex", "getBizType", "switchTab", "tabIndex", "getDefaultHitString", "getConversationPage", "showTmplInputBox", "scene", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatDoubleTabFragment extends TraceFragment implements f4, xi8.a, r1a.a, ry8.c, IChatDoubleTabAbility, m4 {
    public static final /* synthetic */ int t = 0;
    public LarusPageChatDoubleTabBinding e;
    public com.larus.platform.api.g0 f;
    public c g;
    public te8.d h;
    public String i;
    public com.larus.platform.api.g0 j;
    public ChatTitleTwoTab k;
    public View l;
    public String m;
    public Function0<Unit> n;
    public Function1<? super BaseConstraintLayout, Unit> o;
    public Function0<Unit> p;
    public final Lazy q;
    public final Lazy r;
    public int s;

    public static final class a {
    }

    public static final class b implements ChatConstraintLayout.b {
        public final /* synthetic */ ChatDoubleTabFragment a;

        public final void a() {
            ChatFragment r0 = this.a.p7();
            ChatConstraintLayout.b r2 = null;
            if ((r0 instanceof ChatFragment) == false) goto L5;
            ChatFragment r1 = r0;
        L6:
            if (r1 == null) goto L15;
            LarusPageChatBinding r3 = r1.u;
            if (r3 == null) goto L12;
            ChatConstraintLayout r4 = r3.a;
            if (r4 == null) goto L12;
            r2 = r4.getOnBottomInsetUpdateListener();
        L12:
            if (r2 == null) goto L16;
            r2.a();
            return;
        L16:
            return;
        L15:
            return;
        L5:
            r1 = null;
            goto L6
        }

        public final void b() {
            ChatFragment r0 = this.a.p7();
            ChatConstraintLayout.b r2 = null;
            if ((r0 instanceof ChatFragment) == false) goto L5;
            ChatFragment r1 = r0;
        L6:
            if (r1 == null) goto L15;
            LarusPageChatBinding r3 = r1.u;
            if (r3 == null) goto L12;
            ChatConstraintLayout r4 = r3.a;
            if (r4 == null) goto L12;
            r2 = r4.getOnBottomInsetUpdateListener();
        L12:
            if (r2 == null) goto L16;
            r2.b();
            return;
        L16:
            return;
        L15:
            return;
        L5:
            r1 = null;
            goto L6
        }

        public b(ChatDoubleTabFragment r1) {
            this.a = r1;
        }

        public final void onUpdate(int r4) {
            ChatFragment r0 = this.a.p7();
            ChatConstraintLayout.b r2 = null;
            if ((r0 instanceof ChatFragment) == false) goto L5;
            ChatFragment r1 = r0;
        L6:
            if (r1 == null) goto L15;
            LarusPageChatBinding r3 = r1.u;
            if (r3 == null) goto L12;
            ChatConstraintLayout r5 = r3.a;
            if (r5 == null) goto L12;
            r2 = r5.getOnBottomInsetUpdateListener();
        L12:
            if (r2 == null) goto L16;
            r2.onUpdate(r4);
            return;
        L16:
            return;
        L15:
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class c implements te8.b {
        public final /* synthetic */ ChatDoubleTabFragment a;

        public c(ChatDoubleTabFragment r1) {
            this.a = r1;
        }

        @Override // te8.b
        public final void a(boolean r2) {
            com.larus.platform.api.g0 r0 = this.a.j;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("title");
            r0 = null;
        L5:
            r0.setHasMore(r2);
        }

        @Override // te8.b
        public final void b(boolean r2) {
            com.larus.platform.api.g0 r0 = this.a.j;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("title");
            r0 = null;
        L5:
            r0.setHasAddBot(r2);
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.ChatDoubleTabFragment$onViewCreated$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.ChatDoubleTabFragment$onViewCreated$3", f = "ChatDoubleTabFragment.kt", i = {}, l = {212}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatDoubleTabFragment this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.ChatDoubleTabFragment$onViewCreated$3$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.bmhome.chat.ChatDoubleTabFragment$onViewCreated$3$1", f = "ChatDoubleTabFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
            /* synthetic */ boolean Z$0;
            int label;
            final /* synthetic */ ChatDoubleTabFragment this$0;

            public AnonymousClass1(ChatDoubleTabFragment r1, Continuation<? super AnonymousClass1> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
                r0.Z$0 = ((Boolean) r3).booleanValue();
                return r0;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
            }

            public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
                return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L15;
                ResultKt.throwOnFailure(r2);
                if (this.Z$0 == false) goto L9;
                LarusPageChatDoubleTabBinding r3 = this.this$0.e;
                if (r3 == null) goto L13;
                r3.f.setUserInputEnabled(true);
            L13:
                return Unit.INSTANCE;
            L9:
                LarusPageChatDoubleTabBinding r4 = this.this$0.e;
                if (r4 == null) goto L13;
                r4.f.setUserInputEnabled(false);
                goto L13
            L15:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass3(ChatDoubleTabFragment r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            MutableSharedFlow r7 = ((SwipingControlVm) this.this$0.q.getValue()).getSwipingControlFlow();
            AnonymousClass1 r2 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (kotlinx.coroutines.flow.e.i(r7, r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    public final boolean S90() {
        return false;
    }

    public final RecyclerView U90() {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L18
        LarusPageChatDoubleTabBinding r2 = this.e;     // Catch: Throwable -> L18
        if (r2 == null) goto L15;
        ViewPager2 r3 = r2.f;     // Catch: Throwable -> L18
        if (r3 == null) goto L15;
        ChatTitleTwoTabAdapt r4 = r3.getAdapter();     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.larus.bmhome.view.title.ChatTitleTwoTabAdapt");     // Catch: Throwable -> L18
        ChatFragment r5 = (Fragment) r4.n.get(r3.getCurrentItem());     // Catch: Throwable -> L18
        if ((r5 instanceof ChatFragment) == false) goto L10;
        ChatFragment r6 = r5;     // Catch: Throwable -> L18
    L11:
        if (r6 == null) goto L15;
        LarusPageChatBinding r7 = r6.u;     // Catch: Throwable -> L18
        if (r7 == null) goto L15;
        ChatMessageList r8 = r7.n;     // Catch: Throwable -> L18
    L16:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L18
    L21:
        if (Result.isFailure-impl(r9) == true) goto L25;
        r0 = r9;
    L25:
        return (RecyclerView) r0;
    L10:
        r6 = null;
    L15:
        r8 = null;
    L18:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }

    public final String k() {
        return "chat";
    }

    @Override // com.larus.bmhome.chat.m4
    public final String scene() {
        return "CHAT_MESSAGE_LIST_DOUBLE_TAB";
    }

    public final void NN() {
        LarusPageChatDoubleTabBinding r0 = this.e;
        if (r0 == null) goto L11;
        ViewPager2 r1 = r0.f;
        if (r1 == null) goto L11;
        if (r0 == null) goto L9;
        if (r1 == null) goto L9;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
    L10:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r2.height = 0;
        r1.setLayoutParams(r2);
    L9:
        r2 = null;
    L11:
        LarusPageChatDoubleTabBinding r3 = this.e;
        if (r3 == null) goto L16;
        FrameLayout r4 = r3.c;
        if (r4 == null) goto L16;
        com.larus.utils.e1.x(r4);
    L16:
        View r5 = this.l;
        if (r5 == null) goto L20;
        com.larus.utils.e1.o(r5);
        return;
    }

    @Override // com.larus.bmhome.chat.component.doubletab.IChatDoubleTabAbility
    public final void Ui() {
        Lazy r0 = com.larus.bmhome.chat.model.repo.j2.a;
        String r1 = this.i;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
        r1 = null;
    L6:
        if (Intrinsics.areEqual(com.larus.bmhome.chat.model.repo.j2.c, Boolean.TRUE) == false) goto L9;
        ((Keva) com.larus.bmhome.chat.model.repo.j2.a.getValue()).storeInt("template_tab_index_" + r1, com.larus.bmhome.chat.model.repo.j2.b);
    L9:
        if (W90() == false) goto L16;
        LarusPageChatDoubleTabBinding r2 = this.e;
        if (r2 == null) goto L17;
        ViewPager2 r3 = r2.f;
        if (r3 == null) goto L18;
        r3.setCurrentItem(0, true);
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // com.larus.bmhome.chat.component.doubletab.IChatDoubleTabAbility
    public final int ar() {
        return ((Number) v.b.getValue()).intValue();
    }

    public final Fragment getChatFragment() {
        LarusPageChatDoubleTabBinding r0 = this.e;
        if (r0 == null) goto L7;
        ViewPager2 r1 = r0.f;
        if (r1 == null) goto L7;
        RecyclerView.Adapter r2 = r1.getAdapter();
    L9:
        if ((r2 instanceof ChatTitleTwoTabAdapt) == false) goto L11;
        ChatTitleTwoTabAdapt r3 = (ChatTitleTwoTabAdapt) r2;
    L12:
        if (r3 != null) goto L14;
        return null;
    L14:
        return (Fragment) r3.n.get(0);
    L11:
        r3 = null;
    L7:
        r2 = null;
        goto L9
    }

    public final Fragment p7() {
        LarusPageChatDoubleTabBinding r0 = this.e;
        if (r0 == null) goto L13;
        ViewPager2 r1 = r0.f;
        if (r1 == null) goto L13;
        ChatTitleTwoTabAdapt r2 = r1.getAdapter();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.larus.bmhome.view.title.ChatTitleTwoTabAdapt");
        ChatFragment r3 = (Fragment) r2.n.get(0);
        if ((r3 instanceof ChatFragment) == false) goto L9;
        ChatFragment r4 = r3;
    L10:
        if (r4 == null) goto L13;
        return r4;
    L9:
        r4 = null;
    L13:
        return this;
    }

    public final void py() {
        LarusPageChatDoubleTabBinding r0 = this.e;
        if (r0 == null) goto L7;
        ViewPager2 r1 = r0.f;
        if (r1 == null) goto L7;
        r1.setCurrentItem(0, false);
    L7:
        LarusPageChatDoubleTabBinding r2 = this.e;
        View r3 = null;
        if (r2 == null) goto L16;
        ViewPager2 r4 = r2.f;
        if (r4 == null) goto L16;
        if (r2 == null) goto L14;
        if (r4 == null) goto L14;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
    L15:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r5.height = -1;
        r4.setLayoutParams(r5);
    L14:
        r5 = null;
    L16:
        LarusPageChatDoubleTabBinding r6 = this.e;
        if (r6 == null) goto L21;
        FrameLayout r7 = r6.c;
        if (r7 == null) goto L21;
        com.larus.utils.e1.o(r7);
    L21:
        View r8 = this.l;
        if (r8 == null) goto L24;
        com.larus.utils.e1.x(r8);
    L24:
        IObricChatUIService r9 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r9 == null) goto L39;
        LarusPageChatDoubleTabBinding r10 = this.e;
        if (r10 == null) goto L29;
        FrameLayout r11 = r10.c;
    L30:
        View r12 = this.l;
        if (r12 == null) goto L33;
        ViewParent r13 = r12.getParent();
    L35:
        if ((r13 instanceof View) == false) goto L37;
        r3 = (View) r13;
    L37:
        r9.c(r11, r3);
        return;
    L33:
        r13 = null;
        goto L35
    L29:
        r11 = null;
        goto L30
    }

    public ChatDoubleTabFragment() {
        this.m = "other";
        this.q = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SwipingControlVm.class), new ChatDoubleTabFragment$special$$inlined$activityViewModels$default$1(this), new ChatDoubleTabFragment$special$$inlined$activityViewModels$default$2(this));
        this.r = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(TemplateViewModel.class), new ChatDoubleTabFragment$special$$inlined$activityViewModels$default$3(this), new ChatDoubleTabFragment$special$$inlined$activityViewModels$default$4(this));
    }

    public final ConversationPage V90() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        Serializable r1 = r0.getSerializable("conversation_page");
    L7:
        if ((r1 instanceof ConversationPage) == true) goto L9;
        return null;
    L9:
        return (ConversationPage) r1;
    L5:
        r1 = null;
        goto L7
    }

    public final boolean W90() {
        ConversationPage r0 = V90();
        if (r0 == null) goto L7;
        Boolean r1 = r0.getShowTmplInputBox();
        if (r1 == null) goto L7;
        return r1.booleanValue();
    L7:
        return false;
    }

    @Override // com.larus.bmhome.chat.component.doubletab.IChatDoubleTabAbility
    public final int getBizType() {
        ConversationPage r0 = V90();
        if (r0 == null) goto L7;
        List r1 = r0.getPageList();
        if (r1 == null) goto L7;
        Integer r2 = (Integer) CollectionsKt.getOrNull(r1, 1);
    L8:
        int r3 = PageType.IMAGE_TEMPLATE.getType();
        if (r2 != null) goto L12;
    L14:
        int r4 = PageType.MUSIC_TEMPLATE.getType();
        if (r2 != null) goto L18;
    L20:
        return 0;
    L18:
        if (r2.intValue() != r4) goto L20;
        return 2;
    L12:
        if (r2.intValue() != r3) goto L14;
        return 1;
    L7:
        r2 = null;
        goto L8
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        v.a.setValue(-1);
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        Function0<Unit> r0 = this.n;
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }

    public final void onResume() {
        super.onResume();
        LarusPageChatDoubleTabBinding r0 = this.e;
        if (r0 == null) goto L7;
        ChatConstraintLayout r1 = r0.a;
        if (r1 == null) goto L7;
        r1.post(new l(this));
    L7:
        com.larus.utils.v.a(this, new m(this));
    }

    public final g vc() {
        Fragment r0 = getChatFragment();
        if (r0 == null) goto L7;
        t1a.b r1 = s1a.a.g(r0);
        if (r1 == null) goto L7;
        return r1.getAbility(g.class);
    L7:
        return null;
    }

    @Override // com.larus.bmhome.chat.component.doubletab.IChatDoubleTabAbility
    public final String y00() {
        int r0 = getBizType();
        if (r0 == 1) goto L9;
        if (r0 == 2) goto L11;
        return null;
    L11:
        return AppHost.a.getApplication().getString(2131907191);
    L9:
        return AppHost.a.getApplication().getString(2131906506);
    }

    @Override // com.larus.bmhome.chat.f4
    public final void Bv(String r5) {
        LarusPageChatDoubleTabBinding r0 = this.e;
        if (r0 == null) goto L19;
        ViewPager2 r1 = r0.f;
        if (r1 == null) goto L20;
        ChatTitleTwoTabAdapt r2 = r1.getAdapter();
        ChatFragment r3 = null;
        if ((r2 instanceof ChatTitleTwoTabAdapt) == false) goto L9;
        ChatTitleTwoTabAdapt r4 = r2;
    L10:
        if (r4 == null) goto L12;
        Fragment r6 = (Fragment) r4.n.get(r1.getCurrentItem());
    L14:
        if ((r6 instanceof ChatFragment) == false) goto L16;
        r3 = (ChatFragment) r6;
    L16:
        if (r3 == null) goto L21;
        r3.Bv(r5);
        return;
    L21:
        return;
    L12:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L20:
        return;
    }

    public final void Ri(com.larus.bmhome.chat.component.bottom.s r2) {
        Intrinsics.checkNotNullParameter(r2, "pauseCallback");
        this.n = r2;
    }

    @Override // com.larus.bmhome.chat.f4
    public final void Sk(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        LarusPageChatDoubleTabBinding r0 = this.e;
        if (r0 == null) goto L19;
        ViewPager2 r1 = r0.f;
        if (r1 == null) goto L20;
        ChatTitleTwoTabAdapt r2 = r1.getAdapter();
        ChatFragment r3 = null;
        if ((r2 instanceof ChatTitleTwoTabAdapt) == false) goto L9;
        ChatTitleTwoTabAdapt r4 = r2;
    L10:
        if (r4 == null) goto L12;
        Fragment r6 = (Fragment) r4.n.get(r1.getCurrentItem());
    L14:
        if ((r6 instanceof ChatFragment) == false) goto L16;
        r3 = (ChatFragment) r6;
    L16:
        if (r3 == null) goto L21;
        r3.aa0(r5);
        return;
    L21:
        return;
    L12:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L20:
        return;
    }

    @Override // com.larus.bmhome.chat.component.doubletab.IChatDoubleTabAbility
    public final void f0(int r2) {
        LarusPageChatDoubleTabBinding r3 = this.e;
        if (r3 == null) goto L8;
        ViewPager2 r4 = r3.f;
        if (r4 == null) goto L9;
        r4.setCurrentItem(0);
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        Bundle r7 = getArguments();
        String r0 = "other";
        if (r7 == null) goto L8;
        String r8 = r7.getString("argPreviousPage", "other");
        if (r8 == null) goto L8;
        r0 = r8;
    L8:
        this.m = r0;
        Bundle r9 = getArguments();
        Integer r1 = null;
        if (r9 == null) goto L11;
        String r10 = r9.getString("argConversationId", null);
    L12:
        boolean r2 = false;
        if (r10 != null) goto L15;
    L18:
        boolean r3 = true;
    L19:
        if (r3 == false) goto L24;
        Function0<Unit> r4 = this.p;
        if (r4 == null) goto L23;
        r4.invoke();
    L25:
        Bundle r5 = getArguments();
        if (r5 == null) goto L31;
        int r11 = f5.a;
        ConversationPage r12 = V90();
        if (r12 == null) goto L30;
        r1 = r12.getDefaultStatus();
    L30:
        int r13 = r5.getInt("default_tab", f5.a(r1));
    L32:
        this.s = r13;
        Lazy r14 = com.larus.bmhome.chat.model.repo.j2.a;
        if (r10 != null) goto L35;
    L36:
        r2 = true;
    L37:
        if (r2 == true) goto L40;
        r13 = ((Keva) com.larus.bmhome.chat.model.repo.j2.a.getValue()).getInt("template_tab_index_" + r10, r13);
    L40:
        this.s = r13;
        v.a.setValue(Integer.valueOf(r13));
        return;
    L35:
        if (r10.length() != 0) goto L37;
    L31:
        r13 = 1;
        goto L32
    L23:
        requireActivity().finish();
        goto L25
    L24:
        this.i = r10;
        goto L25
    L15:
        if (r10.length() == 0) goto L18;
        r3 = false;
        goto L19
    L11:
        r10 = null;
        goto L12
    }

    @Override // xi8.a
    public final void NK(boolean r2, com.larus.bmhome.chat.component.share.n0 r3) {
        Intrinsics.checkNotNullParameter(r3, "onCloseClick");
        LarusPageChatDoubleTabBinding r4 = this.e;
        if (r4 == null) goto L8;
        ViewPager2 r5 = r4.f;
        if (r5 == null) goto L9;
        r5.setUserInputEnabled(!r2);
        return;
    L9:
        return;
    }

    public final void g00(View r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "inputView");
        Intrinsics.checkNotNullParameter(r3, "viewStub");
        this.l = r3;
        com.larus.utils.e1.o(r3);
        LarusPageChatDoubleTabBinding r4 = this.e;
        if (r4 == null) goto L7;
        FrameLayout r5 = r4.c;
        if (r5 == null) goto L7;
        r5.addView(r2);
    L7:
        FragmentActivity r6 = getActivity();
        if (r6 == null) goto L20;
        LarusPageChatDoubleTabBinding r7 = this.e;
        if (r7 == null) goto L14;
        ChatConstraintLayout r8 = r7.b;
        if (r8 == null) goto L14;
        r8.k6(r6);
    L14:
        LarusPageChatDoubleTabBinding r9 = this.e;
        if (r9 == null) goto L21;
        ChatConstraintLayout r10 = r9.b;
        if (r10 == null) goto L22;
        r10.setOnBottomInsetUpdateListener(new b(this));
        return;
    L22:
        return;
    L21:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v24, types: [com.larus.bmhome.chat.o] */
    /* JADX WARN: Type inference failed for: r1v37, types: [com.larus.bmhome.chat.n] */
    public final void onViewCreated(View r30, Bundle r31) {
        Intrinsics.checkNotNullParameter(r30, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r30, r31);
        LarusPageChatDoubleTabBinding r0 = this.e;
        if (r0 == null) goto L7;
        ChatConstraintLayout r1 = r0.a;
        if (r1 == null) goto L7;
        r1.T5();
    L7:
        LarusPageChatDoubleTabBinding r2 = this.e;
        if (r2 == null) goto L34;
        FrameLayout r3 = r2.e;
        if (r3.getChildCount() == 0) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == true) goto L15;
    L17:
        r3.removeAllViews();
        com.larus.platform.api.g0 r5 = new ChatTitleTwoTab(requireContext());
        Bundle r6 = getArguments();
        if (r6 == null) goto L20;
        String r7 = r6.getString("argBotId", "");
    L21:
        if (r7 != null) goto L23;
        r7 = "";
    L23:
        ((ChatTitleTwoTab) r5).s = r7;
        if (com.larus.platform.service.z2.a.getChatNavigatorConfig().a == false) goto L31;
        Bundle r8 = getArguments();
        if (r8 == null) goto L28;
        boolean r9 = r8.getBoolean("is_unread_dot_enable", true);
    L29:
        if (r9 == false) goto L31;
        boolean r10 = true;
    L32:
        r5.setDotEnable(r10);
        Ref.IntRef r11 = new Ref.IntRef();
        r11.element = -1;
        t r12 = new t(r11, this);
        Intrinsics.checkNotNullParameter(r12, "tabSelectListener");
        r5.getBinding().i.addOnTabSelectedListener(r12);
        this.k = r5;
        r3.addView(r5);
        ViewGroup.LayoutParams r13 = r5.getLayoutParams();
        r13.width = -1;
        r13.height = -1;
        com.larus.platform.api.g0 r14 = r5;
    L33:
        this.j = r14;
        goto L34
    L28:
        r9 = true;
    L31:
        r10 = false;
        goto L32
    L20:
        r7 = null;
        goto L21
    L15:
        if ((ViewGroupKt.get(r3, 0) instanceof com.larus.platform.api.g0) == false) goto L17;
        View r15 = ViewGroupKt.get(r3, 0);
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.larus.platform.api.IChatTitle");
        r14 = (com.larus.platform.api.g0) r15;
        goto L33
    L12:
        r4 = false;
    L34:
        this.g = new c(this);
        if (this.e == null) goto L157;
        com.larus.platform.api.g0 r16 = this.j;
        if (r16 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("title");
        r16 = null;
    L39:
        this.f = r16;
        Bundle r17 = getArguments();
        if (r17 == null) goto L42;
        String r18 = r17.getString("argConversationId", "");
    L43:
        if (r18 != null) goto L45;
        String r19 = "";
    L46:
        LarusPageChatDoubleTabBinding r20 = this.e;
        if (r20 == null) goto L74;
        ViewPager2 r21 = r20.f;
        if (r21 == null) goto L74;
        FragmentManager r22 = getChildFragmentManager();
        Lifecycle r23 = getLifecycle();
        Bundle r24 = getArguments();
        if (r24 == null) goto L53;
        String r25 = r24.getString("argBotId", "");
    L54:
        if (r25 != null) goto L56;
        String r26 = "";
    L57:
        Bundle r27 = getArguments();
        if (r27 == null) goto L60;
        RecommendFrom r28 = (RecommendFrom) r27.getParcelable("argBotRecommendFrom");
    L61:
        c r29 = this.g;
        String r32 = this.m;
        Bundle r33 = getArguments();
        if (r33 == null) goto L64;
        String r34 = r33.getString("enter_method", "");
    L65:
        if (r34 != null) goto L67;
        String r110 = "";
    L68:
        Bundle r111 = getArguments();
        TemplateViewModel r112 = (TemplateViewModel) this.r.getValue();
        LarusPageChatDoubleTabBinding r35 = this.e;
        if (r35 == null) goto L71;
        FrameLayout r210 = r35.e;
    L72:
        r21.setAdapter(new ChatTitleTwoTabAdapt(this, r22, r23, r19, r26, r28, r29, r32, r110, r111, r112, r210, W90(), new n(this), new o(this)));
        goto L74
    L71:
        r210 = null;
        goto L72
    L67:
        r110 = r34;
        goto L68
    L64:
        r34 = null;
        goto L65
    L60:
        r28 = null;
        goto L61
    L56:
        r26 = r25;
        goto L57
    L53:
        r25 = null;
    L74:
        final ChatDoubleTabFragment r36 = this;
        LarusPageChatDoubleTabBinding r37 = r36.e;
        if (r37 == null) goto L79;
        ViewPager2 r38 = r37.f;
        if (r38 == null) goto L79;
        int r39 = 1;
        r38.setOffscreenPageLimit(1);
    L80:
        ConversationPage r40 = V90();
        if (r40 == null) goto L90;
        List r41 = r40.getPageList();
        if (r41 == null) goto L90;
        Integer r42 = (Integer) CollectionsKt.getOrNull(r41, r39);
        int r43 = PageType.MUSIC_TEMPLATE.getType();
        if (r42 == null) goto L90;
        if (r42.intValue() != r43) goto L90;
        boolean r113 = true;
    L91:
        if (r113 == false) goto L93;
        String r44 = "music";
    L94:
        String r45 = r44;
        ChatTitleTwoTab r114 = r36.k;
        if (r114 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("chatTwoTitle");
        r114 = null;
    L97:
        LarusPageChatDoubleTabBinding r46 = r36.e;
        if (r36.s != r39) goto L100;
        boolean r115 = true;
    L101:
        r114.getClass();
        Intrinsics.checkNotNullParameter("", "title");
        Intrinsics.checkNotNullParameter(r45, "templateType");
        Ref.BooleanRef r47 = new Ref.BooleanRef();
        r47.element = r115;
        r114.getBinding().i.addOnTabSelectedListener(new wt8.y(r46, r19, r114, r47, r45));
        if (r46 == null) goto L106;
        ViewPager2 r48 = r46.f;
        if (r48 == null) goto L106;
        r48.registerOnPageChangeCallback(new ChatTitleTwoTab.setTitle.2(r114));
    L106:
        TabLayout r49 = r114.getBinding().i;
        Resources r50 = r49.getContext().getResources();
        String[] r51 = new String[2];
        r51[0] = r50.getString(2131906381);
        r51[r39] = r50.getString(2131906382);
        Iterator r52 = CollectionsKt.listOf(r51).iterator();
    L108:
        if (r52.hasNext() == false) goto L115;
        String r53 = (String) r52.next();
        TabLayout.Tab r54 = r49.newTab();
        r54.setCustomView(new DoubleColumnTitle(r49.getContext(), null));
        View r55 = r54.getCustomView();
        if (r55 == null) goto L114;
        TextView r56 = (TextView) r55.findViewById(2131391606);
        if (r56 == null) goto L114;
        r56.setText(r53);
    L114:
        r49.addTab(r54);
        goto L108
    L115:
        Continuation r116 = null;
        r114.getBinding().d.setVisibility(8);
        r114.getBinding().j.setVisibility(0);
        Bundle r57 = getArguments();
        if (r57 != null) goto L118;
    L120:
        boolean r117 = false;
    L121:
        if (r117 == false) goto L127;
        LarusPageChatDoubleTabBinding r58 = r36.e;
        if (r58 == null) goto L132;
        ViewPager2 r59 = r58.f;
        if (r59 == null) goto L132;
        r59.setCurrentItem(0, false);
    L132:
        LarusPageChatDoubleTabBinding r60 = r36.e;
        if (r60 == null) goto L138;
        ViewPager2 r61 = r60.f;
        if (r61 == null) goto L138;
        r61.registerOnPageChangeCallback(new ChatDoubleTabFragment$setupTitle$1$3(r36));
    L138:
        if (com.larus.bmhome.b0.b(this) == false) goto L146;
        com.larus.platform.api.g0 r118 = r36.j;
        if (r118 != null) goto L142;
        Intrinsics.throwUninitializedPropertyAccessException("title");
        r118 = null;
    L142:
        r118.setBackIconRes(v19.c.b(2130971852, getContext(), 2131242079));
        com.larus.platform.api.g0 r119 = r36.j;
        if (r119 != null) goto L145;
        Intrinsics.throwUninitializedPropertyAccessException("title");
        r119 = null;
    L145:
        r119.setOnBackClickListener(new p(r36));
    L150:
        com.larus.platform.api.g0 r120 = r36.j;
        if (r120 != null) goto L153;
        Intrinsics.throwUninitializedPropertyAccessException("title");
        r120 = null;
    L153:
        r120.setOnAddBotClickListener(new r(r36));
        com.larus.platform.api.g0 r121 = r36.j;
        if (r121 != null) goto L156;
        Intrinsics.throwUninitializedPropertyAccessException("title");
        r121 = null;
    L156:
        r121.setOnMoreClickListener(new s(r36));
        Unit r62 = Unit.INSTANCE;
    L158:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass3(r36, r116), 3, null);
        return;
    L146:
        com.larus.platform.api.g0 r122 = r36.j;
        if (r122 != null) goto L149;
        Intrinsics.throwUninitializedPropertyAccessException("title");
        r122 = null;
    L149:
        r122.setOnBackClickListener(new q(r36));
        goto L150
    L127:
        LarusPageChatDoubleTabBinding r63 = r36.e;
        if (r63 == null) goto L132;
        ViewPager2 r64 = r63.f;
        if (r64 == null) goto L132;
        r64.setCurrentItem(r36.s, false);
        goto L132
    L118:
        if (r57.getBoolean("is_from_template_detail") != r39) goto L120;
        r117 = true;
        goto L121
    L100:
        r115 = false;
        goto L101
    L93:
        r44 = "pic";
    L90:
        r113 = false;
    L79:
        r39 = 1;
        goto L80
    L45:
        r19 = r18;
        goto L46
    L42:
        r18 = null;
        goto L43
    L157:
        r116 = null;
        r36 = this;
        goto L158
    }

    public final void Lc(Bundle r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "bundle");
        if (isDetached() == false) goto L5;
    L12:
        FLogger.a.e("ChatDoubleTabFragment", "on result invalid trigger");
        return;
    L5:
        if (getActivity() == null) goto L12;
        FLogger.a.i("ChatDoubleTabFragment", "on result, code" + r7);
        ChatFragment r0 = p7();
        if ((r0 instanceof ChatFragment) == false) goto L9;
        ChatFragment r1 = r0;
    L10:
        if (r1 == null) goto L14;
        r1.Lc(r5, r6, r7);
        return;
    L14:
        return;
    L9:
        r1 = null;
        goto L10
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        ChatConstraintLayout r11 = r8.inflate(2131563016, r9, false);
        ChatConstraintLayout r12 = r11;
        int r13 = 2131375410;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(r11, 2131375410);
        if (r3 == null) goto L13;
        r13 = 2131386070;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r11, 2131386070);
        if (r4 == null) goto L13;
        r13 = 2131388843;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r11, 2131388843);
        if (r5 == null) goto L13;
        r13 = 2131392566;
        ViewPager2 r6 = ViewBindings.findChildViewById(r11, 2131392566);
        if (r6 == null) goto L13;
        this.e = new LarusPageChatDoubleTabBinding(r12, r12, r3, r4, r5, r6);
        return r12;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r13)));
    }
}
