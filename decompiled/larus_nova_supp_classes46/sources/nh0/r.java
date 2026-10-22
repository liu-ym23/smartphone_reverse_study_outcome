package nh0;

import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.TrackerUpdateType;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r {
    public final TrackerUpdateType a;
    public final Map<String, Map<String, String>> b;
    public final List<String> c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof r) == false) goto L12;
        r r4 = (r) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
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
        TrackerUpdateType r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, Map<String, String>> r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<String> r7 = this.c;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "TrackerExtraObject(type=" + this.a + ", addExtra=" + this.b + ", removeExtra=" + this.c + ")";
    }

    public final TrackerUpdateType getType() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r(TrackerUpdateType r2, Map<String, ? extends Map<String, String>> r3, List<String> r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
