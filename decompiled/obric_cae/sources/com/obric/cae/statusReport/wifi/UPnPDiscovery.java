package com.obric.cae.statusReport.wifi;

import android.os.SystemClock;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.obric.cae.log.CaeLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class UPnPDiscovery {
    private static final String DEFAULT_ADDRESS = "239.255.255.250";
    private static final int DEFAULT_DISCOVERY_RETRY_COUNT = 3;
    private static final int DEFAULT_DISCOVERY_TIMEOUT = 6000;
    private static final int DEFAULT_HTTP_SOCKET_TIMEOUT = 3000;
    private static final int DEFAULT_PORT = 1900;
    private static final String DEFAULT_QUERY = "M-SEARCH * HTTP/1.1\r\nHOST: 239.255.255.250:1900\r\nMAN: \"ssdp:discover\"\r\nMX: 1\r\nST: urn:schemas-upnp-org:device:InternetGatewayDevice:1\r\n\r\n";
    private static final int DEFAULT_UDP_SOCKET_TIMEOUT = 2000;
    private static final String LINE_END = "\r\n";
    private static final String TAG = "UPnPDiscovery";
    private final HashSet<UPnPDevice> mDevices;
    private final ArrayList<String> mHosts;

    public UPnPDiscovery() {
        ArrayList<String> r8 = new ArrayList();
        this.mHosts = r8;
        HashSet<UPnPDevice> r10 = new HashSet();
        this.mDevices = r10;
        r8.clear();
        r10.clear();
    }

    private String getHttpContent(String r8) {
        StringBuilder r10 = new StringBuilder();
        BufferedReader r11 = null;
        HttpURLConnection r12 = (HttpURLConnection) new URL(r8).openConnection();     // Catch: Throwable -> L26 Exception -> L28
        r12.setRequestMethod(HttpMethodContrants.GET);     // Catch: Exception -> L24 Throwable -> L39
        r12.setConnectTimeout(3000);     // Catch: Exception -> L24 Throwable -> L39
        r12.setReadTimeout(3000);     // Catch: Exception -> L24 Throwable -> L39
        r12.setRequestProperty("Connection", "close");     // Catch: Exception -> L24 Throwable -> L39
        r12.setUseCaches(false);     // Catch: Exception -> L24 Throwable -> L39
        r12.setRequestProperty("User-Agent", "Mozilla/5.0");     // Catch: Exception -> L24 Throwable -> L39
        int r13 = r12.getResponseCode();     // Catch: Exception -> L24 Throwable -> L39
        if (r13 == 200) goto L9;
        CaeLog.i(TAG, "get UPnP location url:" + r8 + " response code:" + r13);     // Catch: Exception -> L24 Throwable -> L39
        r12.disconnect();     // Catch: Exception -> L24 Throwable -> L39
        r12.disconnect();
        return "";
    L9:
        BufferedReader r14 = new BufferedReader(new InputStreamReader(r12.getInputStream()));     // Catch: Exception -> L24 Throwable -> L39
    L57:
        String r15 = r14.readLine();     // Catch: Throwable -> L20 Exception -> L22
        if (r15 == null) goto L13;
        r10.append(r15);     // Catch: Throwable -> L20 Exception -> L22
        goto L57
    L13:
        String r16 = r10.toString();     // Catch: Throwable -> L20 Exception -> L22
        r14.close();     // Catch: IOException -> L16
    L18:
        r12.disconnect();
        return r16;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    L22:
        e = move-exception;
        r11 = r14;
        e = e;
    L30:
        e.printStackTrace();     // Catch: Throwable -> L39
        if (r11 != null) goto L50;
    L36:
        if (r12 == null) goto L38;
        r12.disconnect();
    L38:
        return "";
    L50:
        r11.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L20:
        th = th;
        r11 = r14;
    L40:
        if (r11 != null) goto L52;
    L45:
        if (r12 == null) goto L60;
        r12.disconnect();
        throw th;
    L60:
        throw th;
    L52:
        r11.close();     // Catch: IOException -> L43
    L43:
        e = move-exception;
        e.printStackTrace();
    L24:
        e = e;
        goto L30
    L39:
        th = th;
    L28:
        e = e;
        r12 = null;
    L26:
        th = th;
        r12 = null;
        goto L40
    }

    private String parseUPnPHeader(String r8, String r10) {
        int r11 = r8.indexOf(r10);
        if (r11 == (-1)) goto L7;
        int r12 = r10.length() + r11;
        int r13 = r8.indexOf(LINE_END, r12);
        if (r13 == (-1)) goto L7;
        return r8.substring(r12, r13);
    L7:
        return "";
    }

    private boolean parseUPnPPacket(String r8, String r10) {
        String r11 = parseUPnPHeader(r10, "LOCATION: ");
        if (r11.length() > 7) goto L7;
        String r12 = "get location length error";
    L5:
        CaeLog.i(TAG, r12);
        return false;
    L7:
        String r13 = "";
        int r14 = 0;
    L9:
        if (r14 >= 3) goto L15;
        r13 = getHttpContent(r11);
        if (r13.isEmpty() == false) goto L15;
        SystemClock.sleep(500);
        r14 = r14 + 1;
    L15:
        if (r13.isEmpty() == false) goto L17;
        r12 = "get http content length error";
        goto L5
    L17:
        UPnPDevice r15 = new UPnPDevice(r8, r11);
        if (r15.parseXmlData(r13) == true) goto L20;
        r12 = "parse UPnP xml data error";
        goto L5
    L20:
        this.mDevices.add(r15);
        return true;
    }

    private void receiveDiscoveryResponse(DatagramSocket r8) {
        long r10 = System.currentTimeMillis();
        long r11 = System.currentTimeMillis();
    L4:
        if ((r10 - r11) >= 6000) goto L27;
        DatagramPacket r12 = new DatagramPacket(new byte[2048], 2048);     // Catch: Throwable -> L18 IOException -> L20
        r8.receive(r12);     // Catch: Throwable -> L18 IOException -> L20 SocketTimeoutException -> L30
        String r13 = new String(r12.getData(), 0, r12.getLength());     // Catch: Throwable -> L18 IOException -> L20
        String r14 = r12.getAddress().getHostAddress();     // Catch: Throwable -> L18 IOException -> L20
        if (this.mHosts.contains(r14) == true) goto L9;
        if (r13.length() <= 12) goto L9;
        if (r13.substring(0, 12).equalsIgnoreCase("HTTP/1.1 200") == false) goto L9;
        if (parseUPnPPacket(r14, r13) == false) goto L9;
        this.mHosts.add(r14);     // Catch: Throwable -> L18 IOException -> L20
    L9:
        r10 = System.currentTimeMillis();     // Catch: Throwable -> L18 IOException -> L20
        goto L4
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L18
        if (r8 == null) goto L42;
    L28:
        r8.close();
        return;
    L42:
        return;
    L18:
        th = move-exception;
        if (r8 == null) goto L26;
        r8.close();
    L26:
        throw th;
    L27:
        if (r8 != null) goto L28;
    }

    private void sendDiscoveryAndReceive(String r8, int r10, String r11) {
        this.mHosts.clear();
        DatagramSocket r12 = null;
        int r13 = 0;
    L4:
        if (r13 >= 3) goto L9;
        r12 = sendDiscoveryPacket(r8, r10, r11);
        if (r12 != null) goto L9;
        SystemClock.sleep(1000);
        r13 = r13 + 1;
    L9:
        if (r12 != null) goto L12;
        CaeLog.e(TAG, "send UPnP discovery packet error.");
        return;
    L12:
        receiveDiscoveryResponse(r12);
    }

    private DatagramSocket sendDiscoveryPacket(String r8, int r10, String r11) {
        DatagramSocket r12 = new DatagramSocket(null);     // Catch: Exception -> L6
        InetAddress r13 = InetAddress.getByName(r8);     // Catch: Exception -> L10
        r12.setReuseAddress(true);     // Catch: Exception -> L10
        r12.setBroadcast(true);     // Catch: Exception -> L10
        r12.setSoTimeout(2000);     // Catch: Exception -> L10
        r12.send(new DatagramPacket(r11.getBytes(), r11.length(), r13, r10));     // Catch: Exception -> L10
        return r12;
    L7:
        if (r12 == null) goto L9;
        r12.close();
    L9:
        return null;
    L6:
        r12 = null;
        goto L7
    }

    public HashSet<UPnPDevice> discoveryUPnPDevices() {
        return discoveryUPnPDevices(DEFAULT_ADDRESS, DEFAULT_PORT, DEFAULT_QUERY);
    }

    public HashSet<UPnPDevice> getDevices() {
        return this.mDevices;
    }

    public HashSet<UPnPDevice> discoveryUPnPDevices(String r8, int r10, String r11) {
        this.mHosts.clear();
        this.mDevices.clear();
        sendDiscoveryAndReceive(r8, r10, r11);
        return this.mDevices;
    }
}
