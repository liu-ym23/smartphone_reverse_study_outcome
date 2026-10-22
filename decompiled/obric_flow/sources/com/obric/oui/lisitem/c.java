package com.obric.oui.lisitem;

import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import com.google.common.reflect.w;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.oui.layout.OUIFrameLayout;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OUIFrameLayout f13601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GradientDrawable f13602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13603c;
    public int d;
    public int e;
    public float[] f;
    public jp.d g;

    public c(OUIFrameLayout r5, boolean r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "cardContainer");
        this.f13601a = r5;
        this.f13602b = new GradientDrawable();
        this.f13603c = true;
        this.e = -1;
        this.f = new float[8];
        this.d = r11;
        a(r12, r10, false);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a(int r26, boolean r27, boolean r28) {
        if (this.f13603c == r27) goto L5;
    L7:
        jp.d r5 = this.g;
        int r10 = 0;
        if (r5 == null) goto L12;
        int r11 = jp.d.d;
        r5.a(false);
    L12:
        if (r28 == true) goto L14;
    L18:
        boolean r12 = false;
    L19:
        float[] r13 = this.f;
        final float[] r14 = Arrays.copyOf(r13, r13.length);
        OUIFrameLayout r15 = this.f13601a;
        final int r16 = r15.getPaddingTop();
        final int r17 = r15.getPaddingBottom();
        this.f13603c = r27;
        this.e = r26;
        final float[] r18 = new float[8];
        if (r27 == false) goto L33;
        float r19 = com.lynx.tasm.utils.a.E(20, r15);
        int r110 = this.d;
        GradientDrawable r111 = this.f13602b;
        r111.setColor(r110);
        int r112 = this.e;
        if (r112 == 1) goto L28;
        if (r112 == 2) goto L27;
        if (r112 == 3) goto L26;
        r18 = new float[]{r19, r19, r19, r19, r19, r19, r19, r19};
    L29:
        if (r12 == false) goto L31;
        float[] r113 = Arrays.copyOf(r14, r14.length);
    L32:
        this.f = r113;
        r111.setCornerRadii(r113);
        r15.setBackground(r111);
        r15.setShadowCornerRadius((int) r19);
    L34:
        int r20 = com.lynx.tasm.utils.a.B(12, r15);
        int r114 = com.lynx.tasm.utils.a.B(8, r15);
        int r115 = com.lynx.tasm.utils.a.B(8, r15);
        int r116 = com.lynx.tasm.utils.a.B(8, r15);
        int r117 = com.lynx.tasm.utils.a.B(2, r15);
        int r118 = com.lynx.tasm.utils.a.B(2, r15);
        int r119 = com.lynx.tasm.utils.a.B(2, r15);
        int r21 = com.lynx.tasm.utils.a.B(2, r15);
        int r22 = com.lynx.tasm.utils.a.B(8, r15);
        int r23 = com.lynx.tasm.utils.a.B(2, r15);
        int r24 = com.lynx.tasm.utils.a.B(8, r15);
        int r25 = com.lynx.tasm.utils.a.B(8, r15);
        int r29 = com.lynx.tasm.utils.a.B(2, r15);
        ViewGroup.LayoutParams r120 = r15.getLayoutParams();
        if ((r120 instanceof ViewGroup.MarginLayoutParams) == false) goto L37;
        ViewGroup.MarginLayoutParams r121 = (ViewGroup.MarginLayoutParams) r120;
    L38:
        if (r121 == null) goto L50;
        if (this.f13603c == false) goto L43;
        int r122 = r20;
    L44:
        r121.setMarginStart(r122);
        if (this.f13603c == true) goto L48;
        r20 = r114;
    L48:
        r121.setMarginEnd(r20);
        goto L50
    L43:
        r122 = r114;
    L50:
        if (this.f13603c == false) goto L52;
        r15.setClipChildren(true);
        r15.setClipToPadding(true);
    L54:
        if (this.f13603c == true) goto L57;
        r115 = 0;
    L57:
        r15.getPaddingTop();
        r15.getPaddingBottom();
        int r30 = this.e;
        if (r30 == 1) goto L76;
        if (r30 != 2) goto L61;
        int r31 = r118;
        int r32 = r119;
    L78:
        if (r12 == false) goto L80;
        com.obric.common.oea.foundation.animation.spec.spring.b r123 = ug.a.m(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_2);
        Intrinsics.checkNotNullParameter(r123, "spec");
        hp.a r33 = new hp.a(r123, Float.valueOf(0.0f), Float.valueOf(1.0f), null, "valueAnimationPlaceholder", Reflection.getOrCreateKotlinClass(Float.TYPE));
        final int r124 = r31;
        final int r125 = r32;
        final float[] r34 = r18;
        Function3<String, Object, Object, Unit> r126 = new OCardListItemPositionHelper$animatePositionChange$1(this, r14, r34, r16, r124, r17, r125);
        Intrinsics.checkNotNullParameter(r126, "callback");
        Function2<Boolean, Throwable, Unit> r35 = new OCardListItemPositionHelper$animatePositionChange$2(this, r18, r124, r125);
        Intrinsics.checkNotNullParameter(r35, "callback");
        this.g = new w(r33, r126, r35).x();
    L81:
        r15.requestLayout();
        return;
    L80:
        r15.setPadding(r115, r31, r115, r32);
        goto L81
    L61:
        if (r30 == 3) goto L70;
        boolean r36 = this.f13603c;
        if (r36 == false) goto L65;
        r10 = r24;
    L65:
        if (r36 == false) goto L67;
        r117 = r25;
    L68:
        r31 = r10;
        r32 = r117;
        goto L78
    L67:
        r117 = r29;
        goto L68
    L70:
        if (this.f13603c == false) goto L72;
        int r127 = r22;
    L73:
        r32 = r127;
        r31 = r21;
        goto L78
    L72:
        r127 = r23;
        goto L73
    L76:
        if (this.f13603c == false) goto L68;
        r10 = r116;
        goto L68
    L52:
        r15.setClipChildren(false);
        r15.setClipToPadding(false);
        goto L54
    L37:
        r121 = null;
        goto L38
    L31:
        r113 = Arrays.copyOf(r18, r18.length);
        goto L32
    L26:
        r18 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, r19, r19, r19, r19};
        goto L29
    L27:
        r18 = new float[8];
        goto L29
    L28:
        r18 = new float[]{r19, r19, r19, r19, 0.0f, 0.0f, 0.0f, 0.0f};
        goto L29
    L33:
        this.f = Arrays.copyOf(r18, 8);
        r15.setBackground(null);
        goto L34
    L14:
        if (this.f13603c != r27) goto L18;
        if (this.e == (-1)) goto L18;
        r12 = true;
        goto L19
    L5:
        if (this.e != r26) goto L7;
    }
}
