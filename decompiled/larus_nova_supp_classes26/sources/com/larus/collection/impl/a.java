package com.larus.collection.impl;

import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import hq9.n3;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;
import q99.d;
import q99.e;
import q99.l;
import q99.n;
import yc9.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements o99.a {
    public final /* synthetic */ m a;
    public final /* synthetic */ i<Boolean> b;

    public final void d() {
    }

    public final void e(d r1) {
    }

    public final void h() {
    }

    public final void i() {
    }

    public final Bundle b(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "bundle");
        Intrinsics.checkNotNullParameter(r2, "bundle");
        return r2;
    }

    public final n3 f(n3 r2) {
        Intrinsics.checkNotNullParameter(r2, "originalRequest");
        Intrinsics.checkNotNullParameter(r2, "originalRequest");
        return r2;
    }

    public a(m r1, j r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(q99.m r3, l r4) {
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.i("CollectImpl", "onMessageFeedbackFailure, messageId=" + this.a.b + ", error=" + r4);
        if (this.b.isActive() == false) goto L6;
        i<Boolean> r5 = this.b;
        Result.Companion r6 = Result.Companion;
        r5.resumeWith(Result.constructor-impl(Boolean.FALSE));
        return;
    }

    public final void c(e r1, q99.a r2) {
        o99.a.a.a(r1, r2);
    }

    public final void g(q99.m r2, n r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "result");
        FLogger.a.i("CollectImpl", "onMessageFeedbackSuccess, messageId=" + this.a.b);
        if (this.b.isActive() == false) goto L6;
        i<Boolean> r4 = this.b;
        Result.Companion r5 = Result.Companion;
        r4.resumeWith(Result.constructor-impl(Boolean.TRUE));
        return;
    }

    public final void j(e r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "delivery");
        Intrinsics.checkNotNullParameter(r1, "delivery");
    }
}
