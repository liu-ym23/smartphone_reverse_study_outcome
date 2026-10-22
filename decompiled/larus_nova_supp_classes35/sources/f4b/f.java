package f4b;

import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f {
    public final CharSequence a;
    public final CharSequence b;
    public final boolean c;
    public final boolean d;
    public final PartialReplyInfo.PartialContentRelativePosition e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        CharSequence r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        CharSequence r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        int r7 = 1231;
        if (this.c == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r6 + r8) * 31;
        if (this.d == true) goto L18;
        r7 = 1237;
    L18:
        int r10 = (r9 + r7) * 31;
        PartialReplyInfo.PartialContentRelativePosition r11 = this.e;
        if (r11 == null) goto L23;
        r1 = r11.hashCode();
    L23:
        return r10 + r1;
    L13:
        r8 = 1237;
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "SelectData(select=" + this.a + ", full=" + this.b + ", isTranslate=" + this.c + ", isPartialCopy=" + this.d + ", partialPosition=" + this.e + ')';
    }

    public f(CharSequence r1, CharSequence r2, boolean r3, boolean r4, PartialReplyInfo.PartialContentRelativePosition r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
