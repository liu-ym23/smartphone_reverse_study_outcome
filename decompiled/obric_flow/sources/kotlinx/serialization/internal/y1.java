package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.UShortArray;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class y1 extends b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short[] f19374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19375b;

    @Override // kotlinx.serialization.internal.b1
    public final Object a() {
        return UShortArray.m456boximpl(UShortArray.m458constructorimpl(Arrays.copyOf(this.f19374a, this.f19375b)));
    }

    @Override // kotlinx.serialization.internal.b1
    public final void b(int r5) {
        if (UShortArray.m464getSizeimpl(this.f19374a) >= r5) goto L6;
        short[] r10 = this.f19374a;
        this.f19374a = UShortArray.m458constructorimpl(Arrays.copyOf(r10, RangesKt.coerceAtLeast(r5, UShortArray.m464getSizeimpl(r10) * 2)));
        return;
    }

    @Override // kotlinx.serialization.internal.b1
    public final int d() {
        return this.f19375b;
    }
}
