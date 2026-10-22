package com.larus.dora.impl.dynamic;

import com.bytedance.dora.annotation.ProductNameType;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.util.DoraSKU;
import com.larus.image.loader.ImageLoaderKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a1 {
    public static final String a(String r6, Integer r7, DoraSKU r8) {
        int r0 = ProductNameType.DORA_LITE.id;
        if (r7 != null) goto L6;
    L8:
        int r1 = ProductNameType.DORA_E.id;
        if (r7 == null) goto L15;
        if (r7.intValue() != r1) goto L15;
        String r9 = "dora_e";
    L18:
        String r2 = r9;
        if (r2.length() <= 0) goto L21;
        boolean r10 = true;
    L22:
        if (r10 == false) goto L24;
        r6 = StringsKt.replace$default(r6, "${product}", r2, false, 4, null);
    L24:
        String r3 = r6;
        if (r8 != null) goto L27;
        return r3;
    L27:
        return StringsKt.replace$default(r3, "${sku}", r8.getSkuName(), false, 4, null);
    L21:
        r10 = false;
    L15:
        if (o59.a.o(r7) == false) goto L17;
        r9 = "dora_g";
    L17:
        r9 = "dora_lite";
        goto L18
    L6:
        if (r7.intValue() != r0) goto L8;
        goto L8
    }

    public static void b(SimpleDraweeView r9, t1 r10, Integer r11, DoraSKU r12, int r13) {
        String r1 = null;
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = null;
    L8:
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, "imageIdentifier");
        boolean r14 = v19.h.a;
        if (v19.h.a(null) == false) goto L11;
        String r15 = r10.b() + "_dark";
    L12:
        String r0 = "";
        if (r15 != null) goto L15;
        r15 = "";
    L15:
        String r16 = a(r15, r11, r12);
        AppHost.Companion r4 = AppHost.a;
        int r2 = r9.getContext().getResources().getIdentifier("larus_" + r16, "drawable", r4.getApplication().getPackageName());
        if (r2 != 0) goto L18;
        g49.d.b("DoraDynamicResExt", "loadImage: larus_" + r16 + " drawable resourceId=0");
        r2 = r9.getContext().getResources().getIdentifier(r16, "drawable", r4.getApplication().getPackageName());
        g49.d.d("DoraDynamicResExt", "loadImage: " + r16 + " drawable resourceId=" + r2);
    L20:
        if (r10.c() == false) goto L24;
        if (r2 == 0) goto L49;
        ImageLoaderKt.s(r9, UriUtil.getUriForResourceId(r2), null);
        return;
    L49:
        return;
    L24:
        if (v19.h.a(null) == false) goto L30;
        u1 r17 = r10.a();
        if (r17 == null) goto L35;
        String[] r18 = r17.a();
        if (r18 == null) goto L35;
        r1 = (String) ArraysKt.firstOrNull(r18);
    L35:
        if (r1 != null) goto L37;
        r1 = "";
    L37:
        String r110 = a(r1, r11, r12);
        int r111 = com.larus.dora.impl.util.t.a;
        if (r110 != null) goto L40;
        r110 = "";
    L40:
        String r112 = com.larus.dora.impl.util.t.a(r11, r110);
        ScalingUtils.ScaleType r113 = r9.getHierarchy().getActualImageScaleType();
        g49.d.a("DoraDynamicResExt", "loadImage: imageUrl=" + r112 + ", frescoScaleType=" + r113);
        GenericDraweeHierarchyBuilder r114 = GenericDraweeHierarchyBuilder.newInstance(r9.getResources());
        if (r2 == 0) goto L43;
        r114.setPlaceholderImage(r2);
    L43:
        r114.setPlaceholderImageScaleType(r113);
        r9.setHierarchy(r114.build());
        if (r112 == null) goto L47;
        r0 = r112;
    L47:
        ImageLoaderKt.u(r9, r0, "dora_dynamic_img_biz");
        return;
    L30:
        u1 r115 = r10.a();
        if (r115 == null) goto L35;
        String[] r116 = r115.b();
        if (r116 == null) goto L35;
        r1 = (String) ArraysKt.firstOrNull(r116);
        goto L35
    L18:
        g49.d.a("DoraDynamicResExt", "loadImage: " + r16 + " drawable resourceId=" + r2);
        goto L20
    L11:
        r15 = r10.b();
        goto L12
    }
}
