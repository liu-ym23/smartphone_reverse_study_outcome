package dl;

import kotlin.jvm.internal.Intrinsics;
import uq.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f16665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.obric.oui.animation.easy.a f16666b;

    public a(d r5, com.obric.oui.animation.easy.a r10) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        Intrinsics.checkNotNullParameter(r10, "config");
        this.f16665a = r5;
        this.f16666b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r5;
        d r11 = r10.f16665a;
        if (Intrinsics.areEqual(this.f16665a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f16666b, r10.f16666b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f16665a.hashCode() * 31;
        return this.f16666b.hashCode() + r5;
    }

    public final String toString() {
        return "SpringAnimationHolder(animation=" + this.f16665a + ", config=" + this.f16666b + ')';
    }
}
