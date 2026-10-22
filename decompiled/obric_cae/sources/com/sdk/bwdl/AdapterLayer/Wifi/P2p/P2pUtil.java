package com.sdk.bwdl.AdapterLayer.Wifi.P2p;

import android.content.Context;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pGroup;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import com.sdk.bwdl.Utils.BWDLLog;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class P2pUtil {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+-=";
    private static final String P2P_PATTERN = "(?i)p2p";
    private static final String TAG = "P2pAdapter";

    public P2pUtil() {
    }

    public static byte[] convertCapabilitiesToByteArray(WifiCapabilities r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        JSONObject r10 = new JSONObject();
        r10.put("wifi_ap_enabled", r8.isWifiApEnabled);     // Catch: JSONException -> L9
        r10.put("enabled", r8.isEnabled);     // Catch: JSONException -> L9
        r10.put("connected", r8.isConnected);     // Catch: JSONException -> L9
        r10.put("support_dual_band", r8.isSupportDualBand);     // Catch: JSONException -> L9
        r10.put("supported_5ghz", r8.isSupported5GHz);     // Catch: JSONException -> L9
        r10.put("frequency", r8.frequency);     // Catch: JSONException -> L9
        BWDLLog.d(TAG, "convert local device wifi capabilities:\n" + r10.toString());
        return r10.toString().getBytes(StandardCharsets.UTF_8);
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static byte[] convertConfigToByteArray(WifiP2pGroup r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        JSONObject r10 = new JSONObject();
        r10.put("ssid", r8.getNetworkName());     // Catch: JSONException -> L9
        r10.put("psk", r8.getPassphrase());     // Catch: JSONException -> L9
        r10.put("freq", r8.getFrequency());     // Catch: JSONException -> L9
        BWDLLog.d(TAG, "convert p2pconfig:" + r10.toString());
        return r10.toString().getBytes(StandardCharsets.UTF_8);
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static String generateRandomPassword(int r8) {
        SecureRandom r10 = new SecureRandom();
        StringBuilder r11 = new StringBuilder(r8);
        int r12 = 0;
    L3:
        if (r12 >= r8) goto L6;
        r11.append(CHARACTERS.charAt(r10.nextInt(76)));
        r12 = r12 + 1;
        goto L3
    L6:
        return r11.toString();
    }

    public static String getAndroidId(Context r8) {
        return Settings.Secure.getString(r8.getContentResolver(), "android_id");
    }

    public static InetAddress getLocalP2pAddress() {
        Iterator r8 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();     // Catch: Exception -> L15
    L5:
        if (r8.hasNext() == false) goto L14;
        NetworkInterface r10 = (NetworkInterface) r8.next();     // Catch: Exception -> L15
        if (Pattern.compile(P2P_PATTERN).matcher(r10.getName()).find() == false) goto L5;
        Iterator r11 = Collections.list(r10.getInetAddresses()).iterator();     // Catch: Exception -> L15
    L10:
        if (r11.hasNext() == false) goto L5;
        InetAddress r12 = (InetAddress) r11.next();     // Catch: Exception -> L15
        if ((r12 instanceof Inet4Address) == false) goto L10;
        return r12;
    L14:
        return null;
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static WifiCapabilities parseByteArrayToCapabilities(byte[] r8) {
        JSONObject r10 = new JSONObject(new String(r8, StandardCharsets.UTF_8));     // Catch: JSONException -> L5
        boolean r11 = r10.getBoolean("wifi_ap_enabled");     // Catch: JSONException -> L5
        boolean r12 = r10.getBoolean("enabled");     // Catch: JSONException -> L5
        boolean r13 = r10.getBoolean("connected");     // Catch: JSONException -> L5
        boolean r14 = r10.getBoolean("support_dual_band");     // Catch: JSONException -> L5
        boolean r15 = r10.getBoolean("supported_5ghz");     // Catch: JSONException -> L5
        int r16 = r10.getInt("frequency");     // Catch: JSONException -> L5
        WifiCapabilities.Builder r17 = new WifiCapabilities.Builder();     // Catch: JSONException -> L5
        r17.setWifiApEnabled(r11);     // Catch: JSONException -> L5
        r17.setEnabled(r12);     // Catch: JSONException -> L5
        r17.setConnected(r13);     // Catch: JSONException -> L5
        r17.setSupportDualBand(r14);     // Catch: JSONException -> L5
        r17.setSupported5GHz(r15);     // Catch: JSONException -> L5
        r17.setFrequency(r16);     // Catch: JSONException -> L5
        WifiCapabilities r18 = r17.build();     // Catch: JSONException -> L5
        BWDLLog.d(TAG, "parse peer device wifi capabilities:\n" + r18.toString());
        return r18;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static WifiP2pConfig parseByteArrayToConfig(byte[] r8) {
        WifiP2pConfig r10 = null;
        JSONObject r11 = new JSONObject(new String(r8, StandardCharsets.UTF_8));     // Catch: JSONException -> L5
        String r12 = r11.getString("ssid");     // Catch: JSONException -> L5
        String r13 = r11.getString("psk");     // Catch: JSONException -> L5
        int r14 = r11.getInt("freq");     // Catch: JSONException -> L5
        WifiP2pConfig.Builder r15 = new WifiP2pConfig.Builder();     // Catch: JSONException -> L5
        r15.enablePersistentMode(false);     // Catch: JSONException -> L5
        r15.setGroupOperatingFrequency(r14);     // Catch: JSONException -> L5
        r15.setNetworkName(r12);     // Catch: JSONException -> L5
        r15.setPassphrase(r13);     // Catch: JSONException -> L5
        r10 = r15.build();     // Catch: JSONException -> L5
        BWDLLog.d(TAG, "parse p2pconfig:" + r11.toString());     // Catch: JSONException -> L5
        return r10;
    L5:
        e = move-exception;
        e.printStackTrace();
        return r10;
    }

    public static void sendMessageWithParam(Handler r8, int r10) {
        Message.obtain(r8, r10).sendToTarget();
    }

    public static void sendMessageWithParam(Handler r8, int r10, Object r11) {
        Message.obtain(r8, r10, r11).sendToTarget();
    }
}
