package yq9;

import com.larus.platform.constants.media.DataLoaderPreloadPriority;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public final String a;
    public final long b;
    public final String c;
    public final DataLoaderPreloadPriority d;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof d) == true) goto L8;
        return false;
    L8:
        d r9 = (d) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
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
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        return ((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "FlowPreloaderURLItem(key=" + this.a + ", preloadSize=" + this.b + ", url=" + this.c + ", priority=" + this.d + ')';
    }

    public d(String r3, long r4, String r6) {
        DataLoaderPreloadPriority r0 = DataLoaderPreloadPriority.DEFAULT;
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r6, "url");
        Intrinsics.checkNotNullParameter(r0, "priority");
        this.a = r3;
        this.b = r4;
        this.c = r6;
        this.d = r0;
    }
}
