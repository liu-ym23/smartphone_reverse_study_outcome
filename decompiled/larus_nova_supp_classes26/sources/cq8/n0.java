package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n0 extends y {
    public final String b;
    public final bq8.a c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n0) == true) goto L8;
        return false;
    L8:
        n0 r6 = (n0) r5;
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.b.hashCode() * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "MusicTemplateChooseAction(widgetId=" + this.b + ", template=" + this.c + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.b;
    }

    public n0(String r2, bq8.a r3) {
        Intrinsics.checkNotNullParameter(r2, "widgetId");
        Intrinsics.checkNotNullParameter(r3, "template");
        super("MusicTemplateChooseAction");
        this.b = r2;
        this.c = r3;
    }
}
