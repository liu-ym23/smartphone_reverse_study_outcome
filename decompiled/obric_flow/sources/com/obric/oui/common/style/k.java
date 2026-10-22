package com.obric.oui.common.style;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.common.oui.R$attr;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$styleable;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f12509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f12510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f12511c;

    static {
        new r9.c();
    }

    public k(Context r10, AttributeSet r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.f12509a = new i(r10, r11, r12, r13);
        g r5 = new g();
        r5.f12456b = true;
        r5.f12457c = false;
        r5.d = true;
        r5.e = false;
        r5.f = 0;
        r5.g = -1;
        r5.f12458h = 0.3f;
        r5.f12467q = Token$Duration.OUI_ANIMATION_DURATION_SHORT_4.getDuration();
        r5.f12468r = 0;
        r5.f12459i = r10;
        r5.f12460j = r11;
        r5.f12461k = r12;
        r5.f12462l = r13;
        this.f12510b = r5;
    }

    public final h a() {
        h r5 = this.f12511c;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mOUIEffectHelper");
        return null;
    L6:
        return r5;
    }

    public final void b(View r25) {
        Intrinsics.checkNotNullParameter(r25, "owner");
        i r5 = this.f12509a;
        r5.getClass();
        r5.O = new WeakReference(r25);
        int r10 = R$color.oui_line_2;
        Context r11 = r5.f12479a;
        int r12 = ContextCompat.getColor(r11, r10);
        r5.f12490i = r12;
        r5.f12495n = r12;
        int r13 = ContextCompat.getColor(r11, R$color.oui_line_2);
        r5.f12504x = r13;
        r5.s = r13;
        new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        Paint r14 = new Paint();
        r5.B = r14;
        r14.setAntiAlias(true);
        int r15 = R$attr.oui_general_shadow_alpha;
        Resources.Theme r16 = r11.getTheme();
        if (n.f12519a != null) goto L6;
        n.f12519a = new TypedValue();
    L6:
        if (r16.resolveAttribute(r15, n.f12519a, true) == true) goto L8;
        float r17 = -1.0f;
    L10:
        if (r17 <= 0.0f) goto L12;
        r5.U = r17;
    L12:
        r5.K = new RectF();
        boolean r18 = r5.f12485d0;
        int r19 = r5.f12484c0;
        int r20 = r5.f12482b0;
        AttributeSet r21 = r5.f12480a0;
        if (r18 == true) goto L19;
        if (r21 != null) goto L19;
        if (r20 != 0) goto L19;
        if (r19 != 0) goto L19;
        int r22 = 0;
        int r23 = 0;
        boolean r110 = false;
        int r111 = 0;
    L141:
        if (r23 != 0) goto L151;
        if (r110 == false) goto L151;
        int r24 = R$attr.oui_general_shadow_elevation;
        if (n.f12519a != null) goto L147;
        n.f12519a = new TypedValue();
    L147:
        if (r11.getTheme().resolveAttribute(r24, n.f12519a, true) == true) goto L149;
        int r112 = r22;
    L150:
        r23 = r112;
        goto L151
    L149:
        r112 = TypedValue.complexToDimensionPixelSize(n.f12519a.data, r11.getResources().getDisplayMetrics());
    L151:
        r5.E(r5.U, r111, r23);
        g r26 = this.f12510b;
        r26.getClass();
        r26.f12455a = new WeakReference(r25);
        r26.b(r25);
        this.f12511c = new h(r25);
        return;
    L19:
        TypedArray r27 = r11.obtainStyledAttributes(r21, R$styleable.OUILayout, r20, r19);
        int r28 = r27.getIndexCount();
        int r29 = 0;
        r23 = 0;
        r110 = false;
        r111 = 0;
    L20:
        if (r29 >= r28) goto L136;
        int r113 = r27.getIndex(r29);
        if (r113 != R$styleable.OUILayout_android_maxWidth) goto L25;
        r5.f12481b = r27.getDimensionPixelSize(r113, r5.f12481b);
    L127:
        if (r113 != R$styleable.OUILayout_oui_bottomLeft_radius) goto L130;
        r5.G = r27.getDimensionPixelSize(r113, 0);
    L130:
        if (r113 != R$styleable.OUILayout_oui_bottomRight_radius) goto L133;
        r5.H = r27.getDimensionPixelSize(r113, 0);
    L133:
        if (r113 != R$styleable.OUILayout_oui_topRight_radius) goto L135;
        r5.F = r27.getDimensionPixelSize(r113, 0);
    L135:
        r29 = r29 + 1;
        goto L20
    L25:
        if (r113 != R$styleable.OUILayout_android_maxHeight) goto L28;
        r5.f12483c = r27.getDimensionPixelSize(r113, r5.f12483c);
        goto L127
    L28:
        if (r113 != R$styleable.OUILayout_android_minWidth) goto L31;
        r5.d = r27.getDimensionPixelSize(r113, r5.d);
        goto L127
    L31:
        if (r113 != R$styleable.OUILayout_android_minHeight) goto L34;
        r5.e = r27.getDimensionPixelSize(r113, r5.e);
        goto L127
    L34:
        if (r113 != R$styleable.OUILayout_oui_topDividerColor) goto L37;
        r5.f12490i = r27.getColor(r113, r5.f12490i);
        goto L127
    L37:
        if (r113 != R$styleable.OUILayout_oui_topDividerHeight) goto L40;
        r5.f = r27.getDimensionPixelSize(r113, r5.f);
        goto L127
    L40:
        if (r113 != R$styleable.OUILayout_oui_topDividerInsetLeft) goto L43;
        r5.g = r27.getDimensionPixelSize(r113, r5.g);
        goto L127
    L43:
        if (r113 != R$styleable.OUILayout_oui_topDividerInsetRight) goto L46;
        r5.f12488h = r27.getDimensionPixelSize(r113, r5.f12488h);
        goto L127
    L46:
        if (r113 != R$styleable.OUILayout_oui_bottomDividerColor) goto L49;
        r5.f12495n = r27.getColor(r113, r5.f12495n);
        goto L127
    L49:
        if (r113 != R$styleable.OUILayout_oui_bottomDividerHeight) goto L52;
        r5.f12492k = r27.getDimensionPixelSize(r113, r5.f12492k);
        goto L127
    L52:
        if (r113 != R$styleable.OUILayout_oui_bottomDividerInsetLeft) goto L55;
        r5.f12493l = r27.getDimensionPixelSize(r113, r5.f12493l);
        goto L127
    L55:
        if (r113 != R$styleable.OUILayout_oui_bottomDividerInsetRight) goto L58;
        r5.f12494m = r27.getDimensionPixelSize(r113, r5.f12494m);
        goto L127
    L58:
        if (r113 != R$styleable.OUILayout_oui_leftDividerColor) goto L61;
        r5.s = r27.getColor(r113, r5.s);
        goto L127
    L61:
        if (r113 != R$styleable.OUILayout_oui_leftDividerWidth) goto L64;
        r5.f12497p = r27.getDimensionPixelSize(r113, r5.f12497p);
        goto L127
    L64:
        if (r113 != R$styleable.OUILayout_oui_leftDividerInsetTop) goto L67;
        r5.f12498q = r27.getDimensionPixelSize(r113, r5.f12498q);
        goto L127
    L67:
        if (r113 != R$styleable.OUILayout_oui_leftDividerInsetBottom) goto L70;
        r5.f12499r = r27.getDimensionPixelSize(r113, r5.f12499r);
        goto L127
    L70:
        if (r113 != R$styleable.OUILayout_oui_rightDividerColor) goto L73;
        r5.f12504x = r27.getColor(r113, r5.f12504x);
        goto L127
    L73:
        if (r113 != R$styleable.OUILayout_oui_rightDividerWidth) goto L76;
        r5.f12501u = r27.getDimensionPixelSize(r113, r5.f12501u);
        goto L127
    L76:
        if (r113 != R$styleable.OUILayout_oui_rightDividerInsetTop) goto L79;
        r5.f12502v = r27.getDimensionPixelSize(r113, r5.f12502v);
        goto L127
    L79:
        if (r113 != R$styleable.OUILayout_oui_rightDividerInsetBottom) goto L82;
        r5.f12503w = r27.getDimensionPixelSize(r113, r5.f12503w);
        goto L127
    L82:
        if (r113 != R$styleable.OUILayout_oui_layout_borderColor) goto L85;
        r5.L = r27.getColor(r113, r5.L);
        goto L127
    L85:
        if (r113 != R$styleable.OUILayout_oui_layout_borderWidth) goto L88;
        r5.M = r27.getDimensionPixelSize(r113, r5.M);
        goto L127
    L88:
        if (r113 != R$styleable.OUILayout_oui_radius) goto L91;
        r111 = r27.getDimensionPixelSize(r113, 0);
        goto L127
    L91:
        if (r113 != R$styleable.OUILayout_oui_outerNormalColor) goto L94;
        r5.N = r27.getColor(r113, r5.N);
        goto L127
    L94:
        if (r113 != R$styleable.OUILayout_oui_showBorderOnlyBeforeL) goto L97;
        r5.S = r27.getBoolean(r113, r5.S);
        goto L127
    L97:
        if (r113 != R$styleable.OUILayout_oui_shadowElevation) goto L100;
        r23 = r27.getDimensionPixelSize(r113, r23);
        goto L127
    L100:
        if (r113 != R$styleable.OUILayout_oui_shadowAlpha) goto L103;
        r5.U = r27.getFloat(r113, r5.U);
        goto L127
    L103:
        if (r113 != R$styleable.OUILayout_oui_useThemeGeneralShadowElevation) goto L106;
        r110 = r27.getBoolean(r113, false);
        goto L127
    L106:
        if (r113 != R$styleable.OUILayout_oui_outlineInsetLeft) goto L109;
        r5.W = r27.getDimensionPixelSize(r113, 0);
        goto L127
    L109:
        if (r113 != R$styleable.OUILayout_oui_outlineInsetRight) goto L112;
        r5.X = r27.getDimensionPixelSize(r113, 0);
        goto L127
    L112:
        if (r113 != R$styleable.OUILayout_oui_outlineInsetTop) goto L115;
        r5.Y = r27.getDimensionPixelSize(r113, 0);
        goto L127
    L115:
        if (r113 != R$styleable.OUILayout_oui_outlineInsetBottom) goto L118;
        r5.Z = r27.getDimensionPixelSize(r113, 0);
        goto L127
    L118:
        if (r113 != R$styleable.OUILayout_oui_outlineExcludePadding) goto L121;
        r5.P = r27.getBoolean(r113, false);
        goto L127
    L121:
        if (r113 != R$styleable.OUILayout_oui_support_image_mirroring) goto L124;
        r27.getBoolean(r113, false);
        goto L127
    L124:
        if (r113 != R$styleable.OUILayout_oui_topLeft_radius) goto L127;
        r5.E = r27.getDimensionPixelSize(r113, 0);
        goto L127
    L136:
        int r30 = r27.getResourceId(R$styleable.OUILayout_oui_shadow_style, 0);
        if (r30 == 0) goto L139;
        r5.a(r30, r11);
        r22 = 0;
    L140:
        r5.g0.c(r5.f12486e0);
        r5.f12489h0.c(r5.f12487f0);
        r5.i0 = r27.getDimension(R$styleable.OUILayout_oui_shadowCornerRadius, 0.0f);
        r27.recycle();
        goto L141
    L139:
        m r31 = r5.f12486e0;
        int r32 = R$styleable.OUILayout_oui_firstShadowColor;
        int r114 = R$styleable.OUILayout_oui_firstShadowBlur;
        int r115 = R$styleable.OUILayout_oui_firstOffsetX;
        int r116 = R$styleable.OUILayout_oui_firstOffsetY;
        int r33 = R$styleable.OUILayout_oui_firstShadowSpread;
        Intrinsics.checkNotNullParameter(r27, "typedArray");
        r31.d(es.c.a(new es.b(r27.getColor(r32, 0), -1, r27.getDimension(r115, 0.0f), r27.getDimension(r116, 0.0f), r27.getDimension(r114, 0.0f), r27.getDimension(r33, 0.0f))));
        m r34 = r5.f12487f0;
        int r35 = R$styleable.OUILayout_oui_secondShadowColor;
        int r36 = R$styleable.OUILayout_oui_secondShadowBlur;
        int r117 = R$styleable.OUILayout_oui_secondOffsetX;
        int r118 = R$styleable.OUILayout_oui_secondOffsetY;
        int r119 = R$styleable.OUILayout_oui_secondShadowSpread;
        Intrinsics.checkNotNullParameter(r27, "typedArray");
        float r120 = r27.getDimension(r117, 0.0f);
        float r210 = r27.getDimension(r118, 0.0f);
        float r211 = r27.getDimension(r36, 0.0f);
        r22 = 0;
        r34.d(es.c.a(new es.b(r27.getColor(r35, 0), -1, r120, r210, r211, r27.getDimension(r119, 0.0f))));
        goto L140
    L8:
        r17 = n.f12519a.getFloat();
        goto L10
    }
}
