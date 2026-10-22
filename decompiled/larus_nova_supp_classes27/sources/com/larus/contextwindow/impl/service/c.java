package com.larus.contextwindow.impl.service;

import android.content.Context;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class c implements Function2 {
    public final /* synthetic */ Context a;

    public /* synthetic */ c(Context r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4, Object r5) {
        Context r0 = this.a;
        String r6 = (String) r4;
        String r7 = (String) r5;
        Intrinsics.checkNotNullParameter(r6, "used");
        Intrinsics.checkNotNullParameter(r7, "total");
        return r0.getString(2131906701, new Object[]{r6, r7});
    }
}
