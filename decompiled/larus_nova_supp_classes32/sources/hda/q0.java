package hda;

import com.obric.assistant.cocreationreview.modules.memory.MemoryDataReviewModuleKey;
import com.obric.assistant.cocreationreview.modules.memory.MemoryReviewFeedbackState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q0 {
    public final String a;
    public final MemoryDataReviewModuleKey b;
    public final String c;
    public final String d;
    public final String e;
    public final MemoryReviewFeedbackState f;
    public final String g;
    public final long h;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof q0) == true) goto L8;
        return false;
    L8:
        q0 r9 = (q0) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
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
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((r4 + r6) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        String r8 = this.g;
        if (r8 == null) goto L14;
        r2 = r8.hashCode();
    L14:
        long r9 = this.h;
        return ((r7 + r2) * 31) + ((int) (r9 ^ (r9 >>> 32)));
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MemoryReviewRecordDto(recordId=" + this.a + ", module=" + this.b + ", title=" + this.c + ", summary=" + this.d + ", cardPayloadJson=" + this.e + ", feedbackState=" + this.f + ", traceJson=" + this.g + ", updateTimeMillis=" + this.h + ')';
    }

    public q0(String r2, MemoryDataReviewModuleKey r3, String r4, String r5, String r6, MemoryReviewFeedbackState r7, String r8, long r9) {
        Intrinsics.checkNotNullParameter(r2, "recordId");
        Intrinsics.checkNotNullParameter(r3, "module");
        Intrinsics.checkNotNullParameter(r6, "cardPayloadJson");
        Intrinsics.checkNotNullParameter(r7, "feedbackState");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
