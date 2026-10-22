package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import s.h;
import s.i;
import s.k;
import s.l;
import s.m;
import t.j;
import t.n;
import t.p;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static v.e f1342z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<View> f1343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<c> f1344b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final s.f f1345m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f1346n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1347o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f1348p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1349q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1350r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1351s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public d f1352t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public v.a f1353u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1354v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public HashMap<String, Integer> f1355w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final SparseArray<s.e> f1356x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final b f1357y;

    public static class a extends ViewGroup.MarginLayoutParams {
        public int A;
        public int B;
        public final int C;
        public final int D;
        public float E;
        public float F;
        public String G;
        public float H;
        public float I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public float R;
        public float S;
        public int T;
        public int U;
        public int V;
        public boolean W;
        public boolean X;
        public String Y;
        public int Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1358a;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public boolean f1359a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1360b;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public boolean f1361b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f1362c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public boolean f1363c0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f1364d;
        public boolean d0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1365e;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public boolean f1366e0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1367f;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public boolean f1368f0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f1369g;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public int f1370g0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f1371h;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public int f1372h0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f1373i;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public int f1374i0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f1375j;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public int f1376j0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f1377k;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public int f1378k0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f1379l;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public int f1380l0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f1381m;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public float f1382m0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f1383n;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public int f1384n0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f1385o;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public int f1386o0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f1387p;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public float f1388p0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f1389q;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public s.e f1390q0;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f1391r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f1392s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f1393t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f1394u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f1395v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f1396w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f1397x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final int f1398y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f1399z;

        /* JADX INFO: renamed from: androidx.constraintlayout.widget.ConstraintLayout$a$a, reason: collision with other inner class name */
        public static class C0007a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f1400a = null;

            static {
                SparseIntArray r8 = new SparseIntArray();
                f1400a = r8;
                r8.append(98, 64);
                r8.append(75, 65);
                r8.append(84, 8);
                r8.append(85, 9);
                r8.append(87, 10);
                r8.append(88, 11);
                r8.append(94, 12);
                r8.append(93, 13);
                r8.append(65, 14);
                r8.append(64, 15);
                r8.append(60, 16);
                r8.append(62, 52);
                r8.append(61, 53);
                r8.append(66, 2);
                r8.append(68, 3);
                r8.append(67, 4);
                r8.append(103, 49);
                r8.append(104, 50);
                r8.append(72, 5);
                r8.append(73, 6);
                r8.append(74, 7);
                r8.append(55, 67);
                r8.append(0, 1);
                r8.append(89, 17);
                r8.append(90, 18);
                r8.append(71, 19);
                r8.append(70, 20);
                r8.append(108, 21);
                r8.append(111, 22);
                r8.append(109, 23);
                r8.append(106, 24);
                r8.append(110, 25);
                r8.append(107, 26);
                r8.append(105, 55);
                r8.append(BWDLInnerConstant.LINK_RECOVERY, 54);
                r8.append(80, 29);
                r8.append(95, 30);
                r8.append(69, 44);
                r8.append(82, 45);
                r8.append(97, 46);
                r8.append(81, 47);
                r8.append(96, 48);
                r8.append(58, 27);
                r8.append(57, 28);
                r8.append(99, 31);
                r8.append(76, 32);
                r8.append(101, 33);
                r8.append(100, 34);
                r8.append(102, 35);
                r8.append(78, 36);
                r8.append(77, 37);
                r8.append(79, 38);
                r8.append(83, 39);
                r8.append(92, 40);
                r8.append(86, 41);
                r8.append(63, 42);
                r8.append(59, 43);
                r8.append(91, 51);
                r8.append(114, 66);
            }
        }

        public a(int r8, int r10) {
            super(r8, r10);
            this.f1358a = -1;
            this.f1360b = -1;
            this.f1362c = -1.0f;
            this.f1364d = true;
            this.f1365e = -1;
            this.f1367f = -1;
            this.f1369g = -1;
            this.f1371h = -1;
            this.f1373i = -1;
            this.f1375j = -1;
            this.f1377k = -1;
            this.f1379l = -1;
            this.f1381m = -1;
            this.f1383n = -1;
            this.f1385o = -1;
            this.f1387p = -1;
            this.f1389q = 0;
            this.f1391r = 0.0f;
            this.f1392s = -1;
            this.f1393t = -1;
            this.f1394u = -1;
            this.f1395v = -1;
            this.f1396w = Integer.MIN_VALUE;
            this.f1397x = Integer.MIN_VALUE;
            this.f1398y = Integer.MIN_VALUE;
            this.f1399z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = 0.5f;
            this.F = 0.5f;
            this.G = null;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = 1.0f;
            this.T = -1;
            this.U = -1;
            this.V = -1;
            this.W = false;
            this.X = false;
            this.Y = null;
            this.Z = 0;
            this.f1359a0 = true;
            this.f1361b0 = true;
            this.f1363c0 = false;
            this.d0 = false;
            this.f1366e0 = false;
            this.f1368f0 = false;
            this.f1370g0 = -1;
            this.f1372h0 = -1;
            this.f1374i0 = -1;
            this.f1376j0 = -1;
            this.f1378k0 = Integer.MIN_VALUE;
            this.f1380l0 = Integer.MIN_VALUE;
            this.f1382m0 = 0.5f;
            this.f1390q0 = new s.e();
        }

        public final void a() {
            this.d0 = false;
            this.f1359a0 = true;
            this.f1361b0 = true;
            int r8 = ((ViewGroup.MarginLayoutParams) this).width;
            if (r8 == (-2)) goto L5;
        L9:
            int r10 = ((ViewGroup.MarginLayoutParams) this).height;
            if (r10 != (-2)) goto L17;
            if (this.X == false) goto L17;
            this.f1361b0 = false;
            if (this.M != 0) goto L17;
            this.M = 1;
        L17:
            if (r8 == 0) goto L19;
            if (r8 == (-1)) goto L19;
        L24:
            if (r10 == 0) goto L26;
            if (r10 == (-1)) goto L26;
        L32:
            if (this.f1362c == (-1.0f)) goto L34;
        L37:
            this.d0 = true;
            this.f1359a0 = true;
            this.f1361b0 = true;
            if ((this.f1390q0 instanceof h) == true) goto L40;
            this.f1390q0 = new h();
        L40:
            ((h) this.f1390q0).Q(this.V);
            return;
        L34:
            if (this.f1358a != (-1)) goto L37;
            if (this.f1360b != (-1)) goto L37;
            return;
        L26:
            this.f1361b0 = false;
            if (r10 != 0) goto L32;
            if (this.M != 1) goto L32;
            ((ViewGroup.MarginLayoutParams) this).height = -2;
            this.X = true;
        L19:
            this.f1359a0 = false;
            if (r8 != 0) goto L24;
            if (this.L != 1) goto L24;
            ((ViewGroup.MarginLayoutParams) this).width = -2;
            this.W = true;
            goto L24
        L5:
            if (this.W == false) goto L9;
            this.f1359a0 = false;
            if (this.L != 0) goto L9;
            this.L = 1;
            goto L9
        }

        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        public final void resolveLayoutDirection(int r11) {
            int r8 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int r10 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            super.resolveLayoutDirection(r11);
            boolean r12 = false;
            if (1 != getLayoutDirection()) goto L5;
            boolean r13 = true;
        L6:
            this.f1374i0 = -1;
            this.f1376j0 = -1;
            this.f1370g0 = -1;
            this.f1372h0 = -1;
            this.f1378k0 = this.f1396w;
            this.f1380l0 = this.f1398y;
            float r14 = this.E;
            this.f1382m0 = r14;
            int r15 = this.f1358a;
            this.f1384n0 = r15;
            int r16 = this.f1360b;
            this.f1386o0 = r16;
            float r17 = this.f1362c;
            this.f1388p0 = r17;
            if (r13 == false) goto L44;
            int r18 = this.f1392s;
            if (r18 == (-1)) goto L12;
            this.f1374i0 = r18;
        L11:
            r12 = true;
        L15:
            int r19 = this.f1394u;
            if (r19 == (-1)) goto L18;
            this.f1372h0 = r19;
            r12 = true;
        L18:
            int r110 = this.f1395v;
            if (r110 == (-1)) goto L21;
            this.f1370g0 = r110;
            r12 = true;
        L21:
            int r111 = this.A;
            if (r111 == Integer.MIN_VALUE) goto L24;
            this.f1380l0 = r111;
        L24:
            int r112 = this.B;
            if (r112 == Integer.MIN_VALUE) goto L28;
            this.f1378k0 = r112;
        L28:
            if (r12 == false) goto L31;
            this.f1382m0 = 1.0f - r14;
        L31:
            if (this.d0 == false) goto L63;
            if (this.V != 1) goto L63;
            if (this.f1364d == false) goto L63;
            if (r17 == (-1.0f)) goto L39;
            this.f1388p0 = 1.0f - r17;
            this.f1384n0 = -1;
            this.f1386o0 = -1;
            goto L63
        L39:
            if (r15 == (-1)) goto L42;
            this.f1386o0 = r15;
            this.f1384n0 = -1;
        L41:
            this.f1388p0 = -1.0f;
            goto L63
        L42:
            if (r16 == (-1)) goto L63;
            this.f1384n0 = r16;
            this.f1386o0 = -1;
        L63:
            if (this.f1394u == (-1)) goto L65;
            return;
        L65:
            if (this.f1395v == (-1)) goto L67;
            return;
        L67:
            if (this.f1393t == (-1)) goto L69;
            return;
        L69:
            if (this.f1392s != (-1)) goto L97;
            int r113 = this.f1369g;
            if (r113 == (-1)) goto L76;
            this.f1374i0 = r113;
            if (((ViewGroup.MarginLayoutParams) this).rightMargin > 0) goto L82;
            if (r10 <= 0) goto L82;
        L75:
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r10;
        L82:
            int r114 = this.f1365e;
            if (r114 == (-1)) goto L88;
            this.f1370g0 = r114;
            if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0) goto L98;
            if (r8 <= 0) goto L99;
        L87:
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r8;
            return;
        L99:
            return;
        L98:
            return;
        L88:
            int r115 = this.f1367f;
            if (r115 == (-1)) goto L101;
            this.f1372h0 = r115;
            if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0) goto L102;
            if (r8 > 0) goto L87;
            return;
        L102:
            return;
        L101:
            return;
        L76:
            int r116 = this.f1371h;
            if (r116 == (-1)) goto L82;
            this.f1376j0 = r116;
            if (((ViewGroup.MarginLayoutParams) this).rightMargin > 0) goto L82;
            if (r10 <= 0) goto L82;
        L97:
            return;
        L12:
            int r117 = this.f1393t;
            if (r117 == (-1)) goto L15;
            this.f1376j0 = r117;
            goto L11
        L44:
            int r118 = this.f1392s;
            if (r118 == (-1)) goto L47;
            this.f1372h0 = r118;
        L47:
            int r119 = this.f1393t;
            if (r119 == (-1)) goto L50;
            this.f1370g0 = r119;
        L50:
            int r120 = this.f1394u;
            if (r120 == (-1)) goto L53;
            this.f1374i0 = r120;
        L53:
            int r121 = this.f1395v;
            if (r121 == (-1)) goto L56;
            this.f1376j0 = r121;
        L56:
            int r122 = this.A;
            if (r122 == Integer.MIN_VALUE) goto L59;
            this.f1378k0 = r122;
        L59:
            int r123 = this.B;
            if (r123 == Integer.MIN_VALUE) goto L63;
            this.f1380l0 = r123;
            goto L63
        L5:
            r13 = false;
            goto L6
        }

        public a(Context r10, AttributeSet r11) {
            super(r10, r11);
            this.f1358a = -1;
            this.f1360b = -1;
            this.f1362c = -1.0f;
            this.f1364d = true;
            this.f1365e = -1;
            this.f1367f = -1;
            this.f1369g = -1;
            this.f1371h = -1;
            this.f1373i = -1;
            this.f1375j = -1;
            this.f1377k = -1;
            this.f1379l = -1;
            this.f1381m = -1;
            this.f1383n = -1;
            this.f1385o = -1;
            this.f1387p = -1;
            this.f1389q = 0;
            this.f1391r = 0.0f;
            this.f1392s = -1;
            this.f1393t = -1;
            this.f1394u = -1;
            this.f1395v = -1;
            this.f1396w = Integer.MIN_VALUE;
            this.f1397x = Integer.MIN_VALUE;
            this.f1398y = Integer.MIN_VALUE;
            this.f1399z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = 0.5f;
            this.F = 0.5f;
            this.G = null;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = 1.0f;
            this.T = -1;
            this.U = -1;
            this.V = -1;
            this.W = false;
            this.X = false;
            this.Y = null;
            this.Z = 0;
            this.f1359a0 = true;
            this.f1361b0 = true;
            this.f1363c0 = false;
            this.d0 = false;
            this.f1366e0 = false;
            this.f1368f0 = false;
            this.f1370g0 = -1;
            this.f1372h0 = -1;
            this.f1374i0 = -1;
            this.f1376j0 = -1;
            this.f1378k0 = Integer.MIN_VALUE;
            this.f1380l0 = Integer.MIN_VALUE;
            this.f1382m0 = 0.5f;
            this.f1390q0 = new s.e();
            TypedArray r12 = r10.obtainStyledAttributes(r11, v.d.f12656b);
            int r13 = r12.getIndexCount();
            int r8 = 0;
        L3:
            if (r8 >= r13) goto L119;
            int r14 = r12.getIndex(r8);
            int r15 = C0007a.f1400a.get(r14);
            switch(r15) {
                case 1: goto L97;
                case 2: goto L94;
                case 3: goto L93;
                case 4: goto L90;
                case 5: goto L89;
                case 6: goto L88;
                case 7: goto L87;
                case 8: goto L84;
                case 9: goto L81;
                case 10: goto L78;
                case 11: goto L75;
                case 12: goto L72;
                case 13: goto L69;
                case 14: goto L66;
                case 15: goto L63;
                case 16: goto L60;
                case 17: goto L57;
                case 18: goto L54;
                case 19: goto L51;
                case 20: goto L48;
                case 21: goto L47;
                case 22: goto L46;
                case 23: goto L45;
                case 24: goto L44;
                case 25: goto L43;
                case 26: goto L42;
                case 27: goto L41;
                case 28: goto L40;
                case 29: goto L39;
                case 30: goto L38;
                case 31: goto L34;
                case 32: goto L31;
                case 33: goto L123;
                case 34: goto L127;
                case 35: goto L20;
                case 36: goto L121;
                case 37: goto L125;
                case 38: goto L9;
                default: goto L6;
            };
        L6:
            switch(r15) {
                case 44: goto L113;
                case 45: goto L112;
                case 46: goto L111;
                case 47: goto L110;
                case 48: goto L109;
                case 49: goto L108;
                case 50: goto L107;
                case 51: goto L106;
                case 52: goto L103;
                case 53: goto L100;
                case 54: goto L99;
                case 55: goto L98;
                default: goto L7;
            };
        L7:
            switch(r15) {
                case 64: goto L117;
                case 65: goto L116;
                case 66: goto L115;
                case 67: goto L114;
                default: goto L118;
            };
        L114:
            this.f1364d = r12.getBoolean(r14, this.f1364d);
            goto L118
        L115:
            this.Z = r12.getInt(r14, this.Z);
            goto L118
        L116:
            d.h(this, r12, r14, 1);
            goto L118
        L117:
            d.h(this, r12, r14, 0);
        L118:
            r8 = r8 + 1;
            goto L3
        L98:
            this.C = r12.getDimensionPixelSize(r14, this.C);
            goto L118
        L99:
            this.D = r12.getDimensionPixelSize(r14, this.D);
            goto L118
        L100:
            int r16 = r12.getResourceId(r14, this.f1385o);
            this.f1385o = r16;
            if (r16 != (-1)) goto L118;
            this.f1385o = r12.getInt(r14, -1);
            goto L118
        L103:
            int r17 = r12.getResourceId(r14, this.f1383n);
            this.f1383n = r17;
            if (r17 != (-1)) goto L118;
            this.f1383n = r12.getInt(r14, -1);
            goto L118
        L106:
            this.Y = r12.getString(r14);
            goto L118
        L107:
            this.U = r12.getDimensionPixelOffset(r14, this.U);
            goto L118
        L108:
            this.T = r12.getDimensionPixelOffset(r14, this.T);
            goto L118
        L109:
            this.K = r12.getInt(r14, 0);
            goto L118
        L110:
            this.J = r12.getInt(r14, 0);
            goto L118
        L111:
            this.I = r12.getFloat(r14, this.I);
            goto L118
        L112:
            this.H = r12.getFloat(r14, this.H);
            goto L118
        L113:
            d.i(this, r12.getString(r14));
            goto L118
        L9:
            this.S = Math.max(0.0f, r12.getFloat(r14, this.S));
            this.M = 2;
            goto L118
        L20:
            this.R = Math.max(0.0f, r12.getFloat(r14, this.R));
            this.L = 2;
            goto L118
        L31:
            int r18 = r12.getInt(r14, 0);
            this.M = r18;
            if (r18 != 1) goto L118;
            String r19 = "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.";
        L37:
            Log.e("ConstraintLayout", r19);
            goto L118
        L34:
            int r20 = r12.getInt(r14, 0);
            this.L = r20;
            if (r20 != 1) goto L118;
            r19 = "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.";
            goto L37
        L38:
            this.F = r12.getFloat(r14, this.F);
            goto L118
        L39:
            this.E = r12.getFloat(r14, this.E);
            goto L118
        L40:
            this.X = r12.getBoolean(r14, this.X);
            goto L118
        L41:
            this.W = r12.getBoolean(r14, this.W);
            goto L118
        L42:
            this.B = r12.getDimensionPixelSize(r14, this.B);
            goto L118
        L43:
            this.A = r12.getDimensionPixelSize(r14, this.A);
            goto L118
        L44:
            this.f1399z = r12.getDimensionPixelSize(r14, this.f1399z);
            goto L118
        L45:
            this.f1398y = r12.getDimensionPixelSize(r14, this.f1398y);
            goto L118
        L46:
            this.f1397x = r12.getDimensionPixelSize(r14, this.f1397x);
            goto L118
        L47:
            this.f1396w = r12.getDimensionPixelSize(r14, this.f1396w);
            goto L118
        L48:
            int r21 = r12.getResourceId(r14, this.f1395v);
            this.f1395v = r21;
            if (r21 != (-1)) goto L118;
            this.f1395v = r12.getInt(r14, -1);
            goto L118
        L51:
            int r22 = r12.getResourceId(r14, this.f1394u);
            this.f1394u = r22;
            if (r22 != (-1)) goto L118;
            this.f1394u = r12.getInt(r14, -1);
            goto L118
        L54:
            int r23 = r12.getResourceId(r14, this.f1393t);
            this.f1393t = r23;
            if (r23 != (-1)) goto L118;
            this.f1393t = r12.getInt(r14, -1);
            goto L118
        L57:
            int r24 = r12.getResourceId(r14, this.f1392s);
            this.f1392s = r24;
            if (r24 != (-1)) goto L118;
            this.f1392s = r12.getInt(r14, -1);
            goto L118
        L60:
            int r25 = r12.getResourceId(r14, this.f1381m);
            this.f1381m = r25;
            if (r25 != (-1)) goto L118;
            this.f1381m = r12.getInt(r14, -1);
            goto L118
        L63:
            int r26 = r12.getResourceId(r14, this.f1379l);
            this.f1379l = r26;
            if (r26 != (-1)) goto L118;
            this.f1379l = r12.getInt(r14, -1);
            goto L118
        L66:
            int r27 = r12.getResourceId(r14, this.f1377k);
            this.f1377k = r27;
            if (r27 != (-1)) goto L118;
            this.f1377k = r12.getInt(r14, -1);
            goto L118
        L69:
            int r28 = r12.getResourceId(r14, this.f1375j);
            this.f1375j = r28;
            if (r28 != (-1)) goto L118;
            this.f1375j = r12.getInt(r14, -1);
            goto L118
        L72:
            int r29 = r12.getResourceId(r14, this.f1373i);
            this.f1373i = r29;
            if (r29 != (-1)) goto L118;
            this.f1373i = r12.getInt(r14, -1);
            goto L118
        L75:
            int r30 = r12.getResourceId(r14, this.f1371h);
            this.f1371h = r30;
            if (r30 != (-1)) goto L118;
            this.f1371h = r12.getInt(r14, -1);
            goto L118
        L78:
            int r31 = r12.getResourceId(r14, this.f1369g);
            this.f1369g = r31;
            if (r31 != (-1)) goto L118;
            this.f1369g = r12.getInt(r14, -1);
            goto L118
        L81:
            int r32 = r12.getResourceId(r14, this.f1367f);
            this.f1367f = r32;
            if (r32 != (-1)) goto L118;
            this.f1367f = r12.getInt(r14, -1);
            goto L118
        L84:
            int r33 = r12.getResourceId(r14, this.f1365e);
            this.f1365e = r33;
            if (r33 != (-1)) goto L118;
            this.f1365e = r12.getInt(r14, -1);
            goto L118
        L87:
            this.f1362c = r12.getFloat(r14, this.f1362c);
            goto L118
        L88:
            this.f1360b = r12.getDimensionPixelOffset(r14, this.f1360b);
            goto L118
        L89:
            this.f1358a = r12.getDimensionPixelOffset(r14, this.f1358a);
            goto L118
        L90:
            float r34 = r12.getFloat(r14, this.f1391r) % 360.0f;
            this.f1391r = r34;
            if (r34 >= 0.0f) goto L118;
            this.f1391r = (360.0f - r34) % 360.0f;
            goto L118
        L93:
            this.f1389q = r12.getDimensionPixelSize(r14, this.f1389q);
            goto L118
        L94:
            int r35 = r12.getResourceId(r14, this.f1387p);
            this.f1387p = r35;
            if (r35 != (-1)) goto L118;
            this.f1387p = r12.getInt(r14, -1);
            goto L118
        L97:
            this.V = r12.getInt(r14, this.V);
            goto L118
        L121:
            this.O = r12.getDimensionPixelSize(r14, this.O);     // Catch: Exception -> L17
        L18:
            if (r12.getInt(r14, this.O) != (-2)) goto L118;
            this.O = -2;
            goto L118
        L123:
            this.N = r12.getDimensionPixelSize(r14, this.N);     // Catch: Exception -> L28
        L29:
            if (r12.getInt(r14, this.N) != (-2)) goto L118;
            this.N = -2;
            goto L118
        L125:
            this.Q = r12.getDimensionPixelSize(r14, this.Q);     // Catch: Exception -> L12
        L13:
            if (r12.getInt(r14, this.Q) != (-2)) goto L118;
            this.Q = -2;
            goto L118
        L127:
            this.P = r12.getDimensionPixelSize(r14, this.P);     // Catch: Exception -> L23
        L24:
            if (r12.getInt(r14, this.P) != (-2)) goto L118;
            this.P = -2;
            goto L118
        L119:
            r12.recycle();
            a();
        }

        @SuppressLint({"ClassVerificationFailure"})
        public a(ViewGroup.LayoutParams r8) {
            super(r8);
            this.f1358a = -1;
            this.f1360b = -1;
            this.f1362c = -1.0f;
            this.f1364d = true;
            this.f1365e = -1;
            this.f1367f = -1;
            this.f1369g = -1;
            this.f1371h = -1;
            this.f1373i = -1;
            this.f1375j = -1;
            this.f1377k = -1;
            this.f1379l = -1;
            this.f1381m = -1;
            this.f1383n = -1;
            this.f1385o = -1;
            this.f1387p = -1;
            this.f1389q = 0;
            this.f1391r = 0.0f;
            this.f1392s = -1;
            this.f1393t = -1;
            this.f1394u = -1;
            this.f1395v = -1;
            this.f1396w = Integer.MIN_VALUE;
            this.f1397x = Integer.MIN_VALUE;
            this.f1398y = Integer.MIN_VALUE;
            this.f1399z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = 0.5f;
            this.F = 0.5f;
            this.G = null;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = 1.0f;
            this.T = -1;
            this.U = -1;
            this.V = -1;
            this.W = false;
            this.X = false;
            this.Y = null;
            this.Z = 0;
            this.f1359a0 = true;
            this.f1361b0 = true;
            this.f1363c0 = false;
            this.d0 = false;
            this.f1366e0 = false;
            this.f1368f0 = false;
            this.f1370g0 = -1;
            this.f1372h0 = -1;
            this.f1374i0 = -1;
            this.f1376j0 = -1;
            this.f1378k0 = Integer.MIN_VALUE;
            this.f1380l0 = Integer.MIN_VALUE;
            this.f1382m0 = 0.5f;
            this.f1390q0 = new s.e();
            if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
            ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r8;
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r10.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r10.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = r10.topMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = r10.bottomMargin;
            setMarginStart(r10.getMarginStart());
            setMarginEnd(r10.getMarginEnd());
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return;
        L8:
            a r11 = (a) r8;
            this.f1358a = r11.f1358a;
            this.f1360b = r11.f1360b;
            this.f1362c = r11.f1362c;
            this.f1364d = r11.f1364d;
            this.f1365e = r11.f1365e;
            this.f1367f = r11.f1367f;
            this.f1369g = r11.f1369g;
            this.f1371h = r11.f1371h;
            this.f1373i = r11.f1373i;
            this.f1375j = r11.f1375j;
            this.f1377k = r11.f1377k;
            this.f1379l = r11.f1379l;
            this.f1381m = r11.f1381m;
            this.f1383n = r11.f1383n;
            this.f1385o = r11.f1385o;
            this.f1387p = r11.f1387p;
            this.f1389q = r11.f1389q;
            this.f1391r = r11.f1391r;
            this.f1392s = r11.f1392s;
            this.f1393t = r11.f1393t;
            this.f1394u = r11.f1394u;
            this.f1395v = r11.f1395v;
            this.f1396w = r11.f1396w;
            this.f1397x = r11.f1397x;
            this.f1398y = r11.f1398y;
            this.f1399z = r11.f1399z;
            this.A = r11.A;
            this.B = r11.B;
            this.C = r11.C;
            this.D = r11.D;
            this.E = r11.E;
            this.F = r11.F;
            this.G = r11.G;
            this.H = r11.H;
            this.I = r11.I;
            this.J = r11.J;
            this.K = r11.K;
            this.W = r11.W;
            this.X = r11.X;
            this.L = r11.L;
            this.M = r11.M;
            this.N = r11.N;
            this.P = r11.P;
            this.O = r11.O;
            this.Q = r11.Q;
            this.R = r11.R;
            this.S = r11.S;
            this.T = r11.T;
            this.U = r11.U;
            this.V = r11.V;
            this.f1359a0 = r11.f1359a0;
            this.f1361b0 = r11.f1361b0;
            this.f1363c0 = r11.f1363c0;
            this.d0 = r11.d0;
            this.f1370g0 = r11.f1370g0;
            this.f1372h0 = r11.f1372h0;
            this.f1374i0 = r11.f1374i0;
            this.f1376j0 = r11.f1376j0;
            this.f1378k0 = r11.f1378k0;
            this.f1380l0 = r11.f1380l0;
            this.f1382m0 = r11.f1382m0;
            this.Y = r11.Y;
            this.Z = r11.Z;
            this.f1390q0 = r11.f1390q0;
        }
    }

    public class b implements t.b.InterfaceC0157b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConstraintLayout f1401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1402b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1403c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1404d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1405e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1406f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f1407g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ ConstraintLayout f1408h;

        public b(ConstraintLayout r8, ConstraintLayout r10) {
            this.f1408h = r8;
            this.f1401a = r10;
        }

        public static boolean a(int r8, int r10, int r11) {
            if (r8 != r10) goto L5;
            return true;
        L5:
            int r12 = View.MeasureSpec.getMode(r8);
            int r13 = View.MeasureSpec.getMode(r10);
            int r14 = View.MeasureSpec.getSize(r10);
            if (r13 == 1073741824) goto L8;
        L12:
            return false;
        L8:
            if (r12 == Integer.MIN_VALUE) goto L10;
            if (r12 != 0) goto L12;
        L10:
            if (r11 != r14) goto L12;
            return true;
        }

        @SuppressLint({"WrongCall"})
        public final void b(s.e r19, t.b.a r20) {
            if (r19 != null) goto L6;
            return;
        L6:
            if (r19.f11866j0 != 8) goto L12;
            if (r19.G == true) goto L12;
            r20.f12143e = 0;
            r20.f12144f = 0;
            r20.f12145g = 0;
            return;
        L12:
            if (r19.W != null) goto L14;
            return;
        L14:
            v.e r8 = ConstraintLayout.f1342z;
            ConstraintLayout r10 = this.f1408h;
            r10.getClass();
            s.e.a r11 = r20.f12139a;
            s.e.a r12 = r20.f12140b;
            int r13 = r20.f12141c;
            int r14 = r20.f12142d;
            int r15 = this.f1402b + this.f1403c;
            int r16 = this.f1404d;
            View r17 = (View) r19.f11864i0;
            int r18 = r11.ordinal();
            s.d r21 = r19.M;
            s.d r110 = r19.K;
            if (r18 == 0) goto L55;
            if (r18 == 1) goto L53;
            if (r18 != 2) goto L19;
            int r22 = ViewGroup.getChildMeasureSpec(this.f1406f, r16, -2);
            if (r19.f11883s != 1) goto L31;
            boolean r111 = true;
        L32:
            int r112 = r20.f12148j;
            if (r112 == 1) goto L36;
            if (r112 == 2) goto L36;
        L56:
            int r113 = r12.ordinal();
            if (r113 != 0) goto L59;
            int r23 = View.MeasureSpec.makeMeasureSpec(r14, 1073741824);
        L103:
            s.f r24 = (s.f) r19.W;
            if (r24 != null) goto L106;
        L128:
            s.e.a r25 = s.e.a.f11893m;
            if (r11 != r25) goto L131;
            boolean r26 = true;
        L132:
            if (r12 != r25) goto L134;
            boolean r27 = true;
        L135:
            s.e.a r28 = s.e.a.f11894n;
            if (r12 != r28) goto L138;
        L141:
            boolean r29 = true;
        L142:
            if (r11 != r28) goto L144;
        L147:
            boolean r30 = true;
        L149:
            if (r26 == true) goto L151;
        L153:
            boolean r114 = false;
        L154:
            if (r27 == true) goto L156;
        L158:
            boolean r31 = false;
        L159:
            if (r17 != null) goto L161;
            return;
        L161:
            a r115 = (a) r17.getLayoutParams();
            int r116 = r20.f12148j;
            if (r116 == 1) goto L174;
            if (r116 == 2) goto L174;
            if (r26 == false) goto L174;
            if (r19.f11883s != 0) goto L174;
            if (r27 == false) goto L174;
            if (r19.f11884t != 0) goto L174;
            boolean r32 = false;
            int r117 = 0;
            int r118 = 0;
            int r119 = 0;
        L214:
            if (r117 == (-1)) goto L216;
            boolean r120 = true;
        L218:
            if (r118 == r20.f12141c) goto L220;
        L223:
            boolean r33 = true;
        L224:
            r20.f12147i = r33;
            if (r115.f1363c0 == false) goto L227;
            boolean r121 = true;
        L228:
            if (r121 == true) goto L230;
        L234:
            r20.f12143e = r118;
            r20.f12144f = r119;
            r20.f12146h = r121;
            r20.f12145g = r117;
            return;
        L230:
            if (r117 == (-1)) goto L234;
            if (r19.d0 == r117) goto L234;
            r20.f12147i = true;
            goto L234
        L227:
            r121 = r120;
            goto L228
        L220:
            if (r119 != r20.f12142d) goto L223;
            r33 = r32;
            goto L224
        L216:
            r120 = r32;
        L174:
            if ((r17 instanceof v.f) == true) goto L176;
        L178:
            r17.measure(r22, r23);
        L179:
            r19.I = r22;
            r19.J = r23;
            r19.f11859g = false;
            int r34 = r17.getMeasuredWidth();
            int r35 = r17.getMeasuredHeight();
            r117 = r17.getBaseline();
            int r122 = r19.f11886v;
            if (r122 <= 0) goto L182;
            r118 = Math.max(r122, r34);
        L183:
            int r123 = r19.f11887w;
            if (r123 <= 0) goto L186;
            r118 = Math.min(r123, r118);
        L186:
            int r124 = r19.f11889y;
            if (r124 <= 0) goto L189;
            r119 = Math.max(r124, r35);
        L190:
            int r36 = r19.f11890z;
            if (r36 <= 0) goto L194;
            r119 = Math.min(r36, r119);
        L194:
            if (k.b(r10.f1351s, 1) == false) goto L196;
        L202:
            if (r34 != r118) goto L207;
            if (r35 != r119) goto L207;
            r32 = false;
        L207:
            if (r34 == r118) goto L209;
            r22 = View.MeasureSpec.makeMeasureSpec(r118, 1073741824);
        L209:
            if (r35 == r119) goto L211;
            int r37 = View.MeasureSpec.makeMeasureSpec(r119, 1073741824);
        L212:
            r17.measure(r22, r37);
            r19.I = r22;
            r19.J = r37;
            r32 = false;
            r19.f11859g = false;
            int r125 = r17.getMeasuredWidth();
            r119 = r17.getMeasuredHeight();
            r117 = r17.getBaseline();
            r118 = r125;
            goto L214
        L211:
            r37 = r23;
            goto L212
        L196:
            if (r114 == false) goto L199;
            if (r29 == false) goto L199;
            r118 = (int) ((r119 * r19.Z) + 0.5f);
        L199:
            if (r31 == false) goto L202;
            if (r30 == false) goto L202;
            r119 = (int) ((r118 / r19.Z) + 0.5f);
            goto L202
        L189:
            r119 = r35;
            goto L190
        L182:
            r118 = r34;
            goto L183
        L176:
            if ((r19 instanceof l) == false) goto L178;
            ((v.f) r17).l((l) r19, r22, r23);
            goto L179
        L156:
            if (r19.Z <= 0.0f) goto L158;
            r31 = true;
            goto L159
        L151:
            if (r19.Z <= 0.0f) goto L153;
            r114 = true;
            goto L154
        L144:
            if (r11 == s.e.a.f11891a) goto L147;
            r30 = false;
            goto L149
        L138:
            if (r12 == s.e.a.f11891a) goto L141;
            r29 = false;
            goto L142
        L134:
            r27 = false;
            goto L135
        L131:
            r26 = false;
            goto L132
        L106:
            if (k.b(r10.f1351s, 256) == false) goto L128;
            if (r17.getMeasuredWidth() != r19.q()) goto L128;
            if (r17.getMeasuredWidth() >= r24.q()) goto L128;
            if (r17.getMeasuredHeight() != r19.l()) goto L128;
            if (r17.getMeasuredHeight() >= r24.l()) goto L128;
            if (r17.getBaseline() != r19.d0) goto L128;
            if (r19.z() == true) goto L128;
            if (a(r19.I, r22, r19.q()) == true) goto L122;
        L124:
            boolean r38 = false;
        L125:
            if (r38 == false) goto L128;
            r20.f12143e = r19.q();
            r20.f12144f = r19.l();
            r20.f12145g = r19.d0;
            return;
        L122:
            if (a(r19.J, r23, r19.l()) == false) goto L124;
            r38 = true;
            goto L125
        L59:
            if (r113 != 1) goto L61;
            r23 = ViewGroup.getChildMeasureSpec(this.f1407g, r15, -2);
            goto L103
        L61:
            if (r113 != 2) goto L63;
            r23 = ViewGroup.getChildMeasureSpec(this.f1407g, r15, -2);
            if (r19.f11884t != 1) goto L75;
            boolean r39 = true;
        L76:
            int r40 = r20.f12148j;
            if (r40 == 1) goto L82;
            int r41 = 2;
            if (r40 != 2) goto L103;
        L84:
            if (r17.getMeasuredWidth() != r19.q()) goto L86;
            boolean r42 = true;
        L88:
            if (r20.f12148j == r41) goto L98;
            if (r39 == false) goto L98;
            if (r39 == false) goto L93;
            if (r42 == true) goto L98;
        L93:
            if ((r17 instanceof f) == true) goto L98;
            if (r19.B() == true) goto L98;
            boolean r43 = false;
        L99:
            if (r43 == false) goto L103;
            r23 = View.MeasureSpec.makeMeasureSpec(r19.l(), 1073741824);
        L98:
            r43 = true;
            goto L99
        L86:
            r42 = false;
            goto L88
        L82:
            r41 = 2;
            goto L84
        L75:
            r39 = false;
            goto L76
        L63:
            if (r113 == 3) goto L65;
            r23 = 0;
            goto L103
        L65:
            int r44 = this.f1407g;
            if (r110 == null) goto L68;
            int r45 = r19.L.f11836g + 0;
        L69:
            if (r21 == null) goto L71;
            r45 = r45 + r19.N.f11836g;
        L71:
            r23 = ViewGroup.getChildMeasureSpec(r44, r15 + r45, -1);
            goto L103
        L68:
            r45 = 0;
        L36:
            if (r17.getMeasuredHeight() != r19.l()) goto L38;
            boolean r126 = true;
        L40:
            if (r20.f12148j == 2) goto L50;
            if (r111 == false) goto L50;
            if (r111 == false) goto L45;
            if (r126 == true) goto L50;
        L45:
            if ((r17 instanceof f) == true) goto L50;
            if (r19.A() == true) goto L50;
            boolean r127 = false;
        L51:
            if (r127 == false) goto L56;
            r13 = r19.q();
        L50:
            r127 = true;
            goto L51
        L38:
            r126 = false;
            goto L40
        L31:
            r111 = false;
            goto L32
        L19:
            if (r18 == 3) goto L21;
            r22 = 0;
            goto L56
        L21:
            int r46 = this.f1406f;
            if (r110 == null) goto L24;
            int r128 = r110.f11836g + 0;
        L25:
            if (r21 == null) goto L27;
            r128 = r128 + r21.f11836g;
        L27:
            r16 = r16 + r128;
            int r129 = -1;
        L54:
            r22 = ViewGroup.getChildMeasureSpec(r46, r16, r129);
            goto L56
        L24:
            r128 = 0;
            goto L25
        L53:
            r46 = this.f1406f;
            r129 = -2;
        L55:
            r22 = View.MeasureSpec.makeMeasureSpec(r13, 1073741824);
            goto L56
        }
    }

    public ConstraintLayout(Context r8, AttributeSet r10) {
        super(r8, r10);
        this.f1343a = new SparseArray();
        this.f1344b = new ArrayList(4);
        this.f1345m = new s.f();
        this.f1346n = 0;
        this.f1347o = 0;
        this.f1348p = Integer.MAX_VALUE;
        this.f1349q = Integer.MAX_VALUE;
        this.f1350r = true;
        this.f1351s = 257;
        this.f1352t = null;
        this.f1353u = null;
        this.f1354v = -1;
        this.f1355w = new HashMap();
        this.f1356x = new SparseArray();
        this.f1357y = new b(this, this);
        h(r10, 0);
    }

    private int getPaddingWidth() {
        int r8 = Math.max(0, getPaddingLeft());
        int r10 = Math.max(0, getPaddingRight()) + r8;
        int r11 = Math.max(0, getPaddingStart());
        int r12 = Math.max(0, getPaddingEnd()) + r11;
        if (r12 > 0) goto L5;
        return r10;
    L5:
        return r12;
    }

    public static v.e getSharedValues() {
        if (f1342z != null) goto L6;
        f1342z = new v.e();
    L6:
        return f1342z;
    }

    public final s.e b(View r8) {
        if (r8 == this) goto L4;
        if (r8 != null) goto L7;
        return null;
    L7:
        if ((r8.getLayoutParams() instanceof a) == true) goto L9;
        r8.setLayoutParams(generateLayoutParams(r8.getLayoutParams()));
        if ((r8.getLayoutParams() instanceof a) == true) goto L9;
        return null;
    L9:
        return ((a) r8.getLayoutParams()).f1390q0;
    L4:
        return this.f1345m;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r8) {
        return r8 instanceof a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r19) {
        ArrayList<c> r8 = this.f1344b;
        if (r8 == null) goto L9;
        int r10 = r8.size();
        if (r10 <= 0) goto L9;
        int r11 = 0;
    L7:
        if (r11 >= r10) goto L9;
        r8.get(r11).getClass();
        r11 = r11 + 1;
    L9:
        super.dispatchDraw(r19);
        if (isInEditMode() == false) goto L24;
        float r12 = getWidth();
        float r13 = getHeight();
        int r14 = getChildCount();
        int r15 = 0;
    L12:
        if (r15 >= r14) goto L32;
        View r16 = getChildAt(r15);
        if (r16.getVisibility() == 8) goto L23;
        Object r17 = r16.getTag();
        if (r17 == null) goto L23;
        if ((r17 instanceof String) == false) goto L23;
        String[] r18 = ((String) r17).split(",");
        if (r18.length != 4) goto L23;
        int r20 = Integer.parseInt(r18[0]);
        int r21 = Integer.parseInt(r18[1]);
        int r22 = Integer.parseInt(r18[2]);
        int r23 = (int) ((r20 / 1080.0f) * r12);
        int r24 = (int) ((r21 / 1920.0f) * r13);
        int r25 = (int) ((Integer.parseInt(r18[3]) / 1920.0f) * r13);
        Paint r110 = new Paint();
        r110.setColor(-65536);
        float r111 = r23;
        float r112 = r24;
        float r26 = r23 + ((int) ((r22 / 1080.0f) * r12));
        r19.drawLine(r111, r112, r26, r112, r110);
        float r27 = r24 + r25;
        r19.drawLine(r26, r112, r26, r27, r110);
        r19.drawLine(r26, r27, r111, r27, r110);
        r19.drawLine(r111, r27, r111, r112, r110);
        r110.setColor(-16711936);
        r19.drawLine(r111, r112, r26, r27, r110);
        r19.drawLine(r111, r27, r26, r112, r110);
    L23:
        r15 = r15 + 1;
        goto L12
    L32:
        return;
    }

    @Override // android.view.View
    public final void forceLayout() {
        this.f1350r = true;
        super.forceLayout();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r8) {
        return new a(getContext(), r8);
    }

    public int getMaxHeight() {
        return this.f1349q;
    }

    public int getMaxWidth() {
        return this.f1348p;
    }

    public int getMinHeight() {
        return this.f1347o;
    }

    public int getMinWidth() {
        return this.f1346n;
    }

    public int getOptimizationLevel() {
        return this.f1345m.F0;
    }

    public String getSceneString() {
        StringBuilder r8 = new StringBuilder();
        s.f r10 = this.f1345m;
        if (r10.f11867k != null) goto L10;
        int r11 = getId();
        if (r11 == (-1)) goto L7;
        String r12 = getContext().getResources().getResourceEntryName(r11);
    L8:
        r10.f11867k = r12;
        goto L10
    L7:
        r12 = "parent";
    L10:
        if (r10.f11868k0 != null) goto L12;
        r10.f11868k0 = r10.f11867k;
        Log.v("ConstraintLayout", " setDebugName " + r10.f11868k0);
    L12:
        Iterator<s.e> r13 = r10.f11940s0.iterator();
    L14:
        if (r13.hasNext() == false) goto L25;
        s.e r14 = r13.next();
        View r15 = (View) r14.f11864i0;
        if (r15 == null) goto L14;
        if (r14.f11867k != null) goto L23;
        int r16 = r15.getId();
        if (r16 == (-1)) goto L23;
        r14.f11867k = getContext().getResources().getResourceEntryName(r16);
    L23:
        if (r14.f11868k0 != null) goto L14;
        r14.f11868k0 = r14.f11867k;
        Log.v("ConstraintLayout", " setDebugName " + r14.f11868k0);
        goto L14
    L25:
        r10.n(r8);
        return r8.toString();
    }

    public final void h(AttributeSet r8, int r10) {
        s.f r11 = this.f1345m;
        r11.f11864i0 = this;
        b r12 = this.f1357y;
        r11.f11899w0 = r12;
        r11.f11897u0.f12156f = r12;
        this.f1343a.put(getId(), this);
        this.f1352t = null;
        if (r8 == null) goto L37;
        TypedArray r13 = getContext().obtainStyledAttributes(r8, v.d.f12656b, r10, 0);
        int r14 = r13.getIndexCount();
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L36;
        int r16 = r13.getIndex(r15);
        if (r16 != 16) goto L10;
        this.f1346n = r13.getDimensionPixelOffset(r16, this.f1346n);
    L35:
        r15 = r15 + 1;
        goto L5
    L10:
        if (r16 != 17) goto L13;
        this.f1347o = r13.getDimensionPixelOffset(r16, this.f1347o);
        goto L35
    L13:
        if (r16 != 14) goto L16;
        this.f1348p = r13.getDimensionPixelOffset(r16, this.f1348p);
        goto L35
    L16:
        if (r16 != 15) goto L19;
        this.f1349q = r13.getDimensionPixelOffset(r16, this.f1349q);
        goto L35
    L19:
        if (r16 != 113) goto L22;
        this.f1351s = r13.getInt(r16, this.f1351s);
        goto L35
    L22:
        if (r16 != 56) goto L29;
        int r17 = r13.getResourceId(r16, 0);
        if (r17 == 0) goto L35;
        p(r17);     // Catch: Resources.NotFoundException -> L27
    L27:
        this.f1353u = null;
        goto L35
    L29:
        if (r16 != 34) goto L35;
        int r18 = r13.getResourceId(r16, 0);
        d r19 = new d();     // Catch: Resources.NotFoundException -> L33
        this.f1352t = r19;     // Catch: Resources.NotFoundException -> L33
        r19.f(getContext(), r18);     // Catch: Resources.NotFoundException -> L33
    L34:
        this.f1354v = r18;
    L33:
        this.f1352t = null;
        goto L34
    L36:
        r13.recycle();
    L37:
        r11.F0 = this.f1351s;
        p.d.f9870q = r11.V(512);
    }

    public final boolean l() {
        if ((getContext().getApplicationInfo().flags & 4194304) == 0) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == true) goto L8;
        return false;
    L8:
        if (1 == getLayoutDirection()) goto L10;
        return false;
    L10:
        return true;
    L5:
        r8 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        int r14 = getChildCount();
        boolean r15 = isInEditMode();
        int r16 = 0;
        int r17 = 0;
    L3:
        if (r17 >= r14) goto L21;
        View r18 = getChildAt(r17);
        a r19 = (a) r18.getLayoutParams();
        s.e r20 = r19.f1390q0;
        if (r18.getVisibility() != 8) goto L13;
        if (r19.d0 == true) goto L13;
        if (r19.f1366e0 == true) goto L13;
        if (r15 == true) goto L13;
    L20:
        r17 = r17 + 1;
    L13:
        if (r19.f1368f0 == true) goto L20;
        int r21 = r20.r();
        int r22 = r20.s();
        int r23 = r20.q() + r21;
        int r24 = r20.l() + r22;
        r18.layout(r21, r22, r23, r24);
        if ((r18 instanceof f) == false) goto L20;
        View r110 = ((f) r18).getContent();
        if (r110 == null) goto L20;
        r110.setVisibility(0);
        r110.layout(r21, r22, r23, r24);
        goto L20
    L21:
        ArrayList<c> r25 = this.f1344b;
        int r26 = r25.size();
        if (r26 <= 0) goto L25;
    L23:
        if (r16 >= r26) goto L33;
        r25.get(r16).getClass();
        r16 = r16 + 1;
        goto L23
    L33:
        return;
    }

    @Override // android.view.View
    public void onMeasure(int r27, int r28) {
        boolean r8 = this.f1350r | false;
        this.f1350r = r8;
        if (r8 == true) goto L10;
        int r10 = getChildCount();
        int r11 = 0;
    L5:
        if (r11 >= r10) goto L10;
        if (getChildAt(r11).isLayoutRequested() == true) goto L8;
        r11 = r11 + 1;
        goto L5
    L8:
        this.f1350r = true;
    L10:
        boolean r12 = l();
        s.f r13 = this.f1345m;
        r13.f11900x0 = r12;
        boolean r14 = this.f1350r;
        t.b r15 = r13.f11896t0;
        if (r14 == false) goto L15;
        this.f1350r = false;
        if (r() == false) goto L15;
        r15.c(r13);
    L15:
        r13.f11901y0.getClass();
        int r16 = this.f1351s;
        int r17 = View.MeasureSpec.getMode(r27);
        int r18 = View.MeasureSpec.getSize(r27);
        int r19 = View.MeasureSpec.getMode(r28);
        int r110 = View.MeasureSpec.getSize(r28);
        int r111 = Math.max(0, getPaddingTop());
        int r112 = Math.max(0, getPaddingBottom());
        int r113 = r111 + r112;
        int r114 = getPaddingWidth();
        b r20 = this.f1357y;
        r20.f1402b = r111;
        r20.f1403c = r112;
        r20.f1404d = r114;
        r20.f1405e = r113;
        r20.f1406f = r27;
        r20.f1407g = r28;
        int r115 = Math.max(0, getPaddingStart());
        int r21 = Math.max(0, getPaddingEnd());
        if (r115 > 0) goto L21;
        if (r21 > 0) goto L21;
        r115 = Math.max(0, getPaddingLeft());
    L23:
        int r22 = r18 - r114;
        int r116 = r110 - r113;
        int r23 = r20.f1405e;
        int r117 = r20.f1404d;
        s.e.a r118 = s.e.a.f11891a;
        int r119 = getChildCount();
        if (r17 == Integer.MIN_VALUE) goto L33;
        if (r17 == 0) goto L29;
        if (r17 == 1073741824) goto L28;
        s.e.a r120 = r118;
    L32:
        int r24 = Integer.MIN_VALUE;
        int r25 = 0;
    L37:
        if (r19 == r24) goto L47;
        if (r19 != 0) goto L40;
        s.e.a r26 = s.e.a.f11892b;
        if (r119 == 0) goto L49;
    L46:
        r20 = r20;
        int r121 = r116;
        int r29 = 0;
    L52:
        int r122 = r13.q();
        t.e r30 = r13.f11897u0;
        if (r25 == r122) goto L55;
    L56:
        r30.f12153c = true;
    L57:
        r13.f11851b0 = 0;
        r13.f11853c0 = 0;
        int r123 = this.f1348p - r117;
        int[] r31 = r13.D;
        r31[0] = r123;
        r31[1] = this.f1349q - r23;
        r13.f11856e0 = 0;
        r13.f11858f0 = 0;
        r13.L(r120);
        r13.N(r25);
        r13.M(r26);
        r13.K(r29);
        int r32 = this.f1346n - r117;
        if (r32 >= 0) goto L60;
        r32 = 0;
    L60:
        r13.f11856e0 = r32;
        int r33 = this.f1347o - r23;
        if (r33 >= 0) goto L63;
        r33 = 0;
    L63:
        r13.f11858f0 = r33;
        r13.f11902z0 = r115;
        r13.A0 = r111;
        r15.getClass();
        t.b.InterfaceC0157b r34 = r13.f11899w0;
        int r35 = r13.f11940s0.size();
        int r36 = r13.q();
        int r37 = r13.l();
        boolean r124 = k.b(r16, 128);
        if (r124 == false) goto L66;
    L69:
        boolean r38 = true;
    L70:
        if (r38 == false) goto L106;
        int r125 = 0;
    L72:
        if (r125 >= r35) goto L106;
        s.e r126 = r13.f11940s0.get(r125);
        s.e.a[] r127 = r126.V;
        s.e.a r128 = r127[0];
        s.e.a r129 = s.e.a.f11893m;
        if (r128 != r129) goto L76;
        boolean r130 = true;
    L78:
        if (r127[1] != r129) goto L80;
        boolean r131 = true;
    L81:
        if (r130 == false) goto L86;
        if (r131 == false) goto L86;
        if (r126.Z <= 0.0f) goto L86;
        boolean r132 = true;
    L88:
        if (r126.x() == false) goto L92;
        if (r132 == false) goto L92;
    L104:
        r38 = false;
    L92:
        if (r126.y() == false) goto L96;
        if (r132 == true) goto L104;
    L96:
        if ((r126 instanceof l) == true) goto L104;
        if (r126.x() == true) goto L104;
        if (r126.y() == true) goto L104;
        r125 = r125 + 1;
    L86:
        r132 = false;
        goto L88
    L80:
        r131 = false;
        goto L81
    L76:
        r130 = false;
    L106:
        if (r17 != 1073741824) goto L108;
        if (r19 != 1073741824) goto L108;
    L109:
        boolean r133 = true;
    L111:
        boolean r39 = r38 & r133;
        if (r39 == false) goto L228;
        int r134 = Math.min(r31[0], r22);
        int r40 = Math.min(r31[1], r121);
        if (r17 == 1073741824) goto L116;
    L118:
        t.e r135 = r30;
    L119:
        if (r19 == 1073741824) goto L121;
    L123:
        if (r17 != 1073741824) goto L206;
        if (r19 != 1073741824) goto L206;
        boolean r41 = r124 & true;
        boolean r136 = r135.f12152b;
        s.f r137 = r135.f12151a;
        if (r136 == false) goto L128;
    L131:
        Iterator<s.e> r138 = r137.f11940s0.iterator();
    L133:
        if (r138.hasNext() == false) goto L135;
        s.e r139 = r138.next();
        r139.i();
        r139.f11848a = false;
        r139.f11854d.n();
        r139.f11855e.m();
        goto L133
    L135:
        r137.i();
        int r140 = 0;
        r137.f11848a = false;
        r137.f11854d.n();
        r137.f11855e.m();
        r135.f12153c = false;
    L136:
        r135.b(r135.f12154d);
        r137.f11851b0 = r140;
        r137.f11853c0 = r140;
        s.e.a r141 = r137.k(r140);
        s.e.a r142 = r137.k(1);
        if (r135.f12152b == false) goto L139;
        r135.c();
    L139:
        int r143 = r137.r();
        int r42 = r137.s();
        boolean r210 = r39;
        r137.f11854d.f12200h.d(r143);
        r137.f11855e.f12200h.d(r42);
        r135.g();
        s.e.a r43 = s.e.a.f11892b;
        t.b.InterfaceC0157b r211 = r34;
        ArrayList<p> r44 = r135.f12155e;
        if (r141 == r43) goto L144;
        if (r142 == r43) goto L144;
        r36 = r36;
    L160:
        s.e.a[] r45 = r137.V;
        s.e.a r46 = r45[0];
        s.e.a r47 = s.e.a.f11891a;
        int r212 = r37;
        if (r46 != r47) goto L163;
    L166:
        int r48 = r137.q() + r143;
        r137.f11854d.f12201i.d(r48);
        r137.f11854d.f12197e.d(r48 - r143);
        r135.g();
        s.e.a r49 = r45[1];
        if (r49 != r47) goto L169;
    L170:
        int r50 = r137.l() + r42;
        r137.f11855e.f12201i.d(r50);
        r137.f11855e.f12197e.d(r50 - r42);
    L171:
        r135.g();
        boolean r51 = true;
    L172:
        Iterator<p> r52 = r44.iterator();
    L174:
        if (r52.hasNext() == false) goto L181;
        p r53 = r52.next();
        if (r53.f12194b != r137) goto L180;
        if (r53.f12199g == false) goto L174;
    L180:
        r53.e();
        goto L174
    L181:
        Iterator<p> r54 = r44.iterator();
    L183:
        if (r54.hasNext() == false) goto L204;
        p r55 = r54.next();
        if (r51 == true) goto L190;
        if (r55.f12194b == r137) goto L183;
    L190:
        if (r55.f12200h.f12168j == false) goto L203;
        if (r55.f12201i.f12168j == true) goto L198;
        if ((r55 instanceof j) == false) goto L203;
    L198:
        if (r55.f12197e.f12168j == true) goto L183;
        if ((r55 instanceof t.c) == true) goto L183;
        if ((r55 instanceof j) == true) goto L183;
    L203:
        boolean r56 = false;
    L205:
        r137.L(r141);
        r137.M(r142);
        boolean r57 = r56;
        int r58 = 1073741824;
        int r59 = 2;
    L220:
        if (r57 == false) goto L229;
        if (r17 != r58) goto L223;
        boolean r60 = true;
    L224:
        if (r19 != r58) goto L226;
        boolean r61 = true;
    L227:
        r13.O(r60, r61);
        goto L229
    L226:
        r61 = false;
        goto L227
    L223:
        r60 = false;
    L229:
        if (r57 == true) goto L231;
    L232:
        int r62 = r13.F0;
        if (r35 <= 0) goto L313;
        int r63 = r13.f11940s0.size();
        boolean r64 = r13.V(64);
        t.b.InterfaceC0157b r65 = r13.f11899w0;
        int r66 = 0;
    L235:
        if (r66 >= r63) goto L293;
        s.e r67 = r13.f11940s0.get(r66);
        if ((r67 instanceof h) == true) goto L292;
        if ((r67 instanceof s.a) == true) goto L292;
        if (r67.H == true) goto L292;
        if (r64 == false) goto L255;
        t.l r144 = r67.f11854d;
        if (r144 == null) goto L255;
        n r145 = r67.f11855e;
        if (r145 == null) goto L255;
        if (r144.f12197e.f12168j == false) goto L255;
        if (r145.f12197e.f12168j == true) goto L292;
    L255:
        s.e.a r146 = r67.k(0);
        s.e.a r147 = r67.k(1);
        s.e.a r148 = s.e.a.f11893m;
        if (r146 == r148) goto L258;
    L263:
        boolean r149 = false;
    L264:
        if (r149 == true) goto L289;
        if (r13.V(1) == false) goto L289;
        if ((r67 instanceof l) == true) goto L289;
        if (r146 == r148) goto L271;
    L276:
        if (r147 == r148) goto L278;
    L283:
        if (r146 == r148) goto L286;
        if (r147 != r148) goto L289;
    L286:
        if (r67.Z <= 0.0f) goto L289;
        r149 = true;
        goto L289
    L278:
        if (r67.f11884t != 0) goto L283;
        if (r146 == r148) goto L283;
        if (r67.x() == true) goto L283;
        r149 = true;
        goto L283
    L271:
        if (r67.f11883s != 0) goto L276;
        if (r147 == r148) goto L276;
        if (r67.x() == true) goto L276;
        r149 = true;
    L289:
        if (r149 == true) goto L292;
        r15.a(0, r67, r65);
        goto L292
    L258:
        if (r67.f11883s == 1) goto L263;
        if (r147 != r148) goto L263;
        if (r67.f11884t == 1) goto L263;
        r149 = true;
    L292:
        r66 = r66 + 1;
        goto L235
    L293:
        ConstraintLayout r68 = ((b) r65).f1401a;
        int r69 = r68.getChildCount();
        int r70 = 0;
    L294:
        if (r70 >= r69) goto L308;
        View r71 = r68.getChildAt(r70);
        if ((r71 instanceof f) == false) goto L307;
        f r72 = (f) r71;
        if (r72.f1542b == null) goto L307;
        a r73 = (a) r72.getLayoutParams();
        a r74 = (a) r72.f1542b.getLayoutParams();
        s.e r150 = r74.f1390q0;
        r150.f11866j0 = 0;
        s.e r151 = r73.f1390q0;
        s.e.a r152 = r151.V[0];
        s.e.a r153 = s.e.a.f11891a;
        if (r152 == r153) goto L303;
        r151.N(r150.q());
    L303:
        s.e r75 = r73.f1390q0;
        if (r75.V[1] == r153) goto L306;
        r75.K(r74.f1390q0.l());
    L306:
        r74.f1390q0.f11866j0 = 8;
    L307:
        r70 = r70 + 1;
        goto L294
    L308:
        ArrayList<c> r76 = r68.f1344b;
        int r77 = r76.size();
        if (r77 <= 0) goto L313;
        int r78 = 0;
    L311:
        if (r78 >= r77) goto L313;
        r76.get(r78).getClass();
        r78 = r78 + 1;
    L313:
        r15.c(r13);
        ArrayList<s.e> r79 = r15.f12136a;
        int r80 = r79.size();
        if (r35 <= 0) goto L316;
        int r81 = r36;
        int r82 = r212;
        char r83 = 0;
        r15.b(r13, 0, r81, r82);
    L317:
        if (r80 <= 0) goto L398;
        s.e.a[] r84 = r13.V;
        s.e.a r154 = r84[r83];
        s.e.a r85 = s.e.a.f11892b;
        if (r154 != r85) goto L321;
        char r155 = 1;
        boolean r156 = true;
    L323:
        if (r84[r155] != r85) goto L325;
        boolean r86 = true;
    L326:
        int r87 = r13.q();
        s.f r157 = r15.f12138c;
        int r88 = Math.max(r87, r157.f11856e0);
        int r158 = Math.max(r13.l(), r157.f11858f0);
        int r159 = 0;
        boolean r160 = false;
    L327:
        if (r159 >= r80) goto L348;
        s.e r161 = r79.get(r159);
        if ((r161 instanceof l) == true) goto L331;
        t.b.InterfaceC0157b r89 = r211;
    L347:
        r159 = r159 + 1;
        r81 = r81;
        r211 = r89;
        r62 = r62;
        goto L327
    L331:
        int r162 = r161.q();
        int r90 = r161.l();
        r89 = r211;
        boolean r91 = r160 | r15.a(1, r161, r89);
        int r163 = r161.q();
        boolean r213 = r91;
        int r92 = r161.l();
        if (r163 == r162) goto L339;
        r161.N(r163);
        if (r156 == true) goto L336;
    L338:
        r213 = true;
        goto L339
    L336:
        if ((r161.r() + r161.X) <= r88) goto L338;
        r88 = Math.max(r88, r161.j(s.d.a.f11841m).e() + (r161.r() + r161.X));
    L339:
        if (r92 == r90) goto L346;
        r161.K(r92);
        if (r86 == true) goto L343;
    L345:
        r213 = true;
        goto L346
    L343:
        if ((r161.s() + r161.Y) <= r158) goto L345;
        r158 = Math.max(r158, r161.j(s.d.a.f11842n).e() + (r161.s() + r161.Y));
    L346:
        r160 = ((l) r161).A0 | r213;
        goto L347
    L348:
        int r214 = r62;
        t.b.InterfaceC0157b r93 = r211;
        int r215 = r81;
        int r94 = 0;
        int r95 = 2;
    L349:
        if (r94 >= r95) goto L399;
        boolean r164 = r160;
        int r165 = 0;
    L351:
        if (r165 >= r80) goto L395;
        s.e r166 = r79.get(r165);
        if ((r166 instanceof i) == false) goto L357;
        if ((r166 instanceof l) == true) goto L357;
    L370:
        t.b.InterfaceC0157b r216 = r93;
        ArrayList<s.e> r217 = r79;
        int r218 = r80;
    L394:
        r165 = r165 + 1;
        r79 = r217;
        r80 = r218;
        r93 = r216;
    L357:
        if ((r166 instanceof h) == true) goto L370;
        if (r166.f11866j0 == 8) goto L370;
        if (r210 == false) goto L369;
        if (r166.f11854d.f12197e.f12168j == false) goto L369;
        if (r166.f11855e.f12197e.f12168j == true) goto L370;
    L369:
        if ((r166 instanceof l) == true) goto L370;
        int r167 = r166.q();
        int r96 = r166.l();
        r217 = r79;
        int r97 = r166.d0;
        r218 = r80;
        int r98 = 1;
        if (r94 != 1) goto L374;
        r98 = 2;
    L374:
        r164 = r164 | r15.a(r98, r166, r93);
        int r99 = r166.q();
        r216 = r93;
        int r100 = r166.l();
        if (r99 == r167) goto L382;
        r166.N(r99);
        if (r156 == true) goto L379;
    L381:
        r164 = true;
        goto L382
    L379:
        if ((r166.r() + r166.X) <= r88) goto L381;
        r88 = Math.max(r88, r166.j(s.d.a.f11841m).e() + (r166.r() + r166.X));
    L382:
        if (r100 == r96) goto L390;
        r166.K(r100);
        if (r86 == true) goto L386;
    L388:
        r164 = true;
        goto L390
    L386:
        if ((r166.s() + r166.Y) <= r158) goto L388;
        r158 = Math.max(r158, r166.j(s.d.a.f11842n).e() + (r166.s() + r166.Y));
    L390:
        if (r166.F == false) goto L394;
        if (r97 == r166.d0) goto L394;
        r164 = true;
        goto L394
    L395:
        t.b.InterfaceC0157b r219 = r93;
        ArrayList<s.e> r220 = r79;
        int r221 = r80;
        if (r164 == false) goto L399;
        r94 = r94 + 1;
        r15.b(r13, r94, r215, r82);
        r79 = r220;
        r80 = r221;
        r93 = r219;
        r95 = 2;
        r160 = false;
    L399:
        r13.F0 = r214;
        p.d.f9870q = r13.V(512);
    L400:
        int r101 = r13.q();
        int r102 = r13.l();
        boolean r103 = r13.G0;
        boolean r104 = r13.H0;
        b r105 = r20;
        int r106 = r105.f1405e;
        int r107 = ViewGroup.resolveSizeAndState(r101 + r105.f1404d, r27, 0);
        int r108 = ViewGroup.resolveSizeAndState(r102 + r106, r28, 0) & 16777215;
        int r109 = Math.min(this.f1348p, r107 & 16777215);
        int r168 = Math.min(this.f1349q, r108);
        if (r103 == false) goto L403;
        r109 = r109 | 16777216;
    L403:
        if (r104 == false) goto L405;
        r168 = r168 | 16777216;
    L405:
        setMeasuredDimension(r109, r168);
        return;
    L325:
        r86 = false;
        goto L326
    L321:
        r155 = 1;
        r156 = false;
        goto L323
    L398:
        r214 = r62;
        goto L399
    L316:
        r81 = r36;
        r82 = r212;
        r83 = 0;
        goto L317
    L231:
        if (r59 == 2) goto L400;
    L204:
        r56 = true;
        goto L205
    L169:
        if (r49 != s.e.a.f11894n) goto L171;
    L163:
        if (r46 == s.e.a.f11894n) goto L166;
        r51 = false;
    L144:
        if (r41 == false) goto L151;
        Iterator<p> r169 = r44.iterator();
    L147:
        if (r169.hasNext() == false) goto L151;
        if (r169.next().k() == true) goto L147;
        r41 = false;
    L151:
        if (r41 == false) goto L156;
        if (r141 != s.e.a.f11892b) goto L156;
        r137.L(s.e.a.f11891a);
        r137.N(r135.d(r137, 0));
        r137.f11854d.f12197e.d(r137.q());
    L156:
        if (r41 == false) goto L160;
        if (r142 != s.e.a.f11892b) goto L160;
        r137.M(s.e.a.f11891a);
        r137.K(r135.d(r137, 1));
        r137.f11855e.f12197e.d(r137.l());
        goto L160
    L128:
        if (r135.f12153c == true) goto L131;
        r140 = 0;
    L206:
        r211 = r34;
        r210 = r39;
        r36 = r36;
        r212 = r37;
        boolean r170 = r135.f12152b;
        s.f r171 = r135.f12151a;
        if (r170 == false) goto L213;
        Iterator<s.e> r172 = r171.f11940s0.iterator();
    L210:
        if (r172.hasNext() == false) goto L212;
        s.e r173 = r172.next();
        r173.i();
        r173.f11848a = false;
        t.l r174 = r173.f11854d;
        r174.f12197e.f12168j = false;
        r174.f12199g = false;
        r174.n();
        n r175 = r173.f11855e;
        r175.f12197e.f12168j = false;
        r175.f12199g = false;
        r175.m();
        goto L210
    L212:
        int r176 = 0;
        r171.i();
        r171.f11848a = false;
        t.l r177 = r171.f11854d;
        r177.f12197e.f12168j = false;
        r177.f12199g = false;
        r177.n();
        n r178 = r171.f11855e;
        r178.f12197e.f12168j = false;
        r178.f12199g = false;
        r178.m();
        r135.c();
    L214:
        r135.b(r135.f12154d);
        r171.f11851b0 = r176;
        r171.f11853c0 = r176;
        r171.f11854d.f12200h.d(r176);
        r171.f11855e.f12200h.d(r176);
        r58 = 1073741824;
        if (r17 != 1073741824) goto L217;
        int r179 = 1;
        boolean r180 = r13.T(r176, r124) & true;
        r59 = 1;
        r57 = r180;
    L218:
        if (r19 != 1073741824) goto L220;
        r57 = r57 & r13.T(r179, r124);
        r59 = r59 + 1;
        goto L220
    L217:
        r179 = 1;
        r57 = true;
        r59 = 0;
        goto L218
    L213:
        r176 = 0;
        goto L214
    L121:
        if (r13.l() == r40) goto L123;
        r13.K(r40);
        r135.f12152b = true;
        goto L123
    L116:
        if (r13.q() == r134) goto L118;
        r13.N(r134);
        r135 = r30;
        r135.f12152b = true;
        goto L119
    L228:
        r211 = r34;
        r210 = r39;
        r36 = r36;
        r212 = r37;
        r57 = false;
        r59 = 0;
    L108:
        if (r124 == true) goto L109;
        r133 = false;
        goto L111
    L66:
        if (k.b(r16, 64) == true) goto L69;
        r38 = false;
        goto L70
    L55:
        if (r29 == r13.l()) goto L57;
    L49:
        s.e.a r181 = r26;
        int r182 = Math.max(0, this.f1347o);
    L50:
        r29 = r182;
        r26 = r181;
        r121 = r116;
        goto L52
    L40:
        if (r19 == 1073741824) goto L42;
        r26 = r118;
        goto L46
    L42:
        r182 = Math.min(this.f1349q - r23, r116);
        r181 = r118;
        goto L50
    L47:
        r26 = s.e.a.f11892b;
        if (r119 == 0) goto L49;
        r20 = r20;
        r29 = r116;
        r121 = r29;
        goto L52
    L28:
        r24 = Integer.MIN_VALUE;
        r25 = Math.min(this.f1348p - r117, r22);
        r120 = r118;
        goto L37
    L29:
        r120 = s.e.a.f11892b;
        if (r119 != 0) goto L32;
    L35:
        r25 = Math.max(0, this.f1346n);
        r120 = r120;
        r24 = Integer.MIN_VALUE;
        goto L37
    L33:
        r120 = s.e.a.f11892b;
        if (r119 == 0) goto L35;
        r24 = Integer.MIN_VALUE;
        r25 = r22;
    L21:
        if (l() == false) goto L23;
        r115 = r21;
        goto L23
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r8) {
        super.onViewAdded(r8);
        s.e r10 = b(r8);
        if ((r8 instanceof Guideline) == false) goto L8;
        if ((r10 instanceof h) == true) goto L8;
        a r11 = (a) r8.getLayoutParams();
        h r12 = new h();
        r11.f1390q0 = r12;
        r11.d0 = true;
        r12.Q(r11.V);
    L8:
        if ((r8 instanceof c) == false) goto L12;
        c r13 = (c) r8;
        r13.k();
        ((a) r8.getLayoutParams()).f1366e0 = true;
        ArrayList<c> r14 = this.f1344b;
        if (r14.contains(r13) == true) goto L12;
        r14.add(r13);
    L12:
        int r15 = r8.getId();
        this.f1343a.put(r15, r8);
        this.f1350r = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r8) {
        super.onViewRemoved(r8);
        int r10 = r8.getId();
        this.f1343a.remove(r10);
        s.e r11 = b(r8);
        this.f1345m.f11940s0.remove(r11);
        r11.C();
        this.f1344b.remove(r8);
        this.f1350r = true;
    }

    public void p(int r8) {
        this.f1353u = new v.a(getContext(), this, r8);
    }

    public final void q(String r8, Integer r10) {
        if ((r8 instanceof String) == true) goto L5;
        return;
    L5:
        if ((r10 instanceof Integer) == true) goto L7;
        return;
    L7:
        if (this.f1355w != null) goto L9;
        this.f1355w = new HashMap();
    L9:
        int r11 = r8.indexOf("/");
        if (r11 == (-1)) goto L12;
        r8 = r8.substring(r11 + 1);
    L12:
        int r12 = r10.intValue();
        this.f1355w.put(r8, Integer.valueOf(r12));
    }

    public final boolean r() {
        ConstraintLayout r8 = this;
        int r10 = getChildCount();
        int r11 = 0;
        int r12 = 0;
    L3:
        int r13 = 1;
        if (r12 >= r10) goto L9;
        if (r8.getChildAt(r12).isLayoutRequested() == true) goto L7;
        r12 = r12 + 1;
        goto L3
    L7:
        boolean r14 = true;
    L10:
        if (r14 == false) goto L310;
        boolean r15 = isInEditMode();
        int r16 = getChildCount();
        int r17 = 0;
    L12:
        if (r17 >= r16) goto L18;
        s.e r18 = r8.b(r8.getChildAt(r17));
        if (r18 == null) goto L17;
        r18.C();
    L17:
        r17 = r17 + 1;
        goto L12
    L18:
        Object r19 = null;
        SparseArray<View> r20 = r8.f1343a;
        s.f r21 = r8.f1345m;
        if (r15 == false) goto L45;
        int r110 = 0;
    L21:
        if (r110 >= r16) goto L45;
        View r111 = r8.getChildAt(r110);
        String r112 = getResources().getResourceName(r111.getId());     // Catch: Resources.NotFoundException -> L311
        r8.q(r112, Integer.valueOf(r111.getId()));     // Catch: Resources.NotFoundException -> L311
        int r113 = r112.indexOf(47);     // Catch: Resources.NotFoundException -> L311
        if (r113 == (-1)) goto L26;
        r112 = r112.substring(r113 + 1);     // Catch: Resources.NotFoundException -> L311
    L26:
        int r114 = r111.getId();     // Catch: Resources.NotFoundException -> L311
        if (r114 == 0) goto L38;
        View r115 = r20.get(r114);     // Catch: Resources.NotFoundException -> L311
        if (r115 != null) goto L37;
        r115 = r8.findViewById(r114);     // Catch: Resources.NotFoundException -> L311
        if (r115 == null) goto L37;
        if (r115 == r8) goto L37;
        if (r115.getParent() != r8) goto L37;
        r8.onViewAdded(r115);     // Catch: Resources.NotFoundException -> L311
    L37:
        if (r115 == r8) goto L38;
        if (r115 != null) goto L41;
        s.e r116 = null;
    L42:
        r116.f11868k0 = r112;     // Catch: Resources.NotFoundException -> L311
        goto L43
    L41:
        r116 = ((a) r115.getLayoutParams()).f1390q0;     // Catch: Resources.NotFoundException -> L311
    L38:
        r116 = r21;
    L43:
        r110 = r110 + 1;
    L45:
        if (r8.f1354v == (-1)) goto L54;
        int r117 = 0;
    L47:
        if (r117 >= r16) goto L54;
        View r118 = r8.getChildAt(r117);
        if (r118.getId() != r8.f1354v) goto L53;
        if ((r118 instanceof e) == false) goto L53;
        r8.f1352t = ((e) r118).getConstraintSet();
    L53:
        r117 = r117 + 1;
    L54:
        d r119 = r8.f1352t;
        if (r119 == null) goto L57;
        r119.b(r8);
    L57:
        r21.f11940s0.clear();
        ArrayList<c> r120 = r8.f1344b;
        int r121 = r120.size();
        if (r121 <= 0) goto L88;
        int r122 = 0;
    L60:
        if (r122 >= r121) goto L88;
        c r123 = r120.get(r122);
        if (r123.isInEditMode() == false) goto L64;
        r123.setIds(r123.f1434o);
    L64:
        s.j r124 = r123.f1433n;
        if (r124 == null) goto L87;
        r124.f11932t0 = r11;
        Arrays.fill(r124.f11931s0, r19);
        int r125 = r11;
    L69:
        if (r125 >= r123.f1431b) goto L86;
        int r22 = r123.f1430a[r125];
        View r126 = r20.get(r22);
        if (r126 != null) goto L75;
        Integer r23 = Integer.valueOf(r22);
        HashMap<Integer, String> r24 = r123.f1437r;
        String r25 = r24.get(r23);
        int r26 = r123.h(r8, r25);
        if (r26 == 0) goto L75;
        r123.f1430a[r125] = r26;
        r24.put(Integer.valueOf(r26), r25);
        r126 = r20.get(r26);
    L75:
        View r27 = r126;
        if (r27 == null) goto L85;
        s.j r28 = r123.f1433n;
        s.e r29 = r8.b(r27);
        r28.getClass();
        if (r29 == r28) goto L85;
        if (r29 == null) goto L85;
        int r30 = r28.f11932t0 + r13;
        s.e[] r127 = r28.f11931s0;
        if (r30 <= r127.length) goto L84;
        r28.f11931s0 = (s.e[]) Arrays.copyOf(r127, r127.length * 2);
    L84:
        s.e[] r31 = r28.f11931s0;
        int r32 = r28.f11932t0;
        r31[r32] = r29;
        r28.f11932t0 = r32 + 1;
    L85:
        r125 = r125 + 1;
        r13 = 1;
        goto L69
    L86:
        r123.f1433n.a();
    L87:
        r122 = r122 + 1;
        r11 = 0;
        r13 = 1;
        r19 = null;
    L88:
        int r33 = 0;
    L89:
        if (r33 >= r16) goto L102;
        View r34 = r8.getChildAt(r33);
        if ((r34 instanceof f) == false) goto L101;
        f r35 = (f) r34;
        if (r35.f1541a == (-1)) goto L95;
    L97:
        View r36 = r8.findViewById(r35.f1541a);
        r35.f1542b = r36;
        if (r36 == null) goto L101;
        ((a) r36.getLayoutParams()).f1368f0 = true;
        r35.f1542b.setVisibility(0);
        r35.setVisibility(0);
        goto L101
    L95:
        if (r35.isInEditMode() == true) goto L97;
        r35.setVisibility(r35.f1543m);
    L101:
        r33 = r33 + 1;
        goto L89
    L102:
        SparseArray<s.e> r37 = r8.f1356x;
        r37.clear();
        r37.put(0, r21);
        r37.put(getId(), r21);
        int r38 = 0;
    L103:
        if (r38 >= r16) goto L105;
        View r39 = r8.getChildAt(r38);
        r37.put(r39.getId(), r8.b(r39));
        r38 = r38 + 1;
        goto L103
    L105:
        int r40 = 0;
    L106:
        if (r40 >= r16) goto L310;
        View r41 = r8.getChildAt(r40);
        s.e r42 = r8.b(r41);
        if (r42 == null) goto L132;
        a r128 = (a) r41.getLayoutParams();
        r21.f11940s0.add(r42);
        s.e r129 = r42.W;
        if (r129 == null) goto L113;
        ((m) r129).f11940s0.remove(r42);
        r42.C();
    L113:
        r42.W = r21;
        r128.a();
        r42.f11866j0 = r41.getVisibility();
        if (r128.f1368f0 == false) goto L116;
        r42.G = true;
        r42.f11866j0 = 8;
    L116:
        r42.f11864i0 = r41;
        if ((r41 instanceof c) == false) goto L120;
        ((c) r41).j(r42, r21.f11900x0);
    L120:
        if (r128.d0 == false) goto L133;
        h r43 = (h) r42;
        int r44 = r128.f1384n0;
        int r130 = r128.f1386o0;
        float r131 = r128.f1388p0;
        if (r131 == (-1.0f)) goto L126;
        if (r131 <= (-1.0f)) goto L132;
        r43.f11925s0 = r131;
        r43.f11926t0 = -1;
        r43.f11927u0 = -1;
        goto L132
    L126:
        if (r44 == (-1)) goto L129;
        if (r44 <= (-1)) goto L132;
        r43.f11925s0 = -1.0f;
        r43.f11926t0 = r44;
        r43.f11927u0 = -1;
        goto L132
    L129:
        if (r130 == (-1)) goto L132;
        if (r130 <= (-1)) goto L132;
        r43.f11925s0 = -1.0f;
        r43.f11926t0 = -1;
        r43.f11927u0 = r130;
        goto L132
    L133:
        int r45 = r128.f1370g0;
        int r132 = r128.f1372h0;
        int r133 = r128.f1374i0;
        int r134 = r128.f1376j0;
        int r135 = r128.f1378k0;
        int r136 = r128.f1380l0;
        float r46 = r128.f1382m0;
        int r137 = r16;
        int r47 = r128.f1387p;
        s.f r138 = r21;
        int r48 = -1;
        if (r47 == (-1)) goto L140;
        s.e r139 = r37.get(r47);
        if (r139 == null) goto L139;
        float r49 = r128.f1391r;
        int r140 = r128.f1389q;
        s.d.a r141 = s.d.a.f11844p;
        r42.v(r141, r139, r141, r140, 0);
        r42.E = r49;
    L139:
        r14 = r14;
    L208:
        if (r15 == false) goto L215;
        int r50 = r128.T;
        if (r50 == (-1)) goto L212;
    L213:
        int r51 = r128.U;
        r42.f11851b0 = r50;
        r42.f11853c0 = r51;
        goto L215
    L212:
        if (r128.U != (-1)) goto L213;
    L215:
        if (r128.f1359a0 == false) goto L217;
        r42.L(s.e.a.f11891a);
        r42.N(((ViewGroup.MarginLayoutParams) r128).width);
        if (((ViewGroup.MarginLayoutParams) r128).width != (-2)) goto L228;
        r42.L(s.e.a.f11892b);
    L228:
        if (r128.f1361b0 == true) goto L237;
        int r52 = -1;
        if (((ViewGroup.MarginLayoutParams) r128).height == (-1)) goto L232;
        r42.M(s.e.a.f11893m);
        r42.K(0);
    L240:
        String r53 = r128.G;
        if (r53 != null) goto L243;
    L283:
        r42.Z = 0.0f;
    L284:
        float r54 = r128.H;
        float[] r55 = r42.f11874n0;
        r55[0] = r54;
        r55[1] = r128.I;
        r42.f11870l0 = r128.J;
        r42.f11872m0 = r128.K;
        int r56 = r128.Z;
        if (r56 >= 0) goto L287;
    L289:
        int r57 = r128.L;
        int r58 = r128.N;
        int r142 = r128.P;
        float r143 = r128.R;
        r42.f11883s = r57;
        r42.f11886v = r58;
        if (r142 != Integer.MAX_VALUE) goto L292;
        r142 = 0;
    L292:
        r42.f11887w = r142;
        r42.f11888x = r143;
        if (r143 > 0.0f) goto L295;
    L298:
        int r59 = r128.M;
        int r144 = r128.O;
        int r145 = r128.Q;
        float r60 = r128.S;
        r42.f11884t = r59;
        r42.f11889y = r144;
        if (r145 != Integer.MAX_VALUE) goto L301;
        r145 = 0;
    L301:
        r42.f11890z = r145;
        r42.A = r60;
        if (r60 <= 0.0f) goto L308;
        if (r60 >= 1.0f) goto L308;
        if (r59 != 0) goto L308;
        r42.f11884t = 2;
    L308:
        r40 = r40 + 1;
        r8 = this;
        r16 = r137;
        r21 = r138;
        r14 = r14;
        goto L106
    L295:
        if (r143 >= 1.0f) goto L298;
        if (r57 != 0) goto L298;
        r42.f11883s = 2;
        goto L298
    L287:
        if (r56 > 3) goto L289;
        r42.f11881r = r56;
        goto L289
    L243:
        if (r53.length() == 0) goto L283;
        int r61 = r53.length();
        int r62 = r53.indexOf(44);
        if (r62 > 0) goto L248;
    L257:
        int r146 = r52;
        int r63 = 0;
    L258:
        int r147 = r53.indexOf(58);
        if (r147 >= 0) goto L261;
    L275:
        String r64 = r53.substring(r63);
        if (r64.length() <= 0) goto L279;
        float r65 = Float.parseFloat(r64);     // Catch: NumberFormatException -> L312
    L281:
        if (r65 <= 0.0f) goto L284;
        r42.Z = r65;
        r42.f11849a0 = r146;
    L279:
        r65 = 0.0f;
        goto L281
    L261:
        if (r147 >= (r61 - 1)) goto L275;
        String r66 = r53.substring(r63, r147);
        String r67 = r53.substring(r147 + 1);
        if (r66.length() <= 0) goto L279;
        if (r67.length() <= 0) goto L279;
        float r68 = Float.parseFloat(r66);     // Catch: NumberFormatException -> L312
        float r69 = Float.parseFloat(r67);     // Catch: NumberFormatException -> L312
        if (r68 <= 0.0f) goto L279;
        if (r69 <= 0.0f) goto L279;
        if (r146 != 1) goto L273;
        r65 = Math.abs(r69 / r68);     // Catch: NumberFormatException -> L312
        goto L281
    L273:
        r65 = Math.abs(r68 / r69);     // Catch: NumberFormatException -> L312
        goto L281
    L248:
        if (r62 >= (r61 - 1)) goto L257;
        String r148 = r53.substring(0, r62);
        if (r148.equalsIgnoreCase("W") == false) goto L253;
        r146 = 0;
    L256:
        r63 = r62 + 1;
        goto L258
    L253:
        if (r148.equalsIgnoreCase("H") == false) goto L255;
        r146 = 1;
        goto L256
    L255:
        r146 = r52;
        goto L256
    L232:
        if (r128.X == false) goto L234;
        s.e.a r70 = s.e.a.f11893m;
    L235:
        r42.M(r70);
        r42.j(s.d.a.f11840b).f11836g = ((ViewGroup.MarginLayoutParams) r128).topMargin;
        r42.j(s.d.a.f11842n).f11836g = ((ViewGroup.MarginLayoutParams) r128).bottomMargin;
        goto L240
    L234:
        r70 = s.e.a.f11894n;
        goto L235
    L237:
        r52 = -1;
        r42.M(s.e.a.f11891a);
        r42.K(((ViewGroup.MarginLayoutParams) r128).height);
        if (((ViewGroup.MarginLayoutParams) r128).height != (-2)) goto L240;
        r42.M(s.e.a.f11892b);
        goto L240
    L217:
        if (((ViewGroup.MarginLayoutParams) r128).width == (-1)) goto L219;
        r42.L(s.e.a.f11893m);
        r42.N(0);
        goto L228
    L219:
        if (r128.W == false) goto L221;
        s.e.a r71 = s.e.a.f11893m;
    L222:
        r42.L(r71);
        r42.j(s.d.a.f11839a).f11836g = ((ViewGroup.MarginLayoutParams) r128).leftMargin;
        r42.j(s.d.a.f11841m).f11836g = ((ViewGroup.MarginLayoutParams) r128).rightMargin;
        goto L228
    L221:
        r71 = s.e.a.f11894n;
        goto L222
    L140:
        r128 = r128;
        if (r45 == (-1)) goto L145;
        s.e r72 = r37.get(r45);
        if (r72 == null) goto L152;
        s.d.a r73 = s.d.a.f11839a;
        int r149 = ((ViewGroup.MarginLayoutParams) r128).leftMargin;
        s.d.a r150 = r73;
    L149:
        int r74 = r133;
        r42.v(r73, r72, r150, r149, r135);
    L151:
        r48 = -1;
    L153:
        if (r74 == r48) goto L157;
        s.e r75 = r37.get(r74);
        if (r75 == null) goto L162;
        s.d.a r76 = s.d.a.f11841m;
        s.e r151 = r75;
        s.d.a r152 = s.d.a.f11839a;
        int r153 = ((ViewGroup.MarginLayoutParams) r128).rightMargin;
        s.d.a r154 = r76;
    L161:
        r42.v(r154, r151, r152, r153, r136);
    L162:
        int r77 = r128.f1373i;
        if (r77 == (-1)) goto L167;
        s.e r78 = r37.get(r77);
        if (r78 == null) goto L173;
        s.d.a r79 = s.d.a.f11840b;
        s.e r155 = r78;
        s.d.a r156 = r79;
        int r157 = ((ViewGroup.MarginLayoutParams) r128).topMargin;
        int r158 = r128.f1397x;
        s.d.a r159 = r156;
    L172:
        r42.v(r159, r155, r156, r157, r158);
    L173:
        int r80 = r128.f1377k;
        if (r80 == (-1)) goto L178;
        s.e r81 = r37.get(r80);
        if (r81 == null) goto L184;
        s.d.a r82 = s.d.a.f11842n;
        s.d.a r160 = s.d.a.f11840b;
        s.d.a r161 = r160;
        int r162 = ((ViewGroup.MarginLayoutParams) r128).bottomMargin;
        int r163 = r128.f1399z;
        s.e r164 = r81;
        s.d.a r165 = r82;
    L183:
        r42.v(r165, r164, r161, r162, r163);
    L184:
        int r83 = r128.f1381m;
        if (r83 == (-1)) goto L187;
        s.d.a r84 = s.d.a.f11843o;
    L193:
        View r85 = r20.get(r83);
        s.e r86 = r37.get(r83);
        if (r86 == null) goto L203;
        if (r85 == null) goto L203;
        if ((r85.getLayoutParams() instanceof a) == false) goto L203;
        r128.f1363c0 = true;
        s.d.a r166 = s.d.a.f11843o;
        if (r84 != r166) goto L201;
        a r87 = (a) r85.getLayoutParams();
        r87.f1363c0 = true;
        r87.f1390q0.F = true;
    L201:
        r42.j(r166).b(r86.j(r84), r128.D, r128.C, true);
        r42.F = true;
        r42.j(s.d.a.f11840b).j();
        r42.j(s.d.a.f11842n).j();
    L203:
        if (r46 < 0.0f) goto L205;
        r42.f11860g0 = r46;
    L205:
        float r88 = r128.F;
        if (r88 < 0.0f) goto L208;
        r42.f11862h0 = r88;
        goto L208
    L187:
        r83 = r128.f1383n;
        if (r83 == (-1)) goto L190;
        r84 = s.d.a.f11840b;
        goto L193
    L190:
        r83 = r128.f1385o;
        if (r83 == (-1)) goto L203;
        r84 = s.d.a.f11842n;
        goto L193
    L178:
        int r89 = r128.f1379l;
        if (r89 == (-1)) goto L184;
        s.e r90 = r37.get(r89);
        if (r90 == null) goto L184;
        s.d.a r91 = s.d.a.f11842n;
        r164 = r90;
        r165 = r91;
        r161 = r165;
        r162 = ((ViewGroup.MarginLayoutParams) r128).bottomMargin;
        r163 = r128.f1399z;
        goto L183
    L167:
        int r92 = r128.f1375j;
        if (r92 == (-1)) goto L173;
        s.e r93 = r37.get(r92);
        if (r93 == null) goto L173;
        s.d.a r94 = s.d.a.f11840b;
        s.d.a r95 = s.d.a.f11842n;
        r155 = r93;
        r156 = r95;
        r157 = ((ViewGroup.MarginLayoutParams) r128).topMargin;
        r158 = r128.f1397x;
        r159 = r94;
        goto L172
    L157:
        if (r134 == r48) goto L162;
        s.e r96 = r37.get(r134);
        if (r96 == null) goto L162;
        r151 = r96;
        r154 = s.d.a.f11841m;
        r152 = r154;
        r153 = ((ViewGroup.MarginLayoutParams) r128).rightMargin;
    L152:
        r14 = r14;
        r136 = r136;
        r134 = r134;
        r74 = r133;
        goto L153
    L145:
        if (r132 == (-1)) goto L152;
        r72 = r37.get(r132);
        if (r72 == null) goto L150;
        r73 = s.d.a.f11839a;
        s.d.a r167 = s.d.a.f11841m;
        r149 = ((ViewGroup.MarginLayoutParams) r128).leftMargin;
        r150 = r167;
        goto L149
    L150:
        r74 = r133;
    L132:
        r14 = r14;
        r137 = r16;
        r138 = r21;
    L310:
        return r14;
    L9:
        r14 = false;
        goto L10
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f1350r = true;
        super.requestLayout();
    }

    public void setConstraintSet(d r8) {
        this.f1352t = r8;
    }

    @Override // android.view.View
    public void setId(int r8) {
        int r10 = getId();
        SparseArray<View> r11 = this.f1343a;
        r11.remove(r10);
        super.setId(r8);
        r11.put(getId(), this);
    }

    public void setMaxHeight(int r8) {
        if (r8 != this.f1349q) goto L5;
        return;
    L5:
        this.f1349q = r8;
        requestLayout();
    }

    public void setMaxWidth(int r8) {
        if (r8 != this.f1348p) goto L5;
        return;
    L5:
        this.f1348p = r8;
        requestLayout();
    }

    public void setMinHeight(int r8) {
        if (r8 != this.f1347o) goto L5;
        return;
    L5:
        this.f1347o = r8;
        requestLayout();
    }

    public void setMinWidth(int r8) {
        if (r8 != this.f1346n) goto L5;
        return;
    L5:
        this.f1346n = r8;
        requestLayout();
    }

    public void setOnConstraintsChanged(v.b r8) {
        v.a r10 = this.f1353u;
        if (r10 == null) goto L6;
        r10.getClass();
        return;
    }

    public void setOptimizationLevel(int r8) {
        this.f1351s = r8;
        s.f r10 = this.f1345m;
        r10.F0 = r8;
        p.d.f9870q = r10.V(512);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public ConstraintLayout(Context r8, AttributeSet r10, int r11) {
        super(r8, r10, r11);
        this.f1343a = new SparseArray();
        this.f1344b = new ArrayList(4);
        this.f1345m = new s.f();
        this.f1346n = 0;
        this.f1347o = 0;
        this.f1348p = Integer.MAX_VALUE;
        this.f1349q = Integer.MAX_VALUE;
        this.f1350r = true;
        this.f1351s = 257;
        this.f1352t = null;
        this.f1353u = null;
        this.f1354v = -1;
        this.f1355w = new HashMap();
        this.f1356x = new SparseArray();
        this.f1357y = new b(this, this);
        h(r10, r11);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r8) {
        return new a(r8);
    }
}
