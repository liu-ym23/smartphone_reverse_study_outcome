package com.larus.camera.impl.ui.component.capture.edu;

import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u implements Function0<Unit> {
    public final /* synthetic */ kotlinx.coroutines.i<Unit> a;

    public u(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final Object invoke() {
        kotlinx.coroutines.i<Unit> r0 = this.a;
        Result.Companion r1 = Result.Companion;
        Unit r2 = Unit.INSTANCE;
        r0.resumeWith(Result.constructor-impl(r2));
        return r2;
    }
}
