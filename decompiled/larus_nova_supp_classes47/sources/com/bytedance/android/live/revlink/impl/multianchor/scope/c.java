package com.bytedance.android.live.revlink.impl.multianchor.scope;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.control.dialog.RevLinkDialog;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.AnchorLinkInviteFragment;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra;
import com.bytedance.android.livesdk.link.model.bridge.g1;
import com.bytedance.android.livesdk.link.model.e6;
import com.bytedance.android.livesdk.link.model.f6;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j6;
import com.bytedance.android.livesdk.link.model.k6;
import com.bytedance.android.livesdk.link.model.o6;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements o {
    public static final /* synthetic */ int d = 0;
    public RevLinkDialog a;
    public final Context b;
    public final LifecycleOwner c;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void c() {
        com.bytedance.android.live.revlink.impl.service.internal.a r0 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r0 == null) goto L5;
        r0.m();
    L5:
        RevLinkDialog r1 = this.a;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.isShowing() != true) goto L21;
        RevLinkDialog r2 = this.a;
        if (r2 == null) goto L22;
        r2.dismiss();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L23;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L23:
        return;
    L22:
        return;
    }

    public final void onStop() {
        c();
        this.a = null;
    }

    public final void d(i6 r10) {
        Intrinsics.checkNotNullParameter(r10, "linkerMessage");
        c();
        com.bytedance.android.livesdk.revenue.service.room.c r1 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r1 == null) goto L5;
        DataCenter r2 = r1.getDataCenter();
    L6:
        LifecycleOwner r3 = this.c;
        int r4 = RevLinkDialog.x;
        RevLinkDialog r5 = new RevLinkDialog.a(r2, r3).a();
        this.a = r5;
        int r6 = AnchorLinkInviteFragment.W;
        Intrinsics.checkNotNull(r5);
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r10, "linkerMessage");
        AnchorLinkInviteFragment r0 = new AnchorLinkInviteFragment();
        r0.f = new m21.d(r0);
        r0.d = r5;
        if (com.bytedance.android.live.revlink.impl.global.b.z() == null) goto L17;
        LinkCrossRoomDataHolder r7 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r7 != null) goto L11;
    L12:
        Intrinsics.checkNotNullParameter(r10, "$this$getAppliedUserOrNull");
        e6 r8 = r10.getInvite();
        if (r8 == null) goto L15;
        p r9 = r8.getAppliedUser();
    L16:
        r0.w = r0.ga0(r9);
    L18:
        Intrinsics.checkNotNullParameter(r10, "$this$getAppliedUserOrNull");
        e6 r12 = r10.getInvite();
        if (r12 == null) goto L21;
        p r13 = r12.getAppliedUser();
    L22:
        r0.J = r13;
        if (((int) r10.getType2()) != 3) goto L26;
        r0.p = 1;
    L31:
        r0.D = r10;
        e6 r14 = r10.getInvite();
        if (r14 == null) goto L34;
        String r15 = r14.getClientAttachedInfoStr();
    L35:
        r0.F = r15;
        e6 r16 = r10.getInvite();
        if (r16 == null) goto L39;
        String r17 = r16.getBattleAttachedInfoStr();
        if (r17 == null) goto L39;
    L43:
        r0.G = r17;
        r0.v = r5.getCurrentRoom().getId();
        r0.u = r10.getLinkerId();
        IBattleLinkerInviteMessageExtra r18 = j6.a(r10);
        if (r18 == null) goto L46;
        r0.x = (int) r18.getInviteType();
        r0.y = (int) r18.getMatchType();
        r0.M = r18.getBattleConfigSetting();
    L46:
        g1 r19 = r10.getInvite();
        if (r19 == null) goto L50;
        g1 r20 = r19;
        Intrinsics.checkNotNullParameter(r20, "$this$fromUid");
        r0.r = r20.get_fromUid();
        Intrinsics.checkNotNullParameter(r20, "$this$secFromUid");
        r0.s = r20.get_secFromUid();
        r0.z = r19.getInviteSource();
    L52:
        if (r19 == null) goto L70;
        if (com.bytedance.android.live.revenuelink.connect.b.a(r10) == false) goto L70;
        r0.H = x.g(f6.a(r19));
        List r22 = f6.b(r19);
        if (r22 == null) goto L70;
        Iterator r23 = r22.iterator();
    L59:
        if (r23.hasNext() == false) goto L70;
        p r24 = (p) r23.next();
        if (r24.getUser() == null) goto L59;
        IBaseUser r25 = r24.getUser();
        if (r25 == null) goto L65;
        String r26 = r25.getIdString();
    L66:
        g1 r27 = r19;
        Intrinsics.checkNotNullParameter(r27, "$this$fromUid");
        if (TextUtils.equals(r26, r27.get_fromUid()) == false) goto L59;
        r0.q = r24;
        goto L70
    L65:
        r26 = null;
    L70:
        if (r10.getInvite() == null) goto L86;
        e6 r28 = r10.getInvite();
        Intrinsics.checkNotNull(r28);
        if (r28.getInviteUser() == null) goto L86;
        e6 r29 = r10.getInvite();
        Intrinsics.checkNotNull(r29);
        p r30 = r29.getInviteUser();
        Intrinsics.checkNotNull(r30);
        if (r30.getUser() == null) goto L86;
        e6 r110 = r10.getInvite();
        if (r110 == null) goto L83;
        p r111 = r110.getInviteUser();
        if (r111 == null) goto L83;
        IBaseUser r112 = r111.getUser();
        if (r112 == null) goto L83;
        String r113 = r112.getNickName();
        if (r113 == null) goto L83;
    L84:
        r0.O = r113;
    L83:
        r113 = "";
    L86:
        if (r0.p == 2) goto L96;
        i6 r114 = r0.D;
        if (r114 == null) goto L96;
        if (j6.a(r114) == null) goto L96;
        IBattleLinkerInviteMessageExtra r115 = j6.a(r0.D);
        Intrinsics.checkNotNull(r115);
        if (r115.getInviteStatus() == null) goto L94;
        IBattleLinkerInviteMessageExtra r116 = j6.a(r0.D);
        Intrinsics.checkNotNull(r116);
        Integer r117 = r116.getInviteStatus();
    L95:
        r0.R = r117;
        goto L96
    L94:
        r117 = Integer.valueOf(IBattleLinkerInviteMessageExtra.InviteStatus.InviteStatusUnknown.ordinal());
    L96:
        RevLinkDialog r118 = this.a;
        if (r118 == null) goto L99;
        r118.f = r0;
    L99:
        FragmentActivity r119 = ContextUtil.contextToFragmentActivity(this.b);
        if (r119 == null) goto L113;
        FragmentManager r120 = r119.getSupportFragmentManager();
        if (r120 == null) goto L114;
        RevLinkDialog r32 = this.a;
        if (r32 == null) goto L115;
        a(r32, r120);
        return;
    L115:
        return;
    L114:
        return;
    L113:
        return;
    L50:
        if (r10.getSwitchChannelInviteContent() == null) goto L52;
        o6 r33 = r10.getSwitchChannelInviteContent();
        Intrinsics.checkNotNull(r33);
        g1 r34 = r33.getInviteContent();
        g1 r35 = r34;
        Intrinsics.checkNotNullParameter(r35, "$this$fromUid");
        r0.r = r35.get_fromUid();
        Intrinsics.checkNotNullParameter(r35, "$this$secFromUid");
        r0.s = r35.get_secFromUid();
        r0.z = r34.getInviteSource();
        r0.E = r34;
        r0.q = r34.getInviteUser();
        r0.N = false;
    L39:
        k6 r36 = r10.getReply();
        if (r36 == null) goto L42;
        r17 = r36.getBattleAttachedInfoStr();
        goto L43
    L42:
        r17 = null;
        goto L43
    L34:
        r15 = null;
        goto L35
    L26:
        if (((int) r10.getType2()) != 4) goto L29;
        r0.p = 2;
        goto L31
    L29:
        if (((int) r10.getType2()) != 60) goto L31;
        r0.p = 3;
        goto L31
    L21:
        r13 = null;
        goto L22
    L15:
        r9 = null;
        goto L16
    L11:
        if (r7.c() != 0) goto L12;
    L17:
        r0.w = s1.B(2131914779);
        goto L18
    L5:
        r2 = null;
        goto L6
    }

    public c(Context r2, LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "lifeCycle");
        this.b = r2;
        this.c = r3;
    }

    public static void a(RevLinkDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "LinkDialog", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "LinkDialog");
    }
}
