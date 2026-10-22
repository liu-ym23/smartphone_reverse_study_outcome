package com.ss.android.lark.parser.internal;

import android.util.ArrayMap;
import com.bytedance.lark.pb.basic.v1.PreviewEntityPair;
import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.bytedance.lark.pb.basic.v1.UrlPreviewHangPoint;
import com.ss.android.lark.chat.api.service.impl.PreviewCache;
import com.ss.android.lark.chat.api.service.impl.PreviewService;
import com.ss.android.lark.chat.api.service.request.PullUrlPreviewRequest;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.SendScene;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class w {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Map r6, Map r7, PullUrlPreviewRequest.a r8) {
        Intrinsics.checkNotNullParameter(r7, "pbPreviewEntities");
        Intrinsics.checkNotNullParameter(r8, "lazyLoadRequestBuilder");
        if (r6 == null) goto L25;
        Iterator r9 = r6.entrySet().iterator();
    L6:
        if (r9.hasNext() == false) goto L39;
        PreviewHangPoint r0 = (PreviewHangPoint) ((Map.Entry) r9.next()).getValue();
        if (r0 == null) goto L6;
        String r1 = r0.getPreviewId();
        if (r1 == null) goto L12;
        Iterator r2 = r7.entrySet().iterator();
    L14:
        UrlPreviewEntity r4 = null;
        if (r2.hasNext() == false) goto L21;
        Map.Entry r3 = (Map.Entry) r2.next();
        UrlPreviewEntity r5 = (String) r3.getKey();
        Map r10 = ((PreviewEntityPair) r3.getValue()).preview_entity;
        if (r10 == null) goto L19;
        r4 = (UrlPreviewEntity) r10.get(r1);
    L19:
        if (r4 == null) goto L14;
        r4 = r5;
    L21:
        UrlPreviewHangPoint r11 = new UrlPreviewHangPoint.Builder().preview_id(r0.getPreviewId()).url(r0.getUrl()).need_local_preview(Boolean.valueOf(r0.getNeedLocalPreview())).is_lazy_load(Boolean.valueOf(r0.isLazyLoad())).build();
        if (r4 != null) goto L24;
        r4 = "";
    L24:
        Intrinsics.checkNotNull(r11);
        r0.setUrlCardPreviewEntity(b(r4, r7, r11, r0.isLazyLoad(), r8));
        goto L6
    L12:
        Log.w("[URLPreview]MPPreviewHangPoint", "previewId == null");
        goto L6
    L39:
        return;
    }

    public static UrlCardPreviewEntity c(String r4, String r5, Map r6) {
        if (r6 == null) goto L9;
        PreviewEntityPair r7 = (PreviewEntityPair) r6.get(r4);
        if (r7 == null) goto L9;
        Map r8 = r7.preview_entity;
        if (r8 == null) goto L9;
        UrlPreviewEntity r9 = (UrlPreviewEntity) r8.get(r5);
    L10:
        if (r9 == null) goto L12;
        UrlCardPreviewEntity r10 = j6b.d.d(r9, false);
    L13:
        Lazy r1 = PreviewCache.f;
        Map r2 = PreviewCache.a.a().c(r4, new ArrayList(Collections.singleton(r5)));
        if (r2 == null) goto L16;
        UrlCardPreviewEntity r3 = (UrlCardPreviewEntity) ((ArrayMap) r2).get(r5);
    L18:
        if (r3 != null) goto L22;
        if (r10 != null) goto L22;
        Log.i("[URLPreview]MPPreviewHangPoint", "preview entity is null!!! previewId:" + r5 + ",messageId:" + r4);
        return null;
    L22:
        if (r3 != null) goto L26;
        if (r10 == null) goto L26;
        k6b.a r11 = k6b.a.a;
        k6b.a.b(r10.getInlineEntity(), "[URLPreview]MPPreviewHangPoint", "preview entity from pb");
        return r10;
    L26:
        if (r3 == null) goto L30;
        if (r10 != null) goto L30;
        k6b.a r12 = k6b.a.a;
        k6b.a.b(r3.getInlineEntity(), "[URLPreview]MPPreviewHangPoint", "preview entity from cache");
        return r3;
    L30:
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNull(r3);
        if (r10.compareTo(r3) < 0) goto L34;
        k6b.a r13 = k6b.a.a;
        k6b.a.b(r10.getInlineEntity(), "[URLPreview]MPPreviewHangPoint", "preview entity from pb");
        return r10;
    L34:
        k6b.a r14 = k6b.a.a;
        k6b.a.b(r3.getInlineEntity(), "[URLPreview]MPPreviewHangPoint", "preview entity from cache");
        return r3;
    L16:
        r3 = null;
        goto L18
    L12:
        r10 = null;
    L9:
        r9 = null;
        goto L10
    }

    @JvmStatic
    public static final Map d(String r18, Map r19, Map r20) {
        Intrinsics.checkNotNullParameter(r18, "messageId");
        PullUrlPreviewRequest.a r11 = new PullUrlPreviewRequest.a();
        LinkedHashMap r12 = new LinkedHashMap();
        if (r19 == null) goto L60;
        Iterator r13 = r19.entrySet().iterator();
    L6:
        if (r13.hasNext() == false) goto L60;
        Map.Entry r14 = (Map.Entry) r13.next();
        UrlPreviewHangPoint r0 = (UrlPreviewHangPoint) r14.getValue();
        String r1 = r0.url;
        String r2 = (String) r14.getKey();
        String r4 = r0.preview_id;
        boolean r5 = r0.need_local_preview.booleanValue();
        Boolean r3 = r0.is_lazy_load;
        if (r3 == null) goto L10;
        boolean r6 = r3.booleanValue();
    L11:
        UrlPreviewHangPoint.SendScene r7 = r0.send_scene;
        if (r7 == null) goto L18;
        SendScene.a r8 = SendScene.Companion;
        int r9 = r7.getValue();
        r8.getClass();
        if (r9 != 1) goto L16;
        SendScene r10 = SendScene.DOUBAO_CLOUD_DRIVE_CHOOSE;
    L17:
        if (r10 == null) goto L18;
    L19:
        SendScene r15 = r10;
        Boolean r16 = r0.is_lazy_load;
        if (r16 == null) goto L22;
        boolean r17 = r16.booleanValue();
    L23:
        PreviewHangPoint r21 = new PreviewHangPoint(r1, r2, r18, r4, r5, r6, r15, b(r18, r20, r0, r17, r11));
        r12.put(r14.getKey(), r21);
        UrlCardPreviewEntity r22 = r21.getUrlCardPreviewEntity();
        if (r22 == null) goto L28;
        UrlPreviewBody r23 = r22.getPreviewBody();
        if (r23 == null) goto L28;
        HashMap r24 = r23.getComponentHangPoints();
    L29:
        if (r24 != null) goto L31;
    L34:
        boolean r25 = true;
    L35:
        if (r25 == true) goto L6;
        if (r20 != null) goto L39;
    L42:
        boolean r110 = true;
    L43:
        if (r110 == true) goto L44;
        Iterator r26 = r24.entrySet().iterator();
    L57:
        if (r26.hasNext() == false) goto L6;
        a((Map) ((Map.Entry) r26.next()).getValue(), r20, r11);
        goto L57
    L44:
        Iterator r27 = r24.entrySet().iterator();
    L46:
        if (r27.hasNext() == false) goto L6;
        Map r28 = (Map) ((Map.Entry) r27.next()).getValue();
        if (r28 == null) goto L46;
        Iterator r29 = r28.entrySet().iterator();
    L51:
        if (r29.hasNext() == false) goto L46;
        PreviewHangPoint r30 = (PreviewHangPoint) ((Map.Entry) r29.next()).getValue();
        if (r30 == null) goto L51;
        Intrinsics.checkNotNullParameter(r18, "sourceId");
        Intrinsics.checkNotNullParameter(r30, "hangPoint");
        UrlPreviewHangPoint r31 = new UrlPreviewHangPoint.Builder().url(r30.getUrl()).preview_id(r30.getPreviewId()).need_local_preview(Boolean.valueOf(r30.getNeedLocalPreview())).is_lazy_load(Boolean.valueOf(r30.isLazyLoad())).build();
        Intrinsics.checkNotNull(r31);
        r11.a(r18, r31);
        goto L51
    L39:
        if (r20.isEmpty() == true) goto L42;
        r110 = false;
        goto L43
    L31:
        if (r24.isEmpty() == true) goto L34;
        r25 = false;
    L28:
        r24 = null;
        goto L29
    L22:
        r17 = false;
        goto L23
    L16:
        r10 = SendScene.DEFAULT;
    L18:
        r10 = SendScene.DEFAULT;
        goto L19
    L10:
        r6 = false;
    L60:
        if (r11.a.isEmpty() == true) goto L63;
        PullUrlPreviewRequest r32 = new PullUrlPreviewRequest(r11.a);
        ((PreviewService) PreviewService.c.getValue()).Fa(r32);
    L63:
        return r12;
    }

    public static UrlCardPreviewEntity b(String r1, Map r2, UrlPreviewHangPoint r3, boolean r4, PullUrlPreviewRequest.a r5) {
        String r0 = r3.preview_id;
        Intrinsics.checkNotNull(r0);
        UrlCardPreviewEntity r6 = c(r1, r0, r2);
        if (r6 != null) goto L7;
        if (r4 == false) goto L9;
        r5.a(r1, r3);
    L9:
        return r6;
    L7:
        if (r6.getInlineEntity().getNeedReload() == false) goto L9;
        r5.a(r1, r3);
        goto L9
    }
}
