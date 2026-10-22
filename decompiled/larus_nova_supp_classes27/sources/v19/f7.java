package v19;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class f7 implements OnApplyWindowInsetsListener {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ f7(com.larus.uaigc.createpage.bussiness.remove.b r1) {
        this.a = r1;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View r3, WindowInsetsCompat r4) {
        Function1 r0 = this.a;
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        Intrinsics.checkNotNullParameter(r4, "insets");
        r0.invoke(r4.getInsets(WindowInsetsCompat.Type.navigationBars()));
        return r4;
    }
}
