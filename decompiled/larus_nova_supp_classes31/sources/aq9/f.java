package aq9;

import com.larus.platform.api.FlowDriveFileType;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f {
    public final Set<FlowDriveFileType> a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public f() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Set<FlowDriveFileType> r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((((((r1 * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e;
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public final String toString() {
        return "SelectionPolicy(allowDriveFileTypeList=" + this.a + ", currentSize=" + this.b + ", maxAudioCount=" + this.c + ", maxImageCount=" + this.d + ", maxFileCount=" + this.e + ')';
    }

    public /* synthetic */ f(int r7) {
        this(null, 0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Set<? extends FlowDriveFileType> r1, int r2, int r3, int r4, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
