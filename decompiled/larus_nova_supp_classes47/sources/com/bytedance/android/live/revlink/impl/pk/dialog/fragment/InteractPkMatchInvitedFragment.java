package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revlink.impl.control.dialog.r;
import com.bytedance.android.live.revlink.impl.pk.dialog.PkBanSettingFragment;
import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPKInviteContract$View;
import com.bytedance.android.live.revlink.impl.pk.ui.PkTagsContainerView;
import com.bytedance.android.live.revlink.impl.utils.u;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.m4;
import com.bytedance.android.livesdk.link.model.n0;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.s1;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.r1;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/InteractPkMatchInvitedFragment;", "Lcom/bytedance/android/live/revlink/impl/pk/dialog/contract/InteractDialogPKInviteContract$View;", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractPkMatchInvitedFragment extends InteractDialogPKInviteContract$View {
    public static final /* synthetic */ int n = 0;
    public Map<Integer, View> g;
    public IBattleLinkerInviteMessageExtra h;
    public s1 i;
    public final IRoom j;
    public boolean k;
    public x31.d l;
    public long m;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ InteractPkMatchInvitedFragment a;

        public b(InteractPkMatchInvitedFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            InteractPkMatchInvitedFragment r5 = this.a;
            IRoom r0 = r5.j;
            if (r0 == null) goto L5;
            int r1 = PkBanSettingFragment.n;
            PkBanSettingFragment r6 = PkBanSettingFragment.a.a(r5.d, r0, r5, null);
            InteractPkMatchInvitedFragment r2 = this.a;
            r2.l = r6;
            r6.ca0(r2.i);
            this.a.d.zD(r6);
        L5:
            l51.a.H();
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ InteractPkMatchInvitedFragment a;

        public c(InteractPkMatchInvitedFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r12) {
            InteractPkMatchInvitedFragment r13 = this.a;
            int r0 = InteractPkMatchInvitedFragment.n;
            r13.ea0("reject");
            x31.f r1 = (x31.f) this.a.f;
            if (r1 == null) goto L14;
            long r3 = u.d();
            s1 r14 = this.a.i;
            if (r14 == null) goto L7;
            Intrinsics.checkNotNullParameter(r14, "$this$fromUid");
            String r15 = r14.get_fromUid();
        L8:
            String r5 = r15;
            s1 r16 = this.a.i;
            if (r16 == null) goto L11;
            long r6 = r16.getFromRoomId();
        L12:
            r1.e(0, r3, r5, r6, "", "");
            return;
        L11:
            r6 = 0;
            goto L12
        L7:
            r15 = null;
            goto L8
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ InteractPkMatchInvitedFragment a;

        public d(InteractPkMatchInvitedFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            InteractPkMatchInvitedFragment r9 = this.a;
            int r0 = InteractPkMatchInvitedFragment.n;
            r9.ea0("accept");
            InteractPkMatchInvitedFragment r10 = this.a;
            r10.getClass();
            LinkedHashMap r1 = new LinkedHashMap();
            r1.put("if_strategy_invite", DataType.TRUE);
            r1.put("match_time", String.valueOf((int) ((System.currentTimeMillis() - r10.m) / ((long) WebcastRedirectException.UNKNOWN))));
            r1.put("success_type", "1v1");
            mz0.n r2 = new mz0.n();
            mz0.o r3 = new mz0.o(r2.a);
            r3.a("from_room_status", "live");
            r3.a("anchor_type", "invitee");
            r3.a("is_rematch", DataType.FALSE);
            r3.a("match_type", "single");
            r3.a("connection_type", "random_pk");
            r3.a("connection_sub_type", "");
            r3.a("invite_mode", "routine_pk");
            r3.a("anchor_connect_status", "2");
            r3.a("room_status", "live");
            com.bytedance.android.live.revlink.impl.control.d r4 = com.bytedance.android.live.revlink.impl.global.b.f();
            if (r4 == null) goto L7;
            String r5 = r4.getRequestId();
            if (r5 == null) goto L7;
            r3.a("request_id", r5);
        L7:
            r3.b(r1);
            e21.c.e(r3, e21.c.b(r10.i));
            mz0.m r12 = new mz0.m();
            r12.b(LogCommon.ROOM);
            List<Object> r6 = r2.b;
            ArrayList r7 = (ArrayList) r6;
            r7.addAll(r12.a);
            cy0.e.a.getClass();
            cy0.j r13 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r14 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r14);
            ((mz0.i) ((f80.a) r14)).w3("livesdk_random_match_success", r2.a, r2.b);
            x31.f r15 = (x31.f) this.a.f;
            if (r15 == null) goto L16;
            long r16 = u.d();
            IBattleLinkerInviteMessageExtra r17 = this.a.h;
            if (r17 == null) goto L14;
            IRoom r18 = r17.getInviteRoom();
            if (r18 == null) goto L14;
            IBaseUser r19 = r18.getOwner();
        L15:
            r15.g(1, 0, r16, r19);
        L14:
            r19 = null;
        L16:
            r r20 = this.a.d;
            if (r20 == null) goto L20;
            r20.dismiss();
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final float U90() {
        return 270.0f;
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final String X90() {
        return "";
    }

    @Override // x31.e
    public final void ec() {
        IBattleLinkerInviteMessageExtra r0 = this.h;
        if (r0 == null) goto L19;
        IRoom r1 = r0.getInviteRoom();
        if (r1 == null) goto L19;
        if (r1.getOwner() == null) goto L19;
        x31.f r2 = (x31.f) this.f;
        if (r2 == null) goto L19;
        long r4 = u.d();
        s1 r3 = this.i;
        if (r3 == null) goto L13;
        Intrinsics.checkNotNullParameter(r3, "$this$fromUid");
        String r5 = r3.get_fromUid();
    L14:
        String r6 = r5;
        s1 r7 = this.i;
        if (r7 == null) goto L17;
        long r8 = r7.getFromRoomId();
    L18:
        r2.e(0, r4, r6, r8, "", "");
        goto L19
    L17:
        r8 = 0;
        goto L18
    L13:
        r5 = null;
    L19:
        ((x31.f) this.f).f();
    }

    public InteractPkMatchInvitedFragment() {
        this.g = new LinkedHashMap();
        this.j = u.a();
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final View V90() {
        View r0 = LayoutInflater.from(getContext()).inflate(2131567800, (ViewGroup) getView(), false);
        View r1 = r0.findViewById(2131377725);
        if (r1 == null) goto L51;
        TextView r2 = (TextView) r1;
        View r4 = r0.findViewById(2131383050);
        if (r4 == null) goto L49;
        ((TextView) r4).setVisibility(8);
        if (com.bytedance.android.live.revlink.impl.global.b.P() == null) goto L13;
        s1 r3 = this.i;
        if (r3 == null) goto L13;
        IBattleLinkerInviteMessageExtra r5 = r3.getBattleExtra();
        if (r5 == null) goto L13;
        int r6 = r5.getSwitchPlayMode();
    L14:
        int r7 = com.bytedance.android.live.revlink.impl.mergepk.pkdouble.d.a;
        if (r6 != 0) goto L35;
        IBattleLinkerInviteMessageExtra r8 = this.h;
        if (r8 == null) goto L35;
        String r9 = r8.getTips();
        if (r9 == null) goto L35;
        if (StringsKt.contains$default(r9, com.bytedance.android.live.core.utils.s1.B(2131914845), false, 2, null) != true) goto L35;
        IBattleLinkerInviteMessageExtra r10 = this.h;
        if (r10 == null) goto L25;
        String r12 = r10.getTips();
    L26:
        SpannableString r13 = new SpannableString(r12);
        IBattleLinkerInviteMessageExtra r14 = this.h;
        if (r14 == null) goto L31;
        String r15 = r14.getTips();
        if (r15 == null) goto L31;
        int r16 = StringsKt.indexOf$default(r15, com.bytedance.android.live.core.utils.s1.B(2131914845), 0, false, 6, null);
    L32:
        if (r16 == (-1)) goto L34;
        r13.setSpan(new ForegroundColorSpan(com.bytedance.android.live.core.utils.s1.h(2131106993)), r16, com.bytedance.android.live.core.utils.s1.B(2131914845).length() + r16, 0);
    L34:
        r2.setText(r13);
    L40:
        IBattleLinkerInviteMessageExtra r17 = this.h;
        if (r17 == null) goto L52;
        String r18 = r17.getActivityName();
        if (r18 != null) goto L45;
        return r0;
    L45:
        if (by0.b.a(r18) == true) goto L47;
        return r0;
    L47:
        return null;
    L52:
        return r0;
    L31:
        r16 = -1;
        goto L32
    L25:
        r12 = null;
    L35:
        IBattleLinkerInviteMessageExtra r19 = this.h;
        if (r19 == null) goto L38;
        String r20 = r19.getTips();
    L39:
        r2.setText(r20);
        goto L40
    L38:
        r20 = null;
    L13:
        r6 = 0;
        goto L14
    L49:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L51:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
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

    public final void onDestroyView() {
        super.onDestroyView();
        this.g.clear();
    }

    @Override // x31.e
    public final boolean UK() {
        return this.k;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPKInviteContract$View
    public final void ba0(int r4) {
        if (r4 != 5) goto L5;
        boolean r5 = true;
    L6:
        this.k = r5;
        if (r5 == false) goto L14;
        x31.d r6 = this.l;
        if (r6 == null) goto L14;
        if (r6.d() != true) goto L14;
        ToastUtil.b("已拒绝对方邀请", 0);
        return;
    L14:
        this.d.dismiss();
        return;
    L5:
        r5 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPKInviteContract$View
    public final void ca0(int r17) {
        if (((BaseFragment) this).mStatusViewValid == true) goto L5;
        return;
    L5:
        ((TextView) da0(2131364604)).setText(r1.b(getString(2131917997), new Object[]{Integer.valueOf(r17)}));
        if (r17 != 0) goto L26;
        IBattleLinkerInviteMessageExtra r1 = this.h;
        if (r1 == null) goto L24;
        IRoom r2 = r1.getInviteRoom();
        if (r2 == null) goto L24;
        if (r2.getOwner() == null) goto L24;
        x31.f r6 = (x31.f) this.f;
        if (r6 == null) goto L24;
        long r9 = u.d();
        s1 r3 = this.i;
        if (r3 == null) goto L18;
        Intrinsics.checkNotNullParameter(r3, "$this$fromUid");
        String r4 = r3.get_fromUid();
    L19:
        String r12 = r4;
        s1 r5 = this.i;
        if (r5 == null) goto L22;
        long r7 = r5.getFromRoomId();
    L23:
        r6.e(0, r9, r12, r7, "", "");
        goto L24
    L22:
        r7 = 0;
        goto L23
    L18:
        r4 = null;
    L24:
        ea0("overtime");
        this.d.F4(false);
        return;
    }

    public final View da0(int r3) {
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

    public final void ea0(String r8) {
        HashMap r0 = new HashMap();
        IBattleLinkerInviteMessageExtra r1 = this.h;
        if (r1 == null) goto L9;
        IRoom r2 = r1.getInviteRoom();
        if (r2 == null) goto L9;
        IBaseUser r3 = r2.getOwner();
        if (r3 == null) goto L9;
        r0.put("inviter_id", r3.getIdString().toString());
        r0.put("inviter_room_id", String.valueOf(r3.getLiveRoomId()));
        r0.put("inviter_room_status", "live");
        r0.put("inviter_connect_cnt", DataType.FALSE);
    L9:
        r0.put("event_page", "live_detail");
        r0.put("room_id", String.valueOf(this.d.getCurrentRoom().getId()));
        s1 r4 = this.i;
        if (r4 == null) goto L14;
        Intrinsics.checkNotNullParameter(r4, "$this$fromUid");
        String r5 = r4.get_fromUid();
        if (r5 == null) goto L14;
    L15:
        r0.put("inviter_id", r5);
        r0.put("invite_type", "anchor");
        r0.put("connection_type", "random_pk");
        r0.put("connection_sub_type", "");
        r0.put("is_oncemore", DataType.FALSE);
        r0.put("selection", r8);
        int r9 = UserListInviteType.a;
        s1 r10 = this.i;
        if (r10 == null) goto L18;
        int r12 = r10.getInviteType();
    L19:
        p0 r6 = null;
        r0.put("invitee_list", UserListInviteType.a(r12, null));
        r0.put("npk_link_type", "single");
        r0.put("invitee_connection_status", "live");
        r0.put("room_status", "live");
        r0.put("anchor_connect_status", DataType.FALSE);
        r0.put("anchor_connection_type", "invite");
        r0.put("invitee_id", com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.user.a.class).getCurrentUserId());
        r0.put("invite_mode", "routine_pk");
        IBattleLinkerInviteMessageExtra r13 = this.h;
        if (r13 == null) goto L24;
        List r14 = r13.getTagList();
        if (r14 == null) goto L24;
        IBattleRivalTag.Companion.getClass();
        IBattleRivalTag.a.a(r14, r0);
    L24:
        r0.put("list_num", DataType.FALSE);
        r0.put("if_strategy_invite", DataType.TRUE);
        r0.put("audience_connect_cnt", String.valueOf(com.bytedance.android.live.revenue.core.util.e.a(qr2.c.class).H()));
        mz0.n r15 = new mz0.n();
        mz0.o r7 = new mz0.o(r15.a);
        r7.b(r0);
        s1 r16 = this.i;
        if (r16 == null) goto L27;
        r6 = e21.c.b(r16);
    L27:
        e21.c.e(r7, r6);
        mz0.m r17 = new mz0.m();
        r17.b(LogCommon.ROOM);
        List<Object> r18 = r15.b;
        ArrayList r19 = (ArrayList) r18;
        r19.addAll(r17.a);
        cy0.e.a.getClass();
        cy0.j r20 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r22 = com.bytedance.android.scope.m.b(r20).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r22);
        ((mz0.i) ((f80.a) r22)).w3("connection_invited", r15.a, r15.b);
        return;
    L18:
        r12 = 0;
    L14:
        r5 = "";
        goto L15
    }

    public final void onViewCreated(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        super.onViewCreated(r13, r14);
        UIUtils.updateLayoutMargin(da0(2131389643), -3, com.bytedance.android.live.revenue.common.i.b(18), -3, -3);
        IBattleLinkerInviteMessageExtra r15 = this.h;
        List r16 = null;
        if (r15 == null) goto L29;
        String r17 = r15.getActivityName();
        if (r17 == null) goto L29;
        if (by0.b.a(r17) != true) goto L29;
        IBattleLinkerInviteMessageExtra r18 = this.h;
        if (r18 == null) goto L11;
        n0 r19 = r18.getActivityUser();
    L12:
        if (r19 == null) goto L29;
        IBattleLinkerInviteMessageExtra r2 = this.h;
        if (r2 == null) goto L18;
        n0 r3 = r2.getActivityUser();
        if (r3 == null) goto L18;
        List r4 = r3.getLabelList();
    L19:
        ArrayList r110 = new ArrayList(r4);
        IBattleLinkerInviteMessageExtra r5 = this.h;
        if (r5 == null) goto L24;
        List r6 = r5.getTagList();
        if (r6 == null) goto L24;
        r110.addAll(r6);
    L24:
        ViewUtilsKt.g(da0(2131392084), !r110.isEmpty());
        PkTagsContainerView r1 = (PkTagsContainerView) da0(2131392084);
        IBattleLinkerInviteMessageExtra r7 = this.h;
        if (r7 == null) goto L27;
        IRoom r8 = r7.getInviteRoom();
    L28:
        r1.a(r110, r8);
    L44:
        IBattleLinkerInviteMessageExtra r111 = this.h;
        if (r111 == null) goto L47;
        String r112 = r111.getRecommendReason();
    L49:
        if (TextUtils.isEmpty(r112) == true) goto L55;
        ViewUtilsKt.f(da0(2131391251));
        TextView r113 = (TextView) da0(2131391251);
        IBattleLinkerInviteMessageExtra r9 = this.h;
        if (r9 == null) goto L53;
        String r10 = r9.getRecommendReason();
    L54:
        r113.setText(r10);
    L56:
        TextView r114 = (TextView) da0(2131391251);
        if (r114 == null) goto L59;
        ViewUtilsKt.e(r114);
    L59:
        IBaseUser r115 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.user.a.class).b();
        if (r115 != null) goto L62;
    L64:
        boolean r116 = false;
    L66:
        if (r116 == false) goto L68;
        ViewUtilsKt.f(da0(2131383050));
        TextView r117 = (TextView) da0(2131383050);
        StringCompanionObject r12 = StringCompanionObject.INSTANCE;
        r117.setText(String.format(f51.a.e.a(), Arrays.copyOf(new Object[]{com.bytedance.android.live.core.utils.s1.B(2131914452)}, 1)));
    L69:
        IBattleLinkerInviteMessageExtra r118 = this.h;
        if (r118 == null) goto L86;
        IRoom r119 = r118.getInviteRoom();
        if (r119 == null) goto L86;
        IBaseUser r120 = r119.getOwner();
        if (r120 == null) goto L86;
        a1.x((ImageView) da0(2131389610), r120.getAvatarThumbKt(), da0(2131389610).getWidth(), da0(2131389610).getHeight(), 2131250965);
        TextView r20 = (TextView) da0(2131390820);
        String r22 = r120.getNickName();
        if (r22 == null) goto L78;
        String r23 = s21.c.a(r22, 20);
    L79:
        r20.setText(r23);
        VHeadView r24 = da0(2131375624);
        ViewUtilsKt.f(r24);
        if (r120.getGender() != 1) goto L83;
        r24.setImageResource(2131250688);
        goto L86
    L83:
        if (r120.getGender() != 2) goto L85;
        r24.setImageResource(2131250687);
        goto L86
    L85:
        r24.setVisibility(8);
        goto L86
    L78:
        r23 = null;
    L86:
        IBattleLinkerInviteMessageExtra r121 = this.h;
        if (r121 == null) goto L91;
        IRoom r122 = r121.getInviteRoom();
        if (r122 == null) goto L91;
        ViewUtilsKt.f(da0(2131389608));
        ((TextView) da0(2131389608)).setText(com.bytedance.android.live.core.utils.s1.C(2131917965, new Object[]{IESUIUtils.getDisplayCountChinese(r122.getUserCount())}));
    L91:
        IBattleLinkerInviteMessageExtra r123 = this.h;
        if (r123 == null) goto L94;
        m4 r124 = r123.getExtra();
    L96:
        if (r124 == null) goto L143;
        IBattleLinkerInviteMessageExtra r125 = this.h;
        if (r125 == null) goto L100;
        m4 r126 = r125.getExtra();
    L102:
        if (r126 != null) goto L104;
    L105:
        if (r126 != null) goto L107;
    L113:
        ((ImageView) da0(2131389650)).setVisibility(8);
        ((ImageView) da0(2131374680)).setVisibility(0);
    L114:
        if (r126 == null) goto L124;
        String r25 = r126.getText();
        if (r25 == null) goto L124;
        if (r25.length() != 0) goto L120;
        boolean r26 = true;
    L121:
        if (r26 != true) goto L124;
        ((ImageView) da0(2131374680)).setVisibility(8);
        ((TextView) da0(2131390819)).setVisibility(8);
    L129:
        IBattleLinkerInviteMessageExtra r127 = this.h;
        if (r127 == null) goto L132;
        aa r128 = r127.getVoteSetting();
    L134:
        if (r128 == null) goto L142;
        ((TextView) da0(2131391251)).setVisibility(8);
        TextView r129 = (TextView) da0(2131392794);
        Object[] r27 = new Object[1];
        IBattleLinkerInviteMessageExtra r28 = this.h;
        if (r28 == null) goto L140;
        aa r29 = r28.getVoteSetting();
        if (r29 == null) goto L140;
        String r30 = r29.getVoteDes();
    L141:
        r27[0] = r30;
        r129.setText(com.bytedance.android.live.core.utils.s1.C(2131918096, r27));
        ((TextView) da0(2131392794)).setVisibility(0);
    L144:
        ((TextView) da0(2131364604)).setOnClickListener(new c(this));
        ((TextView) da0(2131364592)).setOnClickListener(new d(this));
        r r130 = this.d;
        if (r130 == null) goto L147;
        r130.F4(false);
    L147:
        x31.f r131 = (x31.f) this.f;
        if (r131 == null) goto L154;
        s1 r32 = this.i;
        if (r32 == null) goto L152;
        int r33 = (int) r32.getWaitSec();
    L153:
        r131.h(r33);
        goto L154
    L152:
        r33 = 10;
    L154:
        p0 r132 = e21.c.b(this.i);
        HashMap r34 = new HashMap();
        IBattleLinkerInviteMessageExtra r35 = this.h;
        if (r35 == null) goto L159;
        List r36 = r35.getTagList();
        if (r36 == null) goto L159;
        IBattleRivalTag.Companion.getClass();
        IBattleRivalTag.a.a(r36, r34);
    L159:
        IBattleLinkerInviteMessageExtra r37 = this.h;
        if (r37 == null) goto L166;
        IRoom r38 = r37.getInviteRoom();
        if (r38 == null) goto L166;
        IBaseUser r39 = r38.getOwner();
        if (r39 == null) goto L166;
        r34.put("inviter_id", r39.getIdString().toString());
        r34.put("inviter_room_id", String.valueOf(r39.getLiveRoomId()));
        r34.put("inviter_room_status", "live");
        r34.put("inviter_connect_cnt", DataType.FALSE);
    L166:
        String r40 = u.e();
        if (r40 != null) goto L169;
        r40 = "";
    L169:
        r34.put("invitee_id", r40);
        int r42 = UserListInviteType.a;
        s1 r43 = this.i;
        if (r43 == null) goto L172;
        int r44 = r43.getInviteType();
    L173:
        r34.put("invitee_list", UserListInviteType.a(r44, null));
        r34.put("is_oncemore", DataType.FALSE);
        r34.put("pk_description", "routine");
        r34.put("npk_link_type", "single");
        r34.put("invitee_connection_status", "live");
        r34.put("anchor_connect_status", DataType.TRUE);
        r34.put("anchor_connection_type", "invite");
        r34.put("source", "pk_banner");
        r34.put("invite_type", "anchor");
        r34.put("connection_type", "random_pk");
        r34.put("room_status", "live");
        r34.put("audience_connect_cnt", DataType.FALSE);
        w31.c r45 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r45 == null) goto L176;
        Long r46 = Long.valueOf(r45.i());
    L177:
        r34.put("pk_id", String.valueOf(r46));
        r34.put("invite_mode", "routine_pk");
        r34.put("list_num", DataType.FALSE);
        r34.put("if_strategy_invite", DataType.TRUE);
        mz0.n r47 = new mz0.n();
        mz0.o r48 = new mz0.o(r47.a);
        r48.b(r34);
        e21.c.e(r48, r132);
        mz0.m r133 = new mz0.m();
        r133.b(LogCommon.PAGE_SOURCE_LOG);
        r133.b(LogCommon.ROOM);
        ((ArrayList) r47.b).addAll(r133.a);
        cy0.e.a.getClass();
        cy0.j r134 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r135 = com.bytedance.android.scope.m.b(r134).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r135);
        ((mz0.i) ((f80.a) r135)).w3("livesdk_connection_invited_page_show", r47.a, r47.b);
        LinearLayout r49 = (LinearLayout) da0(2131379708);
        if (r49 == null) goto L180;
        ViewUtilsKt.g(r49, true);
    L180:
        IBattleLinkerInviteMessageExtra r50 = this.h;
        if (r50 == null) goto L183;
        r16 = r50.getSemiFriendTags();
    L183:
        List r52 = r16;
        if (r52 != null) goto L186;
    L189:
        boolean r53 = true;
    L190:
        if (r53 == true) goto L199;
        LinearLayout r136 = (LinearLayout) da0(2131379708);
        if (r136 == null) goto L195;
        ViewUtilsKt.g(r136, false);
    L195:
        Context r54 = ((LinearLayout) da0(2131378739)).getContext();
        Iterator r137 = r16.iterator();
    L197:
        if (r137.hasNext() == false) goto L201;
        IBattleRivalTag r55 = (IBattleRivalTag) r137.next();
        View r56 = new View(r54);
        r56.setBackgroundColor(ColorProtector.parseColor("#D9D9D9"));
        LinearLayout.LayoutParams r57 = new LinearLayout.LayoutParams(com.bytedance.android.live.core.utils.s1.f(1.0f), com.bytedance.android.live.core.utils.s1.f(7.0f));
        r57.leftMargin = com.bytedance.android.live.core.utils.s1.f(4.0f);
        ((LinearLayout) da0(2131378739)).addView(r56, r57);
        TextView r58 = new TextView(r54);
        r58.setTextAppearance(r54, 2131954695);
        r58.setText(r55.getContent());
        r58.setTextColor(ColorProtector.parseColor("#FE2C55"));
        r58.setTextSize(1, 12.0f);
        LinearLayout.LayoutParams r59 = new LinearLayout.LayoutParams(-2, -2);
        r59.leftMargin = com.bytedance.android.live.core.utils.s1.f(4.0f);
        ((LinearLayout) da0(2131378739)).addView(r58, r59);
        goto L197
    L201:
        return;
    L199:
        return;
    L186:
        if (r52.isEmpty() == true) goto L189;
        r53 = false;
        goto L190
    L176:
        r46 = null;
        goto L177
    L172:
        r44 = 0;
    L140:
        r30 = null;
        goto L141
    L142:
        ((TextView) da0(2131392794)).setVisibility(8);
        goto L144
    L132:
        r128 = null;
        goto L134
    L120:
        r26 = false;
    L124:
        ((TextView) da0(2131390819)).setVisibility(0);
        TextView r60 = (TextView) da0(2131390819);
        if (r126 == null) goto L127;
        String r138 = r126.getText();
    L128:
        r60.setText(r138);
        goto L129
    L127:
        r138 = null;
        goto L128
    L107:
        if (r126.getTextType() != IRivalExtraInfo.TextType.DistanceCity.ordinal()) goto L113;
    L109:
        if (r126.getText() == null) goto L114;
        if (r126.getText().length() <= 0) goto L114;
        ((ImageView) da0(2131389650)).setVisibility(0);
        goto L114
    L104:
        if (r126.getTextType() == IRivalExtraInfo.TextType.Distance.ordinal()) goto L109;
    L100:
        r126 = null;
        goto L102
    L143:
        ((TextView) da0(2131390819)).setVisibility(8);
        goto L144
    L94:
        r124 = null;
        goto L96
    L68:
        ViewUtilsKt.e(da0(2131383050));
        goto L69
    L62:
        if (r115.getSecret() != 1) goto L64;
        r116 = true;
        goto L66
    L53:
        r10 = null;
        goto L54
    L55:
        ViewUtilsKt.e(da0(2131391251));
        goto L56
    L47:
        r112 = null;
        goto L49
    L27:
        r8 = null;
    L18:
        r4 = null;
        goto L19
    L11:
        r19 = null;
    L29:
        IBattleLinkerInviteMessageExtra r139 = this.h;
        if (r139 == null) goto L35;
        List r140 = r139.getTagList();
        if (r140 == null) goto L35;
        if (r140.isEmpty() == true) goto L44;
    L35:
        ((PkTagsContainerView) da0(2131392084)).setOldTag(true);
        ViewUtilsKt.g(da0(2131392084), true);
        PkTagsContainerView r141 = (PkTagsContainerView) da0(2131392084);
        IBattleLinkerInviteMessageExtra r62 = this.h;
        if (r62 == null) goto L38;
        List r63 = r62.getTagList();
    L39:
        IBattleLinkerInviteMessageExtra r64 = this.h;
        if (r64 == null) goto L42;
        IRoom r65 = r64.getInviteRoom();
    L43:
        r141.a(r63, r65);
        goto L44
    L42:
        r65 = null;
        goto L43
    L38:
        r63 = null;
        goto L39
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        this.m = System.currentTimeMillis();
        return r3.inflate(2131565693, r4, false);
    }
}
