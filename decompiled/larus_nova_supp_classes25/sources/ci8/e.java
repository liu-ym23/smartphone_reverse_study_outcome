package ci8;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public static final d a(Fragment r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Fragment r2 = r1.getParentFragment();
    L3:
        if (r2 == null) goto L9;
        if ((r2 instanceof d) == true) goto L7;
        r2 = r2.getParentFragment();
        goto L3
    L7:
        return (d) r2;
    L9:
        return null;
    }

    public static final boolean b(Fragment r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Fragment r2 = r1.getParentFragment();
    L3:
        if (r2 == null) goto L9;
        if ((r2 instanceof d) == true) goto L6;
        r2 = r2.getParentFragment();
        goto L3
    L6:
        return true;
    L9:
        return false;
    }
}
