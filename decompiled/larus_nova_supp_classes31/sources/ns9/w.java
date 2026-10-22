package ns9;

import com.larus.reach.api.ReachPageScope;
import com.larus.reach.api.ReachPosition;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class w extends v {
    public final ReachPosition a;
    public final Map<String, String> b;
    public final String c;
    public final long d;
    public final Map<String, String> e;
    public final ReachPageScope f;

    /* JADX WARN: Multi-variable type inference failed */
    public w() {
        Object[] r0 = 0 == true ? 1 : 0;
        Object[] r1 = 0 == true ? 1 : 0;
        this(null, r0, r1, 31);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof w) == true) goto L8;
        return false;
    L8:
        w r9 = (w) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        long r4 = this.d;
        return ((r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31) + this.e.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "TargetPageReachTarget(position=" + this.a + ", reachPageInfo=" + this.b + ", reachPolicy=" + this.c + ", expireTimeMs=" + this.d + ", displayPolicy=" + this.e + ')';
    }

    @Override // ns9.v
    public final ReachPageScope a() {
        return this.f;
    }

    @Override // ns9.v
    public final ReachPosition b() {
        return this.a;
    }

    public /* synthetic */ w(ReachPosition r8, Map r9, Map r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        r8 = ReachPosition.BOTTOM;
    L5:
        ReachPosition r1 = r8;
        if ((r11 & 2) == 0) goto L8;
        r9 = MapsKt.emptyMap();
    L8:
        Map r2 = r9;
        if ((r11 & 16) == 0) goto L11;
        r10 = MapsKt.emptyMap();
    L11:
        this(r1, r2, null, 0, r10);
    }

    public w(ReachPosition r2, Map<String, String> r3, String r4, long r5, Map<String, String> r7) {
        Intrinsics.checkNotNullParameter(r2, "position");
        Intrinsics.checkNotNullParameter(r3, "reachPageInfo");
        Intrinsics.checkNotNullParameter(r7, "displayPolicy");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = ReachPageScope.TargetPage;
    }
}
