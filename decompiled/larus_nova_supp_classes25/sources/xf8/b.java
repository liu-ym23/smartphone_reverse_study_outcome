package xf8;

import com.larus.bmhome.chat.list.cell.lynx.LynxCell;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import va8.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class b implements Function1 {
    public final /* synthetic */ LynxCell a;

    public /* synthetic */ b(LynxCell r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [xf8.g] */
    public final Object invoke(Object r3) {
        LynxCell r0 = this.a;
        final kx7.b r4 = (kx7.b) r3;
        int r1 = LynxCell.l;
        Intrinsics.checkNotNullParameter(r4, "it");
        p r2 = (p) r0.h.getValue();
        if (r2 == null) goto L5;
        r2.n2();
    L5:
        p r5 = (p) r0.h.getValue();
        if (r5 == null) goto L9;
        r5.v60(new g(r4));
    L9:
        return Unit.INSTANCE;
    }
}
