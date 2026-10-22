package com.larus.dora.impl.feedback;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c implements Function1<Throwable, Unit> {
    public final /* synthetic */ Job a;
    public final /* synthetic */ p0 b;

    public c(Job r1, p0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        Throwable r5 = (Throwable) r4;
        Job.DefaultImpls.cancel$default(this.a, null, 1, null);     // Catch: Exception -> L5
        this.b.cancel("", true);     // Catch: Exception -> L5
        pk4.j.d("UploadCancellation", "Upload cancelled successfully");     // Catch: Exception -> L5
    L8:
        return Unit.INSTANCE;
    L5:
        e = move-exception;
        pk4.j.c("UploadCancellation", "Error during cancellation", e);
        goto L8
    }
}
