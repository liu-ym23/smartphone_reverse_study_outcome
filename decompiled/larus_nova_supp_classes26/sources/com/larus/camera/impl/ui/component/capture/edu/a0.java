package com.larus.camera.impl.ui.component.capture.edu;

import com.larus.camera.impl.widget.title.TitleRightIconView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a0 implements Function1<TitleRightIconView, Unit> {
    public final /* synthetic */ c0 a;
    public final /* synthetic */ Ref.ObjectRef<Function0<Unit>> b;

    public a0(c0 r1, Ref.ObjectRef<Function0<Unit>> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        TitleRightIconView r5 = (TitleRightIconView) r4;
        Intrinsics.checkNotNullParameter(r5, "$this$updateRightIcon");
        r5.setHint(new z(this.a, this.b));
        return Unit.INSTANCE;
    }
}
