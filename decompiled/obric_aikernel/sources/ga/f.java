package ga;

import com.obric.oui.window.bean.WindowSizeClass;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WindowSizeClass f9018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f9019b;

    public f(WindowSizeClass r10, a r11) {
        Intrinsics.checkNotNullParameter(r10, "windowSizeClass");
        Intrinsics.checkNotNullParameter(r11, "pageSize");
        this.f9018a = r10;
        this.f9019b = r11;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof f) == false) goto L10;
        f r11 = (f) r10;
        if (Intrinsics.areEqual(this.f9018a, r11.f9018a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f9019b, r11.f9019b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        WindowSizeClass r10 = this.f9018a;
        int r11 = 0;
        if (r10 == null) goto L5;
        int r12 = r10.hashCode();
    L6:
        int r13 = r12 * 31;
        a r14 = this.f9019b;
        if (r14 == null) goto L10;
        r11 = r14.hashCode();
    L10:
        return r13 + r11;
    L5:
        r12 = 0;
        goto L6
    }

    public String toString() {
        return "WindowSizeWithPageSize(windowSizeClass=" + this.f9018a + ", pageSize=" + this.f9019b + ")";
    }
}
