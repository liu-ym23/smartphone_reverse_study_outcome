package js;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f18463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f18464c;

    public f(String r5, long r10, List r11) {
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(r11, "layers");
        this.f18462a = r5;
        this.f18463b = r10;
        this.f18464c = r11;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof f) == true) goto L8;
        return false;
    L8:
        f r11 = (f) r10;
        String r5 = r11.f18462a;
        if (Intrinsics.areEqual(this.f18462a, r5) == true) goto L12;
        return false;
    L12:
        if (this.f18463b == r11.f18463b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f18464c, r11.f18464c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = androidx.room.jarjarred.org.antlr.runtime.a.e(androidx.room.jarjarred.org.antlr.runtime.a.e(this.f18462a.hashCode() * 31, 0, 31), this.f18463b, 31);
        return this.f18464c.hashCode() + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("EffectStage(id=");
        r5.append(this.f18462a);
        r5.append(", startMs=0, durationMs=");
        r5.append(this.f18463b);
        r5.append(", layers=");
        return androidx.constraintlayout.motion.widget.a.v(r5, this.f18464c, ')');
    }
}
