package com.larus.share.impl.util;

import com.larus.camera.impl.ui.viewmodel.b0;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class c implements Function2 {
    public final /* synthetic */ Function2 a;

    public /* synthetic */ c(b0 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3, Object r4) {
        Function2 r0 = this.a;
        boolean r5 = ((Boolean) r3).booleanValue();
        String r6 = (String) r4;
        Intrinsics.checkNotNullParameter(r6, "uriString");
        if (r0 == null) goto L6;
        r0.invoke(Boolean.valueOf(r5), r6);
    L6:
        return Unit.INSTANCE;
    }
}
