package com.obric.cae.smartNetwork.AppQoEManager;

/* JADX INFO: loaded from: classes2.dex */
public final class AIMediaEventSchema {
    public static final String EVENT_AUDIO_TRACK_UNDERRUN_STATS = "audio_track_underrun_stats";
    public static final String EVENT_CODEC_INPUT_BITRATE_UPDATE = "media_codec_bitrate_update";
    public static final String EVENT_CODEC_NETWORK_STARVATION = "media_codec_network_starvation";
    public static final String EVENT_CODEC_PAUSE = "media_codec_pause";
    public static final String EVENT_CODEC_RESUME = "media_codec_resume";
    public static final String EVENT_CODEC_START = "media_codec_start";
    public static final String EVENT_CODEC_STOP = "media_codec_stop";
    public static final String FIELD_CODEC_BITRATE = "bitrate";
    public static final String FIELD_CODEC_END_TIME = "codec_end_time";
    public static final String FIELD_CODEC_EVENT = "codec_event";
    public static final String FIELD_CODEC_INPUT_BITRATE_BPS = "codec_input_bitrate_bps";
    public static final String FIELD_CODEC_INPUT_BITRATE_BPS_5S = "codec_input_bitrate_bps_5s";
    public static final String FIELD_CODEC_NAME = "codec_name";
    public static final String FIELD_CODEC_START_TIME = "codec_start_time";
    public static final String FIELD_ENCODER = "encoder";
    public static final String FIELD_FRAME_RATE = "frame_rate";
    public static final String FIELD_HEIGHT = "height";
    public static final String FIELD_KEY_EVENT = "key_event";
    public static final String FIELD_LOW_LATENCY = "low_latency";
    public static final String FIELD_LOW_LATENCY_MODE = "low_latency_mode";
    public static final String FIELD_MIME = "mime";
    public static final String FIELD_PORT_ID = "port_id";
    public static final String FIELD_RENDER_FRAME_RATE = "render_frame_rate";
    public static final String FIELD_SECURE = "secure";
    public static final String FIELD_SOURCE_BITRATE_BPS = "source_bitrate_bps";
    public static final String FIELD_SOURCE_DURATION_US = "source_duration_us";
    public static final String FIELD_STALL_REASON = "stall_reason";
    public static final String FIELD_SURFACE_TO_SCREEN = "surface_to_screen";
    public static final String FIELD_TRACK_ID = "track_id";
    public static final int FIELD_TYPE_INT64 = 2;
    public static final int FIELD_TYPE_STRING = 4;
    public static final String FIELD_UNDERRUN_FIRST_THRESHOLD_COUNT = "first_threshold_count";
    public static final String FIELD_UNDERRUN_SECOND_THRESHOLD_COUNT = "second_threshold_count";
    public static final String FIELD_UNDERRUN_TOTAL_MS = "total_underrun_ms";
    public static final String FIELD_UNDERRUN_WINDOW_DURATION_MS = "window_duration_ms";
    public static final String FIELD_UNDERRUN_WINDOW_START_MS = "window_start_ms";
    public static final String FIELD_USE_SURFACE = "use_surface";
    public static final String FIELD_VIDEO_HEIGHT = "video_height";
    public static final String FIELD_VIDEO_WIDTH = "video_width";
    public static final String FIELD_WIDTH = "width";
    public static final String MEDIA_TYPE_AUDIO = "audio";
    public static final String MEDIA_TYPE_CODEC = "codec";
    public static final String ORIGIN_AIMEDIA_AIDL = "AIMEDIA_AIDL";
    public static final String ORIGIN_LEGACY_BPBINDER = "LEGACY_BPBINDER";
    public static final String SOURCE_AIMEDIA_REALTIME_METRICS = "aimedia.realtime_metrics";
    public static final String SOURCE_AUDIO_FLINGER = "audioflinger";
    public static final String STALL_REASON_NETWORK_CONTINUOUS_SPARSE_INPUT = "network_starvation_like.continuous_sparse_input";
    public static final String STALL_REASON_NETWORK_FLUCTUATE_THEN_STOP = "network_starvation_like.fluctuate_then_stop";
    public static final String STALL_REASON_NETWORK_INPUT_BUFFERS_RETURNED = "network_starvation_like.input_buffers_returned";
    public static final String STALL_REASON_NETWORK_TINY_INPUT_TRICKLE = "network_starvation_like.tiny_input_trickle";
    public static final String STALL_REASON_PAUSE_NO_INPUT_HISTORY = "pause_like.no_input_history";
    public static final String STALL_REASON_PAUSE_SUDDEN_ZERO_INPUT = "pause_like.sudden_zero_input";

    private AIMediaEventSchema() {
    }
}
