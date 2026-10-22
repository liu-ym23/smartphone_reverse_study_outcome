package com.bytedance.badger.z;

import android.os.Handler;
import android.os.HandlerThread;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class S extends Lambda implements Function0 {
    public static final S a = null;

    static {
        a = new S();
    }

    public S() {
        super(0);
    }

    public Object invoke() {
        h0.c.getClass();
        Lazy r1 = h0.a;
        KProperty r2 = e0.a[0];
        return new Handler(((HandlerThread) r1.getValue()).getLooper());
    }
}
