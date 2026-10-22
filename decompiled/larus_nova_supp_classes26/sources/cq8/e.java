package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e extends y {
    public final String b;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof e) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.b, ((e) r4).b) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return "ButtonRouterShowAction(widgetId=" + this.b + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.b;
    }

    public e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "widgetId");
        super("ButtonRouterShowAction");
        this.b = r2;
    }
}
