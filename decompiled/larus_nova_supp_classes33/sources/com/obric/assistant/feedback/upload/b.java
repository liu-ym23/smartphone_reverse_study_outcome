package com.obric.assistant.feedback.upload;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.feedback.upload.bean.ReportUploadTask;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b implements com.obric.assistant.feedback.upload.a {
    public final LinkedBlockingDeque<ReportUploadTask> b;

    public static final class a {
    }

    static {
    }

    public b() {
        this.b = new LinkedBlockingDeque();
    }

    public final boolean a(ReportUploadTask r4) {
        Intrinsics.checkNotNullParameter(r4, "task");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        this.b.addLast(r4);     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L5
    L7:
        Throwable r1 = Result.exceptionOrNull-impl(r5);
        if (r1 == null) goto L12;
        FLogger.a.e("InMemoryReportUploadTaskManager", "offerTask failed", r1);
        r5 = Boolean.FALSE;
    L12:
        return ((Boolean) r5).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
