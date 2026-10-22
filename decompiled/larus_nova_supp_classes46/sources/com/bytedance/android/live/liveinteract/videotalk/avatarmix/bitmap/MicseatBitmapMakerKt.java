package com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap;

import android.graphics.Canvas;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MicseatBitmapMakerKt {
    public static final void a(final View r3, Canvas r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$drawToCanvas");
        Intrinsics.checkNotNullParameter(r4, "canvas");
        float r0 = -r3.getScrollX();
        float r1 = -r3.getScrollY();
        Function1<Canvas, Unit> r2 = new MicseatBitmapMakerKt$drawToCanvas$1(r3);
        Intrinsics.checkNotNullParameter(r4, "$this$withTranslation");
        Intrinsics.checkNotNullParameter(r2, "block");
        int r5 = r4.save();
        r4.translate(r0, r1);
        r2.invoke(r4);     // Catch: Throwable -> L6
        r4.restoreToCount(r5);
        return;
    L6:
        th = move-exception;
        r4.restoreToCount(r5);
        throw th;
    }
}
