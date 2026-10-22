package a60;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public final com.bytedance.android.live.core.monitor.trace.e a;
    public final JSONObject b;
    public final JSONObject c;
    public final JSONObject d;
    public int e;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L16;
        d r4 = (d) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.live.core.monitor.trace.e r0 = this.a;
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
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        JSONObject r11 = this.d;
        if (r11 == null) goto L18;
        r1 = r11.hashCode();
    L18:
        return ((r9 + r1) * 31) + this.e;
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
        return "TraceEvent(traceMeta=" + this.a + ", category=" + this.b + ", metric=" + this.c + ", extra=" + this.d + ", size=" + this.e + ")";
    }

    public d(com.bytedance.android.live.core.monitor.trace.e r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r2, "traceMeta");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = 0;
    }
}
