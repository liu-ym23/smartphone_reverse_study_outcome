package hn8;

import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l {
    public final j a;
    public final ExpandCardViewMode b;
    public final boolean c;
    public final String d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l) == true) goto L8;
        return false;
    L8:
        l r6 = (l) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
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
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        String r3 = this.d;
        if (r3 != null) goto L9;
        int r4 = 0;
    L11:
        return r2 + r4;
    L9:
        r4 = r3.hashCode();
        goto L11
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "VideoCardViewData(videoCardData=" + this.a + ", videoCardMode=" + this.b + ", isOversea=" + this.c + ", messageId=" + this.d + ')';
    }

    public l(j r2, ExpandCardViewMode r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "videoCardData");
        Intrinsics.checkNotNullParameter(r3, "videoCardMode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
