package com.tencent.open.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.log.SLog;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.tauth.IRequestListener;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class HttpUtils {

    public static class HttpStatusException extends Exception {
        public static final String ERROR_INFO = "http status code error:";
        public final int statusCode;

        public HttpStatusException(int r3) {
            super(ERROR_INFO + r3);
            this.statusCode = r3;
        }

        public HttpStatusException(String r1) {
            super(r1);
            this.statusCode = -1;
        }
    }

    public static class NetworkUnavailableException extends Exception {
        public static final String ERROR_INFO = "network unavailable";

        public NetworkUnavailableException(String r1) {
            super(r1);
        }
    }

    public static class a {
        public final String a;
        public final int b;

        private a(String r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public /* synthetic */ a(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }
    }

    private HttpUtils() {
    }

    private static Map<String, String> a(Bundle r7) {
        HashMap r0 = new HashMap();
        if (r7 != null) goto L5;
    L25:
        return r0;
    L5:
        if (r7.size() == 0) goto L25;
        Iterator<String> r1 = r7.keySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L25;
        String r2 = r1.next();
        Object r3 = r7.get(r2);
        if ((r3 instanceof String) == true) goto L16;
        if ((r3 instanceof String[]) == true) goto L16;
        SLog.w("openSDK_LOG.HttpUtils", "parseBundleToMap: the type " + r3.getClass() + " is unsupported");
    L16:
        if ((r3 instanceof String[]) == true) goto L17;
        r0.put(r2, (String) r3);
        goto L9
    L17:
        String[] r4 = (String[]) r3;
        StringBuilder r5 = new StringBuilder();
        int r6 = 0;
    L19:
        if (r6 >= r4.length) goto L23;
        if (r6 == 0) goto L22;
        r5.append(",");
    L22:
        r5.append(r4[r6]);
        r6 = r6 + 1;
        goto L19
    L23:
        r0.put(r2, r5.toString());
        goto L9
    }

    private static Map<String, byte[]> b(Bundle r5) {
        HashMap r0 = new HashMap(0);
        if (r5 != null) goto L5;
    L14:
        return r0;
    L5:
        if (r5.size() == 0) goto L14;
        Iterator<String> r1 = r5.keySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L14;
        String r2 = r1.next();
        Object r3 = r5.get(r2);
        if ((r3 instanceof byte[]) == false) goto L9;
        r0.put(r2, (byte[]) r3);
        goto L9
    }

    public static String encodeUrl(Map<String, String> r5) {
        if (r5 != null) goto L4;
        return BuildConfig.FLAVOR;
    L4:
        if (r5.size() == 0) goto L21;
        StringBuilder r0 = new StringBuilder();
        Iterator<String> r1 = r5.keySet().iterator();
        boolean r2 = true;
    L8:
        if (r1.hasNext() == false) goto L15;
        String r3 = r1.next();
        if (r2 == false) goto L12;
        r2 = false;
    L13:
        r0.append(URLEncoder.encode(r3));
        r0.append("=");
        r0.append(URLEncoder.encode(r5.get(r3)));
        goto L8
    L12:
        r0.append("&");
        goto L13
    L15:
        return r0.toString();
    L21:
        return BuildConfig.FLAVOR;
    }

    public static int getErrorCodeFromException(IOException r1) {
        if ((r1 instanceof CharConversionException) == false) goto L7;
        return -20;
    L7:
        if ((r1 instanceof MalformedInputException) == false) goto L11;
        return -21;
    L11:
        if ((r1 instanceof UnmappableCharacterException) == false) goto L15;
        return -22;
    L15:
        if ((r1 instanceof ClosedChannelException) == false) goto L19;
        return -24;
    L19:
        if ((r1 instanceof EOFException) == false) goto L23;
        return -26;
    L23:
        if ((r1 instanceof FileLockInterruptionException) == false) goto L27;
        return -27;
    L27:
        if ((r1 instanceof FileNotFoundException) == false) goto L31;
        return -28;
    L31:
        if ((r1 instanceof HttpRetryException) == false) goto L35;
        return -29;
    L35:
        if ((r1 instanceof SocketTimeoutException) == false) goto L39;
        return -8;
    L39:
        if ((r1 instanceof InvalidPropertiesFormatException) == false) goto L43;
        return -30;
    L43:
        if ((r1 instanceof MalformedURLException) == false) goto L47;
        return -3;
    L47:
        if ((r1 instanceof InvalidClassException) == false) goto L51;
        return -33;
    L51:
        if ((r1 instanceof InvalidObjectException) == false) goto L55;
        return -34;
    L55:
        if ((r1 instanceof NotActiveException) == false) goto L59;
        return -35;
    L59:
        if ((r1 instanceof NotSerializableException) == false) goto L63;
        return -36;
    L63:
        if ((r1 instanceof OptionalDataException) == false) goto L67;
        return -37;
    L67:
        if ((r1 instanceof StreamCorruptedException) == false) goto L71;
        return -38;
    L71:
        if ((r1 instanceof WriteAbortedException) == false) goto L75;
        return -39;
    L75:
        if ((r1 instanceof ProtocolException) == false) goto L79;
        return -40;
    L79:
        if ((r1 instanceof SSLHandshakeException) == false) goto L83;
        return -41;
    L83:
        if ((r1 instanceof SSLKeyException) == false) goto L87;
        return -42;
    L87:
        if ((r1 instanceof SSLPeerUnverifiedException) == false) goto L91;
        return -43;
    L91:
        if ((r1 instanceof SSLProtocolException) == false) goto L95;
        return -44;
    L95:
        if ((r1 instanceof BindException) == false) goto L99;
        return -45;
    L99:
        if ((r1 instanceof ConnectException) == false) goto L103;
        return -46;
    L103:
        if ((r1 instanceof NoRouteToHostException) == false) goto L107;
        return -47;
    L107:
        if ((r1 instanceof PortUnreachableException) == false) goto L111;
        return -48;
    L111:
        if ((r1 instanceof SyncFailedException) == false) goto L115;
        return -49;
    L115:
        if ((r1 instanceof UTFDataFormatException) == false) goto L119;
        return -50;
    L119:
        if ((r1 instanceof UnknownHostException) == false) goto L123;
        return -51;
    L123:
        if ((r1 instanceof UnknownServiceException) == false) goto L127;
        return -52;
    L127:
        if ((r1 instanceof UnsupportedEncodingException) == false) goto L131;
        return -53;
    L131:
        if ((r1 instanceof ZipException) == false) goto L134;
        return -54;
    L134:
        return -2;
    }

    public static a getProxy(Context r3) {
        AnonymousClass1 r0 = null;
        if (r3 != null) goto L5;
        return null;
    L5:
        ConnectivityManager r1 = (ConnectivityManager) r3.getSystemService("connectivity");
        if (r1 != null) goto L21;
        return null;
    L21:
        NetworkInfo r2 = r1.getActiveNetworkInfo();     // Catch: Exception -> L10
    L11:
        if (r2 != null) goto L14;
        return null;
    L14:
        if (r2.getType() != 0) goto L20;
        String r4 = b(r3);
        int r5 = a(r3);
        if (TextUtils.isEmpty(r4) == true) goto L20;
        if (r5 < 0) goto L20;
        return new a(r4, r5, r0);
    L20:
        return null;
    L10:
        r2 = null;
        goto L11
    }

    private static int a(Context r1) {
        String r2 = System.getProperty("http.proxyPort");
        if (TextUtils.isEmpty(r2) == false) goto L9;
    L6:
        return -1;
    L9:
        return CastIntegerProtector.parseInt(r2);
    }

    private static String b(Context r0) {
        return System.getProperty("http.proxyHost");
    }

    public static String encodeUrl(Bundle r0) {
        return encodeUrl(a(r0));
    }

    private static com.tencent.open.a.g a(String r4, String r5, Bundle r6) throws IOException {
        if (r6 == null) goto L4;
        Bundle r0 = new Bundle(r6);
    L6:
        if (r5.equalsIgnoreCase("GET") == false) goto L13;
        Map<String, String> r7 = a(r0);
        Bundle r8 = com.tencent.open.log.d.b(r0);
        if (r8 == r0) goto L10;
        SLog.i("openSDK_LOG.HttpUtils", "-->openUrl encodedParam =" + r8.toString() + " -- url = " + r4);
    L24:
        return com.tencent.open.a.f.a().a(r4, r7);
    L10:
        SLog.i("openSDK_LOG.HttpUtils", "-->openUrl encodedParam =" + r7.toString() + " -- url = " + r4);
        goto L24
    L13:
        if (r5.equalsIgnoreCase("POST") == false) goto L22;
        Map<String, String> r9 = a(r0);
        Map<String, byte[]> r10 = b(r0);
        if (r10 == null) goto L21;
        if (r10.size() == 0) goto L21;
        SLog.w("openSDK_LOG.HttpUtils", "openUrl: has binary " + r10.size());
        return com.tencent.open.a.f.a().a(r4, r9, r10);
    L21:
        return com.tencent.open.a.f.a().b(r4, r9);
    L22:
        SLog.e("openSDK_LOG.HttpUtils", "openUrl: http method " + r5 + " is not supported.");
        throw new IOException("http method is not supported.");
    L4:
        r0 = new Bundle();
        goto L6
    }

    private static void a(Context r2, QQToken r3, String r4) {
        if (r4.indexOf("add_share") <= (-1)) goto L5;
    L18:
        com.tencent.connect.a.a.a(r2, r3, "requireApi", new String[]{r4});
        return;
    L5:
        if (r4.indexOf("upload_pic") > (-1)) goto L18;
        if (r4.indexOf("add_topic") > (-1)) goto L18;
        if (r4.indexOf("set_user_face") > (-1)) goto L18;
        if (r4.indexOf("add_t") > (-1)) goto L18;
        if (r4.indexOf("add_pic_t") > (-1)) goto L18;
        if (r4.indexOf("add_pic_url") > (-1)) goto L18;
        if (r4.indexOf("add_video") > (-1)) goto L18;
    }

    public static JSONObject request(QQToken r21, Context r22, String r23, Bundle r24, String r25) throws IOException, JSONException, NetworkUnavailableException, HttpStatusException {
        SLog.i("openSDK_LOG.HttpUtils", "OpenApi request");
        if (m.b(r22) == false) goto L53;
        if (r23.toLowerCase().startsWith("http") == true) goto L7;
        String r2 = j.a().a(r22, "https://openmobile.qq.com/") + r23;
        String r13 = j.a().a(r22, "https://openmobile.qq.com/") + r23;
    L8:
        a(r22, r21, r23);
        long r5 = SystemClock.elapsedRealtime();
        int r0 = i.a(r22, r21.getAppId()).a("Common_HttpRetryCount");
        SLog.v("OpenConfig_test", "config 1:Common_HttpRetryCount            config_value:" + r0 + "   appid:" + r21.getAppId() + "     url:" + r13);
        if (r0 != 0) goto L11;
        int r1 = 3;
    L12:
        SLog.v("OpenConfig_test", "config 1:Common_HttpRetryCount            result_value:" + r1 + "   appid:" + r21.getAppId() + "     url:" + r13);
        int r4 = 0;
        JSONObject r14 = null;
        long r15 = r5;
    L13:
        int r12 = r4 + 1;
        com.tencent.open.a.g r3 = a(r2, r25, r24);     // Catch: JSONException -> L31 IOException -> L34 MalformedURLException -> L37 SocketTimeoutException -> L40
        int r8 = r3.d();     // Catch: JSONException -> L31 IOException -> L34 MalformedURLException -> L37 SocketTimeoutException -> L40
        SLog.i("openSDK_LOG.HttpUtils", "request statusCode " + r8);     // Catch: JSONException -> L31 IOException -> L34 MalformedURLException -> L37 SocketTimeoutException -> L40
        if (r8 != 200) goto L26;
        JSONObject r6 = m.d(r3.a());     // Catch: JSONException -> L31 IOException -> L34 MalformedURLException -> L37 SocketTimeoutException -> L40
        int r7 = JSONObjectProtectorUtils.getInt(r6, "ret");     // Catch: SocketTimeoutException -> L19 JSONException -> L21 IOException -> L34 MalformedURLException -> L37
    L22:
        long r9 = r3.c();     // Catch: SocketTimeoutException -> L19 JSONException -> L31 IOException -> L34 MalformedURLException -> L37
        long r10 = r3.b();     // Catch: SocketTimeoutException -> L19 JSONException -> L31 IOException -> L34 MalformedURLException -> L37
        r14 = r6;
        int r16 = r7;
        long r11 = r9;
    L47:
        com.tencent.open.b.h.a().a(r13, r15, r11, r10, r16);
        return r14;
    L21:
        r7 = -4;
    L19:
        e = e;
        r14 = r6;
    L43:
        e.printStackTrace();
        r16 = -8;
        r11 = 0;
        r10 = 0;
        if (r12 >= r1) goto L50;
        r15 = SystemClock.elapsedRealtime();
        if (r12 >= r1) goto L47;
        r4 = r12;
        r2 = r2;
        goto L13
    L50:
        com.tencent.open.b.h.a().a(r13, r15, 0, 0, -8);
        throw e;
    L26:
        r2 = r2;
        com.tencent.open.b.h.a().a(r13, r15, 0, 0, r8);     // Catch: SocketTimeoutException -> L29 JSONException -> L31 IOException -> L34 MalformedURLException -> L37
        throw new HttpStatusException(r8);     // Catch: SocketTimeoutException -> L29 JSONException -> L31 IOException -> L34 MalformedURLException -> L37
    L29:
        e = e;
        goto L43
    L40:
        e = e;
    L31:
        e = move-exception;
        e.printStackTrace();
        com.tencent.open.b.h.a().a(r13, r15, 0, 0, -4);
        throw e;
    L37:
        e = move-exception;
        e.printStackTrace();
        com.tencent.open.b.h.a().a(r13, r15, 0, 0, -3);
        throw e;
    L34:
        e = move-exception;
        e.printStackTrace();
        com.tencent.open.b.h.a().a(r13, r15, 0, 0, getErrorCodeFromException(e));
        throw e;
    L11:
        r1 = r0;
        goto L12
    L7:
        r2 = r23;
        r13 = r2;
        goto L8
    L53:
        throw new NetworkUnavailableException(NetworkUnavailableException.ERROR_INFO);
    }

    public static void requestAsync(final QQToken r9, final Context r10, final String r11, final Bundle r12, final String r13, final IRequestListener r14) {
        SLog.i("openSDK_LOG.HttpUtils", "OpenApi requestAsync");
        l.a(new AnonymousClass1(r9, r10, r11, r12, r13, r14));
    }
}
