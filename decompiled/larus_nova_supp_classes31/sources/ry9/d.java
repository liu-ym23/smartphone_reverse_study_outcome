package ry9;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public final List<c> a;
    public final int b;
    public final Double c;

    public d() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
        Double r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "CreationReferenceAttachmentSnapshot(attachments=" + this.a + ", additionalVideoCount=" + this.b + ", additionalVideoDuration=" + this.c + ')';
    }

    public /* synthetic */ d(int r3) {
        this(CollectionsKt.emptyList(), 0, null);
    }

    public d(List<c> r2, int r3, Double r4) {
        Intrinsics.checkNotNullParameter(r2, "attachments");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public static d a(d r1, int r2, Double r3) {
        List<c> r4 = r1.a;
        Intrinsics.checkNotNullParameter(r4, "attachments");
        return new d(r4, r2, r3);
    }
}
