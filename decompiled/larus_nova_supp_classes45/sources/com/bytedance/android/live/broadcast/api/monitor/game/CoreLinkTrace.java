package com.bytedance.android.live.broadcast.api.monitor.game;

import d00.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class CoreLinkTrace extends a {
    public static final CoreLinkTrace i = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/monitor/game/CoreLinkTrace$Step;", "", "Companion", "a", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Step {
        public static final String BG_BROADCAST_FRAGMENT_CREATE = "game_broadcast_core_trace_bg_broadcast_fragment_create";
        public static final String BG_BROADCAST_FRAGMENT_DESTROY = "game_broadcast_core_trace_bg_broadcast_fragment_destroy";
        public static final String BG_BROADCAST_FRAGMENT_ERROR = "game_broadcast_core_trace_bg_broadcast_fragment_error";
        public static final String CHECK_PARAMS_CLICK_START = "game_broadcast_core_trace_check_params_click_start";
        public static final String CHECK_PARAMS_START_ACTIVITY = "game_broadcast_core_trace_check_params_start_activity";
        public static final String CLEAR_SCREEN = "game_broadcast_core_trace_clear_screen";
        public static final String CLICK_CONTINUE = "game_broadcast_core_trace_click_continue";
        public static final String CLICK_PERMISSION_DENY = "game_broadcast_core_trace_click_permission_deny";
        public static final String CLICK_PERMISSION_GRANT = "game_broadcast_core_trace_click_permission_grant";
        public static final String CLICK_START = "game_broadcast_core_trace_click_start";
        public static final String CLOSE_ROOM_STATE = "game_broadcast_core_trace_close_room_state";
        public static final String CREATE_ROOM_END = "game_broadcast_core_trace_create_room_end";
        public static final String CREATE_ROOM_START = "game_broadcast_core_trace_create_room_start";
        public static final String CREATE_SHELL_FRAGMENT = "game_broadcast_core_trace_create_shell_fragment";
        public static final a Companion = null;
        public static final String END_SHOW_INTERACTION = "game_broadcast_core_trace_end_show_interaction";
        public static final String ON_MIC_AUDIO_INTERRUPTED = "game_broadcast_core_trace_on_mic_audio_interrupted";
        public static final String ON_MIC_AUDIO_RELAUNCH = "game_broadcast_core_trace_on_mic_audio_relaunch";
        public static final String ON_RECORD_AUDIO_ERROR = "game_broadcast_core_trace_on_record_audio_error";
        public static final String ON_RECORD_AUDIO_LAUNCH = "game_broadcast_core_trace_on_record_audio_launch";
        public static final String ON_RECORD_AUDIO_NOT_SUPPORT = "game_broadcast_core_trace_on_record_audio_not_support";
        public static final String ON_STREAM_END = "game_broadcast_core_trace_on_stream_end";
        public static final String ON_STREAM_ON_RECONNECT = "game_broadcast_core_trace_on_stream_on_reconnect";
        public static final String ON_STREAM_RECONNECTED = "game_broadcast_core_trace_on_stream_reconnected";
        public static final String ON_STREAM_START = "game_broadcast_core_trace_on_stream_start";
        public static final String READY_START_LIVE_ACTIVITY = "game_broadcast_core_trace_ready_start_live_activity";
        public static final String SCREEN_SHOT_FIX_SIZE = "game_broadcast_core_trace_screen_shot_fix_size";
        public static final String SERVICE_CONNECTED = "game_broadcast_core_trace_service_connected";
        public static final String SERVICE_DISCONNECTED = "game_broadcast_core_trace_service_disconnected";
        public static final String SHOW_END_FRAGMENT = "game_broadcast_core_trace_show_end_fragment";
        public static final String SHOW_PERMISSION = "game_broadcast_core_trace_show_permission";
        public static final String START_LIVE_ACTIVITY = "game_broadcast_core_trace_start_live_activity";
        public static final String START_PUSH_STREAM = "game_broadcast_core_trace_start_push_stream";
        public static final String START_SHOW_INTERACTION = "game_broadcast_core_trace_start_show_interaction";
        public static final String START_SUB_LIVE_ACTIVITY = "game_broadcast_core_trace_start_sub_live_activity";
        public static final String STOP_PUSH_STREAM = "game_broadcast_core_trace_stop_push_stream";

        public static final class a {
            public static final /* synthetic */ a a = null;

            public a() {
            }

            static {
                a = new a();
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Override // d00.a
    public final String c() {
        return GameLiveModule.CORE_TRACE;
    }

    static {
        i = new CoreLinkTrace();
    }

    public CoreLinkTrace() {
    }
}
