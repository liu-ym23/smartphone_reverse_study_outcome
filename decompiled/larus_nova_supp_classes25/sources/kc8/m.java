package kc8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ComplexTaskBlock;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m {
    public final boolean a;
    public final long b;
    public final Function2<Message, ComplexTaskBlock, Unit> c;

    public m() {
        this(false, null, 7);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof m) == true) goto L8;
        return false;
    L8:
        m r9 = (m) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        long r1 = this.b;
        int r2 = ((r0 * 31) + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        Function2<Message, ComplexTaskBlock, Unit> r3 = this.c;
        if (r3 != null) goto L9;
        int r4 = 0;
    L11:
        return r2 + r4;
    L9:
        r4 = r3.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ComplexTaskBlockConfig(useCapsuleStyle=" + this.a + ", timeoutMs=" + this.b + ", onClickBlock=" + this.c + ')';
    }

    public m(boolean r3, Function2 r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        this.a = r3;
        this.b = 0;
        this.c = r4;
    }
}
