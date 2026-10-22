package com.ss.android.lark.flow.threadwindow;

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
import com.ss.android.lark.chat.utils.t0;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\"\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018H\u0016J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0012\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J\u0014\u0010%\u001a\u0004\u0018\u00010\u00072\b\u0010&\u001a\u0004\u0018\u00010\u000bH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/ss/android/lark/flow/threadwindow/FlowThreadWindowContainerFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "Lcom/ss/android/lark/notification/export/IPushNotifyStrategy;", "<init>", "()V", "chatId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupFragment", "args", "onNewIntent", "intent", "Landroid/content/Intent;", "onActivityResult", "requestCode", "", "resultCode", "data", "handleBack", "", "shouldNotifyPush", "notice", "Lcom/ss/android/lark/notification/export/entity/Notice;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "getChatId", "bundle", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowThreadWindowContainerFragment extends Hilt_FlowThreadWindowContainerFragment implements d0c.c, zsb.d {
    public String f;

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

    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m515provideComponent() {
        return provideComponent();
    }

    @Inject
    public FlowThreadWindowContainerFragment() {
    }

    public final void A0(Intent r5) {
        if (r5 == null) goto L25;
        Bundle r0 = r5.getExtras();
        if (r0 == null) goto L26;
        String r2 = r0.getString("chatID");
        if (r2 != null) goto L9;
        r2 = r0.getString("chatID");
    L9:
        if (r2 != null) goto L11;
    L14:
        boolean r1 = true;
    L15:
        if (r1 == false) goto L17;
        return;
    L17:
        FlowThreadWindowFragment r3 = getChildFragmentManager().findFragmentByTag(FlowThreadWindowFragment.class.getName());
        if ((r3 instanceof FlowThreadWindowFragment) == true) goto L20;
    L23:
        T90(r0);
        return;
    L20:
        if (Intrinsics.areEqual(r2, this.f) == false) goto L23;
        r3.A0(r5);
        return;
    L11:
        if (r2.length() == 0) goto L14;
        r1 = false;
        goto L15
    L26:
        return;
    }

    @Override // zsb.d
    public final boolean Cy(Notice r2) {
        String r0 = this.f;
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        return t0.c(r2, r0);
    }

    public final void T90(Bundle r5) {
        if (r5 == null) goto L6;
        String r1 = r5.getString("chatID");
        if (r1 == null) goto L6;
    L10:
        if ((getChildFragmentManager().findFragmentByTag(FlowThreadWindowFragment.class.getName()) instanceof FlowThreadWindowFragment) == true) goto L12;
    L14:
        this.f = r1;
        FlowThreadWindowFragment r0 = new FlowThreadWindowFragment();
        r0.setArguments(r5);
        FragmentTransaction r6 = getChildFragmentManager().beginTransaction();
        String r2 = FlowThreadWindowFragment.class.getName();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r6, r0, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r2, 2131373275) == true) goto L18;
        r6 = r6.replace(2131373275, r0, r2);
    L18:
        r6.commitAllowingStateLoss();
        return;
    L12:
        if (Intrinsics.areEqual(r1, this.f) == false) goto L14;
        return;
    L6:
        if (r5 == null) goto L8;
        r1 = r5.getString("chatID");
        goto L10
    L8:
        r1 = null;
        goto L10
    }

    public final void onCreate(Bundle r2) {
        if (r2 == null) goto L4;
        r2.remove("android:support:fragments");
    L4:
        super.onCreate(r2);
        v4b.a.a(requireContext());
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        T90(getArguments());
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r3, r4, r5);
        Fragment r0 = getChildFragmentManager().findFragmentById(2131373275);
        if (r0 == null) goto L6;
        r0.onActivityResult(r3, r4, r5);
        return;
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        FrameLayout r4 = new FrameLayout(r1.getContext());
        r4.setId(2131373275);
        r4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return r4;
    }
}
