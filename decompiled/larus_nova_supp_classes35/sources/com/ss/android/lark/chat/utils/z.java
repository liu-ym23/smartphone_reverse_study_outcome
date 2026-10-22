package com.ss.android.lark.chat.utils;

import android.content.Context;
import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class z {
    public static final void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        KeyboardUtils.hideKeyboard(r2);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.e("KeyboardUtils", "tryHideKeyboard err", th);
    }
}
