package ao;

import com.lynx.tasm.performance.PerformanceController;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PerformanceController f707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f708c;
    public final /* synthetic */ long d;

    public /* synthetic */ b(PerformanceController r5, String r10, long r11, int r12) {
        this.f706a = r12;
        this.f707b = r5;
        this.f708c = r10;
        this.d = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f706a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        String r5 = this.f708c;
        this.f707b.e(r5, this.d);
        return;
    L6:
        String r10 = this.f708c;
        this.f707b.i(this.d, r10);
    }
}
