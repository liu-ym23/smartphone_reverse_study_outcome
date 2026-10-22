package com.obric.oui.common.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6396a = null;

    static {
        f6396a = new a();
    }

    private a() {
    }

    @Nullable
    public final TypedValue a(@NonNull Context r10, @AttrRes int r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        TypedValue r12 = new TypedValue();
        if (r10.getTheme().resolveAttribute(r11, r12, true) == true) goto L7;
        return null;
    L7:
        return r12;
    }

    @Px
    public final int b(Context r10, @AttrRes int r11, @DimenRes int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        TypedValue r13 = a(r10, r11);
        if (r13 != null) goto L5;
    L8:
        float r14 = r10.getResources().getDimension(r12);
    L10:
        return (int) r14;
    L5:
        if (r13.type != 5) goto L8;
        Resources r15 = r10.getResources();
        Intrinsics.checkNotNullExpressionValue(r15, "context.resources");
        r14 = r13.getDimension(r15.getDisplayMetrics());
        goto L10
    }
}
