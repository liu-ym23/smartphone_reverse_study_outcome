package kc8;

import android.view.View;
import com.larus.im.bean.message.Message;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l {
    public final Function2<View, Message, Boolean> a;

    public l() {
        this(null);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof l) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((l) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Function2<View, Message, Boolean> r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "CodeBlockConfig(codeSelectionHandler=" + this.a + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(Function2<? super View, ? super Message, Boolean> r1) {
        this.a = r1;
    }
}
