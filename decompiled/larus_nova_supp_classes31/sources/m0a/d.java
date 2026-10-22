package m0a;

import com.larus.ugc.feed.impl.spi.CommunityCreateNavigatorAndroidImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public final g0a.c a;
    public final g0a.e b;
    public final g0a.d c;
    public final m d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "CommunityCreateInitDependencyKmp(navigator=" + this.a + ", tracker=" + this.b + ", settings=" + this.c + ", tabListRepository=" + this.d + ')';
    }

    public d(CommunityCreateNavigatorAndroidImpl r2, g0a.e r3, com.larus.ugc.feed.impl.spi.a r4, y0a.e r5) {
        Intrinsics.checkNotNullParameter(r2, "navigator");
        Intrinsics.checkNotNullParameter(r3, "tracker");
        Intrinsics.checkNotNullParameter(r4, "settings");
        Intrinsics.checkNotNullParameter(r5, "tabListRepository");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
