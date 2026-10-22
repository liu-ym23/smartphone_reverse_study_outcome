package com.larus.bmhome.chat.component.bottom.core;

import android.content.Context;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class q8 implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Context c;

    public /* synthetic */ q8(String r1, String r2, Context r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        return CoreInputViewModel.lp(this.a, this.b, this.c);
    }
}
