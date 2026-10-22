package com.larus.community.impl.repository;

import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.ttnet.http.RequestContext;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.community.impl.api.CreationRecommendApi;
import com.larus.community.impl.api.j;
import com.larus.community.impl.api.m;
import com.larus.network.http.y;
import com.larus.platform.api.creation.CreationFeedCacheEntity;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.platform.service.z2;
import com.larus.utils.o0;
import java.util.Map;
import juc.d;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import zp9.c;
import zp9.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class CommunityCreationRecommendRepository implements n {
    public static volatile boolean i;
    public static final int j = 0;
    public final int a;
    public final TabItemInfo b;
    public final String c;
    public final CreationFeedCacheEntity d;
    public final String e;
    public volatile String f;
    public volatile String g;
    public final com.larus.community.impl.repository.a h;

    public static final class a {
    }

    static {
        i = true;
        j = z2.a.getCommunityRecommendRequestConfig().a();
    }

    public final CreationFeedCacheEntity b() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v8 */
    public final Object a(int r35, String r36, Long r37, String r38, Continuation<? super Pair<c, ? extends dm9.a<?>>> r310) {
        if ((r310 instanceof CommunityCreationRecommendRepository$fetchBatch$1) == false) goto L7;
        CommunityCreationRecommendRepository$fetchBatch$1 r4 = (CommunityCreationRecommendRepository$fetchBatch$1) r310;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r4.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        ResultKt.throwOnFailure(r3);
        Map<String, String> r2 = null;
    L73:
        y r7 = (com.larus.network.http.a) r3;
        if ((r7 instanceof y) == false) goto L93;
        y r8 = r7;
        Long r9 = r8.g;
        if (r9 == null) goto L95;
        if (r9.longValue() != 0) goto L95;
        m29.a.c("CommunityCreationRecommendRepository", "success in fetch template list ");
        m r1 = (m) ((com.larus.network.http.a) r8).b;
        if (r1 == null) goto L83;
        boolean r10 = r1.a;
    L84:
        if (r1 == null) goto L86;
        Map<String, String> r11 = r1.b;
    L87:
        if (r1 == null) goto L89;
        ?? r12 = r1.c;
    L94:
        return TuplesKt.to(new c(r10, r11, r12, null, null, 24), r2);
    L89:
        r12 = r2;
        goto L94
    L86:
        r11 = r2;
        goto L87
    L83:
        r10 = false;
    L95:
        return TuplesKt.to(r2, r2);
    L93:
        return TuplesKt.to(r2, r2);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r3);
        String r13 = this.f;
        String r14 = this.g;
        if (this.f == null) goto L17;
    L18:
        if (r35 != 1) goto L20;
        this.f = null;
        this.g = null;
        m29.a.c("CommunityCreationRecommendRepository", " clear relatedRecommendationForFirstPage and relatedCreationId");
    L20:
        int r16 = this.a;
        long r17 = j;
        long r18 = r35;
        if (i == false) goto L23;
        i = false;
        boolean r27 = true;
    L24:
        TabItemInfo r110 = this.b;
        if (r110 == null) goto L39;
        String r111 = r110.getId();
        if (r111 == null) goto L39;
        if (r111.length() <= 0) goto L31;
        boolean r112 = true;
    L32:
        if (r112 == true) goto L34;
    L36:
        boolean r113 = false;
    L37:
        if (r113 == false) goto L39;
        String r210 = r111;
    L40:
        String r114 = this.c;
        if (r35 == 1) goto L43;
        r14 = this.e;
    L47:
        String r31 = r14;
        if (r35 != 1) goto L50;
        String r32 = r13;
    L51:
        e29.c r20 = this.h.a;
        if (r20 == null) goto L61;
        String r21 = r20.a();
        if (r21 == null) goto L61;
        if (r21.length() <= 0) goto L58;
        boolean r22 = true;
    L59:
        if (r22 == false) goto L61;
        String r33 = r21;
    L62:
        j r23 = new j(r16, r18, r17, r27, r37, r210, r114, r31, r32, r33);
        CreationRecommendApi.a r24 = CreationRecommendApi.a;
        Long r25 = Boxing.boxLong(((long) z2.a.Y1()) * 1000);
        r4.label = 1;
        r24.getClass();
        FlowDowngradeServiceDelegate r26 = FlowDowngradeServiceDelegate.INSTANCE;
        d<j> r115 = j.Companion.serializer();
        d<m> r116 = m.Companion.serializer();
        if (r38 == null) goto L65;
        Map r117 = MapsKt.mapOf(TuplesKt.to("source", r38));
    L66:
        if (r25 == null) goto L68;
        long r28 = r25.longValue();
        RequestContext r30 = new RequestContext();
        ((BaseRequestContext) r30).timeout_connect = r28;
        ((BaseRequestContext) r30).timeout_read = r28;
        ((BaseRequestContext) r30).timeout_write = r28;
        RequestContext r118 = r30;
    L69:
        r2 = null;
        Object r34 = r26.requestPost("Social", m.class, "/creativity/community/creation/recommend", r23, r115, r116, "application/json", MapsKt.emptyMap(), true, null, r118, null, r117, r4);
        if (r34 != r15) goto L72;
        return r15;
    L72:
        r3 = r34;
        goto L73
    L68:
        r118 = null;
        goto L69
    L65:
        r117 = null;
        goto L66
    L58:
        r22 = false;
    L61:
        r33 = null;
        goto L62
    L50:
        r32 = null;
        goto L51
    L43:
        if (o0.d(r14) == true) goto L47;
        r14 = this.e;
        goto L47
    L34:
        if (Intrinsics.areEqual(r111, "0") == true) goto L36;
        r113 = true;
        goto L37
    L31:
        r112 = false;
    L39:
        r210 = null;
        goto L40
    L23:
        r27 = false;
        goto L24
    L17:
        if (this.g == null) goto L20;
    L7:
        r4 = new CommunityCreationRecommendRepository$fetchBatch$1(this, r310);
        goto L8
    }

    public CommunityCreationRecommendRepository(int r3, TabItemInfo r4, String r5, CreationFeedCacheEntity r6, String r7, String r8, String r9, e29.c r10, int r11) {
        if ((r11 & 8) == 0) goto L6;
        r6 = null;
    L6:
        if ((r11 & 16) == 0) goto L9;
        r7 = null;
    L9:
        if ((r11 & 32) == 0) goto L12;
        r8 = null;
    L12:
        if ((r11 & 64) == 0) goto L15;
        r9 = null;
    L15:
        if ((r11 & 128) == 0) goto L17;
        r10 = null;
    L17:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = new com.larus.community.impl.repository.a(r10);
    }
}
