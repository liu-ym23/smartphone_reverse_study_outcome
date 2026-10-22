package com.bytedance.android.ec.core.imagex;

import android.app.Activity;
import android.content.Context;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class t {
    public static final r a = null;
    public static final Map<String, r> b = null;

    static {
        a = new r("ec_default", "unknown");
        b = new ConcurrentHashMap();
    }

    @JvmStatic
    public static final r a(Context r10) {
        if (r10 == null) goto L7;
        Activity r11 = com.bytedance.android.ec.core.utils.l0.b(r10);
        if (r11 == null) goto L7;
        return new r("ec_default", "unknown", r11.getClass().getName());
    L7:
        return a;
    }

    @JvmStatic
    public static final r c(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Activity r0 = com.bytedance.android.ec.core.utils.l0.b(r1);
        if (r0 == null) goto L5;
        r1 = r0;
    L5:
        String r10 = String.valueOf(r1.hashCode());
        Intrinsics.checkNotNullParameter(r10, "id");
        return (r) ((ConcurrentHashMap) b).remove(r10);
    }

    @JvmStatic
    public static final void b(Context r10, r r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "callerContext");
        Activity r1 = com.bytedance.android.ec.core.utils.l0.b(r10);
        if (r1 == null) goto L5;
        r10 = r1;
    L5:
        String r12 = String.valueOf(r10.hashCode());
        Intrinsics.checkNotNullParameter(r12, "id");
        Intrinsics.checkNotNullParameter(r11, "callerContext");
        if (StringsKt.isBlank(r12) == true) goto L10;
        ((ConcurrentHashMap) b).put(r12, r11);
        return;
    }
}
