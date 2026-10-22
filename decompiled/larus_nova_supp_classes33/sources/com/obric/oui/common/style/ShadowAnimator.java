package com.obric.oui.common.style;

import android.view.View;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ShadowAnimator {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final fja.d a(final View r9, final float r10, final float r11, final List<q> r12, final List<q> r13) {
        Intrinsics.checkNotNullParameter(r9, "view");
        com.obric.common.oea.foundation.animation.builder.b.a r6 = com.obric.common.oea.foundation.animation.builder.c.a(r9);
        AnimationProperty$FloatProperty r0 = AnimationProperty$FloatProperty.SCALE_X;
        Float r1 = Float.valueOf(r9.getScaleX());
        Token$Bounce r3 = Token$Bounce.OUI_ANIMATION_BOUNCE_SNAPPY_4;
        Token$Duration r4 = Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_3;
        com.obric.common.oea.foundation.animation.spec.spring.b r5 = gja.b.c(r3, r4);
        r5.b = 0.01f;
        Unit r8 = Unit.INSTANCE;
        com.obric.common.oea.foundation.animation.builder.b.a.c(r6, r0, r1, r11, r5);
        AnimationProperty$FloatProperty r2 = AnimationProperty$FloatProperty.SCALE_Y;
        Float r7 = Float.valueOf(r9.getScaleY());
        com.obric.common.oea.foundation.animation.spec.spring.b r14 = gja.b.c(r3, r4);
        r14.b = 0.01f;
        com.obric.common.oea.foundation.animation.builder.b.a.c(r6, r2, r7, r11, r14);
        Function3<String, Object, Object, Unit> r15 = new ShadowAnimator$startWithScaleAnimation$3(r10, r11, r12, r13, r9);
        Intrinsics.checkNotNullParameter(r15, "callback");
        r6.d = r15;
        Function2<Boolean, Throwable, Unit> r16 = new ShadowAnimator$startWithScaleAnimation$4(r9, r13);
        Intrinsics.checkNotNullParameter(r16, "callback");
        r6.e = r16;
        return com.obric.common.oea.foundation.animation.builder.b.a(r6.a());
    }
}
