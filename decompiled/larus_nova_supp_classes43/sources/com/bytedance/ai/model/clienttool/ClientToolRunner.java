package com.bytedance.ai.model.clienttool;

import androidx.collection.LruCache;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.LLMData;
import com.bytedance.ai.model.x;
import java.util.LinkedHashMap;
import java.util.UUID;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ClientToolRunner {
    public static final ClientToolRunner a = null;
    public static final LinkedHashMap<String, ClientToolRuntime> b = null;
    public static final LinkedHashMap<String, ClientToolRuntime> c = null;
    public static final CoroutineScope d = null;

    public ClientToolRunner() {
    }

    static {
        a = new ClientToolRunner();
        b = new LinkedHashMap();
        c = new LinkedHashMap();
        d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(com.bytedance.ai.infra.thread_pool.b.c));
    }

    public static void d(String r10) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        BuildersKt.launch$default(d, null, null, new ClientToolRunner$onPackageInvalid$1(r10, null), 3, null);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ai.model.clienttool.b] */
    public static final ClientToolRuntime a(ClientToolRunner r10, Applet r11) {
        r10.getClass();
        int r12 = b.size();
        LinkedHashMap<String, ClientToolRuntime> r0 = c;
        if ((r12 + r0.size()) < 5) goto L8;
        ClientToolRuntime r13 = (ClientToolRuntime) CollectionsKt.firstOrNull(r0.values());
        if (r13 == null) goto L8;
        e(r13, "capacity eviction");
    L8:
        return new ClientToolRuntime(r11, new b());
    }

    public static void e(ClientToolRuntime r10, String r11) {
        if (c.remove(r10.c) == r10) goto L5;
        return;
    L5:
        com.bytedance.ai.utils.g.a.i("ClientToolRunner", "remove idle runtimeId=" + r10.c + " packageName=" + r10.d + " reason=" + r11);
        r10.b();
    }

    public static void f(String r12, LLMData r13, long r14, com.bytedance.applet.event.c r16, x r17) {
        Intrinsics.checkNotNullParameter(r12, "appletId");
        Intrinsics.checkNotNullParameter(r13, "llmData");
        Intrinsics.checkNotNullParameter(r16, "callback");
        Intrinsics.checkNotNullParameter(r17, "fallback");
        BuildersKt.launch$default(d, null, null, new ClientToolRunner$runIfNeeded$1(r12, r17, r13, r16, r14, null), 3, null);
    }

    public static final void b(ClientToolRunner r10, String r11, String r12, Function3 r13, String r14, String r15) {
        r10.getClass();
        com.bytedance.ai.utils.g.a.w("ClientToolRunner", r12);
        LruCache<Long, com.bytedance.ai.utils.j.a> r16 = com.bytedance.ai.utils.j.a;
        com.bytedance.ai.utils.j.a r17 = com.bytedance.ai.utils.j.b(StringsKt.toLongOrNull(r11));
        if (r17 == null) goto L5;
        r17.b(new Pair[]{TuplesKt.to("client_tool_failure_stage", r14), TuplesKt.to("client_tool_failure_reason", r15)});
    L5:
        r13.invoke(-1, "Client Tool execution failed", "");
        com.bytedance.ai.utils.j.a r18 = com.bytedance.ai.utils.j.b(StringsKt.toLongOrNull(r11));
        if (r18 == null) goto L9;
        r18.a(r12);
        return;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.bytedance.ai.model.clienttool.c, java.lang.Object] */
    public static final boolean c(ClientToolRunner r10, final ClientToolRuntime r11, Applet r12, LLMData r13, long r14, final Function3 r15) {
        r10.getClass();
        final String r0 = r13.getMsgId();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        ?? r16 = new c(r11, r0, r15);
        Intrinsics.checkNotNullParameter(r12, "applet");
        Intrinsics.checkNotNullParameter(r13, "llmData");
        Intrinsics.checkNotNullParameter(r16, "terminal");
        if (r12 != r11.a) goto L62;
        ClientToolRuntime.a r17 = new ClientToolRuntime.a(r13, r14, UUID.randomUUID().toString(), r16);
        Object r18 = r11.i;
        monitor-enter(r18);
        ClientToolRuntime.d r19 = r11.l;     // Catch: Throwable -> L55
        if (Intrinsics.areEqual(r19, ClientToolRuntime.d.C0042d.a) == false) goto L14;
        r11.a.e();     // Catch: Throwable -> L55
        r11.l = new ClientToolRuntime.d.e(r17, ClientToolRuntime.RunningPhase.PREPARING);     // Catch: Throwable -> L55
        boolean r110 = false;
    L20:
        monitor-exit(r18);
        r17.g = r110;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L37
        r11.j(r17);     // Catch: Throwable -> L37
        LruCache<Long, com.bytedance.ai.utils.j.a> r112 = com.bytedance.ai.utils.j.a;     // Catch: Throwable -> L37
        com.bytedance.ai.utils.j.a r113 = com.bytedance.ai.utils.j.b(StringsKt.toLongOrNull(r17.i));     // Catch: Throwable -> L37
        if (r113 == null) goto L29;
        Pair<String, ? extends Object>[] r114 = new Pair[2];     // Catch: Throwable -> L37
        r114[0] = TuplesKt.to("client_tool_execution_started", 1);     // Catch: Throwable -> L37
        if (r110 == false) goto L27;
        int r20 = 1;
    L28:
        r114[1] = TuplesKt.to("client_tool_reused", Integer.valueOf(r20));     // Catch: Throwable -> L37
        r113.b(r114);     // Catch: Throwable -> L37
        r113.m.a();     // Catch: Throwable -> L37
        goto L29
    L27:
        r20 = 0;
    L29:
        Long r115 = StringsKt.toLongOrNull(r17.i);     // Catch: Throwable -> L37
        String r116 = r17.c;     // Catch: Throwable -> L37
        if (r115 == null) goto L39;
        r115.longValue();     // Catch: Throwable -> L37
        if (r116 == null) goto L39;
        com.bytedance.ai.utils.j.a r117 = (com.bytedance.ai.utils.j.a) com.bytedance.ai.utils.j.a.get(r115);     // Catch: Throwable -> L37
        if (r117 == null) goto L39;
        com.bytedance.ai.utils.j.b.put(r116, r117);     // Catch: Throwable -> L37
        r117.e = r116;     // Catch: Throwable -> L37
    L39:
        com.bytedance.ai.utils.g.a.i("ClientToolRuntime", "execute runtimeId=" + r11.c + " appletId=" + r11.f + " messageId=" + r17.i + " reused=" + r110 + " timeoutMs=15000");     // Catch: Throwable -> L37
        if (r110 == false) goto L42;
        r11.h(r17);     // Catch: Throwable -> L37
    L43:
        Object r21 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L37
    L46:
        Throwable r22 = Result.exceptionOrNull-impl(r21);
        if (r22 == null) goto L52;
        com.bytedance.ai.utils.g.a.e("ClientToolRuntime", "failed to start Client Tool execution", r22);
        String r23 = r22.getMessage();
        if (r23 != null) goto L51;
        r23 = "failed to start Client Tool execution";
    L51:
        r11.c(r17, new ClientToolRuntime.c(-1, r23, "", MessageIndication.STATUS_PREPARE, "runtime_start_failed"), false);
    L52:
        return true;
    L42:
        r11.f(r17);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L46
    L14:
        if ((r19 instanceof ClientToolRuntime.d.c) == false) goto L53;
        Job r119 = ((ClientToolRuntime.d.c) r19).a;     // Catch: Throwable -> L55
        if (r119 == null) goto L18;
        Job.DefaultImpls.cancel$default(r119, null, 1, null);     // Catch: Throwable -> L55
    L18:
        ((ClientToolRuntime.d.c) r19).a = null;     // Catch: Throwable -> L55
        r11.a.e();     // Catch: Throwable -> L55
        r11.l = new ClientToolRuntime.d.e(r17, ClientToolRuntime.RunningPhase.EXECUTING);     // Catch: Throwable -> L55
        r110 = true;
        goto L20
    L53:
        monitor-exit(r18);
        return false;
    L55:
        th = move-exception;
        throw th;
    L62:
        return false;
    }
}
