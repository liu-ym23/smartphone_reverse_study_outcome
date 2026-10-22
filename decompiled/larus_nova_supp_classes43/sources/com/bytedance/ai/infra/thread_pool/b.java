package com.bytedance.ai.infra.thread_pool;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.android.HandlerDispatcher;
import kotlinx.coroutines.android.HandlerDispatcherKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final a a = null;
    public static final a b = null;
    public static final a c = null;
    public static final a d = null;
    public static final HandlerDispatcher e = null;

    static {
        a = new a(f.a);
        b = new a(f.b);
        new a(f.c);
        c = new a(f.d);
        d = new a(f.e);
        Looper r0 = Looper.getMainLooper();
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (Build.VERSION.SDK_INT < 28) goto L10;
        Handler r1 = Handler.createAsync(r0);
    L8:
        e = HandlerDispatcherKt.from(r1, "fast-main");
        return;
    L10:
        Constructor r10 = Handler.class.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE});     // Catch: NoSuchMethodException -> L7
        r1 = (Handler) r10.newInstance(new Object[]{r0, null, Boolean.TRUE});
    L7:
        r1 = new Handler(r0);
        goto L8
    }
}
