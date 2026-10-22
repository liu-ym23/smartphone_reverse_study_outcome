package com.larus.voice_setting.voice.utils;

import android.content.Context;
import java.io.File;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final Object a(Context r4, File r5, Continuation r6) {
        Object r7 = BuildersKt.withContext(Dispatchers.getIO(), new CommonExtKt$copyAssetsToStorage$2(r5, r4, "audio_metrics_v1.4.model", null), r6);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r7;
    L6:
        return Unit.INSTANCE;
    }
}
