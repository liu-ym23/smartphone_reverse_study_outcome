package t42;

import com.bytedance.android.live.base.model.liteinteraction.d;
import com.bytedance.android.live.base.model.message.m6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public final d a;
    public final m6 b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L10;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        d r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        m6 r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "LiteInteractionServerData(liteInteractionData=" + this.a + ", schemaAction=" + this.b + ')';
    }

    public c(d r2, m6 r3) {
        Intrinsics.checkNotNullParameter(r2, "liteInteractionData");
        Intrinsics.checkNotNullParameter(r3, "schemaAction");
        this.a = r2;
        this.b = r3;
    }
}
