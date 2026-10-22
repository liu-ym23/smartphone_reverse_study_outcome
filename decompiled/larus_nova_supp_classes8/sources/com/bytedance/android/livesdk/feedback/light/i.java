package com.bytedance.android.livesdk.feedback.light;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i<T> implements Consumer {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public final void accept(Object r3) {
        ALogger.e("LiveLightFeedbackWidget", "show feedback page fail on anim start", (Throwable) r3);
    }
}
