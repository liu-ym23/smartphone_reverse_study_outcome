package com.ttnet.org.chromium.net;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.RouteInfo;
import android.net.TrafficStats;
import android.net.TransportInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.ttnet.org.chromium.base.ApiCompatibilityUtils;
import com.ttnet.org.chromium.base.CollectionUtil;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForN;
import com.ttnet.org.chromium.base.compat.ApiHelperForP;
import com.ttnet.org.chromium.base.compat.ApiHelperForQ;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketImpl;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
@MainDex
class AndroidNetworkLibrary {
    private static final String TAG = "AndroidNetworkLibrary";
    private static Boolean sHaveAccessLocationState;
    private static Boolean sHaveAccessNetworkState;
    private static Boolean sHaveAccessWifiState;

    interface Natives {
        void onCellularAlwaysUp(boolean r1, int r2);
    }

    public static class NetworkSecurityPolicyProxy {
        private static NetworkSecurityPolicyProxy sInstance;

        static {
            sInstance = new NetworkSecurityPolicyProxy();
        }

        public NetworkSecurityPolicyProxy() {
        }

        public static NetworkSecurityPolicyProxy getInstance() {
            return sInstance;
        }

        public static void setInstanceForTesting(NetworkSecurityPolicyProxy r0) {
            sInstance = r0;
        }

        public boolean isCleartextTrafficPermitted() {
            if (Build.VERSION.SDK_INT >= 23) goto L7;
            return true;
        L7:
            return ApiHelperForM.isCleartextTrafficPermitted();
        }

        public boolean isCleartextTrafficPermitted(String r3) {
            if (Build.VERSION.SDK_INT >= 24) goto L7;
            return isCleartextTrafficPermitted();
        L7:
            return ApiHelperForN.isCleartextTrafficPermitted(r3);
        }
    }

    private static class SetFileDescriptor {
        private static final Method sFileDescriptorSetInt = null;

        static {
            sFileDescriptorSetInt = FileDescriptor.class.getMethod("setInt$", new Class[]{Integer.TYPE});     // Catch: Throwable -> L4
            return;
        L4:
            e = move-exception;
            throw new RuntimeException("Unable to get FileDescriptor.setInt$", e);
        }

        private SetFileDescriptor() {
        }

        public static FileDescriptor createWithFd(int r5) {
            FileDescriptor r1 = new FileDescriptor();     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L8
            sFileDescriptorSetInt.invoke(r1, new Object[]{Integer.valueOf(r5)});     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L8
            return r1;
        L8:
            e = move-exception;
            throw new RuntimeException("FileDescriptor.setInt$() failed", e);
        L5:
            e = move-exception;
            throw new RuntimeException("FileDescriptor.setInt$() failed", e);
        }
    }

    private static class SocketFd extends Socket {

        private static class SocketImplFd extends SocketImpl {
            SocketImplFd(FileDescriptor r1) {
                this.fd = r1;
            }

