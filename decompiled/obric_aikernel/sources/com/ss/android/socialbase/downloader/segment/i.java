package com.ss.android.socialbase.downloader.segment;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f8243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicLong f8244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile long f8245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f8246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8247e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile l f8248f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f8249g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private JSONObject f8250h;

    static class a implements Comparator<i> {
        a() {
        }

        public int a(i r10, i r11) {
            return (int) (r10.i() - r11.i());
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(i r10, i r11) {
            return a(r10, r11);
        }
    }

    public i(long r10, long r11) {
        AtomicLong r12 = new AtomicLong();
        this.f8244b = r12;
        this.f8249g = 0;
        this.f8243a = r10;
        r12.set(r10);
        this.f8245c = r10;
        if (r11 < r10) goto L5;
        this.f8246d = r11;
        return;
    L5:
        this.f8246d = -1;
    }

    public i(i r10) {
        AtomicLong r11 = new AtomicLong();
        this.f8244b = r11;
        this.f8249g = 0;
        this.f8243a = r10.f8243a;
        this.f8246d = r10.f8246d;
        r11.set(r10.f8244b.get());
        this.f8245c = r11.get();
        this.f8247e = r10.f8247e;
    }

    public i(JSONObject r10) {
        this.f8244b = new AtomicLong();
        this.f8249g = 0;
        this.f8243a = r10.optLong("st");
        o(r10.optLong("en"));
        m(r10.optLong("cu"));
        n(c());
    }

    public static String r(List<i> r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.isEmpty() == true) goto L15;
        Collections.sort(r10, new a());
        StringBuilder r11 = new StringBuilder();
        Iterator<i> r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L11;
        r11.append(r12.next());
        r11.append("\r\n");
        goto L8
    L11:
        return r11.toString();
    L15:
        return null;
    }

    void a() {
        this.f8249g--;
    }

    int b() {
        return this.f8249g;
    }

    public long c() {
        long r10 = this.f8244b.get();
        long r11 = this.f8246d;
        if (r11 <= 0) goto L7;
        long r12 = r11 + 1;
        if (r10 <= r12) goto L7;
        return r12;
    L7:
        return r10;
    }

    public long d() {
        l r10 = this.f8248f;
        if (r10 == null) goto L8;
        long r11 = r10.h();
        if (r11 <= this.f8245c) goto L8;
        return r11;
    L8:
        return this.f8245c;
    }

    public long e() {
        return this.f8244b.get() - this.f8243a;
    }

    public long f() {
        return this.f8246d;
    }

    public int g() {
        return this.f8247e;
    }

    public long h() {
        long r10 = this.f8246d;
        if (r10 >= this.f8243a) goto L5;
        return -1;
    L5:
        return (r10 - d()) + 1;
    }

    public long i() {
        return this.f8243a;
    }

    void j() {
        this.f8249g++;
    }

    void k(long r10) {
        this.f8244b.addAndGet(r10);
    }

    void l(int r10) {
        this.f8249g = r10;
    }

    public void m(long r10) {
        long r11 = this.f8243a;
        if (r10 >= r11) goto L5;
        r10 = r11;
    L5:
        long r12 = this.f8246d;
        if (r12 <= 0) goto L10;
        long r13 = r12 + 1;
        if (r10 <= r13) goto L10;
        r10 = r13;
    L10:
        this.f8244b.set(r10);
    }

    public void n(long r10) {
        if (r10 < this.f8244b.get()) goto L6;
        this.f8245c = r10;
        return;
    }

    void o(long r10) {
        if (r10 < this.f8243a) goto L6;
    L4:
        this.f8246d = r10;
        return;
    L6:
        if (lb.a.a() == false) goto L9;
        lb.a.b("Segment", "setEndOffset", "EndOffset = " + r10 + ", segment = " + this);
    L9:
        if (r10 == (-1)) goto L4;
    }

    void p(int r10) {
        this.f8247e = r10;
    }

    public JSONObject q() {
        JSONObject r10 = this.f8250h;
        if (r10 != null) goto L5;
        r10 = new JSONObject();
        this.f8250h = r10;
    L5:
        r10.put("st", i());
        r10.put("cu", c());
        r10.put("en", f());
        return r10;
    }

    public String toString() {
        return "Segment{startOffset=" + this.f8243a + ",\t currentOffset=" + this.f8244b + ",\t currentOffsetRead=" + d() + ",\t endOffset=" + this.f8246d + '}';
    }
}
