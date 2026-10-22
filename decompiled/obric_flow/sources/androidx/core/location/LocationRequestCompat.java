package androidx.core.location;

import ai.j0;
import android.annotation.SuppressLint;
import android.location.LocationRequest;
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

    public static class Api19Impl {
        private static Method sCreateFromDeprecatedProviderMethod;
        private static Class<?> sLocationRequestClass;
        private static Method sSetExpireInMethod;
        private static Method sSetFastestIntervalMethod;
        private static Method sSetNumUpdatesMethod;
        private static Method sSetQualityMethod;

        private Api19Impl() {
        }

        @SuppressLint({"BanUncheckedReflection"})
        public static Object toLocationRequest(LocationRequestCompat r10, String r11) {
        L31:
            return null;
        L4:
            if (sLocationRequestClass != null) goto L7;
            sLocationRequestClass = Class.forName("android.location.LocationRequest");     // Catch: Throwable -> L31
        L7:
            if (sCreateFromDeprecatedProviderMethod != null) goto L9;
            Method r5 = sLocationRequestClass.getDeclaredMethod("createFromDeprecatedProvider", new Class[]{String.class, Long.TYPE, Float.TYPE, Boolean.TYPE});     // Catch: Throwable -> L31
            sCreateFromDeprecatedProviderMethod = r5;     // Catch: Throwable -> L31
            r5.setAccessible(true);     // Catch: Throwable -> L31
        L9:
            Object r12 = sCreateFromDeprecatedProviderMethod.invoke(null, new Object[]{r11, Long.valueOf(r10.getIntervalMillis()), Float.valueOf(r10.getMinUpdateDistanceMeters()), Boolean.FALSE});     // Catch: Throwable -> L31
            if (r12 != null) goto L13;
            return null;
        L13:
            if (sSetQualityMethod != null) goto L15;
            Method r13 = sLocationRequestClass.getDeclaredMethod("setQuality", new Class[]{Integer.TYPE});     // Catch: Throwable -> L31
            sSetQualityMethod = r13;     // Catch: Throwable -> L31
            r13.setAccessible(true);     // Catch: Throwable -> L31
        L15:
            sSetQualityMethod.invoke(r12, new Object[]{Integer.valueOf(r10.getQuality())});     // Catch: Throwable -> L31
            if (sSetFastestIntervalMethod != null) goto L18;
            Method r14 = sLocationRequestClass.getDeclaredMethod("setFastestInterval", new Class[]{Long.TYPE});     // Catch: Throwable -> L31
            sSetFastestIntervalMethod = r14;     // Catch: Throwable -> L31
            r14.setAccessible(true);     // Catch: Throwable -> L31
        L18:
            sSetFastestIntervalMethod.invoke(r12, new Object[]{Long.valueOf(r10.getMinUpdateIntervalMillis())});     // Catch: Throwable -> L31
            if (r10.getMaxUpdates() >= Integer.MAX_VALUE) goto L25;
            if (sSetNumUpdatesMethod != null) goto L23;
            Method r15 = sLocationRequestClass.getDeclaredMethod("setNumUpdates", new Class[]{Integer.TYPE});     // Catch: Throwable -> L31
            sSetNumUpdatesMethod = r15;     // Catch: Throwable -> L31
            r15.setAccessible(true);     // Catch: Throwable -> L31
        L23:
            sSetNumUpdatesMethod.invoke(r12, new Object[]{Integer.valueOf(r10.getMaxUpdates())});     // Catch: Throwable -> L31
        L25:
            if (r10.getDurationMillis() < Long.MAX_VALUE) goto L27;
        L30:
            return r12;
        L27:
            if (sSetExpireInMethod != null) goto L29;
            Method r16 = sLocationRequestClass.getDeclaredMethod("setExpireIn", new Class[]{Long.TYPE});     // Catch: Throwable -> L31
            sSetExpireInMethod = r16;     // Catch: Throwable -> L31
            r16.setAccessible(true);     // Catch: Throwable -> L31
        L29:
            sSetExpireInMethod.invoke(r12, new Object[]{Long.valueOf(r10.getDurationMillis())});     // Catch: Throwable -> L31
            goto L30
        }
    }

    @RequiresApi(31)
    public static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        public static LocationRequest toLocationRequest(LocationRequestCompat r5) {
            return new LocationRequest.Builder(r5.getIntervalMillis()).setQuality(r5.getQuality()).setMinUpdateIntervalMillis(r5.getMinUpdateIntervalMillis()).setDurationMillis(r5.getDurationMillis()).setMaxUpdates(r5.getMaxUpdates()).setMinUpdateDistanceMeters(r5.getMinUpdateDistanceMeters()).setMaxUpdateDelayMillis(r5.getMaxUpdateDelayMillis()).build();
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

        public Builder(long r5) {
            setIntervalMillis(r5);
            this.mQuality = 102;
            this.mDurationMillis = Long.MAX_VALUE;
            this.mMaxUpdates = Integer.MAX_VALUE;
            this.mMinUpdateIntervalMillis = -1;
            this.mMinUpdateDistanceMeters = 0.0f;
            this.mMaxUpdateDelayMillis = 0;
        }

        @NonNull
        public LocationRequestCompat build() {
            if (this.mIntervalMillis == Long.MAX_VALUE) goto L5;
        L8:
            boolean r5 = true;
        L9:
            Preconditions.checkState(r5, "passive location requests must have an explicit minimum update interval");
            long r10 = this.mIntervalMillis;
            return new LocationRequestCompat(r10, this.mQuality, this.mDurationMillis, this.mMaxUpdates, Math.min(this.mMinUpdateIntervalMillis, r10), this.mMinUpdateDistanceMeters, this.mMaxUpdateDelayMillis);
        L5:
            if (this.mMinUpdateIntervalMillis != (-1)) goto L8;
            r5 = false;
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
        public Builder setMaxUpdates(@IntRange(from = 1, to = 2147483647L) int r5) {
            this.mMaxUpdates = Preconditions.checkArgumentInRange(r5, 1, Integer.MAX_VALUE, "maxUpdates");
            return this;
        }

        @NonNull
        public Builder setMinUpdateDistanceMeters(@FloatRange(from = 0.0d, to = 3.4028234663852886E38d) float r5) {
            this.mMinUpdateDistanceMeters = r5;
            this.mMinUpdateDistanceMeters = Preconditions.checkArgumentInRange(r5, 0.0f, Float.MAX_VALUE, "minUpdateDistanceMeters");
            return this;
        }

        @NonNull
        public Builder setMinUpdateIntervalMillis(@IntRange(from = 0) long r10) {
            this.mMinUpdateIntervalMillis = Preconditions.checkArgumentInRange(r10, 0, Long.MAX_VALUE, "minUpdateIntervalMillis");
            return this;
        }

        @NonNull
        public Builder setQuality(int r5) {
            if (r5 != 104) goto L5;
        L10:
            boolean r10 = true;
        L11:
            Preconditions.checkArgument(r10, "quality must be a defined QUALITY constant, not %d", new Object[]{Integer.valueOf(r5)});
            this.mQuality = r5;
            return this;
        L5:
            if (r5 == 102) goto L10;
            if (r5 == 100) goto L10;
            r10 = false;
            goto L11
        }

        public Builder(@NonNull LocationRequestCompat r5) {
            this.mIntervalMillis = r5.mIntervalMillis;
            this.mQuality = r5.mQuality;
            this.mDurationMillis = r5.mDurationMillis;
            this.mMaxUpdates = r5.mMaxUpdates;
            this.mMinUpdateIntervalMillis = r5.mMinUpdateIntervalMillis;
            this.mMinUpdateDistanceMeters = r5.mMinUpdateDistanceMeters;
            this.mMaxUpdateDelayMillis = r5.mMaxUpdateDelayMillis;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface Quality {
    }

    public LocationRequestCompat(long r5, int r10, long r11, int r12, long r13, float r14, long r15) {
        this.mIntervalMillis = r5;
        this.mQuality = r10;
        this.mMinUpdateIntervalMillis = r13;
        this.mDurationMillis = r11;
        this.mMaxUpdates = r12;
        this.mMinUpdateDistanceMeters = r14;
        this.mMaxUpdateDelayMillis = r15;
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
        long r5 = this.mMinUpdateIntervalMillis;
        if (r5 == (-1)) goto L5;
        return r5;
    L5:
        return this.mIntervalMillis;
    }

    public int getQuality() {
        return this.mQuality;
    }

    public int hashCode() {
        int r5 = this.mQuality * 31;
        long r10 = this.mIntervalMillis;
        int r11 = (r5 + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        long r12 = this.mMinUpdateIntervalMillis;
        return r11 + ((int) (r12 ^ (r12 >>> 32)));
    }

    @NonNull
    @RequiresApi(31)
    public LocationRequest toLocationRequest() {
        return Api31Impl.toLocationRequest(this);
    }

    @NonNull
    public String toString() {
        StringBuilder r5 = j0.u("Request[");
        if (this.mIntervalMillis == Long.MAX_VALUE) goto L14;
        r5.append("@");
        TimeUtils.formatDuration(this.mIntervalMillis, r5);
        int r10 = this.mQuality;
        if (r10 != 100) goto L7;
        r5.append(" HIGH_ACCURACY");
    L16:
        if (this.mDurationMillis == Long.MAX_VALUE) goto L19;
        r5.append(", duration=");
        TimeUtils.formatDuration(this.mDurationMillis, r5);
    L19:
        if (this.mMaxUpdates == Integer.MAX_VALUE) goto L21;
        r5.append(", maxUpdates=");
        r5.append(this.mMaxUpdates);
    L21:
        long r11 = this.mMinUpdateIntervalMillis;
        if (r11 == (-1)) goto L27;
        if (r11 >= this.mIntervalMillis) goto L27;
        r5.append(", minUpdateInterval=");
        TimeUtils.formatDuration(this.mMinUpdateIntervalMillis, r5);
    L27:
        if (this.mMinUpdateDistanceMeters <= 0.0d) goto L30;
        r5.append(", minUpdateDistance=");
        r5.append(this.mMinUpdateDistanceMeters);
    L30:
        if ((this.mMaxUpdateDelayMillis / 2) <= this.mIntervalMillis) goto L32;
        r5.append(", maxUpdateDelay=");
        TimeUtils.formatDuration(this.mMaxUpdateDelayMillis, r5);
    L32:
        r5.append(']');
        return r5.toString();
    L7:
        if (r10 != 102) goto L9;
        r5.append(" BALANCED");
        goto L16
    L9:
        if (r10 != 104) goto L16;
        r5.append(" LOW_POWER");
        goto L16
    L14:
        r5.append("PASSIVE");
        goto L16
    }

    @Nullable
    @SuppressLint({"NewApi"})
    public LocationRequest toLocationRequest(@NonNull String r5) {
        return toLocationRequest();
    }
}
