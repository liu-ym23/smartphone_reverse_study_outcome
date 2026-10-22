package com.bytedance.forest.pollyfill;

import android.os.Handler;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.w;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/forest/model/o;", "cache", "Lkotlin/Pair;", "", "invoke", "(Lcom/bytedance/forest/model/o;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class TTNetDepender$tryFetchFromCache$2 extends Lambda implements Function1<com.bytedance.forest.model.o, Pair<? extends Boolean, ? extends Boolean>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f4488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f4489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f4490c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ boolean e;

    public TTNetDepender$tryFetchFromCache$2(q r5, w r10, k r11, boolean r12, boolean r13) {
        this.f4488a = r5;
        this.f4489b = r10;
        this.f4490c = r11;
        this.d = r12;
        this.e = r13;
        super(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v19, types: [T, com.bytedance.forest.model.q] */
    /* JADX WARN: Type inference failed for: r5v13, types: [T, com.bytedance.forest.model.q] */
    @Override // kotlin.jvm.functions.Function1
    public final Pair<? extends Boolean, ? extends Boolean> invoke(com.bytedance.forest.model.o r20) {
        com.bytedance.forest.model.o r5 = r20;
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        Integer r11 = null;
        String r12 = null;
        String r13 = null;
        r10.element = null;
        if (this.f4489b.f4441q.isWebRequest() == false) goto L35;
        Map r14 = r5.g();
        q r15 = this.f4488a;
        ConcurrentHashMap r16 = this.f4490c.f4524b;
        AtomicBoolean r17 = q.f4535b;
        r15.getClass();
        if (r14 == null) goto L33;
        String r18 = (String) r14.get("vary");
        if (r18 != null) goto L10;
    L15:
        List r19 = null;
    L16:
        if (r19 == null) goto L37;
        if (r19.isEmpty() == true) goto L37;
        Iterator r21 = r19.iterator();
    L21:
        if (r21.hasNext() == false) goto L37;
        String r110 = (String) r21.next();
        if (StringsKt.isBlank(r110) == true) goto L21;
        String r111 = (String) r14.get("forest-append-" + r110);
        if (r16 == null) goto L30;
        String r112 = (String) r16.get(r110);
        if (r112 == null) goto L30;
    L32:
        if (Intrinsics.areEqual(r111, r112) == true) goto L21;
    L30:
        r112 = "";
    L37:
        if (this.d == false) goto L39;
    L58:
        com.bytedance.forest.utils.d.c(this.f4488a.f4537a.g, 4, "TTNetDepender", null, "cdn_ttnet_cache_expired_or_revalidate", new AnonymousClass1(this), 8);
        if (this.f4489b.f4441q.getEnableNegotiation() == true) goto L62;
        com.bytedance.forest.utils.d.b(this.f4488a.f4537a.g, 6, "TTNetDepender", "negotiation disabled, do not start revalidate", false, null, null, 56);
        Boolean r22 = Boolean.FALSE;
        return new Pair(r22, r22);
    L62:
        if (r14 != null) goto L65;
        r14 = r5.g();
    L65:
        if (r14 != null) goto L69;
        com.bytedance.forest.utils.d.b(this.f4488a.f4537a.g, 6, "TTNetDepender", "stale cache but no headers found", true, null, null, 48);
        Boolean r23 = Boolean.FALSE;
        return new Pair(r23, r23);
    L69:
        if (this.e == false) goto L72;
        com.bytedance.forest.utils.d.b(this.f4488a.f4537a.g, 6, "TTNetDepender", "only local, do not start revalidate", false, null, null, 56);
        Boolean r24 = Boolean.FALSE;
        return new Pair(r24, r24);
    L72:
        this.f4488a.f4537a.b(new String[]{"cdn_ttnet_prepare_negotiation_start"});
        HashMap r25 = new HashMap();
        Map r26 = this.f4490c.f4524b;
        if (r26 != null) goto L76;
        r26 = new LinkedHashMap();
    L76:
        Iterator r27 = r26.entrySet().iterator();
    L78:
        if (r27.hasNext() == false) goto L80;
        Map.Entry r113 = (Map.Entry) r27.next();
        r25.put(r113.getKey(), r113.getValue());
        goto L78
    L80:
        String r28 = (String) r14.get("last-modified");
        if (r28 == null) goto L83;
        String r29 = (String) r25.put("If-Modified-Since", r28);
    L83:
        String r30 = (String) r14.get("etag");
        if (r30 == null) goto L87;
        String r31 = (String) r25.put("If-None-Match", r30);
    L87:
        if (GeckoXAdapter.Companion.isCDNMultiVersionResource(this.f4490c.f4525c) == false) goto L89;
        com.bytedance.ies.bullet.service.base.c r32 = q.d;
        Lazy r114 = b.f4507a;
        String r115 = b.a(this.f4490c.f4525c);
        com.bytedance.forest.utils.e r116 = this.f4488a.f4537a;
        r32.getClass();
        c r33 = com.bytedance.ies.bullet.service.base.c.b(r115, r25);
    L90:
        this.f4488a.f4537a.b(new String[]{"cdn_ttnet_prepare_negotiation_finish"});
        this.f4488a.f4537a.b(new String[]{"cdn_ttnet_negotiation_request_start"});
        d r34 = n.b(this.f4489b, r33, this.f4488a.f4537a);
        this.f4488a.f4537a.b(new String[]{"cdn_ttnet_negotiation_request_finish"});
        r33.f4525c = this.f4490c.f4525c;
        if (r34 != null) goto L93;
    L116:
        if (r34 != null) goto L118;
    L134:
        r5.c(false);
        return new Pair(Boolean.FALSE, Boolean.TRUE);
    L118:
        if (r34.f4526a != 200) goto L134;
        this.f4488a.f4537a.b(new String[]{"cdn_ttnet_write_cache_start"});
        com.bytedance.forest.utils.d.c(this.f4488a.f4537a.g, 4, "TTNetDepender", null, "cdn_ttnet_request_is_valid", new AnonymousClass6(this), 8);
        ?? r35 = this.f4488a.f4537a.a(new w8.f(r34), this.f4489b.f4441q);
        List r36 = com.bytedance.forest.utils.k.f4646a;
        String r37 = (String) r34.f4528c.get("content-length");
        if (r37 == null) goto L122;
        r11 = StringsKt.toIntOrNull(r37);
    L122:
        r35.initCache$forest_release(r11);
        r10.element = r35;
        if (this.f4489b.f4441q.getNeedLocalFile() == false) goto L129;
        if (this.f4488a.e(r34, (com.bytedance.forest.model.q) r10.element, this.f4489b) == true) goto L129;
        com.bytedance.forest.utils.d.b(this.f4488a.f4537a.g, 6, "TTNetDepender", "store file failed.", true, null, null, 48);
        return new Pair(Boolean.FALSE, Boolean.TRUE);
    L129:
        if (this.f4489b.f4441q.getNeedLocalFile() == true) goto L131;
        ((Handler) com.bytedance.forest.utils.q.f4657b.getValue()).post(new o(this, r10, r34));
    L131:
        this.f4488a.f4537a.b(new String[]{"cdn_ttnet_write_cache_finish"});
        w r38 = this.f4489b;
        r38.e = r34;
        q r39 = this.f4488a;
        Map r40 = r34.f4528c;
        com.bytedance.forest.model.q r41 = (com.bytedance.forest.model.q) r10.element;
        r39.getClass();
        q.d(r40, r38, false, r41);
        r5.c(false);
        w r42 = this.f4489b;
        r42.f4447x = true;
        r42.f4446w = false;
        boolean r117 = true;
    L132:
        this.f4489b.f4442r = true;
        this.f4489b.d((com.bytedance.forest.model.q) r10.element);
        return new Pair(Boolean.TRUE, Boolean.valueOf(r117));
    L93:
        if (r34.f4526a != 304) goto L116;
        this.f4488a.f4537a.b(new String[]{"cdn_ttnet_write_cache_start"});
        com.bytedance.forest.utils.d.c(this.f4488a.f4537a.g, 4, "TTNetDepender", null, "cdn_ttnet_write_cache", new AnonymousClass3(this), 8);
        com.bytedance.forest.utils.d.b(this.f4488a.f4537a.g, 4, "TTNetDepender", "header of revalidate response is " + r34.f4528c, false, null, null, 56);
        w r118 = this.f4489b;
        if (r5.d() == true) goto L97;
        File r119 = null;
    L98:
        if (r119 == null) goto L100;
        r13 = r119.getPath();
    L100:
        r118.f4443t = r13;
        ?? r43 = r5.a(this.f4489b.f4441q, this.f4488a.f4537a);
        r10.element = r43;
        if (r43 != 0) goto L104;
        r5.c(true);
        com.bytedance.forest.utils.d.c(this.f4488a.f4537a.g, 6, "TTNetDepender", null, null, new AnonymousClass4(this), 24);
        return new Pair(Boolean.FALSE, Boolean.TRUE);
    L104:
        boolean r44 = r34.f4528c.isEmpty();
        r117 = !r44;
        List r120 = com.bytedance.forest.utils.k.f4646a;
        HashMap r121 = new HashMap();
        Iterator r45 = r14.entrySet().iterator();
    L106:
        if (r45.hasNext() == false) goto L110;
        Map.Entry r122 = (Map.Entry) r45.next();
        if (StringsKt.P((String) r122.getKey(), "forest-append-") == true) goto L106;
        r121.put(r122.getKey(), r122.getValue());
        goto L106
    L110:
        if (r44 == true) goto L115;
        com.bytedance.forest.utils.d.c(this.f4488a.f4537a.g, 4, "TTNetDepender", null, null, new AnonymousClass5(this), 28);
        r121.putAll(r34.f4528c);
        r5.b(r34, (com.bytedance.forest.model.q) r10.element, this.f4489b);     // Catch: Throwable -> L114
    L114:
        r5.c(false);
    L115:
        this.f4488a.f4537a.b(new String[]{"cdn_ttnet_write_cache_finish"});
        w r46 = this.f4489b;
        r46.e = r34;
        r46.f4447x = true;
        r46.f4446w = true;
        q r47 = this.f4488a;
        com.bytedance.forest.model.q r48 = (com.bytedance.forest.model.q) r10.element;
        r47.getClass();
        q.d(r121, r46, false, r48);
        goto L132
    L97:
        r119 = r5.f4396c;
        goto L98
    L89:
        com.bytedance.ies.bullet.service.base.c r49 = q.d;
        String r123 = this.f4490c.f4525c;
        com.bytedance.forest.utils.e r124 = this.f4488a.f4537a;
        r49.getClass();
        r33 = com.bytedance.ies.bullet.service.base.c.b(r123, r25);
        goto L90
    L39:
        if (r5.f4395b == true) goto L41;
    L43:
        com.bytedance.forest.model.q r50 = (com.bytedance.forest.model.q) r10.element;
        T r51 = r50;
        if (r50 != null) goto L47;
        r51 = r5.a(this.f4489b.f4441q, this.f4488a.f4537a);
    L47:
        if (r51 == 0) goto L56;
        r10.element = r51;
        com.bytedance.forest.utils.d.c(this.f4488a.f4537a.g, 4, "TTNetDepender", null, "cdn_ttnet_hit_disk_response_cache", new AnonymousClass10(this), 8);
        this.f4489b.f4442r = true;
        w r52 = this.f4489b;
        if (r5.d() == true) goto L51;
        File r53 = null;
    L52:
        if (r53 == null) goto L54;
        r12 = r53.getPath();
    L54:
        r52.f4443t = r12;
        w r54 = this.f4489b;
        r54.f4446w = true;
        r54.d((com.bytedance.forest.model.q) r10.element);
        w r55 = this.f4489b;
        r55.f = r14;
        q r56 = this.f4488a;
        com.bytedance.forest.model.q r57 = (com.bytedance.forest.model.q) r10.element;
        r56.getClass();
        q.d(r14, r55, true, r57);
        return new Pair(Boolean.TRUE, Boolean.FALSE);
    L51:
        r53 = r5.f4396c;
        goto L52
    L56:
        Boolean r58 = Boolean.FALSE;
        return new Pair(r58, r58);
    L41:
        if (System.currentTimeMillis() <= r5.f) goto L43;
    L10:
        if (StringsKt.isBlank(r18) == false) goto L13;
        r18 = null;
    L13:
        if (r18 == null) goto L15;
        r19 = StringsKt.K(r18, new String[]{","}, 0, 6);
    L33:
        Boolean r59 = Boolean.FALSE;
        return new Pair(r59, r59);
    L35:
        r14 = null;
        goto L37
    }
}
