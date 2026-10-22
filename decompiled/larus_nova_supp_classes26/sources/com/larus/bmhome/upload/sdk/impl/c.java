package com.larus.bmhome.upload.sdk.impl;

import com.larus.bmhome.upload.sdk.impl.core.UploadOrchestrator;
import com.larus.bmhome.upload.sdk.impl.core.d;
import com.larus.bmhome.upload.sdk.impl.core.e;
import is8.g;
import is8.j;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c implements gs8.a {
    public final CoroutineScope a;
    public final e b;
    public final UploadOrchestrator c;

    /* JADX WARN: Type inference failed for: r3v5, types: [com.larus.bmhome.upload.sdk.impl.b] */
    @Override // gs8.a
    public final com.larus.bmhome.upload.sdk.impl.core.a a(g r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        e r0 = this.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r10, "request");
        String r1 = UUID.randomUUID().toString();
        final d r2 = new d(r1, r10, j1.a(j.b.a));
        r0.a.put(r1, r2);
        Job r11 = BuildersKt.launch$default(this.a, null, null, new ImageUploadSdkImpl$submit$job$1(this, r2, r10, null), 3, null);
        e r3 = this.b;
        String r4 = r2.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "taskId");
        Intrinsics.checkNotNullParameter(r11, "job");
        d r5 = r3.a.get(r4);
        if (r5 == null) goto L11;
        monitor-enter(r5);
        r5.d = r11;     // Catch: Throwable -> L12
        String r6 = r5.e;     // Catch: Throwable -> L12
        monitor-exit(r5);
        if (r6 == null) goto L11;
        r11.cancel(new CancellationException(r6));
    L12:
        th = move-exception;
        throw th;
    L11:
        return new com.larus.bmhome.upload.sdk.impl.core.a(r2.a, r2.c, new b(this, r2));
    }

    public c(CoroutineScope r2, e r3, UploadOrchestrator r4) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "registry");
        Intrinsics.checkNotNullParameter(r4, "orchestrator");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
