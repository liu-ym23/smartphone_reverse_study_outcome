package com.obric.memorydata.middleware.impl.network;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.TrafficStats;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.rpc.IWifiInfoApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u0000H\u0007J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u0012H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/middleware/impl/network/WifiInfoApiImpl;", "Lcom/obric/memorydata/middleware/api/rpc/IWifiInfoApi;", "<init>", "()V", "wifiManager", "Landroid/net/wifi/WifiManager;", "getWifiManager", "()Landroid/net/wifi/WifiManager;", "wifiManager$delegate", "Lkotlin/Lazy;", "appUid", "", "getInst", "getWifiFrequency", "getWifiGeneration", "getWifiRssi", "getWifiLevel", "getUidTxBytes", "", "retrieveAppUid", "getUidRxBytes", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WifiInfoApiImpl implements IWifiInfoApi {
    public static final WifiInfoApiImpl INSTANCE = null;
    private static int appUid;
    private static final Lazy wifiManager$delegate = null;

    static {
        INSTANCE = new WifiInfoApiImpl();
        wifiManager$delegate = LazyKt.lazy($$Lambda$WifiInfoApiImpl$PiBdMdKK0SWbsjY08VuFEvSU_Y.INSTANCE);
    }

    private WifiInfoApiImpl() {
    }

    @JvmStatic
    public static final WifiInfoApiImpl getInst() {
        return INSTANCE;
    }

    private final WifiManager getWifiManager() {
        return (WifiManager) ZeusTransformUtils.preCheckCast(wifiManager$delegate.getValue(), WifiManager.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$PiBdMdKK0SWbsjY08VuFEvSU-_Y, reason: not valid java name */
    public static /* synthetic */ WifiManager m1024lambda$PiBdMdKK0SWbsjY08VuFEvSU_Y() {
        return wifiManager_delegate$lambda$0();
    }

    private final int retrieveAppUid() {
        if (appUid > 0) goto L6;
        ApplicationInfo r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getApplicationInfo(AppContext.INSTANCE.getPackageName(), 0);     // Catch: Throwable -> L7
        Intrinsics.checkNotNullExpressionValue(r2, "getApplicationInfo(...)");     // Catch: Throwable -> L7
        appUid = r2.uid;     // Catch: Throwable -> L7
    L6:
        return appUid;
    }

    private static final WifiManager wifiManager_delegate$lambda$0() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        return (WifiManager) ZeusTransformUtils.preCheckCast(r0, WifiManager.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.rpc.IWifiInfoApi
    public long getUidRxBytes() {
        int r2 = retrieveAppUid();
        if (r2 > 0) goto L9;
        return 0;
    L9:
        return TrafficStats.getUidRxBytes(r2);
    L11:
        return 0;
    }

    @Override // com.obric.memorydata.middleware.api.rpc.IWifiInfoApi
    public long getUidTxBytes() {
        int r2 = retrieveAppUid();
        if (r2 > 0) goto L9;
        return 0;
    L9:
        return TrafficStats.getUidTxBytes(r2);
    L11:
        return 0;
    }

    @Override // com.obric.memorydata.middleware.api.rpc.IWifiInfoApi
    public int getWifiFrequency() {
        return getWifiManager().getConnectionInfo().getFrequency();
    L4:
        return 0;
    }

    @Override // com.obric.memorydata.middleware.api.rpc.IWifiInfoApi
    public int getWifiGeneration() {
        WifiInfo r4 = getWifiManager().getConnectionInfo();     // Catch: Throwable -> L5
        Method r1 = r4.getClass().getDeclaredMethod("getWifiGeneration", new Class[0]);     // Catch: Throwable -> L5
        r1.setAccessible(true);     // Catch: Throwable -> L5
        Object r5 = r1.invoke(r4, new Object[0]);     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L5
        return ((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.memorydata.plugin")).intValue();
    L5:
        return 0;
    }

    @Override // com.obric.memorydata.middleware.api.rpc.IWifiInfoApi
    public int getWifiLevel() {
        return WifiManager.calculateSignalLevel(getWifiRssi(), 10);
    L4:
        return 0;
    }

    @Override // com.obric.memorydata.middleware.api.rpc.IWifiInfoApi
    public int getWifiRssi() {
        return getWifiManager().getConnectionInfo().getRssi();
    L4:
        return 0;
    }
}
