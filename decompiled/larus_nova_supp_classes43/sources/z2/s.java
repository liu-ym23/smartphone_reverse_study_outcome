package z2;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class s {
    public final List<String> a;
    public final boolean b;
    public final boolean c;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof s) == true) goto L8;
        return false;
    L8:
        s r11 = (s) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r10 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r11 = (r0 + r1) * 31;
        if (this.c == true) goto L11;
        r10 = 1237;
    L11:
        return r11 + r10;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "WebViewFileChooserRequest(acceptTypes=" + this.a + ", captureEnabled=" + this.b + ", allowMultiple=" + this.c + ')';
    }

    public s(List<String> r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "acceptTypes");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }
}
