package i7;

import a9.f;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import l7.g;
import org.json.JSONObject;
import w6.e;

/* JADX INFO: loaded from: classes.dex */
public class a implements Interceptor {
    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse intercept(Interceptor.Chain r18) {
        Long r8 = Long.valueOf(SystemClock.uptimeMillis());
        Request r10 = r18.request();
        int r11 = 0;
        URL r12 = new URL(r10.getUrl());     // Catch: MalformedURLException -> L361
        if (r12.getProtocol().equals("http") == false) goto L6;
        e.c(r12.getHost(), r12.getPath(), false);     // Catch: MalformedURLException -> L361
    L6:
        e.d r13 = e.f13020a;
        Long r14 = Long.valueOf(SystemClock.uptimeMillis());
        String r15 = r10.getUrl();
        if ((r10.getExtraInfo() instanceof w6.b) == false) goto L9;
        w6.b r16 = (w6.b) r10.getExtraInfo();
        e.a(r15);
    L11:
        if (r10.getMetrics() == null) goto L14;
        r10.getMetrics().filterUrlDuration = SystemClock.uptimeMillis() - r14.longValue();
    L14:
        if (r10.getUrl().startsWith("https:") == true) goto L16;
    L18:
        Long r17 = Long.valueOf(SystemClock.uptimeMillis());
        if (r10.isAddCommonParam() == false) goto L28;
        x6.a.a().getClass();
        e.a r19 = e.f13022c;     // Catch: Throwable -> L25
        if (r19 == null) goto L28;
        r15 = r19.addCommonParams(r15, true);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.printStackTrace();
    L28:
        if (r10.getMetrics() == null) goto L30;
        r10.getMetrics().addCommonParamDuration = SystemClock.uptimeMillis() - r17.longValue();
    L30:
        Request.Builder r20 = r10.newBuilder();
        r20.url(r15);
        Request r21 = r20.build();
        if (r21 != null) goto L33;
        Request r22 = null;
    L163:
        if (r22.getMetrics() == null) goto L165;
        r22.getMetrics().requestInterceptDuration.put("BaseSsInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r8.longValue()));
    L165:
        SsResponse r23 = r18.proceed(r22);
        Long r24 = Long.valueOf(SystemClock.uptimeMillis());
        if (r23 == null) goto L355;
        Response r25 = r23.raw();
        Long r26 = Long.valueOf(SystemClock.uptimeMillis());
        e.d r27 = e.f13020a;     // Catch: Throwable -> L171
    L174:
        if (r22.getMetrics() == null) goto L176;
        r22.getMetrics().commandListenerDuration = SystemClock.uptimeMillis() - r26.longValue();
    L176:
        ClientKeyManager r28 = ClientKeyManager.d();
        monitor-enter(r28);
    L358:
        th = move-exception;
        throw th;
    L179:
        if (ClientKeyManager.f4079h != null) goto L181;
    L246:
        monitor-exit(r28);
        Long r29 = Long.valueOf(SystemClock.uptimeMillis());
        Object r30 = r25.getExtraInfo();
        if ((r30 instanceof a9.c) == false) goto L268;
        a9.c r31 = (a9.c) r30;
        if (r31.f12991b == 0) goto L383;
        JSONObject r110 = new JSONObject();
        List<Header> r111 = r25.getHeaders();
        int r112 = 0;
    L253:
        if (r112 >= r111.size()) goto L264;
        Header r32 = r111.get(r112);     // Catch: Exception -> L261
        if (r32 == null) goto L263;
        if (TextUtils.isEmpty(r32.getName()) == true) goto L263;
        r110.put(r32.getName().toUpperCase(), r32.getValue());     // Catch: Exception -> L261
    L263:
        r112 = r112 + 1;
    L261:
        e = move-exception;
        e.printStackTrace();
        goto L263
    L264:
        T r33 = r31.f12991b;
        if ((r33 instanceof f) == false) goto L267;
        ((f) r33).getClass();
    L267:
        f r34 = (f) r31.f12991b;
        r25.getStatus();
        r34.getClass();
        ((f) r31.f12991b).getClass();
    L383:
        r22.getUrl();     // Catch: Throwable -> L276
        Header r35 = r22.getFirstHeader("X-SS-REQ-TICKET");     // Catch: Throwable -> L276
        if (r35 == null) goto L272;
        r35.getValue();     // Catch: Throwable -> L276
    L272:
        Header r36 = r25.getFirstHeader("X-SS-REQ-TICKET");     // Catch: Throwable -> L276
        if (r36 == null) goto L278;
        r36.getValue();     // Catch: Throwable -> L276
    L278:
        int r113 = 2;
        String r37 = r22.getUrl();     // Catch: Throwable -> L314
        Uri r114 = Uri.parse(r37);     // Catch: Throwable -> L314
        if (r114.getHost().endsWith(defpackage.c.I()) == false) goto L355;
        String[] r115 = {"sessionid", "tt_sessionid"};     // Catch: Throwable -> L314
        List<Header> r116 = r25.headers(new String[]{"Set-Cookie"}[0]);     // Catch: Throwable -> L314
        if (r116 == null) goto L317;
        if (r116.size() <= 0) goto L317;
        Iterator<Header> r117 = r116.iterator();     // Catch: Throwable -> L314
    L288:
        if (r117.hasNext() == false) goto L317;
        Header r118 = r117.next();     // Catch: Throwable -> L314
        int r119 = r11;
    L291:
        if (r119 >= r113) goto L288;
        String r38 = defpackage.c.N(r118.getValue(), r115[r119]);     // Catch: Throwable -> L314
        if (Logger.debug() == false) goto L296;
        Logger.d("SsOkHttpClient", r38);     // Catch: Throwable -> L314
    L296:
        if (r5.f.b(r38) == false) goto L298;
        int r39 = r11;
    L312:
        r119 = r119 + 1;
        r11 = r39;
        r113 = 2;
        goto L291
    L298:
        int r40 = r25.getStatus();     // Catch: Throwable -> L314
        r31.getClass();     // Catch: Throwable -> L314
        JSONObject r120 = new JSONObject();     // Catch: Throwable -> L314
        String r41 = r114.getEncodedQuery();     // Catch: Throwable -> L363
        if (r5.f.b(r41) == true) goto L303;
        r120.put("url_query", r41);     // Catch: Throwable -> L363
    L303:
        if (r5.f.b(r31.f12990a) == true) goto L306;
        r120.put(ICronetClient.KEY_REMOTE_IP, r31.f12990a);     // Catch: Throwable -> L314
    L306:
        if (r25.getHeaders() == null) goto L308;
        r120.put("header_list", r25.getHeaders().toString());     // Catch: Throwable -> L314
    L308:
        int r42 = r37.indexOf("?");     // Catch: Throwable -> L314
        if (r42 != (-1)) goto L311;
        r42 = r37.length();     // Catch: Throwable -> L314
    L311:
        r39 = 0;
        e9.b.a(r37.substring(0, r42), r40, r120);     // Catch: Throwable -> L314
    L317:
        if (r22.getMetrics() == null) goto L319;
        r22.getMetrics().checkReqTicketDuration = SystemClock.uptimeMillis() - r29.longValue();
    L319:
        Long r43 = Long.valueOf(SystemClock.uptimeMillis());
        if (e9.a.f7199a == false) goto L352;
        if (r31 != null) goto L325;
        Logger.w("CDN_CACHE_VERIFY", "Req info is null");
        goto L352
    L325:
        Header r44 = r22.getFirstHeader("X-TT-VERIFY-ID");
        if (r44 == null) goto L328;
        String r45 = r44.getValue();
    L329:
        Header r46 = r25.getFirstHeader("X-TT-VERIFY-ID");
        if (r46 == null) goto L332;
        String r47 = r46.getValue();
    L333:
        if (r45 == null) goto L352;
        if (r47 != null) goto L338;
        r31.F = 1;
        String r48 = "Cdn cache verify accessible";
    L345:
        Logger.w("CDN_CACHE_VERIFY", r48);
    L347:
        if (r31.F != 3) goto L352;
        throw new b7.a();
    L338:
        if (r45.equals(r47) == false) goto L340;
        r31.F = 2;
        r48 = "Cdn cache verify success";
        goto L345
    L340:
        r31.F = 3;
        Logger.w("CDN_CACHE_VERIFY", "Cdn cache verify fail");
        r25.getBody().in().close();     // Catch: Throwable -> L343
    L343:
        th = move-exception;
        th.printStackTrace();
        r48 = "Cdn cache verify stream close fail:" + th.toString();
        goto L345
    L332:
        r47 = null;
        goto L333
    L328:
        r45 = null;
    L352:
        if (r22.getMetrics() == null) goto L355;
        r22.getMetrics().postCdnCacheVerifyDuration = SystemClock.uptimeMillis() - r43.longValue();
    L314:
        th = move-exception;
        th.printStackTrace();
    L276:
        th = move-exception;
        th.printStackTrace();
        goto L278
    L268:
        r31 = null;
        goto L383
    L181:
        if (ClientKeyManager.f4080i == false) goto L246;
        Long r49 = Long.valueOf(SystemClock.uptimeMillis());     // Catch: Throwable -> L358
        URI r50 = t2.b.T(r22.getUrl());     // Catch: Throwable -> L186
    L187:
        if (r50 == null) goto L246;
        if (r50.getScheme().equals(LocationInfoConst.HTTPS) == false) goto L246;
        if (r28.f4083a.isEmpty() == true) goto L203;
        Iterator r121 = r28.f4083a.iterator();     // Catch: Throwable -> L358
    L195:
        if (r121.hasNext() == false) goto L199;
        if (g.b(r50.getHost(), (String) r121.next()) == false) goto L195;
        boolean r122 = true;
    L200:
        if (r122 == true) goto L203;
    L199:
        r122 = false;
    L203:
        if (r28.f4084b.isEmpty() == true) goto L210;
        Iterator r123 = r28.f4084b.iterator();     // Catch: Throwable -> L358
    L206:
        if (r123.hasNext() == false) goto L210;
        if (g.b(r50.getPath(), (String) r123.next()) == false) goto L206;
        boolean r51 = true;
    L211:
        if (r51 == false) goto L246;
        String r52 = "";
        String r124 = "";
        List<Header> r125 = r25.headers("Set-Cookie");     // Catch: Throwable -> L358
        if (r125 != null) goto L216;
    L223:
        String[] r126 = r52.split(";");     // Catch: Throwable -> L358
        if (r126 == null) goto L229;
        if (r126.length <= 0) goto L229;
        r124 = r126[0].trim();     // Catch: Throwable -> L358
    L229:
        if (TextUtils.isEmpty(r124) == true) goto L246;
        Logger.d("ClientKeyManager", "original sessionid: " + r28.f4086d + " new sessionid: " + r124);     // Catch: Throwable -> L358
        String r127 = "";
        String r128 = "";
        Header r129 = r25.getFirstHeader("x-bd-lanusk");     // Catch: Throwable -> L358
        Header r130 = r25.getFirstHeader("x-bd-lanusv");     // Catch: Throwable -> L358
        if (r129 == null) goto L240;
        if (r130 == null) goto L240;
        r127 = r129.getValue();     // Catch: Throwable -> L358
        r128 = r130.getValue();     // Catch: Throwable -> L358
        if (TextUtils.isEmpty(r127) == false) goto L237;
    L238:
        r28.f4085c = "";     // Catch: Throwable -> L358
        r28.f4088f = "";     // Catch: Throwable -> L358
    L242:
        r28.f4085c = r127;     // Catch: Throwable -> L358
        r28.f4088f = r128;     // Catch: Throwable -> L358
        String r131 = r22.getUrl();     // Catch: Throwable -> L358
        r28.f4087e = r131;     // Catch: Throwable -> L358
        r28.f4086d = r124;     // Catch: Throwable -> L358
        ClientKeyManager.f4079h.storeString("session_url", r131);     // Catch: Throwable -> L358
        ClientKeyManager.f4079h.storeString(QesdkUtils.TAGS.JSON_TAG_SESSION_ID, r52);     // Catch: Throwable -> L358
        ClientKeyManager.f4079h.storeString("client_key", r28.f4085c);     // Catch: Throwable -> L358
        ClientKeyManager.f4079h.storeString("kms_version", r28.f4088f);     // Catch: Throwable -> L358
        ClientKeyManager.f4079h.storeLong("session_time", System.currentTimeMillis());     // Catch: Throwable -> L358
        ClientKeyManager.f4082k = ClientKeyManager.c(r28.f4085c, r28.f4088f);     // Catch: Throwable -> L358
        if (r22.getMetrics() == null) goto L245;
        r22.getMetrics().updateClientKeyDuration = SystemClock.uptimeMillis() - r49.longValue();     // Catch: Throwable -> L358
    L245:
        Logger.d("ClientKeyManager", "save session url: " + r28.f4087e + " session cookie: " + r52 + " client key: " + r28.f4085c + " kms version: " + r28.f4088f);     // Catch: Throwable -> L358
        goto L246
    L237:
        if (TextUtils.isEmpty(r128) == false) goto L242;
    L240:
        if (r124.equals(r28.f4086d) == false) goto L242;
        r127 = r28.f4085c;     // Catch: Throwable -> L358
        r128 = r28.f4088f;     // Catch: Throwable -> L358
        goto L242
    L216:
        if (r125.isEmpty() == true) goto L223;
        Iterator<Header> r132 = r125.iterator();     // Catch: Throwable -> L358
    L219:
        if (r132.hasNext() == false) goto L223;
        String r133 = r132.next().getValue().trim();     // Catch: Throwable -> L358
        if (r133.toLowerCase().startsWith("sessionid=") == false) goto L219;
        r52 = r133;
    L210:
        r51 = false;
    L186:
        r50 = null;
    L171:
        th = move-exception;
        th.printStackTrace();
    L355:
        if (r22.getMetrics() == null) goto L357;
        r22.getMetrics().responseInterceptDuration.put("BaseSsInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r24.longValue()));
    L357:
        return r23;
    L33:
        long r53 = SystemClock.uptimeMillis();
        Request.Builder r54 = r21.newBuilder();
        String r55 = r21.getUrl();
        if (r5.f.b(r55) == false) goto L373;
    L80:
        r54.url(r55);
        if (r21.getMetrics() == null) goto L83;
        r21.getMetrics().filterDupQueryDuration = SystemClock.uptimeMillis() - r53;
    L83:
        Long r56 = Long.valueOf(SystemClock.uptimeMillis());
        ArrayList r57 = new ArrayList();
        if (r21.getHeaders() == null) goto L87;
        r57.addAll(r21.getHeaders());
    L87:
        if (c9.a.f3424a == false) goto L104;
        LinkedList r58 = new LinkedList();     // Catch: Throwable -> L101
        String r134 = n7.a.f(r55, r58);     // Catch: Throwable -> L101
        if (r134 == null) goto L92;
        r54.url(r134);     // Catch: Throwable -> L101
    L92:
        if (r58.isEmpty() == true) goto L104;
        Iterator r59 = r58.iterator();     // Catch: Throwable -> L101
    L94:
        if (r59.hasNext() == false) goto L104;
        Pair r135 = (Pair) r59.next();     // Catch: Throwable -> L101
        if (r135 == null) goto L94;
        r57.add(new Header((String) r135.first, (String) r135.second));     // Catch: Throwable -> L101
    L101:
        th = move-exception;
        th.printStackTrace();
    L104:
        if (r21.getMetrics() == null) goto L106;
        r21.getMetrics().encryptRequestDuration = SystemClock.uptimeMillis() - r56.longValue();
    L106:
        Long r60 = Long.valueOf(SystemClock.uptimeMillis());
    L119:
        th = move-exception;
        th.printStackTrace();
    L122:
        if (r21.getMetrics() == null) goto L124;
        r21.getMetrics().genReqTicketDuration = SystemClock.uptimeMillis() - r60.longValue();
    L124:
        Long r61 = Long.valueOf(SystemClock.uptimeMillis());
        if (e9.a.f7199a == false) goto L147;
        URI r62 = t2.b.T(r55);     // Catch: Throwable -> L144
        ReentrantReadWriteLock.ReadLock r63 = e9.a.f7201c;     // Catch: Throwable -> L144
        r63.lock();     // Catch: Throwable -> L141
        Iterator<e9.a.b> r136 = e9.a.f7200b.iterator();     // Catch: Throwable -> L141
    L130:
        if (r136.hasNext() == false) goto L134;
        if (r136.next().a(r62) == false) goto L130;
        r63.unlock();     // Catch: Throwable -> L144
        boolean r64 = true;
    L135:
        if (r64 == false) goto L137;
        String r65 = UUID.randomUUID().toString();     // Catch: Throwable -> L144
    L139:
        if (TextUtils.isEmpty(r65) == true) goto L147;
        r57.add(new Header("X-TT-VERIFY-ID", r65));     // Catch: Throwable -> L144
        goto L147
    L137:
        r65 = null;
        goto L139
    L134:
        r63.unlock();     // Catch: Throwable -> L144
        r64 = false;
    L141:
        th = move-exception;
        r63.unlock();     // Catch: Throwable -> L144
        throw th;     // Catch: Throwable -> L144
    L144:
        th = move-exception;
        th.printStackTrace();
    L147:
        if (r21.getMetrics() == null) goto L149;
        r21.getMetrics().preCdnCacheVerifyDuration = SystemClock.uptimeMillis() - r61.longValue();
    L149:
        ClientKeyManager r66 = ClientKeyManager.d();
        RetrofitMetrics r67 = r21.getMetrics();
        r66.getClass();
        if (ClientKeyManager.f4079h != null) goto L152;
    L161:
        r54.headers(r57);
        r22 = r54.build();
        goto L163
    L152:
        if (ClientKeyManager.f4080i == false) goto L161;
        if (TextUtils.isEmpty(r66.f4085c) == true) goto L161;
        if (TextUtils.isEmpty(r66.f4088f) == true) goto L161;
        Long r68 = Long.valueOf(SystemClock.uptimeMillis());
        r57.add(new Header("x-bd-client-key", r66.f4085c));
        r57.add(new Header("x-bd-kmsv", r66.f4088f));
        if (r67 == null) goto L161;
        r67.addClientKeyDuration = SystemClock.uptimeMillis() - r68.longValue();
        goto L161
    L108:
        if (e9.b.f7207b == true) goto L393;
    L114:
        String r69 = null;
    L116:
        if (r5.f.b(r69) == true) goto L122;
        r57.add(new Header("X-SS-REQ-TICKET", r69));     // Catch: Throwable -> L119
        goto L122
    L393:
        if (t2.b.T(r55).getHost().endsWith(defpackage.c.I()) == false) goto L114;
        r69 = String.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L364
    L373:
        LinkedHashMap r70 = new LinkedHashMap();     // Catch: Throwable -> L78
        Pair r137 = g.d(r55, r70);     // Catch: Throwable -> L78
        if (r70.isEmpty() == true) goto L56;
        Iterator r138 = r70.entrySet().iterator();     // Catch: Throwable -> L78
    L40:
        if (r138.hasNext() == false) goto L56;
        Map.Entry r139 = (Map.Entry) r138.next();     // Catch: Throwable -> L78
        if (r139 == null) goto L40;
        List r140 = (List) r139.getValue();     // Catch: Throwable -> L78
        if (r140 == null) goto L40;
        if (r140.isEmpty() == true) goto L40;
        LinkedHashSet r141 = new LinkedHashSet();     // Catch: Throwable -> L78
        Iterator r142 = r140.iterator();     // Catch: Throwable -> L78
    L51:
        if (r142.hasNext() == false) goto L40;
        String r143 = (String) r142.next();     // Catch: Throwable -> L78
        if (r141.contains(r143) == true) goto L54;
        r141.add(r143);     // Catch: Throwable -> L78
        goto L51
    L54:
        r142.remove();     // Catch: Throwable -> L78
    L56:
        l7.f r144 = new l7.f(((String) r137.first) + ((String) r137.second));     // Catch: Throwable -> L78
        if (r70.isEmpty() == true) goto L76;
        Iterator r71 = r70.entrySet().iterator();     // Catch: Throwable -> L78
    L60:
        if (r71.hasNext() == false) goto L76;
        Map.Entry r145 = (Map.Entry) r71.next();     // Catch: Throwable -> L78
        if (r145 == null) goto L60;
        if (r145.getKey() == null) goto L60;
        List r146 = (List) r145.getValue();     // Catch: Throwable -> L78
        if (r146 == null) goto L60;
        if (r146.isEmpty() == true) goto L60;
        Iterator r147 = r146.iterator();     // Catch: Throwable -> L78
    L74:
        if (r147.hasNext() == false) goto L60;
        r144.b((String) r145.getKey(), (String) r147.next());     // Catch: Throwable -> L78
    L76:
        r55 = r144.c();     // Catch: Throwable -> L78
    L78:
        th = move-exception;
        th.printStackTrace();
        goto L80
    L16:
        if (r15.startsWith("http:") == false) goto L18;
        URL r72 = new URL(r15);     // Catch: Throwable -> L362
        e.c(r72.getHost(), r72.getPath(), true);     // Catch: Throwable -> L362
        goto L18
    L9:
        e.a(r15);
        goto L11
    }
}
