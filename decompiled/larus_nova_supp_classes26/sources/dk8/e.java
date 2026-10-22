package dk8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ComplexTaskBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public final Message a;
    public final ComplexTaskBlock b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

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
        Message r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ComplexTaskBlock r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        int r5 = (r3 + r1) * 31;
        int r6 = 1231;
        if (this.c == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r5 + r7) * 31;
        if (this.d == false) goto L17;
        int r9 = 1231;
    L18:
        int r10 = (r8 + r9) * 31;
        if (this.e == true) goto L23;
        r6 = 1237;
    L23:
        return r10 + r6;
    L17:
        r9 = 1237;
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ComplexTaskNormalVMData(message=" + this.a + ", complexTaskBlock=" + this.b + ", isInterrupted=" + this.c + ", showArrow=" + this.d + ", enableClick=" + this.e + ')';
    }

    public e(Message r1, ComplexTaskBlock r2, boolean r3, boolean r4, boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
