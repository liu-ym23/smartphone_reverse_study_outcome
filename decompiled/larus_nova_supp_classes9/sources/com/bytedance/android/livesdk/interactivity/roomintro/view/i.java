package com.bytedance.android.livesdk.interactivity.roomintro.view;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i<T> implements Consumer {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public final void accept(Object r2) {
        ALogger.e("com.bytedance.android.livesdk.interactivity.roomintro.view.RoomIntroDialog", (Throwable) r2);
    }
}
