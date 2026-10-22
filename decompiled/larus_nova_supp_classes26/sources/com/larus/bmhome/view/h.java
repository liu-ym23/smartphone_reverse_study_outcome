package com.larus.bmhome.view;

import android.view.View;
import android.widget.LinearLayout;
import com.larus.common_res.common_ui.databinding.LarusWidgetBottomMenuGridItemBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class h implements Function1 {
    public final /* synthetic */ k a;
    public final /* synthetic */ LarusWidgetBottomMenuGridItemBinding b;

    public /* synthetic */ h(k r1, LarusWidgetBottomMenuGridItemBinding r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        k r0 = this.a;
        LarusWidgetBottomMenuGridItemBinding r1 = this.b;
        int r2 = BottomMenuGridLayout.h;
        Intrinsics.checkNotNullParameter((LinearLayout) r4, "it");
        Function1<View, Unit> r5 = r0.f;
        if (r5 == null) goto L6;
        r5.invoke(r1.b);
    L6:
        return Unit.INSTANCE;
    }
}
