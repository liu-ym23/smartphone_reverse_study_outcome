package dw8;

import com.larus.bmhome.ability.FloatChatWindowState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n {
    public final int a;
    public final FloatChatWindowState b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L8;
        return false;
    L8:
        n r6 = (n) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "AIChatPanelInfo(heightPx=" + this.a + ", state=" + this.b + ')';
    }

    public n(int r2, FloatChatWindowState r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        this.a = r2;
        this.b = r3;
    }
}
