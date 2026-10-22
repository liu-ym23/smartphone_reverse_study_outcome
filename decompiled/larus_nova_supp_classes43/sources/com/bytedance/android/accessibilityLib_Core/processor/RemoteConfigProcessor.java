package com.bytedance.android.accessibilityLib_Core.processor;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.w1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class RemoteConfigProcessor {
    public static final CoroutineScope a = null;
    public static com.bytedance.android.accessibilityLib_Core.config.remote.step.b b;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static boolean e;

    public static final class InternalHandler extends Handler {
        public InternalHandler(Looper r1) {
            super(r1);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r10) {
            super.handleMessage(r10);
            CoroutineScope r11 = RemoteConfigProcessor.a;
            BuildersKt.async$default(RemoteConfigProcessor.a, null, null, new RemoteConfigProcessor$InternalHandler$handleMessage$1(null), 3, null);
        }
    }

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.Key r1) {
            super(r1);
        }

        public final void handleException(CoroutineContext r10, Throwable r11) {
            if (("RemoteConfigProcessor error = " + r11.getMessage()) == null) goto L5;
            Context r12 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
        L5:
            r11.printStackTrace();
        }
    }

    static {
        a = CoroutineScopeKt.CoroutineScope(w1.a(1, "RemoteConfigProcessor").plus(SupervisorKt.SupervisorJob$default(null, 1, null)).plus(new a(CoroutineExceptionHandler.Key)));
        c = LazyKt.lazy(RemoteConfigProcessor$applyStep$2.INSTANCE);
        d = LazyKt.lazy(RemoteConfigProcessor$internalHandler$2.INSTANCE);
    }

    public static void a(boolean r10) {
        BuildersKt.launch$default(a, null, null, new RemoteConfigProcessor$process$1(r10, null), 3, null);
        if (com.bytedance.android.accessibilityLib_Core.engine.b.b == true) goto L6;
        ((InternalHandler) d.getValue()).sendEmptyMessageDelayed(1, 60000);
        return;
    }
}
