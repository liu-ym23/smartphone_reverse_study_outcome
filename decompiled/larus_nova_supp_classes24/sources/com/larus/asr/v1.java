package com.larus.asr;

import android.content.Context;
import b58.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import y48.b;
import y48.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class v1 implements Function1 {
    public final /* synthetic */ a a;

    public /* synthetic */ v1(a r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        final a r0 = this.a;
        b r4 = (b) r3;
        Intrinsics.checkNotNullParameter(r4, "$this$cancelArea");
        Function2<? super Context, ? super y, ? extends y48.o> r1 = new y1(r0);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r1, "provider");
        r4.e = r1;
        return Unit.INSTANCE;
    }
}
