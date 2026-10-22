package com.bytedance.android.live.revlink.impl.pk.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.f2;
import com.bytedance.android.livesdk.link.model.k0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import x31.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/PkUserBanSettingDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkUserBanSettingDialog extends LiveDialogFragment implements View.OnClickListener {
    public static final /* synthetic */ int m = 0;
    public Map<Integer, View> d;
    public u e;
    public int f;
    public int g;
    public boolean h;
    public IRoom i;
    public boolean j;
    public final CompositeDisposable k;
    public f2 l;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ PkUserBanSettingDialog a;
        public final /* synthetic */ View b;
        public final /* synthetic */ HashMap c;

        public b(PkUserBanSettingDialog r1, View r2, HashMap r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            ExtraResponse r5 = (ExtraResponse) r4;
            View r6 = this.b;
            Object r0 = null;
            if (r6 == null) goto L5;
            Integer r7 = Integer.valueOf(r6.getId());
        L6:
            int r8 = r7.intValue();
            if (r8 != 2131378596) goto L10;
            ((ImageView) this.a.S90(2131375974)).setVisibility(0);
        L15:
            Object r9 = this.c.get("increase_or_decrease_invite");
            if ((r9 instanceof Integer) == true) goto L18;
            r9 = null;
        L18:
            Integer r10 = (Integer) r9;
            if (r10 == null) goto L28;
            u r1 = this.a.e;
            if (r1 == null) goto L24;
            r1.b = r10.intValue();
        L24:
            if (r10.intValue() != 1) goto L45;
            u r12 = this.a.e;
            if (r12 == null) goto L45;
            r12.c = false;
        L45:
            ToastUtil.a(2131917815, 0);
            this.a.dismiss();     // Catch: Exception -> L48
            return;
        L48:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r13 = DialogFragmentLancet.sLastShowStack;
            if (r13 == null) goto L55;
            com.bytedance.crash.d.d(r13, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L55:
            return;
        L28:
            Object r14 = this.c.get("invite_reject_permanent");
            if ((r14 instanceof Boolean) == false) goto L32;
            r0 = r14;
        L32:
            Boolean r2 = (Boolean) r0;
            if (r2 == null) goto L45;
            u r15 = this.a.e;
            if (r15 == null) goto L38;
            r15.c = r2.booleanValue();
        L38:
            if (r2.booleanValue() == false) goto L42;
            u r16 = this.a.e;
            if (r16 == null) goto L45;
            r16.b = 2;
            goto L45
        L42:
            u r17 = this.a.e;
            if (r17 == null) goto L45;
            r17.b = 0;
            goto L45
        L10:
            if (r8 != 2131378892) goto L13;
            ((ImageView) this.a.S90(2131376645)).setVisibility(0);
            goto L15
        L13:
            if (r8 != 2131378772) goto L15;
            ((ImageView) this.a.S90(2131376444)).setVisibility(0);
            goto L15
        L5:
            r7 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            Intrinsics.checkNotNullParameter(r3, "obj");
            r3.printStackTrace();
            ToastUtil.a(2131917814, 0);
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ PkUserBanSettingDialog a;
        public final /* synthetic */ f2 b;

        public d(PkUserBanSettingDialog r1, f2 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            Context r7 = this.a.getContext();
            if (r7 != null) goto L5;
            return;
        L5:
            IBattleUserInfo r0 = this.b.getBattleUserInfo();
            if (r0 == null) goto L24;
            k0 r1 = r0.getUserInfo();
            if (r1 == null) goto L25;
            final String r2 = r1.getUserId();
            if (r2 == null) goto L27;
            PkUserBanSettingDialog r3 = this.a;
            if (r3.j == true) goto L28;
            r3.j = true;
            if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).isLogin() == true) goto L18;
            com.bytedance.android.livesdk.revenue.service.user.a r4 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class);
            ds2.e r5 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).Je();
            r5.setMessage(s1.B(2131915987));
            r5.e = -1;
            Intrinsics.checkNotNullParameter("pk", "<set-?>");
            r5.b = "pk";
            Intrinsics.checkNotNullParameter("guest", "<set-?>");
            r5.c = "guest";
            Unit r8 = Unit.INSTANCE;
            r4.g2(r7, r5).subscribe(new com.bytedance.android.livesdk.user.h());
            r3.j = false;
            return;
        L18:
            final com.bytedance.android.livesdk.revenue.service.user.a r9 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class);
            Disposable r10 = r9.om(null, null, new ds2.c(new PkUserBanSettingDialog$follow$params$1(r2, r9))).compose(RxUtil.rxSchedulerHelper()).subscribe(new q(r3), new r(r3, r7));
            r3.k.add(r10);
            mz0.n r12 = new mz0.n();
            Map<String, String> r13 = r12.a;
            Intrinsics.checkNotNullParameter(r13, "map");
            HashMap<String, String> r14 = r3.T90();
            Intrinsics.checkNotNullParameter(r14, "map");
            r13.putAll(r14);
            if (r3.f != 3) goto L21;
            String r15 = "2";
        L22:
            Intrinsics.checkNotNullParameter("click_options", "key");
            Intrinsics.checkNotNullParameter(r15, "value");
            r13.put("click_options", r15);
            mz0.m r16 = new mz0.m();
            r16.b(LogCommon.ROOM);
            List<Object> r17 = r12.b;
            ArrayList r18 = (ArrayList) r17;
            r18.addAll(r16.a);
            cy0.e.a.getClass();
            cy0.j r19 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r20 = com.bytedance.android.scope.m.b(r19).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r20);
            ((mz0.i) ((f80.a) r20)).w3("livesdk_pk_record_anchor_feedback_click", r12.a, r12.b);
            return;
        L21:
            r15 = DataType.TRUE;
            goto L22
        L28:
            return;
        L27:
            return;
        L25:
            return;
        }
    }

    static {
    }

    public final HashMap<String, String> T90() {
        HashMap<String, String> r0 = new HashMap();
        f2 r1 = this.l;
        if (r1 == null) goto L11;
        IBattleUserInfo r2 = r1.getBattleUserInfo();
        if (r2 == null) goto L11;
        k0 r3 = r2.getUserInfo();
        if (r3 == null) goto L11;
        String r4 = r3.getUserId();
        if (r4 == null) goto L11;
        r0.put("feedback_anchor_id", r4);
    L11:
        int r5 = this.f;
        if (r5 != 1) goto L14;
        r0.put("follow_status", "follow");
    L21:
        return r0;
    L14:
        if (r5 != 2) goto L16;
        r0.put("follow_status", "mutual");
        goto L21
    L16:
        if (r5 == 3) goto L18;
        r0.put("follow_status", "irrelevant");
        goto L21
    L18:
        r0.put("follow_status", "followed");
        goto L21
    }

    public PkUserBanSettingDialog() {
        this.d = new LinkedHashMap();
        this.k = new CompositeDisposable();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.j = false;
        this.k.dispose();
        ((LinkedHashMap) this.d).clear();
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void U90(Integer r7) {
        if (r7 != null) goto L6;
    L8:
        if (r7 != null) goto L11;
    L13:
        if (r7 != null) goto L16;
    L18:
        ((TextView) S90(2131390651)).setVisibility(8);
        ((TextView) S90(2131391183)).setVisibility(0);
        return;
    L16:
        if (r7.intValue() != 3) goto L18;
        ((TextView) S90(2131391183)).setVisibility(0);
        ((TextView) S90(2131391183)).setText("回关");
        return;
    L11:
        if (r7.intValue() != 2) goto L13;
        ((TextView) S90(2131390651)).setVisibility(0);
        ((TextView) S90(2131390651)).setText("好友");
        ((TextView) S90(2131391183)).setVisibility(8);
        return;
    L6:
        if (r7.intValue() != 1) goto L8;
        ((TextView) S90(2131390651)).setVisibility(0);
        ((TextView) S90(2131390651)).setText("已关注");
        ((TextView) S90(2131391183)).setVisibility(8);
    }

    public final void onActivityCreated(Bundle r5) {
        super.onActivityCreated(r5);
        Dialog r6 = getDialog();
        if (r6 == null) goto L13;
        Window r7 = r6.getWindow();
        if (r7 == null) goto L14;
        View r0 = r7.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L11;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L11;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L11:
        r0.setPadding(0, 0, 0, 0);
        r7.setLayout(-1, -1);
        r7.setGravity(80);
        r7.setBackgroundDrawable(new ColorDrawable(0));
        r7.setSoftInputMode(48);
        return;
    L14:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        f2 r0 = this.l;
        if (r0 != null) goto L7;
        return;
    L7:
        IRoom r1 = this.i;
        if (r1 != null) goto L10;
        return;
    L10:
        HashMap<String, String> r2 = T90();
        HashMap r9 = new HashMap();
        IBattleUserInfo r3 = r0.getBattleUserInfo();
        if (r3 == null) goto L17;
        k0 r4 = r3.getUserInfo();
        if (r4 == null) goto L17;
        String r5 = r4.getUserId();
        if (r5 == null) goto L17;
        r9.put("rival_anchor_id", r5);
    L17:
        int r6 = Integer.valueOf(r12.getId()).intValue();
        if (r6 != 2131378596) goto L29;
        int r7 = this.g;
        if (r7 == 0) goto L26;
        if (r7 == 1) goto L25;
        if (r7 != 2) goto L27;
        r9.put("increase_or_decrease_invite", 1);
    L27:
        r2.put("click_options", "3");
    L39:
        int r8 = 10;
    L45:
        if ((!r9.isEmpty()) == false) goto L58;
        if (r8 < 0) goto L58;
        r31.a r10 = r31.b.a(r31.a.a);
        long r13 = r1.getId();
        IBaseUser r14 = r1.getOwner();
        if (r14 == null) goto L50;
        Intrinsics.checkNotNullParameter(r14, "$this$secUidExt");
        String r15 = r14.getCastSecUid();
    L51:
        Observable<ExtraResponse<Object, Extra>> r16 = r10.N(r13, r15, r8, r9);
        if (r16 == null) goto L58;
        Observable r17 = r16.compose(RxUtil.rxSchedulerHelper());
        if (r17 == null) goto L58;
        Disposable r18 = r17.subscribe(new b(this, r12, r9), c.a);
        if (r18 == null) goto L58;
        this.k.add(r18);
        goto L58
    L50:
        r15 = null;
    L58:
        mz0.n r19 = new mz0.n();
        Map<String, String> r20 = r19.a;
        Intrinsics.checkNotNullParameter(r20, "map");
        Intrinsics.checkNotNullParameter(r2, "map");
        r20.putAll(r2);
        mz0.m r22 = new mz0.m();
        r22.b(LogCommon.ROOM);
        ((ArrayList) r19.b).addAll(r22.a);
        cy0.e.a.getClass();
        cy0.j r23 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r24 = com.bytedance.android.scope.m.b(r23).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r24);
        ((mz0.i) ((f80.a) r24)).w3("livesdk_pk_record_anchor_feedback_click", r19.a, r19.b);
        return;
    L25:
        r9.put("increase_or_decrease_invite", 0);
        goto L27
    L26:
        r9.put("increase_or_decrease_invite", 1);
        goto L27
    L29:
        if (r6 != 2131378892) goto L41;
        int r25 = this.g;
        if (r25 == 0) goto L37;
        if (r25 == 1) goto L36;
        if (r25 != 2) goto L38;
        r9.put("increase_or_decrease_invite", 0);
    L38:
        r2.put("click_options", "4");
        goto L39
    L36:
        r9.put("increase_or_decrease_invite", 2);
        goto L38
    L37:
        r9.put("increase_or_decrease_invite", 2);
        goto L38
    L41:
        if (r6 != 2131378772) goto L43;
        r9.put("invite_reject_permanent", Boolean.valueOf(!this.h));
        r2.put("click_options", "5");
        r8 = 12;
        goto L45
    L43:
        r8 = -1;
        goto L45
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954727);
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        if (r3 == null) goto L5;
        r3.setCanceledOnTouchOutside(true);
    L5:
        return r3;
    }

    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        super.onViewCreated(r12, r13);
        f2 r14 = this.l;
        if (r14 != null) goto L5;
        return;
    L5:
        ImageView r0 = (ImageView) S90(2131374267);
        IBattleUserInfo r1 = r14.getBattleUserInfo();
        String r2 = null;
        if (r1 == null) goto L10;
        k0 r3 = r1.getUserInfo();
        if (r3 == null) goto L10;
        py.k r4 = r3.getAvatarThumb();
    L11:
        a1.x(r0, r4, S90(2131374267).getWidth(), S90(2131374267).getHeight(), 2131250965);
        TextView r15 = (TextView) S90(2131390993);
        IBattleUserInfo r5 = r14.getBattleUserInfo();
        if (r5 == null) goto L16;
        k0 r6 = r5.getUserInfo();
        if (r6 == null) goto L16;
        String r7 = r6.getNickName();
    L17:
        r15.setText(r7);
        U90(Integer.valueOf(this.f));
        ((TextView) S90(2131391183)).setOnClickListener(new d(this, r14));
        long r8 = (r14.getAllCount() - r14.getWinCount()) - r14.getLoseCount();
        TextView r16 = (TextView) S90(2131391116);
        StringCompanionObject r9 = StringCompanionObject.INSTANCE;
        Object[] r10 = new Object[4];
        r10[0] = Long.valueOf(r14.getAllCount());
        r10[1] = Long.valueOf(r14.getWinCount());
        r10[2] = Long.valueOf(r14.getLoseCount());
        if (r8 >= 0) goto L21;
        r8 = 0;
    L21:
        r10[3] = Long.valueOf(r8);
        r16.setText(String.format("与Ta共PK过%d场，%s胜-%s负-%s平", Arrays.copyOf(r10, 4)));
        IBattleUserInfo r17 = r14.getBattleUserInfo();
        if (r17 == null) goto L26;
        k0 r18 = r17.getUserInfo();
        if (r18 == null) goto L26;
        Integer r19 = Integer.valueOf(r18.getGender());
    L28:
        if (r19 != null) goto L31;
    L33:
        if (r19 != null) goto L36;
    L38:
        S90(2131373623).setVisibility(8);
    L40:
        if (r14.getRivalLivingRoomId() == 0) goto L42;
        ((ImageView) S90(2131365723)).setVisibility(0);
        S90(2131378545).setVisibility(0);
        S90(2131378545).setController(Fresco.newDraweeControllerBuilder().setUri("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_item_rank_top_on_going_hd.webp").setAutoPlayAnimations(true).build());
    L44:
        if (this.h == false) goto L50;
        TextView r110 = (TextView) S90(2131391015);
        StringBuilder r20 = new StringBuilder("取消");
        Context r22 = getContext();
        if (r22 == null) goto L48;
        String r23 = r22.getString(2131917822);
    L49:
        r20.append(r23);
        r110.setText(r20.toString());
        goto L50
    L48:
        r23 = null;
    L50:
        int r111 = this.g;
        if (r111 == 0) goto L73;
        if (r111 == 1) goto L64;
        if (r111 != 2) goto L82;
        TextView r112 = (TextView) S90(2131390112);
        Context r24 = getContext();
        if (r24 == null) goto L58;
        String r25 = r24.getString(2131917820);
    L59:
        r112.setText(r25);
        TextView r113 = (TextView) S90(2131391521);
        StringBuilder r26 = new StringBuilder("取消");
        Context r27 = getContext();
        if (r27 == null) goto L62;
        String r28 = r27.getString(2131917823);
    L63:
        r26.append(r28);
        r113.setText(r26.toString());
        goto L82
    L62:
        r28 = null;
        goto L63
    L58:
        r25 = null;
    L82:
        ((FrameLayout) S90(2131378596)).setOnClickListener(this);
        ((FrameLayout) S90(2131378892)).setOnClickListener(this);
        ((FrameLayout) S90(2131378772)).setOnClickListener(this);
        HashMap r114 = new HashMap();
        IBattleUserInfo r115 = r14.getBattleUserInfo();
        if (r115 == null) goto L87;
        k0 r116 = r115.getUserInfo();
        if (r116 == null) goto L87;
        r2 = r116.getUserId();
    L87:
        r114.put("feedback_anchor_id", String.valueOf(r2));
        mz0.n r117 = new mz0.n();
        Map<String, String> r29 = r117.a;
        Intrinsics.checkNotNullParameter(r29, "map");
        Intrinsics.checkNotNullParameter(r114, "map");
        r29.putAll(r114);
        mz0.m r118 = new mz0.m();
        r118.b(LogCommon.ROOM);
        ((ArrayList) r117.b).addAll(r118.a);
        cy0.e.a.getClass();
        cy0.j r119 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r120 = com.bytedance.android.scope.m.b(r119).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r120);
        ((mz0.i) ((f80.a) r120)).w3("livesdk_pk_record_anchor_feedback_show", r117.a, r117.b);
        return;
    L64:
        TextView r121 = (TextView) S90(2131390112);
        StringBuilder r30 = new StringBuilder("取消");
        Context r32 = getContext();
        if (r32 == null) goto L67;
        String r33 = r32.getString(2131917820);
    L68:
        r30.append(r33);
        r121.setText(r30.toString());
        TextView r122 = (TextView) S90(2131391521);
        Context r34 = getContext();
        if (r34 == null) goto L71;
        String r35 = r34.getString(2131917823);
    L72:
        r122.setText(r35);
        goto L82
    L71:
        r35 = null;
        goto L72
    L67:
        r33 = null;
        goto L68
    L73:
        TextView r123 = (TextView) S90(2131390112);
        Context r36 = getContext();
        if (r36 == null) goto L76;
        String r37 = r36.getString(2131917820);
    L77:
        r123.setText(r37);
        TextView r124 = (TextView) S90(2131391521);
        Context r38 = getContext();
        if (r38 == null) goto L80;
        String r39 = r38.getString(2131917823);
    L81:
        r124.setText(r39);
        goto L82
    L80:
        r39 = null;
        goto L81
    L76:
        r37 = null;
        goto L77
    L42:
        ((ImageView) S90(2131365723)).setVisibility(8);
        S90(2131378545).setVisibility(8);
        goto L44
    L36:
        if (r19.intValue() != 2) goto L38;
        S90(2131373623).setImageResource(2131250687);
        S90(2131373623).setVisibility(0);
        goto L40
    L31:
        if (r19.intValue() != 1) goto L33;
        S90(2131373623).setImageResource(2131250688);
        S90(2131373623).setVisibility(0);
    L26:
        r19 = null;
    L16:
        r7 = null;
    L10:
        r4 = null;
        goto L11
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565692, r3, false);
    }
}
