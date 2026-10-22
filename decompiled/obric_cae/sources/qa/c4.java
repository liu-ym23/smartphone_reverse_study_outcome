package qa;

import android.location.GnssStatus;
import com.amap.api.location.AMapLocation;

/* JADX INFO: loaded from: classes.dex */
public final class c4 extends GnssStatus.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d4 f10290a;

    public c4(d4 r8) {
        this.f10290a = r8;
    }

    @Override // android.location.GnssStatus.Callback
    public final void onFirstFix(int r8) {
        AMapLocation r10 = d4.A;
    }

    @Override // android.location.GnssStatus.Callback
    public final void onSatelliteStatusChanged(GnssStatus r8) {
        d4 r10 = this.f10290a;
        r10.getClass();
        int r11 = 0;
        if (r8 != null) goto L20;
    L16:
        r10.f10323q = r11;
        return;
    L20:
        int r12 = r8.getSatelliteCount();     // Catch: Throwable -> L14
        int r13 = 0;
    L6:
        if (r11 >= r12) goto L13;
        if (r8.usedInFix(r11) == false) goto L10;
        r13 = r13 + 1;
    L10:
        r11 = r11 + 1;
    L11:
        th = th;
        r11 = r13;
    L15:
        t3.g("GpsLocation_Gnss", "GPS_EVENT_SATELLITE_STATUS", th);
        goto L16
    L13:
        r11 = r13;
    L14:
        th = th;
        goto L15
    }

    @Override // android.location.GnssStatus.Callback
    public final void onStarted() {
        AMapLocation r8 = d4.A;
    }

    @Override // android.location.GnssStatus.Callback
    public final void onStopped() {
        this.f10290a.f10323q = 0;
    }
}
