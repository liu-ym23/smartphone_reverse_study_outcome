package com.ss.android.lark.coremdbiz.facade.plugins.markdown;

import com.bytedance.lark.pb.basic.v1.ImageBaseAttribute;
import com.bytedance.lark.pb.basic.v1.ImageCropType;
import com.bytedance.lark.pb.basic.v1.ImageSetV2;
import com.ss.android.lark.movable.attatchment.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements Function2<String, Float, m> {
    public static final d a = null;
    public static final List<Map<String, ImageSetV2>> b = null;

    public d() {
    }

    static {
        a = new d();
        b = new ArrayList();
    }

    public final m a(String r8, float r9) {
        Intrinsics.checkNotNullParameter(r8, "imageKey");
        Iterator<T> r0 = b.iterator();
    L4:
        if (r0.hasNext() == false) goto L51;
        Map r1 = (Map) r0.next();
        if (r1.containsKey(r8) == false) goto L4;
        ImageSetV2 r2 = (ImageSetV2) r1.get(r8);
        ImageBaseAttribute r3 = null;
        if (r2 == null) goto L10;
        List r4 = r2.images;
    L11:
        if (r4 == null) goto L26;
        Iterator r5 = r4.iterator();
    L14:
        if (r5.hasNext() == false) goto L21;
        Object r6 = r5.next();
        if (((ImageSetV2.ImageAttribute) r6).type != ImageCropType.ORIGIN) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == false) goto L14;
    L22:
        ImageSetV2.ImageAttribute r10 = (ImageSetV2.ImageAttribute) r6;
        if (r10 == null) goto L26;
        ImageBaseAttribute r11 = r10.attribute;
        if (r11 == null) goto L26;
    L33:
        Integer r12 = r11.width;
        if (r12 == null) goto L4;
        int r13 = r12.intValue();
        Integer r14 = r11.height;
        if (r14 == null) goto L4;
        int r15 = r14.intValue();
        if (r13 <= 0) goto L4;
        if (r15 <= 0) goto L4;
        if (r9 <= 0.0f) goto L49;
        float r16 = r13;
        if (r16 <= r9) goto L49;
        return new m(r9, r15 * (r9 / r16));
    L49:
        return new m(r13, r15);
    L18:
        r7 = false;
        goto L19
    L21:
        r6 = null;
    L26:
        if (r4 == null) goto L30;
        ImageSetV2.ImageAttribute r17 = (ImageSetV2.ImageAttribute) CollectionsKt.firstOrNull(r4);
        if (r17 == null) goto L30;
        r3 = r17.attribute;
    L30:
        if (r3 == null) goto L4;
        r11 = r3;
        goto L33
    L10:
        r4 = null;
        goto L11
    L51:
        return new m(70.0f, 40.0f);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return a((String) r1, ((Number) r2).floatValue());
    }
}
