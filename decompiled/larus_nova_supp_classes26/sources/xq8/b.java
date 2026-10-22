package xq8;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final boolean a(Fragment r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Fragment r2 = r1.getParentFragment();
    L3:
        if (r2 == null) goto L9;
        if ((r2 instanceof a) == true) goto L6;
        r2 = r2.getParentFragment();
        goto L3
    L6:
        return true;
    L9:
        return false;
    }
}
