package hq9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h5 {
    public final boolean a;
    public final List<String> b;
    public final List<String> c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h5) == true) goto L8;
        return false;
    L8:
        h5 r6 = (h5) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "XBridgeConfig(enableJSBPermission=" + this.a + ", authHostWhiteList=" + this.b + ", websiteHostWhiteList=" + this.c + ')';
    }

    public h5(boolean r2, List<String> r3, List<String> r4) {
        Intrinsics.checkNotNullParameter(r3, "authHostWhiteList");
        Intrinsics.checkNotNullParameter(r4, "websiteHostWhiteList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
