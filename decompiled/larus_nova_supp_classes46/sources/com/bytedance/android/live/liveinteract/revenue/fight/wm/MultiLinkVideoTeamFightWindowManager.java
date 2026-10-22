package com.bytedance.android.live.liveinteract.revenue.fight.wm;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.fulllink.revenue.h;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.l;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenue.fight.c;
import com.bytedance.android.live.liveinteract.revenue.fight.dialog.TeamFightWaitingDialog;
import com.bytedance.android.live.liveinteract.revenue.fight.dynamic.DynamicTeamFightWidget;
import com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight.DynamicTeamFightViewManager;
import com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight.d;
import com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight.e;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import tf0.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/fight/wm/MultiLinkVideoTeamFightWindowManager;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/wm/CommonMultiLinkWindowManager;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkVideoTeamFightWindowManager extends CommonMultiLinkWindowManager {

    public static final class a {
    }

    static {
    }

    public static int q1() {
        TeamFightContext r0 = TeamFightContext.Companion.getContext();
        if (r0 == null) goto L9;
        m<Integer> r1 = r0.getFightStatus();
        if (r1 == null) goto L9;
        Integer r2 = (Integer) r1.getValue();
        if (r2 == null) goto L9;
        return r2.intValue();
    L9:
        return 0;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void T0() {
        c r0 = TeamFightContext.Companion.c();
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0 instanceof DynamicTeamFightWidget) == false) goto L13;
        d r1 = ((DynamicTeamFightWidget) r0).f;
        if (r1 == null) goto L14;
        DynamicTeamFightViewManager r2 = r1.a;
        if (r2 == null) goto L15;
        r2.b("detach");
        r2.k.dispose();
        r2.e.b();
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void r1() {
        FrameLayout r0 = (FrameLayout) this.y.findViewById(2131372815);
        FrameLayout r1 = (FrameLayout) this.y.findViewById(2131372816);
        l r3 = this.d;
        if (r3 == null) goto L5;
        r3.getMultiAdapterWrapper();
    L5:
        hg0.d r4 = this.i;
        Intrinsics.checkNotNull(r4);
        sh0.l r2 = new sh0.l(r0, r1, r4);
        TeamFightContext.a r5 = TeamFightContext.Companion;
        c r6 = r5.c();
        if (r6 != null) goto L8;
    L17:
        int r7 = h.a;
        r5.b();
        return;
    L8:
        if ((r6 instanceof DynamicTeamFightWidget) == false) goto L17;
        DynamicTeamFightWidget r8 = (DynamicTeamFightWidget) r6;
        Intrinsics.checkNotNullParameter(r2, "updateInfo");
        d r9 = r8.f;
        if (r9 == null) goto L12;
        r9.a(r2);
    L12:
        e r10 = r8.g;
        if (r10 == null) goto L17;
        d r11 = r8.f;
        if (r11 == null) goto L17;
        r11.b(r10);
        goto L17
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void w() {
        ALogger.w("MultiLinkVideoTeamFightWindowManager", "sendPlayViewActionAfterUpdateFullMode");
        r1();
        p0();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager
    public final void i1(int r3) {
        if (TeamFightContext.Companion.f() == false) goto L11;
        ILinkPlayerInfoBridge r0 = this.B.X0(k.n(IMiddlewareUserService.class).user().n());
        if (r0 == null) goto L7;
        int r1 = r0.getUserPosition();
    L9:
        if (li0.d.d(r1) == li0.d.d(r3)) goto L11;
        f2.b(2131922784, 0);
        goto L11
    L7:
        r1 = -1;
    L11:
        super.i1(r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager
    public final void j1(int r3) {
        if (TeamFightContext.Companion.a() == false) goto L10;
        TeamFightWaitingDialog r4 = new TeamFightWaitingDialog(getContext(), this.C);
        if (DialogLancet.shouldBlockDialogShow(r4) == false) goto L13;
        DialogLancet.handleBlockedDialogShow(r4);
        return;
    L13:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L8:
        DialogLancet.beforeDialogShow(r4);
        r4.show();
        DialogLancet.afterDialogShow(r4);
        return;
    L10:
        super.j1(r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void S0(int r3, int r4) {
        int r0 = li0.d.d(r3);
        int r1 = li0.d.d(r4);
        TalkRoomLogUtils.p1(r3 + 1, r4 + 1, Integer.valueOf(r0), Integer.valueOf(r1));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager
    public final void n0(boolean r3, boolean r4) {
        StringBuilder r5 = new StringBuilder("initPlayModeViewManager isFromFastMode: ");
        r5.append(r3);
        r5.append(" context:");
        TeamFightContext.a r0 = TeamFightContext.Companion;
        r5.append(r0.getContext());
        ALogger.w("MultiLinkVideoTeamFightWindowManager", r5.toString());
        if (r.m() == false) goto L5;
        super.n0(r3, false);
    L5:
        if (r3 == false) goto L9;
        if (r3 == true) goto L8;
        return;
    L8:
        if (r0.getContext() != null) goto L9;
        return;
    L9:
        r1();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void l(boolean r2, Pair<Integer, Integer> r3, Pair<Integer, Integer> r4) {
        Intrinsics.checkNotNullParameter(r3, "livePlayerVideoSize");
        Intrinsics.checkNotNullParameter(r4, "livePlayerLayoutSize");
        int r0 = h.a;
        super.l(r2, r3, r4);
        h.a(this.y);
    }

    public MultiLinkVideoTeamFightWindowManager(Context r2, ConstraintLayout r3, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r4, zj0.c r5, com.bytedance.android.live.liveinteract.plantform.datamerge.d r6, DataCenter r7, o.a r8, PlatformMultiLinkWidget r9, View r10, GLSurfaceView r11, com.bytedance.android.live.pushstream.d r12, PlatformMultiLinkWidget r13) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        Intrinsics.checkNotNullParameter(r4, "layoutConfig");
        Intrinsics.checkNotNullParameter(r6, "dataMergeCenter");
        Intrinsics.checkNotNullParameter(r7, "dataCenter");
        Intrinsics.checkNotNullParameter(r8, "callBack");
        Intrinsics.checkNotNullParameter(r9, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r10, "interactEmojiLayout");
        Intrinsics.checkNotNullParameter(r11, "renderContainer");
        super(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }
}
