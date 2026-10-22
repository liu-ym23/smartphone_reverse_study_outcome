package jd2;

import com.bytedance.android.livesdk.ktvapi.model.PanelType;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public final String a;
    public final String b;
    public final Integer c;
    public final String d;

    public f() {
        this(null, 15);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L14;
        f r4 = (f) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenPanelEvent(panelType=" + this.a + ", enterFrom=" + this.b + ", topTab=" + this.c + ", labelName=" + this.d + ")";
    }

    public f(String r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r3 = PanelType.UNKNOWN.getValue();
    L6:
        if ((r4 & 2) == 0) goto L8;
        String r5 = BuildConfig.FLAVOR;
    L9:
        Intrinsics.checkNotNullParameter(r3, "panelType");
        Intrinsics.checkNotNullParameter(r5, "enterFrom");
        this.a = r3;
        this.b = r5;
        this.c = null;
        this.d = null;
        return;
    L8:
        r5 = null;
        goto L9
    }
}
