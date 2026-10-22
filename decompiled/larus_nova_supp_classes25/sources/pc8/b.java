package pc8;

import com.larus.bmhome.chat.bubble.floating.BubbleBannerRenderPart;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public final Set<BubbleBannerRenderPart> a;
    public final Set<BubbleBannerRenderPart> b;

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
        return "BubbleBannerExitCompletion(requiredParts=" + this.a + ", finishedParts=" + this.b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Set<? extends BubbleBannerRenderPart> r2, Set<? extends BubbleBannerRenderPart> r3) {
        Intrinsics.checkNotNullParameter(r2, "requiredParts");
        Intrinsics.checkNotNullParameter(r3, "finishedParts");
        this.a = r2;
        this.b = r3;
    }
}
