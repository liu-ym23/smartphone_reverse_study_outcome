package dxb;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officewebview.util.NetWorkUtils;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class o implements Runnable {
    public final /* synthetic */ cxb.a a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ Boolean e;
    public final /* synthetic */ Uri f;

    public o(cxb.a r1, int r2, String r3, boolean r4, Boolean r5, Uri r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final void a() {
        g r0 = new g("wb_load_received_error", c.e, this.a);
        r0.a(UniContext.KEY_OF_ERROR_CODE, Integer.valueOf(this.b));
        r0.a(UniContext.KEY_OF_ERROR_MSG, this.c);
        r0.a("error_type", "normal");
        r0.a("is_first_page", Boolean.valueOf(this.d));
        r0.a("is_main_frame", this.e);
        Uri r1 = this.f;
        int r2 = this.b;
        t.b(r0, r1);
        if (r2 == (-10)) goto L12;
        if (r2 == (-8)) goto L12;
        if (r2 == (-6)) goto L12;
        if (r2 == (-2)) goto L12;
    L125:
        r0.b();
        return;
    L12:
        if (NetWorkUtils.a() == true) goto L14;
        Object r3 = "";
    L35:
        r0.a("device_ip", r3);
        r0.a("network_type", NetWorkUtils.c());
        int r5 = 0;
        if (NetWorkUtils.a() == true) goto L141;
    L44:
        boolean r4 = false;
    L45:
        r0.a("vpn_is_open", Boolean.valueOf(r4));
        if (NetWorkUtils.a() == true) goto L48;
        ArrayList r6 = new ArrayList();
    L64:
        r0.a("local_dns_server", r6);
        if (r1 == null) goto L125;
        String r7 = r1.getHost();
        boolean r8 = TextUtils.isEmpty(r7);
        float r9 = 0.0f;
        Float r10 = Float.valueOf(0.0f);
        if (r8 == false) goto L70;
        Pair r11 = new Pair("", r10);
    L112:
        r0.a("host_ping_result", r11.first);
        r0.a("host_ping_duration", r11.second);
        goto L125
    L70:
        if (NetWorkUtils.a() == true) goto L72;
        r11 = new Pair("", r10);
        goto L112
    L72:
        OutputStream r12 = null;
        InputStream r13 = null;
        r13 = null;
        r12 = null;
        Process r14 = NetWorkUtils.b(Runtime.getRuntime(), "ping -c 3 " + r7);     // Catch: Throwable -> L96 Exception -> L98
        OutputStream r15 = r14.getOutputStream();     // Catch: Throwable -> L96 Exception -> L98
        r15.close();     // Catch: Throwable -> L92 Exception -> L94
        long r16 = System.nanoTime();     // Catch: Throwable -> L92 Exception -> L94
        r13 = r14.getInputStream();     // Catch: Throwable -> L92 Exception -> L94
        BufferedReader r17 = new BufferedReader(new InputStreamReader(r13, "UTF8"));     // Catch: Throwable -> L92 Exception -> L94
        JSONArray r18 = new JSONArray();     // Catch: Throwable -> L92 Exception -> L94
    L75:
        String r19 = r17.readLine();     // Catch: Throwable -> L92 Exception -> L94
        if (r19 == null) goto L82;
        r18.put(r19);     // Catch: Throwable -> L92 Exception -> L94
        if (r19.contains("From") == true) goto L81;
        if (r19.contains("from") == false) goto L75;
    L81:
        r9 = (System.nanoTime() - r16) / 1000000.0f;     // Catch: Throwable -> L92 Exception -> L94
        goto L75
    L82:
        r14.destroy();     // Catch: Throwable -> L92 Exception -> L94
        r11 = new Pair(r18.toString(), Float.valueOf(r9));     // Catch: Throwable -> L92 Exception -> L94
        r15.close();     // Catch: IOException -> L85
    L87:
        if (r13 == null) goto L112;
        r13.close();     // Catch: IOException -> L90
    L90:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("NetWorkUtils", e);
    L85:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("NetWorkUtils", e);
        goto L87
    L94:
        e = e;
        InputStream r110 = r13;
        r12 = r15;
        InputStream r20 = r110;
    L139:
        com.ss.android.lark.officesdk.utils.di.j.d("NetWorkUtils", e);     // Catch: Throwable -> L113
        if (r12 != null) goto L137;
    L106:
        if (r20 != null) goto L129;
    L111:
        r11 = new Pair("", r10);
        goto L112
    L129:
        r20.close();     // Catch: IOException -> L109
    L109:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("NetWorkUtils", e);
        goto L111
    L137:
        r12.close();     // Catch: IOException -> L104
    L104:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("NetWorkUtils", e);
    L113:
        th = th;
    L114:
        if (r12 != null) goto L131;
    L119:
        if (r20 == null) goto L177;
        r20.close();     // Catch: IOException -> L122
        throw th;
    L122:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("NetWorkUtils", e);
        throw th;
    L177:
        throw th;
    L131:
        r12.close();     // Catch: IOException -> L117
    L117:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("NetWorkUtils", e);
    L92:
        th = th;
        InputStream r111 = r13;
        r12 = r15;
        r20 = r111;
        goto L114
    L98:
        e = e;
        r20 = null;
    L96:
        th = th;
        r20 = null;
        goto L114
    L48:
        r6 = new ArrayList();
        int r21 = com.ss.android.lark.officesdk.utils.di.d.a;     // Catch: Exception -> L62
        ConnectivityManager r22 = (ConnectivityManager) com.ss.android.lark.officesdk.utils.di.d.a.a().getSystemService("connectivity");     // Catch: Exception -> L62
        NetworkInfo r23 = r22.getActiveNetworkInfo();     // Catch: Exception -> L62
        Network[] r24 = r22.getAllNetworks();     // Catch: Exception -> L62
        int r25 = r24.length;     // Catch: Exception -> L62
    L50:
        if (r5 >= r25) goto L64;
        Network r112 = r24[r5];     // Catch: Exception -> L62
        NetworkInfo r113 = r22.getNetworkInfo(r112);     // Catch: Exception -> L62
        if (r113 == null) goto L61;
        if (r23 == null) goto L61;
        if (r113.getType() != r23.getType()) goto L61;
        Iterator<InetAddress> r114 = r22.getLinkProperties(r112).getDnsServers().iterator();     // Catch: Exception -> L62
    L58:
        if (r114.hasNext() == false) goto L61;
        r6.add(r114.next().getHostAddress());     // Catch: Exception -> L62
    L61:
        r5 = r5 + 1;
    L62:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("NetWorkUtils", e);
        goto L64
    L141:
        int r26 = com.ss.android.lark.officesdk.utils.di.d.a;     // Catch: Exception -> L42
        NetworkInfo r27 = ((ConnectivityManager) com.ss.android.lark.officesdk.utils.di.d.a.a().getSystemService("connectivity")).getNetworkInfo(17);     // Catch: Exception -> L42
        if (r27 == null) goto L44;
        r4 = r27.isConnected();     // Catch: Exception -> L42
    L42:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("NetWorkUtils", e);
        goto L44
    L14:
        r3 = "none";
        Enumeration<NetworkInterface> r28 = NetworkInterface.getNetworkInterfaces();     // Catch: SocketException -> L33
    L16:
        if (r28.hasMoreElements() == false) goto L35;
        NetworkInterface r29 = r28.nextElement();     // Catch: SocketException -> L33
        String r30 = r29.getName();     // Catch: SocketException -> L33
        if (r30 == null) goto L16;
        if (TextUtils.equals(r30.toLowerCase(), "eth0") == true) goto L24;
        if (TextUtils.equals(r30.toLowerCase(), "wlan0") == false) goto L16;
    L24:
        Enumeration<InetAddress> r31 = r29.getInetAddresses();     // Catch: SocketException -> L33
    L26:
        if (r31.hasMoreElements() == false) goto L16;
        InetAddress r32 = r31.nextElement();     // Catch: SocketException -> L33
        if ((r32 instanceof Inet4Address) == false) goto L26;
        if (r32.isLoopbackAddress() == true) goto L26;
        r3 = r32.getHostAddress();     // Catch: SocketException -> L33
    L33:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("NetWorkUtils", e);
        goto L35
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
