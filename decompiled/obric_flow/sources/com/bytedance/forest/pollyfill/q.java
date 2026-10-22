package com.bytedance.forest.pollyfill;

import android.os.Handler;
import com.bytedance.forest.chain.fetchers.CDNFetcher;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.w;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.h0;
import okhttp3.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f4535b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f4536c = null;
    public static final com.bytedance.ies.bullet.service.base.c d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.forest.utils.e f4537a;

    static {
        f4535b = new AtomicBoolean(false);
        f4536c = new ConcurrentHashMap();
        d = new com.bytedance.ies.bullet.service.base.c(5);
    }

    public q(com.bytedance.forest.utils.e r5) {
        this.f4537a = r5;
    }

    public static void d(Map r5, w r10, boolean r11, com.bytedance.forest.model.q r12) {
        if (r5 == null) goto L41;
        if (r11 == false) goto L11;
        List r13 = com.bytedance.forest.utils.k.f4646a;
        HashMap r14 = new HashMap();
        Iterator r15 = r5.entrySet().iterator();
    L6:
        if (r15.hasNext() == false) goto L10;
        Map.Entry r16 = (Map.Entry) r15.next();
        if (StringsKt.P((String) r16.getKey(), "forest-append-") == true) goto L6;
        r14.put(r16.getKey(), r16.getValue());
        goto L6
    L10:
        r5 = r14;
    L11:
        r10.f = r5;
        String r17 = (String) r5.get("content-type");
        if (r17 != null) goto L15;
        r17 = "text/html; charset=UTF-8";
    L15:
        Pattern r18 = h0.e;
        h0 r19 = z.j(r17);
        if (r19 != null) goto L18;
        String r20 = "text/html";
    L19:
        if (r19 == null) goto L25;
        Charset r21 = r19.a(null);
        if (r21 == null) goto L25;
        String r22 = r21.toString();
        if (r22 == null) goto L25;
    L26:
        Pair r23 = TuplesKt.to(r20, r22);
        String r24 = (String) r23.component1();
        String r25 = (String) r23.component2();
        r10.g = r24;
        r10.f4434j = r25;
        String r26 = (String) r5.get("x-gecko-proxy-pkgid");
        if (r26 == null) goto L31;
        Long r27 = StringsKt.toLongOrNull(r26);
        if (r27 == null) goto L31;
        long r28 = r27.longValue();
    L32:
        r10.f4449z = r28;
        if (r10.f4441q.isWebRequest() == false) goto L42;
        List r29 = com.bytedance.forest.utils.k.f4646a;
        r10.d = com.bytedance.forest.utils.k.a(r24, r25, r12.provideInputStream(r10), r10.f4441q.getUrl(), r5);
        return;
    L42:
        return;
    L31:
        r28 = 0;
    L25:
        r22 = "";
        goto L26
    L18:
        r20 = r19.f20658b + "/" + r19.f20659c;
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [com.bytedance.forest.model.Request] */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v10 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.forest.pollyfill.a] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.forest.model.Request] */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v8 */
    @Override // com.bytedance.forest.pollyfill.m
    public final void a(w r28, a r29, boolean r30) {
        Request r10 = r28.f4441q;
        String r11 = r10.getUrl();
        final c r12 = n.a(r11, r10);
        if (r12 != null) goto L6;
        com.bytedance.forest.utils.d.c(this.f4537a.g, 4, "TTNetDepender", null, "cdn_ttnet_request_empty_error", new TTNetDepender$fetchFile$1(r12), 8);
        r28.f4442r = false;
        r29.c(true, new Throwable("create request failed, " + r12));
        return;
    L6:
        r29.d = r12;
        boolean r5 = r29.f;
        Map r15 = null;
        if (r5 == false) goto L9;
    L103:
        if (r28.f4441q.getEnableCDNCache() == false) goto L85;
        if (r5 == true) goto L85;
        this.f4537a.b(new String[]{"cdn_cache_start"});     // Catch: Throwable -> L81
        ConcurrentHashMap r13 = com.bytedance.forest.utils.o.f4654a;     // Catch: Throwable -> L81
        com.bytedance.forest.utils.o.a(r12.f4525c, this.f4537a.g, new TTNetDepender$tryFetchFromCache$1(this), new TTNetDepender$tryFetchFromCache$2(this, r28, r12, r5, r30), null);     // Catch: Throwable -> L70
        boolean r14 = r28.f4442r;     // Catch: Throwable -> L70
        this.f4537a.b(new String[]{"cdn_ttnet_load_cache_finish"});     // Catch: Throwable -> L70
        boolean r16 = r14;
        if (r14 == true) goto L72;
        JSONObject r17 = i.f4516b;     // Catch: Throwable -> L70
        boolean r18 = n.c(r11, r28, this.f4537a);     // Catch: Throwable -> L70
        this.f4537a.b(new String[]{"cdn_downloader_load_cache_finish"});     // Catch: Throwable -> L70
        r16 = r18;
    L72:
        this.f4537a.b(new String[]{"cdn_cache_finish"});     // Catch: Throwable -> L78
        ?? r19 = r16;
        if (r16 == false) goto L101;
        r29.d();     // Catch: Throwable -> L78
        if (r28.f4443t == null) goto L116;
        new File(r28.f4443t).setLastModified(System.currentTimeMillis());     // Catch: Throwable -> L78
        f4536c.remove(r12.toString());     // Catch: Throwable -> L78
        return;
    L116:
        return;
    L101:
        if (r30 == false) goto L93;
        r28.f4442r = false;     // Catch: Throwable -> L78
        r29.c(true, new Throwable("only local but no cache found"));     // Catch: Throwable -> L91
        f4536c.remove(r12.toString());     // Catch: Throwable -> L91
        return;
    L93:
        c(r12, r29, r28);     // Catch: Throwable -> L91
        return;
    L91:
        th = th;
        ?? r20 = r19;
        ?? r110 = r10;
    L80:
        Throwable r21 = th;
        String r22 = "exception occurred:" + r21 + ", msg=" + r21.getMessage() + ", request:" + r12;
        com.bytedance.forest.utils.d.b(this.f4537a.g, 6, "TTNetDepender", r22, true, r21, null, 32);
        f4536c.remove(r12.toString());
        r20.c(false, new Throwable(r22));
        final ?? r23 = r110;
        com.bytedance.forest.utils.d.c(this.f4537a.g, 6, "TTNetDepender", r21, null, new TTNetDepender$fetchFile$4(r23), 20);
        return;
    L70:
        th = th;
    L83:
        this.f4537a.b(new String[]{"cdn_cache_finish"});     // Catch: Throwable -> L78
        throw th;     // Catch: Throwable -> L78
    L81:
        th = th;
    L85:
        com.bytedance.forest.utils.d r24 = this.f4537a.g;     // Catch: Throwable -> L78
        com.bytedance.forest.utils.d.c(r24, 4, "TTNetDepender", null, "cdn_ttnet_disable_fetch_cache", new TTNetDepender$fetchFile$3(r12), 8);     // Catch: Throwable -> L78
        r19 = r24;
    L78:
        th = th;
        r20 = r29;
        r110 = r18;
    L95:
        th = th;
        r20 = r29;
        r110 = r10;
        goto L80
    L9:
        if (r29.e == true) goto L103;
        final j r25 = (j) f4536c.putIfAbsent(r12.toString(), r29);
        if (r25 == null) goto L103;
        com.bytedance.forest.utils.d.c(this.f4537a.g, 4, "TTNetDepender", null, null, new TTNetDepender$fetchFile$$inlined$let$lambda$1(r12), 28);
        if (Intrinsics.areEqual(r29, r25) == false) goto L15;
        com.bytedance.forest.utils.d.c(r25.f4522h.g, 6, "fetch_task", null, null, new FetchTask$registerSubTask$1(r25), 24);
    L57:
        com.bytedance.forest.utils.d.b(this.f4537a.g, 4, "TTNetDepender", "request hit by loading cache", false, null, null, 56);
        return;
    L15:
        r25.f4520b = true;
    L17:
        if (r25.f4519a != FetchTask$State.f4459a) goto L19;
        Thread.sleep(200);
        goto L17
    L19:
        int r26 = r25.f4519a.ordinal();
        if (r26 != 1) goto L22;
        com.bytedance.forest.model.p r27 = r25.g.i();
        if (r27 != null) goto L32;
    L59:
        com.bytedance.forest.utils.d.c(r25.f4522h.g, 6, "fetch_task", null, null, new FetchTask$registerSubTask$4(r25), 24);
    L60:
        String r111 = "TTNetDepender";
        com.bytedance.forest.utils.d.b(this.f4537a.g, 6, "TTNetDepender", "request hit by loading cache but failed", true, null, null, 48);
        goto L103
    L32:
        if (r25.g.f4442r == true) goto L34;
    L36:
        r27 = null;
    L37:
        if (r27 == null) goto L59;
        w r31 = r29.g;
        w r32 = r25.g;
        r31.e = r32.e;
        r31.f = r32.f;
        r31.g = r32.f();
        r31.f4434j = r25.g.e();
        w r33 = r25.g;
        r31.f4449z = r33.f4449z;
        r31.f4435k = r33.f4435k;
        r31.d(r27);
        r31.f4446w = true;
        w r34 = r25.g;
        r31.f4448y = r34.f4448y;
        r31.f4447x = r34.f4447x;
        r31.f4443t = r34.f4443t;
        ConcurrentHashMap r35 = r25.f4522h.d;
        LinkedHashMap r36 = new LinkedHashMap();
        Iterator r37 = r35.entrySet().iterator();
    L40:
        if (r37.hasNext() == false) goto L46;
        Map.Entry r38 = (Map.Entry) r37.next();
        String r39 = (String) r38.getKey();
        if (StringsKt.g(r39, "cdn_") == false) goto L40;
        if (r29.f4522h.d.containsKey(r39) == true) goto L40;
        r36.put(r38.getKey(), r38.getValue());
        goto L40
    L46:
        Iterator r40 = r36.entrySet().iterator();
    L48:
        if (r40.hasNext() == false) goto L50;
        Map.Entry r41 = (Map.Entry) r40.next();
        r29.f4522h.d.put(r41.getKey(), r41.getValue());
        goto L48
    L50:
        r29.f4522h.f.putAll(r25.f4522h.f);
        if (r31.f4441q.isWebRequest() == false) goto L56;
        List r42 = com.bytedance.forest.utils.k.f4646a;
        String r43 = r25.g.f();
        String r44 = r25.g.e();
        InputStream r45 = r27.provideInputStream(r31);
        String r46 = r31.f4441q.getUrl();
        d r47 = r31.e;
        if (r47 == null) goto L55;
        r15 = r47.f4528c;
    L55:
        r31.d = com.bytedance.forest.utils.k.a(r43, r44, r45, r46, r15);
    L56:
        r29.d();
        goto L57
    L34:
        if (r27.supportReuse() == false) goto L36;
    L22:
        if (r26 == 4) goto L24;
        com.bytedance.forest.utils.d.b(r25.f4522h.g, 6, CDNFetcher.TAG, "failed, state: " + r25.f4519a, false, null, null, 56);
        goto L60
    L24:
        String r48 = r25.f4521c;
        if (r48 != null) goto L28;
        r48 = "";
    L28:
        r29.b(r48);
        goto L57
    }

    @Override // com.bytedance.forest.pollyfill.m
    public final void b(j r5) {
        Object r10 = r5.d;
        if ((r10 instanceof k) == true) goto L6;
        r10 = null;
    L6:
        if (((k) r10) == null) goto L14;
        Result.m124constructorimpl(null);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        return;
    }

    public final void c(final c r17, a r18, final w r19) {
        this.f4537a.b(new String[]{"cdn_download_start"});
        if (GeckoXAdapter.Companion.isCDNMultiVersionResource(r17.f4525c) == false) goto L5;
        com.bytedance.ies.bullet.service.base.c r5 = d;
        Lazy r10 = b.f4507a;
        String r11 = b.a(r17.f4525c);
        ConcurrentHashMap r12 = r17.f4524b;
        r5.getClass();
        c r13 = com.bytedance.ies.bullet.service.base.c.b(r11, r12);
    L6:
        this.f4537a.b(new String[]{"cdn_download_internal_start"});
        final d r14 = n.b(r19, r13, this.f4537a);
        if (r14 != null) goto L10;
        r19.f4442r = false;
        String r15 = "fetch rejected, request:" + r19.f4441q + ", headers:" + r17.f4524b;
        com.bytedance.forest.utils.d.b(this.f4537a.g, 6, "TTNetDepender", r15, true, null, null, 48);
        r18.c(true, new Throwable(r15));
        f4536c.remove(r17.toString());
        return;
    L10:
        r14.d = r17;
        com.bytedance.forest.utils.d.b(this.f4537a.g, 4, "TTNetDepender", "receive response: http code is " + r14.f4526a + ", time stamp: " + System.currentTimeMillis(), true, null, "cdn_ttnet_response_from_online", 16);
        int r16 = r14.f4526a;
        if (300 <= r16) goto L13;
    L19:
        this.f4537a.b(new String[]{"cdn_download_finish"});
        r19.e = r14;
        List r20 = com.bytedance.forest.utils.k.f4646a;
        int r21 = r14.f4526a;
        if (200 > r21) goto L50;
        if (300 < r21) goto L50;
        com.bytedance.forest.model.q r22 = this.f4537a.a(new p(this, r14), r19.f4441q);
        String r23 = (String) r14.f4528c.get("content-length");
        if (r23 == null) goto L26;
        Integer r24 = StringsKt.toIntOrNull(r23);
    L27:
        r22.initCache$forest_release(r24);
        if (r19.f4441q.getNeedLocalFile() == true) goto L30;
    L33:
        r19.f4442r = true;
        r19.d(r22);
        d(r14.f4528c, r19, false, r22);
        r18.d();
        com.bytedance.forest.utils.d.c(this.f4537a.g, 4, "TTNetDepender", null, "cdn_finish", new TTNetDepender$tryFetchOnline$3(r17), 8);
        if (r22.isCacheProvided$forest_release() == true) goto L38;
        com.bytedance.forest.utils.d.b(this.f4537a.g, 6, "TTNetDepender", "request cache provide failed", true, null, null, 48);
        f4536c.remove(r17.toString());
        return;
    L38:
        if (r19.f4441q.getEnableCDNCache() == true) goto L40;
    L48:
        com.bytedance.forest.utils.d.b(this.f4537a.g, 4, "TTNetDepender", "not support cache", false, null, null, 56);
        f4536c.remove(r17.toString());
        return;
    L40:
        if (r14.a() == false) goto L48;
        if (r19.f4441q.getNeedLocalFile() == false) goto L46;
        f4536c.remove(r17.toString());
        return;
    L46:
        ((Handler) com.bytedance.forest.utils.q.f4657b.getValue()).post(new com.bytedance.apm.f(this, r14, r22, r19, r17, 1));
        return;
    L30:
        if (e(r14, r22, r19) == true) goto L33;
        com.bytedance.forest.utils.d.c(this.f4537a.g, 6, "TTNetDepender", null, null, new TTNetDepender$tryFetchOnline$2(r17), 28);
        r19.f4442r = false;
        r18.c(true, new Throwable("store file failed, url: " + r17.f4525c));
        f4536c.remove(r17.toString());
        return;
    L26:
        r24 = null;
    L50:
        com.bytedance.forest.utils.d.c(this.f4537a.g, 6, "TTNetDepender", null, null, new TTNetDepender$tryFetchOnline$1(r17, r14), 24);
        r19.f4442r = false;
        r18.c(true, new Throwable("fetch failed, url: " + r17.f4525c + ", code:" + r14.f4526a + ", message:" + r14.f4527b));
        f4536c.remove(r17.toString());
        return;
    L13:
        if (399 < r16) goto L19;
        r19.f4448y = true;
        final String r25 = (String) r14.f4528c.get("location");
        if (r25 == null) goto L19;
        com.bytedance.forest.utils.d.c(this.f4537a.g, 4, "TTNetDepender", null, "cdn_ttnet_request_redirect", new TTNetDepender$handleRedirectionCase$1(r25, r19), 8);
        r18.b(r25);
        f4536c.remove(r17.toString());
        this.f4537a.b(new String[]{"cdn_download_finish"});
        return;
    L5:
        r13 = r17;
        goto L6
    }

    public final boolean e(d r12, com.bytedance.forest.model.q r13, w r14) {
        boolean r5 = r13.isCacheProvided$forest_release();
        com.bytedance.forest.utils.e r10 = this.f4537a;
        if (r5 == true) goto L18;
        com.bytedance.forest.utils.d.b(r10.g, 6, "TTNetDepender", "forest buffer does not provide cache", false, null, null, 56);
        return false;
    L18:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L8
        Object r15 = Result.m124constructorimpl(new com.bytedance.forest.model.o(r12, r13, r14));     // Catch: Throwable -> L8
    L11:
        if (Result.m130isFailureimpl(r15) == false) goto L13;
        r15 = null;
    L13:
        final com.bytedance.forest.model.o r16 = (com.bytedance.forest.model.o) r15;
        if (r16 == null) goto L17;
        ConcurrentHashMap r17 = com.bytedance.forest.utils.o.f4654a;
        com.bytedance.forest.utils.o.a(r12.d.f4525c, r10.g, null, new TTNetDepender$commit$1(this, r16), new TTNetDepender$commit$2(this, r16));
        return true;
    L17:
        return false;
    L8:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r15 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
