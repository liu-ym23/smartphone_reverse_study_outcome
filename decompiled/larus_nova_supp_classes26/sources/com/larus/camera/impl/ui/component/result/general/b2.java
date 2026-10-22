package com.larus.camera.impl.ui.component.result.general;

import android.view.View;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b2 implements Function1<View, Unit> {
    public final /* synthetic */ ResultTitleComponent a;

    public b2(ResultTitleComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5) {
        View r6 = (View) r5;
        Intrinsics.checkNotNullParameter(r6, "$this$configMiddleTitleIconContainer");
        CameraResultViewModel r0 = (CameraResultViewModel) com.larus.camera.impl.ui.arch.b.e(this.a).a();
        if (r0 == null) goto L17;
        if (((Boolean) r0.getEnableRedo().getValue()).booleanValue() == false) goto L8;
    L11:
        boolean r1 = true;
    L12:
        ResultTitleComponent r2 = this.a;
        if (r2.q == false) goto L17;
        if (r1 == true) goto L17;
        r2.q = false;
        com.larus.utils.e1.x(r6);
        goto L17
    L8:
        if (((Boolean) r0.getEnableUndo().getValue()).booleanValue() == true) goto L11;
        r1 = false;
    L17:
        return Unit.INSTANCE;
    }
}
