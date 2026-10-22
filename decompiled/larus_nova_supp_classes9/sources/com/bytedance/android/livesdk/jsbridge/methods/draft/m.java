package com.bytedance.android.livesdk.jsbridge.methods.draft;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m {
    public static final String a(Object r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$toJson");
        return GsonProtectorUtils.toJson(new Gson(), r1);
    }
}
