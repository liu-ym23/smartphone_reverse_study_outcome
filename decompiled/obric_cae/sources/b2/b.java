package b2;

import android.location.Location;
import android.os.Handler;
import ge.l;
import xd.j;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f3029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Location f3030b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f3031m;

    public b(a r8, Location r10, int r11) {
        this.f3029a = r8;
        this.f3030b = r10;
        this.f3031m = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f3029a.f3015n == true) goto L5;
        return;
    L5:
        a r8 = this.f3029a;
        r8.f3014m = System.currentTimeMillis();
        l<? super a.AbstractC0030a, j> r10 = this.f3029a.f3008g;
        if (r10 == null) goto L8;
        j r11 = r10.invoke(new a.AbstractC0030a.b(this.f3030b, this.f3031m));
    L8:
        a r12 = this.f3029a;
        Handler r13 = r12.f3002a;
        if (r13 == null) goto L12;
        r13.postDelayed(r12.f3020s, r12.f3003b);
        return;
    }
}
