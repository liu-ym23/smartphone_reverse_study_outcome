package com.bytedance.android.ec.core.utils;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import com.byted.cast.sink.api.IServerListener;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Typeface a(Paint r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "textPaint");
        boolean r12 = true;
        if (Build.VERSION.SDK_INT < 28) goto L12;
        Typeface r0 = r10.getTypeface();
        int r13 = RangesKt.coerceIn(r11, 1, IServerListener.WHAT_BYTELINK_SINK_ERROR);
        Typeface r14 = r10.getTypeface();
        if (r14 != null) goto L7;
    L9:
        r12 = false;
    L27:
        return Typeface.create(r0, r13, r12);
    L7:
        if (r14.getStyle() != 2) goto L9;
    L12:
        if (r11 < 500) goto L18;
        Typeface r1 = r10.getTypeface();
        if (r1 == null) goto L18;
        if (r1.getStyle() != 2) goto L18;
        return Typeface.create(r10.getTypeface(), 3);
    L18:
        if (r11 >= 500) goto L29;
        Typeface r15 = r10.getTypeface();
        if (r15 == null) goto L26;
        if (r15.getStyle() != 2) goto L26;
        return Typeface.create(r10.getTypeface(), 2);
    L26:
        return Typeface.DEFAULT;
    L29:
        return Typeface.create(r10.getTypeface(), 1);
    }

    public static void b(TextView r1, int r10) {
        Intrinsics.checkNotNullParameter(r1, "$this$setWeight");
        r1.setTypeface(a(r1.getPaint(), r10));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }
}
