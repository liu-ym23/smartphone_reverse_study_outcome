package com.larus.camera.impl.ui.component.capture.edu;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f0 implements Function0<Unit> {
    public final /* synthetic */ Ref.ObjectRef<Function0<Unit>> a;

    public f0(Ref.ObjectRef<Function0<Unit>> r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ((Function0) this.a.element).invoke();
        Ref.ObjectRef<Function0<Unit>> r0 = this.a;
        r0.element = e0.a;
        return Unit.INSTANCE;
    }
}
