package l3;

import com.google.gson.JsonObject;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements Comparable<a> {
    public final String a;
    public final JsonObject b;
    public final long c;
    public String d;
    public String e;

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
        if (this.c == r11.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        JsonObject r1 = this.b;
        if (r1 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = (r0 + r10) * 31;
        long r12 = this.c;
        return r11 + ((int) (r12 ^ (r12 >>> 32)));
    L5:
        r10 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "AIBridgeEvent(eventName=" + this.a + ", params=" + this.b + ", timestamp=" + this.c + ')';
    }

    @Override // java.lang.Comparable
    public final int compareTo(a r10) {
        a r11 = r10;
        Intrinsics.checkNotNullParameter(r11, "other");
        long r0 = this.c;
        if (r0 != r11.c) goto L7;
        return -1;
    L7:
        return ComparisonsKt.compareValues(Long.valueOf(r0), Long.valueOf(r11.c));
    }

    public /* synthetic */ a(String r10, JsonObject r11, int r12) {
        if ((r12 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r12 & 4) == 0) goto L8;
        long r0 = System.currentTimeMillis();
    L9:
        this(r10, r11, r0);
        return;
    L8:
        r0 = 0;
        goto L9
    }

    public a(String r10, JsonObject r11, long r12) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }
}
