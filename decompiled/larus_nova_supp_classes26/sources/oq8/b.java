package oq8;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public final Set<Character> a;

    public b() {
        this(null);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "InlineTriggerConfig(triggerChars=" + this.a + ')';
    }

    public b(Object r2) {
        Set<Character> r3 = SetsKt.setOf('@');
        Intrinsics.checkNotNullParameter(r3, "triggerChars");
        this.a = r3;
    }
}
