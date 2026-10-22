package com.bytedance.badger.z;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataJson;
import com.bytedance.badger.module.BadgerModuleBase;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p0 extends u0 {
    public p0() {
    }

    public static String c(WifiInfo r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        f06.b r12 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(101100);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(101100, "android/net/wifi/WifiInfo", "getBSSID", r18, r10, "java.lang.String", r12);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (String) r4.b;
    L21:
        return r18.getBSSID();
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static String d(WifiInfo r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        f06.b r12 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(101000);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(101000, "android/net/wifi/WifiInfo", "getSSID", r18, r10, "java.lang.String", r12);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (String) r4.b;
    L21:
        return r18.getSSID();
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static WifiInfo e(WifiManager r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        f06.b r12 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102301);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(102301, "android/net/wifi/WifiManager", "getConnectionInfo", r18, r10, "android.net.wifi.WifiInfo", r12);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (WifiInfo) r4.b;
    L21:
        return r18.getConnectionInfo();
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r4, BadgerModuleBase.BadgerRequestData r5) {
        Object r6 = r4.getApplicationContext().getSystemService("wifi");
        String r0 = null;
        if ((r6 instanceof WifiManager) == true) goto L5;
        r6 = null;
    L5:
        WifiManager r7 = (WifiManager) r6;
        if (r7 == null) goto L8;
        WifiInfo r8 = e(r7);     // Catch: Throwable -> L17
        if (r8 == null) goto L12;
        String r9 = d(r8);     // Catch: Throwable -> L17
    L13:
        if (r8 == null) goto L15;
        r0 = c(r8);     // Catch: Throwable -> L17
    L15:
        return new BadgerResult.Success(new DataJson(com.bm.badgervi.b.f(new Pair[]{TuplesKt.to(DataType.TRUE, r9), TuplesKt.to("2", r0)})));
    L12:
        r9 = null;
    L17:
        th = move-exception;
        com.bytedance.badger.e.c("WifiInfoProvider", "getInfo: failed", th);
        return new BadgerResult.Failure(BadgerResult.ERROR, "error: " + th.toString());
    L8:
        return new BadgerResult.Failure(-999, "wifiManager not available");
    }
}
