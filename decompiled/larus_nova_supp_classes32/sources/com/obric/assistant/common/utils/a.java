package com.obric.assistant.common.utils;

import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static Object a(List r8, Continuation r9) {
        if (r8.isEmpty() == true) goto L10;
        Object r10 = BuildersKt.withContext(Dispatchers.getMain(), new ActivityUtilsKt$waitUntilDestroy$2(2000, r8, true, null), r9);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r10;
    L9:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }
}