            @Override // java.net.SocketImpl
            public void accept(SocketImpl r1) {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            public int available() {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            public void bind(InetAddress r1, int r2) {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            public void close() {
            }

            @Override // java.net.SocketImpl
            public void connect(String r1, int r2) {
                throw new RuntimeException("connect not implemented");
            }

            @Override // java.net.SocketImpl
            public void connect(InetAddress r1, int r2) {
                throw new RuntimeException("connect not implemented");
            }

            @Override // java.net.SocketImpl
            public void connect(SocketAddress r1, int r2) {
                throw new RuntimeException("connect not implemented");
            }

            @Override // java.net.SocketImpl
            public void create(boolean r1) {
            }

            @Override // java.net.SocketImpl
            public InputStream getInputStream() {
                throw new RuntimeException("getInputStream not implemented");
            }

            @Override // java.net.SocketOptions
            public Object getOption(int r1) {
                throw new RuntimeException("getOption not implemented");
            }

            @Override // java.net.SocketImpl
            public OutputStream getOutputStream() {
                throw new RuntimeException("getOutputStream not implemented");
            }

            @Override // java.net.SocketImpl
            public void listen(int r1) {
                throw new RuntimeException("listen not implemented");
            }

            @Override // java.net.SocketImpl
            public void sendUrgentData(int r1) {
                throw new RuntimeException("sendUrgentData not implemented");
            }

            @Override // java.net.SocketOptions
            public void setOption(int r1, Object r2) {
                throw new RuntimeException("setOption not implemented");
            }
        }

        SocketFd(FileDescriptor r2) {
            super(new SocketImplFd(r2));
        }
    }

    AndroidNetworkLibrary() {
    }

    public static void addTestRootCertificate(byte[] r0) {
        X509Util.addTestRootCertificate(r0);
    }

    private static void alwaysUpCellularOnThreadPool() {
        if (Build.VERSION.SDK_INT >= 21) goto L6;
        AndroidNetworkLibraryJni.get().onCellularAlwaysUp(false, 0);
        return;
    L6:
        final ConnectivityManager r0 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        AndroidNetworkLibraryJni.get().onCellularAlwaysUp(false, 7);
        return;
    L10:
        NetworkRequest r2 = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        r0.requestNetwork(r2, new AnonymousClass1(r0));     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        AndroidNetworkLibraryJni.get().onCellularAlwaysUp(false, 9);
    }

    private static boolean checkIsVpnOn() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return false;
    L5:
        ConnectivityManager r0 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
        return false;
    L8:
        Network[] r2 = r0.getAllNetworks();
        int r3 = 0;
    L10:
        if (r3 >= r2.length) goto L18;
        if (r0.getNetworkInfo(r2[r3]).isConnected() == false) goto L17;
        if (r0.getNetworkCapabilities(r2[r3]).hasTransport(4) == false) goto L17;
        return true;
    L17:
        r3 = r3 + 1;
        goto L10
    L18:
        return false;
    }

    public static void clearTestRootCertificates() {
        X509Util.clearTestRootCertificates();
    }

    private static int frequencyToChannel(int r1) {
        if (r1 != 2484) goto L6;
        return 14;
    L6:
        if (r1 >= 2484) goto L10;
        return (r1 - 2407) / 5;
    L10:
        if (r1 < 4910) goto L16;
        if (r1 > 4980) goto L16;
        return (r1 - 4000) / 5;
    L16:
        if (r1 >= 5925) goto L20;
        return (r1 - 5000) / 5;
    L20:
        if (r1 != 5935) goto L24;
        return 2;
    L24:
        if (r1 > 45000) goto L28;
        return (r1 - 5950) / 5;
    L28:
        if (r1 >= 58320) goto L30;
        return -1;
    L30:
        if (r1 <= 70200) goto L32;
        return -1;
    L32:
        return (r1 - 56160) / 2160;
    }

    public static int[] getAllAccessPointChannels() {
        if (haveAccessLocationState() == false) goto L25;
        if (haveAccessWifiState() == false) goto L25;
        WifiManager r0 = (WifiManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI), WifiManager.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L10;
        List<ScanResult> r1 = r0.getScanResults();
        if (r1 == null) goto L23;
        if (r1.isEmpty() == true) goto L23;
        ArrayList r2 = new ArrayList();
        Iterator<ScanResult> r3 = r1.iterator();
    L18:
        if (r3.hasNext() == false) goto L21;
        r2.add(Integer.valueOf(frequencyToChannel(((ScanResult) ZeusTransformUtils.preCheckCast(r3.next(), ScanResult.class, "com.obric.memorydata.plugin")).frequency)));
        goto L18
    L21:
        return CollectionUtil.integerListToIntArray(r2);
    L23:
        return new int[0];
    L10:
        return new int[0];
    L25:
        return new int[0];
    }

