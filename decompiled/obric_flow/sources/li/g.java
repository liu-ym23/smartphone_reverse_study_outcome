package li;

import java.util.Arrays;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f19658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f19659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f19660c;
    public String[] d;
    public Map e;

    public g() {
        String[] r5 = new String[0];
        String[] r10 = new String[0];
        Map r11 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r5, "webPublicMethod");
        Intrinsics.checkNotNullParameter(r10, "lynxPublicMethod");
        Intrinsics.checkNotNullParameter(r11, "commonSecureMethod");
        this.f19658a = false;
        this.f19659b = r5;
        this.f19660c = true;
        this.d = r10;
        this.e = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r10 = (g) r5;
        if (this.f19658a == r10.f19658a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f19659b, r10.f19659b) == true) goto L15;
        return false;
    L15:
        if (this.f19660c == r10.f19660c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r5 = (kn.e.a(((Boolean.hashCode(this.f19658a) * 31) + Arrays.hashCode(this.f19659b)) * 31, 31, this.f19660c) + Arrays.hashCode(this.d)) * 31;
        return this.e.hashCode() + r5;
    }

    public final String toString() {
        return "JSBAuthMethodAuthTypeSetting(enableWebForcePrivate=" + this.f19658a + ", webPublicMethod=" + Arrays.toString(this.f19659b) + ", enableLynxForcePrivate=" + this.f19660c + ", lynxPublicMethod=" + Arrays.toString(this.d) + ", commonSecureMethod=" + this.e + ')';
    }
}
