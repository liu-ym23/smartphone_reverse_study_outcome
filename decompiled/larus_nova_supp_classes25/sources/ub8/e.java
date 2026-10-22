package ub8;

import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public final boolean a;
    public final String b;
    public final String c;
    public final IIMError d;

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
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        IIMError r2 = this.d;
        if (r2 != null) goto L9;
        int r3 = 0;
    L11:
        return r1 + r3;
    L9:
        r3 = r2.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ConversationUpdateResult(success=" + this.a + ", conversationId=" + this.b + ", name=" + this.c + ", fail=" + this.d + ')';
    }

    public e(boolean r2, String r3, String r4, IIMError r5) {
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        Intrinsics.checkNotNullParameter(r4, "name");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
