package com.bytedance.android.live.pushstream.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/pushstream/util/LiveStreamMonitorUtils$ChangeVideoFpsReason", "", "Companion", "a", "livepushstream-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public @interface LiveStreamMonitorUtils$ChangeVideoFpsReason {
    public static final String ANCHOR_DEGRADE_LEVEL_TWO = "anchor_degrade_level_two";
    public static final String ANCHOR_DEGRADE_RECOVER = "anchor_degrade_recover";
    public static final String ANCHOR_FPS_STRATEGY_CONFIG = "anchor_fps_strategy_config";
    public static final a Companion = null;

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
