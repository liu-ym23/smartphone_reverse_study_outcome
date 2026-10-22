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
import androidx.core.view.ViewCompat;
import com.obric.memorydata.plugin.R;
import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.f;
import com.obric.oui.constraintlayout.core.widgets.i;
import com.obric.oui.constraintlayout.core.widgets.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class ConstraintLayout extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean OPTIMIZE_HEIGHT_CHANGE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.2.0-alpha04";
    private static d sSharedValues;
    SparseArray<View> mChildrenByIds;
    private ArrayList<ConstraintHelper> mConstraintHelpers;
    protected com.obric.oui.constraintlayout.widget.a mConstraintLayoutSpec;
    private com.obric.oui.constraintlayout.widget.b mConstraintSet;
    private int mConstraintSetId;
    private HashMap<String, Integer> mDesignIds;
    protected boolean mDirtyHierarchy;
    private int mLastMeasureHeight;
    int mLastMeasureHeightMode;
    int mLastMeasureHeightSize;
    private int mLastMeasureWidth;
    int mLastMeasureWidthMode;
    int mLastMeasureWidthSize;
    protected com.obric.oui.constraintlayout.core.widgets.d mLayoutWidget;
    private int mMaxHeight;
    private int mMaxWidth;
    a mMeasurer;
    private com.obric.oui.constraintlayout.core.e mMetrics;
    private int mMinHeight;
    private int mMinWidth;
    private ArrayList<b> mModifiers;
    private int mOnMeasureHeightMeasureSpec;
    private int mOnMeasureWidthMeasureSpec;
    private int mOptimizationLevel;
    private SparseArray<ConstraintWidget> mTempMapIdToWidget;

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.widget.ConstraintLayout$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13745a = null;

        static {
            int[] r0 = new int[ConstraintWidget.DimensionBehaviour.values().length];
            f13745a = r0;
            r0[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f13745a[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f13745a[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f13745a[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int A;
        public int B;
        public int C;
        public int D;
        boolean E;
        boolean F;
        public float G;
        public float H;
        public String I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        float f13746J;
        int K;
        public float L;
        public float M;
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
        public int f13747a;
        public boolean aa;
        public boolean ab;
        public String ac;
        public int ad;
        boolean ae;
        boolean af;
        boolean ag;
        boolean ah;
        boolean ai;
        boolean aj;
        boolean ak;
        int al;
        int am;
        int an;
        int ao;
        int ap;
        int aq;
        float ar;
        int as;
        int at;
        float au;
        ConstraintWidget av;
        public boolean aw;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f13748b;
        public float c;
        public boolean d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public int o;
        public int p;
        public int q;
        public float r;
        public int s;
        public int t;
        public int u;
        public int v;
        public int w;
        public int x;
        public int y;
        public int z;

        private static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f13749a = null;

            static {
                SparseIntArray r0 = new SparseIntArray();
                f13749a = r0;
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintWidth, "styleable", "ConstraintLayout_Layout_layout_constraintWidth"), 64);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintHeight, "styleable", "ConstraintLayout_Layout_layout_constraintHeight"), 65);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, "styleable", "ConstraintLayout_Layout_layout_constraintLeft_toLeftOf"), 8);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, "styleable", "ConstraintLayout_Layout_layout_constraintLeft_toRightOf"), 9);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, "styleable", "ConstraintLayout_Layout_layout_constraintRight_toLeftOf"), 10);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, "styleable", "ConstraintLayout_Layout_layout_constraintRight_toRightOf"), 11);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, "styleable", "ConstraintLayout_Layout_layout_constraintTop_toTopOf"), 12);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, "styleable", "ConstraintLayout_Layout_layout_constraintTop_toBottomOf"), 13);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, "styleable", "ConstraintLayout_Layout_layout_constraintBottom_toTopOf"), 14);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, "styleable", "ConstraintLayout_Layout_layout_constraintBottom_toBottomOf"), 15);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, "styleable", "ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf"), 16);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toTopOf, "styleable", "ConstraintLayout_Layout_layout_constraintBaseline_toTopOf"), 52);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf, "styleable", "ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf"), 53);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, "styleable", "ConstraintLayout_Layout_layout_constraintCircle"), 2);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, "styleable", "ConstraintLayout_Layout_layout_constraintCircleRadius"), 3);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, "styleable", "ConstraintLayout_Layout_layout_constraintCircleAngle"), 4);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, "styleable", "ConstraintLayout_Layout_layout_editor_absoluteX"), 49);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, "styleable", "ConstraintLayout_Layout_layout_editor_absoluteY"), 50);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, "styleable", "ConstraintLayout_Layout_layout_constraintGuide_begin"), 5);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, "styleable", "ConstraintLayout_Layout_layout_constraintGuide_end"), 6);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, "styleable", "ConstraintLayout_Layout_layout_constraintGuide_percent"), 7);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_guidelineUseRtl, "styleable", "ConstraintLayout_Layout_guidelineUseRtl"), 67);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_orientation, "styleable", "ConstraintLayout_Layout_android_orientation"), 1);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, "styleable", "ConstraintLayout_Layout_layout_constraintStart_toEndOf"), 17);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, "styleable", "ConstraintLayout_Layout_layout_constraintStart_toStartOf"), 18);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, "styleable", "ConstraintLayout_Layout_layout_constraintEnd_toStartOf"), 19);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, "styleable", "ConstraintLayout_Layout_layout_constraintEnd_toEndOf"), 20);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, "styleable", "ConstraintLayout_Layout_layout_goneMarginLeft"), 21);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, "styleable", "ConstraintLayout_Layout_layout_goneMarginTop"), 22);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, "styleable", "ConstraintLayout_Layout_layout_goneMarginRight"), 23);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, "styleable", "ConstraintLayout_Layout_layout_goneMarginBottom"), 24);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, "styleable", "ConstraintLayout_Layout_layout_goneMarginStart"), 25);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, "styleable", "ConstraintLayout_Layout_layout_goneMarginEnd"), 26);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_goneMarginBaseline, "styleable", "ConstraintLayout_Layout_layout_goneMarginBaseline"), 55);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_marginBaseline, "styleable", "ConstraintLayout_Layout_layout_marginBaseline"), 54);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, "styleable", "ConstraintLayout_Layout_layout_constraintHorizontal_bias"), 29);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, "styleable", "ConstraintLayout_Layout_layout_constraintVertical_bias"), 30);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, "styleable", "ConstraintLayout_Layout_layout_constraintDimensionRatio"), 44);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, "styleable", "ConstraintLayout_Layout_layout_constraintHorizontal_weight"), 45);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, "styleable", "ConstraintLayout_Layout_layout_constraintVertical_weight"), 46);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, "styleable", "ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle"), 47);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, "styleable", "ConstraintLayout_Layout_layout_constraintVertical_chainStyle"), 48);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, "styleable", "ConstraintLayout_Layout_layout_constrainedWidth"), 27);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, "styleable", "ConstraintLayout_Layout_layout_constrainedHeight"), 28);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, "styleable", "ConstraintLayout_Layout_layout_constraintWidth_default"), 31);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, "styleable", "ConstraintLayout_Layout_layout_constraintHeight_default"), 32);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, "styleable", "ConstraintLayout_Layout_layout_constraintWidth_min"), 33);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, "styleable", "ConstraintLayout_Layout_layout_constraintWidth_max"), 34);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, "styleable", "ConstraintLayout_Layout_layout_constraintWidth_percent"), 35);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, "styleable", "ConstraintLayout_Layout_layout_constraintHeight_min"), 36);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, "styleable", "ConstraintLayout_Layout_layout_constraintHeight_max"), 37);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, "styleable", "ConstraintLayout_Layout_layout_constraintHeight_percent"), 38);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, "styleable", "ConstraintLayout_Layout_layout_constraintLeft_creator"), 39);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, "styleable", "ConstraintLayout_Layout_layout_constraintTop_creator"), 40);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, "styleable", "ConstraintLayout_Layout_layout_constraintRight_creator"), 41);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, "styleable", "ConstraintLayout_Layout_layout_constraintBottom_creator"), 42);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, "styleable", "ConstraintLayout_Layout_layout_constraintBaseline_creator"), 43);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintTag, "styleable", "ConstraintLayout_Layout_layout_constraintTag"), 51);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_wrapBehaviorInParent, "styleable", "ConstraintLayout_Layout_layout_wrapBehaviorInParent"), 66);
            }
        }

        public LayoutParams(int r7, int r8) {
            super(r7, r8);
            this.f13747a = -1;
            this.f13748b = -1;
            this.c = -1.0f;
            this.d = true;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = 0;
            this.r = 0.0f;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = Integer.MIN_VALUE;
            this.x = Integer.MIN_VALUE;
            this.y = Integer.MIN_VALUE;
            this.z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.f13746J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.aa = false;
            this.ab = false;
            this.ac = null;
            this.ad = 0;
            this.ae = true;
            this.af = true;
            this.ag = false;
            this.ah = false;
            this.ai = false;
            this.aj = false;
            this.ak = false;
            this.al = -1;
            this.am = -1;
            this.an = -1;
            this.ao = -1;
            this.ap = Integer.MIN_VALUE;
            this.aq = Integer.MIN_VALUE;
            this.ar = 0.5f;
            this.av = new ConstraintWidget();
            this.aw = false;
        }

        public LayoutParams(Context r11, AttributeSet r12) {
            Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
            AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
            super(r13, r14);
            this.f13747a = -1;
            this.f13748b = -1;
            this.c = -1.0f;
            this.d = true;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = 0;
            this.r = 0.0f;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = Integer.MIN_VALUE;
            this.x = Integer.MIN_VALUE;
            this.y = Integer.MIN_VALUE;
            this.z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.f13746J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.aa = false;
            this.ab = false;
            this.ac = null;
            this.ad = 0;
            this.ae = true;
            this.af = true;
            this.ag = false;
            this.ah = false;
            this.ai = false;
            this.aj = false;
            this.ak = false;
            this.al = -1;
            this.am = -1;
            this.an = -1;
            this.ao = -1;
            this.ap = Integer.MIN_VALUE;
            this.aq = Integer.MIN_VALUE;
            this.ar = 0.5f;
            this.av = new ConstraintWidget();
            this.aw = false;
            TypedArray r15 = r13.obtainStyledAttributes(r14, R.styleable.ConstraintLayout_Layout);
            int r16 = r15.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r16) goto L119;
            int r5 = r15.getIndex(r1);
            int r6 = a.f13749a.get(r5);
            switch(r6) {
                case 1: goto L117;
                case 2: goto L114;
                case 3: goto L113;
                case 4: goto L110;
                case 5: goto L109;
                case 6: goto L108;
                case 7: goto L107;
                case 8: goto L104;
                case 9: goto L101;
                case 10: goto L98;
                case 11: goto L95;
                case 12: goto L92;
                case 13: goto L89;
                case 14: goto L86;
                case 15: goto L83;
                case 16: goto L80;
                case 17: goto L77;
                case 18: goto L74;
                case 19: goto L71;
                case 20: goto L68;
                case 21: goto L67;
                case 22: goto L66;
                case 23: goto L65;
                case 24: goto L64;
                case 25: goto L63;
                case 26: goto L62;
                case 27: goto L61;
                case 28: goto L60;
                case 29: goto L59;
                case 30: goto L58;
                case 31: goto L54;
                case 32: goto L51;
                case 33: goto L123;
                case 34: goto L127;
                case 35: goto L40;
                case 36: goto L121;
                case 37: goto L125;
                case 38: goto L29;
                default: goto L6;
            };
        L6:
            switch(r6) {
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
            switch(r6) {
                case 64: goto L12;
                case 65: goto L11;
                case 66: goto L10;
                case 67: goto L9;
                default: goto L118;
            };
        L9:
            this.d = r15.getBoolean(r5, this.d);
            goto L118
        L10:
            this.ad = r15.getInt(r5, this.ad);
            goto L118
        L11:
            com.obric.oui.constraintlayout.widget.b.a(this, r15, r5, 1);
            this.F = true;
            goto L118
        L12:
            com.obric.oui.constraintlayout.widget.b.a(this, r15, r5, 0);
            this.E = true;
        L118:
            r1 = r1 + 1;
            goto L3
        L13:
            this.C = r15.getDimensionPixelSize(r5, this.C);
            goto L118
        L14:
            this.D = r15.getDimensionPixelSize(r5, this.D);
            goto L118
        L15:
            int r7 = r15.getResourceId(r5, this.o);
            this.o = r7;
            if (r7 != (-1)) goto L118;
            this.o = r15.getInt(r5, -1);
            goto L118
        L18:
            int r8 = r15.getResourceId(r5, this.n);
            this.n = r8;
            if (r8 != (-1)) goto L118;
            this.n = r15.getInt(r5, -1);
            goto L118
        L21:
            this.ac = r15.getString(r5);
            goto L118
        L22:
            this.Y = r15.getDimensionPixelOffset(r5, this.Y);
            goto L118
        L23:
            this.X = r15.getDimensionPixelOffset(r5, this.X);
            goto L118
        L24:
            this.O = r15.getInt(r5, 0);
            goto L118
        L25:
            this.N = r15.getInt(r5, 0);
            goto L118
        L26:
            this.M = r15.getFloat(r5, this.M);
            goto L118
        L27:
            this.L = r15.getFloat(r5, this.L);
            goto L118
        L28:
            com.obric.oui.constraintlayout.widget.b.a(this, r15.getString(r5));
            goto L118
        L29:
            this.W = Math.max(0.0f, r15.getFloat(r5, this.W));
            this.Q = 2;
            goto L118
        L40:
            this.V = Math.max(0.0f, r15.getFloat(r5, this.V));
            this.P = 2;
            goto L118
        L51:
            int r9 = r15.getInt(r5, 0);
            this.Q = r9;
            if (r9 != 1) goto L118;
            String r10 = "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.";
        L57:
            Log.e(ConstraintLayout.TAG, r10);
            goto L118
        L54:
            int r17 = r15.getInt(r5, 0);
            this.P = r17;
            if (r17 != 1) goto L118;
            r10 = "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.";
            goto L57
        L58:
            this.H = r15.getFloat(r5, this.H);
            goto L118
        L59:
            this.G = r15.getFloat(r5, this.G);
            goto L118
        L60:
            this.ab = r15.getBoolean(r5, this.ab);
            goto L118
        L61:
            this.aa = r15.getBoolean(r5, this.aa);
            goto L118
        L62:
            this.B = r15.getDimensionPixelSize(r5, this.B);
            goto L118
        L63:
            this.A = r15.getDimensionPixelSize(r5, this.A);
            goto L118
        L64:
            this.z = r15.getDimensionPixelSize(r5, this.z);
            goto L118
        L65:
            this.y = r15.getDimensionPixelSize(r5, this.y);
            goto L118
        L66:
            this.x = r15.getDimensionPixelSize(r5, this.x);
            goto L118
        L67:
            this.w = r15.getDimensionPixelSize(r5, this.w);
            goto L118
        L68:
            int r18 = r15.getResourceId(r5, this.v);
            this.v = r18;
            if (r18 != (-1)) goto L118;
            this.v = r15.getInt(r5, -1);
            goto L118
        L71:
            int r19 = r15.getResourceId(r5, this.u);
            this.u = r19;
            if (r19 != (-1)) goto L118;
            this.u = r15.getInt(r5, -1);
            goto L118
        L74:
            int r20 = r15.getResourceId(r5, this.t);
            this.t = r20;
            if (r20 != (-1)) goto L118;
            this.t = r15.getInt(r5, -1);
            goto L118
        L77:
            int r21 = r15.getResourceId(r5, this.s);
            this.s = r21;
            if (r21 != (-1)) goto L118;
            this.s = r15.getInt(r5, -1);
            goto L118
        L80:
            int r22 = r15.getResourceId(r5, this.m);
            this.m = r22;
            if (r22 != (-1)) goto L118;
            this.m = r15.getInt(r5, -1);
            goto L118
        L83:
            int r23 = r15.getResourceId(r5, this.l);
            this.l = r23;
            if (r23 != (-1)) goto L118;
            this.l = r15.getInt(r5, -1);
            goto L118
        L86:
            int r24 = r15.getResourceId(r5, this.k);
            this.k = r24;
            if (r24 != (-1)) goto L118;
            this.k = r15.getInt(r5, -1);
            goto L118
        L89:
            int r25 = r15.getResourceId(r5, this.j);
            this.j = r25;
            if (r25 != (-1)) goto L118;
            this.j = r15.getInt(r5, -1);
            goto L118
        L92:
            int r26 = r15.getResourceId(r5, this.i);
            this.i = r26;
            if (r26 != (-1)) goto L118;
            this.i = r15.getInt(r5, -1);
            goto L118
        L95:
            int r27 = r15.getResourceId(r5, this.h);
            this.h = r27;
            if (r27 != (-1)) goto L118;
            this.h = r15.getInt(r5, -1);
            goto L118
        L98:
            int r28 = r15.getResourceId(r5, this.g);
            this.g = r28;
            if (r28 != (-1)) goto L118;
            this.g = r15.getInt(r5, -1);
            goto L118
        L101:
            int r29 = r15.getResourceId(r5, this.f);
            this.f = r29;
            if (r29 != (-1)) goto L118;
            this.f = r15.getInt(r5, -1);
            goto L118
        L104:
            int r30 = r15.getResourceId(r5, this.e);
            this.e = r30;
            if (r30 != (-1)) goto L118;
            this.e = r15.getInt(r5, -1);
            goto L118
        L107:
            this.c = r15.getFloat(r5, this.c);
            goto L118
        L108:
            this.f13748b = r15.getDimensionPixelOffset(r5, this.f13748b);
            goto L118
        L109:
            this.f13747a = r15.getDimensionPixelOffset(r5, this.f13747a);
            goto L118
        L110:
            float r31 = r15.getFloat(r5, this.r) % 360.0f;
            this.r = r31;
            if (r31 >= 0.0f) goto L118;
            this.r = (360.0f - r31) % 360.0f;
            goto L118
        L113:
            this.q = r15.getDimensionPixelSize(r5, this.q);
            goto L118
        L114:
            int r32 = r15.getResourceId(r5, this.p);
            this.p = r32;
            if (r32 != (-1)) goto L118;
            this.p = r15.getInt(r5, -1);
            goto L118
        L117:
            this.Z = r15.getInt(r5, this.Z);
            goto L118
        L121:
            this.S = r15.getDimensionPixelSize(r5, this.S);     // Catch: Exception -> L37
        L38:
            if (r15.getInt(r5, this.S) != (-2)) goto L118;
            this.S = -2;
            goto L118
        L123:
            this.R = r15.getDimensionPixelSize(r5, this.R);     // Catch: Exception -> L48
        L49:
            if (r15.getInt(r5, this.R) != (-2)) goto L118;
            this.R = -2;
            goto L118
        L125:
            this.U = r15.getDimensionPixelSize(r5, this.U);     // Catch: Exception -> L32
        L33:
            if (r15.getInt(r5, this.U) != (-2)) goto L118;
            this.U = -2;
            goto L118
        L127:
            this.T = r15.getDimensionPixelSize(r5, this.T);     // Catch: Exception -> L43
        L44:
            if (r15.getInt(r5, this.T) != (-2)) goto L118;
            this.T = -2;
            goto L118
        L119:
            r15.recycle();
            b();
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
            this.f13747a = -1;
            this.f13748b = -1;
            this.c = -1.0f;
            this.d = true;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = 0;
            this.r = 0.0f;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = Integer.MIN_VALUE;
            this.x = Integer.MIN_VALUE;
            this.y = Integer.MIN_VALUE;
            this.z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.f13746J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.aa = false;
            this.ab = false;
            this.ac = null;
            this.ad = 0;
            this.ae = true;
            this.af = true;
            this.ag = false;
            this.ah = false;
            this.ai = false;
            this.aj = false;
            this.ak = false;
            this.al = -1;
            this.am = -1;
            this.an = -1;
            this.ao = -1;
            this.ap = Integer.MIN_VALUE;
            this.aq = Integer.MIN_VALUE;
            this.ar = 0.5f;
            this.av = new ConstraintWidget();
            this.aw = false;
            if (ZeusTransformUtils.instanceOf(r10, ViewGroup.MarginLayoutParams.class) == false) goto L6;
            ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r10, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
            this.leftMargin = r1.leftMargin;
            this.rightMargin = r1.rightMargin;
            this.topMargin = r1.topMargin;
            this.bottomMargin = r1.bottomMargin;
            setMarginStart(r1.getMarginStart());
            setMarginEnd(r1.getMarginEnd());
        L6:
            if (ZeusTransformUtils.instanceOf(r10, LayoutParams.class) == true) goto L8;
            return;
        L8:
            LayoutParams r11 = (LayoutParams) ZeusTransformUtils.preCheckCast(r10, LayoutParams.class, "com.obric.memorydata.plugin");
            this.f13747a = r11.f13747a;
            this.f13748b = r11.f13748b;
            this.c = r11.c;
            this.d = r11.d;
            this.e = r11.e;
            this.f = r11.f;
            this.g = r11.g;
            this.h = r11.h;
            this.i = r11.i;
            this.j = r11.j;
            this.k = r11.k;
            this.l = r11.l;
            this.m = r11.m;
            this.n = r11.n;
            this.o = r11.o;
            this.p = r11.p;
            this.q = r11.q;
            this.r = r11.r;
            this.s = r11.s;
            this.t = r11.t;
            this.u = r11.u;
            this.v = r11.v;
            this.w = r11.w;
            this.x = r11.x;
            this.y = r11.y;
            this.z = r11.z;
            this.A = r11.A;
            this.B = r11.B;
            this.C = r11.C;
            this.D = r11.D;
            this.G = r11.G;
            this.H = r11.H;
            this.I = r11.I;
            this.f13746J = r11.f13746J;
            this.K = r11.K;
            this.L = r11.L;
            this.M = r11.M;
            this.N = r11.N;
            this.O = r11.O;
            this.aa = r11.aa;
            this.ab = r11.ab;
            this.P = r11.P;
            this.Q = r11.Q;
            this.R = r11.R;
            this.T = r11.T;
            this.S = r11.S;
            this.U = r11.U;
            this.V = r11.V;
            this.W = r11.W;
            this.X = r11.X;
            this.Y = r11.Y;
            this.Z = r11.Z;
            this.ae = r11.ae;
            this.af = r11.af;
            this.ag = r11.ag;
            this.ah = r11.ah;
            this.al = r11.al;
            this.am = r11.am;
            this.an = r11.an;
            this.ao = r11.ao;
            this.ap = r11.ap;
            this.aq = r11.aq;
            this.ar = r11.ar;
            this.ac = r11.ac;
            this.ad = r11.ad;
            this.av = r11.av;
            this.E = r11.E;
            this.F = r11.F;
        }

        public ConstraintWidget a() {
            return this.av;
        }

        public void b() {
            this.ah = false;
            this.ae = true;
            this.af = true;
            if (this.width != (-2)) goto L10;
            if (this.aa == false) goto L10;
            this.ae = false;
            if (this.P != 0) goto L10;
            this.P = 1;
        L10:
            if (this.height != (-2)) goto L17;
            if (this.ab == false) goto L17;
            this.af = false;
            if (this.Q != 0) goto L17;
            this.Q = 1;
        L17:
            if (this.width != 0) goto L19;
        L20:
            this.ae = false;
            if (this.width == 0) goto L23;
        L26:
            if (this.height != 0) goto L28;
        L29:
            this.af = false;
            if (this.height == 0) goto L32;
        L35:
            if (this.c == (-1.0f)) goto L37;
        L40:
            this.ah = true;
            this.ae = true;
            this.af = true;
            if (ZeusTransformUtils.instanceOf(this.av, f.class) == true) goto L43;
            this.av = new f();
        L43:
            ((f) ZeusTransformUtils.preCheckCast(this.av, f.class, "com.obric.memorydata.plugin")).a(this.Z);
            return;
        L37:
            if (this.f13747a != (-1)) goto L40;
            if (this.f13748b != (-1)) goto L40;
            return;
        L32:
            if (this.Q != 1) goto L35;
            this.height = -2;
            this.ab = true;
            goto L35
        L28:
            if (this.height != (-1)) goto L35;
        L23:
            if (this.P != 1) goto L26;
            this.width = -2;
            this.aa = true;
            goto L26
        L19:
            if (this.width != (-1)) goto L26;
            goto L20
        }

        public String c() {
            return this.ac;
        }

        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        public void resolveLayoutDirection(int r11) {
            int r0 = this.leftMargin;
            int r1 = this.rightMargin;
            super.resolveLayoutDirection(r11);
            boolean r2 = false;
            if (1 != getLayoutDirection()) goto L5;
            boolean r12 = true;
        L6:
            this.an = -1;
            this.ao = -1;
            this.al = -1;
            this.am = -1;
            this.ap = -1;
            this.aq = -1;
            this.ap = this.w;
            this.aq = this.y;
            float r5 = this.G;
            this.ar = r5;
            int r6 = this.f13747a;
            this.as = r6;
            int r7 = this.f13748b;
            this.at = r7;
            float r8 = this.c;
            this.au = r8;
            if (r12 == false) goto L44;
            int r13 = this.s;
            if (r13 == (-1)) goto L12;
            this.an = r13;
        L11:
            r2 = true;
        L15:
            int r14 = this.u;
            if (r14 == (-1)) goto L18;
            this.am = r14;
            r2 = true;
        L18:
            int r15 = this.v;
            if (r15 == (-1)) goto L21;
            this.al = r15;
            r2 = true;
        L21:
            int r16 = this.A;
            if (r16 == Integer.MIN_VALUE) goto L24;
            this.aq = r16;
        L24:
            int r17 = this.B;
            if (r17 == Integer.MIN_VALUE) goto L28;
            this.ap = r17;
        L28:
            if (r2 == false) goto L31;
            this.ar = 1.0f - r5;
        L31:
            if (this.ah == false) goto L63;
            if (this.Z != 1) goto L63;
            if (this.d == false) goto L63;
            if (r8 == (-1.0f)) goto L39;
            this.au = 1.0f - r8;
            this.as = -1;
            this.at = -1;
            goto L63
        L39:
            if (r6 == (-1)) goto L42;
            this.at = r6;
            this.as = -1;
        L41:
            this.au = -1.0f;
            goto L63
        L42:
            if (r7 == (-1)) goto L63;
            this.as = r7;
            this.at = -1;
        L63:
            if (this.u == (-1)) goto L65;
            return;
        L65:
            if (this.v == (-1)) goto L67;
            return;
        L67:
            if (this.t == (-1)) goto L69;
            return;
        L69:
            if (this.s != (-1)) goto L97;
            int r18 = this.g;
            if (r18 == (-1)) goto L76;
            this.an = r18;
            if (this.rightMargin > 0) goto L82;
            if (r1 <= 0) goto L82;
        L75:
            this.rightMargin = r1;
        L82:
            int r19 = this.e;
            if (r19 == (-1)) goto L88;
            this.al = r19;
            if (this.leftMargin > 0) goto L98;
            if (r0 <= 0) goto L99;
        L87:
            this.leftMargin = r0;
            return;
        L99:
            return;
        L98:
            return;
        L88:
            int r110 = this.f;
            if (r110 == (-1)) goto L101;
            this.am = r110;
            if (this.leftMargin > 0) goto L102;
            if (r0 > 0) goto L87;
            return;
        L102:
            return;
        L101:
            return;
        L76:
            int r111 = this.h;
            if (r111 == (-1)) goto L82;
            this.ao = r111;
            if (this.rightMargin > 0) goto L82;
            if (r1 <= 0) goto L82;
        L97:
            return;
        L12:
            int r112 = this.t;
            if (r112 == (-1)) goto L15;
            this.ao = r112;
            goto L11
        L44:
            int r113 = this.s;
            if (r113 == (-1)) goto L47;
            this.am = r113;
        L47:
            int r114 = this.t;
            if (r114 == (-1)) goto L50;
            this.al = r114;
        L50:
            int r115 = this.u;
            if (r115 == (-1)) goto L53;
            this.an = r115;
        L53:
            int r116 = this.v;
            if (r116 == (-1)) goto L56;
            this.ao = r116;
        L56:
            int r117 = this.A;
            if (r117 == Integer.MIN_VALUE) goto L59;
            this.ap = r117;
        L59:
            int r118 = this.B;
            if (r118 == Integer.MIN_VALUE) goto L63;
            this.aq = r118;
            goto L63
        L5:
            r12 = false;
            goto L6
        }
    }

    class a implements com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC0736b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ConstraintLayout f13750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f13751b;
        int c;
        int d;
        int e;
        int f;
        int g;
        final /* synthetic */ ConstraintLayout h;

        a(ConstraintLayout r1, ConstraintLayout r2) {
            this.h = r1;
            this.f13750a = r2;
        }

        private boolean a(int r3, int r4, int r5) {
            if (r3 != r4) goto L5;
            return true;
        L5:
            int r6 = View.MeasureSpec.getMode(r3);
            int r0 = View.MeasureSpec.getMode(r4);
            int r7 = View.MeasureSpec.getSize(r4);
            if (r0 == 1073741824) goto L8;
        L12:
            return false;
        L8:
            if (r6 == Integer.MIN_VALUE) goto L10;
            if (r6 != 0) goto L12;
        L10:
            if (r5 != r7) goto L12;
            return true;
        }

        @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC0736b
        public final void a() {
            int r0 = this.f13750a.getChildCount();
            int r1 = 0;
            int r2 = 0;
        L4:
            if (r2 >= r0) goto L9;
            View r4 = this.f13750a.getChildAt(r2);
            if (ZeusTransformUtils.instanceOf(r4, Placeholder.class) == false) goto L8;
            ((Placeholder) ZeusTransformUtils.preCheckCast(r4, Placeholder.class, "com.obric.memorydata.plugin")).b(this.f13750a);
        L8:
            r2 = r2 + 1;
            goto L4
        L9:
            int r3 = ConstraintLayout.access$200(this.f13750a).size();
            if (r3 <= 0) goto L13;
        L11:
            if (r1 >= r3) goto L18;
            ((ConstraintHelper) ZeusTransformUtils.preCheckCast(ConstraintLayout.access$200(this.f13750a).get(r1), ConstraintHelper.class, "com.obric.memorydata.plugin")).g(this.f13750a);
            r1 = r1 + 1;
            goto L11
        L18:
            return;
        }

        public void a(int r1, int r2, int r3, int r4, int r5, int r6) {
            this.f13751b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r1;
            this.g = r2;
        }

        @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC0736b
        public final void a(ConstraintWidget r22, com.obric.oui.constraintlayout.core.widgets.analyzer.b.a r23) {
            if (r22 != null) goto L6;
            return;
        L6:
            if (r22.B() != 8) goto L12;
            if (r22.s() == true) goto L12;
            r23.h = 0;
            r23.i = 0;
            r23.j = 0;
            return;
        L12:
            if (r22.A() != null) goto L14;
            return;
        L14:
            long r3 = 0;
            if (ConstraintLayout.access$000(this.h) == null) goto L17;
            ConstraintLayout.access$000(this.h).I++;
            r3 = System.nanoTime();
        L17:
            ConstraintWidget.DimensionBehaviour r6 = r23.d;
            ConstraintWidget.DimensionBehaviour r8 = r23.e;
            int r9 = r23.f;
            int r10 = r23.g;
            int r11 = this.f13751b + this.c;
            int r12 = this.d;
            View r13 = (View) ZeusTransformUtils.preCheckCast(r22.T(), View.class, "com.obric.memorydata.plugin");
            int r14 = AnonymousClass1.f13745a[r6.ordinal()];
            if (r14 != 1) goto L20;
            int r5 = View.MeasureSpec.makeMeasureSpec(r9, 1073741824);
        L56:
            int r7 = AnonymousClass1.f13745a[r8.ordinal()];
            if (r7 != 1) goto L59;
            int r15 = View.MeasureSpec.makeMeasureSpec(r10, 1073741824);
        L95:
            com.obric.oui.constraintlayout.core.widgets.d r16 = (com.obric.oui.constraintlayout.core.widgets.d) ZeusTransformUtils.preCheckCast(r22.A(), com.obric.oui.constraintlayout.core.widgets.d.class, "com.obric.memorydata.plugin");
            if (r16 == null) goto L121;
            if (i.a(ConstraintLayout.access$100(this.h), 256) == false) goto L121;
            if (r13.getMeasuredWidth() != r22.F()) goto L121;
            if (r13.getMeasuredWidth() >= r16.F()) goto L121;
            if (r13.getMeasuredHeight() != r22.G()) goto L121;
            if (r13.getMeasuredHeight() >= r16.G()) goto L121;
            if (r13.getBaseline() != r22.S()) goto L121;
            if (r22.t() == true) goto L121;
            if (a(r22.u(), r5, r22.F()) == true) goto L114;
        L116:
            boolean r17 = false;
        L117:
            if (r17 == false) goto L121;
            r23.h = r22.F();
            r23.i = r22.G();
            r23.j = r22.S();
            return;
        L114:
            if (a(r22.v(), r15, r22.G()) == false) goto L116;
            r17 = true;
        L121:
            if (r6 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L123;
            boolean r18 = true;
        L125:
            if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L127;
            boolean r19 = true;
        L129:
            if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L131;
        L134:
            boolean r20 = true;
        L136:
            if (r6 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L138;
        L141:
            boolean r21 = true;
        L143:
            if (r18 == true) goto L145;
        L147:
            boolean r110 = false;
        L148:
            if (r19 == true) goto L150;
        L152:
            boolean r111 = false;
        L153:
            if (r13 != null) goto L155;
            return;
        L155:
            long r112 = r3;
            LayoutParams r4 = (LayoutParams) ZeusTransformUtils.preCheckCast(r13.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
            if (r23.m == com.obric.oui.constraintlayout.core.widgets.analyzer.b.a.f13618b) goto L168;
            if (r23.m == com.obric.oui.constraintlayout.core.widgets.analyzer.b.a.c) goto L168;
            if (r18 == false) goto L168;
            if (r22.n != 0) goto L168;
            if (r19 == false) goto L168;
            if (r22.o != 0) goto L168;
            int r24 = -1;
            int r113 = 0;
            int r114 = 0;
            int r115 = 0;
        L207:
            if (r113 == r24) goto L209;
            boolean r25 = true;
        L211:
            if (r114 == r23.f) goto L213;
        L216:
            boolean r26 = true;
        L217:
            r23.l = r26;
            if (r4.ag == false) goto L220;
            r25 = true;
        L220:
            if (r25 == true) goto L222;
        L226:
            r23.h = r114;
            r23.i = r115;
            r23.k = r25;
            r23.j = r113;
            if (ConstraintLayout.access$000(this.h) == null) goto L230;
            long r1 = System.nanoTime();
            ConstraintLayout.access$000(this.h).f13547a += r1 - r112;
            return;
        L230:
            return;
        L222:
            if (r113 == (-1)) goto L226;
            if (r22.S() == r113) goto L226;
            r23.l = true;
            goto L226
        L213:
            if (r115 != r23.g) goto L216;
            r26 = false;
            goto L217
        L209:
            r25 = false;
        L168:
            if (ZeusTransformUtils.instanceOf(r13, VirtualLayout.class) == true) goto L170;
        L172:
            r13.measure(r5, r15);
        L173:
            r22.d(r5, r15);
            int r27 = r13.getMeasuredWidth();
            int r28 = r13.getMeasuredHeight();
            r113 = r13.getBaseline();
            if (r22.q <= 0) goto L176;
            r114 = Math.max(r22.q, r27);
        L178:
            if (r22.r <= 0) goto L181;
            r114 = Math.min(r22.r, r114);
        L181:
            if (r22.t <= 0) goto L183;
            r115 = Math.max(r22.t, r28);
        L185:
            if (r22.u <= 0) goto L187;
            r115 = Math.min(r22.u, r115);
        L187:
            int r29 = r15;
            if (i.a(ConstraintLayout.access$100(this.h), 1) == false) goto L190;
        L196:
            if (r27 != r114) goto L200;
            if (r28 != r115) goto L200;
        L199:
            r24 = -1;
        L200:
            if (r27 == r114) goto L202;
            int r30 = 1073741824;
            int r31 = View.MeasureSpec.makeMeasureSpec(r114, 1073741824);
        L203:
            if (r28 == r115) goto L205;
            int r32 = View.MeasureSpec.makeMeasureSpec(r115, r30);
        L206:
            r13.measure(r31, r32);
            r22.d(r31, r32);
            r114 = r13.getMeasuredWidth();
            r115 = r13.getMeasuredHeight();
            r113 = r13.getBaseline();
            goto L199
        L205:
            r32 = r29;
            goto L206
        L202:
            r30 = 1073741824;
            r31 = r5;
            goto L203
        L190:
            if (r110 == false) goto L193;
            if (r20 == false) goto L193;
            r114 = (int) ((r115 * r22.P) + 0.5f);
        L193:
            if (r111 == false) goto L196;
            if (r21 == false) goto L196;
            r115 = (int) ((r114 / r22.P) + 0.5f);
            goto L196
        L183:
            r115 = r28;
            goto L185
        L176:
            r114 = r27;
            goto L178
        L170:
            if (ZeusTransformUtils.instanceOf(r22, k.class) == false) goto L172;
            ((VirtualLayout) ZeusTransformUtils.preCheckCast(r13, VirtualLayout.class, "com.obric.memorydata.plugin")).a((k) ZeusTransformUtils.preCheckCast(r22, k.class, "com.obric.memorydata.plugin"), r5, r15);
            goto L173
        L150:
            if (r22.P <= 0.0f) goto L152;
            r111 = true;
            goto L153
        L145:
            if (r22.P <= 0.0f) goto L147;
            r110 = true;
            goto L148
        L138:
            if (r6 == ConstraintWidget.DimensionBehaviour.FIXED) goto L141;
            r21 = false;
            goto L143
        L131:
            if (r8 == ConstraintWidget.DimensionBehaviour.FIXED) goto L134;
            r20 = false;
            goto L136
        L127:
            r19 = false;
            goto L129
        L123:
            r18 = false;
            goto L125
        L59:
            if (r7 != 2) goto L61;
            int r33 = this.g;
            int r34 = -2;
        L93:
            r15 = ViewGroup.getChildMeasureSpec(r33, r11, r34);
            goto L95
        L61:
            if (r7 != 3) goto L63;
            r33 = this.g;
            r11 = r11 + r22.O();
            r34 = -1;
            goto L93
        L63:
            if (r7 == 4) goto L65;
            r15 = 0;
            goto L95
        L65:
            r15 = ViewGroup.getChildMeasureSpec(this.g, r11, -2);
            if (r22.o != 1) goto L68;
            boolean r35 = true;
        L70:
            if (r23.m == com.obric.oui.constraintlayout.core.widgets.analyzer.b.a.f13618b) goto L74;
            if (r23.m != com.obric.oui.constraintlayout.core.widgets.analyzer.b.a.c) goto L95;
        L74:
            if (r13.getMeasuredWidth() != r22.F()) goto L76;
            boolean r116 = true;
        L78:
            if (r23.m == com.obric.oui.constraintlayout.core.widgets.analyzer.b.a.c) goto L88;
            if (r35 == false) goto L88;
            if (r35 == false) goto L83;
            if (r116 == true) goto L88;
        L83:
            if (ZeusTransformUtils.instanceOf(r13, Placeholder.class) == true) goto L88;
            if (r22.e() == true) goto L88;
            boolean r36 = false;
        L89:
            if (r36 == false) goto L95;
            r15 = View.MeasureSpec.makeMeasureSpec(r22.G(), 1073741824);
        L88:
            r36 = true;
            goto L89
        L76:
            r116 = false;
            goto L78
        L68:
            r35 = false;
            goto L70
        L20:
            if (r14 != 2) goto L22;
            int r37 = this.f;
            int r38 = -2;
        L54:
            r5 = ViewGroup.getChildMeasureSpec(r37, r12, r38);
            goto L56
        L22:
            if (r14 != 3) goto L24;
            r37 = this.f;
            r12 = r12 + r22.N();
            r38 = -1;
            goto L54
        L24:
            if (r14 == 4) goto L26;
            r5 = 0;
            goto L56
        L26:
            r5 = ViewGroup.getChildMeasureSpec(this.f, r12, -2);
            if (r22.n != 1) goto L29;
            boolean r39 = true;
        L31:
            if (r23.m == com.obric.oui.constraintlayout.core.widgets.analyzer.b.a.f13618b) goto L35;
            if (r23.m != com.obric.oui.constraintlayout.core.widgets.analyzer.b.a.c) goto L56;
        L35:
            if (r13.getMeasuredHeight() != r22.G()) goto L37;
            boolean r117 = true;
        L39:
            if (r23.m == com.obric.oui.constraintlayout.core.widgets.analyzer.b.a.c) goto L49;
            if (r39 == false) goto L49;
            if (r39 == false) goto L44;
            if (r117 == true) goto L49;
        L44:
            if (ZeusTransformUtils.instanceOf(r13, Placeholder.class) == true) goto L49;
            if (r22.d() == true) goto L49;
            boolean r40 = false;
        L50:
            if (r40 == false) goto L56;
            r5 = View.MeasureSpec.makeMeasureSpec(r22.F(), 1073741824);
        L49:
            r40 = true;
            goto L50
        L37:
            r117 = false;
            goto L39
        L29:
            r39 = false;
            goto L31
        }
    }

    public interface b {
        boolean update(int r1, int r2, int r3, View r4, LayoutParams r5);
    }

    static {
    }

    public ConstraintLayout(Context r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"));
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new com.obric.oui.constraintlayout.core.widgets.d();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new a(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(null, 0, 0);
    }

    public ConstraintLayout(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r5, r6);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new com.obric.oui.constraintlayout.core.widgets.d();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new a(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(r6, 0, 0);
    }

    public ConstraintLayout(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7, r5);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new com.obric.oui.constraintlayout.core.widgets.d();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new a(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(r7, r5, 0);
    }

    public ConstraintLayout(Context r3, AttributeSet r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r7, r8, r5, r6);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new com.obric.oui.constraintlayout.core.widgets.d();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new a(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(r8, r5, r6);
    }

    static /* synthetic */ com.obric.oui.constraintlayout.core.e access$000(ConstraintLayout r0) {
        return r0.mMetrics;
    }

    static /* synthetic */ int access$100(ConstraintLayout r0) {
        return r0.mOptimizationLevel;
    }

    static /* synthetic */ ArrayList access$200(ConstraintLayout r0) {
        return r0.mConstraintHelpers;
    }

    private int getPaddingWidth() {
        int r0 = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int r2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        if (r2 > 0) goto L5;
        return r0;
    L5:
        return r2;
    }

    public static d getSharedValues() {
        if (sSharedValues != null) goto L6;
        sSharedValues = new d();
    L6:
        return sSharedValues;
    }

    private ConstraintWidget getTargetWidget(int r4) {
        if (r4 == 0) goto L4;
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mChildrenByIds.get(r4), View.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L13;
        r0 = findViewById(r4);
        if (r0 == null) goto L13;
        if (r0 == this) goto L13;
        if (r0.getParent() != this) goto L13;
        onViewAdded(r0);
    L13:
        if (r0 == this) goto L15;
        if (r0 != null) goto L19;
        return null;
    L19:
        return ((LayoutParams) ZeusTransformUtils.preCheckCast(r0.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).av;
    L15:
        return this.mLayoutWidget;
    L4:
        return this.mLayoutWidget;
    }

    private void init(AttributeSet r8, int r9, int r10) {
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.memorydata.plugin");
        this.mLayoutWidget.a(this);
        this.mLayoutWidget.a(this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (r11 == null) goto L37;
        TypedArray r12 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r11, R.styleable.ConstraintLayout_Layout, r9, r10);
        int r13 = r12.getIndexCount();
        int r2 = 0;
    L5:
        if (r2 >= r13) goto L36;
        int r3 = r12.getIndex(r2);
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_minWidth, "styleable", "ConstraintLayout_Layout_android_minWidth")) goto L10;
        this.mMinWidth = r12.getDimensionPixelOffset(r3, this.mMinWidth);
    L35:
        r2 = r2 + 1;
        goto L5
    L10:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_minHeight, "styleable", "ConstraintLayout_Layout_android_minHeight")) goto L13;
        this.mMinHeight = r12.getDimensionPixelOffset(r3, this.mMinHeight);
        goto L35
    L13:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_maxWidth, "styleable", "ConstraintLayout_Layout_android_maxWidth")) goto L16;
        this.mMaxWidth = r12.getDimensionPixelOffset(r3, this.mMaxWidth);
        goto L35
    L16:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_maxHeight, "styleable", "ConstraintLayout_Layout_android_maxHeight")) goto L19;
        this.mMaxHeight = r12.getDimensionPixelOffset(r3, this.mMaxHeight);
        goto L35
    L19:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_optimizationLevel, "styleable", "ConstraintLayout_Layout_layout_optimizationLevel")) goto L22;
        this.mOptimizationLevel = r12.getInt(r3, this.mOptimizationLevel);
        goto L35
    L22:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layoutDescription, "styleable", "ConstraintLayout_Layout_layoutDescription")) goto L29;
        int r4 = r12.getResourceId(r3, 0);
        if (r4 == 0) goto L35;
        parseLayoutDescription(r4);     // Catch: Resources.NotFoundException -> L27
    L27:
        this.mConstraintLayoutSpec = null;
        goto L35
    L29:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_constraintSet, "styleable", "ConstraintLayout_Layout_constraintSet")) goto L35;
        int r5 = r12.getResourceId(r3, 0);
        com.obric.oui.constraintlayout.widget.b r6 = new com.obric.oui.constraintlayout.widget.b();     // Catch: Resources.NotFoundException -> L33
        this.mConstraintSet = r6;     // Catch: Resources.NotFoundException -> L33
        r6.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5);     // Catch: Resources.NotFoundException -> L33
    L34:
        this.mConstraintSetId = r5;
    L33:
        this.mConstraintSet = null;
        goto L34
    L36:
        r12.recycle();
    L37:
        this.mLayoutWidget.a(this.mOptimizationLevel);
    }

    private void markHierarchyDirty() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    private void setChildrenConstraints() {
        boolean r6 = isInEditMode();
        int r7 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r7) goto L10;
        ConstraintWidget r2 = getViewWidget(getChildAt(r1));
        if (r2 == null) goto L8;
        r2.w();
    L8:
        r1 = r1 + 1;
        goto L3
    L10:
        if (r6 == false) goto L20;
        int r3 = 0;
    L12:
        if (r3 >= r7) goto L20;
        View r4 = getChildAt(r3);
        String r5 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getResourceName(r4.getId());     // Catch: Resources.NotFoundException -> L54
        setDesignInformation(0, r5, Integer.valueOf(r4.getId()));     // Catch: Resources.NotFoundException -> L54
        int r8 = r5.indexOf(47);     // Catch: Resources.NotFoundException -> L54
        if (r8 == (-1)) goto L17;
        r5 = r5.substring(r8 + 1);     // Catch: Resources.NotFoundException -> L54
    L17:
        getTargetWidget(r4.getId()).a(r5);     // Catch: Resources.NotFoundException -> L54
    L18:
        r3 = r3 + 1;
    L20:
        if (this.mConstraintSetId == (-1)) goto L29;
        int r9 = 0;
    L22:
        if (r9 >= r7) goto L29;
        View r10 = getChildAt(r9);
        if (r10.getId() != this.mConstraintSetId) goto L28;
        if (ZeusTransformUtils.instanceOf(r10, Constraints.class) == false) goto L28;
        this.mConstraintSet = ((Constraints) ZeusTransformUtils.preCheckCast(r10, Constraints.class, "com.obric.memorydata.plugin")).getConstraintSet();
    L28:
        r9 = r9 + 1;
    L29:
        com.obric.oui.constraintlayout.widget.b r11 = this.mConstraintSet;
        if (r11 == null) goto L32;
        r11.a(this, true);
    L32:
        this.mLayoutWidget.al();
        int r12 = this.mConstraintHelpers.size();
        if (r12 <= 0) goto L37;
        int r13 = 0;
    L35:
        if (r13 >= r12) goto L37;
        ((ConstraintHelper) ZeusTransformUtils.preCheckCast(this.mConstraintHelpers.get(r13), ConstraintHelper.class, "com.obric.memorydata.plugin")).e(this);
        r13 = r13 + 1;
    L37:
        int r14 = 0;
    L38:
        if (r14 >= r7) goto L43;
        View r15 = getChildAt(r14);
        if (ZeusTransformUtils.instanceOf(r15, Placeholder.class) == false) goto L42;
        ((Placeholder) ZeusTransformUtils.preCheckCast(r15, Placeholder.class, "com.obric.memorydata.plugin")).a(this);
    L42:
        r14 = r14 + 1;
        goto L38
    L43:
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        int r16 = 0;
    L44:
        if (r16 >= r7) goto L46;
        View r17 = getChildAt(r16);
        this.mTempMapIdToWidget.put(r17.getId(), getViewWidget(r17));
        r16 = r16 + 1;
        goto L44
    L46:
        int r18 = 0;
    L47:
        if (r18 >= r7) goto L53;
        View r19 = getChildAt(r18);
        ConstraintWidget r20 = getViewWidget(r19);
        if (r20 == null) goto L52;
        LayoutParams r21 = (LayoutParams) ZeusTransformUtils.preCheckCast(r19.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        this.mLayoutWidget.b(r20);
        applyConstraintsFromLayoutParams(r6, r19, r20, r21, this.mTempMapIdToWidget);
    L52:
        r18 = r18 + 1;
        goto L47
    }

    private void setWidgetBaseline(ConstraintWidget r3, LayoutParams r4, SparseArray<ConstraintWidget> r5, int r6, ConstraintAnchor.Type r7) {
        View r2 = (View) ZeusTransformUtils.preCheckCast(this.mChildrenByIds.get(r6), View.class, "com.obric.memorydata.plugin");
        ConstraintWidget r8 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r5.get(r6), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L12;
        if (r2 != null) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2.getLayoutParams(), LayoutParams.class) == false) goto L14;
        r4.ag = true;
        if (r7 != ConstraintAnchor.Type.BASELINE) goto L10;
        LayoutParams r9 = (LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        r9.ag = true;
        r9.av.c(true);
    L10:
        r3.a(ConstraintAnchor.Type.BASELINE).a(r8.a(r7), r4.D, r4.C, true);
        r3.c(true);
        r3.a(ConstraintAnchor.Type.TOP).k();
        r3.a(ConstraintAnchor.Type.BOTTOM).k();
        return;
    L14:
        return;
    }

    private boolean updateHierarchy() {
        int r0 = getChildCount();
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (getChildAt(r2).isLayoutRequested() == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        r1 = true;
    L8:
        if (r1 == false) goto L10;
        setChildrenConstraints();
    L10:
        return r1;
    }

    public void addValueModifier(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        if (this.mModifiers != null) goto L5;
        this.mModifiers = new ArrayList();
    L5:
        this.mModifiers.add(r4);
    }

    public void applyConstraintsFromLayoutParams(boolean r18, View r19, ConstraintWidget r20, LayoutParams r21, SparseArray<ConstraintWidget> r22) {
        r21.b();
        r21.aw = false;
        r20.l(r19.getVisibility());
        if (r21.aj == false) goto L5;
        r20.d(true);
        r20.l(8);
    L5:
        r20.a(r19);
        if (ZeusTransformUtils.instanceOf(r19, ConstraintHelper.class) == false) goto L10;
        ((ConstraintHelper) ZeusTransformUtils.preCheckCast(r19, ConstraintHelper.class, "com.obric.memorydata.plugin")).a(r20, this.mLayoutWidget.ag());
    L10:
        if (r21.ah == false) goto L18;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r20, f.class, "com.obric.memorydata.plugin");
        int r1 = r21.as;
        int r2 = r21.at;
        float r3 = r21.au;
        if (r3 == (-1.0f)) goto L14;
        r0.e(r3);
        return;
    L14:
        if (r1 == (-1)) goto L16;
        r0.b(r1);
        return;
    L16:
        if (r2 == (-1)) goto L117;
        r0.A(r2);
        return;
    L117:
        return;
    L18:
        int r4 = r21.al;
        int r5 = r21.am;
        int r13 = r21.an;
        int r14 = r21.ao;
        int r6 = r21.ap;
        int r15 = r21.aq;
        float r7 = r21.ar;
        if (r21.p == (-1)) goto L23;
        ConstraintWidget r8 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r22.get(r21.p), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L81;
        r20.a(r8, r21.r, r21.q);
    L81:
        if (r18 == false) goto L88;
        if (r21.X == (-1)) goto L85;
    L86:
        r20.e(r21.X, r21.Y);
        goto L88
    L85:
        if (r21.Y != (-1)) goto L86;
    L88:
        if (r21.ae == false) goto L90;
        r20.a(ConstraintWidget.DimensionBehaviour.FIXED);
        r20.q(r21.width);
        if (r21.width != (-2)) goto L101;
        r20.a(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
    L101:
        if (r21.af == false) goto L103;
        r20.b(ConstraintWidget.DimensionBehaviour.FIXED);
        r20.r(r21.height);
        if (r21.height != (-2)) goto L113;
        r20.b(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
    L113:
        r20.b(r21.I);
        r20.c(r21.L);
        r20.d(r21.M);
        r20.v(r21.N);
        r20.w(r21.O);
        r20.k(r21.ad);
        r20.a(r21.P, r21.R, r21.T, r21.V);
        r20.b(r21.Q, r21.S, r21.U, r21.W);
        return;
    L103:
        if (r21.height == (-1)) goto L105;
        r20.b(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        r20.r(0);
        goto L113
    L105:
        if (r21.ab == false) goto L107;
        ConstraintWidget.DimensionBehaviour r9 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
    L108:
        r20.b(r9);
        ConstraintAnchor r10 = r20.a(ConstraintAnchor.Type.TOP);
        r10.d = r21.topMargin;
        ConstraintAnchor r11 = r20.a(ConstraintAnchor.Type.BOTTOM);
        r11.d = r21.bottomMargin;
        goto L113
    L107:
        r9 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        goto L108
    L90:
        if (r21.width == (-1)) goto L92;
        r20.a(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        r20.q(0);
        goto L101
    L92:
        if (r21.aa == false) goto L94;
        ConstraintWidget.DimensionBehaviour r12 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
    L95:
        r20.a(r12);
        ConstraintAnchor r16 = r20.a(ConstraintAnchor.Type.LEFT);
        r16.d = r21.leftMargin;
        ConstraintAnchor r17 = r20.a(ConstraintAnchor.Type.RIGHT);
        r17.d = r21.rightMargin;
        goto L101
    L94:
        r12 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        goto L95
    L23:
        if (r4 == (-1)) goto L28;
        ConstraintWidget r23 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r22.get(r4), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r23 == null) goto L27;
        ConstraintAnchor.Type r24 = ConstraintAnchor.Type.LEFT;
        ConstraintAnchor.Type r25 = ConstraintAnchor.Type.LEFT;
        float r26 = r7;
        int r27 = r21.leftMargin;
    L33:
        r20.a(r24, r23, r25, r27, r6);
    L34:
        if (r13 == (-1)) goto L38;
        ConstraintWidget r28 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r22.get(r13), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r28 == null) goto L44;
        ConstraintAnchor.Type r29 = ConstraintAnchor.Type.RIGHT;
        ConstraintAnchor.Type r30 = ConstraintAnchor.Type.LEFT;
    L42:
        r20.a(r29, r28, r30, r21.rightMargin, r15);
    L44:
        if (r21.i == (-1)) goto L49;
        ConstraintWidget r31 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r22.get(r21.i), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r31 == null) goto L55;
        ConstraintAnchor.Type r32 = ConstraintAnchor.Type.TOP;
        ConstraintAnchor.Type r33 = ConstraintAnchor.Type.TOP;
    L53:
        r20.a(r32, r31, r33, r21.topMargin, r21.x);
    L55:
        if (r21.k == (-1)) goto L60;
        ConstraintWidget r34 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r22.get(r21.k), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r34 == null) goto L66;
        ConstraintAnchor.Type r35 = ConstraintAnchor.Type.BOTTOM;
        ConstraintAnchor.Type r36 = ConstraintAnchor.Type.TOP;
    L64:
        r20.a(r35, r34, r36, r21.bottomMargin, r21.z);
    L66:
        if (r21.m == (-1)) goto L70;
        int r37 = r21.m;
        ConstraintAnchor.Type r38 = ConstraintAnchor.Type.BASELINE;
    L68:
        setWidgetBaseline(r20, r21, r22, r37, r38);
    L76:
        if (r26 < 0.0f) goto L79;
        r20.a(r26);
    L79:
        if (r21.H < 0.0f) goto L81;
        r20.b(r21.H);
        goto L81
    L70:
        if (r21.n == (-1)) goto L73;
        r37 = r21.n;
        r38 = ConstraintAnchor.Type.TOP;
        goto L68
    L73:
        if (r21.o == (-1)) goto L76;
        r37 = r21.o;
        r38 = ConstraintAnchor.Type.BOTTOM;
        goto L68
    L60:
        if (r21.l == (-1)) goto L66;
        r34 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r22.get(r21.l), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r34 == null) goto L66;
        r35 = ConstraintAnchor.Type.BOTTOM;
        r36 = ConstraintAnchor.Type.BOTTOM;
        goto L64
    L49:
        if (r21.j == (-1)) goto L55;
        r31 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r22.get(r21.j), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r31 == null) goto L55;
        r32 = ConstraintAnchor.Type.TOP;
        r33 = ConstraintAnchor.Type.BOTTOM;
        goto L53
    L38:
        if (r14 == (-1)) goto L44;
        r28 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r22.get(r14), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r28 == null) goto L44;
        r29 = ConstraintAnchor.Type.RIGHT;
        r30 = ConstraintAnchor.Type.RIGHT;
        goto L42
    L27:
        r26 = r7;
        goto L34
    L28:
        r26 = r7;
        if (r5 == (-1)) goto L34;
        r23 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r22.get(r5), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r23 == null) goto L34;
        r24 = ConstraintAnchor.Type.LEFT;
        r25 = ConstraintAnchor.Type.RIGHT;
        r27 = r21.leftMargin;
        goto L33
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return ZeusTransformUtils.instanceOf(r1, LayoutParams.class);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r22) {
        ArrayList<ConstraintHelper> r1 = this.mConstraintHelpers;
        if (r1 == null) goto L9;
        int r2 = r1.size();
        if (r2 <= 0) goto L9;
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L9;
        ((ConstraintHelper) ZeusTransformUtils.preCheckCast(this.mConstraintHelpers.get(r4), ConstraintHelper.class, "com.obric.memorydata.plugin")).a(this);
        r4 = r4 + 1;
    L9:
        super.dispatchDraw(r22);
        if (isInEditMode() == false) goto L24;
        float r3 = getWidth();
        float r5 = getHeight();
        int r7 = getChildCount();
        int r8 = 0;
    L12:
        if (r8 >= r7) goto L32;
        View r9 = getChildAt(r8);
        if (r9.getVisibility() == 8) goto L23;
        Object r10 = r9.getTag();
        if (r10 == null) goto L23;
        if (ZeusTransformUtils.instanceOf(r10, String.class) == false) goto L23;
        String[] r11 = ((String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin")).split(",");
        if (r11.length != 4) goto L23;
        int r12 = Integer.parseInt(r11[0]);
        int r13 = Integer.parseInt(r11[1]);
        int r14 = Integer.parseInt(r11[2]);
        int r15 = (int) ((r12 / 1080.0f) * r3);
        int r16 = (int) ((r13 / 1920.0f) * r5);
        int r17 = (int) ((Integer.parseInt(r11[3]) / 1920.0f) * r5);
        Paint r18 = new Paint();
        r18.setColor(-65536);
        float r19 = r15;
        float r110 = r16;
        float r111 = r15 + ((int) ((r14 / 1080.0f) * r3));
        r22.drawLine(r19, r110, r111, r110, r18);
        float r20 = r16 + r17;
        r22.drawLine(r111, r110, r111, r20, r18);
        r22.drawLine(r111, r20, r19, r20, r18);
        r22.drawLine(r19, r20, r19, r110, r18);
        r18.setColor(-16711936);
        r22.drawLine(r19, r110, r111, r20, r18);
        r22.drawLine(r19, r20, r111, r110, r18);
    L23:
        r8 = r8 + 1;
        goto L12
    L32:
        return;
    }

    public boolean dynamicUpdateConstraints(int r12, int r13) {
        boolean r1 = false;
        if (this.mModifiers != null) goto L5;
        return false;
    L5:
        int r14 = View.MeasureSpec.getSize(r12);
        int r15 = View.MeasureSpec.getSize(r13);
        Iterator<b> r0 = this.mModifiers.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        b r9 = (b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.memorydata.plugin");
        Iterator<ConstraintWidget> r10 = this.mLayoutWidget.ak().iterator();
    L10:
        if (r10.hasNext() == false) goto L7;
        View r6 = (View) ZeusTransformUtils.preCheckCast(((ConstraintWidget) ZeusTransformUtils.preCheckCast(r10.next(), ConstraintWidget.class, "com.obric.memorydata.plugin")).T(), View.class, "com.obric.memorydata.plugin");
        r1 = r1 | r9.update(r14, r15, r6.getId(), r6, (LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin"));
        goto L10
    L12:
        return r1;
    }

    public void fillMetrics(com.obric.oui.constraintlayout.core.e r1) {
        this.mMetrics = r1;
        this.mLayoutWidget.a(r1);
    }

    @Override // android.view.View
    public void forceLayout() {
        markHierarchyDirty();
        super.forceLayout();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return generateLayoutParams((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new LayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        return new LayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5);
    }

    public Object getDesignInformation(int r2, Object r3) {
        if (r2 == 0) goto L4;
        return null;
    L4:
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L13;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
        HashMap<String, Integer> r5 = this.mDesignIds;
        if (r5 != null) goto L8;
        return null;
    L8:
        if (r5.containsKey(r4) == true) goto L10;
        return null;
    L10:
        return this.mDesignIds.get(r4);
    L13:
        return null;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.h();
    }

    public String getSceneString() {
        StringBuilder r0 = new StringBuilder();
        if (this.mLayoutWidget.k != null) goto L9;
        int r1 = getId();
        if (r1 == (-1)) goto L7;
        this.mLayoutWidget.k = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getResourceEntryName(r1);
        goto L9
    L7:
        this.mLayoutWidget.k = "parent";
    L9:
        if (this.mLayoutWidget.C() != null) goto L11;
        com.obric.oui.constraintlayout.core.widgets.d r2 = this.mLayoutWidget;
        r2.a(r2.k);
        Log.v(TAG, " setDebugName " + this.mLayoutWidget.C());
    L11:
        Iterator<ConstraintWidget> r3 = this.mLayoutWidget.ak().iterator();
    L13:
        if (r3.hasNext() == false) goto L24;
        ConstraintWidget r6 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r3.next(), ConstraintWidget.class, "com.obric.memorydata.plugin");
        View r7 = (View) ZeusTransformUtils.preCheckCast(r6.T(), View.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L13;
        if (r6.k != null) goto L22;
        int r8 = r7.getId();
        if (r8 == (-1)) goto L22;
        r6.k = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getResourceEntryName(r8);
    L22:
        if (r6.C() != null) goto L13;
        r6.a(r6.k);
        Log.v(TAG, " setDebugName " + r6.C());
        goto L13
    L24:
        this.mLayoutWidget.a(r0);
        return r0.toString();
    }

    public View getViewById(int r2) {
        return (View) ZeusTransformUtils.preCheckCast(this.mChildrenByIds.get(r2), View.class, "com.obric.memorydata.plugin");
    }

    public final ConstraintWidget getViewWidget(View r3) {
        if (r3 == this) goto L4;
        if (r3 != null) goto L7;
        return null;
    L7:
        if (ZeusTransformUtils.instanceOf(r3.getLayoutParams(), LayoutParams.class) == true) goto L9;
        r3.setLayoutParams(generateLayoutParams(r3.getLayoutParams()));
        if (ZeusTransformUtils.instanceOf(r3.getLayoutParams(), LayoutParams.class) == true) goto L9;
        return null;
    L9:
        return ((LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).av;
    L4:
        return this.mLayoutWidget;
    }

    public boolean isRtl() {
        if ((((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationInfo().flags & 4194304) == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return false;
    L8:
        if (1 == getLayoutDirection()) goto L10;
        return false;
    L10:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    public void loadLayoutDescription(int r6) {
        if (r6 != 0) goto L9;
    L6:
        this.mConstraintLayoutSpec = null;
        return;
    L9:
        this.mConstraintLayoutSpec = new com.obric.oui.constraintlayout.widget.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this, r6);     // Catch: Resources.NotFoundException -> L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        com.obric.oui.constraintlayout.core.e r12 = this.mMetrics;
        if (r12 == null) goto L5;
        r12.H++;
    L5:
        int r13 = getChildCount();
        boolean r14 = isInEditMode();
        int r15 = 0;
        int r16 = 0;
    L7:
        if (r16 >= r13) goto L27;
        View r0 = getChildAt(r16);
        LayoutParams r1 = (LayoutParams) ZeusTransformUtils.preCheckCast(r0.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        ConstraintWidget r2 = r1.av;
        if (r0.getVisibility() != 8) goto L19;
        if (r1.ah == true) goto L19;
        if (r1.ai == true) goto L19;
        if (r1.ak == true) goto L19;
        if (r14 == true) goto L19;
    L26:
        r16 = r16 + 1;
    L19:
        if (r1.aj == true) goto L26;
        int r3 = r2.D();
        int r4 = r2.E();
        int r5 = r2.F() + r3;
        int r6 = r2.G() + r4;
        r0.layout(r3, r4, r5, r6);
        if (ZeusTransformUtils.instanceOf(r0, Placeholder.class) == false) goto L26;
        View r17 = ((Placeholder) ZeusTransformUtils.preCheckCast(r0, Placeholder.class, "com.obric.memorydata.plugin")).getContent();
        if (r17 == null) goto L26;
        r17.setVisibility(0);
        r17.layout(r3, r4, r5, r6);
        goto L26
    L27:
        int r18 = this.mConstraintHelpers.size();
        if (r18 <= 0) goto L31;
    L29:
        if (r15 >= r18) goto L39;
        ((ConstraintHelper) ZeusTransformUtils.preCheckCast(this.mConstraintHelpers.get(r15), ConstraintHelper.class, "com.obric.memorydata.plugin")).b(this);
        r15 = r15 + 1;
        goto L29
    L39:
        return;
    }

    @Override // android.view.View
    public void onMeasure(int r11, int r12) {
        if (this.mMetrics == null) goto L5;
        long r0 = System.nanoTime();
        this.mMetrics.K = getChildCount();
        this.mMetrics.L++;
    L6:
        boolean r2 = this.mDirtyHierarchy | dynamicUpdateConstraints(r11, r12);
        this.mDirtyHierarchy = r2;
        if (r2 == true) goto L14;
        int r3 = getChildCount();
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L14;
        if (getChildAt(r4).isLayoutRequested() == true) goto L12;
        r4 = r4 + 1;
        goto L9
    L12:
        this.mDirtyHierarchy = true;
    L14:
        boolean r5 = this.mDirtyHierarchy;
        this.mOnMeasureWidthMeasureSpec = r11;
        this.mOnMeasureHeightMeasureSpec = r12;
        this.mLayoutWidget.h(isRtl());
        if (this.mDirtyHierarchy == false) goto L19;
        this.mDirtyHierarchy = false;
        if (updateHierarchy() == false) goto L19;
        this.mLayoutWidget.f();
    L19:
        this.mLayoutWidget.a(this.mMetrics);
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, r11, r12);
        resolveMeasuredDimension(r11, r12, this.mLayoutWidget.F(), this.mLayoutWidget.G(), this.mLayoutWidget.i(), this.mLayoutWidget.af());
        com.obric.oui.constraintlayout.core.e r10 = this.mMetrics;
        if (r10 == null) goto L25;
        r10.f13546J += System.nanoTime() - r0;
        return;
    L25:
        return;
    L5:
        r0 = 0;
        goto L6
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r6) {
        super.onViewAdded(r6);
        ConstraintWidget r0 = getViewWidget(r6);
        if (ZeusTransformUtils.instanceOf(r6, Guideline.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r0, f.class) == true) goto L8;
        LayoutParams r1 = (LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        r1.av = new f();
        r1.ah = true;
        ((f) ZeusTransformUtils.preCheckCast(r1.av, f.class, "com.obric.memorydata.plugin")).a(r1.Z);
    L8:
        if (ZeusTransformUtils.instanceOf(r6, ConstraintHelper.class) == false) goto L12;
        ConstraintHelper r2 = (ConstraintHelper) ZeusTransformUtils.preCheckCast(r6, ConstraintHelper.class, "com.obric.memorydata.plugin");
        r2.d();
        ((LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).ai = true;
        if (this.mConstraintHelpers.contains(r2) == true) goto L12;
        this.mConstraintHelpers.add(r2);
    L12:
        this.mChildrenByIds.put(r6.getId(), r6);
        this.mDirtyHierarchy = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r3) {
        super.onViewRemoved(r3);
        this.mChildrenByIds.remove(r3.getId());
        ConstraintWidget r0 = getViewWidget(r3);
        this.mLayoutWidget.c(r0);
        this.mConstraintHelpers.remove(r3);
        this.mDirtyHierarchy = true;
    }

    public void parseLayoutDescription(int r5) {
        this.mConstraintLayoutSpec = new com.obric.oui.constraintlayout.widget.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this, r5);
    }

    void removeValueModifier(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        this.mModifiers.remove(r4);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        markHierarchyDirty();
        super.requestLayout();
    }

    public void resolveMeasuredDimension(int r3, int r4, int r5, int r6, boolean r7, boolean r8) {
        int r0 = this.mMeasurer.e;
        int r9 = resolveSizeAndState(r5 + this.mMeasurer.d, r3, 0);
        int r10 = resolveSizeAndState(r6 + r0, r4, 0);
        int r11 = r9 & ViewCompat.MEASURED_SIZE_MASK;
        int r12 = r10 & ViewCompat.MEASURED_SIZE_MASK;
        int r13 = Math.min(this.mMaxWidth, r11);
        int r14 = Math.min(this.mMaxHeight, r12);
        if (r7 == false) goto L5;
        r13 = r13 | 16777216;
    L5:
        if (r8 == false) goto L7;
        r14 = r14 | 16777216;
    L7:
        setMeasuredDimension(r13, r14);
        this.mLastMeasureWidth = r13;
        this.mLastMeasureHeight = r14;
    }

    public void resolveSystem(com.obric.oui.constraintlayout.core.widgets.d r18, int r19, int r20, int r21) {
        int r7 = View.MeasureSpec.getMode(r20);
        int r0 = View.MeasureSpec.getSize(r20);
        int r8 = View.MeasureSpec.getMode(r21);
        int r1 = View.MeasureSpec.getSize(r21);
        int r16 = Math.max(0, getPaddingTop());
        int r13 = Math.max(0, getPaddingBottom());
        int r2 = r16 + r13;
        int r4 = getPaddingWidth();
        this.mMeasurer.a(r20, r21, r16, r13, r4, r2);
        int r5 = Math.max(0, getPaddingStart());
        int r9 = Math.max(0, getPaddingEnd());
        if (r5 > 0) goto L8;
        if (r9 > 0) goto L8;
        r9 = Math.max(0, getPaddingLeft());
    L11:
        int r10 = r0 - r4;
        int r11 = r1 - r2;
        setSelfDimensionBehaviour(r18, r7, r10, r8, r11);
        r18.a(r19, r7, r10, r8, r11, this.mLastMeasureWidth, this.mLastMeasureHeight, r9, r16);
        return;
    L8:
        if (isRtl() == true) goto L11;
        r9 = r5;
        goto L11
    }

    public void setConstraintSet(com.obric.oui.constraintlayout.widget.b r1) {
        this.mConstraintSet = r1;
    }

    public void setDesignInformation(int r3, Object r4, Object r5) {
        if (r3 == 0) goto L4;
        return;
    L4:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == true) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Integer.class) == true) goto L8;
        return;
    L8:
        if (this.mDesignIds != null) goto L10;
        this.mDesignIds = new HashMap();
    L10:
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
        int r7 = r6.indexOf("/");
        if (r7 == (-1)) goto L13;
        r6 = r6.substring(r7 + 1);
    L13:
        int r8 = ((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.memorydata.plugin")).intValue();
        this.mDesignIds.put(r6, Integer.valueOf(r8));
    }

    @Override // android.view.View
    public void setId(int r3) {
        this.mChildrenByIds.remove(getId());
        super.setId(r3);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int r2) {
        if (r2 != this.mMaxHeight) goto L5;
        return;
    L5:
        this.mMaxHeight = r2;
        requestLayout();
    }

    public void setMaxWidth(int r2) {
        if (r2 != this.mMaxWidth) goto L5;
        return;
    L5:
        this.mMaxWidth = r2;
        requestLayout();
    }

    public void setMinHeight(int r2) {
        if (r2 != this.mMinHeight) goto L5;
        return;
    L5:
        this.mMinHeight = r2;
        requestLayout();
    }

    public void setMinWidth(int r2) {
        if (r2 != this.mMinWidth) goto L5;
        return;
    L5:
        this.mMinWidth = r2;
        requestLayout();
    }

    public void setOnConstraintsChanged(c r1) {
        com.obric.oui.constraintlayout.widget.a r0 = this.mConstraintLayoutSpec;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    public void setOptimizationLevel(int r1) {
        this.mOptimizationLevel = r1;
        this.mLayoutWidget.a(r1);
    }

    public void setSelfDimensionBehaviour(com.obric.oui.constraintlayout.core.widgets.d r9, int r10, int r11, int r12, int r13) {
        int r0 = this.mMeasurer.e;
        int r1 = this.mMeasurer.d;
        ConstraintWidget.DimensionBehaviour r2 = ConstraintWidget.DimensionBehaviour.FIXED;
        ConstraintWidget.DimensionBehaviour r3 = ConstraintWidget.DimensionBehaviour.FIXED;
        int r4 = getChildCount();
        if (r10 == Integer.MIN_VALUE) goto L11;
        if (r10 == 0) goto L8;
        if (r10 == 1073741824) goto L7;
    L6:
        r11 = 0;
    L14:
        if (r12 == Integer.MIN_VALUE) goto L22;
        if (r12 == 0) goto L19;
        if (r12 == 1073741824) goto L18;
    L17:
        r13 = 0;
    L26:
        if (r11 == r9.F()) goto L28;
    L29:
        r9.c();
    L30:
        r9.o(0);
        r9.p(0);
        r9.h(this.mMaxWidth - r1);
        r9.i(this.mMaxHeight - r0);
        r9.s(0);
        r9.t(0);
        r9.a(r2);
        r9.q(r11);
        r9.b(r3);
        r9.r(r13);
        r9.s(this.mMinWidth - r1);
        r9.t(this.mMinHeight - r0);
        return;
    L28:
        if (r13 == r9.G()) goto L30;
    L18:
        r13 = Math.min(this.mMaxHeight - r0, r13);
        goto L26
    L19:
        r3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r4 != 0) goto L17;
    L24:
        r13 = Math.max(0, this.mMinHeight);
        goto L26
    L22:
        r3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r4 != 0) goto L26;
    L7:
        r11 = Math.min(this.mMaxWidth - r1, r11);
        goto L14
    L8:
        r2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r4 != 0) goto L6;
    L13:
        r11 = Math.max(0, this.mMinWidth);
        goto L14
    L11:
        r2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r4 != 0) goto L14;
        goto L13
    }

    public void setState(int r1, int r2, int r3) {
        com.obric.oui.constraintlayout.widget.a r0 = this.mConstraintLayoutSpec;
        if (r0 == null) goto L6;
        r0.a(r1, r2, r3);
        return;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
