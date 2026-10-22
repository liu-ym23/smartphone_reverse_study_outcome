package i72;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(e r10) {
        Intrinsics.checkNotNullParameter(r10, "uiContext");
        int r0 = r10.pT();
        int r1 = r10.WN();
        if (r1 >= ((((double) r0) * 0.2d) + ((((double) s1.y()) / 4.0d) * ((double) 3)))) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L8;
        return false;
    L8:
        if (r10.g1() == false) goto L13;
        if (r1 <= 0) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L5:
        r2 = false;
        goto L6
    }
}
