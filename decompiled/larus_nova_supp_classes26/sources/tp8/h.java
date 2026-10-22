package tp8;

import com.larus.bmhome.interactionpanel.j;
import jc8.l;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h implements l {
    public final Function1<String, Unit> a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof h) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((h) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "QuickReplyInputPassData(onResult=" + this.a + ')';
    }

    public h(j r2) {
        Intrinsics.checkNotNullParameter(r2, "onResult");
        this.a = r2;
    }
}
