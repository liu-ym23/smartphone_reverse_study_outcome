package i3b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.blueprint.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static final void a(View r2, g r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "ctx");
        b r0 = (b) r3.c.a(b.class);
        if (r0 != null) goto L5;
        return;
    L5:
        int r5 = UIUtils.dp2px(r3.getContext(), r0.f(r4));
        ViewGroup.LayoutParams r6 = r2.getLayoutParams();
        r6.width = r5;
        r6.height = r5;
        r2.setLayoutParams(r6);
    }

    public static final void b(TextView r1, g r2, float r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "ctx");
        b r4 = (b) r2.c.a(b.class);
        if (r4 != null) goto L5;
        return;
    L5:
        r1.setTextSize(1, r4.f(r3));
    }
}
