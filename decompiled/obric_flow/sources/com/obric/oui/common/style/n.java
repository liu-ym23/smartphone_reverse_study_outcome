package com.obric.oui.common.style;

import ai.j0;
import android.graphics.BlurMaskFilter;
import android.util.TypedValue;
import android.view.ViewGroup;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static TypedValue f12519a;

    public static m a(es.a r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "config");
        int r5 = r10.d;
        float r12 = com.lynx.tasm.utils.a.v(r10.f16860c, r11);
        m r13 = new m(r5, r12, com.lynx.tasm.utils.a.v(r10.f16858a, r11), com.lynx.tasm.utils.a.v(r10.f16859b, r11), com.lynx.tasm.utils.a.v(r10.e, r11));
        if (r12 <= 0.0f) goto L5;
        r13.f.setMaskFilter(new BlurMaskFilter(r13.f12517b, BlurMaskFilter.Blur.NORMAL));
    L6:
        return r13;
    L5:
        r13.f.setMaskFilter(null);
        goto L6
    }

    public static List b(float r13, List r14, List r15) {
        if (Float.isInfinite(r13) == false) goto L5;
    L7:
        r13 = 0.0f;
    L8:
        float r16 = RangesKt.coerceIn(r13, 0.0f, 1.0f);
        if (r14 == null) goto L23;
        if (r15 != null) goto L12;
        return r14;
    L12:
        if (r14.size() != r15.size()) goto L25;
        Iterator r5 = r14.iterator();
        Iterator r10 = r15.iterator();
        ArrayList r11 = new ArrayList(Math.min(CollectionsKt.h(r14), CollectionsKt.h(r15)));
    L15:
        if (r5.hasNext() == false) goto L20;
        if (r10.hasNext() == false) goto L20;
        Object r17 = r5.next();
        m r18 = (m) r10.next();
        m r19 = (m) r17;
        int r12 = r19.f12516a;
        int r20 = r18.f12516a;
        int r21 = (r12 >> 24) & 255;
        int r22 = (r12 >> 16) & 255;
        int r23 = (r12 >> 8) & 255;
        int r24 = r12 & 255;
        float r110 = r21;
        int r25 = (int) (((((r20 >> 24) & 255) - r21) * r16) + r110);
        float r26 = r22;
        int r27 = (int) (((((r20 >> 16) & 255) - r22) * r16) + r26);
        float r28 = r23;
        int r29 = (int) (((((r20 >> 8) & 255) - r23) * r16) + r28);
        int r30 = (((r25 << 24) | (r27 << 16)) | (r29 << 8)) | ((int) ((((r20 & 255) - r24) * r16) + r24));
        float r31 = r19.f12517b;
        float r32 = j0.b(r18.f12517b, r31, r16, r31);
        float r33 = r19.f12518c;
        float r34 = j0.b(r18.f12518c, r33, r16, r33);
        float r35 = r19.d;
        float r36 = j0.b(r18.d, r35, r16, r35);
        float r111 = r19.e;
        r11.add(new m(r30, r32, r34, r36, j0.b(r18.e, r111, r16, r111)));
    L20:
        return r11;
    L25:
        return r14;
    L23:
        return r14;
    L5:
        if (Float.isNaN(r13) == true) goto L7;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.obric.oui.common.style.ShadowAnimator$startWithScaleAnimation$4, java.lang.Object, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.obric.oui.common.style.ShadowAnimator$startWithScaleAnimation$3, java.lang.Object, kotlin.jvm.internal.Lambda] */
    public static final jp.d c(final ViewGroup r14, final float r15, final float r16, final List r17, final List r18) {
        Intrinsics.checkNotNullParameter(r14, "view");
        Intrinsics.checkNotNullParameter(r14, "$this$animator");
        com.obric.common.oea.foundation.animation.builder.a r13 = new com.obric.common.oea.foundation.animation.builder.a(r14);
        if (1.0f <= 0) goto L6;
        r13.f11311a = 1.0f;
        r13.f11312b = 90.0f;
        AnimationProperty$FloatProperty r10 = AnimationProperty$FloatProperty.SCALE_X;
        Float r11 = Float.valueOf(r14.getScaleX());
        Token$Bounce r5 = Token$Bounce.OUI_ANIMATION_BOUNCE_SNAPPY_4;
        Token$Duration r12 = Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_3;
        com.obric.common.oea.foundation.animation.spec.spring.b r19 = ug.a.m(r5, r12);
        r19.f11323b = 0.01f;
        Unit r20 = Unit.INSTANCE;
        r13.c(r10, r11, r16, r19, null);
        AnimationProperty$FloatProperty r21 = AnimationProperty$FloatProperty.SCALE_Y;
        Float r22 = Float.valueOf(r14.getScaleY());
        com.obric.common.oea.foundation.animation.spec.spring.b r110 = ug.a.m(r5, r12);
        r110.f11323b = 0.01f;
        r13.c(r21, r22, r16, r110, null);
        ?? r23 = new ShadowAnimator$startWithScaleAnimation$3(r15, r16, r17, r18, r14);
        Intrinsics.checkNotNullParameter(r23, "callback");
        r13.d = r23;
        ?? r24 = new ShadowAnimator$startWithScaleAnimation$4(r14, r18);
        Intrinsics.checkNotNullParameter(r24, "callback");
        r13.e = r24;
        return com.obric.common.oea.foundation.animation.builder.b.a(r13.b());
    L6:
        int r25 = lp.c.f19690a;
        Intrinsics.checkNotNullParameter("animationSpeed必须大于 0", "message");
        throw new IllegalArgumentException("animationSpeed必须大于 0");
    }
}
