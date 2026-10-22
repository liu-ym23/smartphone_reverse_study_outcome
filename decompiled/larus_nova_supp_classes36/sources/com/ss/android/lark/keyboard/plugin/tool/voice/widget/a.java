package com.ss.android.lark.keyboard.plugin.tool.voice.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import vob.c;
import vob.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends LinearLayout {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final Paint e;
    public final RectF f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final int j;
    public final int k;
    public final int l;
    public final float m;
    public final Paint n;
    public final int o;
    public final Paint p;
    public final float q;
    public final C0165a r;
    public final boolean s;
    public int t;
    public int u;
    public float v;
    public c w;
    public SmartTabLayout.f x;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.widget.a$a, reason: collision with other inner class name */
    public static class C0165a implements SmartTabLayout.f {
        public int[] a;
        public int[] b;

        public C0165a() {
        }
    }

    public final void a(Canvas r19) {
        int r8 = getHeight();
        int r9 = getWidth();
        int r10 = getChildCount();
        Object r1 = this.x;
        if (r1 != null) goto L6;
        r1 = this.r;
    L6:
        Object r11 = r1;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L9;
        boolean r14 = true;
    L11:
        if (this.i == false) goto L21;
        if (this.a <= 0) goto L17;
        this.e.setColor(this.b);
        r19.drawRect(0, 0.0f, r9, this.a, this.e);
    L17:
        if (this.c <= 0) goto L21;
        this.e.setColor(this.d);
        r19.drawRect(0, r8 - this.c, r9, r8, this.e);
    L21:
        if (r10 <= 0) goto L60;
        View r2 = getChildAt(this.u);
        int r3 = d.d(r2, this.g);
        int r4 = d.a(r2, this.g);
        if (r14 == false) goto L25;
        r3 = r4;
        r4 = r3;
    L25:
        int r5 = this.u;
        C0165a r12 = (C0165a) r11;
        int[] r13 = r12.a;
        int r15 = r13[r5 % r13.length];
        float r16 = this.j;
        if (this.v > 0.0f) goto L28;
    L37:
        float r17 = 1.0f;
    L38:
        int r6 = this.j;
        if (r6 <= 0) goto L62;
        if (this.k == 0) goto L62;
        int r7 = this.l;
        if (r7 != 1) goto L46;
        float r18 = r6;
    L50:
        float r20 = r18 / 2.0f;
    L51:
        float r110 = r16 / 2.0f;
        float r21 = r20 - r110;
        float r22 = r20 + r110;
        this.n.setColor(r15);
        if (this.k != (-1)) goto L54;
        this.f.set(r3, r21, r4, r22);
    L55:
        float r23 = this.m;
        if (r23 <= 0.0f) goto L58;
        r19.drawRoundRect(this.f, r23, r23, this.n);
        goto L62
    L58:
        r19.drawRect(this.f, this.n);
        goto L62
    L54:
        float r24 = (Math.abs(r3 - r4) - this.k) / 2.0f;
        this.f.set(r3 + r24, r21, r4 - r24, r22);
        goto L55
    L46:
        if (r7 == 2) goto L48;
        r20 = r8 - (r6 / 2.0f);
        goto L51
    L48:
        r18 = r8;
    L62:
        if (this.i == false) goto L64;
        float r111 = 0.0f;
    L73:
        if (this.o <= 0) goto L91;
        int r25 = (int) (Math.min(Math.max(r111, this.q), r17) * r8);
        Object r26 = this.x;
        if (r26 != null) goto L79;
        r26 = this.r;
    L79:
        Object r27 = r26;
        int r28 = (r8 - r25) / 2;
        int r112 = r25 + r28;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L82;
        boolean r113 = true;
    L83:
        int r114 = 0;
    L85:
        if (r114 >= (r10 - 1)) goto L95;
        View r29 = getChildAt(r114);
        int r30 = d.a(r29, false);
        int r31 = d.b(r29);
        if (r113 == false) goto L89;
        int r32 = r30 - r31;
    L90:
        Paint r33 = this.p;
        int[] r34 = ((C0165a) r27).b;
        r33.setColor(r34[r114 % r34.length]);
        float r35 = r32;
        r19.drawLine(r35, r28, r35, r112, this.p);
        r114 = r114 + 1;
        goto L85
    L89:
        r32 = r30 + r31;
        goto L90
    L95:
        return;
    L82:
        r113 = false;
        goto L83
    L91:
        return;
    L64:
        if (this.a > 0) goto L66;
        r111 = 0.0f;
    L67:
        int r36 = getWidth();
        if (this.c <= 0) goto L73;
        this.e.setColor(this.d);
        r19.drawRect(0, r8 - this.c, r36, r8, this.e);
        goto L73
    L66:
        this.e.setColor(this.b);
        r111 = 0.0f;
        r19.drawRect(0, 0.0f, r9, this.a, this.e);
        goto L67
    L28:
        if (r5 >= (getChildCount() - 1)) goto L37;
        int r37 = this.u + 1;
        int[] r38 = r12.a;
        int r39 = r38[r37 % r38.length];
        if (r15 == r39) goto L32;
        float r40 = this.v;
        float r115 = 1.0f - r40;
        r15 = Color.rgb((int) ((Color.red(r39) * r40) + (Color.red(r15) * r115)), (int) ((Color.green(r39) * r40) + (Color.green(r15) * r115)), (int) ((Color.blue(r39) * r40) + (Color.blue(r15) * r115)));
    L32:
        float r41 = this.w.a(this.v);
        float r42 = this.w.b(this.v);
        float r43 = this.w.c(this.v);
        View r44 = getChildAt(this.u + 1);
        int r116 = d.d(r44, this.g);
        int r45 = d.a(r44, this.g);
        if (r14 == false) goto L35;
        r17 = 1.0f;
        r3 = (int) ((r45 * r42) + ((1.0f - r42) * r3));
        r4 = (int) ((r116 * r41) + ((1.0f - r41) * r4));
    L36:
        r16 = r16 * r43;
        goto L38
    L35:
        r17 = 1.0f;
        r3 = (int) ((r116 * r41) + ((1.0f - r41) * r3));
        r4 = (int) ((r45 * r42) + ((1.0f - r42) * r4));
        goto L36
    L60:
        r17 = 1.0f;
        goto L62
    L9:
        r14 = false;
        goto L11
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r2) {
        super.dispatchDraw(r2);
        if (this.s == false) goto L6;
        a(r2);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r2) {
        if (this.s == true) goto L6;
        a(r2);
        return;
    }

    public a(Context r20, AttributeSet r21) {
        super(r20);
        this.f = new RectF();
        setWillNotDraw(false);
        Resources r2 = getResources();
        float r3 = WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).density;
        TypedValue r4 = new TypedValue();
        r20.getTheme().resolveAttribute(R.attr.colorForeground, r4, true);
        int r5 = r4.data;
        float r6 = 0.0f * r3;
        int r8 = b(r5, (byte) 38);
        int r9 = (int) r6;
        int r7 = b(r5, (byte) 38);
        int r10 = b(r5, (byte) 32);
        TypedArray r11 = r20.obtainStyledAttributes(r21, new int[]{2130974279, 2130974280, 2130974281, 2130974282, 2130974283, 2130974284, 2130974285, 2130974286, 2130974287, 2130974288, 2130974289, 2130974290, 2130974291, 2130974292, 2130974293, 2130974294, 2130974295, 2130974296, 2130974297, 2130974298, 2130974299, 2130974300, 2130974301, 2130974302, 2130974303, 2130974304, 2130974305, 2130974306, 2130974307});
        boolean r12 = r11.getBoolean(14, false);
        boolean r13 = r11.getBoolean(23, false);
        boolean r14 = r11.getBoolean(19, false);
        int r15 = r11.getInt(20, 0);
        int r16 = r11.getInt(18, 0);
        int r1 = r11.getColor(15, -13388315);
        int r17 = r11.getResourceId(16, -1);
        int r18 = r11.getDimensionPixelSize(21, (int) (8.0f * r3));
        int r19 = r11.getLayoutDimension(22, -1);
        float r22 = r11.getDimension(17, r6);
        int r23 = r11.getColor(24, r8);
        int r24 = r11.getDimensionPixelSize(25, r9);
        int r25 = r11.getColor(27, r7);
        int r26 = r11.getDimensionPixelSize(28, (int) (2.0f * r3));
        int r27 = r11.getColor(10, r10);
        int r110 = r11.getResourceId(11, -1);
        int r28 = r11.getDimensionPixelSize(12, (int) (r3 * 1.0f));
        boolean r29 = r11.getBoolean(13, false);
        r11.recycle();
        if (r17 != (-1)) goto L5;
        int r111 = 1;
        int[] r112 = {r1};
    L7:
        if (r110 != (-1)) goto L9;
        int[] r30 = new int[r111];
        r30[0] = r27;
    L10:
        C0165a r31 = new C0165a();
        this.r = r31;
        r31.a = r112;
        r31.b = r30;
        this.a = r24;
        this.b = r23;
        this.c = r26;
        this.d = r25;
        this.e = new Paint(1);
        this.h = r12;
        this.g = r13;
        this.i = r14;
        this.j = r18;
        this.k = r19;
        this.n = new Paint(1);
        this.m = r22;
        this.l = r16;
        this.q = 0.5f;
        Paint r32 = new Paint(1);
        this.p = r32;
        r32.setStrokeWidth(r28);
        this.o = r28;
        this.s = r29;
        if (r15 != 0) goto L13;
        c r33 = c.a;
    L18:
        this.w = r33;
        return;
    L13:
        if (r15 != 1) goto L15;
        r33 = c.b;
        goto L18
    L15:
        c.b r34 = c.a;
        throw new IllegalArgumentException("Unknown id: " + r15);
    L9:
        r30 = getResources().getIntArray(r110);
        goto L10
    L5:
        r111 = 1;
        r112 = getResources().getIntArray(r17);
        goto L7
    }

    public static int b(int r2, byte r3) {
        return Color.argb(r3, Color.red(r2), Color.green(r2), Color.blue(r2));
    }
}
