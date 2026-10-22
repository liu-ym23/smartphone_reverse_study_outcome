package uzb;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements OnApplyWindowInsetsListener {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View r2, WindowInsetsCompat r3) {
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        Intrinsics.checkNotNullParameter(r3, "insets");
        this.a.a(r3);
        return r3;
    }
}
