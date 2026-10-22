package com.ss.android.lark.flow.mergeforward;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.columns.ColumnsUtils;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.table.TableUtils;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.utils.u;
import com.ss.android.lark.flow.mergeforward.page.FlowMergeForwardFragment;
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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\fH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006!"}, d2 = {"Lcom/ss/android/lark/flow/mergeforward/FlowMergeForwardContainerFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "mFragment", "Lcom/ss/android/lark/flow/mergeforward/page/FlowMergeForwardFragment;", "getMFragment", "()Lcom/ss/android/lark/flow/mergeforward/page/FlowMergeForwardFragment;", "setMFragment", "(Lcom/ss/android/lark/flow/mergeforward/page/FlowMergeForwardFragment;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowMergeForwardContainerFragment extends Hilt_FlowMergeForwardContainerFragment implements d0c.c {

    @Inject
    public FlowMergeForwardFragment f;

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

    public final void onDestroy() {
        super.onDestroy();
        TableUtils.a = null;
        ColumnsUtils.a = null;
        ChatCoreModule.a().getChatDependency().r();
        u.a.a.a();
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m449provideComponent() {
        return provideComponent();
    }

    @Inject
    public FlowMergeForwardContainerFragment() {
    }

    public final void onCreate(Bundle r5) {
        super.onCreate(r5);     // Catch: Exception -> L4
    L9:
        v4b.a.a(requireContext());
        return;
    L4:
        e = move-exception;
        ImSdk r0 = ImSdk.a;
        boolean r1 = ImSdk.c;
        boolean r2 = OfficeSDKManager.isAvailable();
        if (r2 == false) goto L11;
        if (r1 == true) goto L9;
    L11:
        Log.w("OfficeSDKInitGuard", "office sdk available: " + r2 + ", im sdk ready: " + r1 + ", onCreateFail. fallback. " + e.getMessage());
        int r6 = gza.a.a;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        Log.i("FlowMergeForwardContainerFragment", "container Fragment created");
        Fragment r6 = this.f;
        if (r6 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mFragment");
        r6 = null;
    L6:
        r6.setArguments(getArguments());
        FragmentTransaction r7 = getChildFragmentManager().beginTransaction();
        Fragment r1 = this.f;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFragment");
        r1 = null;
    L11:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r7, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131373275) == true) goto L14;
        r7.add(2131373275, r1, null);
    L14:
        r7.commitAllowingStateLoss();
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r2, r3, r4);
        FlowMergeForwardFragment r0 = this.f;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mFragment");
        r0 = null;
    L6:
        r0.onActivityResult(r2, r3, r4);
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        FrameLayout r4 = new FrameLayout(r1.getContext());
        r4.setId(2131373275);
        r4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return r4;
    }
}
