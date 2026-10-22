package r;

import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.model.DocumentData$Justification;
import com.airbnb.lottie.w;
import com.airbnb.lottie.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import l.n;

/* JADX INFO: loaded from: classes.dex */
public final class l extends c {
    public final HashMap A;
    public final LongSparseArray B;
    public final l.e C;
    public final w D;
    public final com.airbnb.lottie.h E;
    public l.d F;
    public l.d G;
    public l.d H;
    public l.d I;
    public n J;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final StringBuilder f21630v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final RectF f21631w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Matrix f21632x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final j.a f21633y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final j.a f21634z;

    public l(w r5, g r10) {
        super(r5, r10);
        this.f21630v = new StringBuilder(2);
        this.f21631w = new RectF();
        this.f21632x = new Matrix();
        j.a r11 = new j.a(1, 1);
        r11.setStyle(Paint.Style.FILL);
        this.f21633y = r11;
        j.a r12 = new j.a(1, 2);
        r12.setStyle(Paint.Style.STROKE);
        this.f21634z = r12;
        this.A = new HashMap();
        this.B = new LongSparseArray();
        this.D = r5;
        this.E = r10.f21607b;
        l.e r13 = new l.e((ArrayList) r10.f21618q.f22372b, 2);
        this.C = r13;
        r13.a(this);
        f(r13);
        ja.d r14 = r10.f21619r;
        if (r14 == null) goto L7;
        p.a r15 = (p.a) r14.f18301a;
        if (r15 == null) goto L7;
        l.d r16 = r15.d();
        this.F = r16;
        r16.a(this);
        f(this.F);
    L7:
        if (r14 == null) goto L11;
        p.a r17 = (p.a) r14.f18302b;
        if (r17 == null) goto L11;
        l.d r18 = r17.d();
        this.G = r18;
        r18.a(this);
        f(this.G);
    L11:
        if (r14 == null) goto L15;
        p.b r19 = (p.b) r14.f18303c;
        if (r19 == null) goto L15;
        l.d r20 = r19.d();
        this.H = r20;
        r20.a(this);
        f(this.H);
    L15:
        if (r14 == null) goto L20;
        p.b r21 = (p.b) r14.d;
        if (r21 == null) goto L21;
        l.d r22 = r21.d();
        this.I = r22;
        r22.a(this);
        f(this.I);
        return;
    L21:
        return;
    }

    public static void o(DocumentData$Justification r5, Canvas r10, float r11) {
        int r12 = k.f21629a[r5.ordinal()];
        if (r12 != 2) goto L5;
        r10.translate(-r11, 0.0f);
        return;
    L5:
        if (r12 != 3) goto L11;
        r10.translate((-r11) / 2.0f, 0.0f);
        return;
    }

    public static void p(String r10, Paint r11, Canvas r12) {
        if (r11.getColor() != 0) goto L6;
        return;
    L6:
        if (r11.getStyle() == Paint.Style.STROKE) goto L8;
    L10:
        r12.drawText(r10, 0, r10.length(), 0.0f, 0.0f, r11);
        return;
    L8:
        if (r11.getStrokeWidth() != 0.0f) goto L10;
    }

    public static void q(Path r5, Paint r10, Canvas r11) {
        if (r10.getColor() != 0) goto L6;
        return;
    L6:
        if (r10.getStyle() == Paint.Style.STROKE) goto L8;
    L10:
        r11.drawPath(r5, r10);
        return;
    L8:
        if (r10.getStrokeWidth() != 0.0f) goto L10;
    }

    @Override // r.c, o.f
    public final void c(ColorFilter r5, v.c r10) {
        super.c(r5, r10);
        PointF r11 = z.f1356a;
        if (r5 != 1) goto L9;
        l.d r12 = this.F;
        if (r12 == null) goto L7;
        r12.j(r10);
        return;
    L7:
        n r13 = new n(r10, null);
        this.F = r13;
        r13.a(this);
        f(this.F);
        return;
    L9:
        if (r5 != 2) goto L15;
        l.d r14 = this.G;
        if (r14 == null) goto L13;
        r14.j(r10);
        return;
    L13:
        n r15 = new n(r10, null);
        this.G = r15;
        r15.a(this);
        f(this.G);
        return;
    L15:
        if (r5 != z.f1362k) goto L21;
        l.d r16 = this.H;
        if (r16 == null) goto L19;
        r16.j(r10);
        return;
    L19:
        n r17 = new n(r10, null);
        this.H = r17;
        r17.a(this);
        f(this.H);
        return;
    L21:
        if (r5 != z.f1363l) goto L27;
        l.d r18 = this.I;
        if (r18 == null) goto L25;
        r18.j(r10);
        return;
    L25:
        n r19 = new n(r10, null);
        this.I = r19;
        r19.a(this);
        f(this.I);
        return;
    L27:
        if (r5 != z.f1374x) goto L38;
        n r20 = new n(r10, null);
        this.J = r20;
        r20.a(this);
        f(this.J);
        return;
    }

