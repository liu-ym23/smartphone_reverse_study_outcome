package com.larus.asr.view;

import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class l0 implements Function0 {
    public final /* synthetic */ TextView a;

    public /* synthetic */ l0(TextView r1) {
        this.a = r1;
    }

    public final Object invoke() {
        final TextView r0 = this.a;
        r0.setTextSize(0, i5.k());
        r0.post(new m0(r0));
        return Unit.INSTANCE;
    }
}
