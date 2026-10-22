package com.larus.bmhome.chat.component.showcase;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class v implements Function1 {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ v(Function1 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        Function1 r0 = this.a;
        Boolean r4 = (Boolean) r3;
        int r1 = ChatPlaybackComponent.x;
        Intrinsics.checkNotNull(r4);
        r0.invoke(r4);
        return Unit.INSTANCE;
    }
}
