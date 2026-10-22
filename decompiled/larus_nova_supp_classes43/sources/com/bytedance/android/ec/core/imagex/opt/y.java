package com.bytedance.android.ec.core.imagex.opt;

import com.facebook.imagepipeline.common.Priority;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class y {
    public static final Priority a(com.bytedance.android.shopping.api.image.d0 r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$priorityEnum");
        Integer r11 = r10.a();
        if (r11 != null) goto L6;
    L8:
        if (r11 != null) goto L11;
    L13:
        if (r11 != null) goto L16;
    L18:
        if (r11 == null) goto L24;
        if (r11.intValue() != 3) goto L24;
        return Priority.IMMEDIATE;
    L24:
        return Priority.MEDIUM;
    L16:
        if (r11.intValue() != 2) goto L18;
        return Priority.HIGH;
    L11:
        if (r11.intValue() != 1) goto L13;
        return Priority.MEDIUM;
    L6:
        if (r11.intValue() != 0) goto L8;
        return Priority.LOW;
    }
}
