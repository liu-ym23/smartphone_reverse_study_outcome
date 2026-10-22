package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.settingmanager;

import com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.i;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements Consumer {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final void accept(Object r1) {
        Throwable r2 = (Throwable) r1;
        i.d("prefetch simple setting failed");
    }
}
