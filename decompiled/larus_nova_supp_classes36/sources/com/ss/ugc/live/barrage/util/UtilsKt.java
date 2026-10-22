package com.ss.ugc.live.barrage.util;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class UtilsKt {
    public static final /* synthetic */ KProperty[] a = null;
    public static final Lazy b = null;

    static {
        a = new KProperty[]{Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinPackage(UtilsKt.class, "barrage_release"), "mainThreadHandler", "getMainThreadHandler()Landroid/os/Handler;"))};
        b = LazyKt.lazy(UtilsKt$mainThreadHandler$2.INSTANCE);
        new ReentrantLock();
    }

    public static void a() {
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Main thread ONLY!".toString());
    }

    public static final void b(View r3) {
        r3.forceLayout();
        if ((r3 instanceof ViewGroup) == false) goto L7;
        ViewGroup r4 = (ViewGroup) r3;
        int r0 = r4.getChildCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        b(r4.getChildAt(r1));
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }
}
