package hda;

import com.obric.assistant.cocreationreview.modules.memory.DiffType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d1 {
    public final DiffType a;
    public final String b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d1) == true) goto L8;
        return false;
    L8:
        d1 r6 = (d1) r5;
        if (this.a == r6.a) goto L12;
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
        return "MemoryReviewTextDiffSegment(type=" + this.a + ", text=" + this.b + ')';
    }

    public final DiffType getType() {
        return this.a;
    }

    public d1(DiffType r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "text");
        this.a = r2;
        this.b = r3;
    }
}
