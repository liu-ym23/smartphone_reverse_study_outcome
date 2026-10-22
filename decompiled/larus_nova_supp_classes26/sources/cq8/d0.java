package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d0 extends y {
    public final String b;
    public final String c;
    public final String d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d0) == true) goto L8;
        return false;
    L8:
        d0 r6 = (d0) r5;
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.b.hashCode() * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.d;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MediaSelectorPreviewAction(widgetId=" + this.b + ", url=" + this.c + ", localPath=" + this.d + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.b;
    }

    public d0(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "widgetId");
        super("MediaSelectorPreviewAction");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
