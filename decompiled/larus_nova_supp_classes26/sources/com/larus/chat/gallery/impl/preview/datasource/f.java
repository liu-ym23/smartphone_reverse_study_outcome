package com.larus.chat.gallery.impl.preview.datasource;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public final kotlinx.coroutines.i<g> a;
    public final com.larus.chat.gallery.api.i b;
    public final int c;
    public boolean d;
    public final LiveData<Integer> e;
    public final LiveData<Integer> f;
    public final a g;
    public final b h;

    public final void a(g r3) {
        if (this.d == false) goto L5;
        return;
    L5:
        if (this.a.isActive() == false) goto L9;
        this.d = true;
        new Handler(Looper.getMainLooper()).post(new e(this));
        this.a.resumeWith(Result.constructor-impl(r3));
        return;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.larus.chat.gallery.impl.preview.datasource.a] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.chat.gallery.impl.preview.datasource.b] */
    public f(kotlinx.coroutines.j r2, com.larus.chat.gallery.api.i r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "cont");
        Intrinsics.checkNotNullParameter(r3, "dataBridge");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.e = r3.d();
        this.f = r3.c();
        this.g = new a(this);
        this.h = new b(this);
    }
}
