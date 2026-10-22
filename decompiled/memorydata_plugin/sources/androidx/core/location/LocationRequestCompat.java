package androidx.core.location;

import android.location.LocationRequest;
import android.os.Build;
import androidx.core.util.Preconditions;
import androidx.core.util.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class LocationRequestCompat {
    private static final long IMPLICIT_MIN_UPDATE_INTERVAL = -1;
    public static final long PASSIVE_INTERVAL = Long.MAX_VALUE;
    public static final int QUALITY_BALANCED_POWER_ACCURACY = 102;
    public static final int QUALITY_HIGH_ACCURACY = 100;
    public static final int QUALITY_LOW_POWER = 104;
    final long mDurationMillis;
    final long mIntervalMillis;
    final long mMaxUpdateDelayMillis;
    final int mMaxUpdates;
    final float mMinUpdateDistanceMeters;
    final long mMinUpdateIntervalMillis;
    final int mQuality;

    private static class Api19Impl {
        private static Method sCreateFromDeprecatedProviderMethod;
        private static Class<?> sLocationRequestClass;
        private static Method sSetExpireInMethod;
        private static Method sSetFastestIntervalMethod;
        private static Method sSetNumUpdatesMethod;
        private static Method sSetQualityMethod;

        private Api19Impl() {
        }

        public static Object toLocationRequest(LocationRequestCompat r10, String r11) {
            if (Build.VERSION.SDK_INT >= 19) goto L34;
        L32:
            return null;
        L34:
            if (sLocationRequestClass != null) goto L8;
            sLocationRequestClass = ZeusTransformUtils.forName("android.location.LocationRequest", "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        L8:
            if (sCreateFromDeprecatedProviderMethod != null) goto L10;
            Method r0 = sLocationRequestClass.getDeclaredMethod("createFromDeprecatedProvider", new Class[]{String.class, Long.TYPE, Float.TYPE, Boolean.TYPE});     // Catch: Throwable -> L33
            sCreateFromDeprecatedProviderMethod = r0;     // Catch: Throwable -> L33
            r0.setAccessible(true);     // Catch: Throwable -> L33
        L10:
            Object r12 = sCreateFromDeprecatedProviderMethod.invoke(null, new Object[]{r11, Long.valueOf(r10.getIntervalMillis()), Float.valueOf(r10.getMinUpdateDistanceMeters()), false});     // Catch: Throwable -> L33
            if (r12 != null) goto L14;
            return null;
        L14:
            if (sSetQualityMethod != null) goto L16;
            Method r1 = sLocationRequestClass.getDeclaredMethod("setQuality", new Class[]{Integer.TYPE});     // Catch: Throwable -> L33
            sSetQualityMethod = r1;     // Catch: Throwable -> L33
            r1.setAccessible(true);     // Catch: Throwable -> L33
        L16:
            sSetQualityMethod.invoke(r12, new Object[]{Integer.valueOf(r10.getQuality())});     // Catch: Throwable -> L33
            if (sSetFastestIntervalMethod != null) goto L19;
            Method r2 = sLocationRequestClass.getDeclaredMethod("setFastestInterval", new Class[]{Long.TYPE});     // Catch: Throwable -> L33
            sSetFastestIntervalMethod = r2;     // Catch: Throwable -> L33
            r2.setAccessible(true);     // Catch: Throwable -> L33
        L19:
            sSetFastestIntervalMethod.invoke(r12, new Object[]{Long.valueOf(r10.getMinUpdateIntervalMillis())});     // Catch: Throwable -> L33
            if (r10.getMaxUpdates() >= Integer.MAX_VALUE) goto L26;
            if (sSetNumUpdatesMethod != null) goto L24;
            Method r3 = sLocationRequestClass.getDeclaredMethod("setNumUpdates", new Class[]{Integer.TYPE});     // Catch: Throwable -> L33
            sSetNumUpdatesMethod = r3;     // Catch: Throwable -> L33
            r3.setAccessible(true);     // Catch: Throwable -> L33
        L24:
            sSetNumUpdatesMethod.invoke(r12, new Object[]{Integer.valueOf(r10.getMaxUpdates())});     // Catch: Throwable -> L33
        L26:
            if (r10.getDurationMillis() < Long.MAX_VALUE) goto L28;
        L31:
            return r12;
        L28:
            if (sSetExpireInMethod != null) goto L30;
            Method r4 = sLocationRequestClass.getDeclaredMethod("setExpireIn", new Class[]{Long.TYPE});     // Catch: Throwable -> L33
            sSetExpireInMethod = r4;     // Catch: Throwable -> L33
            r4.setAccessible(true);     // Catch: Throwable -> L33
        L30:
            sSetExpireInMethod.invoke(r12, new Object[]{Long.valueOf(r10.getDurationMillis())});     // Catch: Throwable -> L33
            goto L31
        }
    }

    private static class Api31Impl {
        private Api31Impl() {
        }

        public static LocationRequest toLocationRequest(LocationRequestCompat r3) {
            return new LocationRequest.Builder(r3.getIntervalMillis()).setQuality(r3.getQuality()).setMinUpdateIntervalMillis(r3.getMinUpdateIntervalMillis()).setDurationMillis(r3.getDurationMillis()).setMaxUpdates(r3.getMaxUpdates()).setMinUpdateDistanceMeters(r3.getMinUpdateDistanceMeters()).setMaxUpdateDelayMillis(r3.getMaxUpdateDelayMillis()).build();
        }
    }

    public static final class Builder {
        private long mDurationMillis;
        private long mIntervalMillis;
        private long mMaxUpdateDelayMillis;
        private int mMaxUpdates;
        private float mMinUpdateDistanceMeters;
        private long mMinUpdateIntervalMillis;
        private int mQuality;

        public Builder(long r1) {
            setIntervalMillis(r1);
            this.mQuality = 102;
            this.mDurationMillis = Long.MAX_VALUE;
            this.mMaxUpdates = Integer.MAX_VALUE;
            this.mMinUpdateIntervalMillis = -1;
            this.mMinUpdateDistanceMeters = 0.0f;
            this.mMaxUpdateDelayMillis = 0;
        }

        public Builder(LocationRequestCompat r3) {
            this.mIntervalMillis = r3.mIntervalMillis;
            this.mQuality = r3.mQuality;
            this.mDurationMillis = r3.mDurationMillis;
            this.mMaxUpdates = r3.mMaxUpdates;
            this.mMinUpdateIntervalMillis = r3.mMinUpdateIntervalMillis;
            this.mMinUpdateDistanceMeters = r3.mMinUpdateDistanceMeters;
            this.mMaxUpdateDelayMillis = r3.mMaxUpdateDelayMillis;
        }

        public LocationRequestCompat build() {
            if (this.mIntervalMillis == Long.MAX_VALUE) goto L5;
        L8:
            boolean r0 = true;
        L9:
            Preconditions.checkState(r0, "passive location requests must have an explicit minimum update interval");
            long r3 = this.mIntervalMillis;
            return new LocationRequestCompat(r3, this.mQuality, this.mDurationMillis, this.mMaxUpdates, Math.min(this.mMinUpdateIntervalMillis, r3), this.mMinUpdateDistanceMeters, this.mMaxUpdateDelayMillis);
        L5:
            if (this.mMinUpdateIntervalMillis != (-1)) goto L8;
            r0 = false;
            goto L9
        }

        public Builder clearMinUpdateIntervalMillis() {
            this.mMinUpdateIntervalMillis = -1;
            return this;
        }

        public Builder setDurationMillis(long r8) {
            this.mDurationMillis = Preconditions.checkArgumentInRange(r8, 1, Long.MAX_VALUE, "durationMillis");
            return this;
        }

        public Builder setIntervalMillis(long r8) {
            this.mIntervalMillis = Preconditions.checkArgumentInRange(r8, 0, Long.MAX_VALUE, "intervalMillis");
            return this;
        }

        public Builder setMaxUpdateDelayMillis(long r8) {
            this.mMaxUpdateDelayMillis = r8;
            this.mMaxUpdateDelayMillis = Preconditions.checkArgumentInRange(r8, 0, Long.MAX_VALUE, "maxUpdateDelayMillis");
            return this;
        }

        public Builder setMaxUpdates(int r4) {
            this.mMaxUpdates = Preconditions.checkArgumentInRange(r4, 1, Integer.MAX_VALUE, "maxUpdates");
            return this;
        }

        public Builder setMinUpdateDistanceMeters(float r4) {
            this.mMinUpdateDistanceMeters = r4;
            this.mMinUpdateDistanceMeters = Preconditions.checkArgumentInRange(r4, 0.0f, Float.MAX_VALUE, "minUpdateDistanceMeters");
            return this;
        }

        public Builder setMinUpdateIntervalMillis(long r8) {
            this.mMinUpdateIntervalMillis = Preconditions.checkArgumentInRange(r8, 0, Long.MAX_VALUE, "minUpdateIntervalMillis");
            return this;
        }

        public Builder setQuality(int r5) {
            if (r5 != 104) goto L5;
        L10:
            boolean r2 = true;
        L11:
            Preconditions.checkArgument(r2, "quality must be a defined QUALITY constant, not %d", new Object[]{Integer.valueOf(r5)});
            this.mQuality = r5;
            return this;
        L5:
            if (r5 == 102) goto L10;
            if (r5 == 100) goto L10;
            r2 = false;
            goto L11
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Quality {
    }

    LocationRequestCompat(long r1, int r3, long r4, int r6, long r7, float r9, long r10) {
        this.mIntervalMillis = r1;
        this.mQuality = r3;
        this.mMinUpdateIntervalMillis = r7;
        this.mDurationMillis = r4;
        this.mMaxUpdates = r6;
        this.mMinUpdateDistanceMeters = r9;
        this.mMaxUpdateDelayMillis = r10;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, LocationRequestCompat.class) == true) goto L8;
        return false;
    L8:
        LocationRequestCompat r10 = (LocationRequestCompat) ZeusTransformUtils.preCheckCast(r9, LocationRequestCompat.class, "com.obric.memorydata.plugin");
        if (this.mQuality != r10.mQuality) goto L24;
        if (this.mIntervalMillis != r10.mIntervalMillis) goto L24;
        if (this.mMinUpdateIntervalMillis != r10.mMinUpdateIntervalMillis) goto L24;
        if (this.mDurationMillis != r10.mDurationMillis) goto L24;
        if (this.mMaxUpdates != r10.mMaxUpdates) goto L24;
        if (Float.compare(r10.mMinUpdateDistanceMeters, this.mMinUpdateDistanceMeters) != 0) goto L24;
        if (this.mMaxUpdateDelayMillis != r10.mMaxUpdateDelayMillis) goto L24;
        return true;
    L24:
        return false;
    }

    public long getDurationMillis() {
        return this.mDurationMillis;
    }

    public long getIntervalMillis() {
        return this.mIntervalMillis;
    }

    public long getMaxUpdateDelayMillis() {
        return this.mMaxUpdateDelayMillis;
    }

    public int getMaxUpdates() {
        return this.mMaxUpdates;
    }

    public float getMinUpdateDistanceMeters() {
        return this.mMinUpdateDistanceMeters;
    }

    public long getMinUpdateIntervalMillis() {
        long r0 = this.mMinUpdateIntervalMillis;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        return this.mIntervalMillis;
    }

    public int getQuality() {
        return this.mQuality;
    }

    public int hashCode() {
        int r0 = this.mQuality * 31;
        long r1 = this.mIntervalMillis;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.mMinUpdateIntervalMillis;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public LocationRequest toLocationRequest() {
        return Api31Impl.toLocationRequest(this);
    }

    public LocationRequest toLocationRequest(String r3) {
        if (Build.VERSION.SDK_INT < 31) goto L7;
        return toLocationRequest();
    L7:
        return (LocationRequest) ZeusTransformUtils.preCheckCast(Api19Impl.toLocationRequest(this, r3), LocationRequest.class, "com.obric.memorydata.plugin");
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("Request[");
        if (this.mIntervalMillis == Long.MAX_VALUE) goto L14;
        r0.append("@");
        TimeUtils.formatDuration(this.mIntervalMillis, r0);
        int r1 = this.mQuality;
        if (r1 != 100) goto L7;
        String r2 = " HIGH_ACCURACY";
    L15:
        r0.append(r2);
    L17:
        if (this.mDurationMillis == Long.MAX_VALUE) goto L20;
        r0.append(", duration=");
        TimeUtils.formatDuration(this.mDurationMillis, r0);
    L20:
        if (this.mMaxUpdates == Integer.MAX_VALUE) goto L22;
        r0.append(", maxUpdates=").append(this.mMaxUpdates);
    L22:
        long r3 = this.mMinUpdateIntervalMillis;
        if (r3 == (-1)) goto L28;
        if (r3 >= this.mIntervalMillis) goto L28;
        r0.append(", minUpdateInterval=");
        TimeUtils.formatDuration(this.mMinUpdateIntervalMillis, r0);
    L28:
        if (this.mMinUpdateDistanceMeters <= 0.0d) goto L31;
        r0.append(", minUpdateDistance=").append(this.mMinUpdateDistanceMeters);
    L31:
        if ((this.mMaxUpdateDelayMillis / 2) <= this.mIntervalMillis) goto L33;
        r0.append(", maxUpdateDelay=");
        TimeUtils.formatDuration(this.mMaxUpdateDelayMillis, r0);
    L33:
        r0.append(']');
        return r0.toString();
    L7:
        if (r1 != 102) goto L9;
        r2 = " BALANCED";
        goto L15
    L9:
        if (r1 != 104) goto L17;
        r2 = " LOW_POWER";
        goto L15
    L14:
        r2 = "PASSIVE";
        goto L15
    }
}
