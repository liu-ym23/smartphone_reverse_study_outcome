package com.obric.aikernel.runtime;

import java.util.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile long f5351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile int f5352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ArrayDeque<Long> f5353e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f5354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f5355b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f5356c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final c f5357d;

        public a(int r10, int r11, long r12, c r13) {
            Intrinsics.checkNotNullParameter(r13, "snapshot");
            this.f5354a = r10;
            this.f5355b = r11;
            this.f5356c = r12;
            this.f5357d = r13;
        }

        public /* synthetic */ a(int r10, int r11, long r12, c r13, int r14, DefaultConstructorMarker r15) {
            if ((r14 & 4) == 0) goto L5;
            r12 = 0;
        L5:
            this(r10, r11, r12, r13);
        }

        public final int a() {
            return this.f5355b;
        }

        public final long b() {
            return this.f5356c;
        }

        public final c c() {
            return this.f5357d;
        }

        public final int d() {
            return this.f5354a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (this.f5354a == r11.f5354a) goto L12;
            return false;
        L12:
            if (this.f5355b == r11.f5355b) goto L15;
            return false;
        L15:
            if (this.f5356c == r11.f5356c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f5357d, r11.f5357d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.f5354a) * 31) + Integer.hashCode(this.f5355b)) * 31) + Long.hashCode(this.f5356c)) * 31) + this.f5357d.hashCode();
        }

        public String toString() {
            return "AcquireQuotaResult(state=" + this.f5354a + ", attemptCount=" + this.f5355b + ", rejectTimeoutMs=" + this.f5356c + ", snapshot=" + this.f5357d + ')';
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f5358a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c f5359b;

        public b(int r10, c r11) {
            Intrinsics.checkNotNullParameter(r11, "snapshot");
            this.f5358a = r10;
            this.f5359b = r11;
        }

        public final int a() {
            return this.f5358a;
        }

        public final c b() {
            return this.f5359b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (this.f5358a == r11.f5358a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f5359b, r11.f5359b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f5358a) * 31) + this.f5359b.hashCode();
        }

        public String toString() {
            return "CleanupQuotaResult(removedCount=" + this.f5358a + ", snapshot=" + this.f5359b + ')';
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f5360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f5361b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Long f5362c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Long f5363d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f5364e;

        public c(int r10, long r11, Long r12, Long r13, int r14) {
            this.f5360a = r10;
            this.f5361b = r11;
            this.f5362c = r12;
            this.f5363d = r13;
            this.f5364e = r14;
        }

        public final int a() {
            return this.f5364e;
        }

        public final int b() {
            return this.f5360a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (this.f5360a == r11.f5360a) goto L12;
            return false;
        L12:
            if (this.f5361b == r11.f5361b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f5362c, r11.f5362c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f5363d, r11.f5363d) == true) goto L21;
            return false;
        L21:
            if (this.f5364e == r11.f5364e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r10 = ((Integer.hashCode(this.f5360a) * 31) + Long.hashCode(this.f5361b)) * 31;
            Long r11 = this.f5362c;
            int r12 = 0;
            if (r11 != null) goto L5;
            int r13 = 0;
        L6:
            int r14 = (r10 + r13) * 31;
            Long r15 = this.f5363d;
            if (r15 == null) goto L11;
            r12 = r15.hashCode();
        L11:
            return ((r14 + r12) * 31) + Integer.hashCode(this.f5364e);
        L5:
            r13 = r11.hashCode();
            goto L6
        }

        public String toString() {
            return "windowCount=" + this.f5360a + ", quotaWindowMs=" + this.f5361b + ", oldest=" + this.f5362c + ", newest=" + this.f5363d + ", continuousEmptyCount=" + this.f5364e;
        }
    }

    public d(String r10, String r11, long r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "bizName");
        Intrinsics.checkNotNullParameter(r11, "pkgName");
        this.f5349a = r10;
        this.f5350b = r11;
        this.f5351c = r12;
        this.f5352d = r13;
        this.f5353e = new ArrayDeque();
    }

    public /* synthetic */ d(String r10, String r11, long r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 8) == 0) goto L5;
        r13 = 0;
    L5:
        this(r10, r11, r12, r13);
    }

    private final long a(int r10, long r11) {
        if (r10 <= 1) goto L5;
        int r12 = r10 - 1;
        if (this.f5353e.size() >= r12) goto L9;
        return 0;
    L9:
        int r13 = this.f5353e.size() - r12;
        return RangesKt.coerceAtLeast((((Number) CollectionsKt.elementAt(this.f5353e, r13)).longValue() + this.f5351c) - r11, 0);
    L5:
        return this.f5351c;
    }

    private final int c(long r10) {
        int r11 = 0;
    L4:
        if ((!this.f5353e.isEmpty()) == false) goto L9;
        Long r12 = (Long) CollectionsKt.first(this.f5353e);
        Intrinsics.checkNotNullExpressionValue(r12, "firstTimestamp");
        if ((r10 - r12.longValue()) < this.f5351c) goto L9;
        this.f5353e.removeFirst();
        r11 = r11 + 1;
    L9:
        return r11;
    }

    private final c e() {
        return new c(this.f5353e.size(), this.f5351c, (Long) CollectionsKt.firstOrNull(this.f5353e), (Long) CollectionsKt.lastOrNull(this.f5353e), this.f5352d);
    }

    public final synchronized b b(long r10) {
        monitor-enter(this);
        int r11 = c(r10);     // Catch: Throwable -> L10
        if (this.f5353e.isEmpty() == false) goto L6;
        this.f5352d++;     // Catch: Throwable -> L10
    L7:
        b r12 = new b(r11, e());     // Catch: Throwable -> L10
        monitor-exit(this);
        return r12;
    L6:
        this.f5352d = 0;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized int d(int r10, long r11) {
        monitor-enter(this);
        c(r11);     // Catch: Throwable -> L14
        if (r10 > 0) goto L8;
        int r12 = this.f5353e.size();     // Catch: Throwable -> L14
        monitor-exit(this);
        return r12;
    L8:
        int r13 = 0;
    L9:
        if (r13 >= r10) goto L11;
        this.f5353e.addLast(Long.valueOf(r11));     // Catch: Throwable -> L14
        r13 = r13 + 1;     // Catch: Throwable -> L14
        goto L9
    L11:
        this.f5352d = 0;     // Catch: Throwable -> L14
        int r14 = this.f5353e.size();     // Catch: Throwable -> L14
        monitor-exit(this);
        return r14;
    L14:
        th = move-exception;
        throw th;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L8;
        return false;
    L8:
        d r11 = (d) r10;
        if (Intrinsics.areEqual(this.f5349a, r11.f5349a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f5350b, r11.f5350b) == true) goto L15;
        return false;
    L15:
        if (this.f5351c == r11.f5351c) goto L18;
        return false;
    L18:
        if (this.f5352d == r11.f5352d) goto L20;
        return false;
    L20:
        return true;
    }

    public final synchronized a f(int r10, int r11, long r12, long r13) {
        monitor-enter(this);
        g(r12);     // Catch: Throwable -> L14
        c(r13);     // Catch: Throwable -> L14
        int r14 = 1;
        int r15 = this.f5353e.size() + 1;     // Catch: Throwable -> L14
        if (r15 < r11) goto L8;
        a r16 = new a(4, r15, a(r11, r13), e());     // Catch: Throwable -> L14
        monitor-exit(this);
        return r16;
    L8:
        this.f5353e.addLast(Long.valueOf(r13));     // Catch: Throwable -> L14
        this.f5352d = 0;     // Catch: Throwable -> L14
        int r17 = this.f5353e.size();     // Catch: Throwable -> L14
        if (r17 < r10) goto L11;
        r14 = 2;
    L11:
        a r18 = new a(r14, r17, 0, e(), 4, null);     // Catch: Throwable -> L14
        monitor-exit(this);
        return r18;
    L14:
        th = move-exception;
        throw th;
    }

    public final synchronized void g(long r10) {
        monitor-enter(this);
        this.f5351c = r10;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public int hashCode() {
        return (((((this.f5349a.hashCode() * 31) + this.f5350b.hashCode()) * 31) + Long.hashCode(this.f5351c)) * 31) + Integer.hashCode(this.f5352d);
    }

    public synchronized String toString() {
        monitor-enter(this);
        String r10 = "pkgName:" + this.f5350b + ", biz:" + this.f5349a + ", " + e();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }
}
