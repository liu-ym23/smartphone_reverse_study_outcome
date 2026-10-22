package f5b;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements y28.b<a> {
    public final long a;
    public final String b;
    public final CharSequence c;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31;
        CharSequence r2 = this.c;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r1 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public final String toString() {
        return "AISmartReplyVO(messageId=" + this.a + ", aiReplyId=" + this.b + ", answerDigest=" + this.c + ')';
    }

    public final boolean isContentSame(y28.b r8) {
        a r9 = (a) r8;
        if (this != r9) goto L6;
        return true;
    L6:
        if (r9 == null) goto L8;
        Class<a> r2 = a.class;
    L10:
        if (Intrinsics.areEqual(a.class, r2) == true) goto L13;
    L11:
        return false;
    L13:
        if (this.a != r9.a) goto L11;
        if (Intrinsics.areEqual(this.b, r9.b) == false) goto L11;
        if (Intrinsics.areEqual(this.c, r9.c) == false) goto L11;
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public final boolean isItemSame(y28.b r8) {
        a r9 = (a) r8;
        if (r9 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.b, r9.b) == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        if (this.a != r9.a) goto L7;
        r2 = true;
        goto L8
    }

    public a(long r2, String r4, CharSequence r5) {
        Intrinsics.checkNotNullParameter(r4, "aiReplyId");
        this.a = r2;
        this.b = r4;
        this.c = r5;
    }
}
