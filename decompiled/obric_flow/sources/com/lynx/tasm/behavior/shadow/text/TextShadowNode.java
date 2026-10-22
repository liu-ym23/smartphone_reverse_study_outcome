package com.lynx.tasm.behavior.shadow.text;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import com.bytedance.ies.xelement.text.inlinetruncation.LynxInlineTruncationShadowNode;
import com.bytedance.ies.xelement.text.text.LynxTextShadowNode;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.TraceController;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LayoutNodeManager;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.fontface.f;
import com.lynx.tasm.u0;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import ym.e;
import ym.g;
import ym.h;
import ym.i;
import ym.j;
import zm.a;
import zm.b;
import zm.b0;
import zm.c;
import zm.d0;
import zm.g0;
import zm.k;
import zm.l;
import zm.q;
import zm.t;
import zm.u;
import zm.x;
import zm.y;
import zm.z;

/* JADX INFO: loaded from: classes2.dex */
public class TextShadowNode extends BaseTextShadowNode implements e {
    public x K;
    public CharSequence L;
    public SpannableStringBuilder M;
    public SpannableStringBuilder N;
    public InlineTruncationShadowNode O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public float T;
    public float U;
    public float V;
    public int W;
    public i X;
    public g Y;

    public TextShadowNode() {
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = Float.MIN_VALUE;
        this.U = Float.MAX_VALUE;
        this.V = Float.MIN_VALUE;
        this.W = 0;
        this.X = null;
        this.Y = null;
        if ((this instanceof LynxInlineTruncationShadowNode) == true) goto L8;
        this.g = this;
        LayoutNodeManager r5 = this.f10334a;
        if (r5 == null) goto L9;
        this.d = true;
        r5.d(this.f10335b, this);
        return;
    L9:
        return;
    }

    public static void C(int r5, BaseTextShadowNode r10) {
        int r11 = 0;
    L4:
        if (r11 >= r10.j()) goto L12;
        ShadowNode r12 = r10.e(r11);
        if ((r12 instanceof NativeLayoutNodeRef) == false) goto L9;
        NativeLayoutNodeRef r13 = (NativeLayoutNodeRef) r12;
        r13.f10342v += r5;
        r13.f10343w += r5;
    L11:
        r11 = r11 + 1;
        goto L4
    L9:
        if ((r12 instanceof BaseTextShadowNode) == false) goto L11;
        C(r5, (BaseTextShadowNode) r12);
        goto L11
    }

    public static void F(BaseTextShadowNode r5, HashSet r10) {
        int r11 = 0;
    L4:
        if (r11 >= r5.j()) goto L12;
        ShadowNode r12 = r5.e(r11);
        if ((r12 instanceof NativeLayoutNodeRef) == false) goto L9;
        r10.add(Integer.valueOf(r12.f10335b));
    L11:
        r11 = r11 + 1;
        goto L4
    L9:
        if ((r12 instanceof BaseTextShadowNode) == false) goto L11;
        F((BaseTextShadowNode) r12, r10);
        goto L11
    }

