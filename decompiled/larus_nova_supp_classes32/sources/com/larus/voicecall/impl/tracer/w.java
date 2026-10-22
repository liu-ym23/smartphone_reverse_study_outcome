package com.larus.voicecall.impl.tracer;

import com.ixigua.lib.track.TrackParams;
import com.larus.im.bean.bot.SceneModel;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class w {
    public static long a;
    public static long b;
    public static boolean c;
    public static a d;

    public static final class a {
        public final String a;
        public final String b;
        public final String c;
        public final String d;

        public a() {
            this(NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, null);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + this.c.hashCode()) * 31;
            String r5 = this.d;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "SubtitleTracerParam(botId=" + this.a + ", callId=" + this.b + ", conversationId=" + this.c + ", chatType=" + this.d + ')';
        }

        public a(String r2, String r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "botId");
            Intrinsics.checkNotNullParameter(r4, "conversationId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
    }

    public static void a(boolean r8) {
        RealtimeCallUtil.a.getClass();
        String r1 = "1";
        if (RealtimeCallUtil.z == false) goto L5;
        Object r0 = "1";
    L6:
        a r3 = d;
        String r4 = null;
        if (r3 == null) goto L9;
        String r5 = r3.a;
    L10:
        if (r3 == null) goto L12;
        String r6 = r3.b;
    L13:
        if (r3 == null) goto L15;
        String r7 = r3.c;
    L16:
        if (r3 == null) goto L18;
        r4 = r3.d;
    L18:
        com.larus.voicecall.impl.scene.o r9 = RealtimeCallUtil.l;
        if (r9 == null) goto L24;
        SceneModel r10 = r9.a;
        if (r10 == null) goto L24;
        String r11 = r10.getKey();
        if (r11 == null) goto L24;
    L25:
        if (r8 == true) goto L28;
        r1 = "0";
    L28:
        JSONObject r12 = new JSONObject();
        Intrinsics.checkNotNullParameter(r12, LynxResourceModule.PARAMS_KEY);
        if (r5 != null) goto L45;
    L33:
        if (r4 == null) goto L35;
        r12.put("chat_type", r4);     // Catch: JSONException -> L31
    L35:
        if (r6 == null) goto L37;
        r12.put("call_id", r6);     // Catch: JSONException -> L31
    L37:
        r12.put("to_status", r0);     // Catch: JSONException -> L31
        if (r7 == null) goto L40;
        r12.put("conversation_id", r7);     // Catch: JSONException -> L31
    L40:
        r12.put("call_scene", r11);     // Catch: JSONException -> L31
        r12.put("is_auto", r1);     // Catch: JSONException -> L31
    L43:
        TrackParams r13 = new TrackParams().merge(r12);
        by7.a r2 = new by7.a("click_subtitle_button");
        r2.a.merge(r13);
        r2.b();
        return;
    L31:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper mobClickSubtitleButton " + e.getLocalizedMessage());
        goto L43
    L45:
        r12.put("bot_id", r5);     // Catch: JSONException -> L31
    L24:
        r11 = "other";
        goto L25
    L15:
        r7 = null;
        goto L16
    L12:
        r6 = null;
        goto L13
    L9:
        r5 = null;
        goto L10
    L5:
        r0 = "0";
        goto L6
    }

    public static void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "clickFrom");
        a r0 = d;
        if (r0 == null) goto L5;
        String r1 = r0.a;
    L6:
        RealtimeCallUtil.a.getClass();
        com.larus.voicecall.impl.scene.o r2 = RealtimeCallUtil.l;
        if (r2 == null) goto L12;
        SceneModel r3 = r2.a;
        if (r3 == null) goto L12;
        String r5 = r3.getKey();
        if (r5 == null) goto L12;
    L13:
        JSONObject r6 = new JSONObject();
        Intrinsics.checkNotNullParameter(r6, LynxResourceModule.PARAMS_KEY);
        if (r4 != null) goto L24;
    L16:
        r6.put("call_scene", r5);     // Catch: JSONException -> L20
        if (r1 == null) goto L22;
        r6.put("bot_id", r1);     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        FLogger.a.e("CallEventHelper", "error in CallEventHelper mobCallSubtitleCopy " + e.getLocalizedMessage());
    L22:
        TrackParams r7 = new TrackParams().merge(r6);
        by7.a r8 = new by7.a("call_subtitle_copy");
        r8.a.merge(r7);
        r8.b();
        return;
    L24:
        r6.put("click_from", r4);     // Catch: JSONException -> L20
    L12:
        r5 = "other";
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public static void c(boolean r7) {
        a r0 = d;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.a;
    L6:
        if (r0 == null) goto L8;
        String r3 = r0.b;
    L9:
        if (r0 == null) goto L11;
        r1 = r0.c;
    L11:
        RealtimeCallUtil.a.getClass();
        com.larus.voicecall.impl.scene.o r4 = RealtimeCallUtil.l;
        if (r4 == null) goto L17;
        SceneModel r5 = r4.a;
        if (r5 == null) goto L17;
        String r6 = r5.getKey();
        if (r6 == null) goto L17;
    L18:
        JSONObject r8 = new JSONObject();
        if (r7 == false) goto L21;
        r8.put("show_type", "scrolling");
    L21:
        Long r9 = 1L;
        Intrinsics.checkNotNullParameter(r8, LynxResourceModule.PARAMS_KEY);
        r8.put("call_scene", r6);     // Catch: JSONException -> L32
        if (r2 == null) goto L25;
        r8.put("bot_id", r2);     // Catch: JSONException -> L32
    L25:
        if (r3 == null) goto L27;
        r8.put("call_id", r3);     // Catch: JSONException -> L32
    L27:
        if (r1 == null) goto L29;
        r8.put("conversation_id", r1);     // Catch: JSONException -> L32
    L29:
        if (r9 == null) goto L34;
        r8.put("is_subtitles_mode", r9.longValue());     // Catch: JSONException -> L32
    L34:
        TrackParams r10 = new TrackParams().merge(r8);
        by7.a r11 = new by7.a("subtitle_show");
        r11.a.merge(r10);
        r11.b();
        return;
    L32:
        e = move-exception;
        FLogger.a.e("SubtitleEventHelper", "error in SubtitleEventHelper mobSubtitleShow " + e.getLocalizedMessage());
    L17:
        r6 = "other";
        goto L18
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }
}
