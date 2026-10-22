package com.larus.camera.impl.ui.component.result.general;

import com.larus.camera.impl.widget.title.TitleRightIconView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x1 implements Function1<TitleRightIconView, Unit> {
    public static final x1 a = null;

    static {
        a = new x1();
    }

    public x1() {
    }

    public final Object invoke(Object r2) {
        TitleRightIconView r3 = (TitleRightIconView) r2;
        Intrinsics.checkNotNullParameter(r3, "$this$updateRightIcon");
        r3.setAlpha(0.5f);
        r3.setEnabled(false);
        return Unit.INSTANCE;
    }
}
