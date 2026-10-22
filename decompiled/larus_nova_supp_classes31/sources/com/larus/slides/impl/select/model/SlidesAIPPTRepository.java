package com.larus.slides.impl.select.model;

import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.ttnet.http.RequestContext;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class SlidesAIPPTRepository {
    public static final SlidesAIPPTRepository a = null;

    static {
        a = new SlidesAIPPTRepository();
    }

    public SlidesAIPPTRepository() {
    }

    public final Object a(a r17, Continuation<? super com.larus.network.http.a<b>> r18) {
        if ((r18 instanceof SlidesAIPPTRepository$genImages$1) == false) goto L7;
        SlidesAIPPTRepository$genImages$1 r1 = (SlidesAIPPTRepository$genImages$1) r18;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        SlidesAIPPTRepository$genImages$1 r13 = r1;
        Object r0 = r13.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r13.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
    L51:
        com.larus.network.http.a r5 = (com.larus.network.http.a) r0;
        FLogger.a.i("CommerceCreditRepo", "genImages end");
        return r5;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        FLogger.a.i("CommerceCreditRepo", "genImages start");
        e.a r6 = e.a;
        if (e.b != null) goto L25;
        monitor-enter(r6);
    L22:
        th = move-exception;
        throw th;
    L18:
        if (e.b != null) goto L20;
        e.b = new e();     // Catch: Throwable -> L22
    L20:
        monitor-exit(r6);
    L25:
        r13.label = 1;
        JSONArray r7 = new JSONArray();
        List<c> r8 = r17.d();
        if (r8 == null) goto L48;
        Iterator<T> r9 = r8.iterator();
    L29:
        if (r9.hasNext() == false) goto L48;
        c r10 = (c) r9.next();
        JSONObject r11 = new JSONObject();
        if (r10 == null) goto L35;
        String r12 = r10.b();
        if (r12 == null) goto L35;
        r11.put("uri", r12);
    L35:
        if (r10 == null) goto L39;
        String r14 = r10.c();
        if (r14 == null) goto L39;
        r11.put("url", r14);
    L39:
        if (r10 == null) goto L43;
        Integer r15 = r10.d();
        if (r15 == null) goto L43;
        r11.put("width", r15.intValue());
    L43:
        if (r10 == null) goto L47;
        Integer r16 = r10.a();
        if (r16 == null) goto L47;
        r11.put("height", r16.intValue());
    L47:
        r7.put(r11);
    L48:
        JSONObject r19 = new JSONObject();
        r19.put("scene", 1);
        r19.put("query", r17.b());
        r19.put("ratio", r17.c());
        r19.put("reference_images", r7);
        r19.put("need_short_link", r17.a());
        Unit r20 = Unit.INSTANCE;
        Map r110 = MapsKt.mapOf(TuplesKt.to("scene", "SlidesAIPPTGenerateImage"));
        RequestContext r111 = new RequestContext();
        ((BaseRequestContext) r111).timeout_connect = 60000;
        ((BaseRequestContext) r111).timeout_read = 60000;
        ((BaseRequestContext) r111).timeout_write = 60000;
        r0 = HttpExtKt.k("Basic", b.class, "/alice/aippt/gen_images", r19, null, null, true, r110, r111, null, r13, 560);
        if (r0 != r3) goto L51;
        return r3;
    L7:
        r1 = new SlidesAIPPTRepository$genImages$1(this, r18);
        goto L8
    }
}
