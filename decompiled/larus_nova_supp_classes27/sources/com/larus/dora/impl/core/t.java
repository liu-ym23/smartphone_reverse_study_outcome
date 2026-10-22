package com.larus.dora.impl.core;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothSocket;
import android.os.SystemClock;
import androidx.core.content.ContextCompat;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.DoraSimpleDevice;
import com.larus.dora.impl.noti_v3.NotificationBroadcastV3Tracker;
import com.larus.dora.impl.util.f;
import com.larus.platform.service.AccountService;
import java.lang.reflect.Method;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class t {
    public static final Lazy a = null;
    public static final Lazy b = null;

    public static final class a implements BluetoothProfile.ServiceListener {
        public final /* synthetic */ Ref.ObjectRef<BluetoothProfile> a;
        public final /* synthetic */ BluetoothDevice b;
        public final /* synthetic */ Boolean[] c;
        public final /* synthetic */ CountDownLatch d;
        public final /* synthetic */ int e;

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public final void onServiceDisconnected(int r1) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(BluetoothA2dp r8, BluetoothDevice r9) {
            Intrinsics.checkNotNullParameter(r8, "a2dp");
            Intrinsics.checkNotNullParameter(r9, "device");
            Method r1 = BluetoothA2dp.class.getDeclaredMethod("connect", new Class[]{BluetoothDevice.class});     // Catch: Throwable -> L5 Exception -> L7
            r1.setAccessible(true);     // Catch: Throwable -> L5 Exception -> L7
            Boolean[] r2 = this.c;     // Catch: Throwable -> L5 Exception -> L7
            Object r10 = r1.invoke(r8, new Object[]{r9});     // Catch: Throwable -> L5 Exception -> L7
            Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Throwable -> L5 Exception -> L7
            r2[0] = r10;     // Catch: Throwable -> L5 Exception -> L7
        L9:
            this.d.countDown();
            return;
        L5:
            th = move-exception;
            this.d.countDown();
            throw th;
        L7:
            e = move-exception;
            g49.d.d("DoraConnectExt", "connectA2DP: failed caused by error : " + e.getMessage());     // Catch: Throwable -> L5
            goto L9
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void b(BluetoothHeadset r8, BluetoothDevice r9) {
            Intrinsics.checkNotNullParameter(r8, "hfp");
            Intrinsics.checkNotNullParameter(r9, "device");
            Method r1 = BluetoothHeadset.class.getDeclaredMethod("connect", new Class[]{BluetoothDevice.class});     // Catch: Throwable -> L5 Exception -> L7
            r1.setAccessible(true);     // Catch: Throwable -> L5 Exception -> L7
            Boolean[] r2 = this.c;     // Catch: Throwable -> L5 Exception -> L7
            Object r10 = r1.invoke(r8, new Object[]{r9});     // Catch: Throwable -> L5 Exception -> L7
            Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Throwable -> L5 Exception -> L7
            r2[0] = r10;     // Catch: Throwable -> L5 Exception -> L7
        L9:
            this.d.countDown();
            return;
        L5:
            th = move-exception;
            this.d.countDown();
            throw th;
        L7:
            e = move-exception;
            g49.d.d("DoraConnectExt", "connectHfp: failed caused by error : " + e.getMessage());     // Catch: Throwable -> L5
            goto L9
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public final void onServiceConnected(int r12, BluetoothProfile r13) {
            if (r12 == 1) goto L22;
            if (r12 != 2) goto L48;
            this.a.element = r13;
            Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.bluetooth.BluetoothA2dp");
            BluetoothA2dp r14 = (BluetoothA2dp) r13;
        L13:
            e = move-exception;
            g49.d.d("DoraConnectExt", "connectBluetoothProfile: check (profile = " + this.e + ") connection state failed : " + e.getMessage());
        L16:
            if (this.b.getBondState() != 12) goto L18;
            a(r14, this.b);
            return;
        L18:
            boolean r15 = this.b.createBond();
            g49.d.d("DoraConnectExt", "connectBluetoothProfile (profile = " + this.e + "). device create bond  : " + r15);
            if (r15 == false) goto L21;
            a(r14, this.b);
            return;
        L21:
            this.c[0] = Boolean.FALSE;
            this.d.countDown();
            return;
        L8:
            if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), "android.permission.BLUETOOTH_CONNECT") != 0) goto L16;
            if (r14.getConnectionState(this.b) != 2) goto L16;
            this.c[0] = Boolean.TRUE;     // Catch: Exception -> L13
            this.d.countDown();     // Catch: Exception -> L13
            g49.d.d("DoraConnectExt", "connectBluetoothProfile: check (profile = " + this.e + ") connection state : connected");     // Catch: Exception -> L13
            return;
        L48:
            return;
        L22:
            this.a.element = r13;
            Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.bluetooth.BluetoothHeadset");
            BluetoothHeadset r16 = (BluetoothHeadset) r13;
        L29:
            e = move-exception;
            g49.d.d("DoraConnectExt", "connectBluetoothProfile: check (profile = " + this.e + ") connection state failed : " + e.getMessage());
        L32:
            if (this.b.getBondState() != 12) goto L34;
            b(r16, this.b);
            return;
        L34:
            boolean r17 = this.b.createBond();
            g49.d.d("DoraConnectExt", "connectBluetoothProfile (profile = " + this.e + "). device create bond  : " + r17);
            if (r17 == false) goto L37;
            b(r16, this.b);
            return;
        L37:
            this.c[0] = Boolean.FALSE;
            this.d.countDown();
            return;
        L24:
            if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), "android.permission.BLUETOOTH_CONNECT") != 0) goto L32;
            if (r16.getConnectionState(this.b) != 2) goto L32;
            this.c[0] = Boolean.TRUE;     // Catch: Exception -> L29
            this.d.countDown();     // Catch: Exception -> L29
            g49.d.d("DoraConnectExt", "connectBluetoothProfile: check (profile = " + this.e + ") connection state : connected");     // Catch: Exception -> L29
        }

        public a(Ref.ObjectRef<BluetoothProfile> r1, BluetoothDevice r2, Boolean[] r3, CountDownLatch r4, int r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    static {
        a = LazyKt.lazy(new p());
        b = LazyKt.lazy(new q());
    }

    @JvmStatic
    public static final boolean a(final DoraDevice r20) {
        boolean r2 = false;
        if (f.a(r20) == true) goto L5;
        return false;
    L5:
        z r0 = z.a;
        DoraBuryPointManager.a.L("dora_initiate_proprietary_protocol_start", MapsKt.mapOf(new Pair[]{TuplesKt.to("external_device_type", "earphone"), TuplesKt.to("external_device_name", "dora")}));
        monitor-enter(t.class);
        if (r20 != null) goto L11;
        g49.d.e("DoraConnectExt", "connect skipped for non G");     // Catch: Throwable -> L90
        monitor-exit(t.class);
    L89:
        return r2;
    L11:
        AppHost.Companion r11 = AppHost.a;     // Catch: Throwable -> L90
        if (com.larus.dora.impl.util.y.b(r11.getApplication()) == true) goto L16;
        g49.d.d("DoraConnectExt", "connect: " + r20.sn + " not_Allow_In_Not_Main_Process : " + com.larus.dora.impl.util.y.a(r11.getApplication()));     // Catch: Throwable -> L90
        monitor-exit(t.class);
        goto L89
    L16:
        i0 r9 = i0.a.a;     // Catch: Throwable -> L90
        if (AccountService.a.isLogin().booleanValue() == true) goto L21;
        g49.d.d("DoraConnectExt", "connect skipped for logout");     // Catch: Throwable -> L90
        monitor-exit(t.class);
        goto L89
    L21:
        g49.d.d("DoraConnectExt", "connect: " + r20.sn + " start, vendorId=" + Integer.valueOf(r20.vendorId) + "，productId=" + Integer.valueOf(r20.productId));     // Catch: Throwable -> L90
        if (l69.a.a("DoraConnectExt") == true) goto L26;
        g49.d.e("DoraConnectExt", "connect: bluetooth connect permission not granted, skip connect");     // Catch: Throwable -> L90
        monitor-exit(t.class);
        goto L89
    L26:
        final Ref.ObjectRef r8 = new Ref.ObjectRef();     // Catch: Throwable -> L90
        r8.element = new CountDownLatch(1);     // Catch: Throwable -> L90
        long r12 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L90
        final Ref.BooleanRef r10 = new Ref.BooleanRef();     // Catch: Throwable -> L90
        DoraDevice r13 = kj4.a.g().c();     // Catch: Throwable -> L90
        if (r13 != null) goto L29;
    L30:
        kj4.a.g().disConnect(r13, 0);     // Catch: Throwable -> L90
    L32:
        if (r20.isDoraDevice() == false) goto L34;
        String r14 = "00002499-0000-1000-8000-00805f9b34fb";
    L36:
        if (r20.vendorId != 4096) goto L38;
        boolean r15 = true;
    L39:
        if (r15 == false) goto L96;
        g49.d.d("DoraConnectExt", "device connect audio profile a2dpRet=" + b(r20, 2) + ", hfpRet=" + b(r20, 1));     // Catch: Throwable -> L90
    L96:
        kj4.a.g().connect(r20, r14, new r(r20, r8, r10));     // Catch: Throwable -> L44
    L46:
        int r1 = r20.type;     // Catch: Throwable -> L90
        if (r1 != 17) goto L49;
    L54:
        r2 = true;
    L55:
        if (r2 == false) goto L57;
        long r16 = 300;
    L94:
        CountDownLatch r3 = (CountDownLatch) r8.element;     // Catch: InterruptedException -> L64 Throwable -> L90
        if (r3 == null) goto L61;
        Boolean r4 = Boolean.valueOf(r3.await(r16, TimeUnit.SECONDS));     // Catch: InterruptedException -> L64 Throwable -> L90
    L62:
        g49.d.d("DoraConnectExt", "connect: " + r20.sn + ", awaitResult=" + r4);     // Catch: InterruptedException -> L64 Throwable -> L90
    L66:
        z r5 = z.a;     // Catch: Throwable -> L90
        BuildersKt.launch$default(z.b, null, null, new DoraCoreTracker$reportConnect$1(r10.element, SystemClock.elapsedRealtime() - r12, null), 3, null);     // Catch: Throwable -> L90
        if (r10.element == false) goto L87;
        com.larus.dora.impl.util.b0 r6 = com.larus.dora.impl.util.b0.a;     // Catch: Throwable -> L90
        String r7 = r20.mac;     // Catch: Throwable -> L90
        if (r7 != null) goto L71;
        r7 = "";
    L71:
        String r17 = r20.name;     // Catch: Throwable -> L90
        if (r17 != null) goto L74;
        r17 = "";
    L74:
        String r18 = r17;
        String r21 = r20.mac;     // Catch: Throwable -> L90
        if (r21 != null) goto L77;
        r21 = "";
    L77:
        String r110 = r21;
        String r22 = r20.sn;     // Catch: Throwable -> L90
        if (r22 != null) goto L80;
        r22 = "";
    L80:
        String r111 = r22;
        int r23 = r20.sku;     // Catch: Throwable -> L90
        int r24 = r20.type;     // Catch: Throwable -> L90
        String r25 = r20.getSerialNumber();     // Catch: Throwable -> L90
        if (r25 != null) goto L83;
        r25 = "";
    L83:
        DoraSimpleDevice r26 = new DoraSimpleDevice(r18, r110, r111, r23, r24, r25);     // Catch: Throwable -> L90
        r6.getClass();     // Catch: Throwable -> L90
        com.larus.dora.impl.util.b0.D(r7, r26);     // Catch: Throwable -> L90
        if (com.larus.dora.impl.util.b0.b(ILoginService.a.getAccountInfo().c, r20.mac) == false) goto L86;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraConnectExt$connectInternal$2(r20, null), 3, null);     // Catch: Throwable -> L90
    L86:
        BuildersKt.launch$default((CoroutineScope) b.getValue(), null, null, new DoraConnectExt$postConnectedToNetwork$1(null), 3, null);     // Catch: Throwable -> L90
        NotificationBroadcastV3Tracker.a.getClass();     // Catch: Throwable -> L90
        NotificationBroadcastV3Tracker.g();     // Catch: Throwable -> L90
    L87:
        g49.d.d("DoraConnectExt", "connect: " + r20.sn + ", result=" + r10.element + ", consume=" + (SystemClock.elapsedRealtime() - r12));     // Catch: Throwable -> L90
        r2 = r10.element;     // Catch: Throwable -> L90
        monitor-exit(t.class);
        goto L89
    L61:
        r4 = null;
    L64:
        e = move-exception;
        g49.d.c("DoraConnectExt", "connect: " + r20.sn + ", await exception", e);     // Catch: Throwable -> L90
        goto L66
    L57:
        r16 = 15;
        goto L94
    L49:
        if (r1 == 18) goto L54;
        int r27 = r20.productId;     // Catch: Throwable -> L90
        if (r27 == ProductNameType.DORA_G2.id) goto L54;
        if (r27 != ProductNameType.DORA_G_AIR.id) goto L55;
    L44:
        th = move-exception;
        g49.d.c("DoraConnectExt", "connect: exception when calling DoraAdapter.connect", th);     // Catch: Throwable -> L90
        r8.element = null;     // Catch: Throwable -> L90
        r10.element = false;     // Catch: Throwable -> L90
        goto L46
    L38:
        r15 = false;
        goto L39
    L34:
        r14 = "00101020-4C42-0065-636E-614465747942";
        goto L36
    L29:
        if (Intrinsics.areEqual(r13.mac, r20.mac) == true) goto L32;
    L90:
        th = move-exception;
        throw th;
    }

    public static boolean b(DoraDevice r14, int r15) {
        BluetoothAdapter r0 = BluetoothAdapter.getDefaultAdapter();
        if (r0 != null) goto L6;
        g49.d.d("DoraConnectExt", "connectBluetoothProfile(profile = " + r15 + "): failed caused by defaultAdapter is null");
        return false;
    L6:
        if (r14 == null) goto L42;
        String r4 = r14.mac;
        if (r4 != null) goto L10;
    L13:
        boolean r5 = true;
    L14:
        if (r5 == true) goto L42;
        BluetoothDevice r8 = r0.getRemoteDevice(r14.mac);
        if (r8 != null) goto L21;
        g49.d.d("DoraConnectExt", "connectBluetoothProfile(profile = " + r15 + "): failed caused by bluetoothDevice is null");
        return false;
    L21:
        if (l69.a.a("DoraConnectExt") == true) goto L24;
        g49.d.e("DoraConnectExt", "connectBluetoothProfile(profile = " + r15 + "): bluetooth connect permission not granted, skip profile connect");
        return false;
    L24:
        CountDownLatch r16 = new CountDownLatch(1);
        Boolean[] r6 = {Boolean.FALSE};
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        r0.getProfileProxy(AppHost.a.getApplication(), new a(r7, r8, r6, r16, r15), r15);
        r16.await(8, TimeUnit.SECONDS);     // Catch: Throwable -> L29 Exception -> L31
        BluetoothProfile r17 = (BluetoothProfile) r7.element;
        if (r17 == null) goto L37;
    L35:
        r0.closeProfileProxy(r15, r17);
    L37:
        return r6[0].booleanValue();
    L31:
        e = move-exception;
        g49.d.d("DoraConnectExt", "connectBluetoothProfile(profile = " + r15 + "): failed caused by countDownLatch error : " + e.getMessage());     // Catch: Throwable -> L29
        r17 = (BluetoothProfile) r7.element;
        if (r17 == null) goto L37;
    L29:
        th = move-exception;
        BluetoothProfile r1 = (BluetoothProfile) r7.element;
        if (r1 == null) goto L41;
        r0.closeProfileProxy(r15, r1);
    L41:
        throw th;
    L10:
        if (r4.length() == 0) goto L13;
        r5 = false;
    L42:
        g49.d.d("DoraConnectExt", "connectBluetoothProfile(profile = " + r15 + "): failed caused by device is null or mac is empty");
        return false;
    }

    public static boolean c(BluetoothDevice r4, UUID r5) {
        Intrinsics.checkNotNullParameter(r4, "device");
        Intrinsics.checkNotNullParameter(r5, "uuid");
        if (kj4.a.g().isReady() == 0) goto L42;
        g49.d.e("DoraConnectExt", "isSppAvailable: DoraAdapter is not ready");
        return false;
    L42:
        BluetoothSocket r6 = r4.createRfcommSocketToServiceRecord(r5);     // Catch: Throwable -> L19
        if (r6 != null) goto L10;
        g49.d.e("DoraConnectExt", "isSppAvailable: createRfcommSocketToServiceRecord return null");     // Catch: Throwable -> L17
        return false;
    L10:
        r6.connect();     // Catch: Throwable -> L17
        r6.close();     // Catch: Throwable -> L13
        return true;
    L13:
        th = move-exception;
        g49.d.c("DoraConnectExt", "isSppAvailable: close socket error", th);
        return true;
    L17:
        th = th;
    L44:
        g49.d.c("DoraConnectExt", "isSppAvailable exception", th);     // Catch: Throwable -> L28
        if (r6 != null) goto L39;
    L27:
        return false;
    L39:
        r6.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        g49.d.c("DoraConnectExt", "isSppAvailable: close socket error", th);
    L28:
        th = move-exception;
        if (r6 != null) goto L37;
    L34:
        throw th;
    L37:
        r6.close();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        g49.d.c("DoraConnectExt", "isSppAvailable: close socket error", th);
    L19:
        th = th;
        r6 = null;
        goto L44
    }
}
