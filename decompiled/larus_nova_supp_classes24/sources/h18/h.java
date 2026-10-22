package h18;

import android.view.View;
import androidx.core.view.ViewCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h {
    public static final boolean a(View r1) {
        Intrinsics.checkNotNullParameter(r1, "view");
        if (ViewCompat.getLayoutDirection(r1) == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
