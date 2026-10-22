package b4;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f855a;

    public a(byte[] r5) {
        Intrinsics.checkNotNullParameter(r5, "templateJS");
        this.f855a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        if (r5 == null) goto L7;
        Class<?> r10 = r5.getClass();
    L9:
        if (Intrinsics.areEqual(a.class, r10) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.android.anniex.model.AnnieXLynxModel.ComparableByteArray");
        return Arrays.equals(this.f855a, ((a) r5).f855a);
    L7:
        r10 = null;
        goto L9
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f855a);
    }

    public final String toString() {
        return "ComparableByteArray(templateJS=" + Arrays.toString(this.f855a) + ')';
    }
}
