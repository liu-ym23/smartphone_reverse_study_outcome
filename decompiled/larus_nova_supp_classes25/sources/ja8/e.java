package ja8;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import com.larus.avlink.n1;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {

    public static final class a implements BluetoothProfile.ServiceListener {
        public final /* synthetic */ Ref.ObjectRef<String> a;
        public final /* synthetic */ String b;
        public final /* synthetic */ CountDownLatch c;
        public final /* synthetic */ BluetoothAdapter d;

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public final void onServiceDisconnected(int r1) {
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public final void onServiceConnected(int r11, BluetoothProfile r12) {
            String r3 = null;
            if ((r12 instanceof BluetoothA2dp) == false) goto L6;
            BluetoothA2dp r2 = (BluetoothA2dp) r12;     // Catch: Throwable -> L28
        L7:
            Ref.ObjectRef<String> r4 = this.a;     // Catch: Throwable -> L28
            String r5 = this.b;     // Catch: Throwable -> L28
            if (r2 != null) goto L46;
        L16:
            BluetoothDevice r6 = null;
        L17:
            if (r6 == null) goto L19;
            r3 = r6.getAddress();     // Catch: Throwable -> L28
        L19:
            r4.element = r3;     // Catch: Throwable -> L28
            if (r12 == null) goto L27;
            BluetoothAdapter r0 = this.d;
            String r7 = this.b;
            r0.closeProfileProxy(2, r12);     // Catch: Throwable -> L24
        L24:
            th = th;
            StringBuilder r1 = new StringBuilder("queryActiveA2dpDeviceAddress: closeProfileProxy failed, tr=");
        L26:
            r1.append(th);
            n1.d(r7, r1.toString());
        L27:
            this.c.countDown();
            return;
        L46:
            Object r8 = r2.getClass().getMethod("getActiveDevice", new Class[0]).invoke(r2, new Object[0]);     // Catch: Throwable -> L14
            if ((r8 instanceof BluetoothDevice) == false) goto L16;
            r6 = (BluetoothDevice) r8;     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            n1.d(r5, "getActiveA2dpDeviceCompat: reflection getActiveDevice failed, tr=" + th);     // Catch: Throwable -> L28
            goto L16
        L6:
            r2 = null;
        L28:
            th = move-exception;
            n1.d(this.b, "queryActiveA2dpDeviceAddress: read active device failed, tr=" + th);     // Catch: Throwable -> L37
            if (r12 == null) goto L27;
            BluetoothAdapter r9 = this.d;
            r7 = this.b;
            r9.closeProfileProxy(2, r12);     // Catch: Throwable -> L34
        L34:
            th = th;
            r1 = new StringBuilder("queryActiveA2dpDeviceAddress: closeProfileProxy failed, tr=");
        L37:
            th = move-exception;
            if (r12 == null) goto L44;
            BluetoothAdapter r10 = this.d;
            String r13 = this.b;
            r10.closeProfileProxy(2, r12);     // Catch: Throwable -> L42
        L42:
            th = move-exception;
            n1.d(r13, "queryActiveA2dpDeviceAddress: closeProfileProxy failed, tr=" + th);
        L44:
            this.c.countDown();
            throw th;
        }

        public a(Ref.ObjectRef<String> r1, String r2, CountDownLatch r3, BluetoothAdapter r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final String b(Context r7, String r8) {
        Object r0 = r7.getSystemService("bluetooth");
        if ((r0 instanceof BluetoothManager) == false) goto L5;
        BluetoothManager r1 = (BluetoothManager) r0;
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        BluetoothAdapter r2 = r1.getAdapter();
        if (r2 != null) goto L11;
        return null;
    L11:
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        CountDownLatch r4 = new CountDownLatch(1);
        boolean r9 = r2.getProfileProxy(r7.getApplicationContext(), new a(r3, r8, r4, r2), 2);     // Catch: Throwable -> L14
    L16:
        if (r9 == true) goto L32;
        return null;
    L32:
    L28:
        ThreadMethodProxy.currentThread().interrupt();
        return null;
    L19:
        if (r4.await(300, TimeUnit.MILLISECONDS) == true) goto L22;
        n1.d(r8, "queryActiveA2dpDeviceAddressInternal: wait callback timeout");     // Catch: InterruptedException -> L28
        return null;
    L22:
        String r10 = (String) r3.element;
        if (r10 != null) goto L25;
        return null;
    L25:
        if ((!StringsKt.isBlank(r10)) == true) goto L27;
        return null;
    L27:
        return r10;
    L14:
        th = move-exception;
        n1.d(r8, "queryActiveA2dpDeviceAddress: getProfileProxy failed, tr=" + th);
        r9 = false;
        goto L16
    L5:
        r1 = null;
        goto L6
    }

    public static final Set<String> a(AudioManager r6, final Context r7, final String r8) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "logTag");
        if (r6.isBluetoothA2dpOn() == false) goto L5;
        boolean r1 = true;
        String r3 = null;
        if (Build.VERSION.SDK_INT < 31) goto L12;
        if (ContextCompat.checkSelfPermission(r7, "android.permission.BLUETOOTH_CONNECT") == 0) goto L12;
        n1.d(r8, "queryActiveA2dpDeviceAddress: BLUETOOTH_CONNECT not granted");
    L21:
        if (r3 != null) goto L23;
    L26:
        if (r1 == true) goto L30;
        return SetsKt.setOf(r3);
    L30:
        if (Build.VERSION.SDK_INT >= 28) goto L34;
        return SetsKt.emptySet();
    L34:
        return SequencesKt.toSet(SequencesKt.filter(SequencesKt.map(SequencesKt.filter(ArraysKt.asSequence(r6.getDevices(2)), new ja8.a()), new b()), new c()));
    L23:
        if (StringsKt.isBlank(r3) == true) goto L26;
        r1 = false;
    L12:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L20;
        final AtomicReference r0 = new AtomicReference(null);
        final CountDownLatch r2 = new CountDownLatch(1);
        PthreadThreadV2 r4 = new PthreadThreadV2(new d(r0, r7, r8, r2), "query-active-a2dp");
        r4.setDaemon(true);
        ThreadMethodProxy.start(r4);
    L19:
        ThreadMethodProxy.currentThread().interrupt();
        goto L21
    L15:
        if (r2.await(420, TimeUnit.MILLISECONDS) == true) goto L18;
        n1.d(r8, "queryActiveA2dpDeviceAddressFromWorker: timeout");     // Catch: InterruptedException -> L19
    L35:
        goto L21
    L18:
        r3 = (String) r0.get();     // Catch: InterruptedException -> L19
        goto L35
    L20:
        r3 = b(r7, r8);
        goto L21
    L5:
        return SetsKt.emptySet();
    }
}
