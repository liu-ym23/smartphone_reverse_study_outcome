package pc8;

import com.larus.bmhome.chat.bubble.floating.BubbleBannerEnterTrigger;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerRenderPart;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public static final /* synthetic */ int d = 0;
    public final String a;
    public final Set<BubbleBannerEnterTrigger> b;
    public final Set<BubbleBannerRenderPart> c;

    public static final class a {
        public static f a(String r6) {
            if (r6 != null) goto L5;
        L7:
            r6 = null;
        L9:
            if (r6 != null) goto L11;
            Set r4 = SetsKt.setOf(BubbleBannerEnterTrigger.CONTAINER_READY);
        L12:
            if (r6 != null) goto L14;
            Set r0 = SetsKt.setOf(BubbleBannerRenderPart.CONTENT);
        L16:
            return new f(r6, r4, r0);
        L14:
            r0 = SetsKt.setOf(new BubbleBannerRenderPart[]{BubbleBannerRenderPart.CONTENT, BubbleBannerRenderPart.SPACER});
            goto L16
        L11:
            r4 = SetsKt.setOf(new BubbleBannerEnterTrigger[]{BubbleBannerEnterTrigger.CONTAINER_READY, BubbleBannerEnterTrigger.SPACER_READY});
            goto L12
        L5:
            if ((!StringsKt.isBlank(r6)) == false) goto L7;
            goto L7
        }
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((r1 * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public final String toString() {
        return "BubbleBannerRenderPlan(anchorMessageId=" + this.a + ", enterTriggers=" + this.b + ", renderParts=" + this.c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(String r2, Set<? extends BubbleBannerEnterTrigger> r3, Set<? extends BubbleBannerRenderPart> r4) {
        Intrinsics.checkNotNullParameter(r3, "enterTriggers");
        Intrinsics.checkNotNullParameter(r4, "renderParts");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
