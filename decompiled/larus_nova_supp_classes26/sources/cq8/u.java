package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u extends y {
    public final String b;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof u) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.b, ((u) r4).b) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return "ImageStyleListResetAction(widgetId=" + this.b + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.b;
    }

    public u(String r2) {
        Intrinsics.checkNotNullParameter(r2, "widgetId");
        super("ImageStyleListResetAction");
        this.b = r2;
    }
}
