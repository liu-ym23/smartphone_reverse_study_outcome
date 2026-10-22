package com.obric.cae.smartNetwork.iplocateCountrycode;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.SystemProperties;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.obric.cae.log.CaeLog;
import com.obric.cae.utils.CaeUtil;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class IplocateCountryCode {
    private static final String IPLOCATE_COUNTRYCODE_INITED_PROPERTY = "persist.sys.wifi_countrycode_inited";
    private static int SOCKET_TIMEOUT_MS = 60000;
    private static final String TAG = "IplocateCountryCode";
    private static final String TOB_VERSION_PROPERTY = "ro.pxr.externalfunc";
    private static String[] countryCodesSupport = null;
    private static String factoryCountryCodePath = "/mnt/vendor/pvr/picoconfig/countryCode";
    private final ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private final NetworkCallbackImpl mNetworkCallback;

    public class NetworkCallbackImpl extends ConnectivityManager.NetworkCallback {
        final /* synthetic */ IplocateCountryCode this$0;

        private NetworkCallbackImpl(IplocateCountryCode r8) {
            this.this$0 = r8;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r8, NetworkCapabilities r10) {
            super.onCapabilitiesChanged(r8, r10);
            boolean r11 = r10.hasCapability(16);
            boolean r12 = r10.hasCapability(12);
            boolean r13 = r10.hasCapability(21);
            if (r11 == false) goto L15;
            if (r12 == false) goto L16;
            if (r13 == true) goto L7;
            return;
        L7:
            if (IplocateCountryCode.access$100(this.this$0) == false) goto L18;
            IplocateCountryCode.access$200(this.this$0);     // Catch: Exception -> L10
            return;
        L10:
            e = move-exception;
            CaeLog.e(IplocateCountryCode.TAG, e.toString());
            return;
        L18:
            return;
        L16:
            return;
        }

        public /* synthetic */ NetworkCallbackImpl(IplocateCountryCode r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public IplocateCountryCode(Context r8) {
        Context r10 = r8.getApplicationContext();
        this.mContext = r10;
        this.mConnectivityManager = (ConnectivityManager) r10.getSystemService("connectivity");
        this.mNetworkCallback = new NetworkCallbackImpl(this, null);
    }

    public static /* synthetic */ boolean access$100(IplocateCountryCode r8) {
        return r8.isNeedUpdateCountryCode();
    }

    public static /* synthetic */ int access$200(IplocateCountryCode r8) {
        return r8.updateCountryByIPLocate();
    }

    public static /* synthetic */ String access$300() {
        return getIpLocateCountryCode();
    }

    public static /* synthetic */ Context access$400(IplocateCountryCode r8) {
        return r8.mContext;
    }

    public static /* synthetic */ String[] access$500() {
        return countryCodesSupport;
    }

    public static /* synthetic */ String[] access$502(String[] r8) {
        countryCodesSupport = r8;
        return r8;
    }

    public static /* synthetic */ String access$600() {
        return getFactoryCountryCode();
    }

    private static String getFactoryCountryCode() {
        StringBuilder r8 = new StringBuilder();
        InputStreamReader r10 = null;
        FileInputStream r11 = new FileInputStream(factoryCountryCodePath);     // Catch: Throwable -> L28 Exception -> L30
    L81:
        InputStreamReader r12 = new InputStreamReader(r11);     // Catch: Throwable -> L24 Exception -> L26
    L69:
        int r13 = r12.read();     // Catch: Throwable -> L20 Exception -> L22
        if (r13 == (-1)) goto L8;
        r8.append((char) r13);     // Catch: Throwable -> L20 Exception -> L22
        goto L69
    L8:
        String r14 = r8.toString().trim();     // Catch: Throwable -> L20 Exception -> L22
        CaeLog.i(TAG, "read buf =" + r14);     // Catch: Exception -> L18 Throwable -> L20
    L75:
        r12.close();     // Catch: IOException -> L12
    L65:
        r11.close();     // Catch: IOException -> L16
    L45:
        if (isValid(r14) == true) goto L47;
        return null;
    L47:
        return r14;
    L16:
        e = move-exception;
        CaeLog.e(TAG, e.toString());
    L12:
        e = move-exception;
        CaeLog.e(TAG, e.toString());
    L18:
        e = move-exception;
        String r15 = r14;
        e = e;
        InputStreamReader r16 = r12;
        FileInputStream r17 = r11;
    L77:
        CaeLog.e(TAG, e.toString());     // Catch: Throwable -> L48
        if (r16 != null) goto L73;
    L38:
        if (r17 != null) goto L67;
    L43:
        r14 = r15;
        goto L45
    L67:
        r17.close();     // Catch: IOException -> L41
    L41:
        e = move-exception;
        CaeLog.e(TAG, e.toString());
        goto L43
    L73:
        r16.close();     // Catch: IOException -> L36
    L36:
        e = move-exception;
        CaeLog.e(TAG, e.toString());
    L48:
        th = th;
        r11 = r17;
        r10 = r16;
    L50:
        if (r10 != null) goto L71;
    L55:
        if (r11 == null) goto L85;
        r11.close();     // Catch: IOException -> L58
        throw th;
    L58:
        e = move-exception;
        CaeLog.e(TAG, e.toString());
        throw th;
    L85:
        throw th;
    L71:
        r10.close();     // Catch: IOException -> L53
    L53:
        e = move-exception;
        CaeLog.e(TAG, e.toString());
    L22:
        e = e;
        r16 = r12;
        r17 = r11;
        r15 = null;
    L20:
        th = th;
        r10 = r12;
        goto L50
    L26:
        e = e;
        r16 = null;
        r17 = r11;
        r15 = null;
    L24:
        th = th;
    L30:
        e = e;
        r15 = null;
        r17 = null;
        r16 = null;
    L28:
        th = th;
        r11 = null;
        goto L50
    }

    private static String getIpLocateCountryCode() {
        StringBuilder r8 = new StringBuilder();
        BufferedReader r10 = null;
        HttpURLConnection r11 = (HttpURLConnection) new URL("https://user-us.picovr.com/api/location/country?sn=" + getSnCode()).openConnection();     // Catch: Throwable -> L27 Exception -> L29
        r11.setRequestMethod(HttpMethodContrants.GET);     // Catch: Throwable -> L23 Exception -> L25
        r11.setConnectTimeout(SOCKET_TIMEOUT_MS);     // Catch: Throwable -> L23 Exception -> L25
        r11.setReadTimeout(SOCKET_TIMEOUT_MS);     // Catch: Throwable -> L23 Exception -> L25
        r11.setRequestProperty("Connection", "close");     // Catch: Throwable -> L23 Exception -> L25
        r11.setUseCaches(false);     // Catch: Throwable -> L23 Exception -> L25
        r11.setRequestProperty("User-Agent", "Mozilla/5.0");     // Catch: Throwable -> L23 Exception -> L25
        int r12 = r11.getResponseCode();     // Catch: Throwable -> L23 Exception -> L25
        if (r12 == 200) goto L9;
        CaeLog.i(TAG, "ip location fail Response Code: " + r12);     // Catch: Throwable -> L23 Exception -> L25
        r11.disconnect();     // Catch: Throwable -> L23 Exception -> L25
        r11.disconnect();
        return null;
    L9:
        BufferedReader r13 = new BufferedReader(new InputStreamReader(r11.getInputStream()));     // Catch: Throwable -> L23 Exception -> L25
    L79:
        String r14 = r13.readLine();     // Catch: Throwable -> L19 Exception -> L21
        if (r14 == null) goto L13;
        r8.append(r14);     // Catch: Throwable -> L19 Exception -> L21
        goto L79
    L13:
        CaeLog.i(TAG, "Response: " + r8.toString());     // Catch: Throwable -> L19 Exception -> L21
        r13.close();     // Catch: IOException -> L16
    L18:
        r11.disconnect();
    L66:
    L53:
        e = move-exception;
        CaeLog.e(TAG, e.toString());
        return null;
    L40:
        if (r8.length() != 0) goto L42;
        return null;
    L42:
        JSONObject r15 = new JSONObject(r8.toString());     // Catch: JSONException -> L53
        CaeLog.i(TAG, " code=" + r15.getString("code") + " em=" + r15.getString("em") + " et=" + r15.getString("et") + " data=" + r15.getString("data"));     // Catch: JSONException -> L53
        String r16 = r15.getString("data");     // Catch: JSONException -> L53
        if (r16 != null) goto L45;
        return null;
    L45:
        String r17 = new JSONObject(r16).getString("country");     // Catch: JSONException -> L53
        if (r17 != null) goto L48;
        return null;
    L48:
        String r18 = r17.toUpperCase(Locale.US);     // Catch: JSONException -> L53
        CaeLog.i(TAG, "iplocate country is " + r18);     // Catch: JSONException -> L53
        if (isValid(r18) == true) goto L52;
        return null;
    L52:
        return r18;
    L16:
        e = move-exception;
        CaeLog.e(TAG, e.toString());
        goto L18
    L21:
        e = move-exception;
        BufferedReader r19 = r13;
        e = e;
        HttpURLConnection r20 = r11;
    L72:
        CaeLog.e(TAG, e.toString());     // Catch: Throwable -> L56
        if (r19 != null) goto L70;
    L37:
        if (r20 == null) goto L66;
        r20.disconnect();
        goto L66
    L70:
        r19.close();     // Catch: IOException -> L35
    L35:
        e = move-exception;
        CaeLog.e(TAG, e.toString());
    L56:
        th = th;
        r10 = r19;
        r11 = r20;
    L58:
        if (r10 != null) goto L68;
    L63:
        if (r11 == null) goto L83;
        r11.disconnect();
        throw th;
    L83:
        throw th;
    L68:
        r10.close();     // Catch: IOException -> L61
    L61:
        e = move-exception;
        CaeLog.e(TAG, e.toString());
    L19:
        th = th;
        r10 = r13;
    L25:
        e = e;
        r20 = r11;
        r19 = null;
    L23:
        th = th;
        goto L58
    L29:
        e = e;
        r19 = null;
        r20 = null;
    L27:
        th = th;
        r11 = null;
        goto L58
    }

    private static String getSnCode() {
        return Build.getSerial();
    }

    private boolean isNeedUpdateCountryCode() {
        boolean r8 = "1".equals(SystemProperties.get(IPLOCATE_COUNTRYCODE_INITED_PROPERTY, ""));
        boolean r10 = "1".equals(SystemProperties.get(TOB_VERSION_PROPERTY, ""));
        boolean r11 = CaeUtil.isOverseaRomVersion();
        if (r8 == true) goto L9;
        if (r10 == true) goto L11;
        if (r11 == false) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    L9:
        return false;
    }

    private static boolean isValid(String r8) {
        if (r8 != null) goto L4;
    L8:
        return false;
    L4:
        if (r8.length() != 2) goto L8;
        if (r8.chars().allMatch(new a()) == false) goto L8;
        return true;
    }

    private int updateCountryByIPLocate() {
        new Thread(new AnonymousClass1(this)).start();
        return 0;
    }

    public void register() {
        this.mConnectivityManager.registerDefaultNetworkCallback(this.mNetworkCallback);
    }

    public void unregister() {
        this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
    }
}
