package com.ss.android.lark.flow.chatthread;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.flow.chatthread.page.FlowChatThreadFragment;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/flow/chatthread/FlowChatThreadContainerFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "mFragment", "Lcom/ss/android/lark/flow/chatthread/page/FlowChatThreadFragment;", "getMFragment", "()Lcom/ss/android/lark/flow/chatthread/page/FlowChatThreadFragment;", "setMFragment", "(Lcom/ss/android/lark/flow/chatthread/page/FlowChatThreadFragment;)V", "onCreateView", "Landroid/widget/FrameLayout;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "", "initData", "setupFragment", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowChatThreadContainerFragment extends Hilt_FlowChatThreadContainerFragment implements d0c.c {

    @Inject
    public FlowChatThreadFragment f;

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
        return d0c.b.a(this);
    }

    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m359provideComponent() {
        return provideComponent();
    }

    @Inject
    public FlowChatThreadContainerFragment() {
    }

    public final void onCreate(Bundle r5) {
        super.onCreate(r5);     // Catch: Exception -> L4
    L10:
        if (getArguments() != null) goto L12;
        Log.e("ChatThread bundle param is null");
        zab.a.a(this);
    L12:
        Fragment r6 = this.f;
        Fragment r0 = null;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mFragment");
        r6 = null;
    L16:
        r6.setArguments(getArguments());
        FragmentTransaction r7 = getChildFragmentManager().beginTransaction();
        Fragment r2 = this.f;
        if (r2 == null) goto L19;
        r0 = r2;
    L20:
        String r1 = FlowChatThreadFragment.class.getName();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r7, r0, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r1, 2131373275) == true) goto L24;
        r7.add(2131373275, r0, r1);
    L24:
        r7.commitNowAllowingStateLoss();
        return;
    L19:
        Intrinsics.throwUninitializedPropertyAccessException("mFragment");
    L4:
        e = move-exception;
        ImSdk r3 = ImSdk.a;
        boolean r4 = ImSdk.c;
        boolean r8 = OfficeSDKManager.isAvailable();
        if (r8 == false) goto L26;
        if (r4 == true) goto L10;
    L26:
        Log.w("OfficeSDKInitGuard", "office sdk available: " + r8 + ", im sdk ready: " + r4 + ", onCreateFail. fallback. " + e.getMessage());
        int r9 = gza.a.a;
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        FrameLayout r4 = new FrameLayout(r1.getContext());
        r4.setId(2131365524);
        r4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return r4;
    }
}
