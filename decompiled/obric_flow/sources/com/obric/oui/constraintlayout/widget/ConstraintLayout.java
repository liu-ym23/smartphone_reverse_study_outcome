package com.obric.oui.constraintlayout.widget;

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
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.upload.t;
import com.google.common.reflect.w;
import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor$Type;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import com.obric.oui.constraintlayout.core.widgets.analyzer.j;
import com.obric.oui.constraintlayout.core.widgets.analyzer.p;
import com.obric.oui.constraintlayout.core.widgets.analyzer.s;
import hr.f;
import hr.g;
import hr.k;
import hr.l;
import hr.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import lr.m;

/* JADX INFO: loaded from: classes3.dex */
public class ConstraintLayout extends ViewGroup {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static m f12989p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray f12990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f12991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f12992c;
    public int d;
    public int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f12993h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12994i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f12995j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public t f12996k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12997l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public HashMap f12998m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final SparseArray f12999n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f13000o;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
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
        public int f13001a;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public boolean f13002a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f13003b;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public boolean f13004b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f13005c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public boolean f13006c0;
        public final boolean d;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public boolean f13007d0;
        public int e;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public boolean f13008e0;
        public int f;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public boolean f13009f0;
        public int g;
        public int g0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f13010h;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public int f13011h0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f13012i;
        public int i0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f13013j;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public int f13014j0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f13015k;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public int f13016k0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f13017l;
        public int l0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f13018m;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public float f13019m0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f13020n;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public int f13021n0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f13022o;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public int f13023o0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f13024p;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public float f13025p0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f13026q;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public f f13027q0;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f13028r;
        public int s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f13029t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f13030u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f13031v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final int f13032w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f13033x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final int f13034y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f13035z;

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
            this.f13001a = -1;
            this.f13003b = -1;
            this.f13005c = -1.0f;
            this.d = true;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.f13010h = -1;
            this.f13012i = -1;
            this.f13013j = -1;
            this.f13015k = -1;
            this.f13017l = -1;
            this.f13018m = -1;
            this.f13020n = -1;
            this.f13022o = -1;
            this.f13024p = -1;
            this.f13026q = 0;
            this.f13028r = 0.0f;
            this.s = -1;
            this.f13029t = -1;
            this.f13030u = -1;
            this.f13031v = -1;
            this.f13032w = Integer.MIN_VALUE;
            this.f13033x = Integer.MIN_VALUE;
            this.f13034y = Integer.MIN_VALUE;
            this.f13035z = Integer.MIN_VALUE;
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
            this.f13002a0 = true;
            this.f13004b0 = true;
            this.f13006c0 = false;
            this.f13007d0 = false;
            this.f13008e0 = false;
            this.f13009f0 = false;
            this.g0 = -1;
            this.f13011h0 = -1;
            this.i0 = -1;
            this.f13014j0 = -1;
            this.f13016k0 = Integer.MIN_VALUE;
            this.l0 = Integer.MIN_VALUE;
            this.f13019m0 = 0.5f;
            this.f13027q0 = new f();
            if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
            ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r10;
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r5.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r5.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = r5.topMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = r5.bottomMargin;
            setMarginStart(r5.getMarginStart());
            setMarginEnd(r5.getMarginEnd());
        L6:
            if ((r10 instanceof LayoutParams) == true) goto L8;
            return;
        L8:
            LayoutParams r11 = (LayoutParams) r10;
            this.f13001a = r11.f13001a;
            this.f13003b = r11.f13003b;
            this.f13005c = r11.f13005c;
            this.d = r11.d;
            this.e = r11.e;
            this.f = r11.f;
            this.g = r11.g;
            this.f13010h = r11.f13010h;
            this.f13012i = r11.f13012i;
            this.f13013j = r11.f13013j;
            this.f13015k = r11.f13015k;
            this.f13017l = r11.f13017l;
            this.f13018m = r11.f13018m;
            this.f13020n = r11.f13020n;
            this.f13022o = r11.f13022o;
            this.f13024p = r11.f13024p;
            this.f13026q = r11.f13026q;
            this.f13028r = r11.f13028r;
            this.s = r11.s;
            this.f13029t = r11.f13029t;
            this.f13030u = r11.f13030u;
            this.f13031v = r11.f13031v;
            this.f13032w = r11.f13032w;
            this.f13033x = r11.f13033x;
            this.f13034y = r11.f13034y;
            this.f13035z = r11.f13035z;
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
            this.f13002a0 = r11.f13002a0;
            this.f13004b0 = r11.f13004b0;
            this.f13006c0 = r11.f13006c0;
            this.f13007d0 = r11.f13007d0;
            this.g0 = r11.g0;
            this.f13011h0 = r11.f13011h0;
            this.i0 = r11.i0;
            this.f13014j0 = r11.f13014j0;
            this.f13016k0 = r11.f13016k0;
            this.l0 = r11.l0;
            this.f13019m0 = r11.f13019m0;
            this.Y = r11.Y;
            this.Z = r11.Z;
            this.f13027q0 = r11.f13027q0;
        }

        public final void a() {
            this.f13007d0 = false;
            this.f13002a0 = true;
            this.f13004b0 = true;
            int r5 = ((ViewGroup.MarginLayoutParams) this).width;
            if (r5 == (-2)) goto L5;
        L9:
            int r10 = ((ViewGroup.MarginLayoutParams) this).height;
            if (r10 != (-2)) goto L17;
            if (this.X == false) goto L17;
            this.f13004b0 = false;
            if (this.M != 0) goto L17;
            this.M = 1;
        L17:
            if (r5 == 0) goto L19;
            if (r5 == (-1)) goto L19;
        L24:
            if (r10 == 0) goto L26;
            if (r10 == (-1)) goto L26;
        L32:
            if (this.f13005c == (-1.0f)) goto L34;
        L37:
            this.f13007d0 = true;
            this.f13002a0 = true;
            this.f13004b0 = true;
            if ((this.f13027q0 instanceof k) == true) goto L40;
            this.f13027q0 = new k();
        L40:
            ((k) this.f13027q0).T(this.V);
            return;
        L34:
            if (this.f13001a != (-1)) goto L37;
            if (this.f13003b != (-1)) goto L37;
            return;
        L26:
            this.f13004b0 = false;
            if (r10 != 0) goto L32;
            if (this.M != 1) goto L32;
            ((ViewGroup.MarginLayoutParams) this).height = -2;
            this.X = true;
        L19:
            this.f13002a0 = false;
            if (r5 != 0) goto L24;
            if (this.L != 1) goto L24;
            ((ViewGroup.MarginLayoutParams) this).width = -2;
            this.W = true;
            goto L24
        L5:
            if (this.W == false) goto L9;
            this.f13002a0 = false;
            if (this.L != 0) goto L9;
            this.L = 1;
            goto L9
        }

        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        public final void resolveLayoutDirection(int r11) {
            int r5 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int r10 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            super.resolveLayoutDirection(r11);
            boolean r12 = false;
            if (1 != getLayoutDirection()) goto L5;
            boolean r13 = true;
        L6:
            this.i0 = -1;
            this.f13014j0 = -1;
            this.g0 = -1;
            this.f13011h0 = -1;
            this.f13016k0 = this.f13032w;
            this.l0 = this.f13034y;
            float r14 = this.E;
            this.f13019m0 = r14;
            int r15 = this.f13001a;
            this.f13021n0 = r15;
            int r16 = this.f13003b;
            this.f13023o0 = r16;
            float r17 = this.f13005c;
            this.f13025p0 = r17;
            if (r13 == false) goto L43;
            int r18 = this.s;
            if (r18 == (-1)) goto L12;
            this.i0 = r18;
        L11:
            r12 = true;
        L15:
            int r19 = this.f13030u;
            if (r19 == (-1)) goto L18;
            this.f13011h0 = r19;
            r12 = true;
        L18:
            int r110 = this.f13031v;
            if (r110 == (-1)) goto L21;
            this.g0 = r110;
            r12 = true;
        L21:
            int r111 = this.A;
            if (r111 == Integer.MIN_VALUE) goto L24;
            this.l0 = r111;
        L24:
            int r112 = this.B;
            if (r112 == Integer.MIN_VALUE) goto L28;
            this.f13016k0 = r112;
        L28:
            if (r12 == false) goto L31;
            this.f13019m0 = 1.0f - r14;
        L31:
            if (this.f13007d0 == false) goto L62;
            if (this.V != 1) goto L62;
            if (this.d == false) goto L62;
            if (r17 == (-1.0f)) goto L39;
            this.f13025p0 = 1.0f - r17;
            this.f13021n0 = -1;
            this.f13023o0 = -1;
            goto L62
        L39:
            if (r15 == (-1)) goto L41;
            this.f13023o0 = r15;
            this.f13021n0 = -1;
            this.f13025p0 = -1.0f;
            goto L62
        L41:
            if (r16 == (-1)) goto L62;
            this.f13021n0 = r16;
            this.f13023o0 = -1;
            this.f13025p0 = -1.0f;
        L62:
            if (this.f13030u == (-1)) goto L64;
            return;
        L64:
            if (this.f13031v == (-1)) goto L66;
            return;
        L66:
            if (this.f13029t == (-1)) goto L68;
            return;
        L68:
            if (this.s != (-1)) goto L97;
            int r113 = this.g;
            if (r113 == (-1)) goto L75;
            this.i0 = r113;
            if (((ViewGroup.MarginLayoutParams) this).rightMargin > 0) goto L81;
            if (r10 <= 0) goto L81;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r10;
        L81:
            int r114 = this.e;
            if (r114 == (-1)) goto L87;
            this.g0 = r114;
            if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0) goto L98;
            if (r5 <= 0) goto L99;
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r5;
            return;
        L99:
            return;
        L98:
            return;
        L87:
            int r115 = this.f;
            if (r115 == (-1)) goto L101;
            this.f13011h0 = r115;
            if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0) goto L102;
            if (r5 <= 0) goto L103;
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r5;
            return;
        L103:
            return;
        L102:
            return;
        L101:
            return;
        L75:
            int r116 = this.f13010h;
            if (r116 == (-1)) goto L81;
            this.f13014j0 = r116;
            if (((ViewGroup.MarginLayoutParams) this).rightMargin > 0) goto L81;
            if (r10 <= 0) goto L81;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r10;
            goto L81
        L97:
            return;
        L12:
            int r117 = this.f13029t;
            if (r117 == (-1)) goto L15;
            this.f13014j0 = r117;
            goto L11
        L43:
            int r118 = this.s;
            if (r118 == (-1)) goto L46;
            this.f13011h0 = r118;
        L46:
            int r119 = this.f13029t;
            if (r119 == (-1)) goto L49;
            this.g0 = r119;
        L49:
            int r120 = this.f13030u;
            if (r120 == (-1)) goto L52;
            this.i0 = r120;
        L52:
            int r121 = this.f13031v;
            if (r121 == (-1)) goto L55;
            this.f13014j0 = r121;
        L55:
            int r122 = this.A;
            if (r122 == Integer.MIN_VALUE) goto L58;
            this.f13016k0 = r122;
        L58:
            int r123 = this.B;
            if (r123 == Integer.MIN_VALUE) goto L62;
            this.l0 = r123;
            goto L62
        L5:
            r13 = false;
            goto L6
        }

        public LayoutParams(Context r11, AttributeSet r12) {
            super(r11, r12);
            this.f13001a = -1;
            this.f13003b = -1;
            this.f13005c = -1.0f;
            this.d = true;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.f13010h = -1;
            this.f13012i = -1;
            this.f13013j = -1;
            this.f13015k = -1;
            this.f13017l = -1;
            this.f13018m = -1;
            this.f13020n = -1;
            this.f13022o = -1;
            this.f13024p = -1;
            this.f13026q = 0;
            this.f13028r = 0.0f;
            this.s = -1;
            this.f13029t = -1;
            this.f13030u = -1;
            this.f13031v = -1;
            this.f13032w = Integer.MIN_VALUE;
            this.f13033x = Integer.MIN_VALUE;
            this.f13034y = Integer.MIN_VALUE;
            this.f13035z = Integer.MIN_VALUE;
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
            this.f13002a0 = true;
            this.f13004b0 = true;
            this.f13006c0 = false;
            this.f13007d0 = false;
            this.f13008e0 = false;
            this.f13009f0 = false;
            this.g0 = -1;
            this.f13011h0 = -1;
            this.i0 = -1;
            this.f13014j0 = -1;
            this.f13016k0 = Integer.MIN_VALUE;
            this.l0 = Integer.MIN_VALUE;
            this.f13019m0 = 0.5f;
            this.f13027q0 = new f();
            TypedArray r13 = r11.obtainStyledAttributes(r12, R$styleable.ConstraintLayout_Layout);
            int r14 = r13.getIndexCount();
            int r5 = 0;
        L3:
            if (r5 >= r14) goto L118;
            int r10 = r13.getIndex(r5);
            int r15 = a.f13057a.get(r10);
            switch(r15) {
                case 1: goto L116;
                case 2: goto L113;
                case 3: goto L112;
                case 4: goto L109;
                case 5: goto L108;
                case 6: goto L107;
                case 7: goto L106;
                case 8: goto L103;
                case 9: goto L100;
                case 10: goto L97;
                case 11: goto L94;
                case 12: goto L91;
                case 13: goto L88;
                case 14: goto L85;
                case 15: goto L82;
                case 16: goto L79;
                case 17: goto L76;
                case 18: goto L73;
                case 19: goto L70;
                case 20: goto L67;
                case 21: goto L66;
                case 22: goto L65;
                case 23: goto L64;
                case 24: goto L63;
                case 25: goto L62;
                case 26: goto L61;
                case 27: goto L60;
                case 28: goto L59;
                case 29: goto L58;
                case 30: goto L57;
                case 31: goto L54;
                case 32: goto L51;
                case 33: goto L122;
                case 34: goto L126;
                case 35: goto L40;
                case 36: goto L120;
                case 37: goto L124;
                case 38: goto L29;
                default: goto L6;
            };
        L6:
            switch(r15) {
                case 44: goto L28;
                case 45: goto L27;
                case 46: goto L26;
                case 47: goto L25;
                case 48: goto L24;
                case 49: goto L23;
                case 50: goto L22;
                case 51: goto L21;
                case 52: goto L18;
                case 53: goto L15;
                case 54: goto L14;
                case 55: goto L13;
                default: goto L7;
            };
        L7:
            switch(r15) {
                case 64: goto L12;
                case 65: goto L11;
                case 66: goto L10;
                case 67: goto L9;
                default: goto L117;
            };
        L9:
            this.d = r13.getBoolean(r10, this.d);
            goto L117
        L10:
            this.Z = r13.getInt(r10, this.Z);
            goto L117
        L11:
            d.m(this, r13, r10, 1);
            goto L117
        L12:
            d.m(this, r13, r10, 0);
        L117:
            r5 = r5 + 1;
            goto L3
        L13:
            this.C = r13.getDimensionPixelSize(r10, this.C);
            goto L117
        L14:
            this.D = r13.getDimensionPixelSize(r10, this.D);
            goto L117
        L15:
            int r16 = r13.getResourceId(r10, this.f13022o);
            this.f13022o = r16;
            if (r16 != (-1)) goto L117;
            this.f13022o = r13.getInt(r10, -1);
            goto L117
        L18:
            int r17 = r13.getResourceId(r10, this.f13020n);
            this.f13020n = r17;
            if (r17 != (-1)) goto L117;
            this.f13020n = r13.getInt(r10, -1);
            goto L117
        L21:
            this.Y = r13.getString(r10);
            goto L117
        L22:
            this.U = r13.getDimensionPixelOffset(r10, this.U);
            goto L117
        L23:
            this.T = r13.getDimensionPixelOffset(r10, this.T);
            goto L117
        L24:
            this.K = r13.getInt(r10, 0);
            goto L117
        L25:
            this.J = r13.getInt(r10, 0);
            goto L117
        L26:
            this.I = r13.getFloat(r10, this.I);
            goto L117
        L27:
            this.H = r13.getFloat(r10, this.H);
            goto L117
        L28:
            d.n(this, r13.getString(r10));
            goto L117
        L29:
            this.S = Math.max(0.0f, r13.getFloat(r10, this.S));
            this.M = 2;
            goto L117
        L40:
            this.R = Math.max(0.0f, r13.getFloat(r10, this.R));
            this.L = 2;
            goto L117
        L51:
            int r18 = r13.getInt(r10, 0);
            this.M = r18;
            if (r18 != 1) goto L117;
            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
            goto L117
        L54:
            int r19 = r13.getInt(r10, 0);
            this.L = r19;
            if (r19 != 1) goto L117;
            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
            goto L117
        L57:
            this.F = r13.getFloat(r10, this.F);
            goto L117
        L58:
            this.E = r13.getFloat(r10, this.E);
            goto L117
        L59:
            this.X = r13.getBoolean(r10, this.X);
            goto L117
        L60:
            this.W = r13.getBoolean(r10, this.W);
            goto L117
        L61:
            this.B = r13.getDimensionPixelSize(r10, this.B);
            goto L117
        L62:
            this.A = r13.getDimensionPixelSize(r10, this.A);
            goto L117
        L63:
            this.f13035z = r13.getDimensionPixelSize(r10, this.f13035z);
            goto L117
        L64:
            this.f13034y = r13.getDimensionPixelSize(r10, this.f13034y);
            goto L117
        L65:
            this.f13033x = r13.getDimensionPixelSize(r10, this.f13033x);
            goto L117
        L66:
            this.f13032w = r13.getDimensionPixelSize(r10, this.f13032w);
            goto L117
        L67:
            int r20 = r13.getResourceId(r10, this.f13031v);
            this.f13031v = r20;
            if (r20 != (-1)) goto L117;
            this.f13031v = r13.getInt(r10, -1);
            goto L117
        L70:
            int r21 = r13.getResourceId(r10, this.f13030u);
            this.f13030u = r21;
            if (r21 != (-1)) goto L117;
            this.f13030u = r13.getInt(r10, -1);
            goto L117
        L73:
            int r22 = r13.getResourceId(r10, this.f13029t);
            this.f13029t = r22;
            if (r22 != (-1)) goto L117;
            this.f13029t = r13.getInt(r10, -1);
            goto L117
        L76:
            int r23 = r13.getResourceId(r10, this.s);
            this.s = r23;
            if (r23 != (-1)) goto L117;
            this.s = r13.getInt(r10, -1);
            goto L117
        L79:
            int r24 = r13.getResourceId(r10, this.f13018m);
            this.f13018m = r24;
            if (r24 != (-1)) goto L117;
            this.f13018m = r13.getInt(r10, -1);
            goto L117
        L82:
            int r25 = r13.getResourceId(r10, this.f13017l);
            this.f13017l = r25;
            if (r25 != (-1)) goto L117;
            this.f13017l = r13.getInt(r10, -1);
            goto L117
        L85:
            int r26 = r13.getResourceId(r10, this.f13015k);
            this.f13015k = r26;
            if (r26 != (-1)) goto L117;
            this.f13015k = r13.getInt(r10, -1);
            goto L117
        L88:
            int r27 = r13.getResourceId(r10, this.f13013j);
            this.f13013j = r27;
            if (r27 != (-1)) goto L117;
            this.f13013j = r13.getInt(r10, -1);
            goto L117
        L91:
            int r28 = r13.getResourceId(r10, this.f13012i);
            this.f13012i = r28;
            if (r28 != (-1)) goto L117;
            this.f13012i = r13.getInt(r10, -1);
            goto L117
        L94:
            int r29 = r13.getResourceId(r10, this.f13010h);
            this.f13010h = r29;
            if (r29 != (-1)) goto L117;
            this.f13010h = r13.getInt(r10, -1);
            goto L117
        L97:
            int r30 = r13.getResourceId(r10, this.g);
            this.g = r30;
            if (r30 != (-1)) goto L117;
            this.g = r13.getInt(r10, -1);
            goto L117
        L100:
            int r31 = r13.getResourceId(r10, this.f);
            this.f = r31;
            if (r31 != (-1)) goto L117;
            this.f = r13.getInt(r10, -1);
            goto L117
        L103:
            int r32 = r13.getResourceId(r10, this.e);
            this.e = r32;
            if (r32 != (-1)) goto L117;
            this.e = r13.getInt(r10, -1);
            goto L117
        L106:
            this.f13005c = r13.getFloat(r10, this.f13005c);
            goto L117
        L107:
            this.f13003b = r13.getDimensionPixelOffset(r10, this.f13003b);
            goto L117
        L108:
            this.f13001a = r13.getDimensionPixelOffset(r10, this.f13001a);
            goto L117
        L109:
            float r33 = r13.getFloat(r10, this.f13028r) % 360.0f;
            this.f13028r = r33;
            if (r33 >= 0.0f) goto L117;
            this.f13028r = (360.0f - r33) % 360.0f;
            goto L117
        L112:
            this.f13026q = r13.getDimensionPixelSize(r10, this.f13026q);
            goto L117
        L113:
            int r34 = r13.getResourceId(r10, this.f13024p);
            this.f13024p = r34;
            if (r34 != (-1)) goto L117;
            this.f13024p = r13.getInt(r10, -1);
            goto L117
        L116:
            this.V = r13.getInt(r10, this.V);
            goto L117
        L120:
            this.O = r13.getDimensionPixelSize(r10, this.O);     // Catch: Exception -> L37
        L38:
            if (r13.getInt(r10, this.O) != (-2)) goto L117;
            this.O = -2;
            goto L117
        L122:
            this.N = r13.getDimensionPixelSize(r10, this.N);     // Catch: Exception -> L48
        L49:
            if (r13.getInt(r10, this.N) != (-2)) goto L117;
            this.N = -2;
            goto L117
        L124:
            this.Q = r13.getDimensionPixelSize(r10, this.Q);     // Catch: Exception -> L32
        L33:
            if (r13.getInt(r10, this.Q) != (-2)) goto L117;
            this.Q = -2;
            goto L117
        L126:
            this.P = r13.getDimensionPixelSize(r10, this.P);     // Catch: Exception -> L43
        L44:
            if (r13.getInt(r10, this.P) != (-2)) goto L117;
            this.P = -2;
            goto L117
        L118:
            r13.recycle();
            a();
        }

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
            this.f13001a = -1;
            this.f13003b = -1;
            this.f13005c = -1.0f;
            this.d = true;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.f13010h = -1;
            this.f13012i = -1;
            this.f13013j = -1;
            this.f13015k = -1;
            this.f13017l = -1;
            this.f13018m = -1;
            this.f13020n = -1;
            this.f13022o = -1;
            this.f13024p = -1;
            this.f13026q = 0;
            this.f13028r = 0.0f;
            this.s = -1;
            this.f13029t = -1;
            this.f13030u = -1;
            this.f13031v = -1;
            this.f13032w = Integer.MIN_VALUE;
            this.f13033x = Integer.MIN_VALUE;
            this.f13034y = Integer.MIN_VALUE;
            this.f13035z = Integer.MIN_VALUE;
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
            this.f13002a0 = true;
            this.f13004b0 = true;
            this.f13006c0 = false;
            this.f13007d0 = false;
            this.f13008e0 = false;
            this.f13009f0 = false;
            this.g0 = -1;
            this.f13011h0 = -1;
            this.i0 = -1;
            this.f13014j0 = -1;
            this.f13016k0 = Integer.MIN_VALUE;
            this.l0 = Integer.MIN_VALUE;
            this.f13019m0 = 0.5f;
            this.f13027q0 = new f();
        }
    }

    public ConstraintLayout(Context r5) {
        super(r5);
        this.f12990a = new SparseArray();
        this.f12991b = new ArrayList(4);
        this.f12992c = new g();
        this.d = 0;
        this.e = 0;
        this.f = Integer.MAX_VALUE;
        this.g = Integer.MAX_VALUE;
        this.f12993h = true;
        this.f12994i = 257;
        this.f12995j = null;
        this.f12996k = null;
        this.f12997l = -1;
        this.f12998m = new HashMap();
        this.f12999n = new SparseArray();
        this.f13000o = new b(this, this);
        o(null, 0);
    }

    private int getPaddingWidth() {
        int r5 = Math.max(0, getPaddingLeft());
        int r10 = Math.max(0, getPaddingRight()) + r5;
        int r11 = Math.max(0, getPaddingStart());
        int r12 = Math.max(0, getPaddingEnd()) + r11;
        if (r12 > 0) goto L5;
        return r10;
    L5:
        return r12;
    }

    public static m getSharedValues() {
        if (f12989p != null) goto L6;
        m r5 = new m();
        new SparseIntArray();
        r5.f19773a = new HashMap();
        f12989p = r5;
    L6:
        return f12989p;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:152:0x02cf -> B:153:0x02d0). Please report as a decompilation issue!!! */
    public final void a(boolean r18, View r19, f r20, LayoutParams r21, SparseArray r22) {
        r21.a();
        r20.i0 = r19.getVisibility();
        if (r21.f13009f0 == false) goto L5;
        r20.F = true;
        r20.i0 = 8;
    L5:
        r20.f17404h0 = r19;
        if ((r19 instanceof ConstraintHelper) == false) goto L9;
        ((ConstraintHelper) r19).m(r20, this.f12992c.f17437z0);
    L9:
        int r11 = -1;
        if (r21.f13007d0 == false) goto L21;
        k r5 = (k) r20;
        int r10 = r21.f13021n0;
        int r12 = r21.f13023o0;
        float r13 = r21.f13025p0;
        if (r13 == (-1.0f)) goto L15;
        if (r13 <= (-1.0f)) goto L185;
        r5.f17456u0 = r13;
        r5.f17457v0 = -1;
        r5.f17458w0 = -1;
        return;
    L185:
        return;
    L15:
        if (r10 == (-1)) goto L18;
        if (r10 <= (-1)) goto L187;
        r5.f17456u0 = -1.0f;
        r5.f17457v0 = r10;
        r5.f17458w0 = -1;
        return;
    L187:
        return;
    L18:
        if (r12 == (-1)) goto L189;
        if (r12 <= (-1)) goto L190;
        r5.f17456u0 = -1.0f;
        r5.f17457v0 = -1;
        r5.f17458w0 = r12;
        return;
    L190:
        return;
    L189:
        return;
    L21:
        int r14 = r21.g0;
        int r15 = r21.f13011h0;
        int r16 = r21.i0;
        int r17 = r21.f13014j0;
        int r23 = r21.f13016k0;
        int r110 = r21.l0;
        float r111 = r21.f13019m0;
        int r24 = r21.f13024p;
        if (r24 == (-1)) goto L28;
        f r25 = (f) r22.get(r24);
        if (r25 == null) goto L27;
        float r26 = r21.f13028r;
        int r27 = r21.f13026q;
        ConstraintAnchor$Type r28 = ConstraintAnchor$Type.CENTER;
        r20.w(r28, r25, r28, r27, 0);
        r20.D = r26;
    L27:
        float r29 = 0.0f;
    L81:
        if (r18 == false) goto L87;
        int r30 = r21.T;
        if (r30 == (-1)) goto L85;
    L86:
        int r31 = r21.U;
        r20.f17395a0 = r30;
        r20.f17397b0 = r31;
        goto L87
    L85:
        if (r21.U != (-1)) goto L86;
    L87:
        int r32 = 0;
        if (r21.f13002a0 == false) goto L90;
        r20.N(ConstraintWidget$DimensionBehaviour.FIXED);
        r20.P(((ViewGroup.MarginLayoutParams) r21).width);
        if (((ViewGroup.MarginLayoutParams) r21).width != (-2)) goto L101;
        r20.N(ConstraintWidget$DimensionBehaviour.WRAP_CONTENT);
    L101:
        if (r21.f13004b0 == false) goto L103;
        r20.O(ConstraintWidget$DimensionBehaviour.FIXED);
        r20.M(((ViewGroup.MarginLayoutParams) r21).height);
        if (((ViewGroup.MarginLayoutParams) r21).height != (-2)) goto L113;
        r20.O(ConstraintWidget$DimensionBehaviour.WRAP_CONTENT);
    L113:
        String r33 = r21.G;
        if (r33 != null) goto L116;
    L156:
        r20.Y = r29;
    L157:
        float r34 = r21.H;
        float[] r35 = r20.f17414n0;
        r35[0] = r34;
        r35[1] = r21.I;
        r20.l0 = r21.J;
        r20.f17412m0 = r21.K;
        int r36 = r21.Z;
        if (r36 >= 0) goto L160;
    L162:
        int r37 = r21.L;
        int r38 = r21.N;
        int r39 = r21.P;
        float r40 = r21.R;
        r20.f17421r = r37;
        r20.f17426u = r38;
        if (r39 != Integer.MAX_VALUE) goto L165;
        r39 = 0;
    L165:
        r20.f17427v = r39;
        r20.f17428w = r40;
        if (r40 > r29) goto L168;
    L171:
        int r41 = r21.M;
        int r42 = r21.O;
        int r43 = r21.Q;
        float r44 = r21.S;
        r20.s = r41;
        r20.f17429x = r42;
        if (r43 == Integer.MAX_VALUE) goto L175;
        r32 = r43;
    L175:
        r20.f17430y = r32;
        r20.f17431z = r44;
        if (r44 > r29) goto L178;
        return;
    L178:
        if (r44 >= 1.0f) goto L193;
        if (r41 != 0) goto L194;
        r20.s = 2;
        return;
    L194:
        return;
    L193:
        return;
    L168:
        if (r40 >= 1.0f) goto L171;
        if (r37 != 0) goto L171;
        r20.f17421r = 2;
        goto L171
    L160:
        if (r36 > 3) goto L162;
        r20.f17419q = r36;
        goto L162
    L116:
        if (r33.length() == 0) goto L156;
        int r45 = r33.length();
        int r46 = r33.indexOf(44);
        if (r46 > 0) goto L121;
    L130:
        int r47 = 1;
        int r48 = 0;
    L131:
        int r49 = r33.indexOf(58);
        if (r49 >= 0) goto L134;
    L148:
        String r50 = r33.substring(r48);
        if (r50.length() <= 0) goto L152;
        float r51 = Float.parseFloat(r50);     // Catch: NumberFormatException -> L182
    L153:
        if (r51 <= r29) goto L157;
        r20.Y = r51;
        r20.Z = r11;
        goto L157
    L134:
        if (r49 >= (r45 - r47)) goto L148;
        String r52 = r33.substring(r48, r49);
        String r53 = r33.substring(r49 + r47);
        if (r52.length() <= 0) goto L152;
        if (r53.length() <= 0) goto L152;
        float r54 = Float.parseFloat(r52);     // Catch: NumberFormatException -> L182
        float r55 = Float.parseFloat(r53);     // Catch: NumberFormatException -> L182
        if (r54 <= r29) goto L152;
        if (r55 <= r29) goto L152;
        if (r11 != 1) goto L146;
        r51 = Math.abs(r55 / r54);     // Catch: NumberFormatException -> L182
        goto L153
    L146:
        r51 = Math.abs(r54 / r55);     // Catch: NumberFormatException -> L182
    L152:
        r51 = r29;
        goto L153
    L121:
        if (r46 >= (r45 - 1)) goto L130;
        String r56 = r33.substring(0, r46);
        if (r56.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST) == false) goto L127;
        r11 = 0;
    L125:
        r47 = 1;
    L129:
        r48 = r46 + r47;
        goto L131
    L127:
        if (r56.equalsIgnoreCase("H") == false) goto L125;
        r47 = 1;
        r11 = 1;
        goto L129
    L103:
        if (((ViewGroup.MarginLayoutParams) r21).height == (-1)) goto L105;
        r20.O(ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT);
        r20.M(0);
        goto L113
    L105:
        if (r21.X == false) goto L107;
        r20.O(ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT);
    L108:
        r20.j(ConstraintAnchor$Type.TOP).g = ((ViewGroup.MarginLayoutParams) r21).topMargin;
        r20.j(ConstraintAnchor$Type.BOTTOM).g = ((ViewGroup.MarginLayoutParams) r21).bottomMargin;
        goto L113
    L107:
        r20.O(ConstraintWidget$DimensionBehaviour.MATCH_PARENT);
        goto L108
    L90:
        if (((ViewGroup.MarginLayoutParams) r21).width == (-1)) goto L92;
        r20.N(ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT);
        r20.P(0);
        goto L101
    L92:
        if (r21.W == false) goto L94;
        r20.N(ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT);
    L95:
        r20.j(ConstraintAnchor$Type.LEFT).g = ((ViewGroup.MarginLayoutParams) r21).leftMargin;
        r20.j(ConstraintAnchor$Type.RIGHT).g = ((ViewGroup.MarginLayoutParams) r21).rightMargin;
        goto L101
    L94:
        r20.N(ConstraintWidget$DimensionBehaviour.MATCH_PARENT);
        goto L95
    L28:
        if (r14 == (-1)) goto L33;
        f r57 = (f) r22.get(r14);
        if (r57 == null) goto L32;
        ConstraintAnchor$Type r58 = ConstraintAnchor$Type.LEFT;
        r29 = 0.0f;
        r20.w(r58, r57, r58, ((ViewGroup.MarginLayoutParams) r21).leftMargin, r23);
    L38:
        if (r16 == (-1)) goto L42;
        f r59 = (f) r22.get(r16);
        if (r59 == null) goto L46;
        r20.w(ConstraintAnchor$Type.RIGHT, r59, ConstraintAnchor$Type.LEFT, ((ViewGroup.MarginLayoutParams) r21).rightMargin, r110);
    L46:
        int r60 = r21.f13012i;
        if (r60 == (-1)) goto L51;
        f r61 = (f) r22.get(r60);
        if (r61 == null) goto L56;
        ConstraintAnchor$Type r62 = ConstraintAnchor$Type.TOP;
        r20.w(r62, r61, r62, ((ViewGroup.MarginLayoutParams) r21).topMargin, r21.f13033x);
    L56:
        int r63 = r21.f13015k;
        if (r63 == (-1)) goto L61;
        f r64 = (f) r22.get(r63);
        if (r64 == null) goto L66;
        r20.w(ConstraintAnchor$Type.BOTTOM, r64, ConstraintAnchor$Type.TOP, ((ViewGroup.MarginLayoutParams) r21).bottomMargin, r21.f13035z);
    L66:
        int r65 = r21.f13018m;
        if (r65 == (-1)) goto L69;
        t(r20, r21, r22, r65, ConstraintAnchor$Type.BASELINE);
    L76:
        if (r111 < r29) goto L78;
        r20.f17402f0 = r111;
    L78:
        float r66 = r21.F;
        if (r66 < r29) goto L81;
        r20.g0 = r66;
        goto L81
    L69:
        int r67 = r21.f13020n;
        if (r67 == (-1)) goto L72;
        t(r20, r21, r22, r67, ConstraintAnchor$Type.TOP);
        goto L76
    L72:
        int r68 = r21.f13022o;
        if (r68 == (-1)) goto L76;
        t(r20, r21, r22, r68, ConstraintAnchor$Type.BOTTOM);
        goto L76
    L61:
        int r69 = r21.f13017l;
        if (r69 == (-1)) goto L66;
        f r70 = (f) r22.get(r69);
        if (r70 == null) goto L66;
        ConstraintAnchor$Type r71 = ConstraintAnchor$Type.BOTTOM;
        r20.w(r71, r70, r71, ((ViewGroup.MarginLayoutParams) r21).bottomMargin, r21.f13035z);
        goto L66
    L51:
        int r72 = r21.f13013j;
        if (r72 == (-1)) goto L56;
        f r73 = (f) r22.get(r72);
        if (r73 == null) goto L56;
        r20.w(ConstraintAnchor$Type.TOP, r73, ConstraintAnchor$Type.BOTTOM, ((ViewGroup.MarginLayoutParams) r21).topMargin, r21.f13033x);
        goto L56
    L42:
        if (r17 == (-1)) goto L46;
        f r74 = (f) r22.get(r17);
        if (r74 == null) goto L46;
        ConstraintAnchor$Type r75 = ConstraintAnchor$Type.RIGHT;
        r20.w(r75, r74, r75, ((ViewGroup.MarginLayoutParams) r21).rightMargin, r110);
        goto L46
    L32:
        r29 = 0.0f;
        goto L38
    L33:
        r29 = 0.0f;
        if (r15 == (-1)) goto L38;
        f r76 = (f) r22.get(r15);
        if (r76 == null) goto L38;
        r20.w(ConstraintAnchor$Type.LEFT, r76, ConstraintAnchor$Type.RIGHT, ((ViewGroup.MarginLayoutParams) r21).leftMargin, r23);
        goto L38
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r5) {
        return r5 instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r19) {
        ArrayList r5 = this.f12991b;
        if (r5 == null) goto L9;
        int r10 = r5.size();
        if (r10 <= 0) goto L9;
        int r11 = 0;
    L7:
        if (r11 >= r10) goto L9;
        ((ConstraintHelper) r5.get(r11)).o(this);
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
        r110.setColor(SupportMenu.CATEGORY_MASK);
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

    public final View e(int r5) {
        return (View) this.f12990a.get(r5);
    }

    @Override // android.view.View
    public final void forceLayout() {
        this.f12993h = true;
        super.forceLayout();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r5) {
        return new LayoutParams(getContext(), r5);
    }

    public int getMaxHeight() {
        return this.g;
    }

    public int getMaxWidth() {
        return this.f;
    }

    public int getMinHeight() {
        return this.e;
    }

    public int getMinWidth() {
        return this.d;
    }

    public int getOptimizationLevel() {
        return this.f12992c.H0;
    }

    public String getSceneString() {
        StringBuilder r5 = new StringBuilder();
        g r10 = this.f12992c;
        if (r10.f17406j != null) goto L9;
        int r11 = getId();
        if (r11 == (-1)) goto L7;
        r10.f17406j = getContext().getResources().getResourceEntryName(r11);
        goto L9
    L7:
        r10.f17406j = "parent";
    L9:
        if (r10.f17409k0 != null) goto L11;
        r10.f17409k0 = r10.f17406j;
        Log.v("ConstraintLayout", " setDebugName " + r10.f17409k0);
    L11:
        Iterator r12 = r10.f17432u0.iterator();
    L13:
        if (r12.hasNext() == false) goto L24;
        f r13 = (f) r12.next();
        View r14 = r13.f17404h0;
        if (r14 == null) goto L13;
        if (r13.f17406j != null) goto L22;
        int r15 = r14.getId();
        if (r15 == (-1)) goto L22;
        r13.f17406j = getContext().getResources().getResourceEntryName(r15);
    L22:
        if (r13.f17409k0 != null) goto L13;
        r13.f17409k0 = r13.f17406j;
        Log.v("ConstraintLayout", " setDebugName " + r13.f17409k0);
        goto L13
    L24:
        r10.o(r5);
        return r5.toString();
    }

    public final f n(View r5) {
        if (r5 == this) goto L4;
        if (r5 != null) goto L7;
        return null;
    L7:
        if ((r5.getLayoutParams() instanceof LayoutParams) == true) goto L9;
        r5.setLayoutParams(new LayoutParams(r5.getLayoutParams()));
        if ((r5.getLayoutParams() instanceof LayoutParams) == true) goto L13;
        return null;
    L13:
        return ((LayoutParams) r5.getLayoutParams()).f13027q0;
    L9:
        return ((LayoutParams) r5.getLayoutParams()).f13027q0;
    L4:
        return this.f12992c;
    }

    public final void o(AttributeSet r10, int r11) {
        g r5 = this.f12992c;
        r5.f17404h0 = this;
        b r12 = this.f13000o;
        r5.f17436y0 = r12;
        r5.f17434w0.g = r12;
        this.f12990a.put(getId(), this);
        this.f12995j = null;
        if (r10 == null) goto L37;
        TypedArray r13 = getContext().obtainStyledAttributes(r10, R$styleable.ConstraintLayout_Layout, r11, 0);
        int r14 = r13.getIndexCount();
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L36;
        int r16 = r13.getIndex(r15);
        if (r16 != R$styleable.ConstraintLayout_Layout_android_minWidth) goto L10;
        this.d = r13.getDimensionPixelOffset(r16, this.d);
    L35:
        r15 = r15 + 1;
        goto L5
    L10:
        if (r16 != R$styleable.ConstraintLayout_Layout_android_minHeight) goto L13;
        this.e = r13.getDimensionPixelOffset(r16, this.e);
        goto L35
    L13:
        if (r16 != R$styleable.ConstraintLayout_Layout_android_maxWidth) goto L16;
        this.f = r13.getDimensionPixelOffset(r16, this.f);
        goto L35
    L16:
        if (r16 != R$styleable.ConstraintLayout_Layout_android_maxHeight) goto L19;
        this.g = r13.getDimensionPixelOffset(r16, this.g);
        goto L35
    L19:
        if (r16 != R$styleable.ConstraintLayout_Layout_layout_optimizationLevel) goto L22;
        this.f12994i = r13.getInt(r16, this.f12994i);
        goto L35
    L22:
        if (r16 != R$styleable.ConstraintLayout_Layout_layoutDescription) goto L29;
        int r17 = r13.getResourceId(r16, 0);
        if (r17 == 0) goto L35;
        q(r17);     // Catch: Resources.NotFoundException -> L27
    L27:
        this.f12996k = null;
        goto L35
    L29:
        if (r16 != R$styleable.ConstraintLayout_Layout_constraintSet) goto L35;
        int r18 = r13.getResourceId(r16, 0);
        d r19 = new d();     // Catch: Resources.NotFoundException -> L33
        this.f12995j = r19;     // Catch: Resources.NotFoundException -> L33
        r19.j(getContext(), r18);     // Catch: Resources.NotFoundException -> L33
    L34:
        this.f12997l = r18;
    L33:
        this.f12995j = null;
        goto L34
    L36:
        r13.recycle();
    L37:
        r5.H0 = this.f12994i;
        fr.c.f16984q = r5.X(512);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = getChildCount();
        boolean r16 = isInEditMode();
        int r17 = 0;
        int r18 = 0;
    L3:
        if (r18 >= r15) goto L21;
        View r19 = getChildAt(r18);
        LayoutParams r5 = (LayoutParams) r19.getLayoutParams();
        f r20 = r5.f13027q0;
        if (r19.getVisibility() != 8) goto L13;
        if (r5.f13007d0 == true) goto L13;
        if (r5.f13008e0 == true) goto L13;
        if (r16 == true) goto L13;
    L20:
        r18 = r18 + 1;
    L13:
        if (r5.f13009f0 == true) goto L20;
        int r21 = r20.s();
        int r22 = r20.t();
        int r23 = r20.r() + r21;
        int r24 = r20.l() + r22;
        r19.layout(r21, r22, r23, r24);
        if ((r19 instanceof Placeholder) == false) goto L20;
        View r110 = ((Placeholder) r19).getContent();
        if (r110 == null) goto L20;
        r110.setVisibility(0);
        r110.layout(r21, r22, r23, r24);
        goto L20
    L21:
        ArrayList r25 = this.f12991b;
        int r26 = r25.size();
        if (r26 <= 0) goto L25;
    L23:
        if (r17 >= r26) goto L33;
        ((ConstraintHelper) r25.get(r17)).n();
        r17 = r17 + 1;
        goto L23
    L33:
        return;
    }

    @Override // android.view.View
    public void onMeasure(int r17, int r18) {
        boolean r5 = this.f12993h;
        this.f12993h = r5;
        int r10 = 0;
        if (r5 == true) goto L10;
        int r11 = getChildCount();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L10;
        if (getChildAt(r12).isLayoutRequested() == true) goto L8;
        r12 = r12 + 1;
        goto L5
    L8:
        this.f12993h = true;
    L10:
        boolean r13 = p();
        g r14 = this.f12992c;
        r14.f17437z0 = r13;
        if (this.f12993h == false) goto L128;
        this.f12993h = false;
        int r15 = getChildCount();
        int r16 = 0;
    L13:
        if (r16 >= r15) goto L18;
        if (getChildAt(r16).isLayoutRequested() == true) goto L16;
        r16 = r16 + 1;
        goto L13
    L16:
        boolean r19 = true;
    L19:
        if (r19 == false) goto L126;
        boolean r20 = isInEditMode();
        int r110 = getChildCount();
        int r21 = 0;
    L21:
        if (r21 >= r110) goto L27;
        f r22 = n(getChildAt(r21));
        if (r22 == null) goto L26;
        r22.D();
    L26:
        r21 = r21 + 1;
        goto L21
    L27:
        Object r23 = null;
        if (r20 == false) goto L64;
        int r24 = 0;
    L30:
        if (r24 >= r110) goto L64;
        View r25 = getChildAt(r24);
        String r111 = getResources().getResourceName(r25.getId());     // Catch: Resources.NotFoundException -> L130
        Integer r112 = Integer.valueOf(r25.getId());     // Catch: Resources.NotFoundException -> L130
        if (r111 != null) goto L35;
    L42:
        int r113 = r111.indexOf(47);     // Catch: Resources.NotFoundException -> L130
        if (r113 == (-1)) goto L45;
        r111 = r111.substring(r113 + 1);     // Catch: Resources.NotFoundException -> L130
    L45:
        int r26 = r25.getId();     // Catch: Resources.NotFoundException -> L130
        if (r26 != 0) goto L48;
    L47:
        f r27 = r14;
    L61:
        r27.f17409k0 = r111;     // Catch: Resources.NotFoundException -> L130
        goto L62
    L48:
        View r114 = (View) this.f12990a.get(r26);     // Catch: Resources.NotFoundException -> L130
        if (r114 != null) goto L56;
        r114 = findViewById(r26);     // Catch: Resources.NotFoundException -> L130
        if (r114 == null) goto L56;
        if (r114 == this) goto L56;
        if (r114.getParent() != this) goto L56;
        onViewAdded(r114);     // Catch: Resources.NotFoundException -> L130
    L56:
        if (r114 == this) goto L47;
        if (r114 != null) goto L60;
        r27 = null;
        goto L61
    L60:
        r27 = ((LayoutParams) r114.getLayoutParams()).f13027q0;     // Catch: Resources.NotFoundException -> L130
        goto L61
    L35:
        if (this.f12998m != null) goto L37;
        this.f12998m = new HashMap();     // Catch: Resources.NotFoundException -> L130
    L37:
        int r115 = r111.indexOf("/");     // Catch: Resources.NotFoundException -> L130
        if (r115 == (-1)) goto L40;
        String r116 = r111.substring(r115 + 1);     // Catch: Resources.NotFoundException -> L130
    L41:
        this.f12998m.put(r116, r112);     // Catch: Resources.NotFoundException -> L130
        goto L42
    L40:
        r116 = r111;
    L62:
        r24 = r24 + 1;
    L64:
        if (this.f12997l == (-1)) goto L73;
        int r28 = 0;
    L66:
        if (r28 >= r110) goto L73;
        View r29 = getChildAt(r28);
        if (r29.getId() != this.f12997l) goto L72;
        if ((r29 instanceof Constraints) == false) goto L72;
        this.f12995j = ((Constraints) r29).getConstraintSet();
    L72:
        r28 = r28 + 1;
    L73:
        d r30 = this.f12995j;
        if (r30 == null) goto L76;
        r30.c(this);
    L76:
        r14.f17432u0.clear();
        ArrayList r31 = this.f12991b;
        int r32 = r31.size();
        if (r32 <= 0) goto L99;
        int r117 = 0;
    L79:
        if (r117 >= r32) goto L99;
        ConstraintHelper r118 = (ConstraintHelper) r31.get(r117);
        if (r118.isInEditMode() == false) goto L83;
        r118.setIds(r118.f);
    L83:
        l r119 = r118.d;
        if (r119 == null) goto L98;
        r119.f17463v0 = r10;
        Arrays.fill(r119.f17462u0, r23);
        int r120 = r10;
    L88:
        if (r120 >= r118.f12985b) goto L97;
        int r121 = r118.f12984a[r120];
        View r122 = e(r121);
        if (r122 != null) goto L94;
        Integer r123 = Integer.valueOf(r121);
        HashMap r33 = r118.f12988i;
        String r124 = (String) r33.get(r123);
        int r34 = r118.h(this, r124);
        if (r34 == 0) goto L94;
        r118.f12984a[r120] = r34;
        r33.put(Integer.valueOf(r34), r124);
        r122 = e(r34);
    L94:
        if (r122 == null) goto L96;
        r118.d.S(n(r122));
    L96:
        r120 = r120 + 1;
        goto L88
    L97:
        r118.d.U();
    L98:
        r117 = r117 + 1;
        r23 = null;
        r10 = 0;
    L99:
        int r35 = 0;
    L100:
        if (r35 >= r110) goto L113;
        View r36 = getChildAt(r35);
        if ((r36 instanceof Placeholder) == false) goto L112;
        Placeholder r37 = (Placeholder) r36;
        if (r37.f13047a == (-1)) goto L106;
    L108:
        View r38 = findViewById(r37.f13047a);
        r37.f13048b = r38;
        if (r38 == null) goto L112;
        ((LayoutParams) r38.getLayoutParams()).f13009f0 = true;
        r37.f13048b.setVisibility(0);
        r37.setVisibility(0);
        goto L112
    L106:
        if (r37.isInEditMode() == true) goto L108;
        r37.setVisibility(r37.f13049c);
    L112:
        r35 = r35 + 1;
        goto L100
    L113:
        SparseArray r125 = this.f12999n;
        r125.clear();
        r125.put(0, r14);
        r125.put(getId(), r14);
        int r39 = 0;
    L114:
        if (r39 >= r110) goto L116;
        View r40 = getChildAt(r39);
        r125.put(r40.getId(), n(r40));
        r39 = r39 + 1;
        goto L114
    L116:
        int r126 = 0;
    L117:
        if (r126 >= r110) goto L126;
        View r41 = getChildAt(r126);
        f r42 = n(r41);
        if (r42 == null) goto L125;
        LayoutParams r43 = (LayoutParams) r41.getLayoutParams();
        r14.f17432u0.add(r42);
        f r44 = r42.V;
        if (r44 == null) goto L124;
        ((g) r44).f17432u0.remove(r42);
        r42.D();
    L124:
        r42.V = r14;
        a(r20, r41, r42, r43, r125);
    L125:
        r126 = r126 + 1;
    L126:
        if (r19 == false) goto L128;
        r14.f17433v0.A(r14);
        goto L128
    L18:
        r19 = false;
    L128:
        r14.A0.getClass();
        s(r14, this.f12994i, r17, r18);
        r(r17, r18, r14.r(), r14.l(), r14.I0, r14.J0);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r5) {
        super.onViewAdded(r5);
        f r10 = n(r5);
        if ((r5 instanceof Guideline) == false) goto L8;
        if ((r10 instanceof k) == true) goto L8;
        LayoutParams r11 = (LayoutParams) r5.getLayoutParams();
        k r12 = new k();
        r11.f13027q0 = r12;
        r11.f13007d0 = true;
        r12.T(r11.V);
    L8:
        if ((r5 instanceof ConstraintHelper) == false) goto L12;
        ConstraintHelper r13 = (ConstraintHelper) r5;
        r13.q();
        ((LayoutParams) r5.getLayoutParams()).f13008e0 = true;
        ArrayList r14 = this.f12991b;
        if (r14.contains(r13) == true) goto L12;
        r14.add(r13);
    L12:
        int r15 = r5.getId();
        this.f12990a.put(r15, r5);
        this.f12993h = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r5) {
        super.onViewRemoved(r5);
        int r10 = r5.getId();
        this.f12990a.remove(r10);
        f r11 = n(r5);
        this.f12992c.f17432u0.remove(r11);
        r11.D();
        this.f12991b.remove(r5);
        this.f12993h = true;
    }

    public final boolean p() {
        if ((getContext().getApplicationInfo().flags & 4194304) != 0) goto L5;
    L7:
        return false;
    L5:
        if (1 != getLayoutDirection()) goto L7;
        return true;
    }

    public void q(int r5) {
        this.f12996k = new t(getContext(), this, r5);
    }

    public final void r(int r5, int r10, int r11, int r12, boolean r13, boolean r14) {
        b r15 = this.f13000o;
        int r16 = r15.e;
        int r17 = View.resolveSizeAndState(r11 + r15.d, r5, 0);
        int r18 = View.resolveSizeAndState(r12 + r16, r10, 0);
        int r19 = r17 & ViewCompat.MEASURED_SIZE_MASK;
        int r20 = r18 & ViewCompat.MEASURED_SIZE_MASK;
        int r21 = Math.min(this.f, r19);
        int r22 = Math.min(this.g, r20);
        if (r13 == false) goto L5;
        r21 = r21 | 16777216;
    L5:
        if (r14 == false) goto L7;
        r22 = r22 | 16777216;
    L7:
        setMeasuredDimension(r21, r22);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f12993h = true;
        super.requestLayout();
    }

    public final void s(g r24, int r25, int r26, int r27) {
        g r5 = r24;
        int r10 = View.MeasureSpec.getMode(r26);
        int r11 = View.MeasureSpec.getSize(r26);
        int r12 = View.MeasureSpec.getMode(r27);
        int r13 = View.MeasureSpec.getSize(r27);
        int r14 = Math.max(0, getPaddingTop());
        int r15 = Math.max(0, getPaddingBottom());
        int r16 = r14 + r15;
        int r17 = getPaddingWidth();
        b r18 = this.f13000o;
        r18.f13059b = r14;
        r18.f13060c = r15;
        r18.d = r17;
        r18.e = r16;
        r18.f = r26;
        r18.g = r27;
        int r19 = Math.max(0, getPaddingStart());
        int r110 = Math.max(0, getPaddingEnd());
        if (r19 > 0) goto L8;
        if (r110 > 0) goto L8;
        r19 = Math.max(0, getPaddingLeft());
    L10:
        int r20 = r11 - r17;
        int r21 = r13 - r16;
        int r111 = r18.e;
        int r112 = r18.d;
        ConstraintWidget$DimensionBehaviour r113 = ConstraintWidget$DimensionBehaviour.FIXED;
        int r114 = getChildCount();
        if (r10 == Integer.MIN_VALUE) goto L22;
        if (r10 == 0) goto L17;
        if (r10 == 1073741824) goto L16;
        int r115 = 0;
    L15:
        int r22 = Integer.MIN_VALUE;
        ConstraintWidget$DimensionBehaviour r116 = r113;
    L26:
        if (r12 == r22) goto L35;
        if (r12 != 0) goto L29;
        r113 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        if (r114 == 0) goto L34;
    L30:
        int r117 = 0;
    L39:
        int r23 = r24.r();
        com.obric.oui.constraintlayout.core.widgets.analyzer.f r28 = r5.f17434w0;
        if (r115 == r23) goto L42;
    L45:
        r28.f12568b = true;
    L46:
        r5.f17395a0 = 0;
        r5.f17397b0 = 0;
        int r29 = this.f - r112;
        int[] r30 = r5.C;
        r30[0] = r29;
        r30[1] = this.g - r111;
        r5.f17400d0 = 0;
        r5.f17401e0 = 0;
        r5.N(r116);
        r5.P(r115);
        r5.O(r113);
        r5.M(r117);
        int r31 = this.d - r112;
        if (r31 >= 0) goto L49;
        r5.f17400d0 = 0;
    L50:
        int r32 = this.e - r111;
        if (r32 >= 0) goto L53;
        r5.f17401e0 = 0;
    L54:
        r5.B0 = r19;
        r5.C0 = r14;
        w r33 = r5.f17433v0;
        r33.getClass();
        com.obric.oui.constraintlayout.core.widgets.analyzer.c r34 = r5.f17436y0;
        int r35 = r5.f17432u0.size();
        int r36 = r24.r();
        int r37 = r24.l();
        boolean r38 = hr.m.c(r25, 128);
        if (r38 == false) goto L57;
    L60:
        boolean r39 = true;
    L62:
        if (r39 == false) goto L98;
        int r118 = 0;
    L64:
        if (r118 >= r35) goto L98;
        f r119 = (f) r5.f17432u0.get(r118);
        ConstraintWidget$DimensionBehaviour[] r120 = r119.U;
        ConstraintWidget$DimensionBehaviour r121 = r120[0];
        ConstraintWidget$DimensionBehaviour r122 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        if (r121 != r122) goto L69;
        boolean r123 = true;
    L71:
        if (r120[1] != r122) goto L73;
        boolean r124 = true;
    L74:
        if (r123 == false) goto L79;
        if (r124 == false) goto L79;
        if (r119.Y <= 0.0f) goto L79;
        boolean r125 = true;
    L81:
        if (r119.y() == false) goto L86;
        if (r125 == false) goto L86;
    L83:
        r39 = false;
    L86:
        if (r119.z() == false) goto L90;
        if (r125 == true) goto L83;
    L90:
        if ((r119 instanceof o) == true) goto L83;
        if (r119.y() == true) goto L83;
        if (r119.z() == true) goto L83;
        r118 = r118 + 1;
    L79:
        r125 = false;
        goto L81
    L73:
        r124 = false;
        goto L74
    L69:
        r123 = false;
    L98:
        if (r10 != 1073741824) goto L100;
        if (r12 != 1073741824) goto L100;
    L101:
        boolean r126 = true;
    L103:
        boolean r40 = r39 & r126;
        if (r40 == false) goto L219;
        int r127 = Math.min(r5.C[0], r20);
        int r128 = Math.min(r5.C[1], r21);
        if (r10 == 1073741824) goto L108;
    L110:
        if (r12 == 1073741824) goto L112;
    L114:
        if (r10 != 1073741824) goto L197;
        if (r12 != 1073741824) goto L197;
        boolean r129 = r28.f12567a;
        g r130 = (g) r28.f12569c;
        if (r129 == false) goto L119;
    L122:
        Iterator r131 = r130.f17432u0.iterator();
    L124:
        if (r131.hasNext() == false) goto L126;
        f r132 = (f) r131.next();
        r132.i();
        r132.f17394a = false;
        r132.d.n();
        r132.e.m();
        goto L124
    L126:
        int r133 = 0;
        r130.i();
        r130.f17394a = false;
        r130.d.n();
        r130.e.m();
        r28.f12568b = false;
    L127:
        r28.b((g) r28.d);
        r130.f17395a0 = r133;
        r130.f17397b0 = r133;
        ConstraintWidget$DimensionBehaviour r134 = r130.k(r133);
        ConstraintWidget$DimensionBehaviour r135 = r130.k(1);
        if (r28.f12567a == false) goto L130;
        r28.c();
    L130:
        int r136 = r130.s();
        int r137 = r130.t();
        boolean r138 = r40;
        r130.d.f12595h.d(r136);
        r130.e.f12595h.d(r137);
        r28.g();
        ConstraintWidget$DimensionBehaviour r41 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        com.obric.oui.constraintlayout.core.widgets.analyzer.c r139 = r34;
        ArrayList r42 = (ArrayList) r28.e;
        if (r134 == r41) goto L135;
        if (r135 == r41) goto L135;
        r36 = r36;
    L151:
        ConstraintWidget$DimensionBehaviour r43 = r130.U[0];
        ConstraintWidget$DimensionBehaviour r44 = ConstraintWidget$DimensionBehaviour.FIXED;
        if (r43 != r44) goto L154;
    L157:
        int r45 = r130.r() + r136;
        r130.d.f12596i.d(r45);
        r130.d.e.d(r45 - r136);
        r28.g();
        ConstraintWidget$DimensionBehaviour r46 = r130.U[1];
        if (r46 != r44) goto L160;
    L161:
        int r47 = r130.l() + r137;
        r130.e.f12596i.d(r47);
        r130.e.e.d(r47 - r137);
    L162:
        r28.g();
        boolean r48 = true;
    L163:
        Iterator r49 = r42.iterator();
    L165:
        if (r49.hasNext() == false) goto L172;
        s r50 = (s) r49.next();
        if (r50.f12593b != r130) goto L171;
        if (r50.g == false) goto L165;
    L171:
        r50.e();
        goto L165
    L172:
        Iterator r51 = r42.iterator();
    L174:
        if (r51.hasNext() == false) goto L195;
        s r52 = (s) r51.next();
        if (r48 == true) goto L181;
        if (r52.f12593b == r130) goto L174;
    L181:
        if (r52.f12595h.f12576j == false) goto L182;
        if (r52.f12596i.f12576j == true) goto L189;
        if ((r52 instanceof j) == false) goto L182;
    L189:
        if (r52.e.f12576j == true) goto L174;
        if ((r52 instanceof com.obric.oui.constraintlayout.core.widgets.analyzer.d) == true) goto L174;
        if ((r52 instanceof j) == true) goto L174;
    L182:
        boolean r53 = false;
    L196:
        r130.N(r134);
        r130.O(r135);
        boolean r54 = r53;
        int r55 = BasicMeasure.EXACTLY;
        int r56 = 2;
    L211:
        if (r54 == false) goto L220;
        if (r10 != r55) goto L214;
        boolean r57 = true;
    L215:
        if (r12 != r55) goto L217;
        boolean r58 = true;
    L218:
        r5.Q(r57, r58);
        goto L220
    L217:
        r58 = false;
        goto L218
    L214:
        r57 = false;
    L220:
        if (r54 == true) goto L222;
    L223:
        int r59 = r5.H0;
        if (r35 <= 0) goto L305;
        int r60 = r5.f17432u0.size();
        boolean r61 = r5.X(64);
        com.obric.oui.constraintlayout.core.widgets.analyzer.c r62 = r5.f17436y0;
        int r63 = 0;
    L226:
        if (r63 >= r60) goto L285;
        f r140 = (f) r5.f17432u0.get(r63);
        if ((r140 instanceof k) == false) goto L231;
    L284:
        r63 = r63 + 1;
        goto L226
    L231:
        if ((r140 instanceof hr.a) == true) goto L284;
        if (r140.G == true) goto L284;
        if (r61 == false) goto L246;
        com.obric.oui.constraintlayout.core.widgets.analyzer.m r141 = r140.d;
        if (r141 == null) goto L246;
        p r142 = r140.e;
        if (r142 == null) goto L246;
        if (r141.e.f12576j == false) goto L246;
        if (r142.e.f12576j == true) goto L284;
    L246:
        ConstraintWidget$DimensionBehaviour r143 = r140.k(0);
        ConstraintWidget$DimensionBehaviour r144 = r140.k(1);
        ConstraintWidget$DimensionBehaviour r145 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        if (r143 == r145) goto L249;
    L254:
        boolean r146 = false;
    L255:
        if (r146 == true) goto L281;
        if (r5.X(1) == false) goto L281;
        if ((r140 instanceof o) == true) goto L281;
        if (r143 == r145) goto L262;
    L267:
        if (r144 == r145) goto L269;
    L274:
        if (r143 == r145) goto L279;
        if (r144 != r145) goto L281;
    L279:
        if (r140.Y <= 0.0f) goto L281;
        r146 = true;
        goto L281
    L269:
        if (r140.s != 0) goto L274;
        if (r143 == r145) goto L274;
        if (r140.y() == true) goto L274;
        r146 = true;
        goto L274
    L262:
        if (r140.f17421r != 0) goto L267;
        if (r144 == r145) goto L267;
        if (r140.y() == true) goto L267;
        r146 = true;
    L281:
        if (r146 == true) goto L284;
        r33.v(0, r62, r140);
        goto L284
    L249:
        if (r140.f17421r == 1) goto L254;
        if (r144 != r145) goto L254;
        if (r140.s == 1) goto L254;
        r146 = true;
        goto L255
    L285:
        ConstraintLayout r64 = ((b) r62).f13058a;
        int r65 = r64.getChildCount();
        int r147 = 0;
    L286:
        if (r147 >= r65) goto L300;
        View r66 = r64.getChildAt(r147);
        if ((r66 instanceof Placeholder) == false) goto L299;
        Placeholder r67 = (Placeholder) r66;
        if (r67.f13048b == null) goto L299;
        LayoutParams r68 = (LayoutParams) r67.getLayoutParams();
        LayoutParams r69 = (LayoutParams) r67.f13048b.getLayoutParams();
        f r148 = r69.f13027q0;
        r148.i0 = 0;
        f r149 = r68.f13027q0;
        ConstraintWidget$DimensionBehaviour r150 = r149.U[0];
        ConstraintWidget$DimensionBehaviour r151 = ConstraintWidget$DimensionBehaviour.FIXED;
        if (r150 == r151) goto L295;
        r149.P(r148.r());
    L295:
        f r70 = r68.f13027q0;
        if (r70.U[1] == r151) goto L298;
        r70.M(r69.f13027q0.l());
    L298:
        r69.f13027q0.i0 = 8;
    L299:
        r147 = r147 + 1;
        goto L286
    L300:
        ArrayList r71 = r64.f12991b;
        int r72 = r71.size();
        if (r72 <= 0) goto L305;
        int r152 = 0;
    L303:
        if (r152 >= r72) goto L305;
        ((ConstraintHelper) r71.get(r152)).getClass();
        r152 = r152 + 1;
    L305:
        r33.A(r5);
        ArrayList r73 = (ArrayList) r33.f9377c;
        int r74 = r73.size();
        if (r35 <= 0) goto L308;
        int r75 = r36;
        int r153 = 0;
        r33.w(r5, 0, r75, r37);
    L309:
        if (r74 <= 0) goto L396;
        ConstraintWidget$DimensionBehaviour[] r76 = r5.U;
        ConstraintWidget$DimensionBehaviour r77 = r76[r153];
        ConstraintWidget$DimensionBehaviour r154 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        if (r77 != r154) goto L314;
        int r78 = 1;
    L316:
        if (r76[1] != r154) goto L318;
        int r79 = 1;
    L319:
        int r155 = r24.r();
        g r156 = (g) r33.d;
        int r157 = Math.max(r155, r156.f17400d0);
        int r158 = Math.max(r24.l(), r156.f17401e0);
        int r159 = r153;
        int r160 = r159;
    L320:
        if (r159 >= r74) goto L342;
        f r161 = (f) r73.get(r159);
        if ((r161 instanceof o) == true) goto L324;
        com.obric.oui.constraintlayout.core.widgets.analyzer.c r80 = r139;
    L341:
        r159 = r159 + 1;
        r139 = r80;
        r59 = r59;
        goto L320
    L324:
        int r162 = r161.r();
        int r81 = r161.l();
        r80 = r139;
        int r82 = r160 | (r33.v(1, r80, r161) ? 1 : 0);
        int r163 = r161.r();
        int r83 = r161.l();
        if (r163 == r162) goto L332;
        r161.P(r163);
        if (r78 != 0) goto L329;
    L331:
        int r164 = 1;
    L333:
        if (r83 == r81) goto L340;
        r161.M(r83);
        if (r79 != 0) goto L337;
    L339:
        r164 = 1;
        goto L340
    L337:
        if ((r161.t() + r161.X) <= r158) goto L339;
        r158 = Math.max(r158, r161.j(ConstraintAnchor$Type.BOTTOM).e() + (r161.t() + r161.X));
    L340:
        r160 = (((o) r161).C0 ? 1 : 0) | r164;
        goto L341
    L329:
        if ((r161.s() + r161.W) <= r157) goto L331;
        r157 = Math.max(r157, r161.j(ConstraintAnchor$Type.RIGHT).e() + (r161.s() + r161.W));
        goto L331
    L332:
        r164 = r82;
        goto L333
    L342:
        int r210 = r59;
        com.obric.oui.constraintlayout.core.widgets.analyzer.c r84 = r139;
        int r85 = 2;
        int r165 = 0;
    L343:
        if (r165 >= r85) goto L395;
        int r86 = 0;
    L345:
        if (r86 >= r74) goto L392;
        f r166 = (f) r73.get(r86);
        if ((r166 instanceof l) == false) goto L353;
        if ((r166 instanceof o) == true) goto L353;
    L366:
        com.obric.oui.constraintlayout.core.widgets.analyzer.c r167 = r84;
        ArrayList r211 = r73;
        int r212 = r74;
    L391:
        r86 = r86 + 1;
        r73 = r211;
        r74 = r212;
        r84 = r167;
    L353:
        if ((r166 instanceof k) == true) goto L366;
        if (r166.i0 == 8) goto L366;
        if (r138 == false) goto L365;
        if (r166.d.e.f12576j == false) goto L365;
        if (r166.e.e.f12576j == true) goto L366;
    L365:
        if ((r166 instanceof o) == true) goto L366;
        int r168 = r166.r();
        int r87 = r166.l();
        r211 = r73;
        int r88 = r166.f17399c0;
        r212 = r74;
        int r89 = 1;
        if (r165 != 1) goto L370;
        r89 = 2;
    L370:
        int r90 = (r33.v(r89, r84, r166) ? 1 : 0) | r160;
        int r169 = r166.r();
        r167 = r84;
        int r91 = r166.l();
        if (r169 == r168) goto L378;
        r166.P(r169);
        if (r78 != 0) goto L375;
    L377:
        r90 = 1;
        goto L378
    L375:
        if ((r166.s() + r166.W) <= r157) goto L377;
        r157 = Math.max(r157, r166.j(ConstraintAnchor$Type.RIGHT).e() + (r166.s() + r166.W));
    L378:
        if (r91 == r87) goto L386;
        r166.M(r91);
        if (r79 != 0) goto L382;
    L384:
        r90 = 1;
        goto L386
    L382:
        if ((r166.t() + r166.X) <= r158) goto L384;
        r158 = Math.max(r158, r166.j(ConstraintAnchor$Type.BOTTOM).e() + (r166.t() + r166.X));
    L386:
        if (r166.E == true) goto L388;
    L390:
        r160 = r90;
        goto L391
    L388:
        if (r88 == r166.f17399c0) goto L390;
        r160 = 1;
        goto L391
    L392:
        com.obric.oui.constraintlayout.core.widgets.analyzer.c r170 = r84;
        ArrayList r213 = r73;
        int r214 = r74;
        if (r160 == 0) goto L395;
        r165 = r165 + 1;
        r33.w(r24, r165, r75, r37);
        r73 = r213;
        r74 = r214;
        r84 = r170;
        r85 = 2;
        r160 = 0;
    L395:
        r5 = r24;
        int r92 = r210;
    L397:
        r5.H0 = r92;
        fr.c.f16984q = r5.X(512);
        return;
    L318:
        r79 = r153;
        goto L319
    L314:
        r78 = r153;
        goto L316
    L396:
        r92 = r59;
        goto L397
    L308:
        r75 = r36;
        r153 = 0;
        goto L309
    L222:
        if (r56 != 2) goto L223;
        return;
    L195:
        r53 = true;
        goto L196
    L160:
        if (r46 != ConstraintWidget$DimensionBehaviour.MATCH_PARENT) goto L162;
    L154:
        if (r43 == ConstraintWidget$DimensionBehaviour.MATCH_PARENT) goto L157;
        r48 = false;
    L135:
        if (r38 == false) goto L142;
        Iterator r93 = r42.iterator();
    L138:
        if (r93.hasNext() == false) goto L142;
        if (((s) r93.next()).k() == true) goto L138;
        r38 = false;
    L142:
        if (r38 == false) goto L147;
        if (r134 != ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) goto L147;
        r130.N(ConstraintWidget$DimensionBehaviour.FIXED);
        r130.P(r28.d(r130, 0));
        r130.d.e.d(r130.r());
    L147:
        if (r38 == false) goto L151;
        if (r135 != ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) goto L151;
        r130.O(ConstraintWidget$DimensionBehaviour.FIXED);
        r130.M(r28.d(r130, 1));
        r130.e.e.d(r130.l());
        goto L151
    L119:
        if (r28.f12568b == true) goto L122;
        r133 = 0;
    L197:
        r138 = r40;
        r36 = r36;
        r139 = r34;
        boolean r94 = r28.f12567a;
        g r95 = (g) r28.f12569c;
        if (r94 == false) goto L204;
        Iterator r96 = r95.f17432u0.iterator();
    L201:
        if (r96.hasNext() == false) goto L203;
        f r97 = (f) r96.next();
        r97.i();
        r97.f17394a = false;
        com.obric.oui.constraintlayout.core.widgets.analyzer.m r171 = r97.d;
        r171.e.f12576j = false;
        r171.g = false;
        r171.n();
        p r98 = r97.e;
        r98.e.f12576j = false;
        r98.g = false;
        r98.m();
        goto L201
    L203:
        int r172 = 0;
        r95.i();
        r95.f17394a = false;
        com.obric.oui.constraintlayout.core.widgets.analyzer.m r99 = r95.d;
        r99.e.f12576j = false;
        r99.g = false;
        r99.n();
        p r100 = r95.e;
        r100.e.f12576j = false;
        r100.g = false;
        r100.m();
        r28.c();
    L205:
        r28.b((g) r28.d);
        r95.f17395a0 = r172;
        r95.f17397b0 = r172;
        r95.d.f12595h.d(r172);
        r95.e.f12595h.d(r172);
        r55 = BasicMeasure.EXACTLY;
        if (r10 != 1073741824) goto L208;
        r54 = r5.U(r38, r172);
        r56 = 1;
    L209:
        if (r12 != 1073741824) goto L211;
        r54 = r54 & r5.U(r38, 1);
        r56 = r56 + 1;
        goto L211
    L208:
        r56 = 0;
        r54 = true;
        goto L209
    L204:
        r172 = 0;
        goto L205
    L112:
        if (r24.l() == r128) goto L114;
        r5.M(r128);
        r5.f17434w0.f12567a = true;
        goto L114
    L108:
        if (r24.r() == r127) goto L110;
        r5.P(r127);
        r5.f17434w0.f12567a = true;
        goto L110
    L219:
        r138 = r40;
        r139 = r34;
        r36 = r36;
        r56 = 0;
        r54 = false;
    L100:
        if (r38 == true) goto L101;
        r126 = false;
        goto L103
    L57:
        if (hr.m.c(r25, 64) == true) goto L60;
        r39 = false;
        goto L62
    L53:
        r5.f17401e0 = r32;
        goto L54
    L49:
        r5.f17400d0 = r31;
        goto L50
    L42:
        if (r117 == r24.l()) goto L46;
    L34:
        r117 = Math.max(0, this.e);
        goto L39
    L29:
        if (r12 != 1073741824) goto L30;
        r117 = Math.min(this.g - r111, r21);
        goto L39
    L35:
        r113 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        if (r114 != 0) goto L38;
        r117 = Math.max(0, this.e);
        goto L39
    L38:
        r117 = r21;
        goto L39
    L16:
        r115 = Math.min(this.f - r112, r20);
        goto L15
    L17:
        ConstraintWidget$DimensionBehaviour r173 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        if (r114 != 0) goto L21;
        int r174 = Math.max(0, this.d);
    L20:
        r22 = Integer.MIN_VALUE;
        int r215 = r174;
        r116 = r173;
        r115 = r215;
        goto L26
    L21:
        r115 = 0;
        r22 = Integer.MIN_VALUE;
        r116 = r173;
        goto L26
    L22:
        r173 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        if (r114 != 0) goto L25;
        r174 = Math.max(0, this.d);
        goto L20
    L25:
        r116 = r173;
        r22 = Integer.MIN_VALUE;
        r115 = r20;
    L8:
        if (p() == false) goto L10;
        r19 = r110;
        goto L10
    }

    public void setConstraintSet(d r5) {
        this.f12995j = r5;
    }

    @Override // android.view.View
    public void setId(int r5) {
        int r10 = getId();
        SparseArray r11 = this.f12990a;
        r11.remove(r10);
        super.setId(r5);
        r11.put(getId(), this);
    }

    public void setMaxHeight(int r5) {
        if (r5 != this.g) goto L5;
        return;
    L5:
        this.g = r5;
        requestLayout();
    }

    public void setMaxWidth(int r5) {
        if (r5 != this.f) goto L5;
        return;
    L5:
        this.f = r5;
        requestLayout();
    }

    public void setMinHeight(int r5) {
        if (r5 != this.e) goto L5;
        return;
    L5:
        this.e = r5;
        requestLayout();
    }

    public void setMinWidth(int r5) {
        if (r5 != this.d) goto L5;
        return;
    L5:
        this.d = r5;
        requestLayout();
    }

    public void setOnConstraintsChanged(lr.k r5) {
        t r10 = this.f12996k;
        if (r10 == null) goto L6;
        r10.getClass();
        return;
    }

    public void setOptimizationLevel(int r5) {
        this.f12994i = r5;
        g r10 = this.f12992c;
        r10.H0 = r5;
        fr.c.f16984q = r10.X(512);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public final void t(f r5, LayoutParams r10, SparseArray r11, int r12, ConstraintAnchor$Type r13) {
        View r14 = (View) this.f12990a.get(r12);
        f r15 = (f) r11.get(r12);
        if (r15 == null) goto L12;
        if (r14 != null) goto L6;
        return;
    L6:
        if ((r14.getLayoutParams() instanceof LayoutParams) == false) goto L14;
        r10.f13006c0 = true;
        ConstraintAnchor$Type r16 = ConstraintAnchor$Type.BASELINE;
        if (r13 != r16) goto L10;
        LayoutParams r17 = (LayoutParams) r14.getLayoutParams();
        r17.f13006c0 = true;
        r17.f13027q0.E = true;
    L10:
        r5.j(r16).b(r15.j(r13), r10.D, r10.C, true);
        r5.E = true;
        r5.j(ConstraintAnchor$Type.TOP).j();
        r5.j(ConstraintAnchor$Type.BOTTOM).j();
        return;
    L14:
        return;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        return new LayoutParams(r5);
    }

    public ConstraintLayout(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f12990a = new SparseArray();
        this.f12991b = new ArrayList(4);
        this.f12992c = new g();
        this.d = 0;
        this.e = 0;
        this.f = Integer.MAX_VALUE;
        this.g = Integer.MAX_VALUE;
        this.f12993h = true;
        this.f12994i = 257;
        this.f12995j = null;
        this.f12996k = null;
        this.f12997l = -1;
        this.f12998m = new HashMap();
        this.f12999n = new SparseArray();
        this.f13000o = new b(this, this);
        o(r10, 0);
    }

    public ConstraintLayout(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f12990a = new SparseArray();
        this.f12991b = new ArrayList(4);
        this.f12992c = new g();
        this.d = 0;
        this.e = 0;
        this.f = Integer.MAX_VALUE;
        this.g = Integer.MAX_VALUE;
        this.f12993h = true;
        this.f12994i = 257;
        this.f12995j = null;
        this.f12996k = null;
        this.f12997l = -1;
        this.f12998m = new HashMap();
        this.f12999n = new SparseArray();
        this.f13000o = new b(this, this);
        o(r10, r11);
    }
}
