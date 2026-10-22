package com.obric.assistant.wakeup.bluetooth_headset.impl;

import android.app.Application;
import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.wakeup.bluetooth_headset.api.BlueDeviceConnectState;
import com.obric.assistant.wakeup.bluetooth_headset.api.BlueDeviceSwitchState;
import com.obric.assistant.wakeup.bluetooth_headset.api.BlueDeviceTypeEnum;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.w1;
import me.ele.lancet.base.annotations.Skip;
import tha.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ObricBluetoothDeviceManager implements zga.c {
    public static final ConcurrentHashMap<UUID, Function1<a, Unit>> A = null;
    public static final ObricBluetoothDeviceManager$intentReceiver$1 B = null;
    public static final ObricBluetoothDeviceManager a = null;
    public static final LruCache<String, String> b = null;
    public static boolean c;
    public static boolean d;
    public static boolean e;
    public static Context f;
    public static BluetoothDevice g;
    public static BluetoothDevice h;
    public static BluetoothA2dp i;
    public static BluetoothHeadset j;
    public static String k;
    public static final StateFlowImpl l = null;
    public static final StateFlowImpl m = null;
    public static final MutableSharedFlow<a> n = null;
    public static final CoroutineScope o = null;
    public static final CoroutineScope p = null;
    public static final CoroutineScope q = null;
    public static final CoroutineScope r = null;
    public static final CoroutineScope s = null;
    public static final CoroutineScope t = null;
    public static final Handler u = null;
    public static p0 v;
    public static final Lazy w = null;
    public static final AtomicBoolean x = null;
    public static final ConcurrentHashMap<UUID, Function1<BlueDeviceConnectState, Unit>> y = null;
    public static final ConcurrentHashMap<UUID, Function1<BlueDeviceSwitchState, Unit>> z = null;

    /* JADX INFO: renamed from: com.obric.assistant.wakeup.bluetooth_headset.impl.ObricBluetoothDeviceManager$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.wakeup.bluetooth_headset.impl.ObricBluetoothDeviceManager$1", f = "ObricBluetoothDeviceManager.kt", i = {}, l = {316}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.obric.assistant.wakeup.bluetooth_headset.impl.ObricBluetoothDeviceManager$1$a */
        public static final class a<T> implements FlowCollector {
            public static final a<T> a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final Object emit(Object r3, Continuation r4) {
                BlueDeviceConnectState r5 = (BlueDeviceConnectState) r3;
                FLogger.a.i("Obric-BluetoothDeviceManager", "blueConnectState collect " + r5);
                Iterator<Map.Entry<UUID, Function1<BlueDeviceConnectState, Unit>>> r6 = ObricBluetoothDeviceManager.y.entrySet().iterator();
            L4:
                if (r6.hasNext() == false) goto L7;
                r6.next().getValue().invoke(r5);
                goto L4
            L7:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r4);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            StateFlowImpl r5 = ObricBluetoothDeviceManager.l;
            FlowCollector r2 = a.a;
            this.label = 1;
            if (r5.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.wakeup.bluetooth_headset.impl.ObricBluetoothDeviceManager$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.wakeup.bluetooth_headset.impl.ObricBluetoothDeviceManager$2", f = "ObricBluetoothDeviceManager.kt", i = {}, l = {323}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.obric.assistant.wakeup.bluetooth_headset.impl.ObricBluetoothDeviceManager$2$a */
        public static final class a<T> implements FlowCollector {
            public static final a<T> a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final Object emit(Object r6, Continuation r7) {
                boolean r8 = ((Boolean) r6).booleanValue();
                FLogger r9 = FLogger.a;
                StringBuilder r0 = new StringBuilder("blueSwitchState collect value is ");
                r0.append(r8);
                r0.append(" , adapter enable ? ");
                ObricBluetoothDeviceManager r1 = ObricBluetoothDeviceManager.a;
                r0.append(ObricBluetoothDeviceManager.f().isEnabled());
                r9.i("Obric-BluetoothDeviceManager", r0.toString());
                if (r8 == false) goto L7;
                ObricBluetoothDeviceManager.e();
                ObricBluetoothDeviceManager.d();
                p0 r10 = ObricBluetoothDeviceManager.v;
                if (r10 == null) goto L10;
                r10.b();
            L10:
                Iterator<Map.Entry<UUID, Function1<BlueDeviceSwitchState, Unit>>> r11 = ObricBluetoothDeviceManager.z.entrySet().iterator();
            L12:
                if (r11.hasNext() == false) goto L19;
                Function1<BlueDeviceSwitchState, Unit> r2 = r11.next().getValue();
                if (r8 == false) goto L16;
                BlueDeviceSwitchState r3 = BlueDeviceSwitchState.ON;
            L17:
                r2.invoke(r3);
                goto L12
            L16:
                r3 = BlueDeviceSwitchState.OFF;
                goto L17
            L19:
                return Unit.INSTANCE;
            L7:
                r9.w("Obric-BluetoothDeviceManager", "unbindBluetoothHeadset bindState " + ObricBluetoothDeviceManager.d + ", profile " + ObricBluetoothDeviceManager.j);
                ObricBluetoothDeviceManager.f().closeProfileProxy(1, ObricBluetoothDeviceManager.j);
                ObricBluetoothDeviceManager.j = null;
                ObricBluetoothDeviceManager.d = false;
                r9.w("Obric-BluetoothDeviceManager", "unbindBluetoothA2dp bindState " + ObricBluetoothDeviceManager.e + " , profile " + ObricBluetoothDeviceManager.i);
                ObricBluetoothDeviceManager.f().closeProfileProxy(2, ObricBluetoothDeviceManager.i);
                ObricBluetoothDeviceManager.i = null;
                ObricBluetoothDeviceManager.e = false;
                p0 r12 = ObricBluetoothDeviceManager.v;
                if (r12 == null) goto L10;
                r12.c();
                goto L10
            }
        }

        public AnonymousClass2(Continuation<? super AnonymousClass2> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass2(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r4);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            StateFlowImpl r5 = ObricBluetoothDeviceManager.m;
            FlowCollector r2 = a.a;
            this.label = 1;
            if (r5.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.wakeup.bluetooth_headset.impl.ObricBluetoothDeviceManager$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.wakeup.bluetooth_headset.impl.ObricBluetoothDeviceManager$3", f = "ObricBluetoothDeviceManager.kt", i = {}, l = {339}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.obric.assistant.wakeup.bluetooth_headset.impl.ObricBluetoothDeviceManager$3$a */
        public static final class a<T> implements FlowCollector {
            public static final a<T> a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final Object emit(Object r3, Continuation r4) {
                tha.a r5 = (tha.a) r3;
                ObricBluetoothDeviceManager.x.compareAndSet(false, true);
                FLogger.a.i("Obric-BluetoothDeviceManager", "blueDeviceChangedEvent collect " + r5);
                Iterator<Map.Entry<UUID, Function1<tha.a, Unit>>> r6 = ObricBluetoothDeviceManager.A.entrySet().iterator();
            L4:
                if (r6.hasNext() == false) goto L7;
                r6.next().getValue().invoke(r5);
                goto L4
            L7:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass3(Continuation<? super AnonymousClass3> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass3(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r4);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ObricBluetoothDeviceManager r5 = ObricBluetoothDeviceManager.a;
            MutableSharedFlow<tha.a> r6 = ObricBluetoothDeviceManager.n;
            FlowCollector r2 = a.a;
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public ObricBluetoothDeviceManager() {
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.obric.assistant.wakeup.bluetooth_headset.impl.ObricBluetoothDeviceManager$intentReceiver$1] */
    static {
        a = new ObricBluetoothDeviceManager();
        b = new LruCache(50);
        k = "";
        l = j1.a(BlueDeviceConnectState.NA);
        m = j1.a(Boolean.FALSE);
        n = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        o = CoroutineScopeKt.CoroutineScope(w1.a(1, "stateChangedContext").plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        p = CoroutineScopeKt.CoroutineScope(w1.a(1, "switchChangedContext").plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        CoroutineScope r4 = CoroutineScopeKt.CoroutineScope(w1.a(1, "stateCollectContext").plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        q = r4;
        CoroutineScope r2 = CoroutineScopeKt.CoroutineScope(w1.a(1, "switchCollectContext").plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        r = r2;
        s = CoroutineScopeKt.CoroutineScope(w1.a(1, "deviceChangedContext").plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        CoroutineScope r3 = CoroutineScopeKt.CoroutineScope(w1.a(1, "deviceCollectContext").plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        t = r3;
        w = LazyKt.lazy(new e());
        x = new AtomicBoolean(false);
        y = new ConcurrentHashMap();
        z = new ConcurrentHashMap();
        A = new ConcurrentHashMap();
        B = new ObricBluetoothDeviceManager$intentReceiver$1();
        BuildersKt.launch$default(r4, null, null, new AnonymousClass1(null), 3, null);
        BuildersKt.launch$default(r2, null, null, new AnonymousClass2(null), 3, null);
        BuildersKt.launch$default(r3, null, null, new AnonymousClass3(null), 3, null);
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("bluetooth-device-handler");
        ThreadMethodProxy.start(r0);
        u = new Handler(r0.getLooper());
    }

    public static BluetoothAdapter f() {
        return (BluetoothAdapter) w.getValue();
    }

    public static BluetoothDevice g() {
        FLogger.a.i("Obric-BluetoothDeviceManager", "bluetoothDevice ===>: hfp " + g + " a2dp " + h + " lastActiveDeviceType : " + k);
        if (Intrinsics.areEqual(k, "hfp") == false) goto L5;
    L13:
        BluetoothDevice r0 = g;
        if (r0 == null) goto L16;
        return r0;
    L16:
        BluetoothDevice r1 = h;
        if (r1 == null) goto L21;
        return r1;
    L21:
        return null;
    L5:
        if (Intrinsics.areEqual(k, "") == true) goto L13;
        BluetoothDevice r2 = h;
        if (r2 == null) goto L10;
        return r2;
    L10:
        BluetoothDevice r3 = g;
        if (r3 == null) goto L19;
        return r3;
    L19:
        return null;
    }

    public static boolean h() {
        if (j != null) goto L5;
        return false;
    L5:
        AppHost.Companion r0 = AppHost.a;
        if (ContextCompat.checkSelfPermission(r0.getApplication(), "android.permission.BLUETOOTH_CONNECT") == 0) goto L25;
        return false;
    L25:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L10
        Object r1 = r0.getApplication().getSystemService("audio");     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.media.AudioManager");     // Catch: Throwable -> L10
        Object r3 = Result.constructor-impl(Boolean.valueOf(((AudioManager) r1).isBluetoothScoOn()));     // Catch: Throwable -> L10
    L13:
        if (Result.isSuccess-impl(r3) == false) goto L16;
        boolean r4 = ((Boolean) r3).booleanValue();
        FLogger.a.w("Obric-BluetoothDeviceManager", "isBtScoConnected success with value " + r4);
    L16:
        if (Result.exceptionOrNull-impl(r3) == null) goto L18;
        FLogger.a.w("Obric-BluetoothDeviceManager", "isBtScoConnected failed");
    L18:
        FLogger.a.w("Obric-BluetoothDeviceManager", "isBtScoConnected " + Result.toString-impl(r3));
        if (Result.isFailure-impl(r3) == false) goto L21;
        r3 = null;
    L21:
        Boolean r5 = (Boolean) r3;
        if (r5 != null) goto L24;
        return false;
    L24:
        return r5.booleanValue();
    L10:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public static boolean i() {
        Context r0 = f;
        if (r0 != null) goto L5;
        return false;
    L5:
        Intrinsics.checkNotNull(r0);
        int r1 = Settings.Global.getInt(r0.getContentResolver(), "cae_bdim_feature_enabled", 0);
        Context r2 = f;
        Intrinsics.checkNotNull(r2);
        if (ContextCompat.checkSelfPermission(r2, "com.obric.cae.permission.BT_CLIENT_ACCESS_PERMISSION") != 0) goto L8;
        boolean r3 = true;
    L9:
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("isSmartModelSupported checking switch ");
        if (r1 != 1) goto L12;
        boolean r6 = true;
    L13:
        r5.append(r6);
        r5.append(", originValue = ");
        r5.append(r1);
        r5.append(", checking permission ");
        r5.append(r3);
        r4.i("Obric-BluetoothDeviceManager", r5.toString());
        if (r1 != 1) goto L18;
        if (r3 == false) goto L19;
        return true;
    L19:
        return false;
    L18:
        return false;
    L12:
        r6 = false;
        goto L13
    L8:
        r3 = false;
        goto L9
    }

    public static void d() {
        boolean r0 = f().isEnabled();
        FLogger r1 = FLogger.a;
        r1.w("Obric-BluetoothDeviceManager", "bindBluetoothA2dp ... switch ? " + r0);
        if (r0 == true) goto L7;
        r1.w("Obric-BluetoothDeviceManager", "not bindBluetoothA2dp because the switch is off");
        return;
    L7:
        if (e == false) goto L10;
        r1.w("Obric-BluetoothDeviceManager", "not bindBluetoothA2dp because already binded");
        return;
    L10:
        e = f().getProfileProxy(AppHost.a.getApplication(), new a(), 2);
    }

    public static void e() {
        boolean r0 = f().isEnabled();
        FLogger r1 = FLogger.a;
        r1.w("Obric-BluetoothDeviceManager", "bindBluetoothHeadset ... switch ? " + r0);
        if (r0 == true) goto L7;
        r1.w("Obric-BluetoothDeviceManager", "not bindBluetoothHeadset because the switch is off");
        return;
    L7:
        if (d == false) goto L10;
        r1.w("Obric-BluetoothDeviceManager", "not bindBluetoothHeadset because already binded");
        return;
    L10:
        d = f().getProfileProxy(AppHost.a.getApplication(), new b(), 1);
    }

    public final Context getContext() {
        return f;
    }

    public static final void c(String r13) {
        if (Intrinsics.areEqual(r13, "hfp") == false) goto L5;
        BluetoothProfile r1 = j;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), "android.permission.BLUETOOTH_CONNECT") != 0) goto L91;
        Iterator<T> r2 = r1.getConnectedDevices().iterator();
    L12:
        if (r2.hasNext() == false) goto L92;
        BluetoothDevice r3 = (BluetoothDevice) r2.next();
        FLogger r4 = FLogger.a;
        r4.w("Obric-BluetoothDeviceManager", "start " + r13 + "... connected device is " + r3);
        AppHost.Companion r5 = AppHost.a;
        Application r7 = r5.getApplication();
        int r8 = tha.b.a;
        Intrinsics.checkNotNullParameter(r7, "context");
        boolean r9 = true;
        Object r10 = null;
        if (r3 != null) goto L17;
    L41:
        boolean r11 = false;
    L42:
        r4.i("Obric-BluetoothDeviceManager", "isWatch " + r11 + " from class " + r3);
        if ((!r11) == false) goto L12;
        boolean r12 = Intrinsics.areEqual(r13, "hfp");
        Intrinsics.checkNotNull(r3);
        r4.w("Obric-BluetoothDeviceManager", "isDeviceConnected hfp " + r12);
        if (r12 == false) goto L47;
        BluetoothProfile r6 = j;
    L48:
        if (r6 != null) goto L51;
    L74:
        r9 = false;
    L75:
        if (r9 == false) goto L12;
        FLogger.a.w("Obric-BluetoothDeviceManager", "found " + r13 + " connect device " + r3);
        if (Intrinsics.areEqual(r13, "hfp") == false) goto L79;
        g = r3;
        return;
    L79:
        h = r3;
        return;
    L51:
        if (ContextCompat.checkSelfPermission(r5.getApplication(), "android.permission.BLUETOOTH_CONNECT") != 0) goto L74;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L55
        Object r15 = Result.constructor-impl(Integer.valueOf(r6.getConnectionState(r3)));     // Catch: Throwable -> L55
    L58:
        if (Result.isSuccess-impl(r15) == false) goto L60;
        ((Number) r15).intValue();
    L60:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L63;
        FLogger.a.w("Obric-BluetoothDeviceManager", "isDeviceConnected failed " + r16.getMessage());
    L63:
        FLogger.a.w("Obric-BluetoothDeviceManager", "isDeviceConnected " + Result.toString-impl(r15) + " and device " + r3 + " , name is " + r3.getName());
        if (Result.isFailure-impl(r15) == true) goto L67;
        r10 = r15;
    L67:
        Integer r17 = (Integer) r10;
        if (r17 == null) goto L70;
        int r18 = r17.intValue();
    L72:
        if (r18 != 2) goto L74;
    L70:
        r18 = 0;
    L55:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L58
    L47:
        r6 = i;
        goto L48
    L17:
        if (ContextCompat.checkSelfPermission(r7, "android.permission.BLUETOOTH_CONNECT") != 0) goto L41;
        IBluetoothHeadSetAPI r20 = tha.c.a();
        if (r20 != null) goto L22;
    L24:
        boolean r21 = false;
    L25:
        if (r21 == false) goto L36;
        IBluetoothHeadSetAPI r22 = tha.c.a();
        if (r22 == null) goto L29;
        BlueDeviceTypeEnum r23 = r22.e(r3);
    L31:
        if (r23 != BlueDeviceTypeEnum.TYPE_WATCH) goto L33;
        boolean r24 = true;
    L34:
        if (r24 == false) goto L36;
    L40:
        r11 = true;
        goto L42
    L33:
        r24 = false;
        goto L34
    L29:
        r23 = null;
    L36:
        BluetoothClass r25 = r3.getBluetoothClass();
        if (r25 == null) goto L41;
        if (r25.getDeviceClass() != 1796) goto L41;
    L22:
        if (r20.l() != true) goto L24;
        r21 = true;
        goto L25
    L92:
        return;
    L91:
        return;
    L5:
        r1 = i;
        goto L6
    }

    @Override // zga.c
    public final void a(zga.b r4) {
        Intrinsics.checkNotNullParameter(r4, "projection");
        FLogger.a.w("Obric-BluetoothDeviceManager", "onProjectionChanged botID: " + r4.a + " and phase is " + r4.e);
        ObricBluetoothAudioManager r5 = ObricBluetoothAudioManager.a;
        ObricBluetoothAudioManager.h();
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent b(Context r8, ObricBluetoothDeviceManager$intentReceiver$1 r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L41;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L41:
    L35:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L39;
        throw e;
    L39:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L24;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L24;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8);     // Catch: Exception -> L35
        int r1 = r0.result;     // Catch: Exception -> L35
        if (r1 == 1) goto L22;
        if (r1 == 2) goto L20;
        if (r1 == 3) goto L18;
        return r8.registerReceiver(r9, r10);
    L18:
        return r0.intent;
    L20:
        return new Intent();
    L22:
        return r8.registerReceiver(r9, r10);
    L24:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L28;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L35
        return r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L34;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L34;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L35
        return ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L34:
        return r8.registerReceiver(r9, r10);
    }
}
