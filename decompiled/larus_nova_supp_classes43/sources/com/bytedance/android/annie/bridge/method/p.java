package com.bytedance.android.annie.bridge.method;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p implements Runnable {
    public final /* synthetic */ DownloadFileMethod a;
    public final /* synthetic */ Exception b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Integer d;

    public p(DownloadFileMethod r1, Exception r10, int r11, Integer r12) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
    }

    public final void a() {
        DownloadFileMethod r0 = this.a;
        DownloadFileMethod.DownloadFileResModel r1 = new DownloadFileMethod.DownloadFileResModel();
        Exception r10 = this.b;
        int r11 = this.c;
        Integer r12 = this.d;
        r1.b(DownloadFileMethod.DownloadFileResModel.Code.Failed);
        r1.f(r10.getMessage());
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L5
        Object r14 = Result.constructor-impl(Integer.valueOf(r11));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r14) == false) goto L10;
        r14 = 0;
    L10:
        r1.e((Integer) r14);
        if (r12 != null) goto L26;
        Integer r15 = null;
    L16:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L13
    L20:
        if (Result.isFailure-impl(r16) == false) goto L22;
        r16 = 0;
    L22:
        r1.a((Integer) r16);
        r0.finishWithResult(r1);
        return;
    L13:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L26:
        r15 = Integer.valueOf(r12.intValue());     // Catch: Throwable -> L13
    L5:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
