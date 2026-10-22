package n4a;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.LocationManager;
import com.amap.api.location.AMapLocation;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p4 implements GpsStatus.Listener {
    public final /* synthetic */ q4 a;

    public p4(q4 r1) {
        this.a = r1;
    }

    @Override // android.location.GpsStatus.Listener
    public final void onGpsStatusChanged(int r6) {
        q4 r1 = this.a;     // Catch: Throwable -> L37
        LocationManager r2 = r1.c;     // Catch: Throwable -> L37
        if (r2 != null) goto L6;
        return;
    L6:
        r1.r = r2.getGpsStatus(r1.r);     // Catch: Throwable -> L37
        if (r6 == 1) goto L35;
        int r3 = 0;
        if (r6 != 2) goto L11;
        this.a.q = 0;     // Catch: Throwable -> L37
        return;
    L11:
        if (r6 != 3) goto L13;
        AMapLocation r7 = q4.D;     // Catch: Throwable -> L37
        return;
    L13:
        if (r6 != 4) goto L49;
        q4 r8 = this.a;     // Catch: Throwable -> L37
        r8.getClass();     // Catch: Throwable -> L37
        GpsStatus r4 = r8.r;     // Catch: Throwable -> L27
        if (r4 == null) goto L29;
        Iterable<GpsSatellite> r5 = r4.getSatellites();     // Catch: Throwable -> L27
        if (r5 == null) goto L29;
        Iterator<GpsSatellite> r9 = r5.iterator();     // Catch: Throwable -> L27
        int r10 = r8.r.getMaxSatellites();     // Catch: Throwable -> L27
    L22:
        if (r9.hasNext() == false) goto L29;
        if (r3 >= r10) goto L29;
        if (r9.next().usedInFix() == false) goto L22;
        r3 = r3 + 1;
        goto L22
    L29:
        r8.q = r3;     // Catch: Throwable -> L37
        return;
    L27:
        th = move-exception;
        c4.g(th, "GpsLocation", "GPS_EVENT_SATELLITE_STATUS");     // Catch: Throwable -> L37
        goto L29
    L49:
        return;
    L35:
        AMapLocation r11 = q4.D;     // Catch: Throwable -> L37
        return;
    L37:
        th = move-exception;
        new StringBuilder("GpsLocation | onGpsStatusChanged error: ").append(th.getMessage());
        c4.g(th, "GpsLocation", "onGpsStatusChanged");
    }
}
