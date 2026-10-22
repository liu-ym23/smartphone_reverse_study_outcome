package hda;

import com.obric.assistant.cocreationreview.Vote;
import com.obric.assistant.cocreationreview.modules.memory.MemoryReviewFeedbackState;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class y {
    public final MemoryReviewFeedbackState a;
    public final Vote b;
    public final Set<String> c;
    public final String d;
    public final String e;
    public final String f;
    public final long g;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof y) == true) goto L8;
        return false;
    L8:
        y r9 = (y) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        Vote r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((r0 + r3) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        String r5 = this.e;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.f;
        if (r8 == null) goto L14;
        r2 = r8.hashCode();
    L14:
        long r9 = this.g;
        return ((r7 + r2) * 31) + ((int) (r9 ^ (r9 >>> 32)));
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MemoryReviewFeedbackInfoDto(state=" + this.a + ", vote=" + this.b + ", reasons=" + this.c + ", comment=" + this.d + ", displayedCardJson=" + this.e + ", traceJson=" + this.f + ", updateTimeMillis=" + this.g + ')';
    }

    public y(MemoryReviewFeedbackState r2, Vote r3, Set<String> r4, String r5, String r6, String r7, long r8) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r4, "reasons");
        Intrinsics.checkNotNullParameter(r5, "comment");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
