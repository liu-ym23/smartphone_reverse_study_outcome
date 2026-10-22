package androidx.core.location;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.CancellationSignal;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.Consumer;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public final class LocationManagerCompat {
    private static final long GET_CURRENT_LOCATION_TIMEOUT_MS = 30000;
    private static final long MAX_CURRENT_LOCATION_AGE_MS = 10000;
    private static final long PRE_N_LOOPER_TIMEOUT_S = 5;
    private static Field sContextField;
    private static Method sGnssRequestBuilderBuildMethod;
    private static Class<?> sGnssRequestBuilderClass;

    @GuardedBy("sLocationListeners")
    static final WeakHashMap<LocationListenerKey, WeakReference<LocationListenerTransport>> sLocationListeners = null;
    private static Method sRegisterGnssMeasurementsCallbackMethod;

    @RequiresApi(19)
    static class Api19Impl {
        private static Class<?> sLocationRequestClass;
        private static Method sRequestLocationUpdatesLooperMethod;

        private Api19Impl() {
        }

        @DoNotInline
        static boolean tryRequestLocationUpdates(LocationManager r10, String r11, LocationRequestCompat r12, LocationListenerCompat r13, Looper r14) {
            if (Build.VERSION.SDK_INT >= 19) goto L16;
        L14:
            return false;
        L16:
            if (sLocationRequestClass != null) goto L8;
            sLocationRequestClass = Class.forName("android.location.LocationRequest");     // Catch: Throwable -> L15
        L8:
            if (sRequestLocationUpdatesLooperMethod != null) goto L10;
            Method r15 = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{sLocationRequestClass, LocationListener.class, Looper.class});     // Catch: Throwable -> L15
            sRequestLocationUpdatesLooperMethod = r15;     // Catch: Throwable -> L15
            r15.setAccessible(true);     // Catch: Throwable -> L15
        L10:
            LocationRequest r16 = r12.toLocationRequest(r11);     // Catch: Throwable -> L15
            if (r16 == null) goto L14;
            sRequestLocationUpdatesLooperMethod.invoke(r10, new Object[]{r16, r13, r14});     // Catch: Throwable -> L15
            return true;
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        static boolean tryRequestLocationUpdates(LocationManager r10, String r11, LocationRequestCompat r12, LocationListenerTransport r13) {
            if (Build.VERSION.SDK_INT >= 19) goto L22;
        L20:
            return false;
        L22:
            if (sLocationRequestClass != null) goto L8;
            sLocationRequestClass = Class.forName("android.location.LocationRequest");     // Catch: Throwable -> L21
        L8:
            if (sRequestLocationUpdatesLooperMethod != null) goto L10;
            Method r14 = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{sLocationRequestClass, LocationListener.class, Looper.class});     // Catch: Throwable -> L21
            sRequestLocationUpdatesLooperMethod = r14;     // Catch: Throwable -> L21
            r14.setAccessible(true);     // Catch: Throwable -> L21
        L10:
            LocationRequest r15 = r12.toLocationRequest(r11);     // Catch: Throwable -> L21
            if (r15 == null) goto L20;
            WeakHashMap<LocationListenerKey, WeakReference<LocationListenerTransport>> r16 = LocationManagerCompat.sLocationListeners;     // Catch: Throwable -> L21
            monitor-enter(r16);     // Catch: Throwable -> L21
            sRequestLocationUpdatesLooperMethod.invoke(r10, new Object[]{r15, r13, Looper.getMainLooper()});     // Catch: Throwable -> L17
            LocationManagerCompat.registerLocationListenerTransport(r10, r13);     // Catch: Throwable -> L17
            monitor-exit(r16);     // Catch: Throwable -> L17
            return true;
        L17:
            th = move-exception;
            throw th;     // Catch: Throwable -> L21 Throwable -> L21 Throwable -> L21 Throwable -> L21 Throwable -> L21
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        @DoNotInline
        static boolean registerGnssMeasurementsCallback(@NonNull LocationManager r10, @NonNull GnssMeasurementsEvent.Callback r11, @NonNull Handler r12) {
            return r10.registerGnssMeasurementsCallback(r11, r12);
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        static boolean registerGnssStatusCallback(LocationManager r10, Handler r11, Executor r12, GnssStatusCompat.Callback r13) {
            if (r11 == null) goto L5;
            boolean r14 = true;
        L6:
            Preconditions.checkArgument(r14);
            SimpleArrayMap<Object, Object> r15 = GnssListenersHolder.sGnssStatusListeners;
            monitor-enter(r15);
            PreRGnssStatusTransport r16 = (PreRGnssStatusTransport) r15.get(r13);     // Catch: Throwable -> L19
            if (r16 != null) goto L11;
            r16 = new PreRGnssStatusTransport(r13);     // Catch: Throwable -> L19
        L12:
            r16.register(r12);     // Catch: Throwable -> L19
            if (r10.registerGnssStatusCallback(r16, r11) == false) goto L17;
            r15.put(r13, r16);     // Catch: Throwable -> L19
            monitor-exit(r15);     // Catch: Throwable -> L19
            return true;
        L17:
            monitor-exit(r15);     // Catch: Throwable -> L19
            return false;
        L11:
            r16.unregister();     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            throw th;
        L5:
            r14 = false;
            goto L6
        }

        @DoNotInline
        static void unregisterGnssMeasurementsCallback(@NonNull LocationManager r10, @NonNull GnssMeasurementsEvent.Callback r11) {
            r10.unregisterGnssMeasurementsCallback(r11);
        }

        @DoNotInline
        static void unregisterGnssStatusCallback(LocationManager r10, Object r11) {
            if ((r11 instanceof PreRGnssStatusTransport) == false) goto L5;
            ((PreRGnssStatusTransport) r11).unregister();
        L5:
            r10.unregisterGnssStatusCallback((GnssStatus.Callback) r11);
        }
    }

    @RequiresApi(28)
    private static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static String getGnssHardwareModelName(LocationManager r10) {
            return r10.getGnssHardwareModelName();
        }

        @DoNotInline
        static int getGnssYearOfHardware(LocationManager r10) {
            return r10.getGnssYearOfHardware();
        }

        @DoNotInline
        static boolean isLocationEnabled(LocationManager r10) {
            return r10.isLocationEnabled();
        }
    }

    @RequiresApi(30)
    private static class Api30Impl {
        private static Class<?> sLocationRequestClass;
        private static Method sRequestLocationUpdatesExecutorMethod;

        private Api30Impl() {
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        static void getCurrentLocation(LocationManager r10, @NonNull String r11, @Nullable CancellationSignal r12, @NonNull Executor r13, @NonNull final Consumer<Location> r14) {
            if (r12 == null) goto L4;
            android.os.CancellationSignal r15 = (android.os.CancellationSignal) r12.getCancellationSignalObject();
        L5:
            Objects.requireNonNull(r14);
            r10.getCurrentLocation(r11, r15, r13, new d(r14));
            return;
        L4:
            r15 = null;
            goto L5
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        public static boolean registerGnssStatusCallback(LocationManager r10, Handler r11, Executor r12, GnssStatusCompat.Callback r13) {
            SimpleArrayMap<Object, Object> r14 = GnssListenersHolder.sGnssStatusListeners;
            monitor-enter(r14);
            GnssStatusTransport r15 = (GnssStatusTransport) r14.get(r13);     // Catch: Throwable -> L15
            if (r15 != null) goto L8;
            r15 = new GnssStatusTransport(r13);     // Catch: Throwable -> L15
        L8:
            if (r10.registerGnssStatusCallback(r12, r15) == false) goto L13;
            r14.put(r13, r15);     // Catch: Throwable -> L15
            monitor-exit(r14);     // Catch: Throwable -> L15
            return true;
        L13:
            monitor-exit(r14);     // Catch: Throwable -> L15
            return false;
        L15:
            th = move-exception;
            throw th;
        }

        @DoNotInline
        public static boolean tryRequestLocationUpdates(LocationManager r10, String r11, LocationRequestCompat r12, Executor r13, LocationListenerCompat r14) {
            if (Build.VERSION.SDK_INT >= 30) goto L16;
        L14:
            return false;
        L16:
            if (sLocationRequestClass != null) goto L8;
            sLocationRequestClass = Class.forName("android.location.LocationRequest");     // Catch: Throwable -> L15
        L8:
            if (sRequestLocationUpdatesExecutorMethod != null) goto L10;
            Method r15 = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{sLocationRequestClass, Executor.class, LocationListener.class});     // Catch: Throwable -> L15
            sRequestLocationUpdatesExecutorMethod = r15;     // Catch: Throwable -> L15
            r15.setAccessible(true);     // Catch: Throwable -> L15
        L10:
            LocationRequest r16 = r12.toLocationRequest(r11);     // Catch: Throwable -> L15
            if (r16 == null) goto L14;
            sRequestLocationUpdatesExecutorMethod.invoke(r10, new Object[]{r16, r13, r14});     // Catch: Throwable -> L15
            return true;
        }
    }

    @RequiresApi(31)
    private static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        static boolean hasProvider(LocationManager r10, @NonNull String r11) {
            return r10.hasProvider(r11);
        }

        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        @DoNotInline
        static boolean registerGnssMeasurementsCallback(@NonNull LocationManager r10, @NonNull Executor r11, @NonNull GnssMeasurementsEvent.Callback r12) {
            return r10.registerGnssMeasurementsCallback(r11, r12);
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        static void requestLocationUpdates(LocationManager r10, @NonNull String r11, @NonNull LocationRequest r12, @NonNull Executor r13, @NonNull LocationListener r14) {
            r10.requestLocationUpdates(r11, r12, r13, r14);
        }
    }

    private static final class CancellableLocationListener implements LocationListener {
        private Consumer<Location> mConsumer;
        private final Executor mExecutor;
        private final LocationManager mLocationManager;
        private final Handler mTimeoutHandler;

        @Nullable
        Runnable mTimeoutRunnable;

        @GuardedBy("this")
        private boolean mTriggered;

        CancellableLocationListener(LocationManager r10, Executor r11, Consumer<Location> r12) {
            this.mLocationManager = r10;
            this.mExecutor = r11;
            this.mTimeoutHandler = new Handler(Looper.getMainLooper());
            this.mConsumer = r12;
        }

        public static /* synthetic */ void a(Consumer r10, Location r11) {
            lambda$onLocationChanged$1(r10, r11);
        }

        public static /* synthetic */ void b(CancellableLocationListener r10) {
            r10.lambda$startTimeout$0();
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        private void cleanup() {
            this.mConsumer = null;
            this.mLocationManager.removeUpdates(this);
            Runnable r10 = this.mTimeoutRunnable;
            if (r10 == null) goto L6;
            this.mTimeoutHandler.removeCallbacks(r10);
            this.mTimeoutRunnable = null;
            return;
        }

        private static /* synthetic */ void lambda$onLocationChanged$1(Consumer r10, Location r11) {
            r10.accept(r11);
        }

        private /* synthetic */ void lambda$startTimeout$0() {
            this.mTimeoutRunnable = null;
            onLocationChanged(null);
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void cancel() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.mTriggered == false) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L11
            return;
        L7:
            this.mTriggered = true;     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L11
            cleanup();
        }

        @Override // android.location.LocationListener
        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void onLocationChanged(@Nullable final Location r10) {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.mTriggered == false) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L11
            return;
        L7:
            this.mTriggered = true;     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L11
            final Consumer<Location> r11 = this.mConsumer;
            this.mExecutor.execute(new f(r11, r10));
            cleanup();
        }

        @Override // android.location.LocationListener
        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void onProviderDisabled(@NonNull String r10) {
            onLocationChanged(null);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(@NonNull String r10) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String r10, int r11, Bundle r12) {
        }

        @SuppressLint({"MissingPermission"})
        public void startTimeout(long r10) {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (this.mTriggered == false) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L10
            return;
        L7:
            Runnable r11 = new e(this);     // Catch: Throwable -> L10
            this.mTimeoutRunnable = r11;     // Catch: Throwable -> L10
            this.mTimeoutHandler.postDelayed(r11, r10);     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
        }
    }

    private static class GnssListenersHolder {

        @GuardedBy("sGnssStatusListeners")
        static final SimpleArrayMap<Object, Object> sGnssStatusListeners = null;

        static {
            sGnssStatusListeners = new SimpleArrayMap();
        }

        private GnssListenersHolder() {
        }
    }

    @RequiresApi(30)
    private static class GnssStatusTransport extends GnssStatus.Callback {
        final GnssStatusCompat.Callback mCallback;

        GnssStatusTransport(GnssStatusCompat.Callback r10) {
            if (r10 == null) goto L5;
            boolean r11 = true;
        L6:
            Preconditions.checkArgument(r11, "invalid null callback");
            this.mCallback = r10;
            return;
        L5:
            r11 = false;
            goto L6
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int r10) {
            this.mCallback.onFirstFix(r10);
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus r10) {
            this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(r10));
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            this.mCallback.onStarted();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            this.mCallback.onStopped();
        }
    }

    private static class GpsStatusTransport implements GpsStatus.Listener {
        final GnssStatusCompat.Callback mCallback;

        @Nullable
        volatile Executor mExecutor;
        private final LocationManager mLocationManager;

        GpsStatusTransport(LocationManager r10, GnssStatusCompat.Callback r11) {
            if (r11 == null) goto L5;
            boolean r12 = true;
        L6:
            Preconditions.checkArgument(r12, "invalid null callback");
            this.mLocationManager = r10;
            this.mCallback = r11;
            return;
        L5:
            r12 = false;
            goto L6
        }

        public static /* synthetic */ void a(GpsStatusTransport r10, Executor r11, int r12) {
            r10.lambda$onGpsStatusChanged$2(r11, r12);
        }

        public static /* synthetic */ void b(GpsStatusTransport r10, Executor r11, GnssStatusCompat r12) {
            r10.lambda$onGpsStatusChanged$3(r11, r12);
        }

        public static /* synthetic */ void c(GpsStatusTransport r10, Executor r11) {
            r10.lambda$onGpsStatusChanged$0(r11);
        }

        public static /* synthetic */ void d(GpsStatusTransport r10, Executor r11) {
            r10.lambda$onGpsStatusChanged$1(r11);
        }

        private /* synthetic */ void lambda$onGpsStatusChanged$0(Executor r10) {
            if (this.mExecutor == r10) goto L5;
            return;
        L5:
            this.mCallback.onStarted();
        }

        private /* synthetic */ void lambda$onGpsStatusChanged$1(Executor r10) {
            if (this.mExecutor == r10) goto L5;
            return;
        L5:
            this.mCallback.onStopped();
        }

        private /* synthetic */ void lambda$onGpsStatusChanged$2(Executor r10, int r11) {
            if (this.mExecutor == r10) goto L5;
            return;
        L5:
            this.mCallback.onFirstFix(r11);
        }

        private /* synthetic */ void lambda$onGpsStatusChanged$3(Executor r10, GnssStatusCompat r11) {
            if (this.mExecutor == r10) goto L5;
            return;
        L5:
            this.mCallback.onSatelliteStatusChanged(r11);
        }

        @Override // android.location.GpsStatus.Listener
        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        public void onGpsStatusChanged(int r10) {
            final Executor r11 = this.mExecutor;
            if (r11 != null) goto L6;
            return;
        L6:
            if (r10 != 1) goto L8;
            Runnable r12 = new g(this, r11);
        L23:
            r11.execute(r12);
            return;
        L8:
            if (r10 != 2) goto L10;
            r12 = new h(this, r11);
            goto L23
        L10:
            if (r10 != 3) goto L12;
            GpsStatus r13 = this.mLocationManager.getGpsStatus(null);
            if (r13 == null) goto L26;
            final int r14 = r13.getTimeToFirstFix();
            Runnable r15 = new i(this, r11, r14);
        L20:
            r11.execute(r15);
            return;
        L26:
            return;
        L12:
            if (r10 != 4) goto L28;
            GpsStatus r16 = this.mLocationManager.getGpsStatus(null);
            if (r16 == null) goto L25;
            final GnssStatusCompat r17 = GnssStatusCompat.wrap(r16);
            r15 = new j(this, r11, r17);
            goto L20
        L25:
            return;
        }

        public void register(Executor r10) {
            if (this.mExecutor != null) goto L5;
            boolean r11 = true;
        L6:
            Preconditions.checkState(r11);
            this.mExecutor = r10;
            return;
        L5:
            r11 = false;
            goto L6
        }

        public void unregister() {
            this.mExecutor = null;
        }
    }

    private static final class InlineHandlerExecutor implements Executor {
        private final Handler mHandler;

        InlineHandlerExecutor(@NonNull Handler r10) {
            this.mHandler = (Handler) Preconditions.checkNotNull(r10);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable r10) {
            if (Looper.myLooper() != this.mHandler.getLooper()) goto L6;
            r10.run();
            return;
        L6:
            if (this.mHandler.post((Runnable) Preconditions.checkNotNull(r10)) == false) goto L9;
            return;
        L9:
            throw new RejectedExecutionException(this.mHandler + " is shutting down");
        }
    }

    private static class LocationListenerKey {
        final LocationListenerCompat mListener;
        final String mProvider;

        LocationListenerKey(String r10, LocationListenerCompat r11) {
            this.mProvider = (String) ObjectsCompat.requireNonNull(r10, "invalid null provider");
            this.mListener = (LocationListenerCompat) ObjectsCompat.requireNonNull(r11, "invalid null listener");
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof LocationListenerKey) == true) goto L5;
            return false;
        L5:
            LocationListenerKey r11 = (LocationListenerKey) r10;
            if (this.mProvider.equals(r11.mProvider) == true) goto L8;
            return false;
        L8:
            if (this.mListener.equals(r11.mListener) == false) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{this.mProvider, this.mListener});
        }
    }

    private static class LocationListenerTransport implements LocationListener {
        final Executor mExecutor;

        @Nullable
        volatile LocationListenerKey mKey;

        LocationListenerTransport(@Nullable LocationListenerKey r10, Executor r11) {
            this.mKey = r10;
            this.mExecutor = r11;
        }

        public static /* synthetic */ void a(LocationListenerTransport r10, String r11) {
            r10.lambda$onProviderEnabled$4(r11);
        }

        public static /* synthetic */ void b(LocationListenerTransport r10, String r11, int r12, Bundle r13) {
            r10.lambda$onStatusChanged$3(r11, r12, r13);
        }

        public static /* synthetic */ void c(LocationListenerTransport r10, List r11) {
            r10.lambda$onLocationChanged$1(r11);
        }

        public static /* synthetic */ void d(LocationListenerTransport r10, int r11) {
            r10.lambda$onFlushComplete$2(r11);
        }

        public static /* synthetic */ void e(LocationListenerTransport r10, String r11) {
            r10.lambda$onProviderDisabled$5(r11);
        }

        public static /* synthetic */ void f(LocationListenerTransport r10, Location r11) {
            r10.lambda$onLocationChanged$0(r11);
        }

        private /* synthetic */ void lambda$onFlushComplete$2(int r10) {
            LocationListenerKey r11 = this.mKey;
            if (r11 != null) goto L5;
            return;
        L5:
            r11.mListener.onFlushComplete(r10);
        }

        private /* synthetic */ void lambda$onLocationChanged$0(Location r10) {
            LocationListenerKey r11 = this.mKey;
            if (r11 != null) goto L5;
            return;
        L5:
            r11.mListener.onLocationChanged(r10);
        }

        private /* synthetic */ void lambda$onLocationChanged$1(List r10) {
            LocationListenerKey r11 = this.mKey;
            if (r11 != null) goto L5;
            return;
        L5:
            r11.mListener.onLocationChanged(r10);
        }

        private /* synthetic */ void lambda$onProviderDisabled$5(String r10) {
            LocationListenerKey r11 = this.mKey;
            if (r11 != null) goto L5;
            return;
        L5:
            r11.mListener.onProviderDisabled(r10);
        }

        private /* synthetic */ void lambda$onProviderEnabled$4(String r10) {
            LocationListenerKey r11 = this.mKey;
            if (r11 != null) goto L5;
            return;
        L5:
            r11.mListener.onProviderEnabled(r10);
        }

        private /* synthetic */ void lambda$onStatusChanged$3(String r10, int r11, Bundle r12) {
            LocationListenerKey r13 = this.mKey;
            if (r13 != null) goto L5;
            return;
        L5:
            r13.mListener.onStatusChanged(r10, r11, r12);
        }

        public LocationListenerKey getKey() {
            return (LocationListenerKey) ObjectsCompat.requireNonNull(this.mKey);
        }

        @Override // android.location.LocationListener
        public void onFlushComplete(final int r10) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new k(this, r10));
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(@NonNull final Location r10) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new l(this, r10));
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(@NonNull final List<Location> r10) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new p(this, r10));
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(@NonNull final String r10) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new n(this, r10));
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(@NonNull final String r10) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new m(this, r10));
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(final String r10, final int r11, final Bundle r12) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new o(this, r10, r11, r12));
        }

        public void unregister() {
            this.mKey = null;
        }
    }

    @RequiresApi(24)
    private static class PreRGnssStatusTransport extends GnssStatus.Callback {
        final GnssStatusCompat.Callback mCallback;

        @Nullable
        volatile Executor mExecutor;

        PreRGnssStatusTransport(GnssStatusCompat.Callback r10) {
            if (r10 == null) goto L5;
            boolean r11 = true;
        L6:
            Preconditions.checkArgument(r11, "invalid null callback");
            this.mCallback = r10;
            return;
        L5:
            r11 = false;
            goto L6
        }

        public static /* synthetic */ void a(PreRGnssStatusTransport r10, Executor r11) {
            r10.lambda$onStopped$1(r11);
        }

        public static /* synthetic */ void b(PreRGnssStatusTransport r10, Executor r11, GnssStatus r12) {
            r10.lambda$onSatelliteStatusChanged$3(r11, r12);
        }

        public static /* synthetic */ void c(PreRGnssStatusTransport r10, Executor r11, int r12) {
            r10.lambda$onFirstFix$2(r11, r12);
        }

        public static /* synthetic */ void d(PreRGnssStatusTransport r10, Executor r11) {
            r10.lambda$onStarted$0(r11);
        }

        private /* synthetic */ void lambda$onFirstFix$2(Executor r10, int r11) {
            if (this.mExecutor == r10) goto L5;
            return;
        L5:
            this.mCallback.onFirstFix(r11);
        }

        private /* synthetic */ void lambda$onSatelliteStatusChanged$3(Executor r10, GnssStatus r11) {
            if (this.mExecutor == r10) goto L5;
            return;
        L5:
            this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(r11));
        }

        private /* synthetic */ void lambda$onStarted$0(Executor r10) {
            if (this.mExecutor == r10) goto L5;
            return;
        L5:
            this.mCallback.onStarted();
        }

        private /* synthetic */ void lambda$onStopped$1(Executor r10) {
            if (this.mExecutor == r10) goto L5;
            return;
        L5:
            this.mCallback.onStopped();
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(final int r10) {
            final Executor r11 = this.mExecutor;
            if (r11 != null) goto L5;
            return;
        L5:
            r11.execute(new s(this, r11, r10));
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(final GnssStatus r10) {
            final Executor r11 = this.mExecutor;
            if (r11 != null) goto L5;
            return;
        L5:
            r11.execute(new t(this, r11, r10));
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            final Executor r10 = this.mExecutor;
            if (r10 != null) goto L5;
            return;
        L5:
            r10.execute(new r(this, r10));
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            final Executor r10 = this.mExecutor;
            if (r10 != null) goto L5;
            return;
        L5:
            r10.execute(new q(this, r10));
        }

        public void register(Executor r10) {
            boolean r11 = true;
            if (r10 == null) goto L5;
            boolean r12 = true;
        L6:
            Preconditions.checkArgument(r12, "invalid null executor");
            if (this.mExecutor == null) goto L10;
            r11 = false;
        L10:
            Preconditions.checkState(r11);
            this.mExecutor = r10;
            return;
        L5:
            r12 = false;
            goto L6
        }

        public void unregister() {
            this.mExecutor = null;
        }
    }

    static {
        sLocationListeners = new WeakHashMap();
    }

    private LocationManagerCompat() {
    }

    public static /* synthetic */ void a(Consumer r10, Location r11) {
        lambda$getCurrentLocation$0(r10, r11);
    }

    public static /* synthetic */ Boolean b(LocationManager r10, GpsStatusTransport r11) {
        return lambda$registerGnssStatusCallback$1(r10, r11);
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void getCurrentLocation(@NonNull LocationManager r10, @NonNull String r11, @Nullable CancellationSignal r12, @NonNull Executor r13, @NonNull final Consumer<Location> r14) {
        if (Build.VERSION.SDK_INT < 30) goto L6;
        Api30Impl.getCurrentLocation(r10, r11, r12, r13, r14);
        return;
    L6:
        if (r12 == null) goto L8;
        r12.throwIfCanceled();
    L8:
        final Location r15 = r10.getLastKnownLocation(r11);
        if (r15 != null) goto L11;
    L14:
        final CancellableLocationListener r16 = new CancellableLocationListener(r10, r13, r14);
        r10.requestLocationUpdates(r11, 0, 0.0f, r16, Looper.getMainLooper());
        if (r12 == null) goto L17;
        r12.setOnCancelListener(new a(r16));
    L17:
        r16.startTimeout(30000);
        return;
    L11:
        if ((SystemClock.elapsedRealtime() - LocationCompat.getElapsedRealtimeMillis(r15)) >= 10000) goto L14;
        r13.execute(new b(r14, r15));
    }

    @Nullable
    public static String getGnssHardwareModelName(@NonNull LocationManager r10) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return null;
    L5:
        return Api28Impl.getGnssHardwareModelName(r10);
    }

    public static int getGnssYearOfHardware(@NonNull LocationManager r10) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return 0;
    L5:
        return Api28Impl.getGnssYearOfHardware(r10);
    }

    public static boolean hasProvider(@NonNull LocationManager r10, @NonNull String r11) {
        if (Build.VERSION.SDK_INT < 31) goto L7;
        return Api31Impl.hasProvider(r10, r11);
    L7:
        if (r10.getAllProviders().contains(r11) == false) goto L16;
        return true;
    L16:
        if (r10.getProvider(r11) == null) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    public static boolean isLocationEnabled(@NonNull LocationManager r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 28) goto L7;
        return Api28Impl.isLocationEnabled(r10);
    L7:
        if (r11 > 19) goto L22;
        if (sContextField != null) goto L11;
        Field r12 = LocationManager.class.getDeclaredField("mContext");     // Catch: Throwable -> L27
        sContextField = r12;     // Catch: Throwable -> L27
        r12.setAccessible(true);     // Catch: Throwable -> L27
    L11:
        Context r13 = (Context) sContextField.get(r10);     // Catch: Throwable -> L27
        if (r13 == null) goto L22;
        if (r11 != 19) goto L20;
        if (Settings.Secure.getInt(r13.getContentResolver(), "location_mode", 0) != 0) goto L17;
        return false;
    L17:
        return true;
    L20:
        return !TextUtils.isEmpty(Settings.Secure.getString(r13.getContentResolver(), "location_providers_allowed"));
    L22:
        if (r10.isProviderEnabled("network") == true) goto L26;
        if (r10.isProviderEnabled("gps") == true) goto L26;
        return false;
    L26:
        return true;
    }

    private static /* synthetic */ void lambda$getCurrentLocation$0(Consumer r10, Location r11) {
        r10.accept(r11);
    }

    private static /* synthetic */ Boolean lambda$registerGnssStatusCallback$1(LocationManager r10, GpsStatusTransport r11) {
        return Boolean.valueOf(r10.addGpsStatusListener(r11));
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    @RequiresApi(24)
    public static boolean registerGnssMeasurementsCallback(@NonNull LocationManager r10, @NonNull GnssMeasurementsEvent.Callback r11, @NonNull Handler r12) {
        if (Build.VERSION.SDK_INT == 30) goto L7;
        return Api24Impl.registerGnssMeasurementsCallback(r10, r11, r12);
    L7:
        return registerGnssMeasurementsCallbackOnR(r10, ExecutorCompat.create(r12), r11);
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    @RequiresApi(30)
    public static boolean registerGnssMeasurementsCallback(@NonNull LocationManager r10, @NonNull Executor r11, @NonNull GnssMeasurementsEvent.Callback r12) {
        if (Build.VERSION.SDK_INT <= 30) goto L7;
        return Api31Impl.registerGnssMeasurementsCallback(r10, r11, r12);
    L7:
        return registerGnssMeasurementsCallbackOnR(r10, r11, r12);
    }

    @RequiresApi(30)
    private static boolean registerGnssMeasurementsCallbackOnR(@NonNull LocationManager r10, @NonNull Executor r11, @NonNull GnssMeasurementsEvent.Callback r12) {
        if (Build.VERSION.SDK_INT != 30) goto L21;
        if (sGnssRequestBuilderClass != null) goto L9;
        sGnssRequestBuilderClass = Class.forName("android.location.GnssRequest$Builder");     // Catch: Throwable -> L22
    L9:
        if (sGnssRequestBuilderBuildMethod != null) goto L12;
        Method r13 = sGnssRequestBuilderClass.getDeclaredMethod("build", new Class[0]);     // Catch: Throwable -> L22
        sGnssRequestBuilderBuildMethod = r13;     // Catch: Throwable -> L22
        r13.setAccessible(true);     // Catch: Throwable -> L22
    L12:
        if (sRegisterGnssMeasurementsCallbackMethod != null) goto L14;
        Method r14 = LocationManager.class.getDeclaredMethod("registerGnssMeasurementsCallback", new Class[]{Class.forName("android.location.GnssRequest"), Executor.class, GnssMeasurementsEvent.Callback.class});     // Catch: Throwable -> L22
        sRegisterGnssMeasurementsCallbackMethod = r14;     // Catch: Throwable -> L22
        r14.setAccessible(true);     // Catch: Throwable -> L22
    L14:
        Object r15 = sRegisterGnssMeasurementsCallbackMethod.invoke(r10, new Object[]{sGnssRequestBuilderBuildMethod.invoke(sGnssRequestBuilderClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), new Object[0]), r11, r12});     // Catch: Throwable -> L22
        if (r15 == null) goto L25;
        if (((Boolean) r15).booleanValue() == true) goto L19;
        return false;
    L19:
        return true;
    L25:
        return false;
    L27:
        return false;
    L21:
        throw new IllegalStateException();
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    private static boolean registerGnssStatusCallback(final LocationManager r10, Handler r11, Executor r12, GnssStatusCompat.Callback r13) {
        int r14 = Build.VERSION.SDK_INT;
        if (r14 < 30) goto L7;
        return Api30Impl.registerGnssStatusCallback(r10, r11, r12, r13);
    L7:
        if (r14 >= 24) goto L9;
        boolean r15 = true;
        if (r11 == null) goto L13;
        boolean r16 = true;
    L14:
        Preconditions.checkArgument(r16);
        SimpleArrayMap<Object, Object> r17 = GnssListenersHolder.sGnssStatusListeners;
        monitor-enter(r17);
        final GpsStatusTransport r18 = (GpsStatusTransport) r17.get(r13);     // Catch: Throwable -> L74
        if (r18 != null) goto L19;
        r18 = new GpsStatusTransport(r10, r13);     // Catch: Throwable -> L74
    L20:
        r18.register(r12);     // Catch: Throwable -> L74
        FutureTask r19 = new FutureTask(new c(r10, r18));     // Catch: Throwable -> L74
        if (Looper.myLooper() != r11.getLooper()) goto L24;
        r19.run();     // Catch: Throwable -> L74
    L77:
        long r20 = TimeUnit.SECONDS.toNanos(5);     // Catch: Throwable -> L50 TimeoutException -> L52 ExecutionException -> L56
        long r21 = System.nanoTime() + r20;
        boolean r22 = false;
    L80:
    L44:
        r20 = r21 - System.nanoTime();
        r22 = true;
        goto L80
    L42:
        e = e;
    L59:
        if ((e.getCause() instanceof RuntimeException) == true) goto L67;
        if ((e.getCause() instanceof Error) == false) goto L65;
        throw ((Error) e.getCause());     // Catch: Throwable -> L68
    L65:
        throw new IllegalStateException(e);     // Catch: Throwable -> L68
    L67:
        throw ((RuntimeException) e.getCause());     // Catch: Throwable -> L68
    L40:
        e = e;
    L55:
        throw new IllegalStateException(r11 + " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread", e);     // Catch: Throwable -> L68
    L38:
        th = th;
        r15 = r22;
    L69:
        if (r15 == false) goto L71;
        Thread.currentThread().interrupt();     // Catch: Throwable -> L74
    L71:
        throw th;     // Catch: Throwable -> L74
    L48:
        e = e;
    L46:
        e = e;
        goto L55
    L28:
        if (((Boolean) r19.get(r20, TimeUnit.NANOSECONDS)).booleanValue() == false) goto L34;
        GnssListenersHolder.sGnssStatusListeners.put(r13, r18);     // Catch: Throwable -> L38 TimeoutException -> L40 ExecutionException -> L42 InterruptedException -> L44
    L30:
        if (r22 == false) goto L32;
        Thread.currentThread().interrupt();     // Catch: Throwable -> L74
    L32:
        monitor-exit(r17);     // Catch: Throwable -> L74
        return true;
    L34:
        if (r22 == false) goto L36;
        Thread.currentThread().interrupt();     // Catch: Throwable -> L74
    L36:
        monitor-exit(r17);     // Catch: Throwable -> L74
        return false;
    L68:
        th = th;
    L56:
        e = e;
    L52:
        e = e;
    L50:
        th = th;
        r15 = false;
        goto L69
    L24:
        if (r11.post(r19) == true) goto L77;
        throw new IllegalStateException(r11 + " is shutting down");     // Catch: Throwable -> L74
    L19:
        r18.unregister();     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        throw th;
    L13:
        r16 = false;
        goto L14
    L9:
        return Api24Impl.registerGnssStatusCallback(r10, r11, r12, r13);
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager r10, @NonNull GnssStatusCompat.Callback r11, @NonNull Handler r12) {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return registerGnssStatusCallback(r10, ExecutorCompat.create(r12), r11);
    L7:
        return registerGnssStatusCallback(r10, new InlineHandlerExecutor(r12), r11);
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager r10, @NonNull Executor r11, @NonNull GnssStatusCompat.Callback r12) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        Looper r13 = Looper.myLooper();
        if (r13 != null) goto L10;
        r13 = Looper.getMainLooper();
    L10:
        return registerGnssStatusCallback(r10, new Handler(r13), r11, r12);
    L5:
        return registerGnssStatusCallback(r10, null, r11, r12);
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @GuardedBy("sLocationListeners")
    static void registerLocationListenerTransport(LocationManager r10, LocationListenerTransport r11) {
        WeakReference<LocationListenerTransport> r12 = sLocationListeners.put(r11.getKey(), new WeakReference(r11));
        if (r12 == null) goto L5;
        LocationListenerTransport r13 = r12.get();
    L6:
        if (r13 == null) goto L9;
        r13.unregister();
        r10.removeUpdates(r13);
        return;
    L9:
        return;
    L5:
        r13 = null;
        goto L6
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void removeUpdates(@NonNull LocationManager r10, @NonNull LocationListenerCompat r11) {
        WeakHashMap<LocationListenerKey, WeakReference<LocationListenerTransport>> r12 = sLocationListeners;
        monitor-enter(r12);
        ArrayList r13 = null;
        Iterator<WeakReference<LocationListenerTransport>> r14 = r12.values().iterator();     // Catch: Throwable -> L24
    L7:
        if (r14.hasNext() == false) goto L16;
        LocationListenerTransport r15 = r14.next().get();     // Catch: Throwable -> L24
        if (r15 == null) goto L7;
        LocationListenerKey r16 = r15.getKey();     // Catch: Throwable -> L24
        if (r16.mListener != r11) goto L7;
        if (r13 != null) goto L15;
        r13 = new ArrayList();     // Catch: Throwable -> L24
    L15:
        r13.add(r16);     // Catch: Throwable -> L24
        r15.unregister();     // Catch: Throwable -> L24
        r10.removeUpdates(r15);     // Catch: Throwable -> L24
        goto L7
    L16:
        if (r13 == null) goto L21;
        Iterator r17 = r13.iterator();     // Catch: Throwable -> L24
    L19:
        if (r17.hasNext() == false) goto L21;
        LocationListenerKey r18 = (LocationListenerKey) r17.next();     // Catch: Throwable -> L24
        sLocationListeners.remove(r18);     // Catch: Throwable -> L24
    L21:
        monitor-exit(r12);     // Catch: Throwable -> L24
        r10.removeUpdates(r11);
        return;
    L24:
        th = move-exception;
        throw th;
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void requestLocationUpdates(@NonNull LocationManager r10, @NonNull String r11, @NonNull LocationRequestCompat r12, @NonNull LocationListenerCompat r13, @NonNull Looper r14) {
        int r15 = Build.VERSION.SDK_INT;
        if (r15 < 31) goto L7;
        Api31Impl.requestLocationUpdates(r10, r11, r12.toLocationRequest(), ExecutorCompat.create(new Handler(r14)), r13);
        return;
    L7:
        if (r15 >= 19) goto L9;
    L11:
        r10.requestLocationUpdates(r11, r12.getIntervalMillis(), r12.getMinUpdateDistanceMeters(), r13, r14);
        return;
    L9:
        if (Api19Impl.tryRequestLocationUpdates(r10, r11, r12, r13, r14) == false) goto L11;
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void requestLocationUpdates(@NonNull LocationManager r10, @NonNull String r11, @NonNull LocationRequestCompat r12, @NonNull Executor r13, @NonNull LocationListenerCompat r14) {
        int r15 = Build.VERSION.SDK_INT;
        if (r15 < 31) goto L7;
        Api31Impl.requestLocationUpdates(r10, r11, r12.toLocationRequest(), r13, r14);
        return;
    L7:
        if (r15 >= 30) goto L9;
    L11:
        LocationListenerTransport r16 = new LocationListenerTransport(new LocationListenerKey(r11, r14), r13);
        if (r15 >= 19) goto L14;
    L16:
        WeakHashMap<LocationListenerKey, WeakReference<LocationListenerTransport>> r17 = sLocationListeners;
        monitor-enter(r17);
        r10.requestLocationUpdates(r11, r12.getIntervalMillis(), r12.getMinUpdateDistanceMeters(), r16, Looper.getMainLooper());     // Catch: Throwable -> L21
        registerLocationListenerTransport(r10, r16);     // Catch: Throwable -> L21
        monitor-exit(r17);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    L14:
        if (Api19Impl.tryRequestLocationUpdates(r10, r11, r12, r16) == false) goto L16;
        return;
    L9:
        if (Api30Impl.tryRequestLocationUpdates(r10, r11, r12, r13, r14) == false) goto L11;
    }

    @RequiresApi(24)
    public static void unregisterGnssMeasurementsCallback(@NonNull LocationManager r10, @NonNull GnssMeasurementsEvent.Callback r11) {
        Api24Impl.unregisterGnssMeasurementsCallback(r10, r11);
    }

    public static void unregisterGnssStatusCallback(@NonNull LocationManager r10, @NonNull GnssStatusCompat.Callback r11) {
        if (Build.VERSION.SDK_INT < 24) goto L14;
        SimpleArrayMap<Object, Object> r12 = GnssListenersHolder.sGnssStatusListeners;
        monitor-enter(r12);
        Object r13 = r12.remove(r11);     // Catch: Throwable -> L11
        if (r13 == null) goto L9;
        Api24Impl.unregisterGnssStatusCallback(r10, r13);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r12);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        SimpleArrayMap<Object, Object> r14 = GnssListenersHolder.sGnssStatusListeners;
        monitor-enter(r14);
        GpsStatusTransport r15 = (GpsStatusTransport) r14.remove(r11);     // Catch: Throwable -> L21
        if (r15 == null) goto L19;
        r15.unregister();     // Catch: Throwable -> L21
        r10.removeGpsStatusListener(r15);     // Catch: Throwable -> L21
    L19:
        monitor-exit(r14);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    }
}
