package pea;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final Boolean d;
    public final Boolean e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.b.hashCode()) * 31;
        String r4 = this.c;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.d;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.e;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "BigIsLandTextInfo(frontTitle=" + this.a + ", title=" + this.b + ", content=" + this.c + ", narrowFont=" + this.d + ", showHighlightColor=" + this.e + ')';
    }

    public final JSONObject a() {
        JSONObject r0 = new JSONObject();
        String r1 = this.a;
        if (r1 == null) goto L5;
        r0.put("frontTitle", r1);
    L5:
        r0.put("title", this.b);
        String r2 = this.c;
        if (r2 == null) goto L8;
        r0.put("content", r2);
    L8:
        Boolean r3 = this.d;
        if (r3 == null) goto L11;
        r3.booleanValue();
        r0.put("narrowFont", this.d);
    L11:
        Boolean r4 = this.e;
        if (r4 == null) goto L14;
        r4.booleanValue();
        r0.put("showHighlightColor", this.e);
    L14:
        return r0;
    }

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "title");
        this.a = null;
        this.b = r2;
        this.c = null;
        this.d = null;
        this.e = null;
    }
}
