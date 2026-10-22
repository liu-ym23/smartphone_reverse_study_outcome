package o51;

import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public static final String a(e r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$focusLinkerID");
        if ((r1 instanceof e.d) == false) goto L6;
        return ((e.d) r1).f;
    L6:
        if ((r1 instanceof e.c) == false) goto L9;
        return ((e.c) r1).f;
    L9:
        if ((r1 instanceof e.C0283e) == true) goto L15;
        return null;
    L15:
        return ((e.C0283e) r1).g;
    }

    public static final String b(e r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$focusUID");
        if ((r1 instanceof e.d) == false) goto L6;
        return ((e.d) r1).e;
    L6:
        if ((r1 instanceof e.c) == false) goto L9;
        return ((e.c) r1).e;
    L9:
        if ((r1 instanceof e.C0283e) == true) goto L15;
        return null;
    L15:
        return ((e.C0283e) r1).f;
    }

    public static final UILayout c(e r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$toCompactUILayout");
        if ((r1 instanceof e.f) == false) goto L6;
        return UILayout.Normal;
    L6:
        if ((r1 instanceof e.c) == false) goto L9;
        return UILayout.Enlarge;
    L9:
        if ((r1 instanceof e.d) == true) goto L15;
        if ((r1 instanceof e.C0283e) == true) goto L15;
        return UILayout.Normal;
    L15:
        return UILayout.FULL;
    }
}
