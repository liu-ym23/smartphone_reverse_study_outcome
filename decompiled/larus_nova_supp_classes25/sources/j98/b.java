package j98;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public final List<String> a;
    public final String b;

    public b() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "DiaryFeedbackDraft(selectedReasons=" + this.a + ", inputText=" + this.b + ')';
    }

    public /* synthetic */ b(int r2) {
        this(CollectionsKt.emptyList(), "");
    }

    public b(List<String> r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "selectedReasons");
        Intrinsics.checkNotNullParameter(r3, "inputText");
        this.a = r2;
        this.b = r3;
    }
}
