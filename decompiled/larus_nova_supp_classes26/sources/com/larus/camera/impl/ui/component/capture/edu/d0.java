package com.larus.camera.impl.ui.component.capture.edu;

import android.widget.ImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d0 implements Function1<ImageView, Unit> {
    public final /* synthetic */ c0 a;

    public d0(c0 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        ImageView r4 = (ImageView) r3;
        Intrinsics.checkNotNullParameter(r4, "$this$setIcon");
        this.a.v(r4, new f());
        return Unit.INSTANCE;
    }
}
