package com.bytedance.bpea.entry.api.device.info;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroid/net/wifi/ScanResult;", "kotlin.jvm.PlatformType", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class WifiManagerEntry$Companion$getScanResultsUnsafe$1 extends Lambda implements Function0<List<ScanResult>> {
    final /* synthetic */ WifiManager $this_getScanResultsUnsafe;

    public WifiManagerEntry$Companion$getScanResultsUnsafe$1(WifiManager r1) {
        this.$this_getScanResultsUnsafe = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final List<ScanResult> m1690invoke() {
        WifiManager r8 = this.$this_getScanResultsUnsafe;
        f06.c r9 = new f06.c();
        Object[] r10 = new Object[0];
        f06.b r11 = new f06.b();
        f06.d r12 = r9.b(102300, "android/net/wifi/WifiManager", "getScanResults", r8, r10, "java.util.List", r11);
        if (r12.a == false) goto L5;
        r9.a(102300, "android/net/wifi/WifiManager", "getScanResults", r8, r10, null, r11, false);
        return (List) r12.b;
    L5:
        List<ScanResult> r13 = r8.getScanResults();
        r9.a(102300, "android/net/wifi/WifiManager", "getScanResults", r8, r10, r13, r11, true);
        return r13;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1690invoke();
    }
}
