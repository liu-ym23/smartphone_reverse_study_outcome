package com.ss.android.lark.flow.chat.page.flow;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.biz.im.api.page.configurator.ConfiguratorType;
import com.ss.android.lark.biz.im.api.page.plugin.PluginType;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.CoreMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.MessageListSpecPresets;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.messagesender.MessageSenderComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.flow.chat.statistics.perf.DoubaoReplyLatencyTracker$markTracePageInvisible$1;
import com.ss.android.lark.flow.chat.statistics.perf.DoubaoReplyLatencyTracker$onChatPageDestroyed$$inlined$discardByPredicate$1;
import com.ss.android.lark.flow.chat.statistics.perf.DoubaoReplyLatencyTracker$onChatPageDestroyed$$inlined$discardByPredicate$2;
import com.ss.android.lark.flow.chat.statistics.perf.DoubaoReplyLatencyTracker$onChatPageDestroyed$$inlined$discardByPredicate$3;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.insets.f;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ContextsKt;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.SequencesKt;
import l3c.j;
import t6b.e;
import t6b.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u001c2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010#\u001a\u00020\u00182\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u0018H\u0016J\b\u0010'\u001a\u00020\u0018H\u0016J\b\u0010(\u001a\u00020\u0018H\u0016J\f\u0010)\u001a\u00020\u0018*\u00020*H\u0014J\f\u0010+\u001a\u00020\u0018*\u00020*H\u0014J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-H\u0014J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u0002000-H\u0014J\n\u00101\u001a\u0004\u0018\u000102H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0014\u0010\u0015¨\u00064"}, d2 = {"Lcom/ss/android/lark/flow/chat/page/flow/FlowChatFragment;", "Lcom/ss/android/lark/im/base/page/BasePageFragment;", "<init>", "()V", "chatAppContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "getChatAppContainer", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "setChatAppContainer", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;)V", "componentAdaptService", "Lcom/ss/android/lark/biz/officesdk/im/component/IOfficeComponentAdaptService;", "getComponentAdaptService", "()Lcom/ss/android/lark/biz/officesdk/im/component/IOfficeComponentAdaptService;", "componentAdaptService$delegate", "Lkotlin/Lazy;", "binding", "Lcom/ss/android/lark/flow/chat/databinding/FragmentFlowChatBinding;", "viewModel", "Lcom/ss/android/lark/flow/chat/page/flow/FlowChatViewModel;", "getViewModel", "()Lcom/ss/android/lark/flow/chat/page/flow/FlowChatViewModel;", "viewModel$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "onStop", "onDestroy", "initComponents", "Lcom/ss/android/lark/scaffold/ScaffoldScope;", "initViewModels", "pluginTypes", "", "Lcom/ss/android/lark/biz/im/api/page/plugin/PluginType;", "configuratorTypes", "Lcom/ss/android/lark/biz/im/api/page/configurator/ConfiguratorType;", "getContext", "Landroid/content/Context;", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowChatFragment extends Hilt_FlowChatFragment {
    public static final /* synthetic */ int n = 0;

    @Inject
    public v k;
    public final Lazy l;
    public final Lazy m;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final List<ConfiguratorType> T90() {
        return CollectionsKt.listOf(new ConfiguratorType[]{ConfiguratorType.KEYBOARD_WRAPPER, ConfiguratorType.MESSAGE_LIST, ConfiguratorType.ACTIVITY_RESULT});
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final List<PluginType> X90() {
        return CollectionsKt.listOf(PluginType.FLOW_CHAT_PLUGIN_FACTORY);
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
    public FlowChatFragment() {
        this.l = LazyKt.lazy(FlowChatFragment$componentAdaptService$2.INSTANCE);
        Function0<ViewModelProvider.Factory> r0 = new FlowChatFragment$viewModel$2(this);
        final Function0<Fragment> r1 = new FlowChatFragment$special$$inlined$viewModels$default$1(this);
        this.m = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FlowChatViewModel.class), new FlowChatFragment$special$$inlined$viewModels$default$2(r1), r0);
    }

    @Override // com.ss.android.lark.flow.chat.page.flow.Hilt_FlowChatFragment, com.ss.android.lark.im.base.page.Hilt_BasePageFragment
    public Context getContext() {
        Context r0 = super.getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return ContextsKt.preferActivity(r0);
    }

    public final void onDestroy() {
        super/*com.ss.android.lark.base.fragment.BaseFragment*/.onDestroy();
        eza.a r0 = (eza.a) this.l.getValue();
        if (r0 == null) goto L5;
        r0.p(this);
    L5:
        final String r1 = Z90().getChatBundle().getChatId();
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        com.ss.android.lark.flow.chat.statistics.perf.a r2 = com.ss.android.lark.flow.chat.statistics.perf.a.a;
        Intrinsics.checkNotNullParameter(r1, "chatId");
        if (r1.length() != 0) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == true) goto L16;
        CollectionsKt.removeAll(com.ss.android.lark.flow.chat.statistics.perf.a.d.values(), new DoubaoReplyLatencyTracker$onChatPageDestroyed$$inlined$discardByPredicate$1(r1));
        CollectionsKt.removeAll(com.ss.android.lark.flow.chat.statistics.perf.a.e.values(), new DoubaoReplyLatencyTracker$onChatPageDestroyed$$inlined$discardByPredicate$2(r1));
        CollectionsKt.removeAll(com.ss.android.lark.flow.chat.statistics.perf.a.f.values(), new DoubaoReplyLatencyTracker$onChatPageDestroyed$$inlined$discardByPredicate$3(r1));
        return;
    L16:
        return;
    L11:
        r3 = false;
        goto L12
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        Z90().initChatParamUtils();
    }

    public final void onStop() {
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onStop();
        String r0 = Z90().getChatBundle().getChatId();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        com.ss.android.lark.flow.chat.statistics.perf.a r1 = com.ss.android.lark.flow.chat.statistics.perf.a.a;
        Intrinsics.checkNotNullParameter(r0, "chatId");
        if (r0.length() != 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == true) goto L28;
        Iterator<T> r3 = com.ss.android.lark.flow.chat.statistics.perf.a.c.values().iterator();
    L13:
        if (r3.hasNext() == false) goto L17;
        com.ss.android.lark.flow.chat.statistics.perf.a.C0039a r4 = (com.ss.android.lark.flow.chat.statistics.perf.a.C0039a) r3.next();
        if (Intrinsics.areEqual(r4.b, r0) == false) goto L13;
        r4.e = true;
        goto L13
    L17:
        Iterator r5 = SequencesKt.sequence(new DoubaoReplyLatencyTracker$markTracePageInvisible$1(null)).iterator();
    L19:
        if (r5.hasNext() == false) goto L39;
        com.ss.android.lark.flow.chat.statistics.perf.a.b r6 = (com.ss.android.lark.flow.chat.statistics.perf.a.b) r5.next();
        Intrinsics.checkNotNull(r6);
        if (Intrinsics.areEqual(r6.a, r0) == true) goto L23;
    L25:
        boolean r7 = false;
    L26:
        if (r7 == false) goto L19;
        r6.k = true;
        goto L19
    L23:
        if (r6.c != null) goto L25;
        r7 = true;
        goto L26
    L39:
        return;
    L28:
        return;
    L8:
        r2 = false;
        goto L9
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final void A0(Intent r5) {
        super.A0(r5);
        Map r6 = l7b.a.a;
        Iterator r7 = ((HashMap) l7b.a.a).entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L26;
        Dialog r0 = (Dialog) ((WeakReference) ((Map.Entry) r7.next()).getValue()).get();
        if (r0 == null) goto L4;
        if (r0.isShowing() == false) goto L4;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 == null) goto L14;
        if (Looper.myLooper() == r1.getLooper()) goto L14;
        r1.post(DialogLancet.createDismissRunnable(r0));
    L14:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(r0);
        goto L4
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L19:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r2 == null) goto L23;
        d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L23
    L26:
        ((HashMap) l7b.a.a).clear();
        Iterator r8 = ((HashMap) l7b.a.b).entrySet().iterator();
    L28:
        if (r8.hasNext() == false) goto L34;
        PopupWindow r3 = (PopupWindow) ((WeakReference) ((Map.Entry) r8.next()).getValue()).get();
        if (r3 == null) goto L28;
        if (r3.isShowing() == false) goto L28;
        PopupWindowLancet.handleDismissBeforeOrigin(r3);
        r3.dismiss();
        goto L28
    L34:
        ((HashMap) l7b.a.b).clear();
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final void V90(j r12) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        final FragmentActivity r0 = requireActivity();
        final Context r1 = getContext();
        if (r1 != null) goto L6;
        Log.e("FlowChatFragment", "context is null, failed to initComponents.");
        return;
    L6:
        r12.b(new FlowChatFragment$initComponents$1(this, this));
        r12.b(FlowChatFragment$initComponents$2.INSTANCE);
        r12.b(new FlowChatFragment$initComponents$3(this));
        final MessageSenderComponent r2 = new MessageSenderComponent(Y90());
        r2.getMessageSender();
        r12.b(new FlowChatFragment$initComponents$4(r2));
        r12.c(2131365610, new FlowChatFragment$initComponents$5(this));
        final Ref.ObjectRef r3 = new Ref.ObjectRef();
        FragmentActivity r4 = requireActivity();
        Lazy r5 = MessageListSpecPresets.a;
        o r6 = MessageListSpecPresets.a(requireActivity(), this, Z90().getChatBundle(), null);
        r6.c(FlowChatFragment$initComponents$6$1.INSTANCE);
        r6.e(new FlowChatFragment$initComponents$6$2(r1, this, r0, r3));
        r6.d(FlowChatFragment$initComponents$6$3.INSTANCE);
        FlowChatFragment$initComponents$6$4 r7 = FlowChatFragment$initComponents$6$4.INSTANCE;
        Intrinsics.checkNotNullParameter(r7, "patch");
        Object r8 = ((LinkedHashMap) ((s6b.a) r6).a).get(e.class);
        if ((r8 instanceof e) == true) goto L9;
        r8 = null;
    L9:
        s6b.b r9 = (e) r8;
        if (r9 == null) goto L20;
    L15:
        if (r9 == null) goto L18;
        Map r10 = ((s6b.a) r6).a;
        s6b.b r11 = r9.a();
        r7.invoke(r11);
        r10.put(e.class, r9.b(r11));
    L18:
        Unit r13 = Unit.INSTANCE;
        r3.element = new CoreMessageListComponent(r4, r6, Y90(), new c(this, null));
        r12.c(2131365560, new FlowChatFragment$initComponents$7(r3));
        r12.c(2131365548, new FlowChatFragment$initComponents$8(this, r1, r0));
        r12.b(FlowChatFragment$initComponents$9.INSTANCE);
        r12.c(2131373023, FlowChatFragment$initComponents$10.INSTANCE);
        return;
    L20:
        r9 = (s6b.b) e.class.getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L13
        ((s6b.a) r6).a.put(e.class, r9);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        Log.e("create base error", e);
        goto L18
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final void W90(j r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        r3.g(ChatWindowOpenViewModel.class, new FlowChatFragment$initViewModels$1(this));
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        eza.a r2 = (eza.a) this.l.getValue();
        if (r2 == null) goto L5;
        r2.o(this);
    L5:
        com.ss.android.lark.flow.chat.statistics.perf.a.g();
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        Z90().loadChatInitData(null);
        f r4 = WindowInsetsUtils.b(this);
        r4.k(true);
        r4.r(true);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        ConstraintLayout r5 = r2.inflate(2131561192, r3, false);
        int r6 = 2131365508;
        if (((FrameLayout) ViewBindings.findChildViewById(r5, 2131365508)) == null) goto L30;
        r6 = 2131365534;
        if (((FrameLayout) ViewBindings.findChildViewById(r5, 2131365534)) == null) goto L30;
        r6 = 2131365535;
        if (((FrameLayout) ViewBindings.findChildViewById(r5, 2131365535)) == null) goto L30;
        r6 = 2131365548;
        if (((FrameLayout) ViewBindings.findChildViewById(r5, 2131365548)) == null) goto L30;
        r6 = 2131365549;
        if (((FrameLayout) ViewBindings.findChildViewById(r5, 2131365549)) == null) goto L30;
        r6 = 2131365560;
        if (((FrameLayout) ViewBindings.findChildViewById(r5, 2131365560)) == null) goto L30;
        r6 = 2131365610;
        if (((FrameLayout) ViewBindings.findChildViewById(r5, 2131365610)) == null) goto L30;
        r6 = 2131365611;
        if (((FrameLayout) ViewBindings.findChildViewById(r5, 2131365611)) == null) goto L30;
        r6 = 2131373023;
        if (((FrameLayout) ViewBindings.findChildViewById(r5, 2131373023)) == null) goto L30;
        r6 = 2131373024;
        if (((FrameLayout) ViewBindings.findChildViewById(r5, 2131373024)) == null) goto L30;
        r6 = 2131373025;
        if (((FrameLayout) ViewBindings.findChildViewById(r5, 2131373025)) == null) goto L30;
        ConstraintLayout r7 = r5;
        if (ViewBindings.findChildViewById(r5, 2131380364) != null) goto L27;
        r6 = 2131380364;
        goto L30
    L27:
        return r7;
    L30:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
