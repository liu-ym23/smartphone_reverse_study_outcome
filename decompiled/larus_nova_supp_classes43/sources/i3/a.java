package i3;

import com.google.gson.JsonObject;
import e3.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final String a;
    public final JsonObject b;
    public final d c;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        JsonObject r1 = this.b;
        if (r1 != null) goto L5;
        int r10 = 0;
    L7:
        return ((r0 + r10) * 31) + this.c.hashCode();
    L5:
        r10 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "BridgeCallInfo(methodName=" + this.a + ", params=" + this.b + ", bridgeContext=" + this.c + ')';
    }

    public a(String r10, JsonObject r11, e3.a r12) {
        Intrinsics.checkNotNullParameter(r10, "methodName");
        Intrinsics.checkNotNullParameter(r12, "bridgeContext");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }
}
