package cq8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class t extends y {
    public final String b;
    public final List<com.larus.bmhome.actionbar.model.w> c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof t) == true) goto L8;
        return false;
    L8:
        t r6 = (t) r5;
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
        return "ImageStyleListRefreshAction(widgetId=" + this.b + ", imageList=" + this.c + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.b;
    }

    public t(String r2, List<com.larus.bmhome.actionbar.model.w> r3) {
        Intrinsics.checkNotNullParameter(r2, "widgetId");
        Intrinsics.checkNotNullParameter(r3, "imageList");
        super("ImageStyleListRefreshAction");
        this.b = r2;
        this.c = r3;
    }
}
