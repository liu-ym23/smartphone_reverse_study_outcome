package com.bytedance.ai.uiu;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final String a(String r13) {
        Intrinsics.checkNotNullParameter(r13, "jsonString");
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r13, "\\", "\\\\", false, 4, null), "\"", "\\\"", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null), "\t", "\\t", false, 4, null);
    }
}
