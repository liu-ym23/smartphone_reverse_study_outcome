package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.MessageFullScreenPluginAdapter$observer$2;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.MessageFullScreenRichTextSetup;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@DwarfInjectPoint(parent = MessageFullScreenActivity.class)
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0001GB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J&\u0010.\u001a\u0004\u0018\u00010%2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u001c2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001a\u00102\u001a\u00020+2\u0006\u00103\u001a\u00020%2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u00104\u001a\u00020+2\b\u00105\u001a\u0004\u0018\u000106J\u0010\u00107\u001a\u00020+2\u0006\u00108\u001a\u00020%H\u0002J\u0010\u00109\u001a\u00020+2\u0006\u00108\u001a\u00020%H\u0002J\b\u0010:\u001a\u00020+H\u0002J\u0010\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020+H\u0002J\b\u0010F\u001a\u00020+H\u0016R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010?\u001a\u0014\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020+0@X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010C\u001a\u001c\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020B\u0012\u0006\u0012\u0004\u0018\u00010E\u0012\u0004\u0012\u00020+0DX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/MessageFullScreenFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "chatContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "getChatContainer", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "setChatContainer", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;)V", "offlineCacheClean", "Lcom/ss/android/lark/chat/export/offlineCacheClean/IOfflineCacheClean;", "getOfflineCacheClean", "()Lcom/ss/android/lark/chat/export/offlineCacheClean/IOfflineCacheClean;", "setOfflineCacheClean", "(Lcom/ss/android/lark/chat/export/offlineCacheClean/IOfflineCacheClean;)V", "exitAction", "Lcom/ss/android/lark/chat/export/offlineCacheClean/IOfflineCacheCleanAction;", "viewModel", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/MessageFullScreenViewModel;", "getViewModel", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/MessageFullScreenViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "messageDetailWrapper", "Landroid/view/ViewGroup;", "contentTV", "Lcom/ss/android/lark/widget/light/LKUILightTextView;", "translateTV", "contentZone", "Landroidx/constraintlayout/widget/ConstraintLayout;", "attachmentList", "Landroid/widget/LinearLayout;", "dividerView", "Landroid/view/View;", "setup", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/view/MessageFullScreenRichTextSetup;", "pluginContainers", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/plugin/MessageFullScreenPluginAdapter;", "onCreate", BuildConfig.FLAVOR, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "onViewCreated", "view", "onNewIntent", "intent", "Landroid/content/Intent;", "fitWindow", "rootView", "initView", "initViewModel", "bindAttachments", "initData", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/MessageFullScreenViewModel$InitData;", "initPlugins", "replyMessageHandler", "Lkotlin/Function2;", BuildConfig.FLAVOR, "Lcom/ss/android/lark/biz/im/extension/PageType;", "replyPartialMessageHandler", "Lkotlin/Function3;", "Lcom/ss/android/lark/chat/entity/message/PartialReplyInfo;", "onDestroy", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageFullScreenFragment extends Hilt_MessageFullScreenFragment implements d0c.c {
    public static final /* synthetic */ int t = 0;

    @Inject
    public v f;

    @Inject
    public com.ss.android.lark.chat.export.offlineCacheClean.a g;
    public final b h;
    public final Lazy i;
    public ViewGroup j;
    public LKUILightTextView k;
    public LKUILightTextView l;
    public ConstraintLayout m;
    public LinearLayout n;
    public View o;
    public MessageFullScreenRichTextSetup p;
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.b q;
    public final Function2<String, PageType, Unit> r;
    public final Function3<String, PageType, PartialReplyInfo, Unit> s;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.chat.export.offlineCacheClean.b {
        public final /* synthetic */ MessageFullScreenFragment a;

        @Override // com.ss.android.lark.chat.export.offlineCacheClean.b
        public final void a() {
            Context r0 = this.a.getContext();
            if (r0 == null) goto L7;
            boolean r1 = true;
            if (ForsetiConfig.a(r0) != true) goto L7;
        L8:
            if (r1 == false) goto L10;
            zab.a.a(this.a);
            return;
        L10:
            this.a.finish();
            return;
        L7:
            r1 = false;
            goto L8
        }

        public b(MessageFullScreenFragment r1) {
            this.a = r1;
        }
    }

    static {
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

    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    public final MessageFullScreenViewModel T90() {
        return (MessageFullScreenViewModel) this.i.getValue();
    }

    public MessageFullScreenFragment() {
        this.h = new b(this);
        final Function0<Fragment> r0 = new MessageFullScreenFragment$special$$inlined$viewModels$default$1(this);
        this.i = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MessageFullScreenViewModel.class), new MessageFullScreenFragment$special$$inlined$viewModels$default$2(r0), new MessageFullScreenFragment$special$$inlined$viewModels$default$3(r0, this));
        this.r = new MessageFullScreenFragment$replyMessageHandler$1(this);
        this.s = new MessageFullScreenFragment$replyPartialMessageHandler$1(this);
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    public final void onDestroy() {
        super.onDestroy();
        MessageFullScreenRichTextSetup r0 = this.p;
        if (r0 == null) goto L8;
        Iterator r1 = ((HashMap) r0.g).entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        ((com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.a) ((Map.Entry) r1.next()).getValue()).clear();
    L8:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.b r2 = this.q;
        if (r2 == null) goto L11;
        r2.a.getLifecycle().removeObserver((MessageFullScreenPluginAdapter$observer$2.AnonymousClass1) r2.d.getValue());
    L11:
        com.ss.android.lark.chat.export.offlineCacheClean.a r3 = this.g;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("offlineCacheClean");
        r3 = null;
    L15:
        r3.Ib(this.h);
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m375provideComponent() {
        return provideComponent();
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        com.ss.android.lark.chat.export.offlineCacheClean.a r3 = this.g;
        if (r3 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("offlineCacheClean");
        r3 = null;
    L6:
        r3.Wa(this.h);
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        ViewCompat.setOnApplyWindowInsetsListener(r2, new h(this));
        this.k = r2.findViewById(2131390392);
        this.l = r2.findViewById(2131391649);
        this.m = r2.findViewById(2131375311);
        this.n = (LinearLayout) r2.findViewById(2131363346);
        this.o = r2.findViewById(2131369197);
        this.j = (ViewGroup) r2.findViewById(2131379980);
        int r4 = MessageFullScreenRichTextSetup.k;
        Context r5 = requireContext();
        Function1<MessageFullScreenRichTextSetup, Unit> r6 = new MessageFullScreenFragment$initView$1(this);
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "setup");
        MessageFullScreenRichTextSetup r0 = new MessageFullScreenRichTextSetup(r5);
        r6.invoke(r0);
        this.p = r0;
        T90().getError().observe(this, new i(this));
        T90().getInitLiveData().observe(this, new j(this));
        T90().getLaunch().observe(this, new k(this));
        T90().getChatLiveData().observe(this, new l(this));
        T90().parseArguments(getArguments());
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561221, r3, false);
    }
}
