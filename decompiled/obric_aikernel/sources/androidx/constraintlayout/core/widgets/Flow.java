package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
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
    public static final int WRAP_CHAIN_NEW = 3;
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

    private class WidgetsList {
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

        public WidgetsList(Flow r10, int r11, ConstraintAnchor r12, ConstraintAnchor r13, ConstraintAnchor r14, ConstraintAnchor r15, int r16) {
            this.this$0 = r10;
            this.mOrientation = 0;
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
            this.mOrientation = r11;
            this.mLeft = r12;
            this.mTop = r13;
            this.mRight = r14;
            this.mBottom = r15;
            this.mPaddingLeft = r10.getPaddingLeft();
            this.mPaddingTop = r10.getPaddingTop();
            this.mPaddingRight = r10.getPaddingRight();
            this.mPaddingBottom = r10.getPaddingBottom();
            this.mMax = r16;
        }

        static /* synthetic */ ConstraintWidget access$2000(WidgetsList r10) {
            return r10.biggest;
        }

        private void recomputeDimensions() {
            this.mWidth = 0;
            this.mHeight = 0;
            this.biggest = null;
            this.biggestDimension = 0;
            int r10 = this.mCount;
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L26;
            if ((this.mStartIndex + r11) >= Flow.access$400(this.this$0)) goto L33;
            ConstraintWidget r12 = Flow.access$500(this.this$0)[this.mStartIndex + r11];
            if (this.mOrientation != 0) goto L17;
            int r13 = r12.getWidth();
            int r14 = Flow.access$000(this.this$0);
            if (r12.getVisibility() != 8) goto L12;
            r14 = 0;
        L12:
            this.mWidth += r13 + r14;
            int r15 = Flow.access$300(this.this$0, r12, this.mMax);
            if (this.biggest != null) goto L15;
        L16:
            this.biggest = r12;
            this.biggestDimension = r15;
            this.mHeight = r15;
        L25:
            r11 = r11 + 1;
            goto L3
        L15:
            if (this.biggestDimension >= r15) goto L25;
        L17:
            int r16 = Flow.access$200(this.this$0, r12, this.mMax);
            int r17 = Flow.access$300(this.this$0, r12, this.mMax);
            int r18 = Flow.access$100(this.this$0);
            if (r12.getVisibility() != 8) goto L20;
            r18 = 0;
        L20:
            this.mHeight += r17 + r18;
            if (this.biggest != null) goto L23;
        L24:
            this.biggest = r12;
            this.biggestDimension = r16;
            this.mWidth = r16;
            goto L25
        L23:
            if (this.biggestDimension >= r16) goto L25;
        L33:
            return;
        }

        public void add(ConstraintWidget r10) {
            int r11 = 0;
            if (this.mOrientation != 0) goto L16;
            int r12 = Flow.access$200(this.this$0, r10, this.mMax);
            if (r10.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L7;
            this.mNbMatchConstraintsWidgets++;
            r12 = 0;
        L7:
            int r13 = Flow.access$000(this.this$0);
            if (r10.getVisibility() == 8) goto L11;
            r11 = r13;
        L11:
            this.mWidth += r12 + r11;
            int r14 = Flow.access$300(this.this$0, r10, this.mMax);
            if (this.biggest != null) goto L14;
        L15:
            this.biggest = r10;
            this.biggestDimension = r14;
            this.mHeight = r14;
        L28:
            this.mCount++;
            return;
        L14:
            if (this.biggestDimension >= r14) goto L28;
        L16:
            int r15 = Flow.access$200(this.this$0, r10, this.mMax);
            int r16 = Flow.access$300(this.this$0, r10, this.mMax);
            if (r10.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L19;
            this.mNbMatchConstraintsWidgets++;
            r16 = 0;
        L19:
            int r17 = Flow.access$100(this.this$0);
            if (r10.getVisibility() == 8) goto L23;
            r11 = r17;
        L23:
            this.mHeight += r16 + r11;
            if (this.biggest != null) goto L26;
        L27:
            this.biggest = r10;
            this.biggestDimension = r15;
            this.mWidth = r15;
            goto L28
        L26:
            if (this.biggestDimension >= r15) goto L28;
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
            int r10 = this.mCount;
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L11;
            if ((this.mStartIndex + r11) >= Flow.access$400(this.this$0)) goto L11;
            ConstraintWidget r12 = Flow.access$500(this.this$0)[this.mStartIndex + r11];
            if (r12 == null) goto L10;
            r12.resetAnchors();
        L10:
            r11 = r11 + 1;
        L11:
            if (r10 != 0) goto L13;
            return;
        L13:
            if (this.biggest == null) goto L223;
            if (r19 == false) goto L18;
            if (r18 != 0) goto L18;
            boolean r13 = true;
        L19:
            int r14 = 0;
            int r15 = -1;
            int r16 = -1;
        L20:
            if (r14 >= r10) goto L35;
            if (r17 == false) goto L23;
            int r20 = (r10 - 1) - r14;
        L25:
            if ((this.mStartIndex + r20) >= Flow.access$400(this.this$0)) goto L35;
            ConstraintWidget r21 = Flow.access$500(this.this$0)[this.mStartIndex + r20];
            if (r21 == null) goto L34;
            if (r21.getVisibility() != 0) goto L34;
            if (r15 != (-1)) goto L33;
            r15 = r14;
        L33:
            r16 = r14;
        L34:
            r14 = r14 + 1;
            goto L20
        L23:
            r20 = r14;
        L35:
            ConstraintWidget r22 = null;
            if (this.mOrientation != 0) goto L129;
            ConstraintWidget r23 = this.biggest;
            r23.setVerticalChainStyle(Flow.access$600(this.this$0));
            int r110 = this.mPaddingTop;
            if (r18 <= 0) goto L40;
            r110 = r110 + Flow.access$100(this.this$0);
        L40:
            r23.mTop.connect(this.mTop, r110);
            if (r19 == false) goto L43;
            r23.mBottom.connect(this.mBottom, this.mPaddingBottom);
        L43:
            if (r18 <= 0) goto L45;
            this.mTop.mOwner.mBottom.connect(r23.mTop, 0);
        L45:
            char r111 = 3;
            if (Flow.access$700(this.this$0) == 3) goto L48;
        L61:
            ConstraintWidget r112 = r23;
        L62:
            int r113 = 0;
        L63:
            if (r113 >= r10) goto L224;
            if (r17 == false) goto L66;
            int r114 = (r10 - 1) - r113;
        L68:
            if ((this.mStartIndex + r114) >= Flow.access$400(this.this$0)) goto L225;
            ConstraintWidget r115 = Flow.access$500(this.this$0)[this.mStartIndex + r114];
            if (r115 != null) goto L73;
            r115 = r22;
            char r24 = r111;
        L128:
            r113 = r113 + 1;
            r111 = r24;
            r22 = r115;
            goto L63
        L73:
            if (r113 != 0) goto L75;
            r115.connect(r115.mLeft, this.mLeft, this.mPaddingLeft);
        L75:
            if (r114 != 0) goto L98;
            int r25 = Flow.access$800(this.this$0);
            float r116 = Flow.access$900(this.this$0);
            if (r17 == false) goto L80;
            r116 = 1.0f - r116;
        L80:
            if (this.mStartIndex == 0) goto L82;
        L89:
            if (r19 == true) goto L91;
        L96:
            r115.setHorizontalChainStyle(r25);
            r115.setHorizontalBiasPercent(r116);
            goto L98
        L91:
            if (Flow.access$1200(this.this$0) == (-1)) goto L96;
            r25 = Flow.access$1200(this.this$0);
            if (r17 == false) goto L95;
            float r117 = Flow.access$1300(this.this$0);
        L86:
            float r118 = 1.0f - r117;
        L88:
            r116 = r118;
            goto L96
        L95:
            r118 = Flow.access$1300(this.this$0);
            goto L88
        L82:
            if (Flow.access$1000(this.this$0) == (-1)) goto L89;
            r25 = Flow.access$1000(this.this$0);
            if (r17 == false) goto L87;
            r117 = Flow.access$1100(this.this$0);
            goto L86
        L87:
            r118 = Flow.access$1100(this.this$0);
        L98:
            if (r113 != (r10 - 1)) goto L100;
            r115.connect(r115.mRight, this.mRight, this.mPaddingRight);
        L100:
            if (r22 == null) goto L107;
            r115.mLeft.connect(r22.mRight, Flow.access$000(this.this$0));
            if (r113 != r15) goto L104;
            r115.mLeft.setGoneMargin(this.mPaddingLeft);
        L104:
            r22.mRight.connect(r115.mLeft, 0);
            if (r113 != (r16 + 1)) goto L107;
            r22.mRight.setGoneMargin(this.mPaddingRight);
        L107:
            if (r115 == r23) goto L127;
            r24 = 3;
            if (Flow.access$700(this.this$0) == 3) goto L111;
        L116:
            int r26 = Flow.access$700(this.this$0);
            if (r26 != 0) goto L119;
            ConstraintAnchor r27 = r115.mTop;
            ConstraintAnchor r119 = r23.mTop;
        L126:
            r27.connect(r119, 0);
            goto L128
        L119:
            if (r26 == 1) goto L124;
            ConstraintAnchor r28 = r115.mTop;
            if (r13 == false) goto L123;
            r28.connect(this.mTop, this.mPaddingTop);
            r115.mBottom.connect(this.mBottom, this.mPaddingBottom);
            goto L128
        L123:
            r28.connect(r23.mTop, 0);
        L124:
            r27 = r115.mBottom;
            r119 = r23.mBottom;
            goto L126
        L111:
            if (r112.hasBaseline() == false) goto L116;
            if (r115 == r112) goto L116;
            if (r115.hasBaseline() == false) goto L116;
            r27 = r115.mBaseline;
            r119 = r112.mBaseline;
            goto L126
        L127:
            r24 = 3;
            goto L128
        L225:
            return;
        L66:
            r114 = r113;
            goto L68
        L224:
            return;
        L48:
            if (r23.hasBaseline() == true) goto L61;
            int r120 = 0;
        L50:
            if (r120 >= r10) goto L61;
            if (r17 == false) goto L53;
            int r121 = (r10 - 1) - r120;
        L55:
            if ((this.mStartIndex + r121) >= Flow.access$400(this.this$0)) goto L61;
            r112 = Flow.access$500(this.this$0)[this.mStartIndex + r121];
            if (r112.hasBaseline() == true) goto L62;
            r120 = r120 + 1;
            goto L50
        L53:
            r121 = r120;
            goto L55
        L129:
            ConstraintWidget r29 = this.biggest;
            r29.setHorizontalChainStyle(Flow.access$800(this.this$0));
            int r30 = this.mPaddingLeft;
            if (r18 <= 0) goto L132;
            r30 = r30 + Flow.access$000(this.this$0);
        L132:
            if (r17 == false) goto L138;
            r29.mRight.connect(this.mRight, r30);
            if (r19 == false) goto L136;
            r29.mLeft.connect(this.mLeft, this.mPaddingRight);
        L136:
            if (r18 <= 0) goto L144;
            ConstraintAnchor r31 = this.mRight.mOwner.mLeft;
            ConstraintAnchor r122 = r29.mRight;
        L143:
            r31.connect(r122, 0);
        L144:
            int r32 = 0;
        L145:
            if (r32 >= r10) goto L226;
            if ((this.mStartIndex + r32) >= Flow.access$400(this.this$0)) goto L227;
            ConstraintWidget r123 = Flow.access$500(this.this$0)[this.mStartIndex + r32];
            if (r123 == null) goto L199;
            if (r32 != 0) goto L164;
            r123.connect(r123.mTop, this.mTop, this.mPaddingTop);
            int r124 = Flow.access$600(this.this$0);
            float r125 = Flow.access$1400(this.this$0);
            if (this.mStartIndex == 0) goto L156;
        L158:
            if (r19 == true) goto L160;
        L162:
            r123.setVerticalChainStyle(r124);
            r123.setVerticalBiasPercent(r125);
            goto L164
        L160:
            if (Flow.access$1700(this.this$0) == (-1)) goto L162;
            r124 = Flow.access$1700(this.this$0);
            r125 = Flow.access$1800(this.this$0);
            goto L162
        L156:
            if (Flow.access$1500(this.this$0) == (-1)) goto L158;
            r124 = Flow.access$1500(this.this$0);
            r125 = Flow.access$1600(this.this$0);
        L164:
            if (r32 != (r10 - 1)) goto L166;
            r123.connect(r123.mBottom, this.mBottom, this.mPaddingBottom);
        L166:
            if (r22 == null) goto L173;
            r123.mTop.connect(r22.mBottom, Flow.access$100(this.this$0));
            if (r32 != r15) goto L170;
            r123.mTop.setGoneMargin(this.mPaddingTop);
        L170:
            r22.mBottom.connect(r123.mTop, 0);
            if (r32 != (r16 + 1)) goto L173;
            r22.mBottom.setGoneMargin(this.mPaddingBottom);
        L173:
            if (r123 == r29) goto L198;
            int r126 = Flow.access$1900(this.this$0);
            if (r17 == false) goto L186;
            if (r126 != 0) goto L178;
        L183:
            ConstraintAnchor r33 = r123.mRight;
            ConstraintAnchor r127 = r29.mRight;
        L184:
            r33.connect(r127, 0);
            goto L198
        L178:
            if (r126 == 1) goto L182;
            if (r126 != 2) goto L198;
            r123.mLeft.connect(r29.mLeft, 0);
            goto L183
        L182:
            r33 = r123.mLeft;
            r127 = r29.mLeft;
            goto L184
        L186:
            if (r126 == 0) goto L195;
            if (r126 == 1) goto L194;
            if (r126 != 2) goto L198;
            ConstraintAnchor r34 = r123.mLeft;
            if (r13 == false) goto L193;
            r34.connect(this.mLeft, this.mPaddingLeft);
            r123.mRight.connect(this.mRight, this.mPaddingRight);
            goto L198
        L193:
            r34.connect(r29.mLeft, 0);
        L194:
            ConstraintAnchor r35 = r123.mRight;
            ConstraintAnchor r128 = r29.mRight;
        L196:
            r35.connect(r128, 0);
            goto L198
        L195:
            r35 = r123.mLeft;
            r128 = r29.mLeft;
        L198:
            r22 = r123;
        L199:
            r32 = r32 + 1;
            goto L145
        L227:
            return;
        L226:
            return;
        L138:
            r29.mLeft.connect(this.mLeft, r30);
            if (r19 == false) goto L141;
            r29.mRight.connect(this.mRight, this.mPaddingRight);
        L141:
            if (r18 <= 0) goto L144;
            r31 = this.mLeft.mOwner.mRight;
            r122 = r29.mLeft;
        L18:
            r13 = false;
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
            int r11 = this.mNbMatchConstraintsWidgets;
            if (r11 != 0) goto L5;
            return;
        L5:
            int r12 = this.mCount;
            int r13 = r10 / r11;
            int r14 = 0;
        L6:
            if (r14 >= r12) goto L26;
            if ((this.mStartIndex + r14) >= Flow.access$400(this.this$0)) goto L26;
            ConstraintWidget r15 = Flow.access$500(this.this$0)[this.mStartIndex + r14];
            if (this.mOrientation != 0) goto L18;
            if (r15 == null) goto L25;
            if (r15.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L25;
            if (r15.mMatchConstraintDefaultWidth != 0) goto L25;
            Flow r16 = this.this$0;
            ConstraintWidget.DimensionBehaviour r17 = ConstraintWidget.DimensionBehaviour.FIXED;
            ConstraintWidget.DimensionBehaviour r18 = r15.getVerticalDimensionBehaviour();
            int r19 = r15.getHeight();
            int r20 = r13;
        L24:
            r16.measure(r15, r17, r20, r18, r19);
        L25:
            r14 = r14 + 1;
            goto L6
        L18:
            if (r15 == null) goto L25;
            if (r15.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L25;
            if (r15.mMatchConstraintDefaultHeight != 0) goto L25;
            r16 = this.this$0;
            r17 = r15.getHorizontalDimensionBehaviour();
            r20 = r15.getWidth();
            r18 = ConstraintWidget.DimensionBehaviour.FIXED;
            r19 = r13;
        L26:
            recomputeDimensions();
        }

        public void setStartIndex(int r10) {
            this.mStartIndex = r10;
        }

        public void setup(int r10, ConstraintAnchor r11, ConstraintAnchor r12, ConstraintAnchor r13, ConstraintAnchor r14, int r15, int r16, int r17, int r18, int r19) {
            this.mOrientation = r10;
            this.mLeft = r11;
            this.mTop = r12;
            this.mRight = r13;
            this.mBottom = r14;
            this.mPaddingLeft = r15;
            this.mPaddingTop = r16;
            this.mPaddingRight = r17;
            this.mPaddingBottom = r18;
            this.mMax = r19;
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

    static /* synthetic */ int access$000(Flow r10) {
        return r10.mHorizontalGap;
    }

    static /* synthetic */ int access$100(Flow r10) {
        return r10.mVerticalGap;
    }

    static /* synthetic */ int access$1000(Flow r10) {
        return r10.mFirstHorizontalStyle;
    }

    static /* synthetic */ float access$1100(Flow r10) {
        return r10.mFirstHorizontalBias;
    }

    static /* synthetic */ int access$1200(Flow r10) {
        return r10.mLastHorizontalStyle;
    }

    static /* synthetic */ float access$1300(Flow r10) {
        return r10.mLastHorizontalBias;
    }

    static /* synthetic */ float access$1400(Flow r10) {
        return r10.mVerticalBias;
    }

    static /* synthetic */ int access$1500(Flow r10) {
        return r10.mFirstVerticalStyle;
    }

    static /* synthetic */ float access$1600(Flow r10) {
        return r10.mFirstVerticalBias;
    }

    static /* synthetic */ int access$1700(Flow r10) {
        return r10.mLastVerticalStyle;
    }

    static /* synthetic */ float access$1800(Flow r10) {
        return r10.mLastVerticalBias;
    }

    static /* synthetic */ int access$1900(Flow r10) {
        return r10.mHorizontalAlign;
    }

    static /* synthetic */ int access$200(Flow r10, ConstraintWidget r11, int r12) {
        return r10.getWidgetWidth(r11, r12);
    }

    static /* synthetic */ int access$300(Flow r10, ConstraintWidget r11, int r12) {
        return r10.getWidgetHeight(r11, r12);
    }

    static /* synthetic */ int access$400(Flow r10) {
        return r10.mDisplayedWidgetsCount;
    }

    static /* synthetic */ ConstraintWidget[] access$500(Flow r10) {
        return r10.mDisplayedWidgets;
    }

    static /* synthetic */ int access$600(Flow r10) {
        return r10.mVerticalStyle;
    }

    static /* synthetic */ int access$700(Flow r10) {
        return r10.mVerticalAlign;
    }

    static /* synthetic */ int access$800(Flow r10) {
        return r10.mHorizontalStyle;
    }

    static /* synthetic */ float access$900(Flow r10) {
        return r10.mHorizontalBias;
    }

    private void createAlignedConstraints(boolean r12) {
        if (this.mAlignedDimensions != null) goto L5;
        return;
    L5:
        if (this.mAlignedBiggestElementsInCols != null) goto L7;
        return;
    L7:
        if (this.mAlignedBiggestElementsInRows == null) goto L91;
        int r10 = 0;
    L11:
        if (r10 >= this.mDisplayedWidgetsCount) goto L13;
        this.mDisplayedWidgets[r10].resetAnchors();
        r10 = r10 + 1;
        goto L11
    L13:
        int[] r11 = this.mAlignedDimensions;
        int r13 = r11[0];
        int r14 = r11[1];
        ConstraintWidget r15 = null;
        float r16 = this.mHorizontalBias;
        int r17 = 0;
    L15:
        if (r17 >= r13) goto L34;
        if (r12 == false) goto L18;
        int r18 = (r13 - r17) - 1;
        float r19 = 1.0f - this.mHorizontalBias;
    L19:
        ConstraintWidget r20 = this.mAlignedBiggestElementsInCols[r18];
        if (r20 == null) goto L33;
        if (r20.getVisibility() == 8) goto L33;
        if (r17 != 0) goto L27;
        r20.connect(r20.mLeft, this.mLeft, getPaddingLeft());
        r20.setHorizontalChainStyle(this.mHorizontalStyle);
        r20.setHorizontalBiasPercent(r19);
    L27:
        if (r17 != (r13 - 1)) goto L29;
        r20.connect(r20.mRight, this.mRight, getPaddingRight());
    L29:
        if (r17 <= 0) goto L32;
        if (r15 == null) goto L32;
        r20.connect(r20.mLeft, r15.mRight, this.mHorizontalGap);
        r15.connect(r15.mRight, r20.mLeft, 0);
    L32:
        r15 = r20;
    L33:
        r17 = r17 + 1;
        r16 = r19;
        goto L15
    L18:
        r19 = r16;
        r18 = r17;
        goto L19
    L34:
        int r110 = 0;
    L35:
        if (r110 >= r14) goto L51;
        ConstraintWidget r21 = this.mAlignedBiggestElementsInRows[r110];
        if (r21 == null) goto L50;
        if (r21.getVisibility() == 8) goto L50;
        if (r110 != 0) goto L44;
        r21.connect(r21.mTop, this.mTop, getPaddingTop());
        r21.setVerticalChainStyle(this.mVerticalStyle);
        r21.setVerticalBiasPercent(this.mVerticalBias);
    L44:
        if (r110 != (r14 - 1)) goto L46;
        r21.connect(r21.mBottom, this.mBottom, getPaddingBottom());
    L46:
        if (r110 <= 0) goto L49;
        if (r15 == null) goto L49;
        r21.connect(r21.mTop, r15.mBottom, this.mVerticalGap);
        r15.connect(r15.mBottom, r21.mTop, 0);
    L49:
        r15 = r21;
    L50:
        r110 = r110 + 1;
        goto L35
    L51:
        int r111 = 0;
    L52:
        if (r111 >= r13) goto L92;
        int r22 = 0;
    L54:
        if (r22 >= r14) goto L72;
        int r23 = (r22 * r13) + r111;
        if (this.mOrientation != 1) goto L58;
        r23 = (r111 * r14) + r22;
    L58:
        ConstraintWidget[] r24 = this.mDisplayedWidgets;
        if (r23 >= r24.length) goto L71;
        ConstraintWidget r25 = r24[r23];
        if (r25 == null) goto L71;
        if (r25.getVisibility() == 8) goto L71;
        ConstraintWidget r26 = this.mAlignedBiggestElementsInCols[r111];
        ConstraintWidget r27 = this.mAlignedBiggestElementsInRows[r22];
        if (r25 == r26) goto L69;
        r25.connect(r25.mLeft, r26.mLeft, 0);
        r25.connect(r25.mRight, r26.mRight, 0);
    L69:
        if (r25 == r27) goto L71;
        r25.connect(r25.mTop, r27.mTop, 0);
        r25.connect(r25.mBottom, r27.mBottom, 0);
    L71:
        r22 = r22 + 1;
        goto L54
    L72:
        r111 = r111 + 1;
        goto L52
    L92:
        return;
    }

    private final int getWidgetHeight(ConstraintWidget r10, int r11) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
        int r12 = r10.mMatchConstraintDefaultHeight;
        if (r12 != 0) goto L11;
        return 0;
    L11:
        if (r12 != 2) goto L16;
        int r13 = (int) (r10.mMatchConstraintPercentHeight * r11);
        if (r13 == r10.getHeight()) goto L15;
        r10.setMeasureRequested(true);
        measure(r10, r10.getHorizontalDimensionBehaviour(), r10.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, r13);
    L15:
        return r13;
    L16:
        if (r12 != 1) goto L20;
        return r10.getHeight();
    L20:
        if (r12 != 3) goto L24;
        return (int) ((r10.getWidth() * r10.mDimensionRatio) + 0.5f);
    L24:
        return r10.getHeight();
    }

    private final int getWidgetWidth(ConstraintWidget r10, int r11) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
        int r12 = r10.mMatchConstraintDefaultWidth;
        if (r12 != 0) goto L11;
        return 0;
    L11:
        if (r12 != 2) goto L16;
        int r13 = (int) (r10.mMatchConstraintPercentWidth * r11);
        if (r13 == r10.getWidth()) goto L15;
        r10.setMeasureRequested(true);
        measure(r10, ConstraintWidget.DimensionBehaviour.FIXED, r13, r10.getVerticalDimensionBehaviour(), r10.getHeight());
    L15:
        return r13;
    L16:
        if (r12 != 1) goto L20;
        return r10.getWidth();
    L20:
        if (r12 != 3) goto L24;
        return (int) ((r10.getHeight() * r10.mDimensionRatio) + 0.5f);
    L24:
        return r10.getWidth();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:103:0x0119 -> B:40:0x0061). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:104:0x011b -> B:40:0x0061). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x0121 -> B:40:0x0061). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:107:0x0123 -> B:40:0x0061). Please report as a decompilation issue!!! */
    private void measureAligned(ConstraintWidget[] r17, int r18, int r19, int r20, int[] r21) {
        int r10 = this.mMaxElementsWrap;
        if (r19 != 0) goto L18;
        if (r10 > 0) goto L17;
        r10 = 0;
        int r11 = 0;
        int r12 = 0;
    L6:
        if (r11 >= r18) goto L17;
        if (r11 <= 0) goto L9;
        r12 = r12 + this.mHorizontalGap;
    L9:
        ConstraintWidget r13 = r17[r11];
        if (r13 == null) goto L16;
        r12 = r12 + getWidgetWidth(r13, r20);
        if (r12 > r20) goto L17;
        r10 = r10 + 1;
    L16:
        r11 = r11 + 1;
    L17:
        int r14 = r10;
        r10 = 0;
    L33:
        if (this.mAlignedDimensions != null) goto L36;
        this.mAlignedDimensions = new int[2];
    L36:
        if (r10 != 0) goto L38;
        if (r19 != 1) goto L38;
    L40:
        boolean r15 = true;
    L42:
        if (r15 == true) goto L109;
        if (r19 != 0) goto L45;
        r10 = (int) Math.ceil(r18 / r14);
    L46:
        ConstraintWidget[] r16 = this.mAlignedBiggestElementsInCols;
        if (r16 != null) goto L49;
    L52:
        this.mAlignedBiggestElementsInCols = new ConstraintWidget[r14];
    L53:
        ConstraintWidget[] r110 = this.mAlignedBiggestElementsInRows;
        if (r110 != null) goto L56;
    L59:
        this.mAlignedBiggestElementsInRows = new ConstraintWidget[r10];
    L60:
        int r111 = 0;
    L61:
        if (r111 >= r14) goto L85;
        int r112 = 0;
    L63:
        if (r112 >= r10) goto L84;
        int r113 = (r112 * r14) + r111;
        if (r19 != 1) goto L68;
        r113 = (r111 * r10) + r112;
    L68:
        if (r113 >= r17.length) goto L83;
        ConstraintWidget r114 = r17[r113];
        if (r114 == null) goto L83;
        int r115 = getWidgetWidth(r114, r20);
        ConstraintWidget[] r116 = this.mAlignedBiggestElementsInCols;
        if (r116[r111] != null) goto L76;
    L77:
        this.mAlignedBiggestElementsInCols[r111] = r114;
    L78:
        int r117 = getWidgetHeight(r114, r20);
        ConstraintWidget[] r118 = this.mAlignedBiggestElementsInRows;
        if (r118[r112] != null) goto L81;
    L82:
        this.mAlignedBiggestElementsInRows[r112] = r114;
        goto L83
    L81:
        if (r118[r112].getHeight() >= r117) goto L83;
    L76:
        if (r116[r111].getWidth() >= r115) goto L78;
    L83:
        r112 = r112 + 1;
        goto L63
    L84:
        r111 = r111 + 1;
        goto L61
    L85:
        int r119 = 0;
        int r120 = 0;
    L86:
        if (r119 >= r14) goto L93;
        ConstraintWidget r121 = this.mAlignedBiggestElementsInCols[r119];
        if (r121 == null) goto L92;
        if (r119 <= 0) goto L91;
        r120 = r120 + this.mHorizontalGap;
    L91:
        r120 = r120 + getWidgetWidth(r121, r20);
    L92:
        r119 = r119 + 1;
        goto L86
    L93:
        int r122 = 0;
        int r123 = 0;
    L94:
        if (r122 >= r10) goto L101;
        ConstraintWidget r124 = this.mAlignedBiggestElementsInRows[r122];
        if (r124 == null) goto L100;
        if (r122 <= 0) goto L99;
        r123 = r123 + this.mVerticalGap;
    L99:
        r123 = r123 + getWidgetHeight(r124, r20);
    L100:
        r122 = r122 + 1;
        goto L94
    L101:
        r21[0] = r120;
        r21[1] = r123;
        if (r19 == 0) goto L103;
        if (r123 <= r20) goto L40;
        if (r10 <= 1) goto L40;
        r10 = r10 - 1;
        goto L42
    L103:
        if (r120 <= r20) goto L40;
        if (r14 <= 1) goto L40;
        r14 = r14 - 1;
        goto L42
    L56:
        if (r110.length < r10) goto L59;
        Arrays.fill(r110, null);
        goto L60
    L49:
        if (r16.length < r14) goto L52;
        Arrays.fill(r16, null);
        goto L53
    L45:
        r14 = (int) Math.ceil(r18 / r10);
        goto L46
    L109:
        int[] r22 = this.mAlignedDimensions;
        r22[0] = r14;
        r22[1] = r10;
        return;
    L38:
        if (r14 != 0) goto L41;
        if (r19 == 0) goto L40;
    L41:
        r15 = false;
        goto L42
    L18:
        if (r10 > 0) goto L31;
        r10 = 0;
        int r23 = 0;
        int r24 = 0;
    L20:
        if (r23 >= r18) goto L31;
        if (r23 <= 0) goto L23;
        r24 = r24 + this.mVerticalGap;
    L23:
        ConstraintWidget r25 = r17[r23];
        if (r25 == null) goto L30;
        r24 = r24 + getWidgetHeight(r25, r20);
        if (r24 > r20) goto L31;
        r10 = r10 + 1;
    L30:
        r23 = r23 + 1;
    L31:
        r14 = 0;
        goto L33
    }

    private void measureChainWrap(ConstraintWidget[] r29, int r30, int r31, int r32, int[] r33) {
        if (r30 != 0) goto L5;
        return;
    L5:
        this.mChainList.clear();
        WidgetsList r10 = new WidgetsList(this, r31, this.mLeft, this.mTop, this.mRight, this.mBottom, r32);
        this.mChainList.add(r10);
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
        if (r31 != 0) goto L32;
    L7:
        if (r13 >= r30) goto L57;
        ConstraintWidget r14 = r29[r13];
        int r15 = getWidgetWidth(r14, r32);
        if (r14.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L11;
        r11 = r11 + 1;
    L11:
        int r16 = r11;
        if (r12 == r32) goto L16;
        if (((this.mHorizontalGap + r12) + r15) > r32) goto L16;
    L18:
        boolean r17 = false;
    L19:
        if (r17 == true) goto L26;
        if (r13 <= 0) goto L26;
        int r18 = this.mMaxElementsWrap;
        if (r18 <= 0) goto L26;
        if ((r13 % r18) != 0) goto L26;
        r17 = true;
    L26:
        if (r17 == false) goto L29;
        r10 = new WidgetsList(this, r31, this.mLeft, this.mTop, this.mRight, this.mBottom, r32);
        r10.setStartIndex(r13);
        this.mChainList.add(r10);
    L28:
        r12 = r15;
    L31:
        r10.add(r14);
        r13 = r13 + 1;
        r11 = r16;
        goto L7
    L29:
        if (r13 <= 0) goto L28;
        r12 = r12 + (this.mHorizontalGap + r15);
    L16:
        if (WidgetsList.access$2000(r10) == null) goto L18;
        r17 = true;
    L57:
        int r19 = this.mChainList.size();
        ConstraintAnchor r20 = this.mLeft;
        ConstraintAnchor r21 = this.mTop;
        ConstraintAnchor r22 = this.mRight;
        ConstraintAnchor r23 = this.mBottom;
        int r24 = getPaddingLeft();
        int r25 = getPaddingTop();
        int r26 = getPaddingRight();
        int r110 = getPaddingBottom();
        ConstraintWidget.DimensionBehaviour r111 = getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r112 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r111 != r112) goto L60;
    L63:
        boolean r113 = true;
    L64:
        if (r11 <= 0) goto L73;
        if (r113 == false) goto L73;
        int r27 = 0;
    L67:
        if (r27 >= r19) goto L73;
        WidgetsList r114 = this.mChainList.get(r27);
        if (r31 != 0) goto L71;
        int r115 = r114.getWidth();
    L72:
        r114.measureMatchConstraints(r32 - r115);
        r27 = r27 + 1;
        goto L67
    L71:
        r115 = r114.getHeight();
    L73:
        int r28 = r25;
        int r34 = r26;
        int r116 = 0;
        int r117 = 0;
        int r118 = 0;
        int r35 = r24;
        ConstraintAnchor r36 = r21;
        ConstraintAnchor r37 = r20;
        int r38 = r110;
    L74:
        if (r118 >= r19) goto L94;
        WidgetsList r210 = this.mChainList.get(r118);
        if (r31 == 0) goto L78;
        ConstraintAnchor r211 = r37;
        int r39 = r116;
        int r40 = r117;
        int r41 = r118;
        if (r41 >= (r19 - 1)) goto L88;
        ConstraintAnchor r212 = WidgetsList.access$2000(this.mChainList.get(r41 + 1)).mLeft;
        int r213 = 0;
    L89:
        ConstraintAnchor r119 = WidgetsList.access$2000(r210).mRight;
        r210.setup(r31, r211, r36, r212, r23, r35, r28, r213, r38, r32);
        r117 = r40 + r210.getWidth();
        int r42 = Math.max(r39, r210.getHeight());
        if (r41 <= 0) goto L92;
        r117 = r117 + this.mHorizontalGap;
    L92:
        r116 = r42;
        r35 = 0;
        r34 = r213;
        r37 = r119;
    L93:
        r118 = r41 + 1;
        r22 = r212;
        goto L74
    L88:
        r212 = this.mRight;
        r213 = getPaddingRight();
        goto L89
    L78:
        if (r118 >= (r19 - 1)) goto L80;
        ConstraintAnchor r43 = WidgetsList.access$2000(this.mChainList.get(r118 + 1)).mTop;
        int r44 = 0;
    L81:
        ConstraintAnchor r120 = WidgetsList.access$2000(r210).mBottom;
        ConstraintAnchor r121 = r37;
        ConstraintAnchor r214 = r37;
        int r45 = r116;
        ConstraintAnchor r122 = r36;
        int r46 = r117;
        ConstraintAnchor r123 = r22;
        ConstraintAnchor r310 = r22;
        r41 = r118;
        r210.setup(r31, r121, r122, r123, r43, r35, r28, r34, r44, r32);
        int r47 = Math.max(r46, r210.getWidth());
        r116 = r45 + r210.getHeight();
        if (r41 <= 0) goto L84;
        r116 = r116 + this.mVerticalGap;
    L84:
        r37 = r214;
        r117 = r47;
        r28 = 0;
        r36 = r120;
        r212 = r310;
        int r215 = r44;
        r23 = r43;
        r38 = r215;
        goto L93
    L80:
        r43 = this.mBottom;
        r44 = getPaddingBottom();
        goto L81
    L94:
        r33[0] = r117;
        r33[1] = r116;
        return;
    L60:
        if (getVerticalDimensionBehaviour() == r112) goto L63;
        r113 = false;
    L32:
        if (r13 >= r30) goto L57;
        ConstraintWidget r124 = r29[r13];
        int r125 = getWidgetHeight(r124, r32);
        if (r124.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L36;
        r11 = r11 + 1;
    L36:
        int r126 = r11;
        if (r12 == r32) goto L41;
        if (((this.mVerticalGap + r12) + r125) > r32) goto L41;
    L43:
        boolean r48 = false;
    L44:
        if (r48 == true) goto L51;
        if (r13 <= 0) goto L51;
        int r49 = this.mMaxElementsWrap;
        if (r49 <= 0) goto L51;
        if ((r13 % r49) != 0) goto L51;
        r48 = true;
    L51:
        if (r48 == false) goto L54;
        r10 = new WidgetsList(this, r31, this.mLeft, this.mTop, this.mRight, this.mBottom, r32);
        r10.setStartIndex(r13);
        this.mChainList.add(r10);
    L53:
        r12 = r125;
    L56:
        r10.add(r124);
        r13 = r13 + 1;
        r11 = r126;
        goto L32
    L54:
        if (r13 <= 0) goto L53;
        r12 = r12 + (this.mVerticalGap + r125);
    L41:
        if (WidgetsList.access$2000(r10) == null) goto L43;
        r48 = true;
        goto L44
    }

    private void measureChainWrap_new(ConstraintWidget[] r29, int r30, int r31, int r32, int[] r33) {
        if (r30 != 0) goto L5;
        return;
    L5:
        this.mChainList.clear();
        WidgetsList r10 = new WidgetsList(this, r31, this.mLeft, this.mTop, this.mRight, this.mBottom, r32);
        this.mChainList.add(r10);
        int r11 = 0;
        int r12 = 0;
        if (r31 != 0) goto L33;
        int r13 = 0;
        int r14 = 0;
    L8:
        if (r14 >= r30) goto L58;
        int r15 = r11 + 1;
        ConstraintWidget r16 = r29[r14];
        int r17 = getWidgetWidth(r16, r32);
        if (r16.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L12;
        r12 = r12 + 1;
    L12:
        int r18 = r12;
        if (r13 == r32) goto L17;
        if (((this.mHorizontalGap + r13) + r17) > r32) goto L17;
    L19:
        boolean r19 = false;
    L20:
        if (r19 == true) goto L26;
        if (r14 <= 0) goto L26;
        int r20 = this.mMaxElementsWrap;
        if (r20 <= 0) goto L26;
        if (r15 <= r20) goto L26;
        r19 = true;
    L26:
        if (r19 == false) goto L28;
        r10 = new WidgetsList(this, r31, this.mLeft, this.mTop, this.mRight, this.mBottom, r32);
        r10.setStartIndex(r14);
        this.mChainList.add(r10);
        r11 = r15;
        r13 = r17;
    L32:
        r10.add(r16);
        r14 = r14 + 1;
        r12 = r18;
        goto L8
    L28:
        if (r14 <= 0) goto L30;
        r13 = r13 + (this.mHorizontalGap + r17);
    L31:
        r11 = 0;
        goto L32
    L30:
        r13 = r17;
    L17:
        if (WidgetsList.access$2000(r10) == null) goto L19;
        r19 = true;
    L58:
        int r21 = this.mChainList.size();
        ConstraintAnchor r22 = this.mLeft;
        ConstraintAnchor r23 = this.mTop;
        ConstraintAnchor r24 = this.mRight;
        ConstraintAnchor r25 = this.mBottom;
        int r26 = getPaddingLeft();
        int r27 = getPaddingTop();
        int r28 = getPaddingRight();
        int r110 = getPaddingBottom();
        ConstraintWidget.DimensionBehaviour r111 = getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r112 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r111 != r112) goto L61;
    L64:
        boolean r113 = true;
    L65:
        if (r12 <= 0) goto L74;
        if (r113 == false) goto L74;
        int r34 = 0;
    L68:
        if (r34 >= r21) goto L74;
        WidgetsList r114 = this.mChainList.get(r34);
        if (r31 != 0) goto L72;
        int r115 = r114.getWidth();
    L73:
        r114.measureMatchConstraints(r32 - r115);
        r34 = r34 + 1;
        goto L68
    L72:
        r115 = r114.getHeight();
    L74:
        int r210 = r27;
        int r35 = r28;
        int r116 = 0;
        int r117 = 0;
        int r118 = 0;
        int r36 = r26;
        ConstraintAnchor r37 = r23;
        ConstraintAnchor r38 = r22;
        int r39 = r110;
    L75:
        if (r118 >= r21) goto L95;
        WidgetsList r211 = this.mChainList.get(r118);
        if (r31 == 0) goto L79;
        ConstraintAnchor r212 = r38;
        int r40 = r116;
        int r41 = r117;
        int r42 = r118;
        if (r42 >= (r21 - 1)) goto L89;
        ConstraintAnchor r213 = WidgetsList.access$2000(this.mChainList.get(r42 + 1)).mLeft;
        int r214 = 0;
    L90:
        ConstraintAnchor r119 = WidgetsList.access$2000(r211).mRight;
        r211.setup(r31, r212, r37, r213, r25, r36, r210, r214, r39, r32);
        r117 = r41 + r211.getWidth();
        int r43 = Math.max(r40, r211.getHeight());
        if (r42 <= 0) goto L93;
        r117 = r117 + this.mHorizontalGap;
    L93:
        r116 = r43;
        r36 = 0;
        r35 = r214;
        r38 = r119;
    L94:
        r118 = r42 + 1;
        r24 = r213;
        goto L75
    L89:
        r213 = this.mRight;
        r214 = getPaddingRight();
        goto L90
    L79:
        if (r118 >= (r21 - 1)) goto L81;
        ConstraintAnchor r44 = WidgetsList.access$2000(this.mChainList.get(r118 + 1)).mTop;
        int r45 = 0;
    L82:
        ConstraintAnchor r120 = WidgetsList.access$2000(r211).mBottom;
        ConstraintAnchor r121 = r38;
        ConstraintAnchor r215 = r38;
        int r46 = r116;
        ConstraintAnchor r122 = r37;
        int r47 = r117;
        ConstraintAnchor r123 = r24;
        ConstraintAnchor r310 = r24;
        r42 = r118;
        r211.setup(r31, r121, r122, r123, r44, r36, r210, r35, r45, r32);
        int r48 = Math.max(r47, r211.getWidth());
        r116 = r46 + r211.getHeight();
        if (r42 <= 0) goto L85;
        r116 = r116 + this.mVerticalGap;
    L85:
        r38 = r215;
        r117 = r48;
        r210 = 0;
        r37 = r120;
        r213 = r310;
        int r216 = r45;
        r25 = r44;
        r39 = r216;
        goto L94
    L81:
        r44 = this.mBottom;
        r45 = getPaddingBottom();
        goto L82
    L95:
        r33[0] = r117;
        r33[1] = r116;
        return;
    L61:
        if (getVerticalDimensionBehaviour() == r112) goto L64;
        r113 = false;
        goto L65
    L33:
        int r124 = 0;
    L34:
        if (r124 >= r30) goto L58;
        ConstraintWidget r125 = r29[r124];
        int r126 = getWidgetHeight(r125, r32);
        if (r125.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L38;
        r12 = r12 + 1;
    L38:
        int r127 = r12;
        if (r11 == r32) goto L43;
        if (((this.mVerticalGap + r11) + r126) > r32) goto L43;
    L45:
        boolean r49 = false;
    L46:
        if (r49 == true) goto L52;
        if (r124 <= 0) goto L52;
        int r50 = this.mMaxElementsWrap;
        if (r50 <= 0) goto L52;
        if (r50 >= 0) goto L52;
        r49 = true;
    L52:
        if (r49 == false) goto L55;
        r10 = new WidgetsList(this, r31, this.mLeft, this.mTop, this.mRight, this.mBottom, r32);
        r10.setStartIndex(r124);
        this.mChainList.add(r10);
    L54:
        r11 = r126;
    L57:
        r10.add(r125);
        r124 = r124 + 1;
        r12 = r127;
        goto L34
    L55:
        if (r124 <= 0) goto L54;
        r11 = r11 + (this.mVerticalGap + r126);
    L43:
        if (WidgetsList.access$2000(r10) == null) goto L45;
        r49 = true;
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
        int r10 = 0;
    L10:
        if (r10 >= r24) goto L12;
        r11.add(r23[r10]);
        r10 = r10 + 1;
        goto L10
    L12:
        r27[0] = r11.getWidth();
        r27[1] = r11.getHeight();
        return;
    L8:
        WidgetsList r12 = this.mChainList.get(0);
        r12.clear();
        r11 = r12;
        r11.setup(r25, this.mLeft, this.mTop, this.mRight, this.mBottom, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), r26);
        goto L9
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem r10, boolean r11) {
        super.addToSolver(r10, r11);
        if (getParent() != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        int r13 = this.mWrapMode;
        if (r13 == 0) goto L32;
        if (r13 != 1) goto L12;
        int r14 = this.mChainList.size();
        int r15 = 0;
    L25:
        if (r15 >= r14) goto L34;
        WidgetsList r16 = this.mChainList.get(r15);
        if (r15 != (r14 - 1)) goto L29;
        boolean r17 = true;
    L30:
        r16.createConstraints(r12, r15, r17);
        r15 = r15 + 1;
        goto L25
    L29:
        r17 = false;
    L34:
        needsCallbackFromSolver(false);
        return;
    L12:
        if (r13 != 2) goto L14;
        createAlignedConstraints(r12);
        goto L34
    L14:
        if (r13 != 3) goto L34;
        int r18 = this.mChainList.size();
        int r19 = 0;
    L17:
        if (r19 >= r18) goto L34;
        WidgetsList r20 = this.mChainList.get(r19);
        if (r19 != (r18 - 1)) goto L21;
        boolean r21 = true;
    L22:
        r20.createConstraints(r12, r19, r21);
        r19 = r19 + 1;
        goto L17
    L21:
        r21 = false;
        goto L22
    L32:
        if (this.mChainList.size() <= 0) goto L34;
        this.mChainList.get(0).createConstraints(r12, 0, true);
        goto L34
    L5:
        if (((ConstraintWidgetContainer) getParent()).isRtl() == false) goto L7;
        r12 = true;
        goto L8
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void copy(ConstraintWidget r10, HashMap<ConstraintWidget, ConstraintWidget> r11) {
        super.copy(r10, r11);
        Flow r12 = (Flow) r10;
        this.mHorizontalStyle = r12.mHorizontalStyle;
        this.mVerticalStyle = r12.mVerticalStyle;
        this.mFirstHorizontalStyle = r12.mFirstHorizontalStyle;
        this.mFirstVerticalStyle = r12.mFirstVerticalStyle;
        this.mLastHorizontalStyle = r12.mLastHorizontalStyle;
        this.mLastVerticalStyle = r12.mLastVerticalStyle;
        this.mHorizontalBias = r12.mHorizontalBias;
        this.mVerticalBias = r12.mVerticalBias;
        this.mFirstHorizontalBias = r12.mFirstHorizontalBias;
        this.mFirstVerticalBias = r12.mFirstVerticalBias;
        this.mLastHorizontalBias = r12.mLastHorizontalBias;
        this.mLastVerticalBias = r12.mLastVerticalBias;
        this.mHorizontalGap = r12.mHorizontalGap;
        this.mVerticalGap = r12.mVerticalGap;
        this.mHorizontalAlign = r12.mHorizontalAlign;
        this.mVerticalAlign = r12.mVerticalAlign;
        this.mWrapMode = r12.mWrapMode;
        this.mMaxElementsWrap = r12.mMaxElementsWrap;
        this.mOrientation = r12.mOrientation;
    }

    public float getMaxElementsWrap() {
        return this.mMaxElementsWrap;
    }

    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public void measure(int r19, int r20, int r21, int r22) {
        if (this.mWidgetsCount > 0) goto L5;
    L8:
        int r12 = getPaddingLeft();
        int r13 = getPaddingRight();
        int r14 = getPaddingTop();
        int r15 = getPaddingBottom();
        int[] r10 = new int[2];
        int r11 = (r20 - r12) - r13;
        int r16 = this.mOrientation;
        if (r16 != 1) goto L11;
        r11 = (r22 - r14) - r15;
    L11:
        int r17 = r11;
        if (r16 != 0) goto L20;
        if (this.mHorizontalStyle != (-1)) goto L17;
        this.mHorizontalStyle = 0;
    L17:
        if (this.mVerticalStyle == (-1)) goto L24;
    L25:
        ConstraintWidget[] r18 = this.mWidgets;
        int r23 = 0;
        int r24 = 0;
    L26:
        int r110 = this.mWidgetsCount;
        if (r23 >= r110) goto L32;
        if (this.mWidgets[r23].getVisibility() != 8) goto L31;
        r24 = r24 + 1;
    L31:
        r23 = r23 + 1;
        goto L26
    L32:
        if (r24 <= 0) goto L41;
        r18 = new ConstraintWidget[r110 - r24];
        int r25 = 0;
        int r26 = 0;
    L35:
        if (r25 >= this.mWidgetsCount) goto L40;
        ConstraintWidget r111 = this.mWidgets[r25];
        if (r111.getVisibility() == 8) goto L39;
        r18[r26] = r111;
        r26 = r26 + 1;
    L39:
        r25 = r25 + 1;
        goto L35
    L40:
        int r27 = r26;
    L42:
        this.mDisplayedWidgets = r18;
        this.mDisplayedWidgetsCount = r27;
        int r28 = this.mWrapMode;
        if (r28 != 0) goto L45;
        boolean r112 = true;
        measureNoWrap(r18, r27, this.mOrientation, r17, r10);
    L56:
        int r29 = (r10[0] + r12) + r13;
        int r30 = (r10[r112 ? 1 : 0] + r14) + r15;
        if (r19 != 1073741824) goto L59;
        r29 = r20;
    L64:
        if (r21 != 1073741824) goto L66;
        r30 = r22;
    L71:
        setMeasure(r29, r30);
        setWidth(r29);
        setHeight(r30);
        if (this.mWidgetsCount > 0) goto L75;
        r112 = false;
    L75:
        needsCallbackFromSolver(r112);
        return;
    L66:
        if (r21 != Integer.MIN_VALUE) goto L68;
        r30 = Math.min(r30, r22);
        goto L71
    L68:
        if (r21 == 0) goto L71;
        r30 = 0;
        goto L71
    L59:
        if (r19 != Integer.MIN_VALUE) goto L61;
        r29 = Math.min(r29, r20);
        goto L64
    L61:
        if (r19 == 0) goto L64;
        r29 = 0;
        goto L64
    L45:
        if (r28 != 1) goto L47;
        r112 = true;
        measureChainWrap(r18, r27, this.mOrientation, r17, r10);
        goto L56
    L47:
        if (r28 != 2) goto L49;
        r112 = true;
        measureAligned(r18, r27, this.mOrientation, r17, r10);
        goto L56
    L49:
        if (r28 == 3) goto L52;
        r112 = true;
        goto L56
    L52:
        r112 = true;
        measureChainWrap_new(r18, r27, this.mOrientation, r17, r10);
        goto L56
    L41:
        r27 = r110;
    L24:
        this.mVerticalStyle = 0;
        goto L25
    L20:
        if (this.mHorizontalStyle != (-1)) goto L23;
        this.mHorizontalStyle = 0;
    L23:
        if (this.mVerticalStyle != (-1)) goto L25;
    L5:
        if (measureChildren() == true) goto L8;
        setMeasure(0, 0);
        needsCallbackFromSolver(false);
    }

    public void setFirstHorizontalBias(float r10) {
        this.mFirstHorizontalBias = r10;
    }

    public void setFirstHorizontalStyle(int r10) {
        this.mFirstHorizontalStyle = r10;
    }

    public void setFirstVerticalBias(float r10) {
        this.mFirstVerticalBias = r10;
    }

    public void setFirstVerticalStyle(int r10) {
        this.mFirstVerticalStyle = r10;
    }

    public void setHorizontalAlign(int r10) {
        this.mHorizontalAlign = r10;
    }

    public void setHorizontalBias(float r10) {
        this.mHorizontalBias = r10;
    }

    public void setHorizontalGap(int r10) {
        this.mHorizontalGap = r10;
    }

    public void setHorizontalStyle(int r10) {
        this.mHorizontalStyle = r10;
    }

    public void setLastHorizontalBias(float r10) {
        this.mLastHorizontalBias = r10;
    }

    public void setLastHorizontalStyle(int r10) {
        this.mLastHorizontalStyle = r10;
    }

    public void setLastVerticalBias(float r10) {
        this.mLastVerticalBias = r10;
    }

    public void setLastVerticalStyle(int r10) {
        this.mLastVerticalStyle = r10;
    }

    public void setMaxElementsWrap(int r10) {
        this.mMaxElementsWrap = r10;
    }

    public void setOrientation(int r10) {
        this.mOrientation = r10;
    }

    public void setVerticalAlign(int r10) {
        this.mVerticalAlign = r10;
    }

    public void setVerticalBias(float r10) {
        this.mVerticalBias = r10;
    }

    public void setVerticalGap(int r10) {
        this.mVerticalGap = r10;
    }

    public void setVerticalStyle(int r10) {
        this.mVerticalStyle = r10;
    }

    public void setWrapMode(int r10) {
        this.mWrapMode = r10;
    }
}
