package com.bytedance.android.live.room.navi.tetris;

import com.bytedance.android.live.core.monitor.SafetyGuard;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Consumer {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        SafetyGuard.a(null, null, "anchor_new_close_live_popup_error");
    }
}
