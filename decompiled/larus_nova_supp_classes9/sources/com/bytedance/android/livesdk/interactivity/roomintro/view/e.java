package com.bytedance.android.livesdk.interactivity.roomintro.view;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T> implements Consumer {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final void accept(Object r2) {
        ALogger.e("com.bytedance.android.livesdk.interactivity.roomintro.view.RoomIntroDialog", (Throwable) r2);
    }
}
