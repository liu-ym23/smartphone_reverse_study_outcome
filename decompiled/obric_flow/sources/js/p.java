package js;

import com.obric.oui.texteffects.core.EffectProperty;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EffectProperty f18475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f18476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f4.b f18477c;
    public final jm.c d;

    public p(EffectProperty r5, List r10, f4.b r11, jm.c r12) {
        Intrinsics.checkNotNullParameter(r5, "property");
        Intrinsics.checkNotNullParameter(r10, "keyframes");
        Intrinsics.checkNotNullParameter(r11, "easing");
        Intrinsics.checkNotNullParameter(r12, "selector");
        this.f18475a = r5;
        this.f18476b = r10;
        this.f18477c = r11;
        this.d = r12;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p) == true) goto L8;
        return false;
    L8:
        p r10 = (p) r5;
        EffectProperty r11 = r10.f18475a;
        if (this.f18475a == r11) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f18476b, r10.f18476b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f18477c, r10.f18477c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f18475a.hashCode() * 31;
        int r10 = androidx.constraintlayout.motion.widget.a.f(this.f18476b, r5, 31);
        int r11 = (this.f18477c.hashCode() + r10) * 31;
        return this.d.hashCode() + r11;
    }

    public final String toString() {
        return "PropertyTrack(property=" + this.f18475a + ", keyframes=" + this.f18476b + ", easing=" + this.f18477c + ", selector=" + this.d + ')';
    }

    public /* synthetic */ p(EffectProperty r5, List r10, f4.b r11) {
        this(r5, r10, r11, q.d);
    }
}
