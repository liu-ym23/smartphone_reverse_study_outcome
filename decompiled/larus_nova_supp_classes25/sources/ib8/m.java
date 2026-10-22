package ib8;

import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m {
    public final Function1<DeepThinkFoldStatus, String> a;
    public final Function1<DeepThinkFoldStatus, String> b;
    public final String c;
    public final Function1<DeepThinkFoldStatus, List<String>> d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "FoldContainerHeaderInfo(headIcon=" + this.a + ", headTitle=" + this.b + ", headTitleShowCount=" + this.c + ", headTitleList=" + this.d + ')';
    }

    public /* synthetic */ m(Function1 r2, Function1 r3, String r4) {
        this(r2, r3, r4, l.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(Function1<? super DeepThinkFoldStatus, String> r2, Function1<? super DeepThinkFoldStatus, String> r3, String r4, Function1<? super DeepThinkFoldStatus, ? extends List<String>> r5) {
        Intrinsics.checkNotNullParameter(r2, "headIcon");
        Intrinsics.checkNotNullParameter(r3, "headTitle");
        Intrinsics.checkNotNullParameter(r4, "headTitleShowCount");
        Intrinsics.checkNotNullParameter(r5, "headTitleList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
