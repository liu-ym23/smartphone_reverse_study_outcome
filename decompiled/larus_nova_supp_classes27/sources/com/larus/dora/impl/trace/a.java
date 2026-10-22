package com.larus.dora.impl.trace;

import com.google.gson.Gson;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.larus.utils.t0;
import g49.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new p69.a());
    }

    public static void a(final DarEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "doraEvent");
        final b r0 = (b) a.getValue();
        if (r0 == null) goto L31;
        monitor-enter(r0);
        Intrinsics.checkNotNullParameter(r10, "doraEvent");     // Catch: Throwable -> L28
        d.d("【DarLite】", r10.getEvent());     // Catch: Throwable -> L28
        final String r1 = r0.c;     // Catch: Exception -> L13 Throwable -> L28
        if (r1 == null) goto L26;
        p69.b r9 = new p69.b(Long.valueOf(System.currentTimeMillis()), Integer.valueOf(r10.ordinal()), Integer.valueOf(r10.getType()), r10.getEvent(), r10.getMessage(), r10.getExtra());     // Catch: Exception -> L13 Throwable -> L28
        JSONArray r2 = r0.b.get(r1);     // Catch: Exception -> L13 Throwable -> L28
        if (r2 == null) goto L16;
        if (r2.length() >= 100) goto L16;
        r2.put(((Gson) r0.a.getValue()).toJson(r9));     // Catch: Exception -> L13 Throwable -> L28
    L16:
        if (r10 != DarEvent.OtaUpdatePreCheck) goto L18;
    L23:
        t0.c(new p69.d(r0, r10, r1));     // Catch: Exception -> L13 Throwable -> L28
    L18:
        if (r10 == DarEvent.OtaUpdateCheck) goto L23;
        if (r10 == DarEvent.OtaUpdateEnd) goto L23;
        if (r10 == DarEvent.DoraLinkStateChanged) goto L23;
    L26:
        monitor-exit(r0);
        return;
    L13:
        e = move-exception;
        d.b("【DarLite】", e.getMessage());     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }

    public static void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(FlowDoraWifiScene.OTA, "scene");
        b r1 = (b) a.getValue();
        if (r1 == null) goto L11;
        monitor-enter(r1);
        Intrinsics.checkNotNullParameter(r3, "taskId");     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(FlowDoraWifiScene.OTA, "scene");     // Catch: Throwable -> L8
        r1.c = r3;     // Catch: Throwable -> L8
        r1.d = FlowDoraWifiScene.OTA;     // Catch: Throwable -> L8
        monitor-exit(r1);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
