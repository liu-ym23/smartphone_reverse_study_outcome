package com.facebook.drawee.generic;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.obric.launcher.widget.R$styleable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public abstract class GenericDraweeHierarchyInflater {
    public static GenericDraweeHierarchyBuilder a(Context r18, AttributeSet r19) {
        FrescoSystrace.a().getClass();
        GenericDraweeHierarchyBuilder r5 = new GenericDraweeHierarchyBuilder(r18);
        if (r19 == null) goto L183;
        TypedArray r10 = r18.obtainStyledAttributes(r19, R$styleable.GenericDraweeHierarchy);
        int r11 = r10.getIndexCount();     // Catch: Throwable -> L10
        int r12 = 0;
        int r13 = 0;
        boolean r14 = true;
        boolean r15 = true;
        boolean r16 = true;
        boolean r17 = true;
        boolean r110 = true;
        boolean r111 = true;
        boolean r112 = true;
        boolean r113 = true;
        int r114 = 0;
    L6:
        if (r13 >= r11) goto L146;
        int r20 = r10.getIndex(r13);     // Catch: Throwable -> L10
        if (r20 != R$styleable.GenericDraweeHierarchy_actualImageScaleType) goto L12;
        r5.f7922l = a(r10, r20);     // Catch: Throwable -> L10
        int r115 = r11;
    L145:
        r13 = r13 + 1;
        r11 = r115;
        goto L6
    L12:
        r115 = r11;
        Drawable r21 = null;
        if (r20 != R$styleable.GenericDraweeHierarchy_placeholderImage) goto L20;
        int r22 = r10.getResourceId(r20, 0);     // Catch: Throwable -> L10
        if (r22 == 0) goto L18;
        r21 = r18.getResources().getDrawable(r22);     // Catch: Throwable -> L10
    L18:
        r5.d = r21;     // Catch: Throwable -> L10
        goto L145
    L20:
        if (r20 != R$styleable.GenericDraweeHierarchy_pressedStateOverlayImage) goto L29;
        int r23 = r10.getResourceId(r20, 0);     // Catch: Throwable -> L10
        if (r23 != 0) goto L24;
        Drawable r24 = null;
    L25:
        if (r24 != null) goto L27;
        r5.f7925o = null;     // Catch: Throwable -> L10
        goto L145
    L27:
        StateListDrawable r25 = new StateListDrawable();     // Catch: Throwable -> L10
        r25.addState(new int[]{R.attr.state_pressed}, r24);     // Catch: Throwable -> L10
        r5.f7925o = r25;     // Catch: Throwable -> L10
        goto L145
    L24:
        r24 = r18.getResources().getDrawable(r23);     // Catch: Throwable -> L10
        goto L25
    L29:
        if (r20 != R$styleable.GenericDraweeHierarchy_progressBarImage) goto L36;
        int r26 = r10.getResourceId(r20, 0);     // Catch: Throwable -> L10
        if (r26 == 0) goto L34;
        r21 = r18.getResources().getDrawable(r26);     // Catch: Throwable -> L10
    L34:
        r5.f7920j = r21;     // Catch: Throwable -> L10
        goto L145
    L36:
        if (r20 != R$styleable.GenericDraweeHierarchy_fadeDuration) goto L39;
        GenericDraweeHierarchyBuilder.s = r10.getInt(r20, 0);     // Catch: Throwable -> L10
        goto L145
    L39:
        if (r20 != R$styleable.GenericDraweeHierarchy_viewAspectRatio) goto L42;
        r5.f7917c = r10.getFloat(r20, 0.0f);     // Catch: Throwable -> L10
        goto L145
    L42:
        if (r20 != R$styleable.GenericDraweeHierarchy_placeholderImageScaleType) goto L45;
        r5.e = a(r10, r20);     // Catch: Throwable -> L10
        goto L145
    L45:
        if (r20 != R$styleable.GenericDraweeHierarchy_retryImage) goto L52;
        int r27 = r10.getResourceId(r20, 0);     // Catch: Throwable -> L10
        if (r27 == 0) goto L50;
        r21 = r18.getResources().getDrawable(r27);     // Catch: Throwable -> L10
    L50:
        r5.f = r21;     // Catch: Throwable -> L10
        goto L145
    L52:
        if (r20 != R$styleable.GenericDraweeHierarchy_retryImageScaleType) goto L55;
        r5.g = a(r10, r20);     // Catch: Throwable -> L10
        goto L145
    L55:
        if (r20 != R$styleable.GenericDraweeHierarchy_failureImage) goto L62;
        int r28 = r10.getResourceId(r20, 0);     // Catch: Throwable -> L10
        if (r28 == 0) goto L60;
        r21 = r18.getResources().getDrawable(r28);     // Catch: Throwable -> L10
    L60:
        r5.f7918h = r21;     // Catch: Throwable -> L10
        goto L145
    L62:
        if (r20 != R$styleable.GenericDraweeHierarchy_failureImageScaleType) goto L65;
        r5.f7919i = a(r10, r20);     // Catch: Throwable -> L10
        goto L145
    L65:
        if (r20 != R$styleable.GenericDraweeHierarchy_progressBarImageScaleType) goto L68;
        r5.f7921k = a(r10, r20);     // Catch: Throwable -> L10
        goto L145
    L68:
        if (r20 != R$styleable.GenericDraweeHierarchy_progressBarAutoRotateInterval) goto L71;
        r12 = r10.getInteger(r20, r12);     // Catch: Throwable -> L10
        goto L145
    L71:
        if (r20 != R$styleable.GenericDraweeHierarchy_backgroundImage) goto L78;
        int r29 = r10.getResourceId(r20, 0);     // Catch: Throwable -> L10
        if (r29 == 0) goto L76;
        r21 = r18.getResources().getDrawable(r29);     // Catch: Throwable -> L10
    L76:
        r5.f7923m = r21;     // Catch: Throwable -> L10
        goto L145
    L78:
        if (r20 != R$styleable.GenericDraweeHierarchy_overlayImage) goto L87;
        int r30 = r10.getResourceId(r20, 0);     // Catch: Throwable -> L10
        if (r30 != 0) goto L82;
        Drawable r31 = null;
    L83:
        if (r31 != null) goto L85;
        r5.f7924n = null;     // Catch: Throwable -> L10
        goto L145
    L85:
        r5.f7924n = Arrays.asList(new Drawable[]{r31});     // Catch: Throwable -> L10
        goto L145
    L82:
        r31 = r18.getResources().getDrawable(r30);     // Catch: Throwable -> L10
        goto L83
    L87:
        if (r20 != R$styleable.GenericDraweeHierarchy_roundAsCircle) goto L90;
        a(r5).f7928b = r10.getBoolean(r20, false);     // Catch: Throwable -> L10
        goto L145
    L90:
        if (r20 != R$styleable.GenericDraweeHierarchy_roundedCornerRadius) goto L92;
        r114 = r10.getDimensionPixelSize(r20, r114);     // Catch: Throwable -> L10
        goto L145
    L92:
        r114 = r114;
        if (r20 != R$styleable.GenericDraweeHierarchy_roundTopLeft) goto L97;
        r14 = r10.getBoolean(r20, r14);     // Catch: Throwable -> L10
    L95:
        r114 = r114;
        goto L145
    L97:
        if (r20 != R$styleable.GenericDraweeHierarchy_roundTopRight) goto L100;
        r16 = r10.getBoolean(r20, r16);     // Catch: Throwable -> L10
        goto L95
    L100:
        if (r20 != R$styleable.GenericDraweeHierarchy_roundBottomLeft) goto L103;
        r112 = r10.getBoolean(r20, r112);     // Catch: Throwable -> L10
        goto L95
    L103:
        if (r20 != R$styleable.GenericDraweeHierarchy_roundBottomRight) goto L106;
        r110 = r10.getBoolean(r20, r110);     // Catch: Throwable -> L10
        goto L95
    L106:
        if (r20 != R$styleable.GenericDraweeHierarchy_roundTopStart) goto L109;
        r15 = r10.getBoolean(r20, r15);     // Catch: Throwable -> L10
        goto L95
    L109:
        if (r20 != R$styleable.GenericDraweeHierarchy_roundTopEnd) goto L112;
        r17 = r10.getBoolean(r20, r17);     // Catch: Throwable -> L10
        goto L95
    L112:
        if (r20 != R$styleable.GenericDraweeHierarchy_roundBottomStart) goto L115;
        r113 = r10.getBoolean(r20, r113);     // Catch: Throwable -> L10
        goto L95
    L115:
        if (r20 != R$styleable.GenericDraweeHierarchy_roundBottomEnd) goto L118;
        r111 = r10.getBoolean(r20, r111);     // Catch: Throwable -> L10
        goto L95
    L118:
        if (r20 != R$styleable.GenericDraweeHierarchy_roundWithOverlayColor) goto L121;
        RoundingParams r32 = a(r5);     // Catch: Throwable -> L10
        r32.d = r10.getColor(r20, 0);     // Catch: Throwable -> L10
        r32.f7927a = RoundingParams.RoundingMethod.f7930a;     // Catch: Throwable -> L10
        goto L95
    L121:
        if (r20 != R$styleable.GenericDraweeHierarchy_roundingBorderWidth) goto L131;
        RoundingParams r33 = a(r5);     // Catch: Throwable -> L10
        float r34 = r10.getDimensionPixelSize(r20, 0);     // Catch: Throwable -> L10
        r33.getClass();     // Catch: Throwable -> L10
        if (r34 < 0.0f) goto L125;
        boolean r35 = true;
    L127:
        if (r35 == false) goto L130;
        r33.e = r34;     // Catch: Throwable -> L10
        goto L145
    L130:
        throw new IllegalArgumentException("the border width cannot be < 0");     // Catch: Throwable -> L10
    L125:
        r35 = false;
        goto L127
    L131:
        r114 = r114;
        if (r20 != R$styleable.GenericDraweeHierarchy_roundingBorderColor) goto L135;
        a(r5).f = r10.getColor(r20, 0);     // Catch: Throwable -> L10
        goto L145
    L135:
        if (r20 != R$styleable.GenericDraweeHierarchy_roundingBorderPadding) goto L145;
        RoundingParams r36 = a(r5);     // Catch: Throwable -> L10
        float r37 = r10.getDimensionPixelSize(r20, 0);     // Catch: Throwable -> L10
        r36.getClass();     // Catch: Throwable -> L10
        if (r37 < 0.0f) goto L139;
        boolean r38 = true;
    L141:
        if (r38 == false) goto L144;
        r36.g = r37;     // Catch: Throwable -> L10
        goto L145
    L144:
        throw new IllegalArgumentException("the padding cannot be < 0");     // Catch: Throwable -> L10
    L139:
        r38 = false;
        goto L141
    L146:
        r10.recycle();
        if (r18.getResources().getConfiguration().getLayoutDirection() != 1) goto L164;
        if (r14 == false) goto L151;
        if (r17 == false) goto L151;
        boolean r39 = true;
    L152:
        if (r16 == false) goto L155;
        if (r15 == false) goto L155;
        boolean r40 = true;
    L156:
        if (r110 == false) goto L159;
        if (r113 == false) goto L159;
        boolean r41 = true;
    L160:
        if (r112 == false) goto L163;
        if (r111 == false) goto L163;
    L162:
        boolean r42 = r41;
        boolean r43 = r39;
        int r44 = r114;
        boolean r45 = true;
    L185:
        if (r5.f7920j == null) goto L188;
        if (r12 <= 0) goto L188;
        r5.f7920j = new AutoRotateDrawable(r5.f7920j, r12);
    L188:
        if (r44 <= 0) goto L206;
        RoundingParams r46 = a(r5);
        if (r43 == false) goto L192;
        float r47 = r44;
    L193:
        if (r40 == false) goto L195;
        float r48 = r44;
    L196:
        if (r42 == false) goto L198;
        float r49 = r44;
    L199:
        if (r45 == false) goto L201;
        float r116 = r44;
    L203:
        if (r46.f7929c != null) goto L205;
        r46.f7929c = new float[8];
    L205:
        float[] r50 = r46.f7929c;
        r50[1] = r47;
        r50[0] = r47;
        r50[3] = r48;
        r50[2] = r48;
        r50[5] = r49;
        r50[4] = r49;
        r50[7] = r116;
        r50[6] = r116;
        goto L206
    L201:
        r116 = 0.0f;
        goto L203
    L198:
        r49 = 0.0f;
        goto L199
    L195:
        r48 = 0.0f;
        goto L196
    L192:
        r47 = 0.0f;
    L206:
        FrescoSystrace.a().getClass();
        return r5;
    L163:
        r42 = r41;
        r43 = r39;
        r44 = r114;
        r45 = false;
    L159:
        r41 = false;
    L155:
        r40 = false;
    L151:
        r39 = false;
        goto L152
    L164:
        if (r14 == false) goto L167;
        if (r15 == false) goto L167;
        r39 = true;
    L168:
        if (r16 == false) goto L171;
        if (r17 == false) goto L171;
        r40 = true;
    L172:
        if (r110 == false) goto L175;
        if (r111 == false) goto L175;
        r41 = true;
    L176:
        if (r112 == false) goto L163;
        if (r113 == false) goto L163;
    L175:
        r41 = false;
    L171:
        r40 = false;
    L167:
        r39 = false;
    L10:
        th = move-exception;
        r10.recycle();
        r18.getResources().getConfiguration().getLayoutDirection();
        throw th;
    L183:
        r40 = true;
        r43 = true;
        r42 = true;
        r45 = true;
        r12 = 0;
        r44 = 0;
        goto L185
    }

    public static ScalingUtils.AbstractScaleType a(TypedArray r5, int r10) {
        switch(r5.getInt(r10, -2)) {
            case -1: goto L24;
            case 0: goto L23;
            case 1: goto L21;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L9;
            case 8: goto L7;
            default: goto L5;
        };
    L24:
        return null;
    L5:
        throw new RuntimeException("XML attribute not specified!");
    L7:
        return (ScalingUtils.AbstractScaleType) ScalingUtils.ScaleType.f7897i;
    L9:
        return (ScalingUtils.AbstractScaleType) ScalingUtils.ScaleType.f7896h;
    L11:
        return (ScalingUtils.AbstractScaleType) ScalingUtils.ScaleType.g;
    L13:
        return (ScalingUtils.AbstractScaleType) ScalingUtils.ScaleType.f;
    L15:
        return (ScalingUtils.AbstractScaleType) ScalingUtils.ScaleType.e;
    L17:
        return (ScalingUtils.AbstractScaleType) ScalingUtils.ScaleType.d;
    L19:
        return (ScalingUtils.AbstractScaleType) ScalingUtils.ScaleType.f7895c;
    L21:
        return (ScalingUtils.AbstractScaleType) ScalingUtils.ScaleType.f7894b;
    L23:
        return (ScalingUtils.AbstractScaleType) ScalingUtils.ScaleType.f7893a;
    }

    public static RoundingParams a(GenericDraweeHierarchyBuilder r5) {
        if (r5.f7926p != null) goto L6;
        r5.f7926p = new RoundingParams();
    L6:
        return r5.f7926p;
    }
}
