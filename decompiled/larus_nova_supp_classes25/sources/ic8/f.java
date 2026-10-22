package ic8;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public final String a;
    public final Message b;
    public final String c;
    public final Integer d;
    public final Integer e;
    public final r f;

    public f() {
        this(null, null, null, null, null, 63);
    }

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
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        Message r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Integer r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Integer r11 = this.e;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        r r14 = this.f;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "AiEditFunctionParams(url=" + this.a + ", message=" + this.b + ", creationTaskId=" + this.c + ", width=" + this.d + ", height=" + this.e + ", driveInfo=" + this.f + ')';
    }

    public /* synthetic */ f(String r8, Message r9, String r10, Integer r11, Integer r12, int r13) {
        if ((r13 & 1) == 0) goto L5;
        r8 = "";
    L5:
        String r1 = r8;
        if ((r13 & 2) == 0) goto L8;
        Message r2 = null;
    L10:
        if ((r13 & 4) == 0) goto L12;
        String r3 = null;
    L14:
        if ((r13 & 8) == 0) goto L16;
        Integer r4 = null;
    L18:
        if ((r13 & 16) == 0) goto L20;
        Integer r5 = null;
    L21:
        this(r1, r2, r3, r4, r5, null);
        return;
    L20:
        r5 = r12;
        goto L21
    L16:
        r4 = r11;
        goto L18
    L12:
        r3 = r10;
        goto L14
    L8:
        r2 = r9;
        goto L10
    }

    public f(String r2, Message r3, String r4, Integer r5, Integer r6, r r7) {
        Intrinsics.checkNotNullParameter(r2, "url");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
