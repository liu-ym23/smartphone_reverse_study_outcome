package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.h;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes5.dex */
public class b {
    private static final int[] h = null;
    private static SparseIntArray j;
    private static SparseIntArray k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13767b;
    public int c;
    private boolean d;
    private String[] e;
    private HashMap<String, ConstraintAttribute> f;
    private boolean g;
    private HashMap<Integer, a> i;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f13769b;
        public final d c;
        public final c d;
        public final C0744b e;
        public final e f;
        public HashMap<String, ConstraintAttribute> g;
        C0743a h;

        /* JADX INFO: renamed from: com.obric.oui.constraintlayout.widget.b$a$a, reason: collision with other inner class name */
        static class C0743a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int[] f13770a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int[] f13771b;
            int c;
            int[] d;
            float[] e;
            int f;
            int[] g;
            String[] h;
            int i;
            int[] j;
            boolean[] k;
            int l;

            C0743a() {
                this.f13770a = new int[10];
                this.f13771b = new int[10];
                this.c = 0;
                this.d = new int[10];
                this.e = new float[10];
                this.f = 0;
                this.g = new int[5];
                this.h = new String[5];
                this.i = 0;
                this.j = new int[4];
                this.k = new boolean[4];
                this.l = 0;
            }

            void a(int r4, float r5) {
                int r0 = this.f;
                int[] r1 = this.d;
                if (r0 < r1.length) goto L5;
                this.d = Arrays.copyOf(r1, r1.length * 2);
                float[] r2 = this.e;
                this.e = Arrays.copyOf(r2, r2.length * 2);
            L5:
                int[] r3 = this.d;
                int r6 = this.f;
                r3[r6] = r4;
                float[] r7 = this.e;
                this.f = r6 + 1;
                r7[r6] = r5;
            }

            void a(int r4, int r5) {
                int r0 = this.c;
                int[] r1 = this.f13770a;
                if (r0 < r1.length) goto L5;
                this.f13770a = Arrays.copyOf(r1, r1.length * 2);
                int[] r2 = this.f13771b;
                this.f13771b = Arrays.copyOf(r2, r2.length * 2);
            L5:
                int[] r3 = this.f13770a;
                int r6 = this.c;
                r3[r6] = r4;
                int[] r7 = this.f13771b;
                this.c = r6 + 1;
                r7[r6] = r5;
            }

