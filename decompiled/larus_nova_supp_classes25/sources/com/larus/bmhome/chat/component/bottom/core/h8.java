package com.larus.bmhome.chat.component.bottom.core;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class h8 implements Function1 {
    public final /* synthetic */ CharSequence a;

    public /* synthetic */ h8(CharSequence r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        return CoreInputViewModel.ip(this.a, (CoreInputComponentState) r2);
    }
}
