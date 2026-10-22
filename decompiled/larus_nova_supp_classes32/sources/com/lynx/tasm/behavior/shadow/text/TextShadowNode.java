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
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.shadow.LayoutNode;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.fontface.FontFaceManager;
import com.lynx.tasm.utils.UIThreadUtils;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import y6a.i;
import y6a.j;
import y6a.l;
import z6a.k;
import z6a.s;
import z6a.t;
import z6a.v;
import z6a.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class TextShadowNode extends BaseTextShadowNode implements y6a.e {
    public e M;
    public CharSequence N;
    public CharSequence O;
    public CharSequence P;
    public InlineTruncationShadowNode Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public float V;
    public float W;
    public float X;
    public int Y;
    public j Z;
    public y6a.g k0;

    public static class a implements g.c {
        public final WeakReference<ShadowNode> a;

        public a(ShadowNode r2) {
            this.a = new WeakReference(r2);
        }

        @Override // com.lynx.tasm.behavior.shadow.text.g.c
        public final void a(Typeface r2, int r3) {
            ShadowNode r4 = this.a.get();
            if (r4 != null) goto L5;
            return;
        L5:
            if (r4.o == false) goto L8;
            return;
        L8:
            if ((r4 instanceof BaseTextShadowNode) == false) goto L10;
            ((BaseTextShadowNode) r4).v.B = true;
        L10:
            r4.q();
        }
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    public final boolean K() {
        return true;
    }

    public int Q() {
        CharSequence r0 = this.N;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.length();
    }

    public void U() {
        if (this.A == true) goto L14;
        int r3 = 3;
        ShadowNode r0 = this;
    L6:
        if (r0.l() <= 0) goto L12;
        r0 = r0.k(0);
        if ((r0 instanceof InlineTextShadowNode) == false) goto L12;
        int r4 = ((InlineTextShadowNode) r0).v.d;
        if (r4 == 3) goto L6;
        r3 = r4;
    L12:
        if (r3 == 3) goto L14;
        this.v.d = r3;
    L14:
        boolean r1 = T();
        this.v.s = r1;
        if (r1 == true) goto L17;
        SpannableStringBuilder r2 = new SpannableStringBuilder();
        this.N = r2;
        O(r2, this);
        this.Q = null;
        int r5 = 0;
    L31:
        if (r5 >= l()) goto L37;
        if ((k(r5) instanceof InlineTruncationShadowNode) == true) goto L34;
        r5 = r5 + 1;
        goto L31
    L34:
        this.Q = (InlineTruncationShadowNode) k(r5);
    L37:
        if (this.Q == null) goto L39;
        SpannableStringBuilder r6 = new SpannableStringBuilder();
        this.O = r6;
        O(r6, this.Q);
        com.lynx.tasm.behavior.shadow.text.a r7 = this.v;
        boolean r8 = r7.q;
        com.lynx.tasm.behavior.shadow.text.a r9 = this.Q.v;
        r7.q = r8 | r9.q;
        r7.r |= r9.r;
        r7.j = 0;
    L39:
        this.W = Float.MAX_VALUE;
        this.X = Float.MIN_VALUE;
        this.V = Float.MIN_VALUE;
        if (this.U == false) goto L42;
    L43:
        P(this);
    L44:
        float r10 = this.v.k;
        if (r10 != 1.0E21f) goto L47;
        r10 = 0.0f;
    L47:
        z6a.c r11 = new z6a.c(Arrays.asList(new Float[]{Float.valueOf(this.W), Float.valueOf(this.X), Float.valueOf(this.V), Float.valueOf(r10)}));
        S(this.N, r11);
        CharSequence r12 = this.O;
        if (r12 == null) goto L60;
        S(r12, r11);
        return;
    L60:
        return;
    L42:
        if (this.T == false) goto L44;
    L17:
        if (l() != 0) goto L19;
        this.N = H(this.I, false);
    L21:
        if (this.N != null) goto L23;
        return;
    L23:
        ArrayList r13 = new ArrayList();
        SpannableStringBuilder r14 = new SpannableStringBuilder();
        r14.append(this.N);
        F(0, this.N.length(), r13);
        Iterator r15 = r13.iterator();
    L25:
        if (r15.hasNext() == false) goto L27;
        ((BaseTextShadowNode.a) r15.next()).a(r14);
        goto L25
    L27:
        this.N = r14;
        return;
    L19:
        RawTextShadowNode r16 = (RawTextShadowNode) k(0);
        this.N = H(r16.v, r16.w);
        goto L21
    }

    @Override // com.lynx.tasm.behavior.shadow.LayoutNode
    public final void g() {
        if ((this instanceof LynxInlineTruncationShadowNode) == true) goto L6;
        this.M = null;
        this.O = null;
        U();
        return;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public Object m() {
        if (this.M != null) goto L5;
        return null;
    L5:
        DecimalFormat r0 = b.a;
        Map<String, EventsListener> r1 = this.p;
        boolean r2 = false;
        if (r1 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L22;
        e r4 = this.M;
        if (r4 == null) goto L22;
        Layout r5 = r4.a;
        if (r5 == null) goto L22;
        int r6 = this.b;
        int r7 = this.v.j;
        int r8 = r4.h();
        int r9 = this.Y;
        if (r9 != 0) goto L20;
        r9 = this.M.c;
    L20:
        UIThreadUtils.runOnUiThread(new s(this, b.j(r6, r5, r7, r8, r9, Q(), this.M.d(), !(this instanceof LynxTextShadowNode))));
    L22:
        if (this.v.r == false) goto L24;
    L27:
        HashSet r10 = new HashSet();
        J(this.M.a.getText(), r10, this.N.length() - this.Y);
        InlineTruncationShadowNode r11 = this.Q;
        if (r11 != null) goto L30;
    L32:
        e r12 = this.M;
        Layout r13 = r12.a;
        com.lynx.tasm.behavior.shadow.text.a r14 = this.v;
        boolean r15 = r14.q;
        if (this.S == true) goto L35;
    L37:
        w r16 = new w(r13, r15, r10, r2);
        r16.e = new PointF(r12.d, r12.e);
        r16.f = this.G;
        r16.g = this.N;
        this.M = null;
        return r16;
    L35:
        if (r14.d != 5) goto L37;
        r2 = true;
        goto L37
    L30:
        if (this.Y != 0) goto L32;
        R(r11, r10);
        goto L32
    L24:
        if (this.Q != null) goto L27;
        r10 = null;
        goto L32
    L8:
        if (r1.containsKey("layout") == false) goto L10;
        r3 = true;
        goto L11
    }

    public TextShadowNode() {
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = Float.MIN_VALUE;
        this.W = Float.MAX_VALUE;
        this.X = Float.MIN_VALUE;
        this.Y = 0;
        this.Z = null;
        this.k0 = null;
        if ((this instanceof LynxInlineTruncationShadowNode) == true) goto L6;
        h(this);
        return;
    }

    public boolean T() {
        if (l() != 1) goto L7;
        if ((k(0) instanceof RawTextShadowNode) == false) goto L7;
    L11:
        if (l.a(this.v.k) == false) goto L16;
        return true;
    L16:
        return false;
    L7:
        if (l() == 0) goto L9;
        return false;
    L9:
        if (this.I != null) goto L11;
        return false;
    }

    public static void V(BaseTextShadowNode r3) {
        int r0 = 0;
    L4:
        if (r0 >= r3.l()) goto L12;
        ShadowNode r1 = r3.k(r0);
        if ((r1 instanceof NativeLayoutNodeRef) == false) goto L9;
        NativeLayoutNodeRef r2 = (NativeLayoutNodeRef) r1;
        r2.v = r2.x;
        r2.w = r2.y;
    L11:
        r0 = r0 + 1;
        goto L4
    L9:
        if ((r1 instanceof BaseTextShadowNode) == false) goto L11;
        V((BaseTextShadowNode) r1);
        goto L11
    }

    public final void P(BaseTextShadowNode r6) {
        LynxContext r0 = getContext();
        com.lynx.tasm.behavior.shadow.text.a r1 = r6.v;
        DecimalFormat r2 = b.a;
        String r3 = r1.u;
        if (TextUtils.isEmpty(r3) == true) goto L5;
        Typeface r4 = g.d(r0, r3, r1.e());
    L6:
        TextPaint r5 = b.l(r1, r4);
        if (this.U == false) goto L9;
        this.W = Math.min(r5.getFontMetrics().ascent, this.W);
        this.X = Math.max(r5.getFontMetrics().descent, this.X);
    L9:
        int r7 = 0;
        if (this.T == false) goto L13;
        Rect r8 = new Rect();
        r5.getTextBounds("x", 0, 1, r8);
        this.V = Math.max(this.V, r8.height());
    L13:
        if (r7 >= r6.l()) goto L20;
        ShadowNode r9 = r6.k(r7);
        if ((r9 instanceof InlineTextShadowNode) == false) goto L17;
    L18:
        P((BaseTextShadowNode) r9);
    L19:
        r7 = r7 + 1;
        goto L13
    L17:
        if ((r9 instanceof InlineTruncationShadowNode) == false) goto L19;
    L20:
        return;
    L5:
        r4 = null;
        goto L6
    }

    @LynxProp(name = "-x-auto-font-size")
    public void setAutoFontSize(ReadableArray r7) {
        com.lynx.tasm.behavior.shadow.text.a r0 = this.v;
        if (r7 == null) goto L8;
        r0.getClass();
        if (r7.size() != 4) goto L8;
        boolean r1 = r7.getBoolean(0);
        float r2 = (float) r7.getDouble(1);
        float r3 = (float) r7.getDouble(2);
        float r8 = (float) r7.getDouble(3);
        r0.v = r1;
        r0.x = r2;
        r0.w = r3;
        r0.y = r8;
    L9:
        q();
        return;
    L8:
        r0.v = false;
        goto L9
    }

    @LynxProp(name = "-x-auto-font-size-line-ranges")
    public void setAutoFontSizeLineRanges(ReadableArray r12) {
        com.lynx.tasm.behavior.shadow.text.a r0 = this.v;
        ArrayList r1 = null;
        if (r12 == null) goto L29;
        r0.getClass();
        if (r12.size() == 0) goto L29;
        ArrayList r2 = new ArrayList();
        int r4 = 0;
    L9:
        if (r4 >= r12.size()) goto L25;
        if (r12.getType(r4).equals(ReadableType.Array) == false) goto L23;
        ReadableArray r5 = r12.getArray(r4);
        if (r5 == null) goto L23;
        if (r5.size() < 4) goto L23;
        int r6 = (int) r5.getDouble(0);
        int r7 = (int) r5.getDouble(1);
        if (r6 <= 0) goto L23;
        if (r7 < r6) goto L23;
        r2.add(new com.lynx.tasm.behavior.shadow.text.a.C0051a(r6, r7, (float) r5.getDouble(2), (float) r5.getDouble(3)));
    L23:
        r4 = r4 + 1;
        goto L9
    L25:
        if (r2.isEmpty() == true) goto L28;
        r1 = r2;
    L28:
        r0.A = r1;
    L30:
        q();
        return;
    L29:
        r0.A = null;
        goto L30
    }

    @LynxProp(name = "-x-auto-font-size-preset-sizes")
    public void setAutoFontSizePresetSizes(ReadableArray r8) {
        com.lynx.tasm.behavior.shadow.text.a r0 = this.v;
        float[] r1 = null;
        if (r8 == null) goto L15;
        r0.getClass();
        if (r8.size() == 0) goto L15;
        int r2 = r8.size();
        float[] r3 = new float[r2];
        int r4 = 0;
    L9:
        if (r4 >= r8.size()) goto L11;
        r3[r4] = (float) r8.getDouble(r4);
        r4 = r4 + 1;
        goto L9
    L11:
        if (r2 == 0) goto L14;
        r1 = r3;
    L14:
        r0.z = r1;
        return;
    L15:
        r0.z = null;
    }

    @LynxProp(name = "enable-full-justify")
    public void setEnableFullJustify(boolean r2) {
        if (this.S == r2) goto L6;
        q();
        this.S = r2;
        return;
    }

    @LynxProp(name = "tail-color-convert")
    public void setEnableTailColorConvert(boolean r1) {
        this.R = r1;
        q();
    }

    @LynxProp(name = "hyphens")
    public void setHyphen(int r3) {
        com.lynx.tasm.behavior.shadow.text.a r0 = this.v;
        if (r3 != 2) goto L5;
        boolean r4 = true;
    L6:
        r0.C = r4;
        q();
        return;
    L5:
        r4 = false;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    @LynxProp(defaultFloat = 1.0E21f, name = "line-height")
    public void setLineHeight(float r1) {
        N(r1);
    }

    @LynxProp(defaultInt = 0, name = "text-single-line-vertical-align")
    public void setVerticalTextAlign(String r2) {
        if ("center".equals(r2) == false) goto L6;
        this.v.G = 11;
    L12:
        q();
        return;
    L6:
        if ("top".equals(r2) == false) goto L9;
        this.v.G = 4;
        goto L12
    L9:
        if ("bottom".equals(r2) == false) goto L11;
        this.v.G = 7;
        goto L12
    L11:
        this.v.G = 0;
        goto L12
    }

    public static void R(BaseTextShadowNode r3, Set r4) {
        int r0 = 0;
    L4:
        if (r0 >= r3.l()) goto L12;
        ShadowNode r1 = r3.k(r0);
        if ((r1 instanceof NativeLayoutNodeRef) == false) goto L9;
        HashSet r2 = (HashSet) r4;
        r2.add(Integer.valueOf(r1.b));
    L11:
        r0 = r0 + 1;
        goto L4
    L9:
        if ((r1 instanceof BaseTextShadowNode) == false) goto L11;
        R((BaseTextShadowNode) r1, r4);
        goto L11
    }

    public static void W(int r3, BaseTextShadowNode r4) {
        int r0 = 0;
    L4:
        if (r0 >= r4.l()) goto L12;
        ShadowNode r1 = r4.k(r0);
        if ((r1 instanceof NativeLayoutNodeRef) == false) goto L9;
        NativeLayoutNodeRef r2 = (NativeLayoutNodeRef) r1;
        r2.v += r3;
        r2.w += r3;
    L11:
        r0 = r0 + 1;
        goto L4
    L9:
        if ((r1 instanceof BaseTextShadowNode) == false) goto L11;
        W(r3, (BaseTextShadowNode) r1);
        goto L11
    }

    public final void O(SpannableStringBuilder r5, BaseTextShadowNode r6) {
        ArrayList r0 = new ArrayList();
        r6.G(r5, r0);
        int r7 = r0.size() - 1;
    L3:
        if (r7 < 0) goto L5;
        ((BaseTextShadowNode.a) ListProtector.get(r0, r7)).a(r5);
        r7 = r7 - 1;
        goto L3
    L5:
        MetricAffectingSpan[] r8 = (MetricAffectingSpan[]) r5.getSpans(0, r5.length(), MetricAffectingSpan.class);
        int r9 = 0;
    L7:
        if (r9 >= r8.length) goto L45;
        MetricAffectingSpan r1 = r8[r9];
        if ((r1 instanceof z6a.a) == false) goto L12;
        int r2 = ((z6a.a) r1).a;
    L16:
        if (this.U == false) goto L18;
    L33:
        boolean r3 = true;
    L34:
        this.U = r3;
        if (this.T == false) goto L37;
    L43:
        boolean r4 = true;
    L44:
        this.T = r4;
        r9 = r9 + 1;
        goto L7
    L37:
        if (r2 != 6) goto L39;
        boolean r10 = true;
    L40:
        if (r10 == true) goto L43;
        r4 = false;
        goto L44
    L39:
        r10 = false;
        goto L40
    L18:
        if (r2 != 5) goto L20;
    L29:
        boolean r11 = true;
    L30:
        if (r11 == true) goto L33;
        r3 = false;
        goto L34
    L20:
        if (r2 == 8) goto L29;
        if (r2 == 4) goto L29;
        if (r2 == 7) goto L29;
        if (r2 == 11) goto L29;
        r11 = false;
        goto L30
    L12:
        if ((r1 instanceof k) == false) goto L14;
        r2 = ((k) r1).a;
        goto L16
    L14:
        r2 = 0;
        goto L16
    }

    public final void S(CharSequence r6, z6a.c r7) {
        int r3 = 0;
        z6a.a[] r0 = (z6a.a[]) ((SpannableStringBuilder) r6).getSpans(0, r6.length(), z6a.a.class);
        int r1 = 0;
    L4:
        if (r1 >= r0.length) goto L6;
        z6a.a r2 = r0[r1];
        r2.d = r7;
        r2.e = getContext().isTextRefactorEnabled();
        r1 = r1 + 1;
        goto L4
    L6:
        k[] r8 = (k[]) ((SpannableStringBuilder) r6).getSpans(0, r6.length(), k.class);
    L8:
        if (r3 >= r8.length) goto L10;
        k r4 = r8[r3];
        r4.d = r7;
        r4.e = this.v.k;
        r3 = r3 + 1;
        goto L8
    }

    @Override // y6a.e
    public final y6a.k b(j r7, y6a.g r8) {
        this.Z = r7;
        this.k0 = r8;
        this.Y = 0;
        long r9 = c(this, r7.a, r7.b, r7.c, r7.d);
        return new y6a.k(Float.intBitsToFloat((int) ((r9 >> 32) & (-1))), Float.intBitsToFloat((int) (r9 & (-1))), this.i);
    }

    @Override // y6a.e
    public final void d(y6a.b r4, y6a.a r5) {
        e r6 = this.M;
        if (r6 != null) goto L5;
        return;
    L5:
        Layout r7 = r6.a;
        CharSequence r0 = this.P;
        if (r0 != null) goto L8;
        r0 = this.N;
    L8:
        D(r7, (SpannableStringBuilder) r0, new PointF(r6.d, r6.e));
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    public final void F(int r6, int r7, List<BaseTextShadowNode.a> r8) {
        if (this.v.o == null) goto L9;
        t r2 = this.v.o;
        float r3 = this.h.c();
        int r4 = r2.a;
        float r5 = r2.b;
        if (r4 == 0) goto L8;
        r5 = r5 * r3;
    L8:
        BaseTextShadowNode.a r0 = new BaseTextShadowNode.a(r6, r7, new LeadingMarginSpan.Standard((int) r5, 0));
        ((ArrayList) r8).add(r0);
    L9:
        super.F(r6, r7, r8);
        if (TextUtils.isEmpty(this.v.u) == true) goto L16;
        com.lynx.tasm.behavior.shadow.text.a r9 = this.v;
        String r10 = r9.u;
        int r11 = r9.e();
        if (g.d(getContext(), r10, r11) != null) goto L14;
        FontFaceManager.g.a.g(getContext(), r10, r11, new a(this));
        return;
    L14:
        this.v.B = true;
        return;
    }

    public long c(LayoutNode r20, float r21, MeasureMode r22, float r23, MeasureMode r24) {
        if (TraceEvent.isTracingStarted() == false) goto L12;
        HashMap r1 = new HashMap();
        CharSequence r2 = this.N;
        if (r2 == null) goto L7;
        String r3 = r2.toString();
    L9:
        if (r3.length() <= 50) goto L11;
        r3 = r3.substring(0, 50);
    L11:
        r1.put("preview_text", r3);
        TraceEvent.beginSection("TextShadowNode.measure", r1);
        goto L12
    L7:
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L12:
        this.M = null;
        this.P = null;
        MeasureMode r11 = MeasureMode.UNDEFINED;
        float r16 = 0.0f;
        if (r22 == r11) goto L21;
        if (r24 == r11) goto L21;
        if (r21 != 0.0f) goto L21;
        if (r23 != 0.0f) goto L21;
        TraceEvent.endSection("TextShadowNode.measure");
        return i.b(0, 0);
    L21:
        CharSequence r4 = this.N;
        if (r4 != null) goto L25;
        TraceEvent.endSection("TextShadowNode.measure");
        return i.b(0, 0);
    L25:
        y6a.g r5 = this.k0;
        if (r5 == null) goto L30;
        j r6 = this.Z;
        if (r6 == null) goto L30;
        L((SpannableStringBuilder) r4, r6, r5);
    L30:
        f r10 = new f(r4, this.v.a(), r22, r24, r21, r23, this.F, this.R, this.A, this.C);
        v r12 = v.a.a;
        this.M = r12.a(getContext(), r10);
        InlineTruncationShadowNode r7 = this.Q;
        if (r7 == null) goto L40;
        V(r7);
        CharSequence r8 = this.O;
        if (r8 == null) goto L40;
        y6a.g r9 = this.k0;
        if (r9 == null) goto L40;
        j r13 = this.Z;
        if (r13 == null) goto L40;
        this.Q.L((SpannableStringBuilder) r8, r13, r9);
    L40:
        if (this.O != null) goto L42;
    L138:
        float r14 = this.M.i();
        float r15 = this.M.g();
        this.i = this.M.a.getLineBaseline(0);
        TraceEvent.endSection("TextShadowNode.measure");
        return i.a(r15, r14);
    L42:
        if (this.M.k() == false) goto L138;
        if (r22 == r11) goto L138;
        e r17 = r12.a(getContext(), new f(this.O, this.v.a(), MeasureMode.AT_MOST, r24, r21, r23, this.F, this.R, this.A, this.C));
        Layout r18 = r17.a;
        if (r18.getLineCount() == 1) goto L47;
    L49:
        boolean r19 = false;
    L50:
        if (r19 == false) goto L138;
        e r25 = this.M;
        if (r24 != r11) goto L54;
    L61:
        int r26 = r25.h() - 1;
    L62:
        int r110 = r26;
        if (this.M.a.getLineEnd(r110) == this.N.length()) goto L65;
    L67:
        float r27 = r17.g();
        int r111 = this.M.a.getLineStart(r110);
        int r28 = this.M.a.getLineEnd(r110);
        float r29 = r21 - r27;
        if ((this.M.a.getLineMax(r110) - this.M.a.getLineLeft(r110)) <= r29) goto L103;
        Layout r30 = this.M.a;
        HashMap r31 = new HashMap();
        ArrayList r32 = new ArrayList();
        r32.add(Float.valueOf(r30.getLineLeft(r110)));
        r32.add(Float.valueOf(r30.getLineRight(r110)));
        int r33 = r111;
    L71:
        if (r33 >= r28) goto L76;
        if (Character.isHighSurrogate(r30.getText().charAt(r33)) == true) goto L75;
        float r34 = r30.getSecondaryHorizontal(r33);
        r32.add(Float.valueOf(r34));
        r31.put(Integer.valueOf(r33), Float.valueOf(r34));
    L75:
        r33 = r33 + 1;
        goto L71
    L76:
        Collections.sort(r32);
        Iterator r35 = r31.entrySet().iterator();
    L78:
        if (r35.hasNext() == false) goto L95;
        Map.Entry r36 = (Map.Entry) r35.next();
        int r37 = ((Integer) r36.getKey()).intValue();
        float r38 = ((Float) r36.getValue()).floatValue();
        int r39 = Collections.binarySearch(r32, Float.valueOf(r38));
        if (r30.isRtlCharAt(r37) == false) goto L86;
    L81:
        if (r39 < 0) goto L90;
        if (((Float) ListProtector.get(r32, r39)).floatValue() < r38) goto L90;
        r39 = r39 - 1;
    L90:
        if (r39 < 0) goto L94;
        if (r39 >= r32.size()) goto L94;
        r31.put(Integer.valueOf(r37), Float.valueOf(Math.abs(r38 - ((Float) ListProtector.get(r32, r39)).floatValue())));
    L94:
        r31.put(Integer.valueOf(r37), Float.valueOf(0.0f));
    L86:
        if (r39 >= r32.size()) goto L90;
        if (((Float) ListProtector.get(r32, r39)).floatValue() > r38) goto L90;
        r39 = r39 + 1;
        goto L86
    L95:
        int r40 = r111;
    L96:
        if (r40 >= r28) goto L103;
        if (r31.containsKey(Integer.valueOf(r40)) == false) goto L102;
        r16 = r16 + ((Float) r31.get(Integer.valueOf(r40))).floatValue();
        if (r16 <= r29) goto L102;
        r28 = r40;
    L102:
        r40 = r40 + 1;
    L103:
        if (r28 < r111) goto L137;
    L104:
        int r112 = r28;
        if (r112 <= r111) goto L109;
        r28 = r112 - 1;
        if (Character.isWhitespace(this.N.charAt(r28)) == true) goto L104;
    L109:
        if (r112 > r111) goto L111;
        CharSequence r41 = new SpannableStringBuilder();
    L112:
        int r42 = r41.length() + r111;
        W(r42, this.Q);
        SpannableStringBuilder r43 = ((SpannableStringBuilder) this.N.subSequence(0, r111)).append(r41).append(this.O);
        this.P = r43;
        z6a.l[] r44 = (z6a.l[]) r43.getSpans(r42, r43.length(), z6a.l.class);
        int r45 = 0;
    L114:
        if (r45 >= r44.length) goto L119;
        if (r43.getSpanStart(r44[r45]) < r42) goto L118;
        z6a.l r46 = r44[r45];
        r46.a += r42;
        r46.b += r42;
    L118:
        r45 = r45 + 1;
        goto L114
    L119:
        boolean r47 = false;
        z6a.l[] r48 = (z6a.l[]) r43.getSpans(0, r42, z6a.l.class);
        int r49 = 0;
    L121:
        if (r49 >= r48.length) goto L129;
        z6a.l r50 = r48[r49];
        if (r50.a < r42) goto L126;
        r50.c = r47;
    L128:
        r49 = r49 + 1;
        r47 = false;
        goto L121
    L126:
        if (r50.b <= r42) goto L128;
        r50.b = r42;
        goto L128
    L129:
        com.lynx.tasm.behavior.shadow.text.a r51 = this.v;
        boolean r52 = r51.q;
        com.lynx.tasm.behavior.shadow.text.a r53 = this.Q.v;
        r51.q = r52 | r53.q;
        r51.r |= r53.r;
        e r54 = v.a.a.a(getContext(), new f(this.P, r51.a(), r22, r24, r21, r23, this.F, this.R, this.A, this.C));
        this.M = r54;
        if (r54.a.getLineEnd(r110) >= this.P.length()) goto L132;
        boolean r55 = true;
    L133:
        if (r55 == false) goto L136;
        if (r112 <= r111) goto L136;
        r28 = r112 - 1;
        V(this.Q);
    L136:
        r28 = r112;
        goto L137
    L132:
        r55 = false;
        goto L133
    L111:
        r41 = this.N.subSequence(r111, r112);
    L137:
        this.Y = this.N.length() - r28;
        goto L138
    L65:
        if (this.M.a.getWidth() > r21) goto L67;
    L54:
        if (r25.i() <= r23) goto L61;
        Layout r56 = r25.a;
        r26 = r56.getLineCount();
    L56:
        r26 = r26 - 1;
        if (r26 <= 0) goto L62;
        if (r56.getLineBottom(r26) > r23) goto L56;
    L47:
        if (r18.getLineEnd(0) != r18.getText().length()) goto L49;
        r19 = true;
        goto L50
    }
}
