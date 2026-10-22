package xf8;

import android.view.View;
import com.larus.bmhome.chat.list.cell.lynx.LynxCell;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class d implements Function0 {
    public final /* synthetic */ LynxCell a;
    public final /* synthetic */ View b;

    public /* synthetic */ d(LynxCell r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        LynxCell r0 = this.a;
        View r1 = this.b;
        i r2 = r0.f;
        if (r2 == null) goto L6;
        r0.s(r1, r2);
    L6:
        return Unit.INSTANCE;
    }
}
