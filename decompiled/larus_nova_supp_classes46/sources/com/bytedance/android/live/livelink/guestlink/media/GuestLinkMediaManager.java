package com.bytedance.android.live.livelink.guestlink.media;

import android.content.Context;
import com.bytedance.android.live.livelink.guestlink.pipeline.GuestLinkPipeLineManager$startRtcEngine$1;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedMediaStreamType;
import com.bytedance.android.livesdkapi.interact.data.LinkConstantKt_live_model_apiKt;
import com.bytedance.android.scope.m;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.live.livelink.kmp.api.base.event.EventCategory;
import com.bytedance.live.livelink.kmp.api.base.rtc.Env;
import com.bytedance.live.livelink.kmp.impl.base.thread.ThreadManager;
import cy0.j;
import gi6.e;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import oi6.c;
import org.json.JSONObject;
import ui6.d;
import vm2.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class GuestLinkMediaManager extends lb6.b implements ob6.a {
    public static final /* synthetic */ int s = 0;
    public ec6.a b;
    public ei6.a c;
    public boolean d;
    public ob6.b e;
    public boolean f;
    public boolean g;
    public final Set<String> h;
    public boolean i;
    public ob6.a.b j;
    public ob6.a.a k;
    public final ThreadManager l;
    public boolean m;
    public final com.bytedance.android.live.livelink.guestlink.media.a n;
    public final b o;
    public final Lazy p;
    public final Context q;
    public final fc6.a r;

    public static final class a {
    }

    static {
    }

    public final boolean C() {
        jy0.b.d("GuestLinkMediaManager", "checkRtcRoom, isSelfJoinedRTCRoom: " + this.f + ", isRemoteJoinedRTCRoom: " + this.g);
        if (this.f == true) goto L5;
    L7:
        return false;
    L5:
        if (this.g == false) goto L7;
        return true;
    }

    public final void H() {
        Iterator<String> r0 = this.h.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        String r1 = r0.next();
        ei6.a r2 = this.c;
        if (r2 == null) goto L4;
        e r3 = r2.getEventManager();
        if (r3 == null) goto L4;
        r3.c(r1);
        goto L4
    L10:
        this.h.clear();
    }

    public final void destroyEngine() {
        ThreadManager r0 = this.l;
        if (r0 == null) goto L6;
        c.c(r0, new AnonymousClass1(this), "GuestLinkMediaManager");
        return;
    }

    public final void p() {
        jy0.b.d("GuestLinkMediaManager", "leaveRtcRoom");
        ei6.a r2 = this.c;
        if (r2 == null) goto L7;
        si6.b r3 = r2.b();
        if (r3 == null) goto L7;
        si6.a.b(r3, false, "leaveRtcRoom", 3);
    L7:
        jy0.b.d("GuestLinkMediaManager", "switchAudioCapture, isOpen: false, reason: adventure leave rtc room");
        ei6.a r1 = this.c;
        if (r1 == null) goto L14;
        d r4 = r1.l();
        if (r4 == null) goto L14;
        mi6.a r5 = r4.b();
        if (r5 == null) goto L14;
        jy0.b.d("GuestLinkMediaManager", "switchAudioCapture call success");
        r5.f();
    L14:
        cy0.e.a.getClass();
        j r0 = cy0.e.a.a;
        m.e.getClass();
        Object r6 = m.b(r0).a(Reflection.getOrCreateKotlinClass(ly0.a.class));
        Intrinsics.checkNotNull(r6);
        ((f80.a) r6).o5(this.n);
    }

    public final void detach() {
        super.detach();
        ThreadManager r0 = this.l;
        if (r0 == null) goto L6;
        r0.g();
        return;
    }

    public final ei6.a A() {
        return this.c;
    }

    public final Context getContext() {
        return this.q;
    }

    public final ec6.a n() {
        return this.b;
    }

    public final void f(com.bytedance.android.live.livelink.guestlink.pipeline.b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.k = r2;
    }

    public final void s(String r10) {
        Intrinsics.checkNotNullParameter(r10, "rtcExtInfo");
        StringBuilder r1 = new StringBuilder("joinRtcRoom start, isAppBackground:");
        r1.append(this.m);
        r1.append(", rtcRoomId: ");
        ei6.a r2 = this.c;
        String r3 = null;
        if (r2 == null) goto L7;
        si6.b r4 = r2.b();
        if (r4 == null) goto L7;
        String r5 = r4.m();
    L8:
        r1.append(String.valueOf(r5));
        jy0.b.d("GuestLinkMediaManager", r1.toString());
        Intrinsics.checkNotNullParameter(r10, "rtcExtInfo");
        if (this.d == false) goto L11;
        jy0.b.c("GuestLinkMediaManager", "initEngine, return reason: mIsRtcEngineInit is true", null, 4);
    L84:
        if (this.e == null) goto L110;
        this.i = !this.m;
        ei6.a r11 = this.c;
        if (r11 == null) goto L90;
        fi6.a r12 = r11.g();
        if (r12 == null) goto L90;
        r12.e0 = this.i;
    L90:
        ei6.a r13 = this.c;
        if (r13 == null) goto L95;
        fi6.a r14 = r13.g();
        if (r14 == null) goto L95;
        r14.f0 = true;
    L95:
        ei6.a r15 = this.c;
        if (r15 == null) goto L100;
        fi6.a r16 = r15.g();
        if (r16 == null) goto L100;
        r16.g0 = true;
    L100:
        ei6.a r17 = this.c;
        if (r17 == null) goto L110;
        si6.b r18 = r17.b();
        if (r18 == null) goto L110;
        ei6.a r0 = this.c;
        if (r0 == null) goto L109;
        si6.b r6 = r0.b();
        if (r6 == null) goto L109;
        r3 = r6.m();
    L109:
        si6.a.a(r18, String.valueOf(r3), false, 14);
    L110:
        cy0.e.a.getClass();
        j r19 = cy0.e.a.a;
        m.e.getClass();
        Object r110 = m.b(r19).a(Reflection.getOrCreateKotlinClass(ly0.a.class));
        Intrinsics.checkNotNull(r110);
        ((f80.a) r110).y0(this.n);
        return;
    L11:
        int r7 = ob6.c.a;
        Intrinsics.checkNotNullParameter(r10, "rtcExtInfo");
        if (r10.length() <= 0) goto L14;
        boolean r8 = true;
    L15:
        if (r8 == true) goto L112;
    L23:
        ob6.b r9 = null;
    L24:
        this.e = r9;
        jy0.b.d("GuestLinkMediaManager", "initEngine, linkEngineConfig: " + this.e);
        ob6.b r111 = this.e;
        if (r111 == null) goto L84;
        fi6.a r20 = new fi6.a();
        r20.h(this.q);
        r20.m(r111.a);
        r20.S = 5;
        Intrinsics.checkNotNullParameter("douyin_live", "key");
        r20.w = "douyin_live";
        KmpEnv r21 = KmpEnv.a;
        String r22 = vh6.c.b(wh6.a.class).getChannel();
        if (r22 != null) goto L29;
        r22 = "";
    L29:
        Intrinsics.checkNotNullParameter(r22, "channel");
        r20.y = r22;
        r20.c(String.valueOf(vh6.c.b(wh6.a.class).getAppId()));
        r20.e(vh6.c.b(wh6.a.class).getVersionCode());
        r20.d(String.valueOf(vh6.c.b(wh6.a.class).getUpdateVersionCode()));
        if (i.k().getEnable() == false) goto L33;
        r20.m = true;
        r20.n = i.k().q7();
    L33:
        if (vh6.c.b(wh6.a.class).isBoe() == false) goto L35;
        r20.l(Env.ENV_BOE);
    L35:
        r20.Z = true;
        r20.N = LinkConstantKt_live_model_apiKt.getVOLUME_CALLBACK_INTERVAL();
        r20.j = 1;
        sk0.b r23 = this.r.L();
        this.b = r23;
        if (r23 == null) goto L40;
        sk0.c r24 = r23.a;
        if (r24 == null) goto L40;
        r24.a(this.o);
    L40:
        ec6.a r25 = this.b;
        if (r25 == null) goto L43;
        ei6.a r26 = r25.q(r20);
    L44:
        this.c = r26;
        if (r26 == null) goto L51;
        d r27 = r26.l();
        if (r27 == null) goto L51;
        mi6.a r28 = r27.b();
        if (r28 == null) goto L51;
        r28.g(r111.k);
    L51:
        ei6.a r112 = this.c;
        if (r112 == null) goto L56;
        e r113 = r112.getEventManager();
        if (r113 == null) goto L56;
        r113.b((GuestLinkMediaManager$mRtcListener$2.AnonymousClass1) this.p.getValue());
    L56:
        ei6.a r114 = this.c;
        if (r114 == null) goto L61;
        ri6.b r115 = r114.r();
        if (r115 == null) goto L61;
        r115.f(3);
    L61:
        ei6.a r116 = this.c;
        if (r116 == null) goto L68;
        e r117 = r116.getEventManager();
        if (r117 == null) goto L68;
        String r118 = r117.a(EventCategory.RTC_ROOM_EVENT, null, new GuestLinkMediaManager$initEventObserver$1(this));
        if (r118 == null) goto L68;
        this.h.add(r118);
    L68:
        ei6.a r119 = this.c;
        if (r119 == null) goto L75;
        e r120 = r119.getEventManager();
        if (r120 == null) goto L75;
        String r121 = r120.a(EventCategory.RTC_ROOM_EVENT_EX, null, new GuestLinkMediaManager$initEventObserver$2(this));
        if (r121 == null) goto L75;
        this.h.add(r121);
    L75:
        ei6.a r122 = this.c;
        if (r122 == null) goto L82;
        e r123 = r122.getEventManager();
        if (r123 == null) goto L82;
        String r124 = r123.a(EventCategory.RTC_ENGINE_EVENT, null, new GuestLinkMediaManager$initEventObserver$3(this));
        if (r124 == null) goto L82;
        this.h.add(r124);
    L82:
        this.d = true;
        goto L84
    L43:
        r26 = null;
        goto L44
    L112:
        r9 = new ob6.b();     // Catch: Exception -> L22
        JSONObject r29 = new JSONObject(r10);     // Catch: Exception -> L22
        JSONObject r30 = r29.optJSONObject("live_rtc_engine_config");     // Catch: Exception -> L22
        if (r30 == null) goto L20;
        String r31 = r30.optString("rtc_app_id");     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter(r31, "<set-?>");     // Catch: Exception -> L22
        r9.b = r31;     // Catch: Exception -> L22
        String r32 = r30.optString("rtc_token");     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter(r32, "<set-?>");     // Catch: Exception -> L22
        r9.g = r32;     // Catch: Exception -> L22
        r9.c = r30.optInt("rtc_vendor");     // Catch: Exception -> L22
        int r33 = com.bytedance.revenue.platform.api.core.a.a;     // Catch: Exception -> L22
        r9.e = com.bytedance.revenue.platform.api.core.a.a(r30.optString("rtc_app_sign"));     // Catch: Exception -> L22
        String r34 = r30.optString("rtc_channel_id");     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter(r34, "<set-?>");     // Catch: Exception -> L22
        r9.f = r34;     // Catch: Exception -> L22
        String r35 = r30.optString("rtc_user_id");     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter(r35, "<set-?>");     // Catch: Exception -> L22
        r9.i = r35;     // Catch: Exception -> L22
        r9.j = r30.optInt("rtc_user_id_mode");     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter("byte", "<set-?>");     // Catch: Exception -> L22
        r9.d = "byte";     // Catch: Exception -> L22
        String r36 = r30.optString("user_id");     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter(r36, "<set-?>");     // Catch: Exception -> L22
        r9.h = r36;     // Catch: Exception -> L22
    L20:
        String r37 = r29.optString("rtc_business_id");     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter(r37, "<set-?>");     // Catch: Exception -> L22
        r9.k = r37;     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter(r10, "<set-?>");     // Catch: Exception -> L22
        r9.a = r10;     // Catch: Exception -> L22
    L14:
        r8 = false;
    L7:
        r5 = null;
        goto L8
    }

    public final void u(GuestLinkPipeLineManager$startRtcEngine$1 r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.j = r2;
    }

    public GuestLinkMediaManager(Context r2, fc6.a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "hostService");
        this.q = r2;
        this.r = r3;
        this.h = new LinkedHashSet();
        this.i = true;
        this.l = new ThreadManager();
        this.n = new com.bytedance.android.live.livelink.guestlink.media.a(this);
        this.o = new b(this);
        this.p = LazyKt.lazy(new GuestLinkMediaManager$mRtcListener$2(this));
    }

    public static final void F(GuestLinkMediaManager r1, String r2, LiveWrappedMediaStreamType r3) {
        r1.getClass();
        jy0.b.d("GuestLinkMediaManager", "onUserPublishStream, uid: " + r2 + ", type: " + r3);
    }

    public static final void G(GuestLinkMediaManager r1, String r2, LiveWrappedMediaStreamType r3) {
        r1.getClass();
        jy0.b.d("GuestLinkMediaManager", "onUserUnpublishStream, uid: " + r2 + ", type: " + r3 + ", reason: null");
    }
}
