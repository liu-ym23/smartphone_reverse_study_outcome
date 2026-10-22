package kotlinx.serialization.internal;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class o0 implements Map.Entry, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f19320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f19321b;

    public o0(Object r5, Object r10) {
        this.f19320a = r5;
        this.f19321b = r10;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o0) == true) goto L8;
        return false;
    L8:
        o0 r10 = (o0) r5;
        Object r11 = r10.f19320a;
        if (Intrinsics.areEqual(this.f19320a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f19321b, r10.f19321b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f19320a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f19321b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        int r5 = 0;
        Object r10 = this.f19320a;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        Object r13 = this.f19321b;
        if (r13 == null) goto L11;
        r5 = r13.hashCode();
    L11:
        return r12 + r5;
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object r5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final String toString() {
        return "MapEntry(key=" + this.f19320a + ", value=" + this.f19321b + ')';
    }
}
