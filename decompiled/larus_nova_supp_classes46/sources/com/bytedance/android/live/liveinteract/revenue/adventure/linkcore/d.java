package com.bytedance.android.live.liveinteract.revenue.adventure.linkcore;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedRoomProfile;
import com.bytedance.live.livelink.kmp.api.base.event.EventCategory;
import com.bytedance.live.livelink.kmp.api.base.rtc.Env;
import io.reactivex.Observable;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements m.a {
    public final /* synthetic */ String a;

    @Override // com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.m.a
    public final void a() {
        ALogger.i("AdventureLinkService", "onDisconnectSuccess");
        String r2 = ei0.a.a;
        String r3 = this.a;
        Intrinsics.checkNotNullParameter(r3, "rtcExtInfo");
        JSONObject r11 = new JSONObject();
        r11.put("adventure_call_rtc_ext_info", r3);
        r11.put("adventure_call_user_type", ei0.a.a);
        int r4 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiRevenue, MultiTraceData$TraceEvent.AdventureCall, "adventure_call_join_rtc_room", 0, null, r11, 88);
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;
        ALogger.d("AdventureFullLinkMonitor", String.format("joinRtcRoom, extra: %s", Arrays.copyOf(new Object[]{r11}, 1)));
        if (g.e == true) goto L9;
        ALogger.i("AdventureLinkService", "init");
        g.e = true;
        a r1 = new a();
        g.a = r1;
        r1.g();
        a r6 = g.a;
        if (r6 == null) goto L8;
        r6.f();
    L8:
        g.b = new b();
        g.c = new h();
    L9:
        String r7 = this.a;
        int r8 = di0.a.a;
        Intrinsics.checkNotNullParameter(r7, "rtcExtInfo");
        if (TextUtils.isEmpty(r7) == false) goto L113;
    L18:
        ci0.a r9 = null;
    L19:
        if (r9 == null) goto L110;
        final a r10 = g.a;
        if (r10 == null) goto L74;
        Intrinsics.checkNotNullParameter(r9, "linkEngineConfig");
        ALogger.i("AdventureLinkEngine", "initEngine, linkEngineConfig: " + r9);
        r10.d = r9;
        fi6.a r12 = new fi6.a();
        r12.h(TTMiddlewareLiveSDK.getContext());
        r12.m(r9.a);
        r12.S = 5;
        String r13 = s1.B(2131922659);
        Intrinsics.checkNotNullParameter(r13, "key");
        r12.w = r13;
        String r14 = jc1.k.n(IMiddleWareHostContext.class).getChannel();
        Intrinsics.checkNotNullParameter(r14, "channel");
        r12.y = r14;
        r12.c(String.valueOf(jc1.k.n(IMiddleWareHostContext.class).appId()));
        r12.e(jc1.k.n(IMiddleWareHostContext.class).getVersionCode());
        r12.d(String.valueOf(jc1.k.n(IMiddleWareHostContext.class).getUpdateVersionCode()));
        if (vm2.i.k().getEnable() == false) goto L26;
        r12.m = true;
        r12.n = vm2.i.k().q7();
    L26:
        if (jc1.k.n(IMiddleWareHostContext.class).isBoe() == false) goto L28;
        r12.l(Env.ENV_BOE);
    L28:
        m00.g r15 = ((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class)).createVideoTalkView(TTMiddlewareLiveSDK.getContext(), "", false, false, false, null);
        r10.a = r15;
        if (r15 == null) goto L33;
        com.bytedance.android.live.pushstream.d r16 = r15.getLiveStream();
        if (r16 == null) goto L33;
        r16.I0(r10.j);
    L33:
        m00.g r17 = r10.a;
        if (r17 == null) goto L36;
        ei6.a r18 = r17.create();
    L37:
        r10.b = r18;
        if (r18 == null) goto L42;
        si6.b r19 = r18.b();
        if (r19 == null) goto L42;
        r19.g(r9.k);
    L42:
        ei6.a r20 = r10.b;
        if (r20 == null) goto L47;
        ri6.b r21 = r20.r();
        if (r21 == null) goto L47;
        r21.f(3);
    L47:
        ei6.a r22 = r10.b;
        if (r22 == null) goto L52;
        ui6.e r23 = r22.n();
        if (r23 == null) goto L52;
        mi6.b r24 = r23.d(r9.f);
    L53:
        r10.c = r24;
        ei6.a r25 = r10.b;
        if (r25 == null) goto L60;
        gi6.e r26 = r25.getEventManager();
        if (r26 == null) goto L60;
        String r27 = r26.a(EventCategory.RTC_ROOM_EVENT, null, new AdventureLinkEngine$initEventObserver$1(r10));
        if (r27 == null) goto L60;
        r10.k.add(r27);
    L60:
        ei6.a r28 = r10.b;
        if (r28 == null) goto L67;
        gi6.e r29 = r28.getEventManager();
        if (r29 == null) goto L67;
        String r30 = r29.a(EventCategory.RTC_ROOM_EVENT_EX, null, new AdventureLinkEngine$initEventObserver$2(r10));
        if (r30 == null) goto L67;
        r10.k.add(r30);
    L67:
        ei6.a r31 = r10.b;
        if (r31 == null) goto L74;
        gi6.e r32 = r31.getEventManager();
        if (r32 == null) goto L74;
        String r33 = r32.a(EventCategory.RTC_ENGINE_EVENT, null, new AdventureLinkEngine$initEventObserver$3(r10));
        if (r33 == null) goto L74;
        r10.k.add(r33);
    L52:
        r24 = null;
        goto L53
    L36:
        r18 = null;
    L74:
        a r34 = g.a;
        if (r34 == null) goto L104;
        boolean r35 = g.k.a;
        StringBuilder r36 = new StringBuilder("joinRtcRoom start, isAppBackground:");
        r36.append(r35);
        r36.append(", rtcRoomId: ");
        ei6.a r37 = r34.b;
        if (r37 == null) goto L81;
        si6.b r38 = r37.b();
        if (r38 == null) goto L81;
        String r39 = r38.m();
    L82:
        r36.append(r39);
        ALogger.i("AdventureLinkEngine", r36.toString());
        ci0.a r40 = r34.d;
        if (r40 == null) goto L104;
        r34.g = !r35;
        String r41 = r40.g;
        yf2.e r110 = new yf2.e(r40.i, "");
        LiveWrappedRoomProfile r111 = LiveWrappedRoomProfile.LIVE;
        boolean r112 = r34.g;
        yf2.d r42 = new yf2.d(r111, r112, r112, true, false);
        mi6.b r113 = r34.c;
        if (r113 == null) goto L87;
        Integer r43 = Integer.valueOf(r113.t(r41, r110, true, r42));
    L88:
        ALogger.i("AdventureLinkEngine", "joinRtcRoom end, result: " + r43);
        if (r43 == null) goto L104;
        if (r43.intValue() != 0) goto L104;
        if (r35 == false) goto L99;
        m00.g r44 = r34.a;
        if (r44 == null) goto L104;
        com.bytedance.android.live.pushstream.d r45 = r44.getLiveStream();
        if (r45 == null) goto L104;
        r45.f1("adventure join rtc background", new uv0.a(LiveRequestSourceRole.Business, "AdventureLinkEngine.joinRtcRoom.stopAudio", null));
        goto L104
    L99:
        m00.g r46 = r34.a;
        if (r46 == null) goto L104;
        com.bytedance.android.live.pushstream.d r47 = r46.getLiveStream();
        if (r47 == null) goto L104;
        r47.M0("adventure join rtc", new uv0.a(LiveRequestSourceRole.Business, "AdventureLinkEngine.joinRtcRoom.startAudio", null));
        goto L104
    L87:
        r43 = null;
    L81:
        r39 = null;
    L104:
        b r48 = g.b;
        if (r48 == null) goto L110;
        StringBuilder r49 = new StringBuilder("startCheckRtcRoomTimer, CHECK_RTC_ROOM_INTERVAL_IN_SECOND: ");
        long r50 = b.d;
        r49.append(r50);
        ALogger.i("AdventureLinkSecurityManager", r49.toString());
        if (r48.b == false) goto L109;
        ALogger.i("AdventureLinkSecurityManager", "startCheckRtcRoomTimer return, cause: isCheckRtcRoomTaskRunning == true");
        goto L110
    L109:
        r48.a.add(Observable.timer(r50, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(r48)));
        r48.b = true;
    L110:
        if (r9 != null) goto L115;
        a r51 = g.a;
        g.e(false, "invalid_rtc_ext_info");
        return;
    L115:
        return;
    L113:
        r9 = new ci0.a();     // Catch: Exception -> L17
        JSONObject r52 = new JSONObject(r7);     // Catch: Exception -> L17
        JSONObject r53 = r52.optJSONObject("live_rtc_engine_config");     // Catch: Exception -> L17
        if (r53 == null) goto L15;
        String r54 = r53.optString("rtc_app_id");     // Catch: Exception -> L17
        Intrinsics.checkNotNullParameter(r54, "<set-?>");     // Catch: Exception -> L17
        r9.b = r54;     // Catch: Exception -> L17
        String r55 = r53.optString("rtc_token");     // Catch: Exception -> L17
        Intrinsics.checkNotNullParameter(r55, "<set-?>");     // Catch: Exception -> L17
        r9.g = r55;     // Catch: Exception -> L17
        r9.c = r53.optInt("rtc_vendor");     // Catch: Exception -> L17
        r9.e = Base64.decode(r53.optString("rtc_app_sign"), 0);     // Catch: Exception -> L17
        String r56 = r53.optString("rtc_channel_id");     // Catch: Exception -> L17
        Intrinsics.checkNotNullParameter(r56, "<set-?>");     // Catch: Exception -> L17
        r9.f = r56;     // Catch: Exception -> L17
        String r57 = r53.optString("rtc_user_id");     // Catch: Exception -> L17
        Intrinsics.checkNotNullParameter(r57, "<set-?>");     // Catch: Exception -> L17
        r9.i = r57;     // Catch: Exception -> L17
        r9.j = r53.optInt("rtc_user_id_mode");     // Catch: Exception -> L17
        Intrinsics.checkNotNullParameter("byte", "<set-?>");     // Catch: Exception -> L17
        r9.d = "byte";     // Catch: Exception -> L17
        String r58 = r53.optString("user_id");     // Catch: Exception -> L17
        Intrinsics.checkNotNullParameter(r58, "<set-?>");     // Catch: Exception -> L17
        r9.h = r58;     // Catch: Exception -> L17
    L15:
        String r59 = r52.optString("rtc_business_id");     // Catch: Exception -> L17
        Intrinsics.checkNotNullParameter(r59, "<set-?>");     // Catch: Exception -> L17
        r9.k = r59;     // Catch: Exception -> L17
        Intrinsics.checkNotNullParameter(r7, "<set-?>");     // Catch: Exception -> L17
        r9.a = r7;     // Catch: Exception -> L17
        goto L19
    }

    public d(String r1) {
        this.a = r1;
    }
}
