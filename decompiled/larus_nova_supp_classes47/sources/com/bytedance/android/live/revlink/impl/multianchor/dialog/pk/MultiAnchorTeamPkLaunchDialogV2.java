package com.bytedance.android.live.revlink.impl.multianchor.dialog.pk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.ui.TeamPkMatchView;
import com.bytedance.android.live.revlink.impl.pk.ui.LinkCommonDialogFragment;
import com.bytedance.android.live.revlink.link.biz.component.MultiPKLauncher;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.d4;
import com.bytedance.android.livesdk.link.model.h9;
import com.bytedance.android.livesdk.link.model.w2;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.x0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/pk/MultiAnchorTeamPkLaunchDialogV2;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/LinkCommonDialogFragment;", "Lcom/bytedance/android/live/revlink/impl/multianchor/ui/a;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiAnchorTeamPkLaunchDialogV2 extends LinkCommonDialogFragment implements com.bytedance.android.live.revlink.impl.multianchor.ui.a {
    public static final /* synthetic */ int m = 0;
    public Map<Integer, View> e;
    public final Lazy f;
    public IBattleConfigSetting g;
    public boolean h;
    public q21.h i;
    public boolean j;
    public final CompositeDisposable k;
    public final p21.e l;

    public static final class a<T> implements Observer {
        public final /* synthetic */ MultiAnchorTeamPkLaunchDialogV2 a;

        public a(MultiAnchorTeamPkLaunchDialogV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            q21.h r6 = (q21.h) r5;
            this.a.i = r6;
            if (r6 == null) goto L5;
            ArrayList r0 = new ArrayList(r6.b);
            ArrayList r1 = new ArrayList(r6.c);
            ((TeamPkMatchView) this.a.S90(2131362913)).setChangeTeamSupportCallback(this.a);
            ((TeamPkMatchView) this.a.S90(2131362913)).U5(r0, r1);
        L5:
            MultiAnchorTeamPkLaunchDialogV2 r7 = this.a;
            q21.h r2 = r7.i;
            if (r2 == null) goto L20;
            List<TeamPkMatchView.b> r3 = r2.b;
            List<TeamPkMatchView.b> r4 = r2.c;
            ArrayList r8 = (ArrayList) r3;
            if (r8.size() == 0) goto L20;
            ArrayList r9 = (ArrayList) r4;
            if (r9.size() == 0) goto L20;
            Iterator r10 = CollectionsKt.plus(r8, r9).iterator();
        L15:
            if (r10.hasNext() == false) goto L19;
            if (((TeamPkMatchView.b) r10.next()).f == 2) goto L15;
        L19:
            boolean r12 = true;
        L21:
            r7.j = r12;
            if (r12 == false) goto L24;
            ((TextView) r7.S90(2131387228)).setBackgroundResource(2131249697);
            return;
        L24:
            ((TextView) r7.S90(2131387228)).setBackgroundResource(2131249980);
            return;
        L20:
            r12 = false;
            goto L21
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ MultiAnchorTeamPkLaunchDialogV2 a;

        public b(MultiAnchorTeamPkLaunchDialogV2 r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r0 = DialogFragmentLancet.sLastShowStack;
            if (r0 == null) goto L12;
            com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ MultiAnchorTeamPkLaunchDialogV2 a;

        public c(MultiAnchorTeamPkLaunchDialogV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ MultiAnchorTeamPkLaunchDialogV2 a;

        public d(MultiAnchorTeamPkLaunchDialogV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            com.bytedance.android.live.revlink.impl.multianchor.service.c r5 = com.bytedance.android.live.revlink.impl.global.b.y();
            if (r5 == null) goto L13;
            com.bytedance.android.live.revlink.impl.multianchor.service.c.a.a(r5, 0, 0, null, 7);
        L13:
            this.a.dismiss();     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r6 = DialogFragmentLancet.sLastShowStack;
            if (r6 == null) goto L15;
            com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public final MultiAnchorTeamPkLaunchViewModel U90() {
        return (MultiAnchorTeamPkLaunchViewModel) this.f.getValue();
    }

    public final String getDegradeTag() {
        return "anchor_multi_launch";
    }

    public final String T90() {
        IBattleConfigSetting r0 = this.g;
        if (r0 == null) goto L7;
        w2 r1 = r0.getShellConfig();
        if (r1 == null) goto L7;
        String r2 = r1.getName();
    L8:
        if (r2 != null) goto L10;
    L12:
        IBattleConfigSetting r3 = this.g;
        if (r3 != null) goto L15;
        return null;
    L15:
        if (r3.getModType() == PkBaseDataContext.PKModType.SeasonRank.getType()) goto L17;
        return null;
    L17:
        return s1.B(2131921445);
    L10:
        if ((!StringsKt.isBlank(r2)) != true) goto L12;
        return r2;
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.a
    public final void n50() {
        HashMap r0 = new HashMap();
        String r1 = U90().getNpkInvitePageSource();
        if (r1 == null) goto L5;
        r0.put("npk_invite_page_source", r1);
    L5:
        r0.put("battle_mode", "team_pk");
        mz0.n r2 = new mz0.n();
        Map<String, String> r3 = r2.a;
        Intrinsics.checkNotNullParameter(r3, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r3.putAll(r0);
        mz0.m r4 = new mz0.m();
        r4.b(LogCommon.ROOM);
        LinkCrossRoomDataHolder.a r5 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r4);
        ((ArrayList) r2.b).addAll(r4.a);
        cy0.e.a.getClass();
        cy0.j r6 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r7 = com.bytedance.android.scope.m.b(r6).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r7);
        ((mz0.i) ((f80.a) r7)).w3("livesdk_npk_invite_page_switch_teams_click", r2.a, r2.b);
        q21.h r8 = (q21.h) U90().getTeamPkAnchorTeamMatchData().getValue();
        if (r8 != null) goto L8;
    L12:
        int r9 = ToastUtil.a;
        ToastUtil.b(s1.C(2131917499, new Object[]{"PK"}), 0);
        q21.h r10 = this.i;
        if (r10 == null) goto L16;
        ((TeamPkMatchView) S90(2131362913)).U5(new ArrayList(r10.b), new ArrayList(r10.c));
        return;
    L16:
        return;
    L8:
        if (r8.b() != true) goto L12;
        U90().requestChangeMultiTeam();
        this.h = true;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.l.b();
        this.k.dispose();
        jy0.b.d("ttlive_anchor_link_multi_pk", "MultiAnchorTeamPkLaunchDialogV2 dismissed");
        ((LinkedHashMap) this.e).clear();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.a
    public final boolean Zl() {
        return this.h;
    }

    public MultiAnchorTeamPkLaunchDialogV2(p21.e r2) {
        Intrinsics.checkNotNullParameter(r2, "metricUtil");
        this.l = r2;
        this.e = new LinkedHashMap();
        this.f = LazyKt.lazy(new MultiAnchorTeamPkLaunchDialogV2$vm$2(this));
        this.k = new CompositeDisposable();
    }

    public static void V90(MultiAnchorTeamPkLaunchDialogV2 r4) {
        r4.getClass();
        h41.f r0 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r0 == null) goto L6;
        r0.h(false, r4.U90().getCurrentAnchorList().size(), r4.U90().getCurrentAnchorList().size(), PlayMode.TEAM_PK);
        return;
    }

    public final View S90(int r3) {
        if (this.e != null) goto L5;
        this.e = new LinkedHashMap();
    L5:
        View r0 = this.e.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.e.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.LinkCommonDialogFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        U90().attach();
        U90().setBattleConfigSetting(this.g);
        U90().setNpkInvitePageSource(null);
        U90().getTeamPkAnchorTeamMatchData().observe(this, new a(this));
        RxUtilKt.c(U90().getOnDismissEvent().subscribe(new b(this)), this.k);
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        ((TeamPkMatchView) S90(2131362913)).setBattleConfigSetting(this.g);
        TextView r7 = (TextView) S90(2131382443);
        Object[] r0 = new Object[1];
        String r1 = T90();
        String r2 = "PK";
        if (r1 != null) goto L5;
        r1 = "PK";
    L5:
        r0[0] = r1;
        r7.setText(s1.C(2131918045, r0));
        TextView r3 = (TextView) S90(2131387228);
        Object[] r8 = new Object[1];
        String r4 = T90();
        if (r4 == null) goto L9;
        r2 = r4;
    L9:
        r8[0] = r2;
        r3.setText(s1.C(2131918018, r8));
        ((TextView) S90(2131387228)).setOnClickListener(x0.a(new AnonymousClass1(this)));
        S90(2131381758).setOnClickListener(new c(this));
        ((ImageView) S90(2131363762)).setOnClickListener(new d(this));
        d31.e r9 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r9 == null) goto L12;
        r9.g("team_pk");
    L12:
        jy0.b.d("ttlive_anchor_link_multi_pk", "MultiAnchorTeamPkLaunchDialogV2 show");
        p21.e r10 = this.l;
        r10.getClass();
        i97.a r12 = i97.a.a;
        r10.a = Long.valueOf(System.currentTimeMillis());
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return r1.inflate(2131567003, r2);
    }

    public final void W90(String r22, String r23, h31.h r24, long r25) {
        if (U90().getHasInvitee() == false) goto L10;
        h41.f r1 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r1 == null) goto L7;
        r1.g(U90().getNpkInvitePageSource(), "team_pk", Integer.valueOf(U90().getCurrentAnchorList().size()), 0);
    L7:
        V90(this);
        int r2 = ToastUtil.a;
        ToastUtil.b(s1.C(2131917493, new Object[]{r22}), 0);
        return;
    L10:
        if (U90().getHasApplicant() == false) goto L16;
        h41.f r3 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r3 == null) goto L14;
        r3.g(U90().getNpkInvitePageSource(), "team_pk", Integer.valueOf(U90().getCurrentAnchorList().size()), 0);
    L14:
        V90(this);
        int r4 = ToastUtil.a;
        ToastUtil.b(s1.C(2131917492, new Object[]{r22}), 0);
        return;
    L16:
        q21.h r5 = this.i;
        if (r5 == null) goto L39;
        List<TeamPkMatchView.b> r6 = r5.b;
        List<TeamPkMatchView.b> r7 = r5.c;
        ArrayList r8 = (ArrayList) r6;
        if (r8.size() <= 0) goto L30;
        ArrayList r9 = (ArrayList) r7;
        if (r9.size() <= 0) goto L30;
        if ((r8.size() + r9.size()) > 2) goto L30;
        h41.f r10 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r10 == null) goto L27;
        r10.g(U90().getNpkInvitePageSource(), "team_pk", Integer.valueOf(U90().getCurrentAnchorList().size()), 0);
    L27:
        int r12 = ToastUtil.a;
        ToastUtil.b(r23.concat("需至少>2人方可开始"), 0);
        V90(this);
        return;
    L30:
        if (r8.size() != 0) goto L32;
    L33:
        h41.f r13 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r13 == null) goto L36;
        r13.g(U90().getNpkInvitePageSource(), "team_pk", Integer.valueOf(U90().getCurrentAnchorList().size()), 0);
    L36:
        int r14 = ToastUtil.a;
        ToastUtil.b(r23.concat("组队对抗，需双方阵营均>0人方可开始"), 0);
        V90(this);
        return;
    L32:
        if (((ArrayList) r7).size() == 0) goto L33;
    L39:
        if (this.j == true) goto L45;
        h41.f r15 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r15 == null) goto L43;
        r15.g(U90().getNpkInvitePageSource(), "team_pk", Integer.valueOf(U90().getCurrentAnchorList().size()), 0);
    L43:
        V90(this);
        return;
    L45:
        h41.f r16 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r16 == null) goto L48;
        r16.g(U90().getNpkInvitePageSource(), "team_pk", Integer.valueOf(U90().getCurrentAnchorList().size()), 1);
    L48:
        MultiPKLauncher r17 = com.bytedance.android.live.revlink.impl.global.b.F();
        if (r17 == null) goto L87;
        List<com.bytedance.android.livesdk.link.model.p> r18 = U90().getCurrentAnchorList();
        if ((r24 instanceof h31.h.c) == true) goto L53;
        h31.h r19 = null;
    L54:
        h31.h.c r20 = (h31.h.c) r19;
        if (r20 == null) goto L57;
        d4 r26 = r20.b;
    L59:
        if ((r24 instanceof h31.h.e) == false) goto L61;
        w2 r27 = ((h31.h.e) r24).b;
    L63:
        if ((r24 instanceof h31.h.f) == false) goto L65;
        h9 r110 = ((h31.h.f) r24).b;
    L66:
        PkBaseDataContext.PKModType r28 = PkBaseDataContext.PKModType.Default;
        PlayMode r29 = PlayMode.TEAM_PK;
        int r30 = r18.size();
        ArrayList r32 = new ArrayList();
        Iterator<com.bytedance.android.livesdk.link.model.p> r33 = r18.iterator();
    L68:
        if (r33.hasNext() == false) goto L74;
        IBaseUser r111 = r33.next().getUser();
        if (r111 == null) goto L68;
        String r112 = iz.a.a(r111);
        if (r112 == null) goto L68;
        r32.add(r112);
        goto L68
    L74:
        h31.d r34 = new h31.d(r29, r30, r32);
        if (r26 == null) goto L77;
        h31.c r35 = new h31.c(r26);
    L78:
        r17.openPk(new h31.f(r28, r25, r34, null, null, r35, r27, r110, r24, this.l.a(), com.bytedance.android.live.revlink.impl.pk.utils.l.C0177l.c, this.g, DefaultConfig.MAX_CACHE_ENTRIES), new com.bytedance.android.live.revlink.impl.multianchor.dialog.pk.b(this));
        return;
    L77:
        r35 = null;
        goto L78
    L65:
        r110 = null;
        goto L66
    L61:
        r27 = null;
        goto L63
    L57:
        r26 = null;
        goto L59
    L53:
        r19 = r24;
        goto L54
    }
}
