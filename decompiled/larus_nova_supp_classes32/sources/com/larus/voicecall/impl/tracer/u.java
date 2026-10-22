package com.larus.voicecall.impl.tracer;

import android.os.SystemClock;
import com.ixigua.lib.track.TrackParams;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.assistant.RiskPreferenceSettings;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class u {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[IRealtimeCallTracer.TotalTimeType.values().length];
            r0[IRealtimeCallTracer.TotalTimeType.SCREEN_SHARE_START_TIME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L32:
            r0[IRealtimeCallTracer.TotalTimeType.VIDEO_SHARE_START_TIME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L42:
            r0[IRealtimeCallTracer.TotalTimeType.SUBTITLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L8:
            a = r0;
            int[] r1 = new int[IRealtimeCallTracer.HelloStatus.values().length];
            r1[IRealtimeCallTracer.HelloStatus.START_SESSION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L34:
            r1[IRealtimeCallTracer.HelloStatus.TRIGGER_HELLO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L44:
            r1[IRealtimeCallTracer.HelloStatus.SESSION_SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L28:
            r1[IRealtimeCallTracer.HelloStatus.PLAY_HELLO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L36:
            r1[IRealtimeCallTracer.HelloStatus.INTERRUPT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L30:
            r1[IRealtimeCallTracer.HelloStatus.PLAY_END.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L38:
            r1[IRealtimeCallTracer.HelloStatus.HELLO_RESET.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L16:
            b = r1;
        }
    }

    public static final String a(RealtimeCallTracer r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.i == false) goto L6;
        return "screen_share";
    L6:
        if (r1.j == false) goto L8;
        return "video_call";
    L8:
        return LynxResourceModule.AUDIO_TYPE;
    }

    public static final void b(RealtimeCallTracer r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Iterator r10 = ((LinkedHashMap) r9.c0).entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        y r0 = (y) ((Map.Entry) r10.next()).getValue();
        if (r0.b <= 0) goto L8;
        r0.a += SystemClock.elapsedRealtime() - r0.b;
    L8:
        r0.b = 0;
        goto L4
    }

    public static final void e(RealtimeCallTracer r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.H = 0;
        r2.J = 0;
        r2.I = 0;
        if (r3 == false) goto L6;
        r2.K = 0;
        return;
    }

    public static final void c(RealtimeCallTracer r13, boolean r14, String r15) {
        Intrinsics.checkNotNullParameter(r13, "<this>");
        long r0 = System.currentTimeMillis();
        long r2 = r13.K;
        long r4 = 0;
        if (r2 <= 0) goto L5;
        r4 = r0 - r2;
    L5:
        RealtimeCallParam r1 = (RealtimeCallParam) r13.b.invoke();
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.l == null) goto L8;
        long r3 = 2;
    L9:
        long r6 = r14 ? 1 : 0;
        JSONObject r16 = new JSONObject();
        RealtimeCallTracer.C0(r1, r16);
        r13.w0(r16);
        String r5 = r1.e;
        String r8 = r1.o.h;
        RealtimeCallParam.k r7 = r1.p;
        String r9 = r7.g;
        String r10 = r7.i;
        if (r13.i == false) goto L13;
        String r11 = "screen_share";
    L17:
        if (RealtimeCallUtil.J == false) goto L22;
        if (RealtimeCallUtil.l == null) goto L22;
        String r12 = RiskPreferenceSettings.SMART_BALANCE;
    L27:
        String r17 = RealtimeCallUtil.I;
        Long r18 = Long.valueOf(r3);
        Long r19 = Long.valueOf(r4);
        Long r20 = Long.valueOf(r6);
        Intrinsics.checkNotNullParameter(r16, LynxResourceModule.PARAMS_KEY);
        if (r18 != null) goto L55;
    L32:
        if (r19 == null) goto L34;
        r16.put("total", r19.longValue());     // Catch: JSONException -> L30
    L34:
        if (r20 == null) goto L36;
        r16.put("is_success", r20.longValue());     // Catch: JSONException -> L30
    L36:
        if (r15 == null) goto L38;
        r16.put("fail_reason", r15);     // Catch: JSONException -> L30
    L38:
        if (r5 == null) goto L40;
        r16.put("call_id", r5);     // Catch: JSONException -> L30
    L40:
        if (r8 == null) goto L42;
        r16.put("bot_id", r8);     // Catch: JSONException -> L30
    L42:
        if (r9 == null) goto L44;
        r16.put("chat_type", r9);     // Catch: JSONException -> L30
    L44:
        if (r10 == null) goto L46;
        r16.put("enter_method", r10);     // Catch: JSONException -> L30
    L46:
        r16.put("call_background_mode", r11);     // Catch: JSONException -> L30
        if (r12 == null) goto L49;
        r16.put("realtime_call_hello_type", r12);     // Catch: JSONException -> L30
    L49:
        if (r17 == null) goto L53;
        r16.put("realtime_call_hello_tech_type", r17);     // Catch: JSONException -> L30
    L30:
        e = move-exception;
        FLogger.a.e("RealtimeEventHelper", "error in RealtimeEventHelper mobRealtimeCallHelloPlay " + e.getLocalizedMessage());
    L53:
        TrackParams r110 = new TrackParams().merge(r16);
        by7.a r111 = new by7.a("realtime_call_hello_play");
        r111.a.merge(r110);
        r111.b();
        e(r13, true);
        return;
    L55:
        r16.put("hello_type", r18.longValue());     // Catch: JSONException -> L30
    L22:
        if (RealtimeCallUtil.J == true) goto L24;
    L26:
        r12 = null;
        goto L27
    L24:
        if (RealtimeCallUtil.l != null) goto L26;
        r12 = "1";
        goto L27
    L13:
        if (r13.j == false) goto L15;
        r11 = "video_call";
        goto L17
    L15:
        r11 = "others";
        goto L17
    L8:
        r3 = 1;
        goto L9
    }

    public static void d(RealtimeCallTracer r19, boolean r20, String r21, String r22, RealtimeCallParam r23, int r24) {
        if ((r24 & 2) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r24 & 4) == 0) goto L9;
        String r4 = null;
    L10:
        Intrinsics.checkNotNullParameter(r19, "<this>");
        long r5 = r19.K;
        if (r5 <= 0) goto L15;
        long r10 = r19.H;
        if (r10 <= 0) goto L15;
        long r11 = r5 - r10;
    L16:
        long r13 = 1;
        String r25 = r4;
        if (r5 <= 0) goto L26;
        long r3 = r19.J;
        long r7 = r19.H;
        if (1 <= r7) goto L21;
    L23:
        boolean r18 = false;
    L24:
        if (r18 == false) goto L26;
        long r6 = r3 - r7;
    L27:
        if (r5 <= 0) goto L31;
        long r8 = r19.I;
        long r16 = 0;
        if (r8 <= 0) goto L32;
        long r9 = r5 - r8;
    L33:
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.l == null) goto L36;
        r13 = 2;
    L36:
        long r12 = r20 ? 1 : 0;
        RealtimeCallParam r14 = (RealtimeCallParam) r19.b.invoke();
        JSONObject r15 = new JSONObject();
        RealtimeCallTracer.C0(r14, r15);
        r19.w0(r15);
        if (r23 == null) goto L41;
        RealtimeCallParam.p r17 = r23.o;
        if (r17 == null) goto L41;
        String r26 = r17.h;
    L42:
        if (r23 == null) goto L44;
        String r110 = r23.e;
    L45:
        if (r23 == null) goto L49;
        RealtimeCallParam.k r0 = r23.p;
        if (r0 == null) goto L49;
        String r27 = r0.g;
    L51:
        if (r19.i == false) goto L54;
        String r1 = "screen_share";
    L58:
        if (RealtimeCallUtil.J == false) goto L63;
        if (RealtimeCallUtil.l == null) goto L63;
        String r111 = RiskPreferenceSettings.SMART_BALANCE;
    L67:
        String r28 = r111;
    L69:
        String r29 = RealtimeCallUtil.I;
        Long r112 = Long.valueOf(r13);
        Long r113 = Long.valueOf(r11);
        Long r30 = Long.valueOf(r6);
        Long r31 = Long.valueOf(r9);
        Long r32 = Long.valueOf(r12);
        Intrinsics.checkNotNullParameter(r15, LynxResourceModule.PARAMS_KEY);
        if (r112 != null) goto L101;
    L74:
        if (r113 == null) goto L76;
        r15.put("total", r113.longValue());     // Catch: JSONException -> L72
    L76:
        if (r30 == null) goto L78;
        r15.put("connect", r30.longValue());     // Catch: JSONException -> L72
    L78:
        if (r31 == null) goto L80;
        r15.put("waiting_hello", r31.longValue());     // Catch: JSONException -> L72
    L80:
        if (r32 == null) goto L82;
        r15.put("is_success", r32.longValue());     // Catch: JSONException -> L72
    L82:
        if (r2 == null) goto L84;
        r15.put("fail_reason", r2);     // Catch: JSONException -> L72
    L84:
        if (r25 == null) goto L86;
        r15.put("enter_method", r25);     // Catch: JSONException -> L72
    L86:
        if (r26 == null) goto L88;
        r15.put("bot_id", r26);     // Catch: JSONException -> L72
    L88:
        if (r110 == null) goto L90;
        r15.put("call_id", r110);     // Catch: JSONException -> L72
    L90:
        if (r27 == null) goto L92;
        r15.put("chat_type", r27);     // Catch: JSONException -> L72
    L92:
        r15.put("call_background_mode", r1);     // Catch: JSONException -> L72
        if (r28 == null) goto L95;
        r15.put("realtime_call_hello_type", r28);     // Catch: JSONException -> L72
    L95:
        if (r29 == null) goto L99;
        r15.put("realtime_call_hello_tech_type", r29);     // Catch: JSONException -> L72
    L72:
        e = move-exception;
        FLogger.a.e("RealtimeEventHelper", "error in RealtimeEventHelper mobRealtimeCallHelloTime " + e.getLocalizedMessage());
    L99:
        TrackParams r33 = new TrackParams().merge(r15);
        by7.a r34 = new by7.a("realtime_call_hello_time");
        r34.a.merge(r33);
        r34.b();
        e(r19, false);
        return;
    L101:
        r15.put("hello_type", r112.longValue());     // Catch: JSONException -> L72
    L63:
        if (RealtimeCallUtil.J == true) goto L65;
    L68:
        r28 = null;
        goto L69
    L65:
        if (RealtimeCallUtil.l != null) goto L68;
        r111 = "1";
        goto L67
    L54:
        if (r19.j == false) goto L56;
        r1 = "video_call";
        goto L58
    L56:
        r1 = "others";
    L49:
        r27 = null;
        goto L51
    L44:
        r110 = null;
    L41:
        r26 = null;
    L32:
        r9 = r16;
        goto L33
    L31:
        r16 = 0;
        goto L32
    L21:
        if (r7 >= r3) goto L23;
        r18 = true;
    L26:
        r6 = 0;
    L15:
        r11 = 0;
        goto L16
    L9:
        r4 = r22;
        goto L10
    L5:
        r2 = r21;
        goto L7
    }
}
