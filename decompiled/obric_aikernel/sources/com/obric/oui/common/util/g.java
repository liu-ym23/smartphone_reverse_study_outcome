package com.obric.oui.common.util;

import android.content.Context;
import android.content.res.Resources;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f6399a = null;

    static {
        f6399a = new g();
    }

    private g() {
    }

    public final boolean a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Resources r11 = r10.getResources();     // Catch: Exception -> L7
        Intrinsics.checkNotNullExpressionValue(r11, "context.resources");     // Catch: Exception -> L7
        if (r11.getConfiguration().orientation != 2) goto L12;
        return true;
    L12:
        return false;
    L7:
        e = move-exception;
        ea.b.c("ResourceUtils", "isLandscape error", e);
        return false;
    }
}
