package xf8;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.api.v0;
import com.larus.bmhome.chat.list.cell.lynx.LynxCell;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import va8.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class c implements Function3 {
    public final /* synthetic */ LynxCell a;

    public /* synthetic */ c(LynxCell r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2, Object r3, Object r4) {
        LynxCell r0 = this.a;
        View r5 = (View) r2;
        Fragment r6 = (Fragment) r3;
        v0 r7 = (v0) r4;
        int r8 = LynxCell.l;
        p r9 = (p) r0.h.getValue();
        if (r9 == null) goto L6;
        r9.n2();
    L6:
        return Unit.INSTANCE;
    }
}
