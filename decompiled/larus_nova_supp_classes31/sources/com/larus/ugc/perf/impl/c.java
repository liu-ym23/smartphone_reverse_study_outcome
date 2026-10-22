package com.larus.ugc.perf.impl;

import android.text.TextUtils;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public static final c a = null;
    public static final ConcurrentHashMap<String, g> b = null;
    public static final a c = null;
    public static final Lazy d = null;

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.Key r1) {
            super(r1);
        }

        public final void handleException(CoroutineContext r3, Throwable r4) {
            FLogger.a.e("BasePerfMonitor", "err! msg=" + r4);
        }
    }

    public c() {
    }

    static {
        a = new c();
        b = new ConcurrentHashMap();
        c = new a(CoroutineExceptionHandler.Key);
        d = LazyKt.lazy(new b());
    }

    @JvmStatic
    public static final void a(String r6) {
        Intrinsics.checkNotNullParameter(r6, "trackerKey");
        String[] r1 = {""};
        Intrinsics.checkNotNullParameter(r6, "trackerKey");
        Intrinsics.checkNotNullParameter(r1, "keyValues");
        if (TextUtils.isEmpty(r6) == true) goto L19;
        a.getClass();
        g r0 = b(r6);
        if (r0 == null) goto L18;
        e(r6);
        if (r0.a() <= 0) goto L20;
        int r2 = 0;
        int r7 = ProgressionUtilKt.getProgressionLastElement(0, -1, 2);
        if (r7 < 0) goto L15;
    L12:
        r0.d(r1[r2], r1[r2 + 1]);
        if (r2 == r7) goto L15;
        r2 = r2 + 2;
    L15:
        JSONObject r8 = r0.c();
        c r3 = a;
        String r4 = r0.a;
        r3.getClass();
        f(r4, r8);
        return;
    L20:
        return;
    L18:
        return;
    }

    public static g b(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return null;
    L5:
        if (r2 != null) goto L7;
        return null;
    L7:
        return b.get(r2);
    }

    public static void e(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return;
    L5:
        TypeIntrinsics.asMutableMap(b).remove(r1);
    }

    @JvmStatic
    public static final void c(String r5, String... r6) {
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r6, "keyValues");
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        a.getClass();
        g r0 = b(r5);
        if (r0 == null) goto L15;
        int r3 = 0;
        int r1 = ProgressionUtilKt.getProgressionLastElement(0, r6.length - 2, 2);
        if (r1 < 0) goto L12;
    L9:
        r0.d(r6[r3], r6[r3 + 1]);
        if (r3 == r1) goto L12;
        r3 = r3 + 2;
    L12:
        a.getClass();
        d(r5, r0);
        return;
    }

    public static void d(String r6, g r7) {
        Intrinsics.checkNotNullParameter(r7, "tracker");
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return;
    L5:
        if (r6 == null) goto L7;
        b.put(r6, r7);
    L7:
        BuildersKt.launch$default((CoroutineScope) d.getValue(), null, null, new BasePerfMonitor$cleanUpExpiredTrackers$1(null), 3, null);
    }

    public static void f(String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "dataJson");
        o.a.reportEvent(r3, r4);     // Catch: Exception -> L5
        FLogger.a.i("BasePerfMonitor", r3 + ":\t " + r4);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        FLogger.a.e("BasePerfMonitor", "reportEvent error", e);
    }

    @JvmStatic
    public static final void g(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "trackerKey");
        Intrinsics.checkNotNullParameter(r6, "eventName");
        String[] r2 = {""};
        Intrinsics.checkNotNullParameter(r5, "trackerKey");
        Intrinsics.checkNotNullParameter(r6, "eventName");
        Intrinsics.checkNotNullParameter(r2, "keyValues");
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L16;
        g r0 = new g(r6);
        int r1 = 0;
        int r7 = ProgressionUtilKt.getProgressionLastElement(0, -1, 2);
        if (r7 < 0) goto L12;
    L9:
        r0.d(r2[r1], r2[r1 + 1]);
        if (r1 == r7) goto L12;
        r1 = r1 + 2;
    L12:
        a.getClass();
        d(r5, r0);
        return;
    }
}
