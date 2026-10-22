package com.obric.assistant.performance;

import com.larus.utils.logger.FLogger;
import ff7.e;
import java.io.File;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricMemoryUploadServiceImpl$b implements e {
    public final /* synthetic */ ObricMemoryUploadServiceImpl a;
    public final /* synthetic */ File b;

    public final void onSuccess() {
        ObricMemoryUploadServiceImpl r1 = this.a;
        File r2 = this.b;
        int r3 = ObricMemoryUploadServiceImpl.e;
        r1.getClass();
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L10
        if (r2.exists() == true) goto L6;
    L8:
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L15;
        FLogger.a.e("ObricMemoryUploadServiceImpl", "cleanupUploadFile error", r6);
    L15:
        this.a.c = -1;
        this.a.d = false;
        FLogger.a.i("ObricMemoryUploadServiceImpl", "uploadOnce success");
        return;
    L6:
        if (r2.delete() == true) goto L8;
        FLogger.a.w("ObricMemoryUploadServiceImpl", "cleanupUploadFile delete failed");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public final void onFail(String r4) {
        this.a.c = this.a.c + 1;
        this.a.d = false;
        FLogger.a.e("ObricMemoryUploadServiceImpl", "uploadOnce failed, msg=" + r4 + ", retryCount=" + this.a.c);
    }

    public ObricMemoryUploadServiceImpl$b(ObricMemoryUploadServiceImpl r1, File r2) {
        this.a = r1;
        this.b = r2;
    }
}
