package com.bytedance.android.ec.core.widget;

import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e extends d {
    public final /* synthetic */ Function1 g;

    @Override // com.bytedance.android.ec.core.widget.d
    public final void a(View r10) {
        Intrinsics.checkNotNullParameter(r10, "v");
        this.g.invoke(r10);
    }

    public e(Function1 r1, Long r10, String r11) {
        this.g = r1;
        super(r10, r11);
    }
}
