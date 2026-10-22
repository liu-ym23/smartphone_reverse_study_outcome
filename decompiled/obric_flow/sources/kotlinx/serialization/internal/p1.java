package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.UByteArray;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class p1 extends b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f19330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19331b;

    @Override // kotlinx.serialization.internal.b1
    public final Object a() {
        return UByteArray.m193boximpl(UByteArray.m195constructorimpl(Arrays.copyOf(this.f19330a, this.f19331b)));
    }

    @Override // kotlinx.serialization.internal.b1
    public final void b(int r5) {
        if (UByteArray.m201getSizeimpl(this.f19330a) >= r5) goto L6;
        byte[] r10 = this.f19330a;
        this.f19330a = UByteArray.m195constructorimpl(Arrays.copyOf(r10, RangesKt.coerceAtLeast(r5, UByteArray.m201getSizeimpl(r10) * 2)));
        return;
    }

    @Override // kotlinx.serialization.internal.b1
    public final int d() {
        return this.f19331b;
    }
}
