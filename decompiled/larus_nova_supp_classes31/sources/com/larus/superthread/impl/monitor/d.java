package com.larus.superthread.impl.monitor;

import android.os.Looper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.GroupingKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public d() {
    }

    public static void a(JSONObject r13) {
        Intrinsics.checkNotNullParameter(r13, "params");
        boolean r0 = false;
        PolarisFileWrapper r1 = new PolarisFileWrapper("/proc/self/task/");     // Catch: Throwable -> L9
        if (r1.exists() == false) goto L10;
        String[] r2 = r1.list();     // Catch: Throwable -> L9
        if (r2 == null) goto L10;
        int r3 = r2.length;     // Catch: Throwable -> L9
    L11:
        if (r3 != 0) goto L13;
        return;
    L13:
        ThreadGroup r4 = ThreadMethodProxy.getLooperThread(Looper.getMainLooper()).getThreadGroup();
    L14:
        Object r5 = null;
        if (r4 == null) goto L17;
        ThreadGroup r6 = r4.getParent();
    L18:
        if (r6 == null) goto L20;
        r4 = r4.getParent();
        goto L14
    L20:
        if (r4 != null) goto L22;
        return;
    L22:
        int r7 = r4.activeCount();
        int r8 = r7 + (r7 / 2);
        Thread[] r9 = new Thread[r8];
        int r10 = r4.enumerate(r9);
        if (r8 != 0) goto L25;
        r0 = true;
    L25:
        if (r0 == false) goto L39;
    L35:
        r13.put("total_thread_count", r3);
        r13.put("java_thread_count", r10);
        r13.put("native_thread_count", r3 - r10);
        r13.put("thread_names", r5);
        r13.putOpt("current_thread", ThreadMethodProxy.currentThread().getName());
        return;
    L39:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L29
        r5 = CollectionsKt.joinToString$default(GroupingKt.eachCount(new c(ArraysKt.filterNotNull(r9))).entrySet(), ",", null, null, 0, null, new b(), 30, null);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r14) == true) goto L34;
        r5 = r14;
    L34:
        r5 = (String) r5;
        goto L35
    L17:
        r6 = null;
    L10:
        r3 = 0;
        goto L11
    }
}
