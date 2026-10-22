package o08;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final FrameLayout a;
    public View b;

    public final void b() {
        this.a.removeAllViews();
    }

    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.b = r2;
        this.a.addView(r2);
    }

    public a(Context r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "childView");
        FrameLayout r0 = new FrameLayout(r3);
        this.a = r0;
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.b = r4;
        a(r4);
    }
}
