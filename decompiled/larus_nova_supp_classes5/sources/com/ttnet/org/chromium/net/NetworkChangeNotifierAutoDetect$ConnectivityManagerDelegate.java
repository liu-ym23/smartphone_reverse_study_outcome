package com.ttnet.org.chromium.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ttnet.org.chromium.base.ApplicationStatus;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.StrictModeContext;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForO;
import f06.b;
import f06.d;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ConnectivityManager mConnectivityManager;

    public Network[] getAllNetworksUnfiltered() {
        Network[] r0 = this.mConnectivityManager.getAllNetworks();     // Catch: Throwable -> L4
    L5:
        if (r0 == null) goto L7;
        return r0;
    L7:
        return new Network[0];
    L4:
        r0 = null;
        goto L5
    }

    public Network getDefaultNetwork() {
        if (Build.VERSION.SDK_INT >= 23) goto L40;
        Network r0 = null;
    L38:
        NetworkInfo r1 = this.mConnectivityManager.getActiveNetworkInfo();     // Catch: Throwable -> L37
        if (r1 != null) goto L13;
        return null;
    L13:
        Network[] r3 = NetworkChangeNotifierAutoDetect.access$100(this, null);
        int r4 = r3.length;
        int r6 = 0;
    L14:
        if (r6 >= r4) goto L36;
        Network r7 = r3[r6];
        NetworkInfo r8 = getRawNetworkInfo(r7);
        if (r8 == null) goto L35;
        if (r8.getType() != r1.getType()) goto L20;
    L21:
        if (r0 != null) goto L23;
    L32:
        if (r0 == null) goto L34;
        Log.e(NetworkChangeNotifierAutoDetect.access$200(), "defaultNetwork != null", new Object[0]);
    L34:
        r0 = r7;
        goto L35
    L23:
        if (Build.VERSION.SDK_INT < 29) goto L32;
        if (r8.getDetailedState() == NetworkInfo.DetailedState.CONNECTING) goto L35;
        NetworkInfo r9 = getRawNetworkInfo(r0);
        if (r9 == null) goto L32;
        if (r9.getDetailedState() != NetworkInfo.DetailedState.CONNECTING) goto L32;
        r0 = null;
        goto L32
    L20:
        if (r8.getType() == 17) goto L21;
    L35:
        r6 = r6 + 1;
        goto L14
    L36:
        return r0;
    L37:
        return null;
    L40:
        r0 = ApiHelperForM.getActiveNetwork(this.mConnectivityManager);     // Catch: Throwable -> L6
    L7:
        if (r0 == null) goto L38;
        return r0;
    L6:
        r0 = null;
        goto L7
    }

    public NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate() {
        this.mConnectivityManager = null;
    }

    static {
    }

    public NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate(Context r2) {
        this.mConnectivityManager = (ConnectivityManager) r2.getSystemService("connectivity");
    }

    private static String com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate_android_net_NetworkInfo_getExtraInfo(NetworkInfo r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        b r11 = new b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102026);
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
        d r4 = r7.preInvoke(102026, "android/net/NetworkInfo", "getExtraInfo", r18, r10, "java.lang.String", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (String) r4.b;
    L21:
        return r18.getExtraInfo();
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    private NetworkInfo processActiveNetworkInfo(NetworkInfo r4) {
        if (r4 != null) goto L6;
        return null;
    L6:
        if (r4.isConnected() == false) goto L9;
        return r4;
    L9:
        if (r4.getDetailedState() == NetworkInfo.DetailedState.BLOCKED) goto L12;
        return null;
    L12:
        if (ApplicationStatus.getStateForApplication() == 1) goto L14;
        return null;
    L14:
        return r4;
    }

    public int getConnectionType(Network r2) {
        NetworkInfo r3 = getNetworkInfo(r2);
        if (r3 != null) goto L5;
        return 6;
    L5:
        if (r3.isConnected() == true) goto L7;
        return 6;
    L7:
        return NetworkChangeNotifierAutoDetect.access$000(r3.getType(), r3.getSubtype());
    }

    public NetworkCapabilities getNetworkCapabilities(Network r3) {
        int r0 = 0;
    L4:
        if (r0 >= 2) goto L8;
        return this.mConnectivityManager.getNetworkCapabilities(r3);
    L7:
        r0 = r0 + 1;
        goto L4
    L8:
        return null;
    }

    public NetworkInfo getNetworkInfo(Network r3) {
        NetworkInfo r4 = getRawNetworkInfo(r3);
        if (r4 != null) goto L5;
        return r4;
    L5:
        if (r4.getType() != 17) goto L13;
        return this.mConnectivityManager.getActiveNetworkInfo();
    L8:
        return null;
    L13:
        return r4;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect$NetworkState] */
    /* JADX WARN: Type inference failed for: r1v11, types: [com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect$NetworkState] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect$NetworkState] */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect$NetworkState] */
    /* JADX WARN: Type inference failed for: r1v9, types: [com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect$NetworkState] */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect$NetworkState] */
    public NetworkChangeNotifierAutoDetect$NetworkState getNetworkState(NetworkChangeNotifierAutoDetect.WifiManagerDelegate r23) {
        NetworkInfo r2 = null;
        r2 = null;
        Network r3 = null;
    L16:
        Network r4 = null;
    L17:
        NetworkInfo r5 = processActiveNetworkInfo(r2);
        if (r5 != null) goto L22;
        final boolean r6 = false;
        final int r7 = -1;
        final int r8 = -1;
        final boolean r9 = false;
        final String r10 = null;
        final List r11 = null;
        final boolean r12 = false;
        final String r13 = "";
        return new NetworkChangeNotifierAutoDetect$NetworkState(r6, r7, r8, r9, r10, r11, r12, r13);
    L22:
        if (r4 == null) goto L41;
        NetworkCapabilities r1 = getNetworkCapabilities(r4);
        int r14 = 0;
        if (r1 != null) goto L26;
    L28:
        final boolean r15 = false;
    L29:
        DnsStatus r16 = AndroidNetworkLibrary.getDnsStatus(r4);
        if (r16 != null) goto L33;
        final boolean r17 = true;
        final int r18 = r5.getType();
        final int r19 = r5.getSubtype();
        final String r110 = String.valueOf(NetworkChangeNotifierAutoDetect.networkToNetId(r4));
        final List r111 = null;
        final boolean r112 = false;
        final String r113 = "";
        return new NetworkChangeNotifierAutoDetect$NetworkState(r17, r18, r19, r15, r110, r111, r112, r113);
    L33:
        final ArrayList r114 = new ArrayList();
        byte[][] r20 = r16.getDnsServers();     // Catch: UnknownHostException -> L55
        int r21 = r20.length;     // Catch: UnknownHostException -> L55
    L35:
        if (r14 >= r21) goto L38;
        r114.add(InetAddress.getByAddress(r20[r14]));     // Catch: UnknownHostException -> L55
        r14 = r14 + 1;
    L38:
        final boolean r22 = true;
        final int r24 = r5.getType();
        final int r25 = r5.getSubtype();
        final String r115 = String.valueOf(NetworkChangeNotifierAutoDetect.networkToNetId(r4));
        final boolean r116 = r16.getPrivateDnsActive();
        final String r117 = r16.getPrivateDnsServerName();
        return new NetworkChangeNotifierAutoDetect$NetworkState(r22, r24, r25, r15, r115, r114, r116, r117);
    L26:
        if (r1.hasCapability(11) == true) goto L28;
        r15 = true;
        goto L29
    L41:
        if (r5.getType() == 1) goto L43;
    L53:
        final boolean r26 = true;
        final int r27 = r5.getType();
        final int r28 = r5.getSubtype();
        final boolean r29 = false;
        final String r30 = null;
        final List r31 = null;
        final boolean r32 = false;
        final String r118 = "";
        return new NetworkChangeNotifierAutoDetect$NetworkState(r26, r27, r28, r29, r30, r31, r32, r118);
    L43:
        if (Build.VERSION.SDK_INT >= 23) goto L53;
        if (r23 == null) goto L53;
        if (com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate_android_net_NetworkInfo_getExtraInfo(r5) != null) goto L48;
    L51:
        final boolean r119 = true;
        final int r120 = r5.getType();
        final int r121 = r5.getSubtype();
        final boolean r122 = false;
        final String r123 = r23.getWifiSsid();
        final List r124 = null;
        final boolean r125 = false;
        final String r210 = "";
        return new NetworkChangeNotifierAutoDetect$NetworkState(r119, r120, r121, r122, r123, r124, r125, r210);
    L48:
        if ("".equals(com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate_android_net_NetworkInfo_getExtraInfo(r5)) == true) goto L51;
        final boolean r33 = true;
        final int r34 = r5.getType();
        final int r35 = r5.getSubtype();
        final boolean r36 = false;
        final String r37 = com_ttnet_org_chromium_net_NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate_android_net_NetworkInfo_getExtraInfo(r5);
        final List r38 = null;
        final boolean r126 = false;
        final String r127 = "";
        return new NetworkChangeNotifierAutoDetect$NetworkState(r33, r34, r35, r36, r37, r38, r126, r127);
    L4:
        if (Build.VERSION.SDK_INT < 23) goto L14;
        r4 = getDefaultNetwork();     // Catch: Throwable -> L16
        NetworkInfo r39 = getNetworkInfo(r4);     // Catch: Throwable -> L13
        if (r39 != null) goto L9;
    L12:
        r3 = r4;
        NetworkInfo r40 = r39;
    L15:
        NetworkInfo r211 = r40;
        r4 = r3;
        r2 = r211;
        goto L17
    L9:
        if (r39.getType() != 17) goto L12;
        r40 = this.mConnectivityManager.getActiveNetworkInfo();     // Catch: Throwable -> L13
        r3 = r4;
        goto L15
    L14:
        r40 = this.mConnectivityManager.getActiveNetworkInfo();     // Catch: Throwable -> L16
        goto L15
    }

    public NetworkInfo getRawNetworkInfo(Network r2) {
        return this.mConnectivityManager.getNetworkInfo(r2);
    L4:
        return this.mConnectivityManager.getNetworkInfo(r2);
    L6:
        return null;
    }

    public void unregisterNetworkCallback(ConnectivityManager.NetworkCallback r2) {
        this.mConnectivityManager.unregisterNetworkCallback(r2);     // Catch: Throwable -> L4
        return;
    }

    public boolean vpnAccessible(Network r3) {
        Socket r0 = new Socket();
        StrictModeContext r1 = StrictModeContext.allowAllVmPolicies();     // Catch: Throwable -> L17 IOException -> L20
        r3.bindSocket(r0);     // Catch: Throwable -> L10
        if (r1 == null) goto L30;
        r1.close();     // Catch: Throwable -> L17 IOException -> L20
    L30:
        r0.close();     // Catch: IOException -> L23
        return true;
    L36:
        return true;
    L10:
        th = move-exception;
        if (r1 != null) goto L32;
    L16:
        throw th;     // Catch: Throwable -> L17 IOException -> L20
    L32:
        r1.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L17 IOException -> L20
    L20:
        r0.close();     // Catch: IOException -> L25
        return false;
    L17:
        th = move-exception;
        r0.close();     // Catch: IOException -> L24
    L19:
        throw th;
    L37:
        return false;
    }

    public void registerDefaultNetworkCallback(ConnectivityManager.NetworkCallback r2, Handler r3) {
        ApiHelperForO.registerDefaultNetworkCallback(this.mConnectivityManager, r2, r3);     // Catch: Throwable -> L4
        return;
    }

    public void registerNetworkCallback(NetworkRequest r3, ConnectivityManager.NetworkCallback r4, Handler r5) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        ApiHelperForO.registerNetworkCallback(this.mConnectivityManager, r3, r4, r5);     // Catch: Throwable -> L7
    L8:
        return;
    L5:
        this.mConnectivityManager.registerNetworkCallback(r3, r4);     // Catch: Throwable -> L7
    }
}
