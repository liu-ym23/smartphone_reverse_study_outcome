package gw8;

import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public static final int a(Spanned r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Object[] r0 = r8.getSpans(0, r8.length(), LeadingMarginSpan.class);
        ArrayList r1 = new ArrayList();
        int r3 = r0.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L13;
        Object r5 = r0[r4];
        LeadingMarginSpan r6 = (LeadingMarginSpan) r5;
        if (r8.getSpanStart(r6) <= r9) goto L7;
    L9:
        boolean r7 = false;
    L10:
        if (r7 == false) goto L12;
        r1.add(r5);
    L12:
        r4 = r4 + 1;
        goto L3
    L7:
        if (r9 > r8.getSpanEnd(r6)) goto L9;
        r7 = true;
        goto L10
    L13:
        Iterator r10 = r1.iterator();
        int r11 = 0;
    L15:
        if (r10.hasNext() == false) goto L17;
        r11 = r11 + ((LeadingMarginSpan) r10.next()).getLeadingMargin(false);
        goto L15
    L17:
        return r11;
    }
}
