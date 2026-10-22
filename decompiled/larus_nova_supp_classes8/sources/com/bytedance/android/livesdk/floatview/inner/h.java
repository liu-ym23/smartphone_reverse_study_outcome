package com.bytedance.android.livesdk.floatview.inner;

import am2.x;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profit.lottery.LotteryState;
import com.bytedance.android.live.profit.lottery.ParticipateStatus;
import com.bytedance.android.live.profit.lottery.t;
import com.bytedance.android.livesdk.config.g4;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowSceneInterceptor;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h {
    public static final String a = null;
    public static final String b = null;
    public static final String c = null;
    public static final int d = 0;
    public static final int e = 0;

    public static final class a implements lm3.c.a {
        public final /* synthetic */ Context b;

        public a(Context r1) {
            this.b = r1;
        }

        public final void onAction(lm3.d r4) {
            if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.O2.getValue()).booleanValue() == false) goto L5;
            com.bytedance.android.livesdk.sharedpref.e r5 = b6.j;
            r5.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r5, 1);
        L5:
            com.bytedance.android.livesdk.sharedpref.e r6 = com.bytedance.android.livesdk.sharedpref.b.N2;
            r6.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r6, 0);
            HashMap r7 = new HashMap();
            r7.put("trigger_scene", "lottery");
            r7.put("click_button", "open");
            com.bytedance.android.livesdk.floatview.mob.a.b(r7);
            if (rx1.m.e(this.b) == false) goto L8;
            List<Pair<IInnerFloatWindowSceneInterceptor, Integer>> r8 = com.bytedance.android.livesdk.floatview.inner.b.a;
            com.bytedance.android.livesdk.floatview.inner.b.c(null, false);
            return;
        L8:
            boolean r9 = com.bytedance.android.livesdk.floatview.p.a;
            com.bytedance.android.livesdk.floatview.p.g(this.b);
        }
    }

    public static final class b implements lm3.c.a {
        public static final b b = null;

        static {
            b = new b();
        }

        public b() {
        }

        public final void onAction(lm3.d r4) {
            com.bytedance.android.livesdk.sharedpref.e r5 = com.bytedance.android.livesdk.sharedpref.b.O2;
            if (((Boolean) r5.getValue()).booleanValue() == false) goto L5;
            com.bytedance.android.livesdk.sharedpref.e r0 = b6.j;
            r0.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r0, 1);
        L5:
            com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.b.N2;
            com.bytedance.android.livesdk.sharedpref.f.d(r1, Integer.valueOf(((Integer) r1.getValue()).intValue() + 1));
            ALogger.d("PartSceneFloatWindow", "user click cancel " + ((Integer) r1.getValue()) + " ,is_auto_confirm " + ((Boolean) r5.getValue()));
            HashMap r6 = new HashMap();
            r6.put("trigger_scene", "lottery");
            r6.put("click_button", "refuse");
            com.bytedance.android.livesdk.floatview.mob.a.b(r6);
            xs2.b.a().post(new h1(58));
        }
    }

    static {
        a = "https://" + LiveCommonConstants.INSTANCE.getObjectTosPath() + "/obj/live-android/ttlive_bg_part_scene_float_window_retain_dialog.png";
        b = "开启小窗 继续等待福袋";
        c = "退出直播自动播放（仅等待福袋时）";
        d = vm2.h.j().a();
        e = vm2.h.j().b() * 60000;
    }

    @JvmStatic
    public static final boolean a() {
        if (g4.a.getValue().booleanValue() == true) goto L6;
        ALogger.d("PartSceneFloatWindow", "cant show: setting is invalid");
        return false;
    L6:
        com.bytedance.android.live.profit.lottery.i r0 = yt0.c.f();
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.m r1 = r0.getCurCandidateState();
        if (r1 == null) goto L11;
        ParticipateStatus r2 = (ParticipateStatus) r1.getValue();
    L13:
        if (r2 != ParticipateStatus.PARTICIPATEINSUCCESS) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == true) goto L19;
        ALogger.d("PartSceneFloatWindow", "cant show: user not join");
        return false;
    L19:
        Long r4 = d();
        if (r4 != null) goto L22;
    L25:
        ALogger.d("PartSceneFloatWindow", "cant show: time too short");
        return false;
    L22:
        if ((r4.longValue() - System.currentTimeMillis()) <= 10000) goto L25;
        return true;
    L15:
        r3 = false;
    L11:
        r2 = null;
        goto L13
    }

    @JvmStatic
    public static final boolean c() {
        Integer r0 = (Integer) b6.j.getValue();
        if (r0 != null) goto L6;
    L7:
        ALogger.d("PartSceneFloatWindow", "cant show: no need");
        return false;
    L6:
        if (r0.intValue() != 0) goto L7;
        if (((Number) com.bytedance.android.livesdk.sharedpref.b.N2.getValue()).intValue() >= d) goto L21;
        com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.b.P2;
        if (((Number) r1.getValue()).longValue() <= 0) goto L17;
        if ((System.currentTimeMillis() - ((Number) r1.getValue()).longValue()) <= e) goto L21;
    L17:
        if (a() == false) goto L20;
        return true;
    L20:
        return false;
    L21:
        ALogger.d("PartSceneFloatWindow", "cant show: hit control");
        return false;
    }

    public static Long d() {
        com.bytedance.android.live.profit.lottery.i r0 = yt0.c.f();
        if (r0 == null) goto L13;
        com.bytedance.live.datacontext.n r1 = r0.getCurrentLottery();
        if (r1 == null) goto L13;
        com.bytedance.android.live.profit.lottery.g r2 = (com.bytedance.android.live.profit.lottery.g) r1.getValue();
        if (r2 == null) goto L13;
        LotteryState r3 = r2.getState();
        if (r3 == null) goto L13;
        t r4 = com.bytedance.android.live.profit.lottery.l.a(r3);
        if (r4 == null) goto L13;
        return Long.valueOf(r4.c);
    L13:
        return null;
    }

    @JvmStatic
    public static final boolean b(Context r1) {
        if (rx1.m.e(r1) == false) goto L10;
        Integer r2 = (Integer) b6.j.getValue();
        if (r2 == null) goto L10;
        if (r2.intValue() != 1) goto L10;
        return true;
    L10:
        return false;
    }

    @JvmStatic
    public static final lm3.d e(Context r9, lm3.d r10) {
        if (r9 != null) goto L6;
        return null;
    L6:
        if (r10 != null) goto L8;
    L10:
        Intrinsics.checkNotNullParameter("", LiveEndPageData.TAG_TITLE);
        Intrinsics.checkNotNullParameter("", "content");
        String r11 = b;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        String r3 = c;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        View r0 = LayoutInflater.from(r9).inflate(2131567457, null);
        HSImageView r2 = r0.findViewById(2131374718);
        TextView r4 = (TextView) r0.findViewById(2131388772);
        TextView r5 = (TextView) r0.findViewById(2131367794);
        LinearLayout r6 = (LinearLayout) r0.findViewById(2131383717);
        RadioButton r7 = (RadioButton) r0.findViewById(2131383716);
        ImageLoader.bindImage(r2, a);
        r2.setVisibility(0);
        if (r11.length() <= 0) goto L13;
        boolean r8 = true;
    L14:
        if (r8 == false) goto L17;
        r4.setText(r11);
        UtilityKotlinExtentionsKt.w(r4);
    L17:
        if (r3.length() <= 0) goto L19;
        boolean r12 = true;
    L20:
        if (r12 == false) goto L22;
        r5.setText(r3);
        UtilityKotlinExtentionsKt.w(r5);
    L22:
        r7.setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.b.O2.getValue()).booleanValue());
        r6.setOnClickListener(new g(r7));
        lm3.c r13 = new lm3.c();
        r13.b = s1.B(2131922556);
        r13.c = b.b;
        lm3.c r14 = new lm3.c();
        r14.b = s1.B(2131922557);
        r14.c = new a(r9);
        lm3.d.a r15 = new lm3.d.a(r9);
        r15.d = r0;
        r15.e = CollectionsKt.listOf(new lm3.c[]{r13, r14});
        r15.i = true;
        r15.j = false;
        r15.k = 2131249914;
        r15.g = Float.valueOf(0.0f);
        r15.h = Float.valueOf(0.0f);
        r15.f = Float.valueOf(0.0f);
        lm3.d r16 = r15.a();
        com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.b.P2;
        Long r17 = Long.valueOf(System.currentTimeMillis());
        r1.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r1, r17);
        int r18 = com.bytedance.android.livesdk.floatview.mob.a.a;
        Intrinsics.checkNotNullParameter("lottery", "triggerScene");
        HashMap r19 = new HashMap();
        r19.put("trigger_scene", "lottery");
        u.l().sendLog("livesdk_mini_window_popup_show", r19, new Object[]{Room.class, x.class});
        return r16;
    L19:
        r12 = false;
        goto L20
    L13:
        r8 = false;
        goto L14
    L8:
        if (r10.isShowing() != true) goto L10;
        return r10;
    }
}
