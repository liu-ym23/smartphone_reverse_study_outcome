package com.bytedance.android.livesdk.feedback.condition.observer;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T> implements Consumer {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void accept(Object r2) {
        ALogger.e("LiveRoomFeedbackConditionObserver getLiveRoomFeedbackCard failed", (Throwable) r2);
    }
}
