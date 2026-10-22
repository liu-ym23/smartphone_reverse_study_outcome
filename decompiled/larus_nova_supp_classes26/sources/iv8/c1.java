package iv8;

import com.larus.browsertakeover.cdp.RemoteInputCommand;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c1<T> {
    public final T a;
    public final RemoteInputCommand b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c1) == true) goto L8;
        return false;
    L8:
        c1 r6 = (c1) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        T r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + this.b.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public final String toString() {
        return "ScheduledRemoteInput(token=" + this.a + ", command=" + this.b + ')';
    }

    public c1(T r2, RemoteInputCommand r3) {
        Intrinsics.checkNotNullParameter(r3, "command");
        this.a = r2;
        this.b = r3;
    }
}
