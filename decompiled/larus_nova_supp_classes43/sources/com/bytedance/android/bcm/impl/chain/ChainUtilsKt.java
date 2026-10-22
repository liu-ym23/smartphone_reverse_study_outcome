package com.bytedance.android.bcm.impl.chain;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.bcm.impl.config.BcmConfig;
import com.bytedance.android.bcm.impl2.ScopedBcmConfigManager;
import com.bytedance.android.bcm.impl2.ScopedBcmContent;
import com.bytedance.android.bcm.impl2.ScopedBcmRecorder;
import com.bytedance.android.bcm.impl2.d;
import com.bytedance.android.bcm.impl2.model.BcmAllowMode;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.bytedance.android.btm.impl.util.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import pc.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ChainUtilsKt {
    public static final void a(kc.a r10) {
        BcmConfig.a();
        List<kc.a.C0174a> r0 = r10.a;
        ArrayList r1 = new ArrayList();
        Iterator<T> r11 = r0.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        kc.a.C0174a r12 = (kc.a.C0174a) r11.next();
        int r13 = b.j;
        r1.add(b.a.a(r12));
        goto L4
    L6:
        r10.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void b(kc.a r16, boolean r17, String r18) {
        BcmConfig.a();
        List<kc.a.C0174a> r10 = r16.a;
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L186;
        kc.a.C0174a r13 = (kc.a.C0174a) r12.next();
        int r14 = d.j;
        if (r17 == false) goto L8;
        BcmConfig.a();
        List r15 = BcmConfig.a.c();
    L9:
        Map<String, ScopedBcmContent> r19 = ScopedBcmRecorder.a;
        String r20 = r13.d;
        String r21 = r13.a;
        ScopedBcmContent r22 = ScopedBcmRecorder.a.get(r20);
        if (r22 != null) goto L41;
        if (r21 == null) goto L39;
        Map<f<PageInfo>, ScopedBcmContent> r23 = ScopedBcmRecorder.b;
        monitor-enter(r23);
        Iterator<T> r110 = r23.keySet().iterator();     // Catch: Throwable -> L36
    L17:
        if (r110.hasNext() == false) goto L25;
        Object r111 = r110.next();     // Catch: Throwable -> L36
        PageInfo r112 = (PageInfo) ((f) r111).get();     // Catch: Throwable -> L36
        if (r112 == null) goto L21;
        String r113 = r112.getPageId();     // Catch: Throwable -> L36
    L23:
        if (Intrinsics.areEqual(r113, r21) == false) goto L17;
    L26:
        f<PageInfo> r114 = (f) r111;     // Catch: Throwable -> L36
        if (r114 == null) goto L34;
        Map<f<PageInfo>, ScopedBcmContent> r24 = ScopedBcmRecorder.b;     // Catch: Throwable -> L36
        ScopedBcmContent r115 = r24.get(r114);     // Catch: Throwable -> L36
        if (r115 != null) goto L31;
        r115 = new ScopedBcmContent();     // Catch: Throwable -> L36
        r24.put(r114, r115);     // Catch: Throwable -> L36
    L31:
        ScopedBcmContent r25 = r115;     // Catch: Throwable -> L36
        monitor-exit(r23);
        r22 = r25;
        goto L41
    L34:
        monitor-exit(r23);
        goto L39
    L21:
        r113 = null;
        goto L23
    L25:
        r111 = null;
    L36:
        th = move-exception;
        throw th;
    L39:
        r22 = null;
    L41:
        if (r22 != null) goto L43;
    L119:
        LinkedHashMap r116 = null;
        Pair<BcmParams, BcmParams> r1 = null;
    L120:
        if (r1 == null) goto L124;
        BcmParams r26 = (BcmParams) r1.getFirst();
        if (r26 == null) goto L124;
        Map<String, Object> r27 = r26.toMap();
    L125:
        if (r1 == null) goto L129;
        BcmParams r28 = (BcmParams) r1.getSecond();
        if (r28 == null) goto L129;
        Map<String, Object> r29 = r28.toMap();
    L130:
        d r30 = new d();
        r30.c = r13.c;
        r30.e = r13.e;
        r30.f = r13.f;
        if (r13.g != null) goto L134;
        if (r1 != null) goto L134;
    L185:
        r11.add(r30);
    L134:
        LinkedHashMap r31 = new LinkedHashMap();
        kc.a.C0174a.C0175a r117 = r13.g;
        if (r117 == null) goto L150;
        BcmParams r118 = r117.a;
        if (r118 == null) goto L150;
        Map<String, Object> r119 = r118.toMap();
        if (r119 == null) goto L150;
        if (r15 == null) goto L147;
        LinkedHashMap r120 = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> r121 = r119.entrySet().iterator();
    L143:
        if (r121.hasNext() == false) goto L148;
        Map.Entry<String, Object> r122 = r121.next();
        if (r15.contains(r122.getKey()) == false) goto L143;
        r120.put(r122.getKey(), r122.getValue());
    L148:
        if (r120 == null) goto L150;
        r31.putAll(r120);
        goto L150
    L147:
        r120 = r116;
    L150:
        if (r27 == null) goto L153;
        r31.putAll(r27);
    L153:
        if ((!r31.isEmpty()) == true) goto L156;
        r31 = r116;
    L156:
        if (r31 == null) goto L158;
        JSONObject r32 = cd.a.a(r31);
    L159:
        r30.h = r32;
        LinkedHashMap r33 = new LinkedHashMap();
        kc.a.C0174a.C0175a r34 = r13.g;
        if (r34 == null) goto L175;
        BcmParams r35 = r34.b;
        if (r35 == null) goto L175;
        Map<String, Object> r36 = r35.toMap();
        if (r36 == null) goto L175;
        if (r15 == null) goto L172;
        LinkedHashMap r37 = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> r38 = r36.entrySet().iterator();
    L168:
        if (r38.hasNext() == false) goto L173;
        Map.Entry<String, Object> r123 = r38.next();
        if (r15.contains(r123.getKey()) == false) goto L168;
        r37.put(r123.getKey(), r123.getValue());
    L173:
        if (r37 == null) goto L175;
        r33.putAll(r37);
        goto L175
    L172:
        r37 = r116;
    L175:
        if (r29 == null) goto L178;
        r33.putAll(r29);
    L178:
        if ((!r33.isEmpty()) == true) goto L181;
        r33 = r116;
    L181:
        if (r33 == null) goto L183;
        JSONObject r39 = cd.a.a(r33);
    L184:
        r30.i = r39;
        goto L185
    L183:
        r39 = r116;
        goto L184
    L158:
        r32 = r116;
    L129:
        r29 = r116;
    L124:
        r27 = r116;
        goto L125
    L43:
        if (r22.isEmpty() == true) goto L119;
        if (r18 != 0) goto L47;
    L50:
        boolean r124 = true;
    L51:
        if (r124 == true) goto L119;
        Set r125 = (Set) ((ConcurrentHashMap) ScopedBcmConfigManager.b.getValue()).get(r18);
        if (r125 == null) goto L119;
        if (r125.isEmpty() == true) goto L119;
        ArrayList r126 = new ArrayList();
        Iterator r127 = r125.iterator();
    L60:
        if (r127.hasNext() == false) goto L114;
        Object r128 = r127.next();
        g r129 = (g) r128;
        if (r129.b.d() != 1) goto L87;
        if ((!r129.b.b().isEmpty()) == false) goto L108;
        List<String> r130 = r129.b.b();
        if ((r130 instanceof Collection) == true) goto L68;
    L70:
        Iterator<T> r131 = r130.iterator();
    L72:
        if (r131.hasNext() == false) goto L82;
        String r132 = (String) r131.next();
        if (r20 != null) goto L76;
    L78:
        boolean r40 = false;
    L79:
        if (r40 == false) goto L72;
        boolean r41 = true;
    L83:
        if (r41 == false) goto L108;
    L110:
        boolean r42 = false;
    L111:
        if (r42 == false) goto L60;
        r126.add(r128);
        goto L60
    L76:
        if (StringsKt.startsWith$default(r20, r132, false, 2, null) != true) goto L78;
        r40 = true;
    L82:
        r41 = false;
        goto L83
    L68:
        if (r130.isEmpty() == false) goto L70;
    L108:
        r42 = true;
        goto L111
    L87:
        if (r129.b.a().isEmpty() == true) goto L110;
        List<String> r43 = r129.b.a();
        if ((r43 instanceof Collection) == true) goto L91;
    L93:
        Iterator<T> r44 = r43.iterator();
    L95:
        if (r44.hasNext() == false) goto L105;
        String r133 = (String) r44.next();
        if (r20 != null) goto L99;
    L102:
        boolean r134 = true;
    L103:
        if (r134 == true) goto L95;
        boolean r45 = false;
    L106:
        if (r45 == false) goto L108;
    L99:
        if (StringsKt.startsWith$default(r20, r133, false, 2, null) != true) goto L102;
        r134 = false;
    L105:
        r45 = true;
        goto L106
    L91:
        if (r43.isEmpty() == false) goto L93;
    L114:
        r116 = null;
        ArrayList r46 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r126, 10));
        Iterator r47 = r126.iterator();
    L116:
        if (r47.hasNext() == false) goto L118;
        r46.add(((g) r47.next()).a);
        goto L116
    L118:
        r1 = r22.snapshot(r46, BcmAllowMode.EVENT);
        goto L120
    L47:
        if (r18.length() == 0) goto L50;
        r124 = false;
        goto L51
    L8:
        r15 = null;
        goto L9
    L186:
        r16.a = r11;
    }

    public static final boolean c(String r1, boolean r10, List<String> r11, List<String> r12) {
        ChainUtilsKt$shouldAddBcmChain$1 r0 = ChainUtilsKt$shouldAddBcmChain$1.INSTANCE;
        if (r10 == false) goto L9;
        if (r0.invoke(r12, r1) == true) goto L7;
        return true;
    L7:
        return false;
    L9:
        return r0.invoke(r11, r1);
    }
}
