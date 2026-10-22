package androidx.core.location;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.core.util.Preconditions;
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
    private static Field sFieldsMaskField;
    private static Integer sHasBearingAccuracyMask;
    private static Integer sHasSpeedAccuracyMask;
    private static Integer sHasVerticalAccuracyMask;
    private static Method sSetIsFromMockProviderMethod;

    private static class Api17Impl {
        private Api17Impl() {
        }

        static long getElapsedRealtimeNanos(Location r2) {
            return r2.getElapsedRealtimeNanos();
        }
    }

    private static class Api18Impl {
        private Api18Impl() {
        }

        static boolean isMock(Location r0) {
            return r0.isFromMockProvider();
        }
    }

    private static class Api26Impl {
        private Api26Impl() {
        }

        static float getBearingAccuracyDegrees(Location r0) {
            return r0.getBearingAccuracyDegrees();
        }

        static float getSpeedAccuracyMetersPerSecond(Location r0) {
            return r0.getSpeedAccuracyMetersPerSecond();
        }

        static float getVerticalAccuracyMeters(Location r0) {
            return r0.getVerticalAccuracyMeters();
        }

        static boolean hasBearingAccuracy(Location r0) {
            return r0.hasBearingAccuracy();
        }

        static boolean hasSpeedAccuracy(Location r0) {
            return r0.hasSpeedAccuracy();
        }

        static boolean hasVerticalAccuracy(Location r0) {
            return r0.hasVerticalAccuracy();
        }

        static void removeBearingAccuracy(Location r2) {
            byte r0 = (byte) (LocationCompat.getFieldsMaskField().getByte(r2) & (~LocationCompat.getHasBearingAccuracyMask()));     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L7
            LocationCompat.getFieldsMaskField().setByte(r2, r0);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L7
            return;
        L4:
            e = move-exception;
            IllegalAccessError r1 = new IllegalAccessError();
            r1.initCause(e);
            throw r1;
        L7:
            e = move-exception;
            NoSuchFieldError r3 = new NoSuchFieldError();
            r3.initCause(e);
            throw r3;
        }

        static void removeSpeedAccuracy(Location r2) {
            byte r0 = (byte) (LocationCompat.getFieldsMaskField().getByte(r2) & (~LocationCompat.getHasSpeedAccuracyMask()));     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L7
            LocationCompat.getFieldsMaskField().setByte(r2, r0);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L7
            return;
        L4:
            e = move-exception;
            IllegalAccessError r1 = new IllegalAccessError();
            r1.initCause(e);
            throw r1;
        L7:
            e = move-exception;
            NoSuchFieldError r3 = new NoSuchFieldError();
            r3.initCause(e);
            throw r3;
        }

        static void removeVerticalAccuracy(Location r2) {
            byte r0 = (byte) (LocationCompat.getFieldsMaskField().getByte(r2) & (~LocationCompat.getHasVerticalAccuracyMask()));     // Catch: Throwable -> L4
            LocationCompat.getFieldsMaskField().setByte(r2, r0);     // Catch: Throwable -> L4
            return;
        L4:
            e = move-exception;
            IllegalAccessError r1 = new IllegalAccessError();
            r1.initCause(e);
            throw r1;
        }

        static void setBearingAccuracyDegrees(Location r0, float r1) {
            r0.setBearingAccuracyDegrees(r1);
        }

        static void setSpeedAccuracyMetersPerSecond(Location r0, float r1) {
            r0.setSpeedAccuracyMetersPerSecond(r1);
        }

        static void setVerticalAccuracyMeters(Location r0, float r1) {
            r0.setVerticalAccuracyMeters(r1);
        }
    }

    private static class Api28Impl {
        private Api28Impl() {
        }

        static void removeBearingAccuracy(Location r24) {
            if (r24.hasBearingAccuracy() == true) goto L5;
            return;
        L5:
            String r1 = r24.getProvider();
            long r2 = r24.getTime();
            long r4 = r24.getElapsedRealtimeNanos();
            double r6 = r24.getLatitude();
            double r8 = r24.getLongitude();
            boolean r10 = r24.hasAltitude();
            double r11 = r24.getAltitude();
            boolean r13 = r24.hasSpeed();
            float r14 = r24.getSpeed();
            boolean r15 = r24.hasBearing();
            float r16 = r24.getBearing();
            boolean r17 = r24.hasAccuracy();
            float r18 = r24.getAccuracy();
            boolean r19 = r24.hasVerticalAccuracy();
            float r110 = r24.getVerticalAccuracyMeters();
            boolean r21 = r24.hasSpeedAccuracy();
            float r111 = r24.getSpeedAccuracyMetersPerSecond();
            Bundle r112 = r24.getExtras();
            r24.reset();
            r24.setProvider(r1);
            r24.setTime(r2);
            r24.setElapsedRealtimeNanos(r4);
            r24.setLatitude(r6);
            r24.setLongitude(r8);
            if (r10 == false) goto L8;
            r24.setAltitude(r11);
        L8:
            if (r13 == false) goto L10;
            r24.setSpeed(r14);
        L10:
            if (r15 == false) goto L12;
            r24.setBearing(r16);
        L12:
            if (r17 == false) goto L14;
            r24.setAccuracy(r18);
        L14:
            if (r19 == false) goto L16;
            r24.setVerticalAccuracyMeters(r110);
        L16:
            if (r21 == false) goto L18;
            r24.setBearingAccuracyDegrees(r111);
        L18:
            if (r112 == null) goto L21;
            r24.setExtras(r112);
            return;
        }

        static void removeSpeedAccuracy(Location r24) {
            if (r24.hasSpeedAccuracy() == true) goto L5;
            return;
        L5:
            String r1 = r24.getProvider();
            long r2 = r24.getTime();
            long r4 = r24.getElapsedRealtimeNanos();
            double r6 = r24.getLatitude();
            double r8 = r24.getLongitude();
            boolean r10 = r24.hasAltitude();
            double r11 = r24.getAltitude();
            boolean r13 = r24.hasSpeed();
            float r14 = r24.getSpeed();
            boolean r15 = r24.hasBearing();
            float r16 = r24.getBearing();
            boolean r17 = r24.hasAccuracy();
            float r18 = r24.getAccuracy();
            boolean r19 = r24.hasVerticalAccuracy();
            float r110 = r24.getVerticalAccuracyMeters();
            boolean r21 = r24.hasBearingAccuracy();
            float r111 = r24.getBearingAccuracyDegrees();
            Bundle r112 = r24.getExtras();
            r24.reset();
            r24.setProvider(r1);
            r24.setTime(r2);
            r24.setElapsedRealtimeNanos(r4);
            r24.setLatitude(r6);
            r24.setLongitude(r8);
            if (r10 == false) goto L8;
            r24.setAltitude(r11);
        L8:
            if (r13 == false) goto L10;
            r24.setSpeed(r14);
        L10:
            if (r15 == false) goto L12;
            r24.setBearing(r16);
        L12:
            if (r17 == false) goto L14;
            r24.setAccuracy(r18);
        L14:
            if (r19 == false) goto L16;
            r24.setVerticalAccuracyMeters(r110);
        L16:
            if (r21 == false) goto L18;
            r24.setBearingAccuracyDegrees(r111);
        L18:
            if (r112 == null) goto L21;
            r24.setExtras(r112);
            return;
        }

        static void removeVerticalAccuracy(Location r24) {
            if (r24.hasVerticalAccuracy() == true) goto L5;
            return;
        L5:
            String r1 = r24.getProvider();
            long r2 = r24.getTime();
            long r4 = r24.getElapsedRealtimeNanos();
            double r6 = r24.getLatitude();
            double r8 = r24.getLongitude();
            boolean r10 = r24.hasAltitude();
            double r11 = r24.getAltitude();
            boolean r13 = r24.hasSpeed();
            float r14 = r24.getSpeed();
            boolean r15 = r24.hasBearing();
            float r16 = r24.getBearing();
            boolean r17 = r24.hasAccuracy();
            float r18 = r24.getAccuracy();
            boolean r19 = r24.hasSpeedAccuracy();
            float r110 = r24.getSpeedAccuracyMetersPerSecond();
            boolean r21 = r24.hasBearingAccuracy();
            float r111 = r24.getBearingAccuracyDegrees();
            Bundle r112 = r24.getExtras();
            r24.reset();
            r24.setProvider(r1);
            r24.setTime(r2);
            r24.setElapsedRealtimeNanos(r4);
            r24.setLatitude(r6);
            r24.setLongitude(r8);
            if (r10 == false) goto L8;
            r24.setAltitude(r11);
        L8:
            if (r13 == false) goto L10;
            r24.setSpeed(r14);
        L10:
            if (r15 == false) goto L12;
            r24.setBearing(r16);
        L12:
            if (r17 == false) goto L14;
            r24.setAccuracy(r18);
        L14:
            if (r19 == false) goto L16;
            r24.setSpeedAccuracyMetersPerSecond(r110);
        L16:
            if (r21 == false) goto L18;
            r24.setBearingAccuracyDegrees(r111);
        L18:
            if (r112 == null) goto L21;
            r24.setExtras(r112);
            return;
        }
    }

    private static class Api29Impl {
        private Api29Impl() {
        }

        static void removeBearingAccuracy(Location r2) {
            if (r2.hasBearingAccuracy() == true) goto L5;
            return;
        L5:
            double r0 = r2.getElapsedRealtimeUncertaintyNanos();
            Api28Impl.removeBearingAccuracy(r2);
            r2.setElapsedRealtimeUncertaintyNanos(r0);
        }

        static void removeSpeedAccuracy(Location r2) {
            if (r2.hasSpeedAccuracy() == true) goto L5;
            return;
        L5:
            double r0 = r2.getElapsedRealtimeUncertaintyNanos();
            Api28Impl.removeSpeedAccuracy(r2);
            r2.setElapsedRealtimeUncertaintyNanos(r0);
        }

        static void removeVerticalAccuracy(Location r2) {
            if (r2.hasVerticalAccuracy() == true) goto L5;
            return;
        L5:
            double r0 = r2.getElapsedRealtimeUncertaintyNanos();
            Api28Impl.removeVerticalAccuracy(r2);
            r2.setElapsedRealtimeUncertaintyNanos(r0);
        }
    }

    private static class Api33Impl {
        private Api33Impl() {
        }

        static void removeBearingAccuracy(Location r0) {
            r0.removeBearingAccuracy();
        }

        static void removeSpeedAccuracy(Location r0) {
            r0.removeSpeedAccuracy();
        }

        static void removeVerticalAccuracy(Location r0) {
            r0.removeVerticalAccuracy();
        }
    }

    private static class Api34Impl {
        private Api34Impl() {
        }

        static float getMslAltitudeAccuracyMeters(Location r0) {
            return r0.getMslAltitudeAccuracyMeters();
        }

        static double getMslAltitudeMeters(Location r2) {
            return r2.getMslAltitudeMeters();
        }

        static boolean hasMslAltitude(Location r0) {
            return r0.hasMslAltitude();
        }

        static boolean hasMslAltitudeAccuracy(Location r0) {
            return r0.hasMslAltitudeAccuracy();
        }

        static void removeMslAltitude(Location r0) {
            r0.removeMslAltitude();
        }

        static void removeMslAltitudeAccuracy(Location r0) {
            r0.removeMslAltitudeAccuracy();
        }

        static void setMslAltitudeAccuracyMeters(Location r0, float r1) {
            r0.setMslAltitudeAccuracyMeters(r1);
        }

        static void setMslAltitudeMeters(Location r0, double r1) {
            r0.setMslAltitudeMeters(r1);
        }
    }

    private LocationCompat() {
    }

    private static boolean containsExtra(Location r0, String r1) {
        Bundle r2 = r0.getExtras();
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.containsKey(r1) == false) goto L7;
        return true;
    }

    public static float getBearingAccuracyDegrees(Location r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        Bundle r3 = r2.getExtras();
        if (r3 != null) goto L10;
        return 0.0f;
    L10:
        return r3.getFloat(EXTRA_BEARING_ACCURACY, 0.0f);
    L5:
        return Api26Impl.getBearingAccuracyDegrees(r2);
    }

    public static long getElapsedRealtimeMillis(Location r6) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        long r0 = System.currentTimeMillis() - r6.getTime();
        long r2 = SystemClock.elapsedRealtime();
        if (r0 >= 0) goto L10;
        return r2;
    L10:
        if (r0 <= r2) goto L13;
        return 0;
    L13:
        return r2 - r0;
    L5:
        return TimeUnit.NANOSECONDS.toMillis(Api17Impl.getElapsedRealtimeNanos(r6));
    }

    public static long getElapsedRealtimeNanos(Location r3) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return Api17Impl.getElapsedRealtimeNanos(r3);
    L7:
        return TimeUnit.MILLISECONDS.toNanos(getElapsedRealtimeMillis(r3));
    }

    static Field getFieldsMaskField() {
        if (sFieldsMaskField != null) goto L6;
        Field r0 = Location.class.getDeclaredField("mFieldsMask");
        sFieldsMaskField = r0;
        r0.setAccessible(true);
    L6:
        return sFieldsMaskField;
    }

    static int getHasBearingAccuracyMask() {
        if (sHasBearingAccuracyMask != null) goto L6;
        Field r0 = Location.class.getDeclaredField("HAS_BEARING_ACCURACY_MASK");
        r0.setAccessible(true);
        sHasBearingAccuracyMask = Integer.valueOf(r0.getInt(null));
    L6:
        return sHasBearingAccuracyMask.intValue();
    }

    static int getHasSpeedAccuracyMask() {
        if (sHasSpeedAccuracyMask != null) goto L6;
        Field r0 = Location.class.getDeclaredField("HAS_SPEED_ACCURACY_MASK");
        r0.setAccessible(true);
        sHasSpeedAccuracyMask = Integer.valueOf(r0.getInt(null));
    L6:
        return sHasSpeedAccuracyMask.intValue();
    }

    static int getHasVerticalAccuracyMask() {
        if (sHasVerticalAccuracyMask != null) goto L6;
        Field r0 = Location.class.getDeclaredField("HAS_VERTICAL_ACCURACY_MASK");
        r0.setAccessible(true);
        sHasVerticalAccuracyMask = Integer.valueOf(r0.getInt(null));
    L6:
        return sHasVerticalAccuracyMask.intValue();
    }

    public static float getMslAltitudeAccuracyMeters(Location r2) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        Preconditions.checkState(hasMslAltitudeAccuracy(r2), "The Mean Sea Level altitude accuracy of the location is not set.");
        return getOrCreateExtras(r2).getFloat(EXTRA_MSL_ALTITUDE_ACCURACY);
    L5:
        return Api34Impl.getMslAltitudeAccuracyMeters(r2);
    }

    public static double getMslAltitudeMeters(Location r2) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        Preconditions.checkState(hasMslAltitude(r2), "The Mean Sea Level altitude of the location is not set.");
        return getOrCreateExtras(r2).getDouble(EXTRA_MSL_ALTITUDE);
    L5:
        return Api34Impl.getMslAltitudeMeters(r2);
    }

    private static Bundle getOrCreateExtras(Location r1) {
        Bundle r0 = r1.getExtras();
        if (r0 != null) goto L6;
        r1.setExtras(new Bundle());
        return r1.getExtras();
    L6:
        return r0;
    }

    private static Method getSetIsFromMockProviderMethod() {
        if (sSetIsFromMockProviderMethod != null) goto L6;
        Method r0 = Location.class.getDeclaredMethod("setIsFromMockProvider", new Class[]{Boolean.TYPE});
        sSetIsFromMockProviderMethod = r0;
        r0.setAccessible(true);
    L6:
        return sSetIsFromMockProviderMethod;
    }

    public static float getSpeedAccuracyMetersPerSecond(Location r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        Bundle r3 = r2.getExtras();
        if (r3 != null) goto L10;
        return 0.0f;
    L10:
        return r3.getFloat(EXTRA_SPEED_ACCURACY, 0.0f);
    L5:
        return Api26Impl.getSpeedAccuracyMetersPerSecond(r2);
    }

    public static float getVerticalAccuracyMeters(Location r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        Bundle r3 = r2.getExtras();
        if (r3 != null) goto L10;
        return 0.0f;
    L10:
        return r3.getFloat(EXTRA_VERTICAL_ACCURACY, 0.0f);
    L5:
        return Api26Impl.getVerticalAccuracyMeters(r2);
    }

    public static boolean hasBearingAccuracy(Location r2) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.hasBearingAccuracy(r2);
    L7:
        return containsExtra(r2, EXTRA_BEARING_ACCURACY);
    }

    public static boolean hasMslAltitude(Location r2) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.hasMslAltitude(r2);
    L7:
        return containsExtra(r2, EXTRA_MSL_ALTITUDE);
    }

    public static boolean hasMslAltitudeAccuracy(Location r2) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.hasMslAltitudeAccuracy(r2);
    L7:
        return containsExtra(r2, EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static boolean hasSpeedAccuracy(Location r2) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.hasSpeedAccuracy(r2);
    L7:
        return containsExtra(r2, EXTRA_SPEED_ACCURACY);
    }

    public static boolean hasVerticalAccuracy(Location r2) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.hasVerticalAccuracy(r2);
    L7:
        return containsExtra(r2, EXTRA_VERTICAL_ACCURACY);
    }

    public static boolean isMock(Location r2) {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        Bundle r3 = r2.getExtras();
        if (r3 != null) goto L10;
        return false;
    L10:
        return r3.getBoolean(EXTRA_IS_MOCK, false);
    L5:
        return Api18Impl.isMock(r2);
    }

    public static void removeBearingAccuracy(Location r2) {
        if (Build.VERSION.SDK_INT < 33) goto L6;
        Api33Impl.removeBearingAccuracy(r2);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 29) goto L9;
        Api29Impl.removeBearingAccuracy(r2);
        return;
    L9:
        if (Build.VERSION.SDK_INT < 28) goto L12;
        Api28Impl.removeBearingAccuracy(r2);
        return;
    L12:
        if (Build.VERSION.SDK_INT < 26) goto L14;
        Api26Impl.removeBearingAccuracy(r2);
        return;
    L14:
        removeExtra(r2, EXTRA_BEARING_ACCURACY);
    }

    private static void removeExtra(Location r1, String r2) {
        Bundle r0 = r1.getExtras();
        if (r0 == null) goto L8;
        r0.remove(r2);
        if (r0.isEmpty() == false) goto L9;
        r1.setExtras(null);
        return;
    L9:
        return;
    }

    public static void removeMslAltitude(Location r2) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.removeMslAltitude(r2);
        return;
    L5:
        removeExtra(r2, EXTRA_MSL_ALTITUDE);
    }

    public static void removeMslAltitudeAccuracy(Location r2) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.removeMslAltitudeAccuracy(r2);
        return;
    L5:
        removeExtra(r2, EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static void removeSpeedAccuracy(Location r2) {
        if (Build.VERSION.SDK_INT < 33) goto L6;
        Api33Impl.removeSpeedAccuracy(r2);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 29) goto L9;
        Api29Impl.removeSpeedAccuracy(r2);
        return;
    L9:
        if (Build.VERSION.SDK_INT < 28) goto L12;
        Api28Impl.removeSpeedAccuracy(r2);
        return;
    L12:
        if (Build.VERSION.SDK_INT < 26) goto L14;
        Api26Impl.removeSpeedAccuracy(r2);
        return;
    L14:
        removeExtra(r2, EXTRA_SPEED_ACCURACY);
    }

    public static void removeVerticalAccuracy(Location r2) {
        if (Build.VERSION.SDK_INT < 33) goto L6;
        Api33Impl.removeVerticalAccuracy(r2);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 29) goto L9;
        Api29Impl.removeVerticalAccuracy(r2);
        return;
    L9:
        if (Build.VERSION.SDK_INT < 28) goto L12;
        Api28Impl.removeVerticalAccuracy(r2);
        return;
    L12:
        if (Build.VERSION.SDK_INT < 26) goto L14;
        Api26Impl.removeVerticalAccuracy(r2);
        return;
    L14:
        removeExtra(r2, EXTRA_VERTICAL_ACCURACY);
    }

    public static void setBearingAccuracyDegrees(Location r2, float r3) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Api26Impl.setBearingAccuracyDegrees(r2, r3);
        return;
    L5:
        getOrCreateExtras(r2).putFloat(EXTRA_BEARING_ACCURACY, r3);
    }

    public static void setMock(Location r3, boolean r4) {
        if (Build.VERSION.SDK_INT >= 18) goto L26;
        Bundle r0 = r3.getExtras();
        if (r0 != null) goto L20;
        if (r4 == false) goto L25;
        Bundle r5 = new Bundle();
        r5.putBoolean(EXTRA_IS_MOCK, true);
    L19:
        r3.setExtras(r5);
        return;
    L25:
        return;
    L20:
        if (r4 == false) goto L22;
        r0.putBoolean(EXTRA_IS_MOCK, true);
        return;
    L22:
        r0.remove(EXTRA_IS_MOCK);
        if (r0.isEmpty() == false) goto L30;
        r5 = null;
        goto L19
    L30:
        return;
    L26:
        getSetIsFromMockProviderMethod().invoke(r3, new Object[]{Boolean.valueOf(r4)});     // Catch: InvocationTargetException -> L6 IllegalAccessException -> L9 NoSuchMethodException -> L12
    L31:
        return;
    L9:
        e = move-exception;
        IllegalAccessError r6 = new IllegalAccessError();
        r6.initCause(e);
        throw r6;
    L12:
        e = move-exception;
        NoSuchMethodError r7 = new NoSuchMethodError();
        r7.initCause(e);
        throw r7;
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void setMslAltitudeAccuracyMeters(Location r2, float r3) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.setMslAltitudeAccuracyMeters(r2, r3);
        return;
    L5:
        getOrCreateExtras(r2).putFloat(EXTRA_MSL_ALTITUDE_ACCURACY, r3);
    }

    public static void setMslAltitudeMeters(Location r2, double r3) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.setMslAltitudeMeters(r2, r3);
        return;
    L5:
        getOrCreateExtras(r2).putDouble(EXTRA_MSL_ALTITUDE, r3);
    }

    public static void setSpeedAccuracyMetersPerSecond(Location r2, float r3) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Api26Impl.setSpeedAccuracyMetersPerSecond(r2, r3);
        return;
    L5:
        getOrCreateExtras(r2).putFloat(EXTRA_SPEED_ACCURACY, r3);
    }

    public static void setVerticalAccuracyMeters(Location r2, float r3) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Api26Impl.setVerticalAccuracyMeters(r2, r3);
        return;
    L5:
        getOrCreateExtras(r2).putFloat(EXTRA_VERTICAL_ACCURACY, r3);
    }
}
