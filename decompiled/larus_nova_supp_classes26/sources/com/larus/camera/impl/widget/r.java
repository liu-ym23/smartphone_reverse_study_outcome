package com.larus.camera.impl.widget;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class r implements Function3 {
    public final /* synthetic */ PickerLayoutManager a;

    public /* synthetic */ r(PickerLayoutManager r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2, Object r3, Object r4) {
        PickerLayoutManager r0 = this.a;
        View r5 = (View) r2;
        ((Integer) r3).intValue();
        float r6 = ((Float) r4).floatValue();
        Intrinsics.checkNotNullParameter(r5, "child");
        r0.a.a(r5, r6);
        return Unit.INSTANCE;
    }
}
