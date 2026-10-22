package com.larus.camera.impl.ui.component.result.general;

import com.larus.camera.impl.widget.title.TitleRightIconView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a2 implements Function1<TitleRightIconView, Unit> {
    public static final a2 a = null;

    static {
        a = new a2();
    }

    public a2() {
    }

    public final Object invoke(Object r2) {
        TitleRightIconView r3 = (TitleRightIconView) r2;
        Intrinsics.checkNotNullParameter(r3, "$this$updateRightIcon");
        r3.setAlpha(1.0f);
        r3.setEnabled(true);
        return Unit.INSTANCE;
    }
}
