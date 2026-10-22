package androidx.constraintlayout.widget;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.apm6.util.constant.CommonConsts;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintProperties {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int END = 7;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int WRAP_CONTENT = -2;
    ConstraintLayout.LayoutParams mParams;
    View mView;

    public ConstraintProperties(View r10) {
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof ConstraintLayout.LayoutParams) == false) goto L7;
        this.mParams = (ConstraintLayout.LayoutParams) r11;
        this.mView = r10;
        return;
    L7:
        throw new RuntimeException("Only children of ConstraintLayout.LayoutParams supported");
    }

    private String sideToString(int r10) {
        switch(r10) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L3;
        };
    L3:
        return "undefined";
    L5:
        return "end";
    L7:
        return CommonConsts.APM_INNER_EVENT_COST_START;
    L9:
        return "baseline";
    L11:
        return "bottom";
    L13:
        return "top";
    L15:
        return "right";
    L17:
        return "left";
    }

    public ConstraintProperties addToHorizontalChain(int r10, int r11) {
        if (r10 != 0) goto L5;
        int r12 = 1;
    L6:
        connect(1, r10, r12, 0);
        if (r11 != 0) goto L9;
        int r13 = 2;
    L10:
        connect(2, r11, r13, 0);
        if (r10 == 0) goto L13;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r10)).connect(2, this.mView.getId(), 1, 0);
    L13:
        if (r11 == 0) goto L15;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r11)).connect(1, this.mView.getId(), 2, 0);
    L15:
        return this;
    L9:
        r13 = 1;
        goto L10
    L5:
        r12 = 2;
        goto L6
    }

    public ConstraintProperties addToHorizontalChainRTL(int r10, int r11) {
        if (r10 != 0) goto L5;
        int r12 = 6;
    L6:
        connect(6, r10, r12, 0);
        if (r11 != 0) goto L9;
        int r13 = 7;
    L10:
        connect(7, r11, r13, 0);
        if (r10 == 0) goto L13;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r10)).connect(7, this.mView.getId(), 6, 0);
    L13:
        if (r11 == 0) goto L15;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r11)).connect(6, this.mView.getId(), 7, 0);
    L15:
        return this;
    L9:
        r13 = 6;
        goto L10
    L5:
        r12 = 7;
        goto L6
    }

    public ConstraintProperties addToVerticalChain(int r10, int r11) {
        if (r10 != 0) goto L5;
        int r12 = 3;
    L6:
        connect(3, r10, r12, 0);
        if (r11 != 0) goto L9;
        int r13 = 4;
    L10:
        connect(4, r11, r13, 0);
        if (r10 == 0) goto L13;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r10)).connect(4, this.mView.getId(), 3, 0);
    L13:
        if (r11 == 0) goto L15;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r11)).connect(3, this.mView.getId(), 4, 0);
    L15:
        return this;
    L9:
        r13 = 3;
        goto L10
    L5:
        r12 = 4;
        goto L6
    }

    public ConstraintProperties alpha(float r10) {
        this.mView.setAlpha(r10);
        return this;
    }

    public void apply() {
    }

    public ConstraintProperties center(int r10, int r11, int r12, int r13, int r14, int r15, float r16) {
        if (r12 < 0) goto L25;
        if (r15 < 0) goto L23;
        if (r16 <= 0.0f) goto L21;
        if (r16 > 1.0f) goto L21;
        int r17 = 2;
        int r18 = 1;
        if (r11 == 1) goto L18;
        if (r11 == 2) goto L18;
        r17 = 7;
        r18 = 6;
        if (r11 == 6) goto L18;
        if (r11 == 7) goto L18;
        connect(3, r10, r11, r12);
        connect(4, r13, r14, r15);
        this.mParams.verticalBias = r16;
    L19:
        return this;
    L18:
        connect(r18, r10, r11, r12);
        connect(r17, r13, r14, r15);
        this.mParams.horizontalBias = r16;
    L21:
        throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
    L23:
        throw new IllegalArgumentException("margin must be > 0");
    L25:
        throw new IllegalArgumentException("margin must be > 0");
    }

    public ConstraintProperties centerHorizontally(int r10) {
        if (r10 != 0) goto L4;
        int r11 = 0;
        int r12 = 1;
        int r13 = 0;
        int r14 = 0;
        int r15 = 2;
        int r16 = 0;
        float r17 = 0.5f;
    L5:
        center(r11, r12, r13, r14, r15, r16, r17);
        return this;
    L4:
        r12 = 2;
        r13 = 0;
        r15 = 1;
        r16 = 0;
        r17 = 0.5f;
        r11 = r10;
        r14 = r10;
        goto L5
    }

    public ConstraintProperties centerHorizontally(int r10, int r11, int r12, int r13, int r14, int r15, float r16) {
        connect(1, r10, r11, r12);
        connect(2, r13, r14, r15);
        this.mParams.horizontalBias = r16;
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int r10) {
        if (r10 != 0) goto L4;
        int r11 = 0;
        int r12 = 6;
        int r13 = 0;
        int r14 = 0;
        int r15 = 7;
        int r16 = 0;
        float r17 = 0.5f;
    L5:
        center(r11, r12, r13, r14, r15, r16, r17);
        return this;
    L4:
        r12 = 7;
        r13 = 0;
        r15 = 6;
        r16 = 0;
        r17 = 0.5f;
        r11 = r10;
        r14 = r10;
        goto L5
    }

    public ConstraintProperties centerHorizontallyRtl(int r10, int r11, int r12, int r13, int r14, int r15, float r16) {
        connect(6, r10, r11, r12);
        connect(7, r13, r14, r15);
        this.mParams.horizontalBias = r16;
        return this;
    }

    public ConstraintProperties centerVertically(int r10) {
        if (r10 != 0) goto L4;
        int r11 = 0;
        int r12 = 3;
        int r13 = 0;
        int r14 = 0;
        int r15 = 4;
        int r16 = 0;
        float r17 = 0.5f;
    L5:
        center(r11, r12, r13, r14, r15, r16, r17);
        return this;
    L4:
        r12 = 4;
        r13 = 0;
        r15 = 3;
        r16 = 0;
        r17 = 0.5f;
        r11 = r10;
        r14 = r10;
        goto L5
    }

    public ConstraintProperties centerVertically(int r10, int r11, int r12, int r13, int r14, int r15, float r16) {
        connect(3, r10, r11, r12);
        connect(4, r13, r14, r15);
        this.mParams.verticalBias = r16;
        return this;
    }

    public ConstraintProperties connect(int r11, int r12, int r13, int r14) {
        switch(r11) {
            case 1: goto L58;
            case 2: goto L51;
            case 3: goto L43;
            case 4: goto L35;
            case 5: goto L25;
            case 6: goto L15;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        if (r13 != 7) goto L8;
        ConstraintLayout.LayoutParams r15 = this.mParams;
        r15.endToEnd = r12;
        r15.endToStart = -1;
    L11:
        if (Build.VERSION.SDK_INT < 17) goto L63;
        this.mParams.setMarginEnd(r14);
    L63:
        return this;
    L8:
        if (r13 != 6) goto L14;
        ConstraintLayout.LayoutParams r16 = this.mParams;
        r16.endToStart = r12;
        r16.endToEnd = -1;
        goto L11
    L14:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L15:
        if (r13 != 6) goto L17;
        ConstraintLayout.LayoutParams r17 = this.mParams;
        r17.startToStart = r12;
        r17.startToEnd = -1;
    L20:
        if (Build.VERSION.SDK_INT < 17) goto L63;
        this.mParams.setMarginStart(r14);
        goto L63
    L17:
        if (r13 != 7) goto L23;
        ConstraintLayout.LayoutParams r18 = this.mParams;
        r18.startToEnd = r12;
        r18.startToStart = -1;
        goto L20
    L23:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L35:
        if (r13 != 4) goto L38;
        ConstraintLayout.LayoutParams r19 = this.mParams;
        r19.bottomToBottom = r12;
        r19.bottomToTop = -1;
    L37:
        r19.baselineToBaseline = -1;
        r19.baselineToTop = -1;
        r19.baselineToBottom = -1;
        ((ViewGroup.MarginLayoutParams) this.mParams).bottomMargin = r14;
        goto L63
    L38:
        if (r13 != 3) goto L42;
        r19 = this.mParams;
        r19.bottomToTop = r12;
        r19.bottomToBottom = -1;
        goto L37
    L42:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L43:
        if (r13 != 3) goto L46;
        ConstraintLayout.LayoutParams r110 = this.mParams;
        r110.topToTop = r12;
        r110.topToBottom = -1;
    L45:
        r110.baselineToBaseline = -1;
        r110.baselineToTop = -1;
        r110.baselineToBottom = -1;
        ((ViewGroup.MarginLayoutParams) this.mParams).topMargin = r14;
        goto L63
    L46:
        if (r13 != 4) goto L50;
        r110 = this.mParams;
        r110.topToBottom = r12;
        r110.topToTop = -1;
        goto L45
    L50:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L51:
        if (r13 != 1) goto L53;
        ConstraintLayout.LayoutParams r111 = this.mParams;
        r111.rightToLeft = r12;
        r111.rightToRight = -1;
    L55:
        ((ViewGroup.MarginLayoutParams) this.mParams).rightMargin = r14;
        goto L63
    L53:
        if (r13 != 2) goto L57;
        ConstraintLayout.LayoutParams r112 = this.mParams;
        r112.rightToRight = r12;
        r112.rightToLeft = -1;
        goto L55
    L57:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L58:
        if (r13 != 1) goto L60;
        ConstraintLayout.LayoutParams r113 = this.mParams;
        r113.leftToLeft = r12;
        r113.leftToRight = -1;
    L62:
        ((ViewGroup.MarginLayoutParams) this.mParams).leftMargin = r14;
        goto L63
    L60:
        if (r13 != 2) goto L65;
        ConstraintLayout.LayoutParams r114 = this.mParams;
        r114.leftToRight = r12;
        r114.leftToLeft = -1;
        goto L62
    L65:
        throw new IllegalArgumentException("Left to " + sideToString(r13) + " undefined");
    L5:
        throw new IllegalArgumentException(sideToString(r11) + " to " + sideToString(r13) + " unknown");
    L25:
        if (r13 != 5) goto L27;
        ConstraintLayout.LayoutParams r115 = this.mParams;
        r115.baselineToBaseline = r12;
        r115.bottomToBottom = -1;
        r115.bottomToTop = -1;
        r115.topToTop = -1;
        r115.topToBottom = -1;
    L27:
        if (r13 != 3) goto L30;
        ConstraintLayout.LayoutParams r116 = this.mParams;
        r116.baselineToTop = r12;
    L29:
        r116.bottomToBottom = -1;
        r116.bottomToTop = -1;
        r116.topToTop = -1;
        r116.topToBottom = -1;
        this.mParams.baselineMargin = r14;
        goto L63
    L30:
        if (r13 != 4) goto L34;
        r116 = this.mParams;
        r116.baselineToBottom = r12;
        goto L29
    L34:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    }

    public ConstraintProperties constrainDefaultHeight(int r10) {
        this.mParams.matchConstraintDefaultHeight = r10;
        return this;
    }

    public ConstraintProperties constrainDefaultWidth(int r10) {
        this.mParams.matchConstraintDefaultWidth = r10;
        return this;
    }

    public ConstraintProperties constrainHeight(int r10) {
        ((ViewGroup.MarginLayoutParams) this.mParams).height = r10;
        return this;
    }

    public ConstraintProperties constrainMaxHeight(int r10) {
        this.mParams.matchConstraintMaxHeight = r10;
        return this;
    }

    public ConstraintProperties constrainMaxWidth(int r10) {
        this.mParams.matchConstraintMaxWidth = r10;
        return this;
    }

    public ConstraintProperties constrainMinHeight(int r10) {
        this.mParams.matchConstraintMinHeight = r10;
        return this;
    }

    public ConstraintProperties constrainMinWidth(int r10) {
        this.mParams.matchConstraintMinWidth = r10;
        return this;
    }

    public ConstraintProperties constrainWidth(int r10) {
        ((ViewGroup.MarginLayoutParams) this.mParams).width = r10;
        return this;
    }

    public ConstraintProperties dimensionRatio(String r10) {
        this.mParams.dimensionRatio = r10;
        return this;
    }

    public ConstraintProperties elevation(float r10) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        this.mView.setElevation(r10);
    L5:
        return this;
    }

    public ConstraintProperties goneMargin(int r10, int r11) {
        switch(r10) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L5:
        this.mParams.goneEndMargin = r11;
    L13:
        return this;
    L6:
        this.mParams.goneStartMargin = r11;
        goto L13
    L9:
        this.mParams.goneBottomMargin = r11;
        goto L13
    L10:
        this.mParams.goneTopMargin = r11;
        goto L13
    L11:
        this.mParams.goneRightMargin = r11;
        goto L13
    L12:
        this.mParams.goneLeftMargin = r11;
        goto L13
    L4:
        throw new IllegalArgumentException("unknown constraint");
    L8:
        throw new IllegalArgumentException("baseline does not support margins");
    }

    public ConstraintProperties horizontalBias(float r10) {
        this.mParams.horizontalBias = r10;
        return this;
    }

    public ConstraintProperties horizontalChainStyle(int r10) {
        this.mParams.horizontalChainStyle = r10;
        return this;
    }

    public ConstraintProperties horizontalWeight(float r10) {
        this.mParams.horizontalWeight = r10;
        return this;
    }

    public ConstraintProperties margin(int r10, int r11) {
        switch(r10) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L5:
        this.mParams.setMarginEnd(r11);
    L13:
        return this;
    L6:
        this.mParams.setMarginStart(r11);
        goto L13
    L9:
        ((ViewGroup.MarginLayoutParams) this.mParams).bottomMargin = r11;
        goto L13
    L10:
        ((ViewGroup.MarginLayoutParams) this.mParams).topMargin = r11;
        goto L13
    L11:
        ((ViewGroup.MarginLayoutParams) this.mParams).rightMargin = r11;
        goto L13
    L12:
        ((ViewGroup.MarginLayoutParams) this.mParams).leftMargin = r11;
        goto L13
    L4:
        throw new IllegalArgumentException("unknown constraint");
    L8:
        throw new IllegalArgumentException("baseline does not support margins");
    }

    public ConstraintProperties removeConstraints(int r10) {
        switch(r10) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        ConstraintLayout.LayoutParams r11 = this.mParams;
        r11.endToStart = -1;
        r11.endToEnd = -1;
        r11.setMarginEnd(-1);
        this.mParams.goneEndMargin = Integer.MIN_VALUE;
    L13:
        return this;
    L7:
        ConstraintLayout.LayoutParams r12 = this.mParams;
        r12.startToEnd = -1;
        r12.startToStart = -1;
        r12.setMarginStart(-1);
        this.mParams.goneStartMargin = Integer.MIN_VALUE;
        goto L13
    L8:
        this.mParams.baselineToBaseline = -1;
        goto L13
    L9:
        ConstraintLayout.LayoutParams r13 = this.mParams;
        r13.bottomToTop = -1;
        r13.bottomToBottom = -1;
        ((ViewGroup.MarginLayoutParams) r13).bottomMargin = -1;
        r13.goneBottomMargin = Integer.MIN_VALUE;
        goto L13
    L10:
        ConstraintLayout.LayoutParams r14 = this.mParams;
        r14.topToBottom = -1;
        r14.topToTop = -1;
        ((ViewGroup.MarginLayoutParams) r14).topMargin = -1;
        r14.goneTopMargin = Integer.MIN_VALUE;
        goto L13
    L11:
        ConstraintLayout.LayoutParams r15 = this.mParams;
        r15.rightToRight = -1;
        r15.rightToLeft = -1;
        ((ViewGroup.MarginLayoutParams) r15).rightMargin = -1;
        r15.goneRightMargin = Integer.MIN_VALUE;
        goto L13
    L12:
        ConstraintLayout.LayoutParams r16 = this.mParams;
        r16.leftToRight = -1;
        r16.leftToLeft = -1;
        ((ViewGroup.MarginLayoutParams) r16).leftMargin = -1;
        r16.goneLeftMargin = Integer.MIN_VALUE;
        goto L13
    L5:
        throw new IllegalArgumentException("unknown constraint");
    }

    public ConstraintProperties removeFromHorizontalChain() {
        ConstraintLayout.LayoutParams r10 = this.mParams;
        int r11 = r10.leftToRight;
        int r12 = r10.rightToLeft;
        if (r11 != (-1)) goto L22;
        if (r12 != (-1)) goto L22;
        int r13 = r10.startToEnd;
        int r14 = r10.endToStart;
        if (r13 != (-1)) goto L9;
        if (r14 != (-1)) goto L9;
    L21:
        removeConstraints(6);
        removeConstraints(7);
    L35:
        return this;
    L9:
        ConstraintProperties r15 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r13));
        ConstraintProperties r16 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r14));
        ConstraintLayout.LayoutParams r17 = this.mParams;
        if (r13 == (-1)) goto L13;
        if (r14 == (-1)) goto L13;
        r15.connect(7, r14, 6, 0);
        r16.connect(6, r11, 7, 0);
    L13:
        if (r11 != (-1)) goto L15;
        if (r14 == (-1)) goto L21;
    L15:
        int r18 = r17.rightToRight;
        if (r18 == (-1)) goto L18;
        r15.connect(7, r18, 7, 0);
        goto L21
    L18:
        int r19 = r17.leftToLeft;
        if (r19 == (-1)) goto L21;
        r16.connect(6, r19, 6, 0);
    L22:
        ConstraintProperties r20 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r11));
        ConstraintProperties r21 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r12));
        ConstraintLayout.LayoutParams r22 = this.mParams;
        if (r11 == (-1)) goto L26;
        if (r12 == (-1)) goto L26;
        r20.connect(2, r12, 1, 0);
        r21.connect(1, r11, 2, 0);
    L34:
        removeConstraints(1);
        removeConstraints(2);
    L26:
        if (r11 != (-1)) goto L28;
        if (r12 == (-1)) goto L34;
    L28:
        int r23 = r22.rightToRight;
        if (r23 == (-1)) goto L31;
        r20.connect(2, r23, 2, 0);
        goto L34
    L31:
        int r24 = r22.leftToLeft;
        if (r24 == (-1)) goto L34;
        r21.connect(1, r24, 1, 0);
        goto L34
    }

    public ConstraintProperties removeFromVerticalChain() {
        ConstraintLayout.LayoutParams r10 = this.mParams;
        int r11 = r10.topToBottom;
        int r12 = r10.bottomToTop;
        if (r11 != (-1)) goto L5;
        if (r12 != (-1)) goto L5;
    L17:
        removeConstraints(3);
        removeConstraints(4);
        return this;
    L5:
        ConstraintProperties r13 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r11));
        ConstraintProperties r14 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r12));
        ConstraintLayout.LayoutParams r15 = this.mParams;
        if (r11 == (-1)) goto L9;
        if (r12 == (-1)) goto L9;
        r13.connect(4, r12, 3, 0);
        r14.connect(3, r11, 4, 0);
    L9:
        if (r11 != (-1)) goto L11;
        if (r12 == (-1)) goto L17;
    L11:
        int r16 = r15.bottomToBottom;
        if (r16 == (-1)) goto L14;
        r13.connect(4, r16, 4, 0);
        goto L17
    L14:
        int r17 = r15.topToTop;
        if (r17 == (-1)) goto L17;
        r14.connect(3, r17, 3, 0);
        goto L17
    }

    public ConstraintProperties rotation(float r10) {
        this.mView.setRotation(r10);
        return this;
    }

    public ConstraintProperties rotationX(float r10) {
        this.mView.setRotationX(r10);
        return this;
    }

    public ConstraintProperties rotationY(float r10) {
        this.mView.setRotationY(r10);
        return this;
    }

    public ConstraintProperties scaleX(float r10) {
        this.mView.setScaleY(r10);
        return this;
    }

    public ConstraintProperties scaleY(float r10) {
        return this;
    }

    public ConstraintProperties transformPivot(float r10, float r11) {
        this.mView.setPivotX(r10);
        this.mView.setPivotY(r11);
        return this;
    }

    public ConstraintProperties transformPivotX(float r10) {
        this.mView.setPivotX(r10);
        return this;
    }

    public ConstraintProperties transformPivotY(float r10) {
        this.mView.setPivotY(r10);
        return this;
    }

    public ConstraintProperties translation(float r10, float r11) {
        this.mView.setTranslationX(r10);
        this.mView.setTranslationY(r11);
        return this;
    }

    public ConstraintProperties translationX(float r10) {
        this.mView.setTranslationX(r10);
        return this;
    }

    public ConstraintProperties translationY(float r10) {
        this.mView.setTranslationY(r10);
        return this;
    }

    public ConstraintProperties translationZ(float r10) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        this.mView.setTranslationZ(r10);
    L5:
        return this;
    }

    public ConstraintProperties verticalBias(float r10) {
        this.mParams.verticalBias = r10;
        return this;
    }

    public ConstraintProperties verticalChainStyle(int r10) {
        this.mParams.verticalChainStyle = r10;
        return this;
    }

    public ConstraintProperties verticalWeight(float r10) {
        this.mParams.verticalWeight = r10;
        return this;
    }

    public ConstraintProperties visibility(int r10) {
        this.mView.setVisibility(r10);
        return this;
    }
}
