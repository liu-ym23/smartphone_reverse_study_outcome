package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation;

import android.animation.TimeInterpolator;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.ss.android.lark.log.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sob.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public final ViewGroup a;
    public final List<d> b;
    public final TransitionSet c;

    public c(ConstraintLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "rootContainer");
        this.a = r2;
        this.b = new ArrayList();
        this.c = new TransitionSet();
    }

    public final void b(Function1 r2) {
        Intrinsics.checkNotNullParameter(r2, "transitionInfo");
        r2.invoke(this.c);
    }

    public static void a(c r1, ConstraintLayout r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, "endElementsStateConfig");
        d r0 = new d(r2);
        r3.invoke(r0);
        ((ArrayList) r1.b).add(r0);
    }

    public static void c(c r2, final Function1 r3, final Function1 r4, long r5, TimeInterpolator r7, int r8) {
        if ((r8 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r5 = 150;
    L12:
        if ((r8 & 8) == 0) goto L14;
        r7 = new LinearInterpolator();
    L14:
        Intrinsics.checkNotNullParameter(r7, "interpolator");
        final TransitionSet r9 = r2.c;
        r9.addListener(new MotionScene$executeMotion$lambda$3$$inlined$doOnEnd$1(r9, r4, r9));
        r9.addListener(new MotionScene$executeMotion$lambda$3$$inlined$doOnStart$1(r9, r3, r9));
        r9.setDuration(r5);
        r9.setInterpolator(r7);
        TransitionManager.beginDelayedTransition(r2.a, r2.c);
        ArrayList<Transition> r6 = e.a;
        final Transition r10 = r2.c;
        ViewGroup r11 = r2.a;
        Intrinsics.checkNotNullParameter(r10, "task");
        Intrinsics.checkNotNullParameter(r11, "sceneRoot");
        Iterator<Transition> r12 = e.a.iterator();
    L16:
        if (r12.hasNext() == false) goto L26;
        Transition r13 = r12.next();
        int r14 = f.a;
        Object[] r15 = {r11};
        Intrinsics.checkNotNullParameter(r13, "target");
        Intrinsics.checkNotNullParameter("forceToEnd", "methodName");
        Intrinsics.checkNotNullParameter(r15, "args");
        Method r0 = f.a(r13.getClass(), r15);     // Catch: Exception -> L24
        if (r0 == null) goto L21;
        r0.setAccessible(true);     // Catch: Exception -> L24
    L21:
        if (r0 == null) goto L16;
        r0.invoke(r13, Arrays.copyOf(r15, 1));     // Catch: Exception -> L24
    L24:
        e = move-exception;
        Log.w("ReflectUtil", "couldn't invoke forceToEnd on " + r13 + ", " + e);
        goto L16
    L26:
        ArrayList<Transition> r16 = e.a;
        r16.clear();
        r16.add(r10);
        r10.addListener(new TransitionTaskController$whenPostTask$$inlined$doOnEnd$1(r10, r10));
        Iterator r17 = ((ArrayList) r2.b).iterator();
    L28:
        if (r17.hasNext() == false) goto L30;
        d r18 = (d) r17.next();
        d.b(r18);
        r18.c.applyTo(r18.a);
        goto L28
    }
}
