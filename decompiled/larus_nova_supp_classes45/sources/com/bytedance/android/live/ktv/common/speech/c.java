package com.bytedance.android.live.ktv.common.speech;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c<T> implements Consumer {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final void accept(Object r3) {
        ALogger.e("LinkSpeechRecognizer", "onStart, interval exception: " + ((Throwable) r3).getMessage());
    }
}
