package com.bytedance.android.annie.util;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.view.View;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r10, View r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "grayView");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(UriProtector.parse(r10), "gray_enable"), "1") == false) goto L7;
        if (r11 == null) goto L7;
        Paint r12 = new Paint();     // Catch: Throwable -> L9
        ColorMatrix r1 = new ColorMatrix();     // Catch: Throwable -> L9
        r1.setSaturation(0.0f);     // Catch: Throwable -> L9
        r12.setColorFilter(new ColorMatrixColorFilter(r1));     // Catch: Throwable -> L9
        r11.setLayerType(2, r12);     // Catch: Throwable -> L9
    L7:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
