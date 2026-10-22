package com.bytedance.android.ec.core.imagex.common;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public static /* synthetic */ void a(boolean r10, boolean r11, Function0 r12, int r13) {
        AsyncWorker r0 = AsyncWorker.d;
        if ((r13 & 1) == 0) goto L6;
        r10 = false;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r11 = false;
    L8:
        r0.b(r10, r11, r12);
    }
}
