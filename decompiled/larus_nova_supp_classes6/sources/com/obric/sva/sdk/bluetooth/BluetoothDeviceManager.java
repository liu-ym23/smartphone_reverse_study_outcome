package com.obric.sva.sdk.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.memorydata.plugin_api.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import kotlinx.coroutines.w1;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010,\u001a\u00020-2\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010.\u001a\u00020-J\u0006\u0010/\u001a\u00020-J\u0006\u00100\u001a\u00020-R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u0011\u0010(\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/obric/sva/sdk/bluetooth/BluetoothDeviceManager;", "", "<init>", "()V", "TAG", "", "isReceiverRegistered", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "bluetoothDevice", "Landroid/bluetooth/BluetoothDevice;", "getBluetoothDevice", "()Landroid/bluetooth/BluetoothDevice;", "setBluetoothDevice", "(Landroid/bluetooth/BluetoothDevice;)V", "bluetoothDeviceName", "getBluetoothDeviceName", "()Ljava/lang/String;", "setBluetoothDeviceName", "(Ljava/lang/String;)V", "blueConnectState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/sva/sdk/bluetooth/BlueConnectState;", "getBlueConnectState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "stateChangedContext", "Lkotlin/coroutines/CoroutineContext;", "stateChangedScope", "Lkotlinx/coroutines/CoroutineScope;", "adapter", "Landroid/bluetooth/BluetoothAdapter;", "getAdapter", "()Landroid/bluetooth/BluetoothAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "isBluetoothOn", "()Z", "intentReceiver", "Landroid/content/BroadcastReceiver;", "init", "", BuildConfig.BUILD_TYPE, "start", "stop", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class BluetoothDeviceManager {
    public static final BluetoothDeviceManager INSTANCE = null;
    public static final String TAG = "BluetoothDeviceManager";
    private static final Lazy adapter$delegate = null;
    private static final z0<BlueConnectState> blueConnectState = null;
    private static BluetoothDevice bluetoothDevice;
    private static String bluetoothDeviceName;
    private static Context context;
    private static BroadcastReceiver intentReceiver;
    private static boolean isReceiverRegistered;
    private static final CoroutineContext stateChangedContext = null;
    private static final CoroutineScope stateChangedScope = null;

    /* JADX INFO: renamed from: com.obric.sva.sdk.bluetooth.BluetoothDeviceManager$init$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    @DebugMetadata(c = "com.obric.sva.sdk.bluetooth.BluetoothDeviceManager$init$2", f = "BluetoothDeviceManager.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

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
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            z0<BlueConnectState> r5 = BluetoothDeviceManager.INSTANCE.getBlueConnectState();
            BlueConnectState r2 = BlueConnectState.DISCONNECTED;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    private BluetoothDeviceManager() {
    }

    public static /* synthetic */ BluetoothAdapter a() {
        return adapter_delegate$lambda$0();
    }

    public final void release() {
        context = null;
    }

    static {
        INSTANCE = new BluetoothDeviceManager();
        bluetoothDeviceName = "";
        blueConnectState = j1.a(BlueConnectState.NA);
        ExecutorCoroutineDispatcher r0 = w1.a(1, "stateChangedContext");
        stateChangedContext = r0;
        stateChangedScope = CoroutineScopeKt.CoroutineScope(r0.plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        adapter$delegate = LazyKt.lazy(new a());
        intentReceiver = new BluetoothDeviceManager$intentReceiver$1();
    }

    private final BluetoothAdapter getAdapter() {
        return (BluetoothAdapter) adapter$delegate.getValue();
    }

    public final void start() {
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        r0.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        if (isReceiverRegistered == true) goto L16;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        Context r2 = context;     // Catch: Throwable -> L10
        if (r2 == null) goto L7;
        Intent r3 = INVOKEVIRTUAL_com_obric_sva_sdk_bluetooth_BluetoothDeviceManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r2, intentReceiver, r0);     // Catch: Throwable -> L10
    L8:
        Result.constructor-impl(r3);     // Catch: Throwable -> L10
    L12:
        isReceiverRegistered = true;
        return;
    L7:
        r3 = null;
    L10:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public final void stop() {
        if (isReceiverRegistered == true) goto L14;
    L12:
        isReceiverRegistered = false;
        return;
    L14:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        Context r1 = context;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        INVOKEVIRTUAL_com_obric_sva_sdk_bluetooth_BluetoothDeviceManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(r1, intentReceiver);     // Catch: Throwable -> L10
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L10
    L8:
        Result.constructor-impl(r2);     // Catch: Throwable -> L10
        goto L12
    L7:
        r2 = null;
    L10:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    private static final BluetoothAdapter adapter_delegate$lambda$0() {
        return BluetoothAdapter.getDefaultAdapter();
    }

    public final boolean isBluetoothOn() {
        return getAdapter().isEnabled();
    }

    public static final /* synthetic */ CoroutineScope access$getStateChangedScope$p() {
        return stateChangedScope;
    }

    public final z0<BlueConnectState> getBlueConnectState() {
        return blueConnectState;
    }

    public final BluetoothDevice getBluetoothDevice() {
        return bluetoothDevice;
    }

    public final String getBluetoothDeviceName() {
        return bluetoothDeviceName;
    }

    public final Context getContext() {
        return context;
    }

    public final void init(Context r15) {
        Intrinsics.checkNotNullParameter(r15, "context");
        context = r15;
        if (ContextCompat.checkSelfPermission(r15, "android.permission.BLUETOOTH_CONNECT") == 0) goto L5;
        return;
    L5:
        int r16 = getAdapter().getProfileConnectionState(1);
        if (r16 != 0) goto L8;
        BuildersKt.launch$default(stateChangedScope, null, null, new AnonymousClass2(null), 3, null);
        return;
    L8:
        if (r16 != 2) goto L14;
        BuildersKt.launch$default(stateChangedScope, null, null, new init.1(null), 3, null);
        return;
    }

    public final void setBluetoothDevice(BluetoothDevice r1) {
        bluetoothDevice = r1;
    }

    public final void setBluetoothDeviceName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        bluetoothDeviceName = r2;
    }

    public final void setContext(Context r1) {
        context = r1;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_obric_sva_sdk_bluetooth_BluetoothDeviceManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r1, BroadcastReceiver r2) {
        ReceiverRegisterLancet.loge(r2, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r1.unregisterReceiver(r2);
        return;
    L14:
    L8:
        e = move-exception;
        if (r2 == null) goto L11;
        Npth.addTag("unregisterReceiver", r2.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r2, r1) == false) goto L16;
        r1.unregisterReceiver(r2);     // Catch: Exception -> L8
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_obric_sva_sdk_bluetooth_BluetoothDeviceManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r8, BroadcastReceiver r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r10 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8);     // Catch: Exception -> L36
        int r1 = r0.result;     // Catch: Exception -> L36
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        return r8.registerReceiver(r9, r10);
    L19:
        return r0.intent;
    L21:
        return new Intent();
    L23:
        return r8.registerReceiver(r9, r10);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r8.registerReceiver(r9, r10);
    }
}
