package com.larus.bmhome.chat.list.cell.generate_image;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class b implements Function1 {
    public final /* synthetic */ GenerateImageCell a;

    public /* synthetic */ b(GenerateImageCell r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5) {
        final GenerateImageCell r0 = this.a;
        ii9.b r6 = (ii9.b) r5;
        ConcurrentHashMap.KeySetView r1 = GenerateImageCell.A;
        Intrinsics.checkNotNullParameter(r6, "$this$expose");
        Function0 r2 = new p(r0);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r2, "cellId");
        r6.a = r2;
        float[] r3 = {0.5f};
        Intrinsics.checkNotNullParameter(r3, "percentages");
        r6.c = r3;
        Function1 r4 = new c(r0);
        Intrinsics.checkNotNullParameter(r4, "block");
        r6.b = r4;
        return Unit.INSTANCE;
    }
}
