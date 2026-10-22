package d00;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public final JSONObject a;
    public final JSONObject b;
    public final JSONObject c;

    public c() {
        this(null, null, 7);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L12;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
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
        JSONObject r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        JSONObject r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        JSONObject r7 = this.c;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "CommonData(category=" + this.a + ", metric=" + this.b + ", extra=" + this.c + ")";
    }

    public c(JSONObject r2, JSONObject r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = new JSONObject();
    L6:
        if ((r4 & 2) == 0) goto L8;
        JSONObject r0 = new JSONObject();
    L10:
        if ((r4 & 4) == 0) goto L12;
        r3 = new JSONObject();
    L12:
        Intrinsics.checkNotNullParameter(r2, "category");
        Intrinsics.checkNotNullParameter(r0, "metric");
        Intrinsics.checkNotNullParameter(r3, "extra");
        this.a = r2;
        this.b = r0;
        this.c = r3;
        return;
    L8:
        r0 = null;
        goto L10
    }
}
