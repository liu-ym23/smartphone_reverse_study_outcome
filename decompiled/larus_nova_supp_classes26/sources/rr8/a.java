package rr8;

import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final Boolean a;
    public final IChatMessageShareAbility.ActionType b;
    public final Map<String, Object> c;

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
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Boolean r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.b.hashCode()) * 31;
        Map<String, Object> r4 = this.c;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "MessageSelectStatus(selectMode=" + this.a + ", action=" + this.b + ", ext=" + this.c + ')';
    }

    public a(Boolean r2, IChatMessageShareAbility.ActionType r3, Map<String, Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "action");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
