package androidx.core.location;

import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Executor f463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f464c;
    public final /* synthetic */ Object d;

    public /* synthetic */ d(Object r5, Executor r10, Object r11, int r12) {
        this.f462a = r12;
        this.f464c = r5;
        this.f463b = r10;
        this.d = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f462a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        Executor r5 = this.f463b;
        GnssStatus r10 = (GnssStatus) this.d;
        LocationManagerCompat.PreRGnssStatusTransport.d((LocationManagerCompat.PreRGnssStatusTransport) this.f464c, r5, r10);
        return;
    L6:
        Executor r11 = this.f463b;
        GnssStatusCompat r12 = (GnssStatusCompat) this.d;
        LocationManagerCompat.GpsStatusTransport.d((LocationManagerCompat.GpsStatusTransport) this.f464c, r11, r12);
        return;
    L8:
        Executor r13 = this.f463b;
        GnssMeasurementsEvent r14 = (GnssMeasurementsEvent) this.d;
        LocationManagerCompat.GnssMeasurementsTransport.a((LocationManagerCompat.GnssMeasurementsTransport) this.f464c, r13, r14);
    }
}
