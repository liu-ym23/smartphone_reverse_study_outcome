package com.bytedance.badger.utils;

import android.os.Handler;
import android.os.HandlerThread;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class C extends Lambda implements Function0 {
    public static final C a = null;

    static {
        a = new C();
    }

    public C() {
        super(0);
    }

    public Object invoke() {
        f.d.getClass();
        Lazy r1 = f.b;
        KProperty r2 = f.a[0];
        return new Handler(((HandlerThread) r1.getValue()).getLooper());
    }
}
