package com.ss.android.lark.coremd.utils;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import com.larksuite.framework.utils.UIUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static float d(y9b.a r3) {
        Intrinsics.checkNotNullParameter(r3, "span");
        if ((r3 instanceof y9b.c) == false) goto L5;
        float r4 = r3.a.j;
        Paint r0 = e.c;
        r0.setTypeface(Typeface.MONOSPACE);
        r0.setTextSize(r4);
        return r0.measureText("•") / 2.0f;
    L5:
        String r1 = r3.e();
        float r5 = r3.a.j;
        Paint r2 = e.c;
        r2.setTypeface(Typeface.MONOSPACE);
        r2.setTextSize(r5);
        return r2.measureText(r1);
    }

    public static int b(Context r1, y9b.a r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "span");
        if ((r2 instanceof y9b.b) == false) goto L6;
        return UIUtils.getDimens(r1, 2131167697);
    L6:
        if ((r2 instanceof y9b.c) == true) goto L11;
        return 0;
    L11:
        return UIUtils.getDimens(r1, 2131167699);
    }

    public static int a(Context r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (r2 >= 0) goto L5;
        int r4 = UIUtils.dp2px(r1, 24.0f);
    L7:
        return MathKt.roundToInt(r4 * r3);
    L5:
        r4 = UIUtils.dp2px(r1, r2);
        goto L7
    }

    public static int c(Context r3, y9b.a r4, float r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "span");
        if ((r4 instanceof y9b.c) == false) goto L10;
        Paint r6 = e.c;
        r6.setTypeface(Typeface.MONOSPACE);
        r6.setTextSize(UIUtils.getDimens(r3, 2131167738));
        if (r5 < 0.0f) goto L7;
        int r7 = UIUtils.dp2px(r3, r5);
    L17:
        return MathKt.roundToInt((((r6.measureText("aa") + UIUtils.getDimens(r3, 2131167697)) + r7) - UIUtils.getDimens(r3, 2131167696)) - UIUtils.getDimens(r3, 2131167699));
    L7:
        r7 = UIUtils.getDimens(r3, 2131167697);
        goto L17
    L10:
        if ((r4 instanceof y9b.b) == true) goto L12;
        return 0;
    L12:
        if (r5 <= 0.0f) goto L19;
        return UIUtils.dp2px(r3, r5);
    L19:
        return UIUtils.getDimens(r3, 2131167697);
    }
}
