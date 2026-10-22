package com.obric.assistant.dora;

import android.app.Application;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Process;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.main.IPrivacyService;
import com.larus.utils.logger.FLogger;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t39.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n*\u0003\u0012\u0015\u0018\u0018\u0000 72\u00020\u0001:\u000278B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010 \u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010!\u001a\u00020\u001bH\u0016J\b\u0010\"\u001a\u00020\u001bH\u0002J\b\u0010#\u001a\u00020\u001bH\u0002J\b\u0010$\u001a\u00020\fH\u0002J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\fH\u0002J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0(H\u0002J\u0014\u0010)\u001a\u00020\u000f*\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020\u001bH\u0002J\u0010\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\rH\u0002J\b\u00103\u001a\u00020\u001bH\u0002J\u0010\u00104\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\rH\u0002J\u0010\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019¨\u00069"}, d2 = {"Lcom/obric/assistant/dora/DoraBleProtocolService;", "Landroid/app/Service;", "<init>", "()V", "binder", "Lcom/obric/assistant/dora/DoraBleProtocolService$DoraBleProtocolBinder;", "mainHandler", "Landroid/os/Handler;", "boundConnectedDeviceExecutor", "Ljava/util/concurrent/ExecutorService;", "pendingAutoBindRequests", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/assistant/dora/PendingAutoBindRequest;", "hasBoundConnectedDeviceDemand", "", "isServiceDestroyed", "bluetoothStateReceiver", "com/obric/assistant/dora/DoraBleProtocolService$bluetoothStateReceiver$1", "Lcom/obric/assistant/dora/DoraBleProtocolService$bluetoothStateReceiver$1;", "bridgeConnectCallback", "com/obric/assistant/dora/DoraBleProtocolService$bridgeConnectCallback$1", "Lcom/obric/assistant/dora/DoraBleProtocolService$bridgeConnectCallback$1;", "bridgeLifecycleListener", "com/obric/assistant/dora/DoraBleProtocolService$bridgeLifecycleListener$1", "Lcom/obric/assistant/dora/DoraBleProtocolService$bridgeLifecycleListener$1;", "onCreate", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onUnbind", "onDestroy", "registerBluetoothStateReceiver", "unregisterBluetoothStateReceiver", "getBluetoothBroadcastPermission", "checkBoundConnectedDevicesAndUpdateBridgeDemand", "reason", "getConnectedBluetoothMacSet", "", "isConnectedByMethod", "Landroid/bluetooth/BluetoothDevice;", "method", "Ljava/lang/reflect/Method;", "enqueueAutoBindRequest", "device", "Lcom/obric/assistant/dora/DoraBleDevice;", "updateAutoBindBridgeDemand", "dispatchAutoBindRequest", "request", "flushPendingAutoBindRequests", "openOnboarding", "openOnboardingAndRemoveRequest", "requestId", "Companion", "DoraBleProtocolBinder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class DoraBleProtocolService extends Service {
    public static final /* synthetic */ int j = 0;
    public final DoraBleProtocolBinder a;
    public final Handler b;
    public final ExecutorService c;
    public final ConcurrentHashMap<String, i> d;
    public volatile boolean e;
    public volatile boolean f;
    public final DoraBleProtocolService$bluetoothStateReceiver$1 g;
    public final DoraBleProtocolService$bridgeConnectCallback$1 h;
    public final b i;

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0002J*\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016H\u0016R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00030\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/dora/DoraBleProtocolService$DoraBleProtocolBinder;", "Lcom/obric/assistant/dora/IDoraBleProtocolService$Stub;", "service", "Lcom/obric/assistant/dora/DoraBleProtocolService;", "<init>", "(Lcom/obric/assistant/dora/DoraBleProtocolService;)V", "serviceRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "requireService", "onTransact", "", "code", "", "data", "Landroid/os/Parcel;", "reply", "flags", "getScanFilters", "", "Landroid/bluetooth/le/ScanFilter;", "parseScanResult", "Lcom/obric/assistant/dora/DoraBleDevice;", "scanResult", "Landroid/bluetooth/le/ScanResult;", "startAutoBindFlow", "", "device", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class DoraBleProtocolBinder extends IDoraBleProtocolService.Stub {
        private final WeakReference<DoraBleProtocolService> serviceRef;

        private final DoraBleProtocolService requireService() {
            DoraBleProtocolService r0 = this.serviceRef.get();
            if (r0 != null) goto L5;
            FLogger.a.w("DoraBleProtocolService", "binder call ignored: service already released");
        L5:
            return r0;
        }

        @Override // com.obric.assistant.dora.IDoraBleProtocolService
        public List<ScanFilter> getScanFilters() {
            if (requireService() == null) goto L5;
            FLogger.a.i("DoraBleProtocolService", "getScanFilters called");
            ArrayList r0 = new ArrayList();
            ScanFilter r1 = new ScanFilter.Builder().setServiceData(new ParcelUuid(UUID.fromString("0000FDEE-0000-1000-8000-00805F9B34FB")), new byte[]{0, 16, 0}).build();     // Catch: Exception -> L9
            Intrinsics.checkNotNull(r1);     // Catch: Exception -> L9
            r0.add(r1);     // Catch: Exception -> L9
            ScanFilter r2 = new ScanFilter.Builder().setServiceUuid(new ParcelUuid(UUID.fromString("0000FD7B-0000-1000-8000-00805F9B34FB"))).build();     // Catch: Exception -> L9
            Intrinsics.checkNotNull(r2);     // Catch: Exception -> L9
            r0.add(r2);     // Catch: Exception -> L9
            ScanFilter r3 = new ScanFilter.Builder().setServiceUuid(new ParcelUuid(UUID.fromString("00002010-0000-1000-8000-00805F9B34FB"))).build();     // Catch: Exception -> L9
            Intrinsics.checkNotNull(r3);     // Catch: Exception -> L9
            r0.add(r3);     // Catch: Exception -> L9
        L11:
            return r0;
        L9:
            e = move-exception;
            FLogger.a.e("DoraBleProtocolService", "getScanFilters error: " + e.getMessage());
            goto L11
        L5:
            return CollectionsKt.emptyList();
        }

        public DoraBleProtocolBinder(DoraBleProtocolService r2) {
            Intrinsics.checkNotNullParameter(r2, "service");
            this.serviceRef = new WeakReference(r2);
        }

        @Override // com.obric.assistant.dora.IDoraBleProtocolService
        public DoraBleDevice parseScanResult(ScanResult r9) {
            if (requireService() != null) goto L6;
            return null;
        L6:
            if (r9 != null) goto L9;
            FLogger.a.w("DoraBleProtocolService", "parseScanResult: scanResult is null");
            return null;
        L9:
            IPrivacyService r4 = (IPrivacyService) ServiceManager.get().getService(IPrivacyService.class);
            boolean r5 = false;
            if (r4 != null) goto L12;
        L14:
            boolean r6 = false;
        L15:
            if (r6 == true) goto L60;
            FLogger.a.w("DoraBleProtocolService", "parseScanResult: privacy not agreed");
            return null;
        L60:
            ParcelUuid r7 = new ParcelUuid(UUID.fromString("0000FDEE-0000-1000-8000-00805F9B34FB"));     // Catch: Exception -> L57
            ParcelUuid r0 = new ParcelUuid(UUID.fromString("00002010-0000-1000-8000-00805F9B34FB"));     // Catch: Exception -> L57
            ScanRecord r8 = r9.getScanRecord();     // Catch: Exception -> L57
            if (r8 == null) goto L21;
            byte[] r10 = r8.getServiceData(r7);     // Catch: Exception -> L57
        L22:
            if (r10 == null) goto L24;
            boolean r11 = true;
        L25:
            ScanRecord r12 = r9.getScanRecord();     // Catch: Exception -> L57
            if (r12 == null) goto L32;
            List<ParcelUuid> r13 = r12.getServiceUuids();     // Catch: Exception -> L57
            if (r13 == null) goto L32;
            if (r13.contains(r0) != true) goto L32;
            r5 = true;
        L32:
            if (r11 == false) goto L34;
            DoraDevice r14 = pk4.a.j(r9, 4096);     // Catch: Exception -> L57
        L37:
            FLogger r1 = FLogger.a;     // Catch: Exception -> L57
            StringBuilder r15 = new StringBuilder("parseScanResult: isH=");     // Catch: Exception -> L57
            r15.append(r11);     // Catch: Exception -> L57
            r15.append(", isG2=");     // Catch: Exception -> L57
            r15.append(r5);     // Catch: Exception -> L57
            r15.append(", device=(name=");     // Catch: Exception -> L57
            if (r14 == null) goto L40;
            String r2 = r14.name;     // Catch: Exception -> L57
        L41:
            r15.append(r2);     // Catch: Exception -> L57
            r15.append(",sn=");     // Catch: Exception -> L57
            if (r14 == null) goto L44;
            String r3 = r14.getSerialNumber();     // Catch: Exception -> L57
        L45:
            r15.append(r3);     // Catch: Exception -> L57
            r15.append(",type=");     // Catch: Exception -> L57
            if (r14 == null) goto L48;
            Integer r16 = Integer.valueOf(r14.type);     // Catch: Exception -> L57
        L49:
            r15.append(r16);     // Catch: Exception -> L57
            r15.append(",productId=");     // Catch: Exception -> L57
            if (r14 == null) goto L52;
            Integer r17 = Integer.valueOf(r14.productId);     // Catch: Exception -> L57
        L53:
            r15.append(r17);     // Catch: Exception -> L57
            r15.append(')');     // Catch: Exception -> L57
            r1.i("DoraBleProtocolService", r15.toString());     // Catch: Exception -> L57
            if (r14 == null) goto L62;
            return d.b(r14);
        L62:
            return null;
        L52:
            r17 = null;
            goto L53
        L48:
            r16 = null;
            goto L49
        L44:
            r3 = null;
            goto L45
        L40:
            r2 = null;
            goto L41
        L34:
            if (r5 == false) goto L36;
            r14 = kj4.a.g().convertScanResultToDoraDeviceV2(r9);     // Catch: Exception -> L57
            goto L37
        L36:
            r14 = pk4.a.h(r9);     // Catch: Exception -> L57
            r14.vendorId = 1;     // Catch: Exception -> L57
            r14.productId = d.a(r14.productId, r14.type);     // Catch: Exception -> L57
            goto L37
        L24:
            r11 = false;
            goto L25
        L21:
            r10 = null;
        L57:
            e = move-exception;
            FLogger.a.e("DoraBleProtocolService", "parseScanResult error: " + e.getMessage());
            return null;
        L12:
            if (r4.a() != true) goto L14;
            r6 = true;
            goto L15
        }

        @Override // com.obric.assistant.dora.IDoraBleProtocolService
        public void startAutoBindFlow(DoraBleDevice r5) {
            DoraBleProtocolService r0 = requireService();
            if (r0 != null) goto L6;
            return;
        L6:
            if (r5 != null) goto L14;
            FLogger.a.w("DoraBleProtocolService", "startAutoBindFlow: device is null");
            return;
        L14:
            DoraBleProtocolService.a(r0, r5);     // Catch: Exception -> L11
            return;
        L11:
            e = move-exception;
            FLogger.a.e("DoraBleProtocolService", "startAutoBindFlow error: " + e.getMessage());
        }

        @Override // com.obric.assistant.dora.IDoraBleProtocolService.Stub, android.os.Binder
        public boolean onTransact(int r7, Parcel r8, Parcel r9, int r10) {
            Intrinsics.checkNotNullParameter(r8, "data");
            DoraBleProtocolService r0 = requireService();
            if (r0 != null) goto L5;
            return false;
        L5:
            int r2 = Binder.getCallingUid();
            if (r2 == Process.myUid()) goto L22;
            String[] r3 = r0.getPackageManager().getPackagesForUid(r2);
            boolean r4 = true;
            if (r3 != null) goto L10;
        L12:
            boolean r5 = false;
        L14:
            if (r0.checkCallingPermission("com.obric.assistant.dora.permission.DoraBleProtocolService") == 0) goto L17;
            r4 = false;
        L17:
            if (r5 == true) goto L22;
            if (r4 == true) goto L22;
            FLogger.a.e("DoraBleProtocolService", "onTransact denied: callingUid=" + r2 + " does not have permission and is not SystemUI");
            return false;
        L10:
            if (ArraysKt.contains(r3, "com.android.systemui") != true) goto L12;
            r5 = true;
        L22:
            return super.onTransact(r7, r8, r9, r10);
        }
    }

    public static final class a {
    }

    public static final class b implements e.a {
        public final /* synthetic */ DoraBleProtocolService a;

        @Override // com.obric.assistant.dora.e.a
        public final void a() {
            FLogger.a.i("DoraBleProtocolService", "bridge onBridgeAvailable");
            DoraBleProtocolService r0 = this.a;
            Iterator r1 = CollectionsKt.toList(r0.d.values()).iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            i r2 = (i) r1.next();
            Intrinsics.checkNotNull(r2);
            r0.c(r2);
            goto L4
        }

        @Override // com.obric.assistant.dora.e.a
        public final void b() {
            FLogger.a.w("DoraBleProtocolService", "bridge onBridgeUnavailable");
            DoraBleProtocolService r0 = this.a;
            int r1 = DoraBleProtocolService.j;
            r0.b("bridgeUnavailable");
        }

        public b(DoraBleProtocolService r1) {
            this.a = r1;
        }
    }

    static {
    }

    public static Set d() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(BluetoothAdapter.getDefaultAdapter());     // Catch: Throwable -> L4
    L6:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L10;
        FLogger.a.e("DoraBleProtocolService", "getConnectedBluetoothMacSet: get default adapter failed, error=" + r2.getMessage());
    L10:
        if (Result.isFailure-impl(r1) == false) goto L12;
        r1 = null;
    L12:
        BluetoothAdapter r3 = (BluetoothAdapter) r1;
        if (r3 != null) goto L17;
        return SetsKt.emptySet();
    L17:
        if (r3.isEnabled() == true) goto L21;
        FLogger.a.i("DoraBleProtocolService", "getConnectedBluetoothMacSet: bluetooth adapter is disabled");
        return SetsKt.emptySet();
    L21:
        if (Build.VERSION.SDK_INT >= 31) goto L23;
    L80:
        Object r4 = Result.constructor-impl(BluetoothDevice.class.getMethod("isConnected", new Class[0]));     // Catch: Throwable -> L28
    L30:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L34;
        FLogger.a.e("DoraBleProtocolService", "getConnectedBluetoothMacSet: get isConnected method failed, error=" + r5.getMessage());
    L34:
        if (Result.isFailure-impl(r4) == false) goto L36;
        r4 = null;
    L36:
        Method r6 = (Method) r4;
        if (r6 == null) goto L39;
        Set<BluetoothDevice> r7 = r3.getBondedDevices();     // Catch: Throwable -> L68
        if (r7 == null) goto L65;
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L68
        Iterator<T> r9 = r7.iterator();     // Catch: Throwable -> L68
    L44:
        if (r9.hasNext() == false) goto L48;
        Object r10 = r9.next();     // Catch: Throwable -> L68
        BluetoothDevice r11 = (BluetoothDevice) r10;     // Catch: Throwable -> L68
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L68
        if (e(r11, r6) == false) goto L44;
        r8.add(r10);     // Catch: Throwable -> L68
        goto L44
    L48:
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L68
        Iterator r13 = r8.iterator();     // Catch: Throwable -> L68
    L50:
        if (r13.hasNext() == false) goto L62;
        String r14 = ((BluetoothDevice) r13.next()).getAddress();     // Catch: Throwable -> L68
        if (r14 != null) goto L54;
    L59:
        String r15 = null;
    L60:
        if (r15 == null) goto L50;
        r12.add(r15);     // Catch: Throwable -> L68
        goto L50
    L54:
        if ((!StringsKt.isBlank(r14)) == true) goto L57;
        r14 = null;
    L57:
        if (r14 == null) goto L59;
        r15 = r14.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L68
        goto L60
    L62:
        Set r16 = CollectionsKt.toSet(r12);     // Catch: Throwable -> L68
        if (r16 == null) goto L65;
    L66:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L68
    L70:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L73;
        FLogger.a.e("DoraBleProtocolService", "getConnectedBluetoothMacSet: read connected devices failed, error=" + r18.getMessage());
    L73:
        Set r19 = SetsKt.emptySet();
        if (Result.isFailure-impl(r17) == false) goto L77;
        r17 = r19;
    L77:
        return (Set) r17;
    L65:
        r16 = SetsKt.emptySet();     // Catch: Throwable -> L68
    L68:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L70
    L39:
        return SetsKt.emptySet();
    L28:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    L23:
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), "android.permission.BLUETOOTH_CONNECT") == 0) goto L80;
        FLogger.a.w("DoraBleProtocolService", "getConnectedBluetoothMacSet: bluetooth connect permission not granted");
        return SetsKt.emptySet();
    L4:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public final void f() {
        if (this.d.isEmpty() == true) goto L5;
    L20:
        e.a.getClass();
        e.f = true;
        e.b();
        return;
    L5:
        if (this.e == true) goto L20;
        e.a.getClass();
        e.f = false;
        Context r0 = e.c;
        if (e.e == false) goto L18;
        if (r0 == null) goto L18;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        r0.unbindService(e.g);     // Catch: Throwable -> L12
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L17;
        FLogger.a.e("DoraInteractorBridgeHub", "unbindMainProcessBridgeService failed: " + r3.getMessage());
    L17:
        e.c();
        return;
    L12:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
    L18:
        e.c();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        FLogger.a.i("DoraBleProtocolService", "onDestroy called");
        this.f = true;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L16
        Application r2 = AppHost.a.getApplication();     // Catch: Throwable -> L16
        DoraBleProtocolService$bluetoothStateReceiver$1 r3 = this.g;     // Catch: Throwable -> L16
        ReceiverRegisterLancet.loge(r3, false);     // Catch: Throwable -> L16
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L23;
        r2.unregisterReceiver(r3);     // Catch: Throwable -> L16
    L14:
        FLogger.a.i("DoraBleProtocolService", "unregisterBluetoothStateReceiver success");     // Catch: Throwable -> L16
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L21;
        FLogger.a.e("DoraBleProtocolService", "unregisterBluetoothStateReceiver failed: " + r5.getMessage());
    L21:
        e r6 = e.a;
        b r7 = this.i;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "listener");
        e.b.remove(r7);
        this.c.shutdownNow();
        this.d.clear();
        this.e = false;
        f();
        super.onDestroy();
        return;
    L23:
    L9:
        e = move-exception;
        if (r3 == null) goto L12;
        Npth.addTag("unregisterReceiver", r3.toString());     // Catch: Throwable -> L16
    L12:
        e.printStackTrace();     // Catch: Throwable -> L16
        goto L14
    L6:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r3, r2) == false) goto L14;
        r2.unregisterReceiver(r3);     // Catch: Exception -> L9 Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.obric.assistant.dora.DoraBleProtocolService$bluetoothStateReceiver$1] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.obric.assistant.dora.DoraBleProtocolService$bridgeConnectCallback$1] */
    public DoraBleProtocolService() {
        this.a = new DoraBleProtocolBinder(this);
        this.b = new Handler(Looper.getMainLooper());
        this.c = PThreadExecutorsUtils.newSingleThreadExecutor(new com.obric.assistant.dora.b());
        this.d = new ConcurrentHashMap();
        this.g = new DoraBleProtocolService$bluetoothStateReceiver$1(this);
        this.h = new DoraBleProtocolService$bridgeConnectCallback$1(this);
        this.i = new b(this);
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.f = false;
        e r0 = e.a;
        Context r1 = getApplicationContext();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "context");
        if (e.c != null) goto L5;
        e.c = r1.getApplicationContext();
    L5:
        b r2 = this.i;
        Intrinsics.checkNotNullParameter(r2, "listener");
        e.b.add(r2);
        if (e.d == null) goto L22;
        e.d(r2);
    L22:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L15
        IntentFilter r4 = new IntentFilter();     // Catch: Throwable -> L15
        r4.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");     // Catch: Throwable -> L15
        r4.addAction("android.bluetooth.adapter.action.STATE_CHANGED");     // Catch: Throwable -> L15
        Application r5 = AppHost.a.getApplication();     // Catch: Throwable -> L15
        DoraBleProtocolService$bluetoothStateReceiver$1 r6 = this.g;     // Catch: Throwable -> L15
        if (Build.VERSION.SDK_INT < 31) goto L12;
        String r7 = "android.permission.BLUETOOTH_CONNECT";
    L13:
        ContextCompat.registerReceiver(r5, r6, r4, r7, this.b, 2);     // Catch: Throwable -> L15
        FLogger.a.i("DoraBleProtocolService", "registerBluetoothStateReceiver success");     // Catch: Throwable -> L15
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L20;
        FLogger.a.e("DoraBleProtocolService", "registerBluetoothStateReceiver failed: " + r9.getMessage());
    L20:
        b("serviceCreate");
        return;
    L12:
        r7 = "android.permission.BLUETOOTH";
    L15:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }

    public final void b(final String r6) {
        if (this.f == false) goto L14;
        FLogger.a.w("DoraBleProtocolService", "checkBoundConnectedDevicesAndUpdateBridgeDemand ignored: service destroyed, reason=".concat(r6));
        return;
    L14:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        this.c.execute(new c(this, r6));     // Catch: Throwable -> L8
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L16;
        FLogger.a.e("DoraBleProtocolService", "checkBoundConnectedDevicesAndUpdateBridgeDemand submit failed: reason=" + r6 + ", error=" + r2.getMessage());
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final void c(i r20) {
        e.a.getClass();
        IDoraMainProcessBridgeService r0 = e.d;
        if (r0 != null) goto L25;
        FLogger.a.w("DoraBleProtocolService", "dispatchAutoBindRequest deferred: bridge unavailable, requestId=" + r20.a);
        return;
    L25:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L16
        d r5 = r20.d;     // Catch: Throwable -> L16
        String r6 = r5.b;     // Catch: Throwable -> L16
        String r7 = r5.a;     // Catch: Throwable -> L16
        String r12 = r5.f;     // Catch: Throwable -> L16
        Integer r8 = r5.d;     // Catch: Throwable -> L16
        if (r8 == null) goto L9;
        int r16 = r8.intValue();     // Catch: Throwable -> L16
    L10:
        Integer r9 = r5.c;     // Catch: Throwable -> L16
        if (r9 == null) goto L13;
        int r10 = r9.intValue();     // Catch: Throwable -> L16
    L14:
        r0.checkBindAndConnectIfNecessaryAsync(new DoraDeviceInfo(r6, r7, null, null, 0, 0, r12, 0, 0, r16, r10, 3580), r20.a, this.h);     // Catch: Throwable -> L16
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L27;
        FLogger.a.e("DoraBleProtocolService", "dispatchAutoBindRequest failed: requestId=" + r20.a + ", error=" + r2.getMessage());
        i r3 = this.d.remove(r20.a);
        if (r3 == null) goto L28;
        f();
        this.b.post(new com.obric.assistant.dora.a(this, r3));
        return;
    L28:
        return;
    L27:
        return;
    L13:
        r10 = 0;
        goto L14
    L9:
        r16 = 0;
    L16:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r4) {
        FLogger.a.i("DoraBleProtocolService", "onBind called with intent=" + r4);
        return this.a;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent r4) {
        FLogger.a.i("DoraBleProtocolService", "onUnbind called with intent=" + r4);
        return super.onUnbind(r4);
    }

    public static final void a(DoraBleProtocolService r14, DoraBleDevice r15) {
        String r0 = UUID.randomUUID().toString();
        int r2 = r15.j;
        if (r2 != 4096) goto L5;
        boolean r3 = true;
    L6:
        String r5 = r15.b;
        String r6 = r15.a;
        int r4 = r15.l;
        i r1 = new i(r0, r15, r3, new d(r5, r6, Integer.valueOf(r4), Integer.valueOf(r2), r15.m, null, r15.g, 32));
        r14.d.put(r0, r1);
        FLogger.a.i("DoraBleProtocolService", "enqueueAutoBindRequest: requestId=" + r0 + ", name=" + r1.d.a + ", sn=" + r1.d.f + ", productId=" + r1.d.c + ", isH=" + r1.c);
        r14.f();
        r14.c(r1);
        return;
    L5:
        r3 = false;
        goto L6
    }

    public static boolean e(BluetoothDevice r3, Method r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        Object r5 = r4.invoke(r3, new Object[0]);     // Catch: Throwable -> L8
        if ((r5 instanceof Boolean) == false) goto L5;
        Boolean r6 = (Boolean) r5;     // Catch: Throwable -> L8
    L6:
        Object r7 = Result.constructor-impl(Boolean.valueOf(Intrinsics.areEqual(r6, Boolean.TRUE)));     // Catch: Throwable -> L8
    L10:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L13;
        FLogger.a.e("DoraBleProtocolService", "isConnectedByMethod failed, error=" + r8.getMessage());
    L13:
        Boolean r9 = Boolean.FALSE;
        if (Result.isFailure-impl(r7) == false) goto L17;
        r7 = r9;
    L17:
        return ((Boolean) r7).booleanValue();
    L5:
        r6 = null;
    L8:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
