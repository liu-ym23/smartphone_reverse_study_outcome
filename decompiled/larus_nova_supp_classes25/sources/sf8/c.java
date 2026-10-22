package sf8;

import com.larus.bmhome.chat.list.cell.deepsearch.DeepSearchCell;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class c implements Function1 {
    public final /* synthetic */ DeepSearchCell a;

    public /* synthetic */ c(DeepSearchCell r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5) {
        final DeepSearchCell r0 = this.a;
        ii9.b r6 = (ii9.b) r5;
        Intrinsics.checkNotNullParameter(r6, "$this$expose");
        Function0 r1 = new f(r0);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r1, "cellId");
        r6.a = r1;
        float[] r2 = {1.0f};
        Intrinsics.checkNotNullParameter(r2, "percentages");
        r6.c = r2;
        Function1 r3 = new g(r0);
        Intrinsics.checkNotNullParameter(r3, "block");
        r6.b = r3;
        return Unit.INSTANCE;
    }
}
