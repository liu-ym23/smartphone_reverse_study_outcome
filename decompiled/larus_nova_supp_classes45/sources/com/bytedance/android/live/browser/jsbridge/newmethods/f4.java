package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.UtilsKt;
import com.google.gson.JsonObject;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f4<T, R> implements Function {
    public static final f4 a = null;

    static {
        a = new f4();
    }

    public f4() {
    }

    public final Object apply(Object r2) {
        JsonObject r3 = (JsonObject) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return UtilsKt.h(r3);
    }
}