    public static String[][] getAllRouteInfo() {
        if (haveAccessNetworkState() == true) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT >= 21) goto L33;
        return null;
    L33:
        ConnectivityManager r1 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        if (r1 != null) goto L11;
        return null;
    L11:
        Network[] r3 = r1.getAllNetworks();     // Catch: Throwable -> L30
        ArrayList r4 = new ArrayList();     // Catch: Throwable -> L30
        int r5 = r3.length;     // Catch: Throwable -> L30
        int r7 = 0;
    L13:
        if (r7 >= r5) goto L28;
        LinkProperties r10 = r1.getLinkProperties(r3[r7]);     // Catch: Throwable -> L30
        if (r10 == null) goto L27;
        Iterator<RouteInfo> r11 = r10.getRoutes().iterator();     // Catch: Throwable -> L30
    L19:
        if (r11.hasNext() == false) goto L27;
        RouteInfo r12 = (RouteInfo) ZeusTransformUtils.preCheckCast(r11.next(), RouteInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        String[] r13 = new String[4];     // Catch: Throwable -> L30
        if (r12.getDestination() == null) goto L24;
        r13[0] = r12.getDestination().getAddress().getHostAddress();     // Catch: Throwable -> L30
        r13[1] = Integer.toString(r12.getDestination().getPrefixLength());     // Catch: Throwable -> L30
    L24:
        if (r12.getGateway() == null) goto L26;
        r13[2] = r12.getGateway().getHostAddress();     // Catch: Throwable -> L30
    L26:
        r13[3] = r12.getInterface();     // Catch: Throwable -> L30
        r4.add(r13);     // Catch: Throwable -> L30
    L27:
        r7 = r7 + 1;     // Catch: Throwable -> L30
        goto L13
    L28:
        return (String[][]) ZeusTransformUtils.preCheckCast(r4.toArray((String[][]) Array.newInstance(String.class, new int[]{0, 0})), String[][].class, "com.obric.memorydata.plugin");
    L30:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static int getCurrentAccessPointChannel() {
        if (TTAppSecurityManager.getInstance().isTTPRestrictionEnabled() == false) goto L7;
        int r0 = TTAppSecurityManager.getInstance().getWifiFrequency();
    L6:
        return frequencyToChannel(r0);
    L7:
        WifiInfo r1 = getWifiInfo();
        if (r1 != null) goto L11;
        return -1;
    L11:
        r0 = r1.getFrequency();
        goto L6
    }

    public static DnsStatus getCurrentDnsStatus() {
        return getDnsStatus(null);
    }

    public static int[] getDhcpInfo() {
        if (TTAppSecurityManager.getInstance().isUserPrivacyRestrictionEnabled() == true) goto L5;
        WifiManager r0 = (WifiManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI), WifiManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r0 == null) goto L15;
        DhcpInfo r1 = r0.getDhcpInfo();     // Catch: Throwable -> L12
        if (r1 == null) goto L15;
        return new int[]{r1.ipAddress, r1.gateway};
    L15:
        return new int[0];
    L12:
        th = move-exception;
        th.printStackTrace();
        goto L15
    L5:
        return new int[0];
    }

    public static DnsStatus getDnsStatus(Network r4) {
        if (haveAccessNetworkState() == true) goto L5;
        return null;
    L5:
        ConnectivityManager r0 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
        return null;
    L8:
        if (r4 != null) goto L10;
        r4 = ApiHelperForM.getActiveNetwork(r0);
    L10:
        if (r4 != null) goto L22;
        return null;
    L22:
        LinkProperties r5 = r0.getLinkProperties(r4);     // Catch: RuntimeException -> L21
        if (r5 != null) goto L15;
        return null;
    L15:
        List<InetAddress> r1 = r5.getDnsServers();
        String r2 = r5.getDomains();
        if (Build.VERSION.SDK_INT < 28) goto L20;
        return new DnsStatus(r1, ApiHelperForP.isPrivateDnsActive(r5), ApiHelperForP.getPrivateDnsServerName(r5), r2);
    L20:
        return new DnsStatus(r1, false, "", r2);
    L21:
        return null;
    }

    public static DnsStatus getDnsStatusForNetwork(long r0) {
        return getDnsStatus(Network.fromNetworkHandle(r0));
    L4:
        return null;
    }

