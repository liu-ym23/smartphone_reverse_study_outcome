package js;

import com.obric.oui.texteffects.core.BlendSpec;
import com.obric.oui.texteffects.core.TextSource;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextSource f18460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fj.a f18461c;
    public final BlendSpec d;
    public final List e;

    public d(String r5, TextSource r10, fj.a r11, BlendSpec r12, List r13) {
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, "fill");
        Intrinsics.checkNotNullParameter(r12, "blend");
        Intrinsics.checkNotNullParameter(r13, "properties");
        this.f18459a = r5;
        this.f18460b = r10;
        this.f18461c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // js.e
    public final String a() {
        return this.f18459a;
    }

    @Override // js.e
    public final List b() {
        return this.e;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r10 = (d) r5;
        String r11 = r10.f18459a;
        if (Intrinsics.areEqual(this.f18459a, r11) == true) goto L12;
        return false;
    L12:
        if (this.f18460b == r10.f18460b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f18461c, r10.f18461c) == true) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f18459a.hashCode() * 31;
        int r10 = (this.f18460b.hashCode() + r5) * 31;
        int r11 = (this.f18461c.hashCode() + r10) * 31;
        int r12 = (this.d.hashCode() + r11) * 31;
        return this.e.hashCode() + r12;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("Text(id=");
        r5.append(this.f18459a);
        r5.append(", source=");
        r5.append(this.f18460b);
        r5.append(", fill=");
        r5.append(this.f18461c);
        r5.append(", blend=");
        r5.append(this.d);
        r5.append(", properties=");
        return androidx.constraintlayout.motion.widget.a.v(r5, this.e, ')');
    }
}
