package n4a;

import android.location.GnssStatus;
import android.os.Build;
import com.amap.api.location.AMapLocation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o4 extends GnssStatus.Callback {
    public final /* synthetic */ q4 a;

    public o4(q4 r1) {
        this.a = r1;
    }

    @Override // android.location.GnssStatus.Callback
    public final void onFirstFix(int r1) {
        AMapLocation r2 = q4.D;
    }

    @Override // android.location.GnssStatus.Callback
    public final void onStarted() {
        AMapLocation r0 = q4.D;
    }

    @Override // android.location.GnssStatus.Callback
    public final void onStopped() {
        this.a.q = 0;
    }

    @Override // android.location.GnssStatus.Callback
    public final void onSatelliteStatusChanged(GnssStatus r6) {
        q4 r0 = this.a;
        r0.getClass();
        int r1 = 0;
        if (r6 != null) goto L22;
    L18:
        r0.q = r1;
        return;
    L22:
    L16:
        th = th;
    L17:
        c4.g(th, "GpsLocation_Gnss", "GPS_EVENT_SATELLITE_STATUS");
        goto L18
    L5:
        if (Build.VERSION.SDK_INT < 24) goto L18;
        int r2 = r6.getSatelliteCount();     // Catch: Throwable -> L16
        int r3 = 0;
    L8:
        if (r1 >= r2) goto L15;
        if (r6.usedInFix(r1) == false) goto L12;
        r3 = r3 + 1;
    L12:
        r1 = r1 + 1;
    L13:
        th = th;
        r1 = r3;
        goto L17
    L15:
        r1 = r3;
        goto L18
    }
}
