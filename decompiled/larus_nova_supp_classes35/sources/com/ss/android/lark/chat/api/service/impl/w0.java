package com.ss.android.lark.chat.api.service.impl;

import android.util.ArrayMap;
import com.bytedance.lark.pb.basic.v1.PreviewEntityPair;
import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.bytedance.lark.pb.basic.v1.UrlPreviewHangPoint;
import com.bytedance.lark.pb.im.v1.PushMessagePreviewsRequest;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.api.service.request.PullUrlPreviewRequest;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class w0 implements Runnable {
    public final /* synthetic */ PreviewPush a;
    public final /* synthetic */ PushMessagePreviewsRequest b;

    public w0(PreviewPush r1, PushMessagePreviewsRequest r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        PreviewPush r0 = this.a;
        PushMessagePreviewsRequest r1 = this.b;
        r0.getClass();
        PullUrlPreviewRequest.a r2 = new PullUrlPreviewRequest.a();
        HashMap r3 = new HashMap();
        if (CollectionUtils.isEmpty(r1.preview_entities) == false) goto L15;
        Map r4 = r1.need_load_ids;
        if (r4 == null) goto L14;
        Iterator r5 = r4.entrySet().iterator();
    L8:
        if (r5.hasNext() == false) goto L14;
        Map.Entry r6 = (Map.Entry) r5.next();
        String r7 = (String) r6.getKey();
        List<String> r8 = ((PushMessagePreviewsRequest.PreviewPair) r6.getValue()).preview_ids;
        Intrinsics.checkNotNull(r8);
        if ((!r8.isEmpty()) == false) goto L8;
        List<UrlPreviewHangPoint> r9 = r0.a(r7, r8);
        if (r9 == null) goto L8;
        r2.b(r7, r9);
    L14:
        StringBuilder r10 = new StringBuilder("push preview entities isEmpty，all needReload, ");
        int r11 = PullUrlPreviewRequest.c;
        r10.append(PullUrlPreviewRequest.b.a(r2.a, "PullUrlPreviewRequest.Builder"));
        Log.i("[URLPreview] pushMessagePreviews", r10.toString());
    L44:
        LinkedHashMap r12 = new LinkedHashMap(r1.message_links);
        Lazy<PreviewCache> r13 = PreviewCache.f;
        PreviewCache.a.a().e(r3, r12);
        r0.b.Fa(new PullUrlPreviewRequest(r2.a));
        return;
    L15:
        Iterator r14 = r1.preview_entities.entrySet().iterator();
    L17:
        if (r14.hasNext() == false) goto L44;
        Map.Entry r15 = (Map.Entry) r14.next();
        String r16 = (String) r15.getKey();
        ArrayMap r17 = new ArrayMap();
        LinkedHashSet r18 = new LinkedHashSet();
        Iterator r19 = ((PreviewEntityPair) r15.getValue()).preview_entity.entrySet().iterator();
    L20:
        if (r19.hasNext() == false) goto L39;
        Map.Entry r110 = (Map.Entry) r19.next();
        UrlCardPreviewEntity r111 = j6b.d.d((UrlPreviewEntity) r110.getValue(), false);
        UrlPreviewBody r112 = r111.getPreviewBody();
        if (r112 == null) goto L24;
        HashMap<String, Map<String, PreviewHangPoint>> r113 = r112.getComponentHangPoints();
    L25:
        if (r113 == null) goto L31;
        Iterator<Map.Entry<String, Map<String, PreviewHangPoint>>> r114 = r113.entrySet().iterator();
    L28:
        if (r114.hasNext() == false) goto L31;
        Map<String, PreviewHangPoint> r115 = r114.next().getValue();
        int r116 = com.ss.android.lark.parser.internal.w.a;
        com.ss.android.lark.parser.internal.w.a(r115, r1.preview_entities, r2);
    L31:
        if (r111.getInlineEntity().getNeedReload() == true) goto L33;
        r17.put(r110.getKey(), r111);
    L38:
        h6b.g.b.b(r111, "[URLPreview] pushMessagePreviews");
        goto L20
    L33:
        UrlCardPreviewEntity r117 = d1.a(r16, r111.getInlineEntity().getPreviewId());
        if (r117 != null) goto L36;
    L37:
        r18.add(r111.getInlineEntity().getPreviewId());
        goto L38
    L36:
        if (r111.compareTo2(r117) < 0) goto L38;
    L24:
        r113 = null;
        goto L25
    L39:
        r3.put(r16, r17);
        List<String> r20 = CollectionsKt.toList(r18);
        if ((!r20.isEmpty()) == false) goto L17;
        List<UrlPreviewHangPoint> r21 = r0.a(r16, r20);
        if (r21 == null) goto L17;
        r2.b(r16, r21);
        goto L17
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
