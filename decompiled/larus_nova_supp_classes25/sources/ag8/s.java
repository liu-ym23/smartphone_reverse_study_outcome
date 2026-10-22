package ag8;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s extends xc8.b {
    public final Message e;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof s) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.e, ((s) r4).e) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.e.hashCode();
    }

    public final String toString() {
        return "SendImageCellState(sendImageMessage=" + this.e + ')';
    }

    @Override // xc8.b
    public final int d() {
        return com.larus.bmhome.chat.bean.d.G0(this.e) ? 1 : 0;
    }

    public s(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "sendImageMessage");
        super(r2);
        this.e = r2;
    }
}
