package com.bumptech.glide.load.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r0.d f1443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f1444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1445c;

    public b0(Class r5, Class r10, Class r11, List r12, r0.d r13) {
        this.f1443a = r13;
        if (r12.isEmpty() == true) goto L7;
        this.f1444b = r12;
        this.f1445c = "Failed LoadPath{" + r5.getSimpleName() + "->" + r10.getSimpleName() + "->" + r11.getSimpleName() + "}";
        return;
    L7:
        throw new IllegalArgumentException("Must not be empty.");
    }

    public final d0 a(int r15, int r16, com.bumptech.glide.load.data.g r17, i r18, z.f r19) {
        r0.d r5 = this.f1443a;
        List r10 = (List) r5.acquire();
        List r11 = this.f1444b;     // Catch: Throwable -> L20
        int r12 = r11.size();     // Catch: Throwable -> L20
        int r13 = 0;
        d0 r14 = null;
    L4:
        if (r13 >= r12) goto L15;
        r14 = ((l) r11.get(r13)).a(r15, r16, r17, r18, r19);     // Catch: GlideException -> L9 Throwable -> L20
    L12:
        if (r14 != null) goto L15;
        r13 = r13 + 1;
        goto L4
    L9:
        e = move-exception;
        r10.add(e);     // Catch: Throwable -> L20
    L15:
        if (r14 == null) goto L19;
        r5.release(r10);
        return r14;
    L19:
        throw new GlideException(this.f1445c, new ArrayList(r10));     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        r5.release(r10);
        throw th;
    }

    public final String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f1444b.toArray()) + '}';
    }
}
