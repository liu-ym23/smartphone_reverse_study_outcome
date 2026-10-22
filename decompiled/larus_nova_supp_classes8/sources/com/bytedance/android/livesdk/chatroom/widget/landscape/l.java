package com.bytedance.android.livesdk.chatroom.widget.landscape;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l<T> implements Consumer {
    public static final l a = null;

    static {
        a = new l();
    }

    public l() {
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        x8.a.b("LandscapeQuickShotWindow", "autodismiss Fail", false);
    }
}
