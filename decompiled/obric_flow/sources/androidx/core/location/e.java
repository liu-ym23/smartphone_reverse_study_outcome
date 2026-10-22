package androidx.core.location;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Executor f466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f467c;
    public final /* synthetic */ Object d;

    public /* synthetic */ e(Object r5, Executor r10, int r11, int r12) {
        this.f465a = r12;
        this.d = r5;
        this.f466b = r10;
        this.f467c = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f465a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        Executor r5 = this.f466b;
        int r10 = this.f467c;
        LocationManagerCompat.PreRGnssStatusTransport.b((LocationManagerCompat.PreRGnssStatusTransport) this.d, r5, r10);
        return;
    L6:
        Executor r11 = this.f466b;
        int r12 = this.f467c;
        LocationManagerCompat.GpsStatusTransport.c((LocationManagerCompat.GpsStatusTransport) this.d, r11, r12);
        return;
    L8:
        Executor r13 = this.f466b;
        int r14 = this.f467c;
        LocationManagerCompat.GnssMeasurementsTransport.b((LocationManagerCompat.GnssMeasurementsTransport) this.d, r13, r14);
    }
}
