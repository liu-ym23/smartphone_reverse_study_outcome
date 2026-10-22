package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class l0 extends b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f19305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19306b;

    @Override // kotlinx.serialization.internal.b1
    public final Object a() {
        return Arrays.copyOf(this.f19305a, this.f19306b);
    }

    @Override // kotlinx.serialization.internal.b1
    public final void b(int r5) {
        long[] r10 = this.f19305a;
        if (r10.length >= r5) goto L6;
        this.f19305a = Arrays.copyOf(r10, RangesKt.coerceAtLeast(r5, r10.length * 2));
        return;
    }

    @Override // kotlinx.serialization.internal.b1
    public final int d() {
        return this.f19306b;
    }
}
