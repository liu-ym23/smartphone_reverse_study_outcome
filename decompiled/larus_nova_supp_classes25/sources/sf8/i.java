package sf8;

import com.larus.im.bean.message.Message;
import ic8.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i extends xc8.b {
    public final Message e;
    public final p f;

    @Override // xc8.b
    public final int d() {
        return 0;
    }

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
        return "DeepSearchCellState(myMessage=" + this.e + ')';
    }

    public i(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "myMessage");
        super(r2);
        this.e = r2;
        int r3 = p.a;
        this.f = p.a.a(this.a.getContent());
    }
}
