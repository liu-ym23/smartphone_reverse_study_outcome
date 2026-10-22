package t98;

import com.larus.avlink.gallery.power.policy.AlbumPowerLevel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public final AlbumPowerLevel a;
    public final int b;
    public final List<String> c;
    public final long d;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31;
        long r1 = this.d;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "AlbumPowerDecision(level=" + this.a + ", videoThreadCount=" + this.b + ", reasons=" + this.c + ", decidedAtElapsedMs=" + this.d + ')';
    }

    public a(AlbumPowerLevel r2, int r3, List<String> r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, "level");
        Intrinsics.checkNotNullParameter(r4, "reasons");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
