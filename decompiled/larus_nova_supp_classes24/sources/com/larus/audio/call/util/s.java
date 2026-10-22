package com.larus.audio.call.util;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.random.Random;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.w1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class s {
    public static final CoroutineScope a = null;

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.Key r1) {
            super(r1);
        }

        public final void handleException(CoroutineContext r3, Throwable r4) {
            e.a.w("TimeUtils", "[timerScope] exception: " + r4.getMessage());
        }
    }

    static {
        a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(w1.a(1, "flow-av-kit-timer")).plus(new a(CoroutineExceptionHandler.Key)));
    }

    public static boolean a(float r6) {
        double r0 = 2;
        float r4 = (float) Math.pow(10.0d, r0);
        int r1 = (int) Math.pow(10.0d, r0);
        if (Random.Default.nextInt(0, r1) >= ((int) ((((int) (r6 * r4)) / r4) * r1))) goto L6;
        return true;
    L6:
        return false;
    }
}
