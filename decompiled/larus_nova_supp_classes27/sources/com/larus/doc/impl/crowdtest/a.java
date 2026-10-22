package com.larus.doc.impl.crowdtest;

import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import hq9.n3;
import kotlin.jvm.internal.Intrinsics;
import q99.d;
import q99.e;
import q99.l;
import q99.m;
import q99.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a implements o99.a {
    public a() {
    }

    @Override // o99.b
    public final void d() {
    }

    @Override // o99.c
    public final void e(d r1) {
    }

    @Override // o99.b
    public final void h() {
    }

    @Override // o99.b
    public final void i() {
    }

    @Override // o99.b
    public final Bundle b(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "bundle");
        Intrinsics.checkNotNullParameter(r2, "bundle");
        return r2;
    }

    @Override // o99.b
    public final n3 f(n3 r2) {
        Intrinsics.checkNotNullParameter(r2, "originalRequest");
        Intrinsics.checkNotNullParameter(r2, "originalRequest");
        return r2;
    }

    @Override // o99.a
    public final void a(m r3, l r4) {
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.i("DocCrowdTestHelper", "messageFeedback#onFailure error :" + r4 + ' ');
    }

    @Override // o99.b
    public final void c(e r1, q99.a r2) {
        o99.a.C0133a.a(r1, r2);
    }

    @Override // o99.a
    public final void g(m r2, n r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "result");
        FLogger.a.i("DocCrowdTestHelper", "messageFeedback#onSuccess");
    }

    @Override // o99.b
    public final void j(e r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "delivery");
        Intrinsics.checkNotNullParameter(r1, "delivery");
    }
}
