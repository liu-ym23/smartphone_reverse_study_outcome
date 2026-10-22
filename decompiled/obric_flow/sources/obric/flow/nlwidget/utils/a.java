package obric.flow.nlwidget.utils;

import com.obric.common.oea.foundation.animation.spec.spring.b;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.flow.cardlistpage.R$id;
import com.obric.flow.cardlistpage.ui.view.WidgetBox;
import jp.d;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import lp.c;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f20526a = 0;

    static {
        f20526a = R$id.animation_tag_key;
    }

    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Object, kotlin.jvm.internal.Lambda, obric.flow.nlwidget.utils.AnimatorHelper$viewScaleAnimator$anim$2] */
    public static void a(final WidgetBox r10, float r11) {
        int r5 = f20526a;
        Object r12 = r10.getTag(r5);
        if ((r12 instanceof d) == false) goto L5;
        d r13 = (d) r12;
    L7:
        if (r13 == null) goto L9;
        int r14 = d.d;
        r13.a(false);
    L9:
        Intrinsics.checkNotNullParameter(r10, "$this$animator");
        com.obric.common.oea.foundation.animation.builder.a r15 = new com.obric.common.oea.foundation.animation.builder.a(r10);
        if (1.0f <= 0) goto L13;
        r15.f11311a = 1.0f;
        r15.f11312b = 90.0f;
        Token$Bounce r16 = Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH;
        Token$Duration r17 = Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_2;
        Intrinsics.checkNotNullParameter(r16, "bounce");
        Intrinsics.checkNotNullParameter(r17, "duration");
        b r18 = new b(r16.getDampingRatio(), r17.getStiffness(), 0);
        r18.f11323b = 0.001f;
        Unit r19 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r18, "spec");
        r15.c(AnimationProperty$FloatProperty.SCALE_X, null, r11, r18, null);
        r15.c(AnimationProperty$FloatProperty.SCALE_Y, null, r11, r18, null);
        ?? r110 = new AnimatorHelper$viewScaleAnimator$anim$2(r10);
        Intrinsics.checkNotNullParameter(r110, "callback");
        r15.e = r110;
        r10.setTag(r5, com.obric.common.oea.foundation.animation.builder.b.a(r15.b()));
        return;
    L13:
        int r111 = c.f19690a;
        Intrinsics.checkNotNullParameter("animationSpeed必须大于 0", "message");
        throw new IllegalArgumentException("animationSpeed必须大于 0");
    L5:
        r13 = null;
        goto L7
    }
}
