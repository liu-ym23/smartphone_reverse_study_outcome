package com.obric.sva.sdk.lightup;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.memorydata.plugin_api.BuildConfig;
import com.obric.sva.sdk.bluetooth.BlueConnectState;
import com.obric.sva.sdk.bluetooth.BluetoothDeviceManager;
import com.obric.sva.sdk.utils.LogUtils;
import fna.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import kotlinx.coroutines.w1;
import ona.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0007J\b\u0010$\u001a\u00020 H\u0002J\u0006\u0010%\u001a\u00020\"J\u0006\u0010&\u001a\u00020\"J\b\u0010+\u001a\u00020\"H\u0002J\b\u0010,\u001a\u00020\"H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010-\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00060"}, d2 = {"Lcom/obric/sva/sdk/lightup/LightUpManager;", "", "<init>", "()V", "TAG", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "sensorContext", "Lkotlin/coroutines/CoroutineContext;", "sensorScope", "Lkotlinx/coroutines/CoroutineScope;", "sensorCovered", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/sva/sdk/lightup/SensorState;", "getSensorCovered", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "sensorManager", "Landroid/hardware/SensorManager;", "getSensorManager", "()Landroid/hardware/SensorManager;", "sensorManager$delegate", "Lkotlin/Lazy;", "proximitySensor", "Landroid/hardware/Sensor;", "getProximitySensor", "()Landroid/hardware/Sensor;", "registered", "", "init", "", "c", "isBluetoothConditionForLightUp", "trackBluetoothAndSensor", BuildConfig.BUILD_TYPE, "counter", "", "proximitySensorEventListener", "Landroid/hardware/SensorEventListener;", "unregister", "register", "lightUpSurpress", "getLightUpSurpress", "()Z", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class LightUpManager {
    public static final LightUpManager INSTANCE = null;
    public static final String TAG = "LightUpManager";
    public static Context context;
    private static int counter;
    private static final SensorEventListener proximitySensorEventListener = null;
    private static boolean registered;
    private static final CoroutineContext sensorContext = null;
    private static final z0<SensorState> sensorCovered = null;
    private static final Lazy sensorManager$delegate = null;
    private static final CoroutineScope sensorScope = null;

    private LightUpManager() {
    }

    public static /* synthetic */ SensorManager a() {
        return sensorManager_delegate$lambda$0();
    }

    public final void release() {
        LogUtils.d(TAG, BuildConfig.BUILD_TYPE, new Object[0]);
        unregister();
        counter = 0;
    }

    static {
        INSTANCE = new LightUpManager();
        ExecutorCoroutineDispatcher r0 = w1.a(1, "sensorContext");
        sensorContext = r0;
        sensorScope = CoroutineScopeKt.CoroutineScope(r0.plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        sensorCovered = j1.a(SensorState.NA);
        sensorManager$delegate = LazyKt.lazy(new a());
        proximitySensorEventListener = new LightUpManager$proximitySensorEventListener$1();
    }

    private final SensorManager getSensorManager() {
        return (SensorManager) sensorManager$delegate.getValue();
    }

    private final boolean isBluetoothConditionForLightUp() {
        BluetoothDeviceManager r0 = BluetoothDeviceManager.INSTANCE;
        boolean r3 = true;
        if (r0.isBluetoothOn() == true) goto L6;
    L8:
        LogUtils.d(TAG, "isBluetoothConditionForLightUp [false代表已连接蓝牙设备]..." + r3, new Object[0]);
        return r3;
    L6:
        if (r0.getBlueConnectState().getValue() != BlueConnectState.CONNECTED) goto L8;
        r3 = false;
        goto L8
    }

    private final void register() {
        LogUtils.d(TAG, "register and register flag is " + registered, new Object[0]);
        if (registered == true) goto L5;
        getSensorManager().registerListener(proximitySensorEventListener, getProximitySensor(), 3);
    L5:
        registered = true;
    }

    private static final SensorManager sensorManager_delegate$lambda$0() {
        Object r0 = INSTANCE.getContext().getSystemService("sensor");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.hardware.SensorManager");
        return (SensorManager) r0;
    }

    private final void unregister() {
        LogUtils.d(TAG, "unregister and register flag is " + registered, new Object[0]);
        if (registered == true) goto L10;
    L8:
        registered = false;
        return;
    L10:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L6
        INVOKEVIRTUAL_com_obric_sva_sdk_lightup_LightUpManager_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(INSTANCE.getSensorManager(), proximitySensorEventListener);     // Catch: Throwable -> L6
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public final Context getContext() {
        Context r0 = context;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    public final boolean getLightUpSurpress() {
        LogUtils.d(TAG, "lightUpSurpress , will surpress with checking state : " + sensorCovered.getValue(), new Object[0]);
        Ref.BooleanRef r0 = new Ref.BooleanRef();
        BuildersKt.runBlocking$default(null, new lightUpSurpress.1(r0, null), 1, null);
        return r0.element;
    }

    private final Sensor getProximitySensor() {
        return getSensorManager().getDefaultSensor(8);
    }

    public final void trackBluetoothAndSensor() {
        release();
        sensorCovered.setValue(SensorState.NA);
        LogUtils.d(TAG, "trackBluetoothAndSensor ..." + counter, new Object[0]);
        if (isBluetoothConditionForLightUp() == false) goto L5;
        BuildersKt.launch$default(sensorScope, null, null, new trackBluetoothAndSensor.1(null), 3, null);
        LogUtils.d(TAG, "trackBluetoothAndSensor A", new Object[0]);
        return;
    L5:
        register();
        LogUtils.d(TAG, "trackBluetoothAndSensor B", new Object[0]);
    }

    public static final /* synthetic */ int access$getCounter$p() {
        return counter;
    }

    public static final /* synthetic */ CoroutineScope access$getSensorScope$p() {
        return sensorScope;
    }

    public final z0<SensorState> getSensorCovered() {
        return sensorCovered;
    }

    public static final /* synthetic */ Sensor access$getProximitySensor(LightUpManager r0) {
        return r0.getProximitySensor();
    }

    public static final /* synthetic */ void access$setCounter$p(int r0) {
        counter = r0;
    }

    public final void init(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "c");
        LogUtils.d(TAG, "init ...", new Object[0]);
        setContext(r4);
    }

    public final void setContext(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        context = r2;
    }

    public static void INVOKEVIRTUAL_com_obric_sva_sdk_lightup_LightUpManager_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(SensorManager r1, SensorEventListener r2) {
        if (g.d() == true) goto L6;
        r1.unregisterListener(r2);
        return;
    L6:
        r1.unregisterListener(r2);
        if (r2 == null) goto L9;
        int r3 = r2.hashCode();
    L10:
        b.c(new ona.a(r3, null));
        return;
    L9:
        r3 = 0;
        goto L10
    }
}
