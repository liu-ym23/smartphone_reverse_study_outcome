package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.cae.smartNetwork.netAccel.AccelMetric;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f1438d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final SparseIntArray f1439e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final SparseIntArray f1440f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, androidx.constraintlayout.widget.b> f1441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<Integer, a> f1443c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0009d f1445b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f1446c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f1447d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final e f1448e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public HashMap<String, androidx.constraintlayout.widget.b> f1449f;

        /* JADX INFO: renamed from: androidx.constraintlayout.widget.d$a$a, reason: collision with other inner class name */
        public static class C0008a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int[] f1450a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int[] f1451b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f1452c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int[] f1453d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public float[] f1454e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public int f1455f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int[] f1456g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public String[] f1457h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public int f1458i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int[] f1459j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public boolean[] f1460k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public int f1461l;

            public C0008a() {
                this.f1450a = new int[10];
                this.f1451b = new int[10];
                this.f1452c = 0;
                this.f1453d = new int[10];
                this.f1454e = new float[10];
                this.f1455f = 0;
                this.f1456g = new int[5];
                this.f1457h = new String[5];
                this.f1458i = 0;
                this.f1459j = new int[4];
                this.f1460k = new boolean[4];
                this.f1461l = 0;
            }

            public final void a(int r8, float r10) {
                int r11 = this.f1455f;
                int[] r12 = this.f1453d;
                if (r11 < r12.length) goto L5;
                this.f1453d = Arrays.copyOf(r12, r12.length * 2);
                float[] r13 = this.f1454e;
                this.f1454e = Arrays.copyOf(r13, r13.length * 2);
            L5:
                int[] r14 = this.f1453d;
                int r15 = this.f1455f;
                r14[r15] = r8;
                float[] r16 = this.f1454e;
                this.f1455f = r15 + 1;
                r16[r15] = r10;
            }

            public final void b(int r8, int r10) {
                int r11 = this.f1452c;
                int[] r12 = this.f1450a;
                if (r11 < r12.length) goto L5;
                this.f1450a = Arrays.copyOf(r12, r12.length * 2);
                int[] r13 = this.f1451b;
                this.f1451b = Arrays.copyOf(r13, r13.length * 2);
            L5:
                int[] r14 = this.f1450a;
                int r15 = this.f1452c;
                r14[r15] = r8;
                int[] r16 = this.f1451b;
                this.f1452c = r15 + 1;
                r16[r15] = r10;
            }

            public final void c(int r8, String r10) {
                int r11 = this.f1458i;
                int[] r12 = this.f1456g;
                if (r11 < r12.length) goto L5;
                this.f1456g = Arrays.copyOf(r12, r12.length * 2);
                String[] r13 = this.f1457h;
                this.f1457h = (String[]) Arrays.copyOf(r13, r13.length * 2);
            L5:
                int[] r14 = this.f1456g;
                int r15 = this.f1458i;
                r14[r15] = r8;
                String[] r16 = this.f1457h;
                this.f1458i = r15 + 1;
                r16[r15] = r10;
            }

            public final void d(int r8, boolean r10) {
                int r11 = this.f1461l;
                int[] r12 = this.f1459j;
                if (r11 < r12.length) goto L5;
                this.f1459j = Arrays.copyOf(r12, r12.length * 2);
                boolean[] r13 = this.f1460k;
                this.f1460k = Arrays.copyOf(r13, r13.length * 2);
            L5:
                int[] r14 = this.f1459j;
                int r15 = this.f1461l;
                r14[r15] = r8;
                boolean[] r16 = this.f1460k;
                this.f1461l = r15 + 1;
                r16[r15] = r10;
            }
        }

        public a() {
            this.f1445b = new C0009d();
            this.f1446c = new c();
            this.f1447d = new b();
            this.f1448e = new e();
            this.f1449f = new HashMap();
        }

        public final void a(ConstraintLayout.a r8) {
            b r10 = this.f1447d;
            r8.f1365e = r10.f1476h;
            r8.f1367f = r10.f1478i;
            r8.f1369g = r10.f1480j;
            r8.f1371h = r10.f1482k;
            r8.f1373i = r10.f1484l;
            r8.f1375j = r10.f1486m;
            r8.f1377k = r10.f1488n;
            r8.f1379l = r10.f1490o;
            r8.f1381m = r10.f1492p;
            r8.f1383n = r10.f1493q;
            r8.f1385o = r10.f1494r;
            r8.f1392s = r10.f1495s;
            r8.f1393t = r10.f1496t;
            r8.f1394u = r10.f1497u;
            r8.f1395v = r10.f1498v;
            ((ViewGroup.MarginLayoutParams) r8).leftMargin = r10.F;
            ((ViewGroup.MarginLayoutParams) r8).rightMargin = r10.G;
            ((ViewGroup.MarginLayoutParams) r8).topMargin = r10.H;
            ((ViewGroup.MarginLayoutParams) r8).bottomMargin = r10.I;
            r8.A = r10.R;
            r8.B = r10.Q;
            r8.f1397x = r10.N;
            r8.f1399z = r10.P;
            r8.E = r10.f1499w;
            r8.F = r10.f1500x;
            r8.f1387p = r10.f1502z;
            r8.f1389q = r10.A;
            r8.f1391r = r10.B;
            r8.G = r10.f1501y;
            r8.T = r10.C;
            r8.U = r10.D;
            r8.I = r10.T;
            r8.H = r10.U;
            r8.K = r10.W;
            r8.J = r10.V;
            r8.W = r10.f1485l0;
            r8.X = r10.f1487m0;
            r8.L = r10.X;
            r8.M = r10.Y;
            r8.P = r10.Z;
            r8.Q = r10.f1464a0;
            r8.N = r10.f1466b0;
            r8.O = r10.f1468c0;
            r8.R = r10.d0;
            r8.S = r10.f1471e0;
            r8.V = r10.E;
            r8.f1362c = r10.f1472f;
            r8.f1358a = r10.f1469d;
            r8.f1360b = r10.f1470e;
            ((ViewGroup.MarginLayoutParams) r8).width = r10.f1465b;
            ((ViewGroup.MarginLayoutParams) r8).height = r10.f1467c;
            String r11 = r10.f1483k0;
            if (r11 == null) goto L5;
            r8.Y = r11;
        L5:
            r8.Z = r10.f1491o0;
            r8.setMarginStart(r10.K);
            r8.setMarginEnd(r10.J);
            r8.a();
        }

        public final void b(int r8, ConstraintLayout.a r10) {
            this.f1444a = r8;
            int r11 = r10.f1365e;
            b r12 = this.f1447d;
            r12.f1476h = r11;
            r12.f1478i = r10.f1367f;
            r12.f1480j = r10.f1369g;
            r12.f1482k = r10.f1371h;
            r12.f1484l = r10.f1373i;
            r12.f1486m = r10.f1375j;
            r12.f1488n = r10.f1377k;
            r12.f1490o = r10.f1379l;
            r12.f1492p = r10.f1381m;
            r12.f1493q = r10.f1383n;
            r12.f1494r = r10.f1385o;
            r12.f1495s = r10.f1392s;
            r12.f1496t = r10.f1393t;
            r12.f1497u = r10.f1394u;
            r12.f1498v = r10.f1395v;
            r12.f1499w = r10.E;
            r12.f1500x = r10.F;
            r12.f1501y = r10.G;
            r12.f1502z = r10.f1387p;
            r12.A = r10.f1389q;
            r12.B = r10.f1391r;
            r12.C = r10.T;
            r12.D = r10.U;
            r12.E = r10.V;
            r12.f1472f = r10.f1362c;
            r12.f1469d = r10.f1358a;
            r12.f1470e = r10.f1360b;
            r12.f1465b = ((ViewGroup.MarginLayoutParams) r10).width;
            r12.f1467c = ((ViewGroup.MarginLayoutParams) r10).height;
            r12.F = ((ViewGroup.MarginLayoutParams) r10).leftMargin;
            r12.G = ((ViewGroup.MarginLayoutParams) r10).rightMargin;
            r12.H = ((ViewGroup.MarginLayoutParams) r10).topMargin;
            r12.I = ((ViewGroup.MarginLayoutParams) r10).bottomMargin;
            r12.L = r10.D;
            r12.T = r10.I;
            r12.U = r10.H;
            r12.W = r10.K;
            r12.V = r10.J;
            r12.f1485l0 = r10.W;
            r12.f1487m0 = r10.X;
            r12.X = r10.L;
            r12.Y = r10.M;
            r12.Z = r10.P;
            r12.f1464a0 = r10.Q;
            r12.f1466b0 = r10.N;
            r12.f1468c0 = r10.O;
            r12.d0 = r10.R;
            r12.f1471e0 = r10.S;
            r12.f1483k0 = r10.Y;
            r12.N = r10.f1397x;
            r12.P = r10.f1399z;
            r12.M = r10.f1396w;
            r12.O = r10.f1398y;
            r12.R = r10.A;
            r12.Q = r10.B;
            r12.S = r10.C;
            r12.f1491o0 = r10.Z;
            r12.J = r10.getMarginEnd();
            r12.K = r10.getMarginStart();
        }

        public final void c(int r8, androidx.constraintlayout.widget.e.a r10) {
            b(r8, r10);
            C0009d r11 = this.f1445b;
            r11.f1515c = r10.f1532r0;
            float r12 = r10.f1535u0;
            e r13 = this.f1448e;
            r13.f1518a = r12;
            r13.f1519b = r10.f1536v0;
            r13.f1520c = r10.f1537w0;
            r13.f1521d = r10.f1538x0;
            r13.f1522e = r10.f1539y0;
            r13.f1523f = r10.f1540z0;
            r13.f1524g = r10.A0;
            r13.f1526i = r10.B0;
            r13.f1527j = r10.C0;
            r13.f1528k = r10.D0;
            r13.f1530m = r10.f1534t0;
            r13.f1529l = r10.f1533s0;
        }

        public final Object clone() {
            a r8 = new a();
            b r10 = r8.f1447d;
            r10.getClass();
            b r11 = this.f1447d;
            r10.f1463a = r11.f1463a;
            r10.f1465b = r11.f1465b;
            r10.f1467c = r11.f1467c;
            r10.f1469d = r11.f1469d;
            r10.f1470e = r11.f1470e;
            r10.f1472f = r11.f1472f;
            r10.f1474g = r11.f1474g;
            r10.f1476h = r11.f1476h;
            r10.f1478i = r11.f1478i;
            r10.f1480j = r11.f1480j;
            r10.f1482k = r11.f1482k;
            r10.f1484l = r11.f1484l;
            r10.f1486m = r11.f1486m;
            r10.f1488n = r11.f1488n;
            r10.f1490o = r11.f1490o;
            r10.f1492p = r11.f1492p;
            r10.f1493q = r11.f1493q;
            r10.f1494r = r11.f1494r;
            r10.f1495s = r11.f1495s;
            r10.f1496t = r11.f1496t;
            r10.f1497u = r11.f1497u;
            r10.f1498v = r11.f1498v;
            r10.f1499w = r11.f1499w;
            r10.f1500x = r11.f1500x;
            r10.f1501y = r11.f1501y;
            r10.f1502z = r11.f1502z;
            r10.A = r11.A;
            r10.B = r11.B;
            r10.C = r11.C;
            r10.D = r11.D;
            r10.E = r11.E;
            r10.F = r11.F;
            r10.G = r11.G;
            r10.H = r11.H;
            r10.I = r11.I;
            r10.J = r11.J;
            r10.K = r11.K;
            r10.L = r11.L;
            r10.M = r11.M;
            r10.N = r11.N;
            r10.O = r11.O;
            r10.P = r11.P;
            r10.Q = r11.Q;
            r10.R = r11.R;
            r10.S = r11.S;
            r10.T = r11.T;
            r10.U = r11.U;
            r10.V = r11.V;
            r10.W = r11.W;
            r10.X = r11.X;
            r10.Y = r11.Y;
            r10.Z = r11.Z;
            r10.f1464a0 = r11.f1464a0;
            r10.f1466b0 = r11.f1466b0;
            r10.f1468c0 = r11.f1468c0;
            r10.d0 = r11.d0;
            r10.f1471e0 = r11.f1471e0;
            r10.f1473f0 = r11.f1473f0;
            r10.f1475g0 = r11.f1475g0;
            r10.f1477h0 = r11.f1477h0;
            r10.f1483k0 = r11.f1483k0;
            int[] r12 = r11.f1479i0;
            if (r12 != null) goto L5;
        L7:
            r10.f1479i0 = null;
        L8:
            r10.f1481j0 = r11.f1481j0;
            r10.f1485l0 = r11.f1485l0;
            r10.f1487m0 = r11.f1487m0;
            r10.f1489n0 = r11.f1489n0;
            r10.f1491o0 = r11.f1491o0;
            c r13 = r8.f1446c;
            r13.getClass();
            c r14 = this.f1446c;
            r14.getClass();
            r13.f1504a = r14.f1504a;
            r13.f1506c = r14.f1506c;
            r13.f1508e = r14.f1508e;
            r13.f1507d = r14.f1507d;
            C0009d r15 = r8.f1445b;
            r15.getClass();
            C0009d r16 = this.f1445b;
            r16.getClass();
            r15.f1513a = r16.f1513a;
            r15.f1515c = r16.f1515c;
            r15.f1516d = r16.f1516d;
            r15.f1514b = r16.f1514b;
            e r17 = r8.f1448e;
            r17.getClass();
            e r18 = this.f1448e;
            r18.getClass();
            r17.f1518a = r18.f1518a;
            r17.f1519b = r18.f1519b;
            r17.f1520c = r18.f1520c;
            r17.f1521d = r18.f1521d;
            r17.f1522e = r18.f1522e;
            r17.f1523f = r18.f1523f;
            r17.f1524g = r18.f1524g;
            r17.f1525h = r18.f1525h;
            r17.f1526i = r18.f1526i;
            r17.f1527j = r18.f1527j;
            r17.f1528k = r18.f1528k;
            r17.f1529l = r18.f1529l;
            r17.f1530m = r18.f1530m;
            r8.f1444a = this.f1444a;
            return r8;
        L5:
            if (r11.f1481j0 != null) goto L7;
            r10.f1479i0 = Arrays.copyOf(r12, r12.length);
            goto L8
        }
    }

    public static class b {

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public static final SparseIntArray f1462p0 = null;
        public int A;
        public float B;
        public int C;
        public int D;
        public int E;
        public int F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public int R;
        public int S;
        public float T;
        public float U;
        public int V;
        public int W;
        public int X;
        public int Y;
        public int Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1463a;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public int f1464a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1465b;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public int f1466b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1467c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public int f1468c0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1469d;
        public float d0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1470e;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public float f1471e0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f1472f;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public int f1473f0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f1474g;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public int f1475g0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f1476h;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public int f1477h0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f1478i;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public int[] f1479i0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f1480j;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public String f1481j0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f1482k;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public String f1483k0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f1484l;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public boolean f1485l0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f1486m;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public boolean f1487m0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f1488n;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public boolean f1489n0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f1490o;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public int f1491o0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f1492p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f1493q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f1494r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f1495s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f1496t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f1497u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f1498v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public float f1499w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public float f1500x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public String f1501y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f1502z;

        static {
            SparseIntArray r8 = new SparseIntArray();
            f1462p0 = r8;
            r8.append(43, 24);
            r8.append(44, 25);
            r8.append(46, 28);
            r8.append(47, 29);
            r8.append(52, 35);
            r8.append(51, 34);
            r8.append(24, 4);
            r8.append(23, 3);
            r8.append(19, 1);
            r8.append(61, 6);
            r8.append(62, 7);
            r8.append(31, 17);
            r8.append(32, 18);
            r8.append(33, 19);
            r8.append(15, 90);
            r8.append(0, 26);
            r8.append(48, 31);
            r8.append(49, 32);
            r8.append(30, 10);
            r8.append(29, 9);
            r8.append(66, 13);
            r8.append(69, 16);
            r8.append(67, 14);
            r8.append(64, 11);
            r8.append(68, 15);
            r8.append(65, 12);
            r8.append(55, 38);
            r8.append(41, 37);
            r8.append(40, 39);
            r8.append(54, 40);
            r8.append(39, 20);
            r8.append(53, 36);
            r8.append(28, 5);
            r8.append(42, 91);
            r8.append(50, 91);
            r8.append(45, 91);
            r8.append(22, 91);
            r8.append(18, 91);
            r8.append(3, 23);
            r8.append(5, 27);
            r8.append(7, 30);
            r8.append(8, 8);
            r8.append(4, 33);
            r8.append(6, 2);
            r8.append(1, 22);
            r8.append(2, 21);
            r8.append(56, 41);
            r8.append(34, 42);
            r8.append(17, 87);
            r8.append(16, 88);
            r8.append(71, 76);
            r8.append(25, 61);
            r8.append(27, 62);
            r8.append(26, 63);
            r8.append(60, 69);
            r8.append(38, 70);
            r8.append(12, 71);
            r8.append(10, 72);
            r8.append(11, 73);
            r8.append(13, 74);
            r8.append(9, 75);
            r8.append(58, 84);
            r8.append(59, 86);
            r8.append(58, 83);
            r8.append(37, 85);
            r8.append(56, 87);
            r8.append(34, 88);
            r8.append(91, 89);
            r8.append(15, 90);
        }

        public b() {
            this.f1463a = false;
            this.f1469d = -1;
            this.f1470e = -1;
            this.f1472f = -1.0f;
            this.f1474g = true;
            this.f1476h = -1;
            this.f1478i = -1;
            this.f1480j = -1;
            this.f1482k = -1;
            this.f1484l = -1;
            this.f1486m = -1;
            this.f1488n = -1;
            this.f1490o = -1;
            this.f1492p = -1;
            this.f1493q = -1;
            this.f1494r = -1;
            this.f1495s = -1;
            this.f1496t = -1;
            this.f1497u = -1;
            this.f1498v = -1;
            this.f1499w = 0.5f;
            this.f1500x = 0.5f;
            this.f1501y = null;
            this.f1502z = -1;
            this.A = 0;
            this.B = 0.0f;
            this.C = -1;
            this.D = -1;
            this.E = -1;
            this.F = 0;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = Integer.MIN_VALUE;
            this.N = Integer.MIN_VALUE;
            this.O = Integer.MIN_VALUE;
            this.P = Integer.MIN_VALUE;
            this.Q = Integer.MIN_VALUE;
            this.R = Integer.MIN_VALUE;
            this.S = Integer.MIN_VALUE;
            this.T = -1.0f;
            this.U = -1.0f;
            this.V = 0;
            this.W = 0;
            this.X = 0;
            this.Y = 0;
            this.Z = 0;
            this.f1464a0 = 0;
            this.f1466b0 = 0;
            this.f1468c0 = 0;
            this.d0 = 1.0f;
            this.f1471e0 = 1.0f;
            this.f1473f0 = -1;
            this.f1475g0 = 0;
            this.f1477h0 = -1;
            this.f1485l0 = false;
            this.f1487m0 = false;
            this.f1489n0 = true;
            this.f1491o0 = 0;
        }

        public final void a(Context r8, AttributeSet r10) {
            TypedArray r11 = r8.obtainStyledAttributes(r10, v.d.f12660f);
            int r12 = r11.getIndexCount();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L80;
            int r14 = r11.getIndex(r13);
            SparseIntArray r15 = f1462p0;
            int r16 = r15.get(r14);
            switch(r16) {
                case 1: goto L51;
                case 2: goto L50;
                case 3: goto L49;
                case 4: goto L48;
                case 5: goto L47;
                case 6: goto L46;
                case 7: goto L45;
                case 8: goto L44;
                case 9: goto L43;
                case 10: goto L42;
                case 11: goto L41;
                case 12: goto L40;
                case 13: goto L39;
                case 14: goto L38;
                case 15: goto L37;
                case 16: goto L36;
                case 17: goto L35;
                case 18: goto L34;
                case 19: goto L33;
                case 20: goto L32;
                case 21: goto L31;
                case 22: goto L30;
                case 23: goto L29;
                case 24: goto L28;
                case 25: goto L27;
                case 26: goto L26;
                case 27: goto L25;
                case 28: goto L24;
                case 29: goto L23;
                case 30: goto L22;
                case 31: goto L21;
                case 32: goto L20;
                case 33: goto L19;
                case 34: goto L18;
                case 35: goto L17;
                case 36: goto L16;
                case 37: goto L15;
                case 38: goto L14;
                case 39: goto L13;
                case 40: goto L12;
                case 41: goto L11;
                case 42: goto L10;
                default: goto L6;
            };
        L6:
            switch(r16) {
                case 61: goto L54;
                case 62: goto L53;
                case 63: goto L52;
                default: goto L8;
            };
        L52:
            this.B = r11.getFloat(r14, this.B);
        L79:
            r13 = r13 + 1;
            goto L3
        L53:
            this.A = r11.getDimensionPixelSize(r14, this.A);
            goto L79
        L54:
            this.f1502z = d.g(r11, r14, this.f1502z);
            goto L79
        L8:
            switch(r16) {
                case 69: goto L77;
                case 70: goto L76;
                case 71: goto L75;
                case 72: goto L74;
                case 73: goto L73;
                case 74: goto L72;
                case 75: goto L71;
                case 76: goto L70;
                case 77: goto L69;
                case 78: goto L68;
                case 79: goto L67;
                case 80: goto L66;
                case 81: goto L65;
                case 82: goto L64;
                case 83: goto L63;
                case 84: goto L62;
                case 85: goto L61;
                case 86: goto L60;
                case 87: goto L59;
                case 88: goto L58;
                case 89: goto L57;
                case 90: goto L56;
                case 91: goto L55;
                default: goto L9;
            };
        L9:
            StringBuilder r17 = new StringBuilder("Unknown attribute 0x");
        L78:
            r17.append(Integer.toHexString(r14));
            r17.append("   ");
            r17.append(r15.get(r14));
            Log.w("ConstraintSet", r17.toString());
            goto L79
        L55:
            r17 = new StringBuilder("unused attribute 0x");
            goto L78
        L56:
            this.f1474g = r11.getBoolean(r14, this.f1474g);
            goto L79
        L57:
            this.f1483k0 = r11.getString(r14);
            goto L79
        L58:
            this.f1487m0 = r11.getBoolean(r14, this.f1487m0);
            goto L79
        L59:
            this.f1485l0 = r11.getBoolean(r14, this.f1485l0);
            goto L79
        L60:
            this.f1466b0 = r11.getDimensionPixelSize(r14, this.f1466b0);
            goto L79
        L61:
            this.f1468c0 = r11.getDimensionPixelSize(r14, this.f1468c0);
            goto L79
        L62:
            this.Z = r11.getDimensionPixelSize(r14, this.Z);
            goto L79
        L63:
            this.f1464a0 = r11.getDimensionPixelSize(r14, this.f1464a0);
            goto L79
        L64:
            this.Y = r11.getInt(r14, this.Y);
            goto L79
        L65:
            this.X = r11.getInt(r14, this.X);
            goto L79
        L66:
            this.L = r11.getDimensionPixelSize(r14, this.L);
            goto L79
        L67:
            this.S = r11.getDimensionPixelSize(r14, this.S);
            goto L79
        L68:
            this.f1494r = d.g(r11, r14, this.f1494r);
            goto L79
        L69:
            this.f1493q = d.g(r11, r14, this.f1493q);
            goto L79
        L70:
            this.f1491o0 = r11.getInt(r14, this.f1491o0);
            goto L79
        L71:
            this.f1489n0 = r11.getBoolean(r14, this.f1489n0);
            goto L79
        L72:
            this.f1481j0 = r11.getString(r14);
            goto L79
        L73:
            this.f1475g0 = r11.getDimensionPixelSize(r14, this.f1475g0);
            goto L79
        L74:
            this.f1473f0 = r11.getInt(r14, this.f1473f0);
            goto L79
        L75:
            Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
            goto L79
        L76:
            this.f1471e0 = r11.getFloat(r14, 1.0f);
            goto L79
        L77:
            this.d0 = r11.getFloat(r14, 1.0f);
            goto L79
        L10:
            d.h(this, r11, r14, 1);
            goto L79
        L11:
            d.h(this, r11, r14, 0);
            goto L79
        L12:
            this.W = r11.getInt(r14, this.W);
            goto L79
        L13:
            this.V = r11.getInt(r14, this.V);
            goto L79
        L14:
            this.T = r11.getFloat(r14, this.T);
            goto L79
        L15:
            this.U = r11.getFloat(r14, this.U);
            goto L79
        L16:
            this.f1500x = r11.getFloat(r14, this.f1500x);
            goto L79
        L17:
            this.f1484l = d.g(r11, r14, this.f1484l);
            goto L79
        L18:
            this.f1486m = d.g(r11, r14, this.f1486m);
            goto L79
        L19:
            this.H = r11.getDimensionPixelSize(r14, this.H);
            goto L79
        L20:
            this.f1496t = d.g(r11, r14, this.f1496t);
            goto L79
        L21:
            this.f1495s = d.g(r11, r14, this.f1495s);
            goto L79
        L22:
            this.K = r11.getDimensionPixelSize(r14, this.K);
            goto L79
        L23:
            this.f1482k = d.g(r11, r14, this.f1482k);
            goto L79
        L24:
            this.f1480j = d.g(r11, r14, this.f1480j);
            goto L79
        L25:
            this.G = r11.getDimensionPixelSize(r14, this.G);
            goto L79
        L26:
            this.E = r11.getInt(r14, this.E);
            goto L79
        L27:
            this.f1478i = d.g(r11, r14, this.f1478i);
            goto L79
        L28:
            this.f1476h = d.g(r11, r14, this.f1476h);
            goto L79
        L29:
            this.F = r11.getDimensionPixelSize(r14, this.F);
            goto L79
        L30:
            this.f1465b = r11.getLayoutDimension(r14, this.f1465b);
            goto L79
        L31:
            this.f1467c = r11.getLayoutDimension(r14, this.f1467c);
            goto L79
        L32:
            this.f1499w = r11.getFloat(r14, this.f1499w);
            goto L79
        L33:
            this.f1472f = r11.getFloat(r14, this.f1472f);
            goto L79
        L34:
            this.f1470e = r11.getDimensionPixelOffset(r14, this.f1470e);
            goto L79
        L35:
            this.f1469d = r11.getDimensionPixelOffset(r14, this.f1469d);
            goto L79
        L36:
            this.N = r11.getDimensionPixelSize(r14, this.N);
            goto L79
        L37:
            this.R = r11.getDimensionPixelSize(r14, this.R);
            goto L79
        L38:
            this.O = r11.getDimensionPixelSize(r14, this.O);
            goto L79
        L39:
            this.M = r11.getDimensionPixelSize(r14, this.M);
            goto L79
        L40:
            this.Q = r11.getDimensionPixelSize(r14, this.Q);
            goto L79
        L41:
            this.P = r11.getDimensionPixelSize(r14, this.P);
            goto L79
        L42:
            this.f1497u = d.g(r11, r14, this.f1497u);
            goto L79
        L43:
            this.f1498v = d.g(r11, r14, this.f1498v);
            goto L79
        L44:
            this.J = r11.getDimensionPixelSize(r14, this.J);
            goto L79
        L45:
            this.D = r11.getDimensionPixelOffset(r14, this.D);
            goto L79
        L46:
            this.C = r11.getDimensionPixelOffset(r14, this.C);
            goto L79
        L47:
            this.f1501y = r11.getString(r14);
            goto L79
        L48:
            this.f1488n = d.g(r11, r14, this.f1488n);
            goto L79
        L49:
            this.f1490o = d.g(r11, r14, this.f1490o);
            goto L79
        L50:
            this.I = r11.getDimensionPixelSize(r14, this.I);
            goto L79
        L51:
            this.f1492p = d.g(r11, r14, this.f1492p);
            goto L79
        L80:
            r11.recycle();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final SparseIntArray f1503j = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1504a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1505b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1506c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f1507d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f1508e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f1509f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f1510g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f1511h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f1512i;

        static {
            SparseIntArray r8 = new SparseIntArray();
            f1503j = r8;
            r8.append(3, 1);
            r8.append(5, 2);
            r8.append(9, 3);
            r8.append(2, 4);
            r8.append(1, 5);
            r8.append(0, 6);
            r8.append(4, 7);
            r8.append(8, 8);
            r8.append(7, 9);
            r8.append(6, 10);
        }

        public c() {
            this.f1504a = -1;
            this.f1505b = 0;
            this.f1506c = -1;
            this.f1507d = Float.NaN;
            this.f1508e = Float.NaN;
            this.f1509f = Float.NaN;
            this.f1510g = -1;
            this.f1511h = null;
            this.f1512i = -1;
        }

        public final void a(Context r8, AttributeSet r10) {
            TypedArray r11 = r8.obtainStyledAttributes(r10, v.d.f12661g);
            int r12 = r11.getIndexCount();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L28;
            int r14 = r11.getIndex(r13);
            switch(f1503j.get(r14)) {
                case 1: goto L26;
                case 2: goto L25;
                case 3: goto L22;
                case 4: goto L20;
                case 5: goto L19;
                case 6: goto L18;
                case 7: goto L17;
                case 8: goto L16;
                case 9: goto L15;
                case 10: goto L7;
                default: goto L27;
            };
        L7:
            int r15 = r11.peekValue(r14).type;
            if (r15 != 1) goto L10;
        L9:
            this.f1512i = r11.getResourceId(r14, -1);
            goto L27
        L10:
            if (r15 != 3) goto L14;
            String r16 = r11.getString(r14);
            this.f1511h = r16;
            if (r16.indexOf("/") <= 0) goto L27;
        L14:
            r11.getInteger(r14, this.f1512i);
            goto L27
        L15:
            this.f1509f = r11.getFloat(r14, this.f1509f);
            goto L27
        L16:
            this.f1510g = r11.getInteger(r14, this.f1510g);
            goto L27
        L17:
            this.f1507d = r11.getFloat(r14, this.f1507d);
            goto L27
        L18:
            this.f1505b = r11.getInteger(r14, this.f1505b);
            goto L27
        L19:
            this.f1504a = d.g(r11, r14, this.f1504a);
            goto L27
        L20:
            r11.getInt(r14, 0);
            goto L27
        L25:
            this.f1506c = r11.getInt(r14, this.f1506c);
            goto L27
        L26:
            this.f1508e = r11.getFloat(r14, this.f1508e);
            goto L27
        L22:
            if (r11.peekValue(r14).type != 3) goto L24;
            r11.getString(r14);
            goto L27
        L24:
            String r17 = q.a.f10097b[r11.getInteger(r14, 0)];
        L27:
            r13 = r13 + 1;
            goto L3
        L28:
            r11.recycle();
        }
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.d$d, reason: collision with other inner class name */
    public static class C0009d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1514b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f1515c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f1516d;

        public C0009d() {
            this.f1513a = 0;
            this.f1514b = 0;
            this.f1515c = 1.0f;
            this.f1516d = Float.NaN;
        }

        public final void a(Context r8, AttributeSet r10) {
            TypedArray r11 = r8.obtainStyledAttributes(r10, v.d.f12663i);
            int r12 = r11.getIndexCount();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L16;
            int r14 = r11.getIndex(r13);
            if (r14 != 1) goto L7;
            this.f1515c = r11.getFloat(r14, this.f1515c);
        L15:
            r13 = r13 + 1;
            goto L3
        L7:
            if (r14 != 0) goto L10;
            int r15 = r11.getInt(r14, this.f1513a);
            this.f1513a = r15;
            this.f1513a = d.f1438d[r15];
            goto L15
        L10:
            if (r14 != 4) goto L13;
            this.f1514b = r11.getInt(r14, this.f1514b);
            goto L15
        L13:
            if (r14 != 3) goto L15;
            this.f1516d = r11.getFloat(r14, this.f1516d);
            goto L15
        L16:
            r11.recycle();
        }
    }

    public static class e {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final SparseIntArray f1517n = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f1518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f1519b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f1520c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f1521d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f1522e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f1523f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f1524g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f1525h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f1526i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f1527j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f1528k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f1529l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f1530m;

        static {
            SparseIntArray r8 = new SparseIntArray();
            f1517n = r8;
            r8.append(6, 1);
            r8.append(7, 2);
            r8.append(8, 3);
            r8.append(4, 4);
            r8.append(5, 5);
            r8.append(0, 6);
            r8.append(1, 7);
            r8.append(2, 8);
            r8.append(3, 9);
            r8.append(9, 10);
            r8.append(10, 11);
            r8.append(11, 12);
        }

        public e() {
            this.f1518a = 0.0f;
            this.f1519b = 0.0f;
            this.f1520c = 0.0f;
            this.f1521d = 1.0f;
            this.f1522e = 1.0f;
            this.f1523f = Float.NaN;
            this.f1524g = Float.NaN;
            this.f1525h = -1;
            this.f1526i = 0.0f;
            this.f1527j = 0.0f;
            this.f1528k = 0.0f;
            this.f1529l = false;
            this.f1530m = 0.0f;
        }

        public final void a(Context r8, AttributeSet r10) {
            TypedArray r11 = r8.obtainStyledAttributes(r10, v.d.f12665k);
            int r12 = r11.getIndexCount();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L20;
            int r14 = r11.getIndex(r13);
            switch(f1517n.get(r14)) {
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
            this.f1525h = d.g(r11, r14, this.f1525h);
            goto L19
        L8:
            this.f1529l = true;
            this.f1530m = r11.getDimension(r14, this.f1530m);
            goto L19
        L9:
            this.f1528k = r11.getDimension(r14, this.f1528k);
            goto L19
        L10:
            this.f1527j = r11.getDimension(r14, this.f1527j);
            goto L19
        L11:
            this.f1526i = r11.getDimension(r14, this.f1526i);
            goto L19
        L12:
            this.f1524g = r11.getDimension(r14, this.f1524g);
            goto L19
        L13:
            this.f1523f = r11.getDimension(r14, this.f1523f);
            goto L19
        L14:
            this.f1522e = r11.getFloat(r14, this.f1522e);
            goto L19
        L15:
            this.f1521d = r11.getFloat(r14, this.f1521d);
            goto L19
        L16:
            this.f1520c = r11.getFloat(r14, this.f1520c);
            goto L19
        L17:
            this.f1519b = r11.getFloat(r14, this.f1519b);
            goto L19
        L18:
            this.f1518a = r11.getFloat(r14, this.f1518a);
        L19:
            r13 = r13 + 1;
            goto L3
        L20:
            r11.recycle();
        }
    }

    static {
        f1438d = new int[]{0, 4, 8};
        SparseIntArray r8 = new SparseIntArray();
        f1439e = r8;
        SparseIntArray r10 = new SparseIntArray();
        f1440f = r10;
        r8.append(82, 25);
        r8.append(83, 26);
        r8.append(85, 29);
        r8.append(86, 30);
        r8.append(92, 36);
        r8.append(91, 35);
        r8.append(63, 4);
        r8.append(62, 3);
        r8.append(58, 1);
        r8.append(60, 91);
        r8.append(59, 92);
        r8.append(101, 6);
        r8.append(102, 7);
        r8.append(70, 17);
        r8.append(71, 18);
        r8.append(72, 19);
        r8.append(54, 99);
        r8.append(0, 27);
        r8.append(87, 32);
        r8.append(88, 33);
        r8.append(69, 10);
        r8.append(68, 9);
        r8.append(106, 13);
        r8.append(109, 16);
        r8.append(107, 14);
        r8.append(104, 11);
        r8.append(108, 15);
        r8.append(105, 12);
        r8.append(95, 40);
        r8.append(80, 39);
        r8.append(79, 41);
        r8.append(94, 42);
        r8.append(78, 20);
        r8.append(93, 37);
        r8.append(67, 5);
        r8.append(81, 87);
        r8.append(90, 87);
        r8.append(84, 87);
        r8.append(61, 87);
        r8.append(57, 87);
        r8.append(5, 24);
        r8.append(7, 28);
        r8.append(23, 31);
        r8.append(24, 8);
        r8.append(6, 34);
        r8.append(8, 2);
        r8.append(3, 23);
        r8.append(4, 21);
        r8.append(96, 95);
        r8.append(73, 96);
        r8.append(2, 22);
        r8.append(13, 43);
        r8.append(26, 44);
        r8.append(21, 45);
        r8.append(22, 46);
        r8.append(20, 60);
        r8.append(18, 47);
        r8.append(19, 48);
        r8.append(14, 49);
        r8.append(15, 50);
        r8.append(16, 51);
        r8.append(17, 52);
        r8.append(25, 53);
        r8.append(97, 54);
        r8.append(74, 55);
        r8.append(98, 56);
        r8.append(75, 57);
        r8.append(99, 58);
        r8.append(76, 59);
        r8.append(64, 61);
        r8.append(66, 62);
        r8.append(65, 63);
        r8.append(28, 64);
        r8.append(121, 65);
        r8.append(35, 66);
        r8.append(122, 67);
        r8.append(113, 79);
        r8.append(1, 38);
        r8.append(BWDLInnerConstant.LINK_RECOVERY, 68);
        r8.append(100, 69);
        r8.append(77, 70);
        r8.append(111, 97);
        r8.append(32, 71);
        r8.append(30, 72);
        r8.append(31, 73);
        r8.append(33, 74);
        r8.append(29, 75);
        r8.append(114, 76);
        r8.append(89, 77);
        r8.append(AccelMetric.CAE_MULTI_NET_ACCEL_EVENT_FEATURE_ID, 78);
        r8.append(56, 80);
        r8.append(55, 81);
        r8.append(116, 82);
        r8.append(120, 83);
        r8.append(IdlErrors.E_RejectInferDeviceOverheat, 84);
        r8.append(118, 85);
        r8.append(117, 86);
        r10.append(85, 6);
        r10.append(85, 7);
        r10.append(0, 27);
        r10.append(89, 13);
        r10.append(92, 16);
        r10.append(90, 14);
        r10.append(87, 11);
        r10.append(91, 15);
        r10.append(88, 12);
        r10.append(78, 40);
        r10.append(71, 39);
        r10.append(70, 41);
        r10.append(77, 42);
        r10.append(69, 20);
        r10.append(76, 37);
        r10.append(60, 5);
        r10.append(72, 87);
        r10.append(75, 87);
        r10.append(73, 87);
        r10.append(57, 87);
        r10.append(56, 87);
        r10.append(5, 24);
        r10.append(7, 28);
        r10.append(23, 31);
        r10.append(24, 8);
        r10.append(6, 34);
        r10.append(8, 2);
        r10.append(3, 23);
        r10.append(4, 21);
        r10.append(79, 95);
        r10.append(64, 96);
        r10.append(2, 22);
        r10.append(13, 43);
        r10.append(26, 44);
        r10.append(21, 45);
        r10.append(22, 46);
        r10.append(20, 60);
        r10.append(18, 47);
        r10.append(19, 48);
        r10.append(14, 49);
        r10.append(15, 50);
        r10.append(16, 51);
        r10.append(17, 52);
        r10.append(25, 53);
        r10.append(80, 54);
        r10.append(65, 55);
        r10.append(81, 56);
        r10.append(66, 57);
        r10.append(82, 58);
        r10.append(67, 59);
        r10.append(59, 62);
        r10.append(58, 63);
        r10.append(28, 64);
        r10.append(105, 65);
        r10.append(34, 66);
        r10.append(106, 67);
        r10.append(96, 79);
        r10.append(1, 38);
        r10.append(97, 98);
        r10.append(95, 68);
        r10.append(83, 69);
        r10.append(68, 70);
        r10.append(32, 71);
        r10.append(30, 72);
        r10.append(31, 73);
        r10.append(33, 74);
        r10.append(29, 75);
        r10.append(98, 76);
        r10.append(74, 77);
        r10.append(107, 78);
        r10.append(55, 80);
        r10.append(54, 81);
        r10.append(100, 82);
        r10.append(104, 83);
        r10.append(103, 84);
        r10.append(102, 85);
        r10.append(101, 86);
        r10.append(94, 97);
    }

    public d() {
        this.f1441a = new HashMap();
        this.f1442b = true;
        this.f1443c = new HashMap();
    }

    public static int[] d(androidx.constraintlayout.widget.a r10, String r11) {
        String[] r12 = r11.split(",");
        Context r8 = r10.getContext();
        int[] r13 = new int[r12.length];
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r14 >= r12.length) goto L29;
        String r16 = r12[r14].trim();
        Integer r17 = null;
        int r18 = v.c.class.getField(r16).getInt(null);     // Catch: Exception -> L8
    L9:
        if (r18 != 0) goto L11;
        r18 = r8.getResources().getIdentifier(r16, "id", r8.getPackageName());
    L11:
        if (r18 != 0) goto L27;
        if (r10.isInEditMode() == false) goto L27;
        if ((r10.getParent() instanceof ConstraintLayout) == false) goto L27;
        ConstraintLayout r19 = (ConstraintLayout) r10.getParent();
        r19.getClass();
        if ((r16 instanceof String) == false) goto L23;
        HashMap<String, Integer> r20 = r19.f1355w;
        if (r20 == null) goto L23;
        if (r20.containsKey(r16) == false) goto L23;
        r17 = r19.f1355w.get(r16);
    L23:
        if (r17 == null) goto L27;
        if ((r17 instanceof Integer) == false) goto L27;
        r18 = r17.intValue();
    L27:
        r13[r15] = r18;
        r14 = r14 + 1;
        r15 = r15 + 1;
    L8:
        r18 = 0;
        goto L9
    L29:
        if (r15 != r12.length) goto L31;
        return r13;
    L31:
        return Arrays.copyOf(r13, r15);
    }

    public static a e(Context r20, AttributeSet r21, boolean r22) {
        a r8 = new a();
        if (r22 == false) goto L5;
        int[] r10 = v.d.f12657c;
    L6:
        TypedArray r11 = r20.obtainStyledAttributes(r21, r10);
        String[] r12 = q.a.f10097b;
        int[] r13 = f1438d;
        SparseIntArray r14 = f1439e;
        C0009d r15 = r8.f1445b;
        e r16 = r8.f1448e;
        c r17 = r8.f1446c;
        b r18 = r8.f1447d;
        String r19 = "unused attribute 0x";
        if (r22 == false) goto L120;
        int r23 = r11.getIndexCount();
        String r110 = "Unknown attribute 0x";
        a.C0008a r24 = new a.C0008a();
        r17.getClass();
        r18.getClass();
        r15.getClass();
        r16.getClass();
        int r25 = 0;
    L9:
        if (r25 >= r23) goto L247;
        int r26 = r23;
        int r27 = r11.getIndex(r25);
        int r111 = r25;
        switch(f1440f.get(r27)) {
            case 2: goto L116;
            case 3: goto L12;
            case 4: goto L12;
            case 5: goto L114;
            case 6: goto L113;
            case 7: goto L112;
            case 8: goto L111;
            case 9: goto L12;
            case 10: goto L12;
            case 11: goto L110;
            case 12: goto L109;
            case 13: goto L108;
            case 14: goto L107;
            case 15: goto L106;
            case 16: goto L105;
            case 17: goto L104;
            case 18: goto L103;
            case 19: goto L101;
            case 20: goto L100;
            case 21: goto L99;
            case 22: goto L98;
            case 23: goto L97;
            case 24: goto L96;
            case 25: goto L12;
            case 26: goto L12;
            case 27: goto L95;
            case 28: goto L94;
            case 29: goto L12;
            case 30: goto L12;
            case 31: goto L93;
            case 32: goto L12;
            case 33: goto L12;
            case 34: goto L92;
            case 35: goto L12;
            case 36: goto L12;
            case 37: goto L91;
            case 38: goto L90;
            case 39: goto L89;
            case 40: goto L88;
            case 41: goto L87;
            case 42: goto L86;
            case 43: goto L85;
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
            case 61: goto L12;
            case 62: goto L67;
            case 63: goto L66;
            case 64: goto L65;
            case 65: goto L60;
            case 66: goto L59;
            case 67: goto L58;
            case 68: goto L57;
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
            case 82: goto L41;
            case 83: goto L40;
            case 84: goto L39;
            case 85: goto L38;
            case 86: goto L25;
            case 87: goto L24;
            case 88: goto L12;
            case 89: goto L12;
            case 90: goto L12;
            case 91: goto L12;
            case 92: goto L12;
            case 93: goto L23;
            case 94: goto L22;
            case 95: goto L20;
            case 96: goto L19;
            case 97: goto L18;
            case 98: goto L14;
            case 99: goto L13;
            default: goto L12;
        };
    L12:
        r12 = r12;
        String r28 = r110;
        Log.w("ConstraintSet", r28 + Integer.toHexString(r27) + "   " + r14.get(r27));
    L119:
        r23 = r26;
        r24 = r24;
        r110 = r28;
        r25 = r111 + 1;
        r12 = r12;
        goto L9
    L13:
        boolean r29 = r11.getBoolean(r27, r18.f1474g);
        int r30 = 99;
    L49:
        r24.d(r30, r29);
    L118:
        r28 = r110;
        goto L119
    L14:
        int r31 = u.d.U;
        r12 = r12;
        if (r11.peekValue(r27).type != 3) goto L17;
        r11.getString(r27);
        goto L118
    L17:
        r8.f1444a = r11.getResourceId(r27, r8.f1444a);
        goto L118
    L18:
        int r32 = r11.getInt(r27, r18.f1491o0);
        int r33 = 97;
    L117:
        r24.b(r33, r32);
        goto L118
    L19:
        int r34 = 1;
    L21:
        h(r24, r11, r27, r34);
        goto L118
    L20:
        r34 = 0;
        goto L21
    L22:
        r32 = r11.getDimensionPixelSize(r27, r18.S);
        r33 = 94;
        goto L117
    L23:
        r32 = r11.getDimensionPixelSize(r27, r18.L);
        r33 = 93;
        goto L117
    L24:
        r12 = r12;
        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(r27) + "   " + r14.get(r27));
        goto L118
    L25:
        r12 = r12;
        int r35 = r11.peekValue(r27).type;
        if (r35 != 1) goto L31;
        int r36 = r11.getResourceId(r27, -1);
        r17.f1512i = r36;
        r24.b(89, r36);
        if (r17.f1512i == (-1)) goto L118;
    L35:
        r24.b(88, -2);
        goto L118
    L31:
        if (r35 != 3) goto L37;
        String r37 = r11.getString(r27);
        r17.f1511h = r37;
        r24.c(90, r37);
        if (r17.f1511h.indexOf("/") <= 0) goto L36;
        int r38 = r11.getResourceId(r27, -1);
        r17.f1512i = r38;
        r24.b(89, r38);
        goto L35
    L36:
        r24.b(88, -1);
        goto L118
    L37:
        r24.b(88, r11.getInteger(r27, r17.f1512i));
        goto L118
    L38:
        float r39 = r11.getFloat(r27, r17.f1509f);
        int r40 = 85;
    L102:
        r24.a(r40, r39);
        goto L118
    L39:
        r32 = r11.getInteger(r27, r17.f1510g);
        r33 = 84;
        goto L117
    L40:
        r32 = g(r11, r27, r16.f1525h);
        r33 = 83;
        goto L117
    L41:
        r32 = r11.getInteger(r27, r17.f1505b);
        r33 = 82;
        goto L117
    L42:
        r29 = r11.getBoolean(r27, r18.f1487m0);
        r30 = 81;
        goto L49
    L43:
        r29 = r11.getBoolean(r27, r18.f1485l0);
        r30 = 80;
        goto L49
    L44:
        r39 = r11.getFloat(r27, r17.f1507d);
        r40 = 79;
        goto L102
    L45:
        r32 = r11.getInt(r27, r15.f1514b);
        r33 = 78;
        goto L117
    L46:
        int r41 = 77;
    L115:
        r24.c(r41, r11.getString(r27));
        goto L118
    L47:
        r32 = r11.getInt(r27, r17.f1506c);
        r33 = 76;
        goto L117
    L48:
        r29 = r11.getBoolean(r27, r18.f1489n0);
        r30 = 75;
        goto L49
    L50:
        r41 = 74;
        goto L115
    L51:
        r32 = r11.getDimensionPixelSize(r27, r18.f1475g0);
        r33 = 73;
        goto L117
    L52:
        r32 = r11.getInt(r27, r18.f1473f0);
        r33 = 72;
        goto L117
    L53:
        r12 = r12;
        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
        goto L118
    L54:
        int r42 = 70;
    L56:
        r24.a(r42, r11.getFloat(r27, 1.0f));
        goto L118
    L55:
        r42 = 69;
        goto L56
    L57:
        r39 = r11.getFloat(r27, r15.f1516d);
        r40 = 68;
        goto L102
    L58:
        r39 = r11.getFloat(r27, r17.f1508e);
        r40 = 67;
        goto L102
    L59:
        r12 = r12;
        r24.b(66, r11.getInt(r27, 0));
        goto L118
    L60:
        r12 = r12;
        if (r11.peekValue(r27).type != 3) goto L63;
        String r43 = r11.getString(r27);
    L64:
        r24.c(65, r43);
        goto L118
    L63:
        r43 = r12[r11.getInteger(r27, 0)];
        goto L64
    L65:
        r32 = g(r11, r27, r17.f1504a);
        r33 = 64;
        goto L117
    L66:
        r39 = r11.getFloat(r27, r18.B);
        r40 = 63;
        goto L102
    L67:
        r32 = r11.getDimensionPixelSize(r27, r18.A);
        r33 = 62;
        goto L117
    L68:
        r39 = r11.getFloat(r27, r16.f1518a);
        r40 = 60;
        goto L102
    L69:
        r32 = r11.getDimensionPixelSize(r27, r18.f1468c0);
        r33 = 59;
        goto L117
    L70:
        r32 = r11.getDimensionPixelSize(r27, r18.f1466b0);
        r33 = 58;
        goto L117
    L71:
        r32 = r11.getDimensionPixelSize(r27, r18.f1464a0);
        r33 = 57;
        goto L117
    L72:
        r32 = r11.getDimensionPixelSize(r27, r18.Z);
        r33 = 56;
        goto L117
    L73:
        r32 = r11.getInt(r27, r18.Y);
        r33 = 55;
        goto L117
    L74:
        r32 = r11.getInt(r27, r18.X);
        r33 = 54;
        goto L117
    L75:
        r39 = r11.getDimension(r27, r16.f1528k);
        r40 = 53;
        goto L102
    L76:
        r39 = r11.getDimension(r27, r16.f1527j);
        r40 = 52;
        goto L102
    L77:
        r39 = r11.getDimension(r27, r16.f1526i);
        r40 = 51;
        goto L102
    L78:
        r39 = r11.getDimension(r27, r16.f1524g);
        r40 = 50;
        goto L102
    L79:
        r39 = r11.getDimension(r27, r16.f1523f);
        r40 = 49;
        goto L102
    L80:
        r39 = r11.getFloat(r27, r16.f1522e);
        r40 = 48;
        goto L102
    L81:
        r39 = r11.getFloat(r27, r16.f1521d);
        r40 = 47;
        goto L102
    L82:
        r39 = r11.getFloat(r27, r16.f1520c);
        r40 = 46;
        goto L102
    L83:
        r39 = r11.getFloat(r27, r16.f1519b);
        r40 = 45;
        goto L102
    L84:
        r12 = r12;
        r24.d(44, true);
        r24.a(44, r11.getDimension(r27, r16.f1530m));
        goto L118
    L85:
        r39 = r11.getFloat(r27, r15.f1515c);
        r40 = 43;
        goto L102
    L86:
        r32 = r11.getInt(r27, r18.W);
        r33 = 42;
        goto L117
    L87:
        r32 = r11.getInt(r27, r18.V);
        r33 = 41;
        goto L117
    L88:
        r39 = r11.getFloat(r27, r18.T);
        r40 = 40;
        goto L102
    L89:
        r39 = r11.getFloat(r27, r18.U);
        r40 = 39;
        goto L102
    L90:
        r32 = r11.getResourceId(r27, r8.f1444a);
        r8.f1444a = r32;
        r33 = 38;
        goto L117
    L91:
        r39 = r11.getFloat(r27, r18.f1500x);
        r40 = 37;
        goto L102
    L92:
        r32 = r11.getDimensionPixelSize(r27, r18.H);
        r33 = 34;
        goto L117
    L93:
        r32 = r11.getDimensionPixelSize(r27, r18.K);
        r33 = 31;
        goto L117
    L94:
        r32 = r11.getDimensionPixelSize(r27, r18.G);
        r33 = 28;
        goto L117
    L95:
        r32 = r11.getInt(r27, r18.E);
        r33 = 27;
        goto L117
    L96:
        r32 = r11.getDimensionPixelSize(r27, r18.F);
        r33 = 24;
        goto L117
    L97:
        r32 = r11.getLayoutDimension(r27, r18.f1465b);
        r33 = 23;
        goto L117
    L98:
        r32 = r13[r11.getInt(r27, r15.f1513a)];
        r33 = 22;
        goto L117
    L99:
        r32 = r11.getLayoutDimension(r27, r18.f1467c);
        r33 = 21;
        goto L117
    L100:
        r39 = r11.getFloat(r27, r18.f1499w);
        r40 = 20;
        goto L102
    L101:
        r39 = r11.getFloat(r27, r18.f1472f);
        r40 = 19;
        goto L102
    L103:
        r32 = r11.getDimensionPixelOffset(r27, r18.f1470e);
        r33 = 18;
        goto L117
    L104:
        r32 = r11.getDimensionPixelOffset(r27, r18.f1469d);
        r33 = 17;
        goto L117
    L105:
        r32 = r11.getDimensionPixelSize(r27, r18.N);
        r33 = 16;
        goto L117
    L106:
        r32 = r11.getDimensionPixelSize(r27, r18.R);
        r33 = 15;
        goto L117
    L107:
        r32 = r11.getDimensionPixelSize(r27, r18.O);
        r33 = 14;
        goto L117
    L108:
        r32 = r11.getDimensionPixelSize(r27, r18.M);
        r33 = 13;
        goto L117
    L109:
        r32 = r11.getDimensionPixelSize(r27, r18.Q);
        r33 = 12;
        goto L117
    L110:
        r32 = r11.getDimensionPixelSize(r27, r18.P);
        r33 = 11;
        goto L117
    L111:
        r32 = r11.getDimensionPixelSize(r27, r18.J);
        r33 = 8;
        goto L117
    L112:
        r32 = r11.getDimensionPixelOffset(r27, r18.D);
        r33 = 7;
        goto L117
    L113:
        r32 = r11.getDimensionPixelOffset(r27, r18.C);
        r33 = 6;
        goto L117
    L114:
        r41 = 5;
        goto L115
    L116:
        r32 = r11.getDimensionPixelSize(r27, r18.I);
        r33 = 2;
    L247:
        r11.recycle();
        return r8;
    L120:
        int r44 = r11.getIndexCount();
        int r45 = 0;
    L121:
        if (r45 >= r44) goto L245;
        int r46 = r11.getIndex(r45);
        int r210 = r44;
        if (r46 == 1) goto L131;
        if (23 == r46) goto L131;
        if (24 == r46) goto L131;
        r17.getClass();
        r18.getClass();
        r15.getClass();
        r16.getClass();
    L131:
        switch(r14.get(r46)) {
            case 1: goto L242;
            case 2: goto L241;
            case 3: goto L240;
            case 4: goto L239;
            case 5: goto L238;
            case 6: goto L237;
            case 7: goto L236;
            case 8: goto L235;
            case 9: goto L234;
            case 10: goto L233;
            case 11: goto L232;
            case 12: goto L231;
            case 13: goto L230;
            case 14: goto L229;
            case 15: goto L228;
            case 16: goto L227;
            case 17: goto L226;
            case 18: goto L225;
            case 19: goto L224;
            case 20: goto L223;
            case 21: goto L222;
            case 22: goto L221;
            case 23: goto L220;
            case 24: goto L219;
            case 25: goto L218;
            case 26: goto L217;
            case 27: goto L216;
            case 28: goto L215;
            case 29: goto L214;
            case 30: goto L213;
            case 31: goto L212;
            case 32: goto L211;
            case 33: goto L210;
            case 34: goto L209;
            case 35: goto L208;
            case 36: goto L207;
            case 37: goto L206;
            case 38: goto L205;
            case 39: goto L204;
            case 40: goto L203;
            case 41: goto L202;
            case 42: goto L201;
            case 43: goto L200;
            case 44: goto L199;
            case 45: goto L198;
            case 46: goto L197;
            case 47: goto L196;
            case 48: goto L195;
            case 49: goto L194;
            case 50: goto L193;
            case 51: goto L192;
            case 52: goto L191;
            case 53: goto L190;
            case 54: goto L189;
            case 55: goto L188;
            case 56: goto L187;
            case 57: goto L186;
            case 58: goto L185;
            case 59: goto L184;
            case 60: goto L183;
            case 61: goto L182;
            case 62: goto L181;
            case 63: goto L180;
            case 64: goto L179;
            case 65: goto L175;
            case 66: goto L173;
            case 67: goto L172;
            case 68: goto L171;
            case 69: goto L170;
            case 70: goto L169;
            case 71: goto L168;
            case 72: goto L167;
            case 73: goto L166;
            case 74: goto L165;
            case 75: goto L164;
            case 76: goto L163;
            case 77: goto L162;
            case 78: goto L161;
            case 79: goto L160;
            case 80: goto L159;
            case 81: goto L158;
            case 82: goto L157;
            case 83: goto L156;
            case 84: goto L155;
            case 85: goto L154;
            case 86: goto L144;
            case 87: goto L142;
            case 88: goto L132;
            case 89: goto L132;
            case 90: goto L132;
            case 91: goto L140;
            case 92: goto L139;
            case 93: goto L138;
            case 94: goto L137;
            case 95: goto L135;
            case 96: goto L134;
            case 97: goto L133;
            default: goto L132;
        };
    L132:
        r19 = r19;
        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(r46) + "   " + r14.get(r46));
    L243:
        r45 = r45 + 1;
        r44 = r210;
        r19 = r19;
        goto L121
    L133:
        r18.f1491o0 = r11.getInt(r46, r18.f1491o0);
        goto L243
    L134:
        int r47 = 1;
    L136:
        h(r18, r11, r46, r47);
        goto L243
    L135:
        r47 = 0;
        goto L136
    L137:
        r18.S = r11.getDimensionPixelSize(r46, r18.S);
        goto L243
    L138:
        r18.L = r11.getDimensionPixelSize(r46, r18.L);
        goto L243
    L139:
        r18.f1494r = g(r11, r46, r18.f1494r);
        goto L243
    L140:
        r18.f1493q = g(r11, r46, r18.f1493q);
        goto L243
    L142:
        Log.w("ConstraintSet", r19 + Integer.toHexString(r46) + "   " + r14.get(r46));
        goto L243
    L144:
        r19 = r19;
        int r48 = r11.peekValue(r46).type;
        if (r48 != 1) goto L148;
        r17.f1512i = r11.getResourceId(r46, -1);
        goto L243
    L148:
        if (r48 != 3) goto L153;
        String r49 = r11.getString(r46);
        r17.f1511h = r49;
        if (r49.indexOf("/") <= 0) goto L243;
        r17.f1512i = r11.getResourceId(r46, -1);
    L174:
        r17.getClass();
        goto L243
    L153:
        r11.getInteger(r46, r17.f1512i);
        goto L174
    L154:
        r19 = r19;
        r17.f1509f = r11.getFloat(r46, r17.f1509f);
        goto L243
    L155:
        r19 = r19;
        r17.f1510g = r11.getInteger(r46, r17.f1510g);
        goto L243
    L156:
        r19 = r19;
        r16.f1525h = g(r11, r46, r16.f1525h);
        goto L243
    L157:
        r19 = r19;
        r17.f1505b = r11.getInteger(r46, r17.f1505b);
        goto L243
    L158:
        r19 = r19;
        r18.f1487m0 = r11.getBoolean(r46, r18.f1487m0);
        goto L243
    L159:
        r19 = r19;
        r18.f1485l0 = r11.getBoolean(r46, r18.f1485l0);
        goto L243
    L160:
        r19 = r19;
        r17.f1507d = r11.getFloat(r46, r17.f1507d);
        goto L243
    L161:
        r19 = r19;
        r15.f1514b = r11.getInt(r46, r15.f1514b);
        goto L243
    L162:
        r19 = r19;
        r18.f1483k0 = r11.getString(r46);
        goto L243
    L163:
        r19 = r19;
        r17.f1506c = r11.getInt(r46, r17.f1506c);
        goto L243
    L164:
        r19 = r19;
        r18.f1489n0 = r11.getBoolean(r46, r18.f1489n0);
        goto L243
    L165:
        r19 = r19;
        r18.f1481j0 = r11.getString(r46);
        goto L243
    L166:
        r19 = r19;
        r18.f1475g0 = r11.getDimensionPixelSize(r46, r18.f1475g0);
        goto L243
    L167:
        r19 = r19;
        r18.f1473f0 = r11.getInt(r46, r18.f1473f0);
        goto L243
    L168:
        r19 = r19;
        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
        goto L243
    L169:
        r19 = r19;
        r18.f1471e0 = r11.getFloat(r46, 1.0f);
        goto L243
    L170:
        r19 = r19;
        r18.d0 = r11.getFloat(r46, 1.0f);
        goto L243
    L171:
        r19 = r19;
        r15.f1516d = r11.getFloat(r46, r15.f1516d);
        goto L243
    L172:
        r19 = r19;
        r17.f1508e = r11.getFloat(r46, r17.f1508e);
        goto L243
    L173:
        r19 = r19;
        r11.getInt(r46, 0);
        goto L174
    L175:
        r19 = r19;
        if (r11.peekValue(r46).type != 3) goto L178;
        r11.getString(r46);
        goto L174
    L178:
        String r50 = r12[r11.getInteger(r46, 0)];
        goto L174
    L179:
        r19 = r19;
        r17.f1504a = g(r11, r46, r17.f1504a);
        goto L243
    L180:
        r19 = r19;
        r18.B = r11.getFloat(r46, r18.B);
        goto L243
    L181:
        r19 = r19;
        r18.A = r11.getDimensionPixelSize(r46, r18.A);
        goto L243
    L182:
        r19 = r19;
        r18.f1502z = g(r11, r46, r18.f1502z);
        goto L243
    L183:
        r19 = r19;
        r16.f1518a = r11.getFloat(r46, r16.f1518a);
        goto L243
    L184:
        r19 = r19;
        r18.f1468c0 = r11.getDimensionPixelSize(r46, r18.f1468c0);
        goto L243
    L185:
        r19 = r19;
        r18.f1466b0 = r11.getDimensionPixelSize(r46, r18.f1466b0);
        goto L243
    L186:
        r19 = r19;
        r18.f1464a0 = r11.getDimensionPixelSize(r46, r18.f1464a0);
        goto L243
    L187:
        r19 = r19;
        r18.Z = r11.getDimensionPixelSize(r46, r18.Z);
        goto L243
    L188:
        r19 = r19;
        r18.Y = r11.getInt(r46, r18.Y);
        goto L243
    L189:
        r19 = r19;
        r18.X = r11.getInt(r46, r18.X);
        goto L243
    L190:
        r19 = r19;
        r16.f1528k = r11.getDimension(r46, r16.f1528k);
        goto L243
    L191:
        r19 = r19;
        r16.f1527j = r11.getDimension(r46, r16.f1527j);
        goto L243
    L192:
        r19 = r19;
        r16.f1526i = r11.getDimension(r46, r16.f1526i);
        goto L243
    L193:
        r19 = r19;
        r16.f1524g = r11.getDimension(r46, r16.f1524g);
        goto L243
    L194:
        r19 = r19;
        r16.f1523f = r11.getDimension(r46, r16.f1523f);
        goto L243
    L195:
        r19 = r19;
        r16.f1522e = r11.getFloat(r46, r16.f1522e);
        goto L243
    L196:
        r19 = r19;
        r16.f1521d = r11.getFloat(r46, r16.f1521d);
        goto L243
    L197:
        r19 = r19;
        r16.f1520c = r11.getFloat(r46, r16.f1520c);
        goto L243
    L198:
        r19 = r19;
        r16.f1519b = r11.getFloat(r46, r16.f1519b);
        goto L243
    L199:
        r19 = r19;
        r16.f1529l = true;
        r16.f1530m = r11.getDimension(r46, r16.f1530m);
        goto L243
    L200:
        r19 = r19;
        r15.f1515c = r11.getFloat(r46, r15.f1515c);
        goto L243
    L201:
        r19 = r19;
        r18.W = r11.getInt(r46, r18.W);
        goto L243
    L202:
        r19 = r19;
        r18.V = r11.getInt(r46, r18.V);
        goto L243
    L203:
        r19 = r19;
        r18.T = r11.getFloat(r46, r18.T);
        goto L243
    L204:
        r19 = r19;
        r18.U = r11.getFloat(r46, r18.U);
        goto L243
    L205:
        r19 = r19;
        r8.f1444a = r11.getResourceId(r46, r8.f1444a);
        goto L243
    L206:
        r19 = r19;
        r18.f1500x = r11.getFloat(r46, r18.f1500x);
        goto L243
    L207:
        r19 = r19;
        r18.f1484l = g(r11, r46, r18.f1484l);
        goto L243
    L208:
        r19 = r19;
        r18.f1486m = g(r11, r46, r18.f1486m);
        goto L243
    L209:
        r19 = r19;
        r18.H = r11.getDimensionPixelSize(r46, r18.H);
        goto L243
    L210:
        r19 = r19;
        r18.f1496t = g(r11, r46, r18.f1496t);
        goto L243
    L211:
        r19 = r19;
        r18.f1495s = g(r11, r46, r18.f1495s);
        goto L243
    L212:
        r19 = r19;
        r18.K = r11.getDimensionPixelSize(r46, r18.K);
        goto L243
    L213:
        r19 = r19;
        r18.f1482k = g(r11, r46, r18.f1482k);
        goto L243
    L214:
        r19 = r19;
        r18.f1480j = g(r11, r46, r18.f1480j);
        goto L243
    L215:
        r19 = r19;
        r18.G = r11.getDimensionPixelSize(r46, r18.G);
        goto L243
    L216:
        r19 = r19;
        r18.E = r11.getInt(r46, r18.E);
        goto L243
    L217:
        r19 = r19;
        r18.f1478i = g(r11, r46, r18.f1478i);
        goto L243
    L218:
        r19 = r19;
        r18.f1476h = g(r11, r46, r18.f1476h);
        goto L243
    L219:
        r19 = r19;
        r18.F = r11.getDimensionPixelSize(r46, r18.F);
        goto L243
    L220:
        r19 = r19;
        r18.f1465b = r11.getLayoutDimension(r46, r18.f1465b);
        goto L243
    L221:
        r19 = r19;
        r15.f1513a = r13[r11.getInt(r46, r15.f1513a)];
        goto L243
    L222:
        r19 = r19;
        r18.f1467c = r11.getLayoutDimension(r46, r18.f1467c);
        goto L243
    L223:
        r19 = r19;
        r18.f1499w = r11.getFloat(r46, r18.f1499w);
        goto L243
    L224:
        r19 = r19;
        r18.f1472f = r11.getFloat(r46, r18.f1472f);
        goto L243
    L225:
        r19 = r19;
        r18.f1470e = r11.getDimensionPixelOffset(r46, r18.f1470e);
        goto L243
    L226:
        r19 = r19;
        r18.f1469d = r11.getDimensionPixelOffset(r46, r18.f1469d);
        goto L243
    L227:
        r19 = r19;
        r18.N = r11.getDimensionPixelSize(r46, r18.N);
        goto L243
    L228:
        r19 = r19;
        r18.R = r11.getDimensionPixelSize(r46, r18.R);
        goto L243
    L229:
        r19 = r19;
        r18.O = r11.getDimensionPixelSize(r46, r18.O);
        goto L243
    L230:
        r19 = r19;
        r18.M = r11.getDimensionPixelSize(r46, r18.M);
        goto L243
    L231:
        r19 = r19;
        r18.Q = r11.getDimensionPixelSize(r46, r18.Q);
        goto L243
    L232:
        r19 = r19;
        r18.P = r11.getDimensionPixelSize(r46, r18.P);
        goto L243
    L233:
        r19 = r19;
        r18.f1497u = g(r11, r46, r18.f1497u);
        goto L243
    L234:
        r19 = r19;
        r18.f1498v = g(r11, r46, r18.f1498v);
        goto L243
    L235:
        r19 = r19;
        r18.J = r11.getDimensionPixelSize(r46, r18.J);
        goto L243
    L236:
        r19 = r19;
        r18.D = r11.getDimensionPixelOffset(r46, r18.D);
        goto L243
    L237:
        r19 = r19;
        r18.C = r11.getDimensionPixelOffset(r46, r18.C);
        goto L243
    L238:
        r19 = r19;
        r18.f1501y = r11.getString(r46);
        goto L243
    L239:
        r19 = r19;
        r18.f1488n = g(r11, r46, r18.f1488n);
        goto L243
    L240:
        r19 = r19;
        r18.f1490o = g(r11, r46, r18.f1490o);
        goto L243
    L241:
        r19 = r19;
        r18.I = r11.getDimensionPixelSize(r46, r18.I);
        goto L243
    L242:
        r19 = r19;
        r18.f1492p = g(r11, r46, r18.f1492p);
        goto L243
    L245:
        if (r18.f1481j0 == null) goto L247;
        r18.f1479i0 = null;
        goto L247
    L5:
        r10 = v.d.f12655a;
        goto L6
    }

    public static int g(TypedArray r8, int r10, int r11) {
        int r12 = r8.getResourceId(r10, r11);
        if (r12 == (-1)) goto L5;
        return r12;
    L5:
        return r8.getInt(r10, -1);
    }

    public static void h(Object r8, TypedArray r10, int r11, int r12) {
        if (r8 != null) goto L4;
        return;
    L4:
        int r13 = r10.peekValue(r11).type;
        boolean r14 = true;
        int r15 = 0;
        if (r13 == 3) goto L37;
        if (r13 == 5) goto L15;
        int r16 = r10.getInt(r11, 0);
        if (r16 != (-4)) goto L10;
        r15 = -2;
    L18:
        if ((r8 instanceof ConstraintLayout.a) == false) goto L24;
        ConstraintLayout.a r17 = (ConstraintLayout.a) r8;
        if (r12 != 0) goto L22;
        ((ViewGroup.MarginLayoutParams) r17).width = r15;
        r17.W = r14;
        return;
    L22:
        ((ViewGroup.MarginLayoutParams) r17).height = r15;
        r17.X = r14;
        return;
    L24:
        if ((r8 instanceof b) == false) goto L30;
        b r18 = (b) r8;
        if (r12 != 0) goto L28;
        r18.f1465b = r15;
        r18.f1485l0 = r14;
        return;
    L28:
        r18.f1467c = r15;
        r18.f1487m0 = r14;
        return;
    L30:
        if ((r8 instanceof a.C0008a) == false) goto L111;
        a.C0008a r19 = (a.C0008a) r8;
        if (r12 != 0) goto L34;
        r19.b(23, r15);
        int r20 = 80;
    L35:
        r19.d(r20, r14);
        return;
    L34:
        r19.b(21, r15);
        r20 = 81;
        goto L35
    L111:
        return;
    L10:
        if (r16 == (-3)) goto L13;
        if (r16 == (-2)) goto L16;
        if (r16 != (-1)) goto L13;
    L16:
        r14 = false;
        r15 = r16;
    L13:
        r14 = false;
        goto L18
    L15:
        r16 = r10.getDimensionPixelSize(r11, 0);
        goto L16
    L37:
        String r21 = r10.getString(r11);
        if (r21 == null) goto L130;
        int r110 = r21.indexOf(61);
        int r22 = r21.length();
        if (r110 > 0) goto L43;
        return;
    L43:
        if (r110 >= (r22 - 1)) goto L113;
        String r23 = r21.substring(0, r110);
        String r24 = r21.substring(r110 + 1);
        if (r24.length() <= 0) goto L114;
        String r111 = r23.trim();
        String r25 = r24.trim();
        if ("ratio".equalsIgnoreCase(r111) == false) goto L106;
        if ((r8 instanceof ConstraintLayout.a) == false) goto L56;
        ConstraintLayout.a r26 = (ConstraintLayout.a) r8;
        if (r12 != 0) goto L53;
        ((ViewGroup.MarginLayoutParams) r26).width = 0;
    L54:
        i(r26, r25);
        return;
    L53:
        ((ViewGroup.MarginLayoutParams) r26).height = 0;
        goto L54
    L56:
        if ((r8 instanceof b) == false) goto L59;
        ((b) r8).f1501y = r25;
        return;
    L59:
        if ((r8 instanceof a.C0008a) == false) goto L117;
        ((a.C0008a) r8).c(5, r25);
        return;
    L117:
        return;
    L106:
        if ("weight".equalsIgnoreCase(r111) == false) goto L84;
        float r27 = Float.parseFloat(r25);     // Catch: NumberFormatException -> L105
        if ((r8 instanceof ConstraintLayout.a) == false) goto L70;
        ConstraintLayout.a r28 = (ConstraintLayout.a) r8;     // Catch: NumberFormatException -> L105
        if (r12 != 0) goto L68;
        ((ViewGroup.MarginLayoutParams) r28).width = 0;     // Catch: NumberFormatException -> L105
        r28.H = r27;     // Catch: NumberFormatException -> L105
        return;
    L68:
        ((ViewGroup.MarginLayoutParams) r28).height = 0;     // Catch: NumberFormatException -> L105
        r28.I = r27;     // Catch: NumberFormatException -> L105
        return;
    L70:
        if ((r8 instanceof b) == false) goto L76;
        b r29 = (b) r8;     // Catch: NumberFormatException -> L105
        if (r12 != 0) goto L74;
        r29.f1465b = 0;     // Catch: NumberFormatException -> L105
        r29.U = r27;     // Catch: NumberFormatException -> L105
        return;
    L74:
        r29.f1467c = 0;     // Catch: NumberFormatException -> L105
        r29.T = r27;     // Catch: NumberFormatException -> L105
        return;
    L76:
        if ((r8 instanceof a.C0008a) == false) goto L123;
        a.C0008a r30 = (a.C0008a) r8;     // Catch: NumberFormatException -> L105
        if (r12 != 0) goto L80;
        r30.b(23, 0);     // Catch: NumberFormatException -> L105
        int r112 = 39;
    L81:
        r30.a(r112, r27);     // Catch: NumberFormatException -> L105
        return;
    L80:
        r30.b(21, 0);     // Catch: NumberFormatException -> L105
        r112 = 40;
        goto L81
    L123:
        return;
    L84:
        if ("parent".equalsIgnoreCase(r111) == false) goto L124;
        float r31 = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(r25)));     // Catch: NumberFormatException -> L105
        if ((r8 instanceof ConstraintLayout.a) == false) goto L92;
        ConstraintLayout.a r32 = (ConstraintLayout.a) r8;     // Catch: NumberFormatException -> L105
        if (r12 != 0) goto L90;
        ((ViewGroup.MarginLayoutParams) r32).width = 0;     // Catch: NumberFormatException -> L105
        r32.R = r31;     // Catch: NumberFormatException -> L105
        r32.L = 2;     // Catch: NumberFormatException -> L105
        return;
    L90:
        ((ViewGroup.MarginLayoutParams) r32).height = 0;     // Catch: NumberFormatException -> L105
        r32.S = r31;     // Catch: NumberFormatException -> L105
        r32.M = 2;     // Catch: NumberFormatException -> L105
        return;
    L92:
        if ((r8 instanceof b) == false) goto L98;
        b r33 = (b) r8;     // Catch: NumberFormatException -> L105
        if (r12 != 0) goto L96;
        r33.f1465b = 0;     // Catch: NumberFormatException -> L105
        r33.d0 = r31;     // Catch: NumberFormatException -> L105
        r33.X = 2;     // Catch: NumberFormatException -> L105
        return;
    L96:
        r33.f1467c = 0;     // Catch: NumberFormatException -> L105
        r33.f1471e0 = r31;     // Catch: NumberFormatException -> L105
        r33.Y = 2;     // Catch: NumberFormatException -> L105
        return;
    L98:
        if ((r8 instanceof a.C0008a) == false) goto L129;
        a.C0008a r34 = (a.C0008a) r8;     // Catch: NumberFormatException -> L105
        if (r12 != 0) goto L102;
        r34.b(23, 0);     // Catch: NumberFormatException -> L105
        int r35 = 54;
    L103:
        r34.b(r35, 2);     // Catch: NumberFormatException -> L105
        return;
    L102:
        r34.b(21, 0);     // Catch: NumberFormatException -> L105
        r35 = 55;
        goto L103
    L129:
        return;
    L124:
        return;
    L132:
        return;
    L114:
        return;
    L113:
        return;
    }

    public static void i(ConstraintLayout.a r8, String r10) {
        if (r10 == null) goto L33;
        int r11 = r10.length();
        int r12 = r10.indexOf(44);
        byte r13 = -1;
        int r14 = 0;
        if (r12 > 0) goto L6;
    L14:
        int r15 = r10.indexOf(58);
        if (r15 >= 0) goto L17;
    L30:
        String r16 = r10.substring(r14);
        if (r16.length() <= 0) goto L33;
        Float.parseFloat(r16);     // Catch: NumberFormatException -> L35
    L36:
        goto L33
    L17:
        if (r15 >= (r11 - 1)) goto L30;
        String r17 = r10.substring(r14, r15);
        String r18 = r10.substring(r15 + 1);
        if (r17.length() <= 0) goto L33;
        if (r18.length() <= 0) goto L33;
        float r19 = Float.parseFloat(r17);     // Catch: NumberFormatException -> L35
        float r20 = Float.parseFloat(r18);     // Catch: NumberFormatException -> L35
        if (r19 <= 0.0f) goto L36;
        if (r20 <= 0.0f) goto L36;
        if (r13 != 1) goto L28;
        Math.abs(r20 / r19);     // Catch: NumberFormatException -> L35
        goto L36
    L28:
        Math.abs(r19 / r20);     // Catch: NumberFormatException -> L35
        goto L36
    L6:
        if (r12 >= (r11 - 1)) goto L14;
        String r21 = r10.substring(0, r12);
        if (r21.equalsIgnoreCase("W") == false) goto L11;
        r13 = 0;
    L13:
        r14 = r12 + 1;
        goto L14
    L11:
        if (r21.equalsIgnoreCase("H") == false) goto L13;
        r13 = 1;
    L33:
        r8.G = r10;
    }

    public final void a(ConstraintLayout r8) {
        b(r8);
        r8.setConstraintSet(null);
        r8.requestLayout();
    }

    public final void b(ConstraintLayout r12) {
        int r8 = r12.getChildCount();
        HashMap<Integer, a> r10 = this.f1443c;
        HashSet r11 = new HashSet(r10.keySet());
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r14 >= r8) goto L52;
        View r15 = r12.getChildAt(r14);
        int r16 = r15.getId();
        if (r10.containsKey(Integer.valueOf(r16)) == true) goto L9;
        Log.w("ConstraintSet", "id unknown " + u.a.b(r15));
    L51:
        r14 = r14 + 1;
        goto L4
    L9:
        if (this.f1442b == false) goto L14;
        if (r16 != (-1)) goto L14;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L14:
        if (r16 == (-1)) goto L51;
        if (r10.containsKey(Integer.valueOf(r16)) == false) goto L50;
        r11.remove(Integer.valueOf(r16));
        a r17 = r10.get(Integer.valueOf(r16));
        if (r17 == null) goto L51;
        if ((r15 instanceof androidx.constraintlayout.widget.a) == false) goto L29;
        b r18 = r17.f1447d;
        r18.f1477h0 = 1;
        androidx.constraintlayout.widget.a r19 = (androidx.constraintlayout.widget.a) r15;
        r19.setId(r16);
        r19.setType(r18.f1473f0);
        r19.setMargin(r18.f1475g0);
        r19.setAllowsGoneWidget(r18.f1489n0);
        int[] r20 = r18.f1479i0;
        if (r20 == null) goto L26;
        r19.setReferencedIds(r20);
        goto L29
    L26:
        String r21 = r18.f1481j0;
        if (r21 == null) goto L29;
        int[] r22 = d(r19, r21);
        r18.f1479i0 = r22;
        r19.setReferencedIds(r22);
    L29:
        ConstraintLayout.a r23 = (ConstraintLayout.a) r15.getLayoutParams();
        r23.a();
        r17.a(r23);
        androidx.constraintlayout.widget.b.b(r15, r17.f1449f);
        r15.setLayoutParams(r23);
        C0009d r24 = r17.f1445b;
        if (r24.f1514b != 0) goto L32;
        r15.setVisibility(r24.f1513a);
    L32:
        r15.setAlpha(r24.f1515c);
        e r25 = r17.f1448e;
        r15.setRotation(r25.f1518a);
        r15.setRotationX(r25.f1519b);
        r15.setRotationY(r25.f1520c);
        r15.setScaleX(r25.f1521d);
        r15.setScaleY(r25.f1522e);
        if (r25.f1525h == (-1)) goto L42;
        View r26 = ((View) r15.getParent()).findViewById(r25.f1525h);
        if (r26 == null) goto L47;
        float r27 = (r26.getBottom() + r26.getTop()) / 2.0f;
        float r28 = (r26.getRight() + r26.getLeft()) / 2.0f;
        if ((r15.getRight() - r15.getLeft()) <= 0) goto L47;
        if ((r15.getBottom() - r15.getTop()) <= 0) goto L47;
        float r29 = r28 - r15.getLeft();
        float r30 = r27 - r15.getTop();
        r15.setPivotX(r29);
        r15.setPivotY(r30);
    L47:
        r15.setTranslationX(r25.f1526i);
        r15.setTranslationY(r25.f1527j);
        r15.setTranslationZ(r25.f1528k);
        if (r25.f1529l == false) goto L51;
        r15.setElevation(r25.f1530m);
        goto L51
    L42:
        if (Float.isNaN(r25.f1523f) == true) goto L45;
        r15.setPivotX(r25.f1523f);
    L45:
        if (Float.isNaN(r25.f1524g) == true) goto L47;
        r15.setPivotY(r25.f1524g);
        goto L47
    L50:
        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + r16);
        goto L51
    L52:
        Iterator r110 = r11.iterator();
    L54:
        if (r110.hasNext() == false) goto L70;
        Integer r31 = (Integer) r110.next();
        a r32 = r10.get(r31);
        if (r32 == null) goto L54;
        b r33 = r32.f1447d;
        if (r33.f1477h0 != 1) goto L68;
        androidx.constraintlayout.widget.a r34 = new androidx.constraintlayout.widget.a(r12.getContext());
        r34.setId(r31.intValue());
        int[] r35 = r33.f1479i0;
        if (r35 == null) goto L63;
        r34.setReferencedIds(r35);
    L66:
        r34.setType(r33.f1473f0);
        r34.setMargin(r33.f1475g0);
        v.e r36 = ConstraintLayout.f1342z;
        ConstraintLayout.a r37 = new ConstraintLayout.a(-2, -2);
        r34.k();
        r32.a(r37);
        r12.addView(r34, r37);
        goto L68
    L63:
        String r38 = r33.f1481j0;
        if (r38 == null) goto L66;
        int[] r39 = d(r34, r38);
        r33.f1479i0 = r39;
        r34.setReferencedIds(r39);
    L68:
        if (r33.f1463a == false) goto L54;
        View r40 = new Guideline(r12.getContext());
        r40.setId(r31.intValue());
        v.e r41 = ConstraintLayout.f1342z;
        ConstraintLayout.a r42 = new ConstraintLayout.a(-2, -2);
        r32.a(r42);
        r12.addView(r40, r42);
    L70:
        if (r13 >= r8) goto L75;
        View r111 = r12.getChildAt(r13);
        if ((r111 instanceof androidx.constraintlayout.widget.c) == false) goto L74;
        ((androidx.constraintlayout.widget.c) r111).g(r12);
    L74:
        r13 = r13 + 1;
        goto L70
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v14 */
    /* JADX WARN: Type inference failed for: r16v15 */
    /* JADX WARN: Type inference failed for: r16v16 */
    /* JADX WARN: Type inference failed for: r16v17 */
    /* JADX WARN: Type inference failed for: r16v18 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r16v9 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    public final void c(ConstraintLayout r19) {
        d r8 = this;
        int r10 = r19.getChildCount();
        HashMap<Integer, a> r11 = r8.f1443c;
        r11.clear();
        int r12 = 0;
        ?? r13 = r11;
    L3:
        if (r12 >= r10) goto L70;
        View r14 = r19.getChildAt(r12);
        ConstraintLayout.a r15 = (ConstraintLayout.a) r14.getLayoutParams();
        int r16 = r14.getId();
        if (r8.f1442b == false) goto L12;
        if (r16 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (r13.containsKey(Integer.valueOf(r16)) == true) goto L14;
        r13.put(Integer.valueOf(r16), new a());
    L14:
        a r17 = (a) r13.get(Integer.valueOf(r16));
        if (r17 != null) goto L17;
        int r18 = r10;
        ?? r110 = r13;
    L69:
        r12 = r12 + 1;
        r8 = this;
        r13 = r110;
        r10 = r18;
        goto L3
    L17:
        HashMap<String, androidx.constraintlayout.widget.b> r111 = r8.f1441a;
        HashMap r112 = new HashMap();
        Class<?> r113 = r14.getClass();
        Iterator<String> r114 = r111.keySet().iterator();
        ?? r20 = r13;
    L19:
        if (r114.hasNext() == false) goto L58;
        String r21 = r114.next();
        androidx.constraintlayout.widget.b r22 = r111.get(r21);
    L47:
        e = e;
        int r115 = r10;
    L49:
        r20 = r20;
    L50:
        StringBuilder r23 = new StringBuilder(" Custom Attribute \"");
        ?? r116 = r20;
    L51:
        r23.append(r21);
        r23.append("\" not found on ");
        r21 = r113.getName();
        r20 = r116;
    L56:
        r23.append(r21);
        Log.e("TransitionLayout", r23.toString(), e);
    L57:
        r20 = r20;
        r10 = r115;
    L52:
        e = e;
        r115 = r10;
    L54:
        r20 = r20;
    L55:
        r23 = new StringBuilder();
        r23.append(r113.getName());
        r23.append(" must have a method ");
        r20 = r20;
    L43:
        e = e;
        r115 = r10;
    L45:
        r20 = r20;
    L46:
        r23 = new StringBuilder(" Custom Attribute \"");
        r116 = r20;
        goto L51
    L22:
        if (r21.equals("BackgroundColor") == false) goto L26;
        r115 = r10;
        r20 = new androidx.constraintlayout.widget.b(r22, Integer.valueOf(((ColorDrawable) r14.getBackground()).getColor()));     // Catch: InvocationTargetException -> L37 IllegalAccessException -> L39 NoSuchMethodException -> L41
        ?? r24 = r20;
    L73:
        r112.put(r21, r24);     // Catch: InvocationTargetException -> L31 IllegalAccessException -> L33 NoSuchMethodException -> L35
    L33:
        e = e;
    L35:
        e = e;
    L31:
        e = e;
    L39:
        e = e;
    L41:
        e = e;
    L37:
        e = e;
        goto L45
    L26:
        r115 = r10;
        r24 = new androidx.constraintlayout.widget.b(r22, r113.getMethod("getMap" + r21, new Class[0]).invoke(r14, new Object[0]));     // Catch: InvocationTargetException -> L31 IllegalAccessException -> L33 NoSuchMethodException -> L35
        goto L73
    L58:
        r18 = r10;
        r110 = r20;
        r17.f1449f = r112;
        r17.b(r16, r15);
        int r25 = r14.getVisibility();
        C0009d r26 = r17.f1445b;
        r26.f1513a = r25;
        r26.f1515c = r14.getAlpha();
        float r27 = r14.getRotation();
        e r28 = r17.f1448e;
        r28.f1518a = r27;
        r28.f1519b = r14.getRotationX();
        r28.f1520c = r14.getRotationY();
        r28.f1521d = r14.getScaleX();
        r28.f1522e = r14.getScaleY();
        float r29 = r14.getPivotX();
        float r30 = r14.getPivotY();
        if (r29 == 0.0d) goto L61;
    L62:
        r28.f1523f = r29;
        r28.f1524g = r30;
    L63:
        r28.f1526i = r14.getTranslationX();
        r28.f1527j = r14.getTranslationY();
        r28.f1528k = r14.getTranslationZ();
        if (r28.f1529l == false) goto L67;
        r28.f1530m = r14.getElevation();
    L67:
        if ((r14 instanceof androidx.constraintlayout.widget.a) == false) goto L69;
        androidx.constraintlayout.widget.a r31 = (androidx.constraintlayout.widget.a) r14;
        boolean r32 = r31.getAllowsGoneWidget();
        b r33 = r17.f1447d;
        r33.f1489n0 = r32;
        r33.f1479i0 = r31.getReferencedIds();
        r33.f1473f0 = r31.getType();
        r33.f1475g0 = r31.getMargin();
        goto L69
    L61:
        if (r30 == 0.0d) goto L63;
    }

    public final void f(Context r8, int r10) {
        XmlResourceParser r11 = r8.getResources().getXml(r10);
        int r12 = r11.getEventType();     // Catch: IOException -> L15 XmlPullParserException -> L17
    L5:
        if (r12 == 1) goto L27;
        if (r12 != 2) goto L13;
        String r13 = r11.getName();     // Catch: IOException -> L15 XmlPullParserException -> L17
        a r14 = e(r8, Xml.asAttributeSet(r11), false);     // Catch: IOException -> L15 XmlPullParserException -> L17
        if (r13.equalsIgnoreCase("Guideline") == false) goto L12;
        r14.f1447d.f1463a = true;     // Catch: IOException -> L15 XmlPullParserException -> L17
    L12:
        this.f1443c.put(Integer.valueOf(r14.f1444a), r14);     // Catch: IOException -> L15 XmlPullParserException -> L17
    L13:
        r12 = r11.next();     // Catch: IOException -> L15 XmlPullParserException -> L17
    L27:
        return;
    L15:
        e = e;
        StringBuilder r15 = new StringBuilder("Error parsing resource: ");
    L19:
        r15.append(r10);
        Log.e("ConstraintSet", r15.toString(), e);
        return;
    L17:
        e = e;
        r15 = new StringBuilder("Error parsing resource: ");
        goto L19
    }
}
