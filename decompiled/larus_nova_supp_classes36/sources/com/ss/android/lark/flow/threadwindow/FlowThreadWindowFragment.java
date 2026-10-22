package com.ss.android.lark.flow.threadwindow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;
import com.ss.android.lark.biz.im.api.FirstMessagePaddingType;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.biz.im.api.page.configurator.ConfiguratorType;
import com.ss.android.lark.biz.im.api.page.plugin.PluginType;
import com.ss.android.lark.biz.im.api.x0;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.CoreMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.MessageListFeatureSpecCompatKt;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.MessageListDataFeature;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.flow.chat.databinding.FragmentFlowThreadWindowBinding;
import com.ss.android.lark.flow.chat.page.flow.FlowChatViewModel;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.component.FlowKeyboardComponent;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001;B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u001d\u001a\u00020\u001e*\u00020\u001fH\u0014J$\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u001a\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010*\u001a\u00020\u001eH\u0002J\b\u0010+\u001a\u00020\u001eH\u0002J\b\u0010,\u001a\u00020\u001eH\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002J\u0014\u00101\u001a\u00020\u001e2\n\u00102\u001a\u0006\u0012\u0002\b\u000303H\u0002J\f\u00104\u001a\u00020\u001e*\u00020\u001fH\u0014J\u000e\u00105\u001a\b\u0012\u0004\u0012\u00020706H\u0014J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020906H\u0014J\b\u0010:\u001a\u00020\u001eH\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/ss/android/lark/flow/threadwindow/FlowThreadWindowFragment;", "Lcom/ss/android/lark/im/base/page/BasePageFragment;", "<init>", "()V", "chatAppContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "getChatAppContainer", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "setChatAppContainer", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;)V", "chatBundle", "Lcom/ss/android/lark/biz/im/api/bundle/ChatBundle;", "getChatBundle", "()Lcom/ss/android/lark/biz/im/api/bundle/ChatBundle;", "chatBundle$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/ss/android/lark/flow/chat/page/flow/FlowChatViewModel;", "getViewModel", "()Lcom/ss/android/lark/flow/chat/page/flow/FlowChatViewModel;", "viewModel$delegate", "binding", "Lcom/ss/android/lark/flow/chat/databinding/FragmentFlowThreadWindowBinding;", "listCommands", "Lcom/ss/android/lark/flow/threadwindow/FlowThreadWindowListCommands;", "flowKeyboardComponent", "Lcom/ss/android/lark/keyboard/component/FlowKeyboardComponent;", "coreMessageListComponent", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/CoreMessageListComponent;", "initComponents", "", "Lcom/ss/android/lark/scaffold/ScaffoldScope;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupCreateTopicCta", "showKeyboardInput", "revealKeyboardArea", "buildMessageListSpec", "Lcom/ss/android/lark/chat/spec/messagelist/MessageListSpec;", "activity", "Landroidx/fragment/app/FragmentActivity;", "handleTopicContentClick", "item", "Lcom/ss/android/lark/chat/vo/ChatMessageVO;", "initViewModels", "configuratorTypes", "", "Lcom/ss/android/lark/biz/im/api/page/configurator/ConfiguratorType;", "pluginTypes", "Lcom/ss/android/lark/biz/im/api/page/plugin/PluginType;", "onDestroyView", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowThreadWindowFragment extends Hilt_FlowThreadWindowFragment {
    public static final /* synthetic */ int r = 0;

    @Inject
    public v k;
    public final Lazy l;
    public final Lazy m;
    public FragmentFlowThreadWindowBinding n;
    public j o;
    public FlowKeyboardComponent p;
    public CoreMessageListComponent q;

    public static final class a {
    }

    public static final class b implements MessageListDataFeature.a {
        public final /* synthetic */ FlowThreadWindowFragment a;

        public b(FlowThreadWindowFragment r1) {
            this.a = r1;
        }

        public final void b(IMessageListViewModel r3) {
            Intrinsics.checkNotNullParameter(r3, "viewModel");
            FlowThreadWindowFragment r0 = this.a;
            if ((r3 instanceof j) == false) goto L5;
            j r4 = (j) r3;
        L6:
            r0.o = r4;
            return;
        L5:
            r4 = null;
            goto L6
        }

        public final FlowThreadWindowListViewModelFactory a(i7b.a r4, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.b r5) {
            Intrinsics.checkNotNullParameter(r4, "initData");
            Intrinsics.checkNotNullParameter(r5, "dependency");
            FlowThreadWindowFragment r1 = this.a;
            int r2 = FlowThreadWindowFragment.r;
            return new FlowThreadWindowListViewModelFactory((ChatBundle) r1.l.getValue(), this.a.Y90(), r4, r5.o());
        }
    }

    static {
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final List<ConfiguratorType> T90() {
        return CollectionsKt.listOf(new ConfiguratorType[]{ConfiguratorType.KEYBOARD_WRAPPER, ConfiguratorType.MESSAGE_LIST, ConfiguratorType.ACTIVITY_RESULT});
    }

    public final void onDestroyView() {
        this.o = null;
        this.p = null;
        super/*com.ss.android.lark.base.fragment.BaseFragment*/.onDestroyView();
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final List<PluginType> X90() {
        return CollectionsKt.listOf(PluginType.FLOW_THREAD_WINDOW_PLUGIN_FACTORY);
    }

    public final v Y90() {
        v r0 = this.k;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("chatAppContainer");
        return null;
    }

    public final FlowChatViewModel Z90() {
        return (FlowChatViewModel) this.m.getValue();
    }

    @Inject
    public FlowThreadWindowFragment() {
        this.l = LazyKt.lazy(new FlowThreadWindowFragment$chatBundle$2(this));
        Function0<ViewModelProvider.Factory> r0 = new FlowThreadWindowFragment$viewModel$2(this);
        final Function0<Fragment> r1 = new FlowThreadWindowFragment$special$$inlined$viewModels$default$1(this);
        this.m = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FlowChatViewModel.class), new FlowThreadWindowFragment$special$$inlined$viewModels$default$2(r1), r0);
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final void V90(l3c.j r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        final FragmentActivity r2 = requireActivity();
        r8.b(new FlowThreadWindowFragment$initComponents$1(this));
        r8.b(FlowThreadWindowFragment$initComponents$2.INSTANCE);
        r8.b(new FlowThreadWindowFragment$initComponents$3(this));
        r8.b(new FlowThreadWindowFragment$initComponents$4(this));
        r8.c(2131373042, new FlowThreadWindowFragment$initComponents$5(this));
        x0.a r1 = new x0.a();
        Intrinsics.checkNotNullParameter(r2, "hostActivity");
        r1.a = r2;
        Intrinsics.checkNotNullParameter(this, "hostFragment");
        r1.b = this;
        fxa.b r3 = Z90().getChatBundle();
        Intrinsics.checkNotNullParameter(r3, "chatBundle");
        r1.c = r3;
        r1.f = true;
        r1.g = -8193;
        r1.h = -1132462081;
        FirstMessagePaddingType r4 = FirstMessagePaddingType.TITLE_AND_TAB;
        Intrinsics.checkNotNullParameter(r4, "value");
        r1.j = r4;
        c r5 = new c();
        Intrinsics.checkNotNullParameter(r5, "value");
        r1.k = r5;
        r1.m = d.a;
        r1.n = e.a;
        f r6 = f.b;
        Intrinsics.checkNotNullParameter(r6, "provider");
        r1.o = r6;
        r1.t = false;
        Intrinsics.checkNotNullParameter(FlowThreadWindowListViewModel.class, "viewModelClass");
        r1.u = FlowThreadWindowListViewModel.class;
        t6b.o r7 = MessageListFeatureSpecCompatKt.a(new x0(r1));
        r7.c(FlowThreadWindowFragment$buildMessageListSpec$1$1.INSTANCE);
        r7.e(new FlowThreadWindowFragment$buildMessageListSpec$1$2(this, r2));
        r7.d(FlowThreadWindowFragment$buildMessageListSpec$1$3.INSTANCE);
        this.q = new CoreMessageListComponent(r2, r7, Y90(), new com.ss.android.lark.flow.chat.page.flow.c(this, new FlowThreadWindowFragment$initComponents$6(this)), new b(this));
        r8.c(2131373040, new FlowThreadWindowFragment$initComponents$8(this));
        r8.c(2131365548, new FlowThreadWindowFragment$initComponents$9(this));
        r8.b(FlowThreadWindowFragment$initComponents$10.INSTANCE);
        r8.a(FlowThreadWindowFragment$initComponents$11.INSTANCE);
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final void W90(l3c.j r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        r3.g(ChatWindowOpenViewModel.class, new FlowThreadWindowFragment$initViewModels$1(this));
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        FragmentFlowThreadWindowBinding r5 = this.n;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L5:
        r5.b.setVisibility(8);
        FragmentFlowThreadWindowBinding r6 = this.n;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L8:
        LinearLayout r7 = r6.d;
        r7.setOnClickListener(new g(r7, this));
        Z90().loadChatInitData(null);
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        ConstraintLayout r12 = r9.inflate(2131561197, r10, false);
        int r13 = 2131365548;
        FrameLayout r2 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131365548);
        if (r2 == null) goto L21;
        r13 = 2131373025;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131373025);
        if (r3 == null) goto L21;
        r13 = 2131373038;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131373038);
        if (r4 == null) goto L21;
        r13 = 2131373039;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131373039);
        if (r5 == null) goto L21;
        r13 = 2131373040;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131373040);
        if (r6 == null) goto L21;
        ConstraintLayout r14 = r12;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131373042);
        if (r7 != null) goto L15;
        r13 = 2131373042;
        goto L21
    L15:
        if (ViewBindings.findChildViewById(r12, 2131380364) == null) goto L18;
        this.n = new FragmentFlowThreadWindowBinding(r14, r2, r3, r4, r5, r6, r7);
        return r14;
    L18:
        r13 = 2131380364;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}
