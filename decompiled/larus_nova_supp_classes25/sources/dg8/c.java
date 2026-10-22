package dg8;

import android.view.View;
import android.view.ViewParent;
import com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class c implements Function1 {
    public /* synthetic */ c() {
    }

    public final Object invoke(Object r2) {
        View r3 = (View) r2;
        int r0 = BaseCompositeTextCell.i;
        if (r3 == null) goto L5;
        ViewParent r4 = r3.getParent();
    L6:
        if (r4 == null) goto L8;
        boolean r5 = true;
    L10:
        return Boolean.valueOf(r5);
    L8:
        r5 = false;
        goto L10
    L5:
        r4 = null;
        goto L6
    }
}
