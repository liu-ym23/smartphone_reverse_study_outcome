package com.lynx.tasm.behavior.ui.utils;

import ai.j0;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import androidx.annotation.Keep;
import androidx.core.view.ViewCompat;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.b0;
import com.lynx.tasm.behavior.ui.c0;
import com.lynx.tasm.behavior.ui.d0;
import com.lynx.tasm.u0;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class BackgroundDrawable extends f {
    public com.lynx.component.svg.parser.d A;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10708h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public l f10709i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public l f10710j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BorderStyle[] f10711k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public DashPathEffect f10712l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public a f10713m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public a f10714n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public HashMap f10715o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Path f10716p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Path f10717q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public PointF f10718r;
    public PointF s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public PointF f10719t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public PointF f10720u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f10721v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Paint f10722w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f10723x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f10724y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public d f10725z;

    public static final enum BorderRadiusLocation extends Enum<BorderRadiusLocation> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BorderRadiusLocation[] f10726a = null;

        static {
            f10726a = new BorderRadiusLocation[]{new BorderRadiusLocation("TOP_LEFT", 0), new BorderRadiusLocation("TOP_RIGHT", 1), new BorderRadiusLocation("BOTTOM_RIGHT", 2), new BorderRadiusLocation("BOTTOM_LEFT", 3), new BorderRadiusLocation("TOP_START", 4), new BorderRadiusLocation("TOP_END", 5), new BorderRadiusLocation("BOTTOM_START", 6), new BorderRadiusLocation("BOTTOM_END", 7)};
        }

        public BorderRadiusLocation(String r5, int r10) {
            super(r5, r10);
        }

        public static BorderRadiusLocation valueOf(String r5) {
            return (BorderRadiusLocation) Enum.valueOf(BorderRadiusLocation.class, r5);
        }

        public static BorderRadiusLocation[] values() {
            return (BorderRadiusLocation[]) f10726a.clone();
        }
    }

    public BackgroundDrawable(LynxContext r5, float r10) {
        super(r5);
        this.g = false;
        this.f10708h = false;
        this.f10721v = true;
        this.f10722w = new Paint(1);
        this.f10723x = 0;
        this.f10724y = 255;
    }

    public static int f(float r5) {
        if (r5 <= 0.1f) goto L9;
        if (r5 >= 1.0f) goto L9;
        return 1;
    L9:
        return Math.round(r5);
    }

    public static void h(double r21, double r23, double r25, double r27, double r29, double r31, double r33, double r35, PointF r37) {
        double r5 = (r21 + r25) / 2.0d;
        double r10 = (r23 + r27) / 2.0d;
        double r11 = r29 - r5;
        double r12 = r31 - r10;
        double r15 = Math.abs(r25 - r21) / 2.0d;
        double r17 = Math.abs(r27 - r23) / 2.0d;
        double r13 = ((r35 - r10) - r12) / ((r33 - r5) - r11);
        double r14 = r12 - (r11 * r13);
        double r18 = r17 * r17;
        double r16 = r15 * r15;
        double r19 = j0.B(r16, r13, r13, r18);
        double r20 = (((r15 * 2.0d) * r15) * r14) * r13;
        double r22 = (-(r16 * ((r14 * r14) - r18))) / r19;
        double r110 = r19 * 2.0d;
        double r24 = (-r20) / r110;
        double r26 = r24 - Math.sqrt(Math.pow(r20 / r110, 2.0d) + r22);
        double r111 = (r13 * r26) + r14;
        double r28 = r26 + r5;
        double r112 = r111 + r10;
        if (Double.isNaN(r28) == false) goto L5;
        return;
    L5:
        if (Double.isNaN(r112) == true) goto L9;
        r37.x = (float) r28;
        r37.y = (float) r112;
        return;
    }

    public static boolean m(BorderStyle r5) {
        if (r5 != BorderStyle.f10731b) goto L5;
        return true;
    L5:
        if (r5 != BorderStyle.f10732c) goto L7;
        return true;
    L7:
        if (r5 == BorderStyle.g) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.utils.f
    public final an.j a() {
        return new an.d(this.f, this);
    }

    @Override // com.lynx.tasm.behavior.ui.utils.f
    public final void b(int r5, float r10) {
        if (this.f10746a.b(r10, r5) == false) goto L6;
        this.f10721v = true;
        this.f10708h = true;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.utils.f
    public final boolean c(float r5, float r10, float r11, float r12) {
        boolean r13 = super.c(r5, r10, r11, r12);
        if (r13 == false) goto L5;
        this.f10721v = true;
        this.g = true;
    L5:
        return r13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v56, types: [int] */
    /* JADX WARN: Type inference failed for: r1v31, types: [int] */
    /* JADX WARN: Type inference failed for: r1v72 */
    /* JADX WARN: Type inference failed for: r1v73 */
    /* JADX WARN: Type inference failed for: r1v92 */
    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r40) {
        BackgroundDrawable r11 = this;
        if (r11.g == false) goto L5;
    L6:
        e();
        r11.f10708h = false;
        r11.g = false;
    L7:
        int r5 = e.a(r11.f10723x, r11.f10724y);
        int r10 = Color.alpha(r5);
        Paint r12 = r11.f10722w;
        Rect r13 = r11.f10748c;
        Rect r14 = r11.d;
        an.j r15 = r11.e;
        if (r10 == 0) goto L52;
        r12.setColor(r5);
        r12.setStyle(Paint.Style.FILL);
        d r16 = r11.f10725z;
        if (r16 != null) goto L12;
    L43:
        an.d r17 = (an.d) r15;
        if (r17.d.isEmpty() == false) goto L46;
        int r18 = 1;
    L47:
        if (r18 != 1) goto L49;
        r40.drawRect(getBounds(), r12);
        goto L52
    L49:
        if (r18 != 0) goto L51;
        r40.drawRect(r13, r12);
        goto L52
    L51:
        r40.drawRect(r14, r12);
        goto L52
    L46:
        r18 = ((Integer) androidx.constraintlayout.motion.widget.a.h(r17.d, 1)).intValue();
        goto L47
    L12:
        if (r16.d() == false) goto L43;
        if (r() == false) goto L52;
        an.d r19 = (an.d) r15;
        if (r19.d.isEmpty() == false) goto L19;
        int r20 = 1;
    L20:
        if (r20 == 1) goto L22;
        if (r20 != 0) goto L42;
        a r21 = r11.f10713m;
        if (r21 == null) goto L42;
        r21.a(r40, r12);
    L42:
        r40.drawRect(r14, r12);
        goto L52
    L22:
        if ((((Color.alpha(r11.g(0)) & Color.alpha(r11.g(1))) & Color.alpha(r11.g(2))) & Color.alpha(r11.g(3))) == 255) goto L25;
    L32:
        a r22 = r11.f10714n;
        if (r22 == null) goto L35;
        r22.a(r40, r12);
    L35:
        a r23 = r11.f10713m;
        if (r23 == null) goto L52;
        r23.a(r40, r12);
        goto L52
    L25:
        if (m(r11.n(0)) == true) goto L32;
        if (m(r11.n(1)) == true) goto L32;
        if (m(r11.n(2)) == true) goto L32;
        if (m(r11.n(3)) == false) goto L35;
    L19:
        r20 = ((Integer) androidx.constraintlayout.motion.widget.a.h(r19.d, 1)).intValue();
    L52:
        an.d r24 = (an.d) r15;
        if (r24.f344a.isEmpty() == true) goto L70;
        r40.save();
        RectF r25 = new RectF(getBounds());
        RectF r26 = new RectF(r13);
        RectF r27 = new RectF(r14);
        if (r11.f10725z == null) goto L57;
        r();
    L57:
        a r28 = r11.f10714n;
        if (r28 == null) goto L60;
        Path r29 = r28.f10737c;
    L61:
        a r30 = r11.f10713m;
        if (r30 == null) goto L64;
        Path r31 = r30.f10737c;
    L66:
        if (r11.f10746a == null) goto L68;
        boolean r110 = true;
    L69:
        r24.a(r40, r25, r26, r27, r25, r29, r31, r110);
        r40.restore();
        goto L70
    L68:
        r110 = false;
        goto L69
    L64:
        r31 = null;
        goto L66
    L60:
        r29 = null;
    L70:
        d r32 = r11.f10725z;
        if (r32 != null) goto L73;
    L149:
        RectF r33 = d();
        int r34 = f(r33.left);
        int r35 = f(r33.top);
        int r36 = f(r33.right);
        int r37 = f(r33.bottom);
        if (r34 > 0) goto L157;
        if (r36 > 0) goto L157;
        if (r35 > 0) goto L157;
        if (r37 > 0) goto L157;
    L155:
        Paint r38 = r12;
    L156:
        boolean r39 = true;
        Paint r41 = r38;
    L247:
        r41.setAntiAlias(r39);
        ?? r42 = r39;
    L248:
        com.lynx.component.svg.parser.d r43 = r11.A;
        if (r43 == null) goto L278;
        d0 r44 = (d0) r43.f9799c;
        if (r44 == null) goto L279;
        int r45 = r40.save();
        r40.translate(-r43.f9797a, -r43.f9798b);
        ArrayList r46 = r44.f10447b;
        if (r46 == null) goto L257;
        if (r46.isEmpty() == true) goto L257;
    L259:
        ArrayList r47 = r44.f10447b;
        if (r47 == null) goto L269;
        int r48 = r47.size() - r42;
    L262:
        if (r48 < 0) goto L269;
        c0 r49 = (c0) r44.f10447b.get(r48);
        if (r49 == null) goto L268;
        if (r49.f10434k.b() == false) goto L268;
        r49.d(r40);
    L268:
        r48 = r48 - 1;
    L269:
        b0 r50 = r44.f10448c;
        if (r50 == null) goto L272;
        r50.a(r40);
    L272:
        r40.restoreToCount(r45);
        return;
    L257:
        if (r44.f10448c != null) goto L259;
    L279:
        return;
    L278:
        return;
    L157:
        Rect r51 = getBounds();
        int r210 = r11.g(0);
        int r111 = r11.g(1);
        int r211 = r11.g(2);
        int r212 = r11.g(3);
        int r52 = r51.left;
        int r53 = r51.top;
        r12.setAntiAlias(false);
        r12.setStyle(Paint.Style.STROKE);
        int r54 = -1;
        if (r34 <= 0) goto L160;
        int r112 = r210;
    L161:
        if (r35 <= 0) goto L163;
        int r113 = r111;
    L164:
        int r114 = r112 & r113;
        if (r36 <= 0) goto L167;
        int r115 = r211;
    L168:
        int r116 = r114 & r115;
        if (r37 <= 0) goto L171;
        r54 = r212;
    L171:
        int r55 = r54 & r116;
        if (r34 <= 0) goto L174;
        int r117 = r210;
    L175:
        if (r35 <= 0) goto L177;
        int r118 = r111;
    L178:
        int r119 = r117 | r118;
        if (r36 <= 0) goto L181;
        int r120 = r211;
    L182:
        int r121 = r119 | r120;
        if (r37 <= 0) goto L185;
        int r122 = r212;
    L187:
        if (r55 == (r121 | r122)) goto L191;
        r55 = 0;
    L191:
        if (r55 != 0) goto L193;
    L224:
        int r213 = r35;
        int r123 = r51.width();
        int r124 = r51.height();
        if (r213 > 0) goto L227;
    L230:
        int r56 = r34;
        RectF r57 = r33;
        Paint r58 = r12;
        int r125 = r124;
    L231:
        if (r36 > 0) goto L233;
    L235:
        RectF r59 = r57;
        Paint r214 = r58;
        int r60 = r125;
        int r61 = r36;
        int r62 = r53;
        r11 = this;
        int r126 = r56;
        int r127 = r37;
    L236:
        if (r127 > 0) goto L238;
    L241:
        int r63 = r127;
        RectF r64 = r59;
        int r128 = r60;
    L240:
        int r65 = r126;
        if (r65 > 0) goto L244;
    L246:
        r38 = r214;
        goto L156
    L244:
        if (Color.alpha(r210) == 0) goto L246;
        float r66 = r52;
        int r67 = r62;
        float r129 = r67;
        float r68 = r52 + r65;
        int r69 = r67 + r128;
        float r130 = r69;
        float r131 = r65;
        float r215 = (0.5f * r131) + r66;
        r40.save();
        i(r40, r66, r129, r68, r67 + r213, r68, r69 - r63, r66, r130, false);
        r11.o(0).a(r40, r214, 0, r64.left, r210, r215, r130, r215, r129, r128, r131);
        r40.restore();
        goto L246
    L238:
        if (Color.alpha(r212) == 0) goto L241;
        float r132 = r52;
        int r70 = r62 + r60;
        float r71 = r70;
        int r72 = r52 + r123;
        float r133 = r72;
        float r134 = r72 - r61;
        float r73 = r70 - r127;
        float r74 = r127;
        float r216 = r71 - (r74 * 0.5f);
        r40.save();
        int r310 = r127;
        RectF r135 = r59;
        i(r40, r132, r71, r133, r71, r134, r73, r52 + r126, r73, false);
        r128 = r60;
        r64 = r135;
        r63 = r310;
        r11.o(3).a(r40, r214, 3, r135.bottom, r212, r133, r216, r132, r216, r123, r74);
        r40.restore();
        goto L240
    L233:
        if (Color.alpha(r211) == 0) goto L235;
        int r75 = r52 + r123;
        float r136 = r75;
        float r76 = r53;
        int r77 = r53 + r125;
        float r78 = r77;
        float r79 = r75 - r36;
        int r137 = r125;
        float r138 = r36;
        float r217 = r136 - (r138 * 0.5f);
        r40.save();
        RectF r139 = r57;
        r214 = r58;
        r11 = this;
        i(r40, r136, r76, r136, r78, r79, r77 - r37, r79, r53 + r213, false);
        r126 = r56;
        r62 = r53;
        r60 = r137;
        r59 = r139;
        r61 = r36;
        r11.o(2).a(r40, r214, 2, r139.right, r211, r217, r76, r217, r78, r137, r138);
        r40.restore();
        r127 = r37;
        goto L236
    L227:
        if (Color.alpha(r111) == 0) goto L230;
        float r140 = r52;
        float r80 = r53;
        float r81 = r53 + r213;
        int r82 = r52 + r123;
        float r141 = r82 - r36;
        float r83 = r82;
        float r142 = r213;
        float r218 = (r142 * 0.5f) + r80;
        r40.save();
        r213 = r213;
        i(r40, r140, r80, r52 + r34, r81, r141, r81, r83, r80, false);
        r58 = r12;
        r56 = r34;
        r57 = r33;
        r125 = r124;
        o(1).a(r40, r58, 1, r33.top, r111, r140, r218, r83, r218, r123, r142);
        r40.restore();
        goto L231
    L193:
        if (q() == false) goto L224;
        if (Color.alpha(r55) == 0) goto L223;
        int r143 = r51.right;
        int r84 = r51.bottom;
        BorderStyle r219 = r11.o(0);
        if (r35 <= 0) goto L204;
        float r144 = r35;
        float r220 = (r144 * 0.5f) + r53;
        if (r36 <= 0) goto L201;
        int r145 = r36;
    L202:
        int r146 = r55;
        r219.a(r40, r12, 1, r33.top, r146, r52, r220, r143 - r145, r220, r143 - r52, r144);
        goto L204
    L201:
        r145 = 0;
    L204:
        if (r36 <= 0) goto L210;
        float r85 = r36;
        float r221 = r143 - (r85 * 0.5f);
        if (r37 <= 0) goto L208;
        int r147 = r37;
    L209:
        int r148 = r55;
        r219.a(r40, r12, 2, r33.right, r148, r221, r53, r221, r84 - r147, r84 - r53, r85);
        goto L210
    L208:
        r147 = 0;
    L210:
        if (r37 <= 0) goto L216;
        float r86 = r37;
        float r222 = r84 - (r86 * 0.5f);
        if (r34 <= 0) goto L214;
        int r149 = r34;
    L215:
        int r150 = r55;
        r219.a(r40, r12, 3, r33.bottom, r150, r143, r222, r149 + r52, r222, r143 - r52, r86);
        goto L216
    L214:
        r149 = 0;
    L216:
        if (r34 <= 0) goto L222;
        float r87 = r52;
        float r88 = r34;
        float r223 = (0.5f * r88) + r87;
        if (r35 <= 0) goto L220;
        int r151 = r35;
    L221:
        int r152 = r55;
        r219.a(r40, r12, 0, r33.left, r152, r223, r84, r223, r151 + r53, r84 - r53, r88);
        goto L222
    L220:
        r151 = 0;
    L222:
        r11 = this;
        goto L155
    L223:
        r11 = this;
        r39 = true;
        r41 = r12;
        goto L247
    L185:
        r122 = 0;
        goto L187
    L181:
        r120 = 0;
        goto L182
    L177:
        r118 = 0;
        goto L178
    L174:
        r117 = 0;
        goto L175
    L167:
        r115 = -1;
        goto L168
    L163:
        r113 = -1;
        goto L164
    L160:
        r112 = -1;
        goto L161
    L73:
        if (r32.d() == false) goto L149;
        if (r() == true) goto L78;
        r42 = 1;
        goto L248
    L78:
        r40.save();
        RectF r153 = d();
        int r89 = f(r153.left);
        int r90 = f(r153.top);
        int r91 = f(r153.right);
        int r92 = f(r153.bottom);
        if (r90 > 0) goto L83;
        if (r92 > 0) goto L83;
        if (r89 > 0) goto L83;
        if (r91 > 0) goto L83;
    L148:
        r40.restore();
        r42 = 1;
    L83:
        int r93 = r11.g(8);
        int r94 = r11.g(0);
        if (r94 == r11.g(2)) goto L86;
    L90:
        boolean r95 = false;
    L91:
        if (r95 == false) goto L93;
        int r96 = r94;
    L94:
        if (r90 != r89) goto L98;
        if (r92 != r89) goto L98;
        if (r91 != r89) goto L98;
        boolean r154 = true;
    L99:
        if (r154 == false) goto L105;
        if (r95 == false) goto L105;
        if (q() == false) goto L105;
        if (r89 <= 0) goto L105;
        float r97 = r89;
        j(r40, r97, r97, 1, r96);
    L105:
        int r155 = r11.g(0);
        int r156 = r11.g(1);
        int r157 = r11.g(2);
        int r158 = r11.g(3);
        RectF r98 = r11.f10714n.f10735a;
        float r99 = r98.left;
        float r100 = r98.right;
        float r101 = r98.top;
        float r102 = r98.bottom;
        if (r90 > 0) goto L108;
    L117:
        float r224 = r102;
        float r225 = r101;
        float r226 = r100;
        RectF r159 = r153;
    L118:
        if (r91 > 0) goto L120;
    L128:
        if (r92 > 0) goto L130;
    L138:
        if (r89 <= 0) goto L148;
        if (Color.alpha(r155) == 0) goto L148;
        PointF r103 = r11.f10718r;
        float r104 = r103.x;
        float r105 = r103.y;
        PointF r106 = r11.f10720u;
        float r107 = r106.x;
        float r108 = r106.y;
        float r109 = r159.left;
        if (r154 == true) goto L146;
        r109 = Math.max(r109, Math.max(r159.top, r159.bottom));
        if ((r109 - Math.min(r159.top, r159.bottom)) < 2.0f) goto L146;
        float r160 = r109;
        boolean r161 = true;
    L147:
        r40.save();
        i(r40, r99, r225, r104, r105, r107, r108, r99, r224, r161);
        j(r40, r159.left, r160, 0, r155);
        r40.restore();
    L146:
        r160 = r109;
        r161 = false;
        goto L147
    L130:
        if (Color.alpha(r158) == 0) goto L138;
        PointF r162 = r11.f10720u;
        float r163 = r162.x;
        float r164 = r162.y;
        PointF r165 = r11.f10719t;
        float r166 = r165.x;
        float r167 = r165.y;
        float r168 = r159.bottom;
        if (r154 == true) goto L136;
        r168 = Math.max(r168, Math.max(r159.left, r159.right));
        if ((r168 - Math.min(r159.left, r159.right)) < 2.0f) goto L136;
        float r169 = r168;
        boolean r170 = true;
    L137:
        r40.save();
        i(r40, r99, r224, r163, r164, r166, r167, r226, r224, r170);
        j(r40, r159.bottom, r169, 3, r158);
        r40.restore();
    L136:
        r169 = r168;
        r170 = false;
        goto L137
    L120:
        if (Color.alpha(r157) == 0) goto L128;
        PointF r171 = r11.s;
        float r172 = r171.x;
        float r173 = r171.y;
        PointF r174 = r11.f10719t;
        float r175 = r174.x;
        float r176 = r174.y;
        float r177 = r159.right;
        if (r154 == true) goto L126;
        r177 = Math.max(r177, Math.max(r159.top, r159.bottom));
        if ((r177 - Math.min(r159.top, r159.bottom)) < 2.0f) goto L126;
        float r178 = r177;
        boolean r179 = true;
    L127:
        r40.save();
        i(r40, r226, r225, r172, r173, r175, r176, r226, r224, r179);
        j(r40, r159.right, r178, 2, r157);
        r40.restore();
    L126:
        r178 = r177;
        r179 = false;
        goto L127
    L108:
        if (Color.alpha(r156) == 0) goto L117;
        PointF r180 = r11.f10718r;
        float r181 = r180.x;
        float r182 = r180.y;
        PointF r183 = r11.s;
        float r184 = r183.x;
        float r185 = r183.y;
        float r186 = r153.top;
        if (r154 == true) goto L115;
        r224 = r102;
        float r187 = Math.max(r186, Math.max(r153.left, r153.right));
        float r227 = r187;
        if ((r187 - Math.min(r153.left, r153.right)) < 2.0f) goto L114;
        boolean r228 = true;
    L116:
        r40.save();
        r225 = r101;
        r226 = r100;
        r159 = r153;
        i(r40, r99, r101, r181, r182, r184, r185, r226, r225, r228);
        j(r40, r159.top, r227, 1, r156);
        r40.restore();
    L114:
        r228 = false;
        goto L116
    L115:
        r224 = r102;
        r227 = r186;
    L98:
        r154 = false;
        goto L99
    L93:
        r96 = r93;
        goto L94
    L86:
        if (r94 != r11.g(1)) goto L90;
        if (r94 != r11.g(3)) goto L90;
        r95 = true;
        goto L91
    L5:
        if (r11.f10708h == false) goto L7;
        goto L6
    }

    public final int g(int r5) {
        l r10 = this.f10709i;
        if (r10 == null) goto L5;
        float r11 = r10.a(r5);
    L6:
        l r12 = this.f10710j;
        if (r12 == null) goto L9;
        float r13 = r12.a(r5);
    L10:
        int r14 = ((int) r11) & ViewCompat.MEASURED_SIZE_MASK;
        return ((((int) r13) << 24) & ViewCompat.MEASURED_STATE_MASK) | r14;
    L9:
        r13 = 255.0f;
        goto L10
    L5:
        r11 = 0.0f;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f10724y;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        int r5 = e.a(this.f10723x, this.f10724y) >>> 24;
        if (r5 != 255) goto L6;
        return -1;
    L6:
        if (r5 != 0) goto L9;
        return -2;
    L9:
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline r5) {
        if (this.f10725z != null) goto L5;
    L10:
        r5.setRect(getBounds());
        return;
    L5:
        if (r() == false) goto L10;
        Path r10 = this.f10716p;
        if (r10 == null) goto L10;
        r5.setConvexPath(r10);
    }

    public final void i(Canvas r5, float r10, float r11, float r12, float r13, float r14, float r15, float r16, float r17, boolean r18) {
        if (r18 == false) goto L10;
        a r19 = this.f10714n;
        if (r19 == null) goto L6;
        r5.clipPath(r19.f10737c, Region.Op.INTERSECT);
    L6:
        a r110 = this.f10713m;
        if (r110 == null) goto L10;
        r5.clipPath(r110.f10737c, Region.Op.DIFFERENCE);
    L10:
        if (this.f10717q != null) goto L12;
        this.f10717q = new Path();
    L12:
        this.f10717q.reset();
        this.f10717q.moveTo(r10, r11);
        this.f10717q.lineTo(r12, r13);
        this.f10717q.lineTo(r14, r15);
        this.f10717q.lineTo(r16, r17);
        this.f10717q.lineTo(r10, r11);
        r5.clipPath(this.f10717q);
    }

    public final void j(Canvas r15, float r16, float r17, int r18, int r19) {
        BorderStyle[] r10 = this.f10711k;
        if (r10 != null) goto L5;
        BorderStyle r11 = null;
    L9:
        if (r11 != null) goto L17;
        u0 r12 = this.f.K;
        if (r12 == null) goto L13;
        boolean r13 = r12.f10975m;
    L14:
        if (r13 == false) goto L16;
        r11 = BorderStyle.f10733h;
        goto L17
    L16:
        r11 = BorderStyle.f10730a;
        goto L17
    L13:
        r13 = false;
    L17:
        this.f10712l = null;
        switch(r11.ordinal()) {
            case 1: goto L33;
            case 2: goto L33;
            case 3: goto L31;
            case 4: goto L29;
            case 5: goto L27;
            case 6: goto L24;
            case 7: goto L21;
            case 8: goto L20;
            case 9: goto L20;
            default: goto L40;
        };
    L20:
        return;
    L21:
        if (r18 == 3) goto L26;
        if (r18 != 2) goto L40;
    L26:
        int r5 = ((r19 & 16711422) >> 1) | (r19 & ViewCompat.MEASURED_STATE_MASK);
    L41:
        Paint r14 = this.f10722w;
        r14.setStyle(Paint.Style.STROKE);
        r14.setColor(e.a(r5, this.f10724y));
        r14.setStrokeWidth(r17);
        r14.setPathEffect(this.f10712l);
        r14.setAntiAlias(true);
        BackgroundDrawable$RoundRectPath$Pos r20 = BackgroundDrawable$RoundRectPath$Pos.f10727a;
        HashMap r21 = this.f10715o;
        if (r21 != null) goto L44;
        a r22 = null;
    L45:
        if (r22 == null) goto L47;
        r22.a(r15, r14);
    L47:
        r14.setPathEffect(null);
        return;
    L44:
        r22 = (a) r21.get(r20);
        goto L45
    L24:
        if (r18 == 1) goto L26;
        if (r18 != 0) goto L40;
    L27:
        k(r15, r18, r16 / 2.0f, (r19 & ViewCompat.MEASURED_STATE_MASK) | ((r19 & 16711422) >> 1), r19, false);
        return;
    L29:
        k(r15, r18, r16 / 2.0f, r19, ((r19 & 16711422) >> 1) | (r19 & ViewCompat.MEASURED_STATE_MASK), false);
        return;
    L31:
        k(r15, r18, r16 / 3.0f, r19, r19, true);
        return;
    L33:
        int r23 = r11.ordinal();
        if (r23 == 1) goto L38;
        if (r23 == 2) goto L37;
        DashPathEffect r24 = null;
    L39:
        this.f10712l = r24;
        goto L40
    L37:
        r24 = new DashPathEffect(new float[]{r16, r16, r16, r16}, 0.0f);
        goto L39
    L38:
        float r25 = r16 * 3.0f;
        r24 = new DashPathEffect(new float[]{r25, r25, r25, r25}, 0.0f);
    L40:
        r5 = r19;
        goto L41
    L5:
        r11 = r10[r18];
        if (r11 != null) goto L9;
        r11 = r10[8];
        goto L9
    }

    public final void k(Canvas r5, int r10, float r11, int r12, int r13, boolean r14) {
        Paint r15 = this.f10722w;
        a r16 = null;
        r15.setPathEffect(null);
        r15.setStyle(Paint.Style.STROKE);
        r15.setStrokeWidth(r11);
        boolean r17 = true;
        if (r10 == 1) goto L7;
        if (r10 == 0) goto L7;
        r17 = false;
    L7:
        if (r17 == false) goto L9;
        int r18 = r13;
    L10:
        r15.setColor(e.a(r18, this.f10724y));
        if (r14 == false) goto L13;
        BackgroundDrawable$RoundRectPath$Pos r19 = BackgroundDrawable$RoundRectPath$Pos.e;
    L14:
        HashMap r20 = this.f10715o;
        if (r20 != null) goto L17;
        a r21 = null;
    L18:
        if (r21 == null) goto L20;
        r21.a(r5, r15);
    L20:
        if (r17 == true) goto L23;
        r12 = r13;
    L23:
        r15.setColor(e.a(r12, this.f10724y));
        if (r14 == false) goto L26;
        BackgroundDrawable$RoundRectPath$Pos r22 = BackgroundDrawable$RoundRectPath$Pos.d;
    L27:
        HashMap r23 = this.f10715o;
        if (r23 == null) goto L31;
        r16 = (a) r23.get(r22);
    L31:
        if (r16 == null) goto L34;
        r16.a(r5, r15);
        return;
    L34:
        return;
    L26:
        r22 = BackgroundDrawable$RoundRectPath$Pos.f10728b;
        goto L27
    L17:
        r21 = (a) r20.get(r19);
        goto L18
    L13:
        r19 = BackgroundDrawable$RoundRectPath$Pos.f10729c;
        goto L14
    L9:
        r18 = r12;
        goto L10
    }

    public final void l(BackgroundDrawable$RoundRectPath$Pos r10, Rect r11, float[] r12, RectF r13) {
        HashMap r5 = this.f10715o;     // Catch: Exception -> L6
        if (r5 == null) goto L8;
        a r14 = (a) r5.get(r10);     // Catch: Exception -> L6
    L9:
        if (r14 != null) goto L11;
        r14 = new a();     // Catch: Exception -> L6
        this.f10715o.put(r10, r14);     // Catch: Exception -> L6
    L11:
        int r15 = r10.ordinal();     // Catch: Exception -> L6
        if (r15 != 0) goto L14;
        float r16 = 0.5f;
    L27:
        r14.b(r11, r12, r13, r16, true);     // Catch: Exception -> L6
        return;
    L14:
        if (r15 != 1) goto L16;
        r16 = 0.75f;
        goto L27
    L16:
        if (r15 != 2) goto L18;
        r16 = 0.25f;
        goto L27
    L18:
        if (r15 == 3) goto L23;
        if (r15 == 4) goto L22;
        r16 = 0.0f;
        goto L27
    L22:
        r16 = 0.16666667f;
        goto L27
    L23:
        r16 = 0.8333333f;
        goto L27
    L8:
        this.f10715o = new HashMap();     // Catch: Exception -> L6
        r14 = null;
    L6:
        e = move-exception;
        LynxLog.b(4, "BackgroundDrawable", "updateCachePath exception:" + e.toString());
    }

    public final BorderStyle n(int r5) {
        if (r5 > 8) goto L13;
        if (r5 < 0) goto L15;
        BorderStyle[] r10 = this.f10711k;
        if (r10 == null) goto L16;
        BorderStyle r11 = r10[r5];
        if (r11 == null) goto L12;
        return r11;
    L12:
        return r10[8];
    L16:
        return null;
    L15:
        return null;
    L13:
        return null;
    }

    public final BorderStyle o(int r5) {
        BorderStyle[] r10 = this.f10711k;
        if (r10 != null) goto L5;
        BorderStyle r11 = null;
    L9:
        if (r11 != null) goto L19;
        u0 r12 = this.f.K;
        if (r12 == null) goto L13;
        boolean r13 = r12.f10975m;
    L14:
        if (r13 == false) goto L18;
        return BorderStyle.f10733h;
    L18:
        return BorderStyle.f10730a;
    L13:
        r13 = false;
        goto L14
    L19:
        return r11;
    L5:
        r11 = r10[r5];
        if (r11 != null) goto L9;
        r11 = r10[8];
        goto L9
    }

    @Override // com.lynx.tasm.behavior.ui.utils.f, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r5) {
        this.f10721v = true;
        super.onBoundsChange(r5);
    }

    public final Path p() {
        if (this.f10725z != null) goto L5;
        return null;
    L5:
        if (r() == false) goto L12;
        a r5 = this.f10713m;
        if (r5 != null) goto L9;
        return null;
    L9:
        return r5.f10737c;
    L12:
        return null;
    }

    public final boolean q() {
        BorderStyle[] r10 = this.f10711k;
        if (r10 != null) goto L5;
        return true;
    L5:
        BorderStyle r5 = r10[8];
        BorderStyle r11 = r10[0];
        if (r11 != null) goto L9;
        r11 = r5;
    L9:
        BorderStyle r12 = r10[2];
        if (r12 != null) goto L13;
        r12 = r5;
    L13:
        if (r12 == r11) goto L15;
        return false;
    L15:
        BorderStyle r13 = r10[1];
        if (r13 != null) goto L19;
        r13 = r5;
    L19:
        if (r13 == r11) goto L21;
        return false;
    L21:
        BorderStyle r14 = r10[3];
        if (r14 == null) goto L24;
        r5 = r14;
    L24:
        if (r5 == r11) goto L26;
        return false;
    L26:
        if (r11 == null) goto L32;
        int r15 = r11.ordinal();
        if (r15 == 0) goto L32;
        if (r15 == 1) goto L32;
        if (r15 == 2) goto L32;
        return false;
    L32:
        return true;
    }

    public final boolean r() {
        if (this.f10725z != null) goto L6;
        return false;
    L6:
        if (this.f10721v == true) goto L8;
        return true;
    L8:
        Rect r5 = getBounds();
        if (r5.width() != 0) goto L11;
    L69:
        return false;
    L11:
        if (r5.height() == 0) goto L69;
        this.f10721v = false;
        RectF r10 = d();
        if (this.f10725z == null) goto L16;
        Rect r11 = getBounds();
        this.f10725z.a(r11.width(), r11.height());
    L16:
        d r12 = this.f10725z;
        if (r12 == null) goto L20;
        float[] r13 = r12.c();
    L19:
        float[] r14 = r13;
        if (this.f10713m != null) goto L24;
        this.f10713m = new a();
    L24:
        this.f10713m.b(r5, r14, r10, 1.0f, false);
        if (this.f10714n != null) goto L27;
        this.f10714n = new a();
    L27:
        this.f10714n.b(r5, r14, r10, 0.0f, false);
        d r15 = this.f10725z;
        if (r15 != null) goto L30;
    L51:
        Path r16 = this.f10716p;
        if (r16 != null) goto L54;
        this.f10716p = new Path();
    L55:
        this.f10716p.addRoundRect(new RectF(r5), a.c(r14, r10, -0.5f), Path.Direction.CW);
        a r17 = this.f10713m;
        RectF r18 = r17.f10735a;
        RectF r19 = this.f10714n.f10735a;
        float[] r20 = r17.f10736b;
        if (this.f10718r != null) goto L58;
        this.f10718r = new PointF();
    L58:
        PointF r21 = this.f10718r;
        RectF r22 = this.f10713m.f10735a;
        r21.x = r22.left;
        r21.y = r22.top;
        float r23 = r18.left;
        double r24 = r23;
        float r110 = r18.top;
        double r25 = r110;
        h(r24, r25, (r20[0] * 2.0f) + r23, (r20[1] * 2.0f) + r110, r19.left, r19.top, r24, r25, r21);
        if (this.f10720u != null) goto L61;
        this.f10720u = new PointF();
    L61:
        PointF r26 = this.f10720u;
        float r27 = r18.left;
        r26.x = r27;
        float r111 = r18.bottom;
        r26.y = r111;
        double r28 = r27;
        double r112 = r111;
        h(r28, r111 - (r20[6] * 2.0f), (r20[7] * 2.0f) + r27, r112, r19.left, r19.bottom, r28, r112, r26);
        if (this.s != null) goto L64;
        this.s = new PointF();
    L64:
        PointF r29 = this.s;
        float r113 = r18.right;
        r29.x = r113;
        float r114 = r18.top;
        r29.y = r114;
        double r30 = r113 - (r20[2] * 2.0f);
        double r31 = r114;
        double r115 = r113;
        h(r30, r31, r115, (r20[3] * 2.0f) + r114, r19.right, r19.top, r115, r31, r29);
        if (this.f10719t != null) goto L67;
        this.f10719t = new PointF();
    L67:
        PointF r32 = this.f10719t;
        float r33 = r18.right;
        r32.x = r33;
        float r34 = r18.bottom;
        r32.y = r34;
        double r35 = r33;
        double r116 = r34;
        h(r33 - (r20[4] * 2.0f), r34 - (r20[5] * 2.0f), r35, r116, r19.right, r19.bottom, r35, r116, r32);
        return true;
    L54:
        r16.reset();
        goto L55
    L30:
        if (r15.d() == false) goto L51;
        l(BackgroundDrawable$RoundRectPath$Pos.f10727a, r5, r14, r10);
        if (this.f10711k == null) goto L51;
        int r36 = 0;
        boolean r37 = false;
        boolean r38 = false;
    L35:
        if (r36 > 8) goto L47;
        BorderStyle r39 = this.f10711k[r36];
        if (r39 == null) goto L46;
        if (r39 != BorderStyle.d) goto L42;
        r37 = true;
        goto L46
    L42:
        if (r39 != BorderStyle.e) goto L44;
    L45:
        r38 = true;
        goto L46
    L44:
        if (r39 == BorderStyle.f) goto L45;
    L46:
        r36 = r36 + 1;
        goto L35
    L47:
        if (r37 == false) goto L49;
        l(BackgroundDrawable$RoundRectPath$Pos.d, r5, r14, r10);
        l(BackgroundDrawable$RoundRectPath$Pos.e, r5, r14, r10);
    L49:
        if (r38 == false) goto L51;
        l(BackgroundDrawable$RoundRectPath$Pos.f10728b, r5, r14, r10);
        l(BackgroundDrawable$RoundRectPath$Pos.f10729c, r5, r14, r10);
        goto L51
    L20:
        r13 = null;
        goto L19
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r5) {
        if (r5 == this.f10724y) goto L6;
        this.f10724y = r5;
        invalidateSelf();
        return;
    }

    @Keep
    public void setColor(int r5) {
        this.f10723x = r5;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r5) {
    }
}
