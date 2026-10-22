package com.larus.bot.impl.common.util;

import android.animation.ObjectAnimator;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.larus.bmhome.share.panel.ShareType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j {
    public static final void a(final AppCompatEditText r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setOnTouchListener(new i(r1));
    }

    public static final ObjectAnimator c(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r2, "alpha", new float[]{0.7f, 1.0f, 0.7f});
        if (r3 == null) goto L5;
        r3.setRepeatCount(-1);
    L5:
        if (r3 == null) goto L7;
        r3.setDuration(1000);
    L7:
        if (r3 == null) goto L9;
        r3.start();
    L9:
        return r3;
    }

    public static final StaticLayout b(TextView r9, String r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, ShareType.TEXT);
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 23) goto L8;
        StaticLayout.Builder r12 = StaticLayout.Builder.obtain(r10, 0, r10.length(), r9.getPaint(), RangesKt.coerceAtLeast(0, r11));
        if (r0 < 28) goto L7;
        r12.setUseLineSpacingFromFallbacks(true);
    L7:
        StaticLayout r13 = r12.build();
    L9:
        Intrinsics.checkNotNull(r13);
        return r13;
    L8:
        r13 = new StaticLayout(r10, r9.getPaint(), RangesKt.coerceAtLeast(0, r11), Layout.Alignment.ALIGN_NORMAL, r9.getLineSpacingMultiplier(), r9.getLineSpacingExtra(), r9.getIncludeFontPadding());
        goto L9
    }
}
