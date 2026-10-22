package com.obric.assistant.cocreationreview.modules.proactive;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import com.obric.assistant.cocreationreview.c4;
import com.obric.assistant.cocreationreview.j5;
import com.obric.assistant.cocreationreview.k5;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements k5<q> {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // com.obric.assistant.cocreationreview.k5
    public final View a(j5 r8, com.obric.assistant.cocreationreview.a r9) {
        q r10 = (q) r9;
        Intrinsics.checkNotNullParameter(r8, "buildContext");
        Intrinsics.checkNotNullParameter(r10, "record");
        Context r11 = r8.getContext();
        LinearLayout r6 = c4.k(r11);
        r6.setPadding(0, 0, 0, 0);
        GradientDrawable r1 = new GradientDrawable();
        r1.setColor(0);
        r6.setBackground(r1);
        c4.b(r6, c4.f(r11, r10.l, 14.0f, -15656921, 0), 0, 0, 0, 14);
        Iterator<T> r12 = r10.m.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        c4.b(r6, c.a(r11, (a) r12.next()), 0, c4.c(r11, 8), 0, 10);
        goto L4
    L6:
        return r6;
    }
}
