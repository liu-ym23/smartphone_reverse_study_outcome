package com.obric.assistant;

import android.content.ComponentName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class m1 implements Function1 {
    public final /* synthetic */ ObricOmniLockscreenStateServiceImpl a;

    public /* synthetic */ m1(ObricOmniLockscreenStateServiceImpl r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        ObricOmniLockscreenStateServiceImpl r0 = this.a;
        ComponentName r4 = (ComponentName) r3;
        int r1 = ObricOmniLockscreenStateServiceImpl.d;
        Intrinsics.checkNotNullParameter(r4, "it");
        r0.getClass();
        return ObricOmniLockscreenStateServiceImpl.i(r4);
    }
}
