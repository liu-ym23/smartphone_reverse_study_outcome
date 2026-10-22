package t3;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class s0 extends BluetoothGattCallback {
    public final WeakReference<y> a;
    public final String b;
    public volatile Function1<? super Result<Unit>, Unit> c;
    public volatile Function1<? super Result<? extends List<g0>>, Unit> d;
    public volatile Function1<? super Result<Integer>, Unit> e;
    public volatile Function1<? super Result<Integer>, Unit> f;
    public Runnable g;
    public Runnable h;
    public Runnable i;
    public Runnable j;

    public final void a(Object r10) {
        Function1<? super Result<Unit>, Unit> r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        Runnable r1 = this.g;
        if (r1 == null) goto L8;
        e0.a.getClass();
        e0.c.removeCallbacks(r1);
    L8:
        this.g = null;
        this.c = null;
        r0.invoke(Result.box-impl(r10));
    }

    public s0(WeakReference<y> r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "clientRef");
        Intrinsics.checkNotNullParameter(r11, "deviceId");
        this.a = r10;
        this.b = r11;
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onCharacteristicChanged(BluetoothGatt r10, BluetoothGattCharacteristic r11) {
        Intrinsics.checkNotNullParameter(r10, "gatt");
        Intrinsics.checkNotNullParameter(r11, "characteristic");
        b(r10, r11, r11.getValue());
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onServicesDiscovered(BluetoothGatt r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "gatt");
        if (this.a.get() != null) goto L6;
        return;
    L6:
        if (r11 != 0) goto L21;
        Result.Companion r12 = Result.Companion;
        a(Result.constructor-impl(Unit.INSTANCE));
        Function1<? super Result<? extends List<g0>>, Unit> r13 = this.d;
        if (r13 == null) goto L31;
        Runnable r1 = this.h;
        if (r1 == null) goto L12;
        e0.a.getClass();
        e0.c.removeCallbacks(r1);
    L12:
        this.h = null;
        this.d = null;
        List<BluetoothGattService> r14 = r10.getServices();
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r15 = r14.iterator();
    L14:
        if (r15.hasNext() == false) goto L20;
        BluetoothGattService r16 = (BluetoothGattService) r15.next();
        String r17 = r16.getUuid().toString();
        if (r16.getType() != 0) goto L18;
        boolean r18 = true;
    L19:
        r0.add(new g0(r17, r18));
        goto L14
    L18:
        r18 = false;
        goto L19
    L20:
        r13.invoke(Result.box-impl(Result.constructor-impl(r0)));
        return;
    L31:
        return;
    L21:
        Result.Companion r19 = Result.Companion;
        a(Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("discover services failed: " + r11))));
        Function1<? super Result<? extends List<g0>>, Unit> r20 = this.d;
        if (r20 == null) goto L33;
        Runnable r21 = this.h;
        if (r21 == null) goto L26;
        e0.a.getClass();
        e0.c.removeCallbacks(r21);
    L26:
        this.h = null;
        this.d = null;
        r20.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("discover services failed: " + r11)))));
        return;
    }

    public final void b(BluetoothGatt r10, BluetoothGattCharacteristic r11, byte[] r12) {
        y r0 = this.a.get();
        if (r0 != null) goto L5;
        return;
    L5:
        String r1 = this.b;
        String r13 = r11.getUuid().toString();
        Intrinsics.checkNotNullParameter(r1, "deviceId");
        Intrinsics.checkNotNullParameter(r13, "characteristicId");
        if (r0.l.contains(y.c(r1, r13)) == true) goto L8;
        return;
    L8:
        e0.a.getClass();
        String r14 = e0.h(r10, r11);
        if (r14 != null) goto L11;
        return;
    L11:
        r0.l(this.b, r14, r11.getUuid().toString(), r12);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onCharacteristicChanged(BluetoothGatt r10, BluetoothGattCharacteristic r11, byte[] r12) {
        Intrinsics.checkNotNullParameter(r10, "gatt");
        Intrinsics.checkNotNullParameter(r11, "characteristic");
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        b(r10, r11, r12);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onCharacteristicRead(BluetoothGatt r10, BluetoothGattCharacteristic r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "gatt");
        Intrinsics.checkNotNullParameter(r11, "characteristic");
        c(r10, r11, r11.getValue(), r12);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onConnectionStateChange(BluetoothGatt r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "gatt");
        y r0 = this.a.get();
        if (r0 != null) goto L5;
        return;
    L5:
        String r1 = this.b;
        Intrinsics.checkNotNullParameter(r1, "deviceId");
        t0 r13 = r0.k.get(r1);
        if (r11 == 0) goto L9;
        Result.Companion r14 = Result.Companion;
        a(Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("connect gatt failed: " + r11))));
        r0.d(this.b, new IllegalStateException("connect gatt failed: " + r11));
        r0.m(this.b, false);
        return;
    L9:
        if (r12 != 0) goto L11;
        if (r13 == null) goto L21;
        r13.d = false;
    L21:
        r0.m(this.b, false);
        if (this.c == null) goto L24;
        Result.Companion r15 = Result.Companion;
        a(Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("bluetooth disconnected"))));
    L24:
        r0.d(this.b, new IllegalStateException("bluetooth disconnected"));
        return;
    L11:
        if (r12 == 2) goto L14;
        return;
    L14:
        if (r13 == null) goto L16;
        r13.d = true;
    L16:
        r0.m(this.b, true);
        Result.Companion r16 = Result.Companion;
        a(Result.constructor-impl(Unit.INSTANCE));
        if (Build.VERSION.SDK_INT <= 33) goto L26;
        r10.setPreferredPhy(3, 3, 0);
        return;
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onMtuChanged(BluetoothGatt r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "gatt");
        y r13 = this.a.get();
        if (r13 != null) goto L5;
        return;
    L5:
        String r0 = this.b;
        Intrinsics.checkNotNullParameter(r0, "deviceId");
        t0 r14 = r13.k.get(r0);
        Function1<? super Result<Integer>, Unit> r1 = this.e;
        if (r1 != null) goto L8;
        return;
    L8:
        Runnable r15 = this.i;
        if (r15 == null) goto L11;
        e0.a.getClass();
        e0.c.removeCallbacks(r15);
    L11:
        this.i = null;
        this.e = null;
        if (r12 != 0) goto L16;
        if (r14 == null) goto L15;
        r14.e = r11;
    L15:
        Result.Companion r16 = Result.Companion;
        r1.invoke(Result.box-impl(Result.constructor-impl(Integer.valueOf(r11))));
        return;
    L16:
        Result.Companion r17 = Result.Companion;
        r1.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("request mtu failed: " + r12)))));
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onReadRemoteRssi(BluetoothGatt r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "gatt");
        y r13 = this.a.get();
        if (r13 != null) goto L5;
        return;
    L5:
        String r0 = this.b;
        Intrinsics.checkNotNullParameter(r0, "deviceId");
        t0 r14 = r13.k.get(r0);
        Function1<? super Result<Integer>, Unit> r1 = this.f;
        if (r1 != null) goto L8;
        return;
    L8:
        Runnable r15 = this.j;
        if (r15 == null) goto L11;
        e0.a.getClass();
        e0.c.removeCallbacks(r15);
    L11:
        this.j = null;
        this.f = null;
        if (r12 != 0) goto L16;
        if (r14 == null) goto L15;
        r14.f = r11;
    L15:
        Result.Companion r16 = Result.Companion;
        r1.invoke(Result.box-impl(Result.constructor-impl(Integer.valueOf(r11))));
        return;
    L16:
        Result.Companion r17 = Result.Companion;
        r1.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("read rssi failed: " + r12)))));
    }

    public final void c(BluetoothGatt r10, BluetoothGattCharacteristic r11, byte[] r12, int r13) {
        y r0 = this.a.get();
        if (r0 != null) goto L5;
        return;
    L5:
        String r1 = this.b;
        String r14 = r11.getUuid().toString();
        Intrinsics.checkNotNullParameter(r1, "deviceId");
        Intrinsics.checkNotNullParameter(r14, "characteristicId");
        String r15 = y.c(r1, r14);
        AtomicInteger r16 = r0.m.get(r15);
        if (r16 != null) goto L9;
        boolean r17 = false;
    L12:
        if (r17 == true) goto L14;
        return;
    L14:
        if (r13 == 0) goto L16;
        return;
    L16:
        e0.a.getClass();
        String r18 = e0.h(r10, r11);
        if (r18 != null) goto L19;
        return;
    L19:
        r0.l(this.b, r18, r11.getUuid().toString(), r12);
        return;
    L9:
        if (r16.decrementAndGet() > 0) goto L11;
        r0.m.remove(r15);
    L11:
        r17 = true;
        goto L12
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onCharacteristicRead(BluetoothGatt r10, BluetoothGattCharacteristic r11, byte[] r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "gatt");
        Intrinsics.checkNotNullParameter(r11, "characteristic");
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        c(r10, r11, r12, r13);
    }
}
