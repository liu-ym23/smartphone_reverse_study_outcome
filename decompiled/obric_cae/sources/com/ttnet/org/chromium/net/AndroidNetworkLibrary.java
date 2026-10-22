package com.ttnet.org.chromium.net;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.TrafficStats;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.security.NetworkSecurityPolicy;
import android.util.Log;
import com.ttnet.org.chromium.base.ApiCompatibilityUtils;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.VisibleForTesting;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.CalledByNativeUnchecked;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForP;
import com.ttnet.org.chromium.base.metrics.RecordHistogram;
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
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@MainDex
class AndroidNetworkLibrary {
    private static final String TAG = "AndroidNetworkLibrary";
    private static final Set<String> sAutoDohDotServers = null;
    private static final Set<InetAddress> sAutoDohServers = null;
    private static Boolean sHaveAccessNetworkState;
    private static Boolean sHaveAccessWifiState;
    private static AtomicBoolean sIsRequestingCellular;

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
        public static void setInstanceForTesting(NetworkSecurityPolicyProxy r8) {
            sInstance = r8;
        }

        @TargetApi(23)
        public boolean isCleartextTrafficPermitted() {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
        }

        @TargetApi(24)
        public boolean isCleartextTrafficPermitted(String r8) {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(r8);
        }
    }

    public static class SetFileDescriptor {
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

        public static FileDescriptor createWithFd(int r8) {
            FileDescriptor r10 = new FileDescriptor();     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L8
            sFileDescriptorSetInt.invoke(r10, new Object[]{Integer.valueOf(r8)});     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L8
            return r10;
        L8:
            e = move-exception;
            throw new RuntimeException("FileDescriptor.setInt$() failed", e);
        L5:
            e = move-exception;
            throw new RuntimeException("FileDescriptor.setInt$() failed", e);
        }
    }

    public static class SocketFd extends Socket {

        public static class SocketImplFd extends SocketImpl {
            public SocketImplFd(FileDescriptor r8) {
                ((SocketImpl) this).fd = r8;
            }

            @Override // java.net.SocketImpl
            public void accept(SocketImpl r8) {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            public int available() {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            public void bind(InetAddress r8, int r10) {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            public void close() {
            }

            @Override // java.net.SocketImpl
            public void connect(String r8, int r10) {
                throw new RuntimeException("connect not implemented");
            }

            @Override // java.net.SocketImpl
            public void create(boolean r8) {
            }

            @Override // java.net.SocketImpl
            public InputStream getInputStream() {
                throw new RuntimeException("getInputStream not implemented");
            }

            @Override // java.net.SocketOptions
            public Object getOption(int r8) {
                throw new RuntimeException("getOption not implemented");
            }

            @Override // java.net.SocketImpl
            public OutputStream getOutputStream() {
                throw new RuntimeException("getOutputStream not implemented");
            }

            @Override // java.net.SocketImpl
            public void listen(int r8) {
                throw new RuntimeException("listen not implemented");
            }

            @Override // java.net.SocketImpl
            public void sendUrgentData(int r8) {
                throw new RuntimeException("sendUrgentData not implemented");
            }

            @Override // java.net.SocketOptions
            public void setOption(int r8, Object r10) {
                throw new RuntimeException("setOption not implemented");
            }

            @Override // java.net.SocketImpl
            public void connect(InetAddress r8, int r10) {
                throw new RuntimeException("connect not implemented");
            }

            @Override // java.net.SocketImpl
            public void connect(SocketAddress r8, int r10) {
                throw new RuntimeException("connect not implemented");
            }
        }

        public SocketFd(FileDescriptor r8) {
            super(new SocketImplFd(r8));
        }
    }

    static {
        HashSet r8 = new HashSet();
        sAutoDohServers = r8;
        HashSet r10 = new HashSet();
        sAutoDohDotServers = r10;
        sIsRequestingCellular = new AtomicBoolean(false);
        r8.add(InetAddress.getByName("8.8.8.8"));     // Catch: UnknownHostException -> L6
        r8.add(InetAddress.getByName("8.8.4.4"));     // Catch: UnknownHostException -> L6
        r8.add(InetAddress.getByName("2001:4860:4860::8888"));     // Catch: UnknownHostException -> L6
        r8.add(InetAddress.getByName("2001:4860:4860::8844"));     // Catch: UnknownHostException -> L6
        r8.add(InetAddress.getByName("1.1.1.1"));     // Catch: UnknownHostException -> L6
        r8.add(InetAddress.getByName("1.0.0.1"));     // Catch: UnknownHostException -> L6
        r8.add(InetAddress.getByName("2606:4700:4700::1111"));     // Catch: UnknownHostException -> L6
        r8.add(InetAddress.getByName("2606:4700:4700::1001"));     // Catch: UnknownHostException -> L6
        r8.add(InetAddress.getByName("9.9.9.9"));     // Catch: UnknownHostException -> L6
        r8.add(InetAddress.getByName("149.112.112.112"));     // Catch: UnknownHostException -> L6
        r8.add(InetAddress.getByName("2620:fe::fe"));     // Catch: UnknownHostException -> L6
        r8.add(InetAddress.getByName("2620:fe::9"));     // Catch: UnknownHostException -> L6
        r10.add("dns.google");
        r10.add("1dot1dot1dot1.cloudflare-dns.com");
        r10.add("cloudflare-dns.com");
        r10.add("dns.quad9.net");
        return;
    L6:
        e = move-exception;
        throw new RuntimeException("Failed to parse IP addresses", e);
    }

    public AndroidNetworkLibrary() {
    }

    public static /* synthetic */ AtomicBoolean access$000() {
        return sIsRequestingCellular;
    }

    public static /* synthetic */ void access$100(boolean r8) {
        nativeOnCellularAlwaysUp(r8);
    }

    @CalledByNativeUnchecked
    public static void addTestRootCertificate(byte[] r8) {
        X509Util.addTestRootCertificate(r8);
    }

    @CalledByNative
    @TargetApi(21)
    private static boolean alwayUpCellular() {
        if (sIsRequestingCellular.compareAndSet(false, true) == false) goto L13;
        final ConnectivityManager r8 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (r8 != null) goto L8;
    L6:
        sIsRequestingCellular.set(false);
        return false;
    L8:
        NetworkRequest r10 = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        r8.requestNetwork(r10, new AnonymousClass1(r8));     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
    L13:
        return true;
    }

    @CalledByNative
    @TargetApi(21)
    private static boolean checkIsVpnOn() {
        ConnectivityManager r8 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (r8 != null) goto L5;
        return false;
    L5:
        Network[] r10 = r8.getAllNetworks();
        int r11 = 0;
    L7:
        if (r11 >= r10.length) goto L15;
        if (r8.getNetworkInfo(r10[r11]).isConnected() == false) goto L14;
        if (r8.getNetworkCapabilities(r10[r11]).hasTransport(4) == false) goto L14;
        return true;
    L14:
        r11 = r11 + 1;
        goto L7
    L15:
        return false;
    }

    @CalledByNativeUnchecked
    public static void clearTestRootCertificates() {
        X509Util.clearTestRootCertificates();
    }

    @CalledByNative
    @TargetApi(23)
    private static byte[][] getDnsServers() {
        int r8 = 0;
        boolean r10 = false;
        if (haveAccessNetworkState() == true) goto L7;
        Object r11 = Array.newInstance(Byte.TYPE, new int[]{0, 0});
    L6:
        return (byte[][]) r11;
    L7:
        ConnectivityManager r12 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (r12 != null) goto L10;
        r11 = Array.newInstance(Byte.TYPE, new int[]{0, 0});
        goto L6
    L10:
        Network r13 = ApiHelperForM.getActiveNetwork(r12);
        if (r13 != null) goto L13;
        r11 = Array.newInstance(Byte.TYPE, new int[]{0, 0});
        goto L6
    L13:
        LinkProperties r14 = r12.getLinkProperties(r13);
        if (r14 != null) goto L16;
        r11 = Array.newInstance(Byte.TYPE, new int[]{0, 0});
        goto L6
    L16:
        List<InetAddress> r15 = r14.getDnsServers();
        Iterator<InetAddress> r16 = r15.iterator();
    L18:
        if (r16.hasNext() == false) goto L22;
        if (sAutoDohServers.contains(r16.next()) == false) goto L18;
        boolean r17 = true;
    L24:
        if (isPrivateDnsActive(r14) == false) goto L31;
        String r18 = getPrivateDnsServerName(r14);
        if (r18 == null) goto L28;
        r17 = sAutoDohDotServers.contains(r18.toLowerCase(Locale.US));
    L28:
        if (r18 == null) goto L30;
        r10 = true;
    L30:
        RecordHistogram.recordBooleanHistogram("Net.DNS.Android.DotExplicit", r10);
        RecordHistogram.recordBooleanHistogram("Net.DNS.Android.AutoDohPrivate", r17);
        r11 = Array.newInstance(Byte.TYPE, new int[]{1, 1});
        goto L6
    L31:
        RecordHistogram.recordBooleanHistogram("Net.DNS.Android.AutoDohPublic", r17);
        byte[][] r19 = new byte[r15.size()][];
    L33:
        if (r8 >= r15.size()) goto L35;
        r19[r8] = r15.get(r8).getAddress();
        r8 = r8 + 1;
        goto L33
    L35:
        return r19;
    L22:
        r17 = false;
        goto L24
    }

    @CalledByNative
    @TargetApi(23)
    private static boolean getIsCaptivePortal() {
        ConnectivityManager r8 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (r8 != null) goto L5;
        return false;
    L5:
        Network r10 = ApiHelperForM.getActiveNetwork(r8);
        if (r10 != null) goto L8;
        return false;
    L8:
        NetworkCapabilities r11 = r8.getNetworkCapabilities(r10);
        if (r11 != null) goto L11;
        return false;
    L11:
        if (r11.hasCapability(17) == false) goto L15;
        return true;
    L15:
        return false;
    }

    @CalledByNative
    public static String getMimeTypeFromExtension(String r8) {
        return URLConnection.guessContentTypeFromName("foo." + r8);
    }

    private static String getPrivateDnsServerName(LinkProperties r8) {
        if (r8 != null) goto L4;
        return null;
    L4:
        return ApiHelperForP.getPrivateDnsServerName(r8);
    }

    @CalledByNative
    public static int[] getRouteInfo() {
        WifiManager r8 = (WifiManager) ContextUtils.getApplicationContext().getSystemService("wifi");     // Catch: Throwable -> L9
        if (r8 == null) goto L12;
        DhcpInfo r10 = r8.getDhcpInfo();     // Catch: Throwable -> L9
        if (r10 == null) goto L12;
        return new int[]{r10.ipAddress, r10.netmask};
    L12:
        return new int[0];
    L9:
        th = move-exception;
        th.printStackTrace();
        goto L12
    }

    @CalledByNative
    public static String getWifiSSID() {
        return "";
    }

    @CalledByNative
    public static int getWifiSignalLevel(int r8) {
    L28:
        e = move-exception;
        e.printStackTrace();
        return -1;
    L4:
        if (ContextUtils.getApplicationContext() != null) goto L7;
        return -1;
    L7:
        if (ContextUtils.getApplicationContext().getContentResolver() != null) goto L10;
        return -1;
    L10:
        if (haveAccessWifiState() == false) goto L32;
        WifiManager r10 = (WifiManager) ContextUtils.getApplicationContext().getSystemService("wifi");     // Catch: Exception -> L28
        Log.w(TAG, "lz, getConnectionInfo calles");     // Catch: Exception -> L28
        WifiInfo r11 = r10.getConnectionInfo();     // Catch: Exception -> L28
        if (r11 != null) goto L14;
        return -1;
    L14:
        int r12 = r11.getRssi();     // Catch: Exception -> L28
    L20:
        if (r12 != Integer.MIN_VALUE) goto L22;
        return -1;
    L22:
        int r13 = WifiManager.calculateSignalLevel(r12, r8);     // Catch: Exception -> L28
        if (r13 < 0) goto L27;
        if (r13 >= r8) goto L27;
        return r13;
    L27:
        return -1;
    L32:
        Intent r14 = ContextUtils.getApplicationContext().registerReceiver(null, new IntentFilter("android.net.wifi.RSSI_CHANGED"));     // Catch: IllegalArgumentException -> L31 Exception -> L28
        if (r14 != null) goto L19;
        return -1;
    L19:
        r12 = r14.getIntExtra("newRssi", Integer.MIN_VALUE);     // Catch: Exception -> L28
        goto L20
    }

    private static boolean haveAccessNetworkState() {
        if (sHaveAccessNetworkState != null) goto L10;
        if (ApiCompatibilityUtils.checkPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) goto L7;
        boolean r8 = true;
    L8:
        sHaveAccessNetworkState = Boolean.valueOf(r8);
        goto L10
    L7:
        r8 = false;
    L10:
        return sHaveAccessNetworkState.booleanValue();
    }

    private static boolean haveAccessWifiState() {
        if (sHaveAccessWifiState != null) goto L10;
        if (ApiCompatibilityUtils.checkPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_WIFI_STATE", Process.myPid(), Process.myUid()) != 0) goto L7;
        boolean r8 = true;
    L8:
        sHaveAccessWifiState = Boolean.valueOf(r8);
        goto L10
    L7:
        r8 = false;
    L10:
        return sHaveAccessWifiState.booleanValue();
    }

    @CalledByNative
    public static boolean haveOnlyLoopbackAddresses() {
        Enumeration<NetworkInterface> r8 = NetworkInterface.getNetworkInterfaces();     // Catch: Exception -> L16
        if (r8 != null) goto L7;
        return false;
    L7:
        if (r8.hasMoreElements() == false) goto L14;
        NetworkInterface r10 = r8.nextElement();
        if (r10.isUp() == false) goto L7;
        if (r10.isLoopback() == true) goto L7;
        return false;
    L14:
        return true;
    L16:
        e = move-exception;
        Log.w(TAG, "could not get network interfaces: " + e);
        return false;
    }

    @CalledByNative
    private static boolean isCleartextPermitted(String r8) {
        return NetworkSecurityPolicyProxy.getInstance().isCleartextTrafficPermitted(r8);
    L5:
        return NetworkSecurityPolicyProxy.getInstance().isCleartextTrafficPermitted();
    }

    public static boolean isPrivateDnsActive(LinkProperties r8) {
        if (r8 != null) goto L4;
        return false;
    L4:
        return ApiHelperForP.isPrivateDnsActive(r8);
    }

    private static native void nativeOnCellularAlwaysUp(boolean r8);

    @CalledByNative
    private static void tagSocket(int r8, int r10, int r11) {
        int r12 = TrafficStats.getThreadStatsTag();
        if (r11 == r12) goto L6;
        TrafficStats.setThreadStatsTag(r11);
    L6:
        if (r10 == (-1)) goto L8;
        ThreadStatsUid.set(r10);
    L8:
        ParcelFileDescriptor r13 = ParcelFileDescriptor.adoptFd(r8);
        SocketFd r14 = new SocketFd(r13.getFileDescriptor());
        TrafficStats.tagSocket(r14);
        r14.close();
        r13.detachFd();
        if (r11 == r12) goto L11;
        TrafficStats.setThreadStatsTag(r12);
    L11:
        if (r10 == (-1)) goto L14;
        ThreadStatsUid.clear();
        return;
    }

    @CalledByNative
    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] r8, String r10, String r11) {
        return X509Util.verifyServerCertificates(r8, r10, r11);
    L6:
        return new AndroidCertVerifyResult(-1);
    L10:
        return new AndroidCertVerifyResult(-1);
    L8:
        return new AndroidCertVerifyResult(-1);
    }
}
