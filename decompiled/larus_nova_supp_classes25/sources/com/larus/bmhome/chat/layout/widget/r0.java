package com.larus.bmhome.chat.layout.widget;

import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class r0 implements Function1 {
    public final /* synthetic */ q0 a;

    public /* synthetic */ r0(q0 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        q0 r0 = this.a;
        WeakReference r4 = (WeakReference) r3;
        if (r4.get() != null) goto L5;
    L8:
        boolean r5 = true;
    L10:
        return Boolean.valueOf(r5);
    L5:
        if (Intrinsics.areEqual(r4.get(), r0) == true) goto L8;
        r5 = false;
        goto L10
    }
}
