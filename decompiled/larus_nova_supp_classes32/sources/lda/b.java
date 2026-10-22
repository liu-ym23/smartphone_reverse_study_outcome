package lda;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.assistant.cocreationreview.c4;
import com.obric.assistant.cocreationreview.j5;
import com.obric.assistant.cocreationreview.k5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements k5<b0> {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // com.obric.assistant.cocreationreview.k5
    public final View a(j5 r8, com.obric.assistant.cocreationreview.a r9) {
        b0 r10 = (b0) r9;
        Intrinsics.checkNotNullParameter(r8, "buildContext");
        Intrinsics.checkNotNullParameter(r10, "record");
        Context r11 = r8.getContext();
        LinearLayout r0 = c4.e(r11);
        r0.setGravity(16);
        r0.setPadding(c4.c(r11, 12), c4.c(r11, 12), c4.c(r11, 12), c4.c(r11, 12));
        r0.setBackground(c4.h(r11, -262657, 16, -1512723, 1));
        r0.addView(c4.f(r11, "豆包回复", 12.5f, e.a.e, 1));
        TextView r12 = c4.f(r11, r10.f, 13.5f, -13418155, 0);
        r12.setMaxLines(5);
        r12.setEllipsize(TextUtils.TruncateAt.END);
        r12.setPadding(c4.c(r11, 12), 0, c4.c(r11, 8), 0);
        r0.addView(r12, new LinearLayout.LayoutParams(0, -2, 1.0f));
        return r0;
    }
}
