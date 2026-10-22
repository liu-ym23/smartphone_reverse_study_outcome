package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class Chain {
    private static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    public Chain() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r39v0, types: [androidx.constraintlayout.core.LinearSystem] */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29, types: [androidx.constraintlayout.core.SolverVariable] */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [androidx.constraintlayout.core.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v30 */
    static void applyChainConstraints(ConstraintWidgetContainer r38, LinearSystem r39, int r40, int r41, ChainHead r42) {
        int r10 = r40;
        ConstraintWidget r11 = r42.mFirst;
        ConstraintWidget r12 = r42.mLast;
        ConstraintWidget r13 = r42.mFirstVisibleWidget;
        ConstraintWidget r14 = r42.mLastVisibleWidget;
        ConstraintWidget r15 = r42.mHead;
        float r16 = r42.mTotalWeight;
        if (r38.mListDimensionBehaviors[r10] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L5;
        boolean r17 = true;
    L7:
        if (r10 != 0) goto L17;
        int r18 = r15.mHorizontalChainStyle;
        if (r18 != 0) goto L11;
        boolean r19 = true;
    L12:
        if (r18 != 1) goto L14;
        boolean r110 = true;
    L15:
        if (r18 == 2) goto L25;
    L26:
        boolean r20 = false;
    L27:
        ?? r21 = r11;
        boolean r22 = false;
    L28:
        Object r23 = null;
        if (r22 == true) goto L85;
        ConstraintAnchor r24 = r21.mListAnchors[r41];
        if (r20 == false) goto L33;
        int r25 = 1;
    L34:
        int r26 = r24.getMargin();
        float r27 = r16;
        ConstraintWidget.DimensionBehaviour r28 = r21.mListDimensionBehaviors[r10];
        boolean r29 = r22;
        ConstraintWidget.DimensionBehaviour r30 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r28 == r30) goto L37;
    L39:
        boolean r31 = false;
    L40:
        ConstraintAnchor r111 = r24.mTarget;
        if (r111 == null) goto L44;
        if (r21 == r11) goto L44;
        r26 = r26 + r111.getMargin();
    L44:
        int r112 = r26;
        if (r20 == false) goto L50;
        if (r21 == r11) goto L50;
        if (r21 == r13) goto L50;
        r25 = 8;
    L50:
        ConstraintAnchor r32 = r24.mTarget;
        ConstraintWidget r210 = r11;
        if (r32 == null) goto L65;
        if (r21 != r13) goto L54;
        r39.addGreaterThan(r24.mSolverVariable, r32.mSolverVariable, r112, 6);
    L55:
        if (r31 == false) goto L58;
        if (r20 == true) goto L58;
        r25 = 5;
    L58:
        if (r21 != r13) goto L63;
        if (r20 == false) goto L63;
        if (r21.isInBarrier(r10) == false) goto L63;
        int r33 = 5;
    L64:
        r39.addEquality(r24.mSolverVariable, r24.mTarget.mSolverVariable, r112, r33);
    L63:
        r33 = r25;
        goto L64
    L54:
        r39.addGreaterThan(r24.mSolverVariable, r32.mSolverVariable, r112, 8);
    L65:
        if (r17 == true) goto L67;
    L73:
        ConstraintAnchor r34 = r21.mListAnchors[r41 + 1].mTarget;
        if (r34 == null) goto L81;
        ConstraintWidget r35 = r34.mOwner;
        ConstraintAnchor[] r36 = r35.mListAnchors;
        if (r36[r41].mTarget == null) goto L81;
        if (r36[r41].mTarget.mOwner != r21) goto L81;
        r23 = r35;
    L81:
        if (r23 == null) goto L83;
        r21 = r23;
        r22 = r29;
    L84:
        r15 = r15;
        r16 = r27;
        r19 = r19;
        r11 = r210;
        r21 = r21;
        goto L28
    L83:
        r22 = true;
        goto L84
    L67:
        if (r21.getVisibility() != 8) goto L69;
    L71:
        int r37 = 0;
    L72:
        r39.addGreaterThan(r21.mListAnchors[r41].mSolverVariable, r38.mListAnchors[r41].mSolverVariable, r37, 8);
        goto L73
    L69:
        if (r21.mListDimensionBehaviors[r10] != r30) goto L71;
        ConstraintAnchor[] r43 = r21.mListAnchors;
        r37 = 0;
        r39.addGreaterThan(r43[r41 + 1].mSolverVariable, r43[r41].mSolverVariable, 0, 5);
        goto L72
    L37:
        if (r21.mResolvedMatchConstraintDefault[r10] != 0) goto L39;
        r31 = true;
        goto L40
    L33:
        r25 = 4;
        goto L34
    L85:
        ConstraintWidget r211 = r15;
        float r212 = r16;
        ConstraintWidget r213 = r11;
        boolean r214 = r19;
        if (r14 == null) goto L107;
        int r44 = r41 + 1;
        if (r12.mListAnchors[r44].mTarget == null) goto L107;
        ConstraintAnchor r45 = r14.mListAnchors[r44];
        if (r14.mListDimensionBehaviors[r10] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L92;
    L94:
        boolean r46 = false;
    L95:
        if (r46 == false) goto L101;
        if (r20 == true) goto L101;
        ConstraintAnchor r47 = r45.mTarget;
        if (r47.mOwner != r38) goto L101;
        r39.addEquality(r45.mSolverVariable, r47.mSolverVariable, -r45.getMargin(), 5);
    L105:
        r39.addLowerThan(r45.mSolverVariable, r12.mListAnchors[r44].mTarget.mSolverVariable, -r45.getMargin(), 6);
    L101:
        if (r20 == false) goto L105;
        ConstraintAnchor r48 = r45.mTarget;
        if (r48.mOwner != r38) goto L105;
        r39.addEquality(r45.mSolverVariable, r48.mSolverVariable, -r45.getMargin(), 4);
        goto L105
    L92:
        if (r14.mResolvedMatchConstraintDefault[r10] != 0) goto L94;
        r46 = true;
    L107:
        if (r17 == false) goto L109;
        int r49 = r41 + 1;
        SolverVariable r50 = r38.mListAnchors[r49].mSolverVariable;
        ConstraintAnchor[] r51 = r12.mListAnchors;
        r39.addGreaterThan(r50, r51[r49].mSolverVariable, r51[r49].getMargin(), 8);
    L109:
        ArrayList<ConstraintWidget> r52 = r42.mWeightedMatchConstraintsWidgets;
        if (r52 == null) goto L138;
        int r53 = r52.size();
        if (r53 <= 1) goto L138;
        if (r42.mHasUndefinedWeights == true) goto L116;
    L118:
        float r54 = r212;
    L119:
        float r55 = 0.0f;
        float r310 = 0.0f;
        ConstraintWidget r113 = null;
        int r56 = 0;
    L120:
        if (r56 >= r53) goto L138;
        ConstraintWidget r114 = r52.get(r56);
        float r57 = r114.mWeight[r10];
        if (r57 >= r55) goto L129;
        if (r42.mHasComplexMatchWeights == false) goto L126;
        ConstraintAnchor[] r58 = r114.mListAnchors;
        r39.addEquality(r58[r41 + 1].mSolverVariable, r58[r41].mSolverVariable, 0, 4);
    L131:
        r52 = r52;
        r53 = r53;
    L137:
        r56 = r56 + 1;
        r53 = r53;
        r52 = r52;
        r55 = 0.0f;
        goto L120
    L126:
        r57 = 1.0f;
        r55 = 0.0f;
    L129:
        if (r57 != r55) goto L133;
        ConstraintAnchor[] r59 = r114.mListAnchors;
        r39.addEquality(r59[r41 + 1].mSolverVariable, r59[r41].mSolverVariable, 0, 8);
        goto L131
    L133:
        if (r113 == null) goto L136;
        ConstraintAnchor[] r60 = r113.mListAnchors;
        SolverVariable r115 = r60[r41].mSolverVariable;
        int r116 = r41 + 1;
        SolverVariable r61 = r60[r116].mSolverVariable;
        ConstraintAnchor[] r62 = r114.mListAnchors;
        SolverVariable r63 = r62[r41].mSolverVariable;
        SolverVariable r64 = r62[r116].mSolverVariable;
        ArrayRow r65 = r39.createRow();
        r65.createRowEqualMatchDimensions(r310, r54, r57, r115, r61, r63, r64);
        r39.addConstraint(r65);
    L136:
        r310 = r57;
        r113 = r114;
        goto L137
    L116:
        if (r42.mHasComplexMatchWeights == true) goto L118;
        r54 = r42.mWidgetsMatchCount;
    L138:
        if (r13 == null) goto L160;
        if (r13 == r14) goto L141;
        if (r20 == false) goto L160;
    L141:
        ConstraintAnchor r66 = r213.mListAnchors[r41];
        int r67 = r41 + 1;
        ConstraintAnchor r68 = r12.mListAnchors[r67];
        ConstraintAnchor r69 = r66.mTarget;
        if (r69 == null) goto L144;
        SolverVariable r70 = r69.mSolverVariable;
    L145:
        ConstraintAnchor r71 = r68.mTarget;
        if (r71 == null) goto L148;
        SolverVariable r72 = r71.mSolverVariable;
    L149:
        ConstraintAnchor r73 = r13.mListAnchors[r41];
        if (r14 == null) goto L152;
        r68 = r14.mListAnchors[r67];
    L152:
        if (r70 == null) goto L292;
        if (r72 == null) goto L292;
        if (r10 != 0) goto L157;
        float r74 = r211.mHorizontalBiasPercent;
    L158:
        int r75 = r73.getMargin();
        SolverVariable r76 = r70;
        r39.addCentering(r73.mSolverVariable, r76, r75, r74, r72, r68.mSolverVariable, r68.getMargin(), 7);
        goto L292
    L157:
        r74 = r211.mVerticalBiasPercent;
    L292:
        if (r214 == true) goto L294;
        if (r110 == true) goto L294;
        return;
    L294:
        if (r13 == null) goto L335;
        if (r13 == r14) goto L336;
        ConstraintAnchor[] r77 = r13.mListAnchors;
        ConstraintAnchor r78 = r77[r41];
        if (r14 != null) goto L299;
        r14 = r13;
    L299:
        int r79 = r41 + 1;
        ConstraintAnchor r80 = r14.mListAnchors[r79];
        ConstraintAnchor r81 = r78.mTarget;
        if (r81 == null) goto L302;
        SolverVariable r82 = r81.mSolverVariable;
    L303:
        ConstraintAnchor r83 = r80.mTarget;
        if (r83 == null) goto L306;
        ?? r84 = r83.mSolverVariable;
    L307:
        if (r12 == r14) goto L312;
        ConstraintAnchor r85 = r12.mListAnchors[r79].mTarget;
        if (r85 == null) goto L311;
        r23 = r85.mSolverVariable;
    L311:
        r84 = r23;
    L312:
        if (r13 != r14) goto L314;
        r78 = r77[r41];
        r80 = r77[r79];
    L314:
        if (r82 == null) goto L337;
        if (r84 == 0) goto L338;
        int r86 = r78.getMargin();
        int r87 = r14.mListAnchors[r79].getMargin();
        r39.addCentering(r78.mSolverVariable, r82, r86, 0.5f, r84, r80.mSolverVariable, r87, 5);
        return;
    L338:
        return;
    L337:
        return;
    L306:
        r84 = 0;
        goto L307
    L302:
        r82 = null;
        goto L303
    L336:
        return;
    L335:
        return;
    L148:
        r72 = null;
        goto L149
    L144:
        r70 = null;
    L160:
        if (r214 == false) goto L225;
        if (r13 == null) goto L225;
        int r88 = r42.mWidgetsMatchCount;
        if (r88 > 0) goto L165;
    L167:
        boolean r117 = false;
    L168:
        ConstraintWidget r89 = r13;
        ConstraintWidget r118 = r89;
    L169:
        if (r118 == null) goto L292;
        ConstraintWidget r90 = r118.mNextChainWidget[r10];
    L171:
        if (r90 == null) goto L176;
        if (r90.getVisibility() != 8) goto L176;
        r90 = r90.mNextChainWidget[r10];
    L176:
        if (r90 != null) goto L181;
        if (r118 == r14) goto L181;
    L221:
        if (r118.getVisibility() != 8) goto L224;
        r118 = r89;
    L224:
        r89 = r118;
        r118 = r90;
    L181:
        ConstraintAnchor r91 = r118.mListAnchors[r41];
        SolverVariable r92 = r91.mSolverVariable;
        ConstraintAnchor r93 = r91.mTarget;
        if (r93 == null) goto L184;
        SolverVariable r94 = r93.mSolverVariable;
    L185:
        if (r89 == r118) goto L188;
        ConstraintAnchor r95 = r89.mListAnchors[r41 + 1];
    L187:
        r94 = r95.mSolverVariable;
    L193:
        int r96 = r91.getMargin();
        int r97 = r41 + 1;
        int r98 = r118.mListAnchors[r97].getMargin();
        if (r90 == null) goto L197;
        ConstraintAnchor r99 = r90.mListAnchors[r41];
    L196:
        SolverVariable r100 = r99.mSolverVariable;
    L201:
        SolverVariable r101 = r118.mListAnchors[r97].mSolverVariable;
        if (r99 == null) goto L204;
        r98 = r98 + r99.getMargin();
    L204:
        int r102 = r96 + r89.mListAnchors[r97].getMargin();
        if (r92 == null) goto L221;
        if (r94 == null) goto L221;
        if (r100 == null) goto L221;
        if (r101 == null) goto L221;
        if (r118 != r13) goto L211;
        r102 = r13.mListAnchors[r41].getMargin();
    L211:
        int r103 = r102;
        if (r118 != r14) goto L214;
        int r119 = r14.mListAnchors[r97].getMargin();
    L215:
        if (r117 == false) goto L217;
        int r120 = 8;
    L218:
        r90 = r90;
        r39.addCentering(r92, r94, r103, 0.5f, r100, r101, r119, r120);
        goto L221
    L217:
        r120 = 5;
        goto L218
    L214:
        r119 = r98;
        goto L215
    L197:
        r99 = r12.mListAnchors[r97].mTarget;
        if (r99 != null) goto L196;
        r100 = null;
        goto L201
    L188:
        if (r118 != r13) goto L193;
        ConstraintAnchor[] r104 = r213.mListAnchors;
        if (r104[r41].mTarget == null) goto L192;
        r95 = r104[r41].mTarget;
        goto L187
    L192:
        r94 = null;
        goto L193
    L184:
        r94 = null;
        goto L185
    L165:
        if (r42.mWidgetsCount != r88) goto L167;
        r117 = true;
    L225:
        int r105 = 8;
        if (r110 == false) goto L292;
        if (r13 == null) goto L292;
        int r106 = r42.mWidgetsMatchCount;
        if (r106 > 0) goto L231;
    L233:
        boolean r121 = false;
    L234:
        ConstraintWidget r107 = r13;
        ConstraintWidget r122 = r107;
    L235:
        if (r122 == null) goto L281;
        ConstraintWidget r108 = r122.mNextChainWidget[r10];
    L237:
        if (r108 == null) goto L241;
        if (r108.getVisibility() != r105) goto L241;
        r108 = r108.mNextChainWidget[r10];
    L241:
        if (r122 == r13) goto L275;
        if (r122 == r14) goto L275;
        if (r108 == null) goto L275;
        if (r108 != r14) goto L246;
        ConstraintWidget r109 = null;
    L247:
        ConstraintAnchor r123 = r122.mListAnchors[r41];
        SolverVariable r124 = r123.mSolverVariable;
        ConstraintAnchor r125 = r123.mTarget;
        if (r125 == null) goto L250;
        SolverVariable r126 = r125.mSolverVariable;
    L250:
        int r127 = r41 + 1;
        SolverVariable r128 = r107.mListAnchors[r127].mSolverVariable;
        int r129 = r123.getMargin();
        int r130 = r122.mListAnchors[r127].getMargin();
        if (r109 == null) goto L257;
        ConstraintAnchor r131 = r109.mListAnchors[r41];
        SolverVariable r132 = r131.mSolverVariable;
        ConstraintAnchor r133 = r131.mTarget;
        if (r133 == null) goto L255;
        SolverVariable r134 = r133.mSolverVariable;
    L256:
        SolverVariable r135 = r134;
        SolverVariable r136 = r132;
    L262:
        if (r131 == null) goto L264;
        r130 = r130 + r131.getMargin();
    L264:
        int r137 = r130;
        int r138 = r107.mListAnchors[r127].getMargin() + r129;
        if (r121 == false) goto L267;
        int r139 = 8;
    L268:
        if (r124 == null) goto L273;
        if (r128 == null) goto L273;
        if (r136 == null) goto L273;
        if (r135 == null) goto L273;
        int r140 = 8;
        r39.addCentering(r124, r128, r138, 0.5f, r136, r135, r137, r139);
    L274:
        r108 = r109;
    L277:
        if (r122.getVisibility() == r140) goto L279;
        r107 = r122;
    L280:
        r122 = r108;
        r105 = r140;
        r10 = r40;
        goto L235
    L279:
        r107 = r107;
    L273:
        r140 = 8;
        goto L274
    L267:
        r139 = 4;
        goto L268
    L255:
        r134 = null;
        goto L256
    L257:
        r131 = r14.mListAnchors[r41];
        if (r131 == null) goto L260;
        r136 = r131.mSolverVariable;
    L261:
        r135 = r122.mListAnchors[r127].mSolverVariable;
        goto L262
    L260:
        r136 = null;
        goto L261
    L246:
        r109 = r108;
    L275:
        r107 = r107;
        r140 = r105;
        goto L277
    L281:
        ConstraintAnchor r141 = r13.mListAnchors[r41];
        ConstraintAnchor r142 = r213.mListAnchors[r41].mTarget;
        int r143 = r41 + 1;
        ConstraintAnchor r144 = r14.mListAnchors[r143];
        ConstraintAnchor r145 = r12.mListAnchors[r143].mTarget;
        if (r142 == null) goto L288;
        if (r13 == r14) goto L285;
        int r146 = 5;
        r39.addEquality(r141.mSolverVariable, r142.mSolverVariable, r141.getMargin(), 5);
    L289:
        if (r145 == null) goto L292;
        if (r13 == r14) goto L292;
        r39.addEquality(r144.mSolverVariable, r145.mSolverVariable, -r144.getMargin(), r146);
        goto L292
    L285:
        r146 = 5;
        if (r145 == null) goto L289;
        r39.addCentering(r141.mSolverVariable, r142.mSolverVariable, r141.getMargin(), 0.5f, r144.mSolverVariable, r145.mSolverVariable, r144.getMargin(), 5);
        goto L289
    L288:
        r146 = 5;
        goto L289
    L231:
        if (r42.mWidgetsCount != r106) goto L233;
        r121 = true;
    L25:
        r20 = true;
        goto L27
    L14:
        r110 = false;
        goto L15
    L11:
        r19 = false;
        goto L12
    L17:
        int r147 = r15.mVerticalChainStyle;
        if (r147 != 0) goto L20;
        r19 = true;
    L21:
        if (r147 != 1) goto L23;
        r110 = true;
    L24:
        if (r147 != 2) goto L26;
    L23:
        r110 = false;
        goto L24
    L20:
        r19 = false;
        goto L21
    L5:
        r17 = false;
        goto L7
    }

    public static void applyChainConstraints(ConstraintWidgetContainer r10, LinearSystem r11, ArrayList<ConstraintWidget> r12, int r13) {
        int r14 = 0;
        if (r13 != 0) goto L5;
        int r15 = r10.mHorizontalChainsSize;
        ChainHead[] r16 = r10.mHorizontalChainsArray;
        int r17 = 0;
    L6:
        if (r14 >= r15) goto L13;
        ChainHead r18 = r16[r14];
        r18.define();
        if (r12 != null) goto L10;
    L11:
        applyChainConstraints(r10, r11, r13, r17, r18);
    L12:
        r14 = r14 + 1;
        goto L6
    L10:
        if (r12.contains(r18.mFirst) == false) goto L12;
    L13:
        return;
    L5:
        int r19 = r10.mVerticalChainsSize;
        r16 = r10.mVerticalChainsArray;
        r17 = 2;
        r15 = r19;
        goto L6
    }
}
