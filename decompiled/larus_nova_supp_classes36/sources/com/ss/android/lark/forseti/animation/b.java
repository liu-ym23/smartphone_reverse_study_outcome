package com.ss.android.lark.forseti.animation;

import android.animation.Animator;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public final Constructor<Animator> a;
    public final Method b;

    public static Class<Animator> a(ClassLoader r4) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L38;
        Class<?> r5 = r4.loadClass("android.view.RenderNodeAnimator");     // Catch: Throwable -> L8
        Class r6 = r5;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L31;
        FastClassNotFoundHandler.a("android.view.RenderNodeAnimator");     // Catch: Throwable -> L8
        r6 = r5;
    L31:
        if (Animator.class.isAssignableFrom(r6) == false) goto L34;
        return r6;
    L34:
        throw new ClassCastException(String.format("you can not cast class %s to %s.", new Object[]{r6, Animator.class}));
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.view.RenderNodeAnimator");
    L12:
        throw th;
    L38:
        Class<?> r7 = r4.loadClass("android.view.RenderNodeAnimator");     // Catch: Throwable -> L17
        r6 = r7;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L31;
        FastClassNotFoundHandler.a("android.view.RenderNodeAnimator");     // Catch: Throwable -> L17
        r6 = r7;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.view.RenderNodeAnimator");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        r6 = MiraPluginFix.loadClass("android.view.RenderNodeAnimator");
        goto L31
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }

    public b(Constructor<Animator> r1, Method r2) {
        this.a = r1;
        this.b = r2;
    }
}
