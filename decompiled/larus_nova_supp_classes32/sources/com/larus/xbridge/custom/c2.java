package com.larus.xbridge.custom;

import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.lynx.tasm.LynxError;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c2 implements te7.a {
    public final String a;
    public final String b;
    public final /* synthetic */ com.bytedance.sdk.xbridge.cn.network.a.b c;
    public final /* synthetic */ RequestMethod d;
    public final /* synthetic */ IBDXBridgeContext e;
    public final /* synthetic */ CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> f;
    public final /* synthetic */ PlatformType g;

    public final void a(JSONObject r6, LinkedHashMap<String, String> r7, Integer r8, int r9) {
        Intrinsics.checkNotNullParameter(r6, "body");
        Intrinsics.checkNotNullParameter(r7, "responseHeader");
        RequestMethod r0 = this.d;
        this.c.getUrl();
        RequestMethod.a(r0);
        CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r1 = this.f;
        XBaseResultModel r2 = ne7.e.c(Reflection.getOrCreateKotlinClass(com.bytedance.sdk.xbridge.cn.network.a.c.class));
        com.bytedance.sdk.xbridge.cn.network.a.c r3 = (com.bytedance.sdk.xbridge.cn.network.a.c) r2;
        if (r8 != null) goto L6;
        r8 = -1;
    L6:
        r3.setHttpCode(r8);
        r3.setPrefetchStatus(0);
        r3.setClientCode(Integer.valueOf(r9));
        r3.setHeader(r7);
        String r10 = r7.get("x-tt-logid");     // Catch: Throwable -> L16
        LinkedHashMap r11 = new LinkedHashMap();     // Catch: Throwable -> L16
        Iterator<String> r12 = r6.keys();     // Catch: Throwable -> L16
    L9:
        if (r12.hasNext() == false) goto L12;
        String r4 = r12.next();     // Catch: Throwable -> L16
        r11.put(r4, r6.get(r4));     // Catch: Throwable -> L16
        goto L9
    L12:
        if (r10 != null) goto L14;
        r10 = NameKeys.UnloadStrategy_No_Strategy;
    L14:
        r11.put("_Header_RequestID", r10);     // Catch: Throwable -> L16
        r3.setResponse(ne7.e.a(r11));     // Catch: Throwable -> L16
    L17:
        CompletionBlock.DefaultImpls.onSuccess$default(r1, r2, null, 2, null);
        return;
    L16:
        int r13 = RequestMethod.e;
        goto L17
    }

    public final void c(Integer r12, LinkedHashMap<String, String> r13, Throwable r14, int r15) {
        Intrinsics.checkNotNullParameter(r14, LynxError.LYNX_THROWABLE);
        RequestMethod r0 = this.d;
        this.c.getUrl();
        RequestMethod.a(r0);
        if ((r14 instanceof NetworkNotAvailabeException) == false) goto L5;
        int r1 = -1001;
    L6:
        RequestMethod r2 = this.d;
        IBDXBridgeContext r3 = this.e;
        String r4 = this.a;
        String r5 = this.b;
        int r10 = -408;
        if (r12 == null) goto L9;
        int r6 = r12.intValue();
    L10:
        Integer r7 = Integer.valueOf(r6);
        String r8 = r14.toString();
        String r9 = this.g.name();
        r2.b(r3, r4, r5, r7, r1, r8, r9);
        CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r11 = this.f;
        XBaseResultModel r16 = ne7.e.c(Reflection.getOrCreateKotlinClass(com.bytedance.sdk.xbridge.cn.network.a.c.class));
        com.bytedance.sdk.xbridge.cn.network.a.c r17 = (com.bytedance.sdk.xbridge.cn.network.a.c) r16;
        r17.setPrefetchStatus(0);
        if (r12 == null) goto L13;
        Integer r18 = r12;
    L14:
        r17.setHttpCode(r18);
        r17.setClientCode(Integer.valueOf(r15));
        if (r13 == null) goto L17;
        String r19 = r13.get("x-tt-logid");
    L18:
        LinkedHashMap r110 = new LinkedHashMap();
        if (r12 == null) goto L21;
        r10 = r12.intValue();
    L21:
        r110.put("errCode", Integer.valueOf(r10));
        String r111 = r14.getMessage();
        if (r111 != null) goto L24;
        r111 = NameKeys.UnloadStrategy_No_Strategy;
    L24:
        r110.put("message", r111);
        r110.put("prompts", NameKeys.UnloadStrategy_No_Strategy);
        if (r19 != null) goto L27;
        r19 = NameKeys.UnloadStrategy_No_Strategy;
    L27:
        r110.put("_Header_RequestID", r19);
        r17.setResponse(ne7.e.a(r110));
        Unit r112 = Unit.INSTANCE;
        r11.onFailure(r1, NameKeys.UnloadStrategy_No_Strategy, r16);
        return;
    L17:
        r19 = null;
        goto L18
    L13:
        r18 = -408;
        goto L14
    L9:
        r6 = -408;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }

    public c2(com.bytedance.sdk.xbridge.cn.network.a.b r1, RequestMethod r2, IBDXBridgeContext r3, long r4, CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r6, PlatformType r7) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
        this.f = r6;
        this.g = r7;
        this.a = r1.getMethod();
        this.b = r1.getUrl();
    }

    public final Unit b(JSONObject r16, LinkedHashMap<String, String> r17, String r18, Throwable r19, Integer r20, int r21) {
        Intrinsics.checkNotNullParameter(r16, "body");
        Intrinsics.checkNotNullParameter(r17, "responseHeader");
        Intrinsics.checkNotNullParameter(r18, "rawResponse");
        Intrinsics.checkNotNullParameter(r19, LynxError.LYNX_THROWABLE);
        RequestMethod r4 = this.d;
        this.c.getUrl();
        RequestMethod.a(r4);
        String r9 = this.a;
        String r10 = this.b;
        String r13 = r19.toString();
        String r14 = this.g.name();
        this.d.b(this.e, r9, r10, r20, 0, r13, r14);
        CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r5 = this.f;
        String r6 = r19.toString();
        XBaseResultModel r7 = ne7.e.c(Reflection.getOrCreateKotlinClass(com.bytedance.sdk.xbridge.cn.network.a.c.class));
        com.bytedance.sdk.xbridge.cn.network.a.c r8 = (com.bytedance.sdk.xbridge.cn.network.a.c) r7;
        if (r20 == null) goto L5;
        Integer r11 = r20;
    L6:
        r8.setHttpCode(r11);
        r8.setClientCode(Integer.valueOf(r21));
        r8.setPrefetchStatus(0);
        r8.setHeader(r17);
        String r2 = r17.get("x-tt-logid");     // Catch: Throwable -> L16
        LinkedHashMap r12 = new LinkedHashMap();     // Catch: Throwable -> L16
        Iterator<String> r15 = r16.keys();     // Catch: Throwable -> L16
    L9:
        if (r15.hasNext() == false) goto L12;
        String r110 = r15.next();     // Catch: Throwable -> L16
        r12.put(r110, r16.get(r110));     // Catch: Throwable -> L16
        goto L9
    L12:
        if (r2 != null) goto L14;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L14:
        r12.put("_Header_RequestID", r2);     // Catch: Throwable -> L16
        r8.setResponse(ne7.e.a(r12));     // Catch: Throwable -> L16
    L17:
        r8.setRawResponse(r18);
        Unit r1 = Unit.INSTANCE;
        r5.onFailure(0, r6, r7);
        return Unit.INSTANCE;
    L16:
        int r3 = RequestMethod.e;
        goto L17
    L5:
        r11 = -1;
        goto L6
    }
}
