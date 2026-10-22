package cwb;

import android.view.View;
import android.widget.FrameLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements OnApplyWindowInsetsListener {
    public final /* synthetic */ FrameLayout a;

    public a(FrameLayout r1) {
        this.a = r1;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View r5, WindowInsetsCompat r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "insets");
        Insets r0 = r6.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        r5.setPadding(r0.left, r0.top, r0.right, r6.getInsets(WindowInsetsCompat.Type.ime()).bottom);
        FrameLayout r7 = this.a;
        r7.setPadding(r7.getPaddingLeft(), this.a.getPaddingTop(), this.a.getPaddingRight(), xvb.a.a(r6));
        return r6;
    }
}
