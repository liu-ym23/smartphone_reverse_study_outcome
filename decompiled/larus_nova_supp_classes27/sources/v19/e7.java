package v19;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class e7 implements OnApplyWindowInsetsListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ Function1 b;

    public /* synthetic */ e7(View r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View r4, WindowInsetsCompat r5) {
        View r0 = this.a;
        Function1 r1 = this.b;
        Intrinsics.checkNotNullParameter(r4, "<unused var>");
        Intrinsics.checkNotNullParameter(r5, "insets");
        WindowInsetsCompat r6 = ViewCompat.getRootWindowInsets(r0);
        if (r6 == null) goto L7;
        Insets r7 = r6.getInsets(WindowInsetsCompat.Type.statusBars());
        if (r7 == null) goto L7;
        r1.invoke(r7);
    L7:
        return r5;
    }
}
