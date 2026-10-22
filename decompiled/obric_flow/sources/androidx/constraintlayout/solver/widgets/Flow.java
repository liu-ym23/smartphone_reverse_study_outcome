package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class Flow extends VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE = 0;
    private ConstraintWidget[] mAlignedBiggestElementsInCols;
    private ConstraintWidget[] mAlignedBiggestElementsInRows;
    private int[] mAlignedDimensions;
    private ArrayList<WidgetsList> mChainList;
    private ConstraintWidget[] mDisplayedWidgets;
    private int mDisplayedWidgetsCount;
    private float mFirstHorizontalBias;
    private int mFirstHorizontalStyle;
    private float mFirstVerticalBias;
    private int mFirstVerticalStyle;
    private int mHorizontalAlign;
    private float mHorizontalBias;
    private int mHorizontalGap;
    private int mHorizontalStyle;
    private float mLastHorizontalBias;
    private int mLastHorizontalStyle;
    private float mLastVerticalBias;
    private int mLastVerticalStyle;
    private int mMaxElementsWrap;
    private int mOrientation;
    private int mVerticalAlign;
    private float mVerticalBias;
    private int mVerticalGap;
    private int mVerticalStyle;
    private int mWrapMode;

    public class WidgetsList {
        private ConstraintWidget biggest;
        int biggestDimension;
        private ConstraintAnchor mBottom;
        private int mCount;
        private int mHeight;
        private ConstraintAnchor mLeft;
        private int mMax;
        private int mNbMatchConstraintsWidgets;
        private int mOrientation;
        private int mPaddingBottom;
        private int mPaddingLeft;
        private int mPaddingRight;
        private int mPaddingTop;
        private ConstraintAnchor mRight;
        private int mStartIndex;
        private ConstraintAnchor mTop;
        private int mWidth;
        final /* synthetic */ Flow this$0;

        public WidgetsList(Flow r5, int r10, ConstraintAnchor r11, ConstraintAnchor r12, ConstraintAnchor r13, ConstraintAnchor r14, int r15) {
            this.this$0 = r5;
            this.biggest = null;
            this.biggestDimension = 0;
            this.mPaddingLeft = 0;
            this.mPaddingTop = 0;
            this.mPaddingRight = 0;
            this.mPaddingBottom = 0;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
            this.mMax = 0;
            this.mOrientation = r10;
            this.mLeft = r11;
            this.mTop = r12;
            this.mRight = r13;
            this.mBottom = r14;
            this.mPaddingLeft = r5.getPaddingLeft();
            this.mPaddingTop = r5.getPaddingTop();
            this.mPaddingRight = r5.getPaddingRight();
            this.mPaddingBottom = r5.getPaddingBottom();
            this.mMax = r15;
        }

        public static /* synthetic */ ConstraintWidget access$2000(WidgetsList r5) {
            return r5.biggest;
        }

        private void recomputeDimensions() {
            this.mWidth = 0;
            this.mHeight = 0;
            this.biggest = null;
            this.biggestDimension = 0;
            int r5 = this.mCount;
            int r10 = 0;
        L3:
            if (r10 >= r5) goto L26;
            if ((this.mStartIndex + r10) >= Flow.access$400(this.this$0)) goto L33;
            ConstraintWidget r11 = Flow.access$500(this.this$0)[this.mStartIndex + r10];
            if (this.mOrientation != 0) goto L17;
            int r12 = r11.getWidth();
            int r13 = Flow.access$000(this.this$0);
            if (r11.getVisibility() != 8) goto L12;
            r13 = 0;
        L12:
            this.mWidth = (r12 + r13) + this.mWidth;
            int r14 = Flow.access$300(this.this$0, r11, this.mMax);
            if (this.biggest != null) goto L15;
        L16:
            this.biggest = r11;
            this.biggestDimension = r14;
            this.mHeight = r14;
        L25:
            r10 = r10 + 1;
            goto L3
        L15:
            if (this.biggestDimension >= r14) goto L25;
        L17:
            int r15 = Flow.access$200(this.this$0, r11, this.mMax);
            int r16 = Flow.access$300(this.this$0, r11, this.mMax);
            int r17 = Flow.access$100(this.this$0);
            if (r11.getVisibility() != 8) goto L20;
            r17 = 0;
        L20:
            this.mHeight = (r16 + r17) + this.mHeight;
            if (this.biggest != null) goto L23;
        L24:
            this.biggest = r11;
            this.biggestDimension = r15;
            this.mWidth = r15;
            goto L25
        L23:
            if (this.biggestDimension >= r15) goto L25;
        L33:
            return;
        }

        public void add(ConstraintWidget r10) {
            int r5 = 0;
            if (this.mOrientation != 0) goto L16;
            int r11 = Flow.access$200(this.this$0, r10, this.mMax);
            if (r10.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L7;
            this.mNbMatchConstraintsWidgets++;
            r11 = 0;
        L7:
            int r12 = Flow.access$000(this.this$0);
            if (r10.getVisibility() == 8) goto L11;
            r5 = r12;
        L11:
            this.mWidth = (r11 + r5) + this.mWidth;
            int r13 = Flow.access$300(this.this$0, r10, this.mMax);
            if (this.biggest != null) goto L14;
        L15:
            this.biggest = r10;
            this.biggestDimension = r13;
            this.mHeight = r13;
        L28:
            this.mCount++;
            return;
        L14:
            if (this.biggestDimension >= r13) goto L28;
        L16:
            int r14 = Flow.access$200(this.this$0, r10, this.mMax);
            int r15 = Flow.access$300(this.this$0, r10, this.mMax);
            if (r10.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L19;
            this.mNbMatchConstraintsWidgets++;
            r15 = 0;
        L19:
            int r16 = Flow.access$100(this.this$0);
            if (r10.getVisibility() == 8) goto L23;
            r5 = r16;
        L23:
            this.mHeight = (r15 + r5) + this.mHeight;
            if (this.biggest != null) goto L26;
        L27:
            this.biggest = r10;
            this.biggestDimension = r14;
            this.mWidth = r14;
            goto L28
        L26:
            if (this.biggestDimension >= r14) goto L28;
            goto L27
        }

        public void clear() {
            this.biggestDimension = 0;
            this.biggest = null;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
        }

        public void createConstraints(boolean r17, int r18, boolean r19) {
            int r5 = this.mCount;
            int r10 = 0;
        L3:
            if (r10 >= r5) goto L11;
            if ((this.mStartIndex + r10) >= Flow.access$400(this.this$0)) goto L11;
            ConstraintWidget r11 = Flow.access$500(this.this$0)[this.mStartIndex + r10];
            if (r11 == null) goto L10;
            r11.resetAnchors();
        L10:
            r10 = r10 + 1;
        L11:
            if (r5 != 0) goto L13;
            return;
        L13:
            if (this.biggest == null) goto L206;
            if (r19 == false) goto L18;
            if (r18 != 0) goto L18;
            boolean r12 = true;
        L19:
            int r13 = 0;
            int r14 = -1;
            int r15 = -1;
        L20:
            if (r13 >= r5) goto L33;
            if (r17 == false) goto L23;
            int r16 = (r5 - 1) - r13;
        L25:
            if ((this.mStartIndex + r16) >= Flow.access$400(this.this$0)) goto L33;
            if (Flow.access$500(this.this$0)[this.mStartIndex + r16].getVisibility() != 0) goto L32;
            if (r14 != (-1)) goto L31;
            r14 = r13;
        L31:
            r15 = r13;
        L32:
            r13 = r13 + 1;
            goto L20
        L23:
            r16 = r13;
        L33:
            ConstraintWidget r20 = null;
            if (this.mOrientation != 0) goto L112;
            ConstraintWidget r21 = this.biggest;
            r21.setVerticalChainStyle(Flow.access$600(this.this$0));
            int r110 = this.mPaddingTop;
            if (r18 <= 0) goto L38;
            r110 = r110 + Flow.access$100(this.this$0);
        L38:
            r21.mTop.connect(this.mTop, r110);
            if (r19 == false) goto L41;
            r21.mBottom.connect(this.mBottom, this.mPaddingBottom);
        L41:
            if (r18 <= 0) goto L44;
            this.mTop.mOwner.mBottom.connect(r21.mTop, 0);
        L44:
            if (Flow.access$700(this.this$0) == 3) goto L46;
        L59:
            ConstraintWidget r111 = r21;
        L60:
            int r112 = 0;
        L61:
            if (r112 >= r5) goto L207;
            if (r17 == false) goto L64;
            int r113 = (r5 - 1) - r112;
        L66:
            if ((this.mStartIndex + r113) >= Flow.access$400(this.this$0)) goto L208;
            ConstraintWidget r114 = Flow.access$500(this.this$0)[this.mStartIndex + r113];
            if (r112 != 0) goto L71;
            r114.connect(r114.mLeft, this.mLeft, this.mPaddingLeft);
        L71:
            if (r113 != 0) goto L83;
            int r22 = Flow.access$800(this.this$0);
            float r115 = Flow.access$900(this.this$0);
            if (this.mStartIndex == 0) goto L75;
        L77:
            if (r19 == true) goto L79;
        L81:
            r114.setHorizontalChainStyle(r22);
            r114.setHorizontalBiasPercent(r115);
            goto L83
        L79:
            if (Flow.access$1200(this.this$0) == (-1)) goto L81;
            r22 = Flow.access$1200(this.this$0);
            r115 = Flow.access$1300(this.this$0);
            goto L81
        L75:
            if (Flow.access$1000(this.this$0) == (-1)) goto L77;
            r22 = Flow.access$1000(this.this$0);
            r115 = Flow.access$1100(this.this$0);
        L83:
            if (r112 != (r5 - 1)) goto L85;
            r114.connect(r114.mRight, this.mRight, this.mPaddingRight);
        L85:
            if (r20 == null) goto L92;
            r114.mLeft.connect(r20.mRight, Flow.access$000(this.this$0));
            if (r112 != r14) goto L89;
            r114.mLeft.setGoneMargin(this.mPaddingLeft);
        L89:
            r20.mRight.connect(r114.mLeft, 0);
            if (r112 != (r15 + 1)) goto L92;
            r20.mRight.setGoneMargin(this.mPaddingRight);
        L92:
            if (r114 == r21) goto L110;
            char r23 = 3;
            if (Flow.access$700(this.this$0) == 3) goto L96;
        L101:
            int r24 = Flow.access$700(this.this$0);
            if (r24 != 0) goto L104;
            r114.mTop.connect(r21.mTop, 0);
        L111:
            r112 = r112 + 1;
            r20 = r114;
            goto L61
        L104:
            if (r24 == 1) goto L108;
            if (r12 == false) goto L107;
            r114.mTop.connect(this.mTop, this.mPaddingTop);
            r114.mBottom.connect(this.mBottom, this.mPaddingBottom);
            goto L111
        L107:
            r114.mTop.connect(r21.mTop, 0);
            r114.mBottom.connect(r21.mBottom, 0);
            goto L111
        L108:
            r114.mBottom.connect(r21.mBottom, 0);
            goto L111
        L96:
            if (r111.hasBaseline() == false) goto L101;
            if (r114 == r111) goto L101;
            if (r114.hasBaseline() == false) goto L101;
            r114.mBaseline.connect(r111.mBaseline, 0);
            goto L111
        L110:
            r23 = 3;
            goto L111
        L208:
            return;
        L64:
            r113 = r112;
            goto L66
        L207:
            return;
        L46:
            if (r21.hasBaseline() == true) goto L59;
            int r116 = 0;
        L48:
            if (r116 >= r5) goto L59;
            if (r17 == false) goto L51;
            int r117 = (r5 - 1) - r116;
        L53:
            if ((this.mStartIndex + r117) >= Flow.access$400(this.this$0)) goto L59;
            r111 = Flow.access$500(this.this$0)[this.mStartIndex + r117];
            if (r111.hasBaseline() == true) goto L60;
            r116 = r116 + 1;
            goto L48
        L51:
            r117 = r116;
            goto L53
        L112:
            ConstraintWidget r25 = this.biggest;
            r25.setHorizontalChainStyle(Flow.access$800(this.this$0));
            int r26 = this.mPaddingLeft;
            if (r18 <= 0) goto L115;
            r26 = r26 + Flow.access$000(this.this$0);
        L115:
            if (r17 == false) goto L121;
            r25.mRight.connect(this.mRight, r26);
            if (r19 == false) goto L119;
            r25.mLeft.connect(this.mLeft, this.mPaddingRight);
        L119:
            if (r18 <= 0) goto L126;
            this.mRight.mOwner.mLeft.connect(r25.mRight, 0);
        L126:
            int r27 = 0;
        L127:
            if (r27 >= r5) goto L210;
            if ((this.mStartIndex + r27) >= Flow.access$400(this.this$0)) goto L209;
            ConstraintWidget r118 = Flow.access$500(this.this$0)[this.mStartIndex + r27];
            if (r27 != 0) goto L144;
            r118.connect(r118.mTop, this.mTop, this.mPaddingTop);
            int r119 = Flow.access$600(this.this$0);
            float r120 = Flow.access$1400(this.this$0);
            if (this.mStartIndex == 0) goto L136;
        L138:
            if (r19 == true) goto L140;
        L142:
            r118.setVerticalChainStyle(r119);
            r118.setVerticalBiasPercent(r120);
            goto L144
        L140:
            if (Flow.access$1700(this.this$0) == (-1)) goto L142;
            r119 = Flow.access$1700(this.this$0);
            r120 = Flow.access$1800(this.this$0);
            goto L142
        L136:
            if (Flow.access$1500(this.this$0) == (-1)) goto L138;
            r119 = Flow.access$1500(this.this$0);
            r120 = Flow.access$1600(this.this$0);
        L144:
            if (r27 != (r5 - 1)) goto L146;
            r118.connect(r118.mBottom, this.mBottom, this.mPaddingBottom);
        L146:
            if (r20 == null) goto L153;
            r118.mTop.connect(r20.mBottom, Flow.access$100(this.this$0));
            if (r27 != r14) goto L150;
            r118.mTop.setGoneMargin(this.mPaddingTop);
        L150:
            r20.mBottom.connect(r118.mTop, 0);
            if (r27 != (r15 + 1)) goto L153;
            r20.mBottom.setGoneMargin(this.mPaddingBottom);
        L153:
            if (r118 == r25) goto L177;
            if (r17 == false) goto L166;
            int r121 = Flow.access$1900(this.this$0);
            if (r121 != 0) goto L159;
            r118.mRight.connect(r25.mRight, 0);
            goto L177
        L159:
            if (r121 == 1) goto L163;
            if (r121 != 2) goto L177;
            r118.mLeft.connect(r25.mLeft, 0);
            r118.mRight.connect(r25.mRight, 0);
            goto L177
        L163:
            r118.mLeft.connect(r25.mLeft, 0);
            goto L177
        L166:
            int r122 = Flow.access$1900(this.this$0);
            if (r122 != 0) goto L169;
            r118.mLeft.connect(r25.mLeft, 0);
            goto L177
        L169:
            if (r122 == 1) goto L175;
            if (r122 != 2) goto L177;
            if (r12 == false) goto L174;
            r118.mLeft.connect(this.mLeft, this.mPaddingLeft);
            r118.mRight.connect(this.mRight, this.mPaddingRight);
            goto L177
        L174:
            r118.mLeft.connect(r25.mLeft, 0);
            r118.mRight.connect(r25.mRight, 0);
            goto L177
        L175:
            r118.mRight.connect(r25.mRight, 0);
        L177:
            r27 = r27 + 1;
            r20 = r118;
            goto L127
        L209:
            return;
        L210:
            return;
        L121:
            r25.mLeft.connect(this.mLeft, r26);
            if (r19 == false) goto L124;
            r25.mRight.connect(this.mRight, this.mPaddingRight);
        L124:
            if (r18 <= 0) goto L126;
            this.mLeft.mOwner.mRight.connect(r25.mLeft, 0);
        L18:
            r12 = false;
            goto L19
        }

        public int getHeight() {
            if (this.mOrientation != 1) goto L7;
            return this.mHeight - Flow.access$100(this.this$0);
        L7:
            return this.mHeight;
        }

        public int getWidth() {
            if (this.mOrientation != 0) goto L7;
            return this.mWidth - Flow.access$000(this.this$0);
        L7:
            return this.mWidth;
        }

        public void measureMatchConstraints(int r10) {
            int r5 = this.mNbMatchConstraintsWidgets;
            if (r5 != 0) goto L5;
            return;
        L5:
            int r11 = this.mCount;
            int r12 = r10 / r5;
            int r13 = 0;
        L6:
            if (r13 >= r11) goto L25;
            if ((this.mStartIndex + r13) >= Flow.access$400(this.this$0)) goto L25;
            ConstraintWidget r14 = Flow.access$500(this.this$0)[this.mStartIndex + r13];
            if (this.mOrientation != 0) goto L18;
            if (r14 == null) goto L24;
            if (r14.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
            if (r14.mMatchConstraintDefaultWidth != 0) goto L24;
            this.this$0.measure(r14, ConstraintWidget.DimensionBehaviour.FIXED, r12, r14.getVerticalDimensionBehaviour(), r14.getHeight());
        L24:
            r13 = r13 + 1;
            goto L6
        L18:
            if (r14 == null) goto L24;
            if (r14.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
            if (r14.mMatchConstraintDefaultHeight != 0) goto L24;
            this.this$0.measure(r14, r14.getHorizontalDimensionBehaviour(), r14.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, r12);
        L25:
            recomputeDimensions();
        }

        public void setStartIndex(int r5) {
            this.mStartIndex = r5;
        }

        public void setup(int r5, ConstraintAnchor r10, ConstraintAnchor r11, ConstraintAnchor r12, ConstraintAnchor r13, int r14, int r15, int r16, int r17, int r18) {
            this.mOrientation = r5;
            this.mLeft = r10;
            this.mTop = r11;
            this.mRight = r12;
            this.mBottom = r13;
            this.mPaddingLeft = r14;
            this.mPaddingTop = r15;
            this.mPaddingRight = r16;
            this.mPaddingBottom = r17;
            this.mMax = r18;
        }
    }

    public Flow() {
        this.mHorizontalStyle = -1;
        this.mVerticalStyle = -1;
        this.mFirstHorizontalStyle = -1;
        this.mFirstVerticalStyle = -1;
        this.mLastHorizontalStyle = -1;
        this.mLastVerticalStyle = -1;
        this.mHorizontalBias = 0.5f;
        this.mVerticalBias = 0.5f;
        this.mFirstHorizontalBias = 0.5f;
        this.mFirstVerticalBias = 0.5f;
        this.mLastHorizontalBias = 0.5f;
        this.mLastVerticalBias = 0.5f;
        this.mHorizontalGap = 0;
        this.mVerticalGap = 0;
        this.mHorizontalAlign = 2;
        this.mVerticalAlign = 2;
        this.mWrapMode = 0;
        this.mMaxElementsWrap = -1;
        this.mOrientation = 0;
        this.mChainList = new ArrayList();
        this.mAlignedBiggestElementsInRows = null;
        this.mAlignedBiggestElementsInCols = null;
        this.mAlignedDimensions = null;
        this.mDisplayedWidgetsCount = 0;
    }

    public static /* synthetic */ int access$000(Flow r5) {
        return r5.mHorizontalGap;
    }

    public static /* synthetic */ int access$100(Flow r5) {
        return r5.mVerticalGap;
    }

    public static /* synthetic */ int access$1000(Flow r5) {
        return r5.mFirstHorizontalStyle;
    }

    public static /* synthetic */ float access$1100(Flow r5) {
        return r5.mFirstHorizontalBias;
    }

    public static /* synthetic */ int access$1200(Flow r5) {
        return r5.mLastHorizontalStyle;
    }

    public static /* synthetic */ float access$1300(Flow r5) {
        return r5.mLastHorizontalBias;
    }

    public static /* synthetic */ float access$1400(Flow r5) {
        return r5.mVerticalBias;
    }

    public static /* synthetic */ int access$1500(Flow r5) {
        return r5.mFirstVerticalStyle;
    }

    public static /* synthetic */ float access$1600(Flow r5) {
        return r5.mFirstVerticalBias;
    }

    public static /* synthetic */ int access$1700(Flow r5) {
        return r5.mLastVerticalStyle;
    }

    public static /* synthetic */ float access$1800(Flow r5) {
        return r5.mLastVerticalBias;
    }

    public static /* synthetic */ int access$1900(Flow r5) {
        return r5.mHorizontalAlign;
    }

    public static /* synthetic */ int access$200(Flow r5, ConstraintWidget r10, int r11) {
        return r5.getWidgetWidth(r10, r11);
    }

    public static /* synthetic */ int access$300(Flow r5, ConstraintWidget r10, int r11) {
        return r5.getWidgetHeight(r10, r11);
    }

    public static /* synthetic */ int access$400(Flow r5) {
        return r5.mDisplayedWidgetsCount;
    }

    public static /* synthetic */ ConstraintWidget[] access$500(Flow r5) {
        return r5.mDisplayedWidgets;
    }

    public static /* synthetic */ int access$600(Flow r5) {
        return r5.mVerticalStyle;
    }

    public static /* synthetic */ int access$700(Flow r5) {
        return r5.mVerticalAlign;
    }

    public static /* synthetic */ int access$800(Flow r5) {
        return r5.mHorizontalStyle;
    }

    public static /* synthetic */ float access$900(Flow r5) {
        return r5.mHorizontalBias;
    }

    private void createAlignedConstraints(boolean r12) {
        if (this.mAlignedDimensions != null) goto L5;
        return;
    L5:
        if (this.mAlignedBiggestElementsInCols != null) goto L7;
        return;
    L7:
        if (this.mAlignedBiggestElementsInRows == null) goto L89;
        int r5 = 0;
    L11:
        if (r5 >= this.mDisplayedWidgetsCount) goto L13;
        this.mDisplayedWidgets[r5].resetAnchors();
        r5 = r5 + 1;
        goto L11
    L13:
        int[] r10 = this.mAlignedDimensions;
        int r11 = r10[0];
        int r13 = r10[1];
        ConstraintWidget r14 = null;
        int r15 = 0;
    L15:
        if (r15 >= r11) goto L33;
        if (r12 == false) goto L18;
        int r16 = (r11 - r15) - 1;
    L19:
        ConstraintWidget r17 = this.mAlignedBiggestElementsInCols[r16];
        if (r17 == null) goto L32;
        if (r17.getVisibility() == 8) goto L32;
        if (r15 != 0) goto L27;
        r17.connect(r17.mLeft, this.mLeft, getPaddingLeft());
        r17.setHorizontalChainStyle(this.mHorizontalStyle);
        r17.setHorizontalBiasPercent(this.mHorizontalBias);
    L27:
        if (r15 != (r11 - 1)) goto L29;
        r17.connect(r17.mRight, this.mRight, getPaddingRight());
    L29:
        if (r15 <= 0) goto L31;
        r17.connect(r17.mLeft, r14.mRight, this.mHorizontalGap);
        r14.connect(r14.mRight, r17.mLeft, 0);
    L31:
        r14 = r17;
    L32:
        r15 = r15 + 1;
        goto L15
    L18:
        r16 = r15;
        goto L19
    L33:
        int r18 = 0;
    L34:
        if (r18 >= r13) goto L49;
        ConstraintWidget r19 = this.mAlignedBiggestElementsInRows[r18];
        if (r19 == null) goto L48;
        if (r19.getVisibility() == 8) goto L48;
        if (r18 != 0) goto L43;
        r19.connect(r19.mTop, this.mTop, getPaddingTop());
        r19.setVerticalChainStyle(this.mVerticalStyle);
        r19.setVerticalBiasPercent(this.mVerticalBias);
    L43:
        if (r18 != (r13 - 1)) goto L45;
        r19.connect(r19.mBottom, this.mBottom, getPaddingBottom());
    L45:
        if (r18 <= 0) goto L47;
        r19.connect(r19.mTop, r14.mBottom, this.mVerticalGap);
        r14.connect(r14.mBottom, r19.mTop, 0);
    L47:
        r14 = r19;
    L48:
        r18 = r18 + 1;
        goto L34
    L49:
        int r110 = 0;
    L50:
        if (r110 >= r11) goto L90;
        int r20 = 0;
    L52:
        if (r20 >= r13) goto L70;
        int r21 = (r20 * r11) + r110;
        if (this.mOrientation != 1) goto L56;
        r21 = (r110 * r13) + r20;
    L56:
        ConstraintWidget[] r22 = this.mDisplayedWidgets;
        if (r21 >= r22.length) goto L69;
        ConstraintWidget r23 = r22[r21];
        if (r23 == null) goto L69;
        if (r23.getVisibility() == 8) goto L69;
        ConstraintWidget r24 = this.mAlignedBiggestElementsInCols[r110];
        ConstraintWidget r25 = this.mAlignedBiggestElementsInRows[r20];
        if (r23 == r24) goto L67;
        r23.connect(r23.mLeft, r24.mLeft, 0);
        r23.connect(r23.mRight, r24.mRight, 0);
    L67:
        if (r23 == r25) goto L69;
        r23.connect(r23.mTop, r25.mTop, 0);
        r23.connect(r23.mBottom, r25.mBottom, 0);
    L69:
        r20 = r20 + 1;
        goto L52
    L70:
        r110 = r110 + 1;
        goto L50
    L90:
        return;
    }

    private final int getWidgetHeight(ConstraintWidget r10, int r11) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
        int r5 = r10.mMatchConstraintDefaultHeight;
        if (r5 != 0) goto L11;
        return 0;
    L11:
        if (r5 != 2) goto L16;
        int r12 = (int) (r10.mMatchConstraintPercentHeight * r11);
        if (r12 == r10.getHeight()) goto L15;
        r10.setMeasureRequested(true);
        measure(r10, r10.getHorizontalDimensionBehaviour(), r10.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, r12);
    L15:
        return r12;
    L16:
        if (r5 != 1) goto L20;
        return r10.getHeight();
    L20:
        if (r5 != 3) goto L24;
        return (int) ((r10.getWidth() * r10.mDimensionRatio) + 0.5f);
    L24:
        return r10.getHeight();
    }

    private final int getWidgetWidth(ConstraintWidget r10, int r11) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
        int r5 = r10.mMatchConstraintDefaultWidth;
        if (r5 != 0) goto L11;
        return 0;
    L11:
        if (r5 != 2) goto L16;
        int r12 = (int) (r10.mMatchConstraintPercentWidth * r11);
        if (r12 == r10.getWidth()) goto L15;
        r10.setMeasureRequested(true);
        measure(r10, ConstraintWidget.DimensionBehaviour.FIXED, r12, r10.getVerticalDimensionBehaviour(), r10.getHeight());
    L15:
        return r12;
    L16:
        if (r5 != 1) goto L20;
        return r10.getWidth();
    L20:
        if (r5 != 3) goto L24;
        return (int) ((r10.getHeight() * r10.mDimensionRatio) + 0.5f);
    L24:
        return r10.getWidth();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x010d -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x010f -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0115 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0117 -> B:42:0x0059). Please report as a decompilation issue!!! */
    private void measureAligned(ConstraintWidget[] r11, int r12, int r13, int r14, int[] r15) {
        if (r13 != 0) goto L19;
        int r5 = this.mMaxElementsWrap;
        if (r5 > 0) goto L18;
        r5 = 0;
        int r10 = 0;
        int r16 = 0;
    L7:
        if (r10 >= r12) goto L18;
        if (r10 <= 0) goto L10;
        r16 = r16 + this.mHorizontalGap;
    L10:
        ConstraintWidget r17 = r11[r10];
        if (r17 == null) goto L17;
        r16 = r16 + getWidgetWidth(r17, r14);
        if (r16 > r14) goto L18;
        r5 = r5 + 1;
    L17:
        r10 = r10 + 1;
    L18:
        int r18 = r5;
        int r19 = 0;
    L35:
        if (this.mAlignedDimensions != null) goto L38;
        this.mAlignedDimensions = new int[2];
    L38:
        if (r19 != 0) goto L40;
        if (r13 != 1) goto L40;
    L42:
        boolean r20 = true;
    L44:
        if (r20 == true) goto L111;
        if (r13 != 0) goto L47;
        r19 = (int) Math.ceil(r12 / r18);
    L48:
        ConstraintWidget[] r21 = this.mAlignedBiggestElementsInCols;
        if (r21 != null) goto L51;
    L54:
        this.mAlignedBiggestElementsInCols = new ConstraintWidget[r18];
    L55:
        ConstraintWidget[] r22 = this.mAlignedBiggestElementsInRows;
        if (r22 != null) goto L58;
    L61:
        this.mAlignedBiggestElementsInRows = new ConstraintWidget[r19];
    L62:
        int r23 = 0;
    L63:
        if (r23 >= r18) goto L87;
        int r24 = 0;
    L65:
        if (r24 >= r19) goto L86;
        int r25 = (r24 * r18) + r23;
        if (r13 != 1) goto L70;
        r25 = (r23 * r19) + r24;
    L70:
        if (r25 >= r11.length) goto L85;
        ConstraintWidget r26 = r11[r25];
        if (r26 == null) goto L85;
        int r27 = getWidgetWidth(r26, r14);
        ConstraintWidget r28 = this.mAlignedBiggestElementsInCols[r23];
        if (r28 != null) goto L78;
    L79:
        this.mAlignedBiggestElementsInCols[r23] = r26;
    L80:
        int r29 = getWidgetHeight(r26, r14);
        ConstraintWidget r30 = this.mAlignedBiggestElementsInRows[r24];
        if (r30 != null) goto L83;
    L84:
        this.mAlignedBiggestElementsInRows[r24] = r26;
        goto L85
    L83:
        if (r30.getHeight() >= r29) goto L85;
    L78:
        if (r28.getWidth() >= r27) goto L80;
    L85:
        r24 = r24 + 1;
        goto L65
    L86:
        r23 = r23 + 1;
        goto L63
    L87:
        int r31 = 0;
        int r32 = 0;
    L88:
        if (r31 >= r18) goto L95;
        ConstraintWidget r33 = this.mAlignedBiggestElementsInCols[r31];
        if (r33 == null) goto L94;
        if (r31 <= 0) goto L93;
        r32 = r32 + this.mHorizontalGap;
    L93:
        r32 = r32 + getWidgetWidth(r33, r14);
    L94:
        r31 = r31 + 1;
        goto L88
    L95:
        int r34 = 0;
        int r35 = 0;
    L96:
        if (r34 >= r19) goto L103;
        ConstraintWidget r36 = this.mAlignedBiggestElementsInRows[r34];
        if (r36 == null) goto L102;
        if (r34 <= 0) goto L101;
        r35 = r35 + this.mVerticalGap;
    L101:
        r35 = r35 + getWidgetHeight(r36, r14);
    L102:
        r34 = r34 + 1;
        goto L96
    L103:
        r15[0] = r32;
        r15[1] = r35;
        if (r13 == 0) goto L105;
        if (r35 <= r14) goto L42;
        if (r19 <= 1) goto L42;
        r19 = r19 - 1;
        goto L44
    L105:
        if (r32 <= r14) goto L42;
        if (r18 <= 1) goto L42;
        r18 = r18 - 1;
        goto L44
    L58:
        if (r22.length < r19) goto L61;
        Arrays.fill(r22, null);
        goto L62
    L51:
        if (r21.length < r18) goto L54;
        Arrays.fill(r21, null);
        goto L55
    L47:
        r18 = (int) Math.ceil(r12 / r19);
        goto L48
    L111:
        int[] r110 = this.mAlignedDimensions;
        r110[0] = r18;
        r110[1] = r19;
        return;
    L40:
        if (r18 != 0) goto L43;
        if (r13 == 0) goto L42;
    L43:
        r20 = false;
        goto L44
    L19:
        r19 = this.mMaxElementsWrap;
        if (r19 > 0) goto L33;
        r19 = 0;
        int r37 = 0;
        int r38 = 0;
    L22:
        if (r37 >= r12) goto L33;
        if (r37 <= 0) goto L25;
        r38 = r38 + this.mVerticalGap;
    L25:
        ConstraintWidget r39 = r11[r37];
        if (r39 == null) goto L32;
        r38 = r38 + getWidgetHeight(r39, r14);
        if (r38 > r14) goto L33;
        r19 = r19 + 1;
    L32:
        r37 = r37 + 1;
    L33:
        r18 = 0;
        goto L35
    }

    private void measureChainWrap(ConstraintWidget[] r29, int r30, int r31, int r32, int[] r33) {
        if (r30 != 0) goto L5;
        return;
    L5:
        this.mChainList.clear();
        WidgetsList r10 = new WidgetsList(this, r31, this.mLeft, this.mTop, this.mRight, this.mBottom, r32);
        this.mChainList.add(r10);
        if (r31 != 0) goto L33;
        int r5 = 0;
        int r11 = 0;
        int r12 = 0;
    L8:
        if (r12 >= r30) goto L59;
        ConstraintWidget r13 = r29[r12];
        int r14 = getWidgetWidth(r13, r32);
        if (r13.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L12;
        r5 = r5 + 1;
    L12:
        int r15 = r5;
        if (r11 == r32) goto L17;
        if (((this.mHorizontalGap + r11) + r14) > r32) goto L17;
    L19:
        boolean r16 = false;
    L20:
        if (r16 == true) goto L27;
        if (r12 <= 0) goto L27;
        int r17 = this.mMaxElementsWrap;
        if (r17 <= 0) goto L27;
        if ((r12 % r17) != 0) goto L27;
        r16 = true;
    L27:
        if (r16 == false) goto L30;
        r10 = new WidgetsList(this, r31, this.mLeft, this.mTop, this.mRight, this.mBottom, r32);
        r10.setStartIndex(r12);
        this.mChainList.add(r10);
    L29:
        r11 = r14;
    L32:
        r10.add(r13);
        r12 = r12 + 1;
        r5 = r15;
        goto L8
    L30:
        if (r12 <= 0) goto L29;
        r11 = (this.mHorizontalGap + r14) + r11;
    L17:
        if (WidgetsList.access$2000(r10) == null) goto L19;
        r16 = true;
    L59:
        int r18 = this.mChainList.size();
        ConstraintAnchor r19 = this.mLeft;
        ConstraintAnchor r20 = this.mTop;
        ConstraintAnchor r21 = this.mRight;
        ConstraintAnchor r22 = this.mBottom;
        int r23 = getPaddingLeft();
        int r24 = getPaddingTop();
        int r25 = getPaddingRight();
        int r110 = getPaddingBottom();
        ConstraintWidget.DimensionBehaviour r111 = getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r112 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r111 != r112) goto L62;
    L65:
        boolean r113 = true;
    L66:
        if (r5 <= 0) goto L75;
        if (r113 == false) goto L75;
        int r26 = 0;
    L69:
        if (r26 >= r18) goto L75;
        WidgetsList r114 = this.mChainList.get(r26);
        if (r31 != 0) goto L73;
        r114.measureMatchConstraints(r32 - r114.getWidth());
    L74:
        r26 = r26 + 1;
        goto L69
    L73:
        r114.measureMatchConstraints(r32 - r114.getHeight());
    L75:
        int r27 = r24;
        int r28 = r25;
        int r115 = 0;
        int r116 = 0;
        int r117 = 0;
        int r34 = r23;
        ConstraintAnchor r35 = r20;
        ConstraintAnchor r36 = r19;
        int r37 = r110;
    L76:
        if (r117 >= r18) goto L96;
        WidgetsList r210 = this.mChainList.get(r117);
        if (r31 == 0) goto L80;
        ConstraintAnchor r211 = r36;
        int r38 = r115;
        int r39 = r116;
        int r40 = r117;
        if (r40 >= (r18 - 1)) goto L90;
        ConstraintAnchor r212 = WidgetsList.access$2000(this.mChainList.get(r40 + 1)).mLeft;
        int r213 = 0;
    L91:
        ConstraintAnchor r118 = WidgetsList.access$2000(r210).mRight;
        r210.setup(r31, r211, r35, r212, r22, r34, r27, r213, r37, r32);
        r116 = r39 + r210.getWidth();
        int r41 = Math.max(r38, r210.getHeight());
        if (r40 <= 0) goto L94;
        r116 = r116 + this.mHorizontalGap;
    L94:
        r115 = r41;
        r34 = 0;
        r28 = r213;
        r36 = r118;
    L95:
        r117 = r40 + 1;
        r21 = r212;
        goto L76
    L90:
        r212 = this.mRight;
        r213 = getPaddingRight();
        goto L91
    L80:
        if (r117 >= (r18 - 1)) goto L82;
        ConstraintAnchor r42 = WidgetsList.access$2000(this.mChainList.get(r117 + 1)).mTop;
        int r43 = 0;
    L83:
        ConstraintAnchor r119 = WidgetsList.access$2000(r210).mBottom;
        ConstraintAnchor r120 = r36;
        ConstraintAnchor r214 = r36;
        int r44 = r115;
        ConstraintAnchor r121 = r35;
        int r45 = r116;
        ConstraintAnchor r122 = r21;
        ConstraintAnchor r310 = r21;
        r40 = r117;
        r210.setup(r31, r120, r121, r122, r42, r34, r27, r28, r43, r32);
        int r46 = Math.max(r45, r210.getWidth());
        r115 = r44 + r210.getHeight();
        if (r40 <= 0) goto L86;
        r115 = r115 + this.mVerticalGap;
    L86:
        r36 = r214;
        r116 = r46;
        r27 = 0;
        r35 = r119;
        r212 = r310;
        int r215 = r43;
        r22 = r42;
        r37 = r215;
        goto L95
    L82:
        r42 = this.mBottom;
        r43 = getPaddingBottom();
        goto L83
    L96:
        r33[0] = r116;
        r33[1] = r115;
        return;
    L62:
        if (getVerticalDimensionBehaviour() == r112) goto L65;
        r113 = false;
        goto L66
    L33:
        r5 = 0;
        int r47 = 0;
        int r123 = 0;
    L34:
        if (r123 >= r30) goto L59;
        ConstraintWidget r124 = r29[r123];
        int r125 = getWidgetHeight(r124, r32);
        if (r124.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L38;
        r5 = r5 + 1;
    L38:
        int r126 = r5;
        if (r47 == r32) goto L43;
        if (((this.mVerticalGap + r47) + r125) > r32) goto L43;
    L45:
        boolean r48 = false;
    L46:
        if (r48 == true) goto L53;
        if (r123 <= 0) goto L53;
        int r49 = this.mMaxElementsWrap;
        if (r49 <= 0) goto L53;
        if ((r123 % r49) != 0) goto L53;
        r48 = true;
    L53:
        if (r48 == false) goto L56;
        r10 = new WidgetsList(this, r31, this.mLeft, this.mTop, this.mRight, this.mBottom, r32);
        r10.setStartIndex(r123);
        this.mChainList.add(r10);
    L55:
        r47 = r125;
    L58:
        r10.add(r124);
        r123 = r123 + 1;
        r5 = r126;
        goto L34
    L56:
        if (r123 <= 0) goto L55;
        r47 = (this.mVerticalGap + r125) + r47;
    L43:
        if (WidgetsList.access$2000(r10) == null) goto L45;
        r48 = true;
        goto L46
    }

    private void measureNoWrap(ConstraintWidget[] r23, int r24, int r25, int r26, int[] r27) {
        if (r24 != 0) goto L6;
        return;
    L6:
        if (this.mChainList.size() != 0) goto L8;
        WidgetsList r11 = new WidgetsList(this, r25, this.mLeft, this.mTop, this.mRight, this.mBottom, r26);
        this.mChainList.add(r11);
    L9:
        int r5 = 0;
    L10:
        if (r5 >= r24) goto L12;
        r11.add(r23[r5]);
        r5 = r5 + 1;
        goto L10
    L12:
        r27[0] = r11.getWidth();
        r27[1] = r11.getHeight();
        return;
    L8:
        WidgetsList r10 = this.mChainList.get(0);
        r10.clear();
        r11 = r10;
        r11.setup(r25, this.mLeft, this.mTop, this.mRight, this.mBottom, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), r26);
        goto L9
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem r10, boolean r11) {
        super.addToSolver(r10, r11);
        if (getParent() == null) goto L5;
        boolean r12 = ((ConstraintWidgetContainer) getParent()).isRtl();
    L6:
        int r5 = this.mWrapMode;
        if (r5 == 0) goto L21;
        if (r5 != 1) goto L10;
        int r13 = this.mChainList.size();
        int r14 = 0;
    L14:
        if (r14 >= r13) goto L23;
        WidgetsList r15 = this.mChainList.get(r14);
        if (r14 != (r13 - 1)) goto L18;
        boolean r16 = true;
    L19:
        r15.createConstraints(r12, r14, r16);
        r14 = r14 + 1;
        goto L14
    L18:
        r16 = false;
    L23:
        needsCallbackFromSolver(false);
        return;
    L10:
        if (r5 != 2) goto L23;
        createAlignedConstraints(r12);
        goto L23
    L21:
        if (this.mChainList.size() <= 0) goto L23;
        this.mChainList.get(0).createConstraints(r12, 0, true);
        goto L23
    L5:
        r12 = false;
        goto L6
    }

    @Override // androidx.constraintlayout.solver.widgets.HelperWidget, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void copy(ConstraintWidget r5, HashMap<ConstraintWidget, ConstraintWidget> r10) {
        super.copy(r5, r10);
        Flow r11 = (Flow) r5;
        this.mHorizontalStyle = r11.mHorizontalStyle;
        this.mVerticalStyle = r11.mVerticalStyle;
        this.mFirstHorizontalStyle = r11.mFirstHorizontalStyle;
        this.mFirstVerticalStyle = r11.mFirstVerticalStyle;
        this.mLastHorizontalStyle = r11.mLastHorizontalStyle;
        this.mLastVerticalStyle = r11.mLastVerticalStyle;
        this.mHorizontalBias = r11.mHorizontalBias;
        this.mVerticalBias = r11.mVerticalBias;
        this.mFirstHorizontalBias = r11.mFirstHorizontalBias;
        this.mFirstVerticalBias = r11.mFirstVerticalBias;
        this.mLastHorizontalBias = r11.mLastHorizontalBias;
        this.mLastVerticalBias = r11.mLastVerticalBias;
        this.mHorizontalGap = r11.mHorizontalGap;
        this.mVerticalGap = r11.mVerticalGap;
        this.mHorizontalAlign = r11.mHorizontalAlign;
        this.mVerticalAlign = r11.mVerticalAlign;
        this.mWrapMode = r11.mWrapMode;
        this.mMaxElementsWrap = r11.mMaxElementsWrap;
        this.mOrientation = r11.mOrientation;
    }

    @Override // androidx.constraintlayout.solver.widgets.VirtualLayout
    public void measure(int r19, int r20, int r21, int r22) {
        if (this.mWidgetsCount > 0) goto L5;
    L8:
        int r12 = getPaddingLeft();
        int r13 = getPaddingRight();
        int r14 = getPaddingTop();
        int r15 = getPaddingBottom();
        int[] r5 = new int[2];
        int r10 = (r20 - r12) - r13;
        int r11 = this.mOrientation;
        if (r11 != 1) goto L11;
        r10 = (r22 - r14) - r15;
    L11:
        int r16 = r10;
        if (r11 != 0) goto L20;
        if (this.mHorizontalStyle != (-1)) goto L17;
        this.mHorizontalStyle = 0;
    L17:
        if (this.mVerticalStyle != (-1)) goto L25;
        this.mVerticalStyle = 0;
    L25:
        ConstraintWidget[] r17 = this.mWidgets;
        int r18 = 0;
        int r23 = 0;
    L26:
        int r110 = this.mWidgetsCount;
        if (r18 >= r110) goto L32;
        if (this.mWidgets[r18].getVisibility() != 8) goto L31;
        r23 = r23 + 1;
    L31:
        r18 = r18 + 1;
        goto L26
    L32:
        if (r23 <= 0) goto L41;
        r17 = new ConstraintWidget[r110 - r23];
        int r24 = 0;
        int r25 = 0;
    L35:
        if (r24 >= this.mWidgetsCount) goto L40;
        ConstraintWidget r111 = this.mWidgets[r24];
        if (r111.getVisibility() == 8) goto L39;
        r17[r25] = r111;
        r25 = r25 + 1;
    L39:
        r24 = r24 + 1;
        goto L35
    L40:
        int r26 = r25;
    L42:
        this.mDisplayedWidgets = r17;
        this.mDisplayedWidgetsCount = r26;
        int r27 = this.mWrapMode;
        if (r27 != 0) goto L45;
        boolean r112 = true;
        measureNoWrap(r17, r26, this.mOrientation, r16, r5);
    L53:
        int r28 = (r5[0] + r12) + r13;
        int r29 = (r5[r112 ? 1 : 0] + r14) + r15;
        if (r19 != 1073741824) goto L56;
        r28 = r20;
    L61:
        if (r21 != 1073741824) goto L63;
        r29 = r22;
    L68:
        setMeasure(r28, r29);
        setWidth(r28);
        setHeight(r29);
        if (this.mWidgetsCount > 0) goto L72;
        r112 = false;
    L72:
        needsCallbackFromSolver(r112);
        return;
    L63:
        if (r21 != Integer.MIN_VALUE) goto L65;
        r29 = Math.min(r29, r22);
        goto L68
    L65:
        if (r21 == 0) goto L68;
        r29 = 0;
        goto L68
    L56:
        if (r19 != Integer.MIN_VALUE) goto L58;
        r28 = Math.min(r28, r20);
        goto L61
    L58:
        if (r19 == 0) goto L61;
        r28 = 0;
        goto L61
    L45:
        if (r27 != 1) goto L47;
        r112 = true;
        measureChainWrap(r17, r26, this.mOrientation, r16, r5);
        goto L53
    L47:
        if (r27 == 2) goto L50;
        r112 = true;
        goto L53
    L50:
        r112 = true;
        measureAligned(r17, r26, this.mOrientation, r16, r5);
        goto L53
    L41:
        r26 = r110;
        goto L42
    L20:
        if (this.mHorizontalStyle != (-1)) goto L23;
        this.mHorizontalStyle = 0;
    L23:
        if (this.mVerticalStyle != (-1)) goto L25;
        this.mVerticalStyle = 0;
        goto L25
    L5:
        if (measureChildren() == true) goto L8;
        setMeasure(0, 0);
        needsCallbackFromSolver(false);
    }

    public void setFirstHorizontalBias(float r5) {
        this.mFirstHorizontalBias = r5;
    }

    public void setFirstHorizontalStyle(int r5) {
        this.mFirstHorizontalStyle = r5;
    }

    public void setFirstVerticalBias(float r5) {
        this.mFirstVerticalBias = r5;
    }

    public void setFirstVerticalStyle(int r5) {
        this.mFirstVerticalStyle = r5;
    }

    public void setHorizontalAlign(int r5) {
        this.mHorizontalAlign = r5;
    }

    public void setHorizontalBias(float r5) {
        this.mHorizontalBias = r5;
    }

    public void setHorizontalGap(int r5) {
        this.mHorizontalGap = r5;
    }

    public void setHorizontalStyle(int r5) {
        this.mHorizontalStyle = r5;
    }

    public void setLastHorizontalBias(float r5) {
        this.mLastHorizontalBias = r5;
    }

    public void setLastHorizontalStyle(int r5) {
        this.mLastHorizontalStyle = r5;
    }

    public void setLastVerticalBias(float r5) {
        this.mLastVerticalBias = r5;
    }

    public void setLastVerticalStyle(int r5) {
        this.mLastVerticalStyle = r5;
    }

    public void setMaxElementsWrap(int r5) {
        this.mMaxElementsWrap = r5;
    }

    public void setOrientation(int r5) {
        this.mOrientation = r5;
    }

    public void setVerticalAlign(int r5) {
        this.mVerticalAlign = r5;
    }

    public void setVerticalBias(float r5) {
        this.mVerticalBias = r5;
    }

    public void setVerticalGap(int r5) {
        this.mVerticalGap = r5;
    }

    public void setVerticalStyle(int r5) {
        this.mVerticalStyle = r5;
    }

    public void setWrapMode(int r5) {
        this.mWrapMode = r5;
    }
}
