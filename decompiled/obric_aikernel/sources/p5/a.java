package p5;

import i9.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f12326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.oui.animation.easy.a f12327b;

    public a(d r10, com.obric.oui.animation.easy.a r11) {
        Intrinsics.checkNotNullParameter(r10, "animation");
        Intrinsics.checkNotNullParameter(r11, "config");
        this.f12326a = r10;
        this.f12327b = r11;
    }

    public final void a() {
        this.f12327b.a(this.f12326a);
        this.f12326a.q();
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof a) == false) goto L10;
        a r11 = (a) r10;
        if (Intrinsics.areEqual(this.f12326a, r11.f12326a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f12327b, r11.f12327b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        d r10 = this.f12326a;
        int r11 = 0;
        if (r10 == null) goto L5;
        int r12 = r10.hashCode();
    L6:
        int r13 = r12 * 31;
        com.obric.oui.animation.easy.a r14 = this.f12327b;
        if (r14 == null) goto L10;
        r11 = r14.hashCode();
    L10:
        return r13 + r11;
    L5:
        r12 = 0;
        goto L6
    }

    public String toString() {
        return "SpringAnimationHolder(animation=" + this.f12326a + ", config=" + this.f12327b + ")";
    }
}
