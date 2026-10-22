package com.larus.bmhome.chat.component.bottom.core;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class d6 implements Function2 {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ d6(z5 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3, Object r4) {
        Function1 r0 = this.a;
        int r1 = CoreInputComponent.d3;
        Intrinsics.checkNotNullParameter((View) r3, "view");
        Intrinsics.checkNotNullParameter((MotionEvent) r4, "event");
        r0.invoke("release_icon");
        return Unit.INSTANCE;
    }
}
