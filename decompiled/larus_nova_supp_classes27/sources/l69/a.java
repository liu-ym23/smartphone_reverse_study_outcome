package l69;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import g49.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        if (Build.VERSION.SDK_INT < 31) goto L5;
        List r0 = CollectionsKt.listOf("android.permission.BLUETOOTH_CONNECT");
    L7:
        return b(r2, r0, "connect");
    L5:
        r0 = CollectionsKt.listOf(new String[]{"android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN"});
        goto L7
    }

    public static final boolean c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        if (Build.VERSION.SDK_INT < 31) goto L5;
        List r0 = CollectionsKt.listOf("android.permission.BLUETOOTH_SCAN");
    L7:
        return b(r3, r0, "scan");
    L5:
        r0 = CollectionsKt.listOf(new String[]{"android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN", "android.permission.ACCESS_FINE_LOCATION"});
        goto L7
    }

    public static final Set<BluetoothDevice> d(BluetoothAdapter r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
    L16:
        th = move-exception;
        d.c("DoraBtPermission", "safeBondedDevices: unexpected error", th);
        return SetsKt.emptySet();
    L4:
        if (Build.VERSION.SDK_INT >= 31) goto L6;
    L20:
        Set<BluetoothDevice> r4 = r3.getBondedDevices();     // Catch: Throwable -> L13
        if (r4 != null) goto L22;
    L23:
        return SetsKt.emptySet();
    L22:
        return r4;
    L13:
        th = move-exception;
        d.c("DoraBtPermission", "safeBondedDevices: error when accessing bondedDevices", th);     // Catch: Throwable -> L16
        return SetsKt.emptySet();
    L6:
        if (a("DoraBtPermission") == true) goto L20;
        d.e("DoraBtPermission", "safeBondedDevices: BLUETOOTH_CONNECT permission not granted, return empty set");     // Catch: Throwable -> L16
        return SetsKt.emptySet();
    }

    public static final boolean b(String r7, List<String> r8, String r9) {
        Application r2 = AppHost.a.getApplication();     // Catch: Throwable -> L17
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L17
        Iterator<T> r10 = r8.iterator();     // Catch: Throwable -> L17
    L4:
        boolean r5 = true;
        if (r10.hasNext() == false) goto L13;
        Object r4 = r10.next();     // Catch: Throwable -> L17
        if (ContextCompat.checkSelfPermission(r2, (String) r4) != 0) goto L10;
        r5 = false;
    L10:
        if (r5 == false) goto L4;
        r3.add(r4);     // Catch: Throwable -> L17
        goto L4
    L13:
        if ((!r3.isEmpty()) == false) goto L16;
        d.e(r7, "ensure" + r9 + " permission missing: " + r3);     // Catch: Throwable -> L17
        return false;
    L16:
        return true;
    L17:
        th = move-exception;
        d.c(r7, "ensure" + r9 + " permission error", th);
        return false;
    }
}
