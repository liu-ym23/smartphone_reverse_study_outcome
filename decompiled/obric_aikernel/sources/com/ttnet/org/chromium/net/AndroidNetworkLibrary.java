package com.ttnet.org.chromium.net;

import android.annotation.TargetApi;
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
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.ApiCompatibilityUtils;
import com.ttnet.org.chromium.base.CollectionUtil;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.CalledByNativeUnchecked;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForN;
import com.ttnet.org.chromium.base.compat.ApiHelperForP;
import com.ttnet.org.chromium.base.compat.ApiHelperForQ;
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

/* JADX INFO: loaded from: classes2.dex */
@MainDex
class AndroidNetworkLibrary {
    private static final String TAG = "AndroidNetworkLibrary";
    private static Boolean sHaveAccessLocationState;
    private static Boolean sHaveAccessNetworkState;
    private static Boolean sHaveAccessWifiState;

    interface Natives {
        void onCellularAlwaysUp(boolean r10, int r11);
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

        @VisibleForTesting
        public static void setInstanceForTesting(NetworkSecurityPolicyProxy r10) {
            sInstance = r10;
        }

        @RequiresApi(23)
        public boolean isCleartextTrafficPermitted() {
            if (Build.VERSION.SDK_INT >= 23) goto L7;
            return true;
        L7:
            return ApiHelperForM.isCleartextTrafficPermitted();
        }

