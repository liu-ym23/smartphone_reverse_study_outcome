package androidx.core.location;

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
import androidx.collection.SimpleArrayMap;
import androidx.core.os.CancellationSignal;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.Consumer;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
    static final WeakHashMap<LocationListenerKey, WeakReference<LocationListenerTransport>> sLocationListeners = null;
    private static Method sRegisterGnssMeasurementsCallbackMethod;

    static class Api19Impl {
        private static Class<?> sLocationRequestClass;
        private static Method sRequestLocationUpdatesLooperMethod;

        private Api19Impl() {
        }

        static boolean tryRequestLocationUpdates(LocationManager r8, String r9, LocationRequestCompat r10, LocationListenerCompat r11, Looper r12) {
            LocationListenerCompat r13 = (LocationListenerCompat) ZeusTransformUtils.wrapperContextForParams(r11, LocationListenerCompat.class, "com.obric.memorydata.plugin");
            if (Build.VERSION.SDK_INT >= 19) goto L16;
        L14:
            return false;
        L16:
            if (sLocationRequestClass != null) goto L8;
            sLocationRequestClass = ZeusTransformUtils.forName("android.location.LocationRequest", "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        L8:
            if (sRequestLocationUpdatesLooperMethod != null) goto L10;
            Method r0 = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{sLocationRequestClass, LocationListener.class, Looper.class});     // Catch: Throwable -> L15
            sRequestLocationUpdatesLooperMethod = r0;     // Catch: Throwable -> L15
            r0.setAccessible(true);     // Catch: Throwable -> L15
        L10:
            LocationRequest r14 = r10.toLocationRequest(r9);     // Catch: Throwable -> L15
            if (r14 == null) goto L14;
            sRequestLocationUpdatesLooperMethod.invoke(r8, new Object[]{r14, r13, r12});     // Catch: Throwable -> L15
            return true;
        }

        static boolean tryRequestLocationUpdates(LocationManager r8, String r9, LocationRequestCompat r10, LocationListenerTransport r11) {
            if (Build.VERSION.SDK_INT >= 19) goto L24;
        L20:
            return false;
        L24:
            if (sLocationRequestClass != null) goto L8;
            sLocationRequestClass = ZeusTransformUtils.forName("android.location.LocationRequest", "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        L8:
            if (sRequestLocationUpdatesLooperMethod != null) goto L10;
            Method r0 = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{sLocationRequestClass, LocationListener.class, Looper.class});     // Catch: Throwable -> L21
            sRequestLocationUpdatesLooperMethod = r0;     // Catch: Throwable -> L21
            r0.setAccessible(true);     // Catch: Throwable -> L21
        L10:
            LocationRequest r12 = r10.toLocationRequest(r9);     // Catch: Throwable -> L21
            if (r12 == null) goto L20;
            WeakHashMap<LocationListenerKey, WeakReference<LocationListenerTransport>> r13 = LocationManagerCompat.sLocationListeners;     // Catch: Throwable -> L21
            monitor-enter(r13);     // Catch: Throwable -> L21
            sRequestLocationUpdatesLooperMethod.invoke(r8, new Object[]{r12, r11, Looper.getMainLooper()});     // Catch: Throwable -> L17
            LocationManagerCompat.registerLocationListenerTransport(r8, r11);     // Catch: Throwable -> L17
            monitor-exit(r13);     // Catch: Throwable -> L17
            return true;
        L17:
            th = move-exception;
            throw th;     // Catch: Throwable -> L21 Throwable -> L21 Throwable -> L21 Throwable -> L21 Throwable -> L21
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static boolean registerGnssMeasurementsCallback(LocationManager r0, GnssMeasurementsEvent.Callback r1) {
            return r0.registerGnssMeasurementsCallback(r1);
        }

        static boolean registerGnssMeasurementsCallback(LocationManager r0, GnssMeasurementsEvent.Callback r1, Handler r2) {
            return r0.registerGnssMeasurementsCallback(r1, r2);
        }

        static boolean registerGnssStatusCallback(LocationManager r6, Handler r7, Executor r8, GnssStatusCompat.Callback r9) {
            Executor r10 = (Executor) ZeusTransformUtils.wrapperContextForParams(r8, Executor.class, "com.obric.memorydata.plugin");
            if (r7 == null) goto L5;
            boolean r2 = true;
        L6:
            Preconditions.checkArgument(r2);
            SimpleArrayMap<Object, Object> r3 = GnssListenersHolder.sGnssStatusListeners;
            monitor-enter(r3);
            PreRGnssStatusTransport r4 = (PreRGnssStatusTransport) ZeusTransformUtils.preCheckCast(GnssListenersHolder.sGnssStatusListeners.get(r9), PreRGnssStatusTransport.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
            if (r4 != null) goto L11;
            r4 = new PreRGnssStatusTransport(r9);     // Catch: Throwable -> L19
        L12:
            r4.register(r10);     // Catch: Throwable -> L19
            if (r6.registerGnssStatusCallback(r4, r7) == false) goto L17;
            GnssListenersHolder.sGnssStatusListeners.put(r9, r4);     // Catch: Throwable -> L19
            monitor-exit(r3);     // Catch: Throwable -> L19
            return true;
        L17:
            monitor-exit(r3);     // Catch: Throwable -> L19
            return false;
        L11:
            r4.unregister();     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            throw th;
        L5:
            r2 = false;
            goto L6
        }

        static void unregisterGnssMeasurementsCallback(LocationManager r0, GnssMeasurementsEvent.Callback r1) {
            r0.unregisterGnssMeasurementsCallback(r1);
        }

        static void unregisterGnssStatusCallback(LocationManager r2, Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, PreRGnssStatusTransport.class) == false) goto L5;
            ((PreRGnssStatusTransport) ZeusTransformUtils.preCheckCast(r3, PreRGnssStatusTransport.class, "com.obric.memorydata.plugin")).unregister();
        L5:
            r2.unregisterGnssStatusCallback((GnssStatus.Callback) ZeusTransformUtils.preCheckCast(r3, GnssStatus.Callback.class, "com.obric.memorydata.plugin"));
        }
    }

    private static class Api28Impl {
        private Api28Impl() {
        }

        static String getGnssHardwareModelName(LocationManager r0) {
            return r0.getGnssHardwareModelName();
        }

        static int getGnssYearOfHardware(LocationManager r0) {
            return r0.getGnssYearOfHardware();
        }

        static boolean isLocationEnabled(LocationManager r0) {
            return r0.isLocationEnabled();
        }
    }

    private static class Api30Impl {
        private static Class<?> sLocationRequestClass;
        private static Method sRequestLocationUpdatesExecutorMethod;

        private Api30Impl() {
        }

        static void getCurrentLocation(LocationManager r2, String r3, CancellationSignal r4, Executor r5, Consumer<Location> r6) {
            Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin");
            final Consumer r8 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r6, Consumer.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L5;
            android.os.CancellationSignal r9 = (android.os.CancellationSignal) ZeusTransformUtils.preCheckCast(r4.getCancellationSignalObject(), android.os.CancellationSignal.class, "com.obric.memorydata.plugin");
        L6:
            Objects.requireNonNull(r8);
            r2.getCurrentLocation(r3, r9, r7, new $$Lambda$NxsqWMFTsIpMtJBXS45Xotf3cmE(r8));
            return;
        L5:
            r9 = null;
            goto L6
        }

        public static boolean registerGnssStatusCallback(LocationManager r3, Handler r4, Executor r5, GnssStatusCompat.Callback r6) {
            Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin");
            SimpleArrayMap<Object, Object> r8 = GnssListenersHolder.sGnssStatusListeners;
            monitor-enter(r8);
            GnssStatusTransport r0 = (GnssStatusTransport) ZeusTransformUtils.preCheckCast(GnssListenersHolder.sGnssStatusListeners.get(r6), GnssStatusTransport.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
            if (r0 != null) goto L8;
            r0 = new GnssStatusTransport(r6);     // Catch: Throwable -> L15
        L8:
            if (r3.registerGnssStatusCallback(r7, r0) == false) goto L13;
            GnssListenersHolder.sGnssStatusListeners.put(r6, r0);     // Catch: Throwable -> L15
            monitor-exit(r8);     // Catch: Throwable -> L15
            return true;
        L13:
            monitor-exit(r8);     // Catch: Throwable -> L15
            return false;
        L15:
            th = move-exception;
            throw th;
        }

        public static boolean tryRequestLocationUpdates(LocationManager r8, String r9, LocationRequestCompat r10, Executor r11, LocationListenerCompat r12) {
            Executor r13 = (Executor) ZeusTransformUtils.wrapperContextForParams(r11, Executor.class, "com.obric.memorydata.plugin");
            LocationListenerCompat r14 = (LocationListenerCompat) ZeusTransformUtils.wrapperContextForParams(r12, LocationListenerCompat.class, "com.obric.memorydata.plugin");
            if (Build.VERSION.SDK_INT >= 30) goto L16;
        L14:
            return false;
        L16:
            if (sLocationRequestClass != null) goto L8;
            sLocationRequestClass = ZeusTransformUtils.forName("android.location.LocationRequest", "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        L8:
            if (sRequestLocationUpdatesExecutorMethod != null) goto L10;
            Method r0 = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{sLocationRequestClass, Executor.class, LocationListener.class});     // Catch: Throwable -> L15
            sRequestLocationUpdatesExecutorMethod = r0;     // Catch: Throwable -> L15
            r0.setAccessible(true);     // Catch: Throwable -> L15
        L10:
            LocationRequest r15 = r10.toLocationRequest(r9);     // Catch: Throwable -> L15
            if (r15 == null) goto L14;
            sRequestLocationUpdatesExecutorMethod.invoke(r8, new Object[]{r15, r13, r14});     // Catch: Throwable -> L15
            return true;
        }
    }

    private static class Api31Impl {
        private Api31Impl() {
        }

        static boolean hasProvider(LocationManager r0, String r1) {
            return r0.hasProvider(r1);
        }

        static boolean registerGnssMeasurementsCallback(LocationManager r2, Executor r3, GnssMeasurementsEvent.Callback r4) {
            return r2.registerGnssMeasurementsCallback((Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin"), r4);
        }

        static void requestLocationUpdates(LocationManager r2, String r3, LocationRequest r4, Executor r5, LocationListener r6) {
            r2.requestLocationUpdates(r3, r4, (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin"), (LocationListener) ZeusTransformUtils.wrapperContextForParams(r6, LocationListener.class, "com.obric.memorydata.plugin"));
        }
    }

    private static final class CancellableLocationListener implements LocationListener {
        private Consumer<Location> mConsumer;
        private final Executor mExecutor;
        private final LocationManager mLocationManager;
        private final Handler mTimeoutHandler;
        Runnable mTimeoutRunnable;
        private boolean mTriggered;

        CancellableLocationListener(LocationManager r3, Executor r4, Consumer<Location> r5) {
            Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
            Consumer<Location> r7 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r5, Consumer.class, "com.obric.memorydata.plugin");
            this.mLocationManager = r3;
            this.mExecutor = r6;
            this.mTimeoutHandler = new Handler(Looper.getMainLooper());
            this.mConsumer = r7;
        }

        private void cleanup() {
            this.mConsumer = null;
            this.mLocationManager.removeUpdates(this);
            Runnable r1 = this.mTimeoutRunnable;
            if (r1 == null) goto L6;
            this.mTimeoutHandler.removeCallbacks(r1);
            this.mTimeoutRunnable = null;
            return;
        }

        static /* synthetic */ void lambda$onLocationChanged$1(Consumer r2, Location r3) {
            ((Consumer) ZeusTransformUtils.wrapperContextForParams(r2, Consumer.class, "com.obric.memorydata.plugin")).accept(r3);
        }

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

        public /* synthetic */ void lambda$startTimeout$0$LocationManagerCompat$CancellableLocationListener() {
            this.mTimeoutRunnable = null;
            onLocationChanged((Location) ZeusTransformUtils.preCheckCast(null, Location.class, "com.obric.memorydata.plugin"));
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(final Location r4) {
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
            final Consumer<Location> r0 = this.mConsumer;
            this.mExecutor.execute(new $$Lambda$LocationManagerCompat$CancellableLocationListener$YCtILUhe93mA2Pmh3tYj1h0qzZs(r0, r4));
            cleanup();
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String r3) {
            onLocationChanged((Location) ZeusTransformUtils.preCheckCast(null, Location.class, "com.obric.memorydata.plugin"));
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String r1) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String r1, int r2, Bundle r3) {
        }

        public void startTimeout(long r3) {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (this.mTriggered == false) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L10
            return;
        L7:
            Runnable r0 = new $$Lambda$LocationManagerCompat$CancellableLocationListener$t_KfxTHtM_iJ8uJYVqEknYPfeGQ(this);     // Catch: Throwable -> L10
            this.mTimeoutRunnable = r0;     // Catch: Throwable -> L10
            this.mTimeoutHandler.postDelayed(r0, r3);     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
        }
    }

    private static class GnssListenersHolder {
        static final SimpleArrayMap<GnssMeasurementsEvent.Callback, GnssMeasurementsEvent.Callback> sGnssMeasurementListeners = null;
        static final SimpleArrayMap<Object, Object> sGnssStatusListeners = null;

        static {
            sGnssStatusListeners = new SimpleArrayMap();
            sGnssMeasurementListeners = new SimpleArrayMap();
        }

        private GnssListenersHolder() {
        }
    }

    private static class GnssMeasurementsTransport extends GnssMeasurementsEvent.Callback {
        final GnssMeasurementsEvent.Callback mCallback;
        volatile Executor mExecutor;

        GnssMeasurementsTransport(GnssMeasurementsEvent.Callback r3, Executor r4) {
            Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
            this.mCallback = r3;
            this.mExecutor = r5;
        }

        public /* synthetic */ void lambda$onGnssMeasurementsReceived$0$LocationManagerCompat$GnssMeasurementsTransport(Executor r3, GnssMeasurementsEvent r4) {
            Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
            if (this.mExecutor == r5) goto L5;
            return;
        L5:
            this.mCallback.onGnssMeasurementsReceived(r4);
        }

        public /* synthetic */ void lambda$onStatusChanged$1$LocationManagerCompat$GnssMeasurementsTransport(Executor r3, int r4) {
            Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
            if (this.mExecutor == r5) goto L5;
            return;
        L5:
            this.mCallback.onStatusChanged(r4);
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onGnssMeasurementsReceived(final GnssMeasurementsEvent r3) {
            final Executor r0 = this.mExecutor;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.execute(new $$Lambda$LocationManagerCompat$GnssMeasurementsTransport$iLdMFvSQqE3vx6WxeoBOCcjw4k(this, r0, r3));
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onStatusChanged(final int r3) {
            final Executor r0 = this.mExecutor;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.execute(new $$Lambda$LocationManagerCompat$GnssMeasurementsTransport$GFF3lbHvLRJjzms5Rdrtz0gScAc(this, r0, r3));
        }

        public void unregister() {
            this.mExecutor = null;
        }
    }

    private static class GnssStatusTransport extends GnssStatus.Callback {
        final GnssStatusCompat.Callback mCallback;

        GnssStatusTransport(GnssStatusCompat.Callback r3) {
            if (r3 == null) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0, "invalid null callback");
            this.mCallback = r3;
            return;
        L5:
            r0 = false;
            goto L6
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int r1) {
            this.mCallback.onFirstFix(r1);
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus r1) {
            this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(r1));
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
        volatile Executor mExecutor;
        private final LocationManager mLocationManager;

        GpsStatusTransport(LocationManager r3, GnssStatusCompat.Callback r4) {
            if (r4 == null) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0, "invalid null callback");
            this.mLocationManager = r3;
            this.mCallback = r4;
            return;
        L5:
            r0 = false;
            goto L6
        }

        public /* synthetic */ void lambda$onGpsStatusChanged$0$LocationManagerCompat$GpsStatusTransport(Executor r3) {
            Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
            if (this.mExecutor == r4) goto L5;
            return;
        L5:
            this.mCallback.onStarted();
        }

        public /* synthetic */ void lambda$onGpsStatusChanged$1$LocationManagerCompat$GpsStatusTransport(Executor r3) {
            Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
            if (this.mExecutor == r4) goto L5;
            return;
        L5:
            this.mCallback.onStopped();
        }

        public /* synthetic */ void lambda$onGpsStatusChanged$2$LocationManagerCompat$GpsStatusTransport(Executor r3, int r4) {
            Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
            if (this.mExecutor == r5) goto L5;
            return;
        L5:
            this.mCallback.onFirstFix(r4);
        }

        public /* synthetic */ void lambda$onGpsStatusChanged$3$LocationManagerCompat$GpsStatusTransport(Executor r3, GnssStatusCompat r4) {
            Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
            if (this.mExecutor == r5) goto L5;
            return;
        L5:
            this.mCallback.onSatelliteStatusChanged(r4);
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int r4) {
            final Executor r0 = this.mExecutor;
            if (r0 != null) goto L6;
            return;
        L6:
            if (r4 != 1) goto L8;
            Runnable r5 = new $$Lambda$LocationManagerCompat$GpsStatusTransport$YdTHlyzRR62cUonlTLG1CDPrghk(this, r0);
        L23:
            r0.execute(r5);
            return;
        L8:
            if (r4 != 2) goto L10;
            r5 = new $$Lambda$LocationManagerCompat$GpsStatusTransport$o4is_vEFQnCFL3phcwhrVAcNx6o(this, r0);
            goto L23
        L10:
            if (r4 != 3) goto L12;
            GpsStatus r6 = this.mLocationManager.getGpsStatus(null);
            if (r6 == null) goto L26;
            final int r7 = r6.getTimeToFirstFix();
            Runnable r1 = new $$Lambda$LocationManagerCompat$GpsStatusTransport$T0auuLwzEMM99veZUbxskDo10s(this, r0, r7);
        L20:
            r0.execute(r1);
            return;
        L26:
            return;
        L12:
            if (r4 != 4) goto L28;
            GpsStatus r8 = this.mLocationManager.getGpsStatus(null);
            if (r8 == null) goto L25;
            final GnssStatusCompat r9 = GnssStatusCompat.wrap(r8);
            r1 = new $$Lambda$LocationManagerCompat$GpsStatusTransport$V4NDbKd22V64RxjVMVd419nswo(this, r0, r9);
            goto L20
        L25:
            return;
        }

        public void register(Executor r3) {
            Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
            if (this.mExecutor != null) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkState(r0);
            this.mExecutor = r4;
            return;
        L5:
            r0 = false;
            goto L6
        }

        public void unregister() {
            this.mExecutor = null;
        }
    }

    private static final class InlineHandlerExecutor implements Executor {
        private final Handler mHandler;

        InlineHandlerExecutor(Handler r3) {
            this.mHandler = (Handler) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r3), Handler.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r4) {
            Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
            if (Looper.myLooper() != this.mHandler.getLooper()) goto L6;
            r5.run();
            return;
        L6:
            if (this.mHandler.post((Runnable) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r5), Runnable.class, "com.obric.memorydata.plugin")) == false) goto L9;
            return;
        L9:
            throw new RejectedExecutionException(this.mHandler + " is shutting down");
        }
    }

    private static class LocationListenerKey {
        final LocationListenerCompat mListener;
        final String mProvider;

        LocationListenerKey(String r3, LocationListenerCompat r4) {
            LocationListenerCompat r5 = (LocationListenerCompat) ZeusTransformUtils.wrapperContextForParams(r4, LocationListenerCompat.class, "com.obric.memorydata.plugin");
            this.mProvider = (String) ZeusTransformUtils.preCheckCast(ObjectsCompat.requireNonNull(r3, "invalid null provider"), String.class, "com.obric.memorydata.plugin");
            this.mListener = (LocationListenerCompat) ZeusTransformUtils.preCheckCast(ObjectsCompat.requireNonNull(r5, "invalid null listener"), LocationListenerCompat.class, "com.obric.memorydata.plugin");
        }

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, LocationListenerKey.class) == true) goto L5;
            return false;
        L5:
            LocationListenerKey r5 = (LocationListenerKey) ZeusTransformUtils.preCheckCast(r4, LocationListenerKey.class, "com.obric.memorydata.plugin");
            if (this.mProvider.equals(r5.mProvider) == true) goto L8;
            return false;
        L8:
            if (this.mListener.equals(r5.mListener) == false) goto L12;
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
        volatile LocationListenerKey mKey;

        LocationListenerTransport(LocationListenerKey r3, Executor r4) {
            Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
            this.mKey = r3;
            this.mExecutor = r5;
        }

        public LocationListenerKey getKey() {
            return (LocationListenerKey) ZeusTransformUtils.preCheckCast(ObjectsCompat.requireNonNull(this.mKey), LocationListenerKey.class, "com.obric.memorydata.plugin");
        }

        public /* synthetic */ void lambda$onFlushComplete$2$LocationManagerCompat$LocationListenerTransport(int r1) {
            LocationListenerKey r0 = this.mKey;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.mListener.onFlushComplete(r1);
        }

        public /* synthetic */ void lambda$onLocationChanged$0$LocationManagerCompat$LocationListenerTransport(Location r1) {
            LocationListenerKey r0 = this.mKey;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.mListener.onLocationChanged(r1);
        }

        public /* synthetic */ void lambda$onLocationChanged$1$LocationManagerCompat$LocationListenerTransport(List r3) {
            List<Location> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            LocationListenerKey r2 = this.mKey;
            if (r2 != null) goto L5;
            return;
        L5:
            r2.mListener.onLocationChanged(r4);
        }

        public /* synthetic */ void lambda$onProviderDisabled$5$LocationManagerCompat$LocationListenerTransport(String r1) {
            LocationListenerKey r0 = this.mKey;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.mListener.onProviderDisabled(r1);
        }

        public /* synthetic */ void lambda$onProviderEnabled$4$LocationManagerCompat$LocationListenerTransport(String r1) {
            LocationListenerKey r0 = this.mKey;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.mListener.onProviderEnabled(r1);
        }

        public /* synthetic */ void lambda$onStatusChanged$3$LocationManagerCompat$LocationListenerTransport(String r1, int r2, Bundle r3) {
            LocationListenerKey r0 = this.mKey;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.mListener.onStatusChanged(r1, r2, r3);
        }

        @Override // android.location.LocationListener
        public void onFlushComplete(final int r3) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new $$Lambda$LocationManagerCompat$LocationListenerTransport$e6SckAVOXLz5sqdYaQciymznw4(this, r3));
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(final Location r3) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new $$Lambda$LocationManagerCompat$LocationListenerTransport$nQA1ES9Z0HoQZ4k2kiq64G5J1Hw(this, r3));
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(List<Location> r3) {
            final List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new $$Lambda$LocationManagerCompat$LocationListenerTransport$MhoeUnGkDr3ot8_83pxTiAeIweg(this, r4));
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(final String r3) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new $$Lambda$LocationManagerCompat$LocationListenerTransport$lsVZkfjeu_iNJq_Fu3P9SKpwa6w(this, r3));
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(final String r3) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new $$Lambda$LocationManagerCompat$LocationListenerTransport$B1gsSTxy0V0GwE3O1urJcFM1Nw(this, r3));
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(final String r3, final int r4, final Bundle r5) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new $$Lambda$LocationManagerCompat$LocationListenerTransport$DPle4JPT7thJs_1Mhy2Ne8V4No(this, r3, r4, r5));
        }

        public void unregister() {
            this.mKey = null;
        }
    }

    private static class PreRGnssStatusTransport extends GnssStatus.Callback {
        final GnssStatusCompat.Callback mCallback;
        volatile Executor mExecutor;

        PreRGnssStatusTransport(GnssStatusCompat.Callback r3) {
            if (r3 == null) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0, "invalid null callback");
            this.mCallback = r3;
            return;
        L5:
            r0 = false;
            goto L6
        }

        public /* synthetic */ void lambda$onFirstFix$2$LocationManagerCompat$PreRGnssStatusTransport(Executor r3, int r4) {
            Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
            if (this.mExecutor == r5) goto L5;
            return;
        L5:
            this.mCallback.onFirstFix(r4);
        }

        public /* synthetic */ void lambda$onSatelliteStatusChanged$3$LocationManagerCompat$PreRGnssStatusTransport(Executor r3, GnssStatus r4) {
            Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
            if (this.mExecutor == r5) goto L5;
            return;
        L5:
            this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(r4));
        }

        public /* synthetic */ void lambda$onStarted$0$LocationManagerCompat$PreRGnssStatusTransport(Executor r3) {
            Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
            if (this.mExecutor == r4) goto L5;
            return;
        L5:
            this.mCallback.onStarted();
        }

        public /* synthetic */ void lambda$onStopped$1$LocationManagerCompat$PreRGnssStatusTransport(Executor r3) {
            Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
            if (this.mExecutor == r4) goto L5;
            return;
        L5:
            this.mCallback.onStopped();
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(final int r3) {
            final Executor r0 = this.mExecutor;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.execute(new $$Lambda$LocationManagerCompat$PreRGnssStatusTransport$UrmG531cBaBG_MqEWQ130Gx_xM(this, r0, r3));
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(final GnssStatus r3) {
            final Executor r0 = this.mExecutor;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.execute(new $$Lambda$LocationManagerCompat$PreRGnssStatusTransport$M98hBYbLkP_lHaBu4FbOg7TdZV0(this, r0, r3));
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            final Executor r0 = this.mExecutor;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.execute(new $$Lambda$LocationManagerCompat$PreRGnssStatusTransport$W1WiagGzlSlFoo8c3Qd6urjz2M(this, r0));
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            final Executor r0 = this.mExecutor;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.execute(new $$Lambda$LocationManagerCompat$PreRGnssStatusTransport$EV3ALfMBDotS9TFPL4C05K2QFGM(this, r0));
        }

        public void register(Executor r5) {
            Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin");
            boolean r0 = true;
            if (r6 == null) goto L5;
            boolean r2 = true;
        L6:
            Preconditions.checkArgument(r2, "invalid null executor");
            if (this.mExecutor == null) goto L10;
            r0 = false;
        L10:
            Preconditions.checkState(r0);
            this.mExecutor = r6;
            return;
        L5:
            r2 = false;
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

    public static void getCurrentLocation(LocationManager r8, String r9, CancellationSignal r10, Executor r11, Consumer<Location> r12) {
        Executor r13 = (Executor) ZeusTransformUtils.wrapperContextForParams(r11, Executor.class, "com.obric.memorydata.plugin");
        final Consumer r14 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r12, Consumer.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 30) goto L6;
        Api30Impl.getCurrentLocation(r8, r9, r10, r13, r14);
        return;
    L6:
        if (r10 == null) goto L8;
        r10.throwIfCanceled();
    L8:
        final Location r0 = r8.getLastKnownLocation(r9);
        if (r0 != null) goto L11;
    L14:
        final CancellableLocationListener r1 = new CancellableLocationListener(r8, r13, r14);
        r8.requestLocationUpdates(r9, 0, 0.0f, r1, Looper.getMainLooper());
        if (r10 == null) goto L17;
        Objects.requireNonNull(r1);
        r10.setOnCancelListener(new $$Lambda$QZtAxCs8LgaRwm7KsFxdCxwvQ40(r1));
    L17:
        r1.startTimeout(GET_CURRENT_LOCATION_TIMEOUT_MS);
        return;
    L11:
        if ((SystemClock.elapsedRealtime() - LocationCompat.getElapsedRealtimeMillis(r0)) >= 10000) goto L14;
        r13.execute(new $$Lambda$LocationManagerCompat$BuDFX8p4cZynZHSiCJ1nwl98OSc(r14, r0));
    }

    public static String getGnssHardwareModelName(LocationManager r2) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return null;
    L5:
        return Api28Impl.getGnssHardwareModelName(r2);
    }

    public static int getGnssYearOfHardware(LocationManager r2) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return 0;
    L5:
        return Api28Impl.getGnssYearOfHardware(r2);
    }

    public static boolean hasProvider(LocationManager r2, String r3) {
        if (Build.VERSION.SDK_INT < 31) goto L7;
        return Api31Impl.hasProvider(r2, r3);
    L7:
        if (r2.getAllProviders().contains(r3) == false) goto L16;
        return true;
    L16:
        if (r2.getProvider(r3) == null) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    public static boolean isLocationEnabled(LocationManager r6) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Api28Impl.isLocationEnabled(r6);
    L7:
        if (Build.VERSION.SDK_INT > 19) goto L23;
        if (sContextField != null) goto L11;
        Field r0 = LocationManager.class.getDeclaredField("mContext");     // Catch: Throwable -> L28
        sContextField = r0;     // Catch: Throwable -> L28
        r0.setAccessible(true);     // Catch: Throwable -> L28
    L11:
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(sContextField.get(r6), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        if (r1 == null) goto L23;
        if (Build.VERSION.SDK_INT != 19) goto L21;
        if (Settings.Secure.getInt(r1.getContentResolver(), LocationMonitorConst.LOCATION_MODE, 0) != 0) goto L18;
        return false;
    L18:
        return true;
    L21:
        return !TextUtils.isEmpty(Settings.Secure.getString(r1.getContentResolver(), "location_providers_allowed"));
    L23:
        if (r6.isProviderEnabled("network") == true) goto L27;
        if (r6.isProviderEnabled("gps") == true) goto L27;
        return false;
    L27:
        return true;
    }

    static /* synthetic */ void lambda$getCurrentLocation$0(Consumer r2, Location r3) {
        ((Consumer) ZeusTransformUtils.wrapperContextForParams(r2, Consumer.class, "com.obric.memorydata.plugin")).accept(r3);
    }

    static /* synthetic */ Boolean lambda$registerGnssStatusCallback$1(LocationManager r0, GpsStatusTransport r1) {
        return Boolean.valueOf(r0.addGpsStatusListener(r1));
    }

    public static boolean registerGnssMeasurementsCallback(LocationManager r2, GnssMeasurementsEvent.Callback r3, Handler r4) {
        if (Build.VERSION.SDK_INT <= 30) goto L7;
        return Api24Impl.registerGnssMeasurementsCallback(r2, r3, r4);
    L7:
        if (Build.VERSION.SDK_INT == 30) goto L9;
        SimpleArrayMap<GnssMeasurementsEvent.Callback, GnssMeasurementsEvent.Callback> r0 = GnssListenersHolder.sGnssMeasurementListeners;
        monitor-enter(r0);
        unregisterGnssMeasurementsCallback(r2, r3);     // Catch: Throwable -> L20
        if (Api24Impl.registerGnssMeasurementsCallback(r2, r3, r4) == false) goto L18;
        GnssListenersHolder.sGnssMeasurementListeners.put(r3, r3);     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return true;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return false;
    L20:
        th = move-exception;
        throw th;
    L9:
        return registerGnssMeasurementsCallbackOnR(r2, ExecutorCompat.create(r4), r3);
    }

    public static boolean registerGnssMeasurementsCallback(LocationManager r2, Executor r3, GnssMeasurementsEvent.Callback r4) {
        Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT <= 30) goto L7;
        return Api31Impl.registerGnssMeasurementsCallback(r2, r5, r4);
    L7:
        if (Build.VERSION.SDK_INT == 30) goto L9;
        SimpleArrayMap<GnssMeasurementsEvent.Callback, GnssMeasurementsEvent.Callback> r0 = GnssListenersHolder.sGnssMeasurementListeners;
        monitor-enter(r0);
        GnssMeasurementsTransport r1 = new GnssMeasurementsTransport(r4, r5);     // Catch: Throwable -> L20
        unregisterGnssMeasurementsCallback(r2, r4);     // Catch: Throwable -> L20
        if (Api24Impl.registerGnssMeasurementsCallback(r2, r1) == false) goto L18;
        GnssListenersHolder.sGnssMeasurementListeners.put(r4, r1);     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return true;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return false;
    L20:
        th = move-exception;
        throw th;
    L9:
        return registerGnssMeasurementsCallbackOnR(r2, r5, r4);
    }

    private static boolean registerGnssMeasurementsCallbackOnR(LocationManager r9, Executor r10, GnssMeasurementsEvent.Callback r11) {
        Executor r12 = (Executor) ZeusTransformUtils.wrapperContextForParams(r10, Executor.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT != 30) goto L21;
        if (sGnssRequestBuilderClass != null) goto L9;
        sGnssRequestBuilderClass = ZeusTransformUtils.forName("android.location.GnssRequest$Builder", "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
    L9:
        if (sGnssRequestBuilderBuildMethod != null) goto L12;
        Method r2 = sGnssRequestBuilderClass.getDeclaredMethod("build", new Class[0]);     // Catch: Throwable -> L22
        sGnssRequestBuilderBuildMethod = r2;     // Catch: Throwable -> L22
        r2.setAccessible(true);     // Catch: Throwable -> L22
    L12:
        if (sRegisterGnssMeasurementsCallbackMethod != null) goto L14;
        Method r3 = LocationManager.class.getDeclaredMethod("registerGnssMeasurementsCallback", new Class[]{ZeusTransformUtils.forName("android.location.GnssRequest", "com.obric.memorydata.plugin"), Executor.class, GnssMeasurementsEvent.Callback.class});     // Catch: Throwable -> L22
        sRegisterGnssMeasurementsCallbackMethod = r3;     // Catch: Throwable -> L22
        r3.setAccessible(true);     // Catch: Throwable -> L22
    L14:
        Object r13 = sRegisterGnssMeasurementsCallbackMethod.invoke(r9, new Object[]{sGnssRequestBuilderBuildMethod.invoke(sGnssRequestBuilderClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), new Object[0]), r12, r11});     // Catch: Throwable -> L22
        if (r13 == null) goto L25;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L19;
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

    private static boolean registerGnssStatusCallback(final LocationManager r9, Handler r10, Executor r11, GnssStatusCompat.Callback r12) {
        Executor r13 = (Executor) ZeusTransformUtils.wrapperContextForParams(r11, Executor.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return Api30Impl.registerGnssStatusCallback(r9, r10, r13, r12);
    L7:
        if (Build.VERSION.SDK_INT >= 24) goto L9;
        boolean r0 = true;
        if (r10 == null) goto L13;
        boolean r2 = true;
    L14:
        Preconditions.checkArgument(r2);
        SimpleArrayMap<Object, Object> r3 = GnssListenersHolder.sGnssStatusListeners;
        monitor-enter(r3);
        final GpsStatusTransport r4 = (GpsStatusTransport) ZeusTransformUtils.preCheckCast(GnssListenersHolder.sGnssStatusListeners.get(r12), GpsStatusTransport.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L74
        if (r4 != null) goto L19;
        r4 = new GpsStatusTransport(r9, r12);     // Catch: Throwable -> L74
    L20:
        r4.register(r13);     // Catch: Throwable -> L74
        FutureTask r14 = new FutureTask(new $$Lambda$LocationManagerCompat$JLIcm4BkQpukCiUbhX4BKZUICt4(r9, r4));     // Catch: Throwable -> L74
        if (Looper.myLooper() != r10.getLooper()) goto L24;
        r14.run();     // Catch: Throwable -> L74
    L77:
        long r5 = TimeUnit.SECONDS.toNanos(5);     // Catch: Throwable -> L50 TimeoutException -> L52 ExecutionException -> L56
        long r6 = System.nanoTime() + r5;
        boolean r15 = false;
    L80:
    L44:
        r5 = r6 - System.nanoTime();
        r15 = true;
        goto L80
    L42:
        e = e;
    L59:
        if (ZeusTransformUtils.instanceOf(e.getCause(), RuntimeException.class) == true) goto L67;
        if (ZeusTransformUtils.instanceOf(e.getCause(), Error.class) == false) goto L65;
        throw ((Error) ZeusTransformUtils.preCheckCast(e.getCause(), Error.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L68
    L65:
        throw new IllegalStateException(e);     // Catch: Throwable -> L68
    L67:
        throw ((RuntimeException) ZeusTransformUtils.preCheckCast(e.getCause(), RuntimeException.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L68
    L40:
        e = e;
    L55:
        throw new IllegalStateException(r10 + " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread", e);     // Catch: Throwable -> L68
    L38:
        th = th;
        r0 = r15;
    L69:
        if (r0 == false) goto L71;
        Thread.currentThread().interrupt();     // Catch: Throwable -> L74
    L71:
        throw th;     // Catch: Throwable -> L74
    L48:
        e = e;
    L46:
        e = e;
        goto L55
    L28:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r14.get(r5, TimeUnit.NANOSECONDS), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L34;
        GnssListenersHolder.sGnssStatusListeners.put(r12, r4);     // Catch: Throwable -> L38 TimeoutException -> L40 ExecutionException -> L42 InterruptedException -> L44
    L30:
        if (r15 == false) goto L32;
        Thread.currentThread().interrupt();     // Catch: Throwable -> L74
    L32:
        monitor-exit(r3);     // Catch: Throwable -> L74
        return true;
    L34:
        if (r15 == false) goto L36;
        Thread.currentThread().interrupt();     // Catch: Throwable -> L74
    L36:
        monitor-exit(r3);     // Catch: Throwable -> L74
        return false;
    L68:
        th = th;
    L56:
        e = e;
    L52:
        e = e;
    L50:
        th = th;
        r0 = false;
        goto L69
    L24:
        if (r10.post(r14) == true) goto L77;
        throw new IllegalStateException(r10 + " is shutting down");     // Catch: Throwable -> L74
    L19:
        r4.unregister();     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        throw th;
    L13:
        r2 = false;
        goto L14
    L9:
        return Api24Impl.registerGnssStatusCallback(r9, r10, r13, r12);
    }

    public static boolean registerGnssStatusCallback(LocationManager r2, GnssStatusCompat.Callback r3, Handler r4) {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return registerGnssStatusCallback(r2, ExecutorCompat.create(r4), r3);
    L7:
        return registerGnssStatusCallback(r2, new InlineHandlerExecutor(r4), r3);
    }

    public static boolean registerGnssStatusCallback(LocationManager r2, Executor r3, GnssStatusCompat.Callback r4) {
        Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        Looper r0 = Looper.myLooper();
        if (r0 != null) goto L10;
        r0 = Looper.getMainLooper();
    L10:
        return registerGnssStatusCallback(r2, new Handler(r0), r5, r4);
    L5:
        return registerGnssStatusCallback(r2, null, r5, r4);
    }

    static void registerLocationListenerTransport(LocationManager r3, LocationListenerTransport r4) {
        WeakReference r5 = (WeakReference) ZeusTransformUtils.preCheckCast(sLocationListeners.put(r4.getKey(), new WeakReference(r4)), WeakReference.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L5;
        LocationListenerTransport r6 = (LocationListenerTransport) ZeusTransformUtils.preCheckCast(r5.get(), LocationListenerTransport.class, "com.obric.memorydata.plugin");
    L6:
        if (r6 == null) goto L9;
        r6.unregister();
        r3.removeUpdates(r6);
        return;
    L9:
        return;
    L5:
        r6 = null;
        goto L6
    }

    public static void removeUpdates(LocationManager r6, LocationListenerCompat r7) {
        LocationListener r8 = (LocationListenerCompat) ZeusTransformUtils.wrapperContextForParams(r7, LocationListenerCompat.class, "com.obric.memorydata.plugin");
        WeakHashMap<LocationListenerKey, WeakReference<LocationListenerTransport>> r0 = sLocationListeners;
        monitor-enter(r0);
        ArrayList r1 = null;
        Iterator<WeakReference<LocationListenerTransport>> r2 = r0.values().iterator();     // Catch: Throwable -> L24
    L7:
        if (r2.hasNext() == false) goto L16;
        LocationListenerTransport r3 = (LocationListenerTransport) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(r2.next(), WeakReference.class, "com.obric.memorydata.plugin")).get(), LocationListenerTransport.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (r3 == null) goto L7;
        LocationListenerKey r4 = r3.getKey();     // Catch: Throwable -> L24
        if (r4.mListener != r8) goto L7;
        if (r1 != null) goto L15;
        r1 = new ArrayList();     // Catch: Throwable -> L24
    L15:
        r1.add(r4);     // Catch: Throwable -> L24
        r3.unregister();     // Catch: Throwable -> L24
        r6.removeUpdates(r3);     // Catch: Throwable -> L24
        goto L7
    L16:
        if (r1 == null) goto L21;
        Iterator r5 = r1.iterator();     // Catch: Throwable -> L24
    L19:
        if (r5.hasNext() == false) goto L21;
        LocationListenerKey r9 = (LocationListenerKey) ZeusTransformUtils.preCheckCast(r5.next(), LocationListenerKey.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        sLocationListeners.remove(r9);     // Catch: Throwable -> L24
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L24
        r6.removeUpdates(r8);
        return;
    L24:
        th = move-exception;
        throw th;
    }

    public static void requestLocationUpdates(LocationManager r7, String r8, LocationRequestCompat r9, LocationListenerCompat r10, Looper r11) {
        LocationListenerCompat r5 = (LocationListenerCompat) ZeusTransformUtils.wrapperContextForParams(r10, LocationListenerCompat.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 31) goto L7;
        Api31Impl.requestLocationUpdates(r7, r8, r9.toLocationRequest(), ExecutorCompat.create(new Handler(r11)), r5);
        return;
    L7:
        if (Build.VERSION.SDK_INT >= 19) goto L9;
    L11:
        r7.requestLocationUpdates(r8, r9.getIntervalMillis(), r9.getMinUpdateDistanceMeters(), r5, r11);
        return;
    L9:
        if (Api19Impl.tryRequestLocationUpdates(r7, r8, r9, r5, r11) == false) goto L11;
    }

    public static void requestLocationUpdates(LocationManager r8, String r9, LocationRequestCompat r10, Executor r11, LocationListenerCompat r12) {
        Executor r13 = (Executor) ZeusTransformUtils.wrapperContextForParams(r11, Executor.class, "com.obric.memorydata.plugin");
        LocationListenerCompat r14 = (LocationListenerCompat) ZeusTransformUtils.wrapperContextForParams(r12, LocationListenerCompat.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 31) goto L7;
        Api31Impl.requestLocationUpdates(r8, r9, r10.toLocationRequest(), r13, r14);
        return;
    L7:
        if (Build.VERSION.SDK_INT >= 30) goto L9;
    L11:
        LocationListenerTransport r0 = new LocationListenerTransport(new LocationListenerKey(r9, r14), r13);
        if (Build.VERSION.SDK_INT >= 19) goto L14;
    L16:
        WeakHashMap<LocationListenerKey, WeakReference<LocationListenerTransport>> r15 = sLocationListeners;
        monitor-enter(r15);
        r8.requestLocationUpdates(r9, r10.getIntervalMillis(), r10.getMinUpdateDistanceMeters(), r0, Looper.getMainLooper());     // Catch: Throwable -> L21
        registerLocationListenerTransport(r8, r0);     // Catch: Throwable -> L21
        monitor-exit(r15);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    L14:
        if (Api19Impl.tryRequestLocationUpdates(r8, r9, r10, r0) == false) goto L16;
        return;
    L9:
        if (Api30Impl.tryRequestLocationUpdates(r8, r9, r10, r13, r14) == false) goto L11;
    }

    public static void unregisterGnssMeasurementsCallback(LocationManager r3, GnssMeasurementsEvent.Callback r4) {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        Api24Impl.unregisterGnssMeasurementsCallback(r3, r4);
        return;
    L5:
        SimpleArrayMap<GnssMeasurementsEvent.Callback, GnssMeasurementsEvent.Callback> r0 = GnssListenersHolder.sGnssMeasurementListeners;
        monitor-enter(r0);
        GnssMeasurementsEvent.Callback r5 = (GnssMeasurementsEvent.Callback) ZeusTransformUtils.preCheckCast(GnssListenersHolder.sGnssMeasurementListeners.remove(r4), GnssMeasurementsEvent.Callback.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r5 != null) goto L10;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r5, GnssMeasurementsTransport.class) == false) goto L12;
        ((GnssMeasurementsTransport) ZeusTransformUtils.preCheckCast(r5, GnssMeasurementsTransport.class, "com.obric.memorydata.plugin")).unregister();     // Catch: Throwable -> L15
    L12:
        Api24Impl.unregisterGnssMeasurementsCallback(r3, r5);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public static void unregisterGnssStatusCallback(LocationManager r3, GnssStatusCompat.Callback r4) {
        if (Build.VERSION.SDK_INT < 24) goto L14;
        SimpleArrayMap<Object, Object> r0 = GnssListenersHolder.sGnssStatusListeners;
        monitor-enter(r0);
        Object r5 = GnssListenersHolder.sGnssStatusListeners.remove(r4);     // Catch: Throwable -> L11
        if (r5 == null) goto L9;
        Api24Impl.unregisterGnssStatusCallback(r3, r5);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        SimpleArrayMap<Object, Object> r1 = GnssListenersHolder.sGnssStatusListeners;
        monitor-enter(r1);
        GpsStatusTransport r6 = (GpsStatusTransport) ZeusTransformUtils.preCheckCast(GnssListenersHolder.sGnssStatusListeners.remove(r4), GpsStatusTransport.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r6 == null) goto L19;
        r6.unregister();     // Catch: Throwable -> L21
        r3.removeGpsStatusListener(r6);     // Catch: Throwable -> L21
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    }
}
