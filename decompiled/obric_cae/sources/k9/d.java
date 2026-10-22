package k9;

import android.view.View;
import android.view.animation.LinearInterpolator;
import j0.l0;
import j0.m0;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d extends l0.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f8979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8981d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f8982e;

    public d(View r8) {
        this.f8982e = new int[2];
        this.f8979b = r8;
    }

    @Override // j0.l0.b
    public final m0 a(m0 r8, List<l0> r10) {
        Iterator<l0> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        l0 r12 = r11.next();
        if ((r12.f8394a.b() & 8) == 0) goto L4;
        int r13 = this.f8981d;
        float r14 = r12.f8394a.a();
        LinearInterpolator r15 = h9.a.f7943a;
        this.f8979b.setTranslationY(Math.round(r14 * (0 - r13)) + r13);
    L8:
        return r8;
    }
}
