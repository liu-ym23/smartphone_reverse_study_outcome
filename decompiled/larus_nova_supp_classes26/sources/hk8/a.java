package hk8;

import com.larus.im.bean.message.Message;
import kc8.y;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final String a;
    public final Message b;
    public final y c;
    public final int d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final int i;
    public final boolean j;
    public final String k;
    public final String l;
    public final Function0<Boolean> m;
    public final boolean n;
    public final Boolean o;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
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
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (this.n == r6.n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        y r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((((((((r0 + r3) * 31) + this.d) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i) * 31;
        int r5 = 1231;
        if (this.j == false) goto L9;
        int r6 = 1231;
    L10:
        int r7 = (((((r4 + r6) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31;
        Function0<Boolean> r8 = this.m;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        if (this.n == true) goto L18;
        r5 = 1237;
    L18:
        int r11 = (r10 + r5) * 31;
        Boolean r12 = this.o;
        if (r12 == null) goto L23;
        r2 = r12.hashCode();
    L23:
        return r11 + r2;
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ComputerUseToolResultVMData(dataIdentifier=" + this.a + ", message=" + this.b + ", globalConfig=" + this.c + ", startIndex=" + this.d + ", title=" + this.e + ", content=" + this.f + ", imageUri=" + this.g + ", imageUrl=" + this.h + ", status=" + this.i + ", isDeepThinkArea=" + this.j + ", leftDarkIcon=" + this.k + ", leftLightIcon=" + this.l + ", interceptClickCard=" + this.m + ", disableFoldExpandClick=" + this.n + ", initialFoldState=" + this.o + ')';
    }

    public a(String r11, Message r12, y r13, int r14, String r15, String r16, String r17, String r18, int r19, boolean r20, String r21, String r22, fk8.c r23, boolean r24, Boolean r25) {
        Intrinsics.checkNotNullParameter(r11, "dataIdentifier");
        Intrinsics.checkNotNullParameter(r12, "message");
        Intrinsics.checkNotNullParameter(r15, "title");
        Intrinsics.checkNotNullParameter(r16, "content");
        Intrinsics.checkNotNullParameter(r17, "imageUri");
        Intrinsics.checkNotNullParameter(r18, "imageUrl");
        Intrinsics.checkNotNullParameter(r21, "leftDarkIcon");
        Intrinsics.checkNotNullParameter(r22, "leftLightIcon");
        this.a = r11;
        this.b = r12;
        this.c = r13;
        this.d = r14;
        this.e = r15;
        this.f = r16;
        this.g = r17;
        this.h = r18;
        this.i = r19;
        this.j = r20;
        this.k = r21;
        this.l = r22;
        this.m = r23;
        this.n = r24;
        this.o = r25;
    }
}