        @RequiresApi(24)
        public boolean isCleartextTrafficPermitted(String r10) {
            if (Build.VERSION.SDK_INT >= 24) goto L7;
            return isCleartextTrafficPermitted();
        L7:
            return ApiHelperForN.isCleartextTrafficPermitted(r10);
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

        public static FileDescriptor createWithFd(int r10) {
            FileDescriptor r11 = new FileDescriptor();     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L8
            sFileDescriptorSetInt.invoke(r11, new Object[]{Integer.valueOf(r10)});     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L8
            return r11;
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
            SocketImplFd(FileDescriptor r10) {
                ((SocketImpl) this).fd = r10;
            }

            @Override // java.net.SocketImpl
            protected void accept(SocketImpl r10) {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            protected int available() {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            protected void bind(InetAddress r10, int r11) {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            protected void close() {
            }

            @Override // java.net.SocketImpl
            protected void connect(String r10, int r11) {
                throw new RuntimeException("connect not implemented");
            }

            @Override // java.net.SocketImpl
            protected void connect(InetAddress r10, int r11) {
                throw new RuntimeException("connect not implemented");
            }

            @Override // java.net.SocketImpl
            protected void connect(SocketAddress r10, int r11) {
                throw new RuntimeException("connect not implemented");
            }

            @Override // java.net.SocketImpl
            protected void create(boolean r10) {
            }

            @Override // java.net.SocketImpl
            protected InputStream getInputStream() {
                throw new RuntimeException("getInputStream not implemented");
            }

            @Override // java.net.SocketOptions
            public Object getOption(int r10) {
                throw new RuntimeException("getOption not implemented");
            }

            @Override // java.net.SocketImpl
            protected OutputStream getOutputStream() {
                throw new RuntimeException("getOutputStream not implemented");
            }

            @Override // java.net.SocketImpl
            protected void listen(int r10) {
                throw new RuntimeException("listen not implemented");
            }

            @Override // java.net.SocketImpl
            protected void sendUrgentData(int r10) {
                throw new RuntimeException("sendUrgentData not implemented");
            }

            @Override // java.net.SocketOptions
            public void setOption(int r10, Object r11) {
                throw new RuntimeException("setOption not implemented");
            }
        }

        SocketFd(FileDescriptor r10) {
            super(new SocketImplFd(r10));
        }
    }

    AndroidNetworkLibrary() {
    }

    @CalledByNativeUnchecked
    public static void addTestRootCertificate(byte[] r10) {
        X509Util.addTestRootCertificate(r10);
    }

    @CalledByNative
    @TargetApi(21)
    private static void alwaysUpCellularOnThreadPool() {
        if (Build.VERSION.SDK_INT >= 21) goto L6;
        AndroidNetworkLibraryJni.get().onCellularAlwaysUp(false, 0);
        return;
    L6:
        final ConnectivityManager r10 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (r10 != null) goto L10;
        AndroidNetworkLibraryJni.get().onCellularAlwaysUp(false, 7);
        return;
    L10:
        NetworkRequest r11 = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        r10.requestNetwork(r11, new AnonymousClass1(r10));     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        AndroidNetworkLibraryJni.get().onCellularAlwaysUp(false, 9);
    }

    @CalledByNative
    @TargetApi(21)
    private static boolean checkIsVpnOn() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return false;
    L5:
        ConnectivityManager r10 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (r10 != null) goto L8;
        return false;
    L8:
        Network[] r11 = r10.getAllNetworks();
        int r12 = 0;
    L10:
        if (r12 >= r11.length) goto L18;
        if (r10.getNetworkInfo(r11[r12]).isConnected() == false) goto L17;
        if (r10.getNetworkCapabilities(r11[r12]).hasTransport(4) == false) goto L17;
        return true;
    L17:
        r12 = r12 + 1;
        goto L10
    L18:
        return false;
    }

    @CalledByNativeUnchecked
    public static void clearTestRootCertificates() {
        X509Util.clearTestRootCertificates();
    }

    private static int frequencyToChannel(int r10) {
        if (r10 != 2484) goto L6;
        return 14;
    L6:
        if (r10 >= 2484) goto L10;
        return (r10 - 2407) / 5;
    L10:
        if (r10 < 4910) goto L16;
        if (r10 > 4980) goto L16;
        return (r10 - 4000) / 5;
    L16:
        if (r10 >= 5925) goto L20;
        return (r10 - 5000) / 5;
    L20:
        if (r10 != 5935) goto L24;
        return 2;
    L24:
        if (r10 > 45000) goto L28;
        return (r10 - 5950) / 5;
    L28:
        if (r10 >= 58320) goto L30;
        return -1;
    L30:
        if (r10 <= 70200) goto L32;
        return -1;
    L32:
        return (r10 - 56160) / 2160;
    }

    @CalledByNative
    public static int[] getAllAccessPointChannels() {
        if (haveAccessLocationState() == false) goto L25;
        if (haveAccessWifiState() == false) goto L25;
        WifiManager r10 = (WifiManager) ContextUtils.getApplicationContext().getSystemService("wifi");
        if (r10 == null) goto L10;
        List<ScanResult> r11 = r10.getScanResults();
        if (r11 == null) goto L23;
        if (r11.isEmpty() == true) goto L23;
        ArrayList r12 = new ArrayList();
        Iterator<ScanResult> r13 = r11.iterator();
    L18:
        if (r13.hasNext() == false) goto L21;
        r12.add(Integer.valueOf(frequencyToChannel(r13.next().frequency)));
        goto L18
    L21:
        return CollectionUtil.integerListToIntArray(r12);
    L23:
        return new int[0];
    L10:
        return new int[0];
    L25:
        return new int[0];
    }

    @CalledByNative
    public static String[][] getAllRouteInfo() {
        if (haveAccessNetworkState() == true) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT >= 21) goto L33;
        return null;
    L33:
        ConnectivityManager r10 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");     // Catch: Throwable -> L30
        if (r10 != null) goto L11;
        return null;
    L11:
        Network[] r11 = r10.getAllNetworks();     // Catch: Throwable -> L30
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L30
        int r13 = r11.length;     // Catch: Throwable -> L30
        int r14 = 0;
    L13:
        if (r14 >= r13) goto L28;
        LinkProperties r15 = r10.getLinkProperties(r11[r14]);     // Catch: Throwable -> L30
        if (r15 == null) goto L27;
        Iterator<RouteInfo> r16 = r15.getRoutes().iterator();     // Catch: Throwable -> L30
    L19:
        if (r16.hasNext() == false) goto L27;
        RouteInfo r17 = r16.next();     // Catch: Throwable -> L30
        String[] r18 = new String[4];     // Catch: Throwable -> L30
        if (r17.getDestination() == null) goto L24;
        r18[0] = r17.getDestination().getAddress().getHostAddress();     // Catch: Throwable -> L30
        r18[1] = Integer.toString(r17.getDestination().getPrefixLength());     // Catch: Throwable -> L30
    L24:
        if (r17.getGateway() == null) goto L26;
        r18[2] = r17.getGateway().getHostAddress();     // Catch: Throwable -> L30
    L26:
        r18[3] = r17.getInterface();     // Catch: Throwable -> L30
        r12.add(r18);     // Catch: Throwable -> L30
    L27:
        r14 = r14 + 1;     // Catch: Throwable -> L30
        goto L13
    L28:
        return (String[][]) r12.toArray((String[][]) Array.newInstance(String.class, new int[]{0, 0}));
    L30:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @CalledByNative
    public static int getCurrentAccessPointChannel() {
        if (TTAppSecurityManager.getInstance().isTTPRestrictionEnabled() == false) goto L7;
        int r10 = TTAppSecurityManager.getInstance().getWifiFrequency();
    L6:
        return frequencyToChannel(r10);
    L7:
        WifiInfo r11 = getWifiInfo();
        if (r11 != null) goto L11;
        return -1;
    L11:
        r10 = r11.getFrequency();
        goto L6
    }

    @RequiresApi(23)
    @CalledByNative
    public static DnsStatus getCurrentDnsStatus() {
        return getDnsStatus(null);
    }

    @CalledByNative
    public static int[] getDhcpInfo() {
        if (TTAppSecurityManager.getInstance().isUserPrivacyRestrictionEnabled() == true) goto L5;
        WifiManager r10 = (WifiManager) ContextUtils.getApplicationContext().getSystemService("wifi");     // Catch: Throwable -> L12
        if (r10 == null) goto L15;
        DhcpInfo r11 = r10.getDhcpInfo();     // Catch: Throwable -> L12
        if (r11 == null) goto L15;
        return new int[]{r11.ipAddress, r11.gateway};
    L15:
        return new int[0];
    L12:
        th = move-exception;
        th.printStackTrace();
        goto L15
    L5:
        return new int[0];
    }

    @RequiresApi(23)
    public static DnsStatus getDnsStatus(Network r10) {
        if (haveAccessNetworkState() == true) goto L5;
        return null;
    L5:
        ConnectivityManager r11 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (r11 != null) goto L8;
        return null;
    L8:
        if (r10 != null) goto L10;
        r10 = ApiHelperForM.getActiveNetwork(r11);
    L10:
        if (r10 != null) goto L22;
        return null;
    L22:
        LinkProperties r12 = r11.getLinkProperties(r10);     // Catch: RuntimeException -> L21
        if (r12 != null) goto L15;
        return null;
    L15:
        List<InetAddress> r13 = r12.getDnsServers();
        String r14 = r12.getDomains();
        if (Build.VERSION.SDK_INT < 28) goto L20;
        return new DnsStatus(r13, ApiHelperForP.isPrivateDnsActive(r12), ApiHelperForP.getPrivateDnsServerName(r12), r14);
    L20:
        return new DnsStatus(r13, false, "", r14);
    L21:
        return null;
    }

    @RequiresApi(28)
    @CalledByNative
    public static DnsStatus getDnsStatusForNetwork(long r10) {
        return getDnsStatus(Network.fromNetworkHandle(r10));
    L4:
        return null;
    }

    @RequiresApi(23)
    @CalledByNative
    private static boolean getIsCaptivePortal() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return false;
    L5:
        ConnectivityManager r10 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (r10 != null) goto L8;
        return false;
    L8:
        Network r11 = ApiHelperForM.getActiveNetwork(r10);
        if (r11 != null) goto L11;
        return false;
    L11:
        NetworkCapabilities r12 = r10.getNetworkCapabilities(r11);
        if (r12 != null) goto L14;
        return false;
    L14:
        if (r12.hasCapability(17) == false) goto L18;
        return true;
    L18:
        return false;
    }

    @CalledByNative
    public static String getMimeTypeFromExtension(String r10) {
        return URLConnection.guessContentTypeFromName("foo." + r10);
    }

    @CalledByNative
    private static String getNetworkOperator() {
        if (TTAppSecurityManager.getInstance().isTTPRestrictionEnabled() == true) goto L5;
        TelephonyManager r10 = (TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone");     // Catch: Throwable -> L11
        if (r10 != null) goto L9;
        return "";
    L9:
        return r10.getNetworkOperator();
    L11:
        th = move-exception;
        th.printStackTrace();
        return "";
    L5:
        return TTAppSecurityManager.getInstance().getNetworkOperator();
    }

    @CalledByNative
    private static String getSimOperator() {
        if (TTAppSecurityManager.getInstance().isTTPRestrictionEnabled() == true) goto L5;
        TelephonyManager r10 = (TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone");     // Catch: Throwable -> L11
        if (r10 != null) goto L9;
        return "";
    L9:
        return r10.getSimOperator();
    L11:
        th = move-exception;
        th.printStackTrace();
        return "";
    L5:
        return TTAppSecurityManager.getInstance().getSimOperator();
    }

    private static WifiInfo getWifiInfo() {
        if (haveAccessWifiState() == true) goto L5;
        Intent r10 = ContextUtils.getApplicationContext().registerReceiver(null, new IntentFilter("android.net.wifi.STATE_CHANGE"));
        if (r10 != null) goto L25;
        return null;
    L25:
        return (WifiInfo) r10.getParcelableExtra("wifiInfo");
    L5:
        if (Build.VERSION.SDK_INT < 31) goto L21;
        ConnectivityManager r11 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        Network[] r12 = r11.getAllNetworks();
        int r13 = r12.length;
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L19;
        NetworkCapabilities r15 = r11.getNetworkCapabilities(r12[r14]);
        if (r15 == null) goto L18;
        if (r15.hasTransport(1) == false) goto L18;
        TransportInfo r16 = ApiHelperForQ.getTransportInfo(r15);
        if (r16 == null) goto L18;
        if ((r16 instanceof WifiInfo) == false) goto L18;
        return (WifiInfo) r16;
    L18:
        r14 = r14 + 1;
        goto L7
    L19:
        return null;
    L21:
        return ((WifiManager) ContextUtils.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
    }

    @CalledByNative
    public static String getWifiSSID() {
        return "";
    }

    @CalledByNative
    public static int getWifiSignalLevel(int r10) {
        if (ContextUtils.getApplicationContext() != null) goto L6;
        return -1;
    L6:
        if (ContextUtils.getApplicationContext().getContentResolver() != null) goto L9;
        return -1;
    L9:
        if (TTAppSecurityManager.getInstance().isTTPRestrictionEnabled() == false) goto L12;
        int r11 = TTAppSecurityManager.getInstance().getWifiRssi();
    L21:
        if (r11 != Integer.MIN_VALUE) goto L23;
        return -1;
    L23:
        int r12 = WifiManager.calculateSignalLevel(r11, r10);
        if (r12 < 0) goto L28;
        if (r12 >= r10) goto L28;
        return r12;
    L28:
        return -1;
    L12:
        if (haveAccessWifiState() == false) goto L30;
        WifiInfo r13 = getWifiInfo();
        if (r13 != null) goto L16;
        return -1;
    L16:
        r11 = r13.getRssi();
        goto L21
    L30:
        Intent r14 = ContextUtils.getApplicationContext().registerReceiver(null, new IntentFilter("android.net.wifi.RSSI_CHANGED"));     // Catch: IllegalArgumentException -> L29
        if (r14 != null) goto L20;
        return -1;
    L20:
        r11 = r14.getIntExtra("newRssi", Integer.MIN_VALUE);
        goto L21
    }

    private static boolean hasPermission(Context r10, String r11) {
        if (ApiCompatibilityUtils.checkPermission(r10, r11, Process.myPid(), Process.myUid()) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean haveAccessLocationState() {
        if (sHaveAccessLocationState != null) goto L16;
        if (Build.VERSION.SDK_INT < 29) goto L9;
        boolean r10 = hasPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION");
    L7:
        sHaveAccessLocationState = Boolean.valueOf(r10);
        goto L16
    L9:
        if (hasPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION") == false) goto L11;
    L14:
        r10 = true;
        goto L7
    L11:
        if (hasPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == true) goto L14;
        r10 = false;
    L16:
        return sHaveAccessLocationState.booleanValue();
    }

    private static boolean haveAccessNetworkState() {
        if (sHaveAccessNetworkState != null) goto L6;
        sHaveAccessNetworkState = Boolean.valueOf(hasPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_NETWORK_STATE"));
    L6:
        return sHaveAccessNetworkState.booleanValue();
    }

    private static boolean haveAccessWifiState() {
        if (sHaveAccessWifiState != null) goto L6;
        sHaveAccessWifiState = Boolean.valueOf(hasPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_WIFI_STATE"));
    L6:
        return sHaveAccessWifiState.booleanValue();
    }

    @CalledByNative
    public static boolean haveOnlyLoopbackAddresses() {
        Enumeration<NetworkInterface> r10 = NetworkInterface.getNetworkInterfaces();     // Catch: Exception -> L16
        if (r10 != null) goto L7;
        return false;
    L7:
        if (r10.hasMoreElements() == false) goto L14;
        NetworkInterface r11 = r10.nextElement();
        if (r11.isUp() == false) goto L7;
        if (r11.isLoopback() == true) goto L7;
        return false;
    L14:
        return true;
    L16:
        e = move-exception;
        Log.w(TAG, "could not get network interfaces: " + e);
        return false;
    }

    @CalledByNative
    private static boolean isCleartextPermitted(String r10) {
        return NetworkSecurityPolicyProxy.getInstance().isCleartextTrafficPermitted(r10);
    L5:
        return NetworkSecurityPolicyProxy.getInstance().isCleartextTrafficPermitted();
    }

    @RequiresApi(23)
    @CalledByNative
    private static boolean reportBadDefaultNetwork() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return false;
    L5:
        ConnectivityManager r10 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (r10 != null) goto L8;
        return false;
    L8:
        ApiHelperForM.reportNetworkConnectivity(r10, null, false);
        return true;
    }

    @CalledByNative
    public static void setWifiEnabled(boolean r10) {
        ((WifiManager) ContextUtils.getApplicationContext().getSystemService("wifi")).setWifiEnabled(r10);
    }

    @CalledByNative
    private static void tagSocket(int r10, int r11, int r12) {
        int r13 = TrafficStats.getThreadStatsTag();
        if (r12 == r13) goto L6;
        TrafficStats.setThreadStatsTag(r12);
    L6:
        if (r11 == (-1)) goto L9;
        ThreadStatsUid.set(r11);
    L9:
        if (Build.VERSION.SDK_INT >= 23) goto L11;
        ParcelFileDescriptor r14 = null;
        FileDescriptor r15 = SetFileDescriptor.createWithFd(r10);
    L12:
        SocketFd r16 = new SocketFd(r15);
        TrafficStats.tagSocket(r16);
        r16.close();
        if (r14 == null) goto L15;
        r14.detachFd();
    L15:
        if (r12 == r13) goto L17;
        TrafficStats.setThreadStatsTag(r13);
    L17:
        if (r11 == (-1)) goto L20;
        ThreadStatsUid.clear();
        return;
    L20:
        return;
    L11:
        r14 = ParcelFileDescriptor.adoptFd(r10);
        r15 = r14.getFileDescriptor();
        goto L12
    }

    @CalledByNative
    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] r10, String r11, String r12) {
        return X509Util.verifyServerCertificates(r10, r11, r12);
    L6:
        return new AndroidCertVerifyResult(-1);
    L10:
        return new AndroidCertVerifyResult(-1);
    L8:
        return new AndroidCertVerifyResult(-1);
    }
}
