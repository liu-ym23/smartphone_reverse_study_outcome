package pea;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public static final /* synthetic */ int e = 0;
    public final int a;
    public final String b;
    public final int c;
    public final String d;

    public static final class a {
        public static c a(String r1, int r2, String r3) {
            Intrinsics.checkNotNullParameter(r1, "pic");
            return new c(r1, r2, r3);
        }
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a * 31) + this.b.hashCode()) * 31) + this.c) * 31;
        String r1 = this.d;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final JSONObject a() {
        JSONObject r0 = new JSONObject();
        r0.put("type", this.a);
        r0.put("pic", this.b);
        return r0;
    }

    public final String toString() {
        return "{\"type\":" + this.a + ",\"pic\":\"" + this.b + "\", \"picResId\":" + this.c + '}';
    }

    public final int getType() {
        return this.a;
    }

    public c(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "pic");
        this.a = 1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
