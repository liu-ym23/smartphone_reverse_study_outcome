package aq8;

import com.larus.im.bean.message.Image;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public final String a;
    public final Integer b;
    public final Integer c;
    public final String d;
    public final Map<String, String> e;
    public final boolean f;
    public final String g;
    public final String h;
    public final String i;
    public final Image j;

    public e() {
        this(null, null, null, null, null, false, null, null, null, null, 1023);
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
        if (this.f == r6.f) goto L27;
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
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
        return false;
    L38:
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
        Integer r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (((r9 + r11) * 31) + this.e.hashCode()) * 31;
        if (this.f == false) goto L21;
        int r13 = 1231;
    L22:
        int r14 = (r12 + r13) * 31;
        String r15 = this.g;
        if (r15 != null) goto L25;
        int r16 = 0;
    L26:
        int r17 = (r14 + r16) * 31;
        String r18 = this.h;
        if (r18 != null) goto L29;
        int r19 = 0;
    L30:
        int r20 = (r17 + r19) * 31;
        String r21 = this.i;
        if (r21 != null) goto L33;
        int r22 = 0;
    L34:
        int r23 = (r20 + r22) * 31;
        Image r24 = this.j;
        if (r24 == null) goto L39;
        r1 = r24.hashCode();
    L39:
        return r23 + r1;
    L33:
        r22 = r21.hashCode();
        goto L34
    L29:
        r19 = r18.hashCode();
        goto L30
    L25:
        r16 = r15.hashCode();
        goto L26
    L21:
        r13 = 1237;
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
        return "InstructionExtraData(inputContent=" + this.a + ", selectStartPosition=" + this.b + ", selectEndPosition=" + this.c + ", instructionDefaultParams=" + this.d + ", msgExtMap=" + this.e + ", isForceUpdateWhenSame=" + this.f + ", enterMethod=" + this.g + ", scene=" + this.h + ", imageScene=" + this.i + ", image=" + this.j + ')';
    }

    public e(String r3, Integer r4, Integer r5, String r6, Map r7, boolean r8, String r9, String r10, String r11, Image r12, int r13) {
        if ((r13 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r13 & 16) == 0) goto L18;
        r7 = new LinkedHashMap();
    L18:
        if ((r13 & 32) == 0) goto L21;
        r8 = false;
    L21:
        if ((r13 & 64) == 0) goto L24;
        r9 = null;
    L24:
        if ((r13 & 128) == 0) goto L27;
        r10 = null;
    L27:
        if ((r13 & 256) == 0) goto L30;
        r11 = null;
    L30:
        if ((r13 & 512) == 0) goto L32;
        r12 = null;
    L32:
        Intrinsics.checkNotNullParameter(r7, "msgExtMap");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
    }
}
