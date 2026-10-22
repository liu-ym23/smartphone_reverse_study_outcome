package vy7;

import android.view.View;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements OnApplyWindowInsetsListener {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final WindowInsetsCompat onApplyWindowInsets(View r4, WindowInsetsCompat r5) {
        Intrinsics.checkNotNullParameter(r4, "v");
        Intrinsics.checkNotNullParameter(r5, "insets");
        if (r5.getDisplayCutout() == null) goto L11;
        DisplayCutoutCompat r6 = r5.getDisplayCutout();
        if (r6 == null) goto L7;
        Integer r7 = Integer.valueOf(r6.getSafeInsetLeft());
    L8:
        if (r7 == null) goto L11;
        r4.setPadding(r7.intValue(), r4.getPaddingTop(), r4.getPaddingRight(), UIHelper.dp2px(16.0f));
        goto L11
    L7:
        r7 = null;
    L11:
        return WindowInsetsCompat.CONSUMED;
    }
}
