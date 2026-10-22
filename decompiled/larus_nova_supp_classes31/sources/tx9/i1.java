package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.trace.GlobalAudioErrorType;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i1 {
    public static void d(String r3) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("scene", r3);
        TrackParams r4 = new TrackParams().merge(r0);
        by7.a r1 = new by7.a("audio_device_monitor");
        r1.a.merge(r4);
        r1.b();
    }

    public static void a(String r4, String r5) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r4, "scene");
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("scene", r4);     // Catch: JSONException -> L5
        r0.put("id", r5);     // Catch: JSONException -> L5
    L7:
        TrackParams r6 = new TrackParams().merge(r0);
        by7.a r7 = new by7.a("audio_complete_event");
        r7.a.merge(r6);
        r7.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("GlobalAudioEventHelper", "error in GlobalAudioEventHelper mobAudioCompleteEvent " + e.getLocalizedMessage());
        goto L7
    }

    public static void c(String r4, int r5, String r6) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r4, "scene");
        Intrinsics.checkNotNullParameter(r6, "executor");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("scene", r4);     // Catch: JSONException -> L5
        r0.put("executor", r6);     // Catch: JSONException -> L5
        r0.put("control_type", r5);     // Catch: JSONException -> L5
    L7:
        TrackParams r7 = new TrackParams().merge(r0);
        by7.a r8 = new by7.a("audio_control_triggered");
        r8.a.merge(r7);
        r8.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("GlobalAudioEventHelper", "error in GlobalAudioEventHelper mobAudioControlTriggered " + e.getLocalizedMessage());
        goto L7
    }

    public static void f(String r4, String r5, int r6) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r4, "scene");
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("scene", r4);     // Catch: JSONException -> L5
        r0.put("id", r5);     // Catch: JSONException -> L5
        r0.put("state", r6);     // Catch: JSONException -> L5
    L7:
        TrackParams r7 = new TrackParams().merge(r0);
        by7.a r8 = new by7.a("audio_load_state_changed");
        r8.a.merge(r7);
        r8.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("GlobalAudioEventHelper", "error in GlobalAudioEventHelper mobAudioLoadStateChanged " + e.getLocalizedMessage());
        goto L7
    }

    public static void j(String r6, String r7, int r8) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r6, "scene");
        Intrinsics.checkNotNullParameter("default", CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        Intrinsics.checkNotNullParameter(r7, "id");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("scene", r6);     // Catch: JSONException -> L5
        r0.put(CustomFeedPlayerEvent.EXTRA_KEY_REASON, "default");     // Catch: JSONException -> L5
        r0.put("id", r7);     // Catch: JSONException -> L5
        r0.put("status", r8);     // Catch: JSONException -> L5
    L7:
        TrackParams r9 = new TrackParams().merge(r0);
        by7.a r10 = new by7.a("audio_stop_triggered");
        r10.a.merge(r9);
        r10.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("GlobalAudioEventHelper", "error in GlobalAudioEventHelper mobAudioStopTriggered " + e.getLocalizedMessage());
        goto L7
    }

    public static void g(String r5, String r6, String r7, int r8) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r5, "scene");
        Intrinsics.checkNotNullParameter(r6, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        Intrinsics.checkNotNullParameter(r7, "id");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("scene", r5);     // Catch: JSONException -> L5
        r0.put(CustomFeedPlayerEvent.EXTRA_KEY_REASON, r6);     // Catch: JSONException -> L5
        r0.put("id", r7);     // Catch: JSONException -> L5
        r0.put("status", r8);     // Catch: JSONException -> L5
    L7:
        TrackParams r9 = new TrackParams().merge(r0);
        by7.a r10 = new by7.a("audio_pause_triggered");
        r10.a.merge(r9);
        r10.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("GlobalAudioEventHelper", "error in GlobalAudioEventHelper mobAudioPauseTriggered " + e.getLocalizedMessage());
        goto L7
    }

    public static void h(String r5, String r6, String r7, boolean r8, int r9) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r5, "scene");
        Intrinsics.checkNotNullParameter(r6, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        Intrinsics.checkNotNullParameter(r7, "id");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("scene", r5);     // Catch: JSONException -> L9
        r0.put(CustomFeedPlayerEvent.EXTRA_KEY_REASON, r6);     // Catch: JSONException -> L9
        r0.put("id", r7);     // Catch: JSONException -> L9
        if (r8 == false) goto L6;
        int r10 = 1;
    L7:
        r0.put("first_trigger_play", r10);     // Catch: JSONException -> L9
        r0.put("status", r9);     // Catch: JSONException -> L9
    L11:
        TrackParams r11 = new TrackParams().merge(r0);
        by7.a r12 = new by7.a("audio_play_triggered");
        r12.a.merge(r11);
        r12.b();
        return;
    L6:
        r10 = 0;
    L9:
        e = move-exception;
        FLogger.a.e("GlobalAudioEventHelper", "error in GlobalAudioEventHelper mobAudioPlayTriggered " + e.getLocalizedMessage());
        goto L11
    }

    public static void e(String r4, String r5, GlobalAudioErrorType r6, String r7, Integer r8, int r9) {
        JSONObject r1 = null;
        if ((r9 & 16) == 0) goto L6;
        r8 = null;
    L6:
        if ((r9 & 32) == 0) goto L8;
        r1 = new JSONObject();
    L8:
        Intrinsics.checkNotNullParameter(r4, "scene");
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(r6, "type");
        Intrinsics.checkNotNullParameter(r7, "errorMsg");
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.put("scene", r4);     // Catch: JSONException -> L11
        r1.put("id", r5);     // Catch: JSONException -> L11
        r1.put("type", r6.getValue());     // Catch: JSONException -> L11
        r1.put("error_msg", r7);     // Catch: JSONException -> L11
        r1.put("sdk_error_code", r8);     // Catch: JSONException -> L11
    L13:
        TrackParams r10 = new TrackParams().merge(r1);
        by7.a r11 = new by7.a("audio_error_event");
        r11.a.merge(r10);
        r11.b();
        return;
    L11:
        e = move-exception;
        FLogger.a.e("GlobalAudioEventHelper", "error in GlobalAudioEventHelper mobAudioErrorEvent " + e.getLocalizedMessage());
        goto L13
    }

    public static void k(String r2, String r3, boolean r4, long r5, JSONObject r7, int r8) {
        if ((r8 & 16) == 0) goto L5;
        r7 = new JSONObject();
    L5:
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "id");
        Intrinsics.checkNotNullParameter(r7, "params");
        r7.put("scene", r2);
        r7.put("id", r3);
        r7.put("is_hit_cache", r4 ? 1 : 0);
        r7.put("cache_size", r5);
        TrackParams r6 = new TrackParams().merge(r7);
        by7.a r9 = new by7.a("media_hit_cache_event");
        r9.a.merge(r6);
        r9.b();
    }

    public static void b(String r4, int r5, String r6, boolean r7, String r8, Integer r9, Integer r10) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r4, "scene");
        Intrinsics.checkNotNullParameter(r6, "executor");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("scene", r4);     // Catch: JSONException -> L15
        r0.put("control_type", r5);     // Catch: JSONException -> L15
        r0.put("executor", r6);     // Catch: JSONException -> L15
        if (r7 == false) goto L6;
        int r11 = 1;
    L7:
        r0.put("result", r11);     // Catch: JSONException -> L15
        if (r8 == null) goto L10;
        r0.put("failure_msg", r8);     // Catch: JSONException -> L15
    L10:
        if (r9 == null) goto L12;
        r0.put("target_volume", r9.intValue());     // Catch: JSONException -> L15
    L12:
        if (r10 == null) goto L17;
        r0.put("dora_abs_volume_supported", r10.intValue());     // Catch: JSONException -> L15
    L17:
        TrackParams r12 = new TrackParams().merge(r0);
        by7.a r13 = new by7.a("audio_control_result");
        r13.a.merge(r12);
        r13.b();
        return;
    L6:
        r11 = 0;
    L15:
        e = move-exception;
        FLogger.a.e("GlobalAudioEventHelper", "error in GlobalAudioEventHelper mobAudioControlResult " + e.getLocalizedMessage());
        goto L17
    }

    public static void i(String r4, String r5, int r6, int r7, Long r8, Boolean r9, Boolean r10) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r4, "scene");
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("scene", r4);     // Catch: JSONException -> L15
        r0.put("id", r5);     // Catch: JSONException -> L15
        r0.put("status", r6);     // Catch: JSONException -> L15
        r0.put("previous_status", r7);     // Catch: JSONException -> L15
        if (r8 == null) goto L6;
        r0.put("latency", r8.longValue());     // Catch: JSONException -> L15
    L6:
        if (r9 != null) goto L8;
    L12:
        if (r10 == null) goto L17;
        r0.put("is_hit_cache", r10.booleanValue() ? 1 : 0);     // Catch: JSONException -> L15
    L17:
        TrackParams r11 = new TrackParams().merge(r0);
        by7.a r12 = new by7.a("audio_status_changed");
        r12.a.merge(r11);
        r12.b();
        return;
    L8:
        if (r9.booleanValue() == false) goto L10;
        int r13 = 1;
    L11:
        r0.put("first_trigger_play", r13);     // Catch: JSONException -> L15
        goto L12
    L10:
        r13 = 0;
    L15:
        e = move-exception;
        FLogger.a.e("GlobalAudioEventHelper", "error in GlobalAudioEventHelper mobAudioPauseTriggered " + e.getLocalizedMessage());
        goto L17
    }
}
