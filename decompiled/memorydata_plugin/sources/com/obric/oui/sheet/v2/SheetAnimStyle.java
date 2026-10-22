package com.obric.oui.sheet.v2;

import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.common.oea.foundation.animation.token.AnimationProperty;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001:B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nJ$\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\nJ(\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nH\u0002J(\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nH\u0002J#\u0010\"\u001a\u00020\u0006\"\b\b\u0000\u0010#*\u00020\b*\u0002H#2\b\b\u0001\u0010$\u001a\u00020%¢\u0006\u0002\u0010&J\u0014\u0010'\u001a\u00020(*\u00020\b2\u0006\u0010)\u001a\u00020%H\u0002J%\u0010*\u001a\u00020+\"\b\b\u0000\u0010#*\u00020\b*\u0002H#2\b\b\u0001\u0010$\u001a\u00020%H\u0002¢\u0006\u0002\u0010,J]\u0010-\u001a\u00020+*\u00020\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010.\u001a\u00020\u00162\b\b\u0002\u0010/\u001a\u00020\u00162\b\b\u0002\u00100\u001a\u00020\n2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\n\b\u0002\u00103\u001a\u0004\u0018\u00010%¢\u0006\u0002\u00104J[\u00105\u001a\u00020+*\u00020\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010.\u001a\u00020\u00162\b\b\u0002\u0010/\u001a\u00020\u00162\b\b\u0002\u00106\u001a\u00020\n2\b\b\u0002\u00100\u001a\u00020\n2\n\b\u0002\u00103\u001a\u0004\u0018\u00010%¢\u0006\u0002\u00107JQ\u00108\u001a\u00020+*\u00020\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010.\u001a\u00020\u00162\b\b\u0002\u0010/\u001a\u00020\u00162\b\b\u0002\u00106\u001a\u00020\n2\n\b\u0002\u00103\u001a\u0004\u0018\u00010%¢\u0006\u0002\u00109R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/obric/oui/sheet/v2/SheetAnimStyle;", "", "()V", "TAG", "", "adjustSheetRootTopSpace", "", "container", "Landroid/view/View;", "calculateAndroidDecayTarget", "", "initValue", "initialVelocity", "frictionMultiplier", "", "absVelocityThreshold", "calculateStiffnessFromDuration", "durationMs", "decideSpringParams", "Lkotlin/Pair;", "heightRatio", "isShow", "", "shouldDismiss", "view", "dismissThreshold", "updateDimViewWithAnim", "dimView", "animFraction", "startDim", "endDim", "updateWindowDimWithAnim", "window", "Landroid/view/Window;", "clearSheetAnimator", ExifInterface.GPS_DIRECTION_TRUE, "animId", "", "(Landroid/view/View;I)V", "decideHeightLevel", "Lcom/obric/oui/sheet/v2/SheetAnimStyle$HeightLevel;", "screenHeight", "getSheetAnimator", "Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "(Landroid/view/View;I)Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "sheetHide", "enableDimAnim", "useWindowDim", "yVelocity", "endCallback", "Ljava/lang/Runnable;", "fullWindowHeight", "(Landroid/view/View;Landroid/view/Window;Landroid/view/View;ZZFLjava/lang/Runnable;Ljava/lang/Integer;)Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "sheetPositionSmoothReset", "targetDimAmount", "(Landroid/view/View;Landroid/view/Window;Landroid/view/View;ZZFFLjava/lang/Integer;)Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "sheetShow", "(Landroid/view/View;Landroid/view/Window;Landroid/view/View;ZZFLjava/lang/Integer;)Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "HeightLevel", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SheetAnimStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SheetAnimStyle f14486a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/sheet/v2/SheetAnimStyle$HeightLevel;", "", "maxRatio", "", "(Ljava/lang/String;IF)V", "getMaxRatio", "()F", "SMALL", "MEDIUM", "LARGE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum HeightLevel extends Enum<HeightLevel> {
        private static final /* synthetic */ HeightLevel[] $VALUES = null;
        public static final HeightLevel LARGE = null;
        public static final HeightLevel MEDIUM = null;
        public static final HeightLevel SMALL = null;
        private final float maxRatio;

        private static final /* synthetic */ HeightLevel[] $values() {
            return new HeightLevel[]{SMALL, MEDIUM, LARGE};
        }

        static {
            SMALL = new HeightLevel("SMALL", 0, 0.4f);
            MEDIUM = new HeightLevel("MEDIUM", 1, 0.8f);
            LARGE = new HeightLevel("LARGE", 2, 1.0f);
            $VALUES = $values();
        }

        private HeightLevel(String r1, int r2, float r3) {
            super(r1, r2);
            this.maxRatio = r3;
        }

        public static HeightLevel valueOf(String r2) {
            return (HeightLevel) ZeusTransformUtils.preCheckCast(Enum.valueOf(HeightLevel.class, r2), HeightLevel.class, "com.obric.memorydata.plugin");
        }

        public static HeightLevel[] values() {
            return (HeightLevel[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HeightLevel[].class, "com.obric.memorydata.plugin");
        }

        public final float getMaxRatio() {
            return this.maxRatio;
        }
    }

    static {
        f14486a = new SheetAnimStyle();
    }

    private SheetAnimStyle() {
    }

    public static /* synthetic */ float a(SheetAnimStyle r7, float r8, float r9, double r10, double r12, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r10 = 0.5d;
    L5:
        double r3 = r10;
        if ((r14 & 8) == 0) goto L9;
        r12 = 0.1d;
    L9:
        return r7.a(r8, r9, r3, r12);
    }

    private static final float a(Ref.DoubleRef r6, double r7, float r9, float r10) {
        if (Math.abs(r10) > r6.element) goto L5;
        return r9;
    L5:
        double r2 = r10;
        double r4 = 1000;
        double r0 = (Math.log(Math.abs(r6.element / r2)) / r7) * r4;
        double r3 = r2 / r7;
        return (float) ((((double) r9) - r3) + (r3 * Math.exp((r7 * r0) / r4)));
    }

    public static /* synthetic */ com.obric.common.oea.foundation.animation.builder.a.C0372a a(SheetAnimStyle r8, View r9, Window r10, View r11, boolean r12, boolean r13, float r14, float r15, Integer r16, int r17, Object r18) {
        Integer r1 = null;
        if ((r17 & 1) == 0) goto L5;
        Window r0 = null;
    L7:
        if ((r17 & 2) == 0) goto L9;
        View r2 = null;
    L10:
        boolean r4 = true;
        if ((r17 & 4) == 0) goto L13;
        boolean r3 = true;
    L15:
        if ((r17 & 8) != 0) goto L19;
        r4 = r13;
    L19:
        if ((r17 & 16) == 0) goto L21;
        float r5 = 0.6f;
    L23:
        if ((r17 & 32) == 0) goto L25;
        float r6 = 0.0f;
    L27:
        if ((r17 & 64) != 0) goto L31;
        r1 = r16;
    L31:
        return r8.a(r9, r0, r2, r3, r4, r5, r6, r1);
    L25:
        r6 = r15;
        goto L27
    L21:
        r5 = r14;
        goto L23
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L10
    L5:
        r0 = r10;
        goto L7
    }

    public static /* synthetic */ com.obric.common.oea.foundation.animation.builder.a.C0372a a(SheetAnimStyle r7, View r8, Window r9, View r10, boolean r11, boolean r12, float r13, Integer r14, int r15, Object r16) {
        Integer r1 = null;
        if ((r15 & 1) == 0) goto L5;
        Window r0 = null;
    L7:
        if ((r15 & 2) == 0) goto L9;
        View r2 = null;
    L10:
        boolean r4 = true;
        if ((r15 & 4) == 0) goto L13;
        boolean r3 = true;
    L15:
        if ((r15 & 8) != 0) goto L19;
        r4 = r12;
    L19:
        if ((r15 & 16) == 0) goto L21;
        float r5 = 0.6f;
    L23:
        if ((r15 & 32) != 0) goto L27;
        r1 = r14;
    L27:
        return r7.a(r8, r0, r2, r3, r4, r5, r1);
    L21:
        r5 = r13;
        goto L23
    L13:
        r3 = r11;
        goto L15
    L9:
        r2 = r10;
        goto L10
    L5:
        r0 = r9;
        goto L7
    }

    public static /* synthetic */ com.obric.common.oea.foundation.animation.builder.a.C0372a a(SheetAnimStyle r8, View r9, Window r10, View r11, boolean r12, boolean r13, float r14, Runnable r15, Integer r16, int r17, Object r18) {
        Runnable r0 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r15, Runnable.class, "com.obric.memorydata.plugin");
        Integer r2 = null;
        if ((r17 & 1) == 0) goto L5;
        Window r1 = null;
    L7:
        if ((r17 & 2) == 0) goto L9;
        View r3 = null;
    L10:
        boolean r5 = true;
        if ((r17 & 4) == 0) goto L13;
        boolean r4 = true;
    L15:
        if ((r17 & 8) != 0) goto L19;
        r5 = r13;
    L19:
        if ((r17 & 16) == 0) goto L21;
        float r6 = 0.0f;
    L23:
        if ((r17 & 32) == 0) goto L26;
        r0 = null;
    L26:
        if ((r17 & 64) != 0) goto L30;
        r2 = r16;
    L30:
        return r8.a(r9, r1, r3, r4, r5, r6, r0, r2);
    L21:
        r6 = r14;
        goto L23
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L10
    L5:
        r1 = r10;
        goto L7
    }

    private final Pair<Float, Float> a(float r6, boolean r7) {
        float r1 = 1.0f - Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH.getBounce();
        if (r7 == false) goto L7;
        return new Pair(Float.valueOf(r1), Float.valueOf(a(com.obric.oui.c.b.a(r6, 0.3f, 0.6f, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_1.getDuration() / 1000.0f, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_3.getDuration() / 1000.0f))));
    L7:
        return new Pair(Float.valueOf(r1), Float.valueOf(a(com.obric.oui.c.b.a(r6, 0.3f, 0.6f, Token.Duration.OUI_ANIMATION_DURATION_SHORT_4.getDuration() / 1000.0f, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2.getDuration() / 1000.0f))));
    }

    private final void a(View r2, float r3, float r4, float r5) {
        float r6 = r5 - r4;     // Catch: Exception -> L5
        r2.setAlpha(r4 + (r6 * RangesKt.coerceIn(r3, 0.0f, 1.0f)));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.w("SheetAnimStyle", Intrinsics.stringPlus("updateDimViewWithAnim: ", e.getMessage()));
    }

    private final void a(Window r2, float r3, float r4, float r5) {
        float r6 = r5 - r4;     // Catch: Exception -> L5
        r2.setDimAmount(r4 + (r6 * RangesKt.coerceIn(r3, 0.0f, 1.0f)));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.w("SheetAnimStyle", Intrinsics.stringPlus("updateWindowDimWithAnim: ", e.getMessage()));
    }

    public static final /* synthetic */ void a(SheetAnimStyle r0, View r1, float r2, float r3, float r4) {
        r0.a(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void a(SheetAnimStyle r0, Window r1, float r2, float r3, float r4) {
        r0.a(r1, r2, r3, r4);
    }

    public static /* synthetic */ boolean a(SheetAnimStyle r0, View r1, float r2, float r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = 0.333333f;
    L6:
        return r0.a(r1, r2, r3);
    }

    private final <T extends View> com.obric.common.oea.foundation.animation.builder.a.C0372a b(T r3, int r4) {
        com.obric.oui.c.c r2 = com.obric.oui.c.c.f13403a;
        Object r5 = r3.getTag(r4);
        if (r5 != null) goto L6;
    L4:
        r5 = null;
    L7:
        com.obric.common.oea.foundation.animation.builder.a.C0372a r6 = (com.obric.common.oea.foundation.animation.builder.a.C0372a) ZeusTransformUtils.preCheckCast(r5, com.obric.common.oea.foundation.animation.builder.a.C0372a.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L11;
        com.obric.common.oea.foundation.animation.builder.a.C0372a r7 = new com.obric.common.oea.foundation.animation.builder.a.C0372a(r3);
        r3.setTag(r4, r7);
        return r7;
    L11:
        return r6;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, com.obric.common.oea.foundation.animation.builder.a.C0372a.class) == false) goto L4;
        goto L4
    }

    public final float a(float r3) {
        return (float) Math.pow(6.283185307179586d / ((double) r3), 2.0d);
    }

    public final float a(float r3, float r4, double r5, double r7) {
        Ref.DoubleRef r2 = new Ref.DoubleRef();
        r2.element = RangesKt.coerceAtLeast(1.0E-7d, Math.abs(r7));
        return a(r2, RangesKt.coerceAtLeast(1.0E-4d, r5) * (-4.2d), r3, r4);
    }

    public final com.obric.common.oea.foundation.animation.builder.a.C0372a a(View r18, final Window r19, final View r20, final boolean r21, final boolean r22, final float r23, float r24, Integer r25) {
        Intrinsics.checkNotNullParameter(r18, "<this>");
        if (r25 != null) goto L5;
        int r0 = Resources.getSystem().getDisplayMetrics().heightPixels;
    L6:
        r18.setAlpha(1.0f);
        float r5 = 0.0f;
        if (r22 == false) goto L14;
        if (r19 == null) goto L17;
        WindowManager.LayoutParams r6 = r19.getAttributes();
        if (r6 == null) goto L17;
        r5 = r6.dimAmount;
    L17:
        final float r7 = r5;
        Pair<Float, Float> r1 = a(r18.getHeight() / r0, true);
        float r8 = ((Number) ZeusTransformUtils.preCheckCast(r1.component1(), Number.class, "com.obric.memorydata.plugin")).floatValue();
        float r9 = ((Number) ZeusTransformUtils.preCheckCast(r1.component2(), Number.class, "com.obric.memorydata.plugin")).floatValue();
        if (r21 == false) goto L26;
        if (r22 == false) goto L26;
        if (r19 == null) goto L26;
        r19.addFlags(2);     // Catch: Exception -> L24
    L24:
        e = move-exception;
        Log.w("SheetAnimStyle", Intrinsics.stringPlus("dialogBottomShow, can't show dim anim: ", e.getMessage()));
    L26:
        final float r2 = r18.getTranslationY();
        final float r10 = 0.0f;
        com.obric.common.oea.foundation.animation.builder.a.C0372a r11 = b(r18, ZeusTransformUtils.mapRes(R.id.o_dialog_anim_in, OaidModel.KEY_ID, "o_dialog_anim_in"));
        AnimationProperty.FloatProperty r12 = AnimationProperty.FloatProperty.TRANSLATION_Y;
        float r3 = r18.getTranslationY();
        com.obric.common.oea.foundation.animation.spec.spring.b r4 = com.obric.common.oea.foundation.animation.spec.b.a(r8, r9, 0, 4, null);
        r4.a(1.0f);
        return r11.a(r12, Float.valueOf(r3), 0.0f, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.preCheckCast(r4, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), Float.valueOf(r24)).a((Function3) ZeusTransformUtils.preCheckCast(new SheetAnimStyle$sheetPositionSmoothReset$2(r21, r22, r19, r2, r10, r7, r23, r20), Function3.class, "com.obric.memorydata.plugin"));
    L14:
        if (r20 == null) goto L17;
        r5 = r20.getAlpha();
        goto L17
    L5:
        r0 = r25.intValue();
        goto L6
    }

    public final com.obric.common.oea.foundation.animation.builder.a.C0372a a(View r19, final Window r20, final View r21, final boolean r22, final boolean r23, final float r24, Integer r25) {
        Intrinsics.checkNotNullParameter(r19, "<this>");
        if (r25 != null) goto L5;
        int r0 = Resources.getSystem().getDisplayMetrics().heightPixels;
    L6:
        int r3 = r0;
        if (r22 == false) goto L14;
        if (r23 == false) goto L14;
        if (r20 == null) goto L14;
        r20.addFlags(2);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        Log.w("SheetAnimStyle", Intrinsics.stringPlus("dialogBottomShow, can't show dim anim: ", e.getMessage()));
    L14:
        int r1 = r19.getHeight() + h.a(r19, 32);
        r19.setAlpha(1.0f);
        final float r2 = r1;
        r19.setTranslationY(r2);
        Pair<Float, Float> r4 = a(r19.getHeight() / r3, true);
        float r7 = ((Number) ZeusTransformUtils.preCheckCast(r4.component1(), Number.class, "com.obric.memorydata.plugin")).floatValue();
        float r5 = ((Number) ZeusTransformUtils.preCheckCast(r4.component2(), Number.class, "com.obric.memorydata.plugin")).floatValue();
        final float r8 = h.a(r19, 2);
        com.obric.common.oea.foundation.animation.builder.a.C0372a r10 = b(r19, ZeusTransformUtils.mapRes(R.id.o_dialog_anim_in, OaidModel.KEY_ID, "o_dialog_anim_in"));
        AnimationProperty.FloatProperty r11 = AnimationProperty.FloatProperty.TRANSLATION_Y;
        Float r12 = Float.valueOf(r2);
        com.obric.common.oea.foundation.animation.spec.spring.b r6 = com.obric.common.oea.foundation.animation.spec.b.a(r7, r5, 0, 4, null);
        r6.a(1.0f);
        Unit r9 = Unit.INSTANCE;
        return com.obric.common.oea.foundation.animation.builder.a.C0372a.a(r10, r11, r12, r8, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.preCheckCast(r6, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), null, 16, null).a((Function3) ZeusTransformUtils.preCheckCast(new SheetAnimStyle$sheetShow$2(r22, r23, r20, r2, r8, r24, r21), Function3.class, "com.obric.memorydata.plugin"));
    L5:
        r0 = r25.intValue();
        goto L6
    }

    public final com.obric.common.oea.foundation.animation.builder.a.C0372a a(final View r21, final Window r22, final View r23, final boolean r24, final boolean r25, float r26, Runnable r27, Integer r28) {
        final Runnable r11 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r27, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r21, "<this>");
        if (r28 != null) goto L5;
        int r0 = Resources.getSystem().getDisplayMetrics().heightPixels;
    L6:
        int r2 = r0;
        if (r24 == false) goto L15;
        if (r25 == false) goto L15;
        if (r22 == null) goto L15;
        r22.addFlags(2);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        Log.w("SheetAnimStyle", Intrinsics.stringPlus("dialogBottomHide, can't show dim anim: ", e.getMessage()));
    L15:
        int r1 = r21.getHeight() + h.a(r21, 32);
        Pair<Float, Float> r3 = a(r21.getHeight() / r2, false);
        float r5 = ((Number) ZeusTransformUtils.preCheckCast(r3.component1(), Number.class, "com.obric.memorydata.plugin")).floatValue();
        float r4 = ((Number) ZeusTransformUtils.preCheckCast(r3.component2(), Number.class, "com.obric.memorydata.plugin")).floatValue();
        final float r6 = r21.getTranslationY();
        final float r7 = r1;
        final float r8 = 0.0f;
        if (r25 == false) goto L23;
        if (r22 == null) goto L26;
        WindowManager.LayoutParams r9 = r22.getAttributes();
        if (r9 == null) goto L26;
        r8 = r9.dimAmount;
    L26:
        final float r10 = 0.0f;
        com.obric.common.oea.foundation.animation.builder.a.C0372a r14 = b(r21, ZeusTransformUtils.mapRes(R.id.o_dialog_anim_out, OaidModel.KEY_ID, "o_dialog_anim_out"));
        AnimationProperty.FloatProperty r15 = AnimationProperty.FloatProperty.TRANSLATION_Y;
        float r12 = r21.getTranslationY();
        com.obric.common.oea.foundation.animation.spec.spring.b r13 = com.obric.common.oea.foundation.animation.spec.b.a(r5, r4, 0, 4, null);
        r13.a(1.0f);
        com.obric.common.oea.foundation.animation.builder.a.C0372a r16 = r14.a(r15, Float.valueOf(r12), r7, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.preCheckCast(r13, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), Float.valueOf(r26)).a((Function3) ZeusTransformUtils.preCheckCast(new SheetAnimStyle$sheetHide$animBuilder$2(r24, r25, r22, r6, r7, r8, r10, r23, r21, r11), Function3.class, "com.obric.memorydata.plugin"));
        com.obric.oui.animation.style.b.b(r21);
        return r16;
    L23:
        if (r23 == null) goto L26;
        r8 = r23.getAlpha();
        goto L26
    L5:
        r0 = r28.intValue();
        goto L6
    }

    public final void a(View r4) {
        Intrinsics.checkNotNullParameter(r4, "container");
        int r3 = h.a(r4, 10);
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == true) goto L5;
    L7:
        r4.setLayoutParams(r0);
        return;
    L5:
        if (((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).topMargin >= r3) goto L7;
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).topMargin = r3;
        goto L7
    }

    public final <T extends View> void a(T r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setTag(r2, null);
    }

    public final boolean a(View r12, float r13, float r14) {
        Intrinsics.checkNotNullParameter(r12, "view");
        if ((r12.getTranslationY() / r12.getHeight()) <= r14) goto L6;
        return true;
    L6:
        if ((a(this, r12.getTranslationY(), r13, 0.0d, 0.0d, 12, null) / r12.getHeight()) > r14) goto L10;
        return false;
    L10:
        return true;
    }
}
