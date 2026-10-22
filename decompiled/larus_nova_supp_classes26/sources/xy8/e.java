package xy8;

import com.larus.platform.api.creation.UserCreationType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public final String a;
    public final Integer b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final Integer h;
    public final String i;
    public final boolean j;
    public final boolean k;

    public e() {
        this(null, null, null, null, null, null, null, null, null, false, 2047);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.i;
        if (r25 == null) goto L38;
        r1 = r25.hashCode();
    L38:
        int r26 = (r24 + r1) * 31;
        int r27 = 1231;
        if (this.j == false) goto L41;
        int r28 = 1231;
    L42:
        int r29 = (r26 + r28) * 31;
        if (this.k == true) goto L47;
        r27 = 1237;
    L47:
        return r29 + r27;
    L41:
        r28 = 1237;
        goto L42
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "PublishMetadata(creationId=" + this.a + ", creationType=" + this.b + ", messageId=" + this.c + ", refContent=" + this.d + ", taskId=" + this.e + ", creationIndex=" + this.f + ", materialId=" + this.g + ", fromIMCreationType=" + this.h + ", prompt=" + this.i + ", isBlockContent=" + this.j + ", isPublished=" + this.k + ')';
    }

    public static e a(e r15, String r16, Integer r17, String r18, String r19, String r20, boolean r21, int r22) {
        if ((r22 & 1) == 0) goto L5;
        String r4 = r15.a;
    L7:
        if ((r22 & 2) == 0) goto L9;
        Integer r5 = r15.b;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r6 = r15.c;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r7 = r15.d;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r8 = r15.e;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r9 = r15.f;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r10 = r15.g;
    L31:
        if ((r22 & 128) == 0) goto L33;
        Integer r11 = r15.h;
    L35:
        if ((r22 & 256) == 0) goto L37;
        String r12 = r15.i;
    L39:
        if ((r22 & 512) == 0) goto L41;
        boolean r13 = r15.j;
    L43:
        if ((r22 & 1024) == 0) goto L45;
        boolean r14 = r15.k;
    L46:
        r15.getClass();
        return new e(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    L45:
        r14 = r21;
        goto L46
    L41:
        r13 = false;
        goto L43
    L37:
        r12 = r20;
        goto L39
    L33:
        r11 = null;
        goto L35
    L29:
        r10 = r19;
        goto L31
    L25:
        r9 = null;
        goto L27
    L21:
        r8 = null;
        goto L23
    L17:
        r7 = r18;
        goto L19
    L13:
        r6 = null;
        goto L15
    L9:
        r5 = r17;
        goto L11
    L5:
        r4 = r16;
        goto L7
    }

    public /* synthetic */ e(String r16, Integer r17, String r18, String r19, String r20, String r21, String r22, Integer r23, String r24, boolean r25, int r26) {
        if ((r26 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r26 & 2) == 0) goto L9;
        Integer r5 = null;
    L11:
        if ((r26 & 4) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r26 & 8) == 0) goto L17;
        String r7 = null;
    L19:
        if ((r26 & 16) == 0) goto L21;
        String r8 = null;
    L23:
        if ((r26 & 32) == 0) goto L25;
        String r9 = null;
    L27:
        if ((r26 & 64) == 0) goto L29;
        String r10 = null;
    L31:
        if ((r26 & 128) == 0) goto L33;
        Integer r11 = null;
    L35:
        if ((r26 & 256) == 0) goto L37;
        String r12 = null;
    L39:
        if ((r26 & 1024) == 0) goto L41;
        boolean r14 = false;
    L42:
        this(r4, r5, r6, r7, r8, r9, r10, r11, r12, false, r14);
        return;
    L41:
        r14 = r25;
        goto L42
    L37:
        r12 = r24;
        goto L39
    L33:
        r11 = r23;
        goto L35
    L29:
        r10 = r22;
        goto L31
    L25:
        r9 = r21;
        goto L27
    L21:
        r8 = r20;
        goto L23
    L17:
        r7 = r19;
        goto L19
    L13:
        r6 = r18;
        goto L15
    L9:
        r5 = r17;
        goto L11
    L5:
        r4 = r16;
        goto L7
    }

    public e(String r1, @UserCreationType Integer r2, String r3, String r4, String r5, String r6, String r7, @UserCreationType Integer r8, String r9, boolean r10, boolean r11) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
    }
}
