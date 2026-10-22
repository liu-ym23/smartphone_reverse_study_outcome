package com.bytedance.android.ec.core.imagex;

import android.net.Uri;
import android.os.Looper;
import com.bytedance.android.ec.core.imagex.common.ImageUrlParser;
import com.bytedance.android.ec.core.imagex.tmplConv.TmplConvConfig;
import com.bytedance.android.ec.model.ECImageLoadConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n0 {
    public static void c(r0 r10, String r11, ResizeOptions r12, u r13, Function1 r14) {
        Intrinsics.checkNotNullParameter(r10, "$this$handleUrls");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r13, "callerContext");
        Intrinsics.checkNotNullParameter(r14, "afterTransformed");
        b(r10, CollectionsKt.listOf(r11), r12, r13, null, false, r14);
    }

    public static /* synthetic */ void d(r0 r10, List r11, ResizeOptions r12, u r13, Function1 r14) {
        b(r10, r11, r12, r13, null, false, r14);
    }

    public static List a(r0 r21, List r22, ResizeOptions r23, r r24, ECImageLoadConfig r25, boolean r26, int r27) {
        List r0 = r22;
        final r r1 = r24;
        if ((r27 & 2) == 0) goto L5;
        ResizeOptions r10 = null;
    L7:
        if ((r27 & 8) == 0) goto L9;
        final ECImageLoadConfig r11 = null;
    L11:
        if ((r27 & 16) == 0) goto L13;
        boolean r12 = false;
    L15:
        if ((r27 & 32) == 0) goto L17;
        boolean r13 = true;
    L18:
        Intrinsics.checkNotNullParameter(r21, "$this$getHandleUrls");
        Intrinsics.checkNotNullParameter(r0, "originList");
        Intrinsics.checkNotNullParameter(r1, "callerContext");
        long r14 = System.nanoTime();
        ECImageXCompact.c.getClass();
        m0.c("ECImageXCompact.checkNeedDowngrade");
        if (m0.b() == false) goto L24;
        UrlModifyConfDowngrade r15 = UrlModifyConfDowngrade.n;
        if (UrlModifyConfDowngrade.d == true) goto L25;
        r15.g();
        goto L24
    L25:
        r15.getClass();
        boolean r16 = UrlModifyConfDowngrade.e;
    L26:
        if (r16 == true) goto L159;
        List r17 = CollectionsKt.toList(r0);
        String r18 = (String) CollectionsKt.firstOrNull(r17);
        if (r18 == null) goto L159;
        long r19 = System.nanoTime();
        if (r13 == false) goto L38;
        StringBuilder r20 = new StringBuilder();
        r20.append(r18);
        r20.append(",");
        r20.append(r24.getCacheKey());
        r20.append(",");
        r20.append(r11);
        r20.append(",");
        if (r10 == null) goto L37;
        TmplConvConfig.k.getClass();
        if (((Boolean) TmplConvConfig.i.getValue()).booleanValue() == false) goto L37;
        r20.append(r10);
        r20.append(",");
    L37:
        String r28 = r20.toString();
    L39:
        Lazy r29 = EditUrlCache.a;
        if (r28 != null) goto L42;
    L41:
        Pair r30 = null;
    L46:
        r1.f("ec_local_duration_url_find_cache", Float.valueOf(com.bytedance.android.ec.core.imagex.common.e.a(r19)));
        u r31 = s.a(r24);
        if (r31 == null) goto L49;
        r31.D = r18;
    L49:
        u r32 = s.a(r24);
        if (r32 == null) goto L52;
        r32.C = r28;
    L52:
        if (r30 == null) goto L60;
        r0 = (List) r30.component1();
        com.bytedance.android.shopping.api.image.r r33 = (com.bytedance.android.shopping.api.image.r) r30.component2();
        if ((r1 instanceof u) == true) goto L56;
        r r34 = null;
    L57:
        u r35 = (u) r34;
        if (r35 == null) goto L159;
        r35.z = r33;
        Unit r36 = Unit.INSTANCE;
        goto L159
    L56:
        r34 = r1;
        goto L57
    L60:
        if (r12 == false) goto L62;
        r0 = CollectionsKt.emptyList();
        goto L159
    L62:
        TmplConvConfig r37 = TmplConvConfig.k;
        r37.getClass();
        com.bytedance.android.shopping.api.image.h r38 = (com.bytedance.android.shopping.api.image.h) TmplConvConfig.e.getValue(r37, TmplConvConfig.a[3]);
        if (r38 != null) goto L65;
    L68:
        boolean r39 = true;
    L69:
        if (r39 == true) goto L71;
    L74:
        String r40 = r18;
    L75:
        final ImageUrlParser r41 = new ImageUrlParser(r40, r18, r1);
        boolean r42 = r1 instanceof u;
        if (r42 == true) goto L78;
        r r43 = null;
    L79:
        u r44 = (u) r43;
        if (r44 == null) goto L82;
        r44.z = r41;
        Unit r45 = Unit.INSTANCE;
    L82:
        if (r39 == false) goto L90;
        h[] r46 = r21.a();
        int r47 = r46.length;
        int r110 = 0;
    L84:
        if (r110 >= r47) goto L90;
        h r111 = r46[r110];
        r111.getClass();
        Intrinsics.checkNotNullParameter(r1, "callerContext");
        Intrinsics.checkNotNullParameter(r41, "imageUrlParser");
        long r112 = System.nanoTime();
        r111.a(r1, r41);
        Unit r48 = Unit.INSTANCE;
        String r49 = r111.b();
        if (r49 == null) goto L89;
        r1.h(r49, Float.valueOf((System.nanoTime() - r112) / 1000000.0f));
    L89:
        r110 = r110 + 1;
        r14 = r14;
    L90:
        long r210 = r14;
        long r113 = System.nanoTime();
        final Ref.BooleanRef r50 = new Ref.BooleanRef();
        r50.element = false;
        String r51 = r41.k();
        if ((!StringsKt.isBlank(r51)) == true) goto L93;
    L96:
        r1.f("ec_local_duration_url_build", Float.valueOf(com.bytedance.android.ec.core.imagex.common.e.a(r113)));
        long r114 = System.nanoTime();
        ImageExperiments r52 = ImageExperiments.G;
        r52.getClass();
        if (((Boolean) ImageExperiments.A.getValue()).booleanValue() == false) goto L103;
        e r53 = (e) ImageExperiments.C.getValue(r52, ImageExperiments.a[0]);
        if (r53 == null) goto L103;
        if (com.bytedance.android.ec.core.imagex.common.l.b(r53, r1, com.bytedance.android.ec.core.imagex.opt.s.c(r24)) != true) goto L103;
        final boolean r54 = true;
    L104:
        Intrinsics.checkNotNullParameter(r1, "callerContext");
        if (Intrinsics.areEqual(r1.f, "ec_detail") == true) goto L107;
    L111:
        boolean r55 = false;
    L113:
        if (Intrinsics.areEqual(r1.f, "slice_pdp") == false) goto L117;
        String r211 = r28;
        boolean r115 = r13;
        r r56 = null;
        if (StringsKt.contains$default(r1.g, "detail_image", false, 2, null) == false) goto L118;
        boolean r57 = true;
    L120:
        if (((Boolean) ImageExperiments.D.getValue()).booleanValue() == false) goto L124;
        if (r55 == true) goto L123;
        if (r57 == false) goto L124;
    L123:
        final boolean r58 = true;
    L125:
        final Function1<com.bytedance.android.shopping.api.image.v, Unit> r59 = new ImageURLMiddlewareKt$getEditUrls$2(r50, r11, r54, r58);
        if (r41.isHierarchical() == false) goto L142;
        String r60 = (String) CollectionsKt.firstOrNull(r17);
        if (r60 == null) goto L142;
        Function1<com.bytedance.android.shopping.api.image.v, Unit> r61 = new ImageURLMiddlewareKt$appendFirstUrlQueryParams$$inlined$let$lambda$1(r41, r1, r59);
        Intrinsics.checkNotNullParameter(r60, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r61, "appendQuery");
        r61.invoke(r41.s);
        Object r62 = r60;
        if ((!r41.q.isEmpty()) == false) goto L143;
        String r63 = UriProtector.parse(r60).buildUpon().clearQuery().build().toString();
        StringBuilder r64 = new StringBuilder(r41.r);
        Iterator r65 = ((LinkedHashMap) r41.q).entrySet().iterator();
    L133:
        if (r65.hasNext() == false) goto L141;
        Map.Entry r66 = (Map.Entry) r65.next();
        String r67 = (String) r66.getKey();
        String r68 = (String) r66.getValue();
        if (r64.length() <= 0) goto L137;
        boolean r116 = true;
    L138:
        if (r116 == false) goto L140;
        r64.append("&");
    L140:
        r64.append(Uri.encode(r67));
        r64.append("=");
        r64.append(Uri.encode(r68));
        goto L133
    L137:
        r116 = false;
        goto L138
    L141:
        r62 = r63 + '?' + r64;
    L143:
        if (r62 == null) goto L146;
        r17 = CollectionsKt.toMutableList(r17);
        ListProtector.set(r17, 0, r62);
    L146:
        r1.f("ec_local_duration_url_query_build", Float.valueOf(com.bytedance.android.ec.core.imagex.common.e.a(r114)));
        if (r50.element == false) goto L154;
        if (r42 == true) goto L150;
        r r69 = r56;
    L151:
        u r70 = (u) r69;
        if (r70 == null) goto L154;
        r70.E = r51;
        goto L154
    L150:
        r69 = r1;
    L154:
        if (r115 == false) goto L160;
        if ((!r17.isEmpty()) == false) goto L160;
        Lazy r71 = EditUrlCache.a;
        EditUrlCache.b(r211, r17, com.bytedance.android.ec.core.imagex.opt.s.d(r24));
    L160:
        r1.f("ec_local_duration_url_edit", Float.valueOf(com.bytedance.android.ec.core.imagex.common.e.a(r210)));
        if ((r1 instanceof u) == true) goto L163;
        r1 = r56;
    L163:
        u r72 = (u) r1;
        if (r72 != null) goto L166;
    L170:
        return r17;
    L166:
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L168;
        boolean r73 = true;
    L169:
        r72.p = Boolean.valueOf(r73);
        goto L170
    L168:
        r73 = false;
    L142:
        r62 = r56;
    L124:
        r58 = false;
    L118:
        r57 = false;
        goto L120
    L117:
        r211 = r28;
        r115 = r13;
        r56 = null;
        goto L118
    L107:
        if (Intrinsics.areEqual(r1.g, "ec_product_detail_image") == false) goto L109;
    L110:
        r55 = true;
        goto L113
    L109:
        if (Intrinsics.areEqual(r1.g, "ec_product_header_image") == false) goto L111;
    L103:
        r54 = false;
        goto L104
    L93:
        if ((!Intrinsics.areEqual(r51, r18)) == false) goto L95;
        r50.element = true;
    L95:
        r17 = CollectionsKt.plus(CollectionsKt.listOf(r51), r17);
        goto L96
    L78:
        r43 = r1;
        goto L79
    L71:
        if (((Boolean) TmplConvConfig.i.getValue()).booleanValue() == true) goto L74;
        r40 = (String) CollectionsKt.firstOrNull(com.bytedance.android.ec.core.imagex.transform.b.f(r18, r10, r1));
        if (r40 != null) goto L75;
    L65:
        if (com.bytedance.android.ec.core.imagex.common.l.b(r38, r1, null) == true) goto L68;
        r39 = false;
        goto L69
    L42:
        ImageExperiments.G.getClass();
        if (((Boolean) ImageExperiments.e.getValue()).booleanValue() == false) goto L41;
        r30 = (Pair) EditUrlCache.a().get(r28);
        goto L46
    L38:
        r28 = null;
    L159:
        r56 = null;
        r210 = r14;
        r17 = r0;
    L24:
        r16 = false;
        goto L26
    L17:
        r13 = false;
        goto L18
    L13:
        r12 = r26;
        goto L15
    L9:
        r11 = r25;
        goto L11
    L5:
        r10 = r23;
        goto L7
    }

    public static final void b(r0 r10, List r11, ResizeOptions r12, u r13, ECImageLoadConfig r14, boolean r15, Function1 r16) {
        Intrinsics.checkNotNullParameter(r10, "$this$handleUrls");
        Intrinsics.checkNotNullParameter(r11, "originList");
        Intrinsics.checkNotNullParameter(r13, "callerContext");
        Intrinsics.checkNotNullParameter(r16, "afterTransformed");
        r16.invoke(a(r10, r11, r12, r13, r14, r15, 32));
    }
}
