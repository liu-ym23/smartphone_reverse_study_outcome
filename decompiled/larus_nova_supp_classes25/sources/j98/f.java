package j98;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public final long a;
    public final int b;
    public final List<String> c;
    public final List<String> d;
    public final String e;
    public final boolean f;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof f) == true) goto L8;
        return false;
    L8:
        f r9 = (f) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        if (this.f == false) goto L5;
        int r2 = 1231;
    L7:
        return r1 + r2;
    L5:
        r2 = 1237;
        goto L7
    }

    public final String toString() {
        return "DiaryFeedbackSheetUiState(sessionId=" + this.a + ", actionType=" + this.b + ", reasonOptions=" + this.c + ", selectedReasons=" + this.d + ", inputText=" + this.e + ", isSubmitting=" + this.f + ')';
    }

    public final boolean b() {
        if (this.f == false) goto L5;
        return false;
    L5:
        if ((!this.d.isEmpty()) == false) goto L7;
    L11:
        return true;
    L7:
        if (StringsKt.trim(this.e).toString().length() <= 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L11;
        return false;
    L9:
        r0 = false;
        goto L10
    }

    public f() {
        this(System.nanoTime(), 0, CollectionsKt.emptyList(), CollectionsKt.emptyList(), "", false);
    }

    public f(long r2, int r4, List<String> r5, List<String> r6, String r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r5, "reasonOptions");
        Intrinsics.checkNotNullParameter(r6, "selectedReasons");
        Intrinsics.checkNotNullParameter(r7, "inputText");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
    }

    public static f a(f r10, List r11, List r12, String r13, boolean r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        long r0 = r10.a;
    L6:
        long r3 = r0;
        if ((r15 & 2) == 0) goto L9;
        int r5 = r10.b;
    L11:
        if ((r15 & 4) == 0) goto L13;
        r11 = r10.c;
    L13:
        List r6 = r11;
        if ((r15 & 8) == 0) goto L16;
        r12 = r10.d;
    L16:
        List r7 = r12;
        if ((r15 & 16) == 0) goto L19;
        r13 = r10.e;
    L19:
        String r8 = r13;
        if ((r15 & 32) == 0) goto L22;
        r14 = r10.f;
    L22:
        r10.getClass();
        Intrinsics.checkNotNullParameter(r6, "reasonOptions");
        Intrinsics.checkNotNullParameter(r7, "selectedReasons");
        Intrinsics.checkNotNullParameter(r8, "inputText");
        return new f(r3, r5, r6, r7, r8, r14);
    L9:
        r5 = 0;
        goto L11
    L5:
        r0 = 0;
        goto L6
    }
}
