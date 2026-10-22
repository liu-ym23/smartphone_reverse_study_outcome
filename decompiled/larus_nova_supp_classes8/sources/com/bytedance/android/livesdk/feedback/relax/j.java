package com.bytedance.android.livesdk.feedback.relax;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j<T> implements Consumer {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
    }

    public final void accept(Object r3) {
        ALogger.e("LiveLightFeedbackWidget", "show feedback page fail on anim start", (Throwable) r3);
    }
}
