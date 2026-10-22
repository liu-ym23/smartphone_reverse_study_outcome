package pla;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r4, "context");
        TypedValue r0 = new TypedValue();
        if (r4.getTheme().resolveAttribute(2130973017, r0, true) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L8;
    L11:
        float r5 = r4.getResources().getDimension(2131168001);
    L13:
        return (int) r5;
    L8:
        if (r0.type != 5) goto L11;
        Resources r6 = r4.getResources();
        r5 = r0.getDimension(WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics()));
        goto L13
    }
}
