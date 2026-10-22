package d69;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.setAlpha(0.0f);
        e1.x(r2);
        r2.animate().alpha(1.0f).setDuration(150).setInterpolator(new DecelerateInterpolator()).start();
    }

    public static final void b(View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 == false) goto L5;
        a(r1);
        return;
    L5:
        e1.x(r1);
    }
}
