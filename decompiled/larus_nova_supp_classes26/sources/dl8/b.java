package dl8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.FileOperationBlock;
import kc8.y;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public final String a;
    public final Pair<Integer, Integer> b;
    public final Message c;
    public final FileOperationBlock d;
    public final boolean e;
    public final int f;
    public final Integer g;
    public final y h;
    public final int i;
    public final boolean j;
    public final Function0<Boolean> k;
    public final boolean l;
    public final Boolean m;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
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
        if (this.e == r6.e) goto L24;
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
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        Pair<Integer, Integer> r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Message r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        FileOperationBlock r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        int r11 = 1231;
        if (this.e == false) goto L17;
        int r12 = 1231;
    L18:
        int r13 = (((r10 + r12) * 31) + this.f) * 31;
        Integer r14 = this.g;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        y r17 = this.h;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (((r16 + r18) * 31) + this.i) * 31;
        if (this.j == false) goto L29;
        int r20 = 1231;
    L30:
        int r21 = (r19 + r20) * 31;
        Function0<Boolean> r22 = this.k;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        if (this.l == true) goto L38;
        r11 = 1237;
    L38:
        int r25 = (r24 + r11) * 31;
        Boolean r26 = this.m;
        if (r26 == null) goto L43;
        r2 = r26.hashCode();
    L43:
        return r25 + r2;
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = 1237;
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = 1237;
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
        return "FileOperateVMData(dataIdentifier=" + this.a + ", topAndBottomMarginPair=" + this.b + ", message=" + this.c + ", fileOperationBlock=" + this.d + ", isFinish=" + this.e + ", cardPosition=" + this.f + ", backgroundRes=" + this.g + ", globalConfig=" + this.h + ", startIndex=" + this.i + ", isDeepThinkArea=" + this.j + ", interceptClickCard=" + this.k + ", disableFoldExpandClick=" + this.l + ", initialFoldState=" + this.m + ')';
    }

    public b(String r2, Pair r3, Message r4, FileOperationBlock r5, boolean r6, int r7, Integer r8, y r9, int r10, boolean r11, bl8.b r12, boolean r13, Boolean r14) {
        Intrinsics.checkNotNullParameter(r2, "dataIdentifier");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        this.m = r14;
    }
}
