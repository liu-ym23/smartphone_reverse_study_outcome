package tkb;

import androidx.compose.ui.geometry.Size;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public final long a;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Size.equals-impl0(this.a, ((b) r8).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Size.hashCode-impl(this.a);
    }

    public final String toString() {
        return "ImageOptions(size=" + Size.toString-impl(this.a) + ')';
    }

    public /* synthetic */ b() {
        this(Size.Companion.getUnspecified-NH-jbRc());
    }

    public b(long r1) {
        this.a = r1;
    }
}
