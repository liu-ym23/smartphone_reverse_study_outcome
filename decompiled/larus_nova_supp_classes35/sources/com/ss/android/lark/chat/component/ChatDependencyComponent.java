package com.ss.android.lark.chat.component;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.base.frame.FrameFragment;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.chat.chatwindow.biz.component.ChatBaseComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.plugin.NewIntentScrollMessagePlugin$newIntentHandler$2;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.flow.chat.page.flow.plugin.select.FlowMessageSelectPlugin;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.platform.dispatcher.d;
import com.ss.android.lark.platform.dispatcher.f;
import com.ss.android.lark.platform.dispatcher.h;
import com.ss.android.lark.scaffold.LogicComponent;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 H2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001HB'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u001f\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\"0!\u0012\u0004\u0012\u00020\"0 H\u0016J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020$H\u0016J\b\u0010&\u001a\u00020\u0005H\u0016J\u0017\u0010'\u001a\u0002H(\"\b\b\u0000\u0010(*\u00020)H\u0016¢\u0006\u0002\u0010*J\b\u0010+\u001a\u00020\u0007H\u0016J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u000201H\u0016J\n\u00102\u001a\u0004\u0018\u000103H\u0016J%\u00104\u001a\u0002H(\"\b\b\u0000\u0010(*\u0002052\f\u00106\u001a\b\u0012\u0004\u0012\u0002H(0!H\u0016¢\u0006\u0002\u00107J\b\u00108\u001a\u000209H\u0016J\u001a\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0010\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020\u0014H\u0016J\u0010\u0010A\u001a\u00020$2\u0006\u0010@\u001a\u00020\u0014H\u0016J\u0010\u0010B\u001a\u00020$2\u0006\u0010@\u001a\u00020\u001aH\u0016J\u0010\u0010C\u001a\u00020$2\u0006\u0010@\u001a\u00020\u001aH\u0016J\u0010\u0010D\u001a\u00020$2\u0006\u0010@\u001a\u00020\u0017H\u0016J\u0010\u0010E\u001a\u00020$2\u0006\u0010@\u001a\u00020\u0017H\u0016J\u0010\u0010F\u001a\u00020$2\u0006\u0010@\u001a\u00020\u001dH\u0016J\u0010\u0010G\u001a\u00020$2\u0006\u0010@\u001a\u00020\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/ss/android/lark/chat/component/ChatDependencyComponent;", "Lcom/ss/android/lark/scaffold/LogicComponent;", "Lcom/ss/android/lark/chat/component/ChatWindowAdapterComponent;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/ChatBaseComponent$ChatComponentDependency;", "fragment", "Landroidx/fragment/app/Fragment;", "viewModel", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowOpenViewModel;", "chatAppContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "dispatcher", "Lcom/ss/android/lark/platform/dispatcher/CompositeDispatcher;", "<init>", "(Landroidx/fragment/app/Fragment;Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowOpenViewModel;Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;Lcom/ss/android/lark/platform/dispatcher/CompositeDispatcher;)V", "activity", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "backPressedHandlers", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/IChatWindowApp$IBackPressHandler;", "Lcom/ss/android/lark/platform/dispatcher/OnBackPressedHandler;", "newIntentHandlers", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/IChatWindowApp$IOnNewIntentHandler;", "Lcom/ss/android/lark/platform/dispatcher/OnNewIntentHandler;", "activityResultHandlers", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/IChatWindowApp$IActivityResultHandler;", "Lcom/ss/android/lark/platform/dispatcher/OnActivityResultHandler;", "provideAssistContentHandlers", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/IChatWindowApp$IProvideAssistContentHandler;", "Lcom/ss/android/lark/platform/dispatcher/OnProvideAssistContentHandler;", "provideWidgetExport", BuildConfig.FLAVOR, "Ljava/lang/Class;", "Lcom/ss/android/lark/framework/larkwidget/WidgetExport;", "exitChat", BuildConfig.FLAVOR, "exitFragment", "getFragment", "get", "T", "Lcom/ss/android/lark/chat/api/IContainer;", "()Lcom/ss/android/lark/chat/api/IContainer;", "getChatWindowViewModel", "getIntentExtras", "Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "getContext", "Landroid/content/Context;", "getHost", BuildConfig.FLAVOR, "getKeyboardWrapper", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboardwrapper/IKeyboardWrapper;", "getViewModel", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/IDependencyViewModel;", "clazz", "(Ljava/lang/Class;)Lcom/ss/android/lark/biz/im/api/extension/chat_window/IDependencyViewModel;", "handleBack", BuildConfig.FLAVOR, "setActivityResult", "resultCode", BuildConfig.FLAVOR, Keys.API_RETURN_KEY_DATA, "Landroid/content/Intent;", "addBackPressHandler", "handle", "removeBackPressHandler", "addActivityResultHandler", "removeActivityResultHandler", "addNewIntentHandler", "removeNewIntentHandler", "addProvideAssistContentHandler", "removeProvideAssistContentHandler", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ChatDependencyComponent extends LogicComponent implements ChatWindowAdapterComponent, ChatBaseComponent.a {
    public final Fragment i;
    public final ChatWindowOpenViewModel j;
    public final v k;
    public final com.ss.android.lark.platform.dispatcher.a l;
    public final FragmentActivity m;
    public final ConcurrentHashMap<com.ss.android.lark.chat.chatwindow.chat.v2.component.c.InterfaceC0058c, f> n;
    public final ConcurrentHashMap<com.ss.android.lark.chat.chatwindow.chat.v2.component.c.d, h> o;
    public final ConcurrentHashMap<com.ss.android.lark.chat.chatwindow.chat.v2.component.c.b, d> p;

    public static final class a {
    }

    static {
    }

    public final Map<Class<? extends com.ss.android.lark.framework.larkwidget.c>, com.ss.android.lark.framework.larkwidget.c> z0() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(ChatWindowAdapterComponent.class, this), TuplesKt.to(ChatBaseComponent.a.class, this)});
    }

    @Override // m2b.b
    public final <T extends x1b.b> T get() {
        v r0 = this.k;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type T of com.ss.android.lark.chat.component.ChatDependencyComponent.get");
        return r0;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.ChatBaseComponent.a
    public void h() {
        if (KeyboardUtils.isSoftShowing(this.m) == false) goto L5;
        KeyboardUtils.hideKeyboard(this.m);
    L5:
        Context r0 = this.i.getContext();
        if (r0 == null) goto L10;
        boolean r1 = true;
        if (ForsetiConfig.a(r0) != true) goto L10;
    L11:
        if (r1 == true) goto L13;
    L25:
        this.m.onBackPressed();
        return;
    L13:
        if (fib.a.a() == false) goto L25;
        BaseFragment r2 = this.i;
        boolean r3 = r2 instanceof BaseFragment;
        BaseFragment r4 = null;
        if (r3 == false) goto L17;
        BaseFragment r5 = r2;
    L18:
        if (r5 != null) goto L20;
        this.m.onBackPressed();
        return;
    L20:
        if (r3 == false) goto L22;
        r4 = r2;
    L22:
        if (r4 == null) goto L28;
        zab.a.a(r4);
        return;
    L28:
        return;
    L17:
        r5 = null;
    L10:
        r1 = false;
        goto L11
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.c
    public final ChatWindowKeyboard n() {
        return a(IKeyboardComponent.class);
    }

    public final fxa.b u() {
        return this.j.getChatBundle();
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.ChatBaseComponent.a
    public final ChatWindowOpenViewModel c() {
        return this.j;
    }

    public final FragmentActivity getActivity() {
        return this.m;
    }

    @Override // com.ss.android.lark.chat.component.ChatWindowAdapterComponent, com.ss.android.lark.chat.chatwindow.chat.v2.component.c
    public Context getContext() {
        return this.m;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.ChatBaseComponent.a
    public final Fragment getFragment() {
        return this.i;
    }

    public final Object getHost() {
        return this.i;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.c
    public final void a0(Intent r3) {
        FragmentActivity r0 = this.m;
        if ((r0 instanceof i2b.a) == false) goto L5;
        ((i2b.a) r0).MS(r3);
        return;
    L5:
        r0.setResult(-1, r3);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.c
    public final ChatWindowOpenViewModel getViewModel(Class r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        ChatWindowOpenViewModel r3 = this.j;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type T of com.ss.android.lark.chat.component.ChatDependencyComponent.getViewModel");
        return r3;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.c
    public final void i(FlowMessageSelectPlugin.b r3) {
        Intrinsics.checkNotNullParameter(r3, "handle");
        com.ss.android.lark.chat.component.a r0 = new com.ss.android.lark.chat.component.a(r3);
        this.p.put(r3, r0);
        this.l.a(r0);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.c
    public final void k0(NewIntentScrollMessagePlugin$newIntentHandler$2.a r3) {
        Intrinsics.checkNotNullParameter(r3, "handle");
        c r0 = new c(r3);
        this.o.put(r3, r0);
        this.l.b(r0);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.c
    public final void p(FlowMessageSelectPlugin.h r3) {
        Intrinsics.checkNotNullParameter(r3, "handle");
        b r0 = new b(r3);
        this.n.put(r3, r0);
        this.l.e(r0);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.c
    public final void s(FlowMessageSelectPlugin.b r2) {
        Intrinsics.checkNotNullParameter(r2, "handle");
        d r3 = this.p.remove(r2);
        if (r3 == null) goto L6;
        this.l.d(r3);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.c
    public final void t(NewIntentScrollMessagePlugin$newIntentHandler$2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "handle");
        h r3 = this.o.remove(r2);
        if (r3 == null) goto L6;
        this.l.c(r3);
        return;
    }

    public ChatDependencyComponent(FrameFragment r2, ChatWindowOpenViewModel r3, v r4, com.ss.android.lark.platform.dispatcher.b r5) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "chatAppContainer");
        Intrinsics.checkNotNullParameter(r5, "dispatcher");
        this.i = r2;
        this.j = r3;
        this.k = r4;
        this.l = r5;
        this.m = r2.requireActivity();
        this.n = new ConcurrentHashMap();
        this.o = new ConcurrentHashMap();
        this.p = new ConcurrentHashMap();
        new ConcurrentHashMap();
    }
}
