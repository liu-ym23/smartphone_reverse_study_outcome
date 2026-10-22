package hda;

import com.obric.assistant.cocreationreview.Vote;
import com.obric.assistant.cocreationreview.modules.memory.MemoryDataReviewModuleKey;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class w0 {
    public final String a;
    public final MemoryDataReviewModuleKey b;
    public final Vote c;
    public final Set<String> d;
    public final String e;
    public final String f;
    public final String g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof w0) == true) goto L8;
        return false;
    L8:
        w0 r6 = (w0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        String r1 = this.g;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "MemoryReviewSubmitFeedbackDto(recordId=" + this.a + ", module=" + this.b + ", vote=" + this.c + ", reasons=" + this.d + ", comment=" + this.e + ", businessPayloadJson=" + this.f + ", traceJson=" + this.g + ')';
    }

    public w0(String r2, MemoryDataReviewModuleKey r3, Vote r4, Set<String> r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r2, "recordId");
        Intrinsics.checkNotNullParameter(r3, "module");
        Intrinsics.checkNotNullParameter(r4, "vote");
        Intrinsics.checkNotNullParameter(r5, "reasons");
        Intrinsics.checkNotNullParameter(r6, "comment");
        Intrinsics.checkNotNullParameter(r7, "businessPayloadJson");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
