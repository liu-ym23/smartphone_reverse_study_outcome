package ce;

import ai.j0;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.crash.n;
import com.bytedance.crash.upload.i;
import com.bytedance.crash.upload.s;
import com.bytedance.crash.upload.t;
import com.bytedance.crash.upload.u;
import com.bytedance.crash.upload.v;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.lynx.jsbridge.LynxResourceModule;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import mh.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f1176c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f1177h;

    public b(String r5, boolean r10) {
        this.f1175b = r10;
        this.f1174a = "AAA" + System.currentTimeMillis() + "AAA";
        URL r11 = new URL(r5);
        SSLContext r12 = null;
        SSLContext r13 = SSLContext.getInstance("TLS");     // Catch: Throwable -> L17
        r13.init(null, null, null);     // Catch: Throwable -> L6
    L8:
        HttpsURLConnection r14 = (HttpsURLConnection) r11.openConnection();
        this.f1176c = r14;
        if (r13 == null) goto L11;
        io.reactivex.exceptions.a.l("MultipartUtility:setSSLSocketFactory");
        r14.setSSLSocketFactory(new u(r13.getSocketFactory()));
    L11:
        r14.setUseCaches(false);
        r14.setDoOutput(true);
        r14.setDoInput(true);
        r14.setRequestMethod("POST");
        r14.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.f1174a);
        this.g = new i4.a(9);
        if (r10 == false) goto L14;
        r14.setRequestProperty("Content-Encoding", "gzip");
        com.bytedance.crash.upload.c r15 = new com.bytedance.crash.upload.c(r14.getOutputStream());
        this.f = r15;
        this.e = new v(r15);
    L15:
        this.f1177h = new t(0);
        return;
    L14:
        com.bytedance.crash.upload.c r16 = new com.bytedance.crash.upload.c(r14.getOutputStream());
        this.f = r16;
        this.d = new i(r16);
    L6:
        r12 = r13;
    L7:
        r13 = r12;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [byte[], java.lang.Cloneable] */
    public t a(String r10) {
        ArrayList r5 = new ArrayList();
        byte[] r11 = ("\r\n--" + this.f1174a + "--\r\n").getBytes();
        if (this.f1175b == false) goto L5;
        v r12 = (v) this.e;
        r12.write(r11);
        r12.d();
        r12.b();
    L6:
        i4.a r13 = (i4.a) this.g;
        e.k((JSONObject) r13.f17502b, new Object[]{"data_type", r10});
        Object[] r14 = {"total_size", Long.valueOf(((com.bytedance.crash.upload.c) this.f).f4101a)};
        JSONObject r15 = (JSONObject) r13.f17503c;
        e.k(r15, r14);
        if (n.f4057a == null) goto L10;
        StringBuilder r16 = new StringBuilder("upload ");
        String r17 = (String) r13.d;
        r16.append(r17);
        r16.append(" ");
        r16.append(r15);
        r16.append(" ");
        JSONObject r18 = (JSONObject) r13.f17502b;
        r16.append(r18);
        io.reactivex.exceptions.a.i(r16.toString());
        l9.n.b(r17, r18, r15);
    L10:
        HttpsURLConnection r19 = (HttpsURLConnection) this.f1176c;
        int r20 = r19.getResponseCode();
        Map<String, List<String>> r21 = r19.getHeaderFields();
        t r22 = new t(0);
        this.f1177h = r22;
        r22.f4161c = r20;
        r22.f = r21;
        if (r20 != 200) goto L17;
        io.reactivex.exceptions.a.l("MultipartUtility:getResponseCode=" + r20);
        BufferedReader r23 = new BufferedReader(new InputStreamReader(r19.getInputStream()));
    L13:
        String r24 = r23.readLine();
        if (r24 == null) goto L16;
        r5.add(r24);
        goto L13
    L16:
        r23.close();
        r19.disconnect();
        io.reactivex.exceptions.a.i("success upload crash log");
    L18:
        StringBuilder r25 = new StringBuilder();
        Iterator r26 = r5.iterator();
    L20:
        if (r26.hasNext() == false) goto L32;
        r25.append((String) r26.next());
        goto L20
    L32:
        JSONObject r27 = new JSONObject(r25.toString());     // Catch: JSONException -> L24
    L25:
        ((t) this.f1177h).a(r27);
        s.k(r19.getURL(), (t) this.f1177h);     // Catch: Throwable -> L29
    L27:
        ((t) this.f1177h).e = r25.toString().getBytes();
        return (t) this.f1177h;
    L24:
        r27 = new JSONObject();
        ((t) this.f1177h).f4160b = ComposerKt.reuseKey;
        goto L25
    L17:
        r22.f4160b = ComposerKt.reuseKey;
        io.reactivex.exceptions.a.i("Server returned non-OK status: " + r20);
        goto L18
    L5:
        i r28 = (i) this.d;
        r28.write(r11);
        r28.flush();
        r28.b();
        goto L6
    }

    public void b(File r10, String r11) {
        com.bytedance.crash.upload.c r5 = (com.bytedance.crash.upload.c) this.f;
        r5.f4102b = r5.f4101a;
        f(r11, null);
        FileInputStream r12 = new FileInputStream(r10);
        byte[] r13 = new byte[8192];
    L3:
        int r14 = r12.read(r13);
        if (r14 == (-1)) goto L9;
        if (this.f1175b == true) goto L7;
        ((i) this.d).write(r13, 0, r14);
        goto L3
    L7:
        ((v) this.e).write(r13, 0, r14);
        goto L3
    L9:
        r12.close();
        j("\r\n".getBytes());
        String r15 = r11.concat("_size");
        long r16 = r5.f4101a;
        long r17 = r16 - r5.f4102b;
        r5.f4102b = r16;
        Object[] r18 = {r15, Long.valueOf(r17)};
        e.k((JSONObject) ((i4.a) this.g).f17503c, r18);
    }

    public void c(String r10, String r11) {
        JSONArray r5 = new JSONArray(r10);     // Catch: Exception -> L12
        int r12 = r5.length();     // Catch: Exception -> L12
        int r13 = 0;
    L4:
        if (r13 >= r12) goto L23;
        JSONObject r14 = r5.getJSONObject(r13);     // Catch: Exception -> L12
        d r15 = new d();     // Catch: Exception -> L12
        r15.f1178a = r14.getString("__msg_type");     // Catch: Exception -> L12
        r15.f1179b = r14.optString("__callback_id", null);     // Catch: Exception -> L12
        r15.f1180c = r14.optString("func");     // Catch: Exception -> L12
        r15.d = r14.optJSONObject(LynxResourceModule.PARAMS_KEY);     // Catch: Exception -> L12
        r15.e = r14.optInt("JSSDK");     // Catch: Exception -> L12
        r15.f = r14.optString("namespace");     // Catch: Exception -> L12
        r15.g = r14.optString("__iframe_url");     // Catch: Exception -> L12
        r15.f1181h = r11;     // Catch: Exception -> L12
        Log.i("IESJsBridge", "safeV1AuthUrl: " + r11);     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r15.f1178a) == true) goto L14;
        if (TextUtils.isEmpty(r15.f1180c) == true) goto L14;
        Log.d("JsBridge", "parseMsQueue:" + Thread.currentThread());     // Catch: Exception -> L12
        Message r16 = Message.obtain();     // Catch: Exception -> L12
        r16.obj = r15;     // Catch: Exception -> L12
        ((bb.b) this.f1177h).sendMessage(r16);     // Catch: Exception -> L12
    L14:
        r13 = r13 + 1;
        goto L4
    L23:
        return;
    L12:
        e = move-exception;
        androidx.room.jarjarred.org.antlr.runtime.a.A(e, "e =", "JsBridge");
    }

    public void d(String r5, String r10, JSONObject r11) {
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L4
        r12.put("__msg_type", "callback");     // Catch: Exception -> L4
        r12.put("__callback_id", r10);     // Catch: Exception -> L4
        r12.put("__params", r11);     // Catch: Exception -> L4
        i(r12, r5);     // Catch: Exception -> L4
        return;
    }

    public void e(String r10, String r11, boolean r12) {
        com.bytedance.crash.upload.c r5 = (com.bytedance.crash.upload.c) this.f;
        r5.f4102b = r5.f4101a;
        StringBuilder r13 = new StringBuilder("--");
        androidx.constraintlayout.motion.widget.a.C(r13, this.f1174a, "\r\nContent-Disposition: form-data; name=\"", r10, "\"\r\nContent-Type: text/plain; charset=UTF-8\r\n\r\n");
        j(r13.toString().getBytes());     // Catch: IOException -> L10
    L4:
        byte[] r14 = r11.getBytes();
        if (r12 == false) goto L12;
        ((com.lynx.tasm.behavior.d) n.f4062j.getEncryptImpl()).getClass();
        r14 = EncryptorUtil.a(r14.length, r14);
    L12:
        j(r14);     // Catch: IOException -> L11
        j("\r\n".getBytes());     // Catch: IOException -> L11
    L8:
        String r15 = r10.concat("_size");
        long r16 = r5.f4101a;
        long r17 = r16 - r5.f4102b;
        r5.f4102b = r16;
        Object[] r18 = {r15, Long.valueOf(r17)};
        e.k((JSONObject) ((i4.a) this.g).f17503c, r18);
    }

    public void f(String r5, HashMap r10) {
        StringBuilder r11 = new StringBuilder("--");
        f8.b.e(r11, this.f1174a, "\r\nContent-Disposition: form-data; name=\"", r5, "\"; filename=\"");
        r11.append(r5);
        r11.append("\"");
        if (r10 == null) goto L8;
        Iterator r12 = r10.entrySet().iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        Map.Entry r13 = (Map.Entry) r12.next();
        r11.append("; ");
        r11.append((String) r13.getKey());
        r11.append("=\"");
        r11.append((String) r13.getValue());
        r11.append("\"");
    L8:
        r11.append("\r\nContent-Transfer-Encoding: binary\r\n\r\n");
        j(r11.toString().getBytes());
    }

    public void g(String r5, JSONObject r10) {
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L4
        r11.put("__msg_type", "callback");     // Catch: Exception -> L4
        r11.put("__callback_id", r5);     // Catch: Exception -> L4
        r11.put("__params", r10);     // Catch: Exception -> L4
        h(r11);     // Catch: Exception -> L4
        return;
    }

    public void h(JSONObject r5) {
        SSWebView r10 = (SSWebView) this.f1176c;
        if (r10 == null) goto L20;
        String r11 = "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + r5.toString() + ")";
        if (r11 != null) goto L7;
    L16:
        r10.loadUrl(r11);     // Catch: Throwable -> L15
        return;
    L22:
        return;
    L7:
        if (r11.startsWith("javascript:") == false) goto L16;
        r10.evaluateJavascript(r11, null);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        boolean r12 = th instanceof IllegalStateException;
        goto L16
    }

    public void i(JSONObject r5, String r10) {
        SSWebView r11 = (SSWebView) this.f1176c;
        if (r11 == null) goto L20;
        String r12 = j0.q(androidx.constraintlayout.motion.widget.a.y("javascript:(function(){   const iframe = document.querySelector(atob('", Base64.encodeToString(("iframe[src=\"" + r10 + "\"").getBytes(), 2), "'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(", r5.toString(), ", atob('"), Base64.encodeToString(r10.getBytes(), 2), "'));   }})()");
        if (r12 != null) goto L7;
    L16:
        r11.loadUrl(r12);     // Catch: Throwable -> L15
        return;
    L22:
        return;
    L7:
        if (r12.startsWith("javascript:") == false) goto L16;
        r11.evaluateJavascript(r12, null);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        boolean r13 = th instanceof IllegalStateException;
        goto L16
    }

    public void j(byte[] r5) {
        if (this.f1175b == false) goto L6;
        ((v) this.e).write(r5);
        return;
    L6:
        ((i) this.d).write(r5);
    }

    public void k(c5.a... r10) {
        com.bytedance.crash.upload.c r5 = (com.bytedance.crash.upload.c) this.f;
        r5.f4102b = r5.f4101a;
        f("file", null);
        if (this.f1175b == false) goto L5;
        cl.a.r((v) this.e, r10);
    L6:
        j("\r\n".getBytes());
        long r11 = r5.f4101a;
        long r12 = r11 - r5.f4102b;
        r5.f4102b = r11;
        Object[] r13 = {"file_size", Long.valueOf(r12)};
        e.k((JSONObject) ((i4.a) this.g).f17503c, r13);
        return;
    L5:
        cl.a.r((i) this.d, r10);
        goto L6
    }

    public boolean l(String r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.startsWith(this.f1174a) == true) goto L8;
        return false;
    L8:
        String r5 = j0.q(new StringBuilder(), this.f1174a, "://dispatch_message/");
        String r11 = j0.q(new StringBuilder(), this.f1174a, "://private/setresult/");
        SSWebView r12 = (SSWebView) this.f1176c;     // Catch: Exception -> L17
        String r13 = r12.getUrl();     // Catch: Exception -> L17
        if (r10.equals(r5) == false) goto L14;
        r12.evaluateJavascript("javascript:ToutiaoJSBridge._fetchQueue()", new a(this, r13));     // Catch: Exception -> L17
        return true;
    L14:
        if (r10.startsWith(r11) == false) goto L16;
        return true;
    L16:
        return false;
    }
}
