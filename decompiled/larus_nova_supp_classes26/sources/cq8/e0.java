package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e0 extends y {
    public final String b;
    public final String c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r6 = (e0) r5;
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.b.hashCode() * 31;
        String r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "MediaSelectorRemoveAction(widgetId=" + this.b + ", identifier=" + this.c + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.b;
    }

    public final String getIdentifier() {
        return this.c;
    }

    public e0(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "widgetId");
        super("MediaSelectorRemoveAction");
        this.b = r2;
        this.c = r3;
    }
}
