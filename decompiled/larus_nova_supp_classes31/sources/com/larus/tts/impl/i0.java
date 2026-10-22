package com.larus.tts.impl;

import com.larus.im.bean.message.Message;
import com.larus.tts.ITtsReaderInterceptor;
import com.larus.tts.TtsInterceptResult;
import com.larus.tts.TtsScene;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i0 {
    public static final List<ITtsReaderInterceptor> a = null;

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((ITtsReaderInterceptor) r2).priority()), Integer.valueOf(((ITtsReaderInterceptor) r1).priority()));
        }
    }

    static {
        a = CollectionsKt.sortedWith(ServiceManager.get().getServices(ITtsReaderInterceptor.class), new a());
    }

    public static boolean a(Message r9, TtsScene r10) {
        Intrinsics.checkNotNullParameter(r9, "message");
        Intrinsics.checkNotNullParameter(r10, "scene");
        Iterator<T> r2 = a.iterator();     // Catch: IllegalStateException -> L19
    L6:
        if (r2.hasNext() == false) goto L17;
        ITtsReaderInterceptor r3 = (ITtsReaderInterceptor) r2.next();     // Catch: IllegalStateException -> L19
        FLogger r6 = FLogger.a;     // Catch: IllegalStateException -> L19
        r6.d("TtsReaderInterceptorManager", r3.getClass().getSimpleName() + " priority: " + r3.priority());     // Catch: IllegalStateException -> L19
        if (r3.a(r9, r10) == false) goto L6;
        TtsInterceptResult r7 = r3.b(r9, r10);     // Catch: IllegalStateException -> L19
        if (r7 == TtsInterceptResult.ForcePlay) goto L11;
        if (r7 != TtsInterceptResult.Deny) goto L6;
        r6.i("TtsReaderInterceptorManager", "[TTS][DENY] from " + r3.getClass().getSimpleName() + ", scene: " + r10);     // Catch: IllegalStateException -> L19
        return false;
    L11:
        r6.i("TtsReaderInterceptorManager", "[TTS][FORCE_PLAY] from " + r3.getClass().getSimpleName() + ", scene: " + r10);     // Catch: IllegalStateException -> L19
        return true;
    L17:
        FLogger.a.i("TtsReaderInterceptorManager", "[TTS][PASS] interceptorList size : " + a.size() + ", scene: " + r10);     // Catch: IllegalStateException -> L19
        return true;
    L19:
        e = move-exception;
        FLogger.a.e("TtsReaderInterceptorManager", "[TTS][INTERCEPTOR_LIFECYCLE_ERROR] canHandle failed, interceptor=" + i0.class.getSimpleName() + ", scene=" + r10, e);
        return false;
    }
}
