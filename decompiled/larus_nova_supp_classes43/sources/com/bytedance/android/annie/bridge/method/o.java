package com.bytedance.android.annie.bridge.method;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o implements Runnable {
    public final /* synthetic */ DownloadFileMethod a;
    public final /* synthetic */ LinkedHashMap<String, String> b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Integer e;

    public o(DownloadFileMethod r1, LinkedHashMap<String, String> r10, String r11, int r12, Integer r13) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
    }

    public final void a() {
        DownloadFileMethod r0 = this.a;
        DownloadFileMethod.DownloadFileResModel r1 = new DownloadFileMethod.DownloadFileResModel();
        LinkedHashMap<String, String> r10 = this.b;
        String r11 = this.c;
        int r12 = this.d;
        Integer r13 = this.e;
        r1.b(DownloadFileMethod.DownloadFileResModel.Code.Success);
        r1.f("Success");
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L5
        Object r15 = Result.constructor-impl(Integer.valueOf(r12));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r15) == false) goto L10;
        r15 = 0;
    L10:
        r1.e((Integer) r15);
        Object r16 = Result.constructor-impl(r13);     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r16) == false) goto L18;
        r16 = 0;
    L18:
        r1.a((Integer) r16);
        r1.d(r10);
        r1.c(r11);
        r0.finishWithResult(r1);
        return;
    L13:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
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
