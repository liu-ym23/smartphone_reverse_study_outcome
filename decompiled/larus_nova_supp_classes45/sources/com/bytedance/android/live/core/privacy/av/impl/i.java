package com.bytedance.android.live.core.privacy.av.impl;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements com.bytedance.android.live.core.privacy.av.api.h {
    public i() {
    }

    public static String d(Map r4) {
        Intrinsics.checkNotNullParameter(r4, "map");
        Iterator r5 = r4.entrySet().iterator();
        if (r5.hasNext() == true) goto L6;
        return "{}";
    L6:
        StringBuilder r0 = new StringBuilder("{");
    L7:
        Map.Entry r1 = (Map.Entry) r5.next();
        String r2 = (String) r1.getKey();
        String r3 = ((String) r1.getValue()).toString();
        r0.append('\"');
        r0.append(r2);
        r0.append("\":");
        r0.append(r3);
        if (r5.hasNext() == false) goto L9;
        r0.append(", ");
        goto L7
    L9:
        r0.append('}');
        return r0.toString();
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.h
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        ALogger.i("AudioAndVideoPrivacy", r2);
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.h
    public final void c(com.bytedance.android.live.core.privacy.av.api.i r5) {
        Intrinsics.checkNotNullParameter(r5, "remoteData");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        int r2 = com.bytedance.android.live.core.monitor.trace.e.m;     // Catch: Throwable -> L5
        com.bytedance.android.live.core.monitor.trace.e.a r3 = com.bytedance.android.live.core.monitor.trace.e.b.a(r5.a, "privacy_av");     // Catch: Throwable -> L5
        r3.c = "webcast_client_privacy";     // Catch: Throwable -> L5
        r3.d = r5.b;     // Catch: Throwable -> L5
        r3.b("biz", r5.e);     // Catch: Throwable -> L5
        r3.b("sense", r5.f);     // Catch: Throwable -> L5
        r3.b("type", r5.getType());     // Catch: Throwable -> L5
        r3.b("params", d(r5.h));     // Catch: Throwable -> L5
        r3.h = Integer.valueOf(r5.c);     // Catch: Throwable -> L5
        r3.i = r5.d;     // Catch: Throwable -> L5
        com.bytedance.android.live.core.monitor.trace.e r6 = r3.a();     // Catch: Throwable -> L5
        a60.e r4 = com.bytedance.android.live.core.monitor.trace.c.a;     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter(r6, "traceMeta");     // Catch: Throwable -> L5
        TraceMonitor.i(r6, null, null, null);     // Catch: Throwable -> L5
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L13;
        b("upload trace failed:" + r8.getMessage(), null);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.h
    public final void b(String r2, Exception r3) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        if (r3 == null) goto L5;
        ALogger.e("AudioAndVideoPrivacy", r2, r3);
        return;
    L5:
        ALogger.e("AudioAndVideoPrivacy", r2);
    }
}
