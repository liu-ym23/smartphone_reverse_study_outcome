package hq9;

import com.larus.platform.model.LarkSocialFeedPresentationMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class r2 {
    public final LarkSocialFeedPresentationMode a;
    public final v2 b;

    public r2() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r2) == true) goto L8;
        return false;
    L8:
        r2 r6 = (r2) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        v2 r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "LarkSocialFeedPresentationState(mode=" + this.a + ", failedFallbackSession=" + this.b + ')';
    }

    public /* synthetic */ r2(int r2) {
        this(LarkSocialFeedPresentationMode.NATIVE, null);
    }

    public r2(LarkSocialFeedPresentationMode r2, v2 r3) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        this.a = r2;
        this.b = r3;
    }
}
