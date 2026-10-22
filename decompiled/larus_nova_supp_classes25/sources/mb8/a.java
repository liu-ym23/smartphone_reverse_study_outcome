package mb8;

import com.larus.im.bean.message.Message;
import fh8.d;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public final List<jc8.a> a;
    public final boolean b;
    public final Message c;
    public final kc8.b d;
    public final boolean e;
    public final d f;

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
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
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
        int r3 = (((r0 + r1) * 31) + this.c.hashCode()) * 31;
        kc8.b r4 = this.d;
        int r5 = 0;
        if (r4 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r3 + r6) * 31;
        if (this.e == true) goto L14;
        r2 = 1237;
    L14:
        int r8 = (r7 + r2) * 31;
        d r9 = this.f;
        if (r9 == null) goto L19;
        r5 = r9.hashCode();
    L19:
        return r8 + r5;
    L9:
        r6 = r4.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "DeepThinkBlockListVMData(blockList=" + this.a + ", forceRefreshAllBlock=" + this.b + ", message=" + this.c + ", blockDependConfig=" + this.d + ", isDeepThinkingStreaming=" + this.e + ", deepThinkFoldStatusManager=" + this.f + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends jc8.a> r2, boolean r3, Message r4, kc8.b r5, boolean r6, d r7) {
        Intrinsics.checkNotNullParameter(r2, "blockList");
        Intrinsics.checkNotNullParameter(r4, "message");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
