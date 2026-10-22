package androidx.core.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.os.Build;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
class GpsStatusWrapper extends GnssStatusCompat {
    private static final int BEIDOU_PRN_COUNT = 35;
    private static final int BEIDOU_PRN_OFFSET = 200;
    private static final int GLONASS_PRN_COUNT = 24;
    private static final int GLONASS_PRN_OFFSET = 64;
    private static final int GPS_PRN_COUNT = 32;
    private static final int GPS_PRN_OFFSET = 0;
    private static final int QZSS_SVID_MAX = 200;
    private static final int QZSS_SVID_MIN = 193;
    private static final int SBAS_PRN_MAX = 64;
    private static final int SBAS_PRN_MIN = 33;
    private static final int SBAS_PRN_OFFSET = -87;

    @GuardedBy("mWrapped")
    private Iterator<GpsSatellite> mCachedIterator;

    @GuardedBy("mWrapped")
    private int mCachedIteratorPosition;

    @GuardedBy("mWrapped")
    private GpsSatellite mCachedSatellite;

    @GuardedBy("mWrapped")
    private int mCachedSatelliteCount;
    private final GpsStatus mWrapped;

    GpsStatusWrapper(GpsStatus r10) {
        GpsStatus r11 = (GpsStatus) Preconditions.checkNotNull(r10);
        this.mWrapped = r11;
        this.mCachedSatelliteCount = -1;
        this.mCachedIterator = r11.getSatellites().iterator();
        this.mCachedIteratorPosition = -1;
        this.mCachedSatellite = null;
    }

    private static int getConstellationFromPrn(int r10) {
        if (r10 <= 0) goto L8;
        if (r10 > 32) goto L8;
        return 1;
    L8:
        if (r10 < 33) goto L12;
        if (r10 > 64) goto L12;
        return 2;
    L12:
        if (r10 <= 64) goto L18;
        if (r10 > 88) goto L18;
        return 3;
    L18:
        if (r10 <= 200) goto L24;
        if (r10 > 235) goto L24;
        return 5;
    L24:
        if (r10 < QZSS_SVID_MIN) goto L28;
        if (r10 > 200) goto L30;
        return 4;
    L30:
        return 0;
    L28:
        return 0;
    }

    private GpsSatellite getSatellite(int r10) {
        GpsStatus r11 = this.mWrapped;
        monitor-enter(r11);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (r10 >= this.mCachedIteratorPosition) goto L7;
        this.mCachedIterator = this.mWrapped.getSatellites().iterator();     // Catch: Throwable -> L17
        this.mCachedIteratorPosition = -1;     // Catch: Throwable -> L17
    L7:
        int r12 = this.mCachedIteratorPosition;     // Catch: Throwable -> L17
        if (r12 >= r10) goto L13;
        this.mCachedIteratorPosition = r12 + 1;     // Catch: Throwable -> L17
        if (this.mCachedIterator.hasNext() == false) goto L11;
        this.mCachedSatellite = this.mCachedIterator.next();     // Catch: Throwable -> L17
        goto L7
    L11:
        this.mCachedSatellite = null;     // Catch: Throwable -> L17
    L13:
        GpsSatellite r13 = this.mCachedSatellite;     // Catch: Throwable -> L17
        monitor-exit(r11);     // Catch: Throwable -> L17
        return (GpsSatellite) Preconditions.checkNotNull(r13);
    }

    private static int getSvidFromPrn(int r10) {
        int r11 = getConstellationFromPrn(r10);
        if (r11 == 2) goto L12;
        if (r11 == 3) goto L14;
        if (r11 == 5) goto L13;
        return r10;
    L13:
        return r10 - 200;
    L14:
        return r10 - 64;
    L12:
        return r10 + 87;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof GpsStatusWrapper) == true) goto L10;
        return false;
    L10:
        return this.mWrapped.equals(((GpsStatusWrapper) r10).mWrapped);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getAzimuthDegrees(int r10) {
        return getSatellite(r10).getAzimuth();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getBasebandCn0DbHz(int r10) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCarrierFrequencyHz(int r10) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCn0DbHz(int r10) {
        return getSatellite(r10).getSnr();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getConstellationType(int r10) {
        if (Build.VERSION.SDK_INT >= 24) goto L7;
        return 1;
    L7:
        return getConstellationFromPrn(getSatellite(r10).getPrn());
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getElevationDegrees(int r10) {
        return getSatellite(r10).getElevation();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSatelliteCount() {
        GpsStatus r10 = this.mWrapped;
        monitor-enter(r10);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mCachedSatelliteCount != (-1)) goto L11;
        Iterator<GpsSatellite> r11 = this.mWrapped.getSatellites().iterator();     // Catch: Throwable -> L14
    L8:
        if (r11.hasNext() == false) goto L10;
        GpsSatellite r12 = r11.next();     // Catch: Throwable -> L14
        this.mCachedSatelliteCount++;     // Catch: Throwable -> L14
        goto L8
    L10:
        this.mCachedSatelliteCount++;     // Catch: Throwable -> L14
    L11:
        int r13 = this.mCachedSatelliteCount;     // Catch: Throwable -> L14
        monitor-exit(r10);     // Catch: Throwable -> L14
        return r13;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSvid(int r10) {
        int r11 = Build.VERSION.SDK_INT;
        int r12 = getSatellite(r10).getPrn();
        if (r11 >= 24) goto L6;
        return r12;
    L6:
        return getSvidFromPrn(r12);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasAlmanacData(int r10) {
        return getSatellite(r10).hasAlmanac();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasBasebandCn0DbHz(int r10) {
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasCarrierFrequencyHz(int r10) {
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasEphemerisData(int r10) {
        return getSatellite(r10).hasEphemeris();
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean usedInFix(int r10) {
        return getSatellite(r10).usedInFix();
    }
}
