package androidx.core.location;

import android.annotation.SuppressLint;
import android.location.LocationRequest;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.core.util.TimeUtils;
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

    @RequiresApi(19)
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
            sLocationRequestClass = Class.forName("android.location.LocationRequest");     // Catch: Throwable -> L33
        L8:
            if (sCreateFromDeprecatedProviderMethod != null) goto L10;
            Method r12 = sLocationRequestClass.getDeclaredMethod("createFromDeprecatedProvider", new Class[]{String.class, Long.TYPE, Float.TYPE, Boolean.TYPE});     // Catch: Throwable -> L33
            sCreateFromDeprecatedProviderMethod = r12;     // Catch: Throwable -> L33
            r12.setAccessible(true);     // Catch: Throwable -> L33
        L10:
            Object r13 = sCreateFromDeprecatedProviderMethod.invoke(null, new Object[]{r11, Long.valueOf(r10.getIntervalMillis()), Float.valueOf(r10.getMinUpdateDistanceMeters()), Boolean.FALSE});     // Catch: Throwable -> L33
            if (r13 != null) goto L14;
            return null;
        L14:
            if (sSetQualityMethod != null) goto L16;
            Method r14 = sLocationRequestClass.getDeclaredMethod("setQuality", new Class[]{Integer.TYPE});     // Catch: Throwable -> L33
            sSetQualityMethod = r14;     // Catch: Throwable -> L33
            r14.setAccessible(true);     // Catch: Throwable -> L33
        L16:
            sSetQualityMethod.invoke(r13, new Object[]{Integer.valueOf(r10.getQuality())});     // Catch: Throwable -> L33
            if (sSetFastestIntervalMethod != null) goto L19;
            Method r15 = sLocationRequestClass.getDeclaredMethod("setFastestInterval", new Class[]{Long.TYPE});     // Catch: Throwable -> L33
            sSetFastestIntervalMethod = r15;     // Catch: Throwable -> L33
            r15.setAccessible(true);     // Catch: Throwable -> L33
        L19:
            sSetFastestIntervalMethod.invoke(r13, new Object[]{Long.valueOf(r10.getMinUpdateIntervalMillis())});     // Catch: Throwable -> L33
            if (r10.getMaxUpdates() >= Integer.MAX_VALUE) goto L26;
            if (sSetNumUpdatesMethod != null) goto L24;
            Method r16 = sLocationRequestClass.getDeclaredMethod("setNumUpdates", new Class[]{Integer.TYPE});     // Catch: Throwable -> L33
            sSetNumUpdatesMethod = r16;     // Catch: Throwable -> L33
            r16.setAccessible(true);     // Catch: Throwable -> L33
        L24:
            sSetNumUpdatesMethod.invoke(r13, new Object[]{Integer.valueOf(r10.getMaxUpdates())});     // Catch: Throwable -> L33
        L26:
            if (r10.getDurationMillis() < Long.MAX_VALUE) goto L28;
        L31:
            return r13;
        L28:
            if (sSetExpireInMethod != null) goto L30;
            Method r17 = sLocationRequestClass.getDeclaredMethod("setExpireIn", new Class[]{Long.TYPE});     // Catch: Throwable -> L33
            sSetExpireInMethod = r17;     // Catch: Throwable -> L33
            r17.setAccessible(true);     // Catch: Throwable -> L33
        L30:
            sSetExpireInMethod.invoke(r13, new Object[]{Long.valueOf(r10.getDurationMillis())});     // Catch: Throwable -> L33
            goto L31
        }
    }

    @RequiresApi(31)
    private static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        public static LocationRequest toLocationRequest(LocationRequestCompat r10) {
            return new LocationRequest.Builder(r10.getIntervalMillis()).setQuality(r10.getQuality()).setMinUpdateIntervalMillis(r10.getMinUpdateIntervalMillis()).setDurationMillis(r10.getDurationMillis()).setMaxUpdates(r10.getMaxUpdates()).setMinUpdateDistanceMeters(r10.getMinUpdateDistanceMeters()).setMaxUpdateDelayMillis(r10.getMaxUpdateDelayMillis()).build();
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

        public Builder(long r10) {
            setIntervalMillis(r10);
            this.mQuality = 102;
            this.mDurationMillis = Long.MAX_VALUE;
            this.mMaxUpdates = Integer.MAX_VALUE;
            this.mMinUpdateIntervalMillis = -1;
            this.mMinUpdateDistanceMeters = 0.0f;
            this.mMaxUpdateDelayMillis = 0;
        }

        public Builder(@NonNull LocationRequestCompat r10) {
            this.mIntervalMillis = r10.mIntervalMillis;
            this.mQuality = r10.mQuality;
            this.mDurationMillis = r10.mDurationMillis;
            this.mMaxUpdates = r10.mMaxUpdates;
            this.mMinUpdateIntervalMillis = r10.mMinUpdateIntervalMillis;
            this.mMinUpdateDistanceMeters = r10.mMinUpdateDistanceMeters;
            this.mMaxUpdateDelayMillis = r10.mMaxUpdateDelayMillis;
        }

        @NonNull
        public LocationRequestCompat build() {
            if (this.mIntervalMillis == Long.MAX_VALUE) goto L5;
        L8:
            boolean r10 = true;
        L9:
            Preconditions.checkState(r10, "passive location requests must have an explicit minimum update interval");
            long r11 = this.mIntervalMillis;
            return new LocationRequestCompat(r11, this.mQuality, this.mDurationMillis, this.mMaxUpdates, Math.min(this.mMinUpdateIntervalMillis, r11), this.mMinUpdateDistanceMeters, this.mMaxUpdateDelayMillis);
        L5:
            if (this.mMinUpdateIntervalMillis != (-1)) goto L8;
            r10 = false;
            goto L9
        }

        @NonNull
        public Builder clearMinUpdateIntervalMillis() {
            this.mMinUpdateIntervalMillis = -1;
            return this;
        }

        @NonNull
        public Builder setDurationMillis(@IntRange(from = 1) long r10) {
            this.mDurationMillis = Preconditions.checkArgumentInRange(r10, 1, Long.MAX_VALUE, "durationMillis");
            return this;
        }

        @NonNull
        public Builder setIntervalMillis(@IntRange(from = 0) long r10) {
            this.mIntervalMillis = Preconditions.checkArgumentInRange(r10, 0, Long.MAX_VALUE, "intervalMillis");
            return this;
        }

        @NonNull
        public Builder setMaxUpdateDelayMillis(@IntRange(from = 0) long r10) {
            this.mMaxUpdateDelayMillis = r10;
            this.mMaxUpdateDelayMillis = Preconditions.checkArgumentInRange(r10, 0, Long.MAX_VALUE, "maxUpdateDelayMillis");
            return this;
        }

        @NonNull
        public Builder setMaxUpdates(@IntRange(from = 1, to = 2147483647L) int r10) {
            this.mMaxUpdates = Preconditions.checkArgumentInRange(r10, 1, Integer.MAX_VALUE, "maxUpdates");
            return this;
        }

        @NonNull
        public Builder setMinUpdateDistanceMeters(@FloatRange(from = 0.0d, to = 3.4028234663852886E38d) float r10) {
            this.mMinUpdateDistanceMeters = r10;
            this.mMinUpdateDistanceMeters = Preconditions.checkArgumentInRange(r10, 0.0f, Float.MAX_VALUE, "minUpdateDistanceMeters");
            return this;
        }

        @NonNull
        public Builder setMinUpdateIntervalMillis(@IntRange(from = 0) long r10) {
            this.mMinUpdateIntervalMillis = Preconditions.checkArgumentInRange(r10, 0, Long.MAX_VALUE, "minUpdateIntervalMillis");
            return this;
        }

        @NonNull
        public Builder setQuality(int r10) {
            if (r10 != 104) goto L5;
        L10:
            boolean r11 = true;
        L11:
            Preconditions.checkArgument(r11, "quality must be a defined QUALITY constant, not %d", new Object[]{Integer.valueOf(r10)});
            this.mQuality = r10;
            return this;
        L5:
            if (r10 == 102) goto L10;
            if (r10 == 100) goto L10;
            r11 = false;
            goto L11
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface Quality {
    }

    LocationRequestCompat(long r10, int r11, long r12, int r13, long r14, float r15, long r16) {
        this.mIntervalMillis = r10;
        this.mQuality = r11;
        this.mMinUpdateIntervalMillis = r14;
        this.mDurationMillis = r12;
        this.mMaxUpdates = r13;
        this.mMinUpdateDistanceMeters = r15;
        this.mMaxUpdateDelayMillis = r16;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof LocationRequestCompat) == true) goto L8;
        return false;
    L8:
        LocationRequestCompat r11 = (LocationRequestCompat) r10;
        if (this.mQuality != r11.mQuality) goto L24;
        if (this.mIntervalMillis != r11.mIntervalMillis) goto L24;
        if (this.mMinUpdateIntervalMillis != r11.mMinUpdateIntervalMillis) goto L24;
        if (this.mDurationMillis != r11.mDurationMillis) goto L24;
        if (this.mMaxUpdates != r11.mMaxUpdates) goto L24;
        if (Float.compare(r11.mMinUpdateDistanceMeters, this.mMinUpdateDistanceMeters) != 0) goto L24;
        if (this.mMaxUpdateDelayMillis != r11.mMaxUpdateDelayMillis) goto L24;
        return true;
    L24:
        return false;
    }

    @IntRange(from = 1)
    public long getDurationMillis() {
        return this.mDurationMillis;
    }

    @IntRange(from = 0)
    public long getIntervalMillis() {
        return this.mIntervalMillis;
    }

    @IntRange(from = 0)
    public long getMaxUpdateDelayMillis() {
        return this.mMaxUpdateDelayMillis;
    }

    @IntRange(from = 1, to = 2147483647L)
    public int getMaxUpdates() {
        return this.mMaxUpdates;
    }

    @FloatRange(from = 0.0d, to = 3.4028234663852886E38d)
    public float getMinUpdateDistanceMeters() {
        return this.mMinUpdateDistanceMeters;
    }

    @IntRange(from = 0)
    public long getMinUpdateIntervalMillis() {
        long r10 = this.mMinUpdateIntervalMillis;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        return this.mIntervalMillis;
    }

    public int getQuality() {
        return this.mQuality;
    }

    public int hashCode() {
        int r10 = this.mQuality * 31;
        long r11 = this.mIntervalMillis;
        int r12 = (r10 + ((int) (r11 ^ (r11 >>> 32)))) * 31;
        long r13 = this.mMinUpdateIntervalMillis;
        return r12 + ((int) (r13 ^ (r13 >>> 32)));
    }

    @NonNull
    @RequiresApi(31)
    public LocationRequest toLocationRequest() {
        return Api31Impl.toLocationRequest(this);
    }

    @Nullable
    @RequiresApi(19)
    @SuppressLint({"NewApi"})
    public LocationRequest toLocationRequest(@NonNull String r10) {
        if (Build.VERSION.SDK_INT < 31) goto L7;
        return toLocationRequest();
    L7:
        return (LocationRequest) Api19Impl.toLocationRequest(this, r10);
    }

    @NonNull
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("Request[");
        if (this.mIntervalMillis == Long.MAX_VALUE) goto L14;
        r10.append("@");
        TimeUtils.formatDuration(this.mIntervalMillis, r10);
        int r11 = this.mQuality;
        if (r11 != 100) goto L7;
        String r12 = " HIGH_ACCURACY";
    L15:
        r10.append(r12);
    L17:
        if (this.mDurationMillis == Long.MAX_VALUE) goto L20;
        r10.append(", duration=");
        TimeUtils.formatDuration(this.mDurationMillis, r10);
    L20:
        if (this.mMaxUpdates == Integer.MAX_VALUE) goto L22;
        r10.append(", maxUpdates=");
        r10.append(this.mMaxUpdates);
    L22:
        long r13 = this.mMinUpdateIntervalMillis;
        if (r13 == (-1)) goto L28;
        if (r13 >= this.mIntervalMillis) goto L28;
        r10.append(", minUpdateInterval=");
        TimeUtils.formatDuration(this.mMinUpdateIntervalMillis, r10);
    L28:
        if (this.mMinUpdateDistanceMeters <= 0.0d) goto L31;
        r10.append(", minUpdateDistance=");
        r10.append(this.mMinUpdateDistanceMeters);
    L31:
        if ((this.mMaxUpdateDelayMillis / 2) <= this.mIntervalMillis) goto L33;
        r10.append(", maxUpdateDelay=");
        TimeUtils.formatDuration(this.mMaxUpdateDelayMillis, r10);
    L33:
        r10.append(']');
        return r10.toString();
    L7:
        if (r11 != 102) goto L9;
        r12 = " BALANCED";
        goto L15
    L9:
        if (r11 != 104) goto L17;
        r12 = " LOW_POWER";
        goto L15
    L14:
        r12 = "PASSIVE";
        goto L15
    }
}
