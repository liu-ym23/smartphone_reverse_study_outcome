package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class Chain {
    private static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    public Chain() {
    }

    public static void applyChainConstraints(ConstraintWidgetContainer r10, LinearSystem r11, ArrayList<ConstraintWidget> r12, int r13) {
        int r5 = 0;
        if (r13 != 0) goto L5;
        int r14 = r10.mHorizontalChainsSize;
        ChainHead[] r15 = r10.mHorizontalChainsArray;
        int r16 = 0;
    L6:
        if (r5 >= r14) goto L13;
        ChainHead r17 = r15[r5];
        r17.define();
        if (r12 != null) goto L10;
    L11:
        applyChainConstraints(r10, r11, r13, r16, r17);
    L12:
        r5 = r5 + 1;
        goto L6
    L10:
        if (r12.contains(r17.mFirst) == false) goto L12;
    L13:
        return;
    L5:
        r14 = r10.mVerticalChainsSize;
        r15 = r10.mVerticalChainsArray;
        r16 = 2;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r38v0, types: [androidx.constraintlayout.solver.LinearSystem] */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28, types: [androidx.constraintlayout.solver.SolverVariable] */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r8v41 */
    /* JADX WARN: Type inference failed for: r8v42 */
    /* JADX WARN: Type inference failed for: r8v47 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.constraintlayout.solver.widgets.ConstraintWidget] */
    public static void applyChainConstraints(ConstraintWidgetContainer r37, LinearSystem r38, int r39, int r40, ChainHead r41) {
        ConstraintWidget r10 = r41.mFirst;
        ConstraintWidget r11 = r41.mLast;
        ConstraintWidget r12 = r41.mFirstVisibleWidget;
        ConstraintWidget r13 = r41.mLastVisibleWidget;
        ConstraintWidget r5 = r41.mHead;
        float r14 = r41.mTotalWeight;
        if (r37.mListDimensionBehaviors[r39] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L5;
        boolean r15 = true;
    L7:
        if (r39 != 0) goto L19;
        int r16 = r5.mHorizontalChainStyle;
        if (r16 != 0) goto L11;
        boolean r17 = true;
    L12:
        if (r16 != 1) goto L14;
        boolean r18 = true;
    L15:
        if (r16 != 2) goto L17;
    L16:
        boolean r19 = true;
    L18:
        boolean r110 = r18;
        boolean r20 = false;
        boolean r111 = r17;
        ?? r21 = r10;
    L28:
        Object r22 = null;
        if (r20 == true) goto L81;
        ConstraintAnchor r23 = r21.mListAnchors[r40];
        if (r19 == false) goto L33;
        int r112 = 1;
    L34:
        int r24 = r23.getMargin();
        ConstraintWidget.DimensionBehaviour r113 = r21.mListDimensionBehaviors[r39];
        float r25 = r14;
        ConstraintWidget.DimensionBehaviour r26 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r113 == r26) goto L37;
    L39:
        boolean r114 = false;
    L40:
        ConstraintAnchor r27 = r23.mTarget;
        if (r27 == null) goto L44;
        if (r21 == r10) goto L44;
        r24 = r27.getMargin() + r24;
    L44:
        int r28 = r24;
        if (r19 == false) goto L50;
        if (r21 == r10) goto L50;
        if (r21 == r12) goto L50;
        r112 = 8;
    L50:
        ConstraintAnchor r115 = r23.mTarget;
        if (r115 == null) goto L60;
        if (r21 != r12) goto L54;
        r38.addGreaterThan(r23.mSolverVariable, r115.mSolverVariable, r28, 6);
    L55:
        if (r114 == false) goto L58;
        if (r19 == true) goto L58;
        int r29 = 5;
    L59:
        r38.addEquality(r23.mSolverVariable, r23.mTarget.mSolverVariable, r28, r29);
    L61:
        if (r15 == true) goto L63;
    L69:
        ConstraintAnchor r30 = r21.mListAnchors[r40 + 1].mTarget;
        if (r30 == null) goto L77;
        ConstraintWidget r31 = r30.mOwner;
        ConstraintAnchor r32 = r31.mListAnchors[r40].mTarget;
        if (r32 == null) goto L77;
        if (r32.mOwner != r21) goto L77;
        r22 = r31;
    L77:
        if (r22 == null) goto L79;
        r21 = r22;
        r20 = r20;
    L80:
        r111 = r111;
        r14 = r25;
        r5 = r5;
        r10 = r10;
        r21 = r21;
        goto L28
    L79:
        r20 = true;
        goto L80
    L63:
        if (r21.getVisibility() != 8) goto L65;
    L67:
        int r33 = 0;
    L68:
        r38.addGreaterThan(r21.mListAnchors[r40].mSolverVariable, r37.mListAnchors[r40].mSolverVariable, r33, 8);
        goto L69
    L65:
        if (r21.mListDimensionBehaviors[r39] != r26) goto L67;
        ConstraintAnchor[] r34 = r21.mListAnchors;
        r33 = 0;
        r38.addGreaterThan(r34[r40 + 1].mSolverVariable, r34[r40].mSolverVariable, 0, 5);
    L58:
        r29 = r112;
        goto L59
    L54:
        r38.addGreaterThan(r23.mSolverVariable, r115.mSolverVariable, r28, 8);
        goto L55
    L60:
        r5 = r5;
        r10 = r10;
        goto L61
    L37:
        if (r21.mResolvedMatchConstraintDefault[r39] != 0) goto L39;
        r114 = true;
        goto L40
    L33:
        r112 = 4;
        goto L34
    L81:
        ConstraintWidget r210 = r5;
        float r211 = r14;
        ConstraintWidget r212 = r10;
        boolean r213 = r111;
        if (r13 == null) goto L100;
        int r35 = r40 + 1;
        if (r11.mListAnchors[r35].mTarget == null) goto L100;
        ConstraintAnchor r36 = r13.mListAnchors[r35];
        if (r13.mListDimensionBehaviors[r39] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L94;
        if (r13.mResolvedMatchConstraintDefault[r39] != 0) goto L94;
        if (r19 == true) goto L94;
        ConstraintAnchor r42 = r36.mTarget;
        if (r42.mOwner != r37) goto L94;
        r38.addEquality(r36.mSolverVariable, r42.mSolverVariable, -r36.getMargin(), 5);
    L98:
        r38.addLowerThan(r36.mSolverVariable, r11.mListAnchors[r35].mTarget.mSolverVariable, -r36.getMargin(), 6);
    L94:
        if (r19 == false) goto L98;
        ConstraintAnchor r43 = r36.mTarget;
        if (r43.mOwner != r37) goto L98;
        r38.addEquality(r36.mSolverVariable, r43.mSolverVariable, -r36.getMargin(), 4);
    L100:
        if (r15 == false) goto L102;
        int r44 = r40 + 1;
        SolverVariable r45 = r37.mListAnchors[r44].mSolverVariable;
        ConstraintAnchor r46 = r11.mListAnchors[r44];
        r38.addGreaterThan(r45, r46.mSolverVariable, r46.getMargin(), 8);
    L102:
        ArrayList<ConstraintWidget> r47 = r41.mWeightedMatchConstraintsWidgets;
        if (r47 == null) goto L131;
        int r48 = r47.size();
        if (r48 <= 1) goto L131;
        if (r41.mHasUndefinedWeights == true) goto L109;
    L111:
        float r49 = r211;
    L112:
        float r50 = 0.0f;
        float r214 = 0.0f;
        ConstraintWidget r51 = null;
        int r52 = 0;
    L113:
        if (r52 >= r48) goto L131;
        ConstraintWidget r53 = r47.get(r52);
        float r116 = r53.mWeight[r39];
        if (r116 >= r50) goto L122;
        if (r41.mHasComplexMatchWeights == false) goto L119;
        ConstraintAnchor[] r54 = r53.mListAnchors;
        r38.addEquality(r54[r40 + 1].mSolverVariable, r54[r40].mSolverVariable, 0, 4);
    L124:
        r47 = r47;
    L130:
        r52 = r52 + 1;
        r47 = r47;
        r50 = 0.0f;
        goto L113
    L119:
        r116 = 1.0f;
    L122:
        if (r116 != r50) goto L126;
        ConstraintAnchor[] r55 = r53.mListAnchors;
        r38.addEquality(r55[r40 + 1].mSolverVariable, r55[r40].mSolverVariable, 0, 8);
        goto L124
    L126:
        if (r51 == null) goto L129;
        ConstraintAnchor[] r56 = r51.mListAnchors;
        SolverVariable r57 = r56[r40].mSolverVariable;
        int r117 = r40 + 1;
        SolverVariable r58 = r56[r117].mSolverVariable;
        ConstraintAnchor[] r118 = r53.mListAnchors;
        SolverVariable r119 = r118[r40].mSolverVariable;
        SolverVariable r120 = r118[r117].mSolverVariable;
        ArrayRow r59 = r38.createRow();
        r59.createRowEqualMatchDimensions(r214, r49, r116, r57, r58, r119, r120);
        r38.addConstraint(r59);
    L129:
        r51 = r53;
        r214 = r116;
        goto L130
    L109:
        if (r41.mHasComplexMatchWeights == true) goto L111;
        r49 = r41.mWidgetsMatchCount;
    L131:
        if (r12 == null) goto L152;
        if (r12 == r13) goto L136;
        if (r19 == false) goto L152;
    L136:
        ConstraintAnchor r60 = r212.mListAnchors[r40];
        int r61 = r40 + 1;
        ConstraintAnchor r62 = r11.mListAnchors[r61];
        ConstraintAnchor r63 = r60.mTarget;
        if (r63 == null) goto L139;
        SolverVariable r64 = r63.mSolverVariable;
    L140:
        ConstraintAnchor r65 = r62.mTarget;
        if (r65 == null) goto L143;
        SolverVariable r66 = r65.mSolverVariable;
    L144:
        ConstraintAnchor r67 = r12.mListAnchors[r40];
        ConstraintAnchor r68 = r13.mListAnchors[r61];
        if (r64 == null) goto L279;
        if (r66 == null) goto L279;
        if (r39 != 0) goto L150;
        float r69 = r210.mHorizontalBiasPercent;
    L149:
        float r70 = r69;
        SolverVariable r71 = r64;
        r38.addCentering(r67.mSolverVariable, r71, r67.getMargin(), r70, r66, r68.mSolverVariable, r68.getMargin(), 7);
        goto L279
    L150:
        r69 = r210.mVerticalBiasPercent;
    L279:
        if (r213 == true) goto L281;
        if (r110 == true) goto L281;
        return;
    L281:
        if (r12 == null) goto L319;
        if (r12 == r13) goto L320;
        ConstraintAnchor[] r72 = r12.mListAnchors;
        ConstraintAnchor r73 = r72[r40];
        int r74 = r40 + 1;
        ConstraintAnchor r75 = r13.mListAnchors[r74];
        ConstraintAnchor r76 = r73.mTarget;
        if (r76 == null) goto L286;
        SolverVariable r77 = r76.mSolverVariable;
    L287:
        ConstraintAnchor r78 = r75.mTarget;
        if (r78 == null) goto L290;
        ?? r79 = r78.mSolverVariable;
    L291:
        if (r11 == r13) goto L296;
        ConstraintAnchor r80 = r11.mListAnchors[r74].mTarget;
        if (r80 == null) goto L295;
        r22 = r80.mSolverVariable;
    L295:
        r79 = r22;
    L296:
        if (r12 != r13) goto L298;
        r75 = r72[r74];
    L298:
        if (r77 == null) goto L321;
        if (r79 == 0) goto L322;
        int r81 = r73.getMargin();
        int r82 = r13.mListAnchors[r74].getMargin();
        r38.addCentering(r73.mSolverVariable, r77, r81, 0.5f, r79, r75.mSolverVariable, r82, 5);
        return;
    L322:
        return;
    L321:
        return;
    L290:
        r79 = 0;
        goto L291
    L286:
        r77 = null;
        goto L287
    L320:
        return;
    L319:
        return;
    L143:
        r66 = null;
        goto L144
    L139:
        r64 = null;
    L152:
        if (r213 == false) goto L214;
        if (r12 == null) goto L214;
        int r83 = r41.mWidgetsMatchCount;
        if (r83 > 0) goto L157;
    L159:
        boolean r215 = false;
    L160:
        ConstraintWidget r121 = r12;
        ConstraintWidget r122 = r121;
    L161:
        if (r121 == null) goto L279;
        ConstraintWidget r84 = r121.mNextChainWidget[r39];
    L163:
        if (r84 == null) goto L168;
        if (r84.getVisibility() != 8) goto L168;
        r84 = r84.mNextChainWidget[r39];
    L168:
        if (r84 != null) goto L172;
        if (r121 == r13) goto L172;
    L211:
        if (r121.getVisibility() == 8) goto L213;
        r122 = r121;
    L213:
        r121 = r84;
    L172:
        ConstraintAnchor r85 = r121.mListAnchors[r40];
        SolverVariable r86 = r85.mSolverVariable;
        ConstraintAnchor r87 = r85.mTarget;
        if (r87 == null) goto L175;
        SolverVariable r88 = r87.mSolverVariable;
    L176:
        if (r122 == r121) goto L178;
        r88 = r122.mListAnchors[r40 + 1].mSolverVariable;
    L184:
        int r89 = r85.getMargin();
        int r90 = r40 + 1;
        int r91 = r121.mListAnchors[r90].getMargin();
        if (r84 == null) goto L187;
        ConstraintAnchor r92 = r84.mListAnchors[r40];
        SolverVariable r93 = r92.mSolverVariable;
        SolverVariable r94 = r121.mListAnchors[r90].mSolverVariable;
        SolverVariable r95 = r93;
    L192:
        if (r92 == null) goto L194;
        r91 = r91 + r92.getMargin();
    L194:
        if (r122 == null) goto L196;
        r89 = r89 + r122.mListAnchors[r90].getMargin();
    L196:
        if (r86 == null) goto L211;
        if (r88 == null) goto L211;
        if (r95 == null) goto L211;
        if (r94 == null) goto L211;
        if (r121 != r12) goto L202;
        r89 = r12.mListAnchors[r40].getMargin();
    L202:
        int r96 = r89;
        if (r121 != r13) goto L205;
        int r123 = r13.mListAnchors[r90].getMargin();
    L206:
        if (r215 == false) goto L208;
        int r124 = 8;
    L209:
        r38.addCentering(r86, r88, r96, 0.5f, r95, r94, r123, r124);
        goto L211
    L208:
        r124 = 5;
        goto L209
    L205:
        r123 = r91;
        goto L206
    L187:
        r92 = r11.mListAnchors[r90].mTarget;
        if (r92 == null) goto L190;
        r95 = r92.mSolverVariable;
    L191:
        r94 = r121.mListAnchors[r90].mSolverVariable;
        goto L192
    L190:
        r95 = null;
        goto L191
    L178:
        if (r121 != r12) goto L184;
        if (r122 != r121) goto L184;
        ConstraintAnchor r97 = r212.mListAnchors[r40].mTarget;
        if (r97 == null) goto L183;
        r88 = r97.mSolverVariable;
        goto L184
    L183:
        r88 = null;
        goto L184
    L175:
        r88 = null;
        goto L176
    L157:
        if (r41.mWidgetsCount != r83) goto L159;
        r215 = true;
    L214:
        int r98 = 8;
        if (r110 == false) goto L279;
        if (r12 == null) goto L279;
        int r99 = r41.mWidgetsMatchCount;
        if (r99 > 0) goto L220;
    L222:
        boolean r216 = false;
    L223:
        ConstraintWidget r125 = r12;
        ConstraintWidget r126 = r125;
    L224:
        if (r125 == null) goto L270;
        ConstraintWidget r100 = r125.mNextChainWidget[r39];
    L226:
        if (r100 == null) goto L230;
        if (r100.getVisibility() != r98) goto L230;
        r100 = r100.mNextChainWidget[r39];
    L230:
        if (r125 == r12) goto L264;
        if (r125 == r13) goto L264;
        if (r100 == null) goto L264;
        if (r100 != r13) goto L235;
        ConstraintWidget r101 = null;
    L236:
        ConstraintAnchor r102 = r125.mListAnchors[r40];
        SolverVariable r103 = r102.mSolverVariable;
        ConstraintAnchor r104 = r102.mTarget;
        if (r104 == null) goto L239;
        SolverVariable r105 = r104.mSolverVariable;
    L239:
        int r106 = r40 + 1;
        SolverVariable r107 = r126.mListAnchors[r106].mSolverVariable;
        int r108 = r102.getMargin();
        int r109 = r125.mListAnchors[r106].getMargin();
        if (r101 == null) goto L245;
        ConstraintAnchor r127 = r101.mListAnchors[r40];
        SolverVariable r128 = r127.mSolverVariable;
        ConstraintAnchor r129 = r127.mTarget;
        if (r129 == null) goto L244;
        SolverVariable r130 = r129.mSolverVariable;
    L250:
        if (r127 == null) goto L252;
        int r131 = r127.getMargin() + r109;
    L253:
        int r132 = r126.mListAnchors[r106].getMargin() + r108;
        if (r216 == false) goto L256;
        int r133 = 8;
    L257:
        if (r103 == null) goto L262;
        if (r107 == null) goto L262;
        if (r128 == null) goto L262;
        if (r130 == null) goto L262;
        int r134 = 8;
        r38.addCentering(r103, r107, r132, 0.5f, r128, r130, r131, r133);
    L263:
        r100 = r101;
    L266:
        if (r125.getVisibility() != r134) goto L269;
        r125 = r126;
    L269:
        r98 = r134;
        r126 = r125;
        r125 = r100;
    L262:
        r134 = 8;
        goto L263
    L256:
        r133 = 4;
        goto L257
    L252:
        r131 = r109;
        goto L253
    L244:
        r130 = null;
        goto L250
    L245:
        r127 = r13.mListAnchors[r40];
        if (r127 == null) goto L248;
        r128 = r127.mSolverVariable;
    L249:
        r130 = r125.mListAnchors[r106].mSolverVariable;
        goto L250
    L248:
        r128 = null;
        goto L249
    L235:
        r101 = r100;
    L264:
        r126 = r126;
        r134 = r98;
        goto L266
    L270:
        ConstraintAnchor r135 = r12.mListAnchors[r40];
        ConstraintAnchor r136 = r212.mListAnchors[r40].mTarget;
        int r137 = r40 + 1;
        ConstraintAnchor r138 = r13.mListAnchors[r137];
        ConstraintAnchor r139 = r11.mListAnchors[r137].mTarget;
        if (r136 == null) goto L276;
        if (r12 == r13) goto L274;
        r38.addEquality(r135.mSolverVariable, r136.mSolverVariable, r135.getMargin(), 5);
        goto L276
    L274:
        if (r139 == null) goto L276;
        r38.addCentering(r135.mSolverVariable, r136.mSolverVariable, r135.getMargin(), 0.5f, r138.mSolverVariable, r139.mSolverVariable, r138.getMargin(), 5);
    L276:
        if (r139 == null) goto L279;
        if (r12 == r13) goto L279;
        r38.addEquality(r138.mSolverVariable, r139.mSolverVariable, -r138.getMargin(), 5);
        goto L279
    L220:
        if (r41.mWidgetsCount != r99) goto L222;
        r216 = true;
    L17:
        r19 = false;
        goto L18
    L14:
        r18 = false;
        goto L15
    L11:
        r17 = false;
        goto L12
    L19:
        int r140 = r5.mVerticalChainStyle;
        if (r140 != 0) goto L22;
        r17 = true;
    L23:
        if (r140 != 1) goto L25;
        r18 = true;
    L26:
        if (r140 != 2) goto L17;
    L25:
        r18 = false;
        goto L26
    L22:
        r17 = false;
        goto L23
    L5:
        r15 = false;
        goto L7
    }
}
