package dvc;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import cvc.a;
import cvc.c;
import evc.e;
import evc.f;
import evc.g;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okio.Okio;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b implements Interceptor {
    public final i a;

    public b(i r1) {
        this.a = r1;
    }

    public static boolean a(String r1) {
        if (DownloadUtils.CONTENT_LENGTH.equalsIgnoreCase(r1) == false) goto L5;
    L10:
        return true;
    L5:
        if (DownloadHelper.CONTENT_ENCODING.equalsIgnoreCase(r1) == true) goto L10;
        if (DownloadHelper.CONTENT_TYPE.equalsIgnoreCase(r1) == true) goto L10;
        return false;
    }

    public static boolean b(String r1) {
        if ("Connection".equalsIgnoreCase(r1) == false) goto L5;
    L19:
        return false;
    L5:
        if ("Keep-Alive".equalsIgnoreCase(r1) == true) goto L19;
        if ("Proxy-Authenticate".equalsIgnoreCase(r1) == true) goto L19;
        if ("Proxy-Authorization".equalsIgnoreCase(r1) == true) goto L19;
        if ("TE".equalsIgnoreCase(r1) == true) goto L19;
        if ("Trailers".equalsIgnoreCase(r1) == true) goto L19;
        if (DownloadHelper.TRANSFER_ENCODING.equalsIgnoreCase(r1) == true) goto L19;
        if ("Upgrade".equalsIgnoreCase(r1) == true) goto L19;
        return true;
    }

    public static Response c(Response r1) {
        if (r1 != null) goto L4;
        return r1;
    L4:
        if (r1.body() != null) goto L6;
        return r1;
    L6:
        return r1.newBuilder().body(null).build();
    }

    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v21, types: [okhttp3.Request, okhttp3.Response] */
    /* JADX WARN: Type inference failed for: r2v38 */
    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain r27) throws IOException {
        i r0 = this.a;
        if (r0 == null) goto L5;
        Response r3 = r0.a(r27.request());
    L6:
        long r4 = System.currentTimeMillis();
        Request r23 = r27.request();
        if (r3 == null) goto L27;
        long r10 = r3.sentRequestAtMillis();
        long r12 = r3.receivedResponseAtMillis();
        Headers r14 = r3.headers();
        int r15 = r14.size();
        int r6 = 0;
        int r16 = -1;
        Date r17 = null;
        Date r18 = null;
        Date r19 = null;
        String r20 = null;
        String r21 = null;
        String r22 = null;
    L9:
        if (r6 >= r15) goto L26;
        String r8 = r14.name(r6);
        String r9 = r14.value(r6);
        if ("Date".equalsIgnoreCase(r8) == false) goto L14;
        r17 = evc.d.a(r9);
        r22 = r9;
    L25:
        r6 = r6 + 1;
        goto L9
    L14:
        if ("Expires".equalsIgnoreCase(r8) == false) goto L17;
        r18 = evc.d.a(r9);
        goto L25
    L17:
        if (DownloadHelper.LAST_MODIFIED_CASE.equalsIgnoreCase(r8) == false) goto L20;
        r19 = evc.d.a(r9);
        r21 = r9;
        goto L25
    L20:
        if ("ETag".equalsIgnoreCase(r8) == false) goto L23;
        r20 = r9;
        goto L25
    L23:
        if ("Age".equalsIgnoreCase(r8) == false) goto L25;
        r16 = e.c(r9, -1);
        goto L25
    L26:
        int r2 = r16;
    L29:
        if (r3 != null) goto L32;
        d r5 = new d(r23, null);
    L39:
        r23 = r23;
    L112:
        d r1 = r5;
        r23 = r23;
        ?? r7 = 0;
    L116:
        if (r1.a != null) goto L118;
    L120:
        Request r11 = r1.a;
        Response r13 = r1.b;
        i r24 = this.a;
        if (r24 == null) goto L123;
        r24.c(r1);
    L123:
        if (r3 == null) goto L126;
        if (r13 != null) goto L126;
        c.e(r3.body());
    L126:
        if (r11 != null) goto L130;
        if (r13 != null) goto L130;
        return new Response.Builder().request(r27.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(c.c).sentRequestAtMillis(-1).receivedResponseAtMillis(System.currentTimeMillis()).build();
    L130:
        if (r11 != null) goto L193;
        return r13.newBuilder().cacheResponse(c(r13)).build();
    L193:
        Response r25 = r27.proceed(r11);     // Catch: Throwable -> L185
        if (r25 != null) goto L138;
        if (r3 == null) goto L138;
        c.e(r3.body());
    L138:
        if (r13 != null) goto L140;
    L167:
        Response r26 = r25.newBuilder().cacheResponse(c(r13)).networkResponse(c(r25)).build();
        if (this.a != null) goto L170;
    L184:
        return r26;
    L170:
        if (e.b(r26) == false) goto L182;
        if (d.a(r26, r11) == false) goto L182;
        Cache.c r28 = this.a.e(r26);
        if (r28 == null) goto L210;
        Cache.c.a r29 = r28.c;
        if (r29 == null) goto L211;
        a r30 = new a(r26.body().source(), r28, Okio.buffer(r29));
        return r26.newBuilder().body(new g(r26.header(DownloadHelper.CONTENT_TYPE), r26.body().contentLength(), Okio.buffer(r30))).build();
    L211:
        return r26;
    L210:
        return r26;
    L182:
        if (f.a(r11.method()) == false) goto L184;
        this.a.d(r11);     // Catch: IOException -> L190
        goto L184
    L140:
        if (r25.code() != 304) goto L166;
        Response.Builder r31 = r13.newBuilder();
        Headers r32 = r13.headers();
        Headers r33 = r25.headers();
        Headers.Builder r34 = new Headers.Builder();
        int r35 = r32.size();
        int r36 = 0;
    L142:
        if (r36 >= r35) goto L156;
        String r110 = r32.name(r36);
        String r111 = r32.value(r36);
        if ("Warning".equalsIgnoreCase(r110) == false) goto L149;
        if (r111.startsWith("1") == false) goto L149;
    L155:
        r36 = r36 + 1;
    L149:
        if (a(r110) == false) goto L151;
    L154:
        a.a.getClass();
        r34.addLenient(r110, r111);
        goto L155
    L151:
        if (b(r110) == false) goto L154;
        if (r33.get(r110) != null) goto L155;
    L156:
        int r37 = r33.size();
        int r38 = 0;
    L157:
        if (r38 >= r37) goto L164;
        String r39 = r33.name(r38);
        if (a(r39) == true) goto L163;
        if (b(r39) == false) goto L163;
        OkHttpClient.a r40 = a.a;
        String r112 = r33.value(r38);
        r40.getClass();
        r34.addLenient(r39, r112);
    L163:
        r38 = r38 + 1;
        goto L157
    L164:
        Response r41 = r31.headers(r34.build()).sentRequestAtMillis(r25.sentRequestAtMillis()).receivedResponseAtMillis(r25.receivedResponseAtMillis()).cacheResponse(c(r13)).networkResponse(c(r25)).build();
        r25.body().close();
        this.a.b();
        this.a.update(r13, r41);
        return r41;
    L166:
        c.e(r13.body());
    L185:
        th = move-exception;
        if (r3 == null) goto L212;
        c.e(r3.body());
        throw th;
    L212:
        throw th;
    L118:
        if (r23.cacheControl().onlyIfCached() == false) goto L120;
        r1 = new d(r7, r7);
        goto L120
    L32:
        if (r23.isHttps() == false) goto L37;
        if (r3.handshake() != null) goto L37;
        r5 = new d(r23, null);
    L37:
        if (d.a(r3, r23) == true) goto L40;
        r5 = new d(r23, null);
        goto L39
    L40:
        CacheControl r42 = r23.cacheControl();
        if (r42.noCache() == true) goto L114;
        String r43 = "If-Modified-Since";
        if (r23.header("If-Modified-Since") == null) goto L45;
    L48:
        boolean r113 = true;
    L49:
        if (r113 == true) goto L114;
        CacheControl r114 = r3.cacheControl();
        if (r17 == null) goto L54;
        long r44 = Math.max(0, r12 - r17.getTime());
        int r45 = -1;
    L55:
        if (r2 == r45) goto L57;
        r44 = Math.max(r44, TimeUnit.SECONDS.toMillis(r2));
    L57:
        long r46 = (r44 + (r12 - r10)) + (r4 - r12);
        CacheControl r47 = r3.cacheControl();
        if (r47.maxAgeSeconds() == (-1)) goto L60;
        long r48 = TimeUnit.SECONDS.toMillis(r47.maxAgeSeconds());
    L65:
        long r49 = r48;
        long r50 = 0;
    L77:
        if (r42.maxAgeSeconds() == (-1)) goto L80;
        r49 = Math.min(r49, TimeUnit.SECONDS.toMillis(r42.maxAgeSeconds()));
    L80:
        if (r42.minFreshSeconds() == (-1)) goto L82;
        long r115 = TimeUnit.SECONDS.toMillis(r42.minFreshSeconds());
    L84:
        if (r114.mustRevalidate() == true) goto L89;
        if (r42.maxStaleSeconds() == (-1)) goto L89;
        r50 = TimeUnit.SECONDS.toMillis(r42.maxStaleSeconds());
    L89:
        if (r114.noCache() == true) goto L105;
        long r116 = r115 + r46;
        if (r116 >= (r50 + r49)) goto L105;
        Response.Builder r51 = r3.newBuilder();
        if (r116 < r49) goto L96;
        r51.addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
    L96:
        if (r46 > DownloadConstants.DAY) goto L98;
    L104:
        r7 = 0;
        r1 = new d(null, r51.build());
        r23 = r23;
        goto L116
    L98:
        if (r3.cacheControl().maxAgeSeconds() != (-1)) goto L101;
        if (r18 != null) goto L101;
        boolean r117 = true;
    L102:
        if (r117 == false) goto L104;
        r51.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
    L101:
        r117 = false;
    L105:
        if (r20 == null) goto L107;
        r43 = DownloadHelper.IF_NONE_MATCH;
        String r52 = r20;
    L111:
        Headers.Builder r53 = r23.headers().newBuilder();
        a.a.getClass();
        r53.addLenient(r43, r52);
        r5 = new d(r23.newBuilder().headers(r53.build()).build(), r3);
        goto L112
    L107:
        if (r19 == null) goto L109;
        r52 = r21;
        goto L111
    L109:
        if (r17 == null) goto L113;
        r52 = r22;
        goto L111
    L113:
        r23 = r23;
        r7 = 0;
        r1 = new d(r23, null);
        goto L116
    L82:
        r115 = r50;
        goto L84
    L60:
        if (r18 == null) goto L66;
        if (r17 == null) goto L63;
        r12 = r17.getTime();
    L63:
        r48 = r18.getTime() - r12;
        if (r48 > 0) goto L65;
    L74:
        r50 = 0;
    L75:
        r49 = r50;
        goto L77
    L66:
        if (r19 == null) goto L74;
        if (r3.request().url().query() != null) goto L74;
        if (r17 == null) goto L71;
        r10 = r17.getTime();
    L71:
        long r118 = r10 - r19.getTime();
        r50 = 0;
        if (r118 <= 0) goto L75;
        r49 = r118 / 10;
        goto L77
    L54:
        r45 = -1;
        r44 = 0;
        goto L55
    L45:
        if (r23.header(DownloadHelper.IF_NONE_MATCH) != null) goto L48;
        r113 = false;
    L114:
        r7 = 0;
        r1 = new d(r23, null);
        goto L116
    L27:
        r2 = -1;
        r10 = 0;
        r12 = 0;
        r17 = null;
        r18 = null;
        r19 = null;
        r20 = null;
        r21 = null;
        r22 = null;
        goto L29
    L5:
        r3 = null;
        goto L6
    }
}
