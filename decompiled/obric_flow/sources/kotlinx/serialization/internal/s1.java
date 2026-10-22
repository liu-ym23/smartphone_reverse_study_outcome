package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.UIntArray;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class s1 extends b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f19343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19344b;

    @Override // kotlinx.serialization.internal.b1
    public final Object a() {
        return UIntArray.m272boximpl(UIntArray.m274constructorimpl(Arrays.copyOf(this.f19343a, this.f19344b)));
    }

    @Override // kotlinx.serialization.internal.b1
    public final void b(int r5) {
        if (UIntArray.m280getSizeimpl(this.f19343a) >= r5) goto L6;
        int[] r10 = this.f19343a;
        this.f19343a = UIntArray.m274constructorimpl(Arrays.copyOf(r10, RangesKt.coerceAtLeast(r5, UIntArray.m280getSizeimpl(r10) * 2)));
        return;
    }

    @Override // kotlinx.serialization.internal.b1
    public final int d() {
        return this.f19344b;
    }
}
