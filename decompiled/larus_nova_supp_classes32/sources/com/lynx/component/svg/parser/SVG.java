package com.lynx.component.svg.parser;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import com.lynx.serval.svg.SVGRenderEngine;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.obric.aivoice.core.data.NameKeys;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class SVG {
    public a0 a;
    public final Map<String, e0> b;
    public com.lynx.component.svg.parser.c c;

    public static final enum GradientSpread extends Enum<GradientSpread> {
        public static final /* synthetic */ GradientSpread[] a = null;
        public static final GradientSpread pad = null;
        public static final GradientSpread reflect = null;
        public static final GradientSpread repeat = null;

        static {
            GradientSpread r0 = new GradientSpread("pad", 0);
            pad = r0;
            GradientSpread r1 = new GradientSpread("reflect", 1);
            reflect = r1;
            GradientSpread r3 = new GradientSpread("repeat", 2);
            repeat = r3;
            a = new GradientSpread[]{r0, r1, r3};
        }

        public static GradientSpread[] values() {
            return (GradientSpread[]) a.clone();
        }

        public static GradientSpread valueOf(String r1) {
            return (GradientSpread) r27.a.a(GradientSpread.class, r1);
        }

        public GradientSpread(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static class Style implements Cloneable {
        public VectorEffect A;
        public RenderQuality B;
        public long a;
        public h0 b;
        public FillRule c;
        public Float d;
        public h0 e;
        public Float f;
        public o g;
        public LineCap h;
        public LineJoin i;
        public Float j;
        public o[] k;
        public o l;
        public Float m;
        public f n;
        public Boolean o;
        public c p;
        public Boolean q;
        public Boolean r;
        public h0 s;
        public Float t;
        public String u;
        public FillRule v;
        public h0 w;
        public Float x;
        public h0 y;
        public Float z;

        public static final enum FillRule extends Enum<FillRule> {
            public static final FillRule EvenOdd = null;
            public static final FillRule NonZero = null;
            public static final /* synthetic */ FillRule[] a = null;

            static {
                FillRule r0 = new FillRule("NonZero", 0);
                NonZero = r0;
                FillRule r1 = new FillRule("EvenOdd", 1);
                EvenOdd = r1;
                a = new FillRule[]{r0, r1};
            }

            public static FillRule[] values() {
                return (FillRule[]) a.clone();
            }

            public static FillRule valueOf(String r1) {
                return (FillRule) r27.a.a(FillRule.class, r1);
            }

            public FillRule(String r1, int r2) {
                super(r1, r2);
            }
        }

        public static final enum LineCap extends Enum<LineCap> {
            public static final LineCap Butt = null;
            public static final LineCap Round = null;
            public static final LineCap Square = null;
            public static final /* synthetic */ LineCap[] a = null;

            static {
                LineCap r0 = new LineCap("Butt", 0);
                Butt = r0;
                LineCap r1 = new LineCap("Round", 1);
                Round = r1;
                LineCap r3 = new LineCap("Square", 2);
                Square = r3;
                a = new LineCap[]{r0, r1, r3};
            }

            public static LineCap[] values() {
                return (LineCap[]) a.clone();
            }

            public static LineCap valueOf(String r1) {
                return (LineCap) r27.a.a(LineCap.class, r1);
            }

            public LineCap(String r1, int r2) {
                super(r1, r2);
            }
        }

        public static final enum LineJoin extends Enum<LineJoin> {
            public static final LineJoin Bevel = null;
            public static final LineJoin Miter = null;
            public static final LineJoin Round = null;
            public static final /* synthetic */ LineJoin[] a = null;

            static {
                LineJoin r0 = new LineJoin("Miter", 0);
                Miter = r0;
                LineJoin r1 = new LineJoin("Round", 1);
                Round = r1;
                LineJoin r3 = new LineJoin("Bevel", 2);
                Bevel = r3;
                a = new LineJoin[]{r0, r1, r3};
            }

            public static LineJoin[] values() {
                return (LineJoin[]) a.clone();
            }

            public static LineJoin valueOf(String r1) {
                return (LineJoin) r27.a.a(LineJoin.class, r1);
            }

            public LineJoin(String r1, int r2) {
                super(r1, r2);
            }
        }

        public static final enum RenderQuality extends Enum<RenderQuality> {
            public static final /* synthetic */ RenderQuality[] a = null;
            public static final RenderQuality auto = null;
            public static final RenderQuality optimizeQuality = null;
            public static final RenderQuality optimizeSpeed = null;

            static {
                RenderQuality r0 = new RenderQuality("auto", 0);
                auto = r0;
                RenderQuality r1 = new RenderQuality("optimizeQuality", 1);
                optimizeQuality = r1;
                RenderQuality r3 = new RenderQuality("optimizeSpeed", 2);
                optimizeSpeed = r3;
                a = new RenderQuality[]{r0, r1, r3};
            }

            public static RenderQuality[] values() {
                return (RenderQuality[]) a.clone();
            }

            public static RenderQuality valueOf(String r1) {
                return (RenderQuality) r27.a.a(RenderQuality.class, r1);
            }

            public RenderQuality(String r1, int r2) {
                super(r1, r2);
            }
        }

        public static final enum VectorEffect extends Enum<VectorEffect> {
            public static final VectorEffect NonScalingStroke = null;
            public static final VectorEffect None = null;
            public static final /* synthetic */ VectorEffect[] a = null;

            static {
                VectorEffect r0 = new VectorEffect("None", 0);
                None = r0;
                VectorEffect r1 = new VectorEffect("NonScalingStroke", 1);
                NonScalingStroke = r1;
                a = new VectorEffect[]{r0, r1};
            }

            public static VectorEffect[] values() {
                return (VectorEffect[]) a.clone();
            }

            public static VectorEffect valueOf(String r1) {
                return (VectorEffect) r27.a.a(VectorEffect.class, r1);
            }

            public VectorEffect(String r1, int r2) {
                super(r1, r2);
            }
        }

        public static Style a() {
            Style r0 = new Style();
            r0.a = -1;
            f r1 = f.b;
            r0.b = r1;
            FillRule r2 = FillRule.NonZero;
            r0.c = r2;
            Float r3 = Float.valueOf(1.0f);
            r0.d = r3;
            r0.e = null;
            r0.f = r3;
            r0.g = new o();
            r0.h = LineCap.Butt;
            r0.i = LineJoin.Miter;
            r0.j = Float.valueOf(4.0f);
            r0.k = null;
            r0.l = new o();
            r0.m = r3;
            r0.n = r1;
            Boolean r5 = Boolean.TRUE;
            r0.o = r5;
            r0.p = null;
            r0.q = r5;
            r0.r = r5;
            r0.s = r1;
            r0.t = r3;
            r0.u = null;
            r0.v = r2;
            r0.w = null;
            r0.x = r3;
            r0.y = null;
            r0.z = r3;
            r0.A = VectorEffect.None;
            r0.B = RenderQuality.auto;
            return r0;
        }

        public Style() {
            this.a = 0;
        }

        public final Object clone() throws CloneNotSupportedException {
            Style r0 = (Style) super.clone();
            o[] r1 = this.k;
            if (r1 == null) goto L5;
            r0.k = (o[]) r1.clone();
        L5:
            return r0;
        }
    }

    public static final enum Unit extends Enum<Unit> {
        public static final /* synthetic */ Unit[] a = null;
        public static final Unit cm = null;
        public static final Unit em = null;
        public static final Unit ex = null;
        public static final Unit in = null;
        public static final Unit mm = null;
        public static final Unit pc = null;
        public static final Unit percent = null;
        public static final Unit pt = null;
        public static final Unit px = null;
        public static final Unit rem = null;
        public static final Unit rpx = null;

        static {
            Unit r0 = new Unit("px", 0);
            px = r0;
            Unit r1 = new Unit("em", 1);
            em = r1;
            Unit r3 = new Unit("ex", 2);
            ex = r3;
            Unit r5 = new Unit("in", 3);
            in = r5;
            Unit r7 = new Unit("cm", 4);
            cm = r7;
            Unit r9 = new Unit("mm", 5);
            mm = r9;
            Unit r11 = new Unit("pt", 6);
            pt = r11;
            Unit r13 = new Unit("pc", 7);
            pc = r13;
            Unit r15 = new Unit("percent", 8);
            percent = r15;
            Unit r14 = new Unit("rpx", 9);
            rpx = r14;
            Unit r12 = new Unit("rem", 10);
            rem = r12;
            a = new Unit[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12};
        }

        public static Unit[] values() {
            return (Unit[]) a.clone();
        }

        public static Unit valueOf(String r1) {
            return (Unit) r27.a.a(Unit.class, r1);
        }

        public Unit(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Unit.values().length];
            a = r0;
            r0[Unit.em.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L28:
            a[Unit.rem.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L34:
            a[Unit.rpx.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L46:
            a[Unit.ex.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L30:
            a[Unit.in.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L36:
            a[Unit.cm.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L40:
            a[Unit.mm.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L42:
            a[Unit.pt.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L26:
            a[Unit.pc.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L32:
            a[Unit.percent.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L38:
            a[Unit.px.ordinal()] = 11;     // Catch: NoSuchFieldError -> L25
            return;
        }
    }

    public static class a0 extends k0 {
        public o k;
        public o l;
        public o m;
        public o n;

        @Override // com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return SVGRenderEngine.SVG;
        }

        public a0() {
        }
    }

    public static class b {
        public float a;
        public float b;
        public float c;
        public float d;

        public final String toString() {
            return "[" + this.a + " " + this.b + " " + this.c + " " + this.d + "]";
        }

        public b(b r2) {
            this.a = r2.a;
            this.b = r2.b;
            this.c = r2.c;
            this.d = r2.d;
        }

        public b(float r1, float r2, float r3, float r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static abstract class b0 extends d0 implements c0 {
        public List<g0> h;

        public b0() {
            this.h = new ArrayList();
        }

        @Override // com.lynx.component.svg.parser.SVG.c0
        public final List<g0> getChildren() {
            return this.h;
        }

        @Override // com.lynx.component.svg.parser.SVG.c0
        public final void b(e0 r2) throws SVGParseException {
            this.h.add(r2);
        }
    }

    public static class c {
        public final o a;
        public final o b;
        public final o c;
        public final o d;

        public c(o r1, o r2, o r3, o r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public interface c0 {
        void b(e0 r1) throws SVGParseException;

        List<g0> getChildren();
    }

    public static class d extends k {
        public o i;
        public o j;
        public o k;

        @Override // com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return SVGRenderEngine.CIRCLE;
        }

        public d() {
        }
    }

    public static abstract class d0 extends e0 {
        public b g;

        public d0() {
            this.g = null;
        }
    }

    public static class e extends l implements q {
        public Boolean j;

        @Override // com.lynx.component.svg.parser.SVG.l, com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return SVGRenderEngine.CLIP_PATH;
        }

        public e() {
        }
    }

    public static abstract class e0 extends g0 {
        public String c;
        public Boolean d;
        public Style e;
        public Style f;

        public e0() {
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
        }

        public final String toString() {
            return c();
        }
    }

    public static class f extends h0 {
        public static final f b = null;
        public static final f c = null;
        public final int a;

        public final String toString() {
            return String.format("#%08x", new Object[]{Integer.valueOf(this.a)});
        }

        static {
            b = new f(-16777216);
            c = new f(0);
        }

        public f(int r1) {
            this.a = r1;
        }
    }

    public static class f0 extends j {
        public o l;
        public o m;
        public o n;
        public o o;

        @Override // com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return SVGRenderEngine.LINEAR_GRADIENT;
        }

        public f0() {
        }
    }

    public static class g extends h0 {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }
    }

    public static class g0 {
        public SVG a;
        public c0 b;

        public g0() {
        }

        public String c() {
            return NameKeys.UnloadStrategy_No_Strategy;
        }
    }

    public static class h extends l implements q {
        @Override // com.lynx.component.svg.parser.SVG.l, com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return "defs";
        }

        public h() {
        }
    }

    public static abstract class h0 implements Cloneable {
        public h0() {
        }
    }

    public static class i extends k {
        public o i;
        public o j;
        public o k;
        public o l;

        @Override // com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return SVGRenderEngine.ELLIPSE;
        }

        public i() {
        }
    }

    public static abstract class i0 extends b0 {
        public PreserveAspectRatio i;

        public i0() {
            this.i = null;
        }
    }

    public static abstract class j extends e0 implements c0 {
        public List<g0> g;
        public Boolean h;
        public Matrix i;
        public GradientSpread j;
        public String k;

        public j() {
            this.g = new ArrayList();
        }

        @Override // com.lynx.component.svg.parser.SVG.c0
        public final List<g0> getChildren() {
            return this.g;
        }

        @Override // com.lynx.component.svg.parser.SVG.c0
        public final void b(e0 r4) throws SVGParseException {
            if ((r4 instanceof z) == false) goto L7;
            this.g.add(r4);
            return;
        L7:
            throw new SVGParseException("Gradient elements cannot contain " + r4 + " elements.");
        }
    }

    public static class j0 extends j {
        public o l;
        public o m;
        public o n;
        public o o;
        public o p;

        @Override // com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return SVGRenderEngine.RADIAL_GRADIENT;
        }

        public j0() {
        }
    }

    public static abstract class k extends d0 implements m {
        public Matrix h;

        public k() {
        }

        @Override // com.lynx.component.svg.parser.SVG.m
        public final void a(Matrix r1) {
            this.h = r1;
        }
    }

    public static abstract class k0 extends i0 {
        public b j;

        public k0() {
        }
    }

    public static class l extends b0 implements m {
        public Matrix i;

        @Override // com.lynx.component.svg.parser.SVG.g0
        public String c() {
            return "group";
        }

        public l() {
        }

        @Override // com.lynx.component.svg.parser.SVG.m
        public final void a(Matrix r1) {
            this.i = r1;
        }
    }

    public static class l0 extends l {
        public String j;
        public o k;
        public o l;
        public o m;
        public o n;

        @Override // com.lynx.component.svg.parser.SVG.l, com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return NameKeys.LoadStrategy_Use;
        }

        public l0() {
        }
    }

    public interface m {
        void a(Matrix r1);
    }

    public static class n extends i0 implements m {
        public String j;
        public o k;
        public o l;
        public o m;
        public o n;
        public Matrix o;

        @Override // com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return "image";
        }

        public n() {
        }

        @Override // com.lynx.component.svg.parser.SVG.m
        public final void a(Matrix r1) {
            this.o = r1;
        }
    }

    public static class o implements Cloneable {
        public final float a;
        public final Unit b;

        public final boolean f() {
            if (this.a >= 0.0f) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean g() {
            if (this.a != 0.0f) goto L5;
            return true;
        L5:
            return false;
        }

        public final String toString() {
            return String.valueOf(this.a) + this.b;
        }

        public o() {
            this.a = 0.0f;
            this.b = Unit.px;
        }

        public final float b(com.lynx.component.svg.parser.e r7) {
            if (this.b != Unit.percent) goto L18;
            com.lynx.component.svg.parser.e.c r8 = r7.e;
            b r0 = r8.g;
            if (r0 != null) goto L8;
            r0 = r8.f;
        L8:
            if (r0 == null) goto L10;
            float r9 = r0.c;
            float r1 = r0.d;
            if (r9 != r1) goto L16;
            float r2 = this.a;
        L15:
            return (r2 * r9) / 100.0f;
        L16:
            r9 = (float) (Math.sqrt((r9 * r9) + (r1 * r1)) / 1.414213562373095d);
            r2 = this.a;
            goto L15
        L10:
            return this.a;
        L18:
            return d(r7);
        }

        public final float c(com.lynx.component.svg.parser.e r3) {
            if (this.b != Unit.percent) goto L7;
            return (this.a * 1.0f) / 100.0f;
        L7:
            return d(r3);
        }

        public final float d(com.lynx.component.svg.parser.e r10) {
            switch(a.a[this.b.ordinal()]) {
                case 1: goto L24;
                case 2: goto L24;
                case 3: goto L24;
                case 4: goto L23;
                case 5: goto L20;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L6;
                default: goto L5;
            };
        L6:
            com.lynx.component.svg.parser.e.c r11 = r10.e;
            b r0 = r11.g;
            if (r0 != null) goto L10;
            r0 = r11.f;
        L10:
            if (r0 == null) goto L12;
            float r12 = this.a * r0.c;
            float r1 = 100.0f;
        L19:
            return r12 / r1;
        L12:
            return this.a;
        L14:
            float r2 = this.a;
            r10.getClass();
            r12 = r2 * 96.0f;
            r1 = 6.0f;
            goto L19
        L15:
            float r3 = this.a;
            r10.getClass();
            r12 = r3 * 96.0f;
            r1 = 72.0f;
            goto L19
        L16:
            float r4 = this.a;
            r10.getClass();
            r12 = r4 * 96.0f;
            r1 = 25.4f;
            goto L19
        L17:
            float r5 = this.a;
            r10.getClass();
            r12 = r5 * 96.0f;
            r1 = 2.54f;
            goto L19
        L20:
            float r6 = this.a;
            r10.getClass();
            return r6 * 96.0f;
        L24:
            String r7 = this.a + this.b.toString();
            float r8 = r10.b;
            return com.lynx.tasm.utils.n.b(r7, r8, r8, 0.0f, 0.0f, 0.0f, DisplayMetricsHolder.getScreenDisplayMetrics());
        L5:
            return this.a;
        L23:
            return this.a * (r10.b / 2.0f);
        }

        public final float e(com.lynx.component.svg.parser.e r3) {
            if (this.b != Unit.percent) goto L14;
            com.lynx.component.svg.parser.e.c r4 = r3.e;
            b r0 = r4.g;
            if (r0 != null) goto L8;
            r0 = r4.f;
        L8:
            if (r0 != null) goto L12;
            return this.a;
        L12:
            return (this.a * r0.d) / 100.0f;
        L14:
            return d(r3);
        }

        public o(float r1, Unit r2) {
            this.a = r1;
            this.b = r2;
        }

        public final float a(float r10, float r11) {
            switch(a.a[this.b.ordinal()]) {
                case 1: goto L17;
                case 2: goto L17;
                case 3: goto L17;
                case 4: goto L5;
                case 5: goto L15;
                case 6: goto L13;
                case 7: goto L11;
                case 8: goto L9;
                case 9: goto L7;
                default: goto L5;
            };
        L5:
            return this.a;
        L7:
            return (this.a * 96.0f) / 6.0f;
        L9:
            return (this.a * 96.0f) / 72.0f;
        L11:
            return (this.a * 96.0f) / 25.4f;
        L13:
            return (this.a * 96.0f) / 2.54f;
        L15:
            return this.a * 96.0f;
        L17:
            return com.lynx.tasm.utils.n.b(this.a + this.b.toString(), r10, r11, 0.0f, 0.0f, 0.0f, DisplayMetricsHolder.getScreenDisplayMetrics());
        }
    }

    public static class p extends k {
        public o i;
        public o j;
        public o k;
        public o l;

        @Override // com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return SVGRenderEngine.LINE;
        }

        public p() {
        }
    }

    public interface q {
    }

    public static class r extends h0 {
        public final String a;
        public final h0 b;

        public final String toString() {
            return this.a + " " + this.b;
        }

        public r(String r1, h0 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static class s extends k {
        public t i;

        @Override // com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return SVGRenderEngine.PATH;
        }

        public s() {
        }
    }

    public static class t {
        public byte[] a;
        public int b;
        public float[] c;
        public int d;

        public t() {
            this.b = 0;
            this.d = 0;
            this.a = new byte[8];
            this.c = new float[16];
        }

        public final void a(byte r5) {
            int r0 = this.b;
            byte[] r1 = this.a;
            if (r0 != r1.length) goto L5;
            byte[] r2 = new byte[r1.length * 2];
            System.arraycopy(r1, 0, r2, 0, r1.length);
            this.a = r2;
        L5:
            byte[] r3 = this.a;
            int r4 = this.b;
            this.b = r4 + 1;
            r3[r4] = r5;
        }

        public final void b(int r4) {
            float[] r0 = this.c;
            if (r0.length >= (this.d + r4)) goto L6;
            float[] r5 = new float[r0.length * 2];
            System.arraycopy(r0, 0, r5, 0, r0.length);
            this.c = r5;
            return;
        }

        public final void d(float r4, float r5) {
            a((byte) 1);
            b(2);
            float[] r0 = this.c;
            int r1 = this.d;
            int r2 = r1 + 1;
            r0[r1] = r4;
            this.d = r2 + 1;
            r0[r2] = r5;
        }

        public final void e(float r4, float r5, float r6, float r7) {
            a((byte) 3);
            b(4);
            float[] r0 = this.c;
            int r1 = this.d;
            int r2 = r1 + 1;
            r0[r1] = r4;
            int r8 = r2 + 1;
            r0[r2] = r5;
            int r9 = r8 + 1;
            r0[r8] = r6;
            this.d = r9 + 1;
            r0[r9] = r7;
        }

        public final void c(float r4, float r5, float r6, float r7, float r8, float r9) {
            a((byte) 2);
            b(6);
            float[] r0 = this.c;
            int r1 = this.d;
            int r2 = r1 + 1;
            r0[r1] = r4;
            int r10 = r2 + 1;
            r0[r2] = r5;
            int r11 = r10 + 1;
            r0[r10] = r6;
            int r12 = r11 + 1;
            r0[r11] = r7;
            int r13 = r12 + 1;
            r0[r12] = r8;
            this.d = r13 + 1;
            r0[r13] = r9;
        }
    }

    public static class u extends k0 implements q {
        public Boolean k;
        public Boolean l;
        public Matrix m;
        public o n;
        public o o;
        public o p;
        public o q;
        public String r;

        @Override // com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return "pattern";
        }

        public u() {
        }
    }

    public static class v extends k {
        public float[] i;

        @Override // com.lynx.component.svg.parser.SVG.g0
        public String c() {
            return SVGRenderEngine.POLYLINE;
        }

        public v() {
        }
    }

    public static class w extends v {
        @Override // com.lynx.component.svg.parser.SVG.v, com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return SVGRenderEngine.POLYGON;
        }

        public w() {
        }
    }

    public static class x extends k {
        public o i;
        public o j;
        public o k;
        public o l;
        public o m;
        public o n;

        @Override // com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return SVGRenderEngine.RECT;
        }

        public x() {
        }
    }

    public static class y extends e0 implements c0 {
        @Override // com.lynx.component.svg.parser.SVG.c0
        public final void b(e0 r1) {
        }

        @Override // com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return "solidColor";
        }

        @Override // com.lynx.component.svg.parser.SVG.c0
        public final List<g0> getChildren() {
            return Collections.emptyList();
        }

        public y() {
        }
    }

    public static class z extends e0 implements c0 {
        public Float g;

        @Override // com.lynx.component.svg.parser.SVG.c0
        public final void b(e0 r1) {
        }

        @Override // com.lynx.component.svg.parser.SVG.g0
        public final String c() {
            return "stop";
        }

        @Override // com.lynx.component.svg.parser.SVG.c0
        public final List<g0> getChildren() {
            return Collections.emptyList();
        }

        public z() {
        }
    }

    public final b a() {
        a0 r0 = this.a;
        o r1 = r0.m;
        o r2 = r0.n;
        if (r1 == null) goto L32;
        if (r1.g() == true) goto L32;
        Unit r3 = r1.b;
        Unit r4 = Unit.percent;
        if (r3 == r4) goto L32;
        Unit r5 = Unit.em;
        if (r3 == r5) goto L32;
        Unit r6 = Unit.ex;
        if (r3 == r6) goto L32;
        com.lynx.component.svg.parser.c r7 = this.c;
        float r8 = r1.a(r7.b, r7.c);
        if (r2 != null) goto L16;
        b r9 = this.a.j;
        if (r9 == null) goto L28;
        float r10 = (r9.d * r8) / r9.c;
    L30:
        return new b(0.0f, 0.0f, r8, r10);
    L28:
        r10 = r8;
        goto L30
    L16:
        if (r2.g() == true) goto L24;
        Unit r11 = r2.b;
        if (r11 == r4) goto L24;
        if (r11 == r5) goto L24;
        if (r11 == r6) goto L24;
        com.lynx.component.svg.parser.c r12 = this.c;
        r10 = r2.a(r12.b, r12.c);
    L24:
        return new b(-1.0f, -1.0f, -1.0f, -1.0f);
    L32:
        return new b(-1.0f, -1.0f, -1.0f, -1.0f);
    }

    public SVG() {
        this.a = null;
        this.b = new HashMap();
    }

    public static SVG c(String r3) throws SVGParseException {
        LLog.i("lynx_UISvg", "getFromString():" + r3);
        SVGParser r0 = new SVGParser();
        InputStream r1 = new ByteArrayInputStream(r3.getBytes());
        if (r1.markSupported() == true) goto L23;
        r1 = new BufferedInputStream(r1);
    L23:
        r1.mark(3);     // Catch: IOException -> L16
        int r4 = r1.read() + (r1.read() << 8);     // Catch: IOException -> L16
        r1.reset();     // Catch: IOException -> L16
        if (r4 != 35615) goto L21;
        r1 = new BufferedInputStream(new GZIPInputStream(r1));     // Catch: IOException -> L16
    L21:
        r0.s(r1);     // Catch: Throwable -> L13
        SVG r5 = r0.a;     // Catch: Throwable -> L13
        r1.close();     // Catch: IOException -> L18
    L12:
        return r5;
    L13:
        th = move-exception;
        r1.close();     // Catch: IOException -> L17
    L15:
        throw th;
    }

    public final e0 f(String r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r5.startsWith("\"") == false) goto L11;
        if (r5.endsWith("\"") == false) goto L11;
        r5 = r5.substring(1, r5.length() - 1).replace("\\\"", "\"");
    L15:
        String r6 = r5.replace("\\\n", NameKeys.UnloadStrategy_No_Strategy).replace("\\A", "\n");
        if (r6.length() > 1) goto L18;
        return null;
    L18:
        if (r6.startsWith("#") == false) goto L33;
        String r7 = r6.substring(1);
        if (r7 != null) goto L22;
        return null;
    L22:
        if (r7.length() != 0) goto L25;
        return null;
    L25:
        if (r7.equals(this.a.c) == false) goto L28;
        return this.a;
    L28:
        if (((HashMap) this.b).containsKey(r7) == true) goto L36;
        e0 r0 = b(this.a, r7);
        ((HashMap) this.b).put(r7, r0);
        return r0;
    L36:
        return (e0) ((HashMap) this.b).get(r7);
    L33:
        return null;
    L11:
        if (r5.startsWith("'") == false) goto L15;
        if (r5.endsWith("'") == false) goto L15;
        r5 = r5.substring(1, r5.length() - 1).replace("\\'", "'");
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static e0 b(c0 r3, String r4) {
        e0 r0 = (e0) r3;
        if (r4.equals(r0.c) == false) goto L5;
        return r0;
    L5:
        Iterator<g0> r5 = r3.getChildren().iterator();
    L7:
        if (r5.hasNext() == false) goto L19;
        Object r1 = (g0) r5.next();
        if ((r1 instanceof e0) == false) goto L7;
        e0 r2 = (e0) r1;
        if (r4.equals(r2.c) == true) goto L13;
        if ((r1 instanceof c0) == false) goto L7;
        e0 r6 = b((c0) r1, r4);
        if (r6 == null) goto L7;
        return r6;
    L13:
        return r2;
    L19:
        return null;
    }

    public final Picture e(com.lynx.component.svg.parser.c r6, com.lynx.component.svg.d r7) {
        this.c = r6;
        a0 r0 = this.a;
        if (r0 != null) goto L6;
        LLog.e("SVG", " bad format SVG, rootElement is null");
        return null;
    L6:
        b r1 = r0.j;
        if (r6 == null) goto L15;
        b r2 = r6.a;
        if (r2 == null) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L15;
        return d((int) Math.ceil(r2.a + r2.c), (int) Math.ceil(r2.b + r2.d), r6, r7);
    L11:
        r3 = false;
    L15:
        o r4 = r0.m;
        if (r4 == null) goto L25;
        Unit r5 = r4.b;
        Unit r8 = Unit.percent;
        if (r5 == r8) goto L25;
        o r9 = r0.n;
        if (r9 == null) goto L25;
        if (r9.b == r8) goto L25;
        return d((int) Math.ceil(r4.a(r6.b, r6.c)), (int) Math.ceil(this.a.n.a(r6.b, r6.c)), r6, r7);
    L25:
        if (r4 == null) goto L29;
        if (r1 == null) goto L29;
        float r10 = r4.a(r6.b, r6.c);
        return d((int) Math.ceil(r10), (int) Math.ceil((r1.d * r10) / r1.c), r6, r7);
    L29:
        o r11 = r0.n;
        if (r11 == null) goto L35;
        if (r1 == null) goto L35;
        float r12 = r11.a(r6.b, r6.c);
        return d((int) Math.ceil((r1.c * r12) / r1.d), (int) Math.ceil(r12), r6, r7);
    L35:
        return d(512, 512, r6, r7);
    }

    public final Picture d(int r5, int r6, com.lynx.component.svg.parser.c r7, com.lynx.component.svg.d r8) {
        this.c = r7;
        Picture r0 = new Picture();
        Canvas r1 = r0.beginRecording(r5, r6);
        if (r7 != null) goto L5;
    L6:
        if (r7 != null) goto L8;
        r7 = new com.lynx.component.svg.parser.c(14.0f, 14.0f);
    L9:
        r7.a = new b(0.0f, 0.0f, r5, r6);
    L10:
        com.lynx.component.svg.parser.e r9 = new com.lynx.component.svg.parser.e(r1, r7.b, r8);
        LLog.i("lynx_UISvg", "beforeRenderDocument(),  svg hasCode:" + this);
        r9.C(this, r7);
        LLog.i("lynx_UISvg", "AfterRenderDocument(),svg hasCode:" + this);
        r0.endRecording();
        return r0;
    L8:
        r7 = new com.lynx.component.svg.parser.c(r7);
        goto L9
    L5:
        if (r7.a != null) goto L10;
        goto L6
    }
}
