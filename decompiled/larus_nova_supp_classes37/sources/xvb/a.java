package xvb;

import androidx.core.view.WindowInsetsCompat;
import bwb.b;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(WindowInsetsCompat r4) {
        if (r4 != null) goto L7;
        int r5 = b.a;
        b.d(MmUiLogScene.FOUNDATION, "getNavigationAvoidanceBottom", "insets=null", null);
        return 0;
    L7:
        if (r4.getInsets(WindowInsetsCompat.Type.tappableElement()).bottom > 0) goto L10;
        return 0;
    L10:
        return RangesKt.coerceAtLeast(r4.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom, 0);
    }
}
