package com.bytedance.salamander.anniex;

import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.rts.foundation.RTSMapKt;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {
    public static final Map a(j r10) {
        Intrinsics.checkNotNullParameter(r10, "containerBase");
        Map r5 = RTSMapKt.RTSMap();
        Map r11 = RTSMapKt.RTSMap();
        CoreViewType r12 = r10.f7260h.f7263a;
        Intrinsics.checkNotNullParameter(r12, "coreViewType");
        int r13 = r12.ordinal();
        if (r13 != 1) goto L5;
        String r14 = "BulletCard";
    L9:
        RTSMapKt.set(r11, "core_view_type", r14);
        l r15 = r10.f7260h;
        r15.getClass();
        RTSMapKt.set(r11, "biz", "default_bid");
        RTSMapKt.set(r11, "hit_sample", Long.valueOf(r15.d));
        RTSMapKt.set(r11, "setting_bid", r15.f7264b);
        RTSMapKt.set(r11, "setting_id", Long.valueOf(r15.f7265c));
        if (r15.e.size() <= 0) goto L12;
        RTSMapKt.set(r11, "context", r15.e);
    L12:
        r15.getClass();
        RTSMapKt.set(r5, "monitor_metric_version", "3.0");
        Intrinsics.checkNotNullParameter(ContainerName.f7212a, "containerName");
        int r16 = e.f7252a[0];
        RTSMapKt.set(r5, "container_name", "AnnieX");
        String r17 = "schema";
        RTSMapKt.set(r5, "schema", "");
        TemplateResType r18 = r10.f7257a;
        Intrinsics.checkNotNullParameter(r18, "resType");
        int r19 = r18.ordinal();
        String r20 = "unknown";
        switch(r19) {
            case 0: goto L22;
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            default: goto L14;
        };
    L14:
        String r21 = "unknown";
    L23:
        RTSMapKt.set(r5, "template_res_type", r21);
        ViewType r22 = r10.f7258b;
        Intrinsics.checkNotNullParameter(r22, "viewType");
        int r23 = r22.ordinal();
        if (r23 == 0) goto L28;
        if (r23 == 1) goto L27;
        String r24 = "card";
    L29:
        RTSMapKt.set(r5, "view_type", r24);
        RTSMapKt.set(r5, "navigation_id", r10.f7259c);
        ContainerType r25 = r10.d;
        Intrinsics.checkNotNullParameter(r25, "containerType");
        int r26 = r25.ordinal();
        if (r26 == 0) goto L34;
        if (r26 != 1) goto L35;
        r20 = "webview";
    L35:
        RTSMapKt.set(r5, "container_type", r20);
        RTSMapKt.set(r5, "container_reuse", Boolean.FALSE);
        RTSMapKt.set(r5, WsConstants.KEY_SDK_VERSION, r10.e);
        RTSMapKt.set(r5, "bid", r10.f);
        BidSource r27 = r10.g;
        Intrinsics.checkNotNullParameter(r27, "bidSource");
        if (r27.ordinal() == 0) goto L38;
        r17 = "default";
    L38:
        RTSMapKt.set(r5, "bid_source", r17);
        RTSMapKt.set(r5, "__internal", r11);
        return r5;
    L34:
        r20 = "lynx";
        goto L35
    L27:
        r24 = OpenPageMethod.APP_POPUP;
        goto L29
    L28:
        r24 = "page";
        goto L29
    L15:
        r21 = "binary_data";
        goto L23
    L16:
        r21 = "template_bundle";
        goto L23
    L17:
        r21 = "offline";
        goto L23
    L18:
        r21 = "builtin";
        goto L23
    L19:
        r21 = "cdn_cache";
        goto L23
    L20:
        r21 = "cdn";
        goto L23
    L21:
        r21 = "gecko_update";
        goto L23
    L22:
        r21 = "gecko";
        goto L23
    L5:
        if (r13 == 2) goto L7;
        r14 = "AnnieXCard";
        goto L9
    L7:
        r14 = "BDXView";
        goto L9
    }

    public static final Map b(m r5) {
        Intrinsics.checkNotNullParameter(r5, "jsBase");
        Map r10 = RTSMapKt.RTSMap();
        r5.getClass();
        Map r11 = r5.f7266a;
        if (r11.size() <= 0) goto L5;
        RTSMapKt.set(r10, "context", r11);
    L5:
        return r10;
    }

    public static final Map c(SLEventType r5, Map r10, Map r11, Map r12) {
        Intrinsics.checkNotNullParameter(r5, "eventType");
        Intrinsics.checkNotNullParameter(r10, "containerBase");
        Intrinsics.checkNotNullParameter(r11, "jsBase");
        Intrinsics.checkNotNullParameter(r12, "eventInfo");
        Map r13 = RTSMapKt.RTSMap();
        Map r14 = RTSMapKt.RTSMap();
        RTSMapKt.set(r13, "event_type", a.a(r5));
        RTSMapKt.set(r13, "container_base", r10);
        RTSMapKt.set(r13, "js_base", r11);
        Intrinsics.checkNotNullParameter(r12, "jsonMap");
        String r15 = new JSONObject(r12).toString();
        Intrinsics.checkNotNull(r15);
        RTSMapKt.set(r13, "event_info", r15);
        RTSMapKt.set(r14, "extra", r13);
        return r14;
    }

    public static final void d(t r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        e(r5);
    }

    public static final Map e(t r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        Map r5 = a(r10.f7276a);
        Map r11 = b(r10.f7277b);
        Object r12 = null;
        if (((n) r10.f7278c.f808b) == null) goto L18;
        Map r13 = RTSMapKt.RTSMap();
        if (r13 == null) goto L11;
        n r14 = (n) r10.f7278c.f808b;
        if (r14 == null) goto L9;
        int r15 = r14.f7268b;
    L10:
        RTSMapKt.set(r13, WsConstants.ERROR_CODE, Integer.valueOf(r15));
        goto L11
    L9:
        r15 = 0;
    L11:
        if (r13 == null) goto L19;
        n r16 = (n) r10.f7278c.f808b;
        if (r16 == null) goto L16;
        String r17 = r16.f7269c;
        if (r17 == null) goto L16;
    L17:
        RTSMapKt.set(r13, "error_msg", r17);
    L16:
        r17 = "";
    L19:
        jg.k r18 = (jg.k) r10.f7278c.f809c;
        if (r18 == null) goto L22;
        String r19 = (String) r18.f18339b;
    L23:
        if (r19 == null) goto L31;
        Map r20 = RTSMapKt.RTSMap();
        if (r20 == null) goto L30;
        jg.k r21 = (jg.k) r10.f7278c.f809c;
        if (r21 == null) goto L29;
        r12 = (String) r21.f18339b;
    L29:
        Intrinsics.checkNotNull(r12);
        RTSMapKt.set(r20, "exception", r12);
    L30:
        r12 = r20;
    L31:
        Map r22 = RTSMapKt.RTSMap();
        RTSMapKt.set(r22, "error_ts", Long.valueOf(r10.f7278c.f807a));
        if (r13 == null) goto L34;
        RTSMapKt.set(r22, "native_info", r13);
    L34:
        if (r12 == null) goto L36;
        RTSMapKt.set(r22, "js_info", r12);
    L36:
        String r23 = (String) r10.f7278c.d;
        if (r23 == null) goto L39;
        Intrinsics.checkNotNull(r23);
        RTSMapKt.set(r22, "root_cause", r23);
    L39:
        Map r24 = (Map) r10.f7278c.e;
        if (r24 == null) goto L45;
        Intrinsics.checkNotNull(r24);
        if (r24.size() <= 0) goto L45;
        Map r25 = (Map) r10.f7278c.e;
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type kotlin.Any");
        RTSMapKt.set(r22, "js_error_context", TypeIntrinsics.asMutableMap(r25));
    L45:
        return c(SLEventType.f7229c, r5, r11, r22);
    L22:
        r19 = null;
        goto L23
    L18:
        r13 = null;
        goto L19
    }
}
