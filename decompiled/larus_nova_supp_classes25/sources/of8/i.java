package of8;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i extends xc8.b {
    public final Message e;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof i) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.e, ((i) r4).e) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.e.hashCode();
    }

    public final String toString() {
        return "BlockCellState(mMessage=" + this.e + ')';
    }

    @Override // xc8.b
    public final int d() {
        if (this.e.getContentType() != 8) goto L6;
        return 3;
    L6:
        if (this.e.getContentType() != 100) goto L9;
    L7:
        return 0;
    L9:
        if (com.larus.bmhome.chat.bean.d.G0(this.e) == false) goto L7;
        return 1;
    }

    public i(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "mMessage");
        super(r2);
        this.e = r2;
    }
}
