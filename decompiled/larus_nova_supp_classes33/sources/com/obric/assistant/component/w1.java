package com.obric.assistant.component;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class w1 implements Function0 {
    public final /* synthetic */ ObricIntercomComponent a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ w1(ObricIntercomComponent r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        ObricIntercomComponent r0 = this.a;
        boolean r1 = this.b;
        int r2 = ObricIntercomComponent.h1;
        r0.X3().h(!r1);
        return Unit.INSTANCE;
    }
}
