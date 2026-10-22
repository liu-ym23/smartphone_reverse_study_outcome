package xc8;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l extends b {
    public final Message e;

    @Override // xc8.b
    public final int d() {
        return -1;
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof l) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.e, ((l) r4).e) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.e.hashCode();
    }

    public final String toString() {
        return "TimestampCellState(timeMessage=" + this.e + ')';
    }

    public l(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "timeMessage");
        super(r2);
        this.e = r2;
    }
}
