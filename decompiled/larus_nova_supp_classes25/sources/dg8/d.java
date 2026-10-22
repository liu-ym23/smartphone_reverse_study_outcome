package dg8;

import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class d implements Function1 {
    public /* synthetic */ d() {
    }

    public final Object invoke(Object r3) {
        View r4 = (View) r3;
        int r0 = BaseCompositeTextCell.i;
        if (r4 == null) goto L5;
        ViewParent r1 = r4.getParent();
    L6:
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.widget.LinearLayout");
        return Integer.valueOf(((LinearLayout) r1).indexOfChild(r4));
    L5:
        r1 = null;
        goto L6
    }
}
