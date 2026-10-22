package dg8;

import com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a implements Function1 {
    public final /* synthetic */ int a;

    public /* synthetic */ a(int r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        int r0 = this.a;
        bd8.b r4 = (bd8.b) r3;
        int r1 = BaseCompositeTextCell.i;
        Intrinsics.checkNotNullParameter(r4, "it");
        if (r4.b >= r0) goto L5;
        boolean r5 = true;
    L7:
        return Boolean.valueOf(r5);
    L5:
        r5 = false;
        goto L7
    }
}
