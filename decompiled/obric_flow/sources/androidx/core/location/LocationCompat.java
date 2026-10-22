package androidx.core.location;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
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
    private static Field sFieldsMaskField;

    @Nullable
    private static Integer sHasBearingAccuracyMask;

    @Nullable
    private static Integer sHasSpeedAccuracyMask;

    @Nullable
    private static Integer sHasVerticalAccuracyMask;

    @Nullable
    private static Method sSetIsFromMockProviderMethod;

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static float getBearingAccuracyDegrees(Location r5) {
            return r5.getBearingAccuracyDegrees();
        }

        @DoNotInline
        public static float getSpeedAccuracyMetersPerSecond(Location r5) {
            return r5.getSpeedAccuracyMetersPerSecond();
        }

        @DoNotInline
        public static float getVerticalAccuracyMeters(Location r5) {
            return r5.getVerticalAccuracyMeters();
        }

        @DoNotInline
        public static boolean hasBearingAccuracy(Location r5) {
            return r5.hasBearingAccuracy();
        }

        @DoNotInline
        public static boolean hasSpeedAccuracy(Location r5) {
            return r5.hasSpeedAccuracy();
        }

        @DoNotInline
        public static boolean hasVerticalAccuracy(Location r5) {
            return r5.hasVerticalAccuracy();
        }

        @DoNotInline
        public static void removeBearingAccuracy(Location r5) {
            byte r10 = (byte) (LocationCompat.getFieldsMaskField().getByte(r5) & (~LocationCompat.getHasBearingAccuracyMask()));     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
            LocationCompat.getFieldsMaskField().setByte(r5, r10);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
            return;
        L4:
            e = move-exception;
            IllegalAccessError r11 = new IllegalAccessError();
            r11.initCause(e);
            throw r11;
        L6:
            e = move-exception;
            NoSuchFieldError r12 = new NoSuchFieldError();
            r12.initCause(e);
            throw r12;
        }

        @DoNotInline
        public static void removeSpeedAccuracy(Location r5) {
            byte r10 = (byte) (LocationCompat.getFieldsMaskField().getByte(r5) & (~LocationCompat.getHasSpeedAccuracyMask()));     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
            LocationCompat.getFieldsMaskField().setByte(r5, r10);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
            return;
        L4:
            e = move-exception;
            IllegalAccessError r11 = new IllegalAccessError();
            r11.initCause(e);
            throw r11;
        L6:
            e = move-exception;
            NoSuchFieldError r12 = new NoSuchFieldError();
            r12.initCause(e);
            throw r12;
        }

        @DoNotInline
        public static void removeVerticalAccuracy(Location r5) {
            byte r10 = (byte) (LocationCompat.getFieldsMaskField().getByte(r5) & (~LocationCompat.getHasVerticalAccuracyMask()));     // Catch: Throwable -> L4
            LocationCompat.getFieldsMaskField().setByte(r5, r10);     // Catch: Throwable -> L4
            return;
        L4:
            e = move-exception;
            IllegalAccessError r11 = new IllegalAccessError();
            r11.initCause(e);
            throw r11;
        }

        @DoNotInline
        public static void setBearingAccuracyDegrees(Location r5, float r10) {
            r5.setBearingAccuracyDegrees(r10);
        }

        @DoNotInline
        public static void setSpeedAccuracyMetersPerSecond(Location r5, float r10) {
            r5.setSpeedAccuracyMetersPerSecond(r10);
        }

        @DoNotInline
        public static void setVerticalAccuracyMeters(Location r5, float r10) {
            r5.setVerticalAccuracyMeters(r10);
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static void removeBearingAccuracy(Location r24) {
            if (r24.hasBearingAccuracy() == true) goto L5;
            return;
        L5:
            String r5 = r24.getProvider();
            long r10 = r24.getTime();
            long r11 = r24.getElapsedRealtimeNanos();
            double r12 = r24.getLatitude();
            double r13 = r24.getLongitude();
            boolean r14 = r24.hasAltitude();
            double r15 = r24.getAltitude();
            boolean r16 = r24.hasSpeed();
            float r17 = r24.getSpeed();
            boolean r18 = r24.hasBearing();
            float r19 = r24.getBearing();
            boolean r110 = r24.hasAccuracy();
            float r111 = r24.getAccuracy();
            boolean r112 = r24.hasVerticalAccuracy();
            float r113 = r24.getVerticalAccuracyMeters();
            boolean r21 = r24.hasSpeedAccuracy();
            float r114 = r24.getSpeedAccuracyMetersPerSecond();
            Bundle r115 = r24.getExtras();
            r24.reset();
            r24.setProvider(r5);
            r24.setTime(r10);
            r24.setElapsedRealtimeNanos(r11);
            r24.setLatitude(r12);
            r24.setLongitude(r13);
            if (r14 == false) goto L8;
            r24.setAltitude(r15);
        L8:
            if (r16 == false) goto L10;
            r24.setSpeed(r17);
        L10:
            if (r18 == false) goto L12;
            r24.setBearing(r19);
        L12:
            if (r110 == false) goto L14;
            r24.setAccuracy(r111);
        L14:
            if (r112 == false) goto L16;
            r24.setVerticalAccuracyMeters(r113);
        L16:
            if (r21 == false) goto L18;
            r24.setBearingAccuracyDegrees(r114);
        L18:
            if (r115 == null) goto L21;
            r24.setExtras(r115);
            return;
        }

        @DoNotInline
        public static void removeSpeedAccuracy(Location r24) {
            if (r24.hasSpeedAccuracy() == true) goto L5;
            return;
        L5:
            String r5 = r24.getProvider();
            long r10 = r24.getTime();
            long r11 = r24.getElapsedRealtimeNanos();
            double r12 = r24.getLatitude();
            double r13 = r24.getLongitude();
            boolean r14 = r24.hasAltitude();
            double r15 = r24.getAltitude();
            boolean r16 = r24.hasSpeed();
            float r17 = r24.getSpeed();
            boolean r18 = r24.hasBearing();
            float r19 = r24.getBearing();
            boolean r110 = r24.hasAccuracy();
            float r111 = r24.getAccuracy();
            boolean r112 = r24.hasVerticalAccuracy();
            float r113 = r24.getVerticalAccuracyMeters();
            boolean r21 = r24.hasBearingAccuracy();
            float r114 = r24.getBearingAccuracyDegrees();
            Bundle r115 = r24.getExtras();
            r24.reset();
            r24.setProvider(r5);
            r24.setTime(r10);
            r24.setElapsedRealtimeNanos(r11);
            r24.setLatitude(r12);
            r24.setLongitude(r13);
            if (r14 == false) goto L8;
            r24.setAltitude(r15);
        L8:
            if (r16 == false) goto L10;
            r24.setSpeed(r17);
        L10:
            if (r18 == false) goto L12;
            r24.setBearing(r19);
        L12:
            if (r110 == false) goto L14;
            r24.setAccuracy(r111);
        L14:
            if (r112 == false) goto L16;
            r24.setVerticalAccuracyMeters(r113);
        L16:
            if (r21 == false) goto L18;
            r24.setBearingAccuracyDegrees(r114);
        L18:
            if (r115 == null) goto L21;
            r24.setExtras(r115);
            return;
        }

        @DoNotInline
        public static void removeVerticalAccuracy(Location r24) {
            if (r24.hasVerticalAccuracy() == true) goto L5;
            return;
        L5:
            String r5 = r24.getProvider();
            long r10 = r24.getTime();
            long r11 = r24.getElapsedRealtimeNanos();
            double r12 = r24.getLatitude();
            double r13 = r24.getLongitude();
            boolean r14 = r24.hasAltitude();
            double r15 = r24.getAltitude();
            boolean r16 = r24.hasSpeed();
            float r17 = r24.getSpeed();
            boolean r18 = r24.hasBearing();
            float r19 = r24.getBearing();
            boolean r110 = r24.hasAccuracy();
            float r111 = r24.getAccuracy();
            boolean r112 = r24.hasSpeedAccuracy();
            float r113 = r24.getSpeedAccuracyMetersPerSecond();
            boolean r21 = r24.hasBearingAccuracy();
            float r114 = r24.getBearingAccuracyDegrees();
            Bundle r115 = r24.getExtras();
            r24.reset();
            r24.setProvider(r5);
            r24.setTime(r10);
            r24.setElapsedRealtimeNanos(r11);
            r24.setLatitude(r12);
            r24.setLongitude(r13);
            if (r14 == false) goto L8;
            r24.setAltitude(r15);
        L8:
            if (r16 == false) goto L10;
            r24.setSpeed(r17);
        L10:
            if (r18 == false) goto L12;
            r24.setBearing(r19);
        L12:
            if (r110 == false) goto L14;
            r24.setAccuracy(r111);
        L14:
            if (r112 == false) goto L16;
            r24.setSpeedAccuracyMetersPerSecond(r113);
        L16:
            if (r21 == false) goto L18;
            r24.setBearingAccuracyDegrees(r114);
        L18:
            if (r115 == null) goto L21;
            r24.setExtras(r115);
            return;
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static void removeBearingAccuracy(Location r5) {
            if (r5.hasBearingAccuracy() == true) goto L5;
            return;
        L5:
            double r10 = r5.getElapsedRealtimeUncertaintyNanos();
            Api28Impl.removeBearingAccuracy(r5);
            r5.setElapsedRealtimeUncertaintyNanos(r10);
        }

        @DoNotInline
        public static void removeSpeedAccuracy(Location r5) {
            if (r5.hasSpeedAccuracy() == true) goto L5;
            return;
        L5:
            double r10 = r5.getElapsedRealtimeUncertaintyNanos();
            Api28Impl.removeSpeedAccuracy(r5);
            r5.setElapsedRealtimeUncertaintyNanos(r10);
        }

        @DoNotInline
        public static void removeVerticalAccuracy(Location r5) {
            if (r5.hasVerticalAccuracy() == true) goto L5;
            return;
        L5:
            double r10 = r5.getElapsedRealtimeUncertaintyNanos();
            Api28Impl.removeVerticalAccuracy(r5);
            r5.setElapsedRealtimeUncertaintyNanos(r10);
        }
    }

    @RequiresApi(33)
    public static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        public static void removeBearingAccuracy(Location r5) {
            r5.removeBearingAccuracy();
        }

        @DoNotInline
        public static void removeSpeedAccuracy(Location r5) {
            r5.removeSpeedAccuracy();
        }

        @DoNotInline
        public static void removeVerticalAccuracy(Location r5) {
            r5.removeVerticalAccuracy();
        }
    }

    @RequiresApi(34)
    public static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        public static float getMslAltitudeAccuracyMeters(Location r5) {
            return r5.getMslAltitudeAccuracyMeters();
        }

        @DoNotInline
        public static double getMslAltitudeMeters(Location r5) {
            return r5.getMslAltitudeMeters();
        }

        @DoNotInline
        public static boolean hasMslAltitude(Location r5) {
            return r5.hasMslAltitude();
        }

        @DoNotInline
        public static boolean hasMslAltitudeAccuracy(Location r5) {
            return r5.hasMslAltitudeAccuracy();
        }

        @DoNotInline
        public static void removeMslAltitude(Location r5) {
            r5.removeMslAltitude();
        }

        @DoNotInline
        public static void removeMslAltitudeAccuracy(Location r5) {
            r5.removeMslAltitudeAccuracy();
        }

        @DoNotInline
        public static void setMslAltitudeAccuracyMeters(Location r5, float r10) {
            r5.setMslAltitudeAccuracyMeters(r10);
        }

        @DoNotInline
        public static void setMslAltitudeMeters(Location r5, double r10) {
            r5.setMslAltitudeMeters(r10);
        }
    }

    private LocationCompat() {
    }

    private static boolean containsExtra(@NonNull Location r5, String r10) {
        Bundle r11 = r5.getExtras();
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.containsKey(r10) == false) goto L7;
        return true;
    }

    public static float getBearingAccuracyDegrees(@NonNull Location r5) {
        return Api26Impl.getBearingAccuracyDegrees(r5);
    }

    public static long getElapsedRealtimeMillis(@NonNull Location r5) {
        return TimeUnit.NANOSECONDS.toMillis(r5.getElapsedRealtimeNanos());
    }

    public static long getElapsedRealtimeNanos(@NonNull Location r5) {
        return r5.getElapsedRealtimeNanos();
    }

    @SuppressLint({"BlockedPrivateApi"})
    public static Field getFieldsMaskField() throws NoSuchFieldException {
        if (sFieldsMaskField != null) goto L6;
        Field r5 = Location.class.getDeclaredField("mFieldsMask");
        sFieldsMaskField = r5;
        r5.setAccessible(true);
    L6:
        return sFieldsMaskField;
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static int getHasBearingAccuracyMask() throws NoSuchFieldException, IllegalAccessException {
        if (sHasBearingAccuracyMask != null) goto L6;
        Field r5 = Location.class.getDeclaredField("HAS_BEARING_ACCURACY_MASK");
        r5.setAccessible(true);
        sHasBearingAccuracyMask = Integer.valueOf(r5.getInt(null));
    L6:
        return sHasBearingAccuracyMask.intValue();
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static int getHasSpeedAccuracyMask() throws NoSuchFieldException, IllegalAccessException {
        if (sHasSpeedAccuracyMask != null) goto L6;
        Field r5 = Location.class.getDeclaredField("HAS_SPEED_ACCURACY_MASK");
        r5.setAccessible(true);
        sHasSpeedAccuracyMask = Integer.valueOf(r5.getInt(null));
    L6:
        return sHasSpeedAccuracyMask.intValue();
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static int getHasVerticalAccuracyMask() throws NoSuchFieldException, IllegalAccessException {
        if (sHasVerticalAccuracyMask != null) goto L6;
        Field r5 = Location.class.getDeclaredField("HAS_VERTICAL_ACCURACY_MASK");
        r5.setAccessible(true);
        sHasVerticalAccuracyMask = Integer.valueOf(r5.getInt(null));
    L6:
        return sHasVerticalAccuracyMask.intValue();
    }

    @FloatRange(from = 0.0d)
    public static float getMslAltitudeAccuracyMeters(@NonNull Location r5) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.getMslAltitudeAccuracyMeters(r5);
    L7:
        return getOrCreateExtras(r5).getFloat(EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static double getMslAltitudeMeters(@NonNull Location r5) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.getMslAltitudeMeters(r5);
    L7:
        return getOrCreateExtras(r5).getDouble(EXTRA_MSL_ALTITUDE);
    }

    private static Bundle getOrCreateExtras(@NonNull Location r5) {
        Bundle r10 = r5.getExtras();
        if (r10 != null) goto L6;
        r5.setExtras(new Bundle());
        return r5.getExtras();
    L6:
        return r10;
    }

    private static Method getSetIsFromMockProviderMethod() throws NoSuchMethodException {
        if (sSetIsFromMockProviderMethod != null) goto L6;
        Method r5 = Location.class.getDeclaredMethod("setIsFromMockProvider", new Class[]{Boolean.TYPE});
        sSetIsFromMockProviderMethod = r5;
        r5.setAccessible(true);
    L6:
        return sSetIsFromMockProviderMethod;
    }

    public static float getSpeedAccuracyMetersPerSecond(@NonNull Location r5) {
        return Api26Impl.getSpeedAccuracyMetersPerSecond(r5);
    }

    public static float getVerticalAccuracyMeters(@NonNull Location r5) {
        return Api26Impl.getVerticalAccuracyMeters(r5);
    }

    public static boolean hasBearingAccuracy(@NonNull Location r5) {
        return Api26Impl.hasBearingAccuracy(r5);
    }

    public static boolean hasMslAltitude(@NonNull Location r5) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.hasMslAltitude(r5);
    L7:
        return containsExtra(r5, EXTRA_MSL_ALTITUDE);
    }

    public static boolean hasMslAltitudeAccuracy(@NonNull Location r5) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.hasMslAltitudeAccuracy(r5);
    L7:
        return containsExtra(r5, EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static boolean hasSpeedAccuracy(@NonNull Location r5) {
        return Api26Impl.hasSpeedAccuracy(r5);
    }

    public static boolean hasVerticalAccuracy(@NonNull Location r5) {
        return Api26Impl.hasVerticalAccuracy(r5);
    }

    public static boolean isMock(@NonNull Location r5) {
        return r5.isFromMockProvider();
    }

    public static void removeBearingAccuracy(@NonNull Location r5) {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        Api33Impl.removeBearingAccuracy(r5);
        return;
    L5:
        Api29Impl.removeBearingAccuracy(r5);
    }

    private static void removeExtra(@NonNull Location r5, String r10) {
        Bundle r11 = r5.getExtras();
        if (r11 == null) goto L8;
        r11.remove(r10);
        if (r11.isEmpty() == false) goto L9;
        r5.setExtras(null);
        return;
    L9:
        return;
    }

    public static void removeMslAltitude(@NonNull Location r5) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.removeMslAltitude(r5);
        return;
    L5:
        removeExtra(r5, EXTRA_MSL_ALTITUDE);
    }

    public static void removeMslAltitudeAccuracy(@NonNull Location r5) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.removeMslAltitudeAccuracy(r5);
        return;
    L5:
        removeExtra(r5, EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static void removeSpeedAccuracy(@NonNull Location r5) {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        Api33Impl.removeSpeedAccuracy(r5);
        return;
    L5:
        Api29Impl.removeSpeedAccuracy(r5);
    }

    public static void removeVerticalAccuracy(@NonNull Location r5) {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        Api33Impl.removeVerticalAccuracy(r5);
        return;
    L5:
        Api29Impl.removeVerticalAccuracy(r5);
    }

    public static void setBearingAccuracyDegrees(@NonNull Location r5, float r10) {
        Api26Impl.setBearingAccuracyDegrees(r5, r10);
    }

    @SuppressLint({"BanUncheckedReflection"})
    public static void setMock(@NonNull Location r5, boolean r10) {
        getSetIsFromMockProviderMethod().invoke(r5, new Object[]{Boolean.valueOf(r10)});     // Catch: InvocationTargetException -> L4 IllegalAccessException -> L6 NoSuchMethodException -> L8
        return;
    L6:
        e = move-exception;
        IllegalAccessError r11 = new IllegalAccessError();
        r11.initCause(e);
        throw r11;
    L8:
        e = move-exception;
        NoSuchMethodError r12 = new NoSuchMethodError();
        r12.initCause(e);
        throw r12;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void setMslAltitudeAccuracyMeters(@NonNull Location r5, @FloatRange(from = 0.0d) float r10) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.setMslAltitudeAccuracyMeters(r5, r10);
        return;
    L5:
        getOrCreateExtras(r5).putFloat(EXTRA_MSL_ALTITUDE_ACCURACY, r10);
    }

    public static void setMslAltitudeMeters(@NonNull Location r5, double r10) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.setMslAltitudeMeters(r5, r10);
        return;
    L5:
        getOrCreateExtras(r5).putDouble(EXTRA_MSL_ALTITUDE, r10);
    }

    public static void setSpeedAccuracyMetersPerSecond(@NonNull Location r5, float r10) {
        Api26Impl.setSpeedAccuracyMetersPerSecond(r5, r10);
    }

    public static void setVerticalAccuracyMeters(@NonNull Location r5, float r10) {
        Api26Impl.setVerticalAccuracyMeters(r5, r10);
    }
}
