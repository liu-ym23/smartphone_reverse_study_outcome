package com.ss.android.lark.flow.bottomsheet.biz.threadwindow;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentTransaction;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.base.frame.FrameFragment;
import com.ss.android.lark.bottomsheet.fragment.BottomSheetFrameFragment;
import com.ss.android.lark.chat.utils.t0;
import com.ss.android.lark.flow.threadwindow.FlowThreadWindowContainerFragment;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import d0c.b;
import d0c.c;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import e0c.l;
import f0c.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u0016H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/ss/android/lark/flow/bottomsheet/biz/threadwindow/ThreadWindowFrameFragment;", "Lcom/ss/android/lark/bottomsheet/fragment/BottomSheetFrameFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "radiusTopContainer", "", "getRadiusTopContainer", "()F", "setRadiusTopContainer", "(F)V", "mFragment", "Lcom/ss/android/lark/flow/threadwindow/FlowThreadWindowContainerFragment;", "chatId", "", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "initContentContainer", "", "contentContainer", "Landroid/widget/FrameLayout;", "savedInstanceState", "Landroid/os/Bundle;", "handleBack", "", "onNewIntent", "intent", "Landroid/content/Intent;", "notifyPush", "notice", "Lcom/ss/android/lark/notification/export/entity/Notice;", "getChatId", "bundle", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ThreadWindowFrameFragment extends BottomSheetFrameFragment implements c {
    public final float j;
    public FlowThreadWindowContainerFragment k;
    public String l;

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

    public final boolean l1() {
        FlowThreadWindowContainerFragment r0 = this.k;
        if (r0 == null) goto L17;
        FrameFragment r1 = r0.getChildFragmentManager().findFragmentById(2131373275);
        if (r1 == null) goto L9;
        boolean r3 = true;
        if (r1.isVisible() != true) goto L9;
    L10:
        if (r3 == true) goto L12;
        return false;
    L12:
        if (r1.isAdded() == true) goto L14;
        return false;
    L14:
        if ((r1 instanceof FrameFragment) == true) goto L16;
        return false;
    L16:
        return r1.l1();
    L9:
        r3 = false;
        goto L10
    L17:
        return false;
    }

    public ThreadWindowFrameFragment() {
        this.j = 24.0f;
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m5provideComponent() {
        return provideComponent();
    }

    public final float S90() {
        return this.j;
    }

    public final void A0(Intent r4) {
        if (r4 == null) goto L21;
        Bundle r0 = r4.getExtras();
        if (r0 == null) goto L23;
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
        this.l = r2;
        FlowThreadWindowContainerFragment r3 = this.k;
        if (r3 == null) goto L22;
        r3.A0(r4);
        return;
    L22:
        return;
    L11:
        if (r2.length() == 0) goto L14;
        r1 = false;
        goto L15
    L23:
        return;
    }

    public final boolean y30(Notice r2) {
        String r0 = this.l;
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        return t0.c(r2, r0);
    }

    public final void T90(FrameLayout r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "contentContainer");
        Bundle r6 = getArguments();
        if (r6 == null) goto L6;
        String r1 = r6.getString("chatID");
        if (r1 == null) goto L6;
    L9:
        this.l = r1;
        FlowThreadWindowContainerFragment r7 = new FlowThreadWindowContainerFragment();
        r7.setArguments(getArguments());
        this.k = r7;
        FragmentTransaction r0 = getChildFragmentManager().beginTransaction();
        int r8 = r4.getId();
        String r2 = FlowThreadWindowContainerFragment.class.getName();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r7, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r2, r8) == true) goto L13;
        r0 = r0.add(r8, r7, r2);
    L13:
        r0.commitAllowingStateLoss();
        return;
    L6:
        if (r6 == null) goto L8;
        r1 = r6.getString("chatID");
        goto L9
    L8:
        r1 = null;
        goto L9
    }
}
