package zy9;

import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public final Message a;
    public final List<CreationItem> b;
    public final int c;

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
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        List<CreationItem> r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.c;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "CorrectionImageVMData(message=" + this.a + ", creationItems=" + this.b + ", maxContentWidth=" + this.c + ')';
    }

    public a(Message r2, List<CreationItem> r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "message");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
