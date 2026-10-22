package x6a;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.Spanned;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.render.PlatformRendererContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.scroll.AndroidScrollView;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.ui.utils.BorderStyle;
import com.lynx.tasm.service.ILynxTextService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import z6a.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements Drawable.Callback {
    public b a;
    public final com.lynx.tasm.behavior.shadow.text.d b;
    public final Paint c;
    public final Path d;
    public final Path e;
    public final RectF f;
    public final float[] g;
    public final int[] h;
    public final BorderStyle[] i;
    public final PointF j;
    public final PointF k;
    public int[] l;
    public float[] m;
    public BlurMaskFilter n;
    public float o;
    public final PlatformRendererContext p;
    public int q;
    public int r;
    public int s;
    public int t;
    public final WeakReference<e> u;
    public final ArrayList<j> v;

    public static final class a {
        public final j a;
        public final j b;

        public a(j r1, j r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r1, Runnable r2, long r3) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r1, Runnable r2) {
    }

    public final e f() {
        return this.u.get();
    }

    public final float h() {
        float[] r0 = this.a.c;
        if (r0 == null) goto L8;
        int r1 = this.s;
        if (r1 >= r0.length) goto L10;
        this.s = r1 + 1;
        return r0[r1];
    L10:
        return 0.0f;
    L8:
        return 0.0f;
    }

    public final int i() {
        int[] r0 = this.a.b;
        if (r0 == null) goto L8;
        int r1 = this.r;
        if (r1 >= r0.length) goto L10;
        this.r = r1 + 1;
        return r0[r1];
    L10:
        return 0;
    L8:
        return 0;
    }

    public final boolean l() {
        e r0 = f();
        if (this.t != 1) goto L10;
        if (r0 == null) goto L10;
        if (r0.getRendererHostWidth() <= 0) goto L10;
        if (r0.getRendererHostHeight() <= 0) goto L10;
        return true;
    L10:
        return false;
    }

    public final void c(Canvas r115) {
        c r0 = this;
        b r1 = r0.a;
        if (r1 != null) goto L5;
        return;
    L5:
        int[] r2 = r1.a;
        if (r2 == null) goto L508;
        int[] r3 = r1.b;
        if (r3 == null) goto L508;
        float[] r4 = r1.c;
        int r5 = r2.length;
        int r6 = r3.length;
        Canvas r7 = r115;
        c r8 = r0;
    L11:
        int r9 = r8.q;
        if (r9 >= r5) goto L508;
        int r10 = r8.r;
        int r11 = r10 + 1;
        if (r11 >= r6) goto L508;
        r8.q = r9 + 1;
        int r12 = r2[r9];
        int r13 = r3[r10];
        int r14 = r11 + 1;
        r8.r = r14;
        int r15 = r3[r11];
        if (r13 < 0) goto L506;
        if (r15 < 0) goto L506;
        int r16 = r14 + r13;
        int r17 = r8.s + r15;
        switch(r12) {
            case 0: goto L499;
            case 1: goto L496;
            case 2: goto L490;
            case 3: goto L489;
            case 4: goto L22;
            case 5: goto L22;
            case 6: goto L459;
            case 7: goto L435;
            case 8: goto L22;
            case 9: goto L231;
            case 10: goto L217;
            case 11: goto L212;
            case 12: goto L137;
            case 13: goto L89;
            case 14: goto L24;
            default: goto L22;
        };
    L22:
        int[] r31 = r2;
        r5 = r5;
        r17 = r17;
    L23:
        c r18 = r0;
    L505:
        r8.r = r16;
        r8.s = r17;
        r0 = r18;
        r3 = r3;
        r6 = r6;
        r4 = r4;
        r2 = r31;
        r5 = r5;
        goto L11
    L24:
        if (r13 < 5) goto L87;
        int r19 = i();
        int r20 = i();
        int r110 = i();
        int r111 = i();
        int r112 = i();
        d7a.f r21 = r8.p.e(r19);
        if (r21 != null) goto L28;
    L27:
        r31 = r2;
        r5 = r5;
    L88:
        r17 = r17;
        goto L23
    L28:
        j r22 = r8.e(r20);
        if (r22 == null) goto L27;
        j r113 = r8.e(r110);
        if (r113 == null) goto L27;
        RectF r23 = r22.a;
        float r29 = r23.width();
        float r30 = r23.height();
        if (r29 <= 0.0f) goto L27;
        if (r30 <= 0.0f) goto L27;
        RectF r114 = r113.a;
        r115.save();
        r31 = r2;
        if (r113.c == false) goto L42;
        r8.d.reset();
        r8.d.addRoundRect(r114, r113.b, Path.Direction.CW);
        r7.clipPath(r8.d);
    L43:
        e r24 = f();
        if (r24 == null) goto L46;
        View r25 = r24.getView();
    L47:
        r21.V = r25;
        r21.y(null);
        if (r111 != 0) goto L50;
    L53:
        boolean r26 = true;
    L54:
        if (r112 != 0) goto L56;
    L59:
        boolean r27 = true;
    L60:
        if (r26 == true) goto L63;
        if (r27 == true) goto L63;
        b(r115, r21, r23.left, r23.top, r29, r30);
        r115.restore();
    L63:
        float r28 = r23.left;
        float r32 = r23.top;
        if (r26 == false) goto L69;
        float r116 = r114.left;
        if (r28 <= r116) goto L69;
        r28 = r28 - (((int) Math.ceil((r28 - r116) / r29)) * r29);
    L69:
        if (r27 == false) goto L73;
        float r117 = r114.top;
        if (r32 <= r117) goto L73;
        r32 = r32 - (((int) Math.ceil((r32 - r117) / r30)) * r30);
    L73:
        float r33 = Math.round(r28);
        float r34 = Math.round(r32);
        float r118 = Math.max(1, Math.round(r29));
        float r119 = Math.max(1, Math.round(r30));
    L75:
        if (r33 >= r114.right) goto L86;
        float r120 = r34;
    L78:
        if (r120 >= r114.bottom) goto L83;
        b(r115, r21, r33, r120, r118, r119);
        if (r27 == false) goto L83;
        r120 = r120 + r119;
    L83:
        if (r26 == false) goto L86;
        r33 = r33 + r118;
    L86:
        r115.restore();
        goto L23
    L56:
        if (r112 == 3) goto L59;
        r27 = false;
        goto L60
    L50:
        if (r111 == 2) goto L53;
        r26 = false;
        goto L54
    L46:
        r25 = null;
        goto L47
    L42:
        r7.clipRect(r114);
        goto L43
    L87:
        r31 = r2;
        r5 = r5;
        goto L88
    L89:
        r31 = r2;
        r5 = r5;
        r17 = r17;
        if (r13 < 4) goto L23;
        if (r15 < 1) goto L23;
        int r35 = i();
        int r36 = i();
        int r37 = i();
        int r38 = i();
        float r121 = h();
        j r39 = r8.g(r35);
        if (r39 == null) goto L23;
        r8.c.reset();
        r8.c.setAntiAlias(true);
        r8.c.setColor(r37);
        if (r121 > 0.5f) goto L99;
    L102:
        r8.d.reset();
        RectF r40 = r39.a;
        if (r39.c == false) goto L105;
        r8.d.addRoundRect(r40, r39.b, Path.Direction.CW);
    L107:
        if (r38 != 1) goto L123;
        j r41 = r8.e(r36);
        if (r41 == null) goto L135;
        int r42 = r115.save();
        r8.e.reset();
        RectF r122 = r41.a;
        if (r41.c == false) goto L113;
        r8.e.addRoundRect(r122, r41.b, Path.Direction.CW);
    L115:
        if (Build.VERSION.SDK_INT < 26) goto L117;
        r7.clipPath(r8.e);
    L118:
        r8.e.reset();
        r8.e.setFillType(Path.FillType.EVEN_ODD);
        float r43 = Math.max(r121, 1.0f) + 100.0f;
        r8.e.addRect(r122.left - r43, r122.top - r43, r122.right + r43, r122.bottom + r43, Path.Direction.CW);
        if (r39.c == false) goto L121;
        r8.e.addRoundRect(r40, r39.b, Path.Direction.CCW);
    L122:
        r7.drawPath(r8.e, r8.c);
        r7.restoreToCount(r42);
        goto L135
    L121:
        r8.e.addRect(r40, Path.Direction.CCW);
        goto L122
    L117:
        r7.clipPath(r8.e, Region.Op.INTERSECT);
        goto L118
    L113:
        r8.e.addRect(r122, Path.Direction.CW);
    L135:
        r8.c.setMaskFilter(null);
        goto L23
    L123:
        j r44 = r8.e(r36);
        if (r44 == null) goto L134;
        int r45 = r115.save();
        r8.e.reset();
        RectF r46 = r44.a;
        if (r44.c == false) goto L128;
        r8.e.addRoundRect(r46, r44.b, Path.Direction.CW);
    L130:
        if (Build.VERSION.SDK_INT < 26) goto L132;
        r7.clipOutPath(r8.e);
    L133:
        r7.drawPath(r8.d, r8.c);
        r7.restoreToCount(r45);
        goto L135
    L132:
        r7.clipPath(r8.e, Region.Op.DIFFERENCE);
        goto L133
    L128:
        r8.e.addRect(r46, Path.Direction.CW);
        goto L130
    L134:
        r7.drawPath(r8.d, r8.c);
        goto L135
    L105:
        r8.d.addRect(r40, Path.Direction.CW);
        goto L107
    L99:
        if (r121 == r8.o) goto L101;
        r8.n = new BlurMaskFilter(r121, BlurMaskFilter.Blur.NORMAL);
        r8.o = r121;
    L101:
        r8.c.setMaskFilter(r8.n);
        goto L102
    L137:
        r31 = r2;
        r5 = r5;
        r17 = r17;
        int r47 = i();
        int[] r48 = r8.l;
        if (r48 != null) goto L140;
    L141:
        r8.l = new int[r47];
    L142:
        int[] r49 = r8.l;
        System.arraycopy(r3, r8.r, r49, 0, r47);
        r8.r += r47;
        int r50 = i();
        int r51 = i();
        int r52 = i();
        int r123 = i();
        int r124 = i();
        float r125 = h();
        if (r50 <= 0) goto L150;
        float[] r126 = r8.m;
        if (r126 != null) goto L147;
    L148:
        r8.m = new float[r50];
    L149:
        float[] r127 = r8.m;
        System.arraycopy(r4, r8.s, r127, 0, r50);
        r8.s += r50;
        float[] r410 = r127;
    L151:
        if (r49 == null) goto L158;
        j r53 = r8.e(r51);
        if (r53 == null) goto L158;
        j r54 = r8.e(r52);
        if (r54 == null) goto L158;
        RectF r55 = r53.a;
        float r56 = r55.width();
        float r57 = r55.height();
        float r128 = r55.left;
        float r58 = r55.top;
        PointF r129 = r8.j;
        r129.set(r56 / 2.0f, r57 / 2.0f);
        float[] r59 = r4;
        double r60 = Math.toRadians(r125);
        float r130 = (float) Math.sin(r60);
        float r131 = (float) Math.cos(r60);
        float r61 = (float) Math.tan(r60);
        PointF r62 = r8.k;
        if (r130 >= 0.0f) goto L162;
    L164:
        if (r130 < 0.0f) goto L169;
        if (r131 >= 0.0f) goto L169;
        r62.set(r56, r57);
    L174:
        float r132 = r129.y;
        float[] r210 = r59;
        float r63 = r132 - r62.y;
        float r133 = r129.x;
        float r64 = (r63 - (r61 * r133)) + (r62.x * r61);
        float r310 = ((r130 * r64) / ((r130 * r61) + r131)) + r133;
        float r311 = r132 - (r64 / ((r61 * r61) + 1.0f));
        r8.c.reset();
        r8.c.setAntiAlias(true);
        r8.c.setShader(new LinearGradient((r133 * 2.0f) - r310, (r132 * 2.0f) - r311, r310, r311, r49, r410, Shader.TileMode.CLAMP));
        RectF r65 = r54.a;
        float r66 = r65.left;
        float r67 = r65.top;
        float r68 = r65.right;
        float r134 = r65.bottom;
        r115.save();
        if (r54.c == false) goto L177;
        r8.d.reset();
        r8.d.addRoundRect(r65, r54.b, Path.Direction.CW);
        r7.clipPath(r8.d);
    L179:
        if (r123 != 1) goto L182;
        if (r124 != 1) goto L182;
        r115.save();
        r7.translate(r128, r58);
        r115.drawRect(0.0f, 0.0f, r56, r57, r8.c);
        r115.restore();
    L210:
        r115.restore();
        r8.c.setShader(null);
    L211:
        float[] r69 = r210;
    L230:
        r18 = this;
        r4 = r69;
    L182:
        if (r123 == 0) goto L186;
        if (r123 == 2) goto L186;
    L188:
        if (r124 == 0) goto L192;
        if (r124 == 3) goto L192;
    L194:
        int r70 = r115.save();
        float r71 = Math.round(r128);
        float r72 = Math.round(r58);
        float r73 = Math.round(r56);
        float r74 = Math.round(r57);
        r7.translate(r71, r72);
    L196:
        if (r71 >= r68) goto L209;
        int r75 = r115.save();
        float r135 = r72;
    L199:
        if (r135 >= r134) goto L204;
        r115.drawRect(0.0f, 0.0f, r73, r74, r8.c);
        float r136 = 0.0f;
        r7.translate(0.0f, r74);
        int r137 = 1;
        if (r124 == 1) goto L205;
        r135 = r135 + r74;
    L205:
        r7.restoreToCount(r75);
        r7.translate(r73, r136);
        if (r123 == r137) goto L209;
        r71 = r71 + r73;
        goto L196
    L204:
        r136 = 0.0f;
        r137 = 1;
    L209:
        r7.restoreToCount(r70);
    L192:
        if (r58 <= r67) goto L194;
        r58 = r58 - (((int) Math.ceil((r58 - r67) / r57)) * r57);
    L186:
        if (r128 <= r66) goto L188;
        r128 = r128 - (((int) Math.ceil((r128 - r66) / r56)) * r56);
        goto L188
    L177:
        r7.clipRect(r65);
    L169:
        if (r130 < 0.0f) goto L171;
    L173:
        r62.set(0.0f, 0.0f);
        goto L174
    L171:
        if (r131 >= 0.0f) goto L173;
        r62.set(r128, r57);
        goto L174
    L162:
        if (r131 < 0.0f) goto L164;
        r62.set(r56, r58);
    L158:
        r210 = r4;
        goto L211
    L147:
        if (r126.length == r50) goto L149;
    L150:
        r410 = null;
        goto L151
    L140:
        if (r48.length == r47) goto L142;
    L212:
        float[] r211 = r4;
        r31 = r2;
        r3 = r3;
        r5 = r5;
        r6 = r6;
        r16 = r16;
        r17 = r17;
        float r76 = h();
        float r77 = h();
        RectF r78 = new RectF(r76, r77, h() + r76, h() + r77);
        if (r15 < 12) goto L215;
        float[] r138 = new float[8];
        r69 = r211;
        System.arraycopy(r69, r8.s, r138, 0, 8);
        r8.s += 8;
    L216:
        r8.v.add(new j(r78, r138));
        goto L230
    L215:
        r69 = r211;
        r138 = null;
        goto L216
    L217:
        r31 = r2;
        r3 = r3;
        r5 = r5;
        r6 = r6;
        r16 = r16;
        r17 = r17;
        r69 = r4;
        float r79 = h();
        float r80 = h();
        r8.f.set(r79, r80, h() + r79, h() + r80);
        RectF r81 = r8.f;
        e r82 = f();
        if ((r82 instanceof AndroidScrollView) == false) goto L221;
        r81.offset(r82.getRendererHostScrollX(), r82.getRendererHostScrollY());
    L221:
        if (l() == false) goto L227;
        if (r81.intersect(r8.d(true)) == true) goto L227;
        r81.setEmpty();
    L227:
        if (r15 < 12) goto L229;
        System.arraycopy(r69, r8.s, r8.g, 0, 8);
        r8.s += 8;
        r8.d.reset();
        r8.d.addRoundRect(r8.f, r8.g, Path.Direction.CW);
        r7.clipPath(r8.d);
        goto L230
    L229:
        r7.clipRect(r8.f);
        goto L230
    L231:
        r31 = r2;
        r3 = r3;
        r5 = r5;
        r6 = r6;
        r16 = r16;
        r17 = r17;
        float[] r83 = r4;
        if (r13 < 10) goto L434;
        r8.c.reset();
        r8.c.setAntiAlias(true);
        int r84 = i();
        int r85 = i();
        r8.h[1] = i();
        r8.h[2] = i();
        r8.h[3] = i();
        r8.h[0] = i();
        r8.i[1] = BorderStyle.parse(i());
        r8.i[2] = BorderStyle.parse(i());
        r8.i[3] = BorderStyle.parse(i());
        r8.i[0] = BorderStyle.parse(i());
        j r86 = r8.g(r84);
        j r87 = r8.g(r85);
        if (r86 == null) goto L260;
        if (r87 == null) goto L260;
        if (l() == false) goto L260;
        RectF r88 = r86.a;
        RectF r89 = r87.a;
        RectF r90 = new RectF(r88);
        e r91 = f();
        if ((r91 instanceof AndroidScrollView) == true) goto L242;
    L244:
        boolean r92 = false;
    L245:
        if (r92 == false) goto L248;
        RectF r93 = new RectF(r89);
        r8.k(r90);
        r8.k(r93);
        a r94 = new a(a(r90, r86), a(r93, r87));
    L261:
        Paint r95 = r8.c;
        j r96 = r94.a;
        j r97 = r94.b;
        int[] r98 = r8.h;
        BorderStyle[] r99 = r8.i;
        if (r96 == null) goto L433;
        if (r97 == null) goto L433;
        RectF r100 = r97.a;
        float r101 = r100.left;
        RectF r139 = r96.a;
        int[] r102 = {(int) (r101 - r139.left), (int) (r100.top - r139.top), (int) (r139.right - r100.right), (int) (r139.bottom - r100.bottom)};
        if (r96.c == false) goto L268;
    L271:
        r115.save();
        int r103 = r102[0];
        int r140 = r102[1];
        int r141 = r102[2];
        int r142 = r102[3];
        int r143 = r98[0];
        int r104 = r98[1];
        int r144 = r98[2];
        int r105 = r98[3];
        if (r103 > 0) goto L278;
        if (r140 > 0) goto L278;
        if (r141 > 0) goto L278;
        if (r142 > 0) goto L278;
        r4 = r83;
    L432:
        r115.restore();
    L456:
        r18 = this;
    L457:
        Canvas r106 = r115;
    L458:
        r7 = r106;
        r8 = r18;
    L278:
        if (r143 != r144) goto L282;
        if (r143 != r104) goto L282;
        if (r143 != r105) goto L282;
        boolean r145 = true;
    L283:
        if (r140 != r103) goto L287;
        if (r142 != r103) goto L287;
        if (r141 != r103) goto L287;
        boolean r146 = true;
    L289:
        if (r146 == false) goto L351;
        if (r145 == false) goto L351;
        r4 = r83;
        BorderStyle r107 = r99[0];
        BorderStyle r108 = r99[1];
        if (r107 != r108) goto L299;
        BorderStyle r147 = r99[2];
        if (r108 != r147) goto L299;
        if (r147 != r99[3]) goto L299;
        boolean r109 = r107.isSolidDashedOrDotted();
    L300:
        if (r109 == false) goto L352;
        BorderStyle r148 = r99[0];
        if (r148 == BorderStyle.SOLID) goto L304;
    L350:
        float r149 = r103;
        com.lynx.tasm.behavior.ui.utils.b.d(r115, r95, r148, 0, r143, r149, r149, r96, r97);
        goto L432
    L304:
        if (r96.c == false) goto L343;
        float[] r150 = r96.b;
        if (r150 == null) goto L343;
        if (r150.length != 8) goto L343;
        float r151 = r150[0];
        if (r151 > 0.0f) goto L313;
    L314:
        float r152 = r150[1];
        if (r152 > 0.0f) goto L317;
    L318:
        float r153 = r150[2];
        if (r153 > 0.0f) goto L321;
    L322:
        float r154 = r150[3];
        if (r154 > 0.0f) goto L325;
    L326:
        float r155 = r150[4];
        if (r155 > 0.0f) goto L329;
    L330:
        float r156 = r150[5];
        if (r156 > 0.0f) goto L333;
    L334:
        float r157 = r150[6];
        if (r157 > 0.0f) goto L337;
    L338:
        float r158 = r150[7];
        if (r158 <= 0.0f) goto L343;
        if (r158 > (r102[3] * 0.5f)) goto L343;
    L342:
        boolean r212 = true;
    L344:
        if (r212 == false) goto L350;
        Path r159 = new Path();
        r159.setFillType(Path.FillType.EVEN_ODD);
        r159.addRoundRect(r96.a, r96.b, Path.Direction.CW);
        if (r97.c == false) goto L348;
        r159.addRoundRect(r97.a, r97.b, Path.Direction.CCW);
    L349:
        r95.setStyle(Paint.Style.FILL);
        r95.setColor(r143);
        r95.setPathEffect(null);
        r95.setAntiAlias(true);
        r7.drawPath(r159, r95);
        goto L432
    L348:
        r159.addRect(r97.a, Path.Direction.CCW);
        goto L349
    L337:
        if (r157 <= (r102[0] * 0.5f)) goto L342;
    L333:
        if (r156 <= (r102[3] * 0.5f)) goto L342;
    L329:
        if (r155 <= (r102[2] * 0.5f)) goto L342;
    L325:
        if (r154 <= (r102[1] * 0.5f)) goto L342;
    L321:
        if (r153 <= (r102[2] * 0.5f)) goto L342;
    L317:
        if (r152 <= (r102[1] * 0.5f)) goto L342;
    L313:
        if (r151 <= (r102[0] * 0.5f)) goto L342;
    L343:
        r212 = false;
    L352:
        RectF r160 = r96.a;
        float r161 = r160.left;
        float r162 = r160.right;
        float r163 = r160.top;
        float r164 = r160.bottom;
        RectF r165 = r97.a;
        PointF r166 = new PointF(r165.left, r165.top);
        float r167 = r165.left;
        double r168 = r167;
        float r169 = r165.top;
        double r170 = r169;
        float[] r171 = r97.b;
        if (r171 == null) goto L355;
        float r312 = r171[0];
    L356:
        double r172 = r167 + (r312 * 2.0f);
        if (r171 == null) goto L359;
        float r173 = r171[1];
    L360:
        BackgroundDrawable.k(r168, r170, r172, (r173 * 2.0f) + r169, r160.left, r160.top, r168, r170, r166);
        PointF r174 = new PointF(r165.right, r165.top);
        float r175 = r165.right;
        float[] r176 = r97.b;
        if (r176 == null) goto L363;
        float r177 = r176[2];
    L364:
        double r178 = r175 - (r177 * 2.0f);
        float r179 = r165.top;
        double r180 = r179;
        PointF r411 = r166;
        double r181 = r175;
        if (r176 == null) goto L367;
        float r182 = r176[3];
    L368:
        BackgroundDrawable.k(r178, r180, r181, (r182 * 2.0f) + r179, r160.right, r160.top, r181, r180, r174);
        PointF r183 = new PointF(r165.right, r165.bottom);
        float r184 = r165.right;
        float[] r185 = r97.b;
        if (r185 == null) goto L371;
        float r186 = r185[6];
    L372:
        double r187 = r184 - (r186 * 2.0f);
        float r188 = r165.bottom;
        if (r185 == null) goto L375;
        float r189 = r185[7];
    L376:
        double r190 = r184;
        double r191 = r188;
        BackgroundDrawable.k(r187, r188 - (r189 * 2.0f), r190, r191, r160.right, r160.bottom, r190, r191, r183);
        PointF r192 = new PointF(r165.left, r165.bottom);
        float r193 = r165.left;
        double r194 = r193;
        float r195 = r165.bottom;
        float[] r196 = r97.b;
        if (r196 == null) goto L379;
        float r197 = r196[5];
    L380:
        double r198 = r195 - (r197 * 2.0f);
        if (r196 == null) goto L383;
        float r199 = r196[4];
    L384:
        double r1100 = r193 + (r199 * 2.0f);
        double r1101 = r195;
        BackgroundDrawable.k(r194, r198, r1100, r1101, r160.left, r160.bottom, r194, r1101, r192);
        if (r140 > 0) goto L387;
    L397:
        int r1102 = r141;
        int r1103 = r103;
    L398:
        if (r1102 <= 0) goto L409;
        if (r144 == 0) goto L409;
        float r200 = r174.x;
        float r201 = r174.y;
        float r202 = r183.x;
        float r203 = r183.y;
        float r204 = r1102;
        if (r146 == true) goto L407;
        int r205 = r142;
        float r206 = Math.max(r204, Math.max(r140, r205));
        if ((r206 - Math.min(r140, r205)) < 2.0f) goto L405;
        boolean r1104 = true;
    L406:
        boolean r412 = r1104;
    L408:
        r115.save();
        com.lynx.tasm.behavior.ui.utils.b.b(r115, r162, r163, r200, r201, r202, r203, r162, r164, r412, r96, r97);
        com.lynx.tasm.behavior.ui.utils.b.d(r115, r95, r99[2], 2, r144, r204, r206, r96, r97);
        r115.restore();
    L410:
        if (r205 <= 0) goto L421;
        if (r105 == 0) goto L421;
        float r207 = r192.x;
        float r208 = r192.y;
        float r209 = r183.x;
        float r213 = r183.y;
        float r214 = r205;
        if (r146 == true) goto L419;
        float r215 = Math.max(r214, Math.max(r1103, r1102));
        if ((r215 - Math.min(r1103, r1102)) < 2.0f) goto L417;
        boolean r1105 = true;
    L418:
        boolean r413 = r1105;
    L420:
        r115.save();
        com.lynx.tasm.behavior.ui.utils.b.b(r115, r161, r164, r207, r208, r209, r213, r162, r164, r413, r96, r97);
        com.lynx.tasm.behavior.ui.utils.b.d(r115, r95, r99[3], 3, r105, r214, r215, r96, r97);
        r115.restore();
        goto L421
    L417:
        r1105 = false;
        goto L418
    L419:
        r215 = r214;
        r413 = false;
    L421:
        if (r1103 <= 0) goto L432;
        if (r143 == 0) goto L432;
        PointF r216 = r411;
        float r217 = r216.x;
        float r218 = r216.y;
        float r219 = r192.x;
        float r220 = r192.y;
        float r221 = r1103;
        if (r146 == true) goto L430;
        float r222 = Math.max(r221, Math.max(r140, r205));
        if ((r222 - Math.min(r140, r205)) < 2.0f) goto L428;
        boolean r1106 = true;
    L429:
        boolean r414 = r1106;
    L431:
        r115.save();
        com.lynx.tasm.behavior.ui.utils.b.b(r115, r161, r163, r217, r218, r219, r220, r161, r164, r414, r96, r97);
        com.lynx.tasm.behavior.ui.utils.b.d(r115, r95, r99[0], 0, r143, r221, r222, r96, r97);
        r115.restore();
        goto L432
    L428:
        r1106 = false;
        goto L429
    L430:
        r222 = r221;
        r414 = false;
        goto L431
    L405:
        r1104 = false;
        goto L406
    L407:
        r205 = r142;
        r206 = r204;
        r412 = false;
    L409:
        r205 = r142;
        goto L410
    L387:
        if (Color.alpha(r104) == 0) goto L397;
        r411 = r411;
        float r223 = r411.x;
        float r224 = r411.y;
        float r225 = r174.x;
        float r226 = r174.y;
        float r1107 = r140;
        if (r146 == true) goto L395;
        r1102 = r141;
        r1103 = r103;
        float r1108 = Math.max(r1107, Math.max(r1103, r1102));
        if ((r1108 - Math.min(r1103, r1102)) < 2.0f) goto L393;
        boolean r227 = true;
    L394:
        boolean r415 = r227;
    L396:
        r115.save();
        com.lynx.tasm.behavior.ui.utils.b.b(r115, r161, r163, r223, r224, r225, r226, r162, r163, r415, r96, r97);
        com.lynx.tasm.behavior.ui.utils.b.d(r115, r95, r99[1], 1, r104, r1107, r1108, r96, r97);
        r115.restore();
        goto L398
    L393:
        r227 = false;
        goto L394
    L395:
        r1102 = r141;
        r1103 = r103;
        r1108 = r1107;
        r415 = false;
        goto L396
    L383:
        r199 = 0.0f;
        goto L384
    L379:
        r197 = 0.0f;
        goto L380
    L375:
        r189 = 0.0f;
        goto L376
    L371:
        r186 = 0.0f;
        goto L372
    L367:
        r182 = 0.0f;
        goto L368
    L363:
        r177 = 0.0f;
        goto L364
    L359:
        r173 = 0.0f;
        goto L360
    L355:
        r312 = 0.0f;
    L299:
        r109 = false;
    L351:
        r4 = r83;
    L287:
        r146 = false;
    L282:
        r145 = false;
        goto L283
    L268:
        if (r97.c == true) goto L271;
        com.lynx.tasm.behavior.ui.utils.b.c(r115, r95, r96.a(), r102, r98, r99);
    L433:
        r4 = r83;
        LLog.e("DisplayListApplier", "drawRectangularBorders failed since outBox or innerBox is null.");
        goto L456
    L248:
        if (r90.intersect(r8.d(false)) == true) goto L251;
        r90.setEmpty();
    L251:
        if (r90.equals(r88) == false) goto L253;
        r94 = new a(r86, r87);
        goto L261
    L253:
        RectF r228 = new RectF(Math.min(r90.left + Math.max(r89.left - r88.left, 0.0f), r90.right), Math.min(r90.top + Math.max(r89.top - r88.top, 0.0f), r90.bottom), Math.max(r90.right - Math.max(r88.right - r89.right, 0.0f), r90.left), Math.max(r90.bottom - Math.max(r88.bottom - r89.bottom, 0.0f), r90.top));
        float r229 = r228.right;
        float r230 = r228.left;
        if (r229 >= r230) goto L256;
        r228.right = r230;
    L256:
        float r231 = r228.bottom;
        float r232 = r228.top;
        if (r231 >= r232) goto L259;
        r228.bottom = r232;
    L259:
        r94 = new a(a(r90, r86), a(r228, r87));
        goto L261
    L242:
        if (((AndroidScrollView) r91).u == true) goto L244;
        r92 = true;
    L260:
        r94 = new a(r86, r87);
    L434:
        r4 = r83;
        goto L456
    L435:
        r4 = r4;
        r31 = r2;
        r3 = r3;
        r5 = r5;
        r6 = r6;
        r16 = r16;
        r17 = r17;
        if (r13 < 2) goto L456;
        int r233 = i();
        int r234 = i();
        r18 = this;
        d7a.f r235 = r18.p.e(r233);
        if (r235 == null) goto L457;
        if (r234 >= 0) goto L442;
    L444:
        j r236 = null;
    L445:
        if (r236 == null) goto L451;
        Rect r237 = r236.a();
        u7a.j r238 = r235.j;
        if (r238 == null) goto L451;
        if (r237.equals(r238.getBounds()) == true) goto L451;
        r235.j.setBounds(r237);
    L451:
        r235.y(r236);
        e r239 = f();
        if (r239 == null) goto L454;
        View r1109 = r239.getView();
    L455:
        r235.V = r1109;
        r106 = r115;
        r235.i(r106);
        goto L458
    L454:
        r1109 = null;
        goto L455
    L442:
        if (r234 >= r18.v.size()) goto L444;
        r236 = (j) ListProtector.get(r18.v, r234);
        goto L445
    L459:
        r4 = r4;
        r31 = r2;
        r3 = r3;
        r5 = r5;
        r6 = r6;
        r16 = r16;
        r17 = r17;
        r18 = r0;
        if (r13 < 2) goto L505;
        int r240 = i();
        i();
        LynxContext r241 = r8.p.d;
        if (r241 != null) goto L464;
    L469:
        com.lynx.tasm.behavior.shadow.text.d r242 = r8.b;
        if (r242 == null) goto L505;
        w r243 = (w) r242.b.get(r240);
        if (r243 == null) goto L505;
        if (r243.a == false) goto L483;
        Layout r244 = r243.c;
        if (r244 == null) goto L483;
        CharSequence r245 = r244.getText();
        if ((r245 instanceof Spanned) == false) goto L483;
        com.lynx.tasm.behavior.ui.text.a.i((Spanned) r245, r8);
    L483:
        Layout r246 = r243.c;
        if (r246 == null) goto L505;
        PointF r247 = r243.e;
        if (r247 == null) goto L488;
        r7.translate(r247.x, r247.y);
    L488:
        r246.draw(r7);
        goto L505
    L464:
        if (r241.isTextServiceModeOn() == false) goto L469;
        ILynxTextService.a r248 = (ILynxTextService.a) r8.p.i.get(Integer.valueOf(r240));
        if (r248 == null) goto L505;
        r248.d(r7, r8);
        goto L505
    L490:
        r4 = r4;
        r31 = r2;
        r3 = r3;
        r5 = r5;
        r6 = r6;
        r16 = r16;
        r17 = r17;
        r18 = r0;
        r8.c.reset();
        int r249 = i();
        int r250 = i();
        r8.c.setColor(r249);
        j r251 = r8.e(r250);
        if (r251 == null) goto L505;
        if (r251.c == false) goto L495;
        r8.d.reset();
        r8.d.addRoundRect(r251.a, r251.b, Path.Direction.CW);
        r7.drawPath(r8.d, r8.c);
        goto L505
    L495:
        r7.drawRect(r251.a, r8.c);
        goto L505
    L496:
        r4 = r4;
        r31 = r2;
        r3 = r3;
        r5 = r5;
        r6 = r6;
        r16 = r16;
        r17 = r17;
        r18 = r0;
        r115.restore();
        int r252 = r8.t;
        if (r252 <= 0) goto L505;
        r8.t = r252 - 1;
        goto L505
    L499:
        r4 = r4;
        r31 = r2;
        r3 = r3;
        r5 = r5;
        r6 = r6;
        r16 = r16;
        r17 = r17;
        r18 = r0;
        if (r13 < 2) goto L503;
        i();
        i();
    L503:
        if (r15 < 4) goto L505;
        float r253 = h();
        float r254 = h();
        h();
        h();
        r115.save();
        r7.translate(r253, r254);
        r8.t++;
        goto L505
    L489:
        i();
        h();
        h();
        return;
    L506:
        LLog.e("DisplayListApplier", "Invalid param count: " + r13 + ", " + r15);
        return;
    }

    public final RectF d(boolean r5) {
        e r0 = f();
        if (r0 == null) goto L5;
        if (r5 == true) goto L8;
    L10:
        float r6 = 0.0f;
        float r1 = 0.0f;
    L12:
        return new RectF(r6, r1, r0.getRendererHostWidth() + r6, r0.getRendererHostHeight() + r1);
    L8:
        if ((r0 instanceof AndroidScrollView) == false) goto L10;
        r6 = r0.getRendererHostScrollX();
        r1 = r0.getRendererHostScrollY();
        goto L12
    L5:
        return new RectF();
    }

    public final j e(int r5) {
        j r6 = g(r5);
        if (r6 != null) goto L5;
        return r6;
    L5:
        if (l() == false) goto L24;
        RectF r0 = new RectF(r6.a);
        e r1 = f();
        if ((r1 instanceof AndroidScrollView) == true) goto L10;
    L12:
        boolean r2 = false;
    L13:
        if (r2 == false) goto L16;
        k(r0);
    L19:
        if (r0.equals(r6.a) == false) goto L22;
        return r6;
    L22:
        return a(r0, r6);
    L16:
        if (r0.intersect(d(false)) == true) goto L19;
        r0.setEmpty();
        goto L19
    L10:
        if (((AndroidScrollView) r1).u == true) goto L12;
        r2 = true;
        goto L13
    L24:
        return r6;
    }

    public final j g(int r2) {
        if (r2 >= 0) goto L4;
        return null;
    L4:
        if (r2 < this.v.size()) goto L7;
        return null;
    L7:
        return (j) ListProtector.get(this.v, r2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r1) {
        e r2 = f();
        if (r2 == null) goto L6;
        r2.invalidateForRenderer();
        return;
    }

    public final void j(b r5) {
        if (r5 == null) goto L26;
        float[] r0 = r5.c;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.length < 2) goto L28;
        e r1 = f();
        if (r1 == null) goto L11;
        i r2 = r1.getRenderer();
    L13:
        if (r2 == null) goto L19;
        LynxBaseUI r3 = r2.h;
        if (r3 == null) goto L19;
        if (r3.isOverlay() == false) goto L19;
        boolean r4 = true;
    L21:
        if (r4 == false) goto L24;
        r5.c[1] = 0.0f;
        return;
    L24:
        float[] r6 = r5.c;
        r6[1] = 0.0f;
        r6[0] = 0.0f;
        return;
    L19:
        r4 = false;
        goto L21
    L11:
        r2 = null;
        goto L13
    L28:
        return;
    }

    public final void k(RectF r3) {
        e r0 = f();
        if (r0 != null) goto L5;
        return;
    L5:
        r3.offset(r0.getRendererHostScrollX(), r0.getRendererHostScrollY());
    }

    public static j a(RectF r2, j r3) {
        RectF r1 = new RectF(r2);
        float[] r4 = r3.b;
        if (r4 != null) goto L5;
        float[] r5 = null;
    L7:
        return new j(r1, r5);
    L5:
        r5 = (float[]) r4.clone();
        goto L7
    }

    public c(b r4, PlatformRendererContext r5, e r6) {
        this.d = new Path();
        this.e = new Path();
        this.f = new RectF();
        this.g = new float[8];
        this.h = new int[4];
        this.i = new BorderStyle[4];
        this.j = new PointF();
        this.k = new PointF();
        new PointF();
        new PointF();
        this.o = -1.0f;
        ArrayList<j> r0 = new ArrayList();
        this.v = r0;
        this.a = r4;
        Paint r1 = new Paint();
        this.c = r1;
        r1.setAntiAlias(true);
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        r0.clear();
        this.b = r5.j;
        this.p = r5;
        this.u = new WeakReference(r6);
        j(r4);
    }

    public static void b(Canvas r3, d7a.f r4, float r5, float r6, float r7, float r8) {
        Rect r0 = new Rect(Math.round(r5), Math.round(r6), Math.round(r5 + r7), Math.round(r6 + r8));
        u7a.j r9 = r4.j;
        if (r9 != null) goto L5;
    L7:
        r4.i(r3);
        return;
    L5:
        if (r0.equals(r9.getBounds()) == true) goto L7;
        r4.j.setBounds(r0);
        goto L7
    }
}
