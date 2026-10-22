package com.obric.oui.lisitem;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.common.oea.foundation.animation.builder.c;
import com.obric.common.oea.foundation.animation.d.d;
import com.obric.common.oea.foundation.animation.spec.b;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.oui.common.util.h;
import com.obric.oui.layout.OUIFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0016\u0018\u0000 +2\u00020\u0001:\u0001+B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ8\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J \u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!H\u0002J \u0010\"\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!H\u0002J\"\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00072\b\b\u0002\u0010&\u001a\u00020\u0005H\u0002J\u000e\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u0007J\u001a\u0010)\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00072\b\b\u0002\u0010&\u001a\u00020\u0005H\u0007J\u000e\u0010*\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u0005R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/obric/oui/lisitem/OCardListItemPositionHelper;", "", "cardContainer", "Landroid/widget/FrameLayout;", "showBg", "", "bgColor", "", "cardPosition", "(Landroid/widget/FrameLayout;ZII)V", "bgDrawable", "Landroid/graphics/drawable/GradientDrawable;", "cardBg", "getCardContainer", "()Landroid/widget/FrameLayout;", "currentCornerRadii", "", "currentPosition", "positionAnimator", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "showCardBg", "animatePositionChange", "", "startRadii", "targetRadii", "startTopPadding", "startBottomPadding", "targetTopPadding", "targetBottomPadding", "lerpInt", CommonConsts.APM_INNER_EVENT_COST_START, "end", "progress", "", "lerpRadii", "resetCardContainerIfNeed", "show", "position", "animate", "setBgColor", TypedValues.Custom.S_COLOR, "setCardPosition", "setShowCardBg", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0754a f13990a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FrameLayout f13991b;
    private final GradientDrawable c;
    private boolean d;
    private int e;
    private int f;
    private float[] g;
    private d h;

    /* JADX INFO: renamed from: com.obric.oui.lisitem.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/lisitem/OCardListItemPositionHelper$Companion;", "", "()V", "CARD_CORNER_RADIUS_DP", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0754a {
        private C0754a() {
        }

        public /* synthetic */ C0754a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f13990a = new C0754a(null);
    }

    public a(FrameLayout r7, boolean r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r7, "cardContainer");
        this.f13991b = r7;
        this.c = new GradientDrawable();
        this.d = true;
        this.f = -1;
        this.g = new float[8];
        this.e = r9;
        a(this, r8, r10, false, 4, null);
    }

    private final int a(int r2, int r3, float r4) {
        return MathKt.roundToInt(r2 + ((r3 - r2) * RangesKt.coerceIn(r4, 0.0f, 1.0f)));
    }

    public static final /* synthetic */ int a(a r0, int r1, int r2, float r3) {
        return r0.a(r1, r2, r3);
    }

    public static final /* synthetic */ void a(a r0, d r1) {
        r0.h = r1;
    }

    static /* synthetic */ void a(a r0, boolean r1, int r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        r0.a(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resetCardContainerIfNeed");
    }

    public static final /* synthetic */ void a(a r0, float[] r1) {
        r0.g = r1;
    }

    private final void a(boolean r25, int r26, boolean r27) {
        if (this.d == r25) goto L5;
    L7:
        d r2 = this.h;
        if (r2 == null) goto L11;
        d.a(r2, false, 1, null);
    L11:
        if (r27 == true) goto L13;
    L17:
        boolean r3 = false;
    L18:
        float[] r6 = this.g;
        float[] r7 = Arrays.copyOf(r6, r6.length);
        Intrinsics.checkNotNullExpressionValue(r7, "copyOf(this, size)");
        int r9 = this.f13991b.getPaddingTop();
        int r10 = this.f13991b.getPaddingBottom();
        this.d = r25;
        this.f = r26;
        float[] r11 = new float[8];
        if (r25 == false) goto L34;
        float r0 = h.b((View) ZeusTransformUtils.preCheckCast(this.f13991b, View.class, "com.obric.memorydata.plugin"), 20);
        this.c.setColor(this.e);
        int r12 = this.f;
        if (r12 == 1) goto L27;
        if (r12 == 2) goto L26;
        if (r12 == 3) goto L25;
        r11 = new float[]{r0, r0, r0, r0, r0, r0, r0, r0};
    L28:
        if (r3 == false) goto L30;
        float[] r15 = Arrays.copyOf(r7, r7.length);
        Intrinsics.checkNotNullExpressionValue(r15, "copyOf(this, size)");
    L31:
        this.g = r15;
        this.c.setCornerRadii(r15);
        this.f13991b.setBackground((Drawable) ZeusTransformUtils.preCheckCast(this.c, Drawable.class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.instanceOf(this.f13991b, OUIFrameLayout.class) == false) goto L35;
        ((OUIFrameLayout) ZeusTransformUtils.preCheckCast(this.f13991b, OUIFrameLayout.class, "com.obric.memorydata.plugin")).setShadowCornerRadius((int) r0);
    L35:
        int r1 = h.a((View) ZeusTransformUtils.preCheckCast(this.f13991b, View.class, "com.obric.memorydata.plugin"), 12);
        int r8 = h.a((View) ZeusTransformUtils.preCheckCast(this.f13991b, View.class, "com.obric.memorydata.plugin"), 8);
        int r13 = h.a((View) ZeusTransformUtils.preCheckCast(this.f13991b, View.class, "com.obric.memorydata.plugin"), 8);
        int r4 = h.a((View) ZeusTransformUtils.preCheckCast(this.f13991b, View.class, "com.obric.memorydata.plugin"), 8);
        int r5 = h.a((View) ZeusTransformUtils.preCheckCast(this.f13991b, View.class, "com.obric.memorydata.plugin"), 2);
        int r14 = h.a((View) ZeusTransformUtils.preCheckCast(this.f13991b, View.class, "com.obric.memorydata.plugin"), 2);
        int r16 = h.a((View) ZeusTransformUtils.preCheckCast(this.f13991b, View.class, "com.obric.memorydata.plugin"), 2);
        int r17 = h.a((View) ZeusTransformUtils.preCheckCast(this.f13991b, View.class, "com.obric.memorydata.plugin"), 2);
        int r18 = h.a((View) ZeusTransformUtils.preCheckCast(this.f13991b, View.class, "com.obric.memorydata.plugin"), 8);
        int r19 = h.a((View) ZeusTransformUtils.preCheckCast(this.f13991b, View.class, "com.obric.memorydata.plugin"), 2);
        int r20 = h.a((View) ZeusTransformUtils.preCheckCast(this.f13991b, View.class, "com.obric.memorydata.plugin"), 8);
        int r21 = h.a((View) ZeusTransformUtils.preCheckCast(this.f13991b, View.class, "com.obric.memorydata.plugin"), 8);
        int r22 = h.a((View) ZeusTransformUtils.preCheckCast(this.f13991b, View.class, "com.obric.memorydata.plugin"), 2);
        ViewGroup.LayoutParams r110 = this.f13991b.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r110, ViewGroup.MarginLayoutParams.class) == false) goto L38;
        ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r110, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L39:
        if (r23 == null) goto L50;
        if (this.d == false) goto L44;
        int r111 = r1;
    L45:
        r23.setMarginStart(r111);
        if (this.d == false) goto L48;
        r8 = r1;
    L48:
        r23.setMarginEnd(r8);
        goto L50
    L44:
        r111 = r8;
    L50:
        if (this.d == false) goto L52;
        this.f13991b.setClipChildren(true);
        this.f13991b.setClipToPadding(true);
        int r24 = 0;
    L54:
        if (this.d == true) goto L57;
        r13 = r24;
    L57:
        this.f13991b.getPaddingTop();
        this.f13991b.getPaddingBottom();
        int r28 = this.f;
        if (r28 == 1) goto L78;
        if (r28 != 2) goto L62;
        int r29 = r16;
        int r30 = r14;
    L82:
        if (r3 == false) goto L84;
        a(r7, r11, r9, r10, r30, r29);
    L85:
        this.f13991b.requestLayout();
        return;
    L84:
        this.f13991b.setPadding(r13, r30, r13, r29);
        goto L85
    L62:
        if (r28 == 3) goto L72;
        boolean r31 = this.d;
        if (r31 == false) goto L66;
        r30 = r20;
    L67:
        if (r31 == false) goto L69;
        int r32 = r21;
    L70:
        r29 = r32;
        goto L82
    L69:
        r32 = r22;
        goto L70
    L66:
        r30 = r24;
        goto L67
    L72:
        if (this.d == false) goto L74;
        int r33 = r18;
    L75:
        r29 = r33;
        r30 = r17;
        goto L82
    L74:
        r33 = r19;
        goto L75
    L78:
        if (this.d == true) goto L81;
        r4 = r24;
    L81:
        r29 = r5;
        r30 = r4;
        goto L82
    L52:
        r24 = 0;
        this.f13991b.setClipChildren(false);
        this.f13991b.setClipToPadding(false);
        goto L54
    L38:
        r23 = null;
        goto L39
    L30:
        r15 = Arrays.copyOf(r11, r11.length);
        Intrinsics.checkNotNullExpressionValue(r15, "copyOf(this, size)");
        goto L31
    L25:
        r11 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, r0, r0, r0, r0};
        goto L28
    L26:
        r11 = new float[8];
        goto L28
    L27:
        r11 = new float[]{r0, r0, r0, r0, 0.0f, 0.0f, 0.0f, 0.0f};
        goto L28
    L34:
        float[] r34 = Arrays.copyOf(r11, 8);
        Intrinsics.checkNotNullExpressionValue(r34, "copyOf(this, size)");
        this.g = r34;
        this.f13991b.setBackground(null);
        goto L35
    L13:
        if (this.d != r25) goto L17;
        if (this.f == (-1)) goto L17;
        r3 = true;
        goto L18
    L5:
        if (this.f != r26) goto L7;
    }

    private final void a(final float[] r13, final float[] r14, final int r15, final int r16, final int r17, final int r18) {
        this.h = c.a.a(new c.a(), 0.0f, 1.0f, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.preCheckCast(b.a(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2, 0, 4, null), com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), null, 8, null).a((Function3) ZeusTransformUtils.preCheckCast(new OCardListItemPositionHelper$animatePositionChange$1(this, r13, r14, r15, r17, r16, r18), Function3.class, "com.obric.memorydata.plugin")).a((Function2) ZeusTransformUtils.preCheckCast(new OCardListItemPositionHelper$animatePositionChange$2(this, r14, r17, r18), Function2.class, "com.obric.memorydata.plugin")).a().a();
    }

    public static final /* synthetic */ boolean a(a r0) {
        return r0.d;
    }

    public static final /* synthetic */ float[] a(a r0, float[] r1, float[] r2, float r3) {
        return r0.a(r1, r2, r3);
    }

    private final float[] a(float[] r6, float[] r7, float r8) {
        float r5 = RangesKt.coerceIn(r8, 0.0f, 1.0f);
        int r9 = r6.length;
        float[] r0 = new float[r9];
        int r1 = 0;
    L3:
        if (r1 >= r9) goto L5;
        r0[r1] = r6[r1] + ((r7[r1] - r6[r1]) * r5);
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    public static final /* synthetic */ GradientDrawable b(a r0) {
        return r0.c;
    }

    public static final /* synthetic */ float[] c(a r0) {
        return r0.g;
    }

    public final FrameLayout a() {
        return this.f13991b;
    }

    public final void a(int r7) {
        this.e = r7;
        a(this, this.d, this.f, false, 4, null);
    }

    public final void a(int r2, boolean r3) {
        a(this.d, r2, r3);
    }

    public final void a(boolean r7) {
        a(this, r7, this.f, false, 4, null);
    }
}
