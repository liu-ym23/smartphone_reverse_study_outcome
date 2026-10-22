package com.ss.android.lark.flow.mergeforward.page;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.FirstMessagePaddingType;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.biz.im.api.extension.chat_window.TitleBarActionKey;
import com.ss.android.lark.biz.im.api.extension.chat_window.k;
import com.ss.android.lark.biz.im.api.page.configurator.ConfiguratorType;
import com.ss.android.lark.biz.im.api.page.plugin.PluginType;
import com.ss.android.lark.biz.im.api.w0;
import com.ss.android.lark.biz.im.api.x0;
import com.ss.android.lark.chat.base.view.vo.message.AudioContentVO;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.CoreMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.MessageListFeatureSpecCompatKt;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.entity.theme.TitleTheme;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.flow.chat.titlebar.FlowTitleBarComponent;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import fsb.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import l3c.j;
import t6b.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020#H\u0016J&\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010,\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\u001fH\u0016J\u001a\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020'2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u00101\u001a\u00020!H\u0002J\"\u00102\u001a\u00020!2\u0006\u00103\u001a\u00020\u00052\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030605H\u0002J\u001c\u00107\u001a\u00020!2\u0006\u00103\u001a\u00020\u00052\n\u00108\u001a\u0006\u0012\u0002\b\u000306H\u0002J\b\u00109\u001a\u00020!H\u0016J\f\u0010:\u001a\u00020!*\u00020;H\u0014J\f\u0010<\u001a\u00020!*\u00020;H\u0014J\u000e\u0010=\u001a\b\u0012\u0004\u0012\u00020>05H\u0014J\u000e\u0010?\u001a\b\u0012\u0004\u0012\u00020@05H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/ss/android/lark/flow/mergeforward/page/FlowMergeForwardFragment;", "Lcom/ss/android/lark/im/base/page/BasePageFragment;", "<init>", "()V", "messageListComponent", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/CoreMessageListComponent;", "TAG", "", "chatAppContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "getChatAppContainer", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "setChatAppContainer", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;)V", "componentAdaptService", "Lcom/ss/android/lark/biz/officesdk/im/component/IOfficeComponentAdaptService;", "getComponentAdaptService", "()Lcom/ss/android/lark/biz/officesdk/im/component/IOfficeComponentAdaptService;", "componentAdaptService$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/ss/android/lark/flow/mergeforward/page/FlowMergeForwardViewModel;", "getViewModel", "()Lcom/ss/android/lark/flow/mergeforward/page/FlowMergeForwardViewModel;", "viewModel$delegate", "binding", "Lcom/ss/android/lark/flow/chat/databinding/FragmentFlowMergeForwardBinding;", "titleBarComponent", "Lcom/ss/android/lark/flow/chat/titlebar/FlowTitleBarComponent;", "closePageObserver", "Landroidx/lifecycle/Observer;", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onActivityCreated", "onWindowFocusChanged", "hasFocus", "onViewCreated", "view", "setupAudioVisiblePreloadIfNeeded", "preloadAllAudios", "component", LocationHitPoint$ResultType.LIST, "", "Lcom/ss/android/lark/chat/vo/ChatMessageVO;", "maybePreloadAudio", INotificationHitPoint.NoticeType.MESSAGE, "onDestroy", "initComponents", "Lcom/ss/android/lark/scaffold/ScaffoldScope;", "initViewModels", "configuratorTypes", "Lcom/ss/android/lark/biz/im/api/page/configurator/ConfiguratorType;", "pluginTypes", "Lcom/ss/android/lark/biz/im/api/page/plugin/PluginType;", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowMergeForwardFragment extends Hilt_FlowMergeForwardFragment {
    public static final /* synthetic */ int r = 0;
    public CoreMessageListComponent k;
    public final String l;

    @Inject
    public v m;
    public final Lazy n;
    public final Lazy o;
    public FlowTitleBarComponent p;
    public final a q;

    public static final class a<T> implements Observer {
        public final /* synthetic */ FlowMergeForwardFragment a;

        public a(FlowMergeForwardFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L6;
            FlowToast.c(this.a.requireContext(), 2131891886);
            zab.a.a(this.a);
            return;
        }
    }

    public static final class b implements i4b.a {
        public final /* synthetic */ FlowMergeForwardFragment a;
        public final /* synthetic */ FragmentActivity b;

        public final Function1 a(Chat r2) {
            Intrinsics.checkNotNullParameter(r2, "chat");
            return null;
        }

        public final /* synthetic */ boolean b() {
            return false;
        }

        public final CharSequence d(Chat r2) {
            Intrinsics.checkNotNullParameter(r2, "chat");
            return null;
        }

        public final Function1<View, Unit> e(Chat r2) {
            Intrinsics.checkNotNullParameter(r2, "chat");
            return null;
        }

        public final CharSequence c(Chat r4) {
            Intrinsics.checkNotNullParameter(r4, "chat");
            FlowMergeForwardFragment r5 = this.a;
            int r0 = FlowMergeForwardFragment.r;
            MergeForwardContent r6 = r5.Z90().getMessageContent();
            boolean r1 = false;
            if (r6 == null) goto L9;
            String r7 = r6.getTitle();
            if (r7 == null) goto L9;
            if ((!StringsKt.isBlank(r7)) != true) goto L9;
            boolean r8 = true;
        L10:
            String r2 = null;
            if (r8 == false) goto L16;
            MergeForwardContent r9 = this.a.Z90().getMessageContent();
            if (r9 == null) goto L30;
            r2 = r9.getTitle();
        L30:
            return String.valueOf(r2);
        L16:
            MergeForwardContent r10 = this.a.Z90().getMessageContent();
            if (r10 == null) goto L23;
            String r11 = r10.getQuasiTitle();
            if (r11 == null) goto L23;
            if ((!StringsKt.isBlank(r11)) != true) goto L23;
            r1 = true;
        L23:
            if (r1 == false) goto L28;
            MergeForwardContent r12 = this.a.Z90().getMessageContent();
            if (r12 == null) goto L31;
            r2 = r12.getQuasiTitle();
        L31:
            return String.valueOf(r2);
        L28:
            String r13 = UIUtils.getString(this.b, 2131891921);
            Intrinsics.checkNotNull(r13);
            return r13;
        L9:
            r8 = false;
            goto L10
        }

        public b(FlowMergeForwardFragment r1, FragmentActivity r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements w0 {
        public static final c b = null;

        static {
            b = new c();
        }

        public c() {
        }

        public final int a() {
            return -3;
        }
    }

    public static final class d implements com.ss.android.lark.biz.im.api.extension.chat_window.a<TitleBarActionKey> {
        public d() {
        }

        public final boolean a(TitleBarActionKey r2) {
            Intrinsics.checkNotNullParameter(r2, "param");
            if (r2 == TitleBarActionKey.FORWARD) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class e implements k {
        public final /* synthetic */ FlowMergeForwardFragment a;

        public final void d() {
        }

        public final void onHide() {
        }

        public final void onShow() {
        }

        public final TitleBarActionKey getKey() {
            return TitleBarActionKey.FORWARD;
        }

        public e(FlowMergeForwardFragment r1) {
            this.a = r1;
        }

        public final void f(View r2) {
            Intrinsics.checkNotNullParameter(r2, "actionView");
            Intrinsics.checkNotNullParameter(r2, "actionView");
        }

        public final Drawable g(TitleTheme.ThemeType r2) {
            Intrinsics.checkNotNullParameter(r2, "theme");
            return UDIconUtils.getIconDrawable(this.a.requireActivity(), 2131235464);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v5, types: [java.util.ArrayList] */
        public final void onClick(View r9) {
            Intrinsics.checkNotNullParameter(r9, "view");
            FlowMergeForwardFragment r10 = this.a;
            int r0 = FlowMergeForwardFragment.r;
            if (r10.Z90().getFromType() != 4) goto L18;
            int r11 = FlowChatModule.d;
            egb.e r1 = FlowChatModule.a.a().a().getForwardDependency();
            FragmentActivity r2 = this.a.requireActivity();
            Chat r12 = (Chat) this.a.Z90().getChat().getValue();
            if (r12 != null) goto L7;
            r12 = new Chat();
        L7:
            Chat r3 = r12;
            MergeForwardContent r13 = this.a.Z90().getMessageContent();
            if (r13 == null) goto L15;
            List r14 = r13.getMessages();
            if (r14 == null) goto L15;
            List r15 = r14;
            ?? r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
            Iterator r16 = r15.iterator();
        L13:
            if (r16.hasNext() == false) goto L16;
            r4.add(((Message) r16.next()).getId());
        L16:
            r1.a(r2, r3, new ArrayList((Collection) r4), -1, null);
            return;
        L15:
            r4 = CollectionsKt.emptyList();
            goto L16
        L18:
            Message r5 = this.a.Z90().getOriginMessage();
            if (r5 != null) goto L21;
            return;
        L21:
            int r17 = FlowChatModule.d;
            egb.e r6 = FlowChatModule.a.a().a().getForwardDependency();
            FragmentActivity r7 = this.a.requireActivity();
            String r18 = r5.getSourceId();
            if (r18 != null) goto L24;
            r18 = "";
        L24:
            egb.d.a(r6, r7, 1, r5, r18, false, this.a, 80);
        }
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final List<ConfiguratorType> T90() {
        return CollectionsKt.listOf(ConfiguratorType.MESSAGE_LIST);
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final List<PluginType> X90() {
        return CollectionsKt.listOf(PluginType.MERGE_FORWARD_PLUGIN_FACTORY);
    }

    public final v Y90() {
        v r0 = this.m;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("chatAppContainer");
        return null;
    }

    public final FlowMergeForwardViewModel Z90() {
        return (FlowMergeForwardViewModel) this.o.getValue();
    }

    @Inject
    public FlowMergeForwardFragment() {
        this.l = "FlowMergeForwardFragment";
        this.n = LazyKt.lazy(FlowMergeForwardFragment$componentAdaptService$2.INSTANCE);
        Function0<ViewModelProvider.Factory> r0 = new FlowMergeForwardFragment$viewModel$2(this);
        final Function0<Fragment> r1 = new FlowMergeForwardFragment$special$$inlined$viewModels$default$1(this);
        this.o = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FlowMergeForwardViewModel.class), new FlowMergeForwardFragment$special$$inlined$viewModels$default$2(r1), r0);
        this.q = new a(this);
    }

    public final void onDestroy() {
        super/*com.ss.android.lark.base.fragment.BaseFragment*/.onDestroy();
        eza.a r0 = (eza.a) this.n.getValue();
        if (r0 == null) goto L5;
        r0.p(this);
    L5:
        Z90().getClosePageInfo().removeObserver(this.q);
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final void V90(j r11) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        final FragmentActivity r0 = requireActivity();
        if (Z90().getMessageContent() != null) goto L6;
        Log.e(this.l, "mergeForwardContent is null, failed to initComponents.");
        return;
    L6:
        r11.b(new FlowMergeForwardFragment$initComponents$1(this, this));
        r11.b(FlowMergeForwardFragment$initComponents$2.INSTANCE);
        final FlowTitleBarComponent r1 = new FlowTitleBarComponent(Y90());
        r1.H = 2131102022;
        r1.F = new b(this, r0);
        this.p = r1;
        r11.c(2131379957, new FlowMergeForwardFragment$initComponents$4$1(r1));
        x0.a r2 = new x0.a();
        FragmentActivity r3 = requireActivity();
        Intrinsics.checkNotNullParameter(r3, "hostActivity");
        r2.a = r3;
        Intrinsics.checkNotNullParameter(this, "hostFragment");
        r2.b = this;
        fxa.b r4 = Z90().getChatBundle();
        Intrinsics.checkNotNullParameter(r4, "chatBundle");
        r2.c = r4;
        r2.f = false;
        r2.g = 65;
        r2.h = -1132462081;
        com.ss.android.lark.chat.mergeforward.b r5 = new com.ss.android.lark.chat.mergeforward.b(requireActivity(), Z90().getMessageContent(), Z90().getFromType(), this);
        Intrinsics.checkNotNullParameter(r5, "chatContext");
        r2.d = r5;
        FirstMessagePaddingType r6 = FirstMessagePaddingType.TITLE_AND_TAB;
        Intrinsics.checkNotNullParameter(r6, "value");
        r2.j = r6;
        Map r7 = MapsKt.mutableMapOf(new Pair[]{new Pair(g3b.v.class, new g3b.v(new g3b.v.a()))});
        Intrinsics.checkNotNullParameter(r7, "params");
        r2.i = r7;
        nhb.b r8 = new nhb.b(Z90(), Y90());
        Intrinsics.checkNotNullParameter(r8, "value");
        r2.e = r8;
        r2.p = false;
        r2.t = false;
        c r9 = c.b;
        Intrinsics.checkNotNullParameter(r9, "provider");
        r2.o = r9;
        v4b.c.a r10 = new v4b.c.a();
        r10.f = true;
        r10.e = true;
        r2.q = new v4b.c(r10);
        List r12 = exa.a.a;
        Intrinsics.checkNotNullParameter(r12, LocationHitPoint$ResultType.LIST);
        r2.s = r12;
        final o r13 = MessageListFeatureSpecCompatKt.a(new x0(r2));
        r13.c(FlowMergeForwardFragment$initComponents$params$2$1.INSTANCE);
        r13.e(new FlowMergeForwardFragment$initComponents$params$2$2(this));
        r13.d(FlowMergeForwardFragment$initComponents$params$2$3.INSTANCE);
        r11.c(2131379955, new FlowMergeForwardFragment$initComponents$5(r0, r13, this));
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final void W90(j r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        r3.g(ChatWindowOpenViewModel.class, new FlowMergeForwardFragment$initViewModels$1(this));
    }

    public final void onActivityCreated(Bundle r3) {
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onActivityCreated(r3);
        Z90().getClosePageInfo().observe(getViewLifecycleOwner(), this.q);
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final void onCreate(Bundle r3) {
        f.c("FlowMergeForwardFragment").j();
        f.b().i("onCreate");
        super.onCreate(r3);
        eza.a r4 = (eza.a) this.n.getValue();
        if (r4 == null) goto L5;
        r4.o(this);
    L5:
        Z90().loadChatInitData(null);
    }

    public final void onSaveInstanceState(Bundle r5) {
        Intrinsics.checkNotNullParameter(r5, "outState");
        com.ss.android.lark.mergeforward.b.a r0 = com.ss.android.lark.mergeforward.b.a;
        com.ss.android.lark.mergeforward.b.a = new com.ss.android.lark.mergeforward.b.a(Z90().getMessageContent(), Z90().getTranslatedMessageContent(), Z90().getOriginMessage());
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onSaveInstanceState(r5);
    }

    public final void onWindowFocusChanged(boolean r1) {
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onWindowFocusChanged(r1);
        f.b().g();
    }

    public static void aa0(CoreMessageListComponent r5, List r6) {
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L35;
        y6b.c r0 = (y6b.c) r7.next();
        if (r0.j() == true) goto L4;
        AudioContentVO r1 = r0.o;
        if ((r1 instanceof AudioContentVO) == false) goto L4;
        AudioContentVO r2 = r1;
        String r3 = r2.t;
        boolean r4 = false;
        if (r3 != null) goto L14;
    L17:
        boolean r8 = true;
    L18:
        if (r8 == false) goto L4;
        byte[] r9 = r2.v;
        if (r9 != null) goto L23;
    L29:
        if (r4 == true) goto L4;
        if (r2.s == AudioContent.AudioState.DOWNLOADING) goto L4;
        r5.mB(r0.c, AudioContent.AudioState.DONE);
        goto L4
    L23:
        if (r9.length != 0) goto L25;
        boolean r10 = true;
    L27:
        if ((!r10) != true) goto L29;
        r4 = true;
        goto L29
    L25:
        r10 = false;
        goto L27
    L14:
        if (r3.length() == 0) goto L17;
        r8 = false;
        goto L18
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        FlowTitleBarComponent r7 = this.p;
        if (r7 == null) goto L5;
        r7.r.b(new d());
        r7.r.a(new e(this));
    L5:
        com.ss.android.lark.insets.f r8 = WindowInsetsUtils.b(this);
        r8.k(true);
        r8.r(true);
        final CoreMessageListComponent r9 = this.k;
        if (r9 == null) goto L17;
        List r0 = CollectionsKt.toList(r9.Tc().getData());
        if ((!r0.isEmpty()) == false) goto L11;
        aa0(r9, r0);
        goto L17
    L11:
        final Ref.BooleanRef r1 = new Ref.BooleanRef();
        final com.ss.android.lark.biz.im.api.extension.chat_window.e r2 = new FlowMergeForwardFragment$setupAudioVisiblePreloadIfNeeded$callback$1(r9, r1, this);
        Intrinsics.checkNotNullParameter(r2, "callback");
        r9.F0().m(r2);
        List r3 = CollectionsKt.toList(r9.Tc().getData());
        Function0<Unit> r4 = new FlowMergeForwardFragment$setupAudioVisiblePreloadIfNeeded$1(r9, r2);
        if (r3.isEmpty() == true) goto L17;
        if (r1.element == true) goto L17;
        r1.element = true;
        r4.invoke();
        aa0(r9, r3);
    L17:
        f.b().h("onCreate");
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131561195, r3, false);
        FrameLayout r6 = (FrameLayout) r5;
        int r7 = 2131379955;
        if (((FrameLayout) ViewBindings.findChildViewById(r5, 2131379955)) == null) goto L11;
        r7 = 2131379957;
        if (((FrameLayout) ViewBindings.findChildViewById(r5, 2131379957)) == null) goto L11;
        r7 = 2131380364;
        if (ViewBindings.findChildViewById(r5, 2131380364) == null) goto L11;
        return r6;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r7)));
    }
}
