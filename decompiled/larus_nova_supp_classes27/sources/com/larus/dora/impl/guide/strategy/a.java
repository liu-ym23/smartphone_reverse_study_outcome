package com.larus.dora.impl.guide.strategy;

import android.app.Application;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import com.larus.utils.j0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {

    /* JADX INFO: renamed from: com.larus.dora.impl.guide.strategy.a$a, reason: collision with other inner class name */
    public static final class C0083a {
    }

    static {
    }

    public a() {
    }

    public static List a() {
        if (Build.VERSION.SDK_INT < 31) goto L6;
        return CollectionsKt.listOf(new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT"});
    L6:
        return CollectionsKt.listOf(new String[]{"android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN", "android.permission.ACCESS_FINE_LOCATION"});
    }

    public static Map b() {
        if (Build.VERSION.SDK_INT < 31) goto L5;
        int r0 = j0.a;
        return MapsKt.mapOf(TuplesKt.to("android.permission.BLUETOOTH_SCAN", j0.d(2131902335)));
    L5:
        int r1 = j0.a;
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("android.permission.BLUETOOTH", j0.d(2131902335)), TuplesKt.to("android.permission.ACCESS_FINE_LOCATION", j0.d(2131903928))});
    }

    public static Object c() {
        List r0 = a();
        Application r1 = AppHost.a.getApplication();
        ArrayList r2 = new ArrayList();
        Iterator r3 = r0.iterator();
    L3:
        boolean r4 = false;
        if (r3.hasNext() == false) goto L11;
        Object r5 = r3.next();
        if (ContextCompat.checkSelfPermission(r1, (String) r5) == 0) goto L8;
        r4 = true;
    L8:
        if (r4 == false) goto L3;
        r2.add(r5);
        goto L3
    L11:
        if ((!r2.isEmpty()) == false) goto L13;
        g49.d.d("BtPermissionStrategy", "Bluetooth runtime permissions missing: " + r2);
    L15:
        return Boxing.boxBoolean(r4);
    L13:
        r4 = true;
        goto L15
    }
}
