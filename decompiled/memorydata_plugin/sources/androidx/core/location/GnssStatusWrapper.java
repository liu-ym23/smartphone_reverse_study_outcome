package androidx.core.location;

import android.location.GnssStatus;
import android.os.Build;
import androidx.core.util.Preconditions;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class GnssStatusWrapper extends GnssStatusCompat {
    private final GnssStatus mWrapped;

    static class Api26Impl {
        private Api26Impl() {
        }

        static float getCarrierFrequencyHz(GnssStatus r0, int r1) {
            return r0.getCarrierFrequencyHz(r1);
        }

        static boolean hasCarrierFrequencyHz(GnssStatus r0, int r1) {
            return r0.hasCarrierFrequencyHz(r1);
        }
    }

    static class Api30Impl {
        private Api30Impl() {
        }

        static float getBasebandCn0DbHz(GnssStatus r0, int r1) {
            return r0.getBasebandCn0DbHz(r1);
        }

        static boolean hasBasebandCn0DbHz(GnssStatus r0, int r1) {
            return r0.hasBasebandCn0DbHz(r1);
        }
    }

    GnssStatusWrapper(Object r3) {
        this.mWrapped = (GnssStatus) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull((GnssStatus) ZeusTransformUtils.preCheckCast(r3, GnssStatus.class, "com.obric.memorydata.plugin")), GnssStatus.class, "com.obric.memorydata.plugin");
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, GnssStatusWrapper.class) == true) goto L10;
        return false;
    L10:
        GnssStatusWrapper r4 = (GnssStatusWrapper) ZeusTransformUtils.preCheckCast(r3, GnssStatusWrapper.class, "com.obric.memorydata.plugin");
        return this.mWrapped.equals(r4.mWrapped);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getAzimuthDegrees(int r1) {
        return this.mWrapped.getAzimuthDegrees(r1);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getBasebandCn0DbHz(int r3) {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return Api30Impl.getBasebandCn0DbHz(this.mWrapped, r3);
    L7:
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCarrierFrequencyHz(int r3) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.getCarrierFrequencyHz(this.mWrapped, r3);
    L7:
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCn0DbHz(int r1) {
        return this.mWrapped.getCn0DbHz(r1);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getConstellationType(int r1) {
        return this.mWrapped.getConstellationType(r1);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getElevationDegrees(int r1) {
        return this.mWrapped.getElevationDegrees(r1);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSatelliteCount() {
        return this.mWrapped.getSatelliteCount();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSvid(int r1) {
        return this.mWrapped.getSvid(r1);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasAlmanacData(int r1) {
        return this.mWrapped.hasAlmanacData(r1);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasBasebandCn0DbHz(int r3) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        return false;
    L5:
        return Api30Impl.hasBasebandCn0DbHz(this.mWrapped, r3);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasCarrierFrequencyHz(int r3) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return false;
    L5:
        return Api26Impl.hasCarrierFrequencyHz(this.mWrapped, r3);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasEphemerisData(int r1) {
        return this.mWrapped.hasEphemerisData(r1);
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean usedInFix(int r1) {
        return this.mWrapped.usedInFix(r1);
    }
}
