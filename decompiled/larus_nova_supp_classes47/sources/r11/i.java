package r11;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i {
    public static final boolean a(h r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$isLiveCoreCapEnable");
        if (r3.getEnable() == true) goto L5;
        return false;
    L5:
        if (r3.F7() == false) goto L13;
        float r2 = 0;
        if (r3.z8() > r2) goto L9;
        return false;
    L9:
        if (r3.q6() <= r2) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    public static final boolean b(h.b r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isValid");
        if (r1.getW() > 0) goto L5;
    L9:
        return false;
    L5:
        if (r1.getH() <= 0) goto L9;
        if (r1.j() <= 0) goto L9;
        return true;
    }
}
