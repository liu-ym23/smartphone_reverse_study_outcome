package pk8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ResearchProcessBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public final boolean a;
    public final ResearchProcessBlock b;
    public final Message c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        ResearchProcessBlock r2 = this.b;
        if (r2 != null) goto L9;
        int r3 = 0;
    L11:
        return ((r1 + r3) * 31) + this.c.hashCode();
    L9:
        r3 = r2.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "DeepResearchProgressCardVmData(isFinished=" + this.a + ", researchProcessBlock=" + this.b + ", message=" + this.c + ')';
    }

    public e(boolean r2, ResearchProcessBlock r3, Message r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
