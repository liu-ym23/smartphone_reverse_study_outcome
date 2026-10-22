package ev0;

import android.net.Uri;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.taskcenter.k;
import com.bytedance.android.live.profit.taskcenter.panel.model.PanelInfo;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ c a;
    public final /* synthetic */ PanelInfo b;
    public final /* synthetic */ Map c;

    public g(c r1, PanelInfo r2, Map r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r6) {
        PanelInfo.State r7 = (PanelInfo.State) r6;
        if (r7 == null) goto L10;
        int r0 = d.a[r7.ordinal()];
        Uri r1 = null;
        if (r0 != 1) goto L8;
        this.a.getClass();
        c.a("observePanelState subscribe State.READY");
        RxUtilKt.c(RxUtilKt.h(Observable.timer(((Number) k.e.getValue(null, k.a[3])).longValue(), TimeUnit.SECONDS)).takeUntil(this.b.b.filter(e.a)).subscribe(new f(this)), this.a.a);
        return;
    L8:
        if (r0 == 2) goto L12;
        if (r0 != 3) goto L10;
        this.a.getClass();
        c.a("observePanelState subscribe State.DISMISSED");
        this.a.b.remove(this.b);
        this.a.e();
        return;
    L12:
        int r8 = hv0.a.a;
        PanelInfo r9 = this.a.b.peek();
        if (r9 == null) goto L15;
        r1 = r9.d;
    L15:
        hv0.a.b(1, c.c(r1), this.a.b.size());
        c r10 = this.a;
        fv0.a r2 = this.b.g;
        r10.getClass();
        c.a("updateFrequency");
        Iterator r12 = ((ArrayList) r10.d).iterator();
    L17:
        if (r12.hasNext() == false) goto L24;
        ((a) r12.next()).a(r2);
        goto L17
    L24:
        return;
    L10:
        this.a.getClass();
        c.a("observePanelState subscribe " + r7);
    }
}
