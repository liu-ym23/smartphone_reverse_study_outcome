package com.ss.android.lark.forsetiutils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ForsetiConfig {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final boolean c = false;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;

    static {
        a = LazyKt.lazy(ForsetiConfig$PLACE_HOLDER_THRESHOLD_UNDER_LEFT_NAVIGATION$2.INSTANCE);
        b = LazyKt.lazy(ForsetiConfig$THRESHOLD_LEFT_NAVIGATION_APPLYING$2.INSTANCE);
        c = true;
        d = LazyKt.lazy(ForsetiConfig$enableForseti$2.INSTANCE);
        e = LazyKt.lazy(ForsetiConfig$enableLeftNavigation$2.INSTANCE);
        f = LazyKt.lazy(ForsetiConfig$enableUpdateResumedChain$2.INSTANCE);
        g = LazyKt.lazy(ForsetiConfig$isInBlackList$2.INSTANCE);
    }

    public static boolean b() {
        return ((Boolean) d.getValue()).booleanValue();
    }

    public static boolean a(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        if ((r6 instanceof ContextWrapper) == false) goto L7;
        ContextWrapper r0 = (ContextWrapper) r6;
        if ((r0.getBaseContext() instanceof Activity) == false) goto L7;
        boolean r7 = StringsKt.contains$default(r0.getBaseContext().getClass().getName(), "MainActivity", false, 2, null);
    L8:
        if (r7 == true) goto L10;
        return false;
    L10:
        if (b() == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        r7 = StringsKt.contains$default(r6.getClass().getName(), "MainActivity", false, 2, null);
        goto L8
    }

    public static boolean c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        int r0 = ForsetiEmbeddedUtils.e(r2);
        b.a.getClass();
        int r3 = b.b(r0, r2);
        if (((Boolean) e.getValue()).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (r3 < ((Number) b.getValue()).floatValue()) goto L7;
        return true;
    }
}
