package androidx.core.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
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

    public GpsStatusWrapper(GpsStatus r5) {
        GpsStatus r10 = (GpsStatus) Preconditions.checkNotNull(r5);
        this.mWrapped = r10;
        this.mCachedSatelliteCount = -1;
        this.mCachedIterator = r10.getSatellites().iterator();
        this.mCachedIteratorPosition = -1;
        this.mCachedSatellite = null;
    }

    private static int getConstellationFromPrn(int r5) {
        if (r5 <= 0) goto L8;
        if (r5 > 32) goto L8;
        return 1;
    L8:
        if (r5 < 33) goto L12;
        if (r5 > 64) goto L12;
        return 2;
    L12:
        if (r5 <= 64) goto L18;
        if (r5 > 88) goto L18;
        return 3;
    L18:
        if (r5 <= 200) goto L24;
        if (r5 > 235) goto L24;
        return 5;
    L24:
        if (r5 < QZSS_SVID_MIN) goto L28;
        if (r5 > 200) goto L30;
        return 4;
    L30:
        return 0;
    L28:
        return 0;
    }

    private GpsSatellite getSatellite(int r5) {
        GpsStatus r10 = this.mWrapped;
        monitor-enter(r10);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (r5 >= this.mCachedIteratorPosition) goto L9;
        this.mCachedIterator = this.mWrapped.getSatellites().iterator();     // Catch: Throwable -> L7
        this.mCachedIteratorPosition = -1;     // Catch: Throwable -> L7
    L9:
        int r11 = this.mCachedIteratorPosition;     // Catch: Throwable -> L7
        if (r11 >= r5) goto L15;
        this.mCachedIteratorPosition = r11 + 1;     // Catch: Throwable -> L7
        if (this.mCachedIterator.hasNext() == false) goto L13;
        this.mCachedSatellite = this.mCachedIterator.next();     // Catch: Throwable -> L7
        goto L9
    L13:
        this.mCachedSatellite = null;     // Catch: Throwable -> L7
    L15:
        GpsSatellite r12 = this.mCachedSatellite;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return (GpsSatellite) Preconditions.checkNotNull(r12);
    }

    private static int getSvidFromPrn(int r5) {
        int r10 = getConstellationFromPrn(r5);
        if (r10 == 2) goto L12;
        if (r10 == 3) goto L14;
        if (r10 == 5) goto L13;
        return r5;
    L13:
        return r5 - 200;
    L14:
        return r5 - 64;
    L12:
        return r5 + 87;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof GpsStatusWrapper) == true) goto L10;
        return false;
    L10:
        return this.mWrapped.equals(((GpsStatusWrapper) r5).mWrapped);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getAzimuthDegrees(int r5) {
        return getSatellite(r5).getAzimuth();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getBasebandCn0DbHz(int r5) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCarrierFrequencyHz(int r5) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCn0DbHz(int r5) {
        return getSatellite(r5).getSnr();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getConstellationType(int r5) {
        return getConstellationFromPrn(getSatellite(r5).getPrn());
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getElevationDegrees(int r5) {
        return getSatellite(r5).getElevation();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSatelliteCount() {
        GpsStatus r5 = this.mWrapped;
        monitor-enter(r5);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mCachedSatelliteCount != (-1)) goto L13;
        Iterator<GpsSatellite> r10 = this.mWrapped.getSatellites().iterator();     // Catch: Throwable -> L10
    L8:
        if (r10.hasNext() == false) goto L12;
        GpsSatellite r11 = r10.next();     // Catch: Throwable -> L10
        this.mCachedSatelliteCount++;     // Catch: Throwable -> L10
        goto L8
    L12:
        this.mCachedSatelliteCount++;     // Catch: Throwable -> L10
    L13:
        int r12 = this.mCachedSatelliteCount;     // Catch: Throwable -> L10
        monitor-exit(r5);     // Catch: Throwable -> L10
        return r12;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSvid(int r5) {
        return getSvidFromPrn(getSatellite(r5).getPrn());
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasAlmanacData(int r5) {
        return getSatellite(r5).hasAlmanac();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasBasebandCn0DbHz(int r5) {
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasCarrierFrequencyHz(int r5) {
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasEphemerisData(int r5) {
        return getSatellite(r5).hasEphemeris();
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean usedInFix(int r5) {
        return getSatellite(r5).usedInFix();
    }
}
