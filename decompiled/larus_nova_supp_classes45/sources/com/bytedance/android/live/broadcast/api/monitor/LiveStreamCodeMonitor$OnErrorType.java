package com.bytedance.android.live.broadcast.api.monitor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/broadcast/api/monitor/LiveStreamCodeMonitor$OnErrorType", "", "Companion", "a", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public @interface LiveStreamCodeMonitor$OnErrorType {
    public static final a Companion = null;
    public static final String MSG_ERROR_ADM_PLAYER = "MSG_ERROR_ADM_PLAYER";
    public static final String MSG_ERROR_ADM_RECORDING = "MSG_ERROR_ADM_RECORDING";
    public static final String MSG_ERROR_AUDIO_CAPTURE = "MSG_ERROR_AUDIO_CAPTURE";
    public static final String MSG_ERROR_AUDIO_ENCODER = "MSG_ERROR_AUDIO_ENCODER";
    public static final String MSG_ERROR_RTMP = "MSG_ERROR_RTMP";
    public static final String MSG_ERROR_VIDEO_CAPTURE = "MSG_ERROR_VIDEO_CAPTURE";
    public static final String MSG_ERROR_VIDEO_ENCODER = "MSG_ERROR_VIDEO_ENCODER";
    public static final String MSG_STATUS_EXCEPTION = "MSG_STATUS_EXCEPTION";

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
