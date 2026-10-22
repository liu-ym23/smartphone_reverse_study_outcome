package com.bytedance.bpea.entry.api.device.info;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroid/net/wifi/WifiConfiguration;", "kotlin.jvm.PlatformType", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class WifiManagerEntry$Companion$getConfiguredNetworksUnsafe$1 extends Lambda implements Function0<List<WifiConfiguration>> {
    final /* synthetic */ WifiManager $this_getConfiguredNetworksUnsafe;

    public WifiManagerEntry$Companion$getConfiguredNetworksUnsafe$1(WifiManager r1) {
        this.$this_getConfiguredNetworksUnsafe = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final List<WifiConfiguration> m1688invoke() {
        WifiManager r9 = this.$this_getConfiguredNetworksUnsafe;
        ArrayList r10 = new ArrayList();
        Object[] r12 = new Object[0];
        f06.b r13 = new f06.b();
        g06.a r1 = (g06.a) ApiHookConfig.b.get(101001);
        if (r1 == null) goto L5;
        f06.a[] r2 = r1.i;
    L6:
        f06.a[] r8 = r2;
        int r7 = r8.length;
        int r6 = 0;
    L8:
        if (r6 >= r7) goto L15;
        f06.a r5 = r8[r6];
        int r17 = r6;
        int r18 = r7;
        f06.a[] r19 = r8;
        f06.d r3 = r5.preInvoke(101001, "android/net/wifi/WifiManager", "getConfiguredNetworks", r9, r12, "java.util.List", r13);     // Catch: Exception -> L21
        if (r3.a == true) goto L17;
        r10.add(r5);     // Catch: Exception -> L21
    L17:
        if (r3.a == false) goto L20;
        return (List) r3.b;
    L20:
        return r9.getConfiguredNetworks();
    L14:
        r6 = r17 + 1;
        r7 = r18;
        r8 = r19;
        goto L8
    L15:
        r3 = new f06.d(false, null);
        goto L17
    L5:
        r2 = ApiHookConfig.d;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1688invoke();
    }
}
