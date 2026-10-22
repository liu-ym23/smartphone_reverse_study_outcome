package com.bytedance.forest;

import android.os.AsyncTask;
import android.os.Handler;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.w;
import com.bytedance.forest.utils.e;
import com.bytedance.forest.utils.g;
import com.bytedance.forest.utils.p;
import com.bytedance.forest.utils.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f4230b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.frameworks.baselib.network.http.cronet.b f4231c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f4232a;

    static {
        f4231c = new com.bytedance.frameworks.baselib.network.http.cronet.b(5);
        f4230b = LazyKt.lazy(InternalReporter$Companion$uniqueId$2.f4224a);
    }

    public b(e r5) {
        this.f4232a = r5;
    }

    public static final void b(b r16, String r17, JSONObject r18, w r19, JSONObject r20, LinkedHashMap r21, int r22) {
        r16.getClass();
        Request r5 = r19.f4441q;
        za.c r10 = za.b.f23424a;
        if (r10.f23426b.get() == false) goto L5;
        JSONObject r11 = r16.a();
        r10.a(r17, r18, r11, r20);
    L7:
        if (r5.isPreload() == false) goto L13;
        if (r11 != null) goto L10;
        JSONObject r12 = r16.a();
    L11:
        ArrayList r13 = c.f4233a;
        c.a(r19, r17, r18, r12, r20, r22, r16.f4232a);
        return;
    L10:
        r12 = r11;
        goto L11
    L13:
        Map<String, Object> r14 = r5.getCustomParams();
        ArrayList r15 = c.f4233a;
        e r23 = r16.f4232a;
        ArrayList r24 = c.f4233a;
        monitor-enter(r24);
        Iterator r25 = r24.iterator();     // Catch: Throwable -> L31
    L17:
        if (r25.hasNext() == false) goto L33;
        y4.a r26 = (y4.a) r25.next();     // Catch: Throwable -> L31
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L25
        r26.getClass();     // Catch: Throwable -> L25
        y4.a.b(r17, r21, r14, r19);     // Catch: Throwable -> L23
        Object r28 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L28:
        Throwable r110 = Result.m127exceptionOrNullimpl(r28);     // Catch: Throwable -> L31
        if (r110 == null) goto L17;
        com.bytedance.forest.utils.d.b(r23.g, 6, "ResourceReporter", "custom report error", false, r110, null, 40);     // Catch: Throwable -> L31
    L23:
        th = th;
    L27:
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L31
        r28 = Result.m124constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L31
    L25:
        th = th;
        goto L27
    L33:
        Unit r30 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r24);
        return;
    L31:
        th = move-exception;
        throw th;
    L5:
        r11 = null;
        goto L7
    }

    public static void d(final w r5, final Throwable r10) {
        g r11 = q.f4656a;
        p r12 = new p(new InternalReporter$reportForestConsume$1(r5, r10));
        AsyncTask.THREAD_POOL_EXECUTOR.execute(r12);
    }

    public final JSONObject a() {
        e r12 = this.f4232a;
        JSONObject r5 = new JSONObject();
        ConcurrentHashMap r10 = r12.d;     // Catch: Exception -> L25
        Iterator r11 = r10.entrySet().iterator();     // Catch: Exception -> L25
    L4:
        if (r11.hasNext() == false) goto L35;
        Map.Entry r13 = (Map.Entry) r11.next();     // Catch: Exception -> L25
        String r14 = (String) r13.getKey();     // Catch: Exception -> L25
        String r15 = "_finish";
        if (StringsKt.k(r14, "_start") == false) goto L11;
        String r16 = StringsKt.B(r14, "_start");     // Catch: Exception -> L25
        boolean r17 = true;
    L13:
        if (r5.opt(r16) != null) goto L4;
        StringBuilder r18 = new StringBuilder();     // Catch: Exception -> L25
        r18.append(r16);     // Catch: Exception -> L25
        if (r17 == true) goto L19;
        r15 = "_start";
    L19:
        r18.append(r15);     // Catch: Exception -> L25
        String r19 = r18.toString();     // Catch: Exception -> L25
        if (r10.containsKey(r19) == false) goto L4;
        if (r17 == false) goto L28;
        Object r20 = r10.get(r19);     // Catch: Exception -> L25
        if (r20 != null) goto L27;
        Intrinsics.throwNpe();     // Catch: Exception -> L25
    L27:
        long r21 = ((Number) r20).longValue();     // Catch: Exception -> L25
        long r22 = ((Number) r13.getValue()).longValue();     // Catch: Exception -> L25
    L32:
        r5.put(r16, r21 - r22);     // Catch: Exception -> L25
        goto L4
    L28:
        long r23 = ((Number) r13.getValue()).longValue();     // Catch: Exception -> L25
        Object r24 = r10.get(r19);     // Catch: Exception -> L25
        if (r24 != null) goto L31;
        Intrinsics.throwNpe();     // Catch: Exception -> L25
    L31:
        r21 = r23;
        r22 = ((Number) r24).longValue();     // Catch: Exception -> L25
        goto L32
    L11:
        r16 = StringsKt.B(r14, "_finish");     // Catch: Exception -> L25
        r17 = false;
    L35:
        return r5;
    L25:
        e = move-exception;
        com.bytedance.forest.utils.d.b(r12.g, 6, "ResourceReporter", "assemble duration error", false, e, null, 40);
        goto L35
    }

    public final void c(w r5) {
        ab.b r10 = new ab.b(8, this, r5);
        ((Handler) q.f4658c.getValue()).post(r10);
    }
}
