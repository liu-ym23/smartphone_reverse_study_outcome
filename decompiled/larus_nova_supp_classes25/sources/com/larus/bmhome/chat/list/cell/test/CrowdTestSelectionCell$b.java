package com.larus.bmhome.chat.list.cell.test;

import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import hq9.n3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class CrowdTestSelectionCell$b implements o99.a {
    public final /* synthetic */ String a;

    public final void d() {
    }

    public final void e(q99.d r1) {
    }

    public final void h() {
    }

    public final void i() {
    }

    public CrowdTestSelectionCell$b(String r1) {
        this.a = r1;
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

    public final void a(q99.m r3, q99.l r4) {
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.d("CrowdTestSelectionCell", this.a + " #onFailure error :" + r4 + ' ');
    }

    public final void c(q99.e r1, q99.a r2) {
        o99.a.a.a(r1, r2);
    }

    public final void g(q99.m r2, q99.n r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "result");
        FLogger.a.d("CrowdTestSelectionCell", this.a + " #onSuccess message");
    }

    public final void j(q99.e r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "delivery");
        Intrinsics.checkNotNullParameter(r1, "delivery");
    }
}
