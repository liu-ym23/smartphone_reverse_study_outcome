package fs9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "DoImageEditTrackParams(previousPage=" + this.a + ", currentPage=" + this.b + ", clickFrom=" + this.c + ", enterMethod=" + this.d + ')';
    }

    public h(String r4) {
        Intrinsics.checkNotNullParameter(r4, "previousPage");
        Intrinsics.checkNotNullParameter("creation_detail", "currentPage");
        Intrinsics.checkNotNullParameter("creation_detail", "clickFrom");
        Intrinsics.checkNotNullParameter("ai_edit_picture_detail", "enterMethod");
        this.a = r4;
        this.b = "creation_detail";
        this.c = "creation_detail";
        this.d = "ai_edit_picture_detail";
    }
}
