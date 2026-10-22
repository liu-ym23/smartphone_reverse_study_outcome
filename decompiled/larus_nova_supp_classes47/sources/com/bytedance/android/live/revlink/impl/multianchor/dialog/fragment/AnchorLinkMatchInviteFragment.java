package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.FormatUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.contract.AnchorLinkInviteContract$View;
import com.bytedance.android.live.revlink.impl.multianchor.ui.AnchorLinkInfoInviteView;
import com.bytedance.android.live.revlink.impl.pk.dialog.PkBanSettingFragment;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.s1;
import com.bytedance.android.livesdk.link.model.v3;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/fragment/AnchorLinkMatchInviteFragment;", "Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/contract/AnchorLinkInviteContract$View;", "Lx31/e;", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorLinkMatchInviteFragment extends AnchorLinkInviteContract$View implements x31.e {
    public static final /* synthetic */ int p = 0;
    public Map<Integer, View> g;
    public s1 h;
    public Animation i;
    public Animation j;
    public Animation k;
    public final int l;
    public final com.bytedance.android.live.revenuelink.connect.n m;
    public boolean n;
    public long o;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ AnchorLinkMatchInviteFragment a;

        public b(AnchorLinkMatchInviteFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            IRoom r5 = com.bytedance.android.live.revlink.impl.utils.u.a();
            if (r5 == null) goto L5;
            int r0 = PkBanSettingFragment.n;
            AnchorLinkMatchInviteFragment r1 = this.a;
            int r2 = AnchorLinkMatchInviteFragment.p;
            PkBanSettingFragment r6 = PkBanSettingFragment.a.a(r1.d, r5, r1, null);
            AnchorLinkMatchInviteFragment r3 = this.a;
            r3.getClass();
            r6.ca0(r3.h);
            this.a.d.zD(r6);
        L5:
            l51.a.H();
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ AnchorLinkMatchInviteFragment a;

        public c(AnchorLinkMatchInviteFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            int r2 = AnchorLinkMatchInviteFragment.p;
            this.a.ea0(2);
            this.a.da0("reject");
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ AnchorLinkMatchInviteFragment a;

        public d(AnchorLinkMatchInviteFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r40) {
            AnchorLinkMatchInviteFragment r1 = this.a;
            int r2 = AnchorLinkMatchInviteFragment.p;
            r1.da0("accept");
            s1 r3 = this.a.h;
            if (r3 == null) goto L28;
            long r5 = com.bytedance.android.live.revlink.impl.utils.u.d();
            long r7 = r3.getFromRoomId();
            int r9 = r3.getInviteType();
            int r10 = r3.getMatchType();
            Intrinsics.checkNotNullParameter(r3, "$this$fromUid");
            String r12 = r3.get_fromUid();
            IBattleLinkerInviteMessageExtra r4 = r3.getBattleExtra();
            if (r4 == null) goto L11;
            IRoom r6 = r4.getInviteRoom();
            if (r6 == null) goto L11;
            IBaseUser r8 = r6.getOwner();
            if (r8 == null) goto L11;
            Intrinsics.checkNotNullParameter(r8, "$this$secUidExt");
            String r13 = r8.getCastSecUid();
        L12:
            s1 r14 = this.a.h;
            if (r14 == null) goto L17;
            IBattleLinkerInviteMessageExtra r15 = r14.getBattleExtra();
            if (r15 == null) goto L17;
            IRoom r16 = r15.getInviteRoom();
        L18:
            int r17 = BizType.AnchorLink.ordinal();
            s1 r18 = this.a.h;
            if (r18 == null) goto L21;
            String r28 = r18.getBattleAttachedInfo();
        L22:
            String r19 = r3.getClientInfo();
            if (r19 != null) goto L25;
            r19 = "";
        L25:
            d11.d r110 = new d11.d(7, r5, r7, r9, r10, r12, r13, r16, r17, null, 0, null, 0, 0, null, 0, null, null, null, r28, 0, 0, 0, null, r19, null, null, null, 519568896);
            com.bytedance.android.live.revenuelink.connect.n r20 = this.a.m;
            if (r20 == null) goto L28;
            r20.d(r110, null);
            goto L28
        L21:
            r28 = null;
        L17:
            r16 = null;
        L11:
            r13 = null;
        L28:
            AnchorLinkMatchInviteFragment r22 = this.a;
            p0 r23 = e21.c.b(r22.h);
            LinkedHashMap r24 = new LinkedHashMap();
            r24.put("if_strategy_invite", DataType.TRUE);
            r24.put("match_time", String.valueOf((int) ((System.currentTimeMillis() - r22.o) / ((long) WebcastRedirectException.UNKNOWN))));
            r24.put("success_type", "1v1");
            mz0.n r25 = new mz0.n();
            mz0.o r26 = new mz0.o(r25.a);
            r26.a("from_room_status", "live");
            r26.a("anchor_type", "invitee");
            r26.a("is_rematch", DataType.FALSE);
            r26.a("match_type", "single_link");
            r26.a("connection_sub_type", "");
            r26.a("invite_mode", "routine_pk");
            r26.a("anchor_connect_status", "2");
            r26.a("room_status", "live");
            com.bytedance.android.live.revlink.impl.control.d r27 = com.bytedance.android.live.revlink.impl.global.b.f();
            if (r27 == null) goto L33;
            String r29 = r27.getRequestId();
            if (r29 == null) goto L33;
            r26.a("request_id", r29);
        L33:
            r26.b(r24);
            e21.c.e(r26, r23);
            mz0.m r30 = new mz0.m();
            r30.b(LogCommon.ROOM);
            ((ArrayList) r25.b).addAll(r30.a);
            cy0.e.a.getClass();
            cy0.j r32 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r33 = com.bytedance.android.scope.m.b(r32).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r33);
            ((mz0.i) ((f80.a) r33)).w3("livesdk_random_match_success", r25.a, r25.b);
            com.bytedance.android.live.revlink.impl.control.dialog.r r34 = this.a.d;
            if (r34 == null) goto L37;
            r34.dismiss();
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ AnchorLinkMatchInviteFragment a;

        public e(AnchorLinkMatchInviteFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ExtraResponse r3 = (ExtraResponse) r2;
            AnchorLinkMatchInviteFragment r4 = this.a;
            int r0 = AnchorLinkMatchInviteFragment.p;
            com.bytedance.android.live.revlink.impl.control.dialog.r r5 = r4.d;
            if (r5 == null) goto L6;
            r5.dismiss();
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ AnchorLinkMatchInviteFragment a;

        public f(AnchorLinkMatchInviteFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Context r0 = this.a.getContext();
            ExceptionUtils.handleException(r0, (Throwable) r2);
            AnchorLinkMatchInviteFragment r3 = this.a;
            int r1 = AnchorLinkMatchInviteFragment.p;
            com.bytedance.android.live.revlink.impl.control.dialog.r r4 = r3.d;
            if (r4 == null) goto L6;
            r4.dismiss();
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final String X90() {
        return "";
    }

    @Override // x31.e
    public final void ec() {
        ea0(5);
        ((i21.a) this.f).e();
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final float U90() {
        return this.l;
    }

    public AnchorLinkMatchInviteFragment() {
        this.g = new LinkedHashMap();
        this.l = 251;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r0 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r0 == null) goto L5;
        com.bytedance.android.live.revenuelink.connect.n r1 = r0.getLinkOutManagerFn();
    L6:
        this.m = r1;
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final View W90() {
        View r0 = LayoutInflater.from(getContext()).inflate(2131567620, (ViewGroup) getView(), false);
        if (l51.a.i() == false) goto L5;
        r0.findViewById(2131363884).setVisibility(0);
    L5:
        r0.setOnClickListener(new b(this));
        return r0;
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final ViewGroup Z90() {
        View r0 = LayoutInflater.from(getContext()).inflate(2131567000, null);
        if (r0 == null) goto L15;
        ViewGroup r1 = (ViewGroup) r0;
        ((TextView) r1.findViewById(2131362594)).setVisibility(8);
        TextView r2 = (TextView) r1.findViewById(2131388882);
        s1 r3 = this.h;
        if (r3 == null) goto L11;
        IBattleLinkerInviteMessageExtra r4 = r3.getBattleExtra();
        if (r4 == null) goto L11;
        String r5 = r4.getTips();
        if (r5 == null) goto L11;
    L12:
        r2.setText(r5);
        return r1;
    L11:
        r5 = "";
        goto L12
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void onDestroy() {
        super.onDestroy();
        ((i21.a) this.f).e();
        Animation r0 = this.i;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        Animation r1 = this.j;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        Animation r2 = this.k;
        if (r2 == null) goto L12;
        r2.cancel();
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.g.clear();
    }

    @Override // x31.e
    public final boolean UK() {
        return this.n;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.contract.AnchorLinkInviteContract$View
    public final void ba0(int r7) {
        if (((BaseFragment) this).mStatusViewValid == true) goto L5;
        return;
    L5:
        ((TextView) ca0(2131364604)).setText(FormatUtils.format(getString(2131914778), new Object[]{Integer.valueOf(r7)}));
        if (r7 != 0) goto L9;
        this.n = true;
        da0("overtime");
        ea0(5);
        return;
    }

    public final View ca0(int r3) {
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

    public final void da0(String r9) {
        s1 r0 = this.h;
        if (r0 == null) goto L14;
        String r1 = r0.getClientInfo();
        if (r1 == null) goto L14;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        Object r3 = Result.constructor-impl((v3) com.bytedance.android.live.revlink.impl.utils.e.a(r1, v3.class));     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r3) == false) goto L13;
        r3 = null;
    L13:
        v3 r4 = (v3) r3;
    L15:
        s1 r5 = this.h;
        if (r5 == null) goto L18;
        p0 r6 = e21.c.b(r5);
    L19:
        HashMap r7 = new HashMap();
        s1 r8 = this.h;
        if (r8 == null) goto L24;
        IBattleLinkerInviteMessageExtra r10 = r8.getBattleExtra();
        if (r10 == null) goto L24;
        IRoom r12 = r10.getInviteRoom();
    L25:
        String r13 = "";
        if (r12 == null) goto L31;
        IBaseUser r14 = r12.getOwner();
        if (r14 == null) goto L31;
        String r15 = iz.a.a(r14);
        if (r15 == null) goto L31;
    L32:
        r7.put("inviter_id", r15);
        String r16 = iz.a.a(com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.user.a.class).b());
        if (r16 != null) goto L35;
        r16 = "";
    L35:
        r7.put("invitee_id", r16);
        r7.put("selection", r9);
        int r17 = UserListInviteType.a;
        s1 r18 = this.h;
        if (r18 == null) goto L40;
        IBattleLinkerInviteMessageExtra r19 = r18.getBattleExtra();
        if (r19 == null) goto L40;
        int r20 = (int) r19.getInviteType();
    L41:
        r7.put("invitee_list", UserListInviteType.a(r20, null));
        r7.put("npk_link_type", "single");
        r7.put("connection_type", "random_link");
        r7.put("connection_sub_type", "random_nlink");
        r7.put("audience_connect_cnt", DataType.FALSE);
        r7.put("list_num", DataType.FALSE);
        d31.d r22 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r22 == null) goto L45;
        String r23 = r22.a();
        if (r23 == null) goto L45;
    L46:
        r7.put("anchor_connect_status", r23);
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r24 = com.bytedance.android.live.revlink.impl.global.b.v();
        if (r24 == null) goto L49;
        String r25 = r24.p();
    L50:
        r7.put("invitee_connection_status", r25);
        r7.put("anchor_connection_type", "invite");
        r7.put("is_oncemore", DataType.FALSE);
        r7.put("invite_mode", "connection");
        r7.put("invite_type", "anchor");
        d31.d r26 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r26 == null) goto L53;
        String r27 = r26.s();
    L54:
        r7.put("room_status", r27);
        r7.put("inviter_connect_cnt", DataType.FALSE);
        r7.put("inviter_room_status", "live");
        d31.d r28 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r28 == null) goto L57;
        String r29 = r28.s();
    L58:
        r7.put("from_room_status", r29);
        d31.d r30 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r30 == null) goto L61;
        String r32 = r30.s();
    L62:
        r7.put("room_status", r32);
        if (r12 == null) goto L68;
        String r33 = String.valueOf(r12.getRoomId());
        if (r33 == null) goto L68;
        r13 = r33;
    L68:
        r7.put("inviter_room_id", r13);
        s1 r34 = this.h;
        if (r34 == null) goto L75;
        IBattleLinkerInviteMessageExtra r35 = r34.getBattleExtra();
        if (r35 == null) goto L75;
        if (((int) r35.getInviteType()) != 13) goto L75;
        r7.put("if_strategy_invite", DataType.TRUE);
    L76:
        mz0.n r36 = new mz0.n();
        mz0.o r37 = new mz0.o(r36.a);
        r37.b(r7);
        e21.e.d(r37, r4);
        e21.c.e(r37, r6);
        mz0.m r38 = new mz0.m();
        LinkCrossRoomDataHolder.a r39 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.a(r38);
        r38.b(LogCommon.ROOM);
        ((ArrayList) r36.b).addAll(r38.a);
        cy0.e.a.getClass();
        cy0.j r40 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r42 = com.bytedance.android.scope.m.b(r40).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r42);
        ((mz0.i) ((f80.a) r42)).w3("livesdk_connection_invited", r36.a, r36.b);
        return;
    L75:
        r7.put("if_strategy_invite", DataType.FALSE);
        goto L76
    L61:
        r32 = "";
        goto L62
    L57:
        r29 = "";
        goto L58
    L53:
        r27 = "";
        goto L54
    L49:
        r25 = "";
    L45:
        r23 = "";
    L40:
        r20 = 0;
    L31:
        r15 = "";
    L24:
        r12 = null;
        goto L25
    L18:
        r6 = null;
    L8:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
    L14:
        r4 = null;
        goto L15
    }

    public final void ea0(long r9) {
        r31.a r1 = r31.b.a(r31.a.a);
        long r4 = com.bytedance.android.live.revlink.impl.utils.u.d();
        s1 r0 = this.h;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNullParameter(r0, "$this$fromUid");
        String r2 = r0.get_fromUid();
        if (r2 == null) goto L8;
        String r6 = r2;
    L9:
        s1 r3 = this.h;
        if (r3 == null) goto L15;
        String r5 = r3.getClientInfo();
        if (r5 == null) goto L15;
        String r7 = r5;
    L16:
        Observable<ExtraResponse<Object, Extra>> r10 = r1.o(r9, r4, r6, r7);
        if (r10 == null) goto L24;
        Observable r12 = r10.compose(RxUtil.rxSchedulerHelper());
        if (r12 == null) goto L25;
        ObservableSubscribeProxy r13 = (ObservableSubscribeProxy) r12.as(S90());
        if (r13 == null) goto L26;
        r13.subscribe(new e(this), new f(this));
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L15:
        r7 = "";
    L8:
        r6 = "";
        goto L9
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        this.o = System.currentTimeMillis();
        this.i = AnimationUtils.loadAnimation(getContext(), 2130772672);
        this.j = AnimationUtils.loadAnimation(getContext(), 2130772673);
        this.k = AnimationUtils.loadAnimation(getContext(), 2130772674);
        Animation r4 = this.i;
        if (r4 == null) goto L5;
        r4.setRepeatCount(-1);
    L5:
        Animation r5 = this.i;
        if (r5 == null) goto L8;
        r5.setInterpolator(new LinearInterpolator());
    L8:
        Animation r6 = this.k;
        if (r6 == null) goto L11;
        r6.setInterpolator(new LinearInterpolator());
    L11:
        this.d.F4(false);
    }

    public final void onViewCreated(View r20, Bundle r22) {
        Intrinsics.checkNotNullParameter(r20, "view");
        super.onViewCreated(r20, r22);
        IBaseUser r0 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.user.a.class).b();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L12;
        ((TextView) ca0(2131383050)).setVisibility(0);
        String r4 = f51.a.e.a();
        if (TextUtils.isEmpty(r4) == true) goto L12;
        TextView r2 = (TextView) ca0(2131383050);
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;
        r2.setText(String.format(r4, Arrays.copyOf(new Object[]{2131918107}, 1)));
    L12:
        s1 r3 = this.h;
        String r6 = null;
        if (r3 == null) goto L61;
        IBattleLinkerInviteMessageExtra r7 = r3.getBattleExtra();
        if (r7 == null) goto L61;
        IRoom r8 = r7.getInviteRoom();
        if (r8 == null) goto L61;
        IBaseUser r9 = r8.getOwner();
        if (r9 == null) goto L61;
        AnchorLinkInfoInviteView r10 = (AnchorLinkInfoInviteView) ca0(2131377963);
        a1.x(r10.getIvAvatar(), r9.getAvatarThumbKt(), r10.getIvAvatar().getWidth(), r10.getIvAvatar().getHeight(), 2131250965);
        r10.getTvNickname().setText(r9.getNickName());
        if (r9.getGender() != 1) goto L24;
        r10.getIvGender().setImageResource(2131250688);
        r10.getIvGender().setVisibility(0);
    L28:
        if (r9.getFollowInfo() == null) goto L34;
        py.j r12 = r9.getFollowInfo();
        if (r12 == null) goto L34;
        if (r12.getFollowStatus() != 2) goto L34;
        r10.getTvLabelTop().setVisibility(0);
    L34:
        r10.getTvDistance().setVisibility(0);
        if (r9.getFollowInfo() == null) goto L41;
        TextView r13 = r10.getTvDistance();
        Object[] r14 = new Object[1];
        py.j r15 = r9.getFollowInfo();
        if (r15 == null) goto L39;
        long r16 = r15.getFollowerCount();
    L40:
        r14[0] = IESUIUtils.getDisplayCount(r16, "w");
        r13.setText(com.bytedance.android.live.core.utils.s1.C(2131914749, r14));
        goto L41
    L39:
        r16 = 0;
    L41:
        r10.setVisibility(0);
        s1 r17 = this.h;
        if (r17 == null) goto L61;
        IBattleLinkerInviteMessageExtra r18 = r17.getBattleExtra();
        if (r18 == null) goto L61;
        List r19 = r18.getMatchTags();
        if (r19 == null) goto L61;
        Iterator r23 = r19.iterator();
    L49:
        if (r23.hasNext() == false) goto L61;
        IBattleRivalTag r24 = (IBattleRivalTag) r23.next();
        LinearLayout r25 = (LinearLayout) ca0(2131362586);
        if (r25 == null) goto L49;
        View r26 = LayoutInflater.from(((LinearLayout) ca0(2131362586)).getContext()).inflate(2131566714, null);
        if (r26 == null) goto L60;
        TextView r27 = (TextView) r26;
        r27.setText(r24.getContent());
        r27.setTextColor(Color.parseColor(r24.getFontColor()));     // Catch: Exception -> L57
    L58:
        ((ObservableSubscribeProxy) a1.k(r24.getBackgroundImage()).compose(RxUtil.rxSchedulerHelper()).as(S90())).subscribe(new q(r27));
        LinearLayout.LayoutParams r28 = new LinearLayout.LayoutParams(-2, com.bytedance.android.live.revenue.common.i.b(20));
        r28.rightMargin = com.bytedance.android.live.revenue.common.i.b(4);
        Unit r29 = Unit.INSTANCE;
        r25.addView(r27, r28);
    L57:
        r27.setTextColor(ColorProtector.parseColor("#ff3b61"));
        goto L58
    L60:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L24:
        if (r9.getGender() != 2) goto L26;
        r10.getIvGender().setImageResource(2131250687);
        r10.getIvGender().setVisibility(0);
        goto L28
    L26:
        r10.getIvGender().setVisibility(8);
    L61:
        AnchorLinkInfoInviteView r30 = (AnchorLinkInfoInviteView) ca0(2131377963);
        r30.getIvAvatar().startAnimation(this.i);
        r30.getViewWave().setVisibility(0);
        r30.getAnimWave().setVisibility(0);
        r30.getAnimWave().startAnimation(this.k);
        Animation r32 = this.i;
        if (r32 == null) goto L64;
        r32.setAnimationListener(new r(this, r30));
    L64:
        Animation r33 = this.j;
        if (r33 == null) goto L67;
        r33.setAnimationListener(new s(this, r30));
    L67:
        i21.a r34 = (i21.a) this.f;
        s1 r35 = this.h;
        if (r35 == null) goto L70;
        int r36 = (int) r35.getWaitSec();
    L71:
        r34.f(r36);
        ((TextView) ca0(2131364604)).setOnClickListener(new c(this));
        ((TextView) ca0(2131364592)).setOnClickListener(new d(this));
        s1 r37 = this.h;
        if (r37 == null) goto L83;
        String r38 = r37.getClientInfo();
        if (r38 == null) goto L83;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L77
        Object r40 = Result.constructor-impl((v3) com.bytedance.android.live.revlink.impl.utils.e.a(r38, v3.class));     // Catch: Throwable -> L77
    L80:
        if (Result.isFailure-impl(r40) == false) goto L82;
        r40 = null;
    L82:
        v3 r110 = (v3) r40;
    L84:
        s1 r42 = this.h;
        if (r42 == null) goto L87;
        p0 r111 = e21.c.b(r42);
    L88:
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r43 = com.bytedance.android.live.revlink.impl.global.b.v();
        if (r43 == null) goto L122;
        s1 r44 = this.h;
        if (r44 == null) goto L95;
        IBattleLinkerInviteMessageExtra r45 = r44.getBattleExtra();
        if (r45 == null) goto L95;
        int r46 = (int) r45.getInviteType();
    L96:
        s1 r47 = this.h;
        if (r47 == null) goto L101;
        IBattleLinkerInviteMessageExtra r48 = r47.getBattleExtra();
        if (r48 == null) goto L101;
        int r112 = (int) r48.getMatchType();
    L102:
        s1 r49 = this.h;
        if (r49 == null) goto L105;
        Intrinsics.checkNotNullParameter(r49, "$this$fromUid");
        r6 = r49.get_fromUid();
    L105:
        String r113 = r6;
        s1 r50 = this.h;
        if (r50 == null) goto L109;
        String r52 = String.valueOf(r50.getFromRoomId());
        if (r52 == null) goto L109;
    L110:
        com.bytedance.android.live.revlink.impl.multianchor.utils.q.o(r43, r46, false, false, 1, false, r112, r113, r52, r110, r111, null, 1024);
        return;
    L109:
        r52 = "";
    L101:
        r112 = 0;
    L95:
        r46 = 0;
        goto L96
    L122:
        return;
    L87:
        r111 = null;
    L77:
        th = move-exception;
        Result.Companion r53 = Result.Companion;
        r40 = Result.constructor-impl(ResultKt.createFailure(th));
    L83:
        r110 = null;
        goto L84
    L70:
        r36 = 10;
        goto L71
    L5:
        if (r0.getSecret() != 1) goto L7;
        r1 = true;
        goto L8
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131566031, r3, false);
    }
}
