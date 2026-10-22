package com.obric.oui.common.style;

import android.R;
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
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.shadow.ShadowTokenCore;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class o {
    public final l a;
    public final h b;
    public j c;

    public static final class a {
    }

    static {
        new ola.a();
    }

    public final j a() {
        j r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mOUIEffectHelper");
        return null;
    L6:
        return r0;
    }

    public final void b(View r20) {
        Intrinsics.checkNotNullParameter(r20, "owner");
        l r2 = this.a;
        r2.getClass();
        Resources r3 = r20.getResources();
        float r4 = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density;
        r2.O = new WeakReference(r20);
        int r5 = ContextCompat.getColor(r2.a, 2131105288);
        r2.i = r5;
        r2.n = r5;
        int r6 = ContextCompat.getColor(r2.a, 2131105288);
        r2.x = r6;
        r2.s = r6;
        new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        Paint r7 = new Paint();
        r2.B = r7;
        r7.setAntiAlias(true);
        Resources.Theme r8 = r2.a.getTheme();
        if (m.a != null) goto L6;
        m.a = new TypedValue();
    L6:
        if (r8.resolveAttribute(2130973160, m.a, true) == true) goto L8;
        float r9 = -1.0f;
    L10:
        if (r9 <= 0.0f) goto L12;
        r2.U = r9;
    L12:
        r2.K = new RectF();
        int r10 = 0;
        if (r2.V0 == false) goto L15;
    L22:
        TypedArray r11 = r2.a.obtainStyledAttributes(r2.H0, new int[]{R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, 2130973055, 2130973056, 2130973057, 2130973058, 2130973060, 2130973061, 2130973136, 2130973137, 2130973138, 2130973139, 2130973141, 2130973188, 2130973189, 2130973191, 2130973192, 2130973193, 2130973194, 2130973215, 2130973216, 2130973217, 2130973218, 2130973219, 2130973220, 2130973237, 2130973248, 2130973249, 2130973250, 2130973251, 2130973280, 2130973281, 2130973282, 2130973283, 2130973285, 2130973287, 2130973288, 2130973289, 2130973290, 2130973291, 2130973293, 2130973319, 2130973338, 2130973339, 2130973340, 2130973341, 2130973343, 2130973344, 2130973351}, r2.L0, r2.P0);
        int r12 = r11.getIndexCount();
        int r13 = 0;
        int r14 = 0;
        boolean r15 = false;
        int r18 = 0;
    L23:
        if (r13 >= r12) goto L138;
        int r16 = r11.getIndex(r13);
        if (r16 != 0) goto L27;
        r2.b = r11.getDimensionPixelSize(r16, r2.b);
    L129:
        if (r16 != 8) goto L132;
        r2.G = r11.getDimensionPixelSize(r16, 0);
    L132:
        if (r16 != 9) goto L135;
        r2.H = r11.getDimensionPixelSize(r16, 0);
    L135:
        if (r16 != 49) goto L137;
        r2.F = r11.getDimensionPixelSize(r16, 0);
    L137:
        r13 = r13 + 1;
        goto L23
    L27:
        if (r16 != 1) goto L30;
        r2.c = r11.getDimensionPixelSize(r16, r2.c);
        goto L129
    L30:
        if (r16 != 2) goto L33;
        r2.d = r11.getDimensionPixelSize(r16, r2.d);
        goto L129
    L33:
        if (r16 != 3) goto L36;
        r2.e = r11.getDimensionPixelSize(r16, r2.e);
        goto L129
    L36:
        if (r16 != 44) goto L39;
        r2.i = r11.getColor(r16, r2.i);
        goto L129
    L39:
        if (r16 != 45) goto L42;
        r2.f = r11.getDimensionPixelSize(r16, r2.f);
        goto L129
    L42:
        if (r16 != 46) goto L45;
        r2.g = r11.getDimensionPixelSize(r16, r2.g);
        goto L129
    L45:
        if (r16 != 47) goto L48;
        r2.h = r11.getDimensionPixelSize(r16, r2.h);
        goto L129
    L48:
        if (r16 != 4) goto L51;
        r2.n = r11.getColor(r16, r2.n);
        goto L129
    L51:
        if (r16 != 5) goto L54;
        r2.k = r11.getDimensionPixelSize(r16, r2.k);
        goto L129
    L54:
        if (r16 != 6) goto L57;
        r2.l = r11.getDimensionPixelSize(r16, r2.l);
        goto L129
    L57:
        if (r16 != 7) goto L60;
        r2.m = r11.getDimensionPixelSize(r16, r2.m);
        goto L129
    L60:
        if (r16 != 17) goto L63;
        r2.s = r11.getColor(r16, r2.s);
        goto L129
    L63:
        if (r16 != 20) goto L66;
        r2.p = r11.getDimensionPixelSize(r16, r2.p);
        goto L129
    L66:
        if (r16 != 19) goto L69;
        r2.q = r11.getDimensionPixelSize(r16, r2.q);
        goto L129
    L69:
        if (r16 != 18) goto L72;
        r2.r = r11.getDimensionPixelSize(r16, r2.r);
        goto L129
    L72:
        if (r16 != 28) goto L75;
        r2.x = r11.getColor(r16, r2.x);
        goto L129
    L75:
        if (r16 != 31) goto L78;
        r2.u = r11.getDimensionPixelSize(r16, r2.u);
        goto L129
    L78:
        if (r16 != 30) goto L81;
        r2.v = r11.getDimensionPixelSize(r16, r2.v);
        goto L129
    L81:
        if (r16 != 29) goto L84;
        r2.w = r11.getDimensionPixelSize(r16, r2.w);
        goto L129
    L84:
        if (r16 != 15) goto L87;
        r2.L = r11.getColor(r16, r2.L);
        goto L129
    L87:
        if (r16 != 16) goto L90;
        r2.M = r11.getDimensionPixelSize(r16, r2.M);
        goto L129
    L90:
        if (r16 != 27) goto L93;
        r18 = r11.getDimensionPixelSize(r16, 0);
        goto L129
    L93:
        if (r16 != 21) goto L96;
        r2.N = r11.getColor(r16, r2.N);
        goto L129
    L96:
        if (r16 != 42) goto L99;
        r2.S = r11.getBoolean(r16, r2.S);
        goto L129
    L99:
        if (r16 != 40) goto L102;
        r14 = r11.getDimensionPixelSize(r16, r14);
        goto L129
    L102:
        if (r16 != 38) goto L105;
        r2.U = r11.getFloat(r16, r2.U);
        goto L129
    L105:
        if (r16 != 50) goto L108;
        r15 = r11.getBoolean(r16, false);
        goto L129
    L108:
        if (r16 != 24) goto L111;
        r2.Y = r11.getDimensionPixelSize(r16, 0);
        goto L129
    L111:
        if (r16 != 25) goto L114;
        r2.Z = r11.getDimensionPixelSize(r16, 0);
        goto L129
    L114:
        if (r16 != 26) goto L117;
        r2.k0 = r11.getDimensionPixelSize(r16, 0);
        goto L129
    L117:
        if (r16 != 23) goto L120;
        r2.p0 = r11.getDimensionPixelSize(r16, 0);
        goto L129
    L120:
        if (r16 != 22) goto L123;
        r2.P = r11.getBoolean(r16, false);
        goto L129
    L123:
        if (r16 != 43) goto L126;
        r11.getBoolean(r16, false);
        goto L129
    L126:
        if (r16 != 48) goto L129;
        r2.E = r11.getDimensionPixelSize(r16, 0);
        goto L129
    L138:
        com.obric.oui.shadow.b[] r17 = ShadowTokenCore.parse(r11.getString(37));
        if (r17 == null) goto L143;
        r2.b1.d(r17[0], r4);
        if (r17.length <= 1) goto L147;
        r2.g1.d(r17[1], r4);
    L147:
        r2.h1.update(r2.b1);
        r2.k1.update(r2.g1);
        r2.p1 = r11.getDimension(39, 0.0f);
        r11.recycle();
        int r19 = r18;
    L148:
        if (r14 != 0) goto L158;
        if (r15 == false) goto L158;
        Context r21 = r2.a;
        if (m.a != null) goto L154;
        m.a = new TypedValue();
    L154:
        if (r21.getTheme().resolveAttribute(2130973161, m.a, true) == false) goto L157;
        int r22 = m.a.data;
        Resources r23 = r21.getResources();
        r10 = TypedValue.complexToDimensionPixelSize(r22, WindowDisplayMetricsOverride.apply(r23, r23.getDisplayMetrics()));
    L157:
        r14 = r10;
    L158:
        r2.y(r19, r14, r2.U);
        h r24 = this.b;
        r24.getClass();
        r24.a = new WeakReference(r20);
        r24.c(r20);
        this.c = new j(r20);
        return;
    L143:
        int r25 = r11.getResourceId(41, 0);
        if (r25 == 0) goto L146;
        r2.a(r2.a, r25);
        goto L147
    L146:
        q r26 = r2.b1;
        int r27 = com.obric.oui.shadow.a.g;
        r26.c(com.obric.oui.shadow.a.a.a(r11, 13, 12, 10, 11, 14));
        r2.g1.c(com.obric.oui.shadow.a.a.a(r11, 35, 34, 32, 33, 36));
        goto L147
    L15:
        if (r2.H0 != null) goto L22;
        if (r2.L0 != 0) goto L22;
        if (r2.P0 != 0) goto L22;
        r19 = 0;
        r14 = 0;
        r15 = false;
        goto L148
    L8:
        r9 = m.a.getFloat();
        goto L10
    }

    public o(Context r2, AttributeSet r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = new l(r2, r3, r4, r5);
        this.b = new h(r2, r3, r4, r5);
    }
}
