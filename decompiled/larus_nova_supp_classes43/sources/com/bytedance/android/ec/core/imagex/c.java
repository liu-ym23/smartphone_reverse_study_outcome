package com.bytedance.android.ec.core.imagex;

import android.util.Pair;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.common.utility.Logger;
import com.facebook.imagepipeline.request.ImageRequest;
import com.optimize.statistics.IMonitorHookV2;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements IMonitorHookV2 {
    public final a a;

    public interface a {
        boolean match(Object r1);
    }

    public c(k0 r1) {
        this.a = r1;
    }

    public final Pair<Boolean, Map<String, Object>> onMonitorCompleted(ImageRequest r10, Object r11, String r12, JSONObject r13, boolean r14, boolean r15) {
        m0.c("ImageMonitorHook.onMonitorCompleted()");
        if (m0.a() == true) goto L5;
        return null;
    L5:
        a r16 = this.a;
        if (r16 != null) goto L8;
    L10:
        boolean r17 = r11 instanceof u;
        if (r17 == true) goto L13;
        Object r1 = null;
    L14:
        u r18 = (u) r1;
        if (r18 == null) goto L17;
        ECImageTrackHandlerKt.b(r18, r10, r13);
    L17:
        if (r17 == true) goto L19;
        Object r19 = null;
    L20:
        u r20 = (u) r19;
        if (r20 != null) goto L23;
    L49:
        if (r17 == true) goto L51;
        Object r110 = null;
    L52:
        u r111 = (u) r110;
        if (r111 == null) goto L66;
        WeakReference<Function0<Map<String, Object>>> r112 = r111.e;
        if (r112 == null) goto L66;
        Function0<Map<String, Object>> r113 = r112.get();
        if (r113 == null) goto L66;
        Map r114 = (Map) r113.invoke();
        if (r114 == null) goto L66;
        Iterator r115 = r114.entrySet().iterator();
    L62:
        if (r115.hasNext() == false) goto L66;
        Map.Entry r21 = (Map.Entry) r115.next();
        if (r13 == null) goto L62;
        r13.put((String) r21.getKey(), r21.getValue());
    L66:
        if (r13 != null) goto L84;
    L72:
        boolean r116 = false;
    L73:
        ImageMonitor r22 = ImageMonitor.g;     // Catch: Throwable -> L70
        if ((r11 instanceof r) == true) goto L76;
        Object r23 = null;
    L77:
        r22.h(r10, (r) r23, r13, r14, r116, r15);     // Catch: Throwable -> L70
        LinkedHashMap r24 = new LinkedHashMap();     // Catch: Throwable -> L70
        if ((r11 instanceof r) == false) goto L80;
        r24.put("biz_tag", ((r) r11).f);     // Catch: Throwable -> L70
        r24.put("scene_tag", ((r) r11).g);     // Catch: Throwable -> L70
        r24.putAll(((r) r11).d);     // Catch: Throwable -> L70
    L80:
        return new Pair(Boolean.valueOf(r116), r24);
    L70:
        th = move-exception;
        Logger.e("ImageMonitorReportDebug", String.valueOf(th.getMessage()));
        return null;
    L76:
        r23 = r11;
        goto L77
    L84:
        if (r13.optBoolean("is_request_network") != true) goto L72;
        r116 = true;
        goto L73
    L51:
        r110 = r11;
        goto L52
    L23:
        if (Intrinsics.areEqual(r20.f, "ec_live") == true) goto L25;
    L27:
        boolean r25 = false;
    L28:
        if (r25 == true) goto L31;
        r20 = null;
    L31:
        if (r20 == null) goto L49;
        StringBuilder r26 = new StringBuilder("monitorData: is_request_network=");
        if (r13 == null) goto L35;
        Boolean r27 = Boolean.valueOf(r13.optBoolean("is_request_network"));
    L36:
        r26.append(r27);
        r26.append(" queue_duration=");
        if (r13 == null) goto L39;
        Integer r28 = Integer.valueOf(r13.optInt("queue_duration"));
    L40:
        r26.append(r28);
        r26.append(" download_duration=");
        if (r13 == null) goto L43;
        Integer r29 = Integer.valueOf(r13.optInt("download_duration"));
    L44:
        r26.append(r29);
        r26.append(" decode_duration=");
        if (r13 == null) goto L47;
        Integer r30 = Integer.valueOf(r13.optInt("decode_duration"));
    L48:
        r26.append(r30);
        OptCardUtil.b("image", r26.toString());
        goto L49
    L47:
        r30 = null;
        goto L48
    L43:
        r29 = null;
        goto L44
    L39:
        r28 = null;
        goto L40
    L35:
        r27 = null;
        goto L36
    L25:
        if (Intrinsics.areEqual(r20.g, "goods_card_view") == false) goto L27;
        r25 = true;
        goto L28
    L19:
        r19 = r11;
        goto L20
    L13:
        r1 = r11;
        goto L14
    L8:
        if (r16.match(r11) == true) goto L10;
        return null;
    }
}
