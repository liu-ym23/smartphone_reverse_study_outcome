package com.bytedance.android.livesdk.feedback.relax;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h<T> implements Consumer {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
    }

    public final void accept(Object r3) {
        ALogger.e("LiveLightFeedbackWidget", "hide feedback page fail on anim end", (Throwable) r3);
    }
}
