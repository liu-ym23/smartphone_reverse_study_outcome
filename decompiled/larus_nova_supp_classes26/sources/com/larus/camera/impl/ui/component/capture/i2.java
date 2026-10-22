package com.larus.camera.impl.ui.component.capture;

import android.widget.ImageView;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class i2 implements Function1 {
    public final /* synthetic */ CameraCaptureViewModel a;

    public /* synthetic */ i2(CameraCaptureViewModel r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        final CameraCaptureViewModel r0 = this.a;
        ImageView r4 = (ImageView) r3;
        Intrinsics.checkNotNullParameter(r4, "$this$configLeftButton");
        int r1 = com.larus.utils.j0.a;
        r4.setContentDescription(com.larus.utils.j0.d(2131898809));
        r4.setImageResource(2131242189);
        com.larus.utils.e1.d(r4, new d2(r0));
        return Unit.INSTANCE;
    }
}
