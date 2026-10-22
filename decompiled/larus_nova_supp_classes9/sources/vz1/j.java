package vz1;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model.TabChangeSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j {
    public final int a;
    public final int b;
    public final TabChangeSource c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof j) == false) goto L12;
        j r4 = (j) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        TabChangeSource r1 = this.c;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final String toString() {
        return "TabDataModel(tabIndex=" + this.a + ", tabType=" + this.b + ", changeSource=" + this.c + ")";
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public j(int r2, int r3, TabChangeSource r4) {
        Intrinsics.checkNotNullParameter(r4, "changeSource");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