            void a(int r4, String r5) {
                int r0 = this.i;
                int[] r1 = this.g;
                if (r0 < r1.length) goto L5;
                this.g = Arrays.copyOf(r1, r1.length * 2);
                String[] r2 = this.h;
                this.h = (String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r2, r2.length * 2), String[].class, "com.obric.memorydata.plugin");
            L5:
                int[] r3 = this.g;
                int r6 = this.i;
                r3[r6] = r4;
                String[] r7 = this.h;
                this.i = r6 + 1;
                r7[r6] = r5;
            }

            void a(int r4, boolean r5) {
                int r0 = this.l;
                int[] r1 = this.j;
                if (r0 < r1.length) goto L5;
                this.j = Arrays.copyOf(r1, r1.length * 2);
                boolean[] r2 = this.k;
                this.k = Arrays.copyOf(r2, r2.length * 2);
            L5:
                int[] r3 = this.j;
                int r6 = this.l;
                r3[r6] = r4;
                boolean[] r7 = this.k;
                this.l = r6 + 1;
                r7[r6] = r5;
            }

            void a(a r5) {
                int r0 = 0;
                int r1 = 0;
            L4:
                if (r1 >= this.c) goto L6;
                b.a(r5, this.f13770a[r1], this.f13771b[r1]);
                r1 = r1 + 1;
                goto L4
            L6:
                int r2 = 0;
            L8:
                if (r2 >= this.f) goto L10;
                b.a(r5, this.d[r2], this.e[r2]);
                r2 = r2 + 1;
                goto L8
            L10:
                int r3 = 0;
            L12:
                if (r3 >= this.i) goto L15;
                b.a(r5, this.g[r3], this.h[r3]);
                r3 = r3 + 1;
            L15:
                if (r0 >= this.l) goto L17;
                b.a(r5, this.j[r0], this.k[r0]);
                r0 = r0 + 1;
                goto L15
            }
        }

        public a() {
            this.c = new d();
            this.d = new c();
            this.e = new C0744b();
            this.f = new e();
            this.g = new HashMap();
        }

        private void a(int r2, ConstraintLayout.LayoutParams r3) {
            this.f13768a = r2;
            C0744b r4 = this.e;
            r4.j = r3.e;
            C0744b r5 = this.e;
            r5.k = r3.f;
            C0744b r6 = this.e;
            r6.l = r3.g;
            C0744b r7 = this.e;
            r7.m = r3.h;
            C0744b r8 = this.e;
            r8.n = r3.i;
            C0744b r9 = this.e;
            r9.o = r3.j;
            C0744b r10 = this.e;
            r10.p = r3.k;
            C0744b r11 = this.e;
            r11.q = r3.l;
            C0744b r12 = this.e;
            r12.r = r3.m;
            C0744b r13 = this.e;
            r13.s = r3.n;
            C0744b r14 = this.e;
            r14.t = r3.o;
            C0744b r15 = this.e;
            r15.u = r3.s;
            C0744b r16 = this.e;
            r16.v = r3.t;
            C0744b r17 = this.e;
            r17.w = r3.u;
            C0744b r18 = this.e;
            r18.x = r3.v;
            C0744b r19 = this.e;
            r19.y = r3.G;
            C0744b r20 = this.e;
            r20.z = r3.H;
            C0744b r21 = this.e;
            r21.A = r3.I;
            C0744b r22 = this.e;
            r22.B = r3.p;
            C0744b r23 = this.e;
            r23.C = r3.q;
            C0744b r24 = this.e;
            r24.D = r3.r;
            C0744b r25 = this.e;
            r25.E = r3.X;
            C0744b r26 = this.e;
            r26.F = r3.Y;
            C0744b r27 = this.e;
            r27.G = r3.Z;
            C0744b r28 = this.e;
            r28.h = r3.c;
            C0744b r29 = this.e;
            r29.f = r3.f13747a;
            C0744b r30 = this.e;
            r30.g = r3.f13748b;
            C0744b r31 = this.e;
            r31.d = r3.width;
            C0744b r32 = this.e;
            r32.e = r3.height;
            C0744b r33 = this.e;
            r33.H = r3.leftMargin;
            C0744b r34 = this.e;
            r34.I = r3.rightMargin;
            C0744b r35 = this.e;
            r35.f13772J = r3.topMargin;
            C0744b r36 = this.e;
            r36.K = r3.bottomMargin;
            C0744b r37 = this.e;
            r37.N = r3.D;
            C0744b r38 = this.e;
            r38.V = r3.M;
            C0744b r39 = this.e;
            r39.W = r3.L;
            C0744b r40 = this.e;
            r40.Y = r3.O;
            C0744b r41 = this.e;
            r41.X = r3.N;
            C0744b r42 = this.e;
            r42.an = r3.aa;
            C0744b r43 = this.e;
            r43.ao = r3.ab;
            C0744b r44 = this.e;
            r44.Z = r3.P;
            C0744b r45 = this.e;
            r45.aa = r3.Q;
            C0744b r46 = this.e;
            r46.ab = r3.T;
            C0744b r47 = this.e;
            r47.ac = r3.U;
            C0744b r48 = this.e;
            r48.ad = r3.R;
            C0744b r49 = this.e;
            r49.ae = r3.S;
            C0744b r50 = this.e;
            r50.af = r3.V;
            C0744b r51 = this.e;
            r51.ag = r3.W;
            C0744b r52 = this.e;
            r52.am = r3.ac;
            C0744b r53 = this.e;
            r53.P = r3.x;
            C0744b r54 = this.e;
            r54.R = r3.z;
            C0744b r55 = this.e;
            r55.O = r3.w;
            C0744b r56 = this.e;
            r56.Q = r3.y;
            C0744b r57 = this.e;
            r57.T = r3.A;
            C0744b r58 = this.e;
            r58.S = r3.B;
            C0744b r59 = this.e;
            r59.U = r3.C;
            C0744b r60 = this.e;
            r60.aq = r3.ad;
            C0744b r61 = this.e;
            r61.L = r3.getMarginEnd();
            C0744b r1 = this.e;
            r1.M = r3.getMarginStart();
        }

        private void a(int r2, Constraints.LayoutParams r3) {
            a(r2, r3);
            d r4 = this.c;
            r4.d = r3.ax;
            e r5 = this.f;
            r5.f13780b = r3.aA;
            e r6 = this.f;
            r6.c = r3.aB;
            e r7 = this.f;
            r7.d = r3.aC;
            e r8 = this.f;
            r8.e = r3.aD;
            e r9 = this.f;
            r9.f = r3.aE;
            e r10 = this.f;
            r10.g = r3.aF;
            e r11 = this.f;
            r11.h = r3.aG;
            e r12 = this.f;
            r12.j = r3.aH;
            e r13 = this.f;
            r13.k = r3.aI;
            e r14 = this.f;
            r14.l = r3.aJ;
            e r15 = this.f;
            r15.n = r3.az;
            e r1 = this.f;
            r1.m = r3.ay;
        }

        private void a(ConstraintHelper r1, int r2, Constraints.LayoutParams r3) {
            a(r2, r3);
            if (ZeusTransformUtils.instanceOf(r1, Barrier.class) == false) goto L6;
            this.e.aj = 1;
            Barrier r4 = (Barrier) ZeusTransformUtils.preCheckCast(r1, Barrier.class, "com.obric.memorydata.plugin");
            C0744b r5 = this.e;
            r5.ah = r4.getType();
            C0744b r6 = this.e;
            r6.ak = r4.getReferencedIds();
            C0744b r0 = this.e;
            r0.ai = r4.getMargin();
            return;
        }

        static /* synthetic */ void a(a r0, int r1, ConstraintLayout.LayoutParams r2) {
            r0.a(r1, r2);
        }

        static /* synthetic */ void a(a r0, int r1, Constraints.LayoutParams r2) {
            r0.a(r1, r2);
        }

        static /* synthetic */ void a(a r0, ConstraintHelper r1, int r2, Constraints.LayoutParams r3) {
            r0.a(r1, r2, r3);
        }

        public a a() {
            a r0 = new a();
            r0.e.a(this.e);
            r0.d.a(this.d);
            r0.c.a(this.c);
            r0.f.a(this.f);
            r0.f13768a = this.f13768a;
            r0.h = this.h;
            return r0;
        }

        public void a(ConstraintLayout.LayoutParams r2) {
            r2.e = this.e.j;
            r2.f = this.e.k;
            r2.g = this.e.l;
            r2.h = this.e.m;
            r2.i = this.e.n;
            r2.j = this.e.o;
            r2.k = this.e.p;
            r2.l = this.e.q;
            r2.m = this.e.r;
            r2.n = this.e.s;
            r2.o = this.e.t;
            r2.s = this.e.u;
            r2.t = this.e.v;
            r2.u = this.e.w;
            r2.v = this.e.x;
            r2.leftMargin = this.e.H;
            r2.rightMargin = this.e.I;
            r2.topMargin = this.e.f13772J;
            r2.bottomMargin = this.e.K;
            r2.A = this.e.T;
            r2.B = this.e.S;
            r2.x = this.e.P;
            r2.z = this.e.R;
            r2.G = this.e.y;
            r2.H = this.e.z;
            r2.p = this.e.B;
            r2.q = this.e.C;
            r2.r = this.e.D;
            r2.I = this.e.A;
            r2.X = this.e.E;
            r2.Y = this.e.F;
            r2.M = this.e.V;
            r2.L = this.e.W;
            r2.O = this.e.Y;
            r2.N = this.e.X;
            r2.aa = this.e.an;
            r2.ab = this.e.ao;
            r2.P = this.e.Z;
            r2.Q = this.e.aa;
            r2.T = this.e.ab;
            r2.U = this.e.ac;
            r2.R = this.e.ad;
            r2.S = this.e.ae;
            r2.V = this.e.af;
            r2.W = this.e.ag;
            r2.Z = this.e.G;
            r2.c = this.e.h;
            r2.f13747a = this.e.f;
            r2.f13748b = this.e.g;
            r2.width = this.e.d;
            r2.height = this.e.e;
            if (this.e.am == null) goto L5;
            r2.ac = this.e.am;
        L5:
            r2.ad = this.e.aq;
            r2.setMarginStart(this.e.M);
            r2.setMarginEnd(this.e.L);
            r2.b();
        }

        public void a(a r1) {
            C0743a r0 = this.h;
            if (r0 == null) goto L6;
            r0.a(r1);
            return;
        }

        public /* synthetic */ Object clone() {
            return a();
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.widget.b$b, reason: collision with other inner class name */
    public static class C0744b {
        private static SparseIntArray ar;
        public String A;
        public int B;
        public int C;
        public float D;
        public int E;
        public int F;
        public int G;
        public int H;
        public int I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public int f13772J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public int R;
        public int S;
        public int T;
        public int U;
        public float V;
        public float W;
        public int X;
        public int Y;
        public int Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f13773a;
        public int aa;
        public int ab;
        public int ac;
        public int ad;
        public int ae;
        public float af;
        public float ag;
        public int ah;
        public int ai;
        public int aj;
        public int[] ak;
        public String al;
        public String am;
        public boolean an;
        public boolean ao;
        public boolean ap;
        public int aq;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f13774b;
        public boolean c;
        public int d;
        public int e;
        public int f;
        public int g;
        public float h;
        public boolean i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public int o;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;
        public int w;
        public int x;
        public float y;
        public float z;

        static {
            SparseIntArray r0 = new SparseIntArray();
            ar = r0;
            r0.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintLeft_toLeftOf, "styleable", "Layout_layout_constraintLeft_toLeftOf"), 24);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintLeft_toRightOf, "styleable", "Layout_layout_constraintLeft_toRightOf"), 25);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintRight_toLeftOf, "styleable", "Layout_layout_constraintRight_toLeftOf"), 28);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintRight_toRightOf, "styleable", "Layout_layout_constraintRight_toRightOf"), 29);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintTop_toTopOf, "styleable", "Layout_layout_constraintTop_toTopOf"), 35);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintTop_toBottomOf, "styleable", "Layout_layout_constraintTop_toBottomOf"), 34);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintBottom_toTopOf, "styleable", "Layout_layout_constraintBottom_toTopOf"), 4);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintBottom_toBottomOf, "styleable", "Layout_layout_constraintBottom_toBottomOf"), 3);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintBaseline_toBaselineOf, "styleable", "Layout_layout_constraintBaseline_toBaselineOf"), 1);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_editor_absoluteX, "styleable", "Layout_layout_editor_absoluteX"), 6);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_editor_absoluteY, "styleable", "Layout_layout_editor_absoluteY"), 7);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintGuide_begin, "styleable", "Layout_layout_constraintGuide_begin"), 17);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintGuide_end, "styleable", "Layout_layout_constraintGuide_end"), 18);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintGuide_percent, "styleable", "Layout_layout_constraintGuide_percent"), 19);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_guidelineUseRtl, "styleable", "Layout_guidelineUseRtl"), 90);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_android_orientation, "styleable", "Layout_android_orientation"), 26);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintStart_toEndOf, "styleable", "Layout_layout_constraintStart_toEndOf"), 31);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintStart_toStartOf, "styleable", "Layout_layout_constraintStart_toStartOf"), 32);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintEnd_toStartOf, "styleable", "Layout_layout_constraintEnd_toStartOf"), 10);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintEnd_toEndOf, "styleable", "Layout_layout_constraintEnd_toEndOf"), 9);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_goneMarginLeft, "styleable", "Layout_layout_goneMarginLeft"), 13);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_goneMarginTop, "styleable", "Layout_layout_goneMarginTop"), 16);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_goneMarginRight, "styleable", "Layout_layout_goneMarginRight"), 14);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_goneMarginBottom, "styleable", "Layout_layout_goneMarginBottom"), 11);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_goneMarginStart, "styleable", "Layout_layout_goneMarginStart"), 15);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_goneMarginEnd, "styleable", "Layout_layout_goneMarginEnd"), 12);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintVertical_weight, "styleable", "Layout_layout_constraintVertical_weight"), 38);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintHorizontal_weight, "styleable", "Layout_layout_constraintHorizontal_weight"), 37);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintHorizontal_chainStyle, "styleable", "Layout_layout_constraintHorizontal_chainStyle"), 39);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintVertical_chainStyle, "styleable", "Layout_layout_constraintVertical_chainStyle"), 40);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintHorizontal_bias, "styleable", "Layout_layout_constraintHorizontal_bias"), 20);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintVertical_bias, "styleable", "Layout_layout_constraintVertical_bias"), 36);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintDimensionRatio, "styleable", "Layout_layout_constraintDimensionRatio"), 5);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintLeft_creator, "styleable", "Layout_layout_constraintLeft_creator"), 91);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintTop_creator, "styleable", "Layout_layout_constraintTop_creator"), 91);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintRight_creator, "styleable", "Layout_layout_constraintRight_creator"), 91);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintBottom_creator, "styleable", "Layout_layout_constraintBottom_creator"), 91);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintBaseline_creator, "styleable", "Layout_layout_constraintBaseline_creator"), 91);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_android_layout_marginLeft, "styleable", "Layout_android_layout_marginLeft"), 23);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_android_layout_marginRight, "styleable", "Layout_android_layout_marginRight"), 27);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_android_layout_marginStart, "styleable", "Layout_android_layout_marginStart"), 30);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_android_layout_marginEnd, "styleable", "Layout_android_layout_marginEnd"), 8);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_android_layout_marginTop, "styleable", "Layout_android_layout_marginTop"), 33);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_android_layout_marginBottom, "styleable", "Layout_android_layout_marginBottom"), 2);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_android_layout_width, "styleable", "Layout_android_layout_width"), 22);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_android_layout_height, "styleable", "Layout_android_layout_height"), 21);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintWidth, "styleable", "Layout_layout_constraintWidth"), 41);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintHeight, "styleable", "Layout_layout_constraintHeight"), 42);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constrainedWidth, "styleable", "Layout_layout_constrainedWidth"), 87);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constrainedHeight, "styleable", "Layout_layout_constrainedHeight"), 88);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_wrapBehaviorInParent, "styleable", "Layout_layout_wrapBehaviorInParent"), 76);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintCircle, "styleable", "Layout_layout_constraintCircle"), 61);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintCircleRadius, "styleable", "Layout_layout_constraintCircleRadius"), 62);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintCircleAngle, "styleable", "Layout_layout_constraintCircleAngle"), 63);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintWidth_percent, "styleable", "Layout_layout_constraintWidth_percent"), 69);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintHeight_percent, "styleable", "Layout_layout_constraintHeight_percent"), 70);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_chainUseRtl, "styleable", "Layout_chainUseRtl"), 71);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_barrierDirection, "styleable", "Layout_barrierDirection"), 72);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_barrierMargin, "styleable", "Layout_barrierMargin"), 73);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_constraint_referenced_ids, "styleable", "Layout_constraint_referenced_ids"), 74);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_barrierAllowsGoneWidgets, "styleable", "Layout_barrierAllowsGoneWidgets"), 75);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintWidth_max, "styleable", "Layout_layout_constraintWidth_max"), 84);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintWidth_min, "styleable", "Layout_layout_constraintWidth_min"), 86);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintWidth_max, "styleable", "Layout_layout_constraintWidth_max"), 83);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintHeight_min, "styleable", "Layout_layout_constraintHeight_min"), 85);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintWidth, "styleable", "Layout_layout_constraintWidth"), 87);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintHeight, "styleable", "Layout_layout_constraintHeight"), 88);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintTag, "styleable", "ConstraintLayout_Layout_layout_constraintTag"), 89);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_guidelineUseRtl, "styleable", "Layout_guidelineUseRtl"), 90);
        }

        public C0744b() {
            this.f13773a = false;
            this.f13774b = false;
            this.c = false;
            this.f = -1;
            this.g = -1;
            this.h = -1.0f;
            this.i = true;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = 0.5f;
            this.z = 0.5f;
            this.A = null;
            this.B = -1;
            this.C = 0;
            this.D = 0.0f;
            this.E = -1;
            this.F = -1;
            this.G = -1;
            this.H = 0;
            this.I = 0;
            this.f13772J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = Integer.MIN_VALUE;
            this.P = Integer.MIN_VALUE;
            this.Q = Integer.MIN_VALUE;
            this.R = Integer.MIN_VALUE;
            this.S = Integer.MIN_VALUE;
            this.T = Integer.MIN_VALUE;
            this.U = Integer.MIN_VALUE;
            this.V = -1.0f;
            this.W = -1.0f;
            this.X = 0;
            this.Y = 0;
            this.Z = 0;
            this.aa = 0;
            this.ab = 0;
            this.ac = 0;
            this.ad = 0;
            this.ae = 0;
            this.af = 1.0f;
            this.ag = 1.0f;
            this.ah = -1;
            this.ai = 0;
            this.aj = -1;
            this.an = false;
            this.ao = false;
            this.ap = true;
            this.aq = 0;
        }

        void a(Context r9, AttributeSet r10) {
            TypedArray r11 = ((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin"), R.styleable.Layout);
            this.f13774b = true;
            int r0 = r11.getIndexCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L80;
            int r3 = r11.getIndex(r2);
            int r4 = ar.get(r3);
            switch(r4) {
                case 1: goto L78;
                case 2: goto L77;
                case 3: goto L76;
                case 4: goto L75;
                case 5: goto L74;
                case 6: goto L73;
                case 7: goto L72;
                case 8: goto L71;
                case 9: goto L70;
                case 10: goto L69;
                case 11: goto L68;
                case 12: goto L67;
                case 13: goto L66;
                case 14: goto L65;
                case 15: goto L64;
                case 16: goto L63;
                case 17: goto L62;
                case 18: goto L61;
                case 19: goto L60;
                case 20: goto L59;
                case 21: goto L58;
                case 22: goto L57;
                case 23: goto L56;
                case 24: goto L55;
                case 25: goto L54;
                case 26: goto L53;
                case 27: goto L52;
                case 28: goto L51;
                case 29: goto L50;
                case 30: goto L49;
                case 31: goto L48;
                case 32: goto L47;
                case 33: goto L46;
                case 34: goto L45;
                case 35: goto L44;
                case 36: goto L43;
                case 37: goto L42;
                case 38: goto L41;
                case 39: goto L40;
                case 40: goto L39;
                case 41: goto L38;
                case 42: goto L37;
                default: goto L6;
            };
        L6:
            switch(r4) {
                case 61: goto L36;
                case 62: goto L35;
                case 63: goto L34;
                default: goto L8;
            };
        L34:
            this.D = r11.getFloat(r3, this.D);
        L79:
            r2 = r2 + 1;
            goto L3
        L35:
            this.C = r11.getDimensionPixelSize(r3, this.C);
            goto L79
        L36:
            this.B = b.a(r11, r3, this.B);
            goto L79
        L8:
            switch(r4) {
                case 69: goto L33;
                case 70: goto L32;
                case 71: goto L31;
                case 72: goto L30;
                case 73: goto L29;
                case 74: goto L28;
                case 75: goto L27;
                case 76: goto L26;
                case 77: goto L25;
                case 78: goto L24;
                case 79: goto L23;
                case 80: goto L22;
                case 81: goto L21;
                case 82: goto L20;
                case 83: goto L19;
                case 84: goto L18;
                case 85: goto L17;
                case 86: goto L16;
                case 87: goto L15;
                case 88: goto L14;
                case 89: goto L13;
                case 90: goto L12;
                case 91: goto L11;
                default: goto L9;
            };
        L9:
            StringBuilder r5 = new StringBuilder();
            String r6 = "Unknown attribute 0x";
        L10:
            Log.w("ConstraintSet", r5.append(r6).append(Integer.toHexString(r3)).append("   ").append(ar.get(r3)).toString());
            goto L79
        L11:
            r5 = new StringBuilder();
            r6 = "unused attribute 0x";
            goto L10
        L12:
            this.i = r11.getBoolean(r3, this.i);
            goto L79
        L13:
            this.am = r11.getString(r3);
            goto L79
        L14:
            this.ao = r11.getBoolean(r3, this.ao);
            goto L79
        L15:
            this.an = r11.getBoolean(r3, this.an);
            goto L79
        L16:
            this.ad = r11.getDimensionPixelSize(r3, this.ad);
            goto L79
        L17:
            this.ae = r11.getDimensionPixelSize(r3, this.ae);
            goto L79
        L18:
            this.ab = r11.getDimensionPixelSize(r3, this.ab);
            goto L79
        L19:
            this.ac = r11.getDimensionPixelSize(r3, this.ac);
            goto L79
        L20:
            this.aa = r11.getInt(r3, this.aa);
            goto L79
        L21:
            this.Z = r11.getInt(r3, this.Z);
            goto L79
        L22:
            this.N = r11.getDimensionPixelSize(r3, this.N);
            goto L79
        L23:
            this.U = r11.getDimensionPixelSize(r3, this.U);
            goto L79
        L24:
            this.t = b.a(r11, r3, this.t);
            goto L79
        L25:
            this.s = b.a(r11, r3, this.s);
            goto L79
        L26:
            this.aq = r11.getInt(r3, this.aq);
            goto L79
        L27:
            this.ap = r11.getBoolean(r3, this.ap);
            goto L79
        L28:
            this.al = r11.getString(r3);
            goto L79
        L29:
            this.ai = r11.getDimensionPixelSize(r3, this.ai);
            goto L79
        L30:
            this.ah = r11.getInt(r3, this.ah);
            goto L79
        L31:
            Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
            goto L79
        L32:
            this.ag = r11.getFloat(r3, 1.0f);
            goto L79
        L33:
            this.af = r11.getFloat(r3, 1.0f);
            goto L79
        L37:
            b.a(this, r11, r3, 1);
            goto L79
        L38:
            b.a(this, r11, r3, 0);
            goto L79
        L39:
            this.Y = r11.getInt(r3, this.Y);
            goto L79
        L40:
            this.X = r11.getInt(r3, this.X);
            goto L79
        L41:
            this.V = r11.getFloat(r3, this.V);
            goto L79
        L42:
            this.W = r11.getFloat(r3, this.W);
            goto L79
        L43:
            this.z = r11.getFloat(r3, this.z);
            goto L79
        L44:
            this.n = b.a(r11, r3, this.n);
            goto L79
        L45:
            this.o = b.a(r11, r3, this.o);
            goto L79
        L46:
            this.f13772J = r11.getDimensionPixelSize(r3, this.f13772J);
            goto L79
        L47:
            this.v = b.a(r11, r3, this.v);
            goto L79
        L48:
            this.u = b.a(r11, r3, this.u);
            goto L79
        L49:
            this.M = r11.getDimensionPixelSize(r3, this.M);
            goto L79
        L50:
            this.m = b.a(r11, r3, this.m);
            goto L79
        L51:
            this.l = b.a(r11, r3, this.l);
            goto L79
        L52:
            this.I = r11.getDimensionPixelSize(r3, this.I);
            goto L79
        L53:
            this.G = r11.getInt(r3, this.G);
            goto L79
        L54:
            this.k = b.a(r11, r3, this.k);
            goto L79
        L55:
            this.j = b.a(r11, r3, this.j);
            goto L79
        L56:
            this.H = r11.getDimensionPixelSize(r3, this.H);
            goto L79
        L57:
            this.d = r11.getLayoutDimension(r3, this.d);
            goto L79
        L58:
            this.e = r11.getLayoutDimension(r3, this.e);
            goto L79
        L59:
            this.y = r11.getFloat(r3, this.y);
            goto L79
        L60:
            this.h = r11.getFloat(r3, this.h);
            goto L79
        L61:
            this.g = r11.getDimensionPixelOffset(r3, this.g);
            goto L79
        L62:
            this.f = r11.getDimensionPixelOffset(r3, this.f);
            goto L79
        L63:
            this.P = r11.getDimensionPixelSize(r3, this.P);
            goto L79
        L64:
            this.T = r11.getDimensionPixelSize(r3, this.T);
            goto L79
        L65:
            this.Q = r11.getDimensionPixelSize(r3, this.Q);
            goto L79
        L66:
            this.O = r11.getDimensionPixelSize(r3, this.O);
            goto L79
        L67:
            this.S = r11.getDimensionPixelSize(r3, this.S);
            goto L79
        L68:
            this.R = r11.getDimensionPixelSize(r3, this.R);
            goto L79
        L69:
            this.w = b.a(r11, r3, this.w);
            goto L79
        L70:
            this.x = b.a(r11, r3, this.x);
            goto L79
        L71:
            this.L = r11.getDimensionPixelSize(r3, this.L);
            goto L79
        L72:
            this.F = r11.getDimensionPixelOffset(r3, this.F);
            goto L79
        L73:
            this.E = r11.getDimensionPixelOffset(r3, this.E);
            goto L79
        L74:
            this.A = r11.getString(r3);
            goto L79
        L75:
            this.p = b.a(r11, r3, this.p);
            goto L79
        L76:
            this.q = b.a(r11, r3, this.q);
            goto L79
        L77:
            this.K = r11.getDimensionPixelSize(r3, this.K);
            goto L79
        L78:
            this.r = b.a(r11, r3, this.r);
            goto L79
        L80:
            r11.recycle();
        }

        public void a(C0744b r3) {
            this.f13773a = r3.f13773a;
            this.d = r3.d;
            this.f13774b = r3.f13774b;
            this.e = r3.e;
            this.f = r3.f;
            this.g = r3.g;
            this.h = r3.h;
            this.i = r3.i;
            this.j = r3.j;
            this.k = r3.k;
            this.l = r3.l;
            this.m = r3.m;
            this.n = r3.n;
            this.o = r3.o;
            this.p = r3.p;
            this.q = r3.q;
            this.r = r3.r;
            this.s = r3.s;
            this.t = r3.t;
            this.u = r3.u;
            this.v = r3.v;
            this.w = r3.w;
            this.x = r3.x;
            this.y = r3.y;
            this.z = r3.z;
            this.A = r3.A;
            this.B = r3.B;
            this.C = r3.C;
            this.D = r3.D;
            this.E = r3.E;
            this.F = r3.F;
            this.G = r3.G;
            this.H = r3.H;
            this.I = r3.I;
            this.f13772J = r3.f13772J;
            this.K = r3.K;
            this.L = r3.L;
            this.M = r3.M;
            this.N = r3.N;
            this.O = r3.O;
            this.P = r3.P;
            this.Q = r3.Q;
            this.R = r3.R;
            this.S = r3.S;
            this.T = r3.T;
            this.U = r3.U;
            this.V = r3.V;
            this.W = r3.W;
            this.X = r3.X;
            this.Y = r3.Y;
            this.Z = r3.Z;
            this.aa = r3.aa;
            this.ab = r3.ab;
            this.ac = r3.ac;
            this.ad = r3.ad;
            this.ae = r3.ae;
            this.af = r3.af;
            this.ag = r3.ag;
            this.ah = r3.ah;
            this.ai = r3.ai;
            this.aj = r3.aj;
            this.am = r3.am;
            int[] r0 = r3.ak;
            if (r0 != null) goto L5;
        L7:
            this.ak = null;
        L8:
            this.al = r3.al;
            this.an = r3.an;
            this.ao = r3.ao;
            this.ap = r3.ap;
            this.aq = r3.aq;
            return;
        L5:
            if (r3.al != null) goto L7;
            this.ak = Arrays.copyOf(r0, r0.length);
            goto L8
        }
    }

    public static class c {
        private static SparseIntArray o;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f13775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f13776b;
        public int c;
        public String d;
        public int e;
        public int f;
        public float g;
        public int h;
        public float i;
        public float j;
        public int k;
        public String l;
        public int m;
        public int n;

        static {
            SparseIntArray r0 = new SparseIntArray();
            o = r0;
            r0.append(ZeusTransformUtils.mapRes(R.styleable.Motion_motionPathRotate, "styleable", "Motion_motionPathRotate"), 1);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Motion_pathMotionArc, "styleable", "Motion_pathMotionArc"), 2);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Motion_transitionEasing, "styleable", "Motion_transitionEasing"), 3);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Motion_drawPath, "styleable", "Motion_drawPath"), 4);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Motion_animateRelativeTo, "styleable", "Motion_animateRelativeTo"), 5);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Motion_animateCircleAngleTo, "styleable", "Motion_animateCircleAngleTo"), 6);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Motion_motionStagger, "styleable", "Motion_motionStagger"), 7);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Motion_quantizeMotionSteps, "styleable", "Motion_quantizeMotionSteps"), 8);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Motion_quantizeMotionPhase, "styleable", "Motion_quantizeMotionPhase"), 9);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Motion_quantizeMotionInterpolator, "styleable", "Motion_quantizeMotionInterpolator"), 10);
        }

        public c() {
            this.f13775a = false;
            this.f13776b = -1;
            this.c = 0;
            this.d = null;
            this.e = -1;
            this.f = 0;
            this.g = Float.NaN;
            this.h = -1;
            this.i = Float.NaN;
            this.j = Float.NaN;
            this.k = -1;
            this.l = null;
            this.m = -3;
            this.n = -1;
        }

        void a(Context r10, AttributeSet r11) {
            TypedArray r12 = ((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin"), R.styleable.Motion);
            this.f13775a = true;
            int r0 = r12.getIndexCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L33;
            int r3 = r12.getIndex(r2);
            switch(o.get(r3)) {
                case 1: goto L31;
                case 2: goto L30;
                case 3: goto L26;
                case 4: goto L24;
                case 5: goto L23;
                case 6: goto L22;
                case 7: goto L21;
                case 8: goto L20;
                case 9: goto L19;
                case 10: goto L7;
                default: goto L32;
            };
        L7:
            TypedValue r4 = r12.peekValue(r3);
            if (r4.type != 1) goto L13;
            int r5 = r12.getResourceId(r3, -1);
            this.n = r5;
            if (r5 == (-1)) goto L32;
        L11:
            this.m = -2;
            goto L32
        L13:
            if (r4.type != 3) goto L18;
            String r6 = r12.getString(r3);
            this.l = r6;
            if (r6.indexOf("/") <= 0) goto L17;
            this.n = r12.getResourceId(r3, -1);
            goto L11
        L17:
            this.m = -1;
            goto L32
        L18:
            this.m = r12.getInteger(r3, this.n);
            goto L32
        L19:
            this.j = r12.getFloat(r3, this.j);
            goto L32
        L20:
            this.k = r12.getInteger(r3, this.k);
            goto L32
        L21:
            this.g = r12.getFloat(r3, this.g);
            goto L32
        L22:
            this.c = r12.getInteger(r3, this.c);
            goto L32
        L23:
            this.f13776b = b.a(r12, r3, this.f13776b);
            goto L32
        L24:
            this.f = r12.getInt(r3, 0);
            goto L32
        L30:
            this.e = r12.getInt(r3, this.e);
            goto L32
        L31:
            this.i = r12.getFloat(r3, this.i);
            goto L32
        L26:
            if (r12.peekValue(r3).type != 3) goto L28;
            String r7 = r12.getString(r3);
        L29:
            this.d = r7;
            goto L32
        L28:
            r7 = com.obric.oui.constraintlayout.core.motion.a.c.c[r12.getInteger(r3, 0)];
        L32:
            r2 = r2 + 1;
            goto L3
        L33:
            r12.recycle();
        }

        public void a(c r2) {
            this.f13775a = r2.f13775a;
            this.f13776b = r2.f13776b;
            this.d = r2.d;
            this.e = r2.e;
            this.f = r2.f;
            this.i = r2.i;
            this.g = r2.g;
            this.h = r2.h;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f13777a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f13778b;
        public int c;
        public float d;
        public float e;

        public d() {
            this.f13777a = false;
            this.f13778b = 0;
            this.c = 0;
            this.d = 1.0f;
            this.e = Float.NaN;
        }

        void a(Context r6, AttributeSet r7) {
            TypedArray r8 = ((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin"), R.styleable.PropertySet);
            this.f13777a = true;
            int r9 = r8.getIndexCount();
            int r0 = 0;
        L3:
            if (r0 >= r9) goto L17;
            int r1 = r8.getIndex(r0);
            if (r1 != ZeusTransformUtils.mapRes(R.styleable.PropertySet_android_alpha, "styleable", "PropertySet_android_alpha")) goto L8;
            this.d = r8.getFloat(r1, this.d);
        L16:
            r0 = r0 + 1;
            goto L3
        L8:
            if (r1 != ZeusTransformUtils.mapRes(R.styleable.PropertySet_android_visibility, "styleable", "PropertySet_android_visibility")) goto L11;
            this.f13778b = r8.getInt(r1, this.f13778b);
            this.f13778b = b.c()[this.f13778b];
            goto L16
        L11:
            if (r1 != ZeusTransformUtils.mapRes(R.styleable.PropertySet_visibilityMode, "styleable", "PropertySet_visibilityMode")) goto L14;
            this.c = r8.getInt(r1, this.c);
            goto L16
        L14:
            if (r1 != ZeusTransformUtils.mapRes(R.styleable.PropertySet_motionProgress, "styleable", "PropertySet_motionProgress")) goto L16;
            this.e = r8.getFloat(r1, this.e);
            goto L16
        L17:
            r8.recycle();
        }

        public void a(d r2) {
            this.f13777a = r2.f13777a;
            this.f13778b = r2.f13778b;
            this.d = r2.d;
            this.e = r2.e;
            this.c = r2.c;
        }
    }

    public static class e {
        private static SparseIntArray o;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f13779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f13780b;
        public float c;
        public float d;
        public float e;
        public float f;
        public float g;
        public float h;
        public int i;
        public float j;
        public float k;
        public float l;
        public boolean m;
        public float n;

        static {
            SparseIntArray r0 = new SparseIntArray();
            o = r0;
            r0.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_rotation, "styleable", "Transform_android_rotation"), 1);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_rotationX, "styleable", "Transform_android_rotationX"), 2);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_rotationY, "styleable", "Transform_android_rotationY"), 3);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_scaleX, "styleable", "Transform_android_scaleX"), 4);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_scaleY, "styleable", "Transform_android_scaleY"), 5);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_transformPivotX, "styleable", "Transform_android_transformPivotX"), 6);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_transformPivotY, "styleable", "Transform_android_transformPivotY"), 7);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_translationX, "styleable", "Transform_android_translationX"), 8);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_translationY, "styleable", "Transform_android_translationY"), 9);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_translationZ, "styleable", "Transform_android_translationZ"), 10);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_elevation, "styleable", "Transform_android_elevation"), 11);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Transform_transformPivotTarget, "styleable", "Transform_transformPivotTarget"), 12);
        }

        public e() {
            this.f13779a = false;
            this.f13780b = 0.0f;
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 1.0f;
            this.f = 1.0f;
            this.g = Float.NaN;
            this.h = Float.NaN;
            this.i = -1;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = false;
            this.n = 0.0f;
        }

        void a(Context r5, AttributeSet r6) {
            TypedArray r7 = ((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin"), R.styleable.Transform);
            this.f13779a = true;
            int r0 = r7.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L20;
            int r2 = r7.getIndex(r1);
            switch(o.get(r2)) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                case 9: goto L10;
                case 10: goto L9;
                case 11: goto L8;
                case 12: goto L7;
                default: goto L19;
            };
        L7:
            this.i = b.a(r7, r2, this.i);
            goto L19
        L8:
            this.m = true;
            this.n = r7.getDimension(r2, this.n);
            goto L19
        L9:
            this.l = r7.getDimension(r2, this.l);
            goto L19
        L10:
            this.k = r7.getDimension(r2, this.k);
            goto L19
        L11:
            this.j = r7.getDimension(r2, this.j);
            goto L19
        L12:
            this.h = r7.getDimension(r2, this.h);
            goto L19
        L13:
            this.g = r7.getDimension(r2, this.g);
            goto L19
        L14:
            this.f = r7.getFloat(r2, this.f);
            goto L19
        L15:
            this.e = r7.getFloat(r2, this.e);
            goto L19
        L16:
            this.d = r7.getFloat(r2, this.d);
            goto L19
        L17:
            this.c = r7.getFloat(r2, this.c);
            goto L19
        L18:
            this.f13780b = r7.getFloat(r2, this.f13780b);
        L19:
            r1 = r1 + 1;
            goto L3
        L20:
            r7.recycle();
        }

        public void a(e r2) {
            this.f13779a = r2.f13779a;
            this.f13780b = r2.f13780b;
            this.c = r2.c;
            this.d = r2.d;
            this.e = r2.e;
            this.f = r2.f;
            this.g = r2.g;
            this.h = r2.h;
            this.i = r2.i;
            this.j = r2.j;
            this.k = r2.k;
            this.l = r2.l;
            this.m = r2.m;
            this.n = r2.n;
        }
    }

    static {
        h = new int[]{0, 4, 8};
        j = new SparseIntArray();
        k = new SparseIntArray();
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintLeft_toLeftOf, "styleable", "Constraint_layout_constraintLeft_toLeftOf"), 25);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintLeft_toRightOf, "styleable", "Constraint_layout_constraintLeft_toRightOf"), 26);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintRight_toLeftOf, "styleable", "Constraint_layout_constraintRight_toLeftOf"), 29);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintRight_toRightOf, "styleable", "Constraint_layout_constraintRight_toRightOf"), 30);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintTop_toTopOf, "styleable", "Constraint_layout_constraintTop_toTopOf"), 36);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintTop_toBottomOf, "styleable", "Constraint_layout_constraintTop_toBottomOf"), 35);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBottom_toTopOf, "styleable", "Constraint_layout_constraintBottom_toTopOf"), 4);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBottom_toBottomOf, "styleable", "Constraint_layout_constraintBottom_toBottomOf"), 3);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, "styleable", "Constraint_layout_constraintBaseline_toBaselineOf"), 1);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBaseline_toTopOf, "styleable", "Constraint_layout_constraintBaseline_toTopOf"), 91);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBaseline_toBottomOf, "styleable", "Constraint_layout_constraintBaseline_toBottomOf"), 92);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_editor_absoluteX, "styleable", "Constraint_layout_editor_absoluteX"), 6);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_editor_absoluteY, "styleable", "Constraint_layout_editor_absoluteY"), 7);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintGuide_begin, "styleable", "Constraint_layout_constraintGuide_begin"), 17);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintGuide_end, "styleable", "Constraint_layout_constraintGuide_end"), 18);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintGuide_percent, "styleable", "Constraint_layout_constraintGuide_percent"), 19);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_guidelineUseRtl, "styleable", "Constraint_guidelineUseRtl"), 99);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_orientation, "styleable", "Constraint_android_orientation"), 27);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintStart_toEndOf, "styleable", "Constraint_layout_constraintStart_toEndOf"), 32);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintStart_toStartOf, "styleable", "Constraint_layout_constraintStart_toStartOf"), 33);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintEnd_toStartOf, "styleable", "Constraint_layout_constraintEnd_toStartOf"), 10);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintEnd_toEndOf, "styleable", "Constraint_layout_constraintEnd_toEndOf"), 9);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_goneMarginLeft, "styleable", "Constraint_layout_goneMarginLeft"), 13);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_goneMarginTop, "styleable", "Constraint_layout_goneMarginTop"), 16);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_goneMarginRight, "styleable", "Constraint_layout_goneMarginRight"), 14);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_goneMarginBottom, "styleable", "Constraint_layout_goneMarginBottom"), 11);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_goneMarginStart, "styleable", "Constraint_layout_goneMarginStart"), 15);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_goneMarginEnd, "styleable", "Constraint_layout_goneMarginEnd"), 12);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintVertical_weight, "styleable", "Constraint_layout_constraintVertical_weight"), 40);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHorizontal_weight, "styleable", "Constraint_layout_constraintHorizontal_weight"), 39);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, "styleable", "Constraint_layout_constraintHorizontal_chainStyle"), 41);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintVertical_chainStyle, "styleable", "Constraint_layout_constraintVertical_chainStyle"), 42);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHorizontal_bias, "styleable", "Constraint_layout_constraintHorizontal_bias"), 20);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintVertical_bias, "styleable", "Constraint_layout_constraintVertical_bias"), 37);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintDimensionRatio, "styleable", "Constraint_layout_constraintDimensionRatio"), 5);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintLeft_creator, "styleable", "Constraint_layout_constraintLeft_creator"), 87);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintTop_creator, "styleable", "Constraint_layout_constraintTop_creator"), 87);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintRight_creator, "styleable", "Constraint_layout_constraintRight_creator"), 87);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBottom_creator, "styleable", "Constraint_layout_constraintBottom_creator"), 87);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBaseline_creator, "styleable", "Constraint_layout_constraintBaseline_creator"), 87);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginLeft, "styleable", "Constraint_android_layout_marginLeft"), 24);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginRight, "styleable", "Constraint_android_layout_marginRight"), 28);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginStart, "styleable", "Constraint_android_layout_marginStart"), 31);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginEnd, "styleable", "Constraint_android_layout_marginEnd"), 8);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginTop, "styleable", "Constraint_android_layout_marginTop"), 34);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginBottom, "styleable", "Constraint_android_layout_marginBottom"), 2);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_width, "styleable", "Constraint_android_layout_width"), 23);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_height, "styleable", "Constraint_android_layout_height"), 21);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintWidth, "styleable", "Constraint_layout_constraintWidth"), 95);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHeight, "styleable", "Constraint_layout_constraintHeight"), 96);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_visibility, "styleable", "Constraint_android_visibility"), 22);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_alpha, "styleable", "Constraint_android_alpha"), 43);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_elevation, "styleable", "Constraint_android_elevation"), 44);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_rotationX, "styleable", "Constraint_android_rotationX"), 45);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_rotationY, "styleable", "Constraint_android_rotationY"), 46);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_rotation, "styleable", "Constraint_android_rotation"), 60);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_scaleX, "styleable", "Constraint_android_scaleX"), 47);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_scaleY, "styleable", "Constraint_android_scaleY"), 48);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_transformPivotX, "styleable", "Constraint_android_transformPivotX"), 49);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_transformPivotY, "styleable", "Constraint_android_transformPivotY"), 50);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_translationX, "styleable", "Constraint_android_translationX"), 51);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_translationY, "styleable", "Constraint_android_translationY"), 52);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_translationZ, "styleable", "Constraint_android_translationZ"), 53);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintWidth_default, "styleable", "Constraint_layout_constraintWidth_default"), 54);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHeight_default, "styleable", "Constraint_layout_constraintHeight_default"), 55);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintWidth_max, "styleable", "Constraint_layout_constraintWidth_max"), 56);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHeight_max, "styleable", "Constraint_layout_constraintHeight_max"), 57);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintWidth_min, "styleable", "Constraint_layout_constraintWidth_min"), 58);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHeight_min, "styleable", "Constraint_layout_constraintHeight_min"), 59);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintCircle, "styleable", "Constraint_layout_constraintCircle"), 61);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintCircleRadius, "styleable", "Constraint_layout_constraintCircleRadius"), 62);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintCircleAngle, "styleable", "Constraint_layout_constraintCircleAngle"), 63);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_animateRelativeTo, "styleable", "Constraint_animateRelativeTo"), 64);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_transitionEasing, "styleable", "Constraint_transitionEasing"), 65);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_drawPath, "styleable", "Constraint_drawPath"), 66);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_transitionPathRotate, "styleable", "Constraint_transitionPathRotate"), 67);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_motionStagger, "styleable", "Constraint_motionStagger"), 79);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_id, "styleable", "Constraint_android_id"), 38);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_motionProgress, "styleable", "Constraint_motionProgress"), 68);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintWidth_percent, "styleable", "Constraint_layout_constraintWidth_percent"), 69);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHeight_percent, "styleable", "Constraint_layout_constraintHeight_percent"), 70);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_wrapBehaviorInParent, "styleable", "Constraint_layout_wrapBehaviorInParent"), 97);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_chainUseRtl, "styleable", "Constraint_chainUseRtl"), 71);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_barrierDirection, "styleable", "Constraint_barrierDirection"), 72);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_barrierMargin, "styleable", "Constraint_barrierMargin"), 73);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_constraint_referenced_ids, "styleable", "Constraint_constraint_referenced_ids"), 74);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_barrierAllowsGoneWidgets, "styleable", "Constraint_barrierAllowsGoneWidgets"), 75);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_pathMotionArc, "styleable", "Constraint_pathMotionArc"), 76);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintTag, "styleable", "Constraint_layout_constraintTag"), 77);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_visibilityMode, "styleable", "Constraint_visibilityMode"), 78);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constrainedWidth, "styleable", "Constraint_layout_constrainedWidth"), 80);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constrainedHeight, "styleable", "Constraint_layout_constrainedHeight"), 81);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_polarRelativeTo, "styleable", "Constraint_polarRelativeTo"), 82);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_transformPivotTarget, "styleable", "Constraint_transformPivotTarget"), 83);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_quantizeMotionSteps, "styleable", "Constraint_quantizeMotionSteps"), 84);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_quantizeMotionPhase, "styleable", "Constraint_quantizeMotionPhase"), 85);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_quantizeMotionInterpolator, "styleable", "Constraint_quantizeMotionInterpolator"), 86);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_editor_absoluteY, "styleable", "ConstraintOverride_layout_editor_absoluteY"), 6);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_editor_absoluteY, "styleable", "ConstraintOverride_layout_editor_absoluteY"), 7);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_orientation, "styleable", "ConstraintOverride_android_orientation"), 27);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_goneMarginLeft, "styleable", "ConstraintOverride_layout_goneMarginLeft"), 13);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_goneMarginTop, "styleable", "ConstraintOverride_layout_goneMarginTop"), 16);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_goneMarginRight, "styleable", "ConstraintOverride_layout_goneMarginRight"), 14);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_goneMarginBottom, "styleable", "ConstraintOverride_layout_goneMarginBottom"), 11);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_goneMarginStart, "styleable", "ConstraintOverride_layout_goneMarginStart"), 15);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_goneMarginEnd, "styleable", "ConstraintOverride_layout_goneMarginEnd"), 12);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintVertical_weight, "styleable", "ConstraintOverride_layout_constraintVertical_weight"), 40);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHorizontal_weight, "styleable", "ConstraintOverride_layout_constraintHorizontal_weight"), 39);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, "styleable", "ConstraintOverride_layout_constraintHorizontal_chainStyle"), 41);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintVertical_chainStyle, "styleable", "ConstraintOverride_layout_constraintVertical_chainStyle"), 42);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHorizontal_bias, "styleable", "ConstraintOverride_layout_constraintHorizontal_bias"), 20);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintVertical_bias, "styleable", "ConstraintOverride_layout_constraintVertical_bias"), 37);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintDimensionRatio, "styleable", "ConstraintOverride_layout_constraintDimensionRatio"), 5);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintLeft_creator, "styleable", "ConstraintOverride_layout_constraintLeft_creator"), 87);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintTop_creator, "styleable", "ConstraintOverride_layout_constraintTop_creator"), 87);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintRight_creator, "styleable", "ConstraintOverride_layout_constraintRight_creator"), 87);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintBottom_creator, "styleable", "ConstraintOverride_layout_constraintBottom_creator"), 87);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintBaseline_creator, "styleable", "ConstraintOverride_layout_constraintBaseline_creator"), 87);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_marginLeft, "styleable", "ConstraintOverride_android_layout_marginLeft"), 24);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_marginRight, "styleable", "ConstraintOverride_android_layout_marginRight"), 28);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_marginStart, "styleable", "ConstraintOverride_android_layout_marginStart"), 31);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_marginEnd, "styleable", "ConstraintOverride_android_layout_marginEnd"), 8);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_marginTop, "styleable", "ConstraintOverride_android_layout_marginTop"), 34);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_marginBottom, "styleable", "ConstraintOverride_android_layout_marginBottom"), 2);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_width, "styleable", "ConstraintOverride_android_layout_width"), 23);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_height, "styleable", "ConstraintOverride_android_layout_height"), 21);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintWidth, "styleable", "ConstraintOverride_layout_constraintWidth"), 95);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHeight, "styleable", "ConstraintOverride_layout_constraintHeight"), 96);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_visibility, "styleable", "ConstraintOverride_android_visibility"), 22);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_alpha, "styleable", "ConstraintOverride_android_alpha"), 43);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_elevation, "styleable", "ConstraintOverride_android_elevation"), 44);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_rotationX, "styleable", "ConstraintOverride_android_rotationX"), 45);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_rotationY, "styleable", "ConstraintOverride_android_rotationY"), 46);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_rotation, "styleable", "ConstraintOverride_android_rotation"), 60);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_scaleX, "styleable", "ConstraintOverride_android_scaleX"), 47);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_scaleY, "styleable", "ConstraintOverride_android_scaleY"), 48);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_transformPivotX, "styleable", "ConstraintOverride_android_transformPivotX"), 49);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_transformPivotY, "styleable", "ConstraintOverride_android_transformPivotY"), 50);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_translationX, "styleable", "ConstraintOverride_android_translationX"), 51);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_translationY, "styleable", "ConstraintOverride_android_translationY"), 52);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_translationZ, "styleable", "ConstraintOverride_android_translationZ"), 53);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintWidth_default, "styleable", "ConstraintOverride_layout_constraintWidth_default"), 54);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHeight_default, "styleable", "ConstraintOverride_layout_constraintHeight_default"), 55);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintWidth_max, "styleable", "ConstraintOverride_layout_constraintWidth_max"), 56);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHeight_max, "styleable", "ConstraintOverride_layout_constraintHeight_max"), 57);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintWidth_min, "styleable", "ConstraintOverride_layout_constraintWidth_min"), 58);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHeight_min, "styleable", "ConstraintOverride_layout_constraintHeight_min"), 59);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintCircleRadius, "styleable", "ConstraintOverride_layout_constraintCircleRadius"), 62);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintCircleAngle, "styleable", "ConstraintOverride_layout_constraintCircleAngle"), 63);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_animateRelativeTo, "styleable", "ConstraintOverride_animateRelativeTo"), 64);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_transitionEasing, "styleable", "ConstraintOverride_transitionEasing"), 65);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_drawPath, "styleable", "ConstraintOverride_drawPath"), 66);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_transitionPathRotate, "styleable", "ConstraintOverride_transitionPathRotate"), 67);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_motionStagger, "styleable", "ConstraintOverride_motionStagger"), 79);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_id, "styleable", "ConstraintOverride_android_id"), 38);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_motionTarget, "styleable", "ConstraintOverride_motionTarget"), 98);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_motionProgress, "styleable", "ConstraintOverride_motionProgress"), 68);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintWidth_percent, "styleable", "ConstraintOverride_layout_constraintWidth_percent"), 69);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHeight_percent, "styleable", "ConstraintOverride_layout_constraintHeight_percent"), 70);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_chainUseRtl, "styleable", "ConstraintOverride_chainUseRtl"), 71);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_barrierDirection, "styleable", "ConstraintOverride_barrierDirection"), 72);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_barrierMargin, "styleable", "ConstraintOverride_barrierMargin"), 73);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_constraint_referenced_ids, "styleable", "ConstraintOverride_constraint_referenced_ids"), 74);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_barrierAllowsGoneWidgets, "styleable", "ConstraintOverride_barrierAllowsGoneWidgets"), 75);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_pathMotionArc, "styleable", "ConstraintOverride_pathMotionArc"), 76);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintTag, "styleable", "ConstraintOverride_layout_constraintTag"), 77);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_visibilityMode, "styleable", "ConstraintOverride_visibilityMode"), 78);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constrainedWidth, "styleable", "ConstraintOverride_layout_constrainedWidth"), 80);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constrainedHeight, "styleable", "ConstraintOverride_layout_constrainedHeight"), 81);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_polarRelativeTo, "styleable", "ConstraintOverride_polarRelativeTo"), 82);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_transformPivotTarget, "styleable", "ConstraintOverride_transformPivotTarget"), 83);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_quantizeMotionSteps, "styleable", "ConstraintOverride_quantizeMotionSteps"), 84);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_quantizeMotionPhase, "styleable", "ConstraintOverride_quantizeMotionPhase"), 85);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_quantizeMotionInterpolator, "styleable", "ConstraintOverride_quantizeMotionInterpolator"), 86);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_wrapBehaviorInParent, "styleable", "ConstraintOverride_layout_wrapBehaviorInParent"), 97);
    }

    public b() {
        this.f13767b = "";
        this.e = new String[0];
        this.c = 0;
        this.f = new HashMap();
        this.g = true;
        this.i = new HashMap();
    }

    static /* synthetic */ int a(TypedArray r0, int r1, int r2) {
        return b(r0, r1, r2);
    }

    private a a(Context r3, AttributeSet r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        a r0 = new a();
        if (r5 == false) goto L5;
        int[] r1 = R.styleable.ConstraintOverride;
    L6:
        TypedArray r8 = r6.obtainStyledAttributes(r7, r1);
        a(r0, r8, r5);
        r8.recycle();
        return r0;
    L5:
        r1 = R.styleable.Constraint;
        goto L6
    }

    static void a(ConstraintLayout.LayoutParams r8, String r9) {
        float r0 = Float.NaN;
        int r1 = -1;
        if (r9 == null) goto L34;
        int r2 = r9.length();
        int r3 = r9.indexOf(44);
        int r4 = 0;
        if (r3 > 0) goto L7;
    L15:
        int r5 = r9.indexOf(58);
        if (r5 >= 0) goto L18;
    L31:
        String r6 = r9.substring(r4);
        if (r6.length() <= 0) goto L34;
        r0 = Float.parseFloat(r6);     // Catch: NumberFormatException -> L36
    L37:
        goto L34
    L18:
        if (r5 >= (r2 - 1)) goto L31;
        String r7 = r9.substring(r4, r5);
        String r10 = r9.substring(r5 + 1);
        if (r7.length() <= 0) goto L34;
        if (r10.length() <= 0) goto L34;
        float r11 = Float.parseFloat(r7);     // Catch: NumberFormatException -> L36
        float r12 = Float.parseFloat(r10);     // Catch: NumberFormatException -> L36
        if (r11 <= 0.0f) goto L37;
        if (r12 <= 0.0f) goto L37;
        if (r1 != 1) goto L29;
        r0 = Math.abs(r12 / r11);     // Catch: NumberFormatException -> L36
        goto L37
    L29:
        r0 = Math.abs(r11 / r12);     // Catch: NumberFormatException -> L36
        goto L37
    L7:
        if (r3 >= (r2 - 1)) goto L15;
        String r13 = r9.substring(0, r3);
        if (r13.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST) == false) goto L12;
        r1 = 0;
    L14:
        r4 = r3 + 1;
        goto L15
    L12:
        if (r13.equalsIgnoreCase(i.n) == false) goto L14;
        r1 = 1;
    L34:
        r8.I = r9;
        r8.f13746J = r0;
        r8.K = r1;
    }

    static /* synthetic */ void a(a r0, int r1, float r2) {
        b(r0, r1, r2);
    }

    static /* synthetic */ void a(a r0, int r1, int r2) {
        b(r0, r1, r2);
    }

    static /* synthetic */ void a(a r0, int r1, String r2) {
        b(r0, r1, r2);
    }

    static /* synthetic */ void a(a r0, int r1, boolean r2) {
        b(r0, r1, r2);
    }

    private static void a(a r13, TypedArray r14) {
        int r0 = r14.getIndexCount();
        a.C0743a r1 = new a.C0743a();
        r13.h = r1;
        r13.d.f13775a = false;
        r13.e.f13774b = false;
        r13.c.f13777a = false;
        r13.f.f13779a = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L125;
        int r4 = r14.getIndex(r2);
        float r6 = 1.0f;
        switch(k.get(r4)) {
            case 2: goto L121;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L119;
            case 6: goto L117;
            case 7: goto L116;
            case 8: goto L115;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L114;
            case 12: goto L113;
            case 13: goto L112;
            case 14: goto L111;
            case 15: goto L110;
            case 16: goto L109;
            case 17: goto L108;
            case 18: goto L107;
            case 19: goto L104;
            case 20: goto L103;
            case 21: goto L101;
            case 22: goto L100;
            case 23: goto L99;
            case 24: goto L98;
            case 25: goto L6;
            case 26: goto L6;
            case 27: goto L96;
            case 28: goto L95;
            case 29: goto L6;
            case 30: goto L6;
            case 31: goto L94;
            case 32: goto L6;
            case 33: goto L6;
            case 34: goto L93;
            case 35: goto L6;
            case 36: goto L6;
            case 37: goto L92;
            case 38: goto L91;
            case 39: goto L90;
            case 40: goto L89;
            case 41: goto L88;
            case 42: goto L87;
            case 43: goto L86;
            case 44: goto L84;
            case 45: goto L83;
            case 46: goto L82;
            case 47: goto L81;
            case 48: goto L80;
            case 49: goto L79;
            case 50: goto L78;
            case 51: goto L77;
            case 52: goto L76;
            case 53: goto L75;
            case 54: goto L74;
            case 55: goto L73;
            case 56: goto L72;
            case 57: goto L71;
            case 58: goto L70;
            case 59: goto L69;
            case 60: goto L68;
            case 61: goto L6;
            case 62: goto L67;
            case 63: goto L66;
            case 64: goto L64;
            case 65: goto L60;
            case 66: goto L58;
            case 67: goto L57;
            case 68: goto L56;
            case 69: goto L55;
            case 70: goto L54;
            case 71: goto L53;
            case 72: goto L52;
            case 73: goto L51;
            case 74: goto L50;
            case 75: goto L48;
            case 76: goto L47;
            case 77: goto L46;
            case 78: goto L45;
            case 79: goto L44;
            case 80: goto L43;
            case 81: goto L42;
            case 82: goto L40;
            case 83: goto L39;
            case 84: goto L38;
            case 85: goto L37;
            case 86: goto L24;
            case 87: goto L23;
            case 88: goto L6;
            case 89: goto L6;
            case 90: goto L6;
            case 91: goto L6;
            case 92: goto L6;
            case 93: goto L22;
            case 94: goto L21;
            case 95: goto L20;
            case 96: goto L19;
            case 97: goto L18;
            case 98: goto L10;
            case 99: goto L8;
            default: goto L6;
        };
    L6:
        StringBuilder r5 = new StringBuilder();
        String r7 = "Unknown attribute 0x";
    L7:
        Log.w("ConstraintSet", r5.append(r7).append(Integer.toHexString(r4)).append("   ").append(j.get(r4)).toString());
    L124:
        r2 = r2 + 1;
        goto L3
    L8:
        int r8 = 99;
        boolean r9 = r13.e.i;
    L49:
        r1.a(r8, r14.getBoolean(r4, r9));
        goto L124
    L18:
        int r10 = 97;
        int r11 = r13.e.aq;
    L97:
        int r12 = r14.getInt(r4, r11);
    L123:
        r1.a(r10, r12);
        goto L124
    L19:
        a(r1, r14, r4, 1);
        goto L124
    L20:
        a(r1, r14, r4, 0);
        goto L124
    L21:
        r10 = 94;
        int r15 = r13.e.U;
    L122:
        r12 = r14.getDimensionPixelSize(r4, r15);
        goto L123
    L22:
        r10 = 93;
        r15 = r13.e.N;
        goto L122
    L23:
        r5 = new StringBuilder();
        r7 = "unused attribute 0x";
        goto L7
    L24:
        TypedValue r16 = r14.peekValue(r4);
        if (r16.type != 1) goto L30;
        r13.d.n = r14.getResourceId(r4, -1);
        r1.a(89, r13.d.n);
        if (r13.d.n == (-1)) goto L124;
    L28:
        r13.d.m = -2;
    L36:
        r1.a(88, r13.d.m);
        goto L124
    L30:
        if (r16.type != 3) goto L35;
        r13.d.l = r14.getString(r4);
        r1.a(90, r13.d.l);
        if (r13.d.l.indexOf("/") <= 0) goto L34;
        r13.d.n = r14.getResourceId(r4, -1);
        r1.a(89, r13.d.n);
        goto L28
    L34:
        r13.d.m = -1;
        goto L36
    L35:
        r13.d.m = r14.getInteger(r4, r13.d.n);
        goto L36
    L37:
        int r17 = 85;
        r6 = r13.d.j;
    L105:
        float r18 = r14.getFloat(r4, r6);
    L106:
        r1.a(r17, r18);
        goto L124
    L38:
        r10 = 84;
        int r19 = r13.d.k;
    L41:
        r12 = r14.getInteger(r4, r19);
        goto L123
    L39:
        r10 = 83;
        int r20 = r13.f.i;
    L65:
        r12 = b(r14, r4, r20);
        goto L123
    L40:
        r10 = 82;
        r19 = r13.d.c;
        goto L41
    L42:
        r8 = 81;
        r9 = r13.e.ao;
        goto L49
    L43:
        r8 = 80;
        r9 = r13.e.an;
        goto L49
    L44:
        r17 = 79;
        r6 = r13.d.g;
        goto L105
    L45:
        r10 = 78;
        r11 = r13.c.c;
        goto L97
    L46:
        int r21 = 77;
    L120:
        r1.a(r21, r14.getString(r4));
        goto L124
    L47:
        r10 = 76;
        r11 = r13.d.e;
        goto L97
    L48:
        r8 = 75;
        r9 = r13.e.ap;
        goto L49
    L50:
        r21 = 74;
        goto L120
    L51:
        r10 = 73;
        r15 = r13.e.ai;
        goto L122
    L52:
        r10 = 72;
        r11 = r13.e.ah;
        goto L97
    L53:
        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
        goto L124
    L54:
        r17 = 70;
        goto L105
    L55:
        r17 = 69;
        goto L105
    L56:
        r17 = 68;
        r6 = r13.c.e;
        goto L105
    L57:
        r17 = 67;
        r6 = r13.d.i;
        goto L105
    L58:
        r10 = 66;
        r12 = r14.getInt(r4, 0);
        goto L123
    L64:
        r10 = 64;
        r20 = r13.d.f13776b;
        goto L65
    L66:
        r17 = 63;
        r6 = r13.e.D;
        goto L105
    L67:
        r10 = 62;
        r15 = r13.e.C;
        goto L122
    L68:
        r17 = 60;
        r6 = r13.f.f13780b;
        goto L105
    L69:
        r10 = 59;
        r15 = r13.e.ae;
        goto L122
    L70:
        r10 = 58;
        r15 = r13.e.ad;
        goto L122
    L71:
        r10 = 57;
        r15 = r13.e.ac;
        goto L122
    L72:
        r10 = 56;
        r15 = r13.e.ab;
        goto L122
    L73:
        r10 = 55;
        r11 = r13.e.aa;
        goto L97
    L74:
        r10 = 54;
        r11 = r13.e.Z;
        goto L97
    L75:
        r17 = 53;
        float r22 = r13.f.l;
    L85:
        r18 = r14.getDimension(r4, r22);
        goto L106
    L76:
        r17 = 52;
        r22 = r13.f.k;
        goto L85
    L77:
        r17 = 51;
        r22 = r13.f.j;
        goto L85
    L78:
        r17 = 50;
        r22 = r13.f.h;
        goto L85
    L79:
        r17 = 49;
        r22 = r13.f.g;
        goto L85
    L80:
        r17 = 48;
        r6 = r13.f.f;
        goto L105
    L81:
        r17 = 47;
        r6 = r13.f.e;
        goto L105
    L82:
        r17 = 46;
        r6 = r13.f.d;
        goto L105
    L83:
        r17 = 45;
        r6 = r13.f.c;
        goto L105
    L84:
        r17 = 44;
        r1.a(44, true);
        r22 = r13.f.n;
        goto L85
    L86:
        r17 = 43;
        r6 = r13.c.d;
        goto L105
    L87:
        r10 = 42;
        r11 = r13.e.Y;
        goto L97
    L88:
        r10 = 41;
        r11 = r13.e.X;
        goto L97
    L89:
        r17 = 40;
        r6 = r13.e.V;
        goto L105
    L90:
        r17 = 39;
        r6 = r13.e.W;
        goto L105
    L91:
        r13.f13768a = r14.getResourceId(r4, r13.f13768a);
        r1.a(38, r13.f13768a);
        goto L124
    L92:
        r17 = 37;
        r6 = r13.e.z;
        goto L105
    L93:
        r10 = 34;
        r15 = r13.e.f13772J;
        goto L122
    L94:
        r10 = 31;
        r15 = r13.e.M;
        goto L122
    L95:
        r10 = 28;
        r15 = r13.e.I;
        goto L122
    L96:
        r10 = 27;
        r11 = r13.e.G;
        goto L97
    L98:
        r10 = 24;
        r15 = r13.e.H;
        goto L122
    L99:
        r10 = 23;
        int r23 = r13.e.d;
    L102:
        r12 = r14.getLayoutDimension(r4, r23);
        goto L123
    L100:
        r10 = 22;
        r12 = h[r14.getInt(r4, r13.c.f13778b)];
        goto L123
    L101:
        r10 = 21;
        r23 = r13.e.e;
        goto L102
    L103:
        r17 = 20;
        r6 = r13.e.y;
        goto L105
    L104:
        r17 = 19;
        r6 = r13.e.h;
        goto L105
    L107:
        r10 = 18;
        int r24 = r13.e.g;
    L118:
        r12 = r14.getDimensionPixelOffset(r4, r24);
        goto L123
    L108:
        r10 = 17;
        r24 = r13.e.f;
        goto L118
    L109:
        r10 = 16;
        r15 = r13.e.P;
        goto L122
    L110:
        r10 = 15;
        r15 = r13.e.T;
        goto L122
    L111:
        r10 = 14;
        r15 = r13.e.Q;
        goto L122
    L112:
        r10 = 13;
        r15 = r13.e.O;
        goto L122
    L113:
        r10 = 12;
        r15 = r13.e.S;
        goto L122
    L114:
        r10 = 11;
        r15 = r13.e.R;
        goto L122
    L115:
        r10 = 8;
        r15 = r13.e.L;
        goto L122
    L116:
        r10 = 7;
        r24 = r13.e.F;
        goto L118
    L117:
        r10 = 6;
        r24 = r13.e.E;
        goto L118
    L119:
        r21 = 5;
        goto L120
    L121:
        r10 = 2;
        r15 = r13.e.K;
        goto L122
    L10:
        if (MotionLayout.IS_IN_EDIT_MODE == false) goto L15;
        r13.f13768a = r14.getResourceId(r4, r13.f13768a);
        if (r13.f13768a != (-1)) goto L124;
    L16:
        r13.f13769b = r14.getString(r4);
        goto L124
    L15:
        if (r14.peekValue(r4).type == 3) goto L16;
        r13.f13768a = r14.getResourceId(r4, r13.f13768a);
        goto L124
    L60:
        if (r14.peekValue(r4).type != 3) goto L62;
        String r25 = r14.getString(r4);
    L63:
        r1.a(65, r25);
        goto L124
    L62:
        r25 = com.obric.oui.constraintlayout.core.motion.a.c.c[r14.getInteger(r4, 0)];
        goto L63
    }

    private void a(a r9, TypedArray r10, boolean r11) {
        if (r11 == false) goto L5;
        a(r9, r10);
        return;
    L5:
        int r8 = r10.getIndexCount();
        int r0 = 0;
    L6:
        if (r0 >= r8) goto L129;
        int r1 = r10.getIndex(r0);
        if (r1 == ZeusTransformUtils.mapRes(R.styleable.Constraint_android_id, "styleable", "Constraint_android_id")) goto L15;
        if (ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginStart, "styleable", "Constraint_android_layout_marginStart") == r1) goto L15;
        if (ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginEnd, "styleable", "Constraint_android_layout_marginEnd") == r1) goto L15;
        r9.d.f13775a = true;
        r9.e.f13774b = true;
        r9.c.f13777a = true;
        r9.f.f13779a = true;
    L15:
        switch(j.get(r1)) {
            case 1: goto L126;
            case 2: goto L125;
            case 3: goto L124;
            case 4: goto L123;
            case 5: goto L122;
            case 6: goto L121;
            case 7: goto L120;
            case 8: goto L119;
            case 9: goto L118;
            case 10: goto L117;
            case 11: goto L116;
            case 12: goto L115;
            case 13: goto L114;
            case 14: goto L113;
            case 15: goto L112;
            case 16: goto L111;
            case 17: goto L110;
            case 18: goto L109;
            case 19: goto L108;
            case 20: goto L107;
            case 21: goto L106;
            case 22: goto L105;
            case 23: goto L104;
            case 24: goto L103;
            case 25: goto L102;
            case 26: goto L101;
            case 27: goto L100;
            case 28: goto L99;
            case 29: goto L98;
            case 30: goto L97;
            case 31: goto L96;
            case 32: goto L95;
            case 33: goto L94;
            case 34: goto L93;
            case 35: goto L92;
            case 36: goto L91;
            case 37: goto L90;
            case 38: goto L89;
            case 39: goto L88;
            case 40: goto L87;
            case 41: goto L86;
            case 42: goto L85;
            case 43: goto L84;
            case 44: goto L83;
            case 45: goto L82;
            case 46: goto L81;
            case 47: goto L80;
            case 48: goto L79;
            case 49: goto L78;
            case 50: goto L77;
            case 51: goto L76;
            case 52: goto L75;
            case 53: goto L74;
            case 54: goto L73;
            case 55: goto L72;
            case 56: goto L71;
            case 57: goto L70;
            case 58: goto L69;
            case 59: goto L68;
            case 60: goto L67;
            case 61: goto L66;
            case 62: goto L65;
            case 63: goto L64;
            case 64: goto L63;
            case 65: goto L59;
            case 66: goto L57;
            case 67: goto L56;
            case 68: goto L55;
            case 69: goto L54;
            case 70: goto L53;
            case 71: goto L52;
            case 72: goto L51;
            case 73: goto L50;
            case 74: goto L49;
            case 75: goto L48;
            case 76: goto L47;
            case 77: goto L46;
            case 78: goto L45;
            case 79: goto L44;
            case 80: goto L43;
            case 81: goto L42;
            case 82: goto L41;
            case 83: goto L40;
            case 84: goto L39;
            case 85: goto L38;
            case 86: goto L26;
            case 87: goto L24;
            case 88: goto L16;
            case 89: goto L16;
            case 90: goto L16;
            case 91: goto L23;
            case 92: goto L22;
            case 93: goto L21;
            case 94: goto L20;
            case 95: goto L19;
            case 96: goto L18;
            case 97: goto L17;
            default: goto L16;
        };
    L16:
        StringBuilder r2 = new StringBuilder();
        String r4 = "Unknown attribute 0x";
    L25:
        Log.w("ConstraintSet", r2.append(r4).append(Integer.toHexString(r1)).append("   ").append(j.get(r1)).toString());
    L127:
        r0 = r0 + 1;
        goto L6
    L17:
        r9.e.aq = r10.getInt(r1, r9.e.aq);
        goto L127
    L18:
        a(r9.e, r10, r1, 1);
        goto L127
    L19:
        a(r9.e, r10, r1, 0);
        goto L127
    L20:
        r9.e.U = r10.getDimensionPixelSize(r1, r9.e.U);
        goto L127
    L21:
        r9.e.N = r10.getDimensionPixelSize(r1, r9.e.N);
        goto L127
    L22:
        r9.e.t = b(r10, r1, r9.e.t);
        goto L127
    L23:
        r9.e.s = b(r10, r1, r9.e.s);
        goto L127
    L24:
        r2 = new StringBuilder();
        r4 = "unused attribute 0x";
        goto L25
    L26:
        TypedValue r3 = r10.peekValue(r1);
        if (r3.type != 1) goto L32;
        r9.d.n = r10.getResourceId(r1, -1);
        if (r9.d.n == (-1)) goto L127;
    L30:
        r9.d.m = -2;
        goto L127
    L32:
        if (r3.type != 3) goto L37;
        r9.d.l = r10.getString(r1);
        if (r9.d.l.indexOf("/") <= 0) goto L36;
        r9.d.n = r10.getResourceId(r1, -1);
        goto L30
    L36:
        r9.d.m = -1;
        goto L127
    L37:
        r9.d.m = r10.getInteger(r1, r9.d.n);
        goto L127
    L38:
        r9.d.j = r10.getFloat(r1, r9.d.j);
        goto L127
    L39:
        r9.d.k = r10.getInteger(r1, r9.d.k);
        goto L127
    L40:
        r9.f.i = b(r10, r1, r9.f.i);
        goto L127
    L41:
        r9.d.c = r10.getInteger(r1, r9.d.c);
        goto L127
    L42:
        r9.e.ao = r10.getBoolean(r1, r9.e.ao);
        goto L127
    L43:
        r9.e.an = r10.getBoolean(r1, r9.e.an);
        goto L127
    L44:
        r9.d.g = r10.getFloat(r1, r9.d.g);
        goto L127
    L45:
        r9.c.c = r10.getInt(r1, r9.c.c);
        goto L127
    L46:
        r9.e.am = r10.getString(r1);
        goto L127
    L47:
        r9.d.e = r10.getInt(r1, r9.d.e);
        goto L127
    L48:
        r9.e.ap = r10.getBoolean(r1, r9.e.ap);
        goto L127
    L49:
        r9.e.al = r10.getString(r1);
        goto L127
    L50:
        r9.e.ai = r10.getDimensionPixelSize(r1, r9.e.ai);
        goto L127
    L51:
        r9.e.ah = r10.getInt(r1, r9.e.ah);
        goto L127
    L52:
        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
        goto L127
    L53:
        r9.e.ag = r10.getFloat(r1, 1.0f);
        goto L127
    L54:
        r9.e.af = r10.getFloat(r1, 1.0f);
        goto L127
    L55:
        r9.c.e = r10.getFloat(r1, r9.c.e);
        goto L127
    L56:
        r9.d.i = r10.getFloat(r1, r9.d.i);
        goto L127
    L57:
        r9.d.f = r10.getInt(r1, 0);
        goto L127
    L63:
        r9.d.f13776b = b(r10, r1, r9.d.f13776b);
        goto L127
    L64:
        r9.e.D = r10.getFloat(r1, r9.e.D);
        goto L127
    L65:
        r9.e.C = r10.getDimensionPixelSize(r1, r9.e.C);
        goto L127
    L66:
        r9.e.B = b(r10, r1, r9.e.B);
        goto L127
    L67:
        r9.f.f13780b = r10.getFloat(r1, r9.f.f13780b);
        goto L127
    L68:
        r9.e.ae = r10.getDimensionPixelSize(r1, r9.e.ae);
        goto L127
    L69:
        r9.e.ad = r10.getDimensionPixelSize(r1, r9.e.ad);
        goto L127
    L70:
        r9.e.ac = r10.getDimensionPixelSize(r1, r9.e.ac);
        goto L127
    L71:
        r9.e.ab = r10.getDimensionPixelSize(r1, r9.e.ab);
        goto L127
    L72:
        r9.e.aa = r10.getInt(r1, r9.e.aa);
        goto L127
    L73:
        r9.e.Z = r10.getInt(r1, r9.e.Z);
        goto L127
    L74:
        r9.f.l = r10.getDimension(r1, r9.f.l);
        goto L127
    L75:
        r9.f.k = r10.getDimension(r1, r9.f.k);
        goto L127
    L76:
        r9.f.j = r10.getDimension(r1, r9.f.j);
        goto L127
    L77:
        r9.f.h = r10.getDimension(r1, r9.f.h);
        goto L127
    L78:
        r9.f.g = r10.getDimension(r1, r9.f.g);
        goto L127
    L79:
        r9.f.f = r10.getFloat(r1, r9.f.f);
        goto L127
    L80:
        r9.f.e = r10.getFloat(r1, r9.f.e);
        goto L127
    L81:
        r9.f.d = r10.getFloat(r1, r9.f.d);
        goto L127
    L82:
        r9.f.c = r10.getFloat(r1, r9.f.c);
        goto L127
    L83:
        r9.f.m = true;
        r9.f.n = r10.getDimension(r1, r9.f.n);
        goto L127
    L84:
        r9.c.d = r10.getFloat(r1, r9.c.d);
        goto L127
    L85:
        r9.e.Y = r10.getInt(r1, r9.e.Y);
        goto L127
    L86:
        r9.e.X = r10.getInt(r1, r9.e.X);
        goto L127
    L87:
        r9.e.V = r10.getFloat(r1, r9.e.V);
        goto L127
    L88:
        r9.e.W = r10.getFloat(r1, r9.e.W);
        goto L127
    L89:
        r9.f13768a = r10.getResourceId(r1, r9.f13768a);
        goto L127
    L90:
        r9.e.z = r10.getFloat(r1, r9.e.z);
        goto L127
    L91:
        r9.e.n = b(r10, r1, r9.e.n);
        goto L127
    L92:
        r9.e.o = b(r10, r1, r9.e.o);
        goto L127
    L93:
        r9.e.f13772J = r10.getDimensionPixelSize(r1, r9.e.f13772J);
        goto L127
    L94:
        r9.e.v = b(r10, r1, r9.e.v);
        goto L127
    L95:
        r9.e.u = b(r10, r1, r9.e.u);
        goto L127
    L96:
        r9.e.M = r10.getDimensionPixelSize(r1, r9.e.M);
        goto L127
    L97:
        r9.e.m = b(r10, r1, r9.e.m);
        goto L127
    L98:
        r9.e.l = b(r10, r1, r9.e.l);
        goto L127
    L99:
        r9.e.I = r10.getDimensionPixelSize(r1, r9.e.I);
        goto L127
    L100:
        r9.e.G = r10.getInt(r1, r9.e.G);
        goto L127
    L101:
        r9.e.k = b(r10, r1, r9.e.k);
        goto L127
    L102:
        r9.e.j = b(r10, r1, r9.e.j);
        goto L127
    L103:
        r9.e.H = r10.getDimensionPixelSize(r1, r9.e.H);
        goto L127
    L104:
        r9.e.d = r10.getLayoutDimension(r1, r9.e.d);
        goto L127
    L105:
        r9.c.f13778b = r10.getInt(r1, r9.c.f13778b);
        r9.c.f13778b = h[r9.c.f13778b];
        goto L127
    L106:
        r9.e.e = r10.getLayoutDimension(r1, r9.e.e);
        goto L127
    L107:
        r9.e.y = r10.getFloat(r1, r9.e.y);
        goto L127
    L108:
        r9.e.h = r10.getFloat(r1, r9.e.h);
        goto L127
    L109:
        r9.e.g = r10.getDimensionPixelOffset(r1, r9.e.g);
        goto L127
    L110:
        r9.e.f = r10.getDimensionPixelOffset(r1, r9.e.f);
        goto L127
    L111:
        r9.e.P = r10.getDimensionPixelSize(r1, r9.e.P);
        goto L127
    L112:
        r9.e.T = r10.getDimensionPixelSize(r1, r9.e.T);
        goto L127
    L113:
        r9.e.Q = r10.getDimensionPixelSize(r1, r9.e.Q);
        goto L127
    L114:
        r9.e.O = r10.getDimensionPixelSize(r1, r9.e.O);
        goto L127
    L115:
        r9.e.S = r10.getDimensionPixelSize(r1, r9.e.S);
        goto L127
    L116:
        r9.e.R = r10.getDimensionPixelSize(r1, r9.e.R);
        goto L127
    L117:
        r9.e.w = b(r10, r1, r9.e.w);
        goto L127
    L118:
        r9.e.x = b(r10, r1, r9.e.x);
        goto L127
    L119:
        r9.e.L = r10.getDimensionPixelSize(r1, r9.e.L);
        goto L127
    L120:
        r9.e.F = r10.getDimensionPixelOffset(r1, r9.e.F);
        goto L127
    L121:
        r9.e.E = r10.getDimensionPixelOffset(r1, r9.e.E);
        goto L127
    L122:
        r9.e.A = r10.getString(r1);
        goto L127
    L123:
        r9.e.p = b(r10, r1, r9.e.p);
        goto L127
    L124:
        r9.e.q = b(r10, r1, r9.e.q);
        goto L127
    L125:
        r9.e.K = r10.getDimensionPixelSize(r1, r9.e.K);
        goto L127
    L126:
        r9.e.r = b(r10, r1, r9.e.r);
        goto L127
    L59:
        if (r10.peekValue(r1).type != 3) goto L61;
        c r5 = r9.d;
        String r6 = r10.getString(r1);
    L62:
        r5.d = r6;
        goto L127
    L61:
        r5 = r9.d;
        r6 = com.obric.oui.constraintlayout.core.motion.a.c.c[r10.getInteger(r1, 0)];
        goto L62
    L129:
        if (r9.e.al == null) goto L230;
        r9.e.ak = null;
        return;
    }

    static void a(Object r4, TypedArray r5, int r6, int r7) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = r5.peekValue(r6).type;
        if (r0 == 3) goto L39;
        int r2 = -2;
        boolean r3 = false;
        if (r0 == 5) goto L18;
        int r8 = r5.getInt(r6, 0);
        if (r8 != (-4)) goto L11;
        r3 = true;
    L20:
        if (ZeusTransformUtils.instanceOf(r4, ConstraintLayout.LayoutParams.class) == false) goto L26;
        ConstraintLayout.LayoutParams r9 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        if (r7 != 0) goto L24;
        r9.width = r2;
        r9.aa = r3;
        return;
    L24:
        r9.height = r2;
        r9.ab = r3;
        return;
    L26:
        if (ZeusTransformUtils.instanceOf(r4, C0744b.class) == false) goto L32;
        C0744b r10 = (C0744b) ZeusTransformUtils.preCheckCast(r4, C0744b.class, "com.obric.memorydata.plugin");
        if (r7 != 0) goto L30;
        r10.d = r2;
        r10.an = r3;
        return;
    L30:
        r10.e = r2;
        r10.ao = r3;
        return;
    L32:
        if (ZeusTransformUtils.instanceOf(r4, a.C0743a.class) == false) goto L45;
        a.C0743a r11 = (a.C0743a) ZeusTransformUtils.preCheckCast(r4, a.C0743a.class, "com.obric.memorydata.plugin");
        if (r7 != 0) goto L36;
        r11.a(23, r2);
        int r12 = 80;
    L37:
        r11.a(r12, r3);
        return;
    L36:
        r11.a(21, r2);
        r12 = 81;
        goto L37
    L45:
        return;
    L11:
        if (r8 == (-3)) goto L15;
        if (r8 != (-2)) goto L14;
    L16:
        r2 = r8;
        goto L20
    L14:
        if (r8 == (-1)) goto L16;
    L15:
        r2 = 0;
        goto L20
    L18:
        r2 = r5.getDimensionPixelSize(r6, 0);
        goto L20
    L39:
        a(r4, r5.getString(r6), r7);
    }

    static void a(Object r6, String r7, int r8) {
        if (r7 != null) goto L4;
        return;
    L4:
        int r0 = r7.indexOf(61);
        int r1 = r7.length();
        if (r0 > 0) goto L7;
        return;
    L7:
        if (r0 >= (r1 - 1)) goto L73;
        String r2 = r7.substring(0, r0);
        String r9 = r7.substring(r0 + 1);
        if (r9.length() <= 0) goto L74;
        String r3 = r2.trim();
        String r10 = r9.trim();
        if ("ratio".equalsIgnoreCase(r3) == false) goto L72;
        if (ZeusTransformUtils.instanceOf(r6, ConstraintLayout.LayoutParams.class) == false) goto L20;
        ConstraintLayout.LayoutParams r11 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        if (r8 != 0) goto L17;
        r11.width = 0;
    L18:
        a(r11, r10);
        return;
    L17:
        r11.height = 0;
        goto L18
    L20:
        if (ZeusTransformUtils.instanceOf(r6, C0744b.class) == false) goto L23;
        ((C0744b) ZeusTransformUtils.preCheckCast(r6, C0744b.class, "com.obric.memorydata.plugin")).A = r10;
        return;
    L23:
        if (ZeusTransformUtils.instanceOf(r6, a.C0743a.class) == false) goto L77;
        ((a.C0743a) ZeusTransformUtils.preCheckCast(r6, a.C0743a.class, "com.obric.memorydata.plugin")).a(5, r10);
        return;
    L77:
        return;
    L72:
        if ("weight".equalsIgnoreCase(r3) == false) goto L48;
        float r12 = Float.parseFloat(r10);     // Catch: NumberFormatException -> L71
        if (ZeusTransformUtils.instanceOf(r6, ConstraintLayout.LayoutParams.class) == false) goto L34;
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");     // Catch: NumberFormatException -> L71
        if (r8 != 0) goto L32;
        r13.width = 0;     // Catch: NumberFormatException -> L71
        r13.L = r12;     // Catch: NumberFormatException -> L71
        return;
    L32:
        r13.height = 0;     // Catch: NumberFormatException -> L71
        r13.M = r12;     // Catch: NumberFormatException -> L71
        return;
    L34:
        if (ZeusTransformUtils.instanceOf(r6, C0744b.class) == false) goto L40;
        C0744b r14 = (C0744b) ZeusTransformUtils.preCheckCast(r6, C0744b.class, "com.obric.memorydata.plugin");     // Catch: NumberFormatException -> L71
        if (r8 != 0) goto L38;
        r14.d = 0;     // Catch: NumberFormatException -> L71
        r14.W = r12;     // Catch: NumberFormatException -> L71
        return;
    L38:
        r14.e = 0;     // Catch: NumberFormatException -> L71
        r14.V = r12;     // Catch: NumberFormatException -> L71
        return;
    L40:
        if (ZeusTransformUtils.instanceOf(r6, a.C0743a.class) == false) goto L83;
        a.C0743a r15 = (a.C0743a) ZeusTransformUtils.preCheckCast(r6, a.C0743a.class, "com.obric.memorydata.plugin");     // Catch: NumberFormatException -> L71
        if (r8 != 0) goto L45;
        r15.a(23, 0);     // Catch: NumberFormatException -> L71
        int r16 = 39;
    L44:
        r15.a(r16, r12);     // Catch: NumberFormatException -> L71
        return;
    L45:
        r15.a(21, 0);     // Catch: NumberFormatException -> L71
        r16 = 40;
        goto L44
    L83:
        return;
    L48:
        if ("parent".equalsIgnoreCase(r3) == true) goto L50;
        return;
    L50:
        float r17 = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(r10)));     // Catch: NumberFormatException -> L71
        if (ZeusTransformUtils.instanceOf(r6, ConstraintLayout.LayoutParams.class) == false) goto L57;
        ConstraintLayout.LayoutParams r18 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");     // Catch: NumberFormatException -> L71
        if (r8 != 0) goto L55;
        r18.width = 0;     // Catch: NumberFormatException -> L71
        r18.V = r17;     // Catch: NumberFormatException -> L71
        r18.P = 2;     // Catch: NumberFormatException -> L71
        return;
    L55:
        r18.height = 0;     // Catch: NumberFormatException -> L71
        r18.W = r17;     // Catch: NumberFormatException -> L71
        r18.Q = 2;     // Catch: NumberFormatException -> L71
        return;
    L57:
        if (ZeusTransformUtils.instanceOf(r6, C0744b.class) == false) goto L63;
        C0744b r19 = (C0744b) ZeusTransformUtils.preCheckCast(r6, C0744b.class, "com.obric.memorydata.plugin");     // Catch: NumberFormatException -> L71
        if (r8 != 0) goto L61;
        r19.d = 0;     // Catch: NumberFormatException -> L71
        r19.af = r17;     // Catch: NumberFormatException -> L71
        r19.Z = 2;     // Catch: NumberFormatException -> L71
        return;
    L61:
        r19.e = 0;     // Catch: NumberFormatException -> L71
        r19.ag = r17;     // Catch: NumberFormatException -> L71
        r19.aa = 2;     // Catch: NumberFormatException -> L71
        return;
    L63:
        if (ZeusTransformUtils.instanceOf(r6, a.C0743a.class) == false) goto L90;
        a.C0743a r20 = (a.C0743a) ZeusTransformUtils.preCheckCast(r6, a.C0743a.class, "com.obric.memorydata.plugin");     // Catch: NumberFormatException -> L71
        if (r8 != 0) goto L68;
        r20.a(23, 0);     // Catch: NumberFormatException -> L71
        int r21 = 54;
    L67:
        r20.a(r21, 2);     // Catch: NumberFormatException -> L71
        return;
    L68:
        r20.a(21, 0);     // Catch: NumberFormatException -> L71
        r21 = 55;
        goto L67
    L90:
        return;
    L92:
        return;
    L74:
        return;
    }

    private int[] a(View r10, String r11) {
        String[] r9 = r11.split(",");
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        int[] r1 = new int[r9.length];
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r3 >= r9.length) goto L23;
        String r5 = r9[r3].trim();
        int r6 = R.id.class.getField(r5).getInt(null);     // Catch: Exception -> L8
    L9:
        if (r6 != 0) goto L11;
        r6 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin"), r5, OaidModel.KEY_ID, r12.getPackageName(), "com.obric.memorydata.plugin");
    L11:
        if (r6 != 0) goto L21;
        if (r10.isInEditMode() == false) goto L21;
        if (ZeusTransformUtils.instanceOf(r10.getParent(), ConstraintLayout.class) == false) goto L21;
        Object r7 = ((ConstraintLayout) ZeusTransformUtils.preCheckCast(r10.getParent(), ConstraintLayout.class, "com.obric.memorydata.plugin")).getDesignInformation(0, r5);
        if (r7 == null) goto L21;
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L21;
        r6 = ((Integer) ZeusTransformUtils.preCheckCast(r7, Integer.class, "com.obric.memorydata.plugin")).intValue();
    L21:
        r1[r4] = r6;
        r3 = r3 + 1;
        r4 = r4 + 1;
    L8:
        r6 = 0;
        goto L9
    L23:
        if (r4 != r9.length) goto L25;
        return r1;
    L25:
        return Arrays.copyOf(r1, r4);
    }

    private static int b(TypedArray r1, int r2, int r3) {
        int r4 = r1.getResourceId(r2, r3);
        if (r4 == (-1)) goto L5;
        return r4;
    L5:
        return r1.getInt(r2, -1);
    }

    public static a b(Context r2, XmlPullParser r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r5 = Xml.asAttributeSet((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin"));
        a r0 = new a();
        TypedArray r6 = r4.obtainStyledAttributes(r5, R.styleable.ConstraintOverride);
        a(r0, r6);
        r6.recycle();
        return r0;
    }

    private static void b(a r1, int r2, float r3) {
        if (r2 != 19) goto L5;
        r1.e.h = r3;
        return;
    L5:
        if (r2 != 20) goto L7;
        r1.e.y = r3;
        return;
    L7:
        if (r2 != 37) goto L9;
        r1.e.z = r3;
        return;
    L9:
        if (r2 != 60) goto L11;
        r1.f.f13780b = r3;
        return;
    L11:
        if (r2 != 63) goto L13;
        r1.e.D = r3;
        return;
    L13:
        if (r2 != 79) goto L15;
        r1.d.g = r3;
        return;
    L15:
        if (r2 != 85) goto L17;
        r1.d.j = r3;
        return;
    L17:
        if (r2 != 87) goto L19;
        return;
    L19:
        if (r2 != 39) goto L21;
        r1.e.W = r3;
        return;
    L21:
        if (r2 == 40) goto L40;
        switch(r2) {
            case 43: goto L39;
            case 44: goto L38;
            case 45: goto L37;
            case 46: goto L36;
            case 47: goto L35;
            case 48: goto L34;
            case 49: goto L33;
            case 50: goto L32;
            case 51: goto L31;
            case 52: goto L30;
            case 53: goto L29;
            default: goto L23;
        };
    L23:
        switch(r2) {
            case 67: goto L28;
            case 68: goto L27;
            case 69: goto L26;
            case 70: goto L25;
            default: goto L24;
        };
    L24:
        Log.w("ConstraintSet", "Unknown attribute 0x");
        return;
    L25:
        r1.e.ag = r3;
        return;
    L26:
        r1.e.af = r3;
        return;
    L27:
        r1.c.e = r3;
        return;
    L28:
        r1.d.i = r3;
        return;
    L29:
        r1.f.l = r3;
        return;
    L30:
        r1.f.k = r3;
        return;
    L31:
        r1.f.j = r3;
        return;
    L32:
        r1.f.h = r3;
        return;
    L33:
        r1.f.g = r3;
        return;
    L34:
        r1.f.f = r3;
        return;
    L35:
        r1.f.e = r3;
        return;
    L36:
        r1.f.d = r3;
        return;
    L37:
        r1.f.c = r3;
        return;
    L38:
        r1.f.n = r3;
        r1.f.m = true;
        return;
    L39:
        r1.c.d = r3;
        return;
    L40:
        r1.e.V = r3;
    }

    private static void b(a r1, int r2, int r3) {
        if (r2 != 6) goto L5;
        r1.e.E = r3;
        return;
    L5:
        if (r2 != 7) goto L7;
        r1.e.F = r3;
        return;
    L7:
        if (r2 != 8) goto L9;
        r1.e.L = r3;
        return;
    L9:
        if (r2 != 27) goto L11;
        r1.e.G = r3;
        return;
    L11:
        if (r2 != 28) goto L13;
        r1.e.I = r3;
        return;
    L13:
        if (r2 != 41) goto L15;
        r1.e.X = r3;
        return;
    L15:
        if (r2 != 42) goto L17;
        r1.e.Y = r3;
        return;
    L17:
        if (r2 != 61) goto L19;
        r1.e.B = r3;
        return;
    L19:
        if (r2 != 62) goto L21;
        r1.e.C = r3;
        return;
    L21:
        if (r2 != 72) goto L23;
        r1.e.ah = r3;
        return;
    L23:
        if (r2 == 73) goto L64;
        switch(r2) {
            case 2: goto L63;
            case 11: goto L62;
            case 12: goto L61;
            case 13: goto L60;
            case 14: goto L59;
            case 15: goto L58;
            case 16: goto L57;
            case 17: goto L56;
            case 18: goto L55;
            case 31: goto L54;
            case 34: goto L53;
            case 38: goto L52;
            case 64: goto L51;
            case 66: goto L50;
            case 76: goto L49;
            case 78: goto L48;
            case 93: goto L47;
            case 94: goto L46;
            case 97: goto L45;
            default: goto L25;
        };
    L25:
        switch(r2) {
            case 21: goto L44;
            case 22: goto L43;
            case 23: goto L42;
            case 24: goto L41;
            default: goto L26;
        };
    L26:
        switch(r2) {
            case 54: goto L40;
            case 55: goto L39;
            case 56: goto L38;
            case 57: goto L37;
            case 58: goto L36;
            case 59: goto L35;
            default: goto L27;
        };
    L27:
        switch(r2) {
            case 82: goto L34;
            case 83: goto L33;
            case 84: goto L32;
            default: goto L28;
        };
    L28:
        switch(r2) {
            case 87: goto L76;
            case 88: goto L31;
            case 89: goto L30;
            default: goto L29;
        };
    L29:
        Log.w("ConstraintSet", "Unknown attribute 0x");
        return;
    L30:
        r1.d.n = r3;
        return;
    L31:
        r1.d.m = r3;
        return;
    L76:
        return;
    L32:
        r1.d.k = r3;
        return;
    L33:
        r1.f.i = r3;
        return;
    L34:
        r1.d.c = r3;
        return;
    L35:
        r1.e.ae = r3;
        return;
    L36:
        r1.e.ad = r3;
        return;
    L37:
        r1.e.ac = r3;
        return;
    L38:
        r1.e.ab = r3;
        return;
    L39:
        r1.e.aa = r3;
        return;
    L40:
        r1.e.Z = r3;
        return;
    L41:
        r1.e.H = r3;
        return;
    L42:
        r1.e.d = r3;
        return;
    L43:
        r1.c.f13778b = r3;
        return;
    L44:
        r1.e.e = r3;
        return;
    L45:
        r1.e.aq = r3;
        return;
    L46:
        r1.e.U = r3;
        return;
    L47:
        r1.e.N = r3;
        return;
    L48:
        r1.c.c = r3;
        return;
    L49:
        r1.d.e = r3;
        return;
    L50:
        r1.d.f = r3;
        return;
    L51:
        r1.d.f13776b = r3;
        return;
    L52:
        r1.f13768a = r3;
        return;
    L53:
        r1.e.f13772J = r3;
        return;
    L54:
        r1.e.M = r3;
        return;
    L55:
        r1.e.g = r3;
        return;
    L56:
        r1.e.f = r3;
        return;
    L57:
        r1.e.P = r3;
        return;
    L58:
        r1.e.T = r3;
        return;
    L59:
        r1.e.Q = r3;
        return;
    L60:
        r1.e.O = r3;
        return;
    L61:
        r1.e.S = r3;
        return;
    L62:
        r1.e.R = r3;
        return;
    L63:
        r1.e.K = r3;
        return;
    L64:
        r1.e.ai = r3;
    }

    private static void b(a r1, int r2, String r3) {
        if (r2 != 5) goto L5;
        r1.e.A = r3;
        return;
    L5:
        if (r2 != 65) goto L7;
        r1.d.d = r3;
        return;
    L7:
        if (r2 != 74) goto L9;
        r1.e.al = r3;
        r1.e.ak = null;
        return;
    L9:
        if (r2 != 77) goto L11;
        r1.e.am = r3;
        return;
    L11:
        if (r2 != 87) goto L13;
        return;
    L13:
        if (r2 == 90) goto L15;
        Log.w("ConstraintSet", "Unknown attribute 0x");
        return;
    L15:
        r1.d.l = r3;
    }

    private static void b(a r1, int r2, boolean r3) {
        if (r2 != 44) goto L5;
        r1.f.m = r3;
        return;
    L5:
        if (r2 != 75) goto L7;
        r1.e.ap = r3;
        return;
    L7:
        if (r2 != 87) goto L9;
        return;
    L9:
        if (r2 != 80) goto L11;
        r1.e.an = r3;
        return;
    L11:
        if (r2 == 81) goto L13;
        Log.w("ConstraintSet", "Unknown attribute 0x");
        return;
    L13:
        r1.e.ao = r3;
    }

    static /* synthetic */ int[] c() {
        return h;
    }

    private a g(int r4) {
        if (this.i.containsKey(Integer.valueOf(r4)) == true) goto L6;
        this.i.put(Integer.valueOf(r4), new a());
    L6:
        return (a) ZeusTransformUtils.preCheckCast(this.i.get(Integer.valueOf(r4)), a.class, "com.obric.memorydata.plugin");
    }

    public a a(int r1) {
        return g(r1);
    }

    public void a(int r3, ConstraintLayout.LayoutParams r4) {
        if (this.i.containsKey(Integer.valueOf(r3)) == false) goto L8;
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.i.get(Integer.valueOf(r3)), a.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        r2.a(r4);
        return;
    L9:
        return;
    }

    public void a(Context r3, int r4) {
        b((ConstraintLayout) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")), r4, null, "com.obric.memorydata.plugin"), ConstraintLayout.class, "com.obric.memorydata.plugin"));
    }

    public void a(Context r12, XmlPullParser r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        XmlPullParser r15 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r13, XmlPullParser.class, "com.obric.memorydata.plugin");
        int r2 = r15.getEventType();     // Catch: Throwable -> L97
        a r4 = null;
    L5:
        if (r2 == 1) goto L119;
        if (r2 == 0) goto L94;
        byte r6 = -1;
        if (r2 == 2) goto L33;
        if (r2 != 3) goto L95;
        String r3 = r15.getName().toLowerCase(Locale.ROOT);     // Catch: Throwable -> L97
        switch(r3.hashCode()) {
            case -2075718416: goto L24;
            case -190376483: goto L21;
            case 426575017: goto L18;
            case 2146106725: goto L15;
            default: goto L26;
        };     // Catch: Throwable -> L97
    L26:
        if (r6 == 0) goto L32;
        if (r6 == 1) goto L31;
        if (r6 == 2) goto L31;
        if (r6 != 3) goto L95;
    L31:
        this.i.put(Integer.valueOf(r4.f13768a), r4);     // Catch: Throwable -> L97
        r4 = null;
        goto L95
    L32:
        return;
    L15:
        if (r3.equals("constraintset") == false) goto L26;
        r6 = 0;
        goto L26
    L18:
        if (r3.equals("constraintoverride") == false) goto L26;
        r6 = 2;
        goto L26
    L21:
        if (r3.equals("constraint") == false) goto L26;
        r6 = 1;
        goto L26
    L24:
        if (r3.equals("guideline") == false) goto L26;
        r6 = 3;
    L95:
        r2 = r15.next();     // Catch: Throwable -> L97 Throwable -> L97
        goto L5
    L33:
        String r5 = r15.getName();     // Catch: Throwable -> L97
        switch(r5.hashCode()) {
            case -2025855158: goto L64;
            case -1984451626: goto L61;
            case -1962203927: goto L58;
            case -1269513683: goto L55;
            case -1238332596: goto L52;
            case -71750448: goto L49;
            case 366511058: goto L46;
            case 1331510167: goto L43;
            case 1791837707: goto L40;
            case 1803088381: goto L37;
            default: goto L67;
        };     // Catch: Throwable -> L97
    L67:
        switch(r6) {
            case 0: goto L92;
            case 1: goto L91;
            case 2: goto L90;
            case 3: goto L89;
            case 4: goto L85;
            case 5: goto L81;
            case 6: goto L77;
            case 7: goto L73;
            case 8: goto L69;
            case 9: goto L69;
            default: goto L95;
        };
    L69:
        if (r4 == null) goto L72;
        ConstraintAttribute.a(r14, r15, r4.g);     // Catch: Throwable -> L97 Throwable -> L97
        goto L95
    L72:
        throw new RuntimeException("XML parser error must be within a Constraint " + r15.getLineNumber());     // Catch: Throwable -> L97 Throwable -> L97
    L73:
        if (r4 == null) goto L76;
        r4.d.a(r14, Xml.asAttributeSet(r15));     // Catch: Throwable -> L97 Throwable -> L97
        goto L95
    L76:
        throw new RuntimeException("XML parser error must be within a Constraint " + r15.getLineNumber());     // Catch: Throwable -> L97 Throwable -> L97
    L77:
        if (r4 == null) goto L80;
        r4.e.a(r14, Xml.asAttributeSet(r15));     // Catch: Throwable -> L97 Throwable -> L97
        goto L95
    L80:
        throw new RuntimeException("XML parser error must be within a Constraint " + r15.getLineNumber());     // Catch: Throwable -> L97 Throwable -> L97
    L81:
        if (r4 == null) goto L84;
        r4.f.a(r14, Xml.asAttributeSet(r15));     // Catch: Throwable -> L97 Throwable -> L97
        goto L95
    L84:
        throw new RuntimeException("XML parser error must be within a Constraint " + r15.getLineNumber());     // Catch: Throwable -> L97 Throwable -> L97
    L85:
        if (r4 == null) goto L88;
        r4.c.a(r14, Xml.asAttributeSet(r15));     // Catch: Throwable -> L97 Throwable -> L97
        goto L95
    L88:
        throw new RuntimeException("XML parser error must be within a Constraint " + r15.getLineNumber());     // Catch: Throwable -> L97 Throwable -> L97
    L89:
        a r7 = a(r14, Xml.asAttributeSet(r15), false);     // Catch: Throwable -> L97 Throwable -> L97
        r7.e.aj = 1;     // Catch: Throwable -> L97 Throwable -> L97
    L93:
        r4 = r7;
        goto L95
    L90:
        r7 = a(r14, Xml.asAttributeSet(r15), false);     // Catch: Throwable -> L97 Throwable -> L97
        r7.e.f13773a = true;     // Catch: Throwable -> L97 Throwable -> L97
        r7.e.f13774b = true;     // Catch: Throwable -> L97 Throwable -> L97
        goto L93
    L91:
        r7 = a(r14, Xml.asAttributeSet(r15), true);     // Catch: Throwable -> L97 Throwable -> L97
        goto L93
    L92:
        r7 = a(r14, Xml.asAttributeSet(r15), false);     // Catch: Throwable -> L97 Throwable -> L97
        goto L93
    L37:
        if (r5.equals("Constraint") == false) goto L67;
        r6 = 0;
        goto L67
    L40:
        if (r5.equals(ViewTransition.CUSTOM_ATTRIBUTE) == false) goto L67;
        r6 = 8;
        goto L67
    L43:
        if (r5.equals("Barrier") == false) goto L67;
        r6 = 3;
        goto L67
    L46:
        if (r5.equals(ViewTransition.CUSTOM_METHOD) == false) goto L67;
        r6 = 9;
        goto L67
    L49:
        if (r5.equals("Guideline") == false) goto L67;
        r6 = 2;
        goto L67
    L52:
        if (r5.equals("Transform") == false) goto L67;
        r6 = 5;
        goto L67
    L55:
        if (r5.equals("PropertySet") == false) goto L67;
        r6 = 4;
        goto L67
    L58:
        if (r5.equals(ViewTransition.CONSTRAINT_OVERRIDE) == false) goto L67;
        r6 = 1;
        goto L67
    L61:
        if (r5.equals(TypedValues.MotionType.NAME) == false) goto L67;
        r6 = 7;
        goto L67
    L64:
        if (r5.equals(com.tom_roush.pdfbox.pdmodel.a.d.d.h) == false) goto L67;
        r6 = 6;
        goto L67
    L94:
        r15.getName();     // Catch: Throwable -> L97 Throwable -> L97
        goto L95
    L119:
        return;
    L97:
        e = move-exception;
        Log.e("ConstraintSet", "Error parsing XML resource", e);
    }

    public void a(ConstraintHelper r4, ConstraintWidget r5, ConstraintLayout.LayoutParams r6, SparseArray<ConstraintWidget> r7) {
        int r0 = r4.getId();
        if (this.i.containsKey(Integer.valueOf(r0)) == false) goto L10;
        a r3 = (a) ZeusTransformUtils.preCheckCast(this.i.get(Integer.valueOf(r0)), a.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == false) goto L12;
        r4.a(r3, (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.memorydata.plugin"), r6, r7);
        return;
    L12:
        return;
    }

    public void a(ConstraintLayout r12) {
        int r0 = r12.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L39;
        View r2 = r12.getChildAt(r1);
        ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        int r4 = r2.getId();
        if (this.g == false) goto L12;
        if (r4 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.i.containsKey(Integer.valueOf(r4)) == true) goto L14;
        this.i.put(Integer.valueOf(r4), new a());
    L14:
        a r6 = (a) ZeusTransformUtils.preCheckCast(this.i.get(Integer.valueOf(r4)), a.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L38;
        if (r6.e.f13774b == true) goto L26;
        a.a(r6, r4, r3);
        if (ZeusTransformUtils.instanceOf(r2, ConstraintHelper.class) == false) goto L24;
        r6.e.ak = ((ConstraintHelper) ZeusTransformUtils.preCheckCast(r2, ConstraintHelper.class, "com.obric.memorydata.plugin")).getReferencedIds();
        if (ZeusTransformUtils.instanceOf(r2, Barrier.class) == false) goto L24;
        Barrier r5 = (Barrier) ZeusTransformUtils.preCheckCast(r2, Barrier.class, "com.obric.memorydata.plugin");
        r6.e.ap = r5.getAllowsGoneWidget();
        r6.e.ah = r5.getType();
        r6.e.ai = r5.getMargin();
    L24:
        r6.e.f13774b = true;
    L26:
        if (r6.c.f13777a == true) goto L29;
        r6.c.f13778b = r2.getVisibility();
        r6.c.d = r2.getAlpha();
        r6.c.f13777a = true;
    L29:
        if (r6.f.f13779a == true) goto L38;
        r6.f.f13779a = true;
        r6.f.f13780b = r2.getRotation();
        r6.f.c = r2.getRotationX();
        r6.f.d = r2.getRotationY();
        r6.f.e = r2.getScaleX();
        r6.f.f = r2.getScaleY();
        float r7 = r2.getPivotX();
        float r8 = r2.getPivotY();
        if (r7 == 0.0d) goto L33;
    L34:
        r6.f.g = r7;
        r6.f.h = r8;
    L35:
        r6.f.j = r2.getTranslationX();
        r6.f.k = r2.getTranslationY();
        r6.f.l = r2.getTranslationZ();
        if (r6.f.m == false) goto L38;
        r6.f.n = r2.getElevation();
        goto L38
    L33:
        if (r8 == 0.0d) goto L35;
    L38:
        r1 = r1 + 1;
        goto L3
    }

    void a(ConstraintLayout r13, boolean r14) {
        int r0 = r13.getChildCount();
        HashSet r1 = new HashSet(this.i.keySet());
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= r0) goto L55;
        View r6 = r13.getChildAt(r3);
        int r7 = r6.getId();
        if (this.i.containsKey(Integer.valueOf(r7)) == true) goto L9;
        Log.w("ConstraintSet", "id unknown " + com.obric.oui.constraintlayout.motion.widget.a.a(r6));
    L54:
        r3 = r3 + 1;
        goto L4
    L9:
        if (this.g == false) goto L14;
        if (r7 != (-1)) goto L14;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L14:
        if (r7 == (-1)) goto L54;
        if (this.i.containsKey(Integer.valueOf(r7)) == false) goto L53;
        r1.remove(Integer.valueOf(r7));
        a r8 = (a) ZeusTransformUtils.preCheckCast(this.i.get(Integer.valueOf(r7)), a.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L54;
        if (ZeusTransformUtils.instanceOf(r6, Barrier.class) == false) goto L29;
        r8.e.aj = 1;
        Barrier r4 = (Barrier) ZeusTransformUtils.preCheckCast(r6, Barrier.class, "com.obric.memorydata.plugin");
        r4.setId(r7);
        r4.setType(r8.e.ah);
        r4.setMargin(r8.e.ai);
        r4.setAllowsGoneWidget(r8.e.ap);
        if (r8.e.ak == null) goto L27;
        r4.setReferencedIds(r8.e.ak);
        goto L29
    L27:
        if (r8.e.al == null) goto L29;
        r8.e.ak = a(r4, r8.e.al);
        r4.setReferencedIds(r8.e.ak);
    L29:
        ConstraintLayout.LayoutParams r5 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r5.b();
        r8.a(r5);
        if (r14 == false) goto L32;
        ConstraintAttribute.a(r6, r8.g);
    L32:
        r6.setLayoutParams(r5);
        if (r8.c.c != 0) goto L35;
        r6.setVisibility(r8.c.f13778b);
    L35:
        r6.setAlpha(r8.c.d);
        r6.setRotation(r8.f.f13780b);
        r6.setRotationX(r8.f.c);
        r6.setRotationY(r8.f.d);
        r6.setScaleX(r8.f.e);
        r6.setScaleY(r8.f.f);
        if (r8.f.i == (-1)) goto L45;
        View r9 = ((View) ZeusTransformUtils.preCheckCast(r6.getParent(), View.class, "com.obric.memorydata.plugin")).findViewById(r8.f.i);
        if (r9 == null) goto L50;
        float r10 = (r9.getTop() + r9.getBottom()) / 2.0f;
        float r11 = (r9.getLeft() + r9.getRight()) / 2.0f;
        if ((r6.getRight() - r6.getLeft()) <= 0) goto L50;
        if ((r6.getBottom() - r6.getTop()) <= 0) goto L50;
        float r12 = r11 - r6.getLeft();
        float r15 = r10 - r6.getTop();
        r6.setPivotX(r12);
        r6.setPivotY(r15);
    L50:
        r6.setTranslationX(r8.f.j);
        r6.setTranslationY(r8.f.k);
        r6.setTranslationZ(r8.f.l);
        if (r8.f.m == false) goto L54;
        r6.setElevation(r8.f.n);
        goto L54
    L45:
        if (Float.isNaN(r8.f.g) == true) goto L48;
        r6.setPivotX(r8.f.g);
    L48:
        if (Float.isNaN(r8.f.h) == true) goto L50;
        r6.setPivotY(r8.f.h);
        goto L50
    L53:
        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + r7);
        goto L54
    L55:
        Iterator r16 = r1.iterator();
    L57:
        if (r16.hasNext() == false) goto L73;
        Integer r17 = (Integer) ZeusTransformUtils.preCheckCast(r16.next(), Integer.class, "com.obric.memorydata.plugin");
        a r18 = (a) ZeusTransformUtils.preCheckCast(this.i.get(r17), a.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L57;
        if (r18.e.aj != 1) goto L71;
        Barrier r19 = new Barrier((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r19.setId(r17.intValue());
        if (r18.e.ak == null) goto L67;
        r19.setReferencedIds(r18.e.ak);
    L69:
        r19.setType(r18.e.ah);
        r19.setMargin(r18.e.ai);
        ConstraintLayout.LayoutParams r20 = r13.generateDefaultLayoutParams();
        r19.d();
        r18.a(r20);
        r13.addView(r19, r20);
        goto L71
    L67:
        if (r18.e.al == null) goto L69;
        r18.e.ak = a(r19, r18.e.al);
        r19.setReferencedIds(r18.e.ak);
    L71:
        if (r18.e.f13773a == false) goto L57;
        Guideline r21 = new Guideline((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r21.setId(r17.intValue());
        ConstraintLayout.LayoutParams r22 = r13.generateDefaultLayoutParams();
        r18.a(r22);
        r13.addView(r21, r22);
    L73:
        if (r2 >= r0) goto L78;
        View r110 = r13.getChildAt(r2);
        if (ZeusTransformUtils.instanceOf(r110, ConstraintHelper.class) == false) goto L77;
        ((ConstraintHelper) ZeusTransformUtils.preCheckCast(r110, ConstraintHelper.class, "com.obric.memorydata.plugin")).c(r13);
    L77:
        r2 = r2 + 1;
        goto L73
    }

    public void a(Constraints r10) {
        int r0 = r10.getChildCount();
        this.i.clear();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L22;
        View r2 = r10.getChildAt(r1);
        Constraints.LayoutParams r3 = (Constraints.LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), Constraints.LayoutParams.class, "com.obric.memorydata.plugin");
        int r4 = r2.getId();
        if (this.g == false) goto L12;
        if (r4 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.i.containsKey(Integer.valueOf(r4)) == true) goto L14;
        this.i.put(Integer.valueOf(r4), new a());
    L14:
        a r6 = (a) ZeusTransformUtils.preCheckCast(this.i.get(Integer.valueOf(r4)), a.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L21;
        if (ZeusTransformUtils.instanceOf(r2, ConstraintHelper.class) == false) goto L20;
        a.a(r6, (ConstraintHelper) ZeusTransformUtils.preCheckCast(r2, ConstraintHelper.class, "com.obric.memorydata.plugin"), r4, r3);
    L20:
        a.a(r6, r4, r3);
    L21:
        r1 = r1 + 1;
        goto L3
    }

    public void a(b r10) {
        Iterator<Integer> r0 = r10.i.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L29;
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(r0.next(), Integer.class, "com.obric.memorydata.plugin");
        int r2 = r1.intValue();
        a r3 = (a) ZeusTransformUtils.preCheckCast(r10.i.get(r1), a.class, "com.obric.memorydata.plugin");
        if (this.i.containsKey(Integer.valueOf(r2)) == true) goto L8;
        this.i.put(Integer.valueOf(r2), new a());
    L8:
        a r4 = (a) ZeusTransformUtils.preCheckCast(this.i.get(Integer.valueOf(r2)), a.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L4;
        if (r4.e.f13774b == true) goto L15;
        r4.e.a(r3.e);
    L15:
        if (r4.c.f13777a == true) goto L18;
        r4.c.a(r3.c);
    L18:
        if (r4.f.f13779a == true) goto L21;
        r4.f.a(r3.f);
    L21:
        if (r4.d.f13775a == true) goto L23;
        r4.d.a(r3.d);
    L23:
        Iterator<String> r5 = r3.g.keySet().iterator();
    L25:
        if (r5.hasNext() == false) goto L4;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");
        if (r4.g.containsKey(r6) == true) goto L25;
        r4.g.put(r6, (ConstraintAttribute) ZeusTransformUtils.preCheckCast(r3.g.get(r6), ConstraintAttribute.class, "com.obric.memorydata.plugin"));
        goto L25
    }

    public void a(String r3) {
        this.e = r3.split(",");
        int r4 = 0;
    L3:
        String[] r0 = this.e;
        if (r4 >= r0.length) goto L6;
        r0[r4] = r0[r4].trim();
        r4 = r4 + 1;
        goto L3
    }

    public void a(boolean r1) {
        this.g = r1;
    }

    public boolean a(String... r10) {
        int r0 = r10.length;
        int r2 = 0;
    L3:
        boolean r3 = true;
        if (r2 >= r0) goto L15;
        String r4 = r10[r2];
        String[] r5 = this.e;
        int r6 = r5.length;
        int r7 = 0;
    L6:
        if (r7 >= r6) goto L11;
        if (r5[r7].equals(r4) == true) goto L12;
        r7 = r7 + 1;
    L12:
        if (r3 == false) goto L13;
        r2 = r2 + 1;
        goto L3
    L13:
        return false;
    L11:
        r3 = false;
        goto L12
    L15:
        return true;
    }

    public String[] a() {
        String[] r2 = this.e;
        return (String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r2, r2.length), String[].class, "com.obric.memorydata.plugin");
    }

    public int b(int r1) {
        return g(r1).c.c;
    }

    public void b(Context r8, int r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        XmlResourceParser r2 = ZeusTransformUtils.getResources(r10, "com.obric.memorydata.plugin").getXml(r9);
        int r3 = r2.getEventType();     // Catch: IOException -> L15 XmlPullParserException -> L17
    L5:
        if (r3 == 1) goto L27;
        if (r3 != 2) goto L13;
        String r4 = r2.getName();     // Catch: IOException -> L15 XmlPullParserException -> L17
        a r5 = a(r10, Xml.asAttributeSet(r2), false);     // Catch: IOException -> L15 XmlPullParserException -> L17
        if (r4.equalsIgnoreCase("Guideline") == false) goto L12;
        r5.e.f13773a = true;     // Catch: IOException -> L15 XmlPullParserException -> L17
    L12:
        this.i.put(Integer.valueOf(r5.f13768a), r5);     // Catch: IOException -> L15 XmlPullParserException -> L17
    L13:
        r3 = r2.next();     // Catch: IOException -> L15 XmlPullParserException -> L17
    L27:
        return;
    L15:
        e = e;
        StringBuilder r11 = new StringBuilder();
    L19:
        Log.e("ConstraintSet", r11.append("Error parsing resource: ").append(r9).toString(), e);
        return;
    L17:
        e = e;
        r11 = new StringBuilder();
        goto L19
    }

    public void b(ConstraintLayout r12) {
        int r0 = r12.getChildCount();
        this.i.clear();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L29;
        View r2 = r12.getChildAt(r1);
        ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        int r4 = r2.getId();
        if (this.g == false) goto L12;
        if (r4 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.i.containsKey(Integer.valueOf(r4)) == true) goto L14;
        this.i.put(Integer.valueOf(r4), new a());
    L14:
        a r6 = (a) ZeusTransformUtils.preCheckCast(this.i.get(Integer.valueOf(r4)), a.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L28;
        r6.g = ConstraintAttribute.a(this.f, r2);
        a.a(r6, r4, r3);
        r6.c.f13778b = r2.getVisibility();
        r6.c.d = r2.getAlpha();
        r6.f.f13780b = r2.getRotation();
        r6.f.c = r2.getRotationX();
        r6.f.d = r2.getRotationY();
        r6.f.e = r2.getScaleX();
        r6.f.f = r2.getScaleY();
        float r5 = r2.getPivotX();
        float r7 = r2.getPivotY();
        if (r5 == 0.0d) goto L20;
    L21:
        r6.f.g = r5;
        r6.f.h = r7;
    L22:
        r6.f.j = r2.getTranslationX();
        r6.f.k = r2.getTranslationY();
        r6.f.l = r2.getTranslationZ();
        if (r6.f.m == false) goto L26;
        r6.f.n = r2.getElevation();
    L26:
        if (ZeusTransformUtils.instanceOf(r2, Barrier.class) == false) goto L28;
        Barrier r8 = (Barrier) ZeusTransformUtils.preCheckCast(r2, Barrier.class, "com.obric.memorydata.plugin");
        r6.e.ap = r8.getAllowsGoneWidget();
        r6.e.ak = r8.getReferencedIds();
        r6.e.ah = r8.getType();
        r6.e.ai = r8.getMargin();
        goto L28
    L20:
        if (r7 == 0.0d) goto L22;
    L28:
        r1 = r1 + 1;
        goto L3
    }

    public void b(b r7) {
        Iterator<a> r8 = r7.i.values().iterator();
    L4:
        if (r8.hasNext() == false) goto L20;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r8.next(), a.class, "com.obric.memorydata.plugin");
        if (r0.h == null) goto L4;
        if (r0.f13769b == null) goto L10;
        Iterator<Integer> r1 = this.i.keySet().iterator();
    L13:
        if (r1.hasNext() == false) goto L4;
        a r3 = f(((Integer) ZeusTransformUtils.preCheckCast(r1.next(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        if (r3.e.am == null) goto L13;
        if (r0.f13769b.matches(r3.e.am) == false) goto L13;
        r0.h.a(r3);
        HashMap r4 = (HashMap) ZeusTransformUtils.preCheckCast(r0.g.clone(), HashMap.class, "com.obric.memorydata.plugin");
        r3.g.putAll(r4);
        goto L13
    L10:
        a r2 = f(r0.f13768a);
        r0.h.a(r2);
        goto L4
    }

    public void b(boolean r1) {
        this.d = r1;
    }

    public int[] b() {
        int r0 = 0;
        Integer[] r4 = (Integer[]) ZeusTransformUtils.preCheckCast(this.i.keySet().toArray(new Integer[0]), Integer[].class, "com.obric.memorydata.plugin");
        int r1 = r4.length;
        int[] r2 = new int[r1];
    L3:
        if (r0 >= r1) goto L5;
        r2[r0] = r4[r0].intValue();
        r0 = r0 + 1;
        goto L3
    L5:
        return r2;
    }

    public int c(int r1) {
        return g(r1).c.f13778b;
    }

    public void c(ConstraintLayout r2) {
        a(r2, true);
        r2.setConstraintSet(null);
        r2.requestLayout();
    }

    public void c(b r6) {
        this.i.clear();
        Iterator<Integer> r0 = r6.i.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(r0.next(), Integer.class, "com.obric.memorydata.plugin");
        a r2 = (a) ZeusTransformUtils.preCheckCast(r6.i.get(r1), a.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        this.i.put(r1, r2.a());
        goto L4
    }

    public int d(int r1) {
        return g(r1).e.e;
    }

    public void d(ConstraintLayout r7) {
        int r0 = r7.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L21;
        View r2 = r7.getChildAt(r1);
        int r3 = r2.getId();
        if (this.i.containsKey(Integer.valueOf(r3)) == true) goto L8;
        Log.w("ConstraintSet", "id unknown " + com.obric.oui.constraintlayout.motion.widget.a.a(r2));
    L20:
        r1 = r1 + 1;
        goto L3
    L8:
        if (this.g == false) goto L15;
        if (r3 != (-1)) goto L15;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L15:
        if (this.i.containsKey(Integer.valueOf(r3)) == false) goto L20;
        a r4 = (a) ZeusTransformUtils.preCheckCast(this.i.get(Integer.valueOf(r3)), a.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L20;
        ConstraintAttribute.a(r2, r4.g);
        goto L20
    }

    public int e(int r1) {
        return g(r1).e.d;
    }

    public a f(int r3) {
        if (this.i.containsKey(Integer.valueOf(r3)) == true) goto L5;
        return null;
    L5:
        return (a) ZeusTransformUtils.preCheckCast(this.i.get(Integer.valueOf(r3)), a.class, "com.obric.memorydata.plugin");
    }
}
