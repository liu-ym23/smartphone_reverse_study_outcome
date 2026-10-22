package com.bytedance.android.live.livepkaudience.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListUserInfo;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomOperate;
import com.bytedance.android.live.livepkaudience.emoji.LinkPKGameInteractPanel;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.model.interact.LinkInitResult;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/dialog/PkAudienceListApplyDialogFragment;", "Lcom/bytedance/android/live/livepkaudience/dialog/BasePkAudienceApplyListFragment;", "<init>", "()V", "a", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkAudienceListApplyDialogFragment extends BasePkAudienceApplyListFragment {
    public static final /* synthetic */ int S = 0;
    public Map<Integer, View> J;
    public com.bytedance.android.live.livepkaudience.base.f<Integer> K;
    public l L;
    public int M;
    public final CompositeDisposable N;
    public boolean O;
    public final b P;
    public final Lazy Q;
    public boolean R;

    public static final class a {
    }

    public static final class b implements xk0.c {
        public final /* synthetic */ PkAudienceListApplyDialogFragment a;

        @Override // xk0.c
        public final void b(LinkPlayerInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "linkPlayerInfo");
        }

        @Override // xk0.c
        public final void isGame() {
        }

        public b(PkAudienceListApplyDialogFragment r1) {
            this.a = r1;
        }

        @Override // xk0.c
        public final void a(LinkPlayerInfo r4) {
            Intrinsics.checkNotNullParameter(r4, "linkPlayerInfo");
            PkAudienceListApplyDialogFragment r0 = this.a;
            DataCenter r1 = r0.u;
            if (r1 != null) goto L5;
            return;
        L5:
            Context r2 = r0.getContext();
            if (r2 != null) goto L8;
            return;
        L8:
            int r3 = LinkPKGameInteractPanel.z;
            LinkPKGameInteractPanel r5 = LinkPKGameInteractPanel.a.a(r2, r1, r4);
            if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L18;
            DialogLancet.handleBlockedDialogShow(r5);
        L13:
            com.bytedance.android.live.livepkaudience.service.e.y0.getClass();
            com.bytedance.android.live.livepkaudience.service.e r6 = com.bytedance.android.live.livepkaudience.service.e.a.a();
            if (r6 == null) goto L20;
            r6.hideInteractDialog();
            return;
        L20:
            return;
        L18:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
        L12:
            DialogLancet.beforeDialogShow(r5);
            r5.show();
            DialogLancet.afterDialogShow(r5);
            goto L13
        }

        @Override // xk0.c
        public final void c(LinkPlayerInfo r17) {
            Intrinsics.checkNotNullParameter(r17, "linkPlayerInfo");
            PkAudienceListApplyDialogFragment r2 = this.a;
            int r3 = PkAudienceListApplyDialogFragment.S;
            r2.getClass();
            r2.L = new l(r2, r17);
            if (r2.E == false) goto L21;
            com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
            com.bytedance.android.live.livepkaudience.service.b r4 = com.bytedance.android.live.livepkaudience.service.b.a.a();
            if (r4 == null) goto L13;
            com.bytedance.android.live.livepkaudience.base.p r5 = r4.X4();
            if (r5 == null) goto L13;
            l r6 = r2.L;
            if (r6 == null) goto L12;
            r5.a(r6);
            goto L13
        L12:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.livepkaudience.base.SimplePkAnchorLinkListener");
        L13:
            vh7.c r7 = r17.getUser();
            if (r7 == null) goto L39;
            User r8 = jm2.a.e(r7);
            if (r8 == null) goto L39;
            com.bytedance.android.live.livepkaudience.service.b r9 = com.bytedance.android.live.livepkaudience.service.b.a.a();
            if (r9 == null) goto L39;
            r9.Fl(r8);
        L39:
            LinkedHashMap r10 = new LinkedHashMap();
            r10.put("position", String.valueOf(r2.M));
            r10.put("paid_amount", String.valueOf(r17.paidAmount));
            int r11 = el0.j.b;
            IBaseUser r12 = r17.getUser();
            String r13 = "0";
            if (r12 == null) goto L43;
            String r14 = r12.getIdString();
            if (r14 == null) goto L43;
        L45:
            if (r2.E == false) goto L47;
            String r15 = "anchor";
        L48:
            List<KtvMusic> r16 = r17.songList;
            WaitingListUserInfo r18 = r17.waitingListUserInfo;
            if (r18 == null) goto L51;
            String r19 = r18.applyReason;
        L52:
            boolean r20 = !TextUtils.isEmpty(r19);
            String r21 = r17.fuzzyFanTicket;
            String r110 = "";
            if (r21 != null) goto L55;
            r21 = "";
        L55:
            String r111 = r17.getTopR();
            String r112 = r17.getRelationship();
            IBaseUser r113 = r17.getUser();
            if (r113 == null) goto L63;
            py.d r114 = r113.getUserHonor();
            if (r114 == null) goto L63;
            String r115 = String.valueOf(r114.getLevel());
            if (r115 == null) goto L63;
            r110 = r115;
        L63:
            IBaseUser r116 = r17.getUser();
            if (r116 == null) goto L66;
            boolean r117 = r116.isSubscriber();
        L67:
            Long r0 = Long.valueOf(com.bytedance.android.live.liveinteract.plantform.model.n.b(r17));
            Intrinsics.checkNotNullParameter(r14, "applicantId");
            Intrinsics.checkNotNullParameter(r15, "passType");
            Intrinsics.checkNotNullParameter("list", "page");
            Intrinsics.checkNotNullParameter(r21, "fanTicket");
            Intrinsics.checkNotNullParameter(r112, "relationship");
            Intrinsics.checkNotNullParameter(r111, "topPos");
            Intrinsics.checkNotNullParameter(r110, "userLevel");
            HashMap r22 = new HashMap();
            r22.put("applicant_id", r14);
            r22.put("pass_type", r15);
            r22.put("request_page", "list");
            if (r20 == false) goto L70;
            Object r23 = "1";
        L71:
            r22.put("is_application", r23);
            int r24 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
            el0.j.j(r22, Integer.valueOf(r24));
            Intrinsics.checkNotNullParameter(r22, "logMap");
            r22.put("guest_connection_type", "live_chat");
            if (r24 == 0) goto L82;
            List<KtvMusic> r25 = r16;
            if (r25 != null) goto L76;
        L79:
            boolean r26 = true;
        L80:
            if (r26 == true) goto L82;
            el0.j.q(r22, r16);
            goto L82
        L76:
            if (r25.isEmpty() == true) goto L79;
            r26 = false;
        L82:
            Integer r27 = (Integer) com.bytedance.android.livesdk.sharedpref.c.x1.getValue();
            if (r27 != null) goto L86;
        L88:
            String r28 = "time_first";
        L89:
            r22.put("ordering_mode", r28);
            r22.put("money", r21);
            r22.put("relationship", r112);
            r22.put("top_r", r111);
            r22.put("contribution_level", r110);
            if (r0 == null) goto L92;
            r22.put("tag_type", String.valueOf(r0.longValue()));
        L92:
            el0.j.o(r22);
            el0.j.l(r22, r24);
            if (r117 == false) goto L95;
            r13 = "1";
        L95:
            r22.put("if_invitee_subscribe", r13);
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_audience_connection_pass", r22, new Object[]{am2.x.class, Room.class});
            return;
        L86:
            if (r27.intValue() != 41) goto L88;
            r28 = "money_first";
            goto L89
        L70:
            r23 = "0";
            goto L71
        L66:
            r117 = false;
            goto L67
        L51:
            r19 = null;
            goto L52
        L47:
            r15 = "administrator";
        L43:
            r14 = "0";
            goto L45
        L21:
            if (jc1.k.n(IUserService.class).user().c() == false) goto L35;
            com.bytedance.android.live.livepkaudience.service.a.u0.getClass();
            com.bytedance.android.live.livepkaudience.service.a r29 = com.bytedance.android.live.livepkaudience.service.a.C0119a.a();
            if (r29 == null) goto L31;
            com.bytedance.android.live.livepkaudience.base.o r30 = r29.A0();
            if (r30 == null) goto L31;
            l r31 = r2.L;
            if (r31 == null) goto L30;
            r30.a(r31);
            goto L31
        L30:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.livepkaudience.base.SimplePkAnchorLinkListener");
        L31:
            com.bytedance.android.live.livepkaudience.service.a r32 = com.bytedance.android.live.livepkaudience.service.a.C0119a.a();
            if (r32 == null) goto L39;
            r32.wi(r17);
            goto L39
        L35:
            if (jc1.k.n(IUserService.class).user().isAdmin() == false) goto L37;
            f2.b(2131914522, 0);
        L38:
            com.bytedance.android.live.liveinteract.plantform.utils.x.C0(TalkRoomOperate.PERMIT);
            goto L39
        L37:
            f2.b(2131917298, 0);
            goto L38
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ PkAudienceListApplyDialogFragment a;

        public c(PkAudienceListApplyDialogFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            jd0.m r5 = (jd0.m) r4;
            PkAudienceListApplyDialogFragment r6 = this.a;
            LinearLayout r0 = r6.n;
            boolean r1 = true;
            if (r0 != null) goto L5;
        L7:
            boolean r2 = false;
        L8:
            MultiTypeAdapter r3 = this.a.t;
            if (r3 == null) goto L13;
            List r7 = r3.a;
            if (r7 == null) goto L13;
            r1 = r7.isEmpty();
        L13:
            r6.fa0(r2, r1);
            MultiTypeAdapter r8 = this.a.t;
            if (r8 == null) goto L17;
            r8.notifyDataSetChanged();
            return;
        L17:
            return;
        L5:
            if (r0.getVisibility() != 0) goto L7;
            r2 = true;
            goto L8
        }
    }

    static {
    }

    public final void ha0() {
        if (this.R == true) goto L5;
        return;
    L5:
        if (this.O == true) goto L13;
        ViewGroup r0 = this.v;
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.getVisibility() != 0) goto L15;
        int r1 = el0.j.b;
        LinkedHashMap r2 = new LinkedHashMap();
        el0.j.m(r2);
        el0.j.k(r2);
        el0.j.p(r2);
        el0.j.n(r2, Integer.valueOf(dl0.n.a()));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_audience_auto_link_show", r2, new Object[]{Room.class});
        this.O = true;
        return;
    L15:
        return;
    }

    public PkAudienceListApplyDialogFragment() {
        this.J = new LinkedHashMap();
        this.M = -1;
        this.N = new CompositeDisposable();
        this.P = new b(this);
        this.Q = LazyKt.lazy(new PkAudienceListApplyDialogFragment$userCenter$2(this));
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceApplyListFragment
    public final void onDestroy() {
        super.onDestroy();
        this.N.dispose();
        com.bytedance.android.live.livepkaudience.dialog.a r0 = (com.bytedance.android.live.livepkaudience.dialog.a) this.f;
        if (r0 == null) goto L5;
        ((com.bytedance.android.livesdk.common.c) r0).a = null;
    L5:
        l r1 = this.L;
        if (r1 != null) goto L8;
        return;
    L8:
        if (this.E == false) goto L14;
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r2 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r2 == null) goto L21;
        com.bytedance.android.live.livepkaudience.base.p r3 = r2.X4();
        if (r3 == null) goto L22;
        r3.f(r1);
        return;
    L22:
        return;
    L21:
        return;
    L14:
        com.bytedance.android.live.livepkaudience.service.a.u0.getClass();
        com.bytedance.android.live.livepkaudience.service.a r4 = com.bytedance.android.live.livepkaudience.service.a.C0119a.a();
        if (r4 == null) goto L24;
        com.bytedance.android.live.livepkaudience.base.o r5 = r4.A0();
        if (r5 == null) goto L25;
        r5.f(r1);
        return;
    L25:
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.J.clear();
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceApplyListFragment
    public final void ea0(int r2) {
        com.bytedance.android.live.livepkaudience.base.f<Integer> r0 = this.K;
        if (r0 == null) goto L9;
        if (r2 <= 0) goto L6;
        int r3 = 0;
    L7:
        r0.run(Integer.valueOf(r3));
        return;
    L6:
        r3 = 1;
        goto L7
    }

    public final View ga0(int r3) {
        if (this.J != null) goto L5;
        this.J = new LinkedHashMap();
    L5:
        View r4 = (View) ((LinkedHashMap) this.J).get(2131363188);
        if (r4 != null) goto L14;
        View r5 = getView();
        if (r5 == null) goto L12;
        View r6 = r5.findViewById(2131363188);
        if (r6 == null) goto L12;
        this.J.put(2131363188, r6);
        return r6;
    L12:
        return null;
    L14:
        return r4;
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceApplyListFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        com.bytedance.android.live.livepkaudience.presenter.b r3 = new com.bytedance.android.live.livepkaudience.presenter.b(this.D, this);
        this.f = r3;
        ((com.bytedance.android.livesdk.common.c) r3).a = this;
        Disposable r4 = xs2.b.a().b(jd0.m.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this));
        this.N.add(r4);
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceApplyListFragment
    public final void setUserVisibleHint(boolean r1) {
        super.setUserVisibleHint(r1);
        this.R = r1;
        ha0();
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceApplyListFragment
    public final void fa0(boolean r2, boolean r3) {
        if (r2 == true) goto L13;
        if (r3 == true) goto L13;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.t1.getValue()).booleanValue() == true) goto L13;
        LinearLayout r4 = (LinearLayout) ga0(2131363188);
        if (r4 == null) goto L10;
        UtilityKotlinExtentionsKt.w(r4);
    L10:
        ViewGroup r5 = this.v;
        if (r5 == null) goto L31;
        r5.setVisibility(8);
        return;
    L31:
        return;
    L13:
        LinearLayout r6 = (LinearLayout) ga0(2131363188);
        if (r6 == null) goto L16;
        UtilityKotlinExtentionsKt.t(r6);
    L16:
        int r7 = us1.g.a;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.t1.getValue()).booleanValue() == false) goto L33;
        com.bytedance.android.livesdk.sharedpref.e r8 = com.bytedance.android.livesdk.sharedpref.b.P1;
        if (((Boolean) r8.getValue()).booleanValue() == true) goto L34;
        Room r9 = this.D;
        if (r9 == null) goto L35;
        LinkInitResult r10 = r9.linkInitResult;
        if (r10 != null) goto L25;
        return;
    L25:
        if (r10.isFirstInit() != true) goto L37;
        Boolean r11 = Boolean.TRUE;
        r8.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r8, r11);
        ViewGroup r12 = this.v;
        if (r12 == null) goto L29;
        r12.setVisibility(0);
    L29:
        ha0();
        return;
    L37:
        return;
    L35:
        return;
    L34:
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceApplyListFragment
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        MultiTypeAdapter r6 = this.t;
        if (r6 == null) goto L5;
        r6.z2(LinkPlayerInfo.class, new com.bytedance.android.live.livepkaudience.list.i(this.P, 0));
    L5:
        TextView r7 = this.o;
        if (r7 == null) goto L8;
        r7.setOnClickListener(x0.a(new AnonymousClass1(this)));
    L8:
        fa0(false, true);
        TextView r8 = this.w;
        if (r8 == null) goto L11;
        r8.setOnClickListener(x0.a(new AnonymousClass2(this)));
    L11:
        ImageView r9 = this.x;
        if (r9 == null) goto L15;
        r9.setOnClickListener(x0.a(new AnonymousClass3(this)));
        return;
    }
}
