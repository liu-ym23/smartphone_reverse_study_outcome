package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.control.dialog.LinkRevPanelDataContext;
import com.bytedance.android.live.revlink.impl.control.dialog.r;
import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPkPrecisionMatchInviteContract$View;
import com.bytedance.android.live.revlink.impl.pk.flexactivity.InteractFlexMatchSettingDialog;
import com.bytedance.android.live.revlink.impl.pk.service.ToolBarPic;
import com.bytedance.android.live.revlink.impl.pk.utils.w;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkPrecisionMatchDataContext;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.IBattlePrecisionMatcher;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.bridge.s0;
import com.bytedance.android.livesdk.link.model.d2;
import com.bytedance.android.livesdk.link.model.d5;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.w0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/InteractPkPrecisionMatchInviteFragment;", "Lcom/bytedance/android/live/revlink/impl/pk/dialog/contract/InteractDialogPkPrecisionMatchInviteContract$View;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractPkPrecisionMatchInviteFragment extends InteractDialogPkPrecisionMatchInviteContract$View implements View.OnClickListener {
    public static final /* synthetic */ int x = 0;
    public Map<Integer, View> g;
    public DataCenter h;
    public com.bytedance.android.live.revlink.impl.pk.dialog.presenter.k i;
    public final ArrayList<IBattlePrecisionMatcher> j;
    public String k;
    public long l;
    public long m;
    public IRoom n;
    public d2 o;
    public IBattlePrecisionMatcher p;
    public IBattlePrecisionMatcher q;
    public final yz0.l r;
    public final CompositeDisposable s;
    public InteractFlexMatchSettingDialog t;
    public PkPrecisionMatchDataContext u;
    public ViewGroup v;
    public String w;

    public static final class a {
        public static InteractPkPrecisionMatchInviteFragment a(r r5, DataCenter r6, int r7, PkPrecisionMatchDataContext r8) {
            Intrinsics.checkNotNullParameter(r6, "dataCenter");
            InteractPkPrecisionMatchInviteFragment r0 = new InteractPkPrecisionMatchInviteFragment();
            r0.f = new com.bytedance.android.live.revlink.impl.pk.dialog.presenter.k(r0);
            r0.i = new com.bytedance.android.live.revlink.impl.pk.dialog.presenter.k(r0);
            r0.d = r5;
            r0.h = r6;
            r0.u = r8;
            if (r7 != 1) goto L20;
            if (r8 == null) goto L47;
            d5 r9 = r8.getMessage();
            if (r9 == null) goto L47;
            d2 r10 = r9.getPrecisionMatch();
            if (r10 == null) goto L47;
            r0.j.clear();
            r0.j.addAll(r10.getMatcherList());
            PkPrecisionMatchDataContext r12 = r0.u;
            if (r12 == null) goto L12;
            r12.addPrecisionMatcherList(r10.getMatcherList());
        L12:
            r0.k = r10.getMatchReason();
            r10.getActivityName();
            r10.getRecommendReason();
            r0.l = r10.getWaitSeconds();
            PkPrecisionMatchDataContext r13 = r0.u;
            if (r13 == null) goto L15;
            r13.setPrecisionMatchWaitingSeconds(r10.getWaitSeconds());
        L15:
            r0.m = r10.getPrecisionMatchId();
            r0.o = r10;
            String r14 = r10.getActivityId();
            if (r14 != null) goto L18;
            r14 = "";
        L18:
            r0.w = r14;
        L47:
            yz0.k r15 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
            if (r15 == null) goto L50;
            IRoom r16 = r15.getRoom();
        L51:
            r0.n = r16;
            if (r16 == null) goto L68;
            Iterator<IBattlePrecisionMatcher> r17 = r0.j.iterator();
        L55:
            if (r17.hasNext() == false) goto L68;
            IBattlePrecisionMatcher r18 = r17.next();
            String r1 = r18.getUserId();
            IRoom r2 = r0.n;
            if (r2 == null) goto L61;
            IBaseUser r3 = r2.getOwner();
            if (r3 == null) goto L61;
            String r4 = iz.a.a(r3);
        L63:
            if (Intrinsics.areEqual(r1, r4) == true) goto L64;
            r0.q = r18;
            if (r8 == null) goto L55;
            r8.setOppoPrecisionMatcher(r18);
            goto L55
        L64:
            r0.p = r18;
        L61:
            r4 = null;
        L68:
            return r0;
        L50:
            r16 = null;
            goto L51
        L20:
            if (r7 != 2) goto L47;
            if (r8 == null) goto L23;
            String r19 = r8.getMatchReason();
        L24:
            r0.k = r19;
            PkPrecisionMatchDataContext r20 = r0.u;
            if (r20 == null) goto L27;
            r20.getActivityName();
        L27:
            PkPrecisionMatchDataContext r22 = r0.u;
            if (r22 == null) goto L30;
            r22.getRecommendReason();
        L30:
            PkPrecisionMatchDataContext r23 = r0.u;
            if (r23 == null) goto L35;
            ArrayList<IBattlePrecisionMatcher> r24 = r23.getPrecisionMatcherList();
            if (r24 == null) goto L35;
            r0.j.clear();
            r0.j.addAll(r24);
        L35:
            PkPrecisionMatchDataContext r25 = r0.u;
            long r26 = 0;
            if (r25 == null) goto L38;
            long r27 = r25.getPrecisionMatchWaitingSeconds();
        L39:
            r0.l = r27;
            PkPrecisionMatchDataContext r28 = r0.u;
            if (r28 == null) goto L42;
            r26 = r28.getMatchId();
        L42:
            r0.m = r26;
            com.bytedance.android.live.revlink.impl.pk.service.e r29 = com.bytedance.android.live.revlink.impl.global.b.Q();
            if (r29 == null) goto L47;
            d2 r30 = r29.getBattlePrecisionMatch();
            if (r30 == null) goto L47;
            r0.o = r30;
            goto L47
        L38:
            r27 = 0;
            goto L39
        L23:
            r19 = null;
            goto L24
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPkPrecisionMatchInviteFragment$onViewCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass1(InteractPkPrecisionMatchInviteFragment r8) {
            super(1, r8, InteractPkPrecisionMatchInviteFragment.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public final void invoke(yh6.c r6) {
            Intrinsics.checkNotNullParameter(r6, "p1");
            InteractPkPrecisionMatchInviteFragment r0 = (InteractPkPrecisionMatchInviteFragment) ((CallableReference) this).receiver;
            int r1 = InteractPkPrecisionMatchInviteFragment.x;
            r0.getClass();
            if ((r6 instanceof s0) == false) goto L47;
            d5 r7 = ((vh7.c) r6).castTo(d5.class);
            r0.j.clear();
            ArrayList<IBattlePrecisionMatcher> r2 = r0.j;
            d2 r3 = r7.getPrecisionMatch();
            if (r3 == null) goto L9;
            List r4 = r3.getMatcherList();
            if (r4 == null) goto L9;
        L10:
            r2.addAll(r4);
            PkPrecisionMatchDataContext r5 = r0.u;
            if (r5 == null) goto L19;
            d2 r8 = r7.getPrecisionMatch();
            if (r8 == null) goto L16;
            List<? extends IBattlePrecisionMatcher> r9 = r8.getMatcherList();
            if (r9 == null) goto L16;
        L17:
            r5.addPrecisionMatcherList(r9);
        L16:
            r9 = CollectionsKt.emptyList();
        L19:
            if (r0.n == null) goto L35;
            Iterator<IBattlePrecisionMatcher> r10 = r0.j.iterator();
        L22:
            if (r10.hasNext() == false) goto L35;
            IBattlePrecisionMatcher r12 = r10.next();
            String r13 = r12.getUserId();
            IRoom r14 = r0.n;
            if (r14 == null) goto L28;
            IBaseUser r15 = r14.getOwner();
            if (r15 == null) goto L28;
            String r16 = iz.a.a(r15);
        L30:
            if (Intrinsics.areEqual(r13, r16) == true) goto L31;
            r0.q = r12;
            PkPrecisionMatchDataContext r17 = r0.u;
            if (r17 == null) goto L22;
            r17.setOppoPrecisionMatcher(r12);
            goto L22
        L31:
            r0.p = r12;
        L28:
            r16 = null;
        L35:
            r0.o = r7.getPrecisionMatch();
            IBattlePrecisionMatcher r18 = r0.q;
            if (r18 == null) goto L48;
            r0.ga0(r18.getStatus());
            return;
        L48:
            return;
        L9:
            r4 = CollectionsKt.emptyList();
            goto L10
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final String X90() {
        return "";
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final float U90() {
        IBattlePrecisionMatcher r0 = this.p;
        if (r0 != null) goto L5;
    L7:
        return 216.0f;
    L5:
        if (r0.getStatus() != IBattlePrecisionMatcher.Status.StatusReady.ordinal()) goto L7;
        return 120.0f;
    }

    public InteractPkPrecisionMatchInviteFragment() {
        this.g = new LinkedHashMap();
        this.j = new ArrayList();
        this.r = (yz0.l) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.l.class);
        this.s = new CompositeDisposable();
        this.w = "";
    }

    public final void onDestroy() {
        super.onDestroy();
        this.s.clear();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.g.clear();
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final ViewGroup Z90() {
        return this.v;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPkPrecisionMatchInviteContract$View
    public final void ba0(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "throwable");
        PkPrecisionMatchDataContext r3 = this.u;
        if (r3 == null) goto L5;
        r3.resetPrecisionMatch();
    L5:
        i41.r.c.a().a();
        this.d.dismiss();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPkPrecisionMatchInviteContract$View
    public final void ca0(int r3) {
        if (r3 != 2) goto L16;
        com.bytedance.android.live.revlink.impl.pk.service.e r4 = com.bytedance.android.live.revlink.impl.global.b.Q();
        if (r4 != null) goto L7;
    L9:
        PkPrecisionMatchDataContext r5 = this.u;
        if (r5 == null) goto L12;
        r5.setPrecisionMatchWaiting(false);
    L12:
        PkPrecisionMatchDataContext r6 = this.u;
        if (r6 == null) goto L15;
        r6.resetPrecisionMatch();
    L15:
        i41.r.c.a().a();
    L20:
        this.d.dismiss();
        return;
    L7:
        if (r4.isMatchingCount() != true) goto L9;
        ToastUtil.a(2131917893, 0);
        goto L9
    L16:
        if (r3 != 1) goto L20;
        PkPrecisionMatchDataContext r7 = this.u;
        if (r7 == null) goto L20;
        r7.replyAgreeSuccess();
        goto L20
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPkPrecisionMatchInviteContract$View
    public final void da0(long r5) {
        PkPrecisionMatchDataContext r0 = this.u;
        if (r0 == null) goto L6;
        r0.setPrecisionMatchWaitingSeconds(r5);
    L6:
        if (((BaseFragment) this).mStatusViewValid == true) goto L8;
        return;
    L8:
        ((TextView) ea0(2131391271)).setText(s1.C(2131917895, new Object[]{Long.valueOf(r5)}));
        if (r5 != 0) goto L12;
        fa0("overtime");
        this.d.dismiss();
        return;
    }

    public final View ea0(int r3) {
        if (this.g != null) goto L5;
        this.g = new LinkedHashMap();
    L5:
        View r0 = this.g.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.g.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void fa0(String r4) {
        HashMap r0 = new HashMap();
        r0.put("connection_type", "random_pk");
        r0.put("invite_mode", "activity_pk");
        w31.b.a(r0);
        d2 r1 = this.o;
        if (r1 == null) goto L15;
        String r2 = r1.getActivityId();
        if (r2 == null) goto L15;
        if (r2.length() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == true) goto L13;
        r2 = null;
    L13:
        if (r2 == null) goto L15;
        r0.put("pk_activity_type", r2);
        r0.put("invitee_list", "flex_activity");
        goto L15
    L9:
        r3 = false;
    L15:
        r0.put("room_status", "live");
        r0.put("source", "");
        r0.put("selection", r4);
        com.bytedance.android.live.revlink.impl.control.dialog.e r5 = LinkRevPanelDataContext.Companion.a(IRivalRankRecommendResponse.LoadType.OnlyCommonPanel.ordinal(), this.w);
        if (r5 == null) goto L20;
        Map<String, String> r6 = r5.f;
        if (r6 == null) goto L20;
        r0.putAll(r6);
    L20:
        mz0.n r7 = new mz0.n();
        Map<String, String> r8 = r7.a;
        Intrinsics.checkNotNullParameter(r8, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r8.putAll(r0);
        mz0.m r9 = new mz0.m();
        r9.b(LogCommon.ROOM);
        r9.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r10 = r7.b;
        ArrayList r12 = (ArrayList) r10;
        r12.addAll(r9.a);
        cy0.e.a.getClass();
        cy0.j r13 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r14 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r14);
        ((mz0.i) ((f80.a) r14)).w3("livesdk_flexible_match_panel_click", r7.a, r7.b);
    }

    public final void ga0(int r5) {
        if (r5 != IBattlePrecisionMatcher.Status.StatusRejected.ordinal()) goto L5;
        this.d.dismiss();
        return;
    L5:
        IBattlePrecisionMatcher.Status r0 = IBattlePrecisionMatcher.Status.StatusReady;
        if (r5 != r0.ordinal()) goto L24;
        HSImageView r6 = ea0(2131381571);
        if (r6 == null) goto L10;
        w.a(r6, "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/pk_precision_match_waiting_wave_fast.webp");
    L10:
        TextView r7 = (TextView) ea0(2131391507);
        if (r7 == null) goto L13;
        r7.setBackgroundResource(2131249717);
    L13:
        TextView r8 = (TextView) ea0(2131391507);
        if (r8 == null) goto L16;
        r8.setTextColor(s1.h(2131108012));
    L16:
        TextView r9 = (TextView) ea0(2131391507);
        if (r9 == null) goto L19;
        r9.setText(s1.B(2131917896));
    L19:
        IBattlePrecisionMatcher r10 = this.p;
        if (r10 != null) goto L22;
        return;
    L22:
        if (r10.getStatus() != r0.ordinal()) goto L39;
        this.d.dismiss();
        return;
    L39:
        return;
    L24:
        HSImageView r12 = ea0(2131381571);
        if (r12 == null) goto L27;
        w.a(r12, "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/pk_precision_match_waiting_wave_slow.webp");
    L27:
        TextView r13 = (TextView) ea0(2131391507);
        if (r13 == null) goto L30;
        r13.setBackgroundResource(2131249718);
    L30:
        TextView r14 = (TextView) ea0(2131391507);
        if (r14 == null) goto L33;
        r14.setTextColor(s1.h(2131108013));
    L33:
        TextView r15 = (TextView) ea0(2131391507);
        if (r15 == null) goto L41;
        r15.setText(s1.B(2131917897));
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r12, (TextView) ea0(2131391271)) == false) goto L20;
        fa0("cancel");
        com.bytedance.android.live.revlink.impl.pk.dialog.presenter.k r3 = this.i;
        if (r3 == null) goto L40;
        long r5 = this.m;
        d2 r13 = this.o;
        if (r13 == null) goto L10;
        int r7 = r13.getSource();
    L11:
        d2 r14 = this.o;
        if (r14 == null) goto L17;
        String r15 = r14.getActivityId();
        if (r15 == null) goto L17;
        String r8 = r15;
    L18:
        r3.e(2, r5, r7, r8, 0);
        return;
    L17:
        r8 = "";
        goto L18
    L10:
        r7 = 0;
        goto L11
    L40:
        return;
    L20:
        if (Intrinsics.areEqual(r12, (TextView) ea0(2131390090)) == false) goto L42;
        fa0("accept");
        com.bytedance.android.live.revlink.impl.pk.dialog.presenter.k r4 = this.i;
        if (r4 == null) goto L35;
        long r6 = this.m;
        d2 r16 = this.o;
        if (r16 == null) goto L26;
        int r9 = r16.getSource();
    L27:
        d2 r17 = this.o;
        if (r17 == null) goto L33;
        String r18 = r17.getActivityId();
        if (r18 == null) goto L33;
        String r10 = r18;
    L34:
        r4.e(1, r6, r9, r10, 0);
    L33:
        r10 = "";
        goto L34
    L26:
        r9 = 0;
    L35:
        com.bytedance.android.live.revlink.impl.pk.service.i r19 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r19 == null) goto L43;
        r19.S2(ToolBarPic.PK_CLOSE_BROADCAST_OLD);
        return;
    L43:
        return;
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        yz0.l r12 = this.r;
        if (r12 == null) goto L9;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r13 = yz0.h.a.a(r12, com.bytedance.android.live.revenue.common.message.b.h, false, 6);
        if (r13 == null) goto L9;
        final AnonymousClass1 r0 = new AnonymousClass1(this);
        Disposable r14 = r13.subscribe(new b(r0));
        if (r14 == null) goto L9;
        RxUtilKt.c(r14, this.s);
    L9:
        ImageView r1 = (ImageView) ea0(2131385880);
        IRoom r2 = this.n;
        View r3 = null;
        if (r2 == null) goto L14;
        IBaseUser r4 = r2.getOwner();
        if (r4 == null) goto L14;
        py.k r5 = r4.getAvatarThumbKt();
    L15:
        ImageUtil.loadRoundImage(r1, r5);
        IBattlePrecisionMatcher r6 = this.q;
        boolean r7 = true;
        if (r6 == null) goto L41;
        ImageView r8 = (ImageView) ea0(2131381573);
        IRoom r15 = r6.getRoom();
        if (r15 == null) goto L22;
        IBaseUser r16 = r15.getOwner();
        if (r16 == null) goto L22;
        py.k r17 = r16.getAvatarThumbKt();
    L23:
        ImageUtil.loadRoundImage(r8, r17);
        TextView r18 = (TextView) ea0(2131391035);
        IRoom r19 = r6.getRoom();
        if (r19 == null) goto L28;
        IBaseUser r20 = r19.getOwner();
        if (r20 == null) goto L28;
        String r22 = r20.getNickName();
    L29:
        r18.setText(r22);
        String r23 = r6.getDescText();
        if (r23 != null) goto L32;
    L40:
        ga0(r6.getStatus());
        goto L41
    L32:
        if (r23.length() <= 0) goto L34;
        boolean r24 = true;
    L35:
        if (r24 == true) goto L38;
        r23 = null;
    L38:
        if (r23 == null) goto L40;
        ((TextView) ea0(2131381572)).setText(r23);
        goto L40
    L34:
        r24 = false;
    L28:
        r22 = null;
    L22:
        r17 = null;
    L41:
        IBattlePrecisionMatcher r25 = this.p;
        if (r25 == null) goto L66;
        ImageView r26 = (ImageView) ea0(2131385880);
        IRoom r27 = r25.getRoom();
        if (r27 == null) goto L48;
        IBaseUser r28 = r27.getOwner();
        if (r28 == null) goto L48;
        py.k r29 = r28.getAvatarThumbKt();
    L49:
        a1.v(r26, r29, 2131250965);
        TextView r30 = (TextView) ea0(2131385883);
        IRoom r32 = r25.getRoom();
        if (r32 == null) goto L54;
        IBaseUser r33 = r32.getOwner();
        if (r33 == null) goto L54;
        String r34 = r33.getNickName();
    L55:
        r30.setText(r34);
        String r35 = r25.getDescText();
        if (r35 == null) goto L66;
        if (r35.length() > 0) goto L61;
        r7 = false;
    L61:
        if (r7 == true) goto L64;
        r35 = null;
    L64:
        if (r35 == null) goto L66;
        ((TextView) ea0(2131385871)).setText(r35);
    L54:
        r34 = null;
    L48:
        r29 = null;
    L66:
        com.bytedance.android.live.revlink.impl.pk.dialog.presenter.k r36 = this.i;
        if (r36 == null) goto L69;
        long r37 = this.l;
        r36.d = ((ObservableSubscribeProxy) du2.a.b(0, 1, TimeUnit.SECONDS).take(1 + r37).map(new com.bytedance.android.live.revlink.impl.pk.dialog.presenter.l(r37)).observeOn(AndroidSchedulers.mainThread()).as(r36.c.S90())).subscribe(new com.bytedance.android.live.revlink.impl.pk.dialog.presenter.m(r36), new com.bytedance.android.live.revlink.impl.pk.dialog.presenter.n(r36));
    L69:
        IBattlePrecisionMatcher r38 = this.p;
        if (r38 != null) goto L72;
    L74:
        ((LinearLayout) ea0(2131378631)).setVisibility(0);
    L75:
        ((TextView) ea0(2131391271)).setOnClickListener(this);
        ((TextView) ea0(2131390090)).setOnClickListener(this);
        ViewGroup r39 = this.v;
        if (r39 == null) goto L78;
        View r40 = r39.findViewById(2131372262);
    L79:
        TextView r42 = (TextView) r40;
        if (r42 == null) goto L83;
        r42.setOnClickListener(new w0(new AnonymousClass4(this), 500));
    L83:
        if (TextUtils.isEmpty(this.k) == true) goto L90;
        ViewGroup r43 = this.v;
        if (r43 == null) goto L87;
        r3 = r43.findViewById(2131379701);
    L87:
        TextView r44 = (TextView) r3;
        if (r44 == null) goto L90;
        r44.setText(this.k);
    L90:
        HashMap r45 = new HashMap();
        r45.put("invite_mode", "activity_pk");
        r45.put("pk_activity_type", this.w);
        r45.put("flex_activity_id", this.w);
        r45.put("activity_id", this.w);
        r45.put("room_status", "live");
        r45.put("invitee_list", "flex_activity");
        r45.put("connection_type", "random_pk");
        String r46 = "";
        r45.put("source", "");
        IBattlePrecisionMatcher r110 = this.q;
        if (r110 == null) goto L95;
        String r111 = r110.getUserId();
        if (r111 == null) goto L95;
        r46 = r111;
    L95:
        r45.put("invitee_id", r46);
        com.bytedance.android.live.revlink.impl.control.dialog.e r112 = LinkRevPanelDataContext.Companion.a(IRivalRankRecommendResponse.LoadType.OnlyCommonPanel.ordinal(), this.w);
        if (r112 == null) goto L100;
        Map<String, String> r113 = r112.f;
        if (r113 == null) goto L100;
        r45.putAll(r113);
    L100:
        mz0.n r114 = new mz0.n();
        Map<String, String> r47 = r114.a;
        Intrinsics.checkNotNullParameter(r47, "map");
        Intrinsics.checkNotNullParameter(r45, "map");
        r47.putAll(r45);
        mz0.m r48 = new mz0.m();
        r48.b(LogCommon.PAGE_SOURCE_LOG);
        r48.b(LogCommon.ROOM);
        ((ArrayList) r114.b).addAll(r48.a);
        cy0.e.a.getClass();
        cy0.j r49 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r50 = com.bytedance.android.scope.m.b(r49).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r50);
        ((mz0.i) ((f80.a) r50)).w3("livesdk_flexible_match_panel_show", r114.a, r114.b);
        return;
    L78:
        r40 = null;
        goto L79
    L72:
        if (r38.getStatus() != IBattlePrecisionMatcher.Status.StatusReady.ordinal()) goto L74;
        ((LinearLayout) ea0(2131378631)).setVisibility(8);
    L14:
        r5 = null;
        goto L15
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        View r6 = r3.inflate(2131567804, r4, false);
        if ((r6 instanceof ViewGroup) == true) goto L5;
        r6 = null;
    L5:
        this.v = (ViewGroup) r6;
        View r7 = r3.inflate(2131566058, r4, false);
        this.d.F4(false);
        return r7;
    }
}
