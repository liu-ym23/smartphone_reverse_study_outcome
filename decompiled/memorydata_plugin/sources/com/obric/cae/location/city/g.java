package com.obric.cae.location.city;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    public interface a {
        String a(com.obric.cae.location.geosdk.bytedance.a.ai r1);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f7064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<com.obric.cae.location.geosdk.bytedance.a.ai> f7065b;

        public b(boolean r3, List<com.obric.cae.location.geosdk.bytedance.a.ai> r4) {
            List<com.obric.cae.location.geosdk.bytedance.a.ai> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            this.f7064a = r3;
            this.f7065b = r5;
        }
    }

    public static boolean a(String r18, String r19, String r20, String r21, int r22, a r23, LinkedHashMap r24) {
        a r11 = (a) ZeusTransformUtils.wrapperContextForParams(r23, a.class, "com.obric.memorydata.plugin");
        int r13 = 1;
    L3:
        if (r13 > r22) goto L89;
        com.obric.cae.log.a.d("StarLocation-trafficGeo", r21 + " request: keyword=" + r19 + ", index=o_project_bamp_search, pageNum=" + r13 + ", pageSize=20, dsl=" + r20 + ", requestCount=" + r22);
        com.obric.cae.location.geosdk.bytedance.a.am r1 = com.obric.cae.location.geosdk.bytedance.a.a().d(r19, r13, 20, "o_project_bamp_search", r20);
        int r2 = 0;
        if (r1 == null) goto L19;
        Map<String, List<com.obric.cae.location.geosdk.bytedance.a.ai>> r3 = r1.f7113a;
        if (r3 != null) goto L10;
    L12:
        Integer r4 = r1.f7114b;
        if (r4 == null) goto L19;
        if (r4.intValue() != 0) goto L17;
    L18:
        boolean r5 = true;
    L21:
        if (r5 == false) goto L22;
        Map<String, List<com.obric.cae.location.geosdk.bytedance.a.ai>> r6 = r1.f7113a;
        if (r6 == null) goto L67;
        if (r6.isEmpty() == true) goto L67;
        Iterator<List<com.obric.cae.location.geosdk.bytedance.a.ai>> r7 = r6.values().iterator();
    L44:
        if (r7.hasNext() == false) goto L64;
        List r8 = (List) ZeusTransformUtils.preCheckCast(r7.next(), List.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L44;
        r2 = r2 + r8.size();
        Iterator r9 = r8.iterator();
    L50:
        if (r9.hasNext() == false) goto L44;
        r7 = r7;
        com.obric.cae.location.geosdk.bytedance.a.ai r10 = (com.obric.cae.location.geosdk.bytedance.a.ai) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.cae.location.geosdk.bytedance.a.ai.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L50;
        String r12 = r11.a(r10);
        if (r12 == null) goto L61;
        if (r12.isEmpty() == true) goto L50;
        r24.put(r12, r10);
    L61:
        r9 = r9;
        goto L50
    L64:
        if (r2 <= 0) goto L65;
        r13 = r13 + 1;
        goto L3
    L65:
        StringBuilder r14 = new StringBuilder().append(r21);
        String r15 = " result size=0 for city=";
    L68:
        com.obric.cae.log.a.d("StarLocation-trafficGeo", r14.append(r15).append(r18).append(", keyword=").append(r19).append(", pageNum=").append(r13).append(", stop paging").toString());
        return true;
    L67:
        r14 = new StringBuilder().append(r21);
        r15 = " empty result for city=";
        goto L68
    L22:
        String r16 = null;
        if (r1 != null) goto L25;
        Integer r17 = null;
    L26:
        if (r1 == null) goto L30;
        r16 = r1.c;
    L30:
        if (r17 != null) goto L32;
    L34:
        StringBuilder r25 = new StringBuilder().append(r21);
        String r26 = " poi search failed, city=";
    L35:
        com.obric.cae.log.a.h("StarLocation-trafficGeo", r25.append(r26).append(r18).append(", keyword=").append(r19).append(", code=").append(r17).append(", msg=").append(r16).toString());
        return false;
    L32:
        if (r17.intValue() != 102000011) goto L34;
        r25 = new StringBuilder().append(r21);
        r26 = " poi search did not ready, city=";
        goto L35
    L25:
        r17 = r1.f7114b;
        goto L26
    L17:
        if (r4.intValue() != 102000001) goto L19;
    L10:
        if (r3.isEmpty() == true) goto L12;
    L19:
        r5 = false;
        goto L21
    L89:
        return true;
    }
}
