package zz7;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final void a(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r3 = b.g(r1.getContext(), r2);
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        r0.width = r3;
        r0.height = r3;
        r1.setLayoutParams(r0);
    }

    public static final void c(TextView r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setTextSize(0, b.h(r1.getContext(), r2));
    }

    public static final void d(TextView r1, LarkFont r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "larkFont");
        r1.setTextSize(0, b.i(r1.getContext(), r2));
    }

    public static final void b(View r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r4 = b.g(r1.getContext(), r2);
        int r5 = b.g(r1.getContext(), r3);
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        r0.width = r4;
        r0.height = r5;
        r1.setLayoutParams(r0);
    }
}
