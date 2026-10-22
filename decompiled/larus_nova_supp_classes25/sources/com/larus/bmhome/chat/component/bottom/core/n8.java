package com.larus.bmhome.chat.component.bottom.core;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class n8 implements Function1 {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ n8(Function1 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        return CoreInputViewModel.wp(this.a, (CoreInputComponentState) r2);
    }
}
