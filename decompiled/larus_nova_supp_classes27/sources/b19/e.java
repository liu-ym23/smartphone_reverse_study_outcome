package b19;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class e implements OnApplyWindowInsetsListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ FlowCommonAppCompatActivity b;

    public /* synthetic */ e(View r1, FlowCommonAppCompatActivity r2) {
        this.a = r1;
        this.b = r2;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View r4, WindowInsetsCompat r5) {
        final View r0 = this.a;
        final FlowCommonAppCompatActivity r1 = this.b;
        int r2 = FlowCommonAppCompatActivity.f;
        Intrinsics.checkNotNullParameter(r4, "<unused var>");
        Intrinsics.checkNotNullParameter(r5, "insets");
        final boolean r6 = r5.isVisible(WindowInsetsCompat.Type.ime());
        if (r0 == null) goto L5;
        r0.post(new f(r0, r1, r6));
    L5:
        return r5;
    }
}
