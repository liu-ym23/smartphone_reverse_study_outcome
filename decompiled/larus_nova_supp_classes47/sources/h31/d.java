package h31;

import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public final PlayMode a;
    public final int b;
    public final List<String> c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L12;
        d r4 = (d) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        PlayMode r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + this.b) * 31;
        List<String> r4 = this.c;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "FirstPkData(playMode=" + this.a + ", anchorListSize=" + this.b + ", selectAnchorIds=" + this.c + ")";
    }

    public d(PlayMode r2, int r3, List<String> r4) {
        Intrinsics.checkNotNullParameter(r2, "playMode");
        Intrinsics.checkNotNullParameter(r4, "selectAnchorIds");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
