package t3;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.ParcelUuid;
import android.util.Base64;
import androidx.core.content.ContextCompat;
import com.bytedance.ai.applet.base.gson.ByteArrayTypeAdapter;
import com.bytedance.ai.bridge.method.device.BluetoothClient$makeBluetoothPair$receiver$1;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class y implements e3.b {
    public static final /* synthetic */ int n = 0;
    public final WeakReference<e3.d> a;
    public final String b;
    public volatile boolean c;
    public volatile boolean d;
    public volatile Boolean e;
    public volatile Boolean f;
    public final ConcurrentHashMap<String, d0> g;
    public volatile boolean h;
    public volatile ScanCallback i;
    public volatile BluetoothClient$makeBluetoothPair$receiver$1 j;
    public final ConcurrentHashMap<String, t0> k;
    public final ConcurrentHashMap.KeySetView<String, Boolean> l;
    public final ConcurrentHashMap<String, AtomicInteger> m;

    public static final class a {
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r10) {
            return ComparisonsKt.compareValues(((d0) r1).a, ((d0) r10).a);
        }
    }

    static {
    }

    @Override // e3.b
    public final void a() {
        e3.d r0 = this.a.get();
        if (r0 == null) goto L5;
        Context r1 = e3.e.b(r0);
    L6:
        p(r1, false);
        e0.a.getClass();
        Intrinsics.checkNotNullParameter(this, "client");
        e0.d.remove(this);
        q(r1);
        Iterator r10 = CollectionsKt.toList(this.k.keySet()).iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        e(this, (String) r10.next());
        goto L8
    L10:
        this.k.clear();
        this.g.clear();
        this.e = null;
        this.f = null;
        this.c = false;
        this.d = false;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final Object o() {
        if (this.c == false) goto L5;
        Result.Companion r0 = Result.Companion;
        return Result.constructor-impl(Unit.INSTANCE);
    L5:
        Result.Companion r1 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("bluetooth adapter is not initialized")));
    }

    public y(e3.d r10) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        this.a = new WeakReference(r10);
        d3.a0 r11 = r10.getContainerContext();
        if (r11 == null) goto L5;
        String r12 = r11.getContainerId();
    L6:
        if (r12 != null) goto L8;
        r12 = "";
    L8:
        this.b = r12;
        this.g = new ConcurrentHashMap();
        this.k = new ConcurrentHashMap();
        this.l = ConcurrentHashMap.newKeySet();
        this.m = new ConcurrentHashMap();
        e0.a.getClass();
        Intrinsics.checkNotNullParameter(this, "client");
        e0.d.add(this);
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void h(ScanResult r13) {
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_RESULT);
        if (this.d == true) goto L5;
        return;
    L5:
        e0.a.getClass();
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_RESULT);
        ScanRecord r0 = r13.getScanRecord();
        String r1 = r13.getDevice().getAddress();
        if (r1 != null) goto L8;
        String r10 = "";
    L10:
        if (r10.length() != 0) goto L12;
        boolean r11 = true;
    L13:
        d0 r12 = null;
        LinkedHashMap r14 = null;
        r14 = null;
        if (r11 == false) goto L17;
    L53:
        if (r12 != null) goto L55;
        return;
    L55:
        this.g.put(r12.a, r12);
        if (this.h == false) goto L58;
        n(CollectionsKt.sortedWith(this.g.values(), new b()));
        return;
    L58:
        n(CollectionsKt.listOf(r12));
        return;
    L17:
        if (Build.VERSION.SDK_INT < 26) goto L19;
        boolean r15 = r13.isConnectable();
    L20:
        String r16 = r13.getDevice().getName();
        if (r16 != null) goto L23;
        r16 = "";
    L23:
        String r17 = r13.getDevice().getName();
        if (r17 != null) goto L26;
        String r18 = "";
    L27:
        int r19 = r13.getRssi();
        if (r0 == null) goto L30;
        byte[] r20 = r0.getBytes();
    L31:
        if (r0 == null) goto L38;
        List<ParcelUuid> r110 = r0.getServiceUuids();
        if (r110 == null) goto L38;
        List<ParcelUuid> r111 = r110;
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator<T> r112 = r111.iterator();
    L36:
        if (r112.hasNext() == false) goto L39;
        r21.add(((ParcelUuid) r112.next()).getUuid().toString());
    L39:
        if (r21 != null) goto L41;
        List r113 = CollectionsKt.emptyList();
    L42:
        if (r0 == null) goto L49;
        Map<ParcelUuid, byte[]> r114 = r0.getServiceData();
        if (r114 == null) goto L49;
        r14 = new LinkedHashMap(MapsKt.mapCapacity(r114.size()));
        Iterator<T> r115 = r114.entrySet().iterator();
    L47:
        if (r115.hasNext() == false) goto L49;
        Map.Entry r22 = (Map.Entry) r115.next();
        r14.put(((ParcelUuid) r22.getKey()).getUuid().toString(), r22.getValue());
    L49:
        if (r14 != null) goto L51;
        Map r116 = MapsKt.emptyMap();
    L52:
        r12 = new d0(r10, r16, r18, r19, r15, r20, r113, r116);
        goto L53
    L51:
        r116 = r14;
        goto L52
    L41:
        r113 = r21;
    L38:
        r21 = null;
        goto L39
    L30:
        r20 = null;
        goto L31
    L26:
        r18 = r17;
        goto L27
    L19:
        r15 = true;
        goto L20
    L12:
        r11 = false;
        goto L13
    L8:
        r10 = r1;
        goto L10
    }

    public final void n(List<d0> r11) {
        JsonArray r0 = new JsonArray();
        Iterator<T> r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L23;
        d0 r1 = (d0) r12.next();
        JsonObject r10 = new JsonObject();
        r10.addProperty("deviceId", r1.a);
        r10.addProperty(com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, r1.b);
        r10.addProperty("RSSI", Integer.valueOf(r1.d));
        r10.addProperty("connectable", Boolean.valueOf(r1.e));
        String r13 = r1.c;
        if (r13 == null) goto L8;
        r10.addProperty("localName", r13);
    L8:
        byte[] r14 = r1.f;
        if (r14 == null) goto L11;
        int r15 = ByteArrayTypeAdapter.a;
        Intrinsics.checkNotNullParameter(r14, "bytes");
        Intrinsics.checkNotNullParameter(r14, "bytes");
        r10.add("advertisData", new JsonPrimitive(Base64.encodeToString(r14, 2)));
    L11:
        Map<String, byte[]> r16 = r1.h;
        JsonObject r17 = new JsonObject();
        Iterator<T> r18 = r16.entrySet().iterator();
    L13:
        if (r18.hasNext() == false) goto L15;
        Map.Entry r19 = (Map.Entry) r18.next();
        String r20 = (String) r19.getKey();
        byte[] r21 = (byte[]) r19.getValue();
        int r22 = ByteArrayTypeAdapter.a;
        Intrinsics.checkNotNullParameter(r21, "bytes");
        Intrinsics.checkNotNullParameter(r21, "bytes");
        r17.add(r20, new JsonPrimitive(Base64.encodeToString(r21, 2)));
        goto L13
    L15:
        r10.add("serviceData", r17);
        if ((!r1.g.isEmpty()) == false) goto L22;
        JsonArray r23 = new JsonArray();
        Iterator<T> r24 = r1.g.iterator();
    L19:
        if (r24.hasNext() == false) goto L21;
        r23.add((String) r24.next());
        goto L19
    L21:
        r10.add("advertisServiceUUIDs", r23);
    L22:
        r0.add(r10);
        goto L4
    L23:
        JsonObject r110 = new JsonObject();
        r110.add("devices", r0);
        l3.a r25 = new l3.a("doubao.onBluetoothDeviceFound", r110, 4);
        r25.e = this.b;
        l3.d.c(r25);
    }

    public final void q(Context r10) {
        BluetoothClient$makeBluetoothPair$receiver$1 r0 = this.j;
        if (r0 != null) goto L5;
        return;
    L5:
        Unit r1 = null;
        this.j = null;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L22
        if (r10 == null) goto L20;
        Context r12 = r10.getApplicationContext();     // Catch: Throwable -> L22
        if (r12 == null) goto L20;
        ReceiverRegisterLancet.loge(r0, false);     // Catch: Throwable -> L22
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L25;
        r12.unregisterReceiver(r0);     // Catch: Throwable -> L22
    L19:
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L22
        goto L20
    L25:
    L16:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r0.toString());     // Catch: Throwable -> L22
        e.printStackTrace();     // Catch: Throwable -> L22
        goto L19
    L13:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r0, r12) == false) goto L19;
        r12.unregisterReceiver(r0);     // Catch: Exception -> L16 Throwable -> L22
    L20:
        Result.constructor-impl(r1);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static String c(String r10, String r11) {
        StringBuilder r0 = new StringBuilder();
        Locale r1 = Locale.ROOT;
        r0.append(r10.toLowerCase(r1));
        r0.append('|');
        r0.append(r11.toLowerCase(r1));
        return r0.toString();
    }

    public static /* synthetic */ void e(y r10, String r11) {
        r10.d(r11, new IllegalStateException("ble connection closed"));
    }

    public static Object g(t0 r10, String r11) {
        e0 r0 = e0.a;
        BluetoothGatt r12 = r10.b;
        r0.getClass();
        BluetoothGattService r13 = e0.g(r12, r11);
        if (r13 != null) goto L6;
        Result.Companion r14 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("ble service not found")));
    L6:
        Result.Companion r15 = Result.Companion;
        List<BluetoothGattCharacteristic> r16 = r13.getCharacteristics();
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r18 = r16.iterator();
    L8:
        if (r18.hasNext() == false) goto L11;
        BluetoothGattCharacteristic r1 = (BluetoothGattCharacteristic) r18.next();
        String r19 = r1.getUuid().toString();
        Intrinsics.checkNotNull(r1);
        boolean r20 = i(r1, 32);
        boolean r21 = i(r1, 16);
        r17.add(new k(r19, new j(i(r1, 2), i(r1, 8), r21, r20, i(r1, 4))));
        goto L8
    L11:
        return Result.constructor-impl(r17);
    }

    public static boolean i(BluetoothGattCharacteristic r0, int r1) {
        if ((r0.getProperties() & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [t3.l] */
    /* JADX WARN: Type inference failed for: r3v2, types: [t3.q] */
    public final void d(String r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r10, "deviceId");
        Intrinsics.checkNotNullParameter(r11, "failure");
        t0 r1 = this.k.remove(r10);
        if (r1 != null) goto L5;
        return;
    L5:
        final String r12 = r10.toLowerCase(Locale.ROOT) + '|';
        ConcurrentHashMap.KeySetView<String, Boolean> r13 = this.l;
        final ?? r14 = new l(r12);
        r13.removeIf(new p(r14));
        Set<String> r15 = this.m.keySet();
        final ?? r16 = new q(r12);
        r15.removeIf(new r(r16));
        s0 r17 = r1.c;
        r17.getClass();
        Intrinsics.checkNotNullParameter(r11, "failure");
        Runnable r0 = r17.g;
        if (r0 == null) goto L8;
        e0.a.getClass();
        e0.c.removeCallbacks(r0);
    L8:
        Runnable r18 = r17.h;
        if (r18 == null) goto L11;
        e0.a.getClass();
        e0.c.removeCallbacks(r18);
    L11:
        Runnable r19 = r17.i;
        if (r19 == null) goto L14;
        e0.a.getClass();
        e0.c.removeCallbacks(r19);
    L14:
        Runnable r20 = r17.j;
        if (r20 == null) goto L17;
        e0.a.getClass();
        e0.c.removeCallbacks(r20);
    L17:
        r17.g = null;
        r17.h = null;
        r17.i = null;
        r17.j = null;
        Function1<? super Result<Unit>, Unit> r21 = r17.c;
        Function1<? super Result<? extends List<g0>>, Unit> r22 = r17.d;
        Function1<? super Result<Integer>, Unit> r23 = r17.e;
        Function1<? super Result<Integer>, Unit> r24 = r17.f;
        r17.c = null;
        r17.d = null;
        r17.e = null;
        r17.f = null;
        if (r21 == null) goto L20;
        Result.Companion r25 = Result.Companion;
        r21.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r11))));
    L20:
        if (r22 == null) goto L22;
        Result.Companion r26 = Result.Companion;
        r22.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r11))));
    L22:
        if (r23 == null) goto L24;
        Result.Companion r27 = Result.Companion;
        r23.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r11))));
    L24:
        if (r24 == null) goto L35;
        Result.Companion r28 = Result.Companion;
        r24.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r11))));
    L35:
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L28
        r1.b.disconnect();     // Catch: Throwable -> L28
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L37:
        r1.b.close();     // Catch: Throwable -> L32
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L28:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L37
    }

    public final void f(String r10, final Function1<? super Result<? extends List<g0>>, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "deviceId");
        Intrinsics.checkNotNullParameter(r11, "callback");
        Throwable r0 = Result.exceptionOrNull-impl(o());
        if (r0 == null) goto L6;
        r11.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r0))));
        return;
    L6:
        final t0 r12 = this.k.get(r10);
        if (r12 != null) goto L10;
        r11.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("ble connection not found")))));
        return;
    L10:
        r12.c.d = r11;
        Runnable r1 = new x(r12, r11);
        r12.c.h = r1;
        e0.a.getClass();
        Handler r13 = e0.c;
        r13.postDelayed(r1, 5000);
        if (r12.b.discoverServices() == true) goto L14;
        r13.removeCallbacks(r1);
        r12.c.d = null;
        r11.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("discover services failed")))));
        return;
    }

    public final void m(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "deviceId");
        JsonObject r1 = new JsonObject();
        r1.addProperty("deviceId", r10);
        r1.addProperty("connected", Boolean.valueOf(r11));
        l3.a r12 = new l3.a("doubao.onBLEConnectionStateChange", r1, 4);
        r12.e = this.b;
        l3.d.c(r12);
    }

    public final void p(Context r10, boolean r11) {
        ScanCallback r0 = this.i;
        Boolean r1 = null;
        this.i = null;
        this.d = false;
        if (r0 != null) goto L30;
    L21:
        if (r11 == false) goto L32;
        if (r10 == null) goto L27;
        e0.a.getClass();
        BluetoothAdapter r12 = e0.e(r10);
        if (r12 == null) goto L26;
        r1 = Boolean.valueOf(r12.isEnabled());
    L26:
        boolean r13 = Intrinsics.areEqual(r1, Boolean.TRUE);
    L28:
        k(r13, false, false);
        return;
    L27:
        r13 = false;
        goto L28
    L32:
        return;
    L30:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L19
        if (r10 == null) goto L7;
        e0.a.getClass();     // Catch: Throwable -> L19
        BluetoothAdapter r15 = e0.e(r10);     // Catch: Throwable -> L19
    L8:
        if (r15 == null) goto L16;
        BluetoothLeScanner r16 = r15.getBluetoothLeScanner();     // Catch: Throwable -> L19
        if (r16 == null) goto L16;
        if (fna.g.d() == true) goto L14;
        r16.stopScan(r0);     // Catch: Throwable -> L19
    L15:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L17:
        Result.constructor-impl(r17);     // Catch: Throwable -> L19
        goto L21
    L14:
        r16.stopScan(r0);     // Catch: Throwable -> L19
        ina.a.c(r0.hashCode());     // Catch: Throwable -> L19
    L16:
        r17 = null;
        goto L17
    L7:
        r15 = null;
    L19:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void b(Context r10, BluetoothClient$makeBluetoothPair$receiver$1 r11, IntentFilter r12) {
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

    public final void k(boolean r10, boolean r11, boolean r12) {
        if (r12 == false) goto L4;
    L8:
        this.e = Boolean.valueOf(r10);
        this.f = Boolean.valueOf(r11);
        JsonObject r13 = new JsonObject();
        r13.addProperty("available", Boolean.valueOf(r10));
        r13.addProperty("discovering", Boolean.valueOf(r11));
        l3.a r14 = new l3.a("doubao.onBluetoothAdapterStateChange", r13, 4);
        r14.e = this.b;
        l3.d.c(r14);
        return;
    L4:
        if (Intrinsics.areEqual(this.e, Boolean.valueOf(r10)) == false) goto L8;
        if (Intrinsics.areEqual(this.f, Boolean.valueOf(r11)) == false) goto L8;
    }

    public final void l(String r10, String r11, String r12, byte[] r13) {
        Intrinsics.checkNotNullParameter(r10, "deviceId");
        Intrinsics.checkNotNullParameter(r11, "serviceId");
        Intrinsics.checkNotNullParameter(r12, "characteristicId");
        JsonObject r14 = new JsonObject();
        r14.addProperty("deviceId", r10);
        r14.addProperty("serviceId", r11);
        r14.addProperty("characteristicId", r12);
        if (r13 == null) goto L5;
        int r15 = ByteArrayTypeAdapter.a;
        Intrinsics.checkNotNullParameter(r13, "bytes");
        Intrinsics.checkNotNullParameter(r13, "bytes");
        r14.add(com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, new JsonPrimitive(Base64.encodeToString(r13, 2)));
    L5:
        l3.a r16 = new l3.a("doubao.onBLECharacteristicValueChange", r14, 4);
        r16.e = this.b;
        l3.d.c(r16);
    }

    public static final void j(AtomicBoolean r10, Ref.ObjectRef<Runnable> r11, y r12, Context r13, Function1<? super Result<Unit>, Unit> r14, Object r15) {
        if (r10.compareAndSet(false, true) == false) goto L10;
        e0.a.getClass();
        Handler r16 = e0.c;
        Object r17 = r11.element;
        if (r17 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("timeoutRunnable");
        Runnable r18 = null;
    L8:
        r16.removeCallbacks(r18);
        r12.q(r13);
        r14.invoke(Result.box-impl(r15));
        return;
    L7:
        r18 = (Runnable) r17;
        goto L8
    }
}
