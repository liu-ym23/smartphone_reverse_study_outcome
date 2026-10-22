package ef8;

import android.os.Build;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.platform.service.e2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class i implements Function0 {
    public final /* synthetic */ o a;
    public final /* synthetic */ Ref.IntRef b;
    public final /* synthetic */ Ref.IntRef c;
    public final /* synthetic */ CommonMenu d;

    public /* synthetic */ i(o r1, Ref.IntRef r2, Ref.IntRef r3, CommonMenu r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke() {
        o r0 = this.a;
        Ref.IntRef r1 = this.b;
        Ref.IntRef r2 = this.c;
        CommonMenu r3 = this.d;
        r0.d.getLocationInWindow(r0.f);
        int r4 = r1.element;
        int[] r5 = r0.f;
        r1.element = r4 + r5[0];
        r2.element += r5[1];
        e2 r6 = e2.a;
        if (r6.isPad() == false) goto L6;
        r1.element -= (int) (((double) r6.f()) * 0.25d);
    L6:
        if (Build.VERSION.SDK_INT >= 26) goto L8;
        r3.measure(0, 0);
        r0.h(r1.element, Math.max(r3.getMeasuredHeight() + i5.l0(), r2.element));
    L10:
        return Unit.INSTANCE;
    L8:
        r0.h(r1.element, r2.element);
        goto L10
    }
}
