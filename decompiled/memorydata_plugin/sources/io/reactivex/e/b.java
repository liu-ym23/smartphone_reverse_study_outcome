package io.reactivex.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public final class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final T f16709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f16710b;
    final TimeUnit c;

    public b(T r1, long r2, TimeUnit r4) {
        this.f16709a = r1;
        this.f16710b = r2;
        this.c = (TimeUnit) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(r4, "unit is null"), TimeUnit.class, "com.obric.memorydata.plugin");
    }

    public T a() {
        return this.f16709a;
    }

    public long b() {
        return this.f16710b;
    }

    public boolean equals(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, b.class) == false) goto L12;
        b r7 = (b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.memorydata.plugin");
        if (io.reactivex.internal.functions.a.a(this.f16709a, r7.f16709a) == true) goto L7;
        return false;
    L7:
        if (this.f16710b == r7.f16710b) goto L9;
        return false;
    L9:
        if (io.reactivex.internal.functions.a.a(this.c, r7.c) == false) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    public int hashCode() {
        T r0 = this.f16709a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        long r2 = this.f16710b;
        return (((r1 * 31) + ((int) (r2 ^ (r2 >>> 31)))) * 31) + this.c.hashCode();
    L5:
        r1 = 0;
        goto L6
    }

    public String toString() {
        return "Timed[time=" + this.f16710b + ", unit=" + this.c + ", value=" + this.f16709a + "]";
    }
}
