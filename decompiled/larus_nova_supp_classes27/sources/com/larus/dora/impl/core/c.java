package com.larus.dora.impl.core;

import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Result;
import yj4.f;
import yj4.g;
import yj4.h;
import yj4.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c implements i {
    public final /* synthetic */ h a;
    public final /* synthetic */ kotlinx.coroutines.i<yj4.b> b;

    public final /* synthetic */ void a() {
    }

    public final /* synthetic */ void b(int r1) {
    }

    public final /* synthetic */ void c() {
    }

    public final /* synthetic */ void e() {
    }

    public final /* synthetic */ void f(int r1) {
    }

    public final /* synthetic */ void g(yj4.a r1) {
    }

    public final /* synthetic */ void h(int r1) {
    }

    public final /* synthetic */ void i(String r1, long r2, int r4) {
    }

    public final void d(yj4.b r4) {
        g49.d.d("DoraAdapterExt", "onAlbumThumbnailData: imageUuid=" + Long.valueOf(r4.a));
        this.a.getClass();
        int r0 = g.a;
        ((CopyOnWriteArraySet) h.D2).remove(this);
        this.b.resumeWith(Result.constructor-impl(r4));
    }

    public c(f r1, kotlinx.coroutines.j r2) {
        this.a = r1;
        this.b = r2;
    }
}
