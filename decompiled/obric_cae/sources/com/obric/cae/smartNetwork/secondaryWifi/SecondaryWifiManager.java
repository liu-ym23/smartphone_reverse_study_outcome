package com.obric.cae.smartNetwork.secondaryWifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.MacAddress;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.wifi.MloLink;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiNetworkSpecifier;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.obric.cae.libs.wifi.ISecondaryWifiCallback;
import com.obric.cae.log.CaeLog;
import com.obric.cae.userAware.report.SubwayEvaluationEvent;
import com.obric.cae.utils.CaeUtil;
import com.obric.cae.utils.CaeWifiUtil;
import defpackage.b;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class SecondaryWifiManager {
    private static final int CONNECT_TIMEOUT_MS = 6000;
    private static final int DEFAULT_FALLBACK_RSSI = -45;
    private static final int MULTI_INTERNET_MODE_MULTI_AP = 2;
    private static final int REQUEST_RELEASE_DELAY_MS = 150;
    private static final int SECONDARY_WIFI_CONNECTED = 1;
    private static final int SECONDARY_WIFI_DISCONNECTED = 0;
    private static final String SETTINGS_SECURE_SECONDARY_WIFI_CONNECTED = "secondary_wifi_connected";
    private static final String TAG = "SecondaryWifiManager";
    private WifiInfo mBackUpPriWifiINfo;
    private RemoteCallbackList<ISecondaryWifiCallback> mClientCallbacks;
    private final ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private int mCurrentConnectedSecondaryRssi;
    private String mCurrentConnectedSecondarySsid;
    private final Handler mHandler;
    private boolean mHasModeOverride;
    private ConnectivityManager.NetworkCallback mNetworkCallback;
    private int mOriginalMode;
    private int mRequestGeneration;
    private final WifiManager mWifiManager;
    private final BroadcastReceiver supplicantStateReceiver;

    public class SecondaryNetworkCallback extends ConnectivityManager.NetworkCallback {
        private final String mRequestedSsid;
        final /* synthetic */ SecondaryWifiManager this$0;

        public SecondaryNetworkCallback(SecondaryWifiManager r8, String r10) {
            this.this$0 = r8;
            this.mRequestedSsid = r10;
        }

        private boolean isCurrentCallback() {
            SecondaryWifiManager r8 = this.this$0;
            monitor-enter(r8);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (SecondaryWifiManager.access$300(this.this$0) != this) goto L7;
            boolean r10 = true;
        L8:
            monitor-exit(r8);     // Catch: Throwable -> L10
            return r10;
        L7:
            r10 = false;
            goto L8
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r8) {
            if (isCurrentCallback() == true) goto L6;
            CaeLog.d(SecondaryWifiManager.TAG, "Ignore stale onAvailable callback");
            return;
        L6:
            CaeLog.d(SecondaryWifiManager.TAG, "Secondary Wi-Fi available");
            SecondaryWifiManager.access$002(this.this$0, this.mRequestedSsid);
            SecondaryWifiManager.access$400(this.this$0, this.mRequestedSsid, SecondaryWifiManager.DEFAULT_FALLBACK_RSSI);
            Settings.Secure.putInt(SecondaryWifiManager.access$500(this.this$0).getContentResolver(), SecondaryWifiManager.SETTINGS_SECURE_SECONDARY_WIFI_CONNECTED, 1);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r8, NetworkCapabilities r10) {
            if (isCurrentCallback() == true) goto L6;
            CaeLog.d(SecondaryWifiManager.TAG, "Ignore stale onCapabilitiesChanged callback");
            return;
        L6:
            CaeLog.d(SecondaryWifiManager.TAG, "Secondary Wi-Fi CapabilitiesChanged:" + r10.toString());
            if (r10.hasTransport(1) == true) goto L9;
            return;
        L9:
            SecondaryWifiManager.access$002(this.this$0, r10.getSsid());
            int r11 = r10.getSignalStrength();
            StringBuilder r12 = b.f("onCapabilitiesChanged rssi=", r11, " ssid=");
            r12.append(SecondaryWifiManager.access$000(this.this$0));
            CaeLog.d(SecondaryWifiManager.TAG, r12.toString());
            SecondaryWifiManager.access$600(this.this$0, r11);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network r8) {
            if (isCurrentCallback() == true) goto L6;
            CaeLog.d(SecondaryWifiManager.TAG, "Ignore stale onLost callback");
            return;
        L6:
            CaeLog.d(SecondaryWifiManager.TAG, "onLost");
            SecondaryWifiManager.access$700(this.this$0);
            SecondaryWifiManager.access$100(this.this$0, true);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            if (isCurrentCallback() == true) goto L6;
            CaeLog.d(SecondaryWifiManager.TAG, "Ignore stale onUnavailable callback");
            return;
        L6:
            CaeLog.d(SecondaryWifiManager.TAG, "onUnavailable");
            SecondaryWifiManager.access$800(this.this$0);
            SecondaryWifiManager.access$100(this.this$0, true);
        }
    }

    public SecondaryWifiManager(Context r8) {
        this.mClientCallbacks = new RemoteCallbackList();
        this.mNetworkCallback = null;
        this.mCurrentConnectedSecondarySsid = null;
        this.mCurrentConnectedSecondaryRssi = DEFAULT_FALLBACK_RSSI;
        this.mOriginalMode = -1;
        this.mHasModeOverride = false;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mRequestGeneration = 0;
        this.mBackUpPriWifiINfo = null;
        this.supplicantStateReceiver = new AnonymousClass2(this);
        this.mConnectivityManager = (ConnectivityManager) r8.getSystemService(ConnectivityManager.class);
        this.mWifiManager = (WifiManager) r8.getSystemService(WifiManager.class);
        this.mContext = r8;
        Settings.Secure.putInt(r8.getContentResolver(), SETTINGS_SECURE_SECONDARY_WIFI_CONNECTED, 0);
        registerSupplicantReceiver();
    }

    public static /* synthetic */ void a(SecondaryWifiManager r8, int r10, ISecondaryWifiCallback r11, String r12, String r13, String r14, String r15) {
        r8.lambda$requestSecondaryWifi$0(r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ String access$000(SecondaryWifiManager r8) {
        return r8.mCurrentConnectedSecondarySsid;
    }

    public static /* synthetic */ String access$002(SecondaryWifiManager r8, String r10) {
        r8.mCurrentConnectedSecondarySsid = r10;
        return r10;
    }

    public static /* synthetic */ void access$100(SecondaryWifiManager r8, boolean r10) {
        r8.teardownSecondaryWifiConnection(r10);
    }

    public static /* synthetic */ WifiInfo access$202(SecondaryWifiManager r8, WifiInfo r10) {
        r8.mBackUpPriWifiINfo = r10;
        return r10;
    }

    public static /* synthetic */ ConnectivityManager.NetworkCallback access$300(SecondaryWifiManager r8) {
        return r8.mNetworkCallback;
    }

    public static /* synthetic */ void access$400(SecondaryWifiManager r8, String r10, int r11) {
        r8.notifyOnAvailable(r10, r11);
    }

    public static /* synthetic */ Context access$500(SecondaryWifiManager r8) {
        return r8.mContext;
    }

    public static /* synthetic */ void access$600(SecondaryWifiManager r8, int r10) {
        r8.notifyOnSignalStrength(r10);
    }

    public static /* synthetic */ void access$700(SecondaryWifiManager r8) {
        r8.notifyOnLost();
    }

    public static /* synthetic */ void access$800(SecondaryWifiManager r8) {
        r8.notifyOnUnavailable();
    }

    private WifiConfiguration buildWifiConfiguration(String r8, String r10, String r11, String r12) {
        WifiConfiguration r13 = new WifiConfiguration();
        r13.SSID = b.d("\"", r10, "\"");
        r11.getClass();
        r11.hashCode();
        byte r14 = -1;
        switch(r11.hashCode()) {
            case 3417674: goto L14;
            case 3655818: goto L10;
            case 3655819: goto L6;
            default: goto L17;
        };
    L17:
        switch(r14) {
            case 0: goto L23;
            case 1: goto L21;
            case 2: goto L20;
            default: goto L19;
        };
    L20:
        r13.setSecurityParams(4);
        StringBuilder r15 = new StringBuilder("\"");
    L22:
        r13.preSharedKey = android.aimedia.a.i(r15, r12, "\"");
    L24:
        return r13;
    L21:
        r13.setSecurityParams(2);
        r15 = new StringBuilder("\"");
        goto L22
    L23:
        r13.setSecurityParams(0);
        goto L24
    L19:
        throw new IllegalArgumentException("Unknown network type ".concat(r11));
    L6:
        if (r11.equals("wpa3") == false) goto L17;
        r14 = 2;
        goto L17
    L10:
        if (r11.equals("wpa2") == false) goto L17;
        r14 = 1;
        goto L17
    L14:
        if (r11.equals("open") == false) goto L17;
        r14 = 0;
        goto L17
    }

    private void clearSecondaryWifiState() {
        this.mCurrentConnectedSecondarySsid = null;
        this.mCurrentConnectedSecondaryRssi = DEFAULT_FALLBACK_RSSI;
        Settings.Secure.putInt(this.mContext.getContentResolver(), SETTINGS_SECURE_SECONDARY_WIFI_CONNECTED, 0);
    }

    private void continueRequestSecondaryWifi(String r8, String r10, String r11, String r12, ISecondaryWifiCallback r13, WifiInfo r14) {
        switchToMultiInternetModeIfNeeded();
        int r15 = r14.getFrequency();
        int r16 = 5;
        int r17 = 2;
        if (r15 >= 4900) goto L5;
    L7:
        char r18 = 2;
    L8:
        if (r18 != 5) goto L11;
        r16 = 2;
    L11:
        if (TextUtils.isEmpty(r12) == false) goto L18;
        if (requiresPassword(r11) == false) goto L18;
        r12 = tryResolveSavedNetworkPassword(r10, r11);
        if (TextUtils.isEmpty(r12) == false) goto L18;
        CaeLog.w(TAG, "Password empty and cannot resolve from saved network. SSID=" + r10 + ", securityType=" + r11);
    L18:
        if (TextUtils.isEmpty(r8) == false) goto L20;
    L26:
        boolean r19 = false;
    L27:
        if (r19 == false) goto L33;
        WifiConfiguration r110 = buildWifiConfiguration(r8, r10, r11, r12);
        final CountDownLatch r20 = new CountDownLatch(1);
        this.mWifiManager.save(r110, new AnonymousClass1(this, r20));
        r20.await(1000, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L31
    L31:
        e = move-exception;
        CaeLog.e(TAG, "countDownLatch.await e:" + e);
    L33:
        WifiNetworkSpecifier.Builder r111 = new WifiNetworkSpecifier.Builder();
        if (r10 != null) goto L36;
    L45:
        if (r16 != 2) goto L47;
        r17 = 1;
    L47:
        r111.setBand(r17);
        r111.setBssid(MacAddress.fromString(r8));
        NetworkRequest r21 = new NetworkRequest.Builder().addTransportType(1).addCapability(12).setNetworkSpecifier(r111.build()).build();
        safeRegisterCallback(r13);
        this.mNetworkCallback = new SecondaryNetworkCallback(this, r10);
        CaeLog.d(TAG, "Request secondary Wi-Fi SSID=" + r10 + " on band=" + r16 + "GHz");
        this.mConnectivityManager.requestNetwork(r21, this.mNetworkCallback, CONNECT_TIMEOUT_MS);
        return;
    L36:
        if (r10.isEmpty() == true) goto L45;
        r111.setSsid(r10);
        if (TextUtils.isEmpty(r12) == true) goto L45;
        if ("wpa3".equalsIgnoreCase(r11) == false) goto L43;
        r111.setWpa3Passphrase(r12);
        goto L45
    L43:
        if ("wpa2".equalsIgnoreCase(r11) == false) goto L45;
        r111.setWpa2Passphrase(r12);
        goto L45
    L20:
        if (TextUtils.isEmpty(r10) == true) goto L26;
        if (requiresPassword(r11) == true) goto L24;
    L25:
        r19 = true;
        goto L27
    L24:
        if (TextUtils.isEmpty(r12) == true) goto L26;
    L5:
        if (r15 > 5900) goto L7;
        r18 = 5;
        goto L8
    }

    private WifiInfo getPrimaryWifiInfo() {
        if (TextUtils.isEmpty(this.mCurrentConnectedSecondarySsid) == false) goto L11;
        if (this.mNetworkCallback != null) goto L11;
        WifiInfo r8 = this.mWifiManager.getConnectionInfo();
        if (r8 != null) goto L9;
        this.mBackUpPriWifiINfo = null;
    L9:
        return r8;
    L11:
        return this.mBackUpPriWifiINfo;
    }

    private boolean isSecuritySupported(ScanResult r8) {
        String r10 = r8.capabilities;
        if (r10 != null) goto L5;
        return true;
    L5:
        String r11 = r10.toLowerCase();
        if (r11.contains("wep") == false) goto L8;
    L12:
        boolean r12 = false;
    L13:
        boolean r13 = r11.contains("psk");
        if (r12 == true) goto L19;
        if (r13 == false) goto L18;
        return true;
    L18:
        return false;
    L19:
        return true;
    L8:
        if (r11.contains("psk") == true) goto L12;
        if (r11.contains("sae") == true) goto L12;
        r12 = true;
        goto L13
    }

    private /* synthetic */ void lambda$requestSecondaryWifi$0(int r8, ISecondaryWifiCallback r10, String r11, String r12, String r13, String r14) {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L4:
        if (r8 == this.mRequestGeneration) goto L8;
        CaeLog.d(TAG, "Skip stale delayed secondary Wi-Fi request");     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L8:
        WifiInfo r15 = getPrimaryWifiInfo();     // Catch: Throwable -> L24
        if (r15 != null) goto L11;
    L28:
        r10.onUnavailable();     // Catch: RemoteException -> L20 Throwable -> L24
    L22:
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L20:
        e = move-exception;
        CaeLog.e(TAG, "Callback failed", e);     // Catch: Throwable -> L24
        goto L22
    L11:
        if (r15.getNetworkId() == (-1)) goto L28;
        if (r15.getSupplicantState().toString().equals("COMPLETED") == false) goto L28;
        continueRequestSecondaryWifi(r11, r12, r13, r14, r10, r15);     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
    }

    private static boolean looksMasked(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L6;
        return true;
    L6:
        if ("*".equals(r8) == false) goto L8;
        return true;
    L8:
        if ("****".equals(r8) == false) goto L10;
        return true;
    L10:
        if ("\"\"".equals(r8) == true) goto L16;
        return false;
    L16:
        return true;
    }

    private static String normalizeSecurityType(String r8, String r10) {
        if (TextUtils.isEmpty(r8) == true) goto L5;
        String r11 = r8.trim().toLowerCase();
        if (r11.equals("open") == false) goto L11;
    L38:
        return "open";
    L11:
        if (r11.equals(SubwayEvaluationEvent.VERIFY_METHOD_NONE) == true) goto L38;
        if (r11.equals("wpa3") == false) goto L16;
    L37:
        return "wpa3";
    L16:
        if (r11.equals("sae") == true) goto L37;
        if (r11.equals("wpa3_sae") == true) goto L37;
        if (r11.equals("wpa3-sae") == true) goto L37;
        if (r11.equals("wpa2") == false) goto L25;
        return "wpa2";
    L25:
        if (r11.equals("psk") == false) goto L27;
        return "wpa2";
    L27:
        if (r11.equals("wpa_psk") == false) goto L29;
        return "wpa2";
    L29:
        if (r11.equals("wpa2_psk") == false) goto L31;
        return "wpa2";
    L31:
        if (r11.equals("wpa2-psk") == false) goto L34;
        return "wpa2";
    L34:
        if (TextUtils.isEmpty(r10) == true) goto L36;
        return "wpa2";
    L36:
        return "open";
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L7;
        return "wpa2";
    L7:
        return "open";
    }

    private void notifyOnAvailable(String r8, int r10) {
        int r11 = this.mClientCallbacks.beginBroadcast();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        ((ISecondaryWifiCallback) this.mClientCallbacks.getBroadcastItem(r12)).onAvailable(r8, r10);     // Catch: RemoteException -> L6
    L8:
        r12 = r12 + 1;
    L6:
        e = move-exception;
        CaeLog.e(TAG, "onAvailable failed", e);
        goto L8
    L9:
        this.mClientCallbacks.finishBroadcast();
    }

    private void notifyOnLost() {
        int r8 = this.mClientCallbacks.beginBroadcast();
        int r10 = 0;
    L3:
        if (r10 >= r8) goto L9;
        ((ISecondaryWifiCallback) this.mClientCallbacks.getBroadcastItem(r10)).onLost();     // Catch: RemoteException -> L6
    L8:
        r10 = r10 + 1;
    L6:
        e = move-exception;
        CaeLog.e(TAG, "onLost failed", e);
        goto L8
    L9:
        this.mClientCallbacks.finishBroadcast();
    }

    private void notifyOnSignalStrength(int r8) {
        int r10 = this.mClientCallbacks.beginBroadcast();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        ((ISecondaryWifiCallback) this.mClientCallbacks.getBroadcastItem(r11)).onSignalStrength(r8);     // Catch: RemoteException -> L6
    L8:
        r11 = r11 + 1;
    L6:
        e = move-exception;
        CaeLog.e(TAG, "onSignalStrength failed", e);
        goto L8
    L9:
        this.mClientCallbacks.finishBroadcast();
    }

    private void notifyOnUnavailable() {
        int r8 = this.mClientCallbacks.beginBroadcast();
        int r10 = 0;
    L3:
        if (r10 >= r8) goto L9;
        ((ISecondaryWifiCallback) this.mClientCallbacks.getBroadcastItem(r10)).onUnavailable();     // Catch: RemoteException -> L6
    L8:
        r10 = r10 + 1;
    L6:
        e = move-exception;
        CaeLog.e(TAG, "onUnavailable failed", e);
        goto L8
    L9:
        this.mClientCallbacks.finishBroadcast();
    }

    private void registerSupplicantReceiver() {
        IntentFilter r8 = new IntentFilter("android.net.wifi.supplicant.STATE_CHANGE");
        this.mContext.registerReceiver(this.supplicantStateReceiver, r8);
    }

    private static boolean requiresPassword(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return false;
    L5:
        String r10 = r8.toLowerCase();
        if (r10.equals("wpa2") == false) goto L8;
    L9:
        return true;
    L8:
        if (r10.equals("wpa3") == true) goto L9;
        return false;
    }

    private void restoreMultiInternetModeIfNeeded() {
        if (this.mHasModeOverride == true) goto L6;
        this.mOriginalMode = -1;
        return;
    L6:
        int r8 = this.mOriginalMode;
        if (r8 == (-1)) goto L9;
        CaeLog.d(TAG, "Restore dual Wi-Fi mode to " + this.mOriginalMode + ", success=" + setStaConcurrencyForMultiInternetMode(this.mWifiManager, r8));
    L9:
        this.mHasModeOverride = false;
        this.mOriginalMode = -1;
    }

    private void safeRegisterCallback(ISecondaryWifiCallback r8) {
        if (this.mClientCallbacks.register(r8) == true) goto L6;
        CaeLog.w(TAG, "RemoteCallbackList killed, recreate and register again.");
        RemoteCallbackList<ISecondaryWifiCallback> r10 = new RemoteCallbackList();
        this.mClientCallbacks = r10;
        r10.register(r8);
        return;
    }

    public static boolean setStaConcurrencyForMultiInternetMode(WifiManager r8, int r10) {
        Method r11 = r8.getClass().getDeclaredMethod("setStaConcurrencyForMultiInternetMode", new Class[]{Integer.TYPE});     // Catch: Exception -> L9
        r11.setAccessible(true);     // Catch: Exception -> L9
        Object r12 = r11.invoke(r8, new Object[]{Integer.valueOf(r10)});     // Catch: Exception -> L9
        if ((r12 instanceof Boolean) == false) goto L14;
        if (((Boolean) r12).booleanValue() == true) goto L8;
        return false;
    L8:
        return true;
    L14:
        return false;
    L9:
        e = move-exception;
        Log.e("ReflectionUtil", "Error calling setStaConcurrencyForMultiInternetMode", e);
        return false;
    }

    private static String stripDoubleQuotes(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return r8;
    L5:
        int r10 = r8.length();
        if (r10 >= 2) goto L8;
        return r8;
    L8:
        if (r8.charAt(0) != '\"') goto L14;
        int r11 = r10 - 1;
        if (r8.charAt(r11) == '\"') goto L12;
        return r8;
    L12:
        return r8.substring(1, r11);
    L14:
        return r8;
    }

    private void switchToMultiInternetModeIfNeeded() {
        if (this.mHasModeOverride == false) goto L5;
        return;
    L5:
        this.mOriginalMode = this.mWifiManager.getStaConcurrencyForMultiInternetMode();
        defpackage.a.j(new StringBuilder("Current dual Wi-Fi mode: "), this.mOriginalMode, TAG);
        if (this.mOriginalMode != 2) goto L8;
        return;
    L8:
        boolean r8 = setStaConcurrencyForMultiInternetMode(this.mWifiManager, 2);
        this.mHasModeOverride = r8;
        if (r8 == true) goto L12;
        CaeLog.w(TAG, "Failed to switch to Multi-Internet mode, keep original mode=" + this.mOriginalMode);
        return;
    }

    private void teardownSecondaryWifiConnection(boolean r8) {
        this.mRequestGeneration++;
        unregisterNetworkCallbackIfNeeded();
        clearSecondaryWifiState();
        if (r8 == false) goto L6;
        restoreMultiInternetModeIfNeeded();
        return;
    }

    private String tryResolveSavedNetworkPassword(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return null;
    L5:
        String r8 = b.d("\"", r10, "\"");
        Object r12 = WifiManager.class.getMethod("getPrivilegedConfiguredNetworks", new Class[0]).invoke(this.mWifiManager, new Object[0]);     // Catch: Throwable -> L10
        if ((r12 instanceof List) == false) goto L12;
        List r13 = (List) r12;     // Catch: Throwable -> L10
    L13:
        if (r13 != null) goto L15;
    L34:
        return null;
    L15:
        if (r13.isEmpty() == true) goto L34;
        Iterator r14 = r13.iterator();     // Catch: Throwable -> L35
    L19:
        if (r14.hasNext() == false) goto L37;
        WifiConfiguration r15 = (WifiConfiguration) r14.next();     // Catch: Throwable -> L35
        if (r15 == null) goto L19;
        if (TextUtils.equals(r15.SSID, r8) == true) goto L29;
        if (TextUtils.equals(r15.SSID, r10) == false) goto L19;
    L29:
        if (TextUtils.isEmpty(r15.preSharedKey) == true) goto L19;
        if (looksMasked(r15.preSharedKey) == true) goto L19;
        return stripDoubleQuotes(r15.preSharedKey);
    L37:
        return null;
    L12:
        r13 = null;
    L35:
        th = move-exception;
        CaeLog.w(TAG, "tryResolveSavedNetworkPassword failed, SSID=" + r10 + ", e=" + th);
    L10:
        th = move-exception;
        CaeLog.w(TAG, "getPrivilegedConfiguredNetworks via reflection failed, ssid=" + r10 + ", e=" + th);     // Catch: Throwable -> L35
        goto L12
    }

    private void unregisterNetworkCallbackIfNeeded() {
        ConnectivityManager.NetworkCallback r8 = this.mNetworkCallback;
        if (r8 != null) goto L16;
        return;
    L16:
        this.mConnectivityManager.unregisterNetworkCallback(r8);     // Catch: Throwable -> L8 IllegalArgumentException -> L10
    L7:
        this.mNetworkCallback = null;
        return;
    L10:
        e = move-exception;
        CaeLog.e(TAG, "Network callback already unregistered", e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        this.mNetworkCallback = null;
        throw th;
    }

    private void unregisterSupplicantReceiver() {
        this.mContext.unregisterReceiver(this.supplicantStateReceiver);
    }

    public synchronized String getCurrentSecondarySsid() {
        monitor-enter(this);
        CaeLog.i(TAG, "getCurrentSecondarySsid = " + this.mCurrentConnectedSecondarySsid);     // Catch: Throwable -> L7
        String r8 = this.mCurrentConnectedSecondarySsid;     // Catch: Throwable -> L7
        monitor-exit(this);
        return r8;
    L7:
        th = move-exception;
        throw th;
    }

    public List<ScanResult> getSecondaryWifiList() {
        WifiInfo r8 = getPrimaryWifiInfo();
        if (r8 != null) goto L5;
    L31:
        CaeLog.w(TAG, "Primary WiFi not connected");
        return new ArrayList();
    L5:
        if (r8.getNetworkId() == (-1)) goto L31;
        ArrayList r10 = new ArrayList();
        Iterator<ScanResult> r11 = this.mWifiManager.getScanResults().iterator();
    L9:
        if (r11.hasNext() == false) goto L30;
        ScanResult r12 = r11.next();
        if (r12 == null) goto L9;
        if (TextUtils.isEmpty(r12.SSID) == true) goto L9;
        if (TextUtils.equals(r12.BSSID, r8.getBSSID()) == true) goto L9;
        if (TextUtils.equals(CaeWifiUtil.toBand(r12.frequency), CaeWifiUtil.toBand(r8.getFrequency())) == true) goto L9;
        if (isSecuritySupported(r12) == false) goto L9;
        if (isMlo(r8) == false) goto L29;
        if (isAffiliatedLinkBssid(r8, r12.BSSID) == true) goto L9;
    L29:
        r10.add(r12);
        goto L9
    L30:
        return r10;
    }

    public boolean isAffiliatedLinkBssid(WifiInfo r8, String r10) {
        if (r8 != null) goto L5;
    L16:
        return false;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L16;
        MacAddress r11 = MacAddress.fromString(r10);     // Catch: IllegalArgumentException -> L15
        Iterator<MloLink> r12 = r8.getAffiliatedMloLinks().iterator();
    L10:
        if (r12.hasNext() == false) goto L22;
        if (r11.equals(r12.next().getApMacAddress()) == false) goto L10;
        return true;
    L22:
        return false;
    L15:
        CaeLog.w(TAG, "Invalid BSSID: " + CaeUtil.maskMacOrBssid(r10));
        goto L16
    }

    public boolean isMlo(WifiInfo r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        return !r8.getAssociatedMloLinks().isEmpty();
    }

    public synchronized void registerSecondaryWifiListener(ISecondaryWifiCallback r8) {
        monitor-enter(this);
        safeRegisterCallback(r8);     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(this.mCurrentConnectedSecondarySsid) == false) goto L17;
    L9:
        CaeLog.d(TAG, "Client callback registered");     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L17:
        r8.onAvailable(this.mCurrentConnectedSecondarySsid, this.mCurrentConnectedSecondaryRssi);     // Catch: RemoteException -> L7 Throwable -> L12
    L7:
        e = move-exception;
        CaeLog.e(TAG, "onAvailable failed", e);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public synchronized void releaseAll() {
        monitor-enter(this);
        this.mClientCallbacks.kill();     // Catch: Throwable -> L6
        this.mClientCallbacks = new RemoteCallbackList();     // Catch: Throwable -> L6
        teardownSecondaryWifiConnection(true);     // Catch: Throwable -> L6
        CaeLog.d(TAG, "All secondary Wi-Fi connections released");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void releaseSecondaryWifi(ISecondaryWifiCallback r8) {
        monitor-enter(this);
        this.mClientCallbacks.unregister(r8);     // Catch: Throwable -> L8
        CaeLog.d(TAG, "Client callback unregistered");     // Catch: Throwable -> L8
        if (this.mClientCallbacks.getRegisteredCallbackCount() != 0) goto L6;
        teardownSecondaryWifiConnection(true);     // Catch: Throwable -> L8
        CaeLog.d(TAG, "No more clients, secondary Wi-Fi disconnected.");     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized void requestSecondaryWifi(final String r11, final String r12, String r13, final String r14, final ISecondaryWifiCallback r15) {
        monitor-enter(this);
        final String r16 = normalizeSecurityType(r13, r14);     // Catch: Throwable -> L37
        WifiInfo r8 = getPrimaryWifiInfo();     // Catch: Throwable -> L37
        if (r8 != null) goto L7;
    L40:
        r15.onUnavailable();     // Catch: RemoteException -> L33 Throwable -> L37
    L35:
        monitor-exit(this);
        return;
    L33:
        e = move-exception;
        CaeLog.e(TAG, "Callback failed", e);     // Catch: Throwable -> L37
        goto L35
    L7:
        if (r8.getNetworkId() == (-1)) goto L40;
        if (r8.getSupplicantState().toString().equals("COMPLETED") == false) goto L40;
        String r10 = this.mCurrentConnectedSecondarySsid;     // Catch: Throwable -> L37
        if (r10 != null) goto L14;
    L18:
        boolean r17 = true;
        final int r18 = this.mRequestGeneration + 1;     // Catch: Throwable -> L37
        this.mRequestGeneration = r18;     // Catch: Throwable -> L37
        if (this.mNetworkCallback != null) goto L22;
        r17 = false;
    L22:
        unregisterNetworkCallbackIfNeeded();     // Catch: Throwable -> L37
        clearSecondaryWifiState();     // Catch: Throwable -> L37
        if (r17 == false) goto L28;
        this.mHandler.postDelayed(new a(this, r18, r15, r11, r12, r16, r14), 150);     // Catch: Throwable -> L37
        monitor-exit(this);
        return;
    L28:
        continueRequestSecondaryWifi(r11, r12, r16, r14, r15, r8);     // Catch: Throwable -> L37
        monitor-exit(this);
        return;
    L14:
        if (r10.equals(r12) == false) goto L18;
        CaeLog.d(TAG, "Already connected to SSID=" + r12 + ", skip new request.");     // Catch: Throwable -> L37
        monitor-exit(this);
        return;
    L37:
        th = move-exception;
        throw th;
    }

    public synchronized void unregisterSecondaryWifiListener(ISecondaryWifiCallback r8) {
        monitor-enter(this);
        this.mClientCallbacks.unregister(r8);     // Catch: Throwable -> L6
        CaeLog.d(TAG, "Client callback unregistered");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
