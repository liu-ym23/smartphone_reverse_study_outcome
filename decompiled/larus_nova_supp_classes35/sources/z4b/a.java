package z4b;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.framework.utils.UIUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static int b(Context r1, float r2) {
        if (r2 <= 0.0f) goto L7;
        r2 = UIUtils.dp2px(r1, r2);
    L7:
        return (int) r2;
    }

    public static ConstraintLayout.LayoutParams a(Context r2, float r3, float r4, int r5) {
        ConstraintLayout.LayoutParams r0 = new ConstraintLayout.LayoutParams(b(r2, r3), b(r2, r4));
        float r6 = 0;
        r0.setMargins(b(r2, r6), b(r2, r6), b(r2, r6), b(r2, r5));
        return r0;
    }
}
