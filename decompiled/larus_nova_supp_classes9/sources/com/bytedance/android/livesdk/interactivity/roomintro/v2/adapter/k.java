package com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k<T> implements Consumer {
    public static final k a = null;

    static {
        a = new k();
    }

    public k() {
    }

    public final void accept(Object r2) {
        ALogger.e("RoomIntroDialogV2", (Throwable) r2);
    }
}
