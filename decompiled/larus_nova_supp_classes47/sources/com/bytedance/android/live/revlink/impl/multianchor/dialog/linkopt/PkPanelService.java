package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.constants.RandomMatchCheckSource;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.AnchorLinkDebugDialog;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.AnchorInLinkSettingDialog;
import com.bytedance.android.live.revlink.impl.multianchor.match.MultiPkMatchContext;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.live.revlink.impl.pk.dialog.PkFeedbackSwitchDialog;
import com.bytedance.android.live.revlink.impl.pk.randompkcheck.RandomPKCheckFragment;
import com.bytedance.android.live.revlink.impl.pk.vote.InteractVoteStartDialog;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.h1;
import com.bytedance.android.livesdk.p8;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\u0012\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\nJ\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016R\u0017\u0010\u0017\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/PkPanelService;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/c;", "", "isTeamPkPanel", "canOpenMultiPKPanel", "isChorusOn", "", "openChorus", "closeChorus", "", "info", "startTeamPkMatch", "openInviteMorePanel", "uid", "isOrganizer", "openTeamPkPanel", "openSetPanel", "closeLink", "showFeedBackDialog", "openVoteStartDialog", "openAnchorLinkDebugDialog", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/e;", "getPkBaseService", "()Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/e;", "pkBaseService", "<init>", "(Landroid/content/Context;)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkPanelService extends DataContext implements c {
    private final Context context;

    public static final class a implements InteractVoteStartDialog.c {
        public a() {
        }

        @Override // com.bytedance.android.live.revlink.impl.pk.vote.InteractVoteStartDialog.c
        public final void a(long r3, aa r5) {
            Intrinsics.checkNotNullParameter(r5, "voteSetting");
            com.bytedance.android.live.revlink.impl.global.c r0 = com.bytedance.android.live.revlink.impl.global.b.k();
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r1 = null;
            if (r0 == null) goto L5;
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.f r2 = r0.getPKBaseUtils();
        L6:
            if (r2 == null) goto L16;
            com.bytedance.android.live.revlink.impl.global.c r4 = r2.a;
            if (r4 == null) goto L10;
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r6 = r4.Ig();
        L11:
            if (r6 == null) goto L13;
            r1 = r6.getPkAnchorLauncher();
        L13:
            if (r1 == null) goto L17;
            r1.d(r3, r5);
            return;
        L17:
            return;
        L10:
            r6 = null;
            goto L11
        L16:
            return;
        L5:
            r2 = null;
            goto L6
        }
    }

    public void openTeamPkPanel() {
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c
    public void closeLink() {
        p11.h r0 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService();
        if (r0 == null) goto L5;
        r0.H(false);
    L5:
        com.bytedance.android.live.revlink.impl.multianchor.match.a r1 = com.bytedance.android.live.revlink.impl.global.b.I();
        if (r1 == null) goto L9;
        r1.ni(0, "quit_link");
        return;
    }

    public boolean isChorusOn() {
        iq2.b r0 = vh6.c.b(er2.b.class).getChorusService();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.e() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c
    public void openAnchorLinkDebugDialog() {
        p8.a(new AnchorLinkDebugDialog(), this.context);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c
    public void openSetPanel() {
        com.bytedance.android.livesdk.revenue.service.room.c r0 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r0 == null) goto L6;
        int r1 = AnchorInLinkSettingDialog.G;
        p8.a(AnchorInLinkSettingDialog.a.a((IRoom) r0.getRoomContext().getRoom().getValue(), false, 6), this.context);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c
    public void openVoteStartDialog() {
        int r0 = InteractVoteStartDialog.m;
        InteractVoteStartDialog r1 = new InteractVoteStartDialog();
        r1.i = new a();
        p8.a(r1, this.context);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c
    public void showFeedBackDialog() {
        com.bytedance.android.livesdk.revenue.service.room.c r0 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r0 == null) goto L16;
        int r1 = PkFeedbackSwitchDialog.m;
        IRoom r2 = (IRoom) r0.getRoomContext().getRoom().getValue();
        r0.getDataCenter();
        PkFeedbackSwitchDialog r3 = new PkFeedbackSwitchDialog();
        r3.f = r2;
        if (r2 == null) goto L9;
        IBaseUser r4 = r2.getOwner();
        if (r4 == null) goto L9;
        String r5 = iz.a.a(r4);
    L10:
        r3.g = Intrinsics.areEqual(r5, iz.a.a(vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).b()));
        LinkCrossRoomDataHolder r6 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r6 == null) goto L13;
        long r7 = r6.c();
    L14:
        r3.k = r7;
        p8.a(r3, this.context);
        return;
    L13:
        r7 = 0;
    L9:
        r5 = null;
        goto L10
    }

    private final com.bytedance.android.live.revlink.impl.mergepk.pkbase.e getPkBaseService() {
        return com.bytedance.android.live.revlink.impl.global.b.R();
    }

    public void closeChorus() {
        com.bytedance.android.live.revenuelink.connect.f r0 = com.bytedance.android.live.revlink.impl.global.b.a();
        if (r0 == null) goto L9;
        LiveData<ey.f> r1 = r0.connectState();
        if (r1 == null) goto L9;
        ey.f r2 = (ey.f) r1.getValue();
        if (r2 == null) goto L9;
        long r3 = r2.a;
    L10:
        iq2.b r4 = vh6.c.b(er2.b.class).getChorusService();
        if (r4 == null) goto L14;
        r4.a(String.valueOf(r3));
        return;
    L14:
        return;
    L9:
        r3 = 0;
        goto L10
    }

    public void openChorus() {
        com.bytedance.android.live.revenuelink.connect.f r0 = com.bytedance.android.live.revlink.impl.global.b.a();
        if (r0 == null) goto L9;
        LiveData<ey.f> r1 = r0.connectState();
        if (r1 == null) goto L9;
        ey.f r2 = (ey.f) r1.getValue();
        if (r2 == null) goto L9;
        long r3 = r2.a;
    L10:
        iq2.b r4 = vh6.c.b(er2.b.class).getChorusService();
        if (r4 == null) goto L14;
        r4.f(String.valueOf(r3));
        return;
    L14:
        return;
    L9:
        r3 = 0;
        goto L10
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c
    public void openInviteMorePanel() {
        MultiLinkAnchorControlContext r0 = com.bytedance.android.live.revlink.impl.global.b.B();
        String r1 = null;
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.m<Boolean> r2 = r0.getForbidInvite();
        if (r2 == null) goto L12;
        if (((Boolean) r2.getValue()).booleanValue() != true) goto L12;
        if (isOrganizer$default(this, null, 1, null) == true) goto L12;
        ToastUtil.a(2131920546, 0);
        return;
    L12:
        com.bytedance.android.livesdk.revenue.service.room.c r3 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r3 == null) goto L15;
        r3.getDataCenter();
    L15:
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r4 = com.bytedance.android.live.revlink.impl.global.b.D();
        if (r4 == null) goto L18;
        boolean r5 = r4.g();
    L19:
        if (r5 == false) goto L22;
        ToastUtil.a(2131917961, 0);
        return;
    L22:
        f r6 = com.bytedance.android.live.revlink.impl.global.b.m();
        if (r6 != null) goto L25;
    L27:
        boolean r7 = false;
    L28:
        if (r7 == false) goto L31;
        ToastUtil.a(2131914826, 0);
    L52:
        com.bytedance.android.live.revlink.impl.multianchor.utils.v r8 = com.bytedance.android.live.revlink.impl.global.b.C();
        if (r8 == null) goto L55;
        r8.J();
    L55:
        com.bytedance.android.live.revlink.impl.multianchor.service.c r9 = com.bytedance.android.live.revlink.impl.global.b.y();
        if (r9 == null) goto L59;
        r9.Da();
        return;
    L59:
        return;
    L31:
        if (d.a() == false) goto L52;
        f r10 = com.bytedance.android.live.revlink.impl.global.b.m();
        if (r10 == null) goto L42;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r12 = r10.a();
        if (r12 != null) goto L37;
    L39:
        boolean r13 = false;
    L40:
        if (r13 != true) goto L42;
        boolean r14 = true;
    L43:
        if (r14 == false) goto L49;
        int r15 = ToastUtil.a;
        Object[] r16 = new Object[1];
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r17 = getPkBaseService();
        if (r17 == null) goto L47;
        r1 = r17.getShortPlayName();
    L47:
        r16[0] = r1;
        ToastUtil.b(s1.C(2131914825, r16), 0);
        goto L52
    L49:
        if (d.b() == false) goto L51;
        ToastUtil.a(2131914822, 0);
        goto L52
    L51:
        ToastUtil.a(2131914824, 0);
        goto L52
    L37:
        if (r12.isInCompetition() != true) goto L39;
        r13 = true;
    L42:
        r14 = false;
        goto L43
    L25:
        if (r6.i() != true) goto L27;
        r7 = true;
        goto L28
    L18:
        r5 = false;
        goto L19
    }

    public final Context getContext() {
        return this.context;
    }

    public PkPanelService(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
    }

    private final boolean canOpenMultiPKPanel(boolean r6) {
        com.bytedance.android.live.revlink.impl.pk.utils.q r0 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r0 == null) goto L12;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r1 = r0.g();
        if (r1 == null) goto L12;
        if (r1.canSwitchMulti() == true) goto L12;
        ToastUtil.a(2131917959, 0);
        h41.f r7 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r7 == null) goto L11;
        r7.c(0);
    L11:
        return false;
    L12:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r2 = getPkBaseService();
        if (r2 == null) goto L24;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r3 = r2.getPkAnchorLauncher();
        if (r3 == null) goto L24;
        MutableLiveData r4 = r3.g();
        if (r4 == null) goto L24;
        c21.c r5 = (c21.c) r4.getValue();
        if (r5 == null) goto L24;
        if ((r5 instanceof c21.c.d) != true) goto L24;
        ToastUtil.a(2131921452, 0);
        return false;
    L24:
        ld.a r8 = ld.d.a();
        Boolean r9 = null;
        if (r8 == null) goto L29;
        NextLiveData r10 = r8.Fc();
        if (r10 == null) goto L29;
        Boolean r12 = (Boolean) r10.getValue();
    L30:
        Boolean r13 = Boolean.TRUE;
        if (Intrinsics.areEqual(r12, r13) == true) goto L41;
        ld.a r14 = ld.d.a();
        if (r14 == null) goto L38;
        NextLiveData r15 = r14.z9();
        if (r15 == null) goto L38;
        r9 = (Boolean) r15.getValue();
    L38:
        if (Intrinsics.areEqual(r9, r13) == true) goto L41;
        return true;
    L41:
        if (r6 == false) goto L43;
        ToastUtil.a(2131917961, 0);
    L44:
        return false;
    L43:
        ToastUtil.a(2131917960, 0);
    L29:
        r12 = null;
        goto L30
    }

    public final boolean isOrganizer(String r2) {
        com.bytedance.android.live.revlink.impl.multianchor.service.d r0 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r0 == null) goto L7;
        i11.b r1 = r0.getLinkUserCenter();
        if (r1 == null) goto L7;
        return r1.N(r2);
    L7:
        return false;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c
    public void startTeamPkMatch(String r9) {
        Intrinsics.checkNotNullParameter(r9, "info");
        if (l51.a.d() == true) goto L11;
        int r0 = RandomPKCheckFragment.m;
        RandomPKCheckFragment r10 = RandomPKCheckFragment.a.a(RandomMatchCheckSource.MultiPKUserListFragment, null, Boolean.TRUE, r9, null, 18);
        FragmentActivity r1 = ContextUtil.contextToFragmentActivity(this.context);
        if (r1 == null) goto L35;
        FragmentManager r2 = r1.getSupportFragmentManager();
        if (r2 == null) goto L36;
        INVOKEVIRTUAL_com_bytedance_android_live_revlink_impl_multianchor_dialog_linkopt_PkPanelService_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r10, r2, "random_pk_check_fragment");
        return;
    L36:
        return;
    L35:
        return;
    L11:
        if (canOpenMultiPKPanel(true) == true) goto L14;
        jy0.b.c("ttlive_anchor_link_panel", "intercept openMultiTeamPkInvitePanel", null, 4);
        return;
    L14:
        h41.f r3 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r3 == null) goto L17;
        r3.c(1);
    L17:
        MultiLinkAnchorControlContext r4 = com.bytedance.android.live.revlink.impl.global.b.B();
        if (r4 == null) goto L27;
        com.bytedance.live.datacontext.m<Boolean> r5 = r4.getForbidInvite();
        if (r5 == null) goto L27;
        if (((Boolean) r5.getValue()).booleanValue() != true) goto L27;
        if (isOrganizer$default(this, null, 1, null) == true) goto L27;
        ToastUtil.a(2131920546, 0);
        return;
    L27:
        MultiPkMatchContext r6 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r6 == null) goto L37;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.match.a> r7 = r6.getService();
        if (r7 == null) goto L38;
        com.bytedance.android.live.revlink.impl.multianchor.match.a r8 = (com.bytedance.android.live.revlink.impl.multianchor.match.a) r7.getValue();
        if (r8 == null) goto L39;
        com.bytedance.android.live.revlink.impl.multianchor.match.a.C0145a.a(r8, (af2.a) GsonProtectorUtils.fromJson(GsonHelper.get(), r9, h1.class), 6, true, 0, AnonymousClass2.INSTANCE, 24);
        return;
    L39:
        return;
    L38:
        return;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_live_revlink_impl_multianchor_dialog_linkopt_PkPanelService_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(RandomPKCheckFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        RandomPKCheckFragment r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static /* synthetic */ boolean canOpenMultiPKPanel$default(PkPanelService r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return r0.canOpenMultiPKPanel(r1);
    }

    public static /* synthetic */ boolean isOrganizer$default(PkPanelService r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = com.bytedance.android.live.revlink.impl.utils.u.e();
    L6:
        return r0.isOrganizer(r1);
    }
}
