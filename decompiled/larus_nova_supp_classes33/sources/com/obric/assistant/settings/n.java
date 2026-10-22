package com.obric.assistant.settings;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class n implements Function1 {
    public final /* synthetic */ RecyclerView a;

    public /* synthetic */ n(RecyclerView r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        View r0 = this.a;
        zla.f r5 = (zla.f) r4;
        Intrinsics.checkNotNullParameter(r5, "container");
        r5.getBodySlot().removeAllViews();
        r5.getBodySlot().setPadding(0, 0, 0, 0);
        r5.getBodySlot().addView(r0);
        return Unit.INSTANCE;
    }
}
