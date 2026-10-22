package laa;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class w {
    public final String a;
    public final String b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof w) == true) goto L8;
        return false;
    L8:
        w r6 = (w) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "PendingComplexTaskReplyTarget(replyMessageId=" + this.a + ", source=" + this.b + ')';
    }

    public w(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "replyMessageId");
        Intrinsics.checkNotNullParameter(r3, "source");
        this.a = r2;
        this.b = r3;
    }
}
