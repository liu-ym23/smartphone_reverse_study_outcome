package com.larus.asr;

import a58.a;
import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import y48.w;
import y48.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class u1 implements Function1 {
    public final /* synthetic */ a a;

    public /* synthetic */ u1(a r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        final a r0 = this.a;
        w r4 = (w) r3;
        Intrinsics.checkNotNullParameter(r4, "$this$tips");
        Function2<? super Context, ? super y, ? extends y48.o> r1 = new z1(r0);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r1, "provider");
        r4.e = r1;
        return Unit.INSTANCE;
    }
}
