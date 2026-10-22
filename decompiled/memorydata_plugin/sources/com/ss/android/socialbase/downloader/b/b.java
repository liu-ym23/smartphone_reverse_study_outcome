package com.ss.android.socialbase.downloader.b;

import com.ss.android.socialbase.downloader.b.a.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<e> f15278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15279b;
    private i c;
    private volatile boolean d;

    public b(i r2) {
        this.f15278a = new CopyOnWriteArrayList();
        this.d = false;
        this.c = r2;
    }

    public b a(e r3) {
        e r4 = ((e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin")).a(this.c);
        if (r4 != null) goto L5;
        return this;
    L5:
        this.f15278a.add(r4);
        return this;
    }

    @Override // com.ss.android.socialbase.downloader.b.f
    public void a() {
        if (this.f15279b != this.f15278a.size()) goto L5;
        return;
    L5:
        e r0 = (e) ZeusTransformUtils.preCheckCast(this.f15278a.get(this.f15279b), e.class, "com.obric.memorydata.plugin");
        this.f15279b++;
        r0.a(this);
    }

    public void a(long r4, int r6) {
        Iterator<e> r3 = this.f15278a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((e) ZeusTransformUtils.preCheckCast(r3.next(), e.class, "com.obric.memorydata.plugin")).a(r4, r6);
        goto L4
    }

    @Override // com.ss.android.socialbase.downloader.b.f
    public void b() {
        this.d = true;
    }

    public void c() {
        Iterator<e> r3 = this.f15278a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((e) ZeusTransformUtils.preCheckCast(r3.next(), e.class, "com.obric.memorydata.plugin")).a();
        goto L4
    }

    public void d() {
        Iterator<e> r3 = this.f15278a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((e) ZeusTransformUtils.preCheckCast(r3.next(), e.class, "com.obric.memorydata.plugin")).b();
        goto L4
    }

    public void e() {
        this.f15279b = 0;
        this.c.i = false;
    }

    public boolean f() {
        return this.d;
    }
}
