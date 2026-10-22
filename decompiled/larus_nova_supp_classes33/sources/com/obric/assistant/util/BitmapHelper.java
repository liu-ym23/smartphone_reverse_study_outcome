package com.obric.assistant.util;

import android.content.Context;
import android.graphics.Bitmap;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class BitmapHelper {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Object a(Context r3, Bitmap r4, String r5, Continuation r6) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BitmapHelper$saveBitMapToFile$2(r3, r5, r4, null), r6);
    }
}
