package com.ss.android.lark.feed.app.tablayout;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static final int a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (r2.getMeasuredHeight() - r2.getPaddingTop()) - r2.getPaddingBottom();
    }

    public static final int b(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (r2.getMeasuredWidth() - r2.getPaddingLeft()) - r2.getPaddingRight();
    }
}
