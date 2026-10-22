package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import com.bytedance.android.live.browser.jsbridge.base.CommunityLiveAppointmentStatusResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.livesdkapi.announcement.IAnnouncementService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "community.liveAppointmentStatus")
public final class j2 extends w20.e0<w20.k8, CommunityLiveAppointmentStatusResultModel> {
    public j2() {
    }

    public static String j(List r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "scheduleTime");
        Calendar r0 = Calendar.getInstance();
        Object r1 = r0.clone();
        if (r1 == null) goto L39;
        Calendar r2 = (Calendar) r1;
        Iterator r13 = r11.iterator();
        int r3 = Integer.MAX_VALUE;
    L6:
        if (r13.hasNext() == false) goto L37;
        int r4 = (((Number) r13.next()).intValue() - r0.get(7)) + 1;
        if (r4 != 0) goto L28;
        Intrinsics.checkNotNullParameter(r12, "inputTime");
        if (r12.length() != 3) goto L13;
        String r5 = "0".concat(r12);
    L15:
        String r6 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        if (r5 == null) goto L23;
        String r7 = r6 + ' ' + r5.substring(0, 2) + ':' + r5.substring(2, 4) + ":00";
        System.out.println("fullTime：" + r7);
        long r8 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(r7).getTime();     // Catch: Exception -> L20
    L26:
        if (System.currentTimeMillis() <= r8) goto L28;
        r4 = r4 + 7;
    L20:
        e = move-exception;
        e.printStackTrace();
    L24:
        r8 = 0;
        goto L26
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L13:
        if (r12.length() != 4) goto L24;
        r5 = r12;
    L28:
        if (r4 >= 0) goto L30;
        r4 = r4 + 7;
    L30:
        if (r4 >= r3) goto L6;
        Object r9 = r0.clone();
        if (r9 == null) goto L35;
        r2 = (Calendar) r9;
        r2.add(5, r4);
        r3 = r4;
        goto L6
    L35:
        throw new NullPointerException("null cannot be cast to non-null type java.util.Calendar");
    L37:
        return new SimpleDateFormat("yyyyMMdd").format(r2.getTime());
    L39:
        throw new NullPointerException("null cannot be cast to non-null type java.util.Calendar");
    }

    public final void invoke(Object r17, CallContext r18) {
        w20.k8 r0 = (w20.k8) r17;
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r18, "context");
        Boolean r1 = r0.b();     // Catch: Exception -> L65
        JsonObject r2 = r0.a();     // Catch: Exception -> L65
        Boolean r3 = null;
        if (r2 == null) goto L6;
        String r4 = r2.toString();     // Catch: Exception -> L65
    L7:
        com.bytedance.android.live.browser.jsbridge.protobuf.b r5 = (com.bytedance.android.live.browser.jsbridge.protobuf.b) JsonUtil.parse(r4, com.bytedance.android.live.browser.jsbridge.protobuf.b.class);     // Catch: Exception -> L65
        if (r5 == null) goto L10;
        List<Integer> r12 = r5.g();     // Catch: Exception -> L65
    L11:
        if (r5 == null) goto L13;
        String r6 = r5.a();     // Catch: Exception -> L65
    L14:
        if (r5 == null) goto L16;
        String r7 = r5.d();     // Catch: Exception -> L65
    L17:
        if (r5 == null) goto L19;
        Long r8 = r5.e();     // Catch: Exception -> L65
    L20:
        if (r5 == null) goto L22;
        Long r9 = r5.f();     // Catch: Exception -> L65
    L23:
        if (r5 == null) goto L25;
        String r11 = r5.b();     // Catch: Exception -> L65
    L26:
        if (r5 == null) goto L29;
        Integer r13 = r5.c();     // Catch: Exception -> L65
    L31:
        if (r8 != null) goto L70;
    L34:
        if (r12 != null) goto L36;
    L38:
        Boolean r14 = Boolean.TRUE;     // Catch: Exception -> L65
        if (Intrinsics.areEqual(r1, r14) == false) goto L60;
        IAnnouncementService r15 = jc1.k.f(IAnnouncementService.class);     // Catch: Exception -> L65
        if (r15 == null) goto L57;
        Activity r16 = com.bytedance.android.livesdk.utils.z2.b.getActivity();     // Catch: Exception -> L65
        String r19 = String.valueOf(r8);     // Catch: Exception -> L65
        String r21 = String.valueOf(r9);     // Catch: Exception -> L65
        if (r6 != null) goto L46;
        r6 = "";
    L46:
        if (r7 != null) goto L48;
        String r110 = "";
    L49:
        if (r13 == null) goto L51;
        int r22 = r13.intValue();     // Catch: Exception -> L65
    L52:
        Pair[] r23 = new Pair[3];     // Catch: Exception -> L65
        r23[0] = TuplesKt.to("enter_from_merge", "");     // Catch: Exception -> L65
        r23[1] = TuplesKt.to("enter_method", "jsb");     // Catch: Exception -> L65
        if (r11 != null) goto L55;
        r11 = "";
    L55:
        r23[2] = TuplesKt.to("appointment_id", r11);     // Catch: Exception -> L65
        r3 = Boolean.valueOf(r15.addAudienceAnnounceCalendar(r16, r19, r21, r6, r110, r22, MapsKt.mutableMapOf(r23), r12));     // Catch: Exception -> L65
        goto L57
    L51:
        r22 = 0;
        goto L52
    L48:
        r110 = r7;
    L57:
        if ((!Intrinsics.areEqual(r3, r14)) == false) goto L72;
        com.bytedance.android.live.core.utils.f2.c("预约成功，开播时将通知你", 0);     // Catch: Exception -> L65
        return;
    L72:
        return;
    L60:
        if (Intrinsics.areEqual(r1, Boolean.FALSE) == false) goto L74;
        IAnnouncementService r24 = jc1.k.f(IAnnouncementService.class);     // Catch: Exception -> L65
        if (r24 == null) goto L75;
        r24.removeAudienceAnnounceCalendar(com.bytedance.android.livesdk.utils.z2.b.getActivity(), String.valueOf(r11));     // Catch: Exception -> L65
        return;
    L75:
        return;
    L74:
        return;
    L36:
        if ((!r12.isEmpty()) != true) goto L38;
        r8 = Long.valueOf(com.bytedance.android.livesdk.utils.d5.c(j(r12, String.valueOf(r9))));     // Catch: Exception -> L68
    L77:
        return;
    L70:
        if (r8.longValue() != 0) goto L38;
    L29:
        r13 = null;
        goto L31
    L25:
        r11 = null;
        goto L26
    L22:
        r9 = null;
        goto L23
    L19:
        r8 = null;
        goto L20
    L16:
        r7 = null;
        goto L17
    L13:
        r6 = null;
        goto L14
    L10:
        r12 = null;
        goto L11
    L6:
        r4 = null;
    L65:
        e = move-exception;
        ALogger.e("CommunityLiveAppointmentStatusMethod", e.toString());
    }
}
