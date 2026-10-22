package gra;

import android.content.Context;
import android.net.Uri;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.badger.Badger;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.FormUrlEncodedTypedOutput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.sdk.account.identitytoken.e;
import com.bytedance.sdk.account.time.RealTimeManager;
import com.ss.android.account.k;
import com.ss.android.account.token.TTTokenUtils;
import com.ss.android.badger.AccountBadger;
import com.ss.android.badger.d;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.token.TokenFactory;
import com.ss.android.token.f;
import com.ss.android.token.g;
import com.ss.android.token.g0;
import com.ss.android.token.h;
import com.ss.android.token.h0;
import com.ss.android.token.i;
import com.ss.android.token.j;
import com.ss.android.token.o;
import com.ss.android.token.p;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b implements Interceptor {
    public final List<h> a;
    public volatile Boolean b;

    public static class a {
        public static final b a = null;

        static {
            a = new b();
        }
    }

    public b() {
        this.a = Arrays.asList(new h[]{new e(), new d()});
        this.b = null;
        tb7.a.d("TTTokenInterceptor", "TTTokenInterceptor created. isTokenInit: " + TokenFactory.E);
    }

    public final SsResponse intercept(Interceptor.Chain r55) throws Exception {
        long r2 = System.currentTimeMillis();
        long r15 = SystemClock.elapsedRealtime();
        Request r4 = r55.request();
        ArrayList r5 = new ArrayList();
        r5.addAll(r4.getHeaders());
        AccountBadger r0 = AccountBadger.f;
        String r6 = r4.getPath();
        r0.getClass();
        Map r1 = Badger.INSTANCE.getReportHeader(r6);
        if (r1 == null) goto L8;
        Iterator r3 = r1.entrySet().iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        Map.Entry r7 = (Map.Entry) r3.next();
        r5.add(new Header((String) r7.getKey(), (String) r7.getValue()));
    L8:
        List<o> r14 = TTTokenUtils.a(r5);
        String r8 = r4.getUrl();
        if (TextUtils.isEmpty(r8) == false) goto L11;
        String r13 = null;
    L18:
        String r12 = r4.getUrl();
        if (p.f() == false) goto L31;
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.u == false) goto L31;
        if (com.bytedance.sdk.account.settings.common.a.c(r13, com.bytedance.sdk.account.settings.common.a.l, null, null) == false) goto L31;
        TokenFactory r9 = TokenFactory.j();
        r9.getClass();
        tb7.a.a("TokenFactory", "scheduleRevealTokenBeat isUpdateLoading=" + r9.a + " mBeating=" + r9.b);
        if (r9.a == true) goto L31;
        if (r9.b == false) goto L31;
        r9.j.removeMessages(1000);
        Message r10 = r9.j.obtainMessage(1000);
        r10.obj = 1;
        r9.j.sendMessageDelayed(r10, 10000);
        tb7.a.a("TokenFactory", "scheduleRevealTokenBeat do send");
    L31:
        com.bytedance.sdk.account.ticketguard.d.a();
        if (com.bytedance.sdk.account.ticketguard.d.b == false) goto L78;
        String r11 = r4.getPath();
        com.bytedance.sdk.account.ticketguard.d.a();
        if (com.bytedance.sdk.account.ticketguard.d.c.c.contains(r11) == false) goto L78;
    L75:
        th = th;
        String r16 = null;
    L77:
        th.printStackTrace();
    L79:
        boolean r23 = p.c;
        com.bytedance.sdk.account.settings.common.a.a();
        boolean r17 = com.bytedance.sdk.account.settings.common.a.W;
        if (r13 != null) goto L82;
    L84:
        boolean r18 = false;
    L85:
        if (r23 == true) goto L89;
        if (r17 == false) goto L89;
        if (r18 == true) goto L89;
        boolean r19 = true;
    L90:
        f r20 = p.a(r12, r16, r14, r19);
        if (r20 == null) goto L107;
        Map<String, String> r21 = r20.a;
        if (r21 == null) goto L107;
        HashMap r22 = (HashMap) r21;
        if (r22.isEmpty() == true) goto L107;
        Iterator r24 = r22.entrySet().iterator();
    L98:
        if (r24.hasNext() == false) goto L107;
        Map.Entry r110 = (Map.Entry) r24.next();
        if (r110 == null) goto L98;
        if (TextUtils.isEmpty((CharSequence) r110.getKey()) == true) goto L98;
        if (TextUtils.isEmpty((CharSequence) r110.getValue()) == true) goto L98;
        r5.add(new Header((String) r110.getKey(), (String) r110.getValue()));
    L107:
        long r111 = System.currentTimeMillis() - r2;
        SsResponse r25 = r55.proceed(r4.newBuilder().headers(r5).build());
        long r26 = (System.currentTimeMillis() - r2) - r111;
        List<o> r27 = TTTokenUtils.a(r25.headers());
        if ("/passport/token/beat/v2/".equalsIgnoreCase(r13) == false) goto L116;
        if (r25.body() == null) goto L116;
        String r28 = r25.body().toString();     // Catch: Throwable -> L113
        r26 = r26;
    L117:
        if (r20 != null) goto L119;
    L136:
        ArrayList r29 = null;
    L137:
        boolean r30 = p.f();
        String r31 = NetResponse.HEADER_KEY_LOG_ID;
        String r210 = "";
        if (r30 == true) goto L140;
        long r32 = r2;
        long r39 = r111;
        String r33 = r12;
        String r45 = r13;
        long r41 = r15;
        List<o> r112 = r14;
    L264:
        int r34 = r25.code();
        if (p.f() == true) goto L268;
    L279:
        String r35 = r45;
    L281:
        Iterator<h> r36 = this.a.iterator();
    L283:
        if (r36.hasNext() == false) goto L298;
        h r113 = r36.next();
        if (r35 != null) goto L287;
        String r37 = "";
    L288:
        boolean r114 = r25.isSuccessful();
        int r115 = r25.code();
        Object r116 = r25.body();
        if (this.b != null) goto L297;
        Context r38 = k.c();
        if (r38 != null) goto L293;
    L295:
        boolean r40 = false;
    L296:
        this.b = Boolean.valueOf(r40);
        goto L297
    L293:
        if (h0.d(r38) == false) goto L295;
        r40 = true;
    L297:
        long r211 = r32;
        String r117 = r31;
        r113.a(new g(r33, r37, r41, r112, r27, r114, r115, r116, this.b.booleanValue()));
        r36 = r36;
        r31 = r117;
        r32 = r211;
        r35 = r35;
        goto L283
    L287:
        r37 = r35;
        goto L288
    L298:
        String r42 = r31;
        long r50 = r26;
        long r52 = r39;
        long r43 = ((System.currentTimeMillis() - r32) - r52) - r50;
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.X == false) goto L302;
        if (r23 == true) goto L302;
    L325:
        return r25;
    L302:
        if (p.b == false) goto L325;
        TokenFactory.j().getClass();
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.o == false) goto L325;
        String r44 = TokenFactory.p(r33);
        if (TextUtils.isEmpty(r44) == true) goto L325;
        if (com.bytedance.sdk.account.settings.common.a.c(r44, com.bytedance.sdk.account.settings.common.a.c, com.bytedance.sdk.account.settings.common.a.d, com.bytedance.sdk.account.settings.common.a.e) == false) goto L325;
        if (r27 == null) goto L320;
        ArrayList r212 = (ArrayList) r27;
        if (r212.isEmpty() == true) goto L320;
        Iterator r46 = r212.iterator();
    L316:
        if (r46.hasNext() == false) goto L320;
        o r47 = (o) r46.next();
        if (r47.a.equalsIgnoreCase(r42) == false) goto L316;
        r210 = r47.b;
    L320:
        String r48 = r210;
        JSONObject r49 = new JSONObject();     // Catch: JSONException -> L323
        r49.put(DownloadConstants.PATH_KEY, r44);     // Catch: JSONException -> L323
        r49.put("logid", r48);     // Catch: JSONException -> L323
        r49.put("duration_interceptor_request", r52);     // Catch: JSONException -> L323
        r49.put("duration_interceptor_response", r43);     // Catch: JSONException -> L323
        r49.put("duration_interceptor_process", r50);     // Catch: JSONException -> L323
        com.bytedance.sdk.account.monitor.a.a("passport_net_request_monitor", r49);     // Catch: JSONException -> L323
    L323:
        e = move-exception;
        Logger.e("AccountApiMonitor", "sendEvent", e);
        goto L325
    L268:
        if (r34 != 200) goto L279;
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.u == false) goto L279;
        r35 = r45;
        if (com.bytedance.sdk.account.settings.common.a.c(r35, com.bytedance.sdk.account.settings.common.a.l, null, null) == false) goto L281;
        TokenFactory r51 = TokenFactory.j();
        r51.getClass();
        tb7.a.a("TokenFactory", "cancelRevealTokenBeat mBeating=" + r51.b);
        if (r51.b == false) goto L281;
        if (r51.j.hasMessages(1000, 1) == false) goto L281;
        r51.j.removeMessages(1000);
        r51.j.sendEmptyMessageDelayed(1000, r51.h.g);
        tb7.a.a("TokenFactory", "cancelRevealTokenBeat do remove");
        goto L281
    L140:
        TokenFactory r53 = TokenFactory.j();
        r53.getClass();
        r39 = r111;
        long r118 = System.currentTimeMillis();
        r41 = r15;
        r112 = r14;
        long r119 = SystemClock.elapsedRealtime();
        com.bytedance.sdk.account.ticketguard.f.a();
        if (com.bytedance.sdk.account.ticketguard.f.o == true) goto L143;
    L149:
        com.bytedance.sdk.account.ticketguard.f.a();
        if (com.bytedance.sdk.account.ticketguard.f.i == false) goto L255;
        String r54 = TokenFactory.p(r12);
        r45 = r13;
        if (r53.z.compareAndSet(false, true) == true) goto L332;
        long r410 = r2;
        String r56 = "/passport/token/beat/v2/";
        f r411 = r20;
        String r412 = NetResponse.HEADER_KEY_LOG_ID;
        String r310 = r12;
    L204:
        long r57 = r53.A;
        if (r57 == 0) goto L217;
        if ((r118 - r57) > 600000) goto L217;
        if (r118 <= r57) goto L217;
        Map r58 = RealTimeManager.j;
        if (RealTimeManager.a.a().a == null) goto L213;
        boolean r59 = true;
    L214:
        if (r59 == false) goto L217;
    L253:
        r33 = r310;
        r31 = r412;
        r32 = r410;
    L256:
        TokenFactory.j().y(r33, r411, r29, r27, r28);
        List r60 = p.e;
        if (r60 == null) goto L264;
        Iterator r61 = ((ArrayList) r60).iterator();
    L260:
        if (r61.hasNext() == false) goto L264;
        g0 r62 = (g0) r61.next();
        if (r62 == null) goto L260;
        r62.b();
        goto L260
    L213:
        r59 = false;
    L217:
        if (r56.equals(r54) == false) goto L219;
    L222:
        boolean r63 = true;
    L223:
        if (r63 == false) goto L253;
        if (r53.z.compareAndSet(false, true) == false) goto L253;
        StringBuilder r64 = new StringBuilder("[TokenTimeUtil] onNewResponseDate url=");
        r33 = r310;
        r64.append(r33);
        r64.append(", requestTime=");
        r32 = r410;
        r64.append(r32);
        r64.append(", current=");
        r64.append(r118);
        r64.append(", elapsedRealTime=");
        r64.append(r119);
        tb7.a.d("TokenFactory", r64.toString());
        if (r27 != null) goto L330;
    L251:
        r31 = r412;
    L252:
        r53.z.set(false);
        r53.A = r118;
        goto L256
    L330:
        ArrayList r65 = (ArrayList) r27;     // Catch: Throwable -> L248
        if (r65.isEmpty() == true) goto L251;
        Iterator r66 = r65.iterator();     // Catch: Throwable -> L248
        String r311 = null;
        String r312 = null;
    L232:
        if (r66.hasNext() == false) goto L244;
        o r67 = (o) r66.next();     // Catch: Throwable -> L248
        if ("date".equalsIgnoreCase(r67.a) == true) goto L236;
    L238:
        String r68 = r412;
        if (r68.equalsIgnoreCase(r67.a) == false) goto L243;
        if (TextUtils.isEmpty(r67.b) == true) goto L243;
        r312 = r67.b;     // Catch: Throwable -> L248
    L243:
        r412 = r68;
        goto L232
    L236:
        if (TextUtils.isEmpty(r67.b) == true) goto L238;
        r311 = r67.b;     // Catch: Throwable -> L248
        goto L238
    L244:
        r31 = r412;
        if (TextUtils.isEmpty(r311) == true) goto L252;
        r53.q(r311, r118, r119, r54, r312);     // Catch: Throwable -> L248
    L248:
        th = move-exception;
        r53.z.set(false);
        r53.A = r118;
        throw th;
    L219:
        if ("/passport/account/info/v2/".equals(r54) == true) goto L222;
        r63 = false;
        goto L223
    L332:
        Iterator r120 = ((ArrayList) r27).iterator();     // Catch: Throwable -> L200
        String r69 = "";
        String r213 = r69;
        long r214 = 0;
    L155:
        if (r120.hasNext() == false) goto L183;
        r411 = r20;
        o r70 = (o) r120.next();     // Catch: Throwable -> L200
        String r510 = r69;
        r412 = r31;
        if ("bd-ticket-guard-sec-ts".equalsIgnoreCase(r70.a) == true) goto L159;
    L161:
        String r71 = r510;
    L162:
        r410 = r2;
        if ("bd-ticket-guard-ts".equalsIgnoreCase(r70.a) == false) goto L171;
        if (TextUtils.isEmpty(r70.b) == true) goto L171;
        r214 = 1000 * Long.parseLong(r70.b);
        goto L171
    L168:
        e = move-exception;
        tb7.a.c("TokenFactory", "[TokenTimeUtil] onNewResponseDate parse timestamp error", e);     // Catch: Throwable -> L200
    L171:
        if ("X-Tt-Logid".equalsIgnoreCase(r70.a) == false) goto L176;
        if (TextUtils.isEmpty(r70.b) == true) goto L176;
        r213 = r70.b;     // Catch: Throwable -> L200
    L176:
        if (TextUtils.isEmpty(r71) == true) goto L182;
        if (r214 <= 0) goto L182;
        if (TextUtils.isEmpty(r213) == true) goto L182;
        String r72 = r71;
    L184:
        String r73 = r213;
        long r74 = r214;
        if (TextUtils.isEmpty(r72) == false) goto L187;
    L193:
        r310 = r12;
        r56 = "/passport/token/beat/v2/";
        if (TextUtils.equals(r54, r56) == false) goto L197;
    L198:
        j r75 = i.a;     // Catch: Throwable -> L200
        i.c(TokenFactory.i(r310), r54, r73);     // Catch: Throwable -> L200
    L199:
        r53.z.set(false);
        goto L204
    L197:
        if (TextUtils.equals(r54, "/passport/user_info/get_sec_ts/") == false) goto L199;
    L187:
        if (r74 <= 0) goto L193;
        j r76 = i.a;     // Catch: Throwable -> L200
        r310 = r12;
        tb7.a.a("TokenFactory", "[TokenTimeUtil] updateSecTime secTs=" + r72 + ", timestamp=" + r74 + ", current=" + r118 + ", elapsedRealTime=" + r119 + ", path=" + r54 + ", isUpdatedSign=" + i.d(r53.i, r54, r72, r74, r119, r118, r73) + ", logId=" + r73);     // Catch: Throwable -> L200
        com.bytedance.sdk.account.ticketguard.f.a();     // Catch: Throwable -> L200
        if (com.bytedance.sdk.account.ticketguard.f.r == false) goto L192;
        Map r77 = RealTimeManager.j;     // Catch: Throwable -> L200
        RealTimeManager.a.a().a(r53.i, r74, r118, r119);     // Catch: Throwable -> L200
        r53.A = r118;     // Catch: Throwable -> L200
        r53.z.set(false);
        goto L253
    L192:
        r56 = "/passport/token/beat/v2/";
    L182:
        r69 = r71;
        r20 = r411;
        r31 = r412;
        r2 = r410;
        goto L155
    L159:
        if (TextUtils.isEmpty(r70.b) == true) goto L161;
        r71 = r70.b;     // Catch: Throwable -> L200
        goto L162
    L183:
        r410 = r2;
        r411 = r20;
        r412 = r31;
        r72 = r69;
    L200:
        th = move-exception;
        r53.z.set(false);
        throw th;
    L255:
        r411 = r20;
        r45 = r13;
        r32 = r2;
        r33 = r12;
        goto L256
    L143:
        if (r2 <= 0) goto L149;
        if (r118 >= r2) goto L147;
    L148:
        StringBuilder r78 = new StringBuilder("[TokenTimeUtil] 请求到响应的时间大于 600000ms (");
        long r121 = r118 - r2;
        r78.append(r121);
        r78.append(" ms)，可能是设备休眠，不进行时间校准");
        tb7.a.e("TokenFactory", r78.toString());
        Map r79 = com.bytedance.sdk.account.time.d.a;
        com.bytedance.sdk.account.time.d.b(r121);
        goto L255
    L147:
        if ((r118 - r2) <= 600000) goto L149;
    L119:
        if (r20.d == false) goto L136;
        ArrayList r80 = new ArrayList();
        Object r81 = r25.raw().getExtraInfo();
        if ((r81 instanceof BaseHttpRequestInfo) == true) goto L340;
    L135:
        r29 = r80;
        goto L137
    L340:
        JSONObject r82 = new JSONObject(((BaseHttpRequestInfo) r81).requestHeaders);     // Catch: Throwable -> L134
        Iterator<String> r83 = r82.keys();     // Catch: Throwable -> L134
    L126:
        if (r83.hasNext() == false) goto L135;
        String r84 = r83.next();     // Catch: Throwable -> L134
        if (TextUtils.isEmpty(r84) == true) goto L126;
        Iterator<String> r511 = r83;
        String r85 = r82.optString(r84);     // Catch: Throwable -> L134
        if (TextUtils.isEmpty(r85) == false) goto L131;
        r83 = r511;
        goto L126
    L131:
        JSONObject r122 = r82;
        r80.add(new o(r84, r85));     // Catch: Throwable -> L134
        r83 = r511;
        r82 = r122;
    L113:
        th = move-exception;
        tb7.a.f("TTTokenInterceptor", "parse responseBody fail", th);
    L116:
        r28 = null;
    L89:
        r19 = false;
        goto L90
    L82:
        if (r13.contains("/passport/token/beat/v2/") == false) goto L84;
        r18 = true;
        goto L85
    L37:
        if ("post".equalsIgnoreCase(r4.getMethod()) == false) goto L66;
        ByteArrayOutputStream r86 = new ByteArrayOutputStream();     // Catch: Throwable -> L75
        TypedOutput r87 = r4.getBody();     // Catch: Throwable -> L50 Exception -> L52
        if (r87 != null) goto L42;
    L45:
        r16 = null;
    L326:
        r86.close();     // Catch: Exception -> L48 Throwable -> L73
    L68:
        if (TextUtils.isEmpty(r16) == false) goto L79;
        if (r4.getUrl().contains("?") == false) goto L79;
        r16 = r4.getUrl().split("\\?")[1];     // Catch: Throwable -> L73
    L48:
        e = e;
    L58:
        e.printStackTrace();     // Catch: Throwable -> L73
    L73:
        th = th;
        goto L77
    L42:
        if ((r87 instanceof FormUrlEncodedTypedOutput) == false) goto L45;
        r87.writeTo(r86);     // Catch: Throwable -> L50 Exception -> L52
        r16 = r86.toString();     // Catch: Throwable -> L50 Exception -> L52
        goto L326
    L52:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L50
    L342:
        r86.close();     // Catch: Exception -> L56 Throwable -> L75
    L56:
        e = e;
        r16 = null;
    L50:
        th = move-exception;
        r86.close();     // Catch: Exception -> L62 Throwable -> L75
    L384:
        throw th;     // Catch: Throwable -> L75
    L62:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L75
        throw th;     // Catch: Throwable -> L75
    L66:
        r16 = null;
    L78:
        r16 = null;
        goto L79
    L11:
        Uri r88 = UriProtector.parse(r8);
        if (r88 == null) goto L16;
        String r89 = r88.getPath();
        if (TextUtils.isEmpty(r89) == true) goto L17;
        r89 = r89.toLowerCase(Locale.getDefault());
    L17:
        r13 = r89;
        goto L18
    L16:
        r89 = null;
        goto L17
    }
}
