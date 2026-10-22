package com.ss.android.socialbase.downloader.segment;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile l f15619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f15620b;
    private final long c;
    private final AtomicLong d;
    private volatile long e;
    private long f;
    private int g;
    private JSONObject h;

    public i(long r3, long r5) {
        AtomicLong r0 = new AtomicLong();
        this.d = r0;
        this.f15620b = 0;
        this.c = r3;
        r0.set(r3);
        this.e = r3;
        if (r5 < r3) goto L5;
        this.f = r5;
        return;
    L5:
        this.f = -1;
    }

    public i(i r4) {
        AtomicLong r0 = new AtomicLong();
        this.d = r0;
        this.f15620b = 0;
        this.c = r4.c;
        this.f = r4.f;
        r0.set(r4.d.get());
        this.e = r0.get();
        this.g = r4.g;
    }

    public i(JSONObject r3) {
        this.d = new AtomicLong();
        this.f15620b = 0;
        this.c = r3.optLong("st");
        c(r3.optLong("en"));
        a(r3.optLong("cu"));
        d(d());
    }

    public static String a(List<i> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r5.isEmpty() == true) goto L16;
        Collections.sort(r5, new AnonymousClass1());
        StringBuilder r0 = new StringBuilder();
        Iterator r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L12;
        r0.append((i) ZeusTransformUtils.preCheckCast(r6.next(), i.class, "com.obric.memorydata.plugin")).append("\r\n");
        goto L9
    L12:
        return r0.toString();
    L16:
        return null;
    }

    public long a() {
        return this.d.get() - this.c;
    }

    void a(int r1) {
        this.g = r1;
    }

    public void a(long r5) {
        long r0 = this.c;
        if (r5 >= r0) goto L5;
        r5 = r0;
    L5:
        long r1 = this.f;
        if (r1 <= 0) goto L10;
        long r2 = r1 + 1;
        if (r5 <= r2) goto L10;
        r5 = r2;
    L10:
        this.d.set(r5);
    }

    public long b() {
        long r0 = this.f;
        if (r0 >= this.c) goto L5;
        return -1;
    L5:
        return (r0 - e()) + 1;
    }

    void b(int r1) {
        this.f15620b = r1;
    }

    void b(long r1) {
        this.d.addAndGet(r1);
    }

    public long c() {
        return this.c;
    }

    void c(long r4) {
        if (r4 < this.c) goto L6;
    L4:
        this.f = r4;
        return;
    L6:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L9;
        com.ss.android.socialbase.downloader.e.a.a("Segment", "setEndOffset", "EndOffset = " + r4 + ", segment = " + this);
    L9:
        if (r4 == (-1)) goto L4;
    }

    public long d() {
        long r0 = this.d.get();
        long r2 = this.f;
        if (r2 <= 0) goto L7;
        long r3 = r2 + 1;
        if (r0 <= r3) goto L7;
        return r3;
    L7:
        return r0;
    }

    public void d(long r3) {
        if (r3 < this.d.get()) goto L6;
        this.e = r3;
        return;
    }

    public long e() {
        l r0 = this.f15619a;
        if (r0 == null) goto L8;
        long r1 = r0.d();
        if (r1 <= this.e) goto L8;
        return r1;
    L8:
        return this.e;
    }

    public long f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }

    void h() {
        this.f15620b++;
    }

    void i() {
        this.f15620b--;
    }

    int j() {
        return this.f15620b;
    }

    public JSONObject k() {
        JSONObject r0 = this.h;
        if (r0 != null) goto L5;
        r0 = new JSONObject();
        this.h = r0;
    L5:
        r0.put("st", c());
        r0.put("cu", d());
        r0.put("en", f());
        return r0;
    }

    public String toString() {
        return "Segment{startOffset=" + this.c + ",\t currentOffset=" + this.d + ",\t currentOffsetRead=" + e() + ",\t endOffset=" + this.f + '}';
    }
}