    public static void H(BaseTextShadowNode r5) {
        int r10 = 0;
    L4:
        if (r10 >= r5.j()) goto L12;
        ShadowNode r11 = r5.e(r10);
        if ((r11 instanceof NativeLayoutNodeRef) == false) goto L9;
        NativeLayoutNodeRef r12 = (NativeLayoutNodeRef) r11;
        r12.f10342v = r12.f10344x;
        r12.f10343w = r12.f10345y;
    L11:
        r10 = r10 + 1;
        goto L4
    L9:
        if ((r11 instanceof BaseTextShadowNode) == false) goto L11;
        H((BaseTextShadowNode) r11);
        goto L11
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    public final boolean A() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r1v27, types: [android.text.SpannableStringBuilder, android.text.Spanned, java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r3v20, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28, types: [int] */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [int] */
    public long B(TextShadowNode r23, float r24, MeasureMode r25, float r26, MeasureMode r27) {
        if (TraceController.g == false) goto L12;
        HashMap r5 = new HashMap();
        CharSequence r10 = this.L;
        if (r10 == null) goto L7;
        String r11 = r10.toString();
    L9:
        if (r11.length() <= 50) goto L11;
        r11 = r11.substring(0, 50);
    L11:
        r5.put("preview_text", r11);
        TraceEvent.b(0, "TextShadowNode.measure", r5);
        goto L12
    L7:
        r11 = "";
    L12:
        this.K = null;
        this.N = null;
        MeasureMode r12 = MeasureMode.f10339b;
        float r16 = 0.0f;
        if (r25 == r12) goto L21;
        if (r27 == r12) goto L21;
        if (r24 != 0.0f) goto L21;
        if (r26 != 0.0f) goto L21;
        TraceEvent.a(0, "TextShadowNode.measure");
        float r13 = 0;
        return h.b(r13, r13);
    L21:
        CharSequence r14 = this.L;
        if (r14 != null) goto L25;
        TraceEvent.a(0, "TextShadowNode.measure");
        float r15 = 0;
        return h.b(r15, r15);
    L25:
        g r17 = this.Y;
        if (r17 == null) goto L30;
        i r18 = this.X;
        if (r18 == null) goto L30;
        x((SpannableStringBuilder) r14, r18, r17);
    L30:
        q r19 = this.f10357v;
        q r110 = r19;
        b0 r20 = new b0(r14, r19.b(), r25, r27, r24, r26, this.E, this.P, this.A, this.C);
        z r111 = y.f23548a;
        this.K = r111.a(k(), r20);
        InlineTruncationShadowNode r21 = this.O;
        if (r21 == null) goto L40;
        H(r21);
        SpannableStringBuilder r22 = this.M;
        if (r22 == null) goto L40;
        g r28 = this.Y;
        if (r28 == null) goto L40;
        i r29 = this.X;
        if (r29 == null) goto L40;
        this.O.x(r22, r29, r28);
    L40:
        if (this.M != null) goto L42;
    L134:
        float r30 = this.K.i();
        float r31 = this.K.g();
        this.f10338i = this.K.f23545a.getLineBaseline(0);
        TraceEvent.a(0, "TextShadowNode.measure");
        return h.b(r31, r30);
    L42:
        if (this.K.k() == false) goto L134;
        if (r25 == r12) goto L134;
        x r32 = r111.a(k(), new b0(this.M, r110.b(), MeasureMode.d, r27, r24, r26, this.E, this.P, this.A, this.C));
        Layout r33 = r32.f23545a;
        if (r33.getLineCount() != 1) goto L134;
        ?? r112 = 0;
        if (r33.getLineEnd(0) != r33.getText().length()) goto L134;
        x r34 = this.K;
        if (r27 != r12) goto L51;
    L59:
        int r35 = r34.h() - 1;
    L58:
        int r113 = r35;
        if (this.K.f23545a.getLineEnd(r113) == this.L.length()) goto L63;
    L65:
        float r36 = r32.g();
        int r114 = this.K.f23545a.getLineStart(r113);
        int r37 = this.K.f23545a.getLineEnd(r113);
        float r38 = r24 - r36;
        if ((this.K.f23545a.getLineMax(r113) - this.K.f23545a.getLineLeft(r113)) <= r38) goto L102;
        Layout r39 = this.K.f23545a;
        HashMap r40 = new HashMap();
        ArrayList r41 = new ArrayList();
        r41.add(Float.valueOf(r39.getLineLeft(r113)));
        r41.add(Float.valueOf(r39.getLineRight(r113)));
        int r42 = r114;
    L69:
        if (r42 >= r37) goto L74;
        if (Character.isHighSurrogate(r39.getText().charAt(r42)) == true) goto L73;
        float r43 = r39.getSecondaryHorizontal(r42);
        r41.add(Float.valueOf(r43));
        r40.put(Integer.valueOf(r42), Float.valueOf(r43));
    L73:
        r42 = r42 + 1;
        goto L69
    L74:
        Collections.sort(r41);
        Iterator r44 = r40.entrySet().iterator();
    L76:
        if (r44.hasNext() == false) goto L93;
        Map.Entry r45 = (Map.Entry) r44.next();
        Integer r46 = (Integer) r45.getKey();
        int r47 = r46.intValue();
        Float r48 = (Float) r45.getValue();
        float r115 = r48.floatValue();
        int r49 = Collections.binarySearch(r41, r48);
        if (r39.isRtlCharAt(r47) == false) goto L84;
    L79:
        if (r49 < 0) goto L88;
        if (((Float) r41.get(r49)).floatValue() < r115) goto L88;
        r49 = r49 - 1;
    L88:
        if (r49 < 0) goto L92;
        if (r49 >= r41.size()) goto L92;
        r40.put(r46, Float.valueOf(Math.abs(r115 - ((Float) r41.get(r49)).floatValue())));
    L92:
        r40.put(r46, Float.valueOf(0.0f));
    L84:
        if (r49 >= r41.size()) goto L88;
        if (((Float) r41.get(r49)).floatValue() > r115) goto L88;
        r49 = r49 + 1;
        goto L84
    L93:
        int r50 = r114;
    L94:
        if (r50 >= r37) goto L102;
        if (r40.containsKey(Integer.valueOf(r50)) == false) goto L101;
        float r51 = ((Float) r40.get(Integer.valueOf(r50))).floatValue() + r16;
        if (r51 > r38) goto L99;
        r16 = r51;
        goto L101
    L99:
        r37 = r50;
    L101:
        r50 = r50 + 1;
    L102:
        if (r37 < r114) goto L133;
        int r116 = r37;
    L104:
        if (r116 <= r114) goto L108;
        if (Character.isWhitespace(this.L.charAt(r116 - 1)) == false) goto L108;
        r116 = r116 - 1;
    L108:
        if (r116 > r114) goto L110;
        CharSequence r52 = new SpannableStringBuilder();
    L111:
        int r53 = r52.length() + r114;
        C(r53, this.O);
        ?? r54 = ((SpannableStringBuilder) this.L.subSequence(r112, r114)).append(r52).append(this.M);
        this.N = r54;
        l[] r55 = (l[]) r54.getSpans(r53, r54.length(), l.class);
        ?? r56 = r112;
    L113:
        if (r56 >= r55.length) goto L118;
        if (r54.getSpanStart(r55[r56]) < r53) goto L117;
        l r57 = r55[r56];
        r57.f23500a += r53;
        r57.f23501b += r53;
    L117:
        r56 = r56 + 1;
        goto L113
    L118:
        l[] r58 = (l[]) r54.getSpans(r112, r53, l.class);
        ?? r59 = r112;
    L120:
        if (r59 >= r58.length) goto L128;
        l r60 = r58[r59];
        if (r60.f23500a < r53) goto L125;
        r60.f23502c = r112;
    L127:
        r59 = r59 + 1;
        goto L120
    L125:
        if (r60.f23501b <= r53) goto L127;
        r60.f23501b = r53;
        goto L127
    L128:
        boolean r61 = r110.f23526q;
        q r62 = this.O.f10357v;
        r110.f23526q = r61 | r62.f23526q;
        r110.f23527r |= r62.f23527r;
        int r117 = r116;
        q r210 = r110;
        int r118 = r114;
        x r63 = y.f23548a.a(k(), new b0(this.N, r110.b(), r25, r27, r24, r26, this.E, this.P, this.A, this.C));
        this.K = r63;
        if (r63.f23545a.getLineEnd(r113) >= this.N.length()) goto L132;
        if (r117 <= r118) goto L132;
        r37 = r117 - 1;
        H(this.O);
        r114 = r118;
        r112 = 0;
        r110 = r210;
    L132:
        r37 = r117;
        goto L133
    L110:
        r52 = this.L.subSequence(r114, r116);
    L133:
        this.W = this.L.length() - r37;
        goto L134
    L63:
        if (this.K.f23545a.getWidth() > r24) goto L65;
    L51:
        if (r34.i() <= r26) goto L59;
        Layout r64 = r34.f23545a;
        r35 = r64.getLineCount() - 1;
    L53:
        if (r35 <= 0) goto L58;
        if (r64.getLineBottom(r35) <= r26) goto L58;
        r35 = r35 - 1;
        goto L53
    }

    public final void D(SpannableStringBuilder r5, BaseTextShadowNode r10) {
        ArrayList r11 = new ArrayList();
        r10.w(r5, r11);
        int r12 = r11.size() - 1;
    L3:
        if (r12 < 0) goto L5;
        ((b) r11.get(r12)).a(r5);
        r12 = r12 - 1;
        goto L3
    L5:
        MetricAffectingSpan[] r13 = (MetricAffectingSpan[]) r5.getSpans(0, r5.length(), MetricAffectingSpan.class);
        int r14 = 0;
    L7:
        if (r14 >= r13.length) goto L38;
        MetricAffectingSpan r15 = r13[r14];
        if ((r15 instanceof a) == false) goto L12;
        int r16 = ((a) r15).f23456a;
    L16:
        if (this.S == false) goto L18;
    L29:
        boolean r17 = true;
    L30:
        this.S = r17;
        if (this.R == false) goto L33;
    L36:
        boolean r18 = true;
    L37:
        this.R = r18;
        r14 = r14 + 1;
        goto L7
    L33:
        if (r16 == 6) goto L36;
        r18 = false;
        goto L37
    L18:
        if (r16 == 5) goto L29;
        if (r16 == 8) goto L29;
        if (r16 == 4) goto L29;
        if (r16 == 7) goto L29;
        if (r16 == 11) goto L29;
        r17 = false;
        goto L30
    L12:
        if ((r15 instanceof k) == false) goto L14;
        r16 = ((k) r15).f23497a;
        goto L16
    L14:
        r16 = 0;
        goto L16
    }

    public final void E(BaseTextShadowNode r10) {
        LynxContext r5 = k();
        q r11 = r10.f10357v;
        DecimalFormat r12 = t.f23539a;
        String r13 = r11.f23529u;
        if (TextUtils.isEmpty(r13) == true) goto L5;
        Typeface r14 = g0.c(r5, r13, r11.d());
    L6:
        TextPaint r15 = t.c(r11, r14);
        if (this.S == false) goto L9;
        this.U = Math.min(r15.getFontMetrics().ascent, this.U);
        this.V = Math.max(r15.getFontMetrics().descent, this.V);
    L9:
        int r16 = 0;
        if (this.R == false) goto L13;
        Rect r17 = new Rect();
        r15.getTextBounds("x", 0, 1, r17);
        this.T = Math.max(this.T, r17.height());
    L13:
        if (r16 >= r10.j()) goto L20;
        ShadowNode r18 = r10.e(r16);
        if ((r18 instanceof InlineTextShadowNode) == false) goto L17;
    L18:
        E((BaseTextShadowNode) r18);
    L19:
        r16 = r16 + 1;
        goto L13
    L17:
        if ((r18 instanceof InlineTruncationShadowNode) == false) goto L19;
    L20:
        return;
    L5:
        r14 = null;
        goto L6
    }

    public final void G(CharSequence r10, c r11) {
        int r5 = 0;
        a[] r12 = (a[]) ((SpannableStringBuilder) r10).getSpans(0, r10.length(), a.class);
        int r13 = 0;
    L4:
        if (r13 >= r12.length) goto L10;
        a r14 = r12[r13];
        r14.d = r11;
        u0 r15 = k().K;
        if (r15 == null) goto L8;
        boolean r16 = r15.s;
    L9:
        r14.e = r16;
        r13 = r13 + 1;
        goto L4
    L8:
        r16 = false;
        goto L9
    L10:
        k[] r17 = (k[]) ((SpannableStringBuilder) r10).getSpans(0, r10.length(), k.class);
    L12:
        if (r5 >= r17.length) goto L14;
        k r18 = r17[r5];
        r18.d = r11;
        r18.e = this.f10357v.f23520k;
        r5 = r5 + 1;
        goto L12
    }

    public int I() {
        CharSequence r5 = this.L;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.length();
    }

    public boolean J() {
        if (j() != 1) goto L7;
        if ((e(0) instanceof RawTextShadowNode) == false) goto L7;
    L11:
        if (ym.k.b(this.f10357v.f23520k) == false) goto L13;
        return true;
    L13:
        return false;
    L7:
        if (j() != 0) goto L13;
        if (this.G == null) goto L13;
        goto L13
    }

    public void K() {
        boolean r5 = this.A;
        q r10 = this.f10357v;
        if (r5 == true) goto L14;
        ShadowNode r11 = this;
        int r12 = 3;
    L6:
        if (r11.j() <= 0) goto L12;
        r11 = r11.e(0);
        if ((r11 instanceof InlineTextShadowNode) == false) goto L12;
        int r13 = ((InlineTextShadowNode) r11).f10357v.d;
        if (r13 == 3) goto L6;
        r12 = r13;
    L12:
        if (r12 == 3) goto L14;
        r10.d = r12;
    L14:
        boolean r14 = J();
        r10.s = r14;
        if (r14 == true) goto L17;
        SpannableStringBuilder r15 = new SpannableStringBuilder();
        this.L = r15;
        D(r15, this);
        this.O = null;
        int r16 = 0;
    L31:
        if (r16 >= j()) goto L37;
        if ((e(r16) instanceof InlineTruncationShadowNode) == true) goto L34;
        r16 = r16 + 1;
        goto L31
    L34:
        this.O = (InlineTruncationShadowNode) e(r16);
    L37:
        if (this.O == null) goto L39;
        SpannableStringBuilder r17 = new SpannableStringBuilder();
        this.M = r17;
        D(r17, this.O);
        r10.f23519j = 0;
    L39:
        this.U = Float.MAX_VALUE;
        this.V = Float.MIN_VALUE;
        this.T = Float.MIN_VALUE;
        if (this.S == false) goto L42;
    L43:
        E(this);
    L44:
        float r18 = r10.f23520k;
        if (r18 != 1.0E21f) goto L47;
        r18 = 0.0f;
    L47:
        c r19 = new c(Arrays.asList(new Float[]{Float.valueOf(this.U), Float.valueOf(this.V), Float.valueOf(this.T), Float.valueOf(r18)}), 0);
        G(this.L, r19);
        SpannableStringBuilder r20 = this.M;
        if (r20 == null) goto L60;
        G(r20, r19);
        return;
    L60:
        return;
    L42:
        if (this.R == false) goto L44;
    L17:
        if (j() != 0) goto L19;
        this.L = s(this.G, false);
    L21:
        if (this.L == null) goto L61;
        ArrayList r21 = new ArrayList();
        SpannableStringBuilder r22 = new SpannableStringBuilder();
        r22.append(this.L);
        t(0, this.L.length(), r21);
        Iterator r23 = r21.iterator();
    L25:
        if (r23.hasNext() == false) goto L27;
        ((b) r23.next()).a(r22);
        goto L25
    L27:
        this.L = r22;
        return;
    L61:
        return;
    L19:
        RawTextShadowNode r24 = (RawTextShadowNode) e(0);
        this.L = s(r24.f10362v, r24.f10363w);
        goto L21
    }

    @Override // ym.e
    public final j a(g r10, i r11) {
        this.X = r11;
        this.Y = r10;
        this.W = 0;
        long r12 = B(this, r11.f23299a, r11.f23300b, r11.f23301c, r11.d);
        return new j(Float.intBitsToFloat((int) (r12 >> 32)), Float.intBitsToFloat((int) r12), this.f10338i);
    }

    @Override // com.lynx.tasm.behavior.shadow.LayoutNode
    public final void d() {
        if ((this instanceof LynxInlineTruncationShadowNode) == true) goto L6;
        this.K = null;
        this.M = null;
        K();
        return;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final Object l() {
        if (this.K != null) goto L5;
        return null;
    L5:
        DecimalFormat r5 = t.f23539a;
        HashMap r10 = this.f10352p;
        q r11 = this.f10357v;
        if (r10 != null) goto L8;
    L40:
        boolean r12 = true;
        boolean r13 = false;
        q r14 = r11;
    L42:
        if (r14.f23527r == false) goto L44;
    L47:
        HashSet r15 = new HashSet();
        y(this.K.f23545a.getText(), r15, this.L.length() - this.W);
        InlineTruncationShadowNode r16 = this.O;
        if (r16 != null) goto L50;
    L52:
        x r17 = this.K;
        Layout r18 = r17.f23545a;
        boolean r19 = r14.f23526q;
        if (this.Q == true) goto L55;
    L57:
        r12 = r13;
    L58:
        d0 r20 = new d0(r18, r19, r15, r12);
        r20.e = new PointF(r17.d, r17.e);
        r20.f = this.F;
        r20.g = this.L;
        this.K = null;
        return r20;
    L55:
        if (r14.d != 5) goto L57;
    L50:
        if (this.W != 0) goto L52;
        F(r16, r15);
        goto L52
    L44:
        if (this.O != null) goto L47;
        r15 = null;
        goto L52
    L8:
        if (r10.containsKey("layout") == false) goto L40;
        x r21 = this.K;
        if (r21 == null) goto L40;
        Layout r22 = r21.f23545a;
        if (r22 != null) goto L14;
        r14 = r11;
        r12 = true;
        r13 = false;
        goto L42
    L14:
        int r23 = this.f10335b;
        int r24 = r11.f23519j;
        int r25 = r21.h();
        int r110 = this.W;
        if (r110 != 0) goto L17;
        r110 = this.K.f23547c;
    L17:
        int r111 = I();
        float r112 = this.K.a();
        boolean r113 = this instanceof LynxTextShadowNode;
        com.lynx.animax.i r114 = new com.lynx.animax.i(r23, "layout");
        r114.a("lineCount", Integer.valueOf(r25));
        if (r25 > r22.getLineCount()) goto L20;
        if (r25 == 0) goto L20;
        ArrayList r26 = new ArrayList();
        int r27 = 0;
    L23:
        if (r27 >= r25) goto L25;
        HashMap r28 = new HashMap();
        r28.put("start", Integer.valueOf(r22.getLineStart(r27)));
        r28.put("end", Integer.valueOf(r22.getLineEnd(r27)));
        r28.put("ellipsisCount", Integer.valueOf(r22.getEllipsisCount(r27)));
        r26.add(r28);
        r27 = r27 + 1;
        r11 = r11;
        goto L23
    L25:
        q r115 = r11;
        r12 = true;
        int r29 = r25 - 1;
        HashMap r30 = (HashMap) r26.get(r29);
        int r31 = ((Integer) r30.get("ellipsisCount")).intValue();
        int r116 = ((Integer) r30.get("end")).intValue();
        if (r110 <= 0) goto L29;
    L34:
        td.e.f(r110, r30, "ellipsisCount", r111, "end");
        r114.a("lines", r26);
        if (r113 == true) goto L37;
        HashMap r32 = new HashMap();
        r32.put("width", Float.valueOf(r112 / DisplayMetricsHolder.a().density));
        r32.put("height", Float.valueOf(r22.getLineBottom(r29) / DisplayMetricsHolder.a().density));
        r114.a("size", r32);
    L37:
        r13 = false;
    L39:
        com.lynx.tasm.utils.j.a().post(new s8.h(9, this, r13, r114));
        r14 = r115;
        goto L42
    L29:
        if (r25 < r22.getLineCount()) goto L33;
        if (r24 == 0) goto L33;
        r110 = r31;
    L33:
        r110 = r111 - r116;
    L20:
        r115 = r11;
        r12 = true;
        LynxLog.b(4, "TextHelper", "getTextLayoutEvent: get lineCount error");
        r13 = false;
        r114.a("lineCount", 0);
        goto L39
    }

    @c0(name = "-x-auto-font-size")
    public void setAutoFontSize(ReadableArray r5) {
        q r10 = this.f10357v;
        if (r5 == null) goto L8;
        r10.getClass();
        if (r5.size() != 4) goto L8;
        r10.f23530v = r5.getBoolean(0);
        r10.f23532x = (float) r5.getDouble(1);
        r10.f23531w = (float) r5.getDouble(2);
        r10.f23533y = (float) r5.getDouble(3);
    L9:
        n();
        return;
    L8:
        r10.f23530v = false;
        goto L9
    }

    @c0(name = "-x-auto-font-size-preset-sizes")
    public void setAutoFontSizePresetSizes(ReadableArray r5) {
        q r10 = this.f10357v;
        if (r5 == null) goto L12;
        r10.getClass();
        if (r5.size() == 0) goto L12;
        r10.f23534z = new float[r5.size()];
        int r11 = 0;
    L9:
        if (r11 >= r5.size()) goto L11;
        r10.f23534z[r11] = (float) r5.getDouble(r11);
        r11 = r11 + 1;
        goto L9
    L11:
        return;
    L12:
        r10.f23534z = null;
    }

    @c0(name = "enable-full-justify")
    public void setEnableFullJustify(boolean r5) {
        if (this.Q == r5) goto L6;
        n();
        this.Q = r5;
        return;
    }

    @c0(name = "tail-color-convert")
    public void setEnableTailColorConvert(boolean r5) {
        this.P = r5;
        n();
    }

    @c0(name = "hyphens")
    public void setHyphen(int r5) {
        if (r5 != 2) goto L5;
        boolean r10 = true;
    L6:
        this.f10357v.B = r10;
        n();
        return;
    L5:
        r10 = false;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    @c0(defaultFloat = 1.0E21f, name = "line-height")
    public void setLineHeight(float r5) {
        this.f10361z = r5;
        if (this.f10358w == false) goto L10;
        com.lynx.tasm.b0 r10 = this.f10349m;
        if (r10 == null) goto L10;
        if (r10.H != null) goto L9;
        r10.H = Float.valueOf(r10.getResources().getConfiguration().fontScale);
    L9:
        r5 = r5 * r10.H.floatValue();
    L10:
        q r11 = this.f10357v;
        if (r11.f23520k == r5) goto L14;
        r11.f23520k = r5;
        n();
        return;
    }

    @c0(defaultInt = 0, name = "text-single-line-vertical-align")
    public void setVerticalTextAlign(String r5) {
        boolean r10 = "center".equals(r5);
        q r11 = this.f10357v;
        if (r10 == false) goto L6;
        r11.F = 11;
    L12:
        n();
        return;
    L6:
        if ("top".equals(r5) == false) goto L9;
        r11.F = 4;
        goto L12
    L9:
        if ("bottom".equals(r5) == false) goto L11;
        r11.F = 7;
        goto L12
    L11:
        r11.F = 0;
        goto L12
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    public final void t(int r10, int r11, ArrayList r12) {
        q r5 = this.f10357v;
        if (r5.f23524o == null) goto L9;
        u r13 = r5.f23524o;
        ShadowNode r14 = (ShadowNode) this.f10337h.f23310b;
        float r15 = r14.f10334a.g(r14.f10335b);
        int r16 = r13.f23540a;
        float r17 = r13.f23541b;
        if (r16 == 0) goto L8;
        r17 = r17 * r15;
    L8:
        r12.add(new b(r10, r11, new LeadingMarginSpan.Standard((int) r17, 0)));
    L9:
        super.t(r10, r11, r12);
        if (TextUtils.isEmpty(r5.f23529u) == true) goto L17;
        String r18 = r5.f23529u;
        int r19 = r5.d();
        if (g0.c(k(), r18, r19) != null) goto L15;
        f.f10866a.a(k(), r18, r19, new zm.c0(this));
        return;
    L15:
        r5.A = true;
        return;
    }

    @Override // ym.e
    public final void a() {
        x r5 = this.K;
        if (r5 != null) goto L5;
        return;
    L5:
        Layout r10 = r5.f23545a;
        CharSequence r11 = this.N;
        if (r11 != null) goto L8;
        r11 = this.L;
    L8:
        u(r10, (SpannableStringBuilder) r11, new PointF(r5.d, r5.e));
    }
}
