package com.larus.dora.impl.frameassembler;

import g49.d;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class a {
    public final i a;
    public final e b;
    public final g c;
    public final f d;
    public final ReentrantLock e;
    public final Map<Integer, byte[]> f;
    public final long g;
    public volatile long h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public long n;
    public volatile boolean o;
    public boolean p;

    /* JADX INFO: renamed from: com.larus.dora.impl.frameassembler.a$a, reason: collision with other inner class name */
    public static final class C0081a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DoraDuplicateFramePolicy.values().length];
            r0[DoraDuplicateFramePolicy.FAIL_SESSION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DoraDuplicateFramePolicy.OVERWRITE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DoraDuplicateFramePolicy.IGNORE_NEW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public abstract boolean a(byte[] r1, int r2);

    public abstract long e();

    public abstract void h(byte[] r1);

    public abstract void i(DoraIncompleteReason r1, byte[] r2, Throwable r3);

    public final h c() {
        return new h(this.a, this.g, this.h, this.k, this.p, e());
    }

    public final void d(byte[] r6) {
    L2:
        byte[] r0 = (byte[]) ((TreeMap) this.f).remove(Integer.valueOf(this.l));
        if (r0 == null) goto L4;
        this.n -= (long) r0.length;
        this.c.a(r0.length);
        if (a(r0, this.l + 0) == false) goto L7;
        this.m++;
        this.l++;
        goto L2
    L7:
        i(DoraIncompleteReason.RESOURCE_LIMIT, r6, new IllegalStateException("appendInOrder failed while flushing buffered frames"));
        return;
    }

    public final boolean b(int r9, byte[] r10) {
        int r0 = ((TreeMap) this.f).size();
        e r1 = this.b;
        if (r0 < r1.f) goto L5;
        return false;
    L5:
        long r4 = r10.length;
        if ((this.n + r4) <= r1.e) goto L9;
        return false;
    L9:
        if (this.c.c(r4) == true) goto L11;
        return false;
    L11:
        this.n += r4;
        byte[] r11 = (byte[]) ((TreeMap) this.f).put(Integer.valueOf(r9), r10);
        if (r11 != null) goto L14;
        return true;
    L14:
        if (this.b.i != DoraDuplicateFramePolicy.OVERWRITE) goto L16;
        this.n -= (long) r11.length;
        this.c.a(r11.length);
        return true;
    L16:
        ((TreeMap) this.f).put(Integer.valueOf(r9), r11);
        this.n -= r4;
        this.c.a(r4);
        return true;
    }

    public final void f(int r5, byte[] r6) {
        int r0 = b.a[this.b.i.ordinal()];
        if (r0 != 1) goto L5;
        i(DoraIncompleteReason.UNKNOWN, r6, new IllegalStateException("duplicate frame seq=" + r5));
        return;
    L5:
        if (r0 != 2) goto L7;
        return;
    L7:
        if (r0 != 3) goto L10;
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public a(i r2, e r3, g r4, f r5, long r6) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "resourceTracker");
        Intrinsics.checkNotNullParameter(r5, "metrics");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = new ReentrantLock();
        this.f = new TreeMap();
        this.g = r6;
        this.h = r6;
    }

    public final void g(int r16, int r17, int r18, int r110, byte[] r20, byte[] r21) {
        Intrinsics.checkNotNullParameter(r20, "data");
        this.e.lock();
    L45:
        th = move-exception;
        this.e.unlock();
        throw th;
    L4:
        if (this.o == true) goto L39;
        d.d("DoraAbstractFrameSession", "handleFrame, dataId=" + this.a.a + ", scene=" + r16 + ", type=" + r17 + ", seq=" + r18 + ", totalSeq=" + r110 + ", baseSeqInitialized=" + this.i + ", nextExpectedIndex=" + this.l);     // Catch: Throwable -> L45
        long r11 = System.currentTimeMillis();     // Catch: Throwable -> L45
        if (r18 != 0) goto L10;
        this.l = 0;     // Catch: Throwable -> L45
        this.m = 0;     // Catch: Throwable -> L45
        this.i = true;     // Catch: Throwable -> L45
    L10:
        if (this.j == true) goto L13;
        this.j = true;     // Catch: Throwable -> L45
        this.k = r110;     // Catch: Throwable -> L45
    L17:
        this.h = r11;     // Catch: Throwable -> L45
        int r2 = r18 + 0;     // Catch: Throwable -> L45
        if (r2 >= 0) goto L21;
        d.b("DoraAbstractFrameSession", "index < 0, handleDuplicateFrame");     // Catch: Throwable -> L45
        f(r18, r21);     // Catch: Throwable -> L45
        goto L39
    L21:
        if (r2 < this.k) goto L23;
        i(DoraIncompleteReason.TOTAL_SEQ_MISMATCH, r21, new IllegalStateException("seq out of range, index=" + r2 + ", totalSeq=" + this.k));     // Catch: Throwable -> L45
        goto L39
    L23:
        int r6 = this.l;     // Catch: Throwable -> L45
        if (r2 >= r6) goto L27;
        d.b("DoraAbstractFrameSession", "index < nextExpectedIndex, handleDuplicateFrame");     // Catch: Throwable -> L45
        f(r18, r21);     // Catch: Throwable -> L45
        goto L39
    L27:
        if (this.i == false) goto L34;
        if (r2 != r6) goto L34;
        if (a(r20, r18) == true) goto L32;
        i(DoraIncompleteReason.RESOURCE_LIMIT, r21, new IllegalStateException("appendInOrder failed due to resource limit"));     // Catch: Throwable -> L45
        goto L39
    L32:
        this.m++;     // Catch: Throwable -> L45
        this.l++;     // Catch: Throwable -> L45
        d(r21);     // Catch: Throwable -> L45
    L42:
        if (this.m != this.k) goto L39;
        this.o = true;     // Catch: Throwable -> L45
        h(r21);     // Catch: Throwable -> L45
    L34:
        if (this.b.l == false) goto L37;
        i(DoraIncompleteReason.SEQ_MISMATCH, r21, new IllegalStateException("seq mismatch, strict check enabled, index=" + r2 + ", nextExpectedIndex=" + this.l));     // Catch: Throwable -> L45
        goto L39
    L37:
        if (b(r2, r20) == true) goto L42;
        i(DoraIncompleteReason.RESOURCE_LIMIT, r21, new IllegalStateException("bufferOutOfOrderFrame failed due to resource limit"));     // Catch: Throwable -> L45
        goto L39
    L13:
        if (this.b.k == false) goto L17;
        if (r110 == this.k) goto L17;
        i(DoraIncompleteReason.TOTAL_SEQ_MISMATCH, r21, new IllegalStateException("totalSeq mismatch, expected=" + this.k + ", actual=" + r110));     // Catch: Throwable -> L45
    L39:
        this.e.unlock();
    }
}
