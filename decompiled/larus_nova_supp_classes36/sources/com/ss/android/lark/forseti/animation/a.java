package com.ss.android.lark.forseti.animation;

import android.animation.Animator;
import android.view.View;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class a {
    public static final b b = null;
    public final Animator a;

    /* JADX INFO: renamed from: com.ss.android.lark.forseti.animation.a$a, reason: collision with other inner class name */
    public static final class C0066a {
    }

    static {
        Class<Animator> r0 = b.a(b.class.getClassLoader());     // Catch: Exception -> L5
        Constructor<Animator> r1 = r0.getConstructor(new Class[]{Integer.TYPE, Float.TYPE});     // Catch: Exception -> L5
        r1.setAccessible(true);     // Catch: Exception -> L5
        Method r2 = r0.getMethod("setTarget", new Class[]{View.class});     // Catch: Exception -> L5
        r2.setAccessible(true);     // Catch: Exception -> L5
        b r3 = new b(r1, r2);     // Catch: Exception -> L5
    L6:
        b = r3;
        return;
    L5:
        r3 = null;
        goto L6
    }

    public a(Animator r2) {
        this.a = r2;
        new WeakReference(null);
    }
}
