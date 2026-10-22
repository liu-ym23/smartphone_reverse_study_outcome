package androidx.core.location;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class LocationCompat {
    public static final String EXTRA_BEARING_ACCURACY = "bearingAccuracy";
    public static final String EXTRA_IS_MOCK = "mockLocation";
    public static final String EXTRA_MSL_ALTITUDE = "androidx.core.location.extra.MSL_ALTITUDE";
    public static final String EXTRA_MSL_ALTITUDE_ACCURACY = "androidx.core.location.extra.MSL_ALTITUDE_ACCURACY";
    public static final String EXTRA_SPEED_ACCURACY = "speedAccuracy";
    public static final String EXTRA_VERTICAL_ACCURACY = "verticalAccuracy";

    @Nullable
    private static Method sSetIsFromMockProviderMethod;

    @RequiresApi(17)
    private static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        static long getElapsedRealtimeNanos(Location r10) {
            return r10.getElapsedRealtimeNanos();
        }
    }

    @RequiresApi(18)
    private static class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        static boolean isMock(Location r10) {
            return r10.isFromMockProvider();
        }
    }

    @RequiresApi(26)
    private static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static float getBearingAccuracyDegrees(Location r10) {
            return r10.getBearingAccuracyDegrees();
        }

        @DoNotInline
        static float getSpeedAccuracyMetersPerSecond(Location r10) {
            return r10.getSpeedAccuracyMetersPerSecond();
        }

        @DoNotInline
        static float getVerticalAccuracyMeters(Location r10) {
            return r10.getVerticalAccuracyMeters();
        }

        @DoNotInline
        static boolean hasBearingAccuracy(Location r10) {
            return r10.hasBearingAccuracy();
        }

        @DoNotInline
        static boolean hasSpeedAccuracy(Location r10) {
            return r10.hasSpeedAccuracy();
        }

        @DoNotInline
        static boolean hasVerticalAccuracy(Location r10) {
            return r10.hasVerticalAccuracy();
        }

        @DoNotInline
        static void setBearingAccuracyDegrees(Location r10, float r11) {
            r10.setBearingAccuracyDegrees(r11);
        }

        @DoNotInline
        static void setSpeedAccuracyMetersPerSecond(Location r10, float r11) {
            r10.setSpeedAccuracyMetersPerSecond(r11);
        }

        @DoNotInline
        static void setVerticalAccuracyMeters(Location r10, float r11) {
            r10.setVerticalAccuracyMeters(r11);
        }
    }

    private LocationCompat() {
    }

    private static boolean containsExtra(@NonNull Location r10, String r11) {
        Bundle r12 = r10.getExtras();
        if (r12 != null) goto L5;
    L7:
        return false;
    L5:
        if (r12.containsKey(r11) == false) goto L7;
        return true;
    }

    public static float getBearingAccuracyDegrees(@NonNull Location r10) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        Bundle r11 = r10.getExtras();
        if (r11 != null) goto L10;
        return 0.0f;
    L10:
        return r11.getFloat(EXTRA_BEARING_ACCURACY, 0.0f);
    L5:
        return Api26Impl.getBearingAccuracyDegrees(r10);
    }

    public static long getElapsedRealtimeMillis(@NonNull Location r10) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        long r11 = System.currentTimeMillis() - r10.getTime();
        long r12 = SystemClock.elapsedRealtime();
        if (r11 >= 0) goto L10;
        return r12;
    L10:
        if (r11 <= r12) goto L13;
        return 0;
    L13:
        return r12 - r11;
    L5:
        return TimeUnit.NANOSECONDS.toMillis(Api17Impl.getElapsedRealtimeNanos(r10));
    }

    public static long getElapsedRealtimeNanos(@NonNull Location r10) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return Api17Impl.getElapsedRealtimeNanos(r10);
    L7:
        return TimeUnit.MILLISECONDS.toNanos(getElapsedRealtimeMillis(r10));
    }

    @FloatRange(from = 0.0d)
    public static float getMslAltitudeAccuracyMeters(@NonNull Location r10) {
        Preconditions.checkState(hasMslAltitudeAccuracy(r10), "The Mean Sea Level altitude accuracy of the location is not set.");
        return getOrCreateExtras(r10).getFloat(EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static double getMslAltitudeMeters(@NonNull Location r10) {
        Preconditions.checkState(hasMslAltitude(r10), "The Mean Sea Level altitude of the location is not set.");
        return getOrCreateExtras(r10).getDouble(EXTRA_MSL_ALTITUDE);
    }

    private static Bundle getOrCreateExtras(@NonNull Location r10) {
        Bundle r11 = r10.getExtras();
        if (r11 != null) goto L6;
        r10.setExtras(new Bundle());
        return r10.getExtras();
    L6:
        return r11;
    }

    private static Method getSetIsFromMockProviderMethod() {
        if (sSetIsFromMockProviderMethod != null) goto L6;
        Method r10 = Location.class.getDeclaredMethod("setIsFromMockProvider", new Class[]{Boolean.TYPE});
        sSetIsFromMockProviderMethod = r10;
        r10.setAccessible(true);
    L6:
        return sSetIsFromMockProviderMethod;
    }

    public static float getSpeedAccuracyMetersPerSecond(@NonNull Location r10) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        Bundle r11 = r10.getExtras();
        if (r11 != null) goto L10;
        return 0.0f;
    L10:
        return r11.getFloat(EXTRA_SPEED_ACCURACY, 0.0f);
    L5:
        return Api26Impl.getSpeedAccuracyMetersPerSecond(r10);
    }

    public static float getVerticalAccuracyMeters(@NonNull Location r10) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        Bundle r11 = r10.getExtras();
        if (r11 != null) goto L10;
        return 0.0f;
    L10:
        return r11.getFloat(EXTRA_VERTICAL_ACCURACY, 0.0f);
    L5:
        return Api26Impl.getVerticalAccuracyMeters(r10);
    }

    public static boolean hasBearingAccuracy(@NonNull Location r10) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.hasBearingAccuracy(r10);
    L7:
        return containsExtra(r10, EXTRA_BEARING_ACCURACY);
    }

    public static boolean hasMslAltitude(@NonNull Location r10) {
        return containsExtra(r10, EXTRA_MSL_ALTITUDE);
    }

    public static boolean hasMslAltitudeAccuracy(@NonNull Location r10) {
        return containsExtra(r10, EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static boolean hasSpeedAccuracy(@NonNull Location r10) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.hasSpeedAccuracy(r10);
    L7:
        return containsExtra(r10, EXTRA_SPEED_ACCURACY);
    }

    public static boolean hasVerticalAccuracy(@NonNull Location r10) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.hasVerticalAccuracy(r10);
    L7:
        return containsExtra(r10, EXTRA_VERTICAL_ACCURACY);
    }

    public static boolean isMock(@NonNull Location r10) {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        Bundle r11 = r10.getExtras();
        if (r11 != null) goto L10;
        return false;
    L10:
        return r11.getBoolean(EXTRA_IS_MOCK, false);
    L5:
        return Api18Impl.isMock(r10);
    }

    private static void removeExtra(@NonNull Location r10, String r11) {
        Bundle r12 = r10.getExtras();
        if (r12 == null) goto L8;
        r12.remove(r11);
        if (r12.isEmpty() == false) goto L9;
        r10.setExtras(null);
        return;
    L9:
        return;
    }

    public static void removeMslAltitude(@NonNull Location r10) {
        removeExtra(r10, EXTRA_MSL_ALTITUDE);
    }

    public static void removeMslAltitudeAccuracy(@NonNull Location r10) {
        removeExtra(r10, EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static void setBearingAccuracyDegrees(@NonNull Location r10, float r11) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Api26Impl.setBearingAccuracyDegrees(r10, r11);
        return;
    L5:
        getOrCreateExtras(r10).putFloat(EXTRA_BEARING_ACCURACY, r11);
    }

    public static void setMock(@NonNull Location r10, boolean r11) {
        if (Build.VERSION.SDK_INT >= 18) goto L26;
        Bundle r12 = r10.getExtras();
        if (r12 != null) goto L20;
        if (r11 == false) goto L25;
        Bundle r13 = new Bundle();
        r13.putBoolean(EXTRA_IS_MOCK, true);
    L19:
        r10.setExtras(r13);
        return;
    L25:
        return;
    L20:
        if (r11 == false) goto L22;
        r12.putBoolean(EXTRA_IS_MOCK, true);
        return;
    L22:
        r12.remove(EXTRA_IS_MOCK);
        if (r12.isEmpty() == false) goto L30;
        r13 = null;
        goto L19
    L30:
        return;
    L26:
        getSetIsFromMockProviderMethod().invoke(r10, new Object[]{Boolean.valueOf(r11)});     // Catch: InvocationTargetException -> L6 IllegalAccessException -> L9 NoSuchMethodException -> L12
    L31:
        return;
    L9:
        e = move-exception;
        IllegalAccessError r14 = new IllegalAccessError();
        r14.initCause(e);
        throw r14;
    L12:
        e = move-exception;
        NoSuchMethodError r15 = new NoSuchMethodError();
        r15.initCause(e);
        throw r15;
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void setMslAltitudeAccuracyMeters(@NonNull Location r10, @FloatRange(from = 0.0d) float r11) {
        getOrCreateExtras(r10).putFloat(EXTRA_MSL_ALTITUDE_ACCURACY, r11);
    }

    public static void setMslAltitudeMeters(@NonNull Location r10, double r11) {
        getOrCreateExtras(r10).putDouble(EXTRA_MSL_ALTITUDE, r11);
    }

    public static void setSpeedAccuracyMetersPerSecond(@NonNull Location r10, float r11) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Api26Impl.setSpeedAccuracyMetersPerSecond(r10, r11);
        return;
    L5:
        getOrCreateExtras(r10).putFloat(EXTRA_SPEED_ACCURACY, r11);
    }

    public static void setVerticalAccuracyMeters(@NonNull Location r10, float r11) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Api26Impl.setVerticalAccuracyMeters(r10, r11);
        return;
    L5:
        getOrCreateExtras(r10).putFloat(EXTRA_VERTICAL_ACCURACY, r11);
    }
}
