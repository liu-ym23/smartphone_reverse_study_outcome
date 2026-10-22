package com.larus.bmhome.tipoff;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class TipOffApi {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Object a(String r3, Continuation r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new TipOffApi$getReportReasons$2(r3, null), r4);
    }
}
