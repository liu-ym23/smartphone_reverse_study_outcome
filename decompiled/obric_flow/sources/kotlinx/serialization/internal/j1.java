package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class j1 extends b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short[] f19300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19301b;

    @Override // kotlinx.serialization.internal.b1
    public final Object a() {
        return Arrays.copyOf(this.f19300a, this.f19301b);
    }

    @Override // kotlinx.serialization.internal.b1
    public final void b(int r5) {
        short[] r10 = this.f19300a;
        if (r10.length >= r5) goto L6;
        this.f19300a = Arrays.copyOf(r10, RangesKt.coerceAtLeast(r5, r10.length * 2));
        return;
    }

    @Override // kotlinx.serialization.internal.b1
    public final int d() {
        return this.f19301b;
    }
}
