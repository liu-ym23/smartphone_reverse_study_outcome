package com.bytedance.android.livesdk.gamecp;

import android.text.TextUtils;
import com.bytedance.android.gamecp.host_api.GameCpTargetUtils;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.log.o0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.gamecp.IGamecpDependService;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s implements bw.j {
    public final Set<String> a;

    public final void y1() {
    }

    public final Map<String, Object> getAdLogExtra() {
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = am2.n.f().d;
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.put("isOtherChannel", r1);
        String r3 = am2.n.f().a();
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r0.put("adId", r3);
        if (am2.n.f().c().length() <= 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L17;
        r0.put("creativeId", Long.valueOf(CastLongProtector.parseLong(am2.n.f().c())));
        am2.n r5 = am2.n.f();
        if (TextUtils.isEmpty(r5.b) == true) goto L16;
        r2 = am2.n.e(r5.b, "log_extra");
    L16:
        r0.put("logExtra", r2);
    L17:
        return r0;
    L11:
        r4 = false;
        goto L12
    }

    public s() {
        this.a = SetsKt.mutableSetOf(new String[]{"livesdk_game_promote_user_btn_show", "livesdk_game_promote_user_btn_click", "click_start", "click_start_detail", "click_pause", "click_pause_detail", "click_continue", "click_continue_detail", "download_finish", "download_failed", "click_install", "click_install_detail", "install_finish", "install_failed"});
    }

    public final String J0() {
        if (GameCpTargetUtils.g() == false) goto L6;
        return "gpsdk_";
    L6:
        return "livesdk_";
    }

    public final void A0() {
        Map r0 = com.bytedance.android.livesdk.log.e0.a;
    }

    public final void W(String r3) {
        Intrinsics.checkNotNullParameter("GameCpTargetUtils", "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        yr.b.b(6, "GameCpTargetUtils", r3);
    }

    public final Map<String, String> getFilterParamsByName(String r5) {
        o0 r0 = o0.g;
        monitor-enter(o0.class);
    L32:
        th = move-exception;
        throw th;
    L5:
        if (o0.g != null) goto L7;
        o0.g = new o0();     // Catch: Throwable -> L32
    L7:
        o0 r1 = o0.g;     // Catch: Throwable -> L32
        monitor-exit(o0.class);
        r1.getClass();
        HashMap r2 = new HashMap();
        r5.getClass();
        byte r3 = -1;
        switch(r5.hashCode()) {
            case -1310213515: goto L21;
            case -831166662: goto L17;
            case 2553083: goto L13;
            default: goto L24;
        };
    L24:
        switch(r3) {
            case 0: goto L28;
            case 1: goto L27;
            case 2: goto L26;
            default: goto L25;
        };
    L25:
        com.bytedance.android.livesdk.log.filter.o r6 = null;
    L29:
        if (r6 == null) goto L31;
        r6.a(r2);
    L31:
        return r2;
    L26:
        r6 = r1.c(Room.class);
        goto L29
    L27:
        r6 = r1.c(am2.x.class);
        goto L29
    L28:
        r6 = r1.c(am2.n.class);
        goto L29
    L13:
        if (r5.equals("Room") == false) goto L24;
        r3 = 2;
        goto L24
    L17:
        if (r5.equals("PageSourceLog") == false) goto L24;
        r3 = 1;
        goto L24
    L21:
        if (r5.equals("LiveAdLog") == false) goto L24;
        r3 = 0;
        goto L24
    }

    public final void logV3(String r7, Map<String, String> r8) {
        Iterator<String> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (TextUtils.equals(r7, r0.next()) == false) goto L4;
        boolean r1 = false;
    L10:
        if (r7 != null) goto L12;
    L14:
        if (r1 == false) goto L20;
        if (r7 != null) goto L17;
    L19:
        r7 = "tobsdk_livesdk_" + r7;
        goto L20
    L17:
        if (StringsKt.startsWith$default(r7, "livesdk", false, 2, null) != true) goto L19;
        r7 = "tobsdk_".concat(r7);
    L20:
        JSONObject r2 = new JSONObject();
        if (r8 != null) goto L23;
    L30:
        AppLogNewUtils.onEventV3(r7, r2);
        return;
    L23:
        if (r8.isEmpty() == true) goto L30;
        Iterator<String> r3 = r8.keySet().iterator();     // Catch: Exception -> L32
    L27:
        if (r3.hasNext() == false) goto L30;
        String r4 = r3.next();     // Catch: Exception -> L32
        r2.put(r4, r8.get(r4));     // Catch: Exception -> L32
    L12:
        if (StringsKt.startsWith$default(r7, "gpsdk_", false, 2, null) != true) goto L14;
        r1 = false;
        goto L14
    L8:
        r1 = true;
        goto L10
    }

    public final void logV3NoPrefix(String r3, Map<String, String> r4) {
        com.bytedance.android.livesdk.log.u.l().h(r3, r4, new Object[0]);
    }

    public final void sendLiveAdLog(String r8, String r9, Long r10, JSONObject r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "label");
        Intrinsics.checkNotNullParameter(r9, "refer");
        Intrinsics.checkNotNullParameter(r11, "adExtraData");
        jc1.k.n(IGamecpDependService.class).sendLiveAdLog(r8, r9, r10, r11, r12);
    }

    public final void H1(String r10, String r11, String r12, String r13, String r14, Map r15) {
        Intrinsics.checkNotNullParameter(r10, "label");
        Intrinsics.checkNotNullParameter("anchor_page", "refer");
        Intrinsics.checkNotNullParameter(r14, "logExtra");
        Intrinsics.checkNotNullParameter(r15, "adExtraData");
        jc1.k.n(IGamecpDependService.class).sendLiveAdLogForSaas(SourceType.ANCHOR, r10, "anchor_page", r11, r12, r13, r14, r15);
    }
}
