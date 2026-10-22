package hq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x4 {
    public final String a;

    public x4() {
        this(null);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof x4) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((x4) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "UserAvatarImgConfig(authBgImgUrl=" + this.a + ')';
    }

    public x4(String r1) {
        this.a = r1;
    }
}
