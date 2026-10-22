package com.obric.oui.common.style;

import android.view.View;
import com.obric.common.oea.foundation.animation.token.AnimationProperty;
import com.obric.common.oea.foundation.animation.token.Token;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0007J,\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007J,\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007J@\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0007¨\u0006\u0019"}, d2 = {"Lcom/obric/oui/common/style/ShadowAnimator;", "", "()V", "getInterpolatedShadow", "", "Lcom/obric/oui/common/style/Shadow;", "rawFraction", "", "shadow0", "shadow1", "startAnim", "", "ouiLayout", "Lcom/obric/oui/common/style/OUILayoutHelper;", "oldShadow", "newShadow", "startVisibilityAnim", "startWithScaleAnimation", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "view", "Landroid/view/View;", "startScale", "targetScale", "shadowsFrom", "shadowsTo", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f13497a = null;

    static {
        f13497a = new l();
    }

    private l() {
    }

    @JvmStatic
    public static final com.obric.common.oea.foundation.animation.d.d a(final View r26, final float r27, final float r28, List<k> r29, List<k> r30) {
        final List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r29, List.class, "com.obric.memorydata.plugin");
        final List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r30, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r26, "view");
        com.obric.common.oea.foundation.animation.builder.a.C0372a r10 = com.obric.common.oea.foundation.animation.builder.b.a(r26, 0.0f, 1, null);
        AnimationProperty.FloatProperty r11 = AnimationProperty.FloatProperty.SCALE_X;
        Float r12 = Float.valueOf(r26.getScaleX());
        com.obric.common.oea.foundation.animation.spec.spring.b r0 = com.obric.common.oea.foundation.animation.spec.b.a(Token.Bounce.OUI_ANIMATION_BOUNCE_SNAPPY_4, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_3, 0, 4, null);
        r0.a(0.01f);
        Unit r5 = Unit.INSTANCE;
        com.obric.common.oea.foundation.animation.builder.a.C0372a r18 = com.obric.common.oea.foundation.animation.builder.a.C0372a.a(r10, r11, r12, r28, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.preCheckCast(r0, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), null, 16, null);
        AnimationProperty.FloatProperty r19 = AnimationProperty.FloatProperty.SCALE_Y;
        Float r20 = Float.valueOf(r26.getScaleY());
        com.obric.common.oea.foundation.animation.spec.spring.b r1 = com.obric.common.oea.foundation.animation.spec.b.a(Token.Bounce.OUI_ANIMATION_BOUNCE_SNAPPY_4, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_3, 0, 4, null);
        r1.a(0.01f);
        Unit r2 = Unit.INSTANCE;
        return com.obric.common.oea.foundation.animation.builder.a.a(com.obric.common.oea.foundation.animation.builder.a.C0372a.a(r18, r19, r20, r28, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.preCheckCast(r1, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), null, 16, null).a((Function3) ZeusTransformUtils.preCheckCast(new ShadowAnimator$startWithScaleAnimation$3(r27, r28, r3, r8, r26), Function3.class, "com.obric.memorydata.plugin")).a((Function2) ZeusTransformUtils.preCheckCast(new ShadowAnimator$startWithScaleAnimation$4(r26, r8), Function2.class, "com.obric.memorydata.plugin")).b(), null, null, 3, null);
    }

    @JvmStatic
    public static final void a(final f r9, List<k> r10, List<k> r11) {
        final List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        final List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "ouiLayout");
        Intrinsics.checkNotNullParameter(r12, "oldShadow");
        Intrinsics.checkNotNullParameter(r13, "newShadow");
        com.obric.common.oea.foundation.animation.builder.c.a.a(new com.obric.common.oea.foundation.animation.builder.c.a(), 0.0f, 1.0f, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.spec.b.a(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_4, 0, 4, null), com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), null, 8, null).a((Function3) ZeusTransformUtils.preCheckCast(new ShadowAnimator$startAnim$1(r12, r13, r9), Function3.class, "com.obric.memorydata.plugin")).a((Function2) ZeusTransformUtils.preCheckCast(new ShadowAnimator$startAnim$2(r9, r13), Function2.class, "com.obric.memorydata.plugin")).a().a();
    }

    @JvmStatic
    public static final void b(final f r9, List<k> r10, List<k> r11) {
        final List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        final List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "ouiLayout");
        Intrinsics.checkNotNullParameter(r12, "oldShadow");
        Intrinsics.checkNotNullParameter(r13, "newShadow");
        com.obric.common.oea.foundation.animation.builder.c.a.a(new com.obric.common.oea.foundation.animation.builder.c.a(), 0.0f, 1.0f, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.spec.b.a(Token.Duration.OUI_ANIMATION_DURATION_SHORT_2, Token.Delay.OUI_ANIMATION_DELAY_NONE, Token.Easing.OUI_ANIMATION_EASING_EASE_OUT_QUAD), com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), null, 8, null).a((Function3) ZeusTransformUtils.preCheckCast(new ShadowAnimator$startVisibilityAnim$1(r12, r13, r9), Function3.class, "com.obric.memorydata.plugin")).a((Function2) ZeusTransformUtils.preCheckCast(new ShadowAnimator$startVisibilityAnim$2(r9, r13), Function2.class, "com.obric.memorydata.plugin")).a().a();
    }
}
