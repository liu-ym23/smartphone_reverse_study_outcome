package com.obric.assistant.chat.component.interaction;

import com.larus.bmhome.chat.component.cvs.y;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k implements Function1<Throwable, Unit> {
    public final /* synthetic */ y a;
    public final /* synthetic */ l b;

    public k(y r1, l r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r2) {
        Throwable r3 = (Throwable) r2;
        this.a.lQ(this.b);
        return Unit.INSTANCE;
    }
}
