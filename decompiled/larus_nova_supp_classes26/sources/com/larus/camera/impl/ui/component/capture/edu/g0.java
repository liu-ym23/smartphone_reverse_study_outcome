package com.larus.camera.impl.ui.component.capture.edu;

import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g0 implements Function1<TextView, Unit> {
    public final /* synthetic */ c0 a;
    public final /* synthetic */ Ref.ObjectRef<Function0<Unit>> b;

    public g0(c0 r1, Ref.ObjectRef<Function0<Unit>> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        TextView r5 = (TextView) r4;
        Intrinsics.checkNotNullParameter(r5, "$this$setHint");
        this.a.v(r5, new f0(this.b));
        return Unit.INSTANCE;
    }
}
