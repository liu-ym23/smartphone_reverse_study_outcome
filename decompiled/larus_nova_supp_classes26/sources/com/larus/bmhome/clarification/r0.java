package com.larus.bmhome.clarification;

import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class r0 implements Function0 {
    public final /* synthetic */ ClarificationComponent a;

    public /* synthetic */ r0(ClarificationComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ClarificationComponent r0 = this.a;
        int r1 = ClarificationComponent.k0;
        return LifecycleOwnerKt.getLifecycleScope(s1a.a.c(r0));
    }
}
