package com.bytedance.android.live.room.navi.userinfo.flipper.core;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final BaseTabFlipper.LayoutParams a(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$flipperLp");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof BaseTabFlipper.LayoutParams) == true) goto L6;
        r2 = null;
    L6:
        return (BaseTabFlipper.LayoutParams) r2;
    }
}
