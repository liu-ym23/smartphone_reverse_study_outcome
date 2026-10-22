package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.ULongArray;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class v1 extends b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f19358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19359b;

    @Override // kotlinx.serialization.internal.b1
    public final Object a() {
        return ULongArray.m351boximpl(ULongArray.m353constructorimpl(Arrays.copyOf(this.f19358a, this.f19359b)));
    }

    @Override // kotlinx.serialization.internal.b1
    public final void b(int r5) {
        if (ULongArray.m359getSizeimpl(this.f19358a) >= r5) goto L6;
        long[] r10 = this.f19358a;
        this.f19358a = ULongArray.m353constructorimpl(Arrays.copyOf(r10, RangesKt.coerceAtLeast(r5, ULongArray.m359getSizeimpl(r10) * 2)));
        return;
    }

    @Override // kotlinx.serialization.internal.b1
    public final int d() {
        return this.f19359b;
    }
}
