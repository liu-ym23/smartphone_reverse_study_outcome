package androidx.core.location;

import android.location.GnssStatus;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
@RestrictTo({RestrictTo.Scope.LIBRARY})
class GnssStatusWrapper extends GnssStatusCompat {
    private final GnssStatus mWrapped;

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static float getCarrierFrequencyHz(GnssStatus r5, int r10) {
            return r5.getCarrierFrequencyHz(r10);
        }

        @DoNotInline
        public static boolean hasCarrierFrequencyHz(GnssStatus r5, int r10) {
            return r5.hasCarrierFrequencyHz(r10);
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        public static float getBasebandCn0DbHz(GnssStatus r5, int r10) {
            return r5.getBasebandCn0DbHz(r10);
        }

        @DoNotInline
        public static boolean hasBasebandCn0DbHz(GnssStatus r5, int r10) {
            return r5.hasBasebandCn0DbHz(r10);
        }
    }

    public GnssStatusWrapper(Object r5) {
        this.mWrapped = (GnssStatus) Preconditions.checkNotNull((GnssStatus) r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof GnssStatusWrapper) == true) goto L10;
        return false;
    L10:
        return this.mWrapped.equals(((GnssStatusWrapper) r5).mWrapped);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getAzimuthDegrees(int r5) {
        return this.mWrapped.getAzimuthDegrees(r5);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getBasebandCn0DbHz(int r5) {
        return Api30Impl.getBasebandCn0DbHz(this.mWrapped, r5);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCarrierFrequencyHz(int r5) {
        return Api26Impl.getCarrierFrequencyHz(this.mWrapped, r5);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCn0DbHz(int r5) {
        return this.mWrapped.getCn0DbHz(r5);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getConstellationType(int r5) {
        return this.mWrapped.getConstellationType(r5);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getElevationDegrees(int r5) {
        return this.mWrapped.getElevationDegrees(r5);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSatelliteCount() {
        return this.mWrapped.getSatelliteCount();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSvid(int r5) {
        return this.mWrapped.getSvid(r5);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasAlmanacData(int r5) {
        return this.mWrapped.hasAlmanacData(r5);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasBasebandCn0DbHz(int r5) {
        return Api30Impl.hasBasebandCn0DbHz(this.mWrapped, r5);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasCarrierFrequencyHz(int r5) {
        return Api26Impl.hasCarrierFrequencyHz(this.mWrapped, r5);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasEphemerisData(int r5) {
        return this.mWrapped.hasEphemerisData(r5);
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean usedInFix(int r5) {
        return this.mWrapped.usedInFix(r5);
    }
}
