package kc8;

import com.larus.bmhome.chat.block.base.config.ToolBlockInitStatus;
import com.larus.bmhome.chat.block.base.config.ToolBlockInteractType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class w0 implements jc8.l {
    public final ToolBlockInteractType a;
    public final ToolBlockInitStatus b;
    public final d c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof w0) == true) goto L8;
        return false;
    L8:
        w0 r6 = (w0) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        d r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "ToolCallBlockConfig(toolBlockInteractType=" + this.a + ", toolInitStatus=" + this.b + ", detailNavigator=" + this.c + ')';
    }

    public w0() {
        this(ToolBlockInteractType.Default, ToolBlockInitStatus.Default, null);
    }

    public w0(ToolBlockInteractType r2, ToolBlockInitStatus r3, d r4) {
        Intrinsics.checkNotNullParameter(r2, "toolBlockInteractType");
        Intrinsics.checkNotNullParameter(r3, "toolInitStatus");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
