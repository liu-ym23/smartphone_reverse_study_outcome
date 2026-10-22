package com.ss.android.lark.feed.app.tablayout;

import android.graphics.drawable.Drawable;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final View a(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2.getCallback() instanceof View) == false) goto L8;
        Drawable.Callback r3 = r2.getCallback();
        if ((r3 instanceof View) == true) goto L7;
        return null;
    L7:
        return (View) r3;
    L8:
        return null;
    }
}
