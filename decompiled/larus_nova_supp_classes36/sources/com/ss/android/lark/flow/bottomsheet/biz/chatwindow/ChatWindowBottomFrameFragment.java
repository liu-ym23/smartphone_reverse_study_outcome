package com.ss.android.lark.flow.bottomsheet.biz.chatwindow;

import android.app.assist.AssistContent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.base.frame.FrameFragment;
import com.ss.android.lark.biz.im.api.bundle.SourceType;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.utils.t0;
import com.ss.android.lark.flow.chat.page.flow.FlowChatFragment;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.statistics.PerfLog;
import d0c.b;
import d0c.c;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import fsb.f;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010%\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u001a\u0010&\u001a\u00020 2\b\u0010'\u001a\u0004\u0018\u00010\"2\u0006\u0010(\u001a\u00020\bH\u0002J\f\u0010)\u001a\u00020**\u00020\"H\u0002J\b\u0010+\u001a\u00020 H\u0002J\b\u0010,\u001a\u00020 H\u0002J\"\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\b\u00101\u001a\u0004\u0018\u00010*H\u0016J\u0012\u00102\u001a\u00020 2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020\bH\u0016J\u0012\u00106\u001a\u00020 2\b\u00107\u001a\u0004\u0018\u00010*H\u0016J\u0012\u00108\u001a\u00020\b2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020<H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006>"}, d2 = {"Lcom/ss/android/lark/flow/bottomsheet/biz/chatwindow/ChatWindowBottomFrameFragment;", "Lcom/ss/android/lark/bottomsheet/fragment/BottomSheetFrameFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "mChatId", "", "mIsFromNotification", "", "chatWindowFragment", "Lcom/ss/android/lark/flow/chat/page/flow/FlowChatFragment;", "getChatWindowFragment", "()Lcom/ss/android/lark/flow/chat/page/flow/FlowChatFragment;", "setChatWindowFragment", "(Lcom/ss/android/lark/flow/chat/page/flow/FlowChatFragment;)V", "userService", "Lcom/ss/android/lark/passportc/api/IPassportUserService;", "getUserService", "()Lcom/ss/android/lark/passportc/api/IPassportUserService;", "setUserService", "(Lcom/ss/android/lark/passportc/api/IPassportUserService;)V", "container", "Landroid/widget/FrameLayout;", "activityHookManager", "Lcom/ss/android/lark/chat/core/extension/ActivityHookManager;", "radiusTopContainer", "", "getRadiusTopContainer", "()F", "setRadiusTopContainer", "(F)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initContentContainer", "contentContainer", "configActivityHook", "resolveArguments", "arguments", "fromNewIntent", "pack", "Landroid/content/Intent;", "showChatFragment", "statisticsPrefIfNeed", "onActivityResult", "requestCode", "", "resultCode", "data", "onProvideAssistContent", "outContent", "Landroid/app/assist/AssistContent;", "handleBack", "onNewIntent", "intent", "notifyPush", "notice", "Lcom/ss/android/lark/notification/export/entity/Notice;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ChatWindowBottomFrameFragment extends Hilt_ChatWindowBottomFrameFragment implements c {
    public String l;
    public boolean m;

    @Inject
    public FlowChatFragment n;

    @Inject
    public m o;
    public FrameLayout p;
    public com.ss.android.lark.chat.core.extension.a q;
    public final float r;

    public static final class a {
    }

    static {
    }

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return b.a(this);
    }

    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return b.b(this);
    }

    public ChatWindowBottomFrameFragment() {
        this.r = 24.0f;
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    public final boolean l1() {
        FragmentManager r0 = getChildFragmentManager();
        FrameLayout r1 = this.p;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("container");
        r1 = null;
    L5:
        FrameFragment r2 = r0.findFragmentById(r1.getId());
        if (r2 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == true) goto L13;
    L18:
        com.ss.android.lark.chat.core.extension.a r4 = this.q;
        if (r4 != null) goto L21;
    L23:
        boolean r5 = false;
    L24:
        if (r5 == false) goto L26;
        return true;
    L26:
        return false;
    L21:
        if (r4.b() != true) goto L23;
        r5 = true;
        goto L24
    L13:
        if (r2.isAdded() == false) goto L18;
        if ((r2 instanceof FrameFragment) == false) goto L18;
        return r2.l1();
    L8:
        if (r2.isVisible() != true) goto L10;
        r3 = true;
        goto L11
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m3provideComponent() {
        return provideComponent();
    }

    public final float S90() {
        return this.r;
    }

    public final void A0(Intent r3) {
        if (r3 == null) goto L4;
        Bundle r0 = r3.getExtras();
    L5:
        V90(r0, true);
        if (r3 == null) goto L11;
        com.ss.android.lark.chat.core.extension.a r1 = this.q;
        if (r1 == null) goto L12;
        r1.e(r3);
        return;
    L12:
        return;
    L11:
        return;
    L4:
        r0 = null;
        goto L5
    }

    public final void aP(AssistContent r5) {
        FragmentManager r0 = getChildFragmentManager();
        FrameLayout r1 = this.p;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("container");
        r1 = null;
    L5:
        FrameFragment r2 = r0.findFragmentById(r1.getId());
        boolean r3 = false;
        if (r2 != null) goto L8;
    L10:
        if (r3 == true) goto L12;
    L16:
        com.ss.android.lark.chat.core.extension.a r4 = this.q;
        if (r4 == null) goto L20;
        r4.g(r5);
        return;
    L20:
        return;
    L12:
        if (r2.isAdded() == false) goto L16;
        if ((r2 instanceof FrameFragment) == false) goto L16;
        r2.aP(r5);
        goto L16
    L8:
        if (r2.isVisible() != true) goto L10;
        r3 = true;
        goto L10
    }

    public final void onCreate(Bundle r3) {
        ChatCoreModule.a().getPerfEnterChatMonitor().l(false);
        f.c("ChatWindowBottomFrameFragment").j();
        f.b().i("onCreate");
        super/*com.ss.android.lark.base.fragment.BaseFragment*/.onCreate(r3);
        if (ChatCoreModule.a().getLoginDependency().isLogin() == true) goto L6;
        finish();
        return;
    }

    public final boolean y30(Notice r2) {
        String r0 = this.l;
        if (r0 != null) goto L7;
        return true;
    L7:
        return t0.a(r2, r0);
    }

    public final void T90(FrameLayout r2, final Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "contentContainer");
        this.p = r2;
        V90(getArguments(), false);
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L5;
        this.q = new com.ss.android.lark.chat.core.extension.a(r4);
    L5:
        getViewLifecycleOwner().getLifecycle().addObserver(new ChatWindowBottomFrameFragment$configActivityHook$2(this, r3));
        com.ss.android.lark.chat.core.extension.a r5 = this.q;
        if (r5 == null) goto L8;
        r5.c(r3);
    L8:
        f.b().h("onCreate");
    }

    public final void V90(Bundle r7, boolean r8) {
        Bundle r0 = getArguments();
        Fragment r1 = null;
        if (r0 == null) goto L5;
        fxa.b r2 = fxa.a.a(r0);
    L7:
        if (r2 == null) goto L10;
        String r3 = r2.q();
        if (r3 == null) goto L10;
    L11:
        boolean r4 = true;
        if (StringsKt.equals("notification", r3, true) == false) goto L14;
        ChatCoreModule.a().getPerfEnterChatMonitor().a(SourceType.PUSH.value);
    L15:
        this.m = r4;
        Log.i("chatwindow", "statisticsPrefIfNeed:" + r3 + ", isFromNotification:" + this.m);
        if (r7 != null) goto L19;
        finish();
        return;
    L19:
        this.l = r7.getString("chatID");
        Log.i("chatwindow", "Enter chat:" + this.l);
        FragmentManager r5 = getChildFragmentManager();
        FrameLayout r6 = this.p;
        if (r6 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("container");
        r6 = null;
    L22:
        FlowChatFragment r9 = r5.findFragmentById(r6.getId());
        if (r9 == null) goto L28;
        if (r8 == false) goto L28;
        if ((r9 instanceof FlowChatFragment) == false) goto L45;
        Intent r10 = new Intent();
        r10.putExtras(r7);
        r9.A0(r10);
        return;
    L45:
        return;
    L28:
        PerfLog.start("showChatFragment", "");
        Fragment r11 = this.n;
        if (r11 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("chatWindowFragment");
        r11 = null;
    L32:
        r11.setArguments(getArguments());
        FragmentTransaction r12 = getChildFragmentManager().beginTransaction();
        FrameLayout r13 = this.p;
        if (r13 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("container");
        r13 = null;
    L35:
        int r14 = r13.getId();
        Fragment r15 = this.n;
        if (r15 == null) goto L38;
        r1 = r15;
    L39:
        String r16 = FlowChatFragment.class.getName();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r12, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r16, r14) == true) goto L43;
        r12.add(r14, r1, r16);
    L43:
        r12.commitAllowingStateLoss();
        return;
    L38:
        Intrinsics.throwUninitializedPropertyAccessException("chatWindowFragment");
        goto L39
    L14:
        r4 = false;
    L10:
        r3 = "";
        goto L11
    L5:
        r2 = null;
        goto L7
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r3, r4, r5);
        FragmentManager r0 = getChildFragmentManager();
        FrameLayout r1 = this.p;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("container");
        r1 = null;
    L5:
        Fragment r2 = r0.findFragmentById(r1.getId());
        if (r2 == null) goto L8;
        r2.onActivityResult(r3, r4, r5);
    L8:
        com.ss.android.lark.chat.core.extension.a r6 = this.q;
        if (r6 == null) goto L12;
        r6.a(r3, r4, r5);
        return;
    }
}
