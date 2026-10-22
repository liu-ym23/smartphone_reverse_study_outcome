package pea;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final d g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.f;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return ((r10 + r2) * 31) + this.g.hashCode();
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ExpandedIconTextInfo(title=" + this.a + ", content=" + this.b + ", colorTitle=" + this.c + ", colorTitleDark=" + this.d + ", colorContent=" + this.e + ", colorContentDark=" + this.f + ", animIconInfo=" + this.g + ')';
    }

    public final JSONObject a() {
        JSONObject r0 = new JSONObject();
        r0.put("title", this.a);
        r0.put("content", this.b);
        String r1 = this.c;
        if (r1 == null) goto L5;
        r0.put("colorTitle", r1);
    L5:
        String r2 = this.d;
        if (r2 == null) goto L8;
        r0.put("colorTitleDark", r2);
    L8:
        String r3 = this.e;
        if (r3 == null) goto L11;
        r0.put("colorContent", r3);
    L11:
        String r4 = this.f;
        if (r4 == null) goto L14;
        r0.put("colorContentDark", r4);
    L14:
        d r5 = this.g;
        r5.getClass();
        JSONObject r6 = new JSONObject();
        r6.put("type", r5.a);
        r6.put("src", r5.b);
        String r7 = r5.d;
        if (r7 == null) goto L17;
        r6.put("srcDark", r7);
    L17:
        r0.put("animIconInfo", r6);
        return r0;
    }

    public f(String r2, String r3, d r4) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "content");
        Intrinsics.checkNotNullParameter(r4, "animIconInfo");
        this.a = r2;
        this.b = r3;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = r4;
    }
}
