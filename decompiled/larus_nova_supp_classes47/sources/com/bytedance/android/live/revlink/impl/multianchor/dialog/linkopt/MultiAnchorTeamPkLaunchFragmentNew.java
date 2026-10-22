package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.vm.MultiAnchorPkLaunchViewModelNew;
import com.bytedance.android.live.revlink.impl.multianchor.ui.TeamPkMatchView;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkCustomizePlayDataContext;
import com.bytedance.android.live.revlink.link.biz.component.MultiPKLauncher;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.bridge.r0;
import com.bytedance.android.livesdk.link.model.d4;
import com.bytedance.android.livesdk.link.model.h9;
import com.bytedance.android.livesdk.link.model.u2;
import com.bytedance.android.livesdk.link.model.w2;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/MultiAnchorTeamPkLaunchFragmentNew;", "Landroidx/fragment/app/Fragment;", "", "Lcom/bytedance/android/live/revlink/impl/multianchor/ui/a;", "Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/b;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiAnchorTeamPkLaunchFragmentNew extends Fragment implements com.bytedance.android.live.revlink.impl.multianchor.ui.a, com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.b {
    public static final /* synthetic */ int l = 0;
    public Map<Integer, View> d;
    public com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.a e;
    public final CompositeDisposable f;
    public final yz0.l g;
    public boolean h;
    public q21.h i;
    public boolean j;
    public final com.bytedance.android.live.revlink.impl.pk.utils.d k;

    public static final class a<T> implements Observer {
        public final /* synthetic */ MultiAnchorTeamPkLaunchFragmentNew a;

        public a(MultiAnchorTeamPkLaunchFragmentNew r1) {
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
            MultiAnchorTeamPkLaunchFragmentNew r7 = this.a;
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
            com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.a r13 = r7.e;
            if (r13 == null) goto L28;
            r13.JW(r12, PlayMode.TEAM_PK);
            return;
        L28:
            return;
        L20:
            r12 = false;
            goto L21
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.MultiAnchorTeamPkLaunchFragmentNew$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass1(MultiAnchorTeamPkLaunchFragmentNew r8) {
            super(1, r8, MultiAnchorTeamPkLaunchFragmentNew.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public final void invoke(yh6.c r3) {
            Intrinsics.checkNotNullParameter(r3, "p1");
            MultiAnchorTeamPkLaunchFragmentNew r0 = (MultiAnchorTeamPkLaunchFragmentNew) ((CallableReference) this).receiver;
            int r1 = MultiAnchorTeamPkLaunchFragmentNew.l;
            r0.getClass();
            if ((r3 instanceof r0) == false) goto L8;
            MultiAnchorPkLaunchViewModelNew r4 = r0.T90();
            if (r4 == null) goto L9;
            r4.dismiss();
            return;
        L9:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.a
    public final void n50() {
        HashMap r0 = new HashMap();
        MultiAnchorPkLaunchViewModelNew r1 = T90();
        if (r1 == null) goto L7;
        String r2 = r1.getNpkInvitePageSource();
        if (r2 == null) goto L7;
        r0.put("npk_invite_page_source", r2);
    L7:
        MultiAnchorPkLaunchViewModelNew r3 = T90();
        if (r3 == null) goto L12;
        NextLiveData<PlayMode> r4 = r3.getPlayModeLiveData();
        if (r4 == null) goto L12;
        PlayMode r5 = (PlayMode) r4.getValue();
    L14:
        if (r5 == null) goto L20;
        int r6 = a0.a[r5.ordinal()];
        if (r6 != 1) goto L19;
        String r7 = "individual_pk";
    L23:
        r0.put("battle_mode", r7);
        mz0.n r8 = new mz0.n();
        Map<String, String> r9 = r8.a;
        Intrinsics.checkNotNullParameter(r9, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r9.putAll(r0);
        mz0.m r10 = new mz0.m();
        r10.b(LogCommon.ROOM);
        LinkCrossRoomDataHolder.a r12 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r10);
        ((ArrayList) r8.b).addAll(r10.a);
        cy0.e.a.getClass();
        cy0.j r13 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r14 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r14);
        ((mz0.i) ((f80.a) r14)).w3("livesdk_npk_invite_page_switch_teams_click", r8.a, r8.b);
        MultiAnchorPkLaunchViewModelNew r15 = T90();
        if (r15 == null) goto L37;
        MutableLiveData<q21.h> r16 = r15.getTeamPkAnchorTeamMatchData();
        if (r16 == null) goto L37;
        q21.h r17 = (q21.h) r16.getValue();
        if (r17 == null) goto L37;
        if (r17.b() != true) goto L37;
        MultiAnchorPkLaunchViewModelNew r18 = T90();
        if (r18 == null) goto L35;
        r18.requestChangeMultiTeam();
    L35:
        this.h = true;
        return;
    L37:
        int r19 = ToastUtil.a;
        ToastUtil.b(s1.C(2131917499, new Object[]{"比拼"}), 0);
        q21.h r20 = this.i;
        if (r20 == null) goto L41;
        ((TeamPkMatchView) S90(2131362913)).U5(new ArrayList(r20.b), new ArrayList(r20.c));
        return;
    L41:
        return;
    L19:
        if (r6 != 2) goto L20;
        r7 = "team_pk";
    L20:
        r7 = "";
    L12:
        r5 = null;
        goto L14
    }

    public final MultiAnchorPkLaunchViewModelNew T90() {
        Fragment r0 = getParentFragment();
        if (r0 == null) goto L10;
        if (r0.getActivity() != null) goto L8;
        return null;
    L8:
        return (MultiAnchorPkLaunchViewModelNew) ViewModelProviders.of(r0).get(MultiAnchorPkLaunchViewModelNew.class);
    L10:
        if (getActivity() != null) goto L13;
        return null;
    L13:
        return (MultiAnchorPkLaunchViewModelNew) ViewModelProviders.of(requireActivity()).get(MultiAnchorPkLaunchViewModelNew.class);
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f.dispose();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d.clear();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.a
    public final boolean Zl() {
        return this.h;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.b
    public final boolean qr() {
        return this.j;
    }

    public MultiAnchorTeamPkLaunchFragmentNew(p21.e r2) {
        Intrinsics.checkNotNullParameter(r2, "metricUtil");
        this.k = r2;
        this.d = new LinkedHashMap();
        this.f = new CompositeDisposable();
        this.g = (yz0.l) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.l.class);
    }

    public static void U90(MultiAnchorTeamPkLaunchFragmentNew r4) {
        r4.getClass();
        h41.f r0 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r0 == null) goto L24;
        MultiAnchorPkLaunchViewModelNew r1 = r4.T90();
        if (r1 == null) goto L9;
        List<com.bytedance.android.livesdk.link.model.p> r2 = r1.getCurrentAnchorList();
        if (r2 == null) goto L9;
        int r3 = r2.size();
    L10:
        MultiAnchorPkLaunchViewModelNew r5 = r4.T90();
        if (r5 == null) goto L15;
        List<com.bytedance.android.livesdk.link.model.p> r6 = r5.getCurrentAnchorList();
        if (r6 == null) goto L15;
        int r7 = r6.size();
    L16:
        MultiAnchorPkLaunchViewModelNew r8 = r4.T90();
        if (r8 == null) goto L21;
        NextLiveData<PlayMode> r9 = r8.getPlayModeLiveData();
        if (r9 == null) goto L21;
        PlayMode r10 = (PlayMode) r9.getValue();
    L22:
        r0.h(false, r3, r7, r10);
        return;
    L21:
        r10 = null;
    L15:
        r7 = 0;
    L9:
        r3 = 0;
        goto L10
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.b
    public final void JF(IBattleConfigSetting r8) {
        V90("SeasonRank", s1.B(2131921445), new h31.h.i(), l51.a.j(), r8);
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r4 = (View) ((LinkedHashMap) this.d).get(2131362913);
        if (r4 != null) goto L14;
        View r5 = getView();
        if (r5 == null) goto L12;
        View r6 = r5.findViewById(2131362913);
        if (r6 == null) goto L12;
        this.d.put(2131362913, r6);
        return r6;
    L12:
        return null;
    L14:
        return r4;
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        yz0.l r5 = this.g;
        if (r5 == null) goto L10;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r6 = yz0.h.a.a(r5, com.bytedance.android.live.revenue.common.message.b.e, false, 6);
        if (r6 == null) goto L11;
        final AnonymousClass1 r0 = new AnonymousClass1(this);
        Disposable r7 = r6.subscribe(new b(r0));
        if (r7 == null) goto L12;
        RxUtilKt.c(r7, this.f);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.b
    public final void ae(w2 r9, IBattleConfigSetting r10) {
        Intrinsics.checkNotNullParameter(r9, "shellConfig");
        String r3 = r9.getName();
        if (r3 != null) goto L5;
        return;
    L5:
        if ((!StringsKt.isBlank(r3)) != true) goto L9;
        V90(r3, r3, new h31.h.e(r9), l51.a.j(), r10);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.b
    public final void ah(h31.h r10, IBattleConfigSetting r12) {
        com.bytedance.android.live.revlink.impl.pk.utils.q r0 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r0 == null) goto L7;
        PkCustomizePlayDataContext r1 = r0.f();
        if (r1 == null) goto L7;
        u2 r2 = r1.getBattleSelfData();
    L8:
        if (r2 == null) goto L10;
        boolean r3 = true;
    L11:
        if (r10 != null) goto L16;
        if (r3 == false) goto L14;
        h31.h r4 = h31.h.a.b;
    L15:
        h31.h r5 = r4;
    L18:
        if ((r10 instanceof h31.h.c) == true) goto L20;
        r10 = null;
    L20:
        h31.h.c r13 = (h31.h.c) r10;
        if (r13 == null) goto L25;
        d4 r14 = r13.b;
        if (r14 == null) goto L25;
        long r6 = r14.getDuration();
    L26:
        V90("PK", "多人PK", r5, r6, r12);
        return;
    L25:
        r6 = l51.a.j();
        goto L26
    L14:
        r4 = h31.h.d.b;
        goto L15
    L16:
        r5 = r10;
        goto L18
    L10:
        r3 = false;
    L7:
        r2 = null;
        goto L8
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        TeamPkMatchView r4 = (TeamPkMatchView) S90(2131362913);
        MultiAnchorPkLaunchViewModelNew r5 = T90();
        if (r5 == null) goto L5;
        IBattleConfigSetting r6 = r5.getBattleConfigSetting();
    L6:
        r4.setBattleConfigSetting(r6);
        MultiAnchorPkLaunchViewModelNew r7 = T90();
        if (r7 == null) goto L12;
        MutableLiveData<q21.h> r8 = r7.getTeamPkAnchorTeamMatchData();
        if (r8 == null) goto L13;
        r8.observe(getViewLifecycleOwner(), new a(this));
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131566076, r3, false);
    }

    public final void V90(String r22, String r23, h31.h r24, long r25, IBattleConfigSetting r26) {
        MultiAnchorPkLaunchViewModelNew r1 = T90();
        Integer r4 = null;
        if (r1 != null) goto L5;
    L20:
        MultiAnchorPkLaunchViewModelNew r2 = T90();
        if (r2 != null) goto L23;
    L38:
        q21.h r3 = this.i;
        if (r3 == null) goto L79;
        List<TeamPkMatchView.b> r6 = r3.b;
        List<TeamPkMatchView.b> r5 = r3.c;
        ArrayList r7 = (ArrayList) r6;
        if (r7.size() <= 0) goto L61;
        ArrayList r8 = (ArrayList) r5;
        if (r8.size() <= 0) goto L61;
        if ((r7.size() + r8.size()) > 2) goto L61;
        h41.f r9 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r9 == null) goto L58;
        MultiAnchorPkLaunchViewModelNew r10 = T90();
        if (r10 == null) goto L51;
        String r12 = r10.getNpkInvitePageSource();
    L52:
        MultiAnchorPkLaunchViewModelNew r13 = T90();
        if (r13 == null) goto L57;
        List<com.bytedance.android.livesdk.link.model.p> r14 = r13.getCurrentAnchorList();
        if (r14 == null) goto L57;
        r4 = Integer.valueOf(r14.size());
    L57:
        r9.g(r12, "team_pk", r4, 0);
        goto L58
    L51:
        r12 = null;
    L58:
        int r15 = ToastUtil.a;
        ToastUtil.b(s1.C(2131917496, new Object[]{r23}), 0);
        U90(this);
        return;
    L61:
        if (r7.size() != 0) goto L63;
    L64:
        h41.f r16 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r16 == null) goto L76;
        MultiAnchorPkLaunchViewModelNew r17 = T90();
        if (r17 == null) goto L69;
        String r18 = r17.getNpkInvitePageSource();
    L70:
        MultiAnchorPkLaunchViewModelNew r19 = T90();
        if (r19 == null) goto L75;
        List<com.bytedance.android.livesdk.link.model.p> r20 = r19.getCurrentAnchorList();
        if (r20 == null) goto L75;
        r4 = Integer.valueOf(r20.size());
    L75:
        r16.g(r18, "team_pk", r4, 0);
        goto L76
    L69:
        r18 = null;
    L76:
        int r27 = ToastUtil.a;
        ToastUtil.b(s1.C(2131917499, new Object[]{r23}), 0);
        U90(this);
        return;
    L63:
        if (((ArrayList) r5).size() == 0) goto L64;
    L79:
        if (this.j == true) goto L94;
        h41.f r28 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r28 == null) goto L92;
        MultiAnchorPkLaunchViewModelNew r29 = T90();
        if (r29 == null) goto L85;
        String r30 = r29.getNpkInvitePageSource();
    L86:
        MultiAnchorPkLaunchViewModelNew r32 = T90();
        if (r32 == null) goto L91;
        List<com.bytedance.android.livesdk.link.model.p> r33 = r32.getCurrentAnchorList();
        if (r33 == null) goto L91;
        r4 = Integer.valueOf(r33.size());
    L91:
        r28.g(r30, "team_pk", r4, 0);
        goto L92
    L85:
        r30 = null;
    L92:
        U90(this);
        return;
    L94:
        h41.f r34 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r34 == null) goto L107;
        MultiAnchorPkLaunchViewModelNew r35 = T90();
        if (r35 == null) goto L99;
        String r36 = r35.getNpkInvitePageSource();
    L100:
        MultiAnchorPkLaunchViewModelNew r37 = T90();
        if (r37 == null) goto L105;
        List<com.bytedance.android.livesdk.link.model.p> r38 = r37.getCurrentAnchorList();
        if (r38 == null) goto L105;
        Integer r39 = Integer.valueOf(r38.size());
    L106:
        r34.g(r36, "team_pk", r39, 1);
    L105:
        r39 = null;
        goto L106
    L99:
        r36 = null;
    L107:
        MultiPKLauncher r110 = com.bytedance.android.live.revlink.impl.global.b.F();
        if (r110 == null) goto L151;
        MultiAnchorPkLaunchViewModelNew r40 = T90();
        if (r40 == null) goto L113;
        List<com.bytedance.android.livesdk.link.model.p> r42 = r40.getCurrentAnchorList();
        if (r42 == null) goto L113;
    L115:
        if ((r24 instanceof h31.h.c) == true) goto L117;
        h31.h r43 = null;
    L118:
        h31.h.c r44 = (h31.h.c) r43;
        if (r44 == null) goto L121;
        d4 r45 = r44.b;
    L123:
        if ((r24 instanceof h31.h.e) == false) goto L125;
        w2 r46 = ((h31.h.e) r24).b;
    L126:
        PkBaseDataContext.PKModType r47 = PkBaseDataContext.PKModType.Default;
        PlayMode r48 = PlayMode.TEAM_PK;
        int r49 = r42.size();
        ArrayList r50 = new ArrayList();
        Iterator<com.bytedance.android.livesdk.link.model.p> r52 = r42.iterator();
    L128:
        if (r52.hasNext() == false) goto L134;
        IBaseUser r111 = r52.next().getUser();
        if (r111 == null) goto L128;
        String r112 = iz.a.a(r111);
        if (r112 == null) goto L128;
        r50.add(r112);
        goto L128
    L134:
        h31.d r53 = new h31.d(r48, r49, r50);
        if (r45 == null) goto L137;
        h31.c r54 = new h31.c(r45);
    L139:
        if ((r24 instanceof h31.h.f) == false) goto L141;
        h9 r113 = ((h31.h.f) r24).b;
    L142:
        r110.openPk(new h31.f(r47, r25, r53, null, null, r54, r46, r113, r24, this.k.a(), com.bytedance.android.live.revlink.impl.pk.utils.l.n.c, r26, DefaultConfig.MAX_CACHE_ENTRIES), new b0(this));
        return;
    L141:
        r113 = null;
        goto L142
    L137:
        r54 = null;
        goto L139
    L125:
        r46 = null;
        goto L126
    L121:
        r45 = null;
        goto L123
    L117:
        r43 = r24;
    L113:
        r42 = new ArrayList();
        goto L115
    L151:
        return;
    L23:
        if (r2.getHasApplicant() != true) goto L38;
        h41.f r55 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r55 == null) goto L36;
        MultiAnchorPkLaunchViewModelNew r56 = T90();
        if (r56 == null) goto L29;
        String r57 = r56.getNpkInvitePageSource();
    L30:
        MultiAnchorPkLaunchViewModelNew r58 = T90();
        if (r58 == null) goto L35;
        List<com.bytedance.android.livesdk.link.model.p> r59 = r58.getCurrentAnchorList();
        if (r59 == null) goto L35;
        r4 = Integer.valueOf(r59.size());
    L35:
        r55.g(r57, "team_pk", r4, 0);
        goto L36
    L29:
        r57 = null;
    L36:
        U90(this);
        int r60 = ToastUtil.a;
        ToastUtil.b(s1.C(2131917495, new Object[]{r22}), 0);
        return;
    L5:
        if (r1.getHasInvitee() != true) goto L20;
        h41.f r62 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r62 == null) goto L18;
        MultiAnchorPkLaunchViewModelNew r63 = T90();
        if (r63 == null) goto L11;
        String r64 = r63.getNpkInvitePageSource();
    L12:
        MultiAnchorPkLaunchViewModelNew r65 = T90();
        if (r65 == null) goto L17;
        List<com.bytedance.android.livesdk.link.model.p> r66 = r65.getCurrentAnchorList();
        if (r66 == null) goto L17;
        r4 = Integer.valueOf(r66.size());
    L17:
        r62.g(r64, "team_pk", r4, 0);
        goto L18
    L11:
        r64 = null;
    L18:
        U90(this);
        int r67 = ToastUtil.a;
        ToastUtil.b(s1.C(2131917497, new Object[]{r22}), 0);
    }
}
