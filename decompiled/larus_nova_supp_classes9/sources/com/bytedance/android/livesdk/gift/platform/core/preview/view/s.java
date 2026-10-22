package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s {
    public static final void a(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$setHeight");
        r1.getLayoutParams().height = r2;
        r1.requestLayout();
    }
}
