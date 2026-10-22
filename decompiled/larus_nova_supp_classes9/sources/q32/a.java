package q32;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final void a(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$setWidth");
        r1.getLayoutParams().width = r2;
        r1.requestLayout();
    }
}
