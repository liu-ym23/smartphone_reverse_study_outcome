package js;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f18480c;
    public final i.a d;
    public final List e;

    public s(String r5, long r10, n r11, List r12, int r13) {
        if ((r13 & 8) == 0) goto L5;
        r11 = n.e;
    L5:
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(r11, "loop");
        Intrinsics.checkNotNullParameter(r12, "stages");
        this.f18478a = r5;
        this.f18479b = 1;
        this.f18480c = r10;
        this.d = r11;
        this.e = r12;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof s) == true) goto L8;
        return false;
    L8:
        s r11 = (s) r10;
        String r5 = r11.f18478a;
        if (Intrinsics.areEqual(this.f18478a, r5) == true) goto L12;
        return false;
    L12:
        if (this.f18479b == r11.f18479b) goto L15;
        return false;
    L15:
        if (this.f18480c == r11.f18480c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f18478a.hashCode() * 31;
        int r10 = androidx.room.jarjarred.org.antlr.runtime.a.e(androidx.room.jarjarred.org.antlr.runtime.a.c(this.f18479b, r5, 31), this.f18480c, 31);
        int r11 = (this.d.hashCode() + r10) * 31;
        return this.e.hashCode() + r11;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("TextEffectSpec(id=");
        r5.append(this.f18478a);
        r5.append(", version=");
        r5.append(this.f18479b);
        r5.append(", durationMs=");
        r5.append(this.f18480c);
        r5.append(", loop=");
        r5.append(this.d);
        r5.append(", stages=");
        return androidx.constraintlayout.motion.widget.a.v(r5, this.e, ')');
    }
}
