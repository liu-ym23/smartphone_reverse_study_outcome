package com.larus.bmhome.chat.component.fastsend;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class p implements Function0 {
    public final /* synthetic */ FastSendImageComponent a;

    public /* synthetic */ p(FastSendImageComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        FastSendImageComponent r0 = this.a;
        KProperty[] r1 = FastSendImageComponent.M;
        ICoreInputAbility r2 = r0.P2();
        if (r2 == null) goto L6;
        r2.C1(false, true, "");
    L6:
        return Unit.INSTANCE;
    }
}
