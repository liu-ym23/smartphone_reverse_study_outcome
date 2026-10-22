package com.larus.asr.session;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class b implements Function0 {
    public final /* synthetic */ g a;
    public final /* synthetic */ Ref.ObjectRef b;

    public /* synthetic */ b(g r1, Ref.ObjectRef r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        g r0 = this.a;
        Ref.ObjectRef r1 = this.b;
        ComponentAsrSession r2 = r0.b;
        Object r3 = r1.element;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("session");
        q0 r4 = null;
    L6:
        if (r2 != r4) goto L8;
        boolean r5 = true;
    L10:
        return Boolean.valueOf(r5);
    L8:
        r5 = false;
        goto L10
    L5:
        r4 = (q0) r3;
        goto L6
    }
}
