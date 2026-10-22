package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o1 {
    public static final void a(TextView r6, String r7, List<n1> r8) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "value");
        Intrinsics.checkNotNullParameter(r8, "ranges");
        if (r8.isEmpty() == false) goto L6;
        r6.setText(r7);
        return;
    L6:
        SpannableString r0 = new SpannableString(r7);
        int r1 = ContextCompat.getColor(r6.getContext(), v19.c.b(2130972123, r6.getContext(), 2131103203));
        Iterator<T> r9 = r8.iterator();
    L8:
        if (r9.hasNext() == false) goto L16;
        n1 r2 = (n1) r9.next();
        int r3 = r2.a;
        if (r3 < 0) goto L8;
        int r4 = r2.b;
        if (r3 >= r4) goto L8;
        if (r4 > r7.length()) goto L8;
        r0.setSpan(new ForegroundColorSpan(r1), r2.a, r2.b, 33);
        goto L8
    L16:
        r6.setText(r0);
    }

    public static final void b(TextView r10, String r11, List<String> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "value");
        Intrinsics.checkNotNullParameter(r12, "keywords");
        ArrayList r0 = new ArrayList();
        Iterator<T> r13 = r12.iterator();
    L3:
        boolean r2 = false;
        if (r13.hasNext() == false) goto L14;
        String r1 = StringsKt.trim((String) r13.next()).toString();
        if (r1.length() <= 0) goto L8;
        r2 = true;
    L8:
        if (r2 == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L3;
        r0.add(r1);
        goto L3
    L14:
        if (r0.isEmpty() == false) goto L16;
    L15:
        r2 = true;
    L21:
        if (r2 == false) goto L24;
        r10.setText(r11);
        return;
    L24:
        SpannableString r14 = new SpannableString(r11);
        int r3 = ContextCompat.getColor(r10.getContext(), v19.c.b(2130972123, r10.getContext(), 2131103203));
        Iterator r4 = r0.iterator();
    L26:
        if (r4.hasNext() == false) goto L30;
        String r5 = (String) r4.next();
        int r6 = StringsKt.indexOf$default(r11, r5, 0, true, 2, null);
    L28:
        if (r6 < 0) goto L26;
        int r7 = r5.length() + r6;
        r14.setSpan(new ForegroundColorSpan(r3), r6, r7, 33);
        r6 = StringsKt.indexOf(r11, r5, r7, true);
        goto L28
    L30:
        r10.setText(r14);
        return;
    L16:
        Iterator r15 = r0.iterator();
    L18:
        if (r15.hasNext() == false) goto L15;
        if (StringsKt.contains(r11, (String) r15.next(), true) == false) goto L18;
        goto L21
    }
}
