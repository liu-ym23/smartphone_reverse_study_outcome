package com.larus.dora.impl.core;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import androidx.core.content.ContextCompat;
import com.larus.dora.impl.util.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j {
    public static final Set<String> a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        if (l69.a.a("DoraBluetoothEx") == true) goto L6;
        g49.d.e("DoraBluetoothEx", "getBluetoothConnectedDevice: bluetooth connect permission not granted");
        return SetsKt.emptySet();
    L6:
        BluetoothAdapter r1 = null;
        BluetoothManager r5 = (BluetoothManager) ContextCompat.getSystemService(r4, BluetoothManager.class);     // Catch: Throwable -> L9
    L11:
        if (r5 == null) goto L17;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r1 = r5.getAdapter();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        g49.d.c("DoraBtPermission", "safeAdapter: failed to get adapter", th);
    L17:
        if (r1 != null) goto L52;
        g49.d.d("DoraBluetoothEx", "getBluetoothConnectedDevice: bluetoothAdapter is null");
        return SetsKt.emptySet();
    L52:
        Set<BluetoothDevice> r6 = l69.a.d(r1);     // Catch: Throwable -> L22
    L25:
        if (r6.isEmpty() == false) goto L50;
        g49.d.d("DoraBluetoothEx", "getBluetoothConnectedDevice: boundDevice is empty");
        return SetsKt.emptySet();
    L50:
        List r7 = CollectionsKt.filterNotNull(r6);     // Catch: Throwable -> L43
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L43
        Iterator r8 = r7.iterator();     // Catch: Throwable -> L43
    L30:
        if (r8.hasNext() == false) goto L34;
        Object r3 = r8.next();     // Catch: Throwable -> L43
        if (b((BluetoothDevice) r3) == false) goto L30;
        r2.add(r3);     // Catch: Throwable -> L43
        goto L30
    L34:
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));     // Catch: Throwable -> L43
        Iterator r10 = r2.iterator();     // Catch: Throwable -> L43
    L36:
        if (r10.hasNext() == false) goto L41;
        String r11 = ((BluetoothDevice) r10.next()).getAddress();     // Catch: Throwable -> L43
        if (r11 != null) goto L40;
        r11 = "";
    L40:
        r9.add(r11);     // Catch: Throwable -> L43
        goto L36
    L41:
        return CollectionsKt.toSet(r9);
    L43:
        th = move-exception;
        g49.d.c("DoraBluetoothEx", "getBluetoothConnectedDevice: error when filtering connected devices", th);
        return SetsKt.emptySet();
    L22:
        th = move-exception;
        g49.d.c("DoraBluetoothEx", "getBluetoothConnectedDevice: error when reading bondedDevices", th);
        r6 = SetsKt.emptySet();
    L9:
        th = move-exception;
        g49.d.c("DoraBluetoothEx", "getBluetoothConnectedDevice: failed to get BluetoothManager", th);
        r5 = null;
        goto L11
    }

    public static final boolean b(BluetoothDevice r6) {
        Intrinsics.checkNotNullParameter(r6, "device");
        Object r3 = BluetoothDevice.class.getMethod("isConnected", new Class[0]).invoke(r6, new Object[0]);     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Throwable -> L5
        boolean r4 = ((Boolean) r3).booleanValue();     // Catch: Throwable -> L5
        g49.d.d("DoraBluetoothEx", "isDeviceConnected: " + h.a(r6.getAddress()) + ' ' + r4);     // Catch: Throwable -> L5
        return r4;
    L5:
        th = move-exception;
        g49.d.c("DoraBluetoothEx", "isDeviceConnected: Exception", th);
        return false;
    }
}
