package com.larus.camera.impl.ui.component.capture.edu;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class s implements Function1<TextView, Unit> {
    public final /* synthetic */ c0 a;
    public final /* synthetic */ Ref.ObjectRef<Function0<Unit>> b;

    public s(c0 r1, Ref.ObjectRef<Function0<Unit>> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r5) {
        TextView r6 = (TextView) r5;
        Intrinsics.checkNotNullParameter(r6, "$this$setHint");
        ObjectAnimator r7 = ObjectAnimator.ofFloat(r6, View.ALPHA, new float[]{1.0f, 0.0f});
        c0 r0 = this.a;
        Ref.ObjectRef<Function0<Unit>> r1 = this.b;
        r7.setStartDelay(500);
        r7.setDuration(300);
        Intrinsics.checkNotNull(r7);
        r7.addListener(new r(r1));
        r7.addListener(new q(r1));
        com.larus.camera.impl.utils.h r2 = r0.n;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r7, "animator");
        r2.a.add(r7);
        r7.start();
        return Unit.INSTANCE;
    }
}
