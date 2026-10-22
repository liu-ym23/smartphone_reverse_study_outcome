package j42;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public final long a;
    public final String b;
    public final String c;
    public final String d;
    public final long e;
    public final String f;
    public final Long g;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof c) == false) goto L20;
        c r7 = (c) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.b;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        String r6 = this.c;
        if (r6 == null) goto L9;
        int r7 = r6.hashCode();
    L10:
        int r8 = (r5 + r7) * 31;
        String r9 = this.d;
        if (r9 == null) goto L13;
        int r10 = r9.hashCode();
    L14:
        long r11 = this.e;
        int r13 = (((r8 + r10) * 31) + ((int) (r11 ^ (r11 >>> 32)))) * 31;
        String r14 = this.f;
        if (r14 == null) goto L17;
        int r15 = r14.hashCode();
    L18:
        int r16 = (r13 + r15) * 31;
        Long r17 = this.g;
        if (r17 == null) goto L22;
        r3 = r17.hashCode();
    L22:
        return r16 + r3;
    L17:
        r15 = 0;
        goto L18
    L13:
        r10 = 0;
        goto L14
    L9:
        r7 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "PinAnswerData(questionMsgId=" + this.a + ", question=" + this.b + ", questionerId=" + this.c + ", questionerNickname=" + this.d + ", answerMsgId=" + this.e + ", answer=" + this.f + ", answerId=" + this.g + ")";
    }

    public c(long r2, String r4, String r5, String r6, long r7, String r9, Long r10) {
        Intrinsics.checkNotNullParameter(r4, "question");
        Intrinsics.checkNotNullParameter(r5, "questionerId");
        Intrinsics.checkNotNullParameter(r6, "questionerNickname");
        Intrinsics.checkNotNullParameter(r9, "answer");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r9;
        this.g = r10;
    }
}