    @Override // r.c, k.e
    public final void e(RectF r5, Matrix r10, boolean r11) {
        super.e(r5, r10, r11);
        com.airbnb.lottie.h r12 = this.E;
        r5.set(0.0f, 0.0f, r12.f1265j.width(), r12.f1265j.height());
    }

    @Override // r.c
    public final void j(Canvas r29, Matrix r30, int r31) {
        r29.save();
        w r5 = this.D;
        if (r5.f1340b.g.size() > 0) goto L6;
        r29.setMatrix(r30);
    L6:
        o.b r10 = (o.b) this.C.f();
        com.airbnb.lottie.h r11 = this.E;
        o.c r12 = (o.c) r11.e.get(r10.f20362b);
        if (r12 != null) goto L10;
        r29.restore();
        return;
    L10:
        l.d r13 = this.F;
        j.a r14 = this.f21633y;
        if (r13 == null) goto L13;
        r14.setColor(((Integer) r13.f()).intValue());
    L14:
        l.d r15 = this.G;
        j.a r16 = this.f21634z;
        if (r15 == null) goto L17;
        r16.setColor(((Integer) r15.f()).intValue());
    L18:
        l.d r17 = this.f21594t.f19505j;
        if (r17 != null) goto L21;
        int r18 = 100;
    L22:
        int r19 = (r18 * 255) / 100;
        r14.setAlpha(r19);
        r16.setAlpha(r19);
        l.d r20 = this.H;
        if (r20 == null) goto L25;
        r16.setStrokeWidth(((Float) r20.f()).floatValue());
    L27:
        if (r5.f1340b.g.size() <= 0) goto L29;
        boolean r21 = true;
    L30:
        int r110 = r10.e;
        boolean r22 = r10.f20367k;
        DocumentData$Justification r111 = r10.d;
        float r112 = r10.f;
        int r113 = r110;
        String r114 = r10.f20361a;
        j.a r115 = r16;
        float r116 = r10.f20363c;
        String r23 = r12.f20369b;
        String r24 = r12.f20368a;
        if (r21 == false) goto L74;
        n r25 = this.J;
        if (r25 == null) goto L36;
        r116 = ((Float) r25.f()).floatValue();
    L36:
        float r26 = r116 / 100.0f;
        j.a r117 = r14;
        float r27 = u.f.d(r30);
        float r118 = u.f.c() * r112;
        List r119 = Arrays.asList(r114.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
        int r120 = r119.size();
        int r121 = 0;
    L37:
        if (r121 >= r120) goto L151;
        String r122 = (String) r119.get(r121);
        boolean r28 = r22;
        List r32 = r119;
        float r123 = 0.0f;
        int r124 = 0;
    L40:
        if (r124 >= r122.length()) goto L46;
        o.b r210 = r10;
        o.d r33 = (o.d) r11.g.get(o.d.a(r24, r122.charAt(r124), r23));
        if (r33 != null) goto L44;
        com.airbnb.lottie.h r211 = r11;
    L45:
        r124 = r124 + 1;
        r10 = r210;
        r24 = r24;
        r23 = r23;
        r11 = r211;
        r5 = r5;
        goto L40
    L44:
        r211 = r11;
        r123 = (float) ((((r33.f20372c * ((double) r26)) * ((double) u.f.c())) * ((double) r27)) + ((double) r123));
        goto L45
    L46:
        w r212 = r5;
        o.b r213 = r10;
        com.airbnb.lottie.h r214 = r11;
        String r215 = r24;
        String r216 = r23;
        r29.save();
        o(r111, r29, r123);
        r29.translate(0.0f, (r121 * r118) - (((r120 - 1) * r118) / 2.0f));
        int r34 = 0;
    L48:
        if (r34 >= r122.length()) goto L72;
        String r35 = r215;
        String r36 = r216;
        r214 = r214;
        o.d r37 = (o.d) r214.g.get(o.d.a(r35, r122.charAt(r34), r36));
        if (r37 != null) goto L52;
        r214 = r214;
        DocumentData$Justification r217 = r111;
        r120 = r120;
        String r218 = r122;
        int r38 = r113;
        j.a r39 = r117;
        o.b r125 = r213;
        r212 = r212;
    L71:
        r34 = r34 + 1;
        r113 = r38;
        r117 = r39;
        r212 = r212;
        r213 = r125;
        r120 = r120;
        r122 = r218;
        r111 = r217;
        r216 = r36;
        r215 = r35;
        goto L48
    L52:
        HashMap r40 = this.A;
        if (r40.containsKey(r37) == false) goto L55;
        List r41 = (List) r40.get(r37);
        r217 = r111;
        r218 = r122;
    L59:
        int r42 = 0;
    L61:
        if (r42 >= r41.size()) goto L67;
        Path r126 = ((k.d) r41.get(r42)).getPath();
        r126.computeBounds(this.f21631w, false);
        Matrix r127 = this.f21632x;
        r127.set(r30);
        o.b r128 = r213;
        List r219 = r41;
        r127.preTranslate(0.0f, (-r128.g) * u.f.c());
        r127.preScale(r26, r26);
        r126.transform(r127);
        if (r28 == false) goto L65;
        j.a r43 = r117;
        q(r126, r43, r29);
        j.a r129 = r115;
        q(r126, r129, r29);
    L66:
        r42 = r42 + 1;
        r117 = r43;
        r115 = r129;
        r41 = r219;
        r213 = r128;
        goto L61
    L65:
        r129 = r115;
        r43 = r117;
        q(r126, r129, r29);
        q(r126, r43, r29);
        goto L66
    L67:
        r39 = r117;
        r125 = r213;
        float r44 = (u.f.c() * (((float) r37.f20372c) * r26)) * r27;
        r38 = r113;
        float r130 = r38 / 10.0f;
        l.d r131 = this.I;
        if (r131 == null) goto L70;
        r130 = r130 + ((Float) r131.f()).floatValue();
    L70:
        r29.translate((r130 * r27) + r44, 0.0f);
        goto L71
    L55:
        ArrayList r132 = r37.f20370a;
        int r133 = r132.size();
        ArrayList r45 = new ArrayList(r133);
        int r134 = 0;
    L56:
        if (r134 >= r133) goto L58;
        ArrayList r220 = r132;
        r45.add(new k.d(r212, this, (q.l) r132.get(r134)));
        r134 = r134 + 1;
        r122 = r122;
        r132 = r220;
        r111 = r111;
        goto L56
    L58:
        r217 = r111;
        r218 = r122;
        r40.put(r37, r45);
        r41 = r45;
        goto L59
    L72:
        r24 = r215;
        r29.restore();
        r121 = r121 + 1;
        r119 = r32;
        r23 = r216;
        r5 = r212;
        r10 = r213;
        r22 = r28;
        r11 = r214;
        r111 = r111;
    L151:
        r29.restore();
        return;
    L74:
        DocumentData$Justification r221 = r111;
        int r46 = r113;
        float r47 = u.f.d(r30);
        if (r5.getCallback() != null) goto L78;
        r47 = r47;
        z4.a r48 = null;
    L86:
        if (r48 == null) goto L108;
        o.i r49 = (o.i) r48.f23389a;
        r49.f20380a = r24;
        r49.f20381b = r23;
        HashMap r50 = (HashMap) r48.f23391c;
        Typeface r135 = (Typeface) r50.get(r49);
        if (r135 == null) goto L90;
        r46 = r46;
        Typeface r51 = r135;
    L109:
        if (r51 == null) goto L151;
        r14.setTypeface(r51);
        n r52 = this.J;
        if (r52 != null) goto L114;
        float r53 = r116;
    L115:
        r14.setTextSize(u.f.c() * r53);
        r115.setTypeface(r14.getTypeface());
        r115.setTextSize(r14.getTextSize());
        float r54 = u.f.c() * r112;
        List r55 = Arrays.asList(r114.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
        int r56 = r55.size();
        int r136 = 0;
    L116:
        if (r136 >= r56) goto L151;
        String r57 = (String) r55.get(r136);
        DocumentData$Justification r58 = r221;
        o(r58, r29, r115.measureText(r57));
        r29.translate(0.0f, (r136 * r54) - (((r56 - 1) * r54) / 2.0f));
        int r59 = 0;
    L119:
        if (r59 >= r57.length()) goto L150;
        int r137 = r57.codePointAt(r59);
        int r138 = Character.charCount(r137) + r59;
    L122:
        if (r138 >= r57.length()) goto L134;
        int r139 = r57.codePointAt(r138);
        if (Character.getType(r139) == 16) goto L133;
        if (Character.getType(r139) == 27) goto L133;
        if (Character.getType(r139) == 6) goto L133;
        if (Character.getType(r139) == 28) goto L133;
        if (Character.getType(r139) != 19) goto L134;
    L133:
        r138 = r138 + Character.charCount(r139);
        r137 = (r137 * 31) + r139;
    L134:
        long r140 = r137;
        LongSparseArray r141 = this.B;
        if (r141.containsKey(r140) == false) goto L137;
        String r142 = (String) r141.get(r140);
        List r143 = r55;
    L141:
        r59 = r59 + r142.length();
        if (r22 == false) goto L145;
        p(r142, r14, r29);
        p(r142, r115, r29);
    L146:
        float r144 = r14.measureText(r142, 0, 1);
        int r145 = r46;
        float r146 = r145 / 10.0f;
        l.d r147 = this.I;
        if (r147 == null) goto L149;
        r146 = r146 + ((Float) r147.f()).floatValue();
    L149:
        r29.translate((r146 * r47) + r144, 0.0f);
        r46 = r145;
        r54 = r54;
        r55 = r143;
        goto L119
    L145:
        p(r142, r115, r29);
        p(r142, r14, r29);
        goto L146
    L137:
        StringBuilder r148 = this.f21630v;
        r148.setLength(0);
        int r60 = r59;
    L138:
        if (r60 >= r138) goto L140;
        List r149 = r55;
        int r61 = r57.codePointAt(r60);
        r148.appendCodePoint(r61);
        r60 = r60 + Character.charCount(r61);
        r55 = r149;
        goto L138
    L140:
        r143 = r55;
        String r62 = r148.toString();
        r141.put(r140, r62);
        r142 = r62;
        goto L141
    L150:
        r29.setMatrix(r30);
        r136 = r136 + 1;
        r221 = r58;
        r54 = r54;
        r55 = r55;
        goto L116
    L114:
        r53 = ((Float) r52.f()).floatValue();
        goto L115
    L90:
        HashMap r150 = (HashMap) r48.f23390b;
        Typeface r151 = (Typeface) r150.get(r24);
        if (r151 == null) goto L93;
        Typeface r63 = r151;
    L94:
        boolean r64 = r23.contains("Italic");
        boolean r65 = r23.contains("Bold");
        if (r64 == false) goto L98;
        if (r65 == false) goto L98;
        int r66 = 3;
    L104:
        if (r63.getStyle() == r66) goto L107;
        r63 = Typeface.create(r63, r66);
    L107:
        r50.put(r49, r63);
        r51 = r63;
    L98:
        if (r64 == false) goto L100;
        r66 = 2;
        goto L104
    L100:
        if (r65 == false) goto L102;
        r66 = 1;
        goto L104
    L102:
        r66 = 0;
        goto L104
    L93:
        r63 = Typeface.createFromAsset((AssetManager) r48.d, "fonts/" + r24 + ((String) r48.e));
        r150.put(r24, r63);
        goto L94
    L108:
        r46 = r46;
        r51 = null;
        goto L109
    L78:
        if (r5.f1345k != null) goto L85;
        Drawable.Callback r67 = r5.getCallback();
        z4.a r68 = new z4.a();
        r68.f23389a = new o.i();
        r68.f23391c = new HashMap();
        r68.f23390b = new HashMap();
        r68.e = ".ttf";
        if ((r67 instanceof View) == true) goto L82;
        u.b.b("LottieDrawable must be inside of a view for images to work.");
        r68.d = null;
    L83:
        r5.f1345k = r68;
        goto L85
    L82:
        r68.d = ((View) r67).getContext().getAssets();
    L85:
        r48 = r5.f1345k;
        goto L86
    L29:
        r21 = false;
        goto L30
    L25:
        r16.setStrokeWidth((u.f.c() * r10.f20366j) * u.f.d(r30));
        goto L27
    L21:
        r18 = ((Integer) r17.f()).intValue();
        goto L22
    L17:
        r16.setColor(r10.f20365i);
        goto L18
    L13:
        r14.setColor(r10.f20364h);
        goto L14
    }
}
