package com.bytedance.android.livesdk.chatroom.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a2<T> implements Consumer {
    public static final a2 a = null;

    static {
        a = new a2();
    }

    public a2() {
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        x8.a.b("LandscapeQuickShotWindow", "autodismiss Fail", false);
    }
}
