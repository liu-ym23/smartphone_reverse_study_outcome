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
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.vm.MultiAnchorPkLaunchViewModelNew;
import com.bytedance.android.live.revlink.impl.multianchor.pk.PkSwitchMultiSelectPkView;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkCustomizePlayDataContext;
import com.bytedance.android.live.revlink.link.biz.component.MultiPKLauncher;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.bridge.r0;
import com.bytedance.android.livesdk.link.model.d4;
import com.bytedance.android.livesdk.link.model.h9;
import com.bytedance.android.livesdk.link.model.u2;
import com.bytedance.android.livesdk.link.model.w2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
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
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/MultiAnchorPersonalPkLaunchFragmentNew;", "Landroidx/fragment/app/Fragment;", "", "Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/b;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiAnchorPersonalPkLaunchFragmentNew extends Fragment implements com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.b {
    public static final /* synthetic */ int m = 0;
    public Map<Integer, View> d;
    public com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.a e;
    public final CompositeDisposable f;
    public final IRoom g;
    public final yz0.l h;
    public y31.u i;
    public boolean j;
    public final DataCenter k;
    public final com.bytedance.android.live.revlink.impl.pk.utils.d l;

    public static final class a<T> implements Observer {
        public final /* synthetic */ MultiAnchorPersonalPkLaunchFragmentNew a;

        public a(MultiAnchorPersonalPkLaunchFragmentNew r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            y31.u r6 = (y31.u) r5;
            MultiAnchorPersonalPkLaunchFragmentNew r0 = this.a;
            r0.i = r6;
            if (r0.d != null) goto L5;
            r0.d = new LinkedHashMap();
        L5:
            View r1 = (View) ((LinkedHashMap) r0.d).get(2131362913);
            if (r1 != null) goto L13;
            View r2 = r0.getView();
            if (r2 == null) goto L12;
            r1 = r2.findViewById(2131362913);
            if (r1 == null) goto L12;
            r0.d.put(2131362913, r1);
        L12:
            r1 = null;
        L13:
            PkSwitchMultiSelectPkView r3 = (PkSwitchMultiSelectPkView) r1;
            if (r6 == null) goto L17;
            List<com.bytedance.android.livesdk.link.model.p> r7 = r6.a;
            if (r7 == null) goto L17;
        L18:
            r3.update(r7, this.a.k);
            MultiAnchorPersonalPkLaunchFragmentNew r8 = this.a;
            y31.u r4 = r8.i;
            if (r4 == null) goto L23;
            List<com.bytedance.android.livesdk.link.model.p> r9 = r4.a;
            if (r9 == null) goto L23;
            int r10 = r9.size();
        L25:
            if (r10 <= 2) goto L27;
            boolean r12 = true;
        L28:
            r8.j = r12;
            y31.u r13 = r8.i;
            if (r13 == null) goto L32;
            List r14 = r13.a;
            if (r14 == null) goto L32;
        L33:
            Iterator r15 = r14.iterator();
        L35:
            if (r15.hasNext() == false) goto L39;
            if (((com.bytedance.android.livesdk.link.model.p) r15.next()).getStatus() == 2) goto L35;
            r8.j = false;
            goto L35
        L39:
            com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.a r16 = r8.e;
            if (r16 == null) goto L48;
            r16.JW(r8.j, PlayMode.PERSONAL_PK);
            return;
        L48:
            return;
        L32:
            r14 = new ArrayList();
            goto L33
        L27:
            r12 = false;
        L23:
            r10 = 0;
        L17:
            r7 = CollectionsKt.emptyList();
            goto L18
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.MultiAnchorPersonalPkLaunchFragmentNew$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass1(MultiAnchorPersonalPkLaunchFragmentNew r8) {
            super(1, r8, MultiAnchorPersonalPkLaunchFragmentNew.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public final void invoke(yh6.c r3) {
            Intrinsics.checkNotNullParameter(r3, "p1");
            MultiAnchorPersonalPkLaunchFragmentNew r0 = (MultiAnchorPersonalPkLaunchFragmentNew) ((CallableReference) this).receiver;
            int r1 = MultiAnchorPersonalPkLaunchFragmentNew.m;
            r0.getClass();
            if ((r3 instanceof r0) == false) goto L8;
            MultiAnchorPkLaunchViewModelNew r4 = r0.S90();
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

    public final MultiAnchorPkLaunchViewModelNew S90() {
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

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.b
    public final boolean qr() {
        return this.j;
    }

    public static void T90(MultiAnchorPersonalPkLaunchFragmentNew r4) {
        r4.getClass();
        h41.f r0 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r0 == null) goto L24;
        MultiAnchorPkLaunchViewModelNew r1 = r4.S90();
        if (r1 == null) goto L9;
        List<com.bytedance.android.livesdk.link.model.p> r2 = r1.getCurrentAnchorList();
        if (r2 == null) goto L9;
        int r3 = r2.size();
    L10:
        MultiAnchorPkLaunchViewModelNew r5 = r4.S90();
        if (r5 == null) goto L15;
        List<com.bytedance.android.livesdk.link.model.p> r6 = r5.getCurrentAnchorList();
        if (r6 == null) goto L15;
        int r7 = r6.size();
    L16:
        MultiAnchorPkLaunchViewModelNew r8 = r4.S90();
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
        U90("SeasonRank", s1.B(2131921445), new h31.h.i(), l51.a.j(), r8);
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        yz0.l r5 = this.h;
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

    public MultiAnchorPersonalPkLaunchFragmentNew(DataCenter r2, p21.e r3) {
        Intrinsics.checkNotNullParameter(r3, "metricUtil");
        this.k = r2;
        this.l = r3;
        this.d = new LinkedHashMap();
        this.f = new CompositeDisposable();
        com.bytedance.android.live.revenue.core.util.j.a r4 = com.bytedance.android.live.revenue.core.util.j.C0;
        yz0.k r5 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(r4.a(), yz0.k.class);
        if (r5 == null) goto L5;
        IRoom r6 = r5.getRoom();
    L6:
        this.g = r6;
        this.h = (yz0.l) com.bytedance.android.live.revenue.core.util.f.d(r4.a(), yz0.l.class);
        new ArrayList();
        return;
    L5:
        r6 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.b
    public final void ae(w2 r9, IBattleConfigSetting r10) {
        Intrinsics.checkNotNullParameter(r9, "shellConfig");
        String r3 = r9.getName();
        if (r3 != null) goto L5;
        return;
    L5:
        if ((!StringsKt.isBlank(r3)) != true) goto L9;
        U90(r3, r3, new h31.h.e(r9), l51.a.j(), r10);
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
        U90("PK", "多人PK", r5, r6, r12);
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
        MultiAnchorPkLaunchViewModelNew r4 = S90();
        if (r4 == null) goto L8;
        MutableLiveData<y31.u> r5 = r4.getPersonalPkSwitchMultiData();
        if (r5 == null) goto L9;
        r5.observe(getViewLifecycleOwner(), new a(this));
        return;
    L9:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131566075, r3, false);
    }

    public final void U90(String r23, String r24, h31.h r25, long r26, IBattleConfigSetting r28) {
        MultiAnchorPkLaunchViewModelNew r1 = S90();
        Integer r4 = null;
        int r5 = 0;
        if (r1 != null) goto L5;
    L20:
        MultiAnchorPkLaunchViewModelNew r2 = S90();
        if (r2 != null) goto L23;
    L38:
        MultiAnchorPkLaunchViewModelNew r3 = S90();
        if (r3 == null) goto L43;
        List<com.bytedance.android.livesdk.link.model.p> r6 = r3.getCurrentAnchorList();
        if (r6 == null) goto L43;
        int r7 = r6.size();
    L45:
        if (r7 > 2) goto L61;
        h41.f r8 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r8 == null) goto L58;
        MultiAnchorPkLaunchViewModelNew r9 = S90();
        if (r9 == null) goto L51;
        String r10 = r9.getNpkInvitePageSource();
    L52:
        MultiAnchorPkLaunchViewModelNew r12 = S90();
        if (r12 == null) goto L57;
        List<com.bytedance.android.livesdk.link.model.p> r13 = r12.getCurrentAnchorList();
        if (r13 == null) goto L57;
        r4 = Integer.valueOf(r13.size());
    L57:
        r8.g(r10, "individual_pk", r4, 0);
        goto L58
    L51:
        r10 = null;
    L58:
        T90(this);
        int r14 = ToastUtil.a;
        ToastUtil.b(s1.C(2131917496, new Object[]{r24}), 0);
        return;
    L61:
        if (this.j == true) goto L76;
        h41.f r15 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r15 == null) goto L74;
        MultiAnchorPkLaunchViewModelNew r16 = S90();
        if (r16 == null) goto L67;
        String r17 = r16.getNpkInvitePageSource();
    L68:
        MultiAnchorPkLaunchViewModelNew r18 = S90();
        if (r18 == null) goto L73;
        List<com.bytedance.android.livesdk.link.model.p> r19 = r18.getCurrentAnchorList();
        if (r19 == null) goto L73;
        r4 = Integer.valueOf(r19.size());
    L73:
        r15.g(r17, "individual_pk", r4, 0);
        goto L74
    L67:
        r17 = null;
    L74:
        T90(this);
        return;
    L76:
        h41.f r20 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r20 == null) goto L89;
        MultiAnchorPkLaunchViewModelNew r22 = S90();
        if (r22 == null) goto L81;
        String r27 = r22.getNpkInvitePageSource();
    L82:
        MultiAnchorPkLaunchViewModelNew r29 = S90();
        if (r29 == null) goto L87;
        List<com.bytedance.android.livesdk.link.model.p> r30 = r29.getCurrentAnchorList();
        if (r30 == null) goto L87;
        Integer r32 = Integer.valueOf(r30.size());
    L88:
        r20.g(r27, "individual_pk", r32, 1);
    L87:
        r32 = null;
        goto L88
    L81:
        r27 = null;
    L89:
        MultiPKLauncher r110 = com.bytedance.android.live.revlink.impl.global.b.F();
        if (r110 == null) goto L138;
        MultiAnchorPkLaunchViewModelNew r33 = S90();
        if (r33 == null) goto L94;
        List<com.bytedance.android.livesdk.link.model.p> r34 = r33.getCurrentAnchorList();
    L96:
        if ((r25 instanceof h31.h.c) == true) goto L98;
        h31.h r35 = null;
    L99:
        h31.h.c r36 = (h31.h.c) r35;
        if (r36 == null) goto L102;
        d4 r37 = r36.b;
    L103:
        PkBaseDataContext.PKModType r38 = PkBaseDataContext.PKModType.Default;
        PlayMode r39 = PlayMode.PERSONAL_PK;
        if (r34 == null) goto L106;
        r5 = r34.size();
    L106:
        ArrayList r40 = new ArrayList();
        if (r34 == null) goto L117;
        Iterator<com.bytedance.android.livesdk.link.model.p> r42 = r34.iterator();
    L111:
        if (r42.hasNext() == false) goto L117;
        IBaseUser r43 = r42.next().getUser();
        if (r43 == null) goto L111;
        String r44 = iz.a.a(r43);
        if (r44 == null) goto L111;
        r40.add(r44);
    L117:
        h31.d r45 = new h31.d(r39, r5, r40);
        if (r37 == null) goto L120;
        h31.c r46 = new h31.c(r37);
    L122:
        if ((r25 instanceof h31.h.e) == false) goto L124;
        w2 r111 = ((h31.h.e) r25).b;
    L126:
        if ((r25 instanceof h31.h.f) == false) goto L128;
        h9 r112 = ((h31.h.f) r25).b;
    L129:
        r110.openPk(new h31.f(r38, r26, r45, null, null, r46, r111, r112, r25, this.l.a(), com.bytedance.android.live.revlink.impl.pk.utils.l.m.c, r28, DefaultConfig.MAX_CACHE_ENTRIES), new x(this));
        return;
    L128:
        r112 = null;
        goto L129
    L124:
        r111 = null;
        goto L126
    L120:
        r46 = null;
        goto L122
    L102:
        r37 = null;
        goto L103
    L98:
        r35 = r25;
        goto L99
    L94:
        r34 = null;
        goto L96
    L138:
        return;
    L43:
        r7 = 0;
        goto L45
    L23:
        if (r2.getHasApplicant() != true) goto L38;
        h41.f r47 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r47 == null) goto L36;
        MultiAnchorPkLaunchViewModelNew r48 = S90();
        if (r48 == null) goto L29;
        String r49 = r48.getNpkInvitePageSource();
    L30:
        MultiAnchorPkLaunchViewModelNew r50 = S90();
        if (r50 == null) goto L35;
        List<com.bytedance.android.livesdk.link.model.p> r52 = r50.getCurrentAnchorList();
        if (r52 == null) goto L35;
        r4 = Integer.valueOf(r52.size());
    L35:
        r47.g(r49, "individual_pk", r4, 0);
        goto L36
    L29:
        r49 = null;
    L36:
        T90(this);
        int r53 = ToastUtil.a;
        ToastUtil.b(s1.C(2131917495, new Object[]{r23}), 0);
        return;
    L5:
        if (r1.getHasInvitee() != true) goto L20;
        h41.f r54 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r54 == null) goto L18;
        MultiAnchorPkLaunchViewModelNew r55 = S90();
        if (r55 == null) goto L11;
        String r56 = r55.getNpkInvitePageSource();
    L12:
        MultiAnchorPkLaunchViewModelNew r57 = S90();
        if (r57 == null) goto L17;
        List<com.bytedance.android.livesdk.link.model.p> r58 = r57.getCurrentAnchorList();
        if (r58 == null) goto L17;
        r4 = Integer.valueOf(r58.size());
    L17:
        r54.g(r56, "individual_pk", r4, 0);
        goto L18
    L11:
        r56 = null;
    L18:
        T90(this);
        int r59 = ToastUtil.a;
        ToastUtil.b(s1.C(2131917497, new Object[]{r23}), 0);
    }
}
