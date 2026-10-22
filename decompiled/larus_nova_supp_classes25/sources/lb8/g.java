package lb8;

import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g {
    public final List<jc8.a> a;
    public final Message b;
    public final boolean c;
    public final fh8.d d;
    public final kc8.b e;
    public final boolean f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        Message r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        int r5 = 1231;
        if (this.c == false) goto L9;
        int r6 = 1231;
    L10:
        int r7 = (r4 + r6) * 31;
        fh8.d r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        kc8.b r11 = this.e;
        if (r11 == null) goto L18;
        r2 = r11.hashCode();
    L18:
        int r12 = (r10 + r2) * 31;
        if (this.f == true) goto L23;
        r5 = 1237;
    L23:
        return r12 + r5;
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
        return "DeepThinkBlockListViewInput(models=" + this.a + ", message=" + this.b + ", isDeepThinkingStreaming=" + this.c + ", deepThinkFoldStatusManager=" + this.d + ", blockDependConfig=" + this.e + ", forceRefreshAllBlock=" + this.f + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(List<? extends jc8.a> r2, Message r3, boolean r4, fh8.d r5, kc8.b r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "models");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
