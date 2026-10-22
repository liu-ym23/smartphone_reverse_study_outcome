package com.larus.canvas.service.internal.sse;

import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g implements e {
    public final /* synthetic */ e a;
    public final /* synthetic */ StreamPullHandler b;

    @Override // com.larus.canvas.service.internal.sse.e
    public final void a(f r12) {
        Intrinsics.checkNotNullParameter(r12, "data");
        this.a.a(r12);
        if (this.b.h != 0) goto L5;
        long r0 = -1;
    L6:
        long r5 = r0;
        int r1 = d.a;
        int r3 = r12.a;
        StreamPullHandler r2 = this.b;
        int r4 = r2.i;
        String r7 = r12.d;
        int r8 = r12.c;
        String r13 = r12.b;
        if (r13 != null) goto L9;
        r13 = "";
    L9:
        d.a r6 = new d.a(r3, r4, r5, r7, r8, r13, r2.a);
        Intrinsics.checkNotNullParameter(r6, "info");
        o.a.b("flow_canvas_chunk_request", com.larus.utils.f.c(new Pair[]{TuplesKt.to("status", Integer.valueOf(r6.a)), TuplesKt.to("count", Integer.valueOf(r6.b)), TuplesKt.to("duration", Long.valueOf(r6.c)), TuplesKt.to("error_description", r6.d), TuplesKt.to("error_code", Integer.valueOf(r6.e)), TuplesKt.to("binary_type", r6.f), TuplesKt.to("log_id", r6.g), TuplesKt.to("request_path", r6.h), TuplesKt.to("scene", "end")}));     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        FLogger.a.e("flow_canvas_chunk_request_end", "reportEvent error", e);
        return;
    L5:
        r0 = System.currentTimeMillis() - this.b.h;
        goto L6
    }

    @Override // com.larus.canvas.service.internal.sse.e
    public final void b(b r2) {
        Intrinsics.checkNotNullParameter(r2, "chunkPackage");
        this.a.b(r2);
        this.b.i++;
    }

    public g(CanvasChunkReceiver r1, StreamPullHandler r2) {
        this.a = r1;
        this.b = r2;
    }
}
