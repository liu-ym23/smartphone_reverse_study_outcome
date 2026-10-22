package androidx.core.location;

import android.annotation.SuppressLint;
import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.collection.SimpleArrayMap;
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
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

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

    public static class Api19Impl {
        private static Class<?> sLocationRequestClass;
        private static Method sRequestLocationUpdatesLooperMethod;

        private Api19Impl() {
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        @SuppressLint({"BanUncheckedReflection"})
        public static boolean tryRequestLocationUpdates(LocationManager r10, String r11, LocationRequestCompat r12, LocationListenerTransport r13) {
            if (sLocationRequestClass != null) goto L6;
            sLocationRequestClass = Class.forName("android.location.LocationRequest");     // Catch: Throwable -> L20
        L6:
            if (sRequestLocationUpdatesLooperMethod != null) goto L8;
            Method r5 = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{sLocationRequestClass, LocationListener.class, Looper.class});     // Catch: Throwable -> L20
            sRequestLocationUpdatesLooperMethod = r5;     // Catch: Throwable -> L20
            r5.setAccessible(true);     // Catch: Throwable -> L20
        L8:
            LocationRequest r14 = r12.toLocationRequest(r11);     // Catch: Throwable -> L20
            if (r14 == null) goto L18;
            WeakHashMap<LocationListenerKey, WeakReference<LocationListenerTransport>> r15 = LocationManagerCompat.sLocationListeners;     // Catch: Throwable -> L20
            monitor-enter(r15);     // Catch: Throwable -> L20
            sRequestLocationUpdatesLooperMethod.invoke(r10, new Object[]{r14, r13, Looper.getMainLooper()});     // Catch: Throwable -> L15
            LocationManagerCompat.registerLocationListenerTransport(r10, r13);     // Catch: Throwable -> L15
            monitor-exit(r15);     // Catch: Throwable -> L15
            return true;
        L15:
            th = move-exception;
            throw th;     // Catch: Throwable -> L20 Throwable -> L20 Throwable -> L20 Throwable -> L20 Throwable -> L20
            goto L25
        L18:
            return false;
        L25:
            return false;
        }

        @DoNotInline
        @SuppressLint({"BanUncheckedReflection"})
        public static boolean tryRequestLocationUpdates(LocationManager r10, String r11, LocationRequestCompat r12, LocationListenerCompat r13, Looper r14) {
            if (sLocationRequestClass != null) goto L6;
            sLocationRequestClass = Class.forName("android.location.LocationRequest");     // Catch: Throwable -> L14
        L6:
            if (sRequestLocationUpdatesLooperMethod != null) goto L8;
            Method r5 = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{sLocationRequestClass, LocationListener.class, Looper.class});     // Catch: Throwable -> L14
            sRequestLocationUpdatesLooperMethod = r5;     // Catch: Throwable -> L14
            r5.setAccessible(true);     // Catch: Throwable -> L14
        L8:
            LocationRequest r15 = r12.toLocationRequest(r11);     // Catch: Throwable -> L14
            if (r15 == null) goto L12;
            sRequestLocationUpdatesLooperMethod.invoke(r10, new Object[]{r15, r13, r14});     // Catch: Throwable -> L14
            return true;
        L12:
            return false;
        L17:
            return false;
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        @DoNotInline
        public static boolean registerGnssMeasurementsCallback(@NonNull LocationManager r5, @NonNull GnssMeasurementsEvent.Callback r10) {
            return r5.registerGnssMeasurementsCallback(r10);
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        public static boolean registerGnssStatusCallback(LocationManager r5, Handler r10, Executor r11, GnssStatusCompat.Callback r12) {
            if (r10 == null) goto L5;
            boolean r13 = true;
        L6:
            Preconditions.checkArgument(r13);
            SimpleArrayMap<Object, Object> r14 = GnssListenersHolder.sGnssStatusListeners;
            monitor-enter(r14);
            PreRGnssStatusTransport r15 = (PreRGnssStatusTransport) r14.get(r12);     // Catch: Throwable -> L11
            if (r15 != null) goto L13;
            r15 = new PreRGnssStatusTransport(r12);     // Catch: Throwable -> L11
        L14:
            r15.register(r11);     // Catch: Throwable -> L11
            if (r5.registerGnssStatusCallback(r15, r10) == false) goto L19;
            r14.put(r12, r15);     // Catch: Throwable -> L11
            monitor-exit(r14);     // Catch: Throwable -> L11
            return true;
        L19:
            monitor-exit(r14);     // Catch: Throwable -> L11
            return false;
        L13:
            r15.unregister();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        L5:
            r13 = false;
            goto L6
        }

        @DoNotInline
        public static void unregisterGnssMeasurementsCallback(@NonNull LocationManager r5, @NonNull GnssMeasurementsEvent.Callback r10) {
            r5.unregisterGnssMeasurementsCallback(r10);
        }

        @DoNotInline
        public static void unregisterGnssStatusCallback(LocationManager r5, Object r10) {
            if ((r10 instanceof PreRGnssStatusTransport) == false) goto L5;
            ((PreRGnssStatusTransport) r10).unregister();
        L5:
            r5.unregisterGnssStatusCallback((GnssStatus.Callback) r10);
        }

        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        @DoNotInline
        public static boolean registerGnssMeasurementsCallback(@NonNull LocationManager r5, @NonNull GnssMeasurementsEvent.Callback r10, @NonNull Handler r11) {
            return r5.registerGnssMeasurementsCallback(r10, r11);
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static String getGnssHardwareModelName(LocationManager r5) {
            return r5.getGnssHardwareModelName();
        }

        @DoNotInline
        public static int getGnssYearOfHardware(LocationManager r5) {
            return r5.getGnssYearOfHardware();
        }

        @DoNotInline
        public static boolean isLocationEnabled(LocationManager r5) {
            return r5.isLocationEnabled();
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private static Class<?> sLocationRequestClass;
        private static Method sRequestLocationUpdatesExecutorMethod;

        private Api30Impl() {
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        public static void getCurrentLocation(LocationManager r5, @NonNull String r10, @Nullable CancellationSignal r11, @NonNull Executor r12, @NonNull final Consumer<Location> r13) {
            Objects.requireNonNull(r13);
            r5.getCurrentLocation(r10, r11, r12, new a(r13));
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        public static boolean registerGnssStatusCallback(LocationManager r5, Handler r10, Executor r11, GnssStatusCompat.Callback r12) {
            SimpleArrayMap<Object, Object> r13 = GnssListenersHolder.sGnssStatusListeners;
            monitor-enter(r13);
            GnssStatusTransport r14 = (GnssStatusTransport) r13.get(r12);     // Catch: Throwable -> L7
            if (r14 != null) goto L10;
            r14 = new GnssStatusTransport(r12);     // Catch: Throwable -> L7
        L10:
            if (r5.registerGnssStatusCallback(r11, r14) == false) goto L15;
            r13.put(r12, r14);     // Catch: Throwable -> L7
            monitor-exit(r13);     // Catch: Throwable -> L7
            return true;
        L15:
            monitor-exit(r13);     // Catch: Throwable -> L7
            return false;
        L7:
            th = move-exception;
            throw th;
        }

        @DoNotInline
        public static boolean tryRequestLocationUpdates(LocationManager r10, String r11, LocationRequestCompat r12, Executor r13, LocationListenerCompat r14) {
            if (sLocationRequestClass != null) goto L6;
            sLocationRequestClass = Class.forName("android.location.LocationRequest");     // Catch: Throwable -> L14
        L6:
            if (sRequestLocationUpdatesExecutorMethod != null) goto L8;
            Method r5 = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{sLocationRequestClass, Executor.class, LocationListener.class});     // Catch: Throwable -> L14
            sRequestLocationUpdatesExecutorMethod = r5;     // Catch: Throwable -> L14
            r5.setAccessible(true);     // Catch: Throwable -> L14
        L8:
            LocationRequest r15 = r12.toLocationRequest(r11);     // Catch: Throwable -> L14
            if (r15 == null) goto L12;
            sRequestLocationUpdatesExecutorMethod.invoke(r10, new Object[]{r15, r13, r14});     // Catch: Throwable -> L14
            return true;
        L12:
            return false;
        L17:
            return false;
        }
    }

    @RequiresApi(31)
    public static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        public static boolean hasProvider(LocationManager r5, @NonNull String r10) {
            return r5.hasProvider(r10);
        }

        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        @DoNotInline
        public static boolean registerGnssMeasurementsCallback(@NonNull LocationManager r5, @NonNull Executor r10, @NonNull GnssMeasurementsEvent.Callback r11) {
            return r5.registerGnssMeasurementsCallback(r10, r11);
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        public static void requestLocationUpdates(LocationManager r5, @NonNull String r10, @NonNull LocationRequest r11, @NonNull Executor r12, @NonNull LocationListener r13) {
            r5.requestLocationUpdates(r10, r11, r12, r13);
        }
    }

    public static final class CancellableLocationListener implements LocationListener {
        private Consumer<Location> mConsumer;
        private final Executor mExecutor;
        private final LocationManager mLocationManager;
        private final Handler mTimeoutHandler;

        @Nullable
        Runnable mTimeoutRunnable;

        @GuardedBy("this")
        private boolean mTriggered;

        public CancellableLocationListener(LocationManager r5, Executor r10, Consumer<Location> r11) {
            this.mLocationManager = r5;
            this.mExecutor = r10;
            this.mTimeoutHandler = new Handler(Looper.getMainLooper());
            this.mConsumer = r11;
        }

        public static /* synthetic */ void a(CancellableLocationListener r5) {
            r5.lambda$startTimeout$0();
        }

        public static /* synthetic */ void b(Consumer r5, Location r10) {
            lambda$onLocationChanged$1(r5, r10);
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        private void cleanup() {
            this.mConsumer = null;
            this.mLocationManager.removeUpdates(this);
            Runnable r5 = this.mTimeoutRunnable;
            if (r5 == null) goto L6;
            this.mTimeoutHandler.removeCallbacks(r5);
            this.mTimeoutRunnable = null;
            return;
        }

        private static /* synthetic */ void lambda$onLocationChanged$1(Consumer r5, Location r10) {
            r5.accept(r10);
        }

        private /* synthetic */ void lambda$startTimeout$0() {
            this.mTimeoutRunnable = null;
            onLocationChanged(null);
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void cancel() {
            monitor-enter(this);
        L7:
            th = move-exception;
            throw th;
        L4:
            if (this.mTriggered == false) goto L9;
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L9:
            this.mTriggered = true;     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            cleanup();
        }

        @Override // android.location.LocationListener
        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void onLocationChanged(@Nullable Location r5) {
            monitor-enter(this);
        L7:
            th = move-exception;
            throw th;
        L4:
            if (this.mTriggered == false) goto L9;
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L9:
            this.mTriggered = true;     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            Consumer<Location> r10 = this.mConsumer;
            this.mExecutor.execute(new c(0, r10, r5));
            cleanup();
        }

        @Override // android.location.LocationListener
        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void onProviderDisabled(@NonNull String r5) {
            onLocationChanged(null);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(@NonNull String r5) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String r5, int r10, Bundle r11) {
        }

        @SuppressLint({"MissingPermission"})
        public void startTimeout(long r5) {
            monitor-enter(this);
        L7:
            th = move-exception;
            throw th;
        L4:
            if (this.mTriggered == false) goto L9;
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L9:
            Runnable r10 = new b(this);     // Catch: Throwable -> L7
            this.mTimeoutRunnable = r10;     // Catch: Throwable -> L7
            this.mTimeoutHandler.postDelayed(r10, r5);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
        }
    }

    public static class GnssListenersHolder {

        @GuardedBy("sGnssMeasurementListeners")
        static final SimpleArrayMap<GnssMeasurementsEvent.Callback, GnssMeasurementsEvent.Callback> sGnssMeasurementListeners = null;

        @GuardedBy("sGnssStatusListeners")
        static final SimpleArrayMap<Object, Object> sGnssStatusListeners = null;

        static {
            sGnssStatusListeners = new SimpleArrayMap();
            sGnssMeasurementListeners = new SimpleArrayMap();
        }

        private GnssListenersHolder() {
        }
    }

    @RequiresApi(24)
    public static class GnssMeasurementsTransport extends GnssMeasurementsEvent.Callback {
        final GnssMeasurementsEvent.Callback mCallback;

        @Nullable
        volatile Executor mExecutor;

        public GnssMeasurementsTransport(@NonNull GnssMeasurementsEvent.Callback r5, @NonNull Executor r10) {
            this.mCallback = r5;
            this.mExecutor = r10;
        }

        public static /* synthetic */ void a(GnssMeasurementsTransport r5, Executor r10, GnssMeasurementsEvent r11) {
            r5.lambda$onGnssMeasurementsReceived$0(r10, r11);
        }

        public static /* synthetic */ void b(GnssMeasurementsTransport r5, Executor r10, int r11) {
            r5.lambda$onStatusChanged$1(r10, r11);
        }

        private /* synthetic */ void lambda$onGnssMeasurementsReceived$0(Executor r5, GnssMeasurementsEvent r10) {
            if (this.mExecutor == r5) goto L5;
            return;
        L5:
            this.mCallback.onGnssMeasurementsReceived(r10);
        }

        private /* synthetic */ void lambda$onStatusChanged$1(Executor r5, int r10) {
            if (this.mExecutor == r5) goto L5;
            return;
        L5:
            this.mCallback.onStatusChanged(r10);
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onGnssMeasurementsReceived(GnssMeasurementsEvent r5) {
            Executor r10 = this.mExecutor;
            if (r10 != null) goto L5;
            return;
        L5:
            r10.execute(new d(this, r10, r5, 0));
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onStatusChanged(int r5) {
            Executor r10 = this.mExecutor;
            if (r10 != null) goto L5;
            return;
        L5:
            r10.execute(new e(this, r10, r5, 0));
        }

        public void unregister() {
            this.mExecutor = null;
        }
    }

    @RequiresApi(30)
    public static class GnssStatusTransport extends GnssStatus.Callback {
        final GnssStatusCompat.Callback mCallback;

        public GnssStatusTransport(GnssStatusCompat.Callback r5) {
            if (r5 == null) goto L5;
            boolean r10 = true;
        L6:
            Preconditions.checkArgument(r10, "invalid null callback");
            this.mCallback = r5;
            return;
        L5:
            r10 = false;
            goto L6
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int r5) {
            this.mCallback.onFirstFix(r5);
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus r5) {
            this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(r5));
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

    public static class GpsStatusTransport implements GpsStatus.Listener {
        final GnssStatusCompat.Callback mCallback;

        @Nullable
        volatile Executor mExecutor;
        private final LocationManager mLocationManager;

        public GpsStatusTransport(LocationManager r5, GnssStatusCompat.Callback r10) {
            if (r10 == null) goto L5;
            boolean r11 = true;
        L6:
            Preconditions.checkArgument(r11, "invalid null callback");
            this.mLocationManager = r5;
            this.mCallback = r10;
            return;
        L5:
            r11 = false;
            goto L6
        }

        public static /* synthetic */ void a(GpsStatusTransport r5, Executor r10) {
            r5.lambda$onGpsStatusChanged$1(r10);
        }

        public static /* synthetic */ void b(GpsStatusTransport r5, Executor r10) {
            r5.lambda$onGpsStatusChanged$0(r10);
        }

        public static /* synthetic */ void c(GpsStatusTransport r5, Executor r10, int r11) {
            r5.lambda$onGpsStatusChanged$2(r10, r11);
        }

        public static /* synthetic */ void d(GpsStatusTransport r5, Executor r10, GnssStatusCompat r11) {
            r5.lambda$onGpsStatusChanged$3(r10, r11);
        }

        private /* synthetic */ void lambda$onGpsStatusChanged$0(Executor r5) {
            if (this.mExecutor == r5) goto L5;
            return;
        L5:
            this.mCallback.onStarted();
        }

        private /* synthetic */ void lambda$onGpsStatusChanged$1(Executor r5) {
            if (this.mExecutor == r5) goto L5;
            return;
        L5:
            this.mCallback.onStopped();
        }

        private /* synthetic */ void lambda$onGpsStatusChanged$2(Executor r5, int r10) {
            if (this.mExecutor == r5) goto L5;
            return;
        L5:
            this.mCallback.onFirstFix(r10);
        }

        private /* synthetic */ void lambda$onGpsStatusChanged$3(Executor r5, GnssStatusCompat r10) {
            if (this.mExecutor == r5) goto L5;
            return;
        L5:
            this.mCallback.onSatelliteStatusChanged(r10);
        }

        @Override // android.location.GpsStatus.Listener
        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        public void onGpsStatusChanged(int r5) {
            final Executor r10 = this.mExecutor;
            if (r10 != null) goto L6;
            return;
        L6:
            if (r5 != 1) goto L8;
            final int r11 = 0;
            r10.execute(new f(this, r10, r11));
            return;
        L8:
            if (r5 != 2) goto L10;
            final int r12 = 1;
            r10.execute(new f(this, r10, r12));
            return;
        L10:
            if (r5 != 3) goto L12;
            GpsStatus r13 = this.mLocationManager.getGpsStatus(null);
            if (r13 == null) goto L25;
            r10.execute(new e(this, r10, r13.getTimeToFirstFix(), 1));
            return;
        L25:
            return;
        L12:
            if (r5 != 4) goto L28;
            GpsStatus r14 = this.mLocationManager.getGpsStatus(null);
            if (r14 == null) goto L23;
            r10.execute(new d(this, r10, GnssStatusCompat.wrap(r14), 1));
            return;
        L23:
            return;
        }

        public void register(Executor r5) {
            if (this.mExecutor != null) goto L5;
            boolean r10 = true;
        L6:
            Preconditions.checkState(r10);
            this.mExecutor = r5;
            return;
        L5:
            r10 = false;
            goto L6
        }

        public void unregister() {
            this.mExecutor = null;
        }
    }

    public static final class InlineHandlerExecutor implements Executor {
        private final Handler mHandler;

        public InlineHandlerExecutor(@NonNull Handler r5) {
            this.mHandler = (Handler) Preconditions.checkNotNull(r5);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable r5) {
            if (Looper.myLooper() != this.mHandler.getLooper()) goto L6;
            r5.run();
            return;
        L6:
            if (this.mHandler.post((Runnable) Preconditions.checkNotNull(r5)) == false) goto L9;
            return;
        L9:
            throw new RejectedExecutionException(this.mHandler + " is shutting down");
        }
    }

    public static class LocationListenerKey {
        final LocationListenerCompat mListener;
        final String mProvider;

        public LocationListenerKey(String r5, LocationListenerCompat r10) {
            this.mProvider = (String) ObjectsCompat.requireNonNull(r5, "invalid null provider");
            this.mListener = (LocationListenerCompat) ObjectsCompat.requireNonNull(r10, "invalid null listener");
        }

        public boolean equals(Object r5) {
            if ((r5 instanceof LocationListenerKey) == true) goto L5;
            return false;
        L5:
            LocationListenerKey r10 = (LocationListenerKey) r5;
            if (this.mProvider.equals(r10.mProvider) == true) goto L8;
            return false;
        L8:
            if (this.mListener.equals(r10.mListener) == false) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{this.mProvider, this.mListener});
        }
    }

    public static class LocationListenerTransport implements LocationListener {
        final Executor mExecutor;

        @Nullable
        volatile LocationListenerKey mKey;

        public LocationListenerTransport(@Nullable LocationListenerKey r5, Executor r10) {
            this.mKey = r5;
            this.mExecutor = r10;
        }

        public static /* synthetic */ void a(LocationListenerTransport r5, String r10) {
            r5.lambda$onProviderEnabled$4(r10);
        }

        public static /* synthetic */ void b(LocationListenerTransport r5, String r10, int r11, Bundle r12) {
            r5.lambda$onStatusChanged$3(r10, r11, r12);
        }

        public static /* synthetic */ void c(LocationListenerTransport r5, Location r10) {
            r5.lambda$onLocationChanged$0(r10);
        }

        public static /* synthetic */ void d(LocationListenerTransport r5, List r10) {
            r5.lambda$onLocationChanged$1(r10);
        }

        public static /* synthetic */ void e(LocationListenerTransport r5, String r10) {
            r5.lambda$onProviderDisabled$5(r10);
        }

        public static /* synthetic */ void f(LocationListenerTransport r5, int r10) {
            r5.lambda$onFlushComplete$2(r10);
        }

        private /* synthetic */ void lambda$onFlushComplete$2(int r5) {
            LocationListenerKey r10 = this.mKey;
            if (r10 != null) goto L5;
            return;
        L5:
            r10.mListener.onFlushComplete(r5);
        }

        private /* synthetic */ void lambda$onLocationChanged$0(Location r5) {
            LocationListenerKey r10 = this.mKey;
            if (r10 != null) goto L5;
            return;
        L5:
            r10.mListener.onLocationChanged(r5);
        }

        private /* synthetic */ void lambda$onLocationChanged$1(List r5) {
            LocationListenerKey r10 = this.mKey;
            if (r10 != null) goto L5;
            return;
        L5:
            r10.mListener.onLocationChanged(r5);
        }

        private /* synthetic */ void lambda$onProviderDisabled$5(String r5) {
            LocationListenerKey r10 = this.mKey;
            if (r10 != null) goto L5;
            return;
        L5:
            r10.mListener.onProviderDisabled(r5);
        }

        private /* synthetic */ void lambda$onProviderEnabled$4(String r5) {
            LocationListenerKey r10 = this.mKey;
            if (r10 != null) goto L5;
            return;
        L5:
            r10.mListener.onProviderEnabled(r5);
        }

        private /* synthetic */ void lambda$onStatusChanged$3(String r5, int r10, Bundle r11) {
            LocationListenerKey r12 = this.mKey;
            if (r12 != null) goto L5;
            return;
        L5:
            r12.mListener.onStatusChanged(r5, r10, r11);
        }

        public LocationListenerKey getKey() {
            return (LocationListenerKey) ObjectsCompat.requireNonNull(this.mKey);
        }

        @Override // android.location.LocationListener
        public void onFlushComplete(final int r5) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new h(this, r5));
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(@NonNull Location r5) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new c(2, this, r5));
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(@NonNull String r5) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new g(this, r5, 1));
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(@NonNull String r5) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new g(this, r5, 0));
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(final String r5, final int r10, final Bundle r11) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new i(this, r5, r10, r11));
        }

        public void unregister() {
            this.mKey = null;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(@NonNull List<Location> r5) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new c(1, this, r5));
        }
    }

    @RequiresApi(24)
    public static class PreRGnssStatusTransport extends GnssStatus.Callback {
        final GnssStatusCompat.Callback mCallback;

        @Nullable
        volatile Executor mExecutor;

        public PreRGnssStatusTransport(GnssStatusCompat.Callback r5) {
            if (r5 == null) goto L5;
            boolean r10 = true;
        L6:
            Preconditions.checkArgument(r10, "invalid null callback");
            this.mCallback = r5;
            return;
        L5:
            r10 = false;
            goto L6
        }

        public static /* synthetic */ void a(PreRGnssStatusTransport r5, Executor r10) {
            r5.lambda$onStopped$1(r10);
        }

        public static /* synthetic */ void b(PreRGnssStatusTransport r5, Executor r10, int r11) {
            r5.lambda$onFirstFix$2(r10, r11);
        }

        public static /* synthetic */ void c(PreRGnssStatusTransport r5, Executor r10) {
            r5.lambda$onStarted$0(r10);
        }

        public static /* synthetic */ void d(PreRGnssStatusTransport r5, Executor r10, GnssStatus r11) {
            r5.lambda$onSatelliteStatusChanged$3(r10, r11);
        }

        private /* synthetic */ void lambda$onFirstFix$2(Executor r5, int r10) {
            if (this.mExecutor == r5) goto L5;
            return;
        L5:
            this.mCallback.onFirstFix(r10);
        }

        private /* synthetic */ void lambda$onSatelliteStatusChanged$3(Executor r5, GnssStatus r10) {
            if (this.mExecutor == r5) goto L5;
            return;
        L5:
            this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(r10));
        }

        private /* synthetic */ void lambda$onStarted$0(Executor r5) {
            if (this.mExecutor == r5) goto L5;
            return;
        L5:
            this.mCallback.onStarted();
        }

        private /* synthetic */ void lambda$onStopped$1(Executor r5) {
            if (this.mExecutor == r5) goto L5;
            return;
        L5:
            this.mCallback.onStopped();
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int r5) {
            Executor r10 = this.mExecutor;
            if (r10 != null) goto L5;
            return;
        L5:
            r10.execute(new e(this, r10, r5, 2));
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus r5) {
            Executor r10 = this.mExecutor;
            if (r10 != null) goto L5;
            return;
        L5:
            r10.execute(new d(this, r10, r5, 2));
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            Executor r5 = this.mExecutor;
            if (r5 != null) goto L5;
            return;
        L5:
            r5.execute(new j(this, r5, 1));
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            Executor r5 = this.mExecutor;
            if (r5 != null) goto L5;
            return;
        L5:
            r5.execute(new j(this, r5, 0));
        }

        public void register(Executor r5) {
            boolean r10 = false;
            if (r5 == null) goto L5;
            boolean r11 = true;
        L6:
            Preconditions.checkArgument(r11, "invalid null executor");
            if (this.mExecutor != null) goto L9;
            r10 = true;
        L9:
            Preconditions.checkState(r10);
            this.mExecutor = r5;
            return;
        L5:
            r11 = false;
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

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @Deprecated
    public static void getCurrentLocation(@NonNull LocationManager r5, @NonNull String r10, @Nullable androidx.core.os.CancellationSignal r11, @NonNull Executor r12, @NonNull Consumer<Location> r13) {
        if (r11 == null) goto L4;
        CancellationSignal r14 = (CancellationSignal) r11.getCancellationSignalObject();
    L5:
        getCurrentLocation(r5, r10, r14, r12, r13);
        return;
    L4:
        r14 = null;
        goto L5
    }

    @Nullable
    public static String getGnssHardwareModelName(@NonNull LocationManager r5) {
        return Api28Impl.getGnssHardwareModelName(r5);
    }

    public static int getGnssYearOfHardware(@NonNull LocationManager r5) {
        return Api28Impl.getGnssYearOfHardware(r5);
    }

    public static boolean hasProvider(@NonNull LocationManager r5, @NonNull String r10) {
        return Api31Impl.hasProvider(r5, r10);
    }

    public static boolean isLocationEnabled(@NonNull LocationManager r5) {
        return Api28Impl.isLocationEnabled(r5);
    }

    private static /* synthetic */ void lambda$getCurrentLocation$0(Consumer r5, Location r10) {
        r5.accept(r10);
    }

    private static /* synthetic */ Boolean lambda$registerGnssStatusCallback$1(LocationManager r5, GpsStatusTransport r10) throws Exception {
        return Boolean.valueOf(r5.addGpsStatusListener(r10));
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    @RequiresApi(24)
    public static boolean registerGnssMeasurementsCallback(@NonNull LocationManager r5, @NonNull GnssMeasurementsEvent.Callback r10, @NonNull Handler r11) {
        return Api24Impl.registerGnssMeasurementsCallback(r5, r10, r11);
    }

    @RequiresApi(30)
    private static boolean registerGnssMeasurementsCallbackOnR(@NonNull LocationManager r5, @NonNull Executor r10, @NonNull GnssMeasurementsEvent.Callback r11) {
        throw new IllegalStateException();
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager r5, @NonNull GnssStatusCompat.Callback r10, @NonNull Handler r11) {
        return registerGnssStatusCallback(r5, ExecutorCompat.create(r11), r10);
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @GuardedBy("sLocationListeners")
    public static void registerLocationListenerTransport(LocationManager r5, LocationListenerTransport r10) {
        WeakReference<LocationListenerTransport> r11 = sLocationListeners.put(r10.getKey(), new WeakReference(r10));
        if (r11 == null) goto L5;
        LocationListenerTransport r12 = r11.get();
    L6:
        if (r12 == null) goto L9;
        r12.unregister();
        r5.removeUpdates(r12);
        return;
    L9:
        return;
    L5:
        r12 = null;
        goto L6
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void removeUpdates(@NonNull LocationManager r10, @NonNull LocationListenerCompat r11) {
        WeakHashMap<LocationListenerKey, WeakReference<LocationListenerTransport>> r5 = sLocationListeners;
        monitor-enter(r5);
        Iterator<WeakReference<LocationListenerTransport>> r12 = r5.values().iterator();     // Catch: Throwable -> L14
        ArrayList r13 = null;
    L6:
        if (r12.hasNext() == false) goto L17;
        LocationListenerTransport r14 = r12.next().get();     // Catch: Throwable -> L14
        if (r14 == null) goto L6;
        LocationListenerKey r15 = r14.getKey();     // Catch: Throwable -> L14
        if (r15.mListener != r11) goto L6;
        if (r13 != null) goto L16;
        r13 = new ArrayList();     // Catch: Throwable -> L14
    L16:
        r13.add(r15);     // Catch: Throwable -> L14
        r14.unregister();     // Catch: Throwable -> L14
        r10.removeUpdates(r14);     // Catch: Throwable -> L14
        goto L6
    L17:
        if (r13 == null) goto L22;
        Iterator r16 = r13.iterator();     // Catch: Throwable -> L14
    L20:
        if (r16.hasNext() == false) goto L22;
        LocationListenerKey r17 = (LocationListenerKey) r16.next();     // Catch: Throwable -> L14
        sLocationListeners.remove(r17);     // Catch: Throwable -> L14
    L22:
        monitor-exit(r5);     // Catch: Throwable -> L14
        r10.removeUpdates(r11);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void requestLocationUpdates(@NonNull LocationManager r5, @NonNull String r10, @NonNull LocationRequestCompat r11, @NonNull Executor r12, @NonNull LocationListenerCompat r13) {
        Api31Impl.requestLocationUpdates(r5, r10, r11.toLocationRequest(), r12, r13);
    }

    @RequiresApi(24)
    public static void unregisterGnssMeasurementsCallback(@NonNull LocationManager r5, @NonNull GnssMeasurementsEvent.Callback r10) {
        Api24Impl.unregisterGnssMeasurementsCallback(r5, r10);
    }

    public static void unregisterGnssStatusCallback(@NonNull LocationManager r5, @NonNull GnssStatusCompat.Callback r10) {
        SimpleArrayMap<Object, Object> r11 = GnssListenersHolder.sGnssStatusListeners;
        monitor-enter(r11);
        Object r12 = r11.remove(r10);     // Catch: Throwable -> L7
        if (r12 == null) goto L9;
        Api24Impl.unregisterGnssStatusCallback(r5, r12);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    @RequiresApi(24)
    public static boolean registerGnssMeasurementsCallback(@NonNull LocationManager r5, @NonNull Executor r10, @NonNull GnssMeasurementsEvent.Callback r11) {
        return Api31Impl.registerGnssMeasurementsCallback(r5, r10, r11);
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager r5, @NonNull Executor r10, @NonNull GnssStatusCompat.Callback r11) {
        return registerGnssStatusCallback(r5, null, r10, r11);
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void getCurrentLocation(@NonNull LocationManager r5, @NonNull String r10, @Nullable CancellationSignal r11, @NonNull Executor r12, @NonNull Consumer<Location> r13) {
        Api30Impl.getCurrentLocation(r5, r10, r11, r12, r13);
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    private static boolean registerGnssStatusCallback(LocationManager r5, Handler r10, Executor r11, GnssStatusCompat.Callback r12) {
        return Api30Impl.registerGnssStatusCallback(r5, r10, r11, r12);
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void requestLocationUpdates(@NonNull LocationManager r5, @NonNull String r10, @NonNull LocationRequestCompat r11, @NonNull LocationListenerCompat r12, @NonNull Looper r13) {
        Api31Impl.requestLocationUpdates(r5, r10, r11.toLocationRequest(), ExecutorCompat.create(new Handler(r13)), r12);
    }
}
