package com.larus.contextwindow.impl.service;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class d implements Function1 {
    public final /* synthetic */ Context a;

    public /* synthetic */ d(Context r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        Context r0 = this.a;
        String r5 = (String) r4;
        Intrinsics.checkNotNullParameter(r5, "percent");
        return r0.getString(2131906700, new Object[]{r5});
    }
}
