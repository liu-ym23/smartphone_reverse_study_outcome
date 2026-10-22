package com.obric.aikernel.middleware.impl.network;

import android.annotation.SuppressLint;
import android.content.pm.ApplicationInfo;
import android.net.TrafficStats;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.rpc.IWifiInfoApi;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"WrongConstant"})
public final class WifiInfoApiImpl implements IWifiInfoApi {
    public static final WifiInfoApiImpl INSTANCE = null;
    private static int appUid;
    private static final Lazy wifiManager$delegate = null;

    static {
        INSTANCE = new WifiInfoApiImpl();
        wifiManager$delegate = LazyKt.lazy(WifiInfoApiImpl$wifiManager$2.INSTANCE);
    }

    private WifiInfoApiImpl() {
    }

    @JvmStatic
    public static final WifiInfoApiImpl getInst() {
        return INSTANCE;
    }

    private final WifiManager getWifiManager() {
        return (WifiManager) wifiManager$delegate.getValue();
    }

    private final int retrieveAppUid() {
        if (appUid > 0) goto L6;
        AppContext r10 = AppContext.INSTANCE;     // Catch: Throwable -> L7
        ApplicationInfo r11 = r10.getApplication().getPackageManager().getApplicationInfo(r10.getPackageName(), 0);     // Catch: Throwable -> L7
        Intrinsics.checkNotNullExpressionValue(r11, "packageManager.getApplicationInfo(packageName, 0)");     // Catch: Throwable -> L7
        appUid = r11.uid;     // Catch: Throwable -> L7
    L6:
        return appUid;
    }

    @Override // com.obric.aikernel.middleware.api.rpc.IWifiInfoApi
    public long getUidRxBytes() {
        int r10 = retrieveAppUid();
        if (r10 > 0) goto L9;
        return 0;
    L9:
        return TrafficStats.getUidRxBytes(r10);
    L11:
        return 0;
    }

    @Override // com.obric.aikernel.middleware.api.rpc.IWifiInfoApi
    public long getUidTxBytes() {
        int r10 = retrieveAppUid();
        if (r10 > 0) goto L9;
        return 0;
    L9:
        return TrafficStats.getUidTxBytes(r10);
    L11:
        return 0;
    }

    @Override // com.obric.aikernel.middleware.api.rpc.IWifiInfoApi
    public int getWifiFrequency() {
        return getWifiManager().getConnectionInfo().getFrequency();
    L4:
        return 0;
    }

    @Override // com.obric.aikernel.middleware.api.rpc.IWifiInfoApi
    public int getWifiGeneration() {
        WifiInfo r10 = getWifiManager().getConnectionInfo();     // Catch: Throwable -> L5
        Method r11 = r10.getClass().getDeclaredMethod("getWifiGeneration", new Class[0]);     // Catch: Throwable -> L5
        r11.setAccessible(true);     // Catch: Throwable -> L5
        Object r12 = r11.invoke(r10, new Object[0]);     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L5
        return ((Integer) r12).intValue();
    L5:
        return 0;
    }

    @Override // com.obric.aikernel.middleware.api.rpc.IWifiInfoApi
    public int getWifiLevel() {
        return WifiManager.calculateSignalLevel(getWifiRssi(), 10);
    L4:
        return 0;
    }

    @Override // com.obric.aikernel.middleware.api.rpc.IWifiInfoApi
    public int getWifiRssi() {
        return getWifiManager().getConnectionInfo().getRssi();
    L4:
        return 0;
    }
}
