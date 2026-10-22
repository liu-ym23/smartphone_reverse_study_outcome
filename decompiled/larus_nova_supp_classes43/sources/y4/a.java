package y4;

import com.bytedance.applet.model.floating.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final Function2<Boolean, Boolean, Unit> a;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((a) r10).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "ChatSpeakTipsAbility(switchStatus=" + this.a + ')';
    }

    public a(h r10) {
        Intrinsics.checkNotNullParameter(r10, "switchStatus");
        this.a = r10;
    }
}
