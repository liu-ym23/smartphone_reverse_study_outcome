package androidx.constraintlayout.widget;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;

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

    public ConstraintProperties(View r4) {
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, ConstraintLayout.LayoutParams.class) == false) goto L7;
        this.mParams = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        this.mView = r4;
        return;
    L7:
        throw new RuntimeException("Only children of ConstraintLayout.LayoutParams supported");
    }

    private String sideToString(int r1) {
        switch(r1) {
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

    public ConstraintProperties addToHorizontalChain(int r7, int r8) {
        if (r7 != 0) goto L5;
        int r2 = 1;
    L6:
        connect(1, r7, r2, 0);
        if (r8 != 0) goto L9;
        int r3 = 2;
    L10:
        connect(2, r8, r3, 0);
        if (r7 == 0) goto L13;
        new ConstraintProperties(((ViewGroup) ZeusTransformUtils.preCheckCast(this.mView.getParent(), ViewGroup.class, "com.obric.memorydata.plugin")).findViewById(r7)).connect(2, this.mView.getId(), 1, 0);
    L13:
        if (r8 == 0) goto L15;
        new ConstraintProperties(((ViewGroup) ZeusTransformUtils.preCheckCast(this.mView.getParent(), ViewGroup.class, "com.obric.memorydata.plugin")).findViewById(r8)).connect(1, this.mView.getId(), 2, 0);
    L15:
        return this;
    L9:
        r3 = 1;
        goto L10
    L5:
        r2 = 2;
        goto L6
    }

    public ConstraintProperties addToHorizontalChainRTL(int r7, int r8) {
        if (r7 != 0) goto L5;
        int r2 = 6;
    L6:
        connect(6, r7, r2, 0);
        if (r8 != 0) goto L9;
        int r3 = 7;
    L10:
        connect(7, r8, r3, 0);
        if (r7 == 0) goto L13;
        new ConstraintProperties(((ViewGroup) ZeusTransformUtils.preCheckCast(this.mView.getParent(), ViewGroup.class, "com.obric.memorydata.plugin")).findViewById(r7)).connect(7, this.mView.getId(), 6, 0);
    L13:
        if (r8 == 0) goto L15;
        new ConstraintProperties(((ViewGroup) ZeusTransformUtils.preCheckCast(this.mView.getParent(), ViewGroup.class, "com.obric.memorydata.plugin")).findViewById(r8)).connect(6, this.mView.getId(), 7, 0);
    L15:
        return this;
    L9:
        r3 = 6;
        goto L10
    L5:
        r2 = 7;
        goto L6
    }

    public ConstraintProperties addToVerticalChain(int r7, int r8) {
        if (r7 != 0) goto L5;
        int r2 = 3;
    L6:
        connect(3, r7, r2, 0);
        if (r8 != 0) goto L9;
        int r3 = 4;
    L10:
        connect(4, r8, r3, 0);
        if (r7 == 0) goto L13;
        new ConstraintProperties(((ViewGroup) ZeusTransformUtils.preCheckCast(this.mView.getParent(), ViewGroup.class, "com.obric.memorydata.plugin")).findViewById(r7)).connect(4, this.mView.getId(), 3, 0);
    L13:
        if (r8 == 0) goto L15;
        new ConstraintProperties(((ViewGroup) ZeusTransformUtils.preCheckCast(this.mView.getParent(), ViewGroup.class, "com.obric.memorydata.plugin")).findViewById(r8)).connect(3, this.mView.getId(), 4, 0);
    L15:
        return this;
    L9:
        r3 = 3;
        goto L10
    L5:
        r2 = 4;
        goto L6
    }

    public ConstraintProperties alpha(float r2) {
        this.mView.setAlpha(r2);
        return this;
    }

    public void apply() {
    }

    public ConstraintProperties center(int r3, int r4, int r5, int r6, int r7, int r8, float r9) {
        if (r5 < 0) goto L25;
        if (r8 < 0) goto L23;
        if (r9 <= 0.0f) goto L21;
        if (r9 > 1.0f) goto L21;
        int r0 = 2;
        int r1 = 1;
        if (r4 == 1) goto L18;
        if (r4 == 2) goto L18;
        r0 = 7;
        r1 = 6;
        if (r4 == 6) goto L18;
        if (r4 == 7) goto L18;
        connect(3, r3, r4, r5);
        connect(4, r6, r7, r8);
        this.mParams.verticalBias = r9;
    L19:
        return this;
    L18:
        connect(r1, r3, r4, r5);
        connect(r0, r6, r7, r8);
        this.mParams.horizontalBias = r9;
    L21:
        throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
    L23:
        throw new IllegalArgumentException("margin must be > 0");
    L25:
        throw new IllegalArgumentException("margin must be > 0");
    }

    public ConstraintProperties centerHorizontally(int r9) {
        if (r9 != 0) goto L4;
        int r1 = 0;
        int r2 = 1;
        int r3 = 0;
        int r4 = 0;
        int r5 = 2;
        int r6 = 0;
        float r7 = 0.5f;
    L5:
        center(r1, r2, r3, r4, r5, r6, r7);
        return this;
    L4:
        r2 = 2;
        r3 = 0;
        r5 = 1;
        r6 = 0;
        r7 = 0.5f;
        r1 = r9;
        r4 = r9;
        goto L5
    }

    public ConstraintProperties centerHorizontally(int r2, int r3, int r4, int r5, int r6, int r7, float r8) {
        connect(1, r2, r3, r4);
        connect(2, r5, r6, r7);
        this.mParams.horizontalBias = r8;
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int r9) {
        if (r9 != 0) goto L4;
        int r1 = 0;
        int r2 = 6;
        int r3 = 0;
        int r4 = 0;
        int r5 = 7;
        int r6 = 0;
        float r7 = 0.5f;
    L5:
        center(r1, r2, r3, r4, r5, r6, r7);
        return this;
    L4:
        r2 = 7;
        r3 = 0;
        r5 = 6;
        r6 = 0;
        r7 = 0.5f;
        r1 = r9;
        r4 = r9;
        goto L5
    }

    public ConstraintProperties centerHorizontallyRtl(int r2, int r3, int r4, int r5, int r6, int r7, float r8) {
        connect(6, r2, r3, r4);
        connect(7, r5, r6, r7);
        this.mParams.horizontalBias = r8;
        return this;
    }

    public ConstraintProperties centerVertically(int r9) {
        if (r9 != 0) goto L4;
        int r1 = 0;
        int r2 = 3;
        int r3 = 0;
        int r4 = 0;
        int r5 = 4;
        int r6 = 0;
        float r7 = 0.5f;
    L5:
        center(r1, r2, r3, r4, r5, r6, r7);
        return this;
    L4:
        r2 = 4;
        r3 = 0;
        r5 = 3;
        r6 = 0;
        r7 = 0.5f;
        r1 = r9;
        r4 = r9;
        goto L5
    }

    public ConstraintProperties centerVertically(int r2, int r3, int r4, int r5, int r6, int r7, float r8) {
        connect(3, r2, r3, r4);
        connect(4, r5, r6, r7);
        this.mParams.verticalBias = r8;
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
        this.mParams.endToEnd = r12;
        this.mParams.endToStart = -1;
    L11:
        if (Build.VERSION.SDK_INT < 17) goto L63;
        this.mParams.setMarginEnd(r14);
    L63:
        return this;
    L8:
        if (r13 != 6) goto L14;
        this.mParams.endToStart = r12;
        this.mParams.endToEnd = -1;
        goto L11
    L14:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L15:
        if (r13 != 6) goto L17;
        this.mParams.startToStart = r12;
        this.mParams.startToEnd = -1;
    L20:
        if (Build.VERSION.SDK_INT < 17) goto L63;
        this.mParams.setMarginStart(r14);
        goto L63
    L17:
        if (r13 != 7) goto L23;
        this.mParams.startToEnd = r12;
        this.mParams.startToStart = -1;
        goto L20
    L23:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L35:
        if (r13 != 4) goto L38;
        this.mParams.bottomToBottom = r12;
        this.mParams.bottomToTop = -1;
    L37:
        this.mParams.baselineToBaseline = -1;
        this.mParams.baselineToTop = -1;
        this.mParams.baselineToBottom = -1;
        this.mParams.bottomMargin = r14;
        goto L63
    L38:
        if (r13 != 3) goto L42;
        this.mParams.bottomToTop = r12;
        this.mParams.bottomToBottom = -1;
        goto L37
    L42:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L43:
        if (r13 != 3) goto L46;
        this.mParams.topToTop = r12;
        this.mParams.topToBottom = -1;
    L45:
        this.mParams.baselineToBaseline = -1;
        this.mParams.baselineToTop = -1;
        this.mParams.baselineToBottom = -1;
        this.mParams.topMargin = r14;
        goto L63
    L46:
        if (r13 != 4) goto L50;
        this.mParams.topToBottom = r12;
        this.mParams.topToTop = -1;
        goto L45
    L50:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L51:
        if (r13 != 1) goto L53;
        this.mParams.rightToLeft = r12;
        this.mParams.rightToRight = -1;
    L55:
        this.mParams.rightMargin = r14;
        goto L63
    L53:
        if (r13 != 2) goto L57;
        this.mParams.rightToRight = r12;
        this.mParams.rightToLeft = -1;
        goto L55
    L57:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L58:
        if (r13 != 1) goto L60;
        this.mParams.leftToLeft = r12;
        this.mParams.leftToRight = -1;
    L62:
        this.mParams.leftMargin = r14;
        goto L63
    L60:
        if (r13 != 2) goto L65;
        this.mParams.leftToRight = r12;
        this.mParams.leftToLeft = -1;
        goto L62
    L65:
        throw new IllegalArgumentException("Left to " + sideToString(r13) + " undefined");
    L5:
        throw new IllegalArgumentException(sideToString(r11) + " to " + sideToString(r13) + " unknown");
    L25:
        if (r13 != 5) goto L27;
        this.mParams.baselineToBaseline = r12;
        this.mParams.bottomToBottom = -1;
        this.mParams.bottomToTop = -1;
        this.mParams.topToTop = -1;
        this.mParams.topToBottom = -1;
    L27:
        if (r13 != 3) goto L30;
        this.mParams.baselineToTop = r12;
    L29:
        this.mParams.bottomToBottom = -1;
        this.mParams.bottomToTop = -1;
        this.mParams.topToTop = -1;
        this.mParams.topToBottom = -1;
        this.mParams.baselineMargin = r14;
        goto L63
    L30:
        if (r13 != 4) goto L34;
        this.mParams.baselineToBottom = r12;
        goto L29
    L34:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    }

    public ConstraintProperties constrainDefaultHeight(int r2) {
        this.mParams.matchConstraintDefaultHeight = r2;
        return this;
    }

    public ConstraintProperties constrainDefaultWidth(int r2) {
        this.mParams.matchConstraintDefaultWidth = r2;
        return this;
    }

    public ConstraintProperties constrainHeight(int r2) {
        this.mParams.height = r2;
        return this;
    }

    public ConstraintProperties constrainMaxHeight(int r2) {
        this.mParams.matchConstraintMaxHeight = r2;
        return this;
    }

    public ConstraintProperties constrainMaxWidth(int r2) {
        this.mParams.matchConstraintMaxWidth = r2;
        return this;
    }

    public ConstraintProperties constrainMinHeight(int r2) {
        this.mParams.matchConstraintMinHeight = r2;
        return this;
    }

    public ConstraintProperties constrainMinWidth(int r2) {
        this.mParams.matchConstraintMinWidth = r2;
        return this;
    }

    public ConstraintProperties constrainWidth(int r2) {
        this.mParams.width = r2;
        return this;
    }

    public ConstraintProperties dimensionRatio(String r2) {
        this.mParams.dimensionRatio = r2;
        return this;
    }

    public ConstraintProperties elevation(float r3) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        this.mView.setElevation(r3);
    L5:
        return this;
    }

    public ConstraintProperties goneMargin(int r1, int r2) {
        switch(r1) {
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
        this.mParams.goneEndMargin = r2;
    L13:
        return this;
    L6:
        this.mParams.goneStartMargin = r2;
        goto L13
    L9:
        this.mParams.goneBottomMargin = r2;
        goto L13
    L10:
        this.mParams.goneTopMargin = r2;
        goto L13
    L11:
        this.mParams.goneRightMargin = r2;
        goto L13
    L12:
        this.mParams.goneLeftMargin = r2;
        goto L13
    L4:
        throw new IllegalArgumentException("unknown constraint");
    L8:
        throw new IllegalArgumentException("baseline does not support margins");
    }

    public ConstraintProperties horizontalBias(float r2) {
        this.mParams.horizontalBias = r2;
        return this;
    }

    public ConstraintProperties horizontalChainStyle(int r2) {
        this.mParams.horizontalChainStyle = r2;
        return this;
    }

    public ConstraintProperties horizontalWeight(float r2) {
        this.mParams.horizontalWeight = r2;
        return this;
    }

    public ConstraintProperties margin(int r1, int r2) {
        switch(r1) {
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
        this.mParams.setMarginEnd(r2);
    L13:
        return this;
    L6:
        this.mParams.setMarginStart(r2);
        goto L13
    L9:
        this.mParams.bottomMargin = r2;
        goto L13
    L10:
        this.mParams.topMargin = r2;
        goto L13
    L11:
        this.mParams.rightMargin = r2;
        goto L13
    L12:
        this.mParams.leftMargin = r2;
        goto L13
    L4:
        throw new IllegalArgumentException("unknown constraint");
    L8:
        throw new IllegalArgumentException("baseline does not support margins");
    }

    public ConstraintProperties removeConstraints(int r3) {
        switch(r3) {
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
        this.mParams.endToStart = -1;
        this.mParams.endToEnd = -1;
        this.mParams.setMarginEnd(-1);
        this.mParams.goneEndMargin = Integer.MIN_VALUE;
    L13:
        return this;
    L7:
        this.mParams.startToEnd = -1;
        this.mParams.startToStart = -1;
        this.mParams.setMarginStart(-1);
        this.mParams.goneStartMargin = Integer.MIN_VALUE;
        goto L13
    L8:
        this.mParams.baselineToBaseline = -1;
        goto L13
    L9:
        this.mParams.bottomToTop = -1;
        this.mParams.bottomToBottom = -1;
        this.mParams.bottomMargin = -1;
        this.mParams.goneBottomMargin = Integer.MIN_VALUE;
        goto L13
    L10:
        this.mParams.topToBottom = -1;
        this.mParams.topToTop = -1;
        this.mParams.topMargin = -1;
        this.mParams.goneTopMargin = Integer.MIN_VALUE;
        goto L13
    L11:
        this.mParams.rightToRight = -1;
        this.mParams.rightToLeft = -1;
        this.mParams.rightMargin = -1;
        this.mParams.goneRightMargin = Integer.MIN_VALUE;
        goto L13
    L12:
        this.mParams.leftToRight = -1;
        this.mParams.leftToLeft = -1;
        this.mParams.leftMargin = -1;
        this.mParams.goneLeftMargin = Integer.MIN_VALUE;
        goto L13
    L5:
        throw new IllegalArgumentException("unknown constraint");
    }

    public ConstraintProperties removeFromHorizontalChain() {
        int r0 = this.mParams.leftToRight;
        int r1 = this.mParams.rightToLeft;
        ConstraintLayout.LayoutParams r2 = this.mParams;
        if (r0 != (-1)) goto L22;
        if (r1 != (-1)) goto L22;
        int r3 = r2.startToEnd;
        int r4 = this.mParams.endToStart;
        if (r3 != (-1)) goto L9;
        if (r4 != (-1)) goto L9;
    L21:
        removeConstraints(6);
        removeConstraints(7);
    L35:
        return this;
    L9:
        ConstraintProperties r9 = new ConstraintProperties(((ViewGroup) ZeusTransformUtils.preCheckCast(this.mView.getParent(), ViewGroup.class, "com.obric.memorydata.plugin")).findViewById(r3));
        ConstraintProperties r8 = new ConstraintProperties(((ViewGroup) ZeusTransformUtils.preCheckCast(this.mView.getParent(), ViewGroup.class, "com.obric.memorydata.plugin")).findViewById(r4));
        ConstraintLayout.LayoutParams r5 = this.mParams;
        if (r3 == (-1)) goto L13;
        if (r4 == (-1)) goto L13;
        r9.connect(7, r4, 6, 0);
        r8.connect(6, r0, 7, 0);
    L13:
        if (r0 != (-1)) goto L15;
        if (r4 == (-1)) goto L21;
    L15:
        int r6 = r5.rightToRight;
        ConstraintLayout.LayoutParams r7 = this.mParams;
        if (r6 == (-1)) goto L18;
        r9.connect(7, r7.rightToRight, 7, 0);
        goto L21
    L18:
        int r10 = r7.leftToLeft;
        ConstraintLayout.LayoutParams r11 = this.mParams;
        if (r10 == (-1)) goto L21;
        r8.connect(6, r11.leftToLeft, 6, 0);
    L22:
        ConstraintProperties r12 = new ConstraintProperties(((ViewGroup) ZeusTransformUtils.preCheckCast(this.mView.getParent(), ViewGroup.class, "com.obric.memorydata.plugin")).findViewById(r0));
        ConstraintProperties r13 = new ConstraintProperties(((ViewGroup) ZeusTransformUtils.preCheckCast(this.mView.getParent(), ViewGroup.class, "com.obric.memorydata.plugin")).findViewById(r1));
        ConstraintLayout.LayoutParams r14 = this.mParams;
        if (r0 == (-1)) goto L26;
        if (r1 == (-1)) goto L26;
        r12.connect(2, r1, 1, 0);
        r13.connect(1, r0, 2, 0);
    L34:
        removeConstraints(1);
        removeConstraints(2);
    L26:
        if (r0 != (-1)) goto L28;
        if (r1 == (-1)) goto L34;
    L28:
        int r15 = r14.rightToRight;
        ConstraintLayout.LayoutParams r16 = this.mParams;
        if (r15 == (-1)) goto L31;
        r12.connect(2, r16.rightToRight, 2, 0);
        goto L34
    L31:
        int r17 = r16.leftToLeft;
        ConstraintLayout.LayoutParams r18 = this.mParams;
        if (r17 == (-1)) goto L34;
        r13.connect(1, r18.leftToLeft, 1, 0);
        goto L34
    }

    public ConstraintProperties removeFromVerticalChain() {
        int r0 = this.mParams.topToBottom;
        int r1 = this.mParams.bottomToTop;
        if (r0 != (-1)) goto L5;
        if (r1 != (-1)) goto L5;
    L17:
        removeConstraints(3);
        removeConstraints(4);
        return this;
    L5:
        ConstraintProperties r6 = new ConstraintProperties(((ViewGroup) ZeusTransformUtils.preCheckCast(this.mView.getParent(), ViewGroup.class, "com.obric.memorydata.plugin")).findViewById(r0));
        ConstraintProperties r7 = new ConstraintProperties(((ViewGroup) ZeusTransformUtils.preCheckCast(this.mView.getParent(), ViewGroup.class, "com.obric.memorydata.plugin")).findViewById(r1));
        ConstraintLayout.LayoutParams r5 = this.mParams;
        if (r0 == (-1)) goto L9;
        if (r1 == (-1)) goto L9;
        r6.connect(4, r1, 3, 0);
        r7.connect(3, r0, 4, 0);
    L9:
        if (r0 != (-1)) goto L11;
        if (r1 == (-1)) goto L17;
    L11:
        int r2 = r5.bottomToBottom;
        ConstraintLayout.LayoutParams r3 = this.mParams;
        if (r2 == (-1)) goto L14;
        r6.connect(4, r3.bottomToBottom, 4, 0);
        goto L17
    L14:
        int r4 = r3.topToTop;
        ConstraintLayout.LayoutParams r8 = this.mParams;
        if (r4 == (-1)) goto L17;
        r7.connect(3, r8.topToTop, 3, 0);
        goto L17
    }

    public ConstraintProperties rotation(float r2) {
        this.mView.setRotation(r2);
        return this;
    }

    public ConstraintProperties rotationX(float r2) {
        this.mView.setRotationX(r2);
        return this;
    }

    public ConstraintProperties rotationY(float r2) {
        this.mView.setRotationY(r2);
        return this;
    }

    public ConstraintProperties scaleX(float r2) {
        this.mView.setScaleY(r2);
        return this;
    }

    public ConstraintProperties scaleY(float r1) {
        return this;
    }

    public ConstraintProperties transformPivot(float r2, float r3) {
        this.mView.setPivotX(r2);
        this.mView.setPivotY(r3);
        return this;
    }

    public ConstraintProperties transformPivotX(float r2) {
        this.mView.setPivotX(r2);
        return this;
    }

    public ConstraintProperties transformPivotY(float r2) {
        this.mView.setPivotY(r2);
        return this;
    }

    public ConstraintProperties translation(float r2, float r3) {
        this.mView.setTranslationX(r2);
        this.mView.setTranslationY(r3);
        return this;
    }

    public ConstraintProperties translationX(float r2) {
        this.mView.setTranslationX(r2);
        return this;
    }

    public ConstraintProperties translationY(float r2) {
        this.mView.setTranslationY(r2);
        return this;
    }

    public ConstraintProperties translationZ(float r3) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        this.mView.setTranslationZ(r3);
    L5:
        return this;
    }

    public ConstraintProperties verticalBias(float r2) {
        this.mParams.verticalBias = r2;
        return this;
    }

    public ConstraintProperties verticalChainStyle(int r2) {
        this.mParams.verticalChainStyle = r2;
        return this;
    }

    public ConstraintProperties verticalWeight(float r2) {
        this.mParams.verticalWeight = r2;
        return this;
    }

    public ConstraintProperties visibility(int r2) {
        this.mView.setVisibility(r2);
        return this;
    }
}
