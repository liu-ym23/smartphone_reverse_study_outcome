package wvb;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f implements OnApplyWindowInsetsListener {
    public final /* synthetic */ g a;

    public f(g r1) {
        this.a = r1;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View r3, WindowInsetsCompat r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "insets");
        r4.getInsets(WindowInsetsCompat.Type.statusBars());
        this.a.a.getClass();
        Insets r5 = r4.getInsets(WindowInsetsCompat.Type.navigationBars());
        int r0 = 0;
        if (r5 == null) goto L5;
        int r6 = r5.bottom;
    L6:
        this.a.a.getClass();
        Insets r1 = r4.getInsets(WindowInsetsCompat.Type.ime());
        if (r1 == null) goto L9;
        r0 = r1.bottom;
    L9:
        int r2 = r0 - r6;
        Function1<? super Integer, Unit> r7 = this.a.a.a;
        if (r7 == null) goto L12;
        r7.invoke(Integer.valueOf(r2));
    L12:
        r4.isVisible(WindowInsetsCompat.Type.ime());
        this.a.a.getClass();
        return WindowInsetsCompat.CONSUMED;
    L5:
        r6 = 0;
        goto L6
    }
}
