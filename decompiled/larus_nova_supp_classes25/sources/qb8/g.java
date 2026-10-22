package qb8;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class g implements Function1 {
    public final /* synthetic */ Ref.IntRef a;

    public /* synthetic */ g(Ref.IntRef r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        Ref.IntRef r0 = this.a;
        en8.a r5 = (en8.a) r4;
        Intrinsics.checkNotNullParameter(r5, "model");
        int r1 = r0.element;
        r0.element = r1 + 1;
        r5.getClass();
        r5.j = RangesKt.coerceAtLeast(r1, 1);
        return Unit.INSTANCE;
    }
}
