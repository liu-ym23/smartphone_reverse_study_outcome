package lb;

import com.bytedance.android.anya.BaseMVIViewModel;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e extends h<f> implements f {
    public int b;
    public int c;
    public final MVIState<?> d;

    public final void k() {
        if (this.a.isEmpty() == false) goto L6;
        return;
    L6:
        if (this.d.modifiedProperties.isEmpty() == false) goto L8;
        return;
    L8:
        int r0 = a.c;
        i r1 = a.C0177a.a(this.d, false);
        Iterator r10 = this.a.iterator();
    L10:
        if (r10.hasNext() == false) goto L12;
        ((f) r10.next()).g(this.c, r1);
        goto L10
    }

    @Override // lb.f
    public final void d(BaseMVIViewModel<?, ?> r10) {
        Iterator r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) r0.next()).d(r10);
        goto L4
    }

    @Override // lb.f
    public final void e(i r10) {
        Iterator r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) r0.next()).e(r10);
        goto L4
    }

    @Override // lb.f
    public final void f(v<?, ?> r10) {
        Iterator r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) r0.next()).f(r10);
        goto L4
    }

    @Override // lb.f
    public final void i(i r10) {
        Iterator r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) r0.next()).i(r10);
        goto L4
    }

    public final void l(Map<Object, ? extends com.bytedance.android.anya.j<?>> r10) {
        if (this.a.isEmpty() == false) goto L6;
        return;
    L6:
        if (this.d.modifiedProperties.isEmpty() == false) goto L8;
        return;
    L8:
        int r0 = a.c;
        i r1 = a.C0177a.a(this.d, false);
        Iterator r11 = this.a.iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        ((f) r11.next()).h(r1, r10);
        goto L10
    }

    public e(MVIState<?> r1, Collection<? extends f> r10) {
        super(r10);
        this.d = r1;
    }

    @Override // lb.f
    public final void g(int r10, i r11) {
        Iterator r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) r0.next()).g(r10, r11);
        goto L4
    }

    @Override // lb.f
    public final void h(i r10, Map<Object, ? extends com.bytedance.android.anya.j<?>> r11) {
        Iterator r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) r0.next()).h(r10, r11);
        goto L4
    }
}
