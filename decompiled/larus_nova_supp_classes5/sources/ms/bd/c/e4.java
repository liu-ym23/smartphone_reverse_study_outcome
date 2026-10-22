package ms.bd.c;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.CdnCacheVerifyException;
import com.bytedance.frameworks.baselib.network.http.exception.ClientProtocolException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.exception.NoHttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NotAllowApiHttpException;
import com.bytedance.frameworks.baselib.network.http.exception.NotAllowUseNetworkException;
import com.bytedance.frameworks.baselib.network.http.parser.StreamParser;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.mobsec.matrix.utils.m.TN;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.IMetricsCollect;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e4 extends h2 {
    public e4() {
    }

    public static int b(String r22) {
        if (r22 != null) goto L5;
        return 80000;
    L5:
        if ("" == r22) goto L27;
        JSONObject r1 = new JSONObject(r22).getJSONObject((String) p2.a(16777217, 0, 0, "560137", new byte[]{38, 53, 80, 64}));     // Catch: Throwable -> L18
        if (r1 == null) goto L24;
        String r2 = r1.getString((String) p2.a(16777217, 0, 0, "f8f32b", new byte[]{100, 46, 20, 83, 24, 102}));     // Catch: Throwable -> L18
        if (r2 != null) goto L13;
    L17:
        return 80002;
    L13:
        if (((String) p2.a(16777217, 0, 0, "c52fc5", new byte[]{65, 2, 98, 49, 121, 17, 83})) == r2) goto L17;
        return r1.getInt((String) p2.a(16777217, 0, 0, "7597a1", new byte[]{40, 50, 94, 124, 91, 52, 38, 27, 122}));
    L24:
        return 80001;
    L18:
        return 80003;
    L27:
        return 80000;
    }

    public static String c(List r9) {
        if (r9 != null) goto L5;
    L17:
        return null;
    L5:
        if (r9.size() <= 0) goto L17;
        Iterator r10 = r9.iterator();
    L9:
        if (r10.hasNext() == false) goto L17;
        Header r1 = (Header) r10.next();
        if (r1 == null) goto L9;
        if (((String) p2.a(16777217, 0, 0, "cdf479", new byte[]{106, 43, 1, 84, 69, 34, 111, 66, 62, 96})).equalsIgnoreCase(r1.getName()) == false) goto L9;
        return r1.getValue();
    }

    public static int f(String r14) {
        if (r14 != null) goto L5;
        return -1;
    L5:
        if ("" == r14) goto L13;
        return new JSONObject(r14).getJSONObject((String) p2.a(16777217, 0, 0, "c7a8d0", new byte[]{96, 48, 1, 92, 84, 41, 115, 19})).getInt((String) p2.a(16777217, 0, 0, "9ebd4d", new byte[]{43, 104, 21, 21}));
    L14:
        return -1;
    L13:
        return -1;
    }

    public static int a(Call r1, SsResponse r2) {
        if (r1 == null) goto L19;
        if (r2 != null) goto L6;
        return 80004;
    L6:
        if ((r1 instanceof IMetricsCollect) == false) goto L17;
        ((IMetricsCollect) r1).doCollect();
        Response r3 = r2.raw();
        if (r3 == null) goto L16;
        Object r4 = r3.getExtraInfo();
        if ((r4 instanceof HttpRequestInfo) == false) goto L15;
        HttpRequestInfo r5 = (HttpRequestInfo) r4;
        if (r5 != null) goto L21;
        return 80008;
    L21:
        return b(((BaseHttpRequestInfo) r5).requestLog);
    L15:
        return 80007;
    L16:
        return 80006;
    L17:
        return 80005;
    L19:
        return 80004;
    }

    public static int e(Call r2, SsResponse r3) {
        if (r2 == null) goto L16;
        if (r3 != null) goto L7;
        return -1;
    L7:
        if ((r2 instanceof IMetricsCollect) == false) goto L17;
        ((IMetricsCollect) r2).doCollect();
        Response r4 = r3.raw();
        if (r4 == null) goto L18;
        Object r5 = r4.getExtraInfo();
        if ((r5 instanceof HttpRequestInfo) == false) goto L19;
        HttpRequestInfo r6 = (HttpRequestInfo) r5;
        if (r6 != null) goto L15;
        return -1;
    L15:
        return f(((BaseHttpRequestInfo) r6).requestLog);
    L19:
        return -1;
    L18:
        return -1;
    L17:
        return -1;
    L16:
        return -1;
    }

    public static Object[] d(String r39, byte[] r40, String r41, String r42, HashMap r43, String r44, boolean r45) {
        e2 r3 = new e2();
        ArrayList r15 = new ArrayList();     // Catch: Throwable -> L69
        r15.add(new Header((String) p2.a(16777217, 0, 0, "2f487e", new byte[]{0, 107, 72, 71, 1, 119}), ((String) p2.a(16777217, 0, 0, "6973ce", new byte[]{52, 62, 87, 84, 85, 125, 59, 17, 98, 62})) + r41));     // Catch: Throwable -> L69
        r15.add(new Header((String) p2.a(16777217, 0, 0, "48b1f2", new byte[]{4, 57, 18, 64, 73, 49}), (String) p2.a(16777217, 0, 0, "6a817b", new byte[]{109, 44, 1})));     // Catch: Throwable -> L69
        r15.add(new Header((String) p2.a(16777217, 0, 0, "9d7a9b", new byte[]{29, 117, 65, 7, 75, 84, 61, 64, 104, 37}), (String) p2.a(16777217, 0, 0, "d2c210", new byte[]{87, 41, 4, 67, 42, 38, 105, 16, 55, 47, 88, 3, 35, 98, 37})));     // Catch: Throwable -> L69
        r15.add(new Header((String) p2.a(16777217, 0, 0, "a920c4", new byte[]{83, 52, 79, 80, 89, 45, 118, 85, 87, 121, 96, 62}), (String) p2.a(16777217, 0, 0, "2c647a", new byte[]{34, 113, 85, 76, 1, 117, 48, 86, 110, 107, 45, 46, 74, 67, 28, 115, 37, 15, 116, 112, 49, 100, 68, 77})));     // Catch: Throwable -> L69
        if (r43 == null) goto L12;
        if (r43.size() <= 0) goto L12;
        Iterator r5 = r43.entrySet().iterator();     // Catch: Throwable -> L69
    L9:
        if (r5.hasNext() == false) goto L12;
        Map.Entry r6 = (Map.Entry) r5.next();     // Catch: Throwable -> L69
        r15.add(new Header((String) r6.getKey(), (String) r6.getValue()));     // Catch: Throwable -> L69
    L12:
        if (r42 != null) goto L14;
    L16:
        TN r1 = (TN) RetrofitUtils.getSsRetrofit(r39).create(TN.class);     // Catch: Throwable -> L69
        if (r45 == false) goto L19;
        Call r2 = r1.p1(r39, r15, new TypedByteArray((String) p2.a(16777217, 0, 0, "04fe6d", new byte[]{32, 38, 5, 29, 0, 112, 50, 1, 62, 58, 47, 121, 26, 18, 29, 118, 39, 88, 36, 33, 51, 51, 20, 28}), r40, new String[0]));     // Catch: Throwable -> L69
    L140:
        r3.b = r39;     // Catch: Throwable -> L67
        r3.a = System.currentTimeMillis();     // Catch: Throwable -> L67
        SsResponse r4 = r2.execute();     // Catch: Throwable -> L67
        int r7 = r4.code();     // Catch: Throwable -> L65
        String r29 = c(r4.headers());     // Catch: Throwable -> L63
        monitor-enter(z3.class);     // Catch: Throwable -> L63
        z3 r0 = z3.b;     // Catch: Throwable -> L59
        monitor-exit(z3.class);     // Catch: Throwable -> L63
        if (r0 == null) goto L32;
        long r8 = System.currentTimeMillis();     // Catch: Throwable -> L63
        long r9 = r3.a;     // Catch: Throwable -> L63
        long r23 = r8 - r9;     // Catch: Throwable -> L63
        String r10 = r3.b;     // Catch: Throwable -> L63
        SDKMonitor r11 = r0.a;     // Catch: Throwable -> L63
        if (r11 == null) goto L32;
        r11.monitorSLA(r23, r9, r10, null, r29, r7, null);     // Catch: Throwable -> L63
    L32:
        if (r44 == null) goto L35;
        PolarisFileOutputStreamWrapper r12 = new PolarisFileOutputStreamWrapper(r44);     // Catch: Throwable -> L63
    L34:
        PolarisFileOutputStreamWrapper r13 = r12;
        InputStream r14 = ((TypedInput) r4.body()).in();     // Catch: Throwable -> L57
        byte[] r16 = new byte[1024];     // Catch: Throwable -> L55
    L40:
        int r17 = r14.read(r16, 0, 1024);     // Catch: Throwable -> L55
        if (r17 <= 0) goto L43;
        r13.write(r16, 0, r17);     // Catch: Throwable -> L55
        goto L40
    L43:
        r13.flush();     // Catch: Throwable -> L55
        if ((r13 instanceof ByteArrayOutputStream) == false) goto L47;
        byte[] r18 = ((ByteArrayOutputStream) r13).toByteArray();     // Catch: Throwable -> L55
        int r19 = 200;
    L48:
        if (r7 == r19) goto L50;
        int r20 = a(r2, r4);
    L52:
        if (r7 != (-1)) goto L54;
        r7 = e(r2, r4);
    L54:
        StreamParser.safeClose(r14);
        StreamParser.safeClose(r13);
        r2.cancel();
    L125:
        return new Object[]{String.valueOf(r7), r18, Integer.valueOf(r20)};
    L50:
        r20 = 0;
        goto L52
    L47:
        r19 = 200;
        r18 = null;
    L55:
        th = th;
    L74:
        int r21 = c2.COLLECT_MODE_DEFAULT;
    L126:
        th = move-exception;
        if (r7 == 200) goto L132;
        if (r21 != 0) goto L132;
        a(r2, r4);
    L132:
        if (r7 != (-1)) goto L134;
        e(r2, r4);
    L134:
        StreamParser.safeClose(r14);
        StreamParser.safeClose(r13);
        if (r2 == null) goto L137;
        r2.cancel();
    L137:
        throw th;
    L76:
        if ((th instanceof UnsupportedOperationException) == false) goto L79;
        r21 = 90000;
    L79:
        if ((th instanceof CdnCacheVerifyException) == false) goto L82;
        r21 = 90001;
    L82:
        if ((th instanceof ClientProtocolException) == false) goto L85;
        r21 = 90002;
    L85:
        if ((th instanceof HttpResponseException) == false) goto L88;
        r21 = 90003;
    L88:
        if ((th instanceof NetworkNotAvailabeException) == false) goto L91;
        r21 = 90004;
    L91:
        if ((th instanceof NoHttpResponseException) == false) goto L94;
        r21 = 90005;
    L94:
        if ((th instanceof NotAllowApiHttpException) == false) goto L97;
        r21 = 90006;
    L97:
        if ((th instanceof NotAllowUseNetworkException) == false) goto L100;
        r21 = 90007;
    L100:
        if ((th instanceof CronetIOException) == false) goto L107;
        CronetIOException r22 = th;     // Catch: Throwable -> L126
        r21 = b(r22.getRequestLog());     // Catch: Throwable -> L126
        if (r21 < 80000) goto L105;
        r21 = 90009;
    L105:
        if (r7 != (-1)) goto L107;
        r7 = f(r22.getRequestLog());     // Catch: Throwable -> L126
    L107:
        String r24 = (String) p2.a(16777217, 0, 0, "862049", new byte[]{61, 60, 66, 123, 3, 63});     // Catch: Throwable -> L126
        if (r4 == null) goto L110;
        String r25 = c(r4.headers());     // Catch: Throwable -> L126
    L111:
        r3.a(r25, r7);     // Catch: Throwable -> L126
        if (r7 == 200) goto L116;
        if (r21 != 0) goto L116;
        r20 = a(r2, r4);
    L118:
        if (r7 != (-1)) goto L120;
        r7 = e(r2, r4);
    L120:
        StreamParser.safeClose(r14);
        StreamParser.safeClose(r13);
        if (r2 == null) goto L123;
        r2.cancel();
    L123:
        r18 = null;
    L116:
        r20 = r21;
        goto L118
    L110:
        r25 = null;
    L57:
        th = th;
    L73:
        r14 = null;
        goto L74
    L35:
        r12 = new ByteArrayOutputStream();     // Catch: Throwable -> L63
        goto L34
    L59:
        th = move-exception;
        throw th;     // Catch: Throwable -> L63
    L63:
        th = th;
        r13 = null;
    L65:
        th = th;
    L72:
        r13 = null;
        r7 = -1;
    L67:
        th = th;
    L71:
        r4 = null;
        goto L72
    L19:
        r2 = r1.p2(r39, r15);     // Catch: Throwable -> L69
        goto L140
    L14:
        if (r42.trim().length() <= 0) goto L16;
        r15.add(new Header((String) p2.a(16777217, 0, 0, "1d0235", new byte[]{56, 43, 87, 82, 65, 48, 55, 84, 116, 103, 51, 114, 14, 82, 13, 37}), r42));     // Catch: Throwable -> L69
    L69:
        th = th;
        r2 = null;
        goto L71
    }
}
