package a5;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.crash.service.INetworkCallback;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o2.f;
import o2.g;

/* JADX INFO: loaded from: classes.dex */
public class c {

    class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ HttpURLConnection f109a;

        a(String r10, HttpURLConnection r11) {
            this.f109a = r11;
        }

        @Override // o2.g
        public void a() {
            HttpURLConnection r10 = this.f109a;     // Catch: Throwable -> L6
            if (r10 == null) goto L9;
            r10.disconnect();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }
    }

    public static String a(String r10, Map<String, String> r11, Map<String, List<String>> r12, a5.a r13) {
        HttpURLConnection r14 = null;
        if (com.bytedance.common.utility.g.b(r10) == true) goto L90;
        if (r13 == null) goto L90;
        if (NetworkUtils.g(TTNetInit.getTTNetDepend().getContext()) == true) goto L94;
        return null;
    L94:
    L83:
        th = th;
    L98:
        th.printStackTrace();     // Catch: Throwable -> L86
        throw th;     // Catch: Throwable -> L86
    L86:
        th = move-exception;
        if (r14 != null) goto L96;
    L89:
        throw th;
    L96:
        r14.disconnect();     // Catch: Exception -> L93
        goto L89
    L10:
        if (r13.f103c == false) goto L25;
        String r15 = f.c(r10, true);     // Catch: Throwable -> L83
        if (TextUtils.isEmpty(r15) == true) goto L25;
        if (r15.equals(r10) == false) goto L24;
        StringBuilder r16 = new StringBuilder(r15);     // Catch: Throwable -> L83
        if (r15.indexOf(63) >= 0) goto L19;
        String r17 = "?";
    L18:
        r16.append(r17);     // Catch: Throwable -> L83
        r16.append("aid=");     // Catch: Throwable -> L83
        r16.append(TTNetInit.getTTNetDepend().getAppId());     // Catch: Throwable -> L83
        r16.append("&device_platform=");     // Catch: Throwable -> L83
        r16.append("android");     // Catch: Throwable -> L83
        if (TTNetInit.getCronetProvider() == null) goto L23;
        r16.append("&version_code=");     // Catch: Throwable -> L83
        r16.append(TTNetInit.getCronetProvider().getVersionCode());     // Catch: Throwable -> L83
        r16.append("&channel=");     // Catch: Throwable -> L83
        r16.append(TTNetInit.getCronetProvider().getChannel());     // Catch: Throwable -> L83
        r16.append("device_id");     // Catch: Throwable -> L83
        r16.append(TTNetInit.getCronetProvider().getDeviceId());     // Catch: Throwable -> L83
    L23:
        r10 = r16.toString();     // Catch: Throwable -> L83
        goto L25
    L19:
        r17 = "&";
        goto L18
    L24:
        r10 = r15;
    L25:
        HttpURLConnection r18 = (HttpURLConnection) new URL(r10).openConnection();     // Catch: Throwable -> L83
        r18.setRequestMethod("GET");     // Catch: Throwable -> L81
        r18.setConnectTimeout(f.j());     // Catch: Throwable -> L81
        r18.setReadTimeout(f.p());     // Catch: Throwable -> L81
        r18.setInstanceFollowRedirects(true);     // Catch: Throwable -> L81
        r18.setRequestProperty(NetConst.KEY_ACCEPT_ENCODING, NetConst.GZIP);     // Catch: Throwable -> L81
        if (r13.f102b == false) goto L29;
        String r19 = " HttpsURLConnection";
    L30:
        r18.setRequestProperty("User-Agent", INetworkCallback.TYPE_TTNET + r19);     // Catch: Throwable -> L81
        if (r11 != null) goto L33;
    L38:
        int r110 = r18.getResponseCode();     // Catch: Throwable -> L81
        if (r12 == null) goto L51;
        if (r18.getHeaderFields() == null) goto L51;
        Map<String, List<String>> r20 = r18.getHeaderFields();     // Catch: Throwable -> L81
        if (r20 == null) goto L51;
        Iterator<Map.Entry<String, List<String>>> r21 = r20.entrySet().iterator();     // Catch: Throwable -> L81
    L46:
        if (r21.hasNext() == false) goto L51;
        Map.Entry<String, List<String>> r22 = r21.next();     // Catch: Throwable -> L81
        String r23 = r22.getKey();     // Catch: Throwable -> L81
        if (TextUtils.isEmpty(r23) == true) goto L46;
        r12.put(r23.toLowerCase(), r22.getValue());     // Catch: Throwable -> L81
    L51:
        if (r13.f102b == true) goto L53;
        r18.getHeaderField("X-SS-SIGN");     // Catch: Throwable -> L81
    L53:
        r13.f104d = r18.getHeaderField("x-ss-etag");     // Catch: Throwable -> L81
        r13.f105e = r18.getHeaderField("x-tt-tnc-abtest");     // Catch: Throwable -> L81
        r13.f106f = r18.getHeaderField("x-tt-tnc-control");     // Catch: Throwable -> L81
        r13.f107g = r18.getHeaderField("x-tt-tnc-config");     // Catch: Throwable -> L81
        r13.f108h = r18.getHeaderField("x-ss-canary");     // Catch: Throwable -> L81
        r18.getHeaderField("x-tt-tnc-query-region");     // Catch: Throwable -> L81
        r18.getHeaderField("x-tt-logid");     // Catch: Throwable -> L81
        if (r110 != 200) goto L80;
        InputStream r24 = r18.getInputStream();     // Catch: Throwable -> L81
        boolean r25 = NetConst.GZIP.equals(r18.getHeaderField(NetConst.KEY_CONTENT_ENCODING));     // Catch: Throwable -> L81
        String r111 = r18.getHeaderField(NetConst.KEY_CONTENT_TYPE);     // Catch: Throwable -> L81
        boolean r112 = z2.d.n(r111);     // Catch: Throwable -> L81
        Pair<String, String> r113 = RetrofitUtils.j(r111);     // Catch: Throwable -> L81
        if (r113 == null) goto L62;
        Object r114 = r113.second;     // Catch: Throwable -> L81
        if (r114 == null) goto L62;
        if (Charset.isSupported((String) r114) == false) goto L62;
        String r115 = (String) r113.second;     // Catch: Throwable -> L81
    L63:
        if (r115 != null) goto L65;
        r115 = "UTF-8";
    L65:
        int[] r116 = {0};     // Catch: Throwable -> L81
        byte[] r117 = z2.d.k(r25, r18.getHeaderFields(), -1, r24, r116, new a(r10, r18));     // Catch: Throwable -> L81
        if (r117 != null) goto L68;
    L100:
        r18.disconnect();     // Catch: Exception -> L92
    L78:
        return null;
    L68:
        if (r116[0] <= 0) goto L100;
        if (r116[0] > r117.length) goto L100;
        if (r112 == false) goto L74;
        z2.d.a(r117, r116[0]);     // Catch: Throwable -> L81
    L74:
        String r118 = new String(r117, 0, r116[0], r115);     // Catch: Throwable -> L81
        r18.disconnect();     // Catch: Exception -> L91
    L76:
        return r118;
    L62:
        r115 = null;
        goto L63
    L80:
        throw new IOException("err status = " + r110);     // Catch: Throwable -> L81
    L33:
        if (r11.size() <= 0) goto L38;
        Iterator<Map.Entry<String, String>> r119 = r11.entrySet().iterator();     // Catch: Throwable -> L81
    L36:
        if (r119.hasNext() == false) goto L38;
        Map.Entry<String, String> r26 = r119.next();     // Catch: Throwable -> L81
        r18.setRequestProperty(r26.getKey(), r26.getValue());     // Catch: Throwable -> L81
        goto L36
    L29:
        r19 = " HttpURLConnection";
    L81:
        th = th;
        r14 = r18;
    L90:
        return null;
    }
}
