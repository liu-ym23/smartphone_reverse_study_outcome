package com.larus.common_ui.view;

import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class x implements Function1 {
    public /* synthetic */ x() {
    }

    public final Object invoke(Object r2) {
        ViewGroup r3 = (ViewGroup) r2;
        int r0 = SuggestedActionBar.t;
        Intrinsics.checkNotNullParameter(r3, "it");
        return ViewGroupKt.getChildren(r3);
    }
}
