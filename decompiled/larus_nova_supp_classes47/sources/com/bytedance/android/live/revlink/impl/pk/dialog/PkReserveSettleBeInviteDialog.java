package com.bytedance.android.live.revlink.impl.pk.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.FormatUtils;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.pk.ui.PkTagsContainerView;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkReserveBattleDataContext;
import com.bytedance.android.livesdk.link.model.i2;
import com.bytedance.android.livesdk.link.model.j2;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/PkReserveSettleBeInviteDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkReserveSettleBeInviteDialog extends CommonBottomDialog {
    public static final /* synthetic */ int e = 0;
    public final CompositeDisposable a;
    public boolean b;
    public final i2 c;
    public final PkReserveBattleDataContext d;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ PkReserveSettleBeInviteDialog a;

        public b(PkReserveSettleBeInviteDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            PkReserveSettleBeInviteDialog r4 = this.a;
            ReplyStatus r0 = ReplyStatus.Accept;
            int r1 = PkReserveSettleBeInviteDialog.e;
            r4.M0(r0, false);
            LinkedHashMap r5 = new LinkedHashMap();
            r5.put("selection", "accept");
            this.a.N0("livesdk_pk_invited_popup_click", r5);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ PkReserveSettleBeInviteDialog a;

        public c(PkReserveSettleBeInviteDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            PkReserveSettleBeInviteDialog r4 = this.a;
            ReplyStatus r0 = ReplyStatus.Reject;
            int r1 = PkReserveSettleBeInviteDialog.e;
            r4.M0(r0, false);
            LinkedHashMap r5 = new LinkedHashMap();
            r5.put("selection", "reject");
            this.a.N0("livesdk_pk_invited_popup_click", r5);
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
        public final /* synthetic */ PkReserveSettleBeInviteDialog a;

        public e(PkReserveSettleBeInviteDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            Long r8 = (Long) r7;
            TextView r0 = (TextView) this.a.findViewById(2131390273);
            if (r0 == null) goto L6;
            r0.setText(FormatUtils.format(s1.B(2131914778), new Object[]{Integer.valueOf((int) r8.longValue())}));
        L6:
            if (r8.longValue() > 0) goto L9;
            PkReserveSettleBeInviteDialog r9 = this.a;
            ReplyStatus r1 = ReplyStatus.RefuseByTimeOut;
            int r2 = PkReserveSettleBeInviteDialog.e;
            r9.M0(r1, false);
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ PkReserveSettleBeInviteDialog a;
        public final /* synthetic */ boolean b;

        public f(PkReserveSettleBeInviteDialog r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            ExtraResponse r5 = (ExtraResponse) r4;
            f2.c("回复成功", 0);
            PkReserveBattleDataContext r6 = this.a.d;
            if (r6 == null) goto L6;
            r6.setBattleReserveState(PkReserveBattleDataContext.b.a.a);
        L6:
            if (this.b == true) goto L24;
            CommonBottomDialog r7 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r7);
            if (r0 != null) goto L10;
        L12:
            DialogLancet.beforeDialogDismiss(r7);
            r7.dismiss();     // Catch: Throwable -> L15 Exception -> L17
        L21:
            DialogLancet.afterDialogDismiss(r7);
            return;
        L17:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
            if (r1 == null) goto L21;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r7);
            throw th;
        L10:
            if (Looper.myLooper() == r0.getLooper()) goto L12;
            r0.post(DialogLancet.createDismissRunnable(r7));
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ PkReserveSettleBeInviteDialog a;

        public g(PkReserveSettleBeInviteDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            f2.c("回复失败", 0);
            CommonBottomDialog r6 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r6));
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131566057;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.b == true) goto L5;
        M0(ReplyStatus.RefuseByTimeOut, true);
    L5:
        PkReserveBattleDataContext r0 = this.d;
        if (r0 == null) goto L8;
        r0.setBattleReserveState(PkReserveBattleDataContext.b.a.a);
    L8:
        this.a.dispose();
    }

    public final void onCreate(Bundle r12) {
        super.onCreate(r12);
        TextView r0 = (TextView) findViewById(2131391606);
        if (r0 == null) goto L5;
        r0.setText(this.c.getTips());
    L5:
        TextView r13 = (TextView) findViewById(2131391606);
        if (r13 == null) goto L8;
        r13.setTextColor(s1.h(2131107372));
    L8:
        View r14 = findViewById(2131391412);
        if (r14 == null) goto L11;
        r14.setVisibility(8);
    L11:
        View r15 = findViewById(2131392517);
        if (r15 == null) goto L14;
        r15.setVisibility(8);
    L14:
        View r16 = findViewById(2131369197);
        if (r16 == null) goto L17;
        r16.setBackground(s1.m(2131109391));
    L17:
        IRoom r17 = this.c.getInviteRoom();
        if (r17 == null) goto L24;
        IBaseUser r18 = r17.getOwner();
        if (r18 == null) goto L24;
        ImageUtil.loadRoundImage((ImageView) findViewById(2131381573), r18.getAvatarThumbKt());
        TextView r1 = (TextView) findViewById(2131391035);
        if (r1 == null) goto L24;
        r1.setText(r18.getRealNickName());
    L24:
        Object[] r2 = new Object[1];
        i2 r3 = this.c;
        if (r3 == null) goto L29;
        IRoom r4 = r3.getInviteRoom();
        if (r4 == null) goto L29;
        Long r5 = Long.valueOf(r4.getUserCount());
    L30:
        r2[0] = Long.valueOf(r5.longValue());
        s1.C(2131917892, r2);
        ImageView r6 = (ImageView) findViewById(2131376014);
        if (r6 == null) goto L33;
        r6.setBackground(s1.m(2131252607));
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        r7.width = s1.f(16.0f);
        r7.height = s1.f(16.0f);
        r6.setLayoutParams(r7);
    L33:
        TextView r8 = (TextView) findViewById(2131391033);
        if (r8 == null) goto L40;
        Object[] r9 = new Object[1];
        IRoom r10 = this.c.getInviteRoom();
        if (r10 == null) goto L38;
        Long r19 = Long.valueOf(r10.getUserCount());
    L39:
        r9[0] = Long.valueOf(r19.longValue());
        r8.setText(s1.C(2131917965, r9));
        goto L40
    L38:
        r19 = null;
    L40:
        PkTagsContainerView r20 = (PkTagsContainerView) findViewById(2131388092);
        if (r20 == null) goto L47;
        i2 r22 = this.c;
        if (r22 == null) goto L45;
        List r23 = r22.getTags();
    L46:
        PkTagsContainerView.f(r20, r23, false, null, 0, null, 56);
        goto L47
    L45:
        r23 = null;
    L47:
        TextView r24 = (TextView) findViewById(2131390810);
        if (r24 == null) goto L50;
        r24.setText("接受邀约");
        r24.setOnClickListener(new b(this));
    L50:
        View r25 = findViewById(2131390273);
        if (r25 == null) goto L53;
        r25.setBackground(s1.m(2131249706));
        r25.setOnClickListener(new c(this));
    L53:
        long r26 = this.c.getWaitSec();
        Disposable r27 = du2.a.b(0, 1, TimeUnit.SECONDS).take(1 + r26).map(new d(r26)).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this));
        if (r27 == null) goto L56;
        RxUtilKt.c(r27, this.a);
    L56:
        TextView r28 = (TextView) findViewById(2131391036);
        if (r28 == null) goto L75;
        i2 r29 = this.c;
        String r30 = "";
        if (r29 == null) goto L65;
        j2 r32 = r29.getOption();
        if (r32 == null) goto L65;
        String r33 = r32.getText();
        if (r33 == null) goto L65;
    L66:
        r28.setText(r33);
        r28.setTextColor(s1.h(2131108106));
        r28.setTextSize(15.0f);
        r28.setBackground(null);
        r28.setTypeface(null, 1);
        Object[] r110 = new Object[1];
        i2 r34 = this.c;
        if (r34 == null) goto L74;
        j2 r35 = r34.getOption();
        if (r35 == null) goto L74;
        String r36 = r35.getText();
        if (r36 == null) goto L74;
        r30 = r36;
    L74:
        r110[0] = r30;
        r28.setText(s1.C(2131921540, r110));
        r28.setVisibility(0);
    L65:
        r33 = "";
    L75:
        N0("livesdk_pk_invited_popup_show", new LinkedHashMap());
        return;
    L29:
        r5 = null;
        goto L30
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void M0(ReplyStatus r12, boolean r13) {
        if (this.b == false) goto L5;
        return;
    L5:
        this.b = true;
        com.bytedance.android.live.revlink.impl.global.c r0 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r0 == null) goto L34;
        r31.a r1 = r0.getLinkNetwork();
        if (r1 == null) goto L38;
        Observable<ExtraResponse<Object, Extra>> r14 = r1.F(r12.getValue(), this.c.getToRoomId(), String.valueOf(this.c.getFromUserId()), this.c.getFromRoomId(), this.c.getClientAttachedInfo(), this.c.getReserveId(), this.c.getFromOpenId());
        if (r14 == null) goto L39;
        Observable r15 = r14.compose(RxUtil.rxSchedulerHelper());
        if (r15 == null) goto L40;
        Disposable r16 = r15.subscribe(new f(this, r13), new g(this));
        if (r16 == null) goto L41;
        this.a.add(r16);
        if (r13 == true) goto L42;
        Handler r17 = DialogLancet.resolveDialogHandler(this);
        if (r17 != null) goto L20;
    L22:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L25 Exception -> L27
    L31:
        DialogLancet.afterDialogDismiss(this);
        return;
    L25:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L27:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L25
        Throwable r18 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L25
        if (r18 == null) goto L31;
        com.bytedance.crash.d.d(r18, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L25
        goto L31
    L20:
        if (Looper.myLooper() == r17.getLooper()) goto L22;
        r17.post(DialogLancet.createDismissRunnable(this));
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
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
        d31.d r10 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r10 == null) goto L20;
        String r12 = r10.a();
        if (r12 == null) goto L20;
    L21:
        r6.put("anchor_connect_status", r12);
        r6.put("request_id", "");
        com.bytedance.android.live.revlink.impl.global.c r13 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r13 == null) goto L29;
        com.bytedance.android.live.revenuelink.connect.g r14 = r13.getAnchorConnectUtils();
        if (r14 == null) goto L29;
        String r15 = String.valueOf(r14.getChannelId());
        if (r15 == null) goto L29;
        r2 = r15;
    L29:
        r6.put("channel_id", r2);
        com.bytedance.android.live.revlink.impl.global.c r16 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r16 == null) goto L35;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r17 = r16.Ig();
        if (r17 == null) goto L35;
        String r18 = String.valueOf(r17.getPkId());
        if (r18 == null) goto L35;
    L36:
        r6.put("pk_id", r18);
        r6.put("source", "live_room");
        r6.put("inviter_room_status", "2");
        r6.put("inviter_id", String.valueOf(this.c.getFromUserId()));
        r6.put("inviter_room_id", String.valueOf(this.c.getFromRoomId()));
        mz0.n r19 = new mz0.n();
        Map<String, String> r20 = r19.a;
        Intrinsics.checkNotNullParameter(r20, "map");
        Intrinsics.checkNotNullParameter(r6, "map");
        r20.putAll(r6);
        mz0.m r22 = new mz0.m();
        r22.b(LogCommon.ROOM);
        List<Object> r23 = r19.b;
        ArrayList r24 = (ArrayList) r23;
        r24.addAll(r22.a);
        cy0.e.a.getClass();
        cy0.j r25 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r26 = com.bytedance.android.scope.m.b(r25).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r26);
        ((mz0.i) ((f80.a) r26)).w3(r5, r19.a, r19.b);
        return;
    L35:
        r18 = DataType.FALSE;
    L20:
        r12 = "";
    L15:
        r9 = "";
    L8:
        r4 = "";
        goto L9
    }

    public PkReserveSettleBeInviteDialog(Context r2, i2 r3, PkReserveBattleDataContext r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "beinviteMsg");
        super(r2);
        this.c = r3;
        this.d = r4;
        this.a = new CompositeDisposable();
    }
}
