package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x0 {
    public boolean a;
    public yo2.e b;
    public yo2.e c;
    public yo2.e d;
    public yo2.e e;
    public yo2.d<?> f;
    public yo2.e g;
    public yo2.e h;
    public boolean i;
    public boolean j;
    public View k;
    public DataCenter l;
    public CompositeDisposable m;
    public final Context n;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ x0 a;

        public b(x0 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            x0 r3 = this.a;
            yo2.e r0 = r3.g;
            if (r0 == null) goto L5;
            r0.d();
        L5:
            r3.g = null;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ x0 a;

        public c(x0 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            String r4 = (String) r3;
            if (this.a.c() == false) goto L6;
            this.a.d(r4, true);
            return;
        }
    }

    static {
    }

    public final View b() {
        if (this.i == true) goto L7;
        return null;
    L7:
        return this.k;
    }

    public final boolean c() {
        if (this.i == true) goto L5;
        return false;
    L5:
        if (this.j == true) goto L47;
        yo2.e r0 = this.d;
        if (r0 != null) goto L10;
        boolean r1 = false;
    L11:
        if (r1 == false) goto L13;
        return false;
    L13:
        DataCenter r2 = this.l;
        if (r2 == null) goto L18;
        Boolean r3 = (Boolean) r2.get("data_is_portrait", Boolean.FALSE);
        if (r3 == null) goto L18;
        boolean r4 = r3.booleanValue();
    L19:
        if (r4 == true) goto L22;
        return false;
    L22:
        if (this.a == false) goto L24;
        return false;
    L24:
        Integer r5 = (Integer) com.bytedance.android.livesdk.sharedpref.b.K1.getValue();
        if (r5 != null) goto L28;
    L29:
        if (r5 != null) goto L32;
    L34:
        long r6 = ((Long) new com.bytedance.android.livesdk.sharedpref.e("last_dou_plus_coupon_show_time_" + com.bytedance.android.live.base.model.user.o.a(jc1.k.n(IUserService.class).user().b()), 0L).getValue()).longValue();
        if (r6 != 0) goto L37;
        int r7 = Integer.MAX_VALUE;
    L38:
        JSONObject r8 = jc1.k.n(ILiveDouPlusService.class).getClientDouPlusPopupSettings();
        int r9 = 14;
        if (r8 == null) goto L41;
        r9 = r8.optInt("douplus_live_bubble_coupon_interval_days", 14);
    L41:
        if (r7 < r9) goto L46;
        return true;
    L46:
        return false;
    L37:
        r7 = (int) ((System.currentTimeMillis() - r6) / 86400000);
        goto L38
    L32:
        if (r5.intValue() != 2) goto L34;
        return false;
    L28:
        if (r5.intValue() != 1) goto L29;
        return false;
    L18:
        r4 = false;
        goto L19
    L10:
        r1 = r0.h();
        goto L11
    L47:
        return false;
    }

    public final void e() {
        View r1 = this.k;
        if (r1 != null) goto L5;
        return;
    L5:
        String r0 = com.bytedance.android.live.base.model.user.o.a(jc1.k.n(IUserService.class).user().b());
        int r2 = com.bytedance.android.livesdk.chatroom.utils.k0.a;
        Intrinsics.checkNotNullParameter(r0, "key");
        String r4 = "transform_widget_fold_pop_up_shown_" + r0;
        Boolean r6 = Boolean.FALSE;
        if (((Boolean) new com.bytedance.android.livesdk.sharedpref.e(r4, r6).getValue()).booleanValue() == false) goto L8;
        return;
    L8:
        Intrinsics.checkNotNullParameter(r0, "key");
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("transform_widget_fold_pop_up_shown_".concat(r0), r6), Boolean.TRUE);
        View r3 = LayoutInflater.from(this.n).inflate(2131567899, null);
        View r5 = r3.findViewById(2131390392);
        if (r5 == null) goto L13;
        ((TextView) r5).setText(2131922965);
        r3.setOnClickListener(new b(this));
        yo2.e r7 = new yo2.e(this.n);
        ((yo2.d) r7).d = r3;
        ((yo2.d) r7).e = 0;
        ((yo2.d) r7).m = 5;
        ((yo2.d) r7).n = true;
        ((yo2.d) r7).l = true;
        ((yo2.d) r7).g = true;
        r7.a();
        this.g = r7;
        Intrinsics.checkNotNull(r7);
        r7.i(r1, 1, 4, 0, -4);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    public x0(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.n = r2;
        this.i = true;
        this.m = new CompositeDisposable();
    }

    public final void f(boolean r6) {
        if (r6 == true) goto L4;
    L7:
        if (r6 == true) goto L50;
        RoomContext r7 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r7 != null) goto L12;
    L42:
        boolean r2 = false;
    L43:
        if (r2 == false) goto L51;
        JSONObject r8 = jc1.k.n(ILiveDouPlusService.class).getClientDouPlusPopupSettings();
        String r1 = "DOU+助你上热门";
        if (r8 == null) goto L48;
        r1 = r8.optString("douplus_live_bubble_text", "DOU+助你上热门");
    L48:
        d(r1, false);
        return;
    L51:
        return;
    L12:
        if (this.i == false) goto L42;
        if (this.j == true) goto L42;
        JSONObject r3 = jc1.k.n(ILiveDouPlusService.class).getClientDouPlusPopupSettings();
        int r4 = 5;
        if (r3 == null) goto L19;
        r4 = r3.optInt("douplus_live_bubble_delay_mins", 5);
    L19:
        if (r4 == (-1)) goto L42;
        yo2.e r5 = this.d;
        if (r5 != null) goto L24;
        boolean r9 = false;
    L25:
        if (r9 == true) goto L42;
        if (((Boolean) r7.isPortraitInteraction().getValue()).booleanValue() == false) goto L42;
        if (this.a == true) goto L42;
        IUser r10 = jc1.k.n(IUserService.class).user().b();
        if (((Boolean) new com.bytedance.android.livesdk.sharedpref.e("has_dou_plus_popup_show_" + com.bytedance.android.live.base.model.user.o.a(r10), Boolean.FALSE).getValue()).booleanValue() == true) goto L42;
        IUser r11 = TTLiveSDK.hostService().user().getCurUser();
        r2 = true;
        if (r10.getEnableShowCommerceSale() == true) goto L43;
        if (r11.getEnterprise() < 1) goto L42;
    L24:
        r9 = r5.h();
        goto L25
    L50:
        return;
    L4:
        if (c() == false) goto L7;
        jc1.k.n(ILiveDouPlusService.class).fetchDouLiveCouponToast(new c(this));
    }

    public static void a(String r4, Map r5) {
        com.bytedance.android.livesdk.log.g r0 = com.bytedance.android.livesdk.log.u.l();
        am2.x r2 = new am2.x();
        r2.b = "live_take_detail";
        r2.a = "live_take";
        r0.sendLog(r4, r5, new Object[]{r2, Room.class});
    }

    public final void d(String r8, boolean r9) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        View r2 = b();
        if (r2 != null) goto L8;
        return;
    L8:
        View r0 = LayoutInflater.from(this.n).inflate(2131565810, null);
        ((TextView) r0.findViewById(2131390392)).setText(r8);
        yo2.e r1 = new yo2.e(this.n);
        ((yo2.d) r1).d = r0;
        ((yo2.d) r1).e = 0;
        ((yo2.d) r1).m = 3;
        ((yo2.d) r1).n = true;
        ((yo2.d) r1).l = true;
        r1.a();
        Intrinsics.checkNotNull(r1);
        r1.i(r2, 1, 4, 0, -8);
        this.i = false;
        if (r9 == false) goto L11;
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("last_dou_plus_coupon_show_time_" + com.bytedance.android.live.base.model.user.o.a(jc1.k.n(IUserService.class).user().b()), 0L), Long.valueOf(System.currentTimeMillis()));
        ILiveDouPlusService r10 = jc1.k.n(ILiveDouPlusService.class);
        HashMap r3 = new HashMap();
        r3.put("toast_type", "coupon");
        r10.logEvent(false, "show_dou_live_toast", "", r3);
        return;
    L11:
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("has_dou_plus_popup_show_" + com.bytedance.android.live.base.model.user.o.a(jc1.k.n(IUserService.class).user().b()), Boolean.FALSE), Boolean.TRUE);
        ILiveDouPlusService r11 = jc1.k.n(ILiveDouPlusService.class);
        HashMap r4 = new HashMap();
        r4.put("bubble_type", "remind_position");
        r11.logEvent(false, "show_dou_live_bubble", "", r4);
    }
}
