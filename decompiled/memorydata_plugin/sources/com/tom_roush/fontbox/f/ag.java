package com.tom_roush.fontbox.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class ag implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ad f15976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f15977b;
    private final long[] c;

    public interface a {
        void a(ah r1);
    }

    ag(ad r6) {
        this.f15976a = r6;
        if (r6.m().equals("ttcf") == false) goto L19;
        float r0 = r6.h();
        int r1 = (int) r6.k();
        this.f15977b = r1;
        if (r1 <= 0) goto L17;
        if (r1 > 1024) goto L17;
        this.c = new long[r1];
        int r2 = 0;
    L10:
        if (r2 >= this.f15977b) goto L13;
        this.c[r2] = r6.k();
        r2 = r2 + 1;
        goto L10
    L13:
        if (r0 < 2.0f) goto L21;
        r6.d();
        r6.d();
        r6.d();
        return;
    L21:
        return;
    L17:
        throw new IOException("Invalid number of fonts " + r1);
    L19:
        throw new IOException("Missing TTC header");
    }

    public ag(File r3) {
        this(new aa(r3, "r"));
    }

    private ah a(int r5) {
        this.f15976a.a(this.c[r5]);
        if (this.f15976a.m().equals("OTTO") == false) goto L5;
        ae r0 = new v(false, true);
    L6:
        this.f15976a.a(this.c[r5]);
        return r0.d(new ac(this.f15976a));
    L5:
        r0 = new ae(false, true);
        goto L6
    }

    public ah a(String r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.f15977b) goto L9;
        ah r1 = a(r0);
        if (r1.b().equals(r4) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r1;
    L9:
        return null;
    }

    public void a(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        int r0 = 0;
    L4:
        if (r0 >= this.f15977b) goto L6;
        r4.a(a(r0));
        r0 = r0 + 1;
        goto L4
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f15976a.close();
    }
}
