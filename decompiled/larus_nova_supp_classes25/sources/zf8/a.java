package zf8;

import com.larus.bmhome.chat.list.cell.poi.PoiMapCell;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a implements Function1 {
    public final /* synthetic */ PoiMapCell a;

    public /* synthetic */ a(PoiMapCell r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        final PoiMapCell r0 = this.a;
        ii9.b r5 = (ii9.b) r4;
        Set r1 = PoiMapCell.i;
        Intrinsics.checkNotNullParameter(r5, "$this$expose");
        Function0 r2 = new d(r0);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r2, "cellId");
        r5.a = r2;
        Function1 r3 = new e(r0);
        Intrinsics.checkNotNullParameter(r3, "block");
        r5.b = r3;
        return Unit.INSTANCE;
    }
}
