package ag8;

import com.larus.bmhome.chat.list.cell.send_image.SendImageCell;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class k implements Function1 {
    public final /* synthetic */ SendImageCell a;

    public /* synthetic */ k(SendImageCell r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5) {
        final SendImageCell r0 = this.a;
        ii9.b r6 = (ii9.b) r5;
        int r1 = SendImageCell.t;
        Intrinsics.checkNotNullParameter(r6, "$this$expose");
        Function0 r2 = new e(r0);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r2, "cellId");
        r6.a = r2;
        float[] r3 = {1.0f};
        Intrinsics.checkNotNullParameter(r3, "percentages");
        r6.c = r3;
        Function1 r4 = new f(r0);
        Intrinsics.checkNotNullParameter(r4, "block");
        r6.b = r4;
        return Unit.INSTANCE;
    }
}
