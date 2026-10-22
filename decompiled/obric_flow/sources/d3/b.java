package d3;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f16588a;

    public b(byte[] r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        this.f16588a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        if (r5 == null) goto L7;
        Class<?> r10 = r5.getClass();
    L9:
        if (Intrinsics.areEqual(b.class, r10) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ai.resource.loader.ComparableByteArray");
        return Arrays.equals(this.f16588a, ((b) r5).f16588a);
    L7:
        r10 = null;
        goto L9
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f16588a);
    }

    public final String toString() {
        return "ComparableByteArray(value=" + Arrays.toString(this.f16588a) + ')';
    }
}
