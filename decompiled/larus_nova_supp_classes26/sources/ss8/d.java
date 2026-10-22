package ss8;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public final String a;
    public final int b;
    public final int c;
    public final String d;
    public final boolean e;
    public final Map<String, Object> f;

    public d() {
        this(false, null, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d.hashCode()) * 31;
        if (this.e == false) goto L5;
        int r1 = 1231;
    L7:
        return ((r0 + r1) * 31) + this.f.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "FilterContext(chatId=" + this.a + ", chatType=" + this.b + ", chatMode=" + this.c + ", segmentId=" + this.d + ", isLocalPcMode=" + this.e + ", extra=" + this.f + ')';
    }

    public d(boolean r5, Map r6, int r7) {
        String r1 = null;
        if ((r7 & 1) == 0) goto L5;
        String r0 = "";
    L7:
        if ((r7 & 8) == 0) goto L10;
        r1 = "";
    L10:
        if ((r7 & 16) == 0) goto L13;
        r5 = false;
    L13:
        if ((r7 & 32) == 0) goto L15;
        r6 = MapsKt.emptyMap();
    L15:
        Intrinsics.checkNotNullParameter(r0, "chatId");
        Intrinsics.checkNotNullParameter(r1, "segmentId");
        Intrinsics.checkNotNullParameter(r6, "extra");
        this.a = r0;
        this.b = 0;
        this.c = 0;
        this.d = r1;
        this.e = r5;
        this.f = r6;
        return;
    L5:
        r0 = null;
        goto L7
    }
}
