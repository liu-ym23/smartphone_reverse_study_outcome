package com.bytedance.android.live.liveinteract.revenue.adventure.linkcore;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.bmmt.BuildConfig;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements m {
    public static com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a a;
    public static com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.b b;
    public static h c;
    public static boolean d;
    public static boolean e;
    public static boolean f;
    public static String g;
    public static Observer<Integer> h;
    public static final c i = null;
    public static final b j = null;
    public static final a k = null;
    public static final g l = null;

    public static final class a extends IHostAppMonitorListener.Stub {
        public boolean a;

        public a() {
        }

        public final void appEnterBackground(boolean r3, boolean r4) {
            ALogger.i("AdventureLinkService", "appEnterBackground, background: " + r3 + ", isRegister: " + r4);
            this.a = r3;
            if (r4 == true) goto L24;
            com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r5 = g.a;
            com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r6 = g.a;
            if (r6 != null) goto L7;
            return;
        L7:
            if (r6.e == true) goto L9;
            return;
        L9:
            if (r3 == false) goto L13;
            Intrinsics.checkNotNullParameter("appEnterBackground", "reason");
            ALogger.i("AdventureLinkService", "enterBackground, reason: appEnterBackground");
            com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r7 = g.a;
            if (r7 == null) goto L27;
            r7.e();
            return;
        L27:
            return;
        L13:
            Intrinsics.checkNotNullParameter("appEnterForeground", "reason");
            ALogger.i("AdventureLinkService", "enterForeground, reason: appEnterForeground");
            com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r8 = g.a;
            if (r8 == null) goto L16;
            r8.h();
        L16:
            com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r9 = g.a;
            if (r9 != null) goto L19;
            return;
        L19:
            if (r9.e == true) goto L21;
            return;
        L21:
            if (g.d == false) goto L31;
            g.c(true, "enterForeground");
            return;
        L31:
            return;
        }
    }

    public static final class b implements k {
        public b() {
        }

        @Override // com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.k
        public final void a(boolean r3) {
            ALogger.i("AdventureLinkService", "onLocalAudioPublishStateChanged, isPublishOpen: " + r3);
        }
    }

    public static final class c implements l {

        public static final class a implements Runnable {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r0 = g.a;     // Catch: Throwable -> L4
                g.e(false, "remote_user_leave");     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class b implements Runnable {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r0 = g.a;     // Catch: Throwable -> L4
                g.e(false, "self_user_join_failed");     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public c() {
        }

        @Override // com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.l
        public final void g() {
            ALogger.i("AdventureLinkService", "onSelfLeaveRtcRoomSuccess");
        }

        @Override // com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.l
        public final void d(String r3) {
            ALogger.i("AdventureLinkService", "onRemoteRtcUserJoined, rtcUserId: " + r3);
        }

        @Override // com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.l
        public final void e(String r2) {
            ALogger.i("AdventureLinkService", "onRemoteRtcUserLeave, rtcUserId: ".concat(r2));
            MainThreadPostUtils.b(a.a);
        }

        @Override // com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.l
        public final void f(int r3) {
            ALogger.i("AdventureLinkService", "onSelfJoinRtcRoomFailed, errorCode: " + r3);
            MainThreadPostUtils.b(b.a);
        }

        @Override // com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.l
        public final void b(String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "rtcRoomId");
            Intrinsics.checkNotNullParameter(r4, "rtcUserId");
            ALogger.i("AdventureLinkService", "onSelfJoinRtcRoomSuccess, rtcRoomId: " + r3 + ", rtcUserId: " + r4);
            com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r5 = g.a;
            g.c(true, "onSelfJoinRtcRoomSuccess");
        }
    }

    public g() {
    }

    static {
        l = new g();
        g = "";
        i = new c();
        j = new b();
        a r0 = new a();
        k = r0;
        IMiddlewareHostApp r1 = jc1.k.f(IMiddlewareHostApp.class);
        if (r1 == null) goto L6;
        r1.registerLiveLifeCycleListener(r0);
        return;
    }

    public static void b(String r9) {
        ALogger.i("AdventureLinkService", "leaveRtcRoom, source: " + r9);
        String r0 = ei0.a.a;
        if (r9 != null) goto L5;
        r9 = "unknown";
    L5:
        Intrinsics.checkNotNullParameter(r9, "reason");
        JSONObject r8 = new JSONObject();
        r8.put("reason", r9);
        r8.put("adventure_call_user_type", ei0.a.a);
        r8.put("code", "native");
        int r10 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiRevenue, MultiTraceData$TraceEvent.AdventureCall, "adventure_call_leave_rtc_room", 0, null, r8, 88);
        StringCompanionObject r11 = StringCompanionObject.INSTANCE;
        ALogger.d("AdventureFullLinkMonitor", String.format("leaveRtcRoom, extra: %s", Arrays.copyOf(new Object[]{r8}, 1)));
        f2.g();
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r12 = a;
        if (r12 == null) goto L15;
        ALogger.i("AdventureLinkEngine", "leaveRtcRoom");
        mi6.b r1 = r12.c;
        if (r1 == null) goto L10;
        r1.leaveRoom();
    L10:
        m00.g r13 = r12.a;
        if (r13 == null) goto L15;
        com.bytedance.android.live.pushstream.d r14 = r13.getLiveStream();
        if (r14 == null) goto L15;
        r14.f1("adventure leave rtc room", new uv0.a(LiveRequestSourceRole.Business, "AdventureLinkEngine.leaveRtcRoom.stopAudio", null));
    L15:
        d("leaveRtcRoom");
    }

    public static void d(String r4) {
        ALogger.i("AdventureLinkService", "release, source: ".concat(r4));
        e = false;
        f = false;
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r0 = a;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        a = null;
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.b r1 = b;
        if (r1 == null) goto L8;
        ALogger.i("AdventureLinkSecurityManager", BuildConfig.BUILD_TYPE);
        r1.a.clear();
    L8:
        b = null;
        c(false, BuildConfig.BUILD_TYPE);
        h r2 = c;
        if (r2 == null) goto L11;
        MainThreadPostUtils.b(new j(r2));
    L11:
        c = null;
        d = false;
        g = "";
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.m
    public final void a(String r5) {
        ALogger.i("AdventureLinkService", "checkRtcRoom, source: " + r5);
        f2.g();
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r0 = a;
        boolean r1 = false;
        if (r0 == null) goto L12;
        ALogger.i("AdventureLinkEngine", "checkRtcRoom, isSelfJoinedRTCRoom: " + r0.e + ", isRemoteJoinedRTCRoom: " + r0.f);
        if (r0.e == true) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 != true) goto L12;
        r1 = true;
        goto L12
    L7:
        if (r0.f == false) goto L9;
        r2 = true;
    L12:
        e(r1, r5);
    }

    public static void c(boolean r2, String r3) {
        ALogger.i("AdventureLinkService", "muteLiveRoom, isMute: " + r2 + ", source: " + r3 + ", isMuteByAdventure: " + d);
        if (r2 == false) goto L8;
        d = true;
        h r4 = c;
        if (r4 == null) goto L13;
        MainThreadPostUtils.b(new i(r4, true));
        return;
    L13:
        return;
    L8:
        if (d == false) goto L15;
        d = false;
        h r5 = c;
        if (r5 == null) goto L16;
        MainThreadPostUtils.b(new i(r5, false));
        return;
    L16:
        return;
    }

    public static void e(boolean r14, String r15) {
        StringBuilder r0 = new StringBuilder("sendCheckRtcRoomResult, success: ");
        r0.append(r14);
        r0.append(", source: ");
        r0.append(r15);
        r0.append(", isSelfJoin: ");
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r1 = a;
        if (r1 == null) goto L5;
        Boolean r2 = Boolean.valueOf(r1.e);
    L6:
        r0.append(r2);
        r0.append(", isRemoteJoin: ");
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r3 = a;
        if (r3 == null) goto L9;
        Boolean r4 = Boolean.valueOf(r3.f);
    L10:
        r0.append(r4);
        ALogger.i("AdventureLinkService", r0.toString());
        f2.g();
        String r5 = ei0.a.a;
        if (r15 != null) goto L13;
        r15 = "unknown";
    L13:
        String r6 = g;
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r7 = a;
        if (r7 == null) goto L16;
        boolean r8 = r7.e;
    L17:
        if (r7 == null) goto L19;
        boolean r9 = r7.f;
    L20:
        Intrinsics.checkNotNullParameter(r15, "reason");
        Intrinsics.checkNotNullParameter(r6, "rtcExtInfo");
        JSONObject r10 = new JSONObject();
        r10.put("reason", r15);
        r10.put("adventure_call_user_type", ei0.a.a);
        r10.put("adventure_call_rtc_ext_info", r6);
        r10.put("isSuccess", r14);
        r10.put("isSelfUserJoinSuccess", r8);
        r10.put("isRemoteUserJoinSuccess", r9);
        int r16 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiRevenue, MultiTraceData$TraceEvent.AdventureCall, "adventure_call_check_rtc_room", 0, null, r10, 88);
        StringCompanionObject r17 = StringCompanionObject.INSTANCE;
        ALogger.d("AdventureFullLinkMonitor", String.format("checkRtcRoom, extra: %s", Arrays.copyOf(new Object[]{r10}, 1)));
        JsonObject r18 = new JsonObject();
        r18.addProperty("success", Boolean.valueOf(r14));
        ai0.c r11 = ai0.c.a;
        Intrinsics.checkNotNullParameter("check_rtc_room", "type");
        JsonObject r12 = new JsonObject();
        r12.addProperty("type", "check_rtc_room");
        r12.add("data", r18);
        ih0.b r19 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(null);
        if (r19 == null) goto L23;
        r19.Dk("adventure", "adventure_event", r12, false);
    L23:
        if (r14 == false) goto L25;
        MainThreadPostUtils.b(new f(null));
        return;
    L25:
        b("check_rtc_room_failed");
        return;
    L19:
        r9 = false;
        goto L20
    L16:
        r8 = false;
        goto L17
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
