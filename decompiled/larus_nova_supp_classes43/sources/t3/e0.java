package t3;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import com.bytedance.ai.bridge.method.device.BluetoothMethodHelper$registerAdapterStateReceiver$1$receiver$1;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e0 {
    public static final e0 a = null;
    public static final UUID b = null;
    public static final Handler c = null;
    public static final ConcurrentHashMap.KeySetView<y, Boolean> d = null;
    public static volatile BluetoothMethodHelper$registerAdapterStateReceiver$1$receiver$1 e;
    public static final Object f = null;

    public e0() {
    }

    static {
        a = new e0();
        b = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
        c = new Handler(Looper.getMainLooper());
        d = ConcurrentHashMap.newKeySet();
        f = new Object();
    }

    public static String[] c() {
        if (Build.VERSION.SDK_INT < 31) goto L6;
        return new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_FINE_LOCATION"};
    L6:
        return new String[]{"android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN"};
    }

    public static String[] j() {
        if (Build.VERSION.SDK_INT < 31) goto L6;
        return new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_FINE_LOCATION"};
    L6:
        return new String[]{"android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN", "android.permission.ACCESS_FINE_LOCATION"};
    }

    public static BluetoothAdapter e(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r10, "context");
        Object r11 = r10.getSystemService("bluetooth");
        if ((r11 instanceof BluetoothManager) == false) goto L5;
        BluetoothManager r12 = (BluetoothManager) r11;
    L6:
        if (r12 != null) goto L8;
        return null;
    L8:
        return r12.getAdapter();
    L5:
        r12 = null;
        goto L6
    }

    public static UUID i(String r10) {
        Intrinsics.checkNotNullParameter(r10, "uuid");
        String r11 = StringsKt.removeSuffix(StringsKt.removePrefix(StringsKt.trim(r10).toString(), "{"), "}");
        boolean r12 = true;
        if (r11.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        Object r13 = null;
        if (r0 == false) goto L9;
        return null;
    L9:
        String r1 = StringsKt.replace$default(r11, "-", "", false, 4, null).toLowerCase(Locale.ROOT);
        int r14 = 0;
    L11:
        if (r14 >= r1.length()) goto L32;
        char r15 = r1.charAt(r14);
        if ('0' <= r15) goto L15;
    L17:
        boolean r16 = false;
    L18:
        if (r16 == false) goto L20;
    L28:
        boolean r17 = true;
    L29:
        if (r17 == false) goto L30;
        r14 = r14 + 1;
        goto L11
    L30:
        r12 = false;
        goto L32
    L20:
        if ('a' <= r15) goto L22;
    L24:
        boolean r18 = false;
    L25:
        if (r18 == true) goto L28;
        r17 = false;
        goto L29
    L22:
        if (r15 >= 'g') goto L24;
        r18 = true;
        goto L25
    L15:
        if (r15 >= ':') goto L17;
        r16 = true;
    L32:
        if (r12 == false) goto L62;
        int r19 = r1.length();
        if (r19 == 4) goto L61;
        if (r19 == 8) goto L70;
        if (r19 == 32) goto L69;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L51
        Object r110 = Result.constructor-impl(UUID.fromString(r11));     // Catch: Throwable -> L51
    L54:
        if (Result.isFailure-impl(r110) == true) goto L68;
        r13 = r110;
    L68:
        return (UUID) r13;
    L51:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r110 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L54
    L69:
        return UUID.fromString(r1.substring(0, 8) + '-' + r1.substring(8, 12) + '-' + r1.substring(12, 16) + '-' + r1.substring(16, 20) + '-' + r1.substring(20, 32));
    L70:
        return UUID.fromString(r1.concat("-0000-1000-8000-00805f9b34fb"));
    L61:
        return UUID.fromString("0000" + r1 + "-0000-1000-8000-00805f9b34fb");
    L62:
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L35
        Object r111 = Result.constructor-impl(UUID.fromString(r11));     // Catch: Throwable -> L35
    L38:
        if (Result.isFailure-impl(r111) == true) goto L42;
        r13 = r111;
    L42:
        return (UUID) r13;
    L35:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r111 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.content.BroadcastReceiver, com.bytedance.ai.bridge.method.device.BluetoothMethodHelper$registerAdapterStateReceiver$1$receiver$1, java.lang.Object] */
    public static void d(e3.d r10, Context r11) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "context");
        y r12 = c0.a(r10);
        boolean r1 = false;
        if (e != null) goto L34;
        Object r0 = f;
        monitor-enter(r0);
    L41:
        th = move-exception;
        throw th;
    L8:
        if (e == null) goto L11;
        monitor-exit(r0);
        goto L34
    L11:
        ?? r13 = new BluetoothMethodHelper$registerAdapterStateReceiver$1$receiver$1();     // Catch: Throwable -> L41
        IntentFilter r14 = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");     // Catch: Throwable -> L41
        Context r15 = r11.getApplicationContext();     // Catch: Throwable -> L41
    L18:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L29
        ReceiverRegisterLancet.loge(r13, false);     // Catch: Throwable -> L29
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L48;
        r15.unregisterReceiver(r13);     // Catch: Throwable -> L29
    L27:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        e = null;     // Catch: Throwable -> L41
    L32:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L41
        monitor-exit(r0);
        goto L34
    L48:
    L24:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r13.toString());     // Catch: Throwable -> L29
        e.printStackTrace();     // Catch: Throwable -> L29
        goto L27
    L21:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r13, r15) == false) goto L27;
        r15.unregisterReceiver(r13);     // Catch: Exception -> L24 Throwable -> L29
    L29:
        th = move-exception;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L41
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L41
        goto L31
    L13:
        if (Build.VERSION.SDK_INT < 33) goto L15;
        a(r15, r13, r14);     // Catch: RuntimeException -> L18 Throwable -> L41
    L16:
        e = r13;     // Catch: RuntimeException -> L18 Throwable -> L41
        goto L32
    L15:
        b(r15, r13, r14);     // Catch: RuntimeException -> L18 Throwable -> L41
    L34:
        BluetoothAdapter r19 = e(r11);
        if (r19 != null) goto L37;
    L39:
        r12.k(r1, r12.d, true);
        return;
    L37:
        if (r19.isEnabled() != true) goto L39;
        r1 = true;
        goto L39
    }

    public static BluetoothGattService g(BluetoothGatt r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "gatt");
        Intrinsics.checkNotNullParameter(r11, "serviceId");
        UUID r0 = i(r11);
        Object r1 = null;
        if (r0 == null) goto L13;
        BluetoothGattService r12 = r10.getService(r0);
        if (r12 != null) goto L27;
        Iterator<T> r13 = r10.getServices().iterator();
    L8:
        if (r13.hasNext() == false) goto L28;
        Object r14 = r13.next();
        if (Intrinsics.areEqual(((BluetoothGattService) r14).getUuid(), r0) == false) goto L8;
        r1 = r14;
    L28:
        return (BluetoothGattService) r1;
    L27:
        return r12;
    L13:
        Iterator<T> r15 = r10.getServices().iterator();
    L15:
        if (r15.hasNext() == false) goto L20;
        Object r16 = r15.next();
        if (StringsKt.equals(((BluetoothGattService) r16).getUuid().toString(), r11, true) == false) goto L15;
        r1 = r16;
    L20:
        return (BluetoothGattService) r1;
    }

    public static String h(BluetoothGatt r10, BluetoothGattCharacteristic r11) {
        Intrinsics.checkNotNullParameter(r10, "gatt");
        Intrinsics.checkNotNullParameter(r11, "characteristic");
        Iterator<BluetoothGattService> r12 = r10.getServices().iterator();
    L4:
        if (r12.hasNext() == false) goto L12;
        BluetoothGattService r0 = r12.next();
        Iterator<BluetoothGattCharacteristic> r1 = r0.getCharacteristics().iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        if (Intrinsics.areEqual(r1.next().getUuid(), r11.getUuid()) == false) goto L7;
        return r0.getUuid().toString();
    L12:
        return null;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Context r10, BluetoothMethodHelper$registerAdapterStateReceiver$1$receiver$1 r11, IntentFilter r12) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L40;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L40:
    L34:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.registerReceiver(r11, r12, 4);
        return;
    L39:
        throw e;
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L23;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r12) == false) goto L23;
        int r1 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r11, r12, 4, null, null, 3, r10).result;     // Catch: Exception -> L34
        if (r1 != 1) goto L13;
        r10.registerReceiver(r11, r12, 4);     // Catch: Exception -> L34
        return;
    L13:
        if (r1 != 2) goto L15;
        new Intent();     // Catch: Exception -> L34
        return;
    L15:
        if (r1 == 3) goto L41;
        r10.registerReceiver(r11, r12, 4);     // Catch: Exception -> L34
        return;
    L41:
        return;
    L23:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L27;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L34
        r10.registerReceiver(r11, r12, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L34
        return;
    L27:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L29;
    L32:
        r10.registerReceiver(r11, r12, 4);     // Catch: Exception -> L34
        return;
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r12) == false) goto L32;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L34
        ContextCompat.registerReceiver(r10, r11, r12, null, ReceiverRegisterLancet.sProxyHandler, 4);     // Catch: Exception -> L34
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void b(Context r10, BluetoothMethodHelper$registerAdapterStateReceiver$1$receiver$1 r11, IntentFilter r12) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r11, r12);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r12) == false) goto L22;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r11, r12, 0, null, null, 2, r10).result;     // Catch: Exception -> L33
        if (r0 != 1) goto L12;
        r10.registerReceiver(r11, r12);     // Catch: Exception -> L33
        return;
    L12:
        if (r0 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r0 == 3) goto L40;
        r10.registerReceiver(r11, r12);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r10.registerReceiver(r11, r12, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r10.registerReceiver(r11, r12);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r12) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r10, r11, r12, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }

    public static BluetoothGattCharacteristic f(BluetoothGatt r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "gatt");
        Intrinsics.checkNotNullParameter(r11, "serviceId");
        Intrinsics.checkNotNullParameter(r12, "characteristicId");
        BluetoothGattService r13 = g(r10, r11);
        Object r14 = null;
        if (r13 != null) goto L5;
        return null;
    L5:
        UUID r0 = i(r12);
        if (r0 == null) goto L16;
        BluetoothGattCharacteristic r15 = r13.getCharacteristic(r0);
        if (r15 != null) goto L30;
        Iterator<T> r16 = r13.getCharacteristics().iterator();
    L11:
        if (r16.hasNext() == false) goto L31;
        Object r17 = r16.next();
        if (Intrinsics.areEqual(((BluetoothGattCharacteristic) r17).getUuid(), r0) == false) goto L11;
        r14 = r17;
    L31:
        return (BluetoothGattCharacteristic) r14;
    L30:
        return r15;
    L16:
        Iterator<T> r18 = r13.getCharacteristics().iterator();
    L18:
        if (r18.hasNext() == false) goto L23;
        Object r1 = r18.next();
        if (StringsKt.equals(((BluetoothGattCharacteristic) r1).getUuid().toString(), r12, true) == false) goto L18;
        r14 = r1;
    L23:
        return (BluetoothGattCharacteristic) r14;
    }
}
