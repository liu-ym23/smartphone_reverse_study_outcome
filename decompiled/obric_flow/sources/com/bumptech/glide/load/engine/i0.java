package com.bumptech.glide.load.engine;

import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.DataSource;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class i0 implements f, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f1514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f1515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1516c;
    public c d;
    public Object e;
    public volatile d0.q f;
    public d g;

    public i0(g r5, k r10) {
        this.f1514a = r5;
        this.f1515b = r10;
    }

    @Override // com.bumptech.glide.load.engine.e
    public final void a(z.c r5, Exception r10, com.bumptech.glide.load.data.e r11, DataSource r12) {
        this.f1515b.a(r5, r10, r11, this.f.f16567c.d());
    }

    @Override // com.bumptech.glide.load.engine.f
    public final boolean b() {
        Object r5 = this.e;
        if (r5 == null) goto L14;
        this.e = null;
        int r10 = q0.f.f21454b;
        long r11 = SystemClock.elapsedRealtimeNanos();
        z.a r12 = this.f1514a.d(r5);     // Catch: Throwable -> L9
        com.google.common.reflect.w r13 = new com.google.common.reflect.w(r12, 2, r5, this.f1514a.f1496i);     // Catch: Throwable -> L9
        z.c r14 = this.f.f16565a;     // Catch: Throwable -> L9
        g r15 = this.f1514a;     // Catch: Throwable -> L9
        this.g = new d(r14, r15.f1501n);     // Catch: Throwable -> L9
        r15.f1495h.a().c(this.g, r13);     // Catch: Throwable -> L9
        if (Log.isLoggable("SourceGenerator", 2) == false) goto L11;
        Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.g + ", data: " + r5 + ", encoder: " + r12 + ", duration: " + q0.f.a(r11));     // Catch: Throwable -> L9
    L11:
        this.f.f16567c.b();
        this.d = new c(Collections.singletonList(this.f.f16565a), this.f1514a, this);
    L9:
        th = move-exception;
        this.f.f16567c.b();
        throw th;
    L14:
        c r16 = this.d;
        if (r16 != null) goto L17;
    L19:
        this.d = null;
        this.f = null;
        boolean r17 = false;
    L20:
        if (r17 == true) goto L30;
        if (this.f1516c >= this.f1514a.b().size()) goto L30;
        ArrayList r18 = this.f1514a.b();
        int r19 = this.f1516c;
        this.f1516c = r19 + 1;
        this.f = (d0.q) r18.get(r19);
        if (this.f == null) goto L20;
        if (this.f1514a.f1503p.a(this.f.f16567c.d()) == true) goto L29;
        if (this.f1514a.c(this.f.f16567c.c()) == null) goto L20;
    L29:
        this.f.f16567c.e(this.f1514a.f1502o, new i(this, this.f));
        r17 = true;
    L30:
        return r17;
    L17:
        if (r16.b() == false) goto L19;
        return true;
    }

    @Override // com.bumptech.glide.load.engine.e
    public final void c(z.c r10, Object r11, com.bumptech.glide.load.data.e r12, DataSource r13, z.c r14) {
        this.f1515b.c(r10, r11, r12, this.f.f16567c.d(), r10);
    }

    @Override // com.bumptech.glide.load.engine.f
    public final void cancel() {
        d0.q r5 = this.f;
        if (r5 == null) goto L6;
        r5.f16567c.cancel();
        return;
    }
}
