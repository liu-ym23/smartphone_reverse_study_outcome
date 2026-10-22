package com.larus.avlink.activeSummary;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class j {
    public static final a c = null;
    public static volatile j d;
    public final Handler a;
    public final AtomicInteger b;

    public static final class a {
        public a() {
        }
    }

    static {
        c = new a();
    }

    public j() {
        this.a = new Handler(Looper.getMainLooper());
        this.b = new AtomicInteger(23000);
    }
}