    private static boolean getIsCaptivePortal() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return false;
    L5:
        ConnectivityManager r0 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
        return false;
    L8:
        Network r2 = ApiHelperForM.getActiveNetwork(r0);
        if (r2 != null) goto L11;
        return false;
    L11:
        NetworkCapabilities r1 = r0.getNetworkCapabilities(r2);
        if (r1 != null) goto L14;
        return false;
    L14:
        if (r1.hasCapability(17) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public static String getMimeTypeFromExtension(String r2) {
        return URLConnection.guessContentTypeFromName("foo." + r2);
    }

    private static String getNetworkOperator() {
        if (TTAppSecurityManager.getInstance().isTTPRestrictionEnabled() == true) goto L5;
        TelephonyManager r1 = (TelephonyManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(MemoryKeyInfoEntity.KEY_PHONE), TelephonyManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getNetworkOperator();
    L11:
        th = move-exception;
        th.printStackTrace();
        return "";
    L5:
        return TTAppSecurityManager.getInstance().getNetworkOperator();
    }

    private static String getSimOperator() {
        if (TTAppSecurityManager.getInstance().isTTPRestrictionEnabled() == true) goto L5;
        TelephonyManager r1 = (TelephonyManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(MemoryKeyInfoEntity.KEY_PHONE), TelephonyManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getSimOperator();
    L11:
        th = move-exception;
        th.printStackTrace();
        return "";
    L5:
        return TTAppSecurityManager.getInstance().getSimOperator();
    }

    private static WifiInfo getWifiInfo() {
        if (haveAccessWifiState() == true) goto L5;
        Intent r0 = ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), null, new IntentFilter("android.net.wifi.STATE_CHANGE"), "com.obric.memorydata.plugin");
        if (r0 != null) goto L25;
        return null;
    L25:
        return (WifiInfo) ZeusTransformUtils.preCheckCast(r0.getParcelableExtra("wifiInfo"), WifiInfo.class, "com.obric.memorydata.plugin");
    L5:
        if (Build.VERSION.SDK_INT < 31) goto L21;
        ConnectivityManager r1 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");
        Network[] r3 = r1.getAllNetworks();
        int r4 = r3.length;
        int r5 = 0;
    L7:
        if (r5 >= r4) goto L19;
        NetworkCapabilities r6 = r1.getNetworkCapabilities(r3[r5]);
        if (r6 == null) goto L18;
        if (r6.hasTransport(1) == false) goto L18;
        TransportInfo r7 = ApiHelperForQ.getTransportInfo(r6);
        if (r7 == null) goto L18;
        if (ZeusTransformUtils.instanceOf(r7, WifiInfo.class) == false) goto L18;
        return (WifiInfo) ZeusTransformUtils.preCheckCast(r7, WifiInfo.class, "com.obric.memorydata.plugin");
    L18:
        r5 = r5 + 1;
        goto L7
    L19:
        return null;
    L21:
        return ((WifiManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI), WifiManager.class, "com.obric.memorydata.plugin")).getConnectionInfo();
    }

    public static String getWifiSSID() {
        return "";
    }

