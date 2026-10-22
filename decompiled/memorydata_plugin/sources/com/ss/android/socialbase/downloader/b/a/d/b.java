package com.ss.android.socialbase.downloader.b.a.d;

import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
public class b implements com.ss.android.socialbase.downloader.network.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f15253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15254b;
    private long c;
    private long d;
    private AtomicLong e;
    private List<a> f;
    private long g;
    private int h;
    private int i;

    public interface a {
        void c();
    }

    public b(int r4, long r5, int r7) {
        this.f15253a = false;
        this.e = new AtomicLong(0);
        this.f = new CopyOnWriteArrayList();
        this.i = r4;
        this.g = r5;
        this.h = r7;
        if (r5 <= 0) goto L7;
        if (r7 <= 0) goto L8;
        com.ss.android.socialbase.downloader.network.b.a().a(this);
        return;
    L8:
        return;
    }

    private void a(long r6, long r8) {
        if (r8 != 0) goto L5;
        return;
    L5:
        long r0 = r6 / r8;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L9;
        com.ss.android.socialbase.downloader.e.a.a("PCDNBandwidthSampler", this.i, "addSampleImpl", "Speed:" + r0 + " byteDiff:" + r6 + " timeDiff:" + r8);
    L9:
        if (r0 >= this.g) goto L16;
        int r7 = this.f15254b + 1;
        this.f15254b = r7;
        if (r7 <= this.h) goto L19;
        Iterator<a> r9 = this.f.iterator();
    L14:
        if (r9.hasNext() == false) goto L16;
        ((a) ZeusTransformUtils.preCheckCast(r9.next(), a.class, "com.obric.memorydata.plugin")).c();
        goto L14
    L19:
        return;
    L16:
        this.f15254b = 0;
    }

    public void a() {
        this.f15253a = true;
    }

    public void a(long r1) {
        this.e.addAndGet(r1);
    }

    public void a(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        this.f.add(r4);
    }

    public void b() {
        this.f15253a = false;
        com.ss.android.socialbase.downloader.network.b.a().b(this);
    }

    @Override // com.ss.android.socialbase.downloader.network.b.a
    public void c() {
        if (this.f15253a == true) goto L5;
        return;
    L5:
        long r0 = SystemClock.uptimeMillis();
        long r2 = this.e.get();
        long r4 = this.c;
        if (r4 > 0) goto L9;
    L7:
        this.c = r0;
        this.d = r2;
        return;
    L9:
        a(r2 - this.d, r0 - r4);
        goto L7
    }
}
