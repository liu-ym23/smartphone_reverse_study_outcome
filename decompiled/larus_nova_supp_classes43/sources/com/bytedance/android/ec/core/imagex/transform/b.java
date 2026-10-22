package com.bytedance.android.ec.core.imagex.transform;

import android.net.Uri;
import android.util.LruCache;
import com.bytedance.android.ec.core.imagex.ImageExperiments;
import com.bytedance.android.ec.core.imagex.ImageSettings;
import com.bytedance.android.ec.core.imagex.common.e;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.imagex.u;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.imagepipeline.common.ResizeOptions;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final LruCache<String, List<String>> a = null;
    public static final List<String> b = null;
    public static final a c = null;

    public static final class a extends LruCache<String, List<? extends String>> {
        public a(int r1) {
            super(r1);
        }

        @Override // android.util.LruCache
        public final int sizeOf(String r1, List<? extends String> r10) {
            List<? extends String> r11 = r10;
            if (r11 == null) goto L5;
            int r12 = r11.size();
        L7:
            return RangesKt.coerceAtLeast(r12, 1);
        L5:
            r12 = 1;
            goto L7
        }
    }

    static {
        a = new LruCache(512);
        b = CollectionsKt.emptyList();
        c = new a(((Number) ImageSettings.d.getValue()).intValue());
    }

    public static boolean d(String r10) {
        Intrinsics.checkNotNullParameter(r10, "origin");
        if (StringsKt.isBlank(r10) == false) goto L5;
        return false;
    L5:
        if (StringsKt.startsWith(r10, "http://", true) == true) goto L9;
        if (StringsKt.startsWith(r10, "https://", true) == true) goto L9;
        return false;
    L9:
        if (StringsKt.contains$default(r10, "-sign", false, 2, null) == false) goto L11;
        return false;
    L11:
        if (StringsKt.contains$default(r10, "-private", false, 2, null) == false) goto L13;
        return false;
    L13:
        if (StringsKt.contains$default(r10, "disable_ecom_template=1", false, 2, null) == true) goto L20;
        return true;
    L20:
        return false;
    }

    public static String a(String r10, r r11) {
        if (((Boolean) ImageSettings.g.getValue()).booleanValue() == false) goto L36;
        if (r11 != null) goto L6;
        return r10;
    L6:
        if (StringsKt.startsWith(r10, "http", true) == true) goto L8;
        return r10;
    L8:
        if (StringsKt.startsWith(r10, "https", true) == false) goto L40;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L20
        int r1 = p0.a;     // Catch: Throwable -> L20
        Uri r12 = UriProtector.parse(r10);     // Catch: Throwable -> L20
        Pair[] r13 = new Pair[2];     // Catch: Throwable -> L20
        String r14 = a2.d(r11.f);     // Catch: Throwable -> L20
        String r15 = "unknown";
        if (r14 != null) goto L14;
        r14 = "unknown";
    L14:
        r13[0] = TuplesKt.to("ec_biz_tag", r14);     // Catch: Throwable -> L20
        String r16 = a2.d(r11.g);     // Catch: Throwable -> L20
        if (r16 == null) goto L18;
        r15 = r16;
    L18:
        r13[1] = TuplesKt.to("ec_scene_tag", r15);     // Catch: Throwable -> L20
        Object r17 = Result.constructor-impl(p0.f(r12, MapsKt.mutableMapOf(r13)).toString());     // Catch: Throwable -> L20
    L22:
        String r18 = null;
        if (Result.isFailure-impl(r17) == false) goto L25;
        r17 = null;
    L25:
        String r19 = (String) r17;
        if (r19 != null) goto L28;
        return r10;
    L28:
        if ((!StringsKt.isBlank(r19)) == false) goto L30;
        r18 = r19;
    L30:
        if (r18 != null) goto L33;
        return r10;
    L33:
        return r18;
    L20:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L40:
        return r10;
    L36:
        return r10;
    }

    public static List b(List r10, r r11) {
        if (((Boolean) ImageSettings.g.getValue()).booleanValue() == true) goto L5;
        return r10;
    L5:
        if (r10.isEmpty() == true) goto L11;
        if (r11 == null) goto L12;
        String r1 = (String) ListProtector.get(r10, 0);
        List r12 = CollectionsKt.toMutableList(r10);
        ListProtector.set(r12, 0, a(r1, r11));
        return r12;
    L12:
        return r10;
    L11:
        return r10;
    }

    public static String e(String r10, com.bytedance.android.ec.core.imagex.transform.a r11, String r12) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r10);
        if (r11 == null) goto L5;
        String r13 = "_" + r11.a + 'x' + r11.b;
    L15:
        r0.append(r13);
        return r0.toString();
    L5:
        String r1 = "";
        StringBuilder r14 = new StringBuilder("");
        if (r12 != null) goto L8;
    L11:
        boolean r15 = true;
    L12:
        if (r15 == true) goto L14;
        r1 = "_" + r12;
    L14:
        r14.append(r1);
        r13 = r14.toString();
        goto L15
    L8:
        if (StringsKt.isBlank(r12) == true) goto L11;
        r15 = false;
        goto L12
    }

    public static List f(String r11, ResizeOptions r12, r r13) {
        Intrinsics.checkNotNullParameter(r11, "origin");
        ImageExperiments.G.getClass();
        if (((Boolean) ImageExperiments.b.getValue()).booleanValue() == false) goto L5;
        long r10 = System.nanoTime();
        com.bytedance.android.ec.core.imagex.transform.a.c.getClass();
        String r0 = null;
        if (r12 != null) goto L9;
        com.bytedance.android.ec.core.imagex.transform.a r14 = null;
    L25:
        if (((Boolean) ImageSettings.c.getValue()).booleanValue() == true) goto L27;
    L48:
        List r15 = null;
    L49:
        List r16 = r15;
        if (r16 != null) goto L52;
    L55:
        boolean r17 = true;
    L57:
        if (r17 == false) goto L59;
        boolean r18 = r13 instanceof u;
        if (r18 == false) goto L66;
        r13.f("transform_stage", "sync");
    L66:
        List r19 = CollectionsKt.mutableListOf(new String[]{r11});
        if (d(r11) == false) goto L106;
        ImageUrlTransformRulesConfig r20 = ImageUrlTransformRulesConfigCenter.a(r13);
        if (r20 == null) goto L104;
        String r21 = r20.getRulesVersion();
        if (r21 == null) goto L76;
        if (r13 == null) goto L76;
        r13.f("rules_version", r21);
    L76:
        String r22 = r20.transform(r11, r14);
        if (r22 != null) goto L79;
    L82:
        boolean r23 = true;
    L83:
        if (r23 == false) goto L85;
        c(r11, r14, r20.getName(), b);
    L95:
        if (r22 != null) goto L97;
    L100:
        boolean r110 = true;
    L102:
        if ((!r110) == false) goto L104;
        r0 = r22;
        goto L104
    L97:
        if (StringsKt.isBlank(r22) == true) goto L100;
        r110 = false;
        goto L102
    L85:
        if (((Boolean) ImageSettings.f.getValue()).booleanValue() == false) goto L92;
        if (r18 == true) goto L88;
        r r111 = null;
    L89:
        u r112 = (u) r111;
        if (r112 == null) goto L93;
        r112.m = true;
    L93:
        String r113 = r20.getName();
        Intrinsics.checkNotNull(r22);
        c(r11, r14, r113, CollectionsKt.listOf(r22));
        goto L95
    L88:
        r111 = r13;
        goto L89
    L92:
        int r114 = p0.a;
        r22 = p0.f(UriProtector.parse(r22), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("iesec_transformed", "1")})).toString();
        goto L93
    L79:
        if (StringsKt.isBlank(r22) == true) goto L82;
        r23 = false;
    L104:
        if (r0 == null) goto L106;
        ListProtector.add(r19, 0, r0);
    L106:
        List r115 = b(r19, r13);
        if (r13 == null) goto L109;
        r13.f("ec_local_duration_url_transform", Float.valueOf(e.a(r10)));
    L109:
        return r115;
    L59:
        if ((r13 instanceof u) == false) goto L61;
        r13.f("transform_stage", "cache");
    L61:
        Intrinsics.checkNotNull(r15);
        return b(r15, r13);
    L52:
        if (r16.isEmpty() == true) goto L55;
        r17 = false;
        goto L57
    L27:
        if (StringsKt.isBlank(r11) == true) goto L48;
        ImageUrlTransformRulesConfig r116 = ImageUrlTransformRulesConfigCenter.a(r13);
        if (r116 == null) goto L32;
        String r117 = r116.getName();
    L33:
        List<? extends String> r118 = c.get(e(r11, r14, r117));
        if (r118 == null) goto L48;
        if (Intrinsics.areEqual(r118, b) == false) goto L39;
        r15 = CollectionsKt.mutableListOf(new String[]{r11});
        goto L49
    L39:
        r15 = CollectionsKt.toMutableList(r118);
        ListProtector.add(r15, r15.size(), r11);
        if (((Boolean) ImageSettings.f.getValue()).booleanValue() == false) goto L49;
        if ((r13 instanceof u) == true) goto L44;
        r r24 = null;
    L45:
        u r25 = (u) r24;
        if (r25 == null) goto L49;
        r25.m = true;
        goto L49
    L44:
        r24 = r13;
        goto L45
    L32:
        r117 = null;
        goto L33
    L9:
        int r26 = r12.width;
        int r119 = r12.height;
        Lazy r27 = ImageSettings.i;
        int r28 = ((Number) r27.getValue()).intValue();
        if (r26 > 0) goto L13;
        r26 = 0;
    L16:
        int r29 = RangesKt.coerceAtLeast(r26, 0);
        int r30 = ((Number) r27.getValue()).intValue();
        if (r119 > 0) goto L20;
        r119 = 0;
    L23:
        r14 = new com.bytedance.android.ec.core.imagex.transform.a(r29, RangesKt.coerceAtLeast(r119, 0));
        goto L25
    L20:
        if ((r119 % r30) == 0) goto L23;
        r119 = ((r119 / r30) * r30) + r30;
        goto L23
    L13:
        if ((r26 % r28) == 0) goto L16;
        r26 = ((r26 / r28) * r28) + r28;
        goto L16
    L5:
        return CollectionsKt.mutableListOf(new String[]{a(r11, r13)});
    }

    public static void c(String r10, com.bytedance.android.ec.core.imagex.transform.a r11, String r12, List r13) {
        a.put(e(r10, null, null), r13);
        if (((Boolean) ImageSettings.c.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        c.put(e(r10, r11, r12), r13);
    }
}
