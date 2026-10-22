package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.control.dialog.r;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c0;
import com.bytedance.android.live.revlink.impl.pk.dialog.PkBanSettingFragment;
import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPKInviteContract$View;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.ui.PkTagsContainerView;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.gift.model.IRichText;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.RichTextType;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.e6;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j6;
import com.bytedance.android.livesdk.link.model.l1;
import com.bytedance.android.livesdk.link.model.m1;
import com.bytedance.android.livesdk.link.model.m4;
import com.bytedance.android.livesdk.link.model.n0;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.q1;
import com.bytedance.android.livesdk.link.model.v3;
import com.bytedance.android.livesdk.link.model.w2;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.r1;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import dq2.w;
import gd0.v;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/InteractPKBeInviteFragment;", "Lcom/bytedance/android/live/revlink/impl/pk/dialog/contract/InteractDialogPKInviteContract$View;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractPKBeInviteFragment extends InteractDialogPKInviteContract$View implements View.OnClickListener {
    public static final a T = null;
    public View A;
    public x0 B;
    public final IRoom C;
    public View D;
    public TextView E;
    public HSImageView F;
    public HSImageView G;
    public TextView H;
    public View I;
    public View J;
    public LinearLayout K;
    public IBattleLinkerInviteMessageExtra L;
    public View M;
    public x31.d N;
    public boolean O;
    public i6 P;
    public TextView Q;
    public final LinkCrossRoomDataHolder R;
    public i11.b S;
    public PkTagsContainerView g;
    public final CompositeDisposable h;
    public ViewGroup i;
    public ViewGroup j;
    public TextView k;
    public IBaseUser l;
    public IBaseUser m;
    public long n;
    public long o;
    public TextView p;
    public FrameLayout q;
    public HSImageView r;
    public TextView s;
    public ConstraintLayout t;
    public String u;
    public IRoom v;
    public int w;
    public m4 x;
    public List<? extends IBattleRivalTag> y;
    public View z;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ InteractPKBeInviteFragment a;

        public b(InteractPKBeInviteFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            int r5 = PkBanSettingFragment.n;
            InteractPKBeInviteFragment r6 = this.a;
            a r0 = InteractPKBeInviteFragment.T;
            r r1 = r6.d;
            IRoom r7 = r6.C;
            Intrinsics.checkNotNull(r7);
            InteractPKBeInviteFragment r2 = this.a;
            PkBanSettingFragment r8 = PkBanSettingFragment.a.a(r1, r7, r2, r2.P);
            InteractPKBeInviteFragment r3 = this.a;
            r3.N = r8;
            r3.d.zD(r8);
            l51.a.H();
            HashMap r9 = new HashMap();
            IRoom r10 = this.a.d.getCurrentRoom();
            if (r10 == null) goto L5;
            r9.put("room_id", String.valueOf(r10.getId()));
            IBaseUser r12 = r10.getOwner();
            Intrinsics.checkNotNull(r12);
            r9.put("anchor_id", r12.getIdString().toString());
        L5:
            IBaseUser r13 = this.a.m;
            if (r13 == null) goto L8;
            Intrinsics.checkNotNull(r13);
            r9.put("inviter_id", r13.getIdString().toString());
        L8:
            IBattleLinkerInviteMessageExtra r14 = this.a.L;
            if (r14 == null) goto L13;
            Intrinsics.checkNotNull(r14);
            if (r14.getVoteSetting() == null) goto L13;
            r9.put("invite_mode", "vote");
        L14:
            int r15 = UserListInviteType.a;
            LinkCrossRoomDataHolder r16 = this.a.R;
            if (r16 == null) goto L17;
            int r17 = r16.f();
        L18:
            String r18 = null;
            r9.put("invitee_list", UserListInviteType.a(r17, null));
            IBattleLinkerInviteMessageExtra r19 = this.a.L;
            if (r19 == null) goto L23;
            IBattleConfigSetting r20 = r19.getBattleConfigSetting();
            if (r20 == null) goto L23;
            r18 = r20.getActivityId();
        L23:
            if (r18 != null) goto L25;
        L27:
            mz0.n r22 = new mz0.n();
            Map<String, String> r23 = r22.a;
            Intrinsics.checkNotNullParameter(r23, "map");
            Intrinsics.checkNotNullParameter(r9, "map");
            r23.putAll(r9);
            mz0.m r24 = new mz0.m();
            LinkCrossRoomDataHolder.a r25 = LinkCrossRoomDataHolder.c;
            com.bytedance.android.live.revlink.impl.a.b(r24);
            List<Object> r26 = r22.b;
            ArrayList r27 = (ArrayList) r26;
            r27.addAll(r24.a);
            cy0.e.a.getClass();
            cy0.j r28 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r29 = com.bytedance.android.scope.m.b(r28).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r29);
            ((mz0.i) ((f80.a) r29)).w3("livesdk_pk_disturb_settings_click", r22.a, r22.b);
            return;
        L25:
            if (r2.a(r18) != true) goto L27;
            r9.put("pk_activity_type", r18);
            goto L27
        L17:
            r17 = 0;
        L13:
            r9.put("invite_mode", "routine_pk");
            goto L14
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ InteractPKBeInviteFragment a;

        public c(InteractPKBeInviteFragment r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r8, int r9) {
            Intrinsics.checkNotNullParameter(r8, "dialog");
            r8.dismiss();
            InteractPKBeInviteFragment r10 = this.a;
            a r12 = InteractPKBeInviteFragment.T;
            ((x31.f) r10.f).g(2, r10.n, r10.o, r10.m);
            ((x31.f) this.a.f).f();
            InteractPKBeInviteFragment.da0(this.a, false);
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ InteractPKBeInviteFragment a;

        public d(InteractPKBeInviteFragment r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r9, int r10) {
            Intrinsics.checkNotNullParameter(r9, "dialog");
            r9.dismiss();
            com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.broadcast.a.class).stopGameCastToAudience();
            com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.broadcast.a.class).hidePlugin(true);
            InteractPKBeInviteFragment r12 = this.a;
            a r0 = InteractPKBeInviteFragment.T;
            ((x31.f) r12.f).g(1, r12.n, r12.o, r12.m);
            ((x31.f) this.a.f).f();
            InteractPKBeInviteFragment.da0(this.a, true);
        }
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final float U90() {
        return 270.0f;
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final String X90() {
        return "";
    }

    static {
        T = new a();
    }

    public static int fa0() {
        if (v.a(com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.interact.d.class).getMultiInteractMode(), 32) == true) goto L5;
    L7:
        return 0;
    L5:
        if (com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.interact.d.class).M1() == null) goto L7;
        w r0 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.interact.d.class).M1();
        Intrinsics.checkNotNull(r0);
        return r0.w();
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final View W90() {
        View r0 = this.M;
        Intrinsics.checkNotNull(r0);
        r0.setVisibility(8);
        View r1 = LayoutInflater.from(getContext()).inflate(2131567620, (ViewGroup) getView(), false);
        if (l51.a.i() == false) goto L5;
        r1.findViewById(2131363884).setVisibility(0);
    L5:
        r1.setOnClickListener(new b(this));
        return r1;
    }

    @Override // x31.e
    public final void ec() {
        ((x31.f) this.f).g(2, this.n, this.o, this.m);
        ((x31.f) this.f).f();
    }

    public InteractPKBeInviteFragment() {
        this.h = new CompositeDisposable();
        yz0.k r0 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r0 == null) goto L5;
        IRoom r1 = r0.getRoom();
    L6:
        this.C = r1;
        this.R = com.bytedance.android.live.revlink.impl.global.b.j();
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final View V90() {
        boolean r3 = false;
        View r0 = LayoutInflater.from(getContext()).inflate(2131567800, (ViewGroup) getView(), false);
        View r1 = r0.findViewById(2131377725);
        if (r1 == null) goto L36;
        TextView r2 = (TextView) r1;
        View r4 = r0.findViewById(2131383050);
        if (r4 == null) goto L34;
        ((TextView) r4).setVisibility(8);
        if (com.bytedance.android.live.revlink.impl.global.b.P() == null) goto L13;
        i6 r5 = this.P;
        if (r5 == null) goto L13;
        IBattleLinkerInviteMessageExtra r6 = j6.a(r5);
        if (r6 == null) goto L13;
        int r7 = r6.getSwitchPlayMode();
    L14:
        int r8 = com.bytedance.android.live.revlink.impl.mergepk.pkdouble.d.a;
        if (r7 != 0) goto L22;
        String r9 = this.u;
        Intrinsics.checkNotNull(r9);
        if (StringsKt.contains$default(r9, s1.B(2131914845), false, 2, null) == false) goto L22;
        SpannableString r10 = new SpannableString(this.u);
        String r12 = this.u;
        Intrinsics.checkNotNull(r12);
        int r13 = StringsKt.indexOf$default(r12, s1.B(2131914845), 0, false, 6, null);
        if (r13 == (-1)) goto L21;
        r10.setSpan(new ForegroundColorSpan(s1.h(2131106993)), r13, s1.B(2131914845).length() + r13, 0);
    L21:
        r2.setText(r10);
    L23:
        IBattleLinkerInviteMessageExtra r14 = this.L;
        if (r14 == null) goto L32;
        Intrinsics.checkNotNull(r14);
        if (r14.getActivityName() == null) goto L32;
        IBattleLinkerInviteMessageExtra r15 = this.L;
        Intrinsics.checkNotNull(r15);
        if (r15.getActivityName().length() != 0) goto L30;
        r3 = true;
    L30:
        if (r3 == true) goto L32;
        return null;
    L32:
        return r0;
    L22:
        r2.setText(this.u);
    L13:
        r7 = 0;
        goto L14
    L34:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L36:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    public final void onDestroy() {
        super.onDestroy();
        this.d.F4(true);
        this.h.dispose();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((x31.f) this.f).f();
        IRoom r0 = this.C;
        if (r0 != null) goto L5;
    L9:
        com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.room.a.class).checkRecoverForNative("anchor_invited_panel", "dismiss");
        return;
    L5:
        if (r0.isLiveTypeAudio() == true) goto L9;
        p11.d r1 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo469getPerfManager();
        if (r1 == null) goto L9;
        r1.g();
        goto L9
    }

    @Override // x31.e
    public final boolean UK() {
        return this.O;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPKInviteContract$View
    public final void ba0(int r3) {
        if (r3 != 5) goto L5;
        boolean r4 = true;
    L6:
        this.O = r4;
        if (r4 == false) goto L14;
        x31.d r5 = this.N;
        if (r5 == null) goto L14;
        Intrinsics.checkNotNull(r5);
        if (r5.d() == false) goto L14;
        ToastUtil.b("已拒绝对方邀请", 0);
        return;
    L14:
        this.d.dismiss();
        return;
    L5:
        r4 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPKInviteContract$View
    public final void ca0(int r14) {
        if (((BaseFragment) this).mStatusViewValid == true) goto L5;
        return;
    L5:
        TextView r0 = this.k;
        Intrinsics.checkNotNull(r0);
        r0.setText(r1.b(getString(2131917997), new Object[]{Integer.valueOf(r14)}));
        if (r14 != 0) goto L121;
        HashMap r15 = new HashMap();
        r15.put("event_page", "live_detail");
        r15.put("room_id", String.valueOf(this.d.getCurrentRoom().getId()));
        IBaseUser r1 = this.m;
        if (r1 == null) goto L10;
        Intrinsics.checkNotNull(r1);
        r15.put("inviter_id", r1.getIdString().toString());
    L10:
        IBaseUser r2 = this.l;
        if (r2 == null) goto L13;
        Intrinsics.checkNotNull(r2);
        r15.put("invitee_id", r2.getIdString().toString());
    L13:
        LinkCrossRoomDataHolder r3 = this.R;
        String r6 = "";
        String r7 = null;
        if (r3 != null) goto L16;
    L26:
        LinkCrossRoomDataHolder r4 = this.R;
        if (r4 != null) goto L29;
    L31:
        String r5 = "manual";
    L32:
        r15.put("match_type", r5);
        r15.put("is_oncemore", DataType.FALSE);
        r15.put("selection", "overtime");
        long r9 = 0;
        w31.c r8 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r8 == null) goto L35;
        int r10 = r8.a();
    L36:
        if (r10 <= 0) goto L42;
        LinkCrossRoomDataHolder r12 = this.R;
        if (r12 == null) goto L42;
        if (r12.i() != 0) goto L42;
        r9 = this.w;
    L42:
        int r13 = UserListInviteType.a;
        LinkCrossRoomDataHolder r16 = this.R;
        if (r16 == null) goto L45;
        int r17 = r16.f();
    L46:
        r15.put("invitee_list", UserListInviteType.a(r17, null));
        r15.put("pk_description", "routine");
        r15.put("npk_link_type", "single");
        r15.put("invitee_connection_status", "live");
        d31.d r18 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r18 == null) goto L52;
        String r19 = r18.a();
        if (r19 == null) goto L52;
        r6 = r19;
    L52:
        r15.put("anchor_connect_status", r6);
        r15.put("anchor_connection_type", "invite");
        r15.put("invitee_id", com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.user.a.class).getCurrentUserId().toString());
        IBattleLinkerInviteMessageExtra r20 = this.L;
        if (r20 == null) goto L59;
        Intrinsics.checkNotNull(r20);
        if (TextUtils.isEmpty(r20.getRecommendReason()) == true) goto L57;
        Object r22 = DataType.TRUE;
    L58:
        r15.put("with_audience", r22);
        goto L59
    L57:
        r22 = DataType.FALSE;
    L59:
        ea0(r15);
        IBattleLinkerInviteMessageExtra r23 = this.L;
        if (r23 == null) goto L64;
        Intrinsics.checkNotNull(r23);
        if (r23.getVoteSetting() == null) goto L64;
        r15.put("invite_mode", "vote");
    L65:
        IBattleLinkerInviteMessageExtra r24 = this.L;
        if (r24 == null) goto L70;
        IBattleConfigSetting r25 = r24.getBattleConfigSetting();
        if (r25 == null) goto L70;
        r7 = r25.getActivityId();
    L70:
        if (r7 != null) goto L72;
    L74:
        IBattleRivalTag.a r26 = IBattleRivalTag.Companion;
        List<? extends IBattleRivalTag> r27 = this.y;
        Intrinsics.checkNotNull(r27);
        r26.getClass();
        IBattleRivalTag.a.a(r27, r15);
        r15.put("audience_connect_cnt", String.valueOf(fa0()));
        i6 r28 = this.P;
        if (r28 == null) goto L82;
        Intrinsics.checkNotNull(r28);
        if (r28.getInvite() == null) goto L82;
        i6 r29 = this.P;
        Intrinsics.checkNotNull(r29);
        e6 r30 = r29.getInvite();
        Intrinsics.checkNotNull(r30);
        if (r30.getSupportMultiInvite() == false) goto L81;
        r15.put("support_multi_invite", DataType.TRUE);
        i6 r32 = this.P;
        Intrinsics.checkNotNull(r32);
        e6 r33 = r32.getInvite();
        Intrinsics.checkNotNull(r33);
        r15.put("invited_cnt", String.valueOf(r33.getCurInviteNum()));
        goto L82
    L81:
        r15.put("support_multi_invite", DataType.FALSE);
    L82:
        IBattleLinkerInviteMessageExtra r34 = this.L;
        if (r34 == null) goto L89;
        Intrinsics.checkNotNull(r34);
        if (r34.getBattleConfigSetting() == null) goto L89;
        IBattleLinkerInviteMessageExtra r35 = this.L;
        Intrinsics.checkNotNull(r35);
        IBattleConfigSetting r36 = r35.getBattleConfigSetting();
        Intrinsics.checkNotNull(r36);
        if (r36.getSpecifyGiftConfig() == null) goto L89;
        r15.put("invite_mode", "focus_gift");
        IBattleLinkerInviteMessageExtra r37 = this.L;
        Intrinsics.checkNotNull(r37);
        IBattleConfigSetting r38 = r37.getBattleConfigSetting();
        Intrinsics.checkNotNull(r38);
        c0.a(r38.getSpecifyGiftConfig(), r15);
    L89:
        IBaseUser r39 = this.m;
        if (r39 == null) goto L92;
        Intrinsics.checkNotNull(r39);
        r15.put("inviter_id", r39.getIdString().toString());
        IBaseUser r40 = this.m;
        Intrinsics.checkNotNull(r40);
        r15.put("inviter_room_id", String.valueOf(r40.getLiveRoomId()));
    L92:
        q1.a(this.L, r15);
        mz0.n r42 = new mz0.n();
        mz0.o r43 = new mz0.o(r42.a);
        r43.b(r15);
        e21.e.d(r43, e21.e.c(this.P));
        e21.c.e(r43, e21.c.a(this.P));
        mz0.m r110 = new mz0.m();
        r110.b(LogCommon.PAGE_SOURCE_LOG);
        com.bytedance.android.livesdk.revenue.log.h r44 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r44, "linkInfoLog");
        r44.c(r9);
        ((ArrayList) r110.a).add(r44.a);
        r110.b(LogCommon.ROOM);
        LinkCrossRoomDataHolder.a r45 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r110);
        ((ArrayList) r42.b).addAll(r110.a);
        cy0.e.a.getClass();
        cy0.j r111 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r112 = com.bytedance.android.scope.m.b(r111).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r112);
        ((mz0.i) ((f80.a) r112)).w3("connection_invited", r42.a, r42.b);
        x0 r113 = this.B;
        if (r113 == null) goto L113;
        Intrinsics.checkNotNull(r113);
        if (r113.isShowing() == false) goto L113;
        x0 r114 = this.B;
        Intrinsics.checkNotNull(r114);
        Handler r46 = DialogLancet.resolveDialogHandler(r114);
        if (r46 != null) goto L99;
    L101:
        DialogLancet.beforeDialogDismiss(r114);
        r114.dismiss();     // Catch: Throwable -> L104 Exception -> L106
    L110:
        DialogLancet.afterDialogDismiss(r114);
        goto L113
    L106:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L104
        Throwable r47 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L104
        if (r47 == null) goto L110;
        com.bytedance.crash.d.d(r47, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L104
    L104:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r114);
        throw th;
    L99:
        if (Looper.myLooper() == r46.getLooper()) goto L101;
        r46.post(DialogLancet.createDismissRunnable(r114));
    L113:
        IBaseUser r115 = this.m;
        if (r115 == null) goto L116;
        ((x31.f) this.f).g(5, this.n, this.o, r115);
    L116:
        this.d.F4(false);
        return;
    L72:
        if (r2.a(r7) != true) goto L74;
        r15.put("pk_activity_type", r7);
        r15.put("invite_mode", "activity_pk");
    L64:
        r15.put("invite_mode", "routine_pk");
        goto L65
    L45:
        r17 = 0;
        goto L46
    L35:
        r10 = 0;
        goto L36
    L29:
        if (r4.i() != 1) goto L31;
        r5 = "random";
        goto L32
    L16:
        if (r3.i() != 1) goto L26;
        Map<? extends String, ? extends String> r48 = MapsKt.toMutableMap(r15);
        w31.c r49 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r49 == null) goto L20;
        String r50 = r49.l();
    L21:
        r48.put(FileUtils.PICTURE_THEME, r50);
        w31.c r52 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r52 == null) goto L24;
        Integer r53 = Integer.valueOf(r52.a());
    L25:
        r48.put("pk_time", String.valueOf(r53));
        mz0.n r54 = new mz0.n();
        Map<String, String> r55 = r54.a;
        Intrinsics.checkNotNullParameter(r55, "map");
        Intrinsics.checkNotNullParameter(r48, "map");
        r55.putAll(r48);
        mz0.m r56 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r57 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r57, "pageSourceLog");
        Intrinsics.checkNotNullParameter("live", "belong");
        r57.a("live");
        Intrinsics.checkNotNullParameter("other", "type");
        r57.d("other");
        ((ArrayList) r56.a).add(r57.a);
        ((ArrayList) r54.b).addAll(r56.a);
        cy0.e.a.getClass();
        cy0.j r58 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r59 = com.bytedance.android.scope.m.b(r58).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r59);
        ((mz0.i) ((f80.a) r59)).w3("random_match_cancel", r54.a, r54.b);
        goto L26
    L24:
        r53 = null;
        goto L25
    L20:
        r50 = "";
        goto L21
    }

    public final void ea0(Map<String, String> r12) {
        w31.c r0 = com.bytedance.android.live.revlink.impl.global.b.T();
        boolean r1 = false;
        String r3 = "manual_link";
        String r5 = null;
        if (r0 == null) goto L8;
        if (r0.a() != 0) goto L8;
        r12.put("connection_type", "manual_link");
    L38:
        String r2 = iz.a.a(com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.user.a.class).b());
        IPKLinkBizDataService r4 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r4 == null) goto L43;
        String r6 = r4.getTransformReason(r2, iz.a.a(this.m));
        if (TextUtils.isEmpty(r6) == true) goto L43;
        r12.put("transform_reason", r6);
    L43:
        ILinkService r7 = (ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class);
        p11.h r8 = r7.mo470getPkService();
        if (r8 == null) goto L46;
        String r9 = r8.getTheme();
    L47:
        if (r9 != null) goto L49;
    L52:
        boolean r10 = true;
    L53:
        if (r10 == true) goto L55;
        r12.put(FileUtils.PICTURE_THEME, r9);
    L55:
        if (r8 == null) goto L57;
        r5 = r8.getInviteMode();
    L57:
        String r13 = r7.mo468getMultiAnchorService().q();
        if (r5 != null) goto L60;
    L61:
        r1 = true;
    L62:
        if (r1 == false) goto L65;
        r5 = "routine_pk";
    L65:
        r12.put("invite_mode", r5);
        if (r13 != null) goto L68;
        r13 = "";
    L68:
        r12.put("battle_mode", r13);
        r12.put("inviter_connect_cnt", DataType.FALSE);
        i6 r14 = this.P;
        if (r14 != null) goto L71;
    L81:
        r12.put("invite_type", "anchor");
        if (fa0() <= 0) goto L84;
        r12.put("room_status", "audience_connection");
    L85:
        r12.put("connection_sub_type", "");
        return;
    L84:
        r12.put("room_status", "live");
        goto L85
    L71:
        if (j6.a(r14) == null) goto L81;
        IBattleLinkerInviteMessageExtra r15 = j6.a(this.P);
        Intrinsics.checkNotNull(r15);
        if (r15.getInviteStatus() == null) goto L80;
        IBattleLinkerInviteMessageExtra r16 = j6.a(this.P);
        Intrinsics.checkNotNull(r16);
        Integer r17 = r16.getInviteStatus();
        int r18 = IBattleLinkerInviteMessageExtra.InviteStatus.InviteStatusInAudienceLinkMic.ordinal();
        if (r17 == null) goto L80;
        if (r17.intValue() != r18) goto L80;
        r12.put("inviter_room_status", "audience_connection");
    L80:
        r12.put("inviter_room_status", "live");
        goto L81
    L60:
        if (r5.length() != 0) goto L62;
    L49:
        if (r9.length() == 0) goto L52;
        r10 = false;
        goto L53
    L46:
        r9 = null;
    L8:
        if (com.bytedance.android.live.revlink.impl.global.b.P() == null) goto L24;
        i6 r19 = this.P;
        if (r19 == null) goto L14;
        IBattleLinkerInviteMessageExtra r20 = j6.a(r19);
        if (r20 == null) goto L14;
        int r22 = r20.getSwitchPlayMode();
    L15:
        int r23 = com.bytedance.android.live.revlink.impl.mergepk.pkdouble.d.a;
        if (r22 != 1) goto L23;
        LinkCrossRoomDataHolder r24 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r24 != null) goto L20;
    L22:
        r12.put("connection_type", r3);
    L25:
        p11.h r25 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService();
        if (r25 == null) goto L29;
        String r26 = r25.getTheme();
        if (r26 == null) goto L29;
    L31:
        if (TextUtils.isEmpty(r26) == true) goto L33;
        r12.put(FileUtils.PICTURE_THEME, r26);
    L33:
        w31.c r27 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r27 == null) goto L36;
        Integer r28 = Integer.valueOf(r27.a());
    L37:
        r12.put("pk_time", String.valueOf(r28));
        goto L38
    L36:
        r28 = null;
    L29:
        r26 = "";
        goto L31
    L20:
        if (r24.i() != 1) goto L22;
        r3 = "random_link";
        goto L22
    L23:
        r12.put("connection_type", "manual_pk");
    L14:
        r22 = 0;
        goto L15
    L24:
        r12.put("connection_type", "manual_pk");
        goto L25
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r25) {
        Intrinsics.checkNotNullParameter(r25, "v");
        int r1 = r25.getId();
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).R1();
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("event_page", "live_detail");
        r2.put("room_id", String.valueOf(this.d.getCurrentRoom().getId()));
        IBaseUser r3 = this.m;
        if (r3 == null) goto L5;
        Intrinsics.checkNotNull(r3);
        r2.put("inviter_id", r3.getIdString().toString());
    L5:
        IBaseUser r4 = this.l;
        if (r4 == null) goto L9;
        Intrinsics.checkNotNull(r4);
        r2.put("invitee_id", r4.getIdString().toString());
    L9:
        if (r1 == 2131364595) goto L11;
        if (r1 == 2131364604) goto L11;
    L25:
        if (r1 != 2131364595) goto L38;
        LinkCrossRoomDataHolder r5 = this.R;
        if (r5 == null) goto L38;
        if (r5.i() != 0) goto L38;
        HashMap r6 = new HashMap();
        IRoom r7 = this.d.getCurrentRoom();
        if (r7 == null) goto L33;
        r6.put("room_id", String.valueOf(r7.getId()));
        IBaseUser r8 = r7.getOwner();
        Intrinsics.checkNotNull(r8);
        r6.put("anchor_id", r8.getIdString().toString());
    L33:
        IBaseUser r9 = this.l;
        if (r9 == null) goto L36;
        Intrinsics.checkNotNull(r9);
        r6.put("invitee_id", r9.getIdString().toString());
    L36:
        mz0.n r10 = new mz0.n();
        Map<String, String> r12 = r10.a;
        Intrinsics.checkNotNullParameter(r12, "map");
        Intrinsics.checkNotNullParameter(r6, "map");
        r12.putAll(r6);
        cy0.e.a.getClass();
        cy0.j r13 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r14 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r14);
        ((mz0.i) ((f80.a) r14)).w3("livesdk_manual_match_cancel", r10.a, r10.b);
    L38:
        if (r1 == 2131364604) goto L40;
        if (r1 == 2131364592) goto L40;
    L105:
        if (r1 != 2131364595) goto L111;
        IBaseUser r15 = this.l;
        if (r15 == null) goto L109;
        x31.f r16 = (x31.f) this.f;
        long r17 = this.n;
        long r18 = this.o;
        Intrinsics.checkNotNull(r15);
        String r19 = iz.a.a(r15);
        IBaseUser r20 = this.l;
        Intrinsics.checkNotNull(r20);
        r16.e(r17, r18, r19, 0, com.bytedance.android.live.base.model.user.o.a(r20), "click_item_cancel");
    L109:
        this.d.dismiss();
        return;
    L111:
        if (r1 == 2131364592) goto L115;
        if (r1 == 2131364604) goto L115;
        return;
    L115:
        if (this.m != null) goto L117;
        return;
    L117:
        if (r1 != 2131364592) goto L131;
        if (wq2.e.b().d() <= 0) goto L121;
    L122:
        Context r22 = getContext();
        x0.d r23 = new x0.d();
        r23.b = r22;
        r23.a = 4;
        r23.k = false;
        r23.d = r23.b.getText(2131921454);
        c r24 = new c(this);
        x0.c[] r26 = r23.g;
        x0.c r27 = r26[1];
        if (r27 != null) goto L125;
        r27 = new x0.c();
        r26[1] = r27;
    L125:
        r27.a = "取消";
        r27.b = r24;
        d r28 = new d(this);
        x0.c[] r29 = r23.g;
        x0.c r30 = r29[0];
        if (r30 != null) goto L128;
        r30 = new x0.c();
        r29[0] = r30;
    L128:
        r30.a = "确定";
        r30.b = r28;
        x0 r32 = new x0(r23.b, r23);
        x0.b.g(r32);
        this.B = r32;
        return;
    L121:
        if (wq2.e.b().b() == true) goto L122;
    L131:
        if (com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.interact.d.class).M1() == null) goto L135;
        w r33 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.interact.d.class).M1();
        Intrinsics.checkNotNull(r33);
        if (r33.n() == true) goto L135;
        int r34 = 11;
    L136:
        x31.f r110 = (x31.f) this.f;
        if (r1 != 2131364604) goto L139;
        int r111 = 2;
    L140:
        r110.g(r111, this.n, this.o, this.m);
        if (r1 == 2131364592) goto L143;
    L149:
        ((x31.f) this.f).f();
        return;
    L143:
        if (com.bytedance.android.live.revlink.impl.global.b.N() == null) goto L149;
        com.bytedance.android.livesdk.revenue.service.room.c r35 = com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        Intrinsics.checkNotNull(r35);
        com.bytedance.android.livesdk.revenue.room.a r36 = r35.getRoomContext();
        if (r36 == null) goto L149;
        if (r36.isInVideoPlay() == false) goto L149;
        r36.resetVideoPlayState();
        ToastUtil.b("结束PK状态，可再次使用放映视频", 0);
        goto L149
    L139:
        r111 = r34;
    L135:
        r34 = 1;
    L40:
        r2.put("is_oncemore", DataType.FALSE);
        if (r1 != 2131364604) goto L43;
        String r37 = "reject";
    L44:
        r2.put("selection", r37);
        com.bytedance.android.livesdk.revenue.log.h r38 = com.bytedance.android.live.revenue.core.util.e.a(kr2.a.class).be();
        w31.c r39 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r39 == null) goto L47;
        int r40 = r39.a();
    L48:
        if (r40 <= 0) goto L54;
        LinkCrossRoomDataHolder r42 = this.R;
        if (r42 == null) goto L54;
        if (r42.i() != 0) goto L54;
        r38.c(this.w);
    L54:
        int r43 = UserListInviteType.a;
        LinkCrossRoomDataHolder r44 = this.R;
        if (r44 == null) goto L57;
        int r45 = r44.f();
    L58:
        r2.put("invitee_list", UserListInviteType.a(r45, null));
        r2.put("pk_description", "routine");
        r2.put("npk_link_type", "single");
        r2.put("invitee_connection_status", "live");
        i11.b r46 = com.bytedance.android.live.revlink.impl.global.b.e();
        if (r46 == null) goto L61;
        r2.put("anchor_connect_status", String.valueOf(r46.getOnlineUserList().size()));
    L62:
        r2.put("anchor_connection_type", "invite");
        r2.put("invitee_id", com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.user.a.class).getCurrentUserId());
        IBattleLinkerInviteMessageExtra r47 = this.L;
        if (r47 == null) goto L69;
        Intrinsics.checkNotNull(r47);
        if (TextUtils.isEmpty(r47.getRecommendReason()) == true) goto L67;
        String r48 = DataType.TRUE;
    L68:
        r2.put("with_audience", r48);
        goto L69
    L67:
        r48 = DataType.FALSE;
    L69:
        ea0(r2);
        IBattleLinkerInviteMessageExtra r49 = this.L;
        if (r49 == null) goto L74;
        Intrinsics.checkNotNull(r49);
        if (r49.getVoteSetting() == null) goto L74;
        r2.put("invite_mode", "vote");
    L75:
        IBattleRivalTag.a r50 = IBattleRivalTag.Companion;
        List<? extends IBattleRivalTag> r52 = this.y;
        Intrinsics.checkNotNull(r52);
        r50.getClass();
        IBattleRivalTag.a.a(r52, r2);
        IBattleLinkerInviteMessageExtra r53 = this.L;
        if (r53 == null) goto L80;
        IBattleConfigSetting r54 = r53.getBattleConfigSetting();
        if (r54 == null) goto L80;
        String r55 = r54.getActivityId();
    L81:
        if (r55 != null) goto L83;
    L85:
        r2.put("audience_connect_cnt", String.valueOf(com.bytedance.android.live.revenue.core.util.e.a(qr2.c.class).H()));
        i6 r56 = this.P;
        if (r56 == null) goto L93;
        Intrinsics.checkNotNull(r56);
        if (r56.getInvite() == null) goto L93;
        i6 r57 = this.P;
        Intrinsics.checkNotNull(r57);
        e6 r58 = r57.getInvite();
        Intrinsics.checkNotNull(r58);
        if (r58.getSupportMultiInvite() == false) goto L92;
        r2.put("support_multi_invite", DataType.TRUE);
        i6 r59 = this.P;
        Intrinsics.checkNotNull(r59);
        e6 r60 = r59.getInvite();
        Intrinsics.checkNotNull(r60);
        r2.put("invited_cnt", String.valueOf(r60.getCurInviteNum()));
        goto L93
    L92:
        r2.put("support_multi_invite", DataType.FALSE);
    L93:
        IBattleLinkerInviteMessageExtra r62 = this.L;
        if (r62 == null) goto L100;
        Intrinsics.checkNotNull(r62);
        if (r62.getBattleConfigSetting() == null) goto L100;
        IBattleLinkerInviteMessageExtra r63 = this.L;
        Intrinsics.checkNotNull(r63);
        IBattleConfigSetting r64 = r63.getBattleConfigSetting();
        Intrinsics.checkNotNull(r64);
        if (r64.getSpecifyGiftConfig() == null) goto L100;
        r2.put("invite_mode", "focus_gift");
        IBattleLinkerInviteMessageExtra r65 = this.L;
        Intrinsics.checkNotNull(r65);
        IBattleConfigSetting r66 = r65.getBattleConfigSetting();
        Intrinsics.checkNotNull(r66);
        c0.a(r66.getSpecifyGiftConfig(), r2);
    L100:
        q1.a(this.L, r2);
        IBaseUser r67 = this.m;
        if (r67 == null) goto L103;
        Intrinsics.checkNotNull(r67);
        r2.put("inviter_id", r67.getIdString().toString());
        IBaseUser r68 = this.m;
        Intrinsics.checkNotNull(r68);
        r2.put("inviter_room_id", String.valueOf(r68.getLiveRoomId()));
    L103:
        mz0.n r69 = new mz0.n();
        mz0.o r70 = new mz0.o(r69.a);
        r70.b(r2);
        e21.e.d(r70, e21.e.c(this.P));
        e21.c.e(r70, e21.c.a(this.P));
        mz0.m r72 = new mz0.m();
        r72.d(r38);
        com.bytedance.android.livesdk.revenue.log.i r73 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r73, "pageSourceLog");
        Intrinsics.checkNotNullParameter("live", "belong");
        r73.a("live");
        Intrinsics.checkNotNullParameter("other", "type");
        r73.d("other");
        ((ArrayList) r72.a).add(r73.a);
        LinkCrossRoomDataHolder.a r74 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r72);
        r72.b(LogCommon.ROOM);
        ((ArrayList) r69.b).addAll(r72.a);
        cy0.e.a.getClass();
        cy0.j r75 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r76 = com.bytedance.android.scope.m.b(r75).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r76);
        ((mz0.i) ((f80.a) r76)).w3("connection_invited", r69.a, r69.b);
        goto L105
    L83:
        if (r2.a(r55) != true) goto L85;
        r2.put("pk_activity_type", r55);
        r2.put("invite_mode", "activity_pk");
    L80:
        r55 = null;
    L74:
        r2.put("invite_mode", "routine_pk");
        goto L75
    L61:
        r2.put("anchor_connect_status", DataType.FALSE);
        goto L62
    L57:
        r45 = 0;
        goto L58
    L47:
        r40 = 0;
        goto L48
    L43:
        r37 = "accept";
    L11:
        LinkCrossRoomDataHolder r77 = this.R;
        if (r77 == null) goto L25;
        if (r77.i() != 1) goto L25;
        Map<? extends String, ? extends String> r78 = MapsKt.toMutableMap(r2);
        w31.c r112 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r112 == null) goto L18;
        String r113 = r112.l();
    L19:
        r78.put(FileUtils.PICTURE_THEME, r113);
        w31.c r79 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r79 == null) goto L22;
        Integer r80 = Integer.valueOf(r79.a());
    L23:
        r78.put("pk_time", String.valueOf(r80));
        mz0.n r82 = new mz0.n();
        Map<String, String> r83 = r82.a;
        Intrinsics.checkNotNullParameter(r83, "map");
        Intrinsics.checkNotNullParameter(r78, "map");
        r83.putAll(r78);
        mz0.m r84 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r85 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r85, "pageSourceLog");
        Intrinsics.checkNotNullParameter("live", "belong");
        r85.a("live");
        Intrinsics.checkNotNullParameter("other", "type");
        r85.d("other");
        ((ArrayList) r84.a).add(r85.a);
        ((ArrayList) r82.b).addAll(r84.a);
        cy0.e.a.getClass();
        cy0.j r86 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r87 = com.bytedance.android.scope.m.b(r86).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r87);
        ((mz0.i) ((f80.a) r87)).w3("random_match_cancel", r82.a, r82.b);
        goto L25
    L22:
        r80 = null;
        goto L23
    L18:
        r113 = "";
        goto L19
    }

    public static final void da0(InteractPKBeInviteFragment r2, boolean r3) {
        r2.getClass();
        HashMap r4 = new HashMap();
        if (r3 == false) goto L5;
        String r5 = "confirm";
    L6:
        r4.put("button_clicked", r5);
        r4.put("end_reason", "anchor_pk");
        mz0.n r6 = new mz0.n();
        Map<String, String> r0 = r6.a;
        Intrinsics.checkNotNullParameter(r0, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r0.putAll(r4);
        mz0.m r7 = new mz0.m();
        r7.b(LogCommon.ROOM);
        r7.b(LogCommon.GAME_PARAM_ITEM);
        List<Object> r1 = r6.b;
        ArrayList r8 = (ArrayList) r1;
        r8.addAll(r7.a);
        cy0.e.a.getClass();
        cy0.j r9 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r10 = com.bytedance.android.scope.m.b(r9).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r10);
        ((mz0.i) ((f80.a) r10)).w3("livesdk_little_game_share_screen_switch_to_interact", r6.a, r6.b);
        return;
    L5:
        r5 = "cancel";
        goto L6
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.room.a.class).checkDegradeForNative("anchor_invited_panel");
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final View onCreateView(LayoutInflater r18, ViewGroup r19, Bundle r20) {
        Intrinsics.checkNotNullParameter(r18, "inflater");
        View r1 = r18.inflate(2131565693, r19, false);
        this.i = (ViewGroup) r1.findViewById(2131389643);
        this.j = (ViewGroup) r1.findViewById(2131378740);
        TextView r2 = (TextView) r1.findViewById(2131391715);
        this.k = (TextView) r1.findViewById(2131364604);
        this.p = (TextView) r1.findViewById(2131364592);
        this.q = (FrameLayout) r1.findViewById(2131383667);
        this.r = r1.findViewById(2131383666);
        this.s = (TextView) r1.findViewById(2131383668);
        this.z = r1.findViewById(2131389650);
        this.A = r1.findViewById(2131374680);
        VHeadView r3 = r1.findViewById(2131389610);
        this.M = r1.findViewById(2131378616);
        this.F = r1.findViewById(2131383682);
        this.G = r1.findViewById(2131383683);
        this.H = (TextView) r1.findViewById(2131383663);
        this.I = r1.findViewById(2131385654);
        this.J = r1.findViewById(2131374268);
        VHeadView r4 = r1.findViewById(2131375624);
        TextView r5 = (TextView) r1.findViewById(2131390820);
        TextView r6 = (TextView) r1.findViewById(2131389608);
        TextView r7 = (TextView) r1.findViewById(2131389609);
        ImageView r8 = (ImageView) r1.findViewById(2131389458);
        TextView r9 = (TextView) r1.findViewById(2131390819);
        TextView r10 = (TextView) r1.findViewById(2131383050);
        this.K = (LinearLayout) r1.findViewById(2131378739);
        this.D = r1.findViewById(2131377500);
        this.E = (TextView) r1.findViewById(2131391251);
        this.g = (PkTagsContainerView) r1.findViewById(2131392084);
        this.t = r1.findViewById(2131389477);
        this.Q = (TextView) r1.findViewById(2131392794);
        TextView r12 = this.k;
        if (r12 == null) goto L5;
        r12.setOnClickListener(this);
    L5:
        TextView r13 = this.p;
        if (r13 == null) goto L9;
        r13.setOnClickListener(this);
    L9:
        if (com.bytedance.android.live.revlink.impl.global.b.N() == null) goto L15;
        com.bytedance.android.live.revlink.impl.pk.service.b r14 = com.bytedance.android.live.revlink.impl.global.b.N();
        Intrinsics.checkNotNull(r14);
        this.S = r14.getLinkUserCenter();
        i6 r15 = this.P;
        Intrinsics.checkNotNull(r15);
        e6 r16 = r15.getInvite();
        Intrinsics.checkNotNull(r16);
        if (r16.getSupportMultiInvite() == false) goto L15;
        i6 r17 = this.P;
        Intrinsics.checkNotNull(r17);
        e6 r110 = r17.getInvite();
        Intrinsics.checkNotNull(r110);
        if (r110.getCurInviteNum() <= 1) goto L15;
        i11.b r111 = this.S;
        Intrinsics.checkNotNull(r111);
        r111.b(4, "show_be_invited_applied_dialog");
    L15:
        IBattleLinkerInviteMessageExtra r112 = this.L;
        if (r112 == null) goto L33;
        Intrinsics.checkNotNull(r112);
        if (r112.getActivityName() == null) goto L33;
        IBattleLinkerInviteMessageExtra r113 = this.L;
        Intrinsics.checkNotNull(r113);
        if (r113.getActivityName().length() != 0) goto L22;
        boolean r114 = true;
    L23:
        if (r114 == true) goto L33;
        IBattleLinkerInviteMessageExtra r115 = this.L;
        Intrinsics.checkNotNull(r115);
        if (r115.getActivityUser() == null) goto L33;
        IBattleLinkerInviteMessageExtra r116 = this.L;
        Intrinsics.checkNotNull(r116);
        n0 r117 = r116.getActivityUser();
        Intrinsics.checkNotNull(r117);
        ArrayList r118 = new ArrayList(r117.getLabelList());
        List<? extends IBattleRivalTag> r119 = this.y;
        if (r119 == null) goto L31;
        Intrinsics.checkNotNull(r119);
        r118.addAll(r119);
        List<? extends IBattleRivalTag> r120 = this.y;
        Intrinsics.checkNotNull(r120);
        if (r120.isEmpty() == true) goto L31;
        PkTagsContainerView r121 = this.g;
        Intrinsics.checkNotNull(r121);
        r121.setVisibility(0);
    L31:
        PkTagsContainerView r122 = this.g;
        Intrinsics.checkNotNull(r122);
        r122.a(r118, this.v);
    L38:
        IBattleLinkerInviteMessageExtra r123 = this.L;
        if (r123 == null) goto L41;
        Intrinsics.checkNotNull(r123);
        List r124 = r123.getSemiFriendTags();
    L42:
        if (r124 != null) goto L44;
    L50:
        IBattleLinkerInviteMessageExtra r22 = this.L;
        if (r22 == null) goto L57;
        Intrinsics.checkNotNull(r22);
        if (TextUtils.isEmpty(r22.getRecommendReason()) == true) goto L57;
        TextView r23 = this.E;
        if (r23 == null) goto L60;
        Intrinsics.checkNotNull(r23);
        r23.setVisibility(0);
        TextView r24 = this.E;
        Intrinsics.checkNotNull(r24);
        IBattleLinkerInviteMessageExtra r125 = this.L;
        Intrinsics.checkNotNull(r125);
        r24.setText(r125.getRecommendReason());
    L60:
        TextView r25 = this.E;
        Intrinsics.checkNotNull(r25);
        r25.setVisibility(8);
        IBaseUser r26 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.user.a.class).b();
        if (r26 != null) goto L63;
    L65:
        boolean r27 = false;
    L66:
        if (r27 == false) goto L79;
        r10.setVisibility(0);
        String r28 = f51.a.e.a();
        if (TextUtils.isEmpty(r28) == false) goto L70;
    L78:
        int r126 = 0;
    L80:
        ConstraintLayout r29 = this.t;
        if (r29 == null) goto L83;
        r29.setVisibility(r126);
    L83:
        IBaseUser r30 = this.m;
        if (r30 == null) goto L93;
        Intrinsics.checkNotNull(r30);
        a1.x(r3, r30.getAvatarThumbKt(), r3.getWidth(), r3.getHeight(), 2131250965);
        IBaseUser r32 = this.m;
        Intrinsics.checkNotNull(r32);
        r5.setText(s21.c.a(r32.getNickName(), 20));
        r4.setVisibility(0);
        IBaseUser r33 = this.m;
        Intrinsics.checkNotNull(r33);
        if (r33.getGender() != 1) goto L88;
        r4.setImageResource(2131250688);
        goto L93
    L88:
        IBaseUser r34 = this.m;
        Intrinsics.checkNotNull(r34);
        if (r34.getGender() != 2) goto L91;
        r4.setImageResource(2131250687);
        goto L93
    L91:
        r4.setVisibility(8);
    L93:
        if (this.v == null) goto L118;
        w31.c r35 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r35 == null) goto L97;
        int r36 = r35.a();
    L98:
        if (r36 <= 0) goto L118;
        r6.setVisibility(0);
        Context r37 = getContext();
        if (r37 == null) goto L104;
        Resources r38 = r37.getResources();
        if (r38 == null) goto L104;
        IRoom r39 = this.v;
        Intrinsics.checkNotNull(r39);
        CharSequence r40 = r38.getString(2131917965, new Object[]{IESUIUtils.getDisplayCountChinese(r39.getUserCount())});
    L105:
        r6.setText(r40);
        d51.c r42 = d51.c.A0;
        r42.getClass();
        if (((Boolean) d51.c.c0.getValue(r42, d51.c.a[53])).booleanValue() == false) goto L118;
        IBaseUser r43 = this.m;
        if (r43 == null) goto L118;
        Intrinsics.checkNotNull(r43);
        if (r43.getFollowInfo() == null) goto L118;
        r7.setVisibility(0);
        Object[] r44 = new Object[1];
        IBaseUser r45 = this.m;
        if (r45 == null) goto L116;
        py.j r46 = r45.getFollowInfo();
        if (r46 == null) goto L116;
        long r127 = r46.getFollowerCount();
    L117:
        r44[0] = IESUIUtils.getDisplayCount(r127, "w");
        r7.setText(s1.C(2131914749, r44));
    L116:
        r127 = 0;
    L104:
        r40 = null;
        goto L105
    L97:
        r36 = 0;
    L118:
        m4 r47 = this.x;
        if (r47 == null) goto L165;
        Intrinsics.checkNotNull(r47);
        if (r47.getTextType() == IRivalExtraInfo.TextType.Distance.ordinal()) goto L131;
        m4 r48 = this.x;
        Intrinsics.checkNotNull(r48);
        if (r48.getTextType() == IRivalExtraInfo.TextType.DistanceCity.ordinal()) goto L131;
        View r49 = this.z;
        if (r49 == null) goto L128;
        r49.setVisibility(8);
    L128:
        View r50 = this.A;
        if (r50 == null) goto L138;
        r50.setVisibility(0);
    L138:
        m4 r52 = this.x;
        Intrinsics.checkNotNull(r52);
        if (r52.getText() == null) goto L146;
        m4 r53 = this.x;
        Intrinsics.checkNotNull(r53);
        if (r53.getText().length() != 0) goto L143;
        boolean r54 = true;
    L144:
        if (r54 == true) goto L146;
        r9.setVisibility(0);
        m4 r55 = this.x;
        Intrinsics.checkNotNull(r55);
        r9.setText(r55.getText());
    L150:
        IBattleLinkerInviteMessageExtra r56 = this.L;
        Intrinsics.checkNotNull(r56);
        if (r56.getVoteSetting() == null) goto L162;
        TextView r57 = this.E;
        if (r57 == null) goto L155;
        r57.setVisibility(8);
    L155:
        TextView r58 = this.Q;
        if (r58 == null) goto L158;
        IBattleLinkerInviteMessageExtra r59 = this.L;
        Intrinsics.checkNotNull(r59);
        aa r60 = r59.getVoteSetting();
        Intrinsics.checkNotNull(r60);
        boolean r62 = false;
        r58.setText(s1.C(2131918096, new Object[]{r60.getVoteDes()}));
    L159:
        TextView r63 = this.Q;
        if (r63 == null) goto L166;
        r63.setVisibility(r62 ? 1 : 0);
    L166:
        this.d.F4(r62);
        v3 r64 = e21.e.c(this.P);
        p0 r65 = e21.c.a(this.P);
        i6 r66 = this.P;
        if (r66 == null) goto L171;
        e6 r67 = r66.getInvite();
        if (r67 == null) goto L171;
        String r68 = r67.getEventTrackingInfo();
    L172:
        LinkedHashMap r69 = new LinkedHashMap();
        IBattleRivalTag.a r70 = IBattleRivalTag.Companion;
        List<? extends IBattleRivalTag> r72 = this.y;
        Intrinsics.checkNotNull(r72);
        r70.getClass();
        IBattleRivalTag.a.a(r72, r69);
        IBaseUser r73 = this.m;
        if (r73 == null) goto L175;
        Intrinsics.checkNotNull(r73);
        r69.put("inviter_id", r73.getIdString().toString());
        IBaseUser r74 = this.m;
        Intrinsics.checkNotNull(r74);
        r69.put("inviter_room_id", String.valueOf(r74.getLiveRoomId()));
        r69.put("inviter_room_status", "live");
        r69.put("inviter_connect_cnt", "o");
    L175:
        IBaseUser r75 = this.l;
        if (r75 == null) goto L178;
        Intrinsics.checkNotNull(r75);
        r69.put("invitee_id", r75.getIdString().toString());
    L178:
        int r76 = UserListInviteType.a;
        LinkCrossRoomDataHolder r77 = this.R;
        if (r77 == null) goto L181;
        int r78 = r77.f();
    L182:
        r69.put("invitee_list", UserListInviteType.a(r78, null));
        r69.put("is_oncemore", DataType.FALSE);
        r69.put("pk_description", "routine");
        r69.put("npk_link_type", "single");
        r69.put("invitee_connection_status", "live");
        r69.put("anchor_connect_status", DataType.TRUE);
        r69.put("anchor_connection_type", "invite");
        r69.put("source", "pk_banner");
        r69.put("invite_type", "anchor");
        ea0(r69);
        IBattleLinkerInviteMessageExtra r79 = this.L;
        if (r79 == null) goto L187;
        IBattleConfigSetting r80 = r79.getBattleConfigSetting();
        if (r80 == null) goto L187;
        String r82 = r80.getActivityId();
    L189:
        if (r82 != null) goto L191;
    L193:
        IBattleLinkerInviteMessageExtra r83 = this.L;
        if (r83 == null) goto L203;
        Intrinsics.checkNotNull(r83);
        if (r83.getBattleConfigSetting() == null) goto L203;
        IBattleLinkerInviteMessageExtra r84 = this.L;
        Intrinsics.checkNotNull(r84);
        IBattleConfigSetting r85 = r84.getBattleConfigSetting();
        Intrinsics.checkNotNull(r85);
        if (r85.getShellConfig() == null) goto L203;
        IBattleLinkerInviteMessageExtra r86 = this.L;
        Intrinsics.checkNotNull(r86);
        IBattleConfigSetting r87 = r86.getBattleConfigSetting();
        Intrinsics.checkNotNull(r87);
        w2 r88 = r87.getShellConfig();
        Intrinsics.checkNotNull(r88);
        if (r88.getType() <= 0) goto L203;
        r69.put("invite_mode", "compete");
    L203:
        if (fa0() <= 0) goto L205;
        r69.put("room_status", "audience_connection");
    L206:
        r69.put("if_strategy_invite", DataType.FALSE);
        r69.put("audience_connect_cnt", String.valueOf(fa0()));
        w31.c r89 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r89 == null) goto L209;
        Long r128 = Long.valueOf(r89.i());
    L210:
        r69.put("pk_id", String.valueOf(r128));
        q1.a(this.L, r69);
        if (r68 == null) goto L215;
        Map<String, String> r90 = h41.h.a(r68);
        if (r90 == null) goto L215;
        r69.putAll(r90);
    L215:
        mz0.n r92 = new mz0.n();
        mz0.o r93 = new mz0.o(r92.a);
        r93.b(r69);
        e21.e.d(r93, r64);
        e21.c.e(r93, r65);
        mz0.m r94 = new mz0.m();
        r94.b(LogCommon.PAGE_SOURCE_LOG);
        r94.b(LogCommon.ROOM);
        ((ArrayList) r92.b).addAll(r94.a);
        cy0.e.a.getClass();
        cy0.j r95 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r96 = com.bytedance.android.scope.m.b(r95).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r96);
        ((mz0.i) ((f80.a) r96)).w3("livesdk_connection_invited_page_show", r92.a, r92.b);
        x31.f r97 = (x31.f) this.f;
        d51.c r98 = d51.c.A0;
        r98.getClass();
        r97.h(((Number) d51.c.b0.getValue(r98, d51.c.a[52])).intValue());
        this.O = false;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r99 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r99 == null) goto L218;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r99.c = "";
    L218:
        IRoom r100 = this.C;
        if (r100 != null) goto L221;
    L225:
        IBattleLinkerInviteMessageExtra r101 = this.L;
        if (r101 == null) goto L230;
        m1 r102 = r101.getRankSeasonInfo();
        if (r102 == null) goto L230;
        py.k r129 = r102.getRankAFrame();
    L232:
        if (UtilityKotlinExtentionsKt.n(r129) == true) goto L239;
        ImageLoader.bindImage(this.F, r129);
        HSImageView r103 = this.F;
        if (r103 == null) goto L236;
        ViewUtilsKt.g(r103, true);
    L236:
        View r104 = this.J;
        a5 r130 = null;
        if (r104 == null) goto L245;
        r104.setBackground(null);
    L245:
        IBattleLinkerInviteMessageExtra r105 = this.L;
        if (r105 == null) goto L288;
        l1 r106 = r105.getAcceptTip();
        if (r106 == null) goto L288;
        FrameLayout r107 = this.q;
        if (r107 == null) goto L252;
        UtilityKotlinExtentionsKt.w(r107);
    L252:
        ImageUtil.loadImage(this.r, r106.getBgImage(), 0);
        TextView r108 = this.s;
        if (r108 == null) goto L288;
        ur2.a r109 = vh6.c.b(ur2.a.class);
        List r131 = r106.getContent();
        if (r131 != null) goto L257;
    L259:
        StringBuilder r132 = new StringBuilder();
        b5 r133 = vh7.f.c(b5.class);
        ArrayList r134 = new ArrayList();
        if (r131 == null) goto L286;
        Iterator r135 = r131.iterator();
        int r136 = 0;
    L263:
        if (r135.hasNext() == false) goto L286;
        IRichText r137 = (IRichText) r135.next();
        int r138 = r137.getType();
        if (r138 == RichTextType.RichTextTypeText.getValue()) goto L266;
        if (r138 != RichTextType.RichTextTypeImg.getValue()) goto L263;
        py.k r139 = r137.getImg();
        if (r139 == null) goto L263;
        r132.append("{" + r136 + ":image}");
        c5 r140 = vh7.f.c(c5.class);
        c5 r141 = r140;
        r141.setType(15);
        ITextPieceImage r142 = vh7.f.c(ITextPieceImage.class);
        r142.setImageModel(r139);
        Unit r143 = Unit.INSTANCE;
        r141.setImageValue(r142);
        r134.add(r140);
        r136 = r136 + 1;
        goto L263
    L266:
        String r144 = r137.getFontColor();
        Intrinsics.checkNotNull(r144);
        r133.setColor(r144);
        Long r145 = Long.valueOf(r137.getFontSize());
        if (r145 != null) goto L269;
    L272:
        int r146 = 13;
    L273:
        r133.setFontSize(r146);
        Long r147 = Long.valueOf(r137.getWeight());
        if (r147 != null) goto L276;
    L279:
        int r148 = 500;
    L280:
        r133.setWeight(r148);
        r132.append(r137.getText());
        goto L263
    L276:
        if (((int) r147.longValue()) <= 0) goto L279;
        r148 = (int) r147.longValue();
        goto L280
    L269:
        if (((int) r145.longValue()) <= 0) goto L272;
        r146 = (int) r145.longValue();
    L286:
        a5 r149 = vh7.f.c(a5.class);
        r149.setDefaultPattern(r132.toString());
        r149.setDefaultFormat(r133);
        r149.setPieces(r134);
    L287:
        r108.setText(r109.Lf(r149, ""));
        goto L288
    L257:
        if ((!r131.isEmpty()) == true) goto L259;
        r149 = r130;
    L288:
        View r150 = this.I;
        if (r150 == null) goto L298;
        IBattleLinkerInviteMessageExtra r151 = this.L;
        if (r151 == null) goto L293;
        a5 r152 = r151.getRankSeasonInfo();
    L294:
        if (r152 == null) goto L296;
        boolean r153 = true;
    L297:
        ViewUtilsKt.g(r150, r153);
        goto L298
    L296:
        r153 = false;
        goto L297
    L293:
        r152 = r130;
    L298:
        IBattleLinkerInviteMessageExtra r154 = this.L;
        if (r154 == null) goto L303;
        m1 r155 = r154.getRankSeasonInfo();
        if (r155 == null) goto L303;
        a5 r156 = r155.getRankBadge();
    L305:
        if (UtilityKotlinExtentionsKt.n(r156) == true) goto L309;
        ImageLoader.bindImage(this.G, r156);
        HSImageView r157 = this.G;
        if (r157 == null) goto L312;
        ViewUtilsKt.g(r157, true);
    L312:
        IBattleLinkerInviteMessageExtra r158 = this.L;
        if (r158 == null) goto L317;
        m1 r159 = r158.getRankSeasonInfo();
        if (r159 == null) goto L317;
        a5 r160 = r159.getRankDetail();
    L318:
        if (r160 != null) goto L320;
    L323:
        boolean r161 = true;
    L324:
        if (r161 == true) goto L331;
        TextView r162 = this.H;
        if (r162 == null) goto L328;
        r162.setText(r160);
    L328:
        TextView r163 = this.H;
        if (r163 == null) goto L334;
        ViewUtilsKt.g(r163, true);
    L334:
        return r1;
    L331:
        TextView r164 = this.H;
        if (r164 == null) goto L334;
        ViewUtilsKt.g(r164, false);
        goto L334
    L320:
        if (r160.length() == 0) goto L323;
        r161 = false;
    L317:
        r160 = r130;
        goto L318
    L309:
        HSImageView r165 = this.G;
        if (r165 == null) goto L312;
        ViewUtilsKt.g(r165, false);
    L303:
        r156 = r130;
        goto L305
    L239:
        r130 = null;
        HSImageView r166 = this.F;
        if (r166 == null) goto L242;
        ViewUtilsKt.g(r166, false);
    L242:
        View r167 = this.J;
        if (r167 == null) goto L245;
        r167.setBackgroundResource(2131249469);
    L230:
        r129 = null;
        goto L232
    L221:
        if (r100.isLiveTypeAudio() == true) goto L225;
        p11.d r168 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo469getPerfManager();
        if (r168 == null) goto L225;
        r168.b();
        goto L225
    L209:
        r128 = null;
        goto L210
    L205:
        r69.put("room_status", "live");
        goto L206
    L191:
        if (r2.a(r82) != true) goto L193;
        r69.put("pk_activity_type", r82);
        r69.put("invite_mode", "activity_pk");
    L187:
        r82 = null;
        goto L189
    L181:
        r78 = 0;
    L171:
        r68 = null;
        goto L172
    L158:
        r62 = false;
        goto L159
    L162:
        r62 = false;
        r62 = false;
        TextView r169 = this.Q;
        if (r169 == null) goto L166;
        r169.setVisibility(8);
        goto L166
    L143:
        r54 = false;
    L146:
        View r170 = this.A;
        if (r170 == null) goto L149;
        r170.setVisibility(8);
    L149:
        r9.setVisibility(8);
    L131:
        m4 r171 = this.x;
        Intrinsics.checkNotNull(r171);
        if (r171.getText() == null) goto L138;
        m4 r172 = this.x;
        Intrinsics.checkNotNull(r172);
        if (r172.getText().length() <= 0) goto L138;
        View r173 = this.z;
        if (r173 == null) goto L138;
        r173.setVisibility(0);
        goto L138
    L165:
        r62 = false;
        r9.setVisibility(8);
        goto L166
    L70:
        if (getContext() == null) goto L78;
        StringCompanionObject r174 = StringCompanionObject.INSTANCE;
        Object[] r175 = new Object[1];
        Context r176 = getContext();
        if (r176 == null) goto L76;
        Resources r177 = r176.getResources();
        if (r177 == null) goto L76;
        Object r178 = r177.getString(2131914452);
    L77:
        r126 = 0;
        r175[0] = r178;
        r10.setText(String.format(r28, Arrays.copyOf(r175, 1)));
    L76:
        r178 = null;
        goto L77
    L79:
        r126 = 0;
        r10.setVisibility(8);
        goto L80
    L63:
        if (r26.getSecret() != 1) goto L65;
        r27 = true;
    L57:
        TextView r179 = this.E;
        if (r179 == null) goto L60;
        Intrinsics.checkNotNull(r179);
        r179.setVisibility(8);
        goto L60
    L44:
        if (r124.isEmpty() == true) goto L50;
        LinearLayout r180 = this.K;
        Intrinsics.checkNotNull(r180);
        Context r181 = r180.getContext();
        Iterator r182 = r124.iterator();
    L48:
        if (r182.hasNext() == false) goto L50;
        IBattleRivalTag r183 = (IBattleRivalTag) r182.next();
        View r184 = new View(r181);
        r184.setBackgroundColor(ColorProtector.parseColor("#D9D9D9"));
        LinearLayout.LayoutParams r185 = new LinearLayout.LayoutParams(s1.f(1.0f), s1.f(7.0f));
        r185.leftMargin = s1.f(4.0f);
        LinearLayout r186 = this.K;
        Intrinsics.checkNotNull(r186);
        r186.addView(r184, r185);
        TextView r187 = new TextView(r181);
        r187.setTextAppearance(r181, 2131954695);
        r187.setText(r183.getContent());
        r187.setTextColor(ColorProtector.parseColor("#FE2C55"));
        r187.setTextSize(1, 12.0f);
        LinearLayout.LayoutParams r188 = new LinearLayout.LayoutParams(-2, -2);
        r188.leftMargin = s1.f(4.0f);
        LinearLayout r189 = this.K;
        Intrinsics.checkNotNull(r189);
        r189.addView(r187, r188);
        goto L48
    L41:
        r124 = null;
        goto L42
    L22:
        r114 = false;
    L33:
        if (this.y == null) goto L38;
        PkTagsContainerView r190 = this.g;
        Intrinsics.checkNotNull(r190);
        r190.setOldTag(true);
        List<? extends IBattleRivalTag> r191 = this.y;
        Intrinsics.checkNotNull(r191);
        if (r191.isEmpty() == true) goto L37;
        PkTagsContainerView r192 = this.g;
        Intrinsics.checkNotNull(r192);
        r192.setVisibility(0);
    L37:
        PkTagsContainerView r193 = this.g;
        Intrinsics.checkNotNull(r193);
        r193.a(this.y, this.v);
        goto L38
    }
}
