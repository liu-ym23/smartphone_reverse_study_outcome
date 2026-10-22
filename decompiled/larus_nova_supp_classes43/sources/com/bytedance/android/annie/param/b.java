package com.bytedance.android.annie.param;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Function0 r1) {
        Intrinsics.checkNotNullParameter(r1, "block");
        if (j.b.b() == true) goto L6;
        r1.invoke();
        return;
    }

    public static Map b(Object r1) {
        if (r1 == null) goto L11;
        if ((r1 instanceof k) == false) goto L11;
        JsonObject r10 = new Gson().toJsonTree(r1);     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.google.gson.JsonObject");     // Catch: Throwable -> L8
        return UtilsKt.i(r10);
    L9:
        return new LinkedHashMap();
    L11:
        return new LinkedHashMap();
    }
}
