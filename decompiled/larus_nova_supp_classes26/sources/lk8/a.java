package lk8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ResearchBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final Message a;
    public final boolean b;
    public final boolean c;
    public final ResearchBlock d;
    public final int e;
    public final boolean f;

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
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.c == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        ResearchBlock r6 = this.d;
        if (r6 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (((r5 + r7) * 31) + this.e) * 31;
        if (this.f == true) goto L19;
        r2 = 1237;
    L19:
        return r8 + r2;
    L13:
        r7 = r6.hashCode();
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "DeepResearchCardVMData(message=" + this.a + ", isFirstBlockModel=" + this.b + ", isLastBlockModel=" + this.c + ", researchBlock=" + this.d + ", maxContentWidth=" + this.e + ", enableTableHeader=" + this.f + ')';
    }

    public a(Message r2, boolean r3, boolean r4, ResearchBlock r5, int r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "message");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
