package com.bytedance.android.live.revlink.impl.multianchor.widget;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.revlink.impl.constants.RandomMatchCheckSource;
import com.bytedance.android.live.revlink.impl.control.dialog.RevLinkDialog;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.AnchorLinkMatchInviteFragment;
import com.bytedance.android.live.revlink.impl.pk.dialog.PkRandomMatchDialogV2;
import com.bytedance.android.live.revlink.impl.pk.dialog.PkReserveSettleBeInviteDialog;
import com.bytedance.android.live.revlink.impl.pk.dialog.PkReserverSettleDialog;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPkMatchInvitedFragment;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPkPrecisionMatchLynxFragment;
import com.bytedance.android.live.revlink.impl.pk.dialog.presenter.t;
import com.bytedance.android.live.revlink.impl.pk.randompkcheck.RandomPKCheckFragment;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkAutoMatchDataContext;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkAutoMatchManager;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkPrecisionMatchDataContext;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkReserveBattleDataContext;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra;
import com.bytedance.android.livesdk.link.model.bridge.s;
import com.bytedance.android.livesdk.link.model.d2;
import com.bytedance.android.livesdk.link.model.i2;
import com.bytedance.android.livesdk.link.model.l2;
import com.bytedance.android.livesdk.link.model.s1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements com.bytedance.android.live.revlink.link.domain.anchorimpl.c {
    public PkRandomMatchDialogV2 a;
    public RevLinkDialog b;
    public InteractPkPrecisionMatchLynxFragment c;
    public final Context d;
    public final DataCenter e;
    public final IRoom f;
    public final LifecycleOwner g;

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.c
    public final void a() {
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.c
    public final void b() {
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.c
    public final void c(s r2, com.bytedance.android.live.revlink.impl.pk.vm.linkout.f r3) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "dismissListener");
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.c
    public final void g() {
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.c
    public final void d() {
        PkRandomMatchDialogV2 r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L19;
        r0.dismiss();     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L20;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L20:
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.c
    public final void f() {
        PkRandomMatchDialogV2 r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() != true) goto L18;
        PkRandomMatchDialogV2 r1 = this.a;
        if (r1 == null) goto L19;
        r1.dismiss();     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L20;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L20:
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.c
    public final void i() {
        RevLinkDialog r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() != true) goto L18;
        RevLinkDialog r1 = this.b;
        if (r1 == null) goto L19;
        r1.dismiss();     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L20;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L20:
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.c
    public final void e(PkAutoMatchDataContext r3) {
        Intrinsics.checkNotNullParameter(r3, "pkAutoMatchDataContext");
        PkRandomMatchDialogV2 r0 = new PkRandomMatchDialogV2();
        r0.n = this.e;
        r0.o = r3;
        Unit r4 = Unit.INSTANCE;
        this.a = r0;
        FragmentActivity r5 = ContextUtil.contextToFragmentActivity(this.d);
        if (r5 == null) goto L10;
        FragmentManager r6 = r5.getSupportFragmentManager();
        if (r6 == null) goto L11;
        PkRandomMatchDialogV2 r1 = this.a;
        if (r1 == null) goto L12;
        q(r1, r6);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.c
    public final void h(PkAutoMatchManager.b r3) {
        Intrinsics.checkNotNullParameter(r3, "dismissListener");
        PkRandomMatchDialogV2 r0 = this.a;
        if (r0 == null) goto L6;
        r0.setOnDismissListener(new d(r3));
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.c
    public final void k(com.bytedance.android.live.revlink.impl.pk.service.j r8) {
        Intrinsics.checkNotNullParameter(r8, "startParams");
        int r0 = RandomPKCheckFragment.m;
        RandomPKCheckFragment r1 = RandomPKCheckFragment.a.a(RandomMatchCheckSource.TOPBANNER, null, null, null, null, 30);
        r1.k = r8;
        FragmentActivity r9 = this.d;
        if (r9 == null) goto L11;
        FragmentManager r10 = r9.getSupportFragmentManager();
        LandscapeRestrictionOperation r2 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, "random_pk_check_fragment", r2);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r10, r1, r2) == true) goto L15;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L8:
        r1.show(r10, "random_pk_check_fragment");
        return;
    L15:
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.c
    public final void m(PkPrecisionMatchDataContext r4) {
        if (r4 == null) goto L8;
        d2 r0 = r4.getBattlePrecisionMatch();
        if (r0 == null) goto L8;
        if (r0.getSource() != PkPrecisionMatchDataContext.PrecisionMatchSource.PrecisionMatchSourceGuildActivity.ordinal()) goto L8;
        int r1 = InteractPkPrecisionMatchLynxFragment.d;
        Context r2 = this.d;
        Intrinsics.checkNotNullParameter(r2, "context");
        InteractPkPrecisionMatchLynxFragment r3 = new InteractPkPrecisionMatchLynxFragment(r2, r4);
        this.c = r3;
        r3.a();
        return;
    L8:
        DataCenter r5 = this.e;
        LifecycleOwner r6 = this.g;
        int r7 = RevLinkDialog.x;
        RevLinkDialog.a r8 = new RevLinkDialog.a(r5, r6);
        RevLinkDialog r9 = r8.b(12);
        r8.i = r4;
        FragmentActivity r10 = this.d;
        if (r10 == null) goto L13;
        p(r9, r10.getSupportFragmentManager());
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.c
    public final void n(PkPrecisionMatchDataContext r5) {
        InteractPkPrecisionMatchLynxFragment r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.a == null) goto L16;
        if (r5 == null) goto L12;
        d2 r6 = r5.getBattlePrecisionMatch();
        if (r6 == null) goto L12;
        List r7 = r6.getMatcherList();
        if (r7 == null) goto L12;
    L13:
        cy0.e.a.getClass();
        cy0.j r1 = cy0.e.a.a;
        m.e.getClass();
        Object r2 = m.b(r1).a(Reflection.getOrCreateKotlinClass(vy0.b.class));
        Intrinsics.checkNotNull(r2);
        JSONObject r3 = new JSONObject();
        r3.put("event_name", "revlink_refresh_match_bell_dialog");
        r3.put("match_users", InteractPkPrecisionMatchLynxFragment.b(r7));
        Unit r8 = Unit.INSTANCE;
        ((vy0.b) ((f80.a) r2)).sendEventToAllJsBridges("H5_revenueInteractData", r3);
        return;
    L12:
        r7 = CollectionsKt.emptyList();
        goto L13
    }

    public static void p(RevLinkDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "LinkDialog", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "LinkDialog");
    }

    public static void q(LiveDialogFragment r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "PkRandomMatchDialog", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "PkRandomMatchDialog");
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.c
    public final void j(s r6, com.bytedance.android.live.revlink.impl.pk.vm.linkout.g r7) {
        Intrinsics.checkNotNullParameter(r6, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r7, "dismissListener");
        IBattleLinkerInviteMessageExtra r0 = r6.castTo(s1.class).getBattleExtra();
        if (r0 != null) goto L5;
        return;
    L5:
        DataCenter r1 = this.e;
        Intrinsics.checkNotNull(r1);
        LifecycleOwner r2 = this.g;
        int r3 = RevLinkDialog.x;
        RevLinkDialog r4 = new RevLinkDialog.a(r1, r2).a();
        if (((int) r0.getScene()) != 1) goto L8;
        int r5 = InteractPkMatchInvitedFragment.n;
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r6, "bridge");
        InteractPkMatchInvitedFragment r8 = new InteractPkMatchInvitedFragment();
        s1 r9 = r6.castTo(s1.class);
        r8.d = r4;
        r8.i = r9;
        r8.h = r9.getBattleExtra();
        r8.f = new t(r8, r9);
        r4.f = r8;
    L9:
        Unit r10 = Unit.INSTANCE;
        this.b = r4;
        r4.setOnDismissListener(new e(r7));
        FragmentActivity r12 = ContextUtil.contextToFragmentActivity(this.d);
        if (r12 == null) goto L17;
        FragmentManager r13 = r12.getSupportFragmentManager();
        if (r13 == null) goto L18;
        RevLinkDialog r14 = this.b;
        if (r14 == null) goto L19;
        p(r14, r13);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L8:
        int r15 = AnchorLinkMatchInviteFragment.p;
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r6, "bridge");
        AnchorLinkMatchInviteFragment r16 = new AnchorLinkMatchInviteFragment();
        s1 r17 = r6.castTo(s1.class);
        r16.d = r4;
        r16.h = r17;
        r16.f = new m21.d(r16);
        r4.f = r16;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.c
    public final void l(i2 r3, PkReserveBattleDataContext r4) {
        Intrinsics.checkNotNullParameter(r3, "beInvitedMsg");
        PkReserveSettleBeInviteDialog r0 = new PkReserveSettleBeInviteDialog(this.d, r3, r4);
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r0);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.c
    public final void o(l2 r3, PkReserveBattleDataContext r4) {
        Intrinsics.checkNotNullParameter(r3, "reserveSettleMessage");
        PkReserverSettleDialog r0 = new PkReserverSettleDialog(this.d, r3, r4);
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r0);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
    }

    public f(Context r2, DataCenter r3, IRoom r4, LifecycleOwner r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "room");
        Intrinsics.checkNotNullParameter(r5, "lifecycleOwner");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
    }
}
