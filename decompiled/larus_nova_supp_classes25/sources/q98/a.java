package q98;

import com.larus.avlink.gallery.view.y;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public final StateFlowImpl a;
    public final b1 b;

    public final void a() {
        StateFlowImpl r0 = this.a;
    L3:
        Object r1 = r0.getValue();
        y r2 = (y) r1;
        if (r0.compareAndSet(r1, y.a(false, r2.b, r2.c, r2.d, r2.e, r2.f, r2.g, r2.h, r2.i)) == false) goto L3;
    }

    public a() {
        StateFlowImpl r0 = j1.a(new y(0));
        this.a = r0;
        this.b = e.b(r0);
    }
}
