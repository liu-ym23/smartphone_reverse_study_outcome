package com.obric.assistant.cocreationreview.modules.proactive;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.assistant.cocreationreview.c4;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public static final View a(Context r11, a r12) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r12, "action");
        Intrinsics.checkNotNullParameter(r12, "action");
        if (r12.b == false) goto L5;
        ProactiveActionDisplayState r0 = ProactiveActionDisplayState.ADOPTED;
    L7:
        if (r0 != ProactiveActionDisplayState.ADOPTED) goto L9;
        boolean r1 = true;
    L10:
        LinearLayout r2 = c4.e(r11);
        r2.setGravity(16);
        r2.setPadding(c4.c(r11, 11), c4.c(r11, 10), c4.c(r11, 11), c4.c(r11, 10));
        r2.setMinimumHeight(c4.c(r11, 44));
        r2.setBackground(c4.h(r11, -592141, 14, -1512723, 1));
        if (r1 == false) goto L13;
        TextView r3 = c4.f(r11, "已采纳", 11.5f, -1, 1);
        r3.setGravity(17);
        r3.setPadding(c4.c(r11, 10), c4.c(r11, 4), c4.c(r11, 10), c4.c(r11, 4));
        r3.setBackground(c4.h(r11, -14540254, 12, 0, 0));
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(-2, -2);
        r6.setMargins(0, 0, c4.c(r11, 10), 0);
        Unit r7 = Unit.INSTANCE;
        r2.addView(r3, r6);
    L13:
        TextView r13 = c4.f(r11, r12.a, 12.5f, -13946048, 1);
        r13.setGravity(16);
        r2.addView(r13, new LinearLayout.LayoutParams(0, -2, 1.0f));
        return r2;
    L9:
        r1 = false;
        goto L10
    L5:
        r0 = ProactiveActionDisplayState.DEFAULT;
        goto L7
    }
}
