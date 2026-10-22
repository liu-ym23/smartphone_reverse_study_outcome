package com.lynx.tasm.behavior.shadow.text;

import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import java.text.Bidi;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import y6a.l;
import z6a.j;
import z6a.k;
import z6a.m;
import z6a.n;
import z6a.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e {
    public Layout a;
    public final f b;
    public int c;
    public float d;
    public float e;
    public float f;

    public static class a {
        public CharSequence a;
        public boolean b;
        public float c;
        public int d;
        public int e;
        public TextPaint f;

        public a() {
        }
    }

    static {
        new BoringLayout.Metrics();
    }

    public final float d() {
        float r0 = this.f;
        if (r0 < 0.0f) goto L5;
        return r0;
    L5:
        this.f = -1.0f;
        int r1 = 0;
    L7:
        if (r1 >= h()) goto L14;
        float r2 = this.f;
        if (this.b.a.b.d(false) != Layout.Alignment.ALIGN_NORMAL) goto L11;
        float r3 = this.a.getLineMax(r1);
    L12:
        this.f = Math.max(r2, r3);
        r1 = r1 + 1;
        goto L7
    L11:
        r3 = this.a.getLineMax(r1) - this.a.getParagraphLeft(r1);
        goto L12
    L14:
        if (this.b.a.a.length() != 0) goto L16;
    L15:
        boolean r4 = false;
    L35:
        if (r4 == false) goto L38;
        this.f = (float) (((double) this.f) + (((double) (-this.a.getLineAscent(0))) * 0.2d));
    L38:
        return this.f;
    L16:
        r4 = true;
        if (this.b.a.b.h == 2) goto L35;
        int r5 = this.a.getLineEnd(h() - 1);
        if (Build.VERSION.SDK_INT < 28) goto L28;
        z6a.g[] r6 = (z6a.g[]) ((SpannableStringBuilder) this.b.a.a).getSpans(0, r5, z6a.g.class);
        int r7 = 0;
    L23:
        if (r7 >= r6.length) goto L15;
        if (r6[r7].a == 2) goto L35;
        r7 = r7 + 1;
        goto L23
    L28:
        StyleSpan[] r8 = (StyleSpan[]) ((SpannableStringBuilder) this.b.a.a).getSpans(0, r5, StyleSpan.class);
        int r9 = 0;
    L30:
        if (r9 >= r8.length) goto L15;
        if (r8[r9].getStyle() == 2) goto L35;
        r9 = r9 + 1;
        goto L30
    }

    public final int g() {
        if (this.b.b != MeasureMode.EXACTLY) goto L9;
        float r0 = this.a.getWidth();
        float r1 = this.b.d;
        if (r0 > r1) goto L9;
        double r2 = Math.ceil(r1);
    L8:
        return (int) r2;
    L9:
        r2 = Math.ceil(d());
        goto L8
    }

    public final int h() {
        int r0 = this.b.a.b.a;
        if (r0 == (-1)) goto L9;
        if (r0 > this.a.getLineCount()) goto L9;
        return r0;
    L9:
        return this.a.getLineCount();
    }

    public final boolean j() {
        if (l.a(this.b.a.b.k) == true) goto L15;
        f r0 = this.b;
        if (r0.i == false) goto L15;
        if (r0.h == false) goto L15;
        com.lynx.tasm.behavior.shadow.text.a r1 = r0.a.b;
        if (r1.i != 1) goto L15;
        if (r1.q == true) goto L15;
        if (r1.r == true) goto L15;
        return true;
    L15:
        return false;
    }

    public final boolean k() {
        if (this.b.c == MeasureMode.UNDEFINED) goto L7;
        if (this.a.getHeight() <= this.b.e) goto L7;
    L12:
        return true;
    L7:
        if (d() > this.b.d) goto L12;
        if (l() == true) goto L12;
        return false;
    }

    public final boolean l() {
        if (this.a.getLineCount() > h()) goto L11;
        Layout r0 = this.a;
        if (r0.getEllipsisCount(r0.getLineCount() - 1) > 0) goto L12;
        Layout r1 = this.a;
        if (r1.getLineEnd(r1.getLineCount() - 1) < this.a.getText().length()) goto L13;
        return false;
    L13:
        return true;
    L12:
        return true;
    L11:
        return true;
    }

    public final int i() {
        if (j() == true) goto L5;
        com.lynx.tasm.behavior.shadow.text.a r0 = this.b.a.b;
        int r1 = r0.a;
        if (r0.i == 1) goto L11;
        if (r1 == 1) goto L11;
        boolean r2 = false;
    L12:
        if (r2 == false) goto L15;
        r1 = 1;
    L15:
        if (r1 == (-1)) goto L22;
        if (r1 > this.a.getLineCount()) goto L22;
        return this.a.getLineBottom(r1 - 1);
    L22:
        return this.a.getHeight();
    L11:
        r2 = true;
        goto L12
    L5:
        return (int) Math.ceil(this.b.a.b.k);
    }

    public final void a(a r19) {
        com.lynx.tasm.behavior.shadow.text.a r2 = this.b.a.b;
        int r3 = r2.d;
        if (r3 == 0) goto L6;
        if (r3 == 2) goto L6;
    L14:
        Layout.Alignment r4 = r2.d(false);
    L15:
        SpannableStringBuilder r5 = (SpannableStringBuilder) r19.a;
        f r7 = this.b;
        if (r7.i == false) goto L40;
        com.lynx.tasm.behavior.shadow.text.a r8 = r7.a.b;
        if (r8.r == true) goto L40;
        if (r8.q == true) goto L40;
        if (r8.e == 2) goto L40;
        if (r8.H == 1) goto L40;
        if (r8.i == 1) goto L34;
        if (r8.a != 1) goto L32;
        if (r8.j == 1) goto L34;
    L32:
        if (r7.b != MeasureMode.UNDEFINED) goto L40;
    L34:
        if (r5.length() != 0) goto L36;
    L39:
        boolean r6 = true;
    L42:
        if (r6 == false) goto L50;
        BoringLayout.Metrics r9 = BoringLayout.isBoring(r19.a, r19.f);
        if (r9 != null) goto L46;
    L51:
        if (r9 != null) goto L105;
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 23) goto L100;
        StaticLayout.Builder r11 = e(r19.a, r4, r19.f, r19.c);
        if (r19.d != 0) goto L57;
        r11.setEllipsize(TextUtils.TruncateAt.END).setEllipsizedWidth((int) Math.floor(r19.c)).setMaxLines(r19.e);
    L57:
        int r12 = r19.e;
        if (r12 <= 0) goto L61;
        r11.setMaxLines(r12);
    L61:
        if (r19.b == false) goto L63;
        r11.setMaxLines(1);
    L63:
        com.lynx.tasm.behavior.shadow.text.a r13 = this.b.a.b;
        if (r13.d != 5) goto L71;
        if (r13.r == true) goto L71;
        if (r10 < 26) goto L71;
        r11.setJustificationMode(1);
    L71:
        if (this.b.a.b.C == false) goto L73;
        r11.setHyphenationFrequency(2);
        r11.setBreakStrategy(1);
    L73:
        StaticLayout r14 = r11.build();
        this.a = r14;
        if (r19.d != 0) goto L105;
        int r15 = r14.getLineCount() - 1;
        if (r10 > 28) goto L95;
        com.lynx.tasm.behavior.shadow.text.a r16 = this.b.a.b;
        if (r16.q == true) goto L82;
        if (r16.r == false) goto L95;
    L82:
        if (this.a.getEllipsisCount(r15) <= 0) goto L95;
        int r17 = (this.a.getLineStart(r15) + this.a.getEllipsisStart(r15)) - 1;
        SpannableStringBuilder r18 = (SpannableStringBuilder) r19.a;
        if (r17 >= r18.length()) goto L91;
        int r20 = r17 + 1;
        if (((com.lynx.tasm.behavior.ui.text.a[]) r18.getSpans(r17, r20, com.lynx.tasm.behavior.ui.text.a.class)).length <= 0) goto L89;
    L92:
        boolean r21 = true;
    L93:
        if (r21 == false) goto L95;
        CharSequence r22 = f((SpannableStringBuilder) r19.a, r17 + 1);
        r19.a = r22;
        this.a = e(r22, r4, r19.f, r19.c).build();
        goto L95
    L89:
        if (((n[]) r18.getSpans(r17, r20, n.class)).length > 0) goto L92;
    L91:
        r21 = false;
    L95:
        Layout r23 = this.a;
        if (r23.getLineWidth(r23.getLineCount() - 1) <= r19.c) goto L105;
        Layout r24 = this.a;
        if (r24.getEllipsisCount(r24.getLineCount() - 1) <= 0) goto L105;
        StaticLayout.Builder r25 = e(r19.a, r4, r19.f, r19.c);
        r25.setMaxLines(r19.e);
        r25.setEllipsize(TextUtils.TruncateAt.END);
        double r26 = Math.floor(r19.c) * 2.0d;
        Layout r1 = this.a;
        r25.setEllipsizedWidth((int) (r26 - ((double) r1.getLineWidth(r1.getLineCount() - 1))));
        this.a = r25.build();
        goto L105
    L100:
        CharSequence r27 = r19.a;
        int r28 = r27.length();
        TextPaint r29 = r19.f;
        int r110 = (int) Math.floor(r19.c);
        com.lynx.tasm.behavior.shadow.text.a r30 = this.b.a.b;
        float r111 = r30.m;
        boolean r112 = r30.t;
        if (r19.d != 0) goto L103;
        TextUtils.TruncateAt r113 = TextUtils.TruncateAt.END;
    L104:
        this.a = p.a(r27, r28, r29, r110, r4, 1.0f, r111, r112, r113, r19.e, r30.b());
        goto L105
    L103:
        r113 = null;
    L105:
        this.f = -1.0f;
        return;
    L46:
        if (r19.d != 0) goto L48;
        CharSequence r31 = r19.a;
        TextPaint r32 = r19.f;
        int r33 = (int) Math.floor(r19.c);
        com.lynx.tasm.behavior.shadow.text.a r114 = this.b.a.b;
        BoringLayout r34 = BoringLayout.make(r31, r32, r33, r4, 1.0f, r114.m, r9, r114.t, TextUtils.TruncateAt.END, (int) Math.floor(r19.c));
    L49:
        this.a = r34;
        goto L51
    L48:
        CharSequence r35 = r19.a;
        TextPaint r36 = r19.f;
        int r37 = (int) Math.floor(r19.c);
        com.lynx.tasm.behavior.shadow.text.a r38 = this.b.a.b;
        r34 = BoringLayout.make(r35, r36, r37, r4, 1.0f, r38.m, r9, r38.t);
        goto L49
    L50:
        r9 = null;
        goto L51
    L36:
        if (((z6a.d[]) r5.getSpans(0, r5.length(), z6a.d.class)).length != 0) goto L40;
        if (((k[]) r5.getSpans(0, r5.length(), k.class)).length == 0) goto L39;
    L40:
        r6 = false;
    L6:
        if (r2.e != 0) goto L14;
        int r39 = r2.H;
        if (r39 == 0) goto L13;
        if (r39 != 1) goto L11;
        boolean r40 = true;
    L12:
        r4 = r2.d(r40);
        goto L15
    L11:
        r40 = false;
        goto L12
    L13:
        r4 = this.b.a.b.d(!new Bidi(r19.a.toString(), -2).baseIsLeftToRight());
        goto L15
    }

    public final float c(float r5) {
        if (this.a.getLineLeft(0) != 0.0f) goto L6;
        return 0.0f;
    L6:
        if (this.a.getAlignment() != Layout.Alignment.ALIGN_CENTER) goto L9;
        return (-(this.a.getWidth() - r5)) / 2.0f;
    L9:
        if (this.a.getAlignment() == Layout.Alignment.ALIGN_OPPOSITE) goto L15;
        if (this.a.getParagraphDirection(0) == (-1)) goto L15;
        if (this.a.getParagraphAlignment(0) == Layout.Alignment.ALIGN_OPPOSITE) goto L15;
        return 0.0f;
    L15:
        return -(this.a.getWidth() - r5);
    }

    public final void m(LynxContext r18) {
        f.a r1 = this.b.a;
        if (r1.a == null) goto L285;
        a r2 = new a();
        com.lynx.tasm.behavior.shadow.text.a r3 = r1.b;
        DecimalFormat r4 = b.a;
        String r5 = r3.u;
        float[] r6 = null;
        if (TextUtils.isEmpty(r5) == true) goto L7;
        Typeface r7 = g.d(r18, r5, r3.e());
    L8:
        r2.f = b.l(this.b.a.b, r7);
        f.a r8 = this.b.a;
        com.lynx.tasm.behavior.shadow.text.a r9 = r8.b;
        int r10 = r9.i;
        boolean r11 = false;
        if (r10 != 1) goto L11;
    L14:
        boolean r12 = true;
    L15:
        r2.b = r12;
        if (r9.j != 1) goto L18;
        boolean r13 = true;
    L19:
        if (r10 != 1) goto L21;
        int r14 = 1;
    L23:
        if (r13 == false) goto L27;
        if (r14 == (-1)) goto L26;
        int r15 = 0;
    L28:
        r2.d = r15;
        CharSequence r16 = r8.a;
        int r17 = r9.b;
        int r19 = r16.length();
        if (r17 == (-1)) goto L32;
        if (r17 >= r19) goto L32;
        r16 = f((SpannableStringBuilder) r16, r17);
    L32:
        r2.a = r16;
        f r20 = this.b;
        MeasureMode r21 = r20.b;
        if (r21 != MeasureMode.EXACTLY) goto L35;
    L38:
        float r22 = r20.d;
    L39:
        r2.c = r22;
        if (r2.b == false) goto L42;
        int r23 = 1;
    L43:
        r2.e = r23;
        if (r20.a.b.i != 1) goto L52;
        String r24 = r16.toString();
        SpannableStringBuilder r25 = new SpannableStringBuilder(r2.a);
        int r26 = r24.indexOf(10);
        if (r26 <= 0) goto L49;
        r25.delete(r26, r25.length());
    L49:
        r2.a = r25;
        if (this.b.a.b.j == 1) goto L52;
        r2.c = 32767.0f;
    L52:
        a(r2);
        f r27 = this.b;
        f.a r28 = r27.a;
        com.lynx.tasm.behavior.shadow.text.a r29 = r28.b;
        if (r29.v == false) goto L201;
        if (r27.b == MeasureMode.UNDEFINED) goto L201;
        if (Build.VERSION.SDK_INT < 24) goto L59;
    L61:
        int r30 = (int) r29.n;
        CharSequence r31 = r28.a;
        AbsoluteSizeSpan[] r32 = (AbsoluteSizeSpan[]) ((Spanned) r31).getSpans(0, r31.length(), AbsoluteSizeSpan.class);
        int r33 = 0;
    L63:
        if (r33 >= r32.length) goto L68;
        if (r30 >= r32[r33].getSize()) goto L67;
        r30 = r32[r33].getSize();
    L67:
        r33 = r33 + 1;
        goto L63
    L68:
        int r34 = h();
        List<com.lynx.tasm.behavior.shadow.text.a.C0051a> r35 = this.b.a.b.A;
        if (r35 != null) goto L71;
    L73:
        boolean r36 = false;
    L74:
        if (r34 <= 0) goto L90;
        List<com.lynx.tasm.behavior.shadow.text.a.C0051a> r37 = this.b.a.b.A;
        if (r37 == null) goto L90;
        if (r37.isEmpty() == true) goto L90;
        int r110 = 0;
    L83:
        if (r110 >= r37.size()) goto L90;
        com.lynx.tasm.behavior.shadow.text.a.C0051a r111 = (com.lynx.tasm.behavior.shadow.text.a.C0051a) ListProtector.get(r37, r110);
        if (r34 < r111.a) goto L89;
        if (r34 > r111.b) goto L89;
    L91:
        if (r36 == false) goto L94;
        if (r111 == null) goto L201;
    L94:
        com.lynx.tasm.behavior.shadow.text.a r38 = this.b.a.b;
        float[] r39 = r38.z;
        float r40 = r38.x;
        float r112 = r38.w;
        float r41 = r38.y;
        if (r41 > 0.0f) goto L98;
        r41 = 1.0f;
    L98:
        if (r111 == null) goto L100;
        r40 = r111.c;
        r112 = r111.d;
    L102:
        if (r112 <= 0.0f) goto L107;
        if (r40 <= r112) goto L107;
        float r113 = r112;
        r112 = r40;
        r40 = r113;
    L107:
        if (k() == false) goto L118;
        if (l.a(this.b.a.b.k) == true) goto L118;
        f r42 = this.b;
        if (r42.c == MeasureMode.UNDEFINED) goto L118;
        if (r42.a.b.k <= r42.e) goto L118;
        if (l() == false) goto L201;
    L118:
        if (k() == true) goto L125;
        if (r111 != null) goto L121;
    L124:
        int r43 = r30;
        int r114 = r43;
    L127:
        if (k() == true) goto L131;
        if (r111 == null) goto L147;
        if (h() > r111.b) goto L131;
    L147:
        if (k() == false) goto L152;
        if (r111 == null) goto L201;
        if (r114 < 0) goto L151;
        b(r114, r2);
        goto L201
    L151:
        b(r30, r2);
        goto L201
    L152:
        if (r111 == null) goto L158;
        if (h() <= r111.b) goto L158;
        if (r114 < 0) goto L157;
        b(r114, r2);
        goto L201
    L157:
        b(r30, r2);
    L158:
        if (r6 == null) goto L166;
        int r44 = 0;
    L161:
        if (r44 >= r6.length) goto L172;
        float r115 = r6[r44];
        if (r115 > r43) goto L164;
        r44 = r44 + 1;
        goto L161
    L164:
        r43 = (int) r115;
    L173:
        if (r43 < 0) goto L188;
        b(r43, r2);
        if (k() == true) goto L185;
        if (r111 != null) goto L179;
    L181:
        if (r111 == null) goto L184;
        if (h() < r111.a) goto L158;
    L184:
        r114 = r43;
        goto L158
    L179:
        if (h() <= r111.b) goto L181;
    L185:
        if (r114 < 0) goto L187;
        b(r114, r2);
        goto L188
    L187:
        b(r30, r2);
    L188:
        if (r111 == null) goto L201;
        if (r114 >= 0) goto L201;
        b(r30, r2);
    L172:
        r43 = -1;
        goto L173
    L166:
        int r45 = (int) (r43 + r41);
        if (r45 == r43) goto L172;
        if (r45 > r112) goto L172;
        r43 = r45;
    L131:
        if (r6 == null) goto L138;
        int r116 = r6.length - 1;
    L133:
        if (r116 < 0) goto L144;
        float r117 = r6[r116];
        if (r117 < r43) goto L136;
        r116 = r116 - 1;
        goto L133
    L136:
        int r118 = (int) r117;
    L145:
        if (r118 < 0) goto L147;
        b(r118, r2);
        if (k() == true) goto L199;
        if (r111 != null) goto L195;
    L198:
        r114 = r118;
        goto L199
    L195:
        if (h() < r111.a) goto L199;
        if (h() <= r111.b) goto L198;
    L199:
        r43 = r118;
    L144:
        r118 = -1;
        goto L145
    L138:
        r118 = (int) (r43 - r41);
        if (r118 == r43) goto L144;
        if (r118 < r40) goto L144;
    L121:
        if (h() < r111.a) goto L125;
        if (h() <= r111.b) goto L124;
    L125:
        r43 = r30;
        r114 = -1;
        goto L127
    L100:
        r6 = r39;
    L89:
        r110 = r110 + 1;
    L90:
        r111 = null;
        goto L91
    L71:
        if (r35.isEmpty() == true) goto L73;
        r36 = true;
        goto L74
    L59:
        if (r29.s == true) goto L61;
    L201:
        if (r2.d == (-1)) goto L221;
        float r46 = this.b.a.b.k;
        int r47 = this.a.getLineCount();
        int r48 = this.a.getHeight();
        if (l.a(r46) == false) goto L206;
        double r119 = 0.0d;
    L207:
        int r49 = (int) Math.ceil(((double) this.b.e) + Math.max(r119, 0.0d));
        if (this.b.c == MeasureMode.UNDEFINED) goto L221;
        if (r48 <= r49) goto L221;
        if (r2.b == true) goto L221;
        int r50 = r47 - 1;
    L214:
        if (r50 <= 0) goto L219;
        if (this.a.getLineBottom(r50) <= this.b.e) goto L219;
        r50 = r50 - 1;
    L219:
        r2.e = r50 + 1;
        r2.d = 0;
        a(r2);
        goto L221
    L206:
        double r120 = r46;
        r119 = (Math.ceil(r120) - r120) * ((double) r47);
    L221:
        if (r2.d != (-1)) goto L223;
    L265:
        f r51 = this.b;
        MeasureMode r52 = r51.b;
        MeasureMode r53 = MeasureMode.EXACTLY;
        if (r52 == r53) goto L268;
    L270:
        float r54 = d();
        f r55 = this.b;
        com.lynx.tasm.behavior.shadow.text.a r56 = r55.a.b;
        if (r56.i == 1) goto L273;
    L279:
        this.d = c(r54);
    L280:
        this.e = 0.0f;
        if (j() == false) goto L320;
        this.e = b.a((int) Math.ceil(this.b.a.b.k), this.a.getPaint().getFontMetricsInt(), this.b.a.b.t);
        return;
    L320:
        return;
    L273:
        if (r55.b != r53) goto L279;
        float r57 = r55.d;
        if (r57 <= r54) goto L279;
        if (r56.j == 1) goto L280;
        this.d = c(r57);
        goto L280
    L268:
        if (r51.a.b.i == 1) goto L270;
    L223:
        if (this.b.a.b.b() == TextDirectionHeuristics.FIRSTSTRONG_LTR) goto L225;
    L227:
        int r58 = this.a.getLineCount() - 1;
        int r59 = this.a.getEllipsisCount(r58);
        this.c = r59;
        if (r59 <= 0) goto L265;
        int r60 = this.a.getLineStart(r58) + this.a.getEllipsisStart(r58);
        SpannableStringBuilder r61 = new SpannableStringBuilder(this.a.getText().subSequence(0, r60 + 1));
        if (this.b.g == false) goto L238;
        j[] r62 = (j[]) r61.getSpans(0, 1, j.class);
        if (r62 == null) goto L238;
        if (r62.length == 0) goto L238;
        r61.setSpan(new j(r62[0].a), r60, r61.length(), 17);
        r11 = true;
    L238:
        if (this.b.a.b.b() == TextDirectionHeuristics.FIRSTSTRONG_LTR) goto L250;
        if (r60 >= 0) goto L241;
    L249:
        r11 = true;
        goto L250
    L241:
        if (r60 > r61.length()) goto L249;
        if (this.b.a.b.b() != TextDirectionHeuristics.LTR) goto L247;
        r61.insert(r60, "\u200e");
        goto L249
    L247:
        if (this.b.a.b.b() != TextDirectionHeuristics.RTL) goto L249;
        r61.insert(r60, "\u200f");
    L250:
        if (r11 == false) goto L265;
        r2.a = r61;
        r2.d = -1;
        int r63 = this.a.getLineCount();
        a(r2);
        if (this.a.getLineCount() <= r63) goto L265;
    L255:
        if (this.a.getLineCount() <= r63) goto L265;
        int r64 = 2;
        if (r2.a.length() < 2) goto L265;
        CharSequence r65 = r2.a;
        if (Character.isLowSurrogate(r65.charAt(r65.length() - 2)) == true) goto L261;
    L263:
        r64 = 1;
    L264:
        CharSequence r66 = r2.a;
        r2.a = ((SpannableStringBuilder) r66).delete((r66.length() - 1) - r64, r2.a.length() - 1);
        a(r2);
        goto L255
    L261:
        if (r2.a.length() <= 2) goto L263;
    L225:
        if (this.b.g == true) goto L227;
    L42:
        r23 = r20.a.b.a;
        goto L43
    L35:
        if (r21 == MeasureMode.AT_MOST) goto L38;
        r22 = 32767.0f;
        goto L39
    L26:
        r15 = 1;
        goto L28
    L27:
        r15 = -1;
        goto L28
    L21:
        r14 = r9.a;
        goto L23
    L18:
        r13 = false;
        goto L19
    L11:
        if (r9.a == 1) goto L14;
        r12 = false;
        goto L15
    L7:
        r7 = null;
        goto L8
    L285:
        throw new RuntimeException("prepareSpan() should be called!");
    }

    public e(LynxContext r17, f r18) {
        this.c = 0;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = -1.0f;
        this.b = r18;
        m(r17);
        if (r18.g == false) goto L27;
        if (r18.h == true) goto L27;
        Layout r3 = this.a;
        if (r3.getEllipsisCount(r3.getLineCount() - 1) == 0) goto L27;
        if ((r18.a.a instanceof SpannableStringBuilder) == false) goto L27;
        int r4 = this.a.getLineCount() - 1;
        int r5 = this.a.getLineStart(r4) + this.a.getEllipsisStart(r4);
        SpannableStringBuilder r6 = new SpannableStringBuilder(r18.a.a);
        j[] r7 = (j[]) r6.getSpans(0, 1, j.class);
        if (r7 == null) goto L27;
        if (r7.length == 0) goto L27;
        j[] r8 = (j[]) r6.getSpans(r5, r5 + 1, j.class);
        if (r8 == null) goto L27;
        if (r8.length == 0) goto L27;
        j r9 = r8[r8.length - 1];
        int r10 = r6.getSpanStart(r9);
        int r11 = r6.getSpanEnd(r9);
        r6.removeSpan(r9);
        if (r10 >= r5) goto L25;
        r6.setSpan(r9, r10, r5, 33);
    L25:
        r6.setSpan(new j(r7[0].a), r5, r11, 34);
        r18.a.a = r6;
        this.a = null;
        m(r17);
    L27:
        if (this.a.getWidth() != 0) goto L29;
        return;
    L29:
        if (this.a.getHeight() == 0) goto L85;
        Spanned r1 = (Spanned) this.a.getText();
        m[] r12 = (m[]) r1.getSpans(0, r1.length(), m.class);
        int r13 = r12.length;
        int r14 = 0;
    L32:
        if (r14 >= r13) goto L52;
        m r15 = r12[r14];
        int r16 = r1.getSpanStart(r15);
        int r19 = r1.getSpanEnd(r15);
        if (r16 == 0) goto L36;
    L38:
        int r110 = this.a.getLineForOffset(r16);
        int r111 = this.a.getLineForOffset(r19);
        Rect r112 = new Rect();
        int r113 = r110;
    L39:
        if (r113 > r111) goto L50;
        Rect r114 = new Rect();
        this.a.getLineBounds(r113, r114);
        if (r113 != r110) goto L43;
        r114.left = Math.max(r114.left, (int) this.a.getPrimaryHorizontal(r16));
    L43:
        if (r113 != r111) goto L46;
        r114.right = Math.min(r114.right, (int) this.a.getPrimaryHorizontal(r19));
    L46:
        if (r114.right == 0) goto L49;
        r112.union(r114);
    L49:
        r113 = r113 + 1;
        goto L39
    L50:
        r15.a.set(r112);
    L51:
        r14 = r14 + 1;
        goto L32
    L36:
        if (r19 != r1.length()) goto L38;
        float r20 = d();
        float r115 = -this.d;
        r15.a.set(new Rect((int) r115, 0, (int) (r115 + r20), this.a.getHeight()));
        goto L51
    L52:
        z6a.l[] r2 = (z6a.l[]) r1.getSpans(0, r1.length(), z6a.l.class);
        int r21 = 0;
    L54:
        if (r21 >= r2.length) goto L86;
        z6a.l r22 = r2[r21];
        Layout r23 = this.a;
        r22.getClass();
        r22.d = new HashMap();
        int r24 = r23.getLineForOffset(r22.a);
    L57:
        if (r24 > r23.getLineForOffset(r22.b)) goto L73;
        int r25 = r23.getLineStart(r24);
        int r26 = r23.getLineEnd(r24);
        int r27 = r22.a;
        if (r27 <= r25) goto L62;
        if (r27 >= r26) goto L62;
        r25 = r27;
    L62:
        int r28 = r22.b;
        if (r28 <= r25) goto L66;
        if (r28 >= r26) goto L66;
        r26 = r28;
    L66:
        int r29 = (int) r23.getPrimaryHorizontal(r25);
        int r116 = (int) r23.getPrimaryHorizontal(r26);
        if (r25 != r23.getLineStart(r24)) goto L70;
        r29 = (int) r23.getLineLeft(r24);
    L70:
        if (r26 != r23.getLineEnd(r24)) goto L72;
        r116 = (int) r23.getLineRight(r24);
    L72:
        r22.d.put(Integer.valueOf(r24), new int[]{r29, r116});
        r24 = r24 + 1;
        goto L57
    L73:
        r21 = r21 + 1;
        goto L54
    L86:
        return;
    }

    public final void b(int r5, a r6) {
        SpannableStringBuilder r0 = (SpannableStringBuilder) r6.a;
        int r3 = 0;
        AbsoluteSizeSpan[] r1 = (AbsoluteSizeSpan[]) r0.getSpans(0, r0.length(), AbsoluteSizeSpan.class);
    L4:
        if (r3 >= r1.length) goto L6;
        r0.removeSpan(r1[r3]);
        r3 = r3 + 1;
        goto L4
    L6:
        r6.f.setTextSize(r5);
        a(r6);
    }

    public final CharSequence f(SpannableStringBuilder r3, int r4) {
        int r5 = Math.max(0, r4);
        SpannableStringBuilder r6 = (SpannableStringBuilder) r3.subSequence(0, Math.min(r3.length(), r5));
        if (this.b.a.b.b() != TextDirectionHeuristics.LTR) goto L6;
        r6.append("\u200e");
    L8:
        r6.append("…");
        return r6;
    L6:
        if (this.b.a.b.b() != TextDirectionHeuristics.RTL) goto L8;
        r6.append("\u200f");
        goto L8
    }

    public final StaticLayout.Builder e(CharSequence r4, Layout.Alignment r5, TextPaint r6, float r7) {
        StaticLayout.Builder r8 = StaticLayout.Builder.obtain(r4, 0, r4.length(), r6, (int) Math.floor(r7));
        r8.setAlignment(r5);
        r8.setLineSpacing(this.b.a.b.m, 1.0f);
        r8.setIncludePad(this.b.a.b.t);
        r8.setTextDirection(this.b.a.b.b());
        r8.setBreakStrategy(this.b.f);
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r8.setUseLineSpacingFromFallbacks(true);
    L5:
        return r8;
    }
}
