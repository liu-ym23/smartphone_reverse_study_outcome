package com.larus.audio.call.util;

import com.larus.audio.call.plugins.b0;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.w1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class r {
    public static final CoroutineScope a = null;

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.Key r1) {
            super(r1);
        }

        public final void handleException(CoroutineContext r3, Throwable r4) {
            e.a.w("ThreadUtils", "[thread-util-scope] exception: " + r4.getMessage());
        }
    }

    static {
        a = CoroutineScopeKt.CoroutineScope(w1.a(1, "flow-av-kit-thread-util").plus(new a(CoroutineExceptionHandler.Key)));
    }

    public static Job a(long r7, b0 r9) {
        Intrinsics.checkNotNullParameter(r9, "task");
        return BuildersKt.launch$default(a, null, null, new ThreadUtils$schedule$1(r7, r9, null), 3, null);
    }
}
