package hda;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.assistant.cocreationreview.c4;
import com.obric.assistant.cocreationreview.j5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public c() {
    }

    public static View a(j5 r8, e1 r9) {
        Intrinsics.checkNotNullParameter(r8, "buildContext");
        Intrinsics.checkNotNullParameter(r9, "uiModel");
        Context r10 = r8.getContext();
        LinearLayout r6 = c4.k(r10);
        View r1 = new View(r10);
        r1.setBackgroundColor(-1512723);
        r1.setMinimumHeight(c4.c(r10, 1));
        c4.b(r6, r1, c4.c(r10, 1), 0, c4.c(r10, 8), 4);
        int r0 = b1.a;
        String r2 = r9.e;
        if (StringsKt.isBlank(r2) == false) goto L5;
        r2 = r9.d;
    L5:
        TextView r3 = c4.f(r10, b1.a(r2), 13.5f, -11908796, 0);
        r3.setMaxLines(RangesKt.coerceAtLeast(3, 1));
        r3.setEllipsize(TextUtils.TruncateAt.END);
        r3.setLineSpacing(c4.c(r10, 2), 1.0f);
        c4.b(r6, r3, 0, 0, 0, 14);
        return r6;
    }
}
