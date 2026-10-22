package un8;

import com.larus.im.bean.message.block.TaskCardBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public boolean a;
    public TaskCardBlock b;
    public boolean c;

    public a() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        TaskCardBlock r3 = this.b;
        if (r3 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r2 + r4) * 31;
        if (this.c == true) goto L15;
        r1 = 1237;
    L15:
        return r5 + r1;
    L9:
        r4 = r3.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "CycleInfo(canExecute=" + this.a + ", block=" + this.b + ", started=" + this.c + ')';
    }

    public a(int r2) {
        this.a = false;
        this.b = null;
        this.c = false;
    }
}
