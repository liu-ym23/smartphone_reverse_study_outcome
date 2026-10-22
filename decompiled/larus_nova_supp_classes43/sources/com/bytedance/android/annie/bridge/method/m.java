package com.bytedance.android.annie.bridge.method;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m implements Runnable {
    public final /* synthetic */ DownloadFileMethod a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Integer d;

    public m(DownloadFileMethod r1, String r10, int r11, Integer r12) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
    }

    public final void a() {
        DownloadFileMethod r0 = this.a;
        DownloadFileMethod.DownloadFileResModel r1 = new DownloadFileMethod.DownloadFileResModel();
        String r10 = this.b;
        int r11 = this.c;
        Integer r12 = this.d;
        r1.b(DownloadFileMethod.DownloadFileResModel.Code.Failed);
        if (r10 != null) goto L5;
        r10 = "body is null";
    L5:
        r1.f(r10);
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L8
        Object r14 = Result.constructor-impl(Integer.valueOf(r11));     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r14) == false) goto L13;
        r14 = 0;
    L13:
        r1.e((Integer) r14);
        Object r15 = Result.constructor-impl(r12);     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r15) == false) goto L21;
        r15 = 0;
    L21:
        r1.a((Integer) r15);
        r1.c("");
        r0.finishWithResult(r1);
        return;
    L16:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L8:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
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
