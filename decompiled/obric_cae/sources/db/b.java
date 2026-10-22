package db;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import yd.k;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public cb.b f7010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public cb.a f7011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<? extends ya.a<?>> f7012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<View> f7013d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f7014e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7015f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f7016g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f7017h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f7018i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f7019j;

    public b() {
        this.f7010a = cb.b.f3430a;
        this.f7011b = cb.a.f3428a;
        this.f7012c = k.f14119a;
        this.f7015f = -1;
        this.f7016g = 1.0f;
        this.f7019j = true;
    }

    public final void a(boolean r8) {
        WeakReference<View> r10 = this.f7013d;
        if (r10 == null) goto L5;
        r10.clear();
    L5:
        Iterator<T> r11 = this.f7012c.iterator();
    L7:
        if (r11.hasNext() == false) goto L13;
        ya.a r12 = (ya.a) r11.next();
        r12.f14096d = false;
        if (r8 == false) goto L11;
        float r13 = 0.0f;
    L12:
        r12.f14103k = r13;
        r12.f14094b = -1;
        r12.f14095c = -1;
        goto L7
    L11:
        r13 = r12.f14103k;
        goto L12
    L13:
        this.f7014e = 0;
        this.f7015f = -1;
        this.f7016g = 1.0f;
        this.f7017h = 0;
        this.f7018i = 0;
    }
}
