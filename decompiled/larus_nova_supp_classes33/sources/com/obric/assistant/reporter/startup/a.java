package com.obric.assistant.reporter.startup;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final Set<String> a = null;
    public static final Set<String> b = null;
    public static final Set<String> c = null;
    public static final Set<String> d = null;
    public static final Set<String> e = null;
    public static final Set<String> f = null;
    public static final Set<String> g = null;
    public static final Set<String> h = null;
    public static final Set<String> i = null;
    public static final Set<String> j = null;
    public static final Set<String> k = null;
    public static final Set<String> l = null;
    public static final Set<String> m = null;
    public static final Set<String> n = null;
    public static final Set<String> o = null;
    public static final Set<String> p = null;
    public static final Set<String> q = null;
    public static final Set<String> r = null;
    public static final Set<String> s = null;
    public static final Set<String> t = null;

    /* JADX INFO: renamed from: com.obric.assistant.reporter.startup.a$a, reason: collision with other inner class name */
    public static final class C0013a {
        public final Map<String, Object> a;
        public final Map<String, Long> b;
        public final Map<String, String> c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0013a) == true) goto L8;
            return false;
        L8:
            C0013a r6 = (C0013a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "Payload(category=" + this.a + ", metric=" + this.b + ", extraLog=" + this.c + ')';
        }

        public C0013a(Map<String, ? extends Object> r2, Map<String, Long> r3, Map<String, String> r4) {
            Intrinsics.checkNotNullParameter(r2, "category");
            Intrinsics.checkNotNullParameter(r3, "metric");
            Intrinsics.checkNotNullParameter(r4, "extraLog");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
        a = SetsKt.setOf(new String[]{"desktop", "voice", "breath", "ai_key", "dora", "bluetooth", "auto_mic"});
        b = SetsKt.setOf(new String[]{"icon_click", "voice_wakeup", "breath_wakeup", "dora_voice_wakeup", "voice_command", "auto_mic", "physical_press", "single_press", "short_press", "long_press", "double_press"});
        c = SetsKt.setOf(new String[]{"chat", "window", "click_talk", "touch_speak", "assistant", "realtime_call", "camera"});
        d = SetsKt.setOf(new String[]{WindowEvent.WindowOpenPerfResult.SUCCESS, "blocked", "dropped", "timeout", "cancelled", "superseded"});
        e = SetsKt.setOf(new String[]{"elapsed_realtime", "uptime_converted_to_elapsed", "wall_converted_to_elapsed", "receiver_elapsed_fallback"});
        f = SetsKt.setOf(new String[]{"cold", "alive", "unknown"});
        g = SetsKt.setOf(new String[]{"cold", "warm", "hot", "not_applicable", "unknown"});
        h = SetsKt.setOf(new String[]{"foreground", "background", "no_real_activity", "unknown"});
        i = SetsKt.setOf("main");
        j = SetsKt.setOf("interactor");
        k = SetsKt.setOf(new String[]{"0", "1"});
        l = SetsKt.setOf(new String[]{"window", "activity", "reuse_current_chat", "legacy_camera"});
        m = SetsKt.setOf(new String[]{"HighLevel", "MidLevel", "LowLevel", "Unknown"});
        n = SetsKt.setOf(new String[]{"main_view", "child_first_frame"});
        o = SetsKt.setOf(new String[]{"child_first_frame", "main_view"});
        p = SetsKt.setOf("interactor_oneshot");
        q = SetsKt.setOf(new String[]{"audio", "video", "screen_share", "camera"});
        r = SetsKt.setOf(new String[]{"ready", "deadline_exceeded", "new_attempt", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "login_required", "network_unavailable", "assistant_unavailable", "ai_key_cancelled", "ai_key_gesture_timeout", "mic_in_use", "audio_input_disabled", "audio_session_busy", "record_audio_denied", "bot_unavailable", "camera_ability_unavailable", "camera_already_foreground", "camera_background_transition", "camera_launch_in_progress", "camera_legacy_host_destroyed", "camera_legacy_exact_launch_unavailable", "conversation_unavailable", "dora_pressing", "speaker_ability_unavailable", "speaker_ability_missing", "chat_context_unavailable", "chat_fragment_detached", "click_talk_replaced_before_start", "click_talk_start_failed", "asr_failed_before_pcm", "asr_finished_before_pcm", "asr_cancelled_before_pcm", "touch_speak_start_failed", "touch_speak_stopped_before_pcm", "continuous_talk_replaced_before_start", "continuous_talk_replaced_before_pcm", "continuous_talk_start_failed", "continuous_talk_error", "continuous_talk_finished_before_pcm", "continuous_talk_stopped_before_pcm", "realtime_call_downgraded", "realtime_call_not_enable", "realtime_call_timbre_not_set", "realtime_call_network_unavailable", "realtime_call_launch_failed", "dismiss_keyguard_failed", "dismiss_keyguard_in_progress", "low_storage", "start_chat_activity_failed", "ai_key_cancel", "ai_key_orphan_up_cancel", "new_ai_key_sequence", "intercom_condition_failed", "user_not_login", "screen_rotated", "screen_landscape", "pocket_mode", "click_talk_activation_failed", "touch_speak_activation_failed", "stopped_before_user_guide", "long_press_stopped_before_ready", "system_alert_window_permission", "user_guide_showing", "legacy_launcher_fallback", "session_processing_exception", "launch_failed", "quit_session", "only_end", "interactor_show_session_failed", "interactor_delivery_failed", "interactor_client_unavailable", "interactor_handoff_failed", "session_proxy_unavailable", "Album-camera-result", "Album-canvas-ps", "Blocked-by-system-alert-window-permission", "System-aiKeyPressing", "System-all-search-launch", "System-clickTalkSpeaking", "System-continuousTalkRunning", "System-dismiss-keyguard", "System-doraPressing", "System-ignore-request", "System-invalid-request-from", "System-pullup-once", "System-realtime-calling", "System-rotate-display", "System-startup", "System-user-guiding", "System-voice-enrolling", "Voice-in-pocket-mode", "Voice-mic-in-use-and-breath", "Voice-mic-in-use-calling", "Voice-mic-in-use-common", "Voice-re-wakeup-when-sessioning", "Voice-sync-error", "Voice-timer-running", "Voice-wrong-uid"});
        s = SetsKt.setOf(new String[]{"window_content_ready", "chat_content_ready", "asr_record_ready", "first_frame_ready", "route_ready", "rtc_call_content_ready", "camera_content_ready"});
        t = SetsKt.setOf(new String[]{"attempt_id", "request_from", "session_name", "handoff_stage", "session_error_code", "window_fallback", "launcher_payload_version", "requested_start_clock", "start_timestamp_rejected_reason", "child_surface_generation", "error_code", WindowEvent.Params.ERROR_TYPE, "superseded_by_attempt_id"});
    }

    public static C0013a c(Map r38) {
        Intrinsics.checkNotNullParameter(r38, "raw");
        String r2 = (String) r38.get("schema_version");
        if (r2 == null) goto L202;
        Integer r3 = StringsKt.toIntOrNull(r2);
        if (r3 == null) goto L202;
        if (r3.intValue() != 1) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L202;
        int r5 = r3.intValue();
        String r6 = b(r38, "source", a);
        if (r6 != null) goto L17;
        return null;
    L17:
        String r8 = b(r38, "action", b);
        if (r8 != null) goto L20;
        return null;
    L20:
        String r10 = b(r38, "target", c);
        if (r10 != null) goto L23;
        return null;
    L23:
        String r12 = b(r38, WindowEvent.Params.RESULT, d);
        if (r12 != null) goto L26;
        return null;
    L26:
        String r14 = b(r38, "start_clock", e);
        if (r14 != null) goto L29;
        return null;
    L29:
        String r7 = b(r38, "process_start_type", f);
        if (r7 != null) goto L32;
        return null;
    L32:
        String r9 = b(r38, "activity_start_type", g);
        if (r9 != null) goto L36;
        return null;
    L36:
        String r11 = b(r38, "app_visibility_at_start", h);
        if (r11 != null) goto L39;
        return null;
    L39:
        String r13 = b(r38, "state_owner_process_role", i);
        if (r13 != null) goto L42;
        return null;
    L42:
        String r23 = (String) r38.get("total_duration_ms");
        if (r23 == null) goto L54;
        Long r24 = StringsKt.toLongOrNull(r23);
        if (r24 == null) goto L54;
        long r28 = r24.longValue();
        if (0 <= r28) goto L49;
    L51:
        boolean r29 = false;
    L52:
        if (r29 == false) goto L54;
    L55:
        Pair[] r15 = new Pair[11];
        r15[0] = TuplesKt.to("schema_version", Integer.valueOf(r5));
        r15[1] = TuplesKt.to("source", r6);
        r15[2] = TuplesKt.to("action", r8);
        r15[3] = TuplesKt.to("target", r10);
        r15[4] = TuplesKt.to(WindowEvent.Params.RESULT, r12);
        r15[5] = TuplesKt.to("start_clock", r14);
        r15[6] = TuplesKt.to("process_start_type", r7);
        r15[7] = TuplesKt.to("activity_start_type", r9);
        r15[8] = TuplesKt.to("app_visibility_at_start", r11);
        r15[9] = TuplesKt.to("state_owner_process_role", r13);
        if (r24 == null) goto L58;
        String r1 = "1";
    L59:
        r15[10] = TuplesKt.to("duration_valid", r1);
        LinkedHashMap r16 = MapsKt.linkedMapOf(r15);
        a(r16, r38, "origin_process_role", j);
        Set<String> r17 = k;
        a(r16, r38, "main_handoff_completed", r17);
        a(r16, r38, "route", l);
        a(r16, r38, "call_type", q);
        a(r16, r38, "keep_alive_level_mode", m);
        a(r16, r38, "window_ready_source", n);
        a(r16, r38, "asr_ready_source", p);
        a(r16, r38, "first_frame_source", o);
        String r18 = (String) r38.get("process_start_inferred");
        if (r18 == null) goto L69;
        String r19 = StringsKt.trim(r18).toString();
        if (r19 == null) goto L69;
        if (r17.contains(r19) == true) goto L67;
        r19 = null;
    L67:
        if (r19 == null) goto L69;
        r16.put("process_start_inferred", r19);
    L69:
        String r20 = (String) r38.get(WindowEvent.Params.REASON);
        if (r20 != null) goto L72;
        r20 = "";
    L72:
        String r21 = StringsKt.trim(r20).toString();
        if (r.contains(r21) == false) goto L76;
    L95:
        r16.put(WindowEvent.Params.REASON, r21);
        String r22 = (String) r38.get("missing_gate");
        if (r22 == null) goto L137;
        List r25 = StringsKt.split$default(r22, new char[]{','}, false, 0, 6, null);
        if (r25 == null) goto L137;
        List r26 = r25;
        ArrayList r27 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10));
        Iterator r30 = r26.iterator();
    L101:
        if (r30.hasNext() == false) goto L103;
        r27.add(StringsKt.trim((String) r30.next()).toString());
        goto L101
    L103:
        ArrayList r31 = new ArrayList();
        Iterator r32 = r27.iterator();
    L105:
        if (r32.hasNext() == false) goto L113;
        Object r33 = r32.next();
        if (((String) r33).length() <= 0) goto L109;
        boolean r34 = true;
    L110:
        if (r34 == false) goto L105;
        r31.add(r33);
        goto L105
    L109:
        r34 = false;
        goto L110
    L113:
        if ((!r31.isEmpty()) == false) goto L126;
        Set<String> r35 = s;
        if (r31.isEmpty() == true) goto L123;
        Iterator r36 = r31.iterator();
    L119:
        if (r36.hasNext() == false) goto L123;
        if (r35.contains((String) r36.next()) == true) goto L119;
        boolean r37 = false;
    L124:
        if (r37 == false) goto L126;
        boolean r39 = true;
    L127:
        if (r39 == true) goto L130;
        r31 = null;
    L130:
        if (r31 == null) goto L137;
        List r40 = CollectionsKt.sorted(r31);
        if (r40 == null) goto L137;
        String r41 = CollectionsKt.joinToString$default(r40, ",", null, null, 0, null, null, 62, null);
        if (r41 == null) goto L137;
        r16.put("missing_gate", r41);
    L123:
        r37 = true;
    L126:
        r39 = false;
    L137:
        LinkedHashMap r42 = new LinkedHashMap();
        if (r24 == null) goto L140;
        r42.put("total_duration_ms", Long.valueOf(r24.longValue()));
    L140:
        String r43 = (String) r38.get("first_frame_duration_ms");
        if (r43 == null) goto L155;
        Long r44 = StringsKt.toLongOrNull(r43);
        if (r44 == null) goto L155;
        long r45 = r44.longValue();
        if (0 <= r45) goto L147;
    L149:
        boolean r46 = false;
    L150:
        if (r46 == true) goto L153;
        r44 = null;
    L153:
        if (r44 == null) goto L155;
        r42.put("first_frame_duration_ms", Long.valueOf(r44.longValue()));
        goto L155
    L147:
        if (r45 >= 60001) goto L149;
        r46 = true;
    L155:
        String r47 = (String) r38.get("process_uptime_ms");
        if (r47 == null) goto L168;
        Long r48 = StringsKt.toLongOrNull(r47);
        if (r48 == null) goto L168;
        if (r48.longValue() < 0) goto L162;
        boolean r49 = true;
    L163:
        if (r49 == true) goto L166;
        r48 = null;
    L166:
        if (r48 == null) goto L168;
        r42.put("process_uptime_ms", Long.valueOf(r48.longValue()));
        goto L168
    L162:
        r49 = false;
    L168:
        LinkedHashMap r50 = new LinkedHashMap();
        Iterator<T> r51 = t.iterator();
    L170:
        if (r51.hasNext() == false) goto L200;
        String r52 = (String) r51.next();
        String r53 = (String) r38.get(r52);
        if (r53 == null) goto L170;
        String r54 = StringsKt.trim(r53).toString();
        if (r54 == null) goto L170;
        int r55 = r54.length();
        if (1 <= r55) goto L178;
    L180:
        boolean r56 = false;
    L181:
        if (r56 == false) goto L192;
        int r57 = 0;
    L184:
        if (r57 >= r54.length()) goto L189;
        if (Character.isISOControl(r54.charAt(r57)) == true) goto L187;
        r57 = r57 + 1;
        goto L184
    L187:
        boolean r58 = false;
    L190:
        if (r58 == false) goto L192;
        boolean r59 = true;
    L193:
        if (r59 == true) goto L196;
        r54 = null;
    L196:
        if (r54 == null) goto L170;
        r50.put(r52, r54);
        goto L170
    L189:
        r58 = true;
    L192:
        r59 = false;
        goto L193
    L178:
        if (r55 >= 257) goto L180;
        r56 = true;
        goto L181
    L200:
        return new C0013a(r16, r42, r50);
    L76:
        if (StringsKt.startsWith$default(r21, "intercom_condition_", false, 2, null) == false) goto L80;
        String r60 = "intercom_condition_failed";
    L78:
        r21 = r60;
        goto L95
    L80:
        if (StringsKt.startsWith$default(r21, "click_talk_", false, 2, null) == false) goto L85;
        if (StringsKt.endsWith$default(r21, "_before_pcm", false, 2, null) == false) goto L85;
        r60 = "click_talk_ended_before_pcm";
    L85:
        if (StringsKt.startsWith$default(r21, "click_talk_", false, 2, null) == false) goto L90;
        if (StringsKt.endsWith$default(r21, "_before_start", false, 2, null) == false) goto L90;
        r60 = "click_talk_ended_before_start";
    L90:
        if (StringsKt.startsWith$default(r21, "continuous_talk_", false, 2, null) == true) goto L92;
    L94:
        r60 = IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER;
        goto L78
    L92:
        if (StringsKt.endsWith$default(r21, "_before_start", false, 2, null) == false) goto L94;
        r60 = "continuous_talk_ended_before_start";
        goto L78
    L58:
        r1 = "0";
        goto L59
    L49:
        if (r28 >= 60001) goto L51;
        r29 = true;
    L54:
        r24 = null;
        goto L55
    L9:
        r4 = false;
    L202:
        return null;
    }

    public static String b(Map r0, String r1, Set r2) {
        String r3 = (String) r0.get(r1);
        if (r3 == null) goto L9;
        String r4 = StringsKt.trim(r3).toString();
        if (r4 == null) goto L9;
        if (r2.contains(r4) == false) goto L9;
        return r4;
    L9:
        return null;
    }

    public static void a(Map r0, Map r1, String r2, Set r3) {
        String r4 = (String) r1.get(r2);
        if (r4 == null) goto L13;
        String r5 = StringsKt.trim(r4).toString();
        if (r5 != null) goto L7;
        return;
    L7:
        if (r3.contains(r5) == true) goto L10;
        r5 = null;
    L10:
        if (r5 == null) goto L15;
        r0.put(r2, r5);
        return;
    L15:
        return;
    }
}
