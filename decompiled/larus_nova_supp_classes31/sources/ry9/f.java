package ry9;

import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.uaigc.bean.createpage.component.mediacontainer.UIStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f {
    public final String a;
    public final long b;
    public final ResourceItemBean c;
    public final UIStatus d;

    public f() {
        this(null, 0, null, null, 15);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof f) == true) goto L8;
        return false;
    L8:
        f r9 = (f) r8;
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
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        ResourceItemBean r3 = this.c;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return ((r2 + r4) * 31) + this.d.hashCode();
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public final String toString() {
        return "CreationUpdateUIStatus(resourceKey=" + this.a + ", progress=" + this.b + ", replaceBean=" + this.c + ", uiStatus=" + this.d + ')';
    }

    public f(String r2, long r3, ResourceItemBean r5, UIStatus r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = UIStatus.STATUS_INIT;
    L14:
        Intrinsics.checkNotNullParameter(r2, "resourceKey");
        Intrinsics.checkNotNullParameter(r6, "uiStatus");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
    }
}
