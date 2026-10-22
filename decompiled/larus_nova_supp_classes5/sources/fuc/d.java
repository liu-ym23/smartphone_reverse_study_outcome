package fuc;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.Instant;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
import iuc.b;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Serializable(with = b.class)
public final class d implements Comparable<d> {
    public static final a Companion = null;
    public static final d b = null;
    public static final d c = null;
    public final Instant a;

    public static final class a {
        public a() {
        }

        public final juc.d<d> serializer() {
            return b.a;
        }

        public static d a(long r1, long r3) {
            return new d(Instant.ofEpochSecond(r1, r3));
        L4:
            e = move-exception;
            if ((e instanceof ArithmeticException) == true) goto L12;
            if ((e instanceof DateTimeException) == true) goto L12;
            throw e;
        L12:
            if (r1 <= 0) goto L14;
            d r2 = d.c;
        L16:
            return r2;
        L14:
            r2 = d.b;
            goto L16
        }
    }

    static {
        Companion = new a();
        new d(Instant.ofEpochSecond(-3217862419201L, 999999999));
        new d(Instant.ofEpochSecond(3093527980800L, 0));
        b = new d(Instant.MIN);
        c = new d(Instant.MAX);
    }

    public final long a() {
        return this.a.toEpochMilli();
    L5:
        if (this.a.isAfter(Instant.EPOCH) == false) goto L7;
        return LongCompanionObject.MAX_VALUE;
    L7:
        return Long.MIN_VALUE;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a.toString();
    }

    public d(Instant r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.a = r2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(d r2) {
        d r3 = r2;
        Intrinsics.checkNotNullParameter(r3, IInteractionStateService.WAKE_UP_SOURCE_OTHER);
        return this.a.compareTo(r3.a);
    }

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
    L9:
        return true;
    L4:
        if ((r2 instanceof d) == true) goto L6;
    L8:
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((d) r2).a) == false) goto L8;
        goto L8
    }
}
