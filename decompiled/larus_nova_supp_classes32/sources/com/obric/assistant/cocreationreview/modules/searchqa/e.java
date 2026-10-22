package com.obric.assistant.cocreationreview.modules.searchqa;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.assistant.cocreationreview.a;
import com.obric.assistant.cocreationreview.c4;
import com.obric.assistant.cocreationreview.j5;
import com.obric.assistant.cocreationreview.k5;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e implements k5<c0> {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    @Override // com.obric.assistant.cocreationreview.k5
    public final View a(j5 r22, a r23) {
        c0 r0 = (c0) r23;
        Intrinsics.checkNotNullParameter(r22, "buildContext");
        Intrinsics.checkNotNullParameter(r0, "record");
        final Context r1 = r22.getContext();
        LinearLayout r8 = c4.k(r1);
        LinearLayout r9 = c4.k(r1);
        View r3 = new View(r1);
        r3.setBackgroundColor(-1512723);
        r3.setMinimumHeight(c4.c(r1, 1));
        c4.b(r9, r3, c4.c(r1, 1), 0, c4.c(r1, 8), 4);
        if ((!r0.j.isEmpty()) == false) goto L35;
        List<s> r2 = r0.j;
        LinearLayout r4 = c4.k(r1);
        c4.b(r4, c4.f(r1, "搜到的本地资料", 11.0f, h.a.e, 1), 0, 0, c4.c(r1, 6), 6);
        Iterator r5 = CollectionsKt.take(r2, 3).iterator();
        int r6 = 0;
    L6:
        if (r5.hasNext() == false) goto L34;
        Object r7 = r5.next();
        int r10 = r6 + 1;
        if (r6 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        final s r11 = (s) r7;
        LinearLayout r12 = c4.k(r1);
        r12.setPadding(c4.c(r1, 10), c4.c(r1, 8), c4.c(r1, 10), c4.c(r1, 8));
        r12.setBackground(c4.h(r1, -263172, 9, -1512723, 1));
        if (f.b(r11) == false) goto L13;
        r12.setClickable(true);
        r12.setOnClickListener(new b(r11));
    L27:
        if (f.c(r11) == false) goto L29;
        int r13 = -5721662;
    L30:
        c4.b(r12, c4.f(r1, r10 + ". " + r11.a, 12.0f, r13, 1), 0, 0, 0, 14);
        if (f.b(r11) == false) goto L33;
        c4.b(r12, f.g(r1, r11), 0, c4.c(r1, 8), 0, 10);
    L33:
        c4.b(r4, r12, 0, 0, c4.c(r1, 7), 6);
        r6 = r10;
        goto L6
    L29:
        r13 = -15656921;
        goto L30
    L13:
        Intrinsics.checkNotNullParameter(r11, "<this>");
        String r14 = r11.j;
        if (r14 != null) goto L16;
    L19:
        boolean r15 = true;
    L21:
        if ((!r15) == false) goto L24;
        r12.setClickable(true);
        r12.setOnClickListener(new c(r1, r11));
        goto L27
    L24:
        if (f.a(r11) == false) goto L27;
        r12.setClickable(true);
        r12.setOnClickListener(new d(r11));
        goto L27
    L16:
        if (StringsKt.isBlank(r14) == true) goto L19;
        r15 = false;
        goto L21
    L34:
        c4.b(r9, r4, 0, 0, c4.c(r1, 4), 6);
    L35:
        LinearLayout r16 = c4.e(r1);
        r16.setGravity(16);
        r16.setPadding(c4.c(r1, 12), c4.c(r1, 12), c4.c(r1, 12), c4.c(r1, 12));
        r16.setBackground(c4.h(r1, -262657, 16, -1512723, 1));
        r16.addView(c4.f(r1, "豆包回复", 13.0f, h.a.e, 1));
        TextView r17 = c4.f(r1, r0.i, 14.0f, -11908796, 1);
        r17.setMaxLines(5);
        r17.setEllipsize(TextUtils.TruncateAt.END);
        r17.setPadding(c4.c(r1, 12), 0, c4.c(r1, 8), 0);
        r16.addView(r17, new LinearLayout.LayoutParams(0, -2, 1.0f));
        c4.b(r9, r16, 0, 0, c4.c(r1, 4), 6);
        c4.b(r8, r9, 0, 0, 0, 14);
        return r8;
    }
}
