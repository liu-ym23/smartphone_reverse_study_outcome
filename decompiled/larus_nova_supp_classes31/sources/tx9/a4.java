package tx9;

import android.content.Context;
import android.media.AudioManager;
import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a4 {
    public static final boolean a(String r6) {
        boolean r0 = true;
        if (r6 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return false;
    L11:
        Object r3 = null;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L36
        if (r6 != null) goto L15;
        r6 = "";
    L15:
        JSONObject r7 = new JSONObject(r6).optJSONObject("video_list");     // Catch: Throwable -> L36
        if (r7 == null) goto L20;
        Iterator<String> r5 = r7.keys();     // Catch: Throwable -> L36
        if (r5 == null) goto L20;
        String r8 = r5.next();     // Catch: Throwable -> L36
    L21:
        if (r7 == null) goto L23;
        JSONObject r9 = r7.optJSONObject(r8);     // Catch: Throwable -> L36
    L24:
        if (r9 == null) goto L28;
        String r10 = r9.optString("audio_channels");     // Catch: Throwable -> L36
        if (r10 == null) goto L28;
        Float r11 = StringsKt.toFloatOrNull(r10);     // Catch: Throwable -> L36
    L29:
        if (r11 != null) goto L31;
    L33:
        r0 = false;
    L34:
        Object r12 = Result.constructor-impl(Boolean.valueOf(r0));     // Catch: Throwable -> L36
    L38:
        Throwable r1 = Result.exceptionOrNull-impl(r12);
        if (r1 == null) goto L42;
        FLogger.a.i("isHasVoice", "isHasVoice failed: " + r1);
    L42:
        if (Result.isFailure-impl(r12) == true) goto L45;
        r3 = r12;
    L45:
        Boolean r13 = (Boolean) r3;
        if (r13 != null) goto L48;
        return false;
    L48:
        return r13.booleanValue();
    L31:
        if (r11.floatValue() <= 0.0f) goto L33;
    L28:
        r11 = null;
        goto L29
    L23:
        r9 = null;
    L20:
        r8 = null;
    L36:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    L5:
        if (StringsKt.isBlank(r6) == true) goto L8;
        r2 = false;
        goto L9
    }

    public static final boolean b(Context r7, Boolean r8) {
        Object r2 = null;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L27
        if (r7 == null) goto L6;
        Object r9 = r7.getSystemService("audio");     // Catch: Throwable -> L27
    L8:
        if ((r9 instanceof AudioManager) == false) goto L10;
        AudioManager r10 = (AudioManager) r9;     // Catch: Throwable -> L27
    L12:
        if (r10 == null) goto L14;
        int r5 = r10.getStreamVolume(3);     // Catch: Throwable -> L27
    L15:
        if (r10 == null) goto L17;
        int r11 = r10.getStreamMaxVolume(3);     // Catch: Throwable -> L27
    L18:
        FLogger.a.i("isVoicePlay", "currentVolume=" + r5 + ", maxVolume=" + r11 + ", isVideoMute=" + r8);     // Catch: Throwable -> L27
        if (r5 <= 0) goto L24;
        if (r11 <= 0) goto L24;
        if (Intrinsics.areEqual(r8, Boolean.TRUE) == true) goto L24;
        boolean r12 = true;
    L25:
        Object r13 = Result.constructor-impl(Boolean.valueOf(r12));     // Catch: Throwable -> L27
    L29:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L33;
        FLogger.a.i("isVoicePlay", "isMediaVolumeOn failed: " + r14);
    L33:
        if (Result.isFailure-impl(r13) == true) goto L36;
        r2 = r13;
    L36:
        Boolean r3 = (Boolean) r2;
        if (r3 != null) goto L39;
        return false;
    L39:
        return r3.booleanValue();
    L24:
        r12 = false;
        goto L25
    L17:
        r11 = 0;
        goto L18
    L14:
        r5 = 0;
        goto L15
    L10:
        r10 = null;
        goto L12
    L6:
        r9 = null;
    L27:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    }

    public static void c(String r1, String r2, String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
    L13:
        e = move-exception;
        FLogger.a.e("VideoGenerateEnventHelper", "error in VideoGenerateEnventHelper mobAiVideoMessageClick " + e.getLocalizedMessage());
    L15:
        TrackParams r5 = new TrackParams().merge(r4);
        by7.a r6 = new by7.a("ai_video_message_click");
        r6.a.merge(r5);
        r6.b();
        return;
    L4:
        if (com.larus.utils.o0.d(r1) == false) goto L7;
        r4.put("video_id", r1);     // Catch: JSONException -> L13
    L7:
        if (com.larus.utils.o0.d(r2) == false) goto L10;
        r4.put("message_id", r2);     // Catch: JSONException -> L13
    L10:
        if (com.larus.utils.o0.d(r3) == false) goto L15;
        r4.put("bot_id", r3);     // Catch: JSONException -> L13
        goto L15
    }

    public static void g(String r1, String r2, String r3, String r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
    L16:
        e = move-exception;
        FLogger.a.e("VideoGenerateEnventHelper", "error in VideoGenerateEnventHelper mobAiVideoMessageClick " + e.getLocalizedMessage());
    L18:
        TrackParams r6 = new TrackParams().merge(r5);
        by7.a r7 = new by7.a("ai_video_play_fail");
        r7.a.merge(r6);
        r7.b();
        return;
    L4:
        if (com.larus.utils.o0.d(r1) == false) goto L7;
        r5.put("video_id", r1);     // Catch: JSONException -> L16
    L7:
        if (com.larus.utils.o0.d(r2) == false) goto L10;
        r5.put("message_id", r2);     // Catch: JSONException -> L16
    L10:
        if (com.larus.utils.o0.d(r3) == false) goto L13;
        r5.put("bot_id", r3);     // Catch: JSONException -> L16
    L13:
        if (com.larus.utils.o0.d(r4) == false) goto L18;
        r5.put("previous_page", r4);     // Catch: JSONException -> L16
        goto L18
    }

    public static void i(String r2, String r3, String r4, String r5, String r6, Long r7, int r8) {
        JSONObject r1 = null;
        if ((r8 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r8 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r8 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r8 & 64) == 0) goto L23;
        r1 = new JSONObject();
    L23:
        Intrinsics.checkNotNullParameter(r1, "params");
    L42:
        e = move-exception;
        FLogger.a.e("VideoGenerateEnventHelper", "error in VideoGenerateEnventHelper mobAiVideoMessageClick " + e.getLocalizedMessage());
    L44:
        TrackParams r9 = new TrackParams().merge(r1);
        by7.a r10 = new by7.a("ai_video_click_close");
        r10.a.merge(r9);
        r10.b();
        return;
    L25:
        if (com.larus.utils.o0.d(r2) == false) goto L28;
        r1.put("video_id", r2);     // Catch: JSONException -> L42
    L28:
        if (com.larus.utils.o0.d(r3) == false) goto L31;
        r1.put("message_id", r3);     // Catch: JSONException -> L42
    L31:
        if (com.larus.utils.o0.d(r4) == false) goto L34;
        r1.put("bot_id", r4);     // Catch: JSONException -> L42
    L34:
        if (com.larus.utils.o0.d(r5) == false) goto L37;
        r1.put("previous_page", r5);     // Catch: JSONException -> L42
    L37:
        if (com.larus.utils.o0.d(r6) == false) goto L39;
        r1.put("is_upload_video", r6);     // Catch: JSONException -> L42
    L39:
        if (r7 == null) goto L44;
        r1.put("duration", r7.longValue());     // Catch: JSONException -> L42
        goto L44
    }

    public static void d(String r2, String r3, String r4, String r5, Integer r6, String r7, Float r8, JSONObject r9, int r10) {
        if ((r10 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r10 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r10 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r10 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r10 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r10 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r10 & 128) == 0) goto L26;
        r9 = new JSONObject();
    L26:
        Intrinsics.checkNotNullParameter(r9, "params");
        if (r7 != null) goto L51;
        r7 = "";
    L51:
        r9.putOpt("creation_task_id", r7);     // Catch: JSONException -> L47
        r9.putOpt("position", r6);     // Catch: JSONException -> L47
        if (r5 != null) goto L34;
        r5 = "";
    L34:
        r9.putOpt("ai_create_show_mode", r5);     // Catch: JSONException -> L47
        if (r8 == null) goto L38;
        r9.put("show_pct", r8);     // Catch: JSONException -> L47
    L38:
        if (com.larus.utils.o0.d(r2) == false) goto L41;
        r9.put("video_id", r2);     // Catch: JSONException -> L47
    L41:
        if (com.larus.utils.o0.d(r3) == false) goto L44;
        r9.put("message_id", r3);     // Catch: JSONException -> L47
    L44:
        if (com.larus.utils.o0.d(r4) == false) goto L49;
        r9.put("bot_id", r4);     // Catch: JSONException -> L47
    L49:
        TrackParams r11 = new TrackParams().merge(r9);
        by7.a r12 = new by7.a("ai_video_message_show");
        r12.a.merge(r11);
        r12.b();
        return;
    L47:
        e = move-exception;
        FLogger.a.e("VideoGenerateEnventHelper", "error in VideoGenerateEnventHelper mobAiVideoMessageShow " + e.getLocalizedMessage());
        goto L49
    }

    public static void k(String r2, String r3, String r4, String r5, String r6, String r7, Integer r8, String r9, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        if (r9 != null) goto L30;
        r9 = "";
    L30:
        r10.putOpt("creation_task_id", r9);     // Catch: JSONException -> L26
        r10.putOpt("position", r8);     // Catch: JSONException -> L26
        if (r7 != null) goto L10;
        r7 = "";
    L10:
        r10.putOpt("ai_create_show_mode", r7);     // Catch: JSONException -> L26
        if (com.larus.utils.o0.d(r2) == false) goto L14;
        r10.put("video_id", r2);     // Catch: JSONException -> L26
    L14:
        if (com.larus.utils.o0.d(r3) == false) goto L17;
        r10.put("message_id", r3);     // Catch: JSONException -> L26
    L17:
        if (com.larus.utils.o0.d(r4) == false) goto L20;
        r10.put("bot_id", r4);     // Catch: JSONException -> L26
    L20:
        if (com.larus.utils.o0.d(r5) == false) goto L23;
        r10.put("previous_page", r5);     // Catch: JSONException -> L26
    L23:
        if (com.larus.utils.o0.d(r6) == false) goto L28;
        r10.put("is_upload_video", r6);     // Catch: JSONException -> L26
    L28:
        TrackParams r11 = new TrackParams().merge(r10);
        by7.a r12 = new by7.a("ai_video_click_share");
        r12.a.merge(r11);
        r12.b();
        return;
    L26:
        e = move-exception;
        FLogger.a.e("VideoGenerateEnventHelper", "error in VideoGenerateEnventHelper mobAiVideoMessageClick " + e.getLocalizedMessage());
        goto L28
    }

    public static void h(String r2, String r3, String r4, String r5, String r6, String r7, String r8, Integer r9, String r10, String r11, int r12) {
        JSONObject r1 = null;
        if ((r12 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r12 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r12 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r12 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r12 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r12 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r12 & 256) == 0) goto L30;
        r10 = null;
    L30:
        if ((r12 & 512) == 0) goto L33;
        r11 = null;
    L33:
        if ((r12 & 1024) == 0) goto L35;
        r1 = new JSONObject();
    L35:
        Intrinsics.checkNotNullParameter(r1, "params");
        if (r10 != null) goto L69;
        r10 = "";
    L69:
        r1.putOpt("creation_task_id", r10);     // Catch: JSONException -> L65
        r1.putOpt("position", r9);     // Catch: JSONException -> L65
        if (r8 != null) goto L43;
        r8 = "";
    L43:
        r1.putOpt("ai_create_show_mode", r8);     // Catch: JSONException -> L65
        if (com.larus.utils.o0.d(r2) == false) goto L47;
        r1.put("video_id", r2);     // Catch: JSONException -> L65
    L47:
        if (com.larus.utils.o0.d(r3) == false) goto L50;
        r1.put("message_id", r3);     // Catch: JSONException -> L65
    L50:
        if (com.larus.utils.o0.d(r4) == false) goto L53;
        r1.put("bot_id", r4);     // Catch: JSONException -> L65
    L53:
        if (com.larus.utils.o0.d(r5) == false) goto L56;
        r1.put("enter_method", r5);     // Catch: JSONException -> L65
    L56:
        if (com.larus.utils.o0.d(r6) == false) goto L59;
        r1.put("previous_page", r6);     // Catch: JSONException -> L65
    L59:
        if (com.larus.utils.o0.d(r7) == false) goto L62;
        r1.put("is_upload_video", r7);     // Catch: JSONException -> L65
    L62:
        if (com.larus.utils.o0.d(r11) == false) goto L67;
        r1.put("user_type", r11);     // Catch: JSONException -> L65
    L67:
        TrackParams r13 = new TrackParams().merge(r1);
        by7.a r14 = new by7.a("enter_video_detail");
        r14.a.merge(r13);
        r14.b();
        return;
    L65:
        e = move-exception;
        FLogger.a.e("VideoGenerateEnventHelper", "error in VideoGenerateEnventHelper mobAiVideoMessageClick " + e.getLocalizedMessage());
        goto L67
    }

    public static void j(String r2, String r3, String r4, String r5, String r6, String r7, String r8, Integer r9, String r10, String r11, JSONObject r12, int r13) {
        if ((r13 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r13 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r13 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r13 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r13 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r13 & 256) == 0) goto L30;
        r10 = null;
    L30:
        if ((r13 & 512) == 0) goto L33;
        r11 = null;
    L33:
        if ((r13 & 1024) == 0) goto L35;
        r12 = new JSONObject();
    L35:
        Intrinsics.checkNotNullParameter(r12, "params");
        if (r10 != null) goto L69;
        r10 = "";
    L69:
        r12.putOpt("creation_task_id", r10);     // Catch: JSONException -> L65
        r12.putOpt("position", r9);     // Catch: JSONException -> L65
        if (r8 != null) goto L43;
        r8 = "";
    L43:
        r12.putOpt("ai_create_show_mode", r8);     // Catch: JSONException -> L65
        if (com.larus.utils.o0.d(r2) == false) goto L47;
        r12.put("video_id", r2);     // Catch: JSONException -> L65
    L47:
        if (com.larus.utils.o0.d(r3) == false) goto L50;
        r12.put("message_id", r3);     // Catch: JSONException -> L65
    L50:
        if (com.larus.utils.o0.d(r4) == false) goto L53;
        r12.put("bot_id", r4);     // Catch: JSONException -> L65
    L53:
        if (com.larus.utils.o0.d(r5) == false) goto L56;
        r12.put("click_method", r5);     // Catch: JSONException -> L65
    L56:
        if (com.larus.utils.o0.d(r6) == false) goto L59;
        r12.put("previous_page", r6);     // Catch: JSONException -> L65
    L59:
        if (com.larus.utils.o0.d(r7) == false) goto L61;
        r12.put("is_upload_video", r7);     // Catch: JSONException -> L65
    L61:
        r12.putOpt("save_type", "video");     // Catch: JSONException -> L65
        if (com.larus.utils.o0.d(r11) == false) goto L67;
        r12.put("creation_id", r11);     // Catch: JSONException -> L65
    L67:
        b2.f(r12, false);
        TrackParams r14 = new TrackParams().merge(b2.b(r12));
        by7.a r15 = new by7.a("ai_video_click_download");
        r15.a.merge(r14);
        r15.b();
        return;
    L65:
        e = move-exception;
        FLogger.a.e("VideoGenerateEnventHelper", "error in VideoGenerateEnventHelper mobAiVideoMessageClick " + e.getLocalizedMessage());
        goto L67
    }

    public static /* synthetic */ void f(String r27, String r28, String r29, Boolean r30, String r31, String r32, String r33, Integer r34, String r35, String r36, JSONObject r37, Boolean r38, Boolean r39, int r40) {
        if ((r40 & 1) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r40 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r40 & 4) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r40 & 8) == 0) goto L17;
        Boolean r6 = Boolean.TRUE;
    L19:
        if ((r40 & 16) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r40 & 32) == 0) goto L25;
        String r8 = null;
    L27:
        if ((r40 & 64) == 0) goto L29;
        String r9 = null;
    L31:
        if ((r40 & 128) == 0) goto L33;
        Integer r10 = null;
    L35:
        if ((r40 & 256) == 0) goto L37;
        String r11 = null;
    L39:
        if ((r40 & 512) == 0) goto L41;
        String r12 = null;
    L43:
        if ((r40 & 1024) == 0) goto L45;
        JSONObject r13 = new JSONObject();
    L47:
        if ((r40 & 4096) == 0) goto L49;
        Boolean r15 = null;
    L51:
        if ((r40 & 8192) == 0) goto L53;
        Boolean r16 = null;
    L54:
        e(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, null, r15, r16, null, null, null, null, null, null, null, null, null, null);
        return;
    L53:
        r16 = r39;
        goto L54
    L49:
        r15 = r38;
        goto L51
    L45:
        r13 = r37;
        goto L47
    L41:
        r12 = r36;
        goto L43
    L37:
        r11 = r35;
        goto L39
    L33:
        r10 = r34;
        goto L35
    L29:
        r9 = r33;
        goto L31
    L25:
        r8 = r32;
        goto L27
    L21:
        r7 = r31;
        goto L23
    L17:
        r6 = r30;
        goto L19
    L13:
        r5 = r29;
        goto L15
    L9:
        r4 = r28;
        goto L11
    L5:
        r3 = r27;
        goto L7
    }

    public static /* synthetic */ void m(String r27, String r28, String r29, Boolean r30, String r31, Long r32, Boolean r33, String r34, String r35, String r36, JSONObject r37, Boolean r38, Boolean r39, int r40) {
        if ((r40 & 1) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r40 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r40 & 4) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r40 & 8) == 0) goto L17;
        Boolean r6 = Boolean.TRUE;
    L19:
        if ((r40 & 16) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r40 & 32) == 0) goto L25;
        Long r8 = null;
    L27:
        if ((r40 & 64) == 0) goto L29;
        Boolean r9 = Boolean.TRUE;
    L31:
        if ((r40 & 128) == 0) goto L33;
        String r10 = null;
    L35:
        if ((r40 & 256) == 0) goto L37;
        String r11 = null;
    L39:
        if ((r40 & 512) == 0) goto L41;
        String r12 = null;
    L43:
        if ((r40 & 1024) == 0) goto L45;
        JSONObject r13 = new JSONObject();
    L47:
        if ((r40 & 4096) == 0) goto L49;
        Boolean r15 = null;
    L51:
        if ((r40 & 8192) == 0) goto L53;
        Boolean r16 = null;
    L54:
        l(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, null, r15, r16, null, null, null, null, null, null, null, null, null, null);
        return;
    L53:
        r16 = r39;
        goto L54
    L49:
        r15 = r38;
        goto L51
    L45:
        r13 = r37;
        goto L47
    L41:
        r12 = r36;
        goto L43
    L37:
        r11 = r35;
        goto L39
    L33:
        r10 = r34;
        goto L35
    L29:
        r9 = r33;
        goto L31
    L25:
        r8 = r32;
        goto L27
    L21:
        r7 = r31;
        goto L23
    L17:
        r6 = r30;
        goto L19
    L13:
        r5 = r29;
        goto L15
    L9:
        r4 = r28;
        goto L11
    L5:
        r3 = r27;
        goto L7
    }

    public static final void e(String r6, String r7, String r8, Boolean r9, String r10, String r11, String r12, Integer r13, String r14, String r15, JSONObject r16, by7.e r17, Boolean r18, Boolean r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29) {
        Intrinsics.checkNotNullParameter(r16, "params");
        r16.putOpt("current_page", r15);     // Catch: JSONException -> L74
        String r3 = "";
        if (r14 != null) goto L7;
        Object r4 = "";
    L8:
        r16.putOpt("creation_task_id", r4);     // Catch: JSONException -> L74
        r16.putOpt("position", r13);     // Catch: JSONException -> L74
        if (r12 == null) goto L12;
        r3 = r12;
    L12:
        r16.putOpt("ai_create_show_mode", r3);     // Catch: JSONException -> L74
        if (com.larus.utils.o0.d(r6) == false) goto L16;
        r16.put("video_id", r6);     // Catch: JSONException -> L74
    L16:
        if (com.larus.utils.o0.d(r7) == false) goto L19;
        r16.put("message_id", r7);     // Catch: JSONException -> L74
    L19:
        if (com.larus.utils.o0.d(r8) == false) goto L22;
        r16.put("bot_id", r8);     // Catch: JSONException -> L74
    L22:
        if (com.larus.utils.o0.d(r11) == false) goto L24;
        r16.put("is_upload_video", r11);     // Catch: JSONException -> L74
    L24:
        int r5 = 1;
        if (Intrinsics.areEqual(r9, Boolean.TRUE) == false) goto L27;
        int r30 = 1;
    L28:
        r16.put("is_auto_play", r30);     // Catch: JSONException -> L74
        if (com.larus.utils.o0.d(r10) == false) goto L32;
        r16.put("previous_page", r10);     // Catch: JSONException -> L74
    L32:
        if (com.larus.utils.o0.d(r20) == false) goto L35;
        r16.put("ai_generate_tab_id", r20);     // Catch: JSONException -> L74
    L35:
        if (com.larus.utils.o0.d(r21) == false) goto L38;
        r16.put("ai_generate_tab_name", r21);     // Catch: JSONException -> L74
    L38:
        if (com.larus.utils.o0.d(r22) == false) goto L41;
        r16.put("enter_method", r22);     // Catch: JSONException -> L74
    L41:
        if (com.larus.utils.o0.d(r23) == false) goto L44;
        r16.put("recommend_from", r23);     // Catch: JSONException -> L74
    L44:
        if (com.larus.utils.o0.d(r24) == false) goto L47;
        r16.put("template_source", r24);     // Catch: JSONException -> L74
    L47:
        if (com.larus.utils.o0.d(r25) == false) goto L50;
        r16.put("template_sub_type", r25);     // Catch: JSONException -> L74
    L50:
        if (com.larus.utils.o0.d(r26) == false) goto L53;
        r16.put("template_type", r26);     // Catch: JSONException -> L74
    L53:
        if (com.larus.utils.o0.d(r27) == false) goto L56;
        r16.put("template_id", r27);     // Catch: JSONException -> L74
    L56:
        if (com.larus.utils.o0.d(r28) == false) goto L59;
        r16.put("template_rec_extra", r28);     // Catch: JSONException -> L74
    L59:
        if (com.larus.utils.o0.d(r29) == false) goto L61;
        r16.put("template_rec_req_id", r29);     // Catch: JSONException -> L74
    L61:
        if (r18 != null) goto L63;
    L67:
        if (r19 != null) goto L69;
    L76:
        TrackParams r0 = new TrackParams().merge(r16);
        by7.a r1 = new by7.a("ai_video_play");
        if (r17 == null) goto L79;
        r1.b = r17;
    L79:
        r1.a.merge(r0);
        r1.b();
        return;
    L69:
        if (r19.booleanValue() == true) goto L72;
        r5 = 0;
    L72:
        r16.put("is_voice_play", r5);     // Catch: JSONException -> L74
        goto L76
    L63:
        if (r18.booleanValue() == false) goto L65;
        int r31 = 1;
    L66:
        r16.put("is_has_voice", r31);     // Catch: JSONException -> L74
        goto L67
    L65:
        r31 = 0;
        goto L66
    L27:
        r30 = 0;
        goto L28
    L7:
        r4 = r14;
    L74:
        e = move-exception;
        FLogger.a.e("VideoGenerateEnventHelper", "error in VideoGenerateEnventHelper mobAiVideoMessageClick " + e.getLocalizedMessage());
        goto L76
    }

    public static final void l(String r9, String r10, String r11, Boolean r12, String r13, Long r14, Boolean r15, String r16, String r17, String r18, JSONObject r19, by7.e r20, Boolean r21, Boolean r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32) {
        Intrinsics.checkNotNullParameter(r19, "params");
        r19.putOpt("current_page", r17);     // Catch: JSONException -> L77
        if (r18 != null) goto L6;
        String r3 = "";
    L7:
        r19.putOpt("creation_task_id", r3);     // Catch: JSONException -> L77
        if (com.larus.utils.o0.d(r9) == false) goto L11;
        r19.put("video_id", r9);     // Catch: JSONException -> L77
    L11:
        if (com.larus.utils.o0.d(r10) == false) goto L14;
        r19.put("message_id", r10);     // Catch: JSONException -> L77
    L14:
        if (com.larus.utils.o0.d(r11) == false) goto L17;
        r19.put("bot_id", r11);     // Catch: JSONException -> L77
    L17:
        if (com.larus.utils.o0.d(r13) == false) goto L20;
        r19.put("previous_page", r13);     // Catch: JSONException -> L77
    L20:
        if (com.larus.utils.o0.d(r16) == false) goto L23;
        r19.put("is_upload_video", r16);     // Catch: JSONException -> L77
    L23:
        if (com.larus.utils.o0.d(r23) == false) goto L26;
        r19.put("ai_generate_tab_id", r23);     // Catch: JSONException -> L77
    L26:
        if (com.larus.utils.o0.d(r24) == false) goto L29;
        r19.put("ai_generate_tab_name", r24);     // Catch: JSONException -> L77
    L29:
        if (com.larus.utils.o0.d(r25) == false) goto L32;
        r19.put("enter_method", r25);     // Catch: JSONException -> L77
    L32:
        if (com.larus.utils.o0.d(r26) == false) goto L35;
        r19.put("recommend_from", r26);     // Catch: JSONException -> L77
    L35:
        if (com.larus.utils.o0.d(r27) == false) goto L38;
        r19.put("template_source", r27);     // Catch: JSONException -> L77
    L38:
        if (com.larus.utils.o0.d(r28) == false) goto L41;
        r19.put("template_sub_type", r28);     // Catch: JSONException -> L77
    L41:
        if (com.larus.utils.o0.d(r29) == false) goto L44;
        r19.put("template_type", r29);     // Catch: JSONException -> L77
    L44:
        if (com.larus.utils.o0.d(r30) == false) goto L47;
        r19.put("template_id", r30);     // Catch: JSONException -> L77
    L47:
        if (com.larus.utils.o0.d(r31) == false) goto L50;
        r19.put("template_rec_extra", r31);     // Catch: JSONException -> L77
    L50:
        if (com.larus.utils.o0.d(r32) == false) goto L52;
        r19.put("template_rec_req_id", r32);     // Catch: JSONException -> L77
    L52:
        Boolean r4 = Boolean.TRUE;     // Catch: JSONException -> L77
        int r5 = 1;
        if (Intrinsics.areEqual(r12, r4) == false) goto L55;
        int r6 = 1;
    L56:
        r19.put("is_auto_play", r6);     // Catch: JSONException -> L77
        if (r14 == null) goto L60;
        r19.put("duration", r14.longValue());     // Catch: JSONException -> L77
    L60:
        if (Intrinsics.areEqual(r15, r4) == false) goto L62;
        int r7 = 1;
    L63:
        r19.put("is_finish", r7);     // Catch: JSONException -> L77
        if (r21 != null) goto L66;
    L70:
        if (r22 != null) goto L72;
    L79:
        TrackParams r0 = new TrackParams().merge(r19);
        by7.a r1 = new by7.a("ai_video_play_time");
        if (r20 == null) goto L82;
        r1.b = r20;
    L82:
        r1.a.merge(r0);
        r1.b();
        return;
    L72:
        if (r22.booleanValue() == true) goto L75;
        r5 = 0;
    L75:
        r19.put("is_voice_play", r5);     // Catch: JSONException -> L77
        goto L79
    L66:
        if (r21.booleanValue() == false) goto L68;
        int r8 = 1;
    L69:
        r19.put("is_has_voice", r8);     // Catch: JSONException -> L77
        goto L70
    L68:
        r8 = 0;
        goto L69
    L62:
        r7 = 0;
        goto L63
    L55:
        r6 = 0;
        goto L56
    L6:
        r3 = r18;
    L77:
        e = move-exception;
        FLogger.a.e("VideoGenerateEnventHelper", "error in VideoGenerateEnventHelper mobAiVideoMessageClick " + e.getLocalizedMessage());
        goto L79
    }
}
