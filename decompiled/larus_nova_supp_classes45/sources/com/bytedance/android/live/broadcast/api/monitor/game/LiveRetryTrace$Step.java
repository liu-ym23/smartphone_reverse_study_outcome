package com.bytedance.android.live.broadcast.api.monitor.game;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/broadcast/api/monitor/game/LiveRetryTrace$Step", "", "Companion", "a", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface LiveRetryTrace$Step {
    public static final a Companion = null;
    public static final String INTERCEPT = "game_live_retry_intercept";
    public static final String PERMISSION_DENY = "game_live_retry_permission_deny";
    public static final String PERMISSION_SUCCESS = "game_live_retry_permission_success";
    public static final String PUSH_ERROR = "game_live_retry_push_error";
    public static final String PUSH_SUCCESS = "game_live_retry_push_success";
    public static final String REQUEST_ERROR = "game_live_retry_request_error";
    public static final String REQUEST_PERMISSION = "game_live_retry_request_permission";
    public static final String WAIT_TIME_OUT = "game_live_retry_wait_time_out";

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
