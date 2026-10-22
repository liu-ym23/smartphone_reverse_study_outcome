package cbb;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public final c a;
    public String b;

    public d() {
        this(0);
    }

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
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "RemoteConfig(global=" + this.a + ", cacheConfig=" + this.b + ')';
    }

    public d(int r3) {
        c r4 = new c(0);
        Intrinsics.checkNotNullParameter(r4, "global");
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "cacheConfig");
        this.a = r4;
        this.b = BuildConfig.FLAVOR;
    }
}
