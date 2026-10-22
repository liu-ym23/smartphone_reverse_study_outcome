package i5;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements com.bytedance.assem.arch.viewModel.h {
    public final Map<String, a6.a> a;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((a) r10).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "AIViewPrivateData(aiViewModelMap=" + this.a + ')';
    }

    public a(Map<String, a6.a> r10) {
        Intrinsics.checkNotNullParameter(r10, "aiViewModelMap");
        this.a = r10;
    }
}
