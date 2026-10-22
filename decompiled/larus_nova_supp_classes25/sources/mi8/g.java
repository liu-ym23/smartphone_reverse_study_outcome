package mi8;

import android.content.Context;
import com.larus.bmhome.chat.quickreply.MoaGrantingDecision;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g {
    public final String a;
    public final MoaGrantingDecision b;
    public final f c;
    public final WeakReference<Context> d;
    public final Function0<Unit> e;

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
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        WeakReference<Context> r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Function0<Unit> r5 = this.e;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MoaGrantingOperateRequest(schemaPayload=" + this.a + ", decision=" + this.b + ", messageContext=" + this.c + ", uiContext=" + this.d + ", onWaitingForAction=" + this.e + ')';
    }

    public g(String r2, MoaGrantingDecision r3, f r4, WeakReference r5, qm8.a r6) {
        Intrinsics.checkNotNullParameter(r2, "schemaPayload");
        Intrinsics.checkNotNullParameter(r3, "decision");
        Intrinsics.checkNotNullParameter(r4, "messageContext");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
