package z4;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.b f14202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f14203b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f14204m;

    public b(c.b r8, a r10, Object r11) {
        this.f14202a = r8;
        this.f14203b = r10;
        this.f14204m = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<a> r8 = this.f14202a.f14213b.keySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L12;
        a r10 = r8.next();
        a r11 = this.f14203b;
        if (r11 != r10) goto L4;
        r11.a(this.f14204m);
        return;
    }
}
