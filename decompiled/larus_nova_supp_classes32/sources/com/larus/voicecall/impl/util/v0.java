package com.larus.voicecall.impl.util;

import android.graphics.BitmapFactory;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import ic8.m0;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class v0 {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new u0());
    }

    public static final Pair<Integer, Integer> a(x3a.a r5) {
        float r0 = r5.c * 1.0f;
        float r6 = r5.b;
        float r1 = r0 / r6;
        float r7 = Math.min(((r6 * 1.0f) * 286) / 390, ((Number) a.getValue()).floatValue());
        if (r1 <= 5.0f) goto L7;
        FLogger.a.d("RealtimeSubtitleImageHelper", "generatePhotoWH h:w=[5:1] maxLimit=" + r7);
        return new Pair(Integer.valueOf((int) (r7 / 5.0f)), Integer.valueOf((int) r7));
    L7:
        if (r1 >= 0.2f) goto L11;
        FLogger.a.d("RealtimeSubtitleImageHelper", "generatePhotoWH h:w=[1:5] ");
        return new Pair(Integer.valueOf((int) r7), Integer.valueOf((int) (r7 / 5.0f)));
    L11:
        if (r1 >= 1.0f) goto L13;
        FLogger.a.d("RealtimeSubtitleImageHelper", "generatePhotoWH h:w=[" + r1 + ":1] ");
        return new Pair(Integer.valueOf((int) r7), Integer.valueOf((int) (r1 * r7)));
    L13:
        return new Pair(Integer.valueOf((int) (r7 / r1)), Integer.valueOf((int) r7));
    }

    public static final x3a.a b(m0 r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        String r0 = r12.e;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        BitmapFactory.Options r2 = new BitmapFactory.Options();     // Catch: Throwable -> L22
        r2.inJustDecodeBounds = true;     // Catch: Throwable -> L22
        BitmapFactory.decodeFile(r12.e, r2);     // Catch: Throwable -> L22
        int r4 = r2.outWidth;     // Catch: Throwable -> L22
        int r5 = r2.outHeight;     // Catch: Throwable -> L22
        String r3 = r12.e;     // Catch: Throwable -> L22
        String r6 = NameKeys.UnloadStrategy_No_Strategy;
        if (r3 != null) goto L16;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L16:
        int r7 = StringsKt.lastIndexOf$default(r3, ".", 0, false, 6, null);     // Catch: Throwable -> L22
        if (r7 == (-1)) goto L20;
        r6 = r3.substring(r7);     // Catch: Throwable -> L22
    L20:
        x3a.a r8 = new x3a.a(r12, r4, r5, r13, UUID.randomUUID() + r6);     // Catch: Throwable -> L22
        r8.h = a(r8);     // Catch: Throwable -> L22
        return r8;
    L22:
        th = move-exception;
        FLogger.a.e("RealtimeSubtitleImageHelper", "ProcessFileInfo.wrap() err=" + th);
        return new x3a.a(r12, r13);
    L11:
        return new x3a.a(r12, r13);
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }
}
