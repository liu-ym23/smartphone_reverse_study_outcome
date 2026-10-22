package com.bytedance.android.live.revlink.impl.pk.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkReserveBattleDataContext;
import com.bytedance.android.livesdk.link.model.l2;
import com.bytedance.android.livesdk.link.model.v4;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.c5;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/PkReserverSettleDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkReserverSettleDialog extends CommonBottomDialog {
    public static final /* synthetic */ int e = 0;
    public final CompositeDisposable a;
    public final a b;
    public final l2 c;
    public final PkReserveBattleDataContext d;

    public static final class a extends com.bytedance.android.live.revenuelink.connect.d {
        public final /* synthetic */ PkReserverSettleDialog a;

        public a(PkReserverSettleDialog r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void hl(d11.d r2, long r3, v4 r5, ey.l r6) {
            Intrinsics.checkNotNullParameter(r2, "params");
            Intrinsics.checkNotNullParameter(r5, "inviteResult");
            super.hl(r2, r3, r5, r6);
            LinkedHashMap r4 = new LinkedHashMap();
            r4.put("btn_type", "pk_invite");
            r4.put("invite_success", DataType.TRUE);
            PkReserverSettleDialog r7 = this.a;
            int r8 = PkReserverSettleDialog.e;
            r7.N0("livesdk_pk_invite_remind_popup_click", r4);
            PkReserverSettleDialog.M0(this.a, ReplyStatus.Accept);
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void rp(d11.d r1, Throwable r2, long r3, ey.l.b r5) {
            Intrinsics.checkNotNullParameter(r1, "params");
            Intrinsics.checkNotNullParameter(r1, "params");
            LinkedHashMap r4 = new LinkedHashMap();
            r4.put("btn_type", "pk_invite");
            r4.put("invite_success", DataType.FALSE);
            PkReserverSettleDialog r6 = this.a;
            int r7 = PkReserverSettleDialog.e;
            r6.N0("livesdk_pk_invite_remind_popup_click", r4);
            this.a.getClass();
            LinkedHashMap r8 = new LinkedHashMap();
            if (r2 == null) goto L6;
            String r9 = String.valueOf(c5.a(r2));
            if (r9 == null) goto L6;
        L7:
            r8.put("error_code", r9);
            i97.a r10 = i97.a.a;
            r8.put("time_stamp", String.valueOf(System.currentTimeMillis()));
            r8.put("inviter_id", String.valueOf(r1.f));
            com.bytedance.android.live.revlink.impl.global.c r12 = com.bytedance.android.live.revlink.impl.global.b.k();
            if (r12 == null) goto L12;
            LiveFullLinkPKMonitor r13 = r12.getLiveFullLinkPKMonitor();
            if (r13 == null) goto L12;
            LiveFullLinkPKMonitor.t(r13, "track_pk_invite_remind_popup_invite_fail", null, r8, 2);
        L12:
            PkReserverSettleDialog.M0(this.a, ReplyStatus.Accept);
            return;
        L6:
            r9 = "";
            goto L7
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ PkReserverSettleDialog a;

        public b(PkReserverSettleDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r39) {
            PkReserverSettleDialog r1 = this.a;
            int r2 = PkReserverSettleDialog.e;
            r1.getClass();
            long r5 = r1.c.getFromRoomId();
            long r7 = r1.c.getToRoomId();
            String r12 = r1.c.getToRoom().getAnchorId();
            IBaseUser r3 = r1.c.getToRoom().getOwner();
            if (r3 == null) goto L5;
            Intrinsics.checkNotNullParameter(r3, "$this$secUidExt");
            String r37 = r3.getCastSecUid();
        L6:
            IRoom r13 = r1.c.getToRoom();
            int r14 = BizType.PK.ordinal();
            String r26 = r1.c.getBattleAttachedInfo();
            String r15 = r37;
            d11.d r4 = new d11.d(1, r5, r7, 1, 0, r12, r15, r13, r14, l51.a.m(), l51.a.j(), null, 0, 0, null, 0, null, null, null, r26, 0, 0, 0, null, null, null, null, null, 536344576);
            com.bytedance.android.live.revlink.impl.pk.service.b r6 = com.bytedance.android.live.revlink.impl.global.b.N();
            if (r6 == null) goto L11;
            com.bytedance.android.live.revenuelink.connect.n r8 = r6.getLinkOutManagerFn();
            if (r8 == null) goto L11;
            r8.d(r4, null);
        L11:
            LinkedHashMap r9 = new LinkedHashMap();
            r9.put("is_oncemore", DataType.FALSE);
            r9.put("invitee_list", "mutual_follow");
            r9.put("connection_type", "manaul_pk");
            r9.put("is_recommend_list", DataType.FALSE);
            IRoom r10 = r1.c.getToRoom();
            if (r10 == null) goto L16;
            String r16 = r10.getAnchorId();
            if (r16 == null) goto L16;
        L17:
            r9.put("invitee_id", r16);
            r9.put("from_room_status", "live");
            r9.put("invite_mode", "routine_pk");
            com.bytedance.android.live.revlink.impl.global.c r17 = com.bytedance.android.live.revlink.impl.global.b.k();
            if (r17 == null) goto L22;
            com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r18 = r17.getLinkOptLogContext();
            if (r18 == null) goto L22;
            Intrinsics.checkNotNullParameter("pk_invite_remind", "<set-?>");
            r18.c = "pk_invite_remind";
        L22:
            r9.put("anchor_connection_type", "invite");
            r9.put("invite_type", "anchor");
            r9.put("source", "pk_invite_remind");
            r9.put("anchor_connect_status", DataType.FALSE);
            r9.put("connection_sub_type", "");
            IRoom r19 = r1.c.getToRoom();
            if (r19 == null) goto L25;
            Long r110 = Long.valueOf(r19.getId());
        L26:
            r9.put("invitee_room_id", String.valueOf(r110.longValue()));
            com.bytedance.android.live.revlink.impl.global.c r0 = com.bytedance.android.live.revlink.impl.global.b.k();
            if (r0 == null) goto L35;
            w31.c r20 = r0.getPkLinkUtils();
            if (r20 == null) goto L35;
            IPKLinkBizDataService r22 = r20.g();
            if (r22 == null) goto L35;
            if (r22.getSelfHasAudienceBeforePk() == false) goto L35;
            String r23 = "audience_connection";
        L36:
            r9.put("room_status", r23);
            r9.put("is_random_match", DataType.FALSE);
            r9.put("invitee_room_status", "live");
            r9.put("invitee_connect_cnt", DataType.FALSE);
            r9.put("audience_connect_cnt", String.valueOf(n41.a.b()));
            mz0.n r24 = new mz0.n();
            Map<String, String> r25 = r24.a;
            Intrinsics.checkNotNullParameter(r25, "map");
            Intrinsics.checkNotNullParameter(r9, "map");
            r25.putAll(r9);
            mz0.m r27 = new mz0.m();
            com.bytedance.android.live.revlink.impl.global.c r28 = com.bytedance.android.live.revlink.impl.global.b.k();
            if (r28 == null) goto L41;
            LinkCrossRoomDataHolder r29 = r28.getLinkCrossRoomDataHolder();
            if (r29 == null) goto L41;
            r29.m(r27);
        L41:
            r27.b(LogCommon.ROOM);
            ((ArrayList) r24.b).addAll(r27.a);
            cy0.e.a.getClass();
            cy0.j r30 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r32 = com.bytedance.android.scope.m.b(r30).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r32);
            ((mz0.i) ((f80.a) r32)).w3("livesdk_connection_invite", r24.a, r24.b);
            return;
        L35:
            r23 = "live";
            goto L36
        L25:
            r110 = null;
        L16:
            r16 = "";
            goto L17
        L5:
            r37 = null;
            goto L6
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ PkReserverSettleDialog a;

        public c(PkReserverSettleDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            PkReserverSettleDialog.M0(this.a, ReplyStatus.Reject);
            LinkedHashMap r4 = new LinkedHashMap();
            r4.put("btn_type", "cancel");
            this.a.N0("livesdk_pk_invite_remind_popup_click", r4);
        }
    }

    public static final class d<T, R> implements Function {
        public final /* synthetic */ long a;

        public d(long r1) {
            this.a = r1;
        }

        public final Object apply(Object r5) {
            long r0 = ((Number) r5).longValue();
            return Long.valueOf(this.a - r0);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ PkReserverSettleDialog a;

        public e(PkReserverSettleDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            TextView r0 = (TextView) this.a.findViewById(2131390273);
            if (r0 == null) goto L6;
            r0.setText(s1.C(2131919642, new Object[]{String.valueOf(r6.longValue())}));
        L6:
            if (r6.longValue() > 0) goto L9;
            PkReserverSettleDialog.M0(this.a, ReplyStatus.RefuseByTimeOut);
            return;
        }
    }

    public final int getLayoutId() {
        return 2131566057;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        PkReserveBattleDataContext r0 = this.d;
        if (r0 == null) goto L5;
        r0.setBattleReserveState(PkReserveBattleDataContext.b.a.a);
    L5:
        Handler r1 = DialogLancet.resolveDialogHandler(this);
        if (r1 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(this);
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r2 == null) goto L19;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L8:
        if (Looper.myLooper() == r1.getLooper()) goto L10;
        r1.post(DialogLancet.createDismissRunnable(this));
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a.dispose();
        com.bytedance.android.live.revenuelink.connect.f r0 = com.bytedance.android.live.revlink.impl.global.b.a();
        if (r0 == null) goto L6;
        r0.removeLinkOutListener(1, this.b);
        return;
    }

    public final void onCreate(Bundle r9) {
        super.onCreate(r9);
        TextView r10 = (TextView) findViewById(2131391606);
        if (r10 == null) goto L5;
        r10.setText(this.c.getTips());
        r10.setTextColor(s1.h(2131107368));
    L5:
        View r12 = findViewById(2131391412);
        if (r12 == null) goto L8;
        r12.setVisibility(8);
    L8:
        View r13 = findViewById(2131392517);
        if (r13 == null) goto L11;
        r13.setVisibility(8);
    L11:
        IRoom r14 = this.c.getToRoom();
        if (r14 == null) goto L18;
        IBaseUser r15 = r14.getOwner();
        if (r15 == null) goto L18;
        ImageUtil.loadRoundImage((ImageView) findViewById(2131381573), r15.getAvatarThumbKt());
        TextView r0 = (TextView) findViewById(2131391035);
        if (r0 == null) goto L18;
        r0.setText(r15.getRealNickName());
    L18:
        Object[] r1 = new Object[1];
        l2 r2 = this.c;
        Long r3 = null;
        if (r2 == null) goto L23;
        IRoom r4 = r2.getToRoom();
        if (r4 == null) goto L23;
        Long r5 = Long.valueOf(r4.getUserCount());
    L24:
        r1[0] = Long.valueOf(r5.longValue());
        s1.C(2131917892, r1);
        ImageView r6 = (ImageView) findViewById(2131376014);
        if (r6 == null) goto L27;
        r6.setBackground(s1.m(2131252607));
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        r7.width = s1.f(16.0f);
        r7.height = s1.f(16.0f);
        r6.setLayoutParams(r7);
    L27:
        TextView r8 = (TextView) findViewById(2131391033);
        if (r8 == null) goto L33;
        Object[] r16 = new Object[1];
        IRoom r17 = this.c.getToRoom();
        if (r17 == null) goto L32;
        r3 = Long.valueOf(r17.getUserCount());
    L32:
        r16[0] = Long.valueOf(r3.longValue());
        r8.setText(s1.C(2131917965, r16));
    L33:
        LinearLayout r18 = (LinearLayout) findViewById(2131392032);
        if (r18 == null) goto L40;
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
        if (r19 == null) goto L39;
        ConstraintLayout.LayoutParams r20 = (ConstraintLayout.LayoutParams) r19;
        ((ViewGroup.MarginLayoutParams) r20).topMargin = s1.f(37.0f);
        r18.setLayoutParams(r20);
        goto L40
    L39:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L40:
        View r22 = findViewById(2131390810);
        if (r22 == null) goto L43;
        r22.setOnClickListener(new b(this));
    L43:
        View r23 = findViewById(2131390273);
        if (r23 == null) goto L46;
        r23.setOnClickListener(new c(this));
    L46:
        long r24 = this.c.getWaitSec();
        Disposable r25 = du2.a.b(0, 1, TimeUnit.SECONDS).take(1 + r24).map(new d(r24)).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this));
        if (r25 == null) goto L49;
        RxUtilKt.c(r25, this.a);
    L49:
        setCanceledOnTouchOutside(false);
        N0("livesdk_pk_invite_remind_popup_show", new LinkedHashMap());
        com.bytedance.android.live.revenuelink.connect.f r26 = com.bytedance.android.live.revlink.impl.global.b.a();
        if (r26 == null) goto L53;
        r26.addLinkOutListener(1, this.b);
        return;
    L53:
        return;
    L23:
        r5 = null;
        goto L24
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void M0(PkReserverSettleDialog r12, ReplyStatus r13) {
        r12.getClass();
        com.bytedance.android.live.revlink.impl.global.c r0 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r0 == null) goto L13;
        r31.a r1 = r0.getLinkNetwork();
        if (r1 == null) goto L13;
        Observable<ExtraResponse<Object, Extra>> r14 = r1.H(r13.getValue(), r12.c.getFromRoomId(), r12.c.getToUserId(), r12.c.getBattleAttachedInfo(), r12.c.getReserveId(), r12.c.getToOpenId(), r12.c.getToRoomId());
        if (r14 == null) goto L13;
        Observable r15 = r14.compose(RxUtil.rxSchedulerHelper());
        if (r15 == null) goto L13;
        Disposable r16 = r15.subscribe(o.a, p.a);
        if (r16 == null) goto L13;
        r12.a.add(r16);
    L13:
        Handler r17 = DialogLancet.resolveDialogHandler(r12);
        if (r17 != null) goto L16;
    L18:
        DialogLancet.beforeDialogDismiss(r12);
        r12.dismiss();     // Catch: Throwable -> L21 Exception -> L23
    L27:
        DialogLancet.afterDialogDismiss(r12);
        return;
    L21:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r12);
        throw th;
    L23:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L21
        Throwable r18 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L21
        if (r18 == null) goto L27;
        com.bytedance.crash.d.d(r18, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L21
        goto L27
    L16:
        if (Looper.myLooper() == r17.getLooper()) goto L18;
        r17.post(DialogLancet.createDismissRunnable(r12));
    }

    public final void N0(String r5, Map<String, String> r6) {
        com.bytedance.android.live.revenue.core.util.j.a r0 = com.bytedance.android.live.revenue.core.util.j.C0;
        yz0.k r1 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(r0.a(), yz0.k.class);
        String r2 = "";
        if (r1 == null) goto L8;
        IRoom r3 = r1.getRoom();
        if (r3 == null) goto L8;
        String r4 = r3.getAnchorId();
        if (r4 == null) goto L8;
    L9:
        r6.put("anchor_id", r4);
        yz0.k r7 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(r0.a(), yz0.k.class);
        if (r7 == null) goto L15;
        IRoom r8 = r7.getRoom();
        if (r8 == null) goto L15;
        String r9 = String.valueOf(r8.getId());
        if (r9 == null) goto L15;
    L16:
        r6.put("room_id", r9);
        r6.put("anchor_connect_status", DataType.FALSE);
        r6.put("request_id", "");
        r6.put("channel_id", "");
        r6.put("pk_id", DataType.FALSE);
        r6.put("right_user_status", "2");
        String r10 = this.c.getToRoom().getAnchorId();
        if (r10 == null) goto L20;
        r2 = r10;
    L20:
        r6.put("right_user_id", r2);
        r6.put("right_room_id", String.valueOf(this.c.getToRoom().getRoomId()));
        mz0.n r12 = new mz0.n();
        Map<String, String> r13 = r12.a;
        Intrinsics.checkNotNullParameter(r13, "map");
        Intrinsics.checkNotNullParameter(r6, "map");
        r13.putAll(r6);
        mz0.m r14 = new mz0.m();
        r14.b(LogCommon.ROOM);
        List<Object> r15 = r12.b;
        ArrayList r16 = (ArrayList) r15;
        r16.addAll(r14.a);
        cy0.e.a.getClass();
        cy0.j r17 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r18 = com.bytedance.android.scope.m.b(r17).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r18);
        ((mz0.i) ((f80.a) r18)).w3(r5, r12.a, r12.b);
        return;
    L15:
        r9 = "";
    L8:
        r4 = "";
        goto L9
    }

    public PkReserverSettleDialog(Context r2, l2 r3, PkReserveBattleDataContext r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "reserveSettleMessage");
        super(r2);
        this.c = r3;
        this.d = r4;
        this.a = new CompositeDisposable();
        this.b = new a(this);
    }
}
