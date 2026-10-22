package j98;

import com.larus.avlink.env.diary.feedback.model.DiaryFeedbackToastType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g {
    public final int a;
    public final DiaryFeedbackToastType b;
    public final long c;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof g) == true) goto L8;
        return false;
    L8:
        g r9 = (g) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b.hashCode()) * 31;
        long r1 = this.c;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "DiaryFeedbackToastEffect(messageRes=" + this.a + ", toastType=" + this.b + ", effectId=" + this.c + ')';
    }

    public g(int r4, DiaryFeedbackToastType r5) {
        long r0 = System.nanoTime();
        Intrinsics.checkNotNullParameter(r5, "toastType");
        this.a = r4;
        this.b = r5;
        this.c = r0;
    }
}
