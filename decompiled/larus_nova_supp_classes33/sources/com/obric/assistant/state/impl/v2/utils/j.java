package com.obric.assistant.state.impl.v2.utils;

import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j {
    public static final Lazy a = null;
    public static final ExecutorCoroutineDispatcher b = null;
    public static final a c = null;
    public static final Lazy d = null;

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.Key r1) {
            super(r1);
        }

        public final void handleException(CoroutineContext r2, Throwable r3) {
            FLogger.a.e("ObricStateMachine", r3.getMessage());
        }
    }

    static {
        a = LazyKt.lazy(new g());
        b = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new h()));
        c = new a(CoroutineExceptionHandler.Key);
        d = LazyKt.lazy(new i());
    }
}
