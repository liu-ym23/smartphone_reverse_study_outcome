package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y implements com.bytedance.android.scope.o, l {
    public final bn0.b a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void Pb() {
        int r0 = x.a;
        tc0.c r1 = tc0.c.h();
        Intrinsics.checkNotNullParameter(r1, "dataHolder");
        HashMap r2 = new HashMap();
        r2.put("reason", "有bgm，或者静音过程中打开了bgm，则不能muteLocal");
        x.u0("rtc_unmute_local_audio", r2, r1);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void zg() {
        int r0 = x.a;
        tc0.c r1 = tc0.c.h();
        Intrinsics.checkNotNullParameter(r1, "dataHolder");
        HashMap r2 = new HashMap();
        r2.put("reason", "关闭bgm,且关闭了麦克风,可以muteLocal");
        x.u0("rtc_mute_local_audio", r2, r1);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void Ef() {
        tc0.c r0 = tc0.c.h();
        int r1 = x.a;
        Intrinsics.checkNotNullParameter(r0, "dataHolder");
        x.u0("rtc_turn_off", new HashMap(), r0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void Ie() {
        x.m0(tc0.c.h());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void Aj() {
        x.L();
    }

    public y(bn0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "myScope");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void Bm(boolean r3) {
        int r0 = x.a;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("engine_on", Boolean.valueOf(r3));
        x.t0("cancel_apply_when_start_rtc", r1);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void D7(long r2) {
        x.e0(tc0.c.h(), r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void Eg(BaseCheckException r2) {
        Intrinsics.checkNotNullParameter(r2, "exception");
        x.K(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void I3(boolean r1) {
        x.O(r1);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void Ji(long r3) {
        int r0 = x.a;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("msg_id", Long.valueOf(r3));
        x.t0("anchor_receive_admin_agree_msg", r1);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void Ob(String r2) {
        int r0 = x.a;
        x.i0(tc0.c.h(), r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void Q4(String r3) {
        Intrinsics.checkNotNullParameter(r3, "targetId");
        int r1 = x.a;
        Intrinsics.checkNotNullParameter(r3, "targetId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("target_user_id", r3);
        x.t0("kickout_audience_success", r0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void Tl(long r3) {
        int r0 = x.a;
        x.t0("guest_receive_sys_kickout_when_turn_off", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("msg_id", Long.valueOf(r3))}));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void U6(String r3) {
        Intrinsics.checkNotNullParameter(r3, "rtcExtInfo");
        int r1 = x.a;
        Intrinsics.checkNotNullParameter(r3, "rtcExtInfo");
        HashMap r0 = new HashMap();
        r0.put("ext_info", r3);
        x.t0("rtc_update_ext_info", r0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void d7(boolean r3) {
        int r0 = x.a;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("engine_on", Boolean.valueOf(r3));
        x.t0("cancel_apply_when_join_channel", r1);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void g5(String r2) {
        Intrinsics.checkNotNullParameter(r2, "linkmicId");
        x.q0(r2, tc0.c.h());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void h6(Throwable r2) {
        int r0 = x.a;
        LinkedHashMap r1 = new LinkedHashMap();
        x.X(r2, r1);
        x.t0("notify_join_rtc_failed", r1);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void i4(String r3) {
        Intrinsics.checkNotNullParameter(r3, "token");
        int r1 = x.a;
        Intrinsics.checkNotNullParameter(r3, "token");
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("token", r3);
        x.t0("notify_join_rtc_success", r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void rc(String r3) {
        Intrinsics.checkNotNullParameter(r3, "liveCoreExtInfo");
        int r1 = x.a;
        Intrinsics.checkNotNullParameter(r3, "liveCoreExtInfo");
        HashMap r0 = new HashMap();
        r0.put("ext_info", r3);
        x.t0("livecore_update_ext_info", r0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void ui(String r2) {
        Intrinsics.checkNotNullParameter(r2, "linkmicId");
        x.p0(r2, tc0.c.h());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void x5(String r2) {
        Intrinsics.checkNotNullParameter(r2, "targetId");
        x.w(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void zd(long r3) {
        Intrinsics.checkNotNullParameter("", "reqFrom");
        x.z(r3, "");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void Bd(long r2, String r4) {
        x.f0(r2, r4, tc0.c.h());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void Em(long r1, String r3) {
        x.p(r1, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void F6(Throwable r1, long r2) {
        x.u(r1, r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void Jh(Throwable r2, long r3) {
        int r0 = x.a;
        LinkedHashMap r1 = new LinkedHashMap();
        x.X(r2, r1);
        r1.put("duration", Long.valueOf(r3));
        x.t0("guest_apply_failed", r1);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void L8(long r1, int r3) {
        x.b(r1, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void Nb(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "fromUserId");
        x.n(r2, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void Nm(String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r3, "targetId");
        int r1 = x.a;
        Intrinsics.checkNotNullParameter(r3, "targetId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("target_user_id", r3);
        x.X(r4, r0);
        x.t0("kickout_audience_failed", r0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void Pg(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "linkmicId");
        x.g0(r2, tc0.c.h(), r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void Qg(String r2, Boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "linkmicId");
        x.k0(r2, tc0.c.h(), r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void Rh(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "reqFrom");
        x.l(r2, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void Td(long r2, String r4) {
        x.d0(r2, r4, tc0.c.h());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void U8(long r1, int r3) {
        x.o(r1, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void Xa(long r2, boolean r4) {
        x.o0(tc0.c.h(), r2, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void Yb(long r1, String r3) {
        x.f(r1, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void ce(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "fromUserId");
        x.c(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void e2(long r2, String r4) {
        x.n0(r2, r4, tc0.c.h());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void la(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "targetId");
        x.Y(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void ma(String r2, Boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "linkmicId");
        x.l0(r2, tc0.c.h(), r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void pb(int r1, long r2) {
        x.B(r1, r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void uo(boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        tc0.c r1 = tc0.c.h();
        int r2 = x.a;
        Intrinsics.checkNotNullParameter(r1, "dataHolder");
        Intrinsics.checkNotNullParameter(r5, "reason");
        HashMap r3 = new HashMap();
        r3.put("reason", r5);
        x.a(r3);
        if (r4 == false) goto L5;
        x.a(r3);
        com.bytedance.android.live.liveinteract.api.utils.g.n("rtc_mute_allremote_video", r3, r1, false);
        return;
    L5:
        x.a(r3);
        com.bytedance.android.live.liveinteract.api.utils.g.n("rtc_unmute_allremote_video", r3, r1, false);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void y4(int r3, boolean r4) {
        int r0 = x.a;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("apply_linkType", Integer.valueOf(r3));
        r1.put("videoDown2Audio", Boolean.valueOf(r4));
        x.t0("digit_avatar_video_talk_guest_apply", r1);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void Mi(boolean r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        int r1 = x.a;
        Intrinsics.checkNotNullParameter(r5, "reason");
        HashMap r2 = new HashMap();
        r2.put("reason", r5);
        r2.put("old_enable", Boolean.valueOf(r4));
        if (r3 == false) goto L5;
        x.t0("resume_local_layer_render_frame", r2);
        return;
    L5:
        x.t0("pause_local_layer_render_frame", r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void Nf(String r2, long r3, String r5) {
        Intrinsics.checkNotNullParameter(r2, "linkmicId");
        Intrinsics.checkNotNullParameter(r5, "viewInfo");
        x.h0(r2, tc0.c.h(), r3, r5);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void Xg(Throwable r2, long r3, String r5) {
        Intrinsics.checkNotNullParameter(r5, "reqFrom");
        x.k(r2, r3, r5);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void bc(String r2, Throwable r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "targetId");
        x.Z(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void fc(String r2, int r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "invitorUserId");
        x.q(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void kc(Throwable r3, long r4, Boolean r6) {
        Intrinsics.checkNotNullParameter("", "reqFrom");
        x.y(r3, r4, "", r6);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void qo(String r2, long r3, String r5) {
        Intrinsics.checkNotNullParameter(r2, "targetId");
        x.s(r2, r3, r5);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void um(Throwable r1, long r2, String r4) {
        x.e(r1, r2, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void Gn(long r1, String r3, Long r4, String r5) {
        x.v(r1, r3, r4, r5);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void em(String r2, Throwable r3, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r2, "targetId");
        x.t(r2, r3, r4, r6);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void mc(String r2, int r3, Throwable r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, "invitorUserId");
        x.r(r2, r3, r4, r5);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.l
    public final void xo(long r9, int r11, int r12, int r13, int r14, String r15) {
        Intrinsics.checkNotNullParameter(r15, "fromSource");
        x.m(r9, r11, 2, r12, r13, r14, r15);
    }
}
