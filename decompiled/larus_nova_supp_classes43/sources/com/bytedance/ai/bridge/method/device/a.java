package com.bytedance.ai.bridge.method.device;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import fna.g;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import t3.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final a a = null;
    public static final ConcurrentHashMap<String, C0023a> b = null;
    public static volatile i c;
    public static volatile Set<String> d;

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.device.a$a, reason: collision with other inner class name */
    public static final class C0023a {
        public final String a;
        public final int b;
        public final int c;
        public final int d;
        public final double e;
        public final int f;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof C0023a) == true) goto L8;
            return false;
        L8:
            C0023a r11 = (C0023a) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (this.c == r11.c) goto L18;
            return false;
        L18:
            if (this.d == r11.d) goto L21;
            return false;
        L21:
            if (Double.compare(this.e, r11.e) == 0) goto L24;
            return false;
        L24:
            if (this.f == r11.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31;
            long r1 = Double.doubleToLongBits(this.e);
            return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.f;
        }

        public final String toString() {
            return "BeaconSnapshot(uuid=" + this.a + ", major=" + this.b + ", minor=" + this.c + ", proximity=" + this.d + ", accuracy=" + this.e + ", rssi=" + this.f + ')';
        }

        public C0023a(String r10, int r11, int r12, int r13, double r14, int r15) {
            Intrinsics.checkNotNullParameter(r10, "uuid");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
            this.e = r14;
            this.f = r15;
        }
    }

    public a() {
    }

    static {
        a = new a();
        new Handler(Looper.getMainLooper());
        b = new ConcurrentHashMap();
        d = SetsKt.emptySet();
    }

    public static Object b(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Object r11 = r10.getSystemService("bluetooth");
        if ((r11 instanceof BluetoothManager) == false) goto L5;
        BluetoothManager r12 = (BluetoothManager) r11;
    L6:
        if (r12 == null) goto L8;
        BluetoothAdapter r13 = r12.getAdapter();
    L9:
        if (r13 == null) goto L11;
        BluetoothLeScanner r14 = r13.getBluetoothLeScanner();
    L12:
        i r0 = c;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L22
        if (r14 == null) goto L20;
        if (r0 == null) goto L20;
        if (g.d() == true) goto L19;
        r14.stopScan(r0);     // Catch: Throwable -> L22
        goto L20
    L19:
        r14.stopScan(r0);     // Catch: Throwable -> L22
        ina.a.c(r0.hashCode());     // Catch: Throwable -> L22
    L20:
        Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        c = null;
        return r16;
    L22:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L11:
        r14 = null;
        goto L12
    L8:
        r13 = null;
        goto L9
    L5:
        r12 = null;
        goto L6
    }

    public static final void a(a r20, ScanResult r21) {
        r20.getClass();
        ScanRecord r0 = r21.getScanRecord();
        if (r0 == null) goto L38;
        byte[] r1 = r0.getManufacturerSpecificData(76);
        if (r1 == null) goto L38;
        if (r1.length < 23) goto L38;
        if (r1[0] != 2) goto L38;
        if (r1[1] != 21) goto L38;
        ByteBuffer r10 = ByteBuffer.wrap(ArraysKt.copyOfRange(r1, 2, 18));
        String r13 = new UUID(r10.getLong(), r10.getLong()).toString();
        if ((!d.isEmpty()) == true) goto L17;
    L19:
        int r14 = (r1[19] & 255) | ((r1[18] & 255) << 8);
        int r15 = (r1[21] & 255) | ((r1[20] & 255) << 8);
        byte r11 = r1[22];
        int r12 = r21.getRssi();
        if (r12 != 0) goto L23;
        double r16 = -1.0d;
    L22:
        double r17 = r16;
        if (r17 >= 0.0d) goto L31;
        int r18 = 0;
    L37:
        C0023a r19 = new C0023a(r13, r14, r15, r18, r17, r21.getRssi());
    L39:
        if (r19 == null) goto L43;
        b.put(r19.a + '-' + r19.b + '-' + r19.c, r19);
        return;
    L43:
        return;
    L31:
        if (r17 >= 0.5d) goto L34;
        r18 = 1;
        goto L37
    L34:
        if (r17 >= 3.0d) goto L36;
        r18 = 2;
        goto L37
    L36:
        r18 = 3;
        goto L37
    L23:
        double r22 = (((double) r12) * 1.0d) / ((double) r11);
        if (r22 >= 1.0d) goto L26;
        r16 = Math.pow(r22, 10.0d);
        goto L22
    L26:
        r16 = (Math.pow(r22, 7.7095d) * 0.89976d) + 0.111d;
        goto L22
    L17:
        if (d.contains(r13.toLowerCase(Locale.ROOT)) == true) goto L19;
    L38:
        r19 = null;
        goto L39
    }
}
