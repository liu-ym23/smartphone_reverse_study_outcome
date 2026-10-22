package com.larksuite.framework.http.v2.internal.main;

import com.larus.utils.logger.FLogger;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.l;
import okio.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements Call {
    public final l a;

    public final boolean isExecuted() {
        return this.a.isExecuted();
    }

    public final void cancel() {
        this.a.a(-1);
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public final Call m322clone() {
        l r0 = this.a;
        return l.c(r0.a, r0.e, r0.f);
    }

    public final Response execute() {
        Request r3 = request();     // Catch: Throwable -> L8 IOException -> L12
        String r4 = r3.url().host();     // Catch: Throwable -> L8 IOException -> L12
        String r5 = r3.url().encodedPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r4, r5) == false) goto L11;
        FLogger.a.i("OkHttp3CallLancet", "execute drop " + r4 + r5);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(com.obric.assistant.network.okhttp.a.a(r4, r5), r4, r5);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r3.url());     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return this.a.execute();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.a.e("OkHttp3CallLancet", "execute intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    public final boolean isCanceled() {
        return this.a.b.d;
    }

    public final Request request() {
        return this.a.e;
    }

    public final j0 timeout() {
        return this.a.c;
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return m322clone();
    }

    public a(l r2) {
        Intrinsics.checkNotNullParameter(r2, "realCall");
        this.a = r2;
    }

    public final void enqueue(Callback r7) {
        Request r0 = request();
        String r1 = r0.url().host();
        String r2 = r0.url().encodedPath();
        if (com.obric.assistant.network.okhttp.a.c(r1, r2) == false) goto L7;
        FLogger.a.i("OkHttp3CallLancet", "enqueue drop " + r1 + r2);
        com.obric.assistant.network.okhttp.a.b(com.obric.assistant.network.okhttp.a.a(r1, r2), r1, r2);
        if (r7 == null) goto L9;
        r7.onFailure(this, new IOException("[NetGuard] dropped " + r0.url()));
        return;
    L9:
        return;
    L7:
        this.a.enqueue(r7);
    }
}
