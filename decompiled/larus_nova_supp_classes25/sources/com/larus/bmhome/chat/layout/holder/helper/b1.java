package com.larus.bmhome.chat.layout.holder.helper;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b1 {
    public static final void a(a1 r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "view");
        w0 r1 = new w0(r2);
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, "targetView");
        r3.setOnLongClickListener(r1);
    }
}
