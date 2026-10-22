package com.ss.android.lark.officesdk.miaoda.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SendHttpRequest;
import com.bytedance.lark.pb.basic.v1.SendHttpResponse;
import com.bytedance.lark.rustclient.api.d;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.larus.office.base.service.OfficeSdkServiceV2;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKTokenProvider;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passport.dpop.DPOPServiceSdk;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import jcb.b;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@OfficeSDKUserScope
public final class a implements dub.a {
    public final l a;
    public final ConcurrentHashMap<String, Long> b;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.miaoda.impl.a$a, reason: collision with other inner class name */
    public static final class C0011a {
    }

    static {
    }

    @Inject
    public a(l r2) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        this.a = r2;
        this.b = new ConcurrentHashMap();
    }

    @Override // dub.a
    public final void kc(final String r18, final OfficeSdkServiceV2.e r19) {
        Intrinsics.checkNotNullParameter(r18, "appID");
        final long r3 = System.currentTimeMillis();
        CollectionsKt.removeAll(this.b.entrySet(), new MiaodaPrewarmCapacityImpl$prewarm$1(r3));
        Long r5 = this.b.get(r18);
        if (r5 != null) goto L5;
    L8:
        this.b.put(r18, Long.valueOf(r3));
        boolean r4 = true;
        String r6 = b.c().a("miaoda");     // Catch: Exception -> L39
        if (r6 == null) goto L15;
        if (r6.length() == 0) goto L15;
        boolean r7 = false;
    L16:
        if (r7 == true) goto L17;
    L18:
        String r8 = "https://" + r6 + "/af/api/v1/studio/app/" + URLEncoder.encode(r18, "UTF-8") + "/instance/get_or_bind?branch=sprint%2Fdefault";
        Map r9 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("Content-Type", "application/json"), TuplesKt.to("Accept", "application/json")});
        IOfficeSDKTokenProvider r10 = OfficeSDKManager.getTokenProvider();
        if (r10 != null) goto L22;
        this.b.remove(r18);
        r19.onFailure(new IllegalStateException("Missing token provider"));
        return;
    L22:
        String r11 = r10.getAccessToken();
        if (r11.length() != 0) goto L25;
        boolean r12 = true;
    L26:
        if (r12 == false) goto L29;
        this.b.remove(r18);
        r19.onFailure(new IllegalStateException("Missing access token"));
        return;
    L29:
        String r13 = r10.getAuthSchema() + ' ' + r11;
        r9.put("Authorization", r13);
        if (StringsKt.startsWith$default(r13, "DPoP ", false, 2, null) == false) goto L37;
        String r14 = new String(DPOPServiceSdk.getDPOPToken(r8, "GET"), Charsets.UTF_8);
        if (r14.length() > 0) goto L35;
        r4 = false;
    L35:
        if (r4 == false) goto L37;
        r9.put("DPoP", r14);
    L37:
        SendHttpRequest.Builder r15 = new SendHttpRequest.Builder().url(r8).method(SendHttpRequest.Method.GET).headers(r9);
        l r16 = this.a;
        Command r17 = Command.SEND_HTTP;
        Intrinsics.checkNotNull(r15);
        t.a(r16.h(new d(r15, SendHttpResponse.ADAPTER, r17, null, null, null, null, 248)).a(), new MiaodaPrewarmCapacityImpl$prewarm$2(r18, r19, this), new MiaodaPrewarmCapacityImpl$prewarm$3(r18, this, r19), new MiaodaPrewarmCapacityImpl$prewarm$4(r18, this, r19));
        return;
    L25:
        r12 = false;
    L15:
        r7 = true;
    L17:
        r6 = "miaoda.feishu.cn";
        goto L18
    L5:
        if ((r3 - r5.longValue()) >= 1200000) goto L8;
        r19.onSuccess();
    }
}
