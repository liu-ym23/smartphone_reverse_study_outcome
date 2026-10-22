package com.larus.avlink.activeSummary;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k<T> {
    public final List<c<T>> a;
    public int b;

    public static final class a {
    }

    public static final class b<T> {
        public final List<c<T>> a;
        public final List<c<T>> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "EnqueueResult(expired=" + this.a + ", overwritten=" + this.b + ')';
        }

        public b(List<c<T>> r2, List<c<T>> r3) {
            Intrinsics.checkNotNullParameter(r2, "expired");
            Intrinsics.checkNotNullParameter(r3, "overwritten");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c<T> {
        public final String a;
        public final T b;
        public final long c;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof c) == true) goto L8;
            return false;
        L8:
            c r9 = (c) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            T r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (r0 + r2) * 31;
            long r4 = this.c;
            return r3 + ((int) (r4 ^ (r4 >>> 32)));
        L5:
            r2 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Entry(source=" + this.a + ", value=" + this.b + ", expiredTimestampMs=" + this.c + ')';
        }

        public c(String r2, T r3, long r4) {
            Intrinsics.checkNotNullParameter(r2, "source");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
    }

    public k() {
        this.a = new ArrayList();
        this.b = RangesKt.coerceAtLeast(5, 1);
    }

    public final List<c<T>> b(long r7) {
        ArrayList r0 = new ArrayList();
        Iterator r1 = ((ArrayList) this.a).iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        c r2 = (c) r1.next();
        if (r2.c > r7) goto L4;
        r0.add(r2);
        r1.remove();
        goto L4
    L8:
        return r0;
    }

    public final b<T> a(String r8, T r9, long r10, Integer r12, Integer r13) {
        Intrinsics.checkNotNullParameter(r8, "source");
        if (r13 != null) goto L5;
    L7:
        List<c<T>> r14 = b(r10);
        if (r12 == null) goto L10;
        ArrayList r0 = new ArrayList();
    L13:
        if (((ArrayList) this.a).size() < this.b) goto L15;
        r0.add(ListProtector.remove(this.a, 0));
        goto L13
    L15:
        List<c<T>> r1 = this.a;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new c(r8, r9, r10 + (((long) r12.intValue()) * 1000)));
        return new b(r14, r0);
    L10:
        return new b(r14, CollectionsKt.emptyList());
    L5:
        if (r13.intValue() <= 0) goto L7;
        this.b = r13.intValue();
        goto L7
    }
}
