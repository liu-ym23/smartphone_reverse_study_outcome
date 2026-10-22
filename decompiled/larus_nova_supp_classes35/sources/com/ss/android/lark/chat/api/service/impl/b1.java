package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.MessageLink;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.basic.v1.UrlPreviewHangPoint;
import com.bytedance.lark.pb.im.v1.GetMessagePreviewsRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.api.service.request.PullUrlPreviewRequest;
import com.ss.android.lark.chat.preview.entity.PreviewFetchStrategy;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.log.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b1 implements Runnable {
    public final /* synthetic */ PreviewService a;
    public final /* synthetic */ Collection<u0> b;

    public b1(PreviewService r1, Collection<u0> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        PullUrlPreviewRequest.a r0 = new PullUrlPreviewRequest.a();
        Iterator<T> r1 = this.b.iterator();
    L3:
        boolean r3 = true;
        if (r1.hasNext() == false) goto L11;
        u0 r2 = (u0) r1.next();
        if ((true ^ r2.a.a.isEmpty()) == false) goto L3;
        PullUrlPreviewRequest r4 = r2.a;
        Intrinsics.checkNotNullParameter(r4, "request");
        Iterator<Map.Entry<String, List<UrlPreviewHangPoint>>> r5 = r4.a.entrySet().iterator();
    L9:
        if (r5.hasNext() == false) goto L3;
        Map.Entry<String, List<UrlPreviewHangPoint>> r6 = r5.next();
        r0.b(r6.getKey(), r6.getValue());
        goto L9
    L11:
        Map<String, List<UrlPreviewHangPoint>> r7 = r0.a;
        PullUrlPreviewRequest r8 = new PullUrlPreviewRequest(r7);
        Log.i("[URLPreview] PreviewService", "lazy load start " + ((String) r8.b.getValue()));
        final PreviewService r9 = this.a;
        PreviewFetchStrategy r10 = PreviewFetchStrategy.FORCE_SERVER;
        r9.getClass();
        Log.i("[URLPreview] GetMessagePreviewsRequest", "start, " + ((String) r8.b.getValue()));
        HashMap r11 = new HashMap();
        Iterator<Map.Entry<String, List<UrlPreviewHangPoint>>> r12 = r7.entrySet().iterator();
    L13:
        if (r12.hasNext() == false) goto L15;
        Map.Entry<String, List<UrlPreviewHangPoint>> r13 = r12.next();
        r11.put(r13.getKey(), new GetMessagePreviewsRequest.UrlPreviewHangPointPair.Builder().hang_points(r13.getValue()).build());
        goto L13
    L15:
        GetMessagePreviewsRequest.Builder r14 = new GetMessagePreviewsRequest.Builder().hang_point_pair_map(r11).sync_data_strategy(SyncDataStrategy.fromValue(r10.getValue()));
        Intrinsics.checkNotNull(r14);
        if (r10 != PreviewFetchStrategy.FORCE_SERVER) goto L18;
        Pair<Map<String, Map<String, UrlCardPreviewEntity>>, LinkedHashMap<String, MessageLink>> r15 = r9.a.a(r14, new PreviewService$syncGetMessagePreviewServer$1(r9), PreviewService$syncGetMessagePreviewServer$2.INSTANCE);
    L19:
        if (r15 == null) goto L21;
        Map r16 = (Map) r15.getFirst();
    L22:
        StringBuilder r17 = new StringBuilder("lazy load end ");
        r17.append((String) r8.b.getValue());
        r17.append(", result empty: ");
        if (r16 != null) goto L25;
    L27:
        boolean r18 = false;
    L28:
        r17.append(r18);
        Log.i("[URLPreview] PreviewService", r17.toString());
        if (r16 != null) goto L31;
    L34:
        if (r3 == true) goto L43;
        Lazy<PreviewCache> r19 = PreviewCache.f;
        PreviewCache.a.a().e(r16, (Map) r15.getSecond());
        return;
    L43:
        return;
    L31:
        if (r16.isEmpty() == true) goto L34;
        r3 = false;
        goto L34
    L25:
        if (r16.isEmpty() != true) goto L27;
        r18 = true;
        goto L28
    L21:
        r16 = null;
        goto L22
    L18:
        r15 = r9.a.a(r14, new PreviewService$syncGetMessagePreviewLocal$1(r9), PreviewService$syncGetMessagePreviewLocal$2.INSTANCE);
        goto L19
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
