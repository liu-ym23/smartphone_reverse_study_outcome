package androidx.constraintlayout.widget;

import ai.j0;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;

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

    public ConstraintProperties(View r5) {
        ViewGroup.LayoutParams r10 = r5.getLayoutParams();
        if ((r10 instanceof ConstraintLayout.LayoutParams) == false) goto L7;
        this.mParams = (ConstraintLayout.LayoutParams) r10;
        this.mView = r5;
        return;
    L7:
        throw new RuntimeException("Only children of ConstraintLayout.LayoutParams supported");
    }

    private String sideToString(int r5) {
        switch(r5) {
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
        return "start";
    L9:
        return "baseline";
    L11:
        return "bottom";
    L13:
        return "top";
    L15:
        return "right";
    L17:
        return OpenPageMethod.ALIGN_LEFT;
    }

    public ConstraintProperties addToHorizontalChain(int r5, int r10) {
        if (r5 != 0) goto L5;
        int r11 = 1;
    L6:
        connect(1, r5, r11, 0);
        if (r10 != 0) goto L9;
        int r12 = 2;
    L10:
        connect(2, r10, r12, 0);
        if (r5 == 0) goto L13;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r5)).connect(2, this.mView.getId(), 1, 0);
    L13:
        if (r10 == 0) goto L15;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r10)).connect(1, this.mView.getId(), 2, 0);
    L15:
        return this;
    L9:
        r12 = 1;
        goto L10
    L5:
        r11 = 2;
        goto L6
    }

    public ConstraintProperties addToHorizontalChainRTL(int r5, int r10) {
        if (r5 != 0) goto L5;
        int r11 = 6;
    L6:
        connect(6, r5, r11, 0);
        if (r10 != 0) goto L9;
        int r12 = 7;
    L10:
        connect(7, r10, r12, 0);
        if (r5 == 0) goto L13;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r5)).connect(7, this.mView.getId(), 6, 0);
    L13:
        if (r10 == 0) goto L15;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r10)).connect(6, this.mView.getId(), 7, 0);
    L15:
        return this;
    L9:
        r12 = 6;
        goto L10
    L5:
        r11 = 7;
        goto L6
    }

    public ConstraintProperties addToVerticalChain(int r5, int r10) {
        if (r5 != 0) goto L5;
        int r11 = 3;
    L6:
        connect(3, r5, r11, 0);
        if (r10 != 0) goto L9;
        int r12 = 4;
    L10:
        connect(4, r10, r12, 0);
        if (r5 == 0) goto L13;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r5)).connect(4, this.mView.getId(), 3, 0);
    L13:
        if (r10 == 0) goto L15;
        new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r10)).connect(3, this.mView.getId(), 4, 0);
    L15:
        return this;
    L9:
        r12 = 3;
        goto L10
    L5:
        r11 = 4;
        goto L6
    }

    public ConstraintProperties alpha(float r5) {
        this.mView.setAlpha(r5);
        return this;
    }

    public void apply() {
    }

    public ConstraintProperties center(int r5, int r10, int r11, int r12, int r13, int r14, float r15) {
        if (r11 < 0) goto L26;
        if (r14 < 0) goto L24;
        if (r15 <= 0.0f) goto L22;
        if (r15 > 1.0f) goto L22;
        if (r10 == 1) goto L19;
        if (r10 == 2) goto L19;
        if (r10 == 6) goto L18;
        if (r10 == 7) goto L18;
        connect(3, r5, r10, r11);
        connect(4, r12, r13, r14);
        this.mParams.verticalBias = r15;
    L20:
        return this;
    L18:
        connect(6, r5, r10, r11);
        connect(7, r12, r13, r14);
        this.mParams.horizontalBias = r15;
    L19:
        connect(1, r5, r10, r11);
        connect(2, r12, r13, r14);
        this.mParams.horizontalBias = r15;
    L22:
        throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
    L24:
        throw new IllegalArgumentException("margin must be > 0");
    L26:
        throw new IllegalArgumentException("margin must be > 0");
    }

    public ConstraintProperties centerHorizontally(int r5, int r10, int r11, int r12, int r13, int r14, float r15) {
        connect(1, r5, r10, r11);
        connect(2, r12, r13, r14);
        this.mParams.horizontalBias = r15;
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int r5, int r10, int r11, int r12, int r13, int r14, float r15) {
        connect(6, r5, r10, r11);
        connect(7, r12, r13, r14);
        this.mParams.horizontalBias = r15;
        return this;
    }

    public ConstraintProperties centerVertically(int r5, int r10, int r11, int r12, int r13, int r14, float r15) {
        connect(3, r5, r10, r11);
        connect(4, r12, r13, r14);
        this.mParams.verticalBias = r15;
        return this;
    }

    public ConstraintProperties connect(int r10, int r11, int r12, int r13) {
        switch(r10) {
            case 1: goto L46;
            case 2: goto L39;
            case 3: goto L32;
            case 4: goto L25;
            case 5: goto L21;
            case 6: goto L13;
            case 7: goto L6;
            default: goto L4;
        };
    L4:
        StringBuilder r14 = new StringBuilder();
        r14.append(sideToString(r10));
        r14.append(" to ");
        throw new IllegalArgumentException(j0.q(r14, sideToString(r12), " unknown"));
    L6:
        if (r12 != 7) goto L8;
        ConstraintLayout.LayoutParams r15 = this.mParams;
        r15.endToEnd = r11;
        r15.endToStart = -1;
    L10:
        this.mParams.setMarginEnd(r13);
    L51:
        return this;
    L8:
        if (r12 != 6) goto L12;
        ConstraintLayout.LayoutParams r16 = this.mParams;
        r16.endToStart = r11;
        r16.endToEnd = -1;
        goto L10
    L12:
        throw new IllegalArgumentException(j0.q(new StringBuilder("right to "), sideToString(r12), " undefined"));
    L13:
        if (r12 != 6) goto L15;
        ConstraintLayout.LayoutParams r17 = this.mParams;
        r17.startToStart = r11;
        r17.startToEnd = -1;
    L17:
        this.mParams.setMarginStart(r13);
        goto L51
    L15:
        if (r12 != 7) goto L19;
        ConstraintLayout.LayoutParams r18 = this.mParams;
        r18.startToEnd = r11;
        r18.startToStart = -1;
        goto L17
    L19:
        throw new IllegalArgumentException(j0.q(new StringBuilder("right to "), sideToString(r12), " undefined"));
    L25:
        if (r12 != 4) goto L27;
        ConstraintLayout.LayoutParams r19 = this.mParams;
        r19.bottomToBottom = r11;
        r19.bottomToTop = -1;
        r19.baselineToBaseline = -1;
    L29:
        ((ViewGroup.MarginLayoutParams) this.mParams).bottomMargin = r13;
        goto L51
    L27:
        if (r12 != 3) goto L31;
        ConstraintLayout.LayoutParams r110 = this.mParams;
        r110.bottomToTop = r11;
        r110.bottomToBottom = -1;
        r110.baselineToBaseline = -1;
        goto L29
    L31:
        throw new IllegalArgumentException(j0.q(new StringBuilder("right to "), sideToString(r12), " undefined"));
    L32:
        if (r12 != 3) goto L34;
        ConstraintLayout.LayoutParams r111 = this.mParams;
        r111.topToTop = r11;
        r111.topToBottom = -1;
        r111.baselineToBaseline = -1;
    L36:
        ((ViewGroup.MarginLayoutParams) this.mParams).topMargin = r13;
        goto L51
    L34:
        if (r12 != 4) goto L38;
        ConstraintLayout.LayoutParams r112 = this.mParams;
        r112.topToBottom = r11;
        r112.topToTop = -1;
        r112.baselineToBaseline = -1;
        goto L36
    L38:
        throw new IllegalArgumentException(j0.q(new StringBuilder("right to "), sideToString(r12), " undefined"));
    L39:
        if (r12 != 1) goto L41;
        ConstraintLayout.LayoutParams r113 = this.mParams;
        r113.rightToLeft = r11;
        r113.rightToRight = -1;
    L43:
        ((ViewGroup.MarginLayoutParams) this.mParams).rightMargin = r13;
        goto L51
    L41:
        if (r12 != 2) goto L45;
        ConstraintLayout.LayoutParams r114 = this.mParams;
        r114.rightToRight = r11;
        r114.rightToLeft = -1;
        goto L43
    L45:
        throw new IllegalArgumentException(j0.q(new StringBuilder("right to "), sideToString(r12), " undefined"));
    L46:
        if (r12 != 1) goto L48;
        ConstraintLayout.LayoutParams r115 = this.mParams;
        r115.leftToLeft = r11;
        r115.leftToRight = -1;
    L50:
        ((ViewGroup.MarginLayoutParams) this.mParams).leftMargin = r13;
        goto L51
    L48:
        if (r12 != 2) goto L53;
        ConstraintLayout.LayoutParams r116 = this.mParams;
        r116.leftToRight = r11;
        r116.leftToLeft = -1;
        goto L50
    L53:
        throw new IllegalArgumentException(j0.q(new StringBuilder("Left to "), sideToString(r12), " undefined"));
    L21:
        if (r12 != 5) goto L24;
        ConstraintLayout.LayoutParams r117 = this.mParams;
        r117.baselineToBaseline = r11;
        r117.bottomToBottom = -1;
        r117.bottomToTop = -1;
        r117.topToTop = -1;
        r117.topToBottom = -1;
        goto L51
    L24:
        throw new IllegalArgumentException(j0.q(new StringBuilder("right to "), sideToString(r12), " undefined"));
    }

    public ConstraintProperties constrainDefaultHeight(int r5) {
        this.mParams.matchConstraintDefaultHeight = r5;
        return this;
    }

    public ConstraintProperties constrainDefaultWidth(int r5) {
        this.mParams.matchConstraintDefaultWidth = r5;
        return this;
    }

    public ConstraintProperties constrainHeight(int r5) {
        ((ViewGroup.MarginLayoutParams) this.mParams).height = r5;
        return this;
    }

    public ConstraintProperties constrainMaxHeight(int r5) {
        this.mParams.matchConstraintMaxHeight = r5;
        return this;
    }

    public ConstraintProperties constrainMaxWidth(int r5) {
        this.mParams.matchConstraintMaxWidth = r5;
        return this;
    }

    public ConstraintProperties constrainMinHeight(int r5) {
        this.mParams.matchConstraintMinHeight = r5;
        return this;
    }

    public ConstraintProperties constrainMinWidth(int r5) {
        this.mParams.matchConstraintMinWidth = r5;
        return this;
    }

    public ConstraintProperties constrainWidth(int r5) {
        ((ViewGroup.MarginLayoutParams) this.mParams).width = r5;
        return this;
    }

    public ConstraintProperties dimensionRatio(String r5) {
        this.mParams.dimensionRatio = r5;
        return this;
    }

    public ConstraintProperties elevation(float r5) {
        this.mView.setElevation(r5);
        return this;
    }

    public ConstraintProperties goneMargin(int r5, int r10) {
        switch(r5) {
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
        this.mParams.goneEndMargin = r10;
    L13:
        return this;
    L6:
        this.mParams.goneStartMargin = r10;
        goto L13
    L9:
        this.mParams.goneBottomMargin = r10;
        goto L13
    L10:
        this.mParams.goneTopMargin = r10;
        goto L13
    L11:
        this.mParams.goneRightMargin = r10;
        goto L13
    L12:
        this.mParams.goneLeftMargin = r10;
        goto L13
    L4:
        throw new IllegalArgumentException("unknown constraint");
    L8:
        throw new IllegalArgumentException("baseline does not support margins");
    }

    public ConstraintProperties horizontalBias(float r5) {
        this.mParams.horizontalBias = r5;
        return this;
    }

    public ConstraintProperties horizontalChainStyle(int r5) {
        this.mParams.horizontalChainStyle = r5;
        return this;
    }

    public ConstraintProperties horizontalWeight(float r5) {
        this.mParams.horizontalWeight = r5;
        return this;
    }

    public ConstraintProperties margin(int r5, int r10) {
        switch(r5) {
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
        this.mParams.setMarginEnd(r10);
    L13:
        return this;
    L6:
        this.mParams.setMarginStart(r10);
        goto L13
    L9:
        ((ViewGroup.MarginLayoutParams) this.mParams).bottomMargin = r10;
        goto L13
    L10:
        ((ViewGroup.MarginLayoutParams) this.mParams).topMargin = r10;
        goto L13
    L11:
        ((ViewGroup.MarginLayoutParams) this.mParams).rightMargin = r10;
        goto L13
    L12:
        ((ViewGroup.MarginLayoutParams) this.mParams).leftMargin = r10;
        goto L13
    L4:
        throw new IllegalArgumentException("unknown constraint");
    L8:
        throw new IllegalArgumentException("baseline does not support margins");
    }

    public ConstraintProperties removeConstraints(int r5) {
        switch(r5) {
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
        ConstraintLayout.LayoutParams r10 = this.mParams;
        r10.endToStart = -1;
        r10.endToEnd = -1;
        r10.setMarginEnd(-1);
        this.mParams.goneEndMargin = -1;
    L13:
        return this;
    L7:
        ConstraintLayout.LayoutParams r11 = this.mParams;
        r11.startToEnd = -1;
        r11.startToStart = -1;
        r11.setMarginStart(-1);
        this.mParams.goneStartMargin = -1;
        goto L13
    L8:
        this.mParams.baselineToBaseline = -1;
        goto L13
    L9:
        ConstraintLayout.LayoutParams r12 = this.mParams;
        r12.bottomToTop = -1;
        r12.bottomToBottom = -1;
        ((ViewGroup.MarginLayoutParams) r12).bottomMargin = -1;
        r12.goneBottomMargin = -1;
        goto L13
    L10:
        ConstraintLayout.LayoutParams r13 = this.mParams;
        r13.topToBottom = -1;
        r13.topToTop = -1;
        ((ViewGroup.MarginLayoutParams) r13).topMargin = -1;
        r13.goneTopMargin = -1;
        goto L13
    L11:
        ConstraintLayout.LayoutParams r14 = this.mParams;
        r14.rightToRight = -1;
        r14.rightToLeft = -1;
        ((ViewGroup.MarginLayoutParams) r14).rightMargin = -1;
        r14.goneRightMargin = -1;
        goto L13
    L12:
        ConstraintLayout.LayoutParams r15 = this.mParams;
        r15.leftToRight = -1;
        r15.leftToLeft = -1;
        ((ViewGroup.MarginLayoutParams) r15).leftMargin = -1;
        r15.goneLeftMargin = -1;
        goto L13
    L5:
        throw new IllegalArgumentException("unknown constraint");
    }

    public ConstraintProperties removeFromHorizontalChain() {
        ConstraintLayout.LayoutParams r5 = this.mParams;
        int r10 = r5.leftToRight;
        int r11 = r5.rightToLeft;
        if (r10 != (-1)) goto L22;
        if (r11 != (-1)) goto L22;
        int r12 = r5.startToEnd;
        int r13 = r5.endToStart;
        if (r12 != (-1)) goto L9;
        if (r13 != (-1)) goto L9;
    L21:
        removeConstraints(6);
        removeConstraints(7);
    L35:
        return this;
    L9:
        ConstraintProperties r14 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r12));
        ConstraintProperties r15 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r13));
        ConstraintLayout.LayoutParams r16 = this.mParams;
        if (r12 == (-1)) goto L13;
        if (r13 == (-1)) goto L13;
        r14.connect(7, r13, 6, 0);
        r15.connect(6, r10, 7, 0);
    L13:
        if (r10 != (-1)) goto L15;
        if (r13 == (-1)) goto L21;
    L15:
        int r17 = r16.rightToRight;
        if (r17 == (-1)) goto L18;
        r14.connect(7, r17, 7, 0);
        goto L21
    L18:
        int r18 = r16.leftToLeft;
        if (r18 == (-1)) goto L21;
        r15.connect(6, r18, 6, 0);
    L22:
        ConstraintProperties r19 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r10));
        ConstraintProperties r20 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r11));
        ConstraintLayout.LayoutParams r21 = this.mParams;
        if (r10 == (-1)) goto L26;
        if (r11 == (-1)) goto L26;
        r19.connect(2, r11, 1, 0);
        r20.connect(1, r10, 2, 0);
    L34:
        removeConstraints(1);
        removeConstraints(2);
    L26:
        if (r10 != (-1)) goto L28;
        if (r11 == (-1)) goto L34;
    L28:
        int r22 = r21.rightToRight;
        if (r22 == (-1)) goto L31;
        r19.connect(2, r22, 2, 0);
        goto L34
    L31:
        int r23 = r21.leftToLeft;
        if (r23 == (-1)) goto L34;
        r20.connect(1, r23, 1, 0);
        goto L34
    }

    public ConstraintProperties removeFromVerticalChain() {
        ConstraintLayout.LayoutParams r5 = this.mParams;
        int r10 = r5.topToBottom;
        int r11 = r5.bottomToTop;
        if (r10 != (-1)) goto L5;
        if (r11 != (-1)) goto L5;
    L17:
        removeConstraints(3);
        removeConstraints(4);
        return this;
    L5:
        ConstraintProperties r12 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r10));
        ConstraintProperties r13 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(r11));
        ConstraintLayout.LayoutParams r14 = this.mParams;
        if (r10 == (-1)) goto L9;
        if (r11 == (-1)) goto L9;
        r12.connect(4, r11, 3, 0);
        r13.connect(3, r10, 4, 0);
    L9:
        if (r10 != (-1)) goto L11;
        if (r11 == (-1)) goto L17;
    L11:
        int r15 = r14.bottomToBottom;
        if (r15 == (-1)) goto L14;
        r12.connect(4, r15, 4, 0);
        goto L17
    L14:
        int r16 = r14.topToTop;
        if (r16 == (-1)) goto L17;
        r13.connect(3, r16, 3, 0);
        goto L17
    }

    public ConstraintProperties rotation(float r5) {
        this.mView.setRotation(r5);
        return this;
    }

    public ConstraintProperties rotationX(float r5) {
        this.mView.setRotationX(r5);
        return this;
    }

    public ConstraintProperties rotationY(float r5) {
        this.mView.setRotationY(r5);
        return this;
    }

    public ConstraintProperties scaleX(float r5) {
        this.mView.setScaleY(r5);
        return this;
    }

    public ConstraintProperties scaleY(float r5) {
        return this;
    }

    public ConstraintProperties transformPivot(float r5, float r10) {
        this.mView.setPivotX(r5);
        this.mView.setPivotY(r10);
        return this;
    }

    public ConstraintProperties transformPivotX(float r5) {
        this.mView.setPivotX(r5);
        return this;
    }

    public ConstraintProperties transformPivotY(float r5) {
        this.mView.setPivotY(r5);
        return this;
    }

    public ConstraintProperties translation(float r5, float r10) {
        this.mView.setTranslationX(r5);
        this.mView.setTranslationY(r10);
        return this;
    }

    public ConstraintProperties translationX(float r5) {
        this.mView.setTranslationX(r5);
        return this;
    }

    public ConstraintProperties translationY(float r5) {
        this.mView.setTranslationY(r5);
        return this;
    }

    public ConstraintProperties translationZ(float r5) {
        this.mView.setTranslationZ(r5);
        return this;
    }

    public ConstraintProperties verticalBias(float r5) {
        this.mParams.verticalBias = r5;
        return this;
    }

    public ConstraintProperties verticalChainStyle(int r5) {
        this.mParams.verticalChainStyle = r5;
        return this;
    }

    public ConstraintProperties verticalWeight(float r5) {
        this.mParams.verticalWeight = r5;
        return this;
    }

    public ConstraintProperties visibility(int r5) {
        this.mView.setVisibility(r5);
        return this;
    }

    public ConstraintProperties centerHorizontally(int r10) {
        if (r10 != 0) goto L4;
        center(0, 1, 0, 0, 2, 0, 0.5f);
    L5:
        return this;
    L4:
        center(r10, 2, 0, r10, 1, 0, 0.5f);
        goto L5
    }

    public ConstraintProperties centerHorizontallyRtl(int r10) {
        if (r10 != 0) goto L4;
        center(0, 6, 0, 0, 7, 0, 0.5f);
    L5:
        return this;
    L4:
        center(r10, 7, 0, r10, 6, 0, 0.5f);
        goto L5
    }

    public ConstraintProperties centerVertically(int r10) {
        if (r10 != 0) goto L4;
        center(0, 3, 0, 0, 4, 0, 0.5f);
    L5:
        return this;
    L4:
        center(r10, 4, 0, r10, 3, 0, 0.5f);
        goto L5
    }
}
