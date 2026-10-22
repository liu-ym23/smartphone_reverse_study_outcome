package i01;

import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarButton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements h01.c {
    public RevToolbarButton a;

    public b() {
    }

    @Override // h01.c
    public final void a(RevToolbarButton r2) {
        Intrinsics.checkNotNullParameter(r2, "button");
        this.a = r2;
    }
}