    public static int getWifiSignalLevel(int r7) {
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) != null) goto L6;
        return -1;
    L6:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver() != null) goto L9;
        return -1;
    L9:
        if (TTAppSecurityManager.getInstance().isTTPRestrictionEnabled() == false) goto L12;
        int r0 = TTAppSecurityManager.getInstance().getWifiRssi();
    L21:
        if (r0 != Integer.MIN_VALUE) goto L23;
        return -1;
    L23:
        int r1 = WifiManager.calculateSignalLevel(r0, r7);
        if (r1 < 0) goto L28;
        if (r1 >= r7) goto L28;
        return r1;
    L28:
        return -1;
    L12:
        if (haveAccessWifiState() == false) goto L30;
        WifiInfo r2 = getWifiInfo();
        if (r2 != null) goto L16;
        return -1;
    L16:
        r0 = r2.getRssi();
        goto L21
    L30:
        Intent r3 = ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), null, new IntentFilter("android.net.wifi.RSSI_CHANGED"), "com.obric.memorydata.plugin");     // Catch: IllegalArgumentException -> L29
        if (r3 != null) goto L20;
        return -1;
    L20:
        r0 = r3.getIntExtra("newRssi", Integer.MIN_VALUE);
        goto L21
    }

    private static boolean hasPermission(Context r2, String r3) {
        if (ApiCompatibilityUtils.checkPermission((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, Process.myPid(), Process.myUid()) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean haveAccessLocationState() {
        if (sHaveAccessLocationState != null) goto L16;
        if (Build.VERSION.SDK_INT < 29) goto L9;
        boolean r0 = hasPermission((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "android.permission.ACCESS_FINE_LOCATION");
    L7:
        sHaveAccessLocationState = Boolean.valueOf(r0);
        goto L16
    L9:
        if (hasPermission((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "android.permission.ACCESS_COARSE_LOCATION") == false) goto L11;
    L14:
        r0 = true;
        goto L7
    L11:
        if (hasPermission((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "android.permission.ACCESS_FINE_LOCATION") == true) goto L14;
        r0 = false;
    L16:
        return sHaveAccessLocationState.booleanValue();
    }

    private static boolean haveAccessNetworkState() {
        if (sHaveAccessNetworkState != null) goto L6;
        sHaveAccessNetworkState = Boolean.valueOf(hasPermission((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "android.permission.ACCESS_NETWORK_STATE"));
    L6:
        return sHaveAccessNetworkState.booleanValue();
    }

    private static boolean haveAccessWifiState() {
        if (sHaveAccessWifiState != null) goto L6;
        sHaveAccessWifiState = Boolean.valueOf(hasPermission((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "android.permission.ACCESS_WIFI_STATE"));
    L6:
        return sHaveAccessWifiState.booleanValue();
    }

    public static boolean haveOnlyLoopbackAddresses() {
        Enumeration<NetworkInterface> r1 = NetworkInterface.getNetworkInterfaces();     // Catch: Exception -> L16
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.hasMoreElements() == false) goto L14;
        NetworkInterface r2 = (NetworkInterface) ZeusTransformUtils.preCheckCast(r1.nextElement(), NetworkInterface.class, "com.obric.memorydata.plugin");
        if (r2.isUp() == false) goto L7;
        if (r2.isLoopback() == true) goto L7;
        return false;
    L14:
        return true;
    L16:
        e = move-exception;
        Log.w(TAG, "could not get network interfaces: " + e);
        return false;
    }

    private static boolean isCleartextPermitted(String r1) {
        return NetworkSecurityPolicyProxy.getInstance().isCleartextTrafficPermitted(r1);
    L5:
        return NetworkSecurityPolicyProxy.getInstance().isCleartextTrafficPermitted();
    }

    private static boolean reportBadDefaultNetwork() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return false;
    L5:
        ConnectivityManager r0 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
        return false;
    L8:
        ApiHelperForM.reportNetworkConnectivity(r0, null, false);
        return true;
    }

    public static void setWifiEnabled(boolean r3) {
        ((WifiManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI), WifiManager.class, "com.obric.memorydata.plugin")).setWifiEnabled(r3);
    }

    private static void tagSocket(int r4, int r5, int r6) {
        int r0 = TrafficStats.getThreadStatsTag();
        if (r6 == r0) goto L6;
        TrafficStats.setThreadStatsTag(r6);
    L6:
        if (r5 == (-1)) goto L9;
        ThreadStatsUid.set(r5);
    L9:
        if (Build.VERSION.SDK_INT >= 23) goto L11;
        ParcelFileDescriptor r2 = null;
        FileDescriptor r7 = SetFileDescriptor.createWithFd(r4);
    L12:
        SocketFd r3 = new SocketFd(r7);
        TrafficStats.tagSocket(r3);
        r3.close();
        if (r2 == null) goto L15;
        r2.detachFd();
    L15:
        if (r6 == r0) goto L17;
        TrafficStats.setThreadStatsTag(r0);
    L17:
        if (r5 == (-1)) goto L20;
        ThreadStatsUid.clear();
        return;
    L20:
        return;
    L11:
        r2 = ParcelFileDescriptor.adoptFd(r4);
        r7 = r2.getFileDescriptor();
        goto L12
    }

    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] r1, String r2, String r3) {
        return X509Util.verifyServerCertificates(r1, r2, r3);
    L6:
        return new AndroidCertVerifyResult(-1);
    L10:
        return new AndroidCertVerifyResult(-1);
    L8:
        return new AndroidCertVerifyResult(-1);
    }
}
