package com.bytedance.forest.utils;

import ai.j0;
import com.bytedance.forest.model.w;
import java.io.Closeable;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.forest.model.p f4625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f4627c;
    public final w d;
    public n e;

    public h(w r5, n r10) {
        this.d = r5;
        this.e = r10;
        com.bytedance.forest.model.p r11 = r5.i();
        this.f4625a = r11;
        int r12 = 1;
        if (r11 != null) goto L5;
    L7:
        String r13 = r5.f4443t;
        if (r13 == null) goto L10;
        r12 = r13.length();
    L10:
        this.f4626b = r12;
        HashMap r14 = j.f4643c;
        if (r5.f4441q.getGeckoModel().f4389a.length() != 0) goto L14;
    L15:
        f r15 = null;
    L24:
        this.f4627c = r15;
        return;
    L14:
        if (r5.f4441q.getGeckoModel().f4390b.length() == 0) goto L15;
        r15 = new f(this);
        HashMap r16 = j.f4643c;
        monitor-enter(r16);
        CopyOnWriteArrayList r17 = (CopyOnWriteArrayList) r16.get(r15.f4623b);     // Catch: Throwable -> L26
        if (r17 != null) goto L22;
        r17 = new CopyOnWriteArrayList();     // Catch: Throwable -> L26
        r16.put(r15.f4623b, r17);     // Catch: Throwable -> L26
    L22:
        monitor-exit(r16);
        r17.add(r15);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (r11.isCacheProvided$forest_release() != true) goto L7;
        r12 = RangesKt.coerceAtLeast(r11.size(), 1);
        goto L10
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        f r5 = this.f4627c;
        if (r5 == null) goto L6;
        r5.close();
        return;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(super.toString());
        r5.append("(response=");
        w r10 = this.d;
        r5.append(r10.n());
        r5.append(", cacheSize=");
        r5.append(this.f4626b);
        r5.append(", buffer=");
        r5.append(this.f4625a);
        r5.append(", file=");
        return j0.p(r5, r10.f4443t, ')');
    }
}
