package com.bytedance.android.livesdk.feedback.light;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g<T> implements Consumer {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final void accept(Object r3) {
        ALogger.e("LiveLightFeedbackWidget", "hide feedback page fail on anim end", (Throwable) r3);
    }
}
