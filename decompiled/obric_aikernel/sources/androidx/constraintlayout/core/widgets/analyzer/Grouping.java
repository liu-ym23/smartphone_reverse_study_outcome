package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Flow;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class Grouping {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_GROUPING = false;

    public Grouping() {
    }

    public static WidgetGroup findDependents(ConstraintWidget r10, int r11, ArrayList<WidgetGroup> r12, WidgetGroup r13) {
        if (r11 != 0) goto L4;
        int r14 = r10.horizontalGroup;
    L5:
        int r15 = 0;
        if (r14 == (-1)) goto L19;
        if (r13 != null) goto L9;
    L10:
        int r16 = 0;
    L12:
        if (r16 >= r12.size()) goto L21;
        WidgetGroup r17 = r12.get(r16);
        if (r17.getId() == r14) goto L15;
        r16 = r16 + 1;
        goto L12
    L15:
        if (r13 == null) goto L17;
        r13.moveTo(r11, r17);
        r12.remove(r13);
    L17:
        r13 = r17;
    L21:
        if (r13 != null) goto L37;
        if ((r10 instanceof HelperWidget) == false) goto L33;
        int r18 = ((HelperWidget) r10).findGroupInDependents(r11);
        if (r18 == (-1)) goto L33;
        int r19 = 0;
    L28:
        if (r19 >= r12.size()) goto L33;
        WidgetGroup r20 = r12.get(r19);
        if (r20.getId() == r18) goto L31;
        r19 = r19 + 1;
        goto L28
    L31:
        r13 = r20;
    L33:
        if (r13 != null) goto L35;
        r13 = new WidgetGroup(r11);
    L35:
        r12.add(r13);
    L37:
        if (r13.add(r10) == true) goto L39;
    L49:
        return r13;
    L39:
        if ((r10 instanceof Guideline) == false) goto L44;
        Guideline r21 = (Guideline) r10;
        ConstraintAnchor r22 = r21.getAnchor();
        if (r21.getOrientation() != 0) goto L43;
        r15 = 1;
    L43:
        r22.findDependents(r15, r12, r13);
    L44:
        int r23 = r13.getId();
        if (r11 != 0) goto L47;
        r10.horizontalGroup = r23;
        r10.mLeft.findDependents(r11, r12, r13);
        ConstraintAnchor r24 = r10.mRight;
    L48:
        r24.findDependents(r11, r12, r13);
        r10.mCenter.findDependents(r11, r12, r13);
        goto L49
    L47:
        r10.verticalGroup = r23;
        r10.mTop.findDependents(r11, r12, r13);
        r10.mBaseline.findDependents(r11, r12, r13);
        r24 = r10.mBottom;
        goto L48
    L9:
        if (r14 != r13.id) goto L10;
    L19:
        if (r14 == (-1)) goto L21;
        return r13;
    L4:
        r14 = r10.verticalGroup;
        goto L5
    }

    private static WidgetGroup findGroup(ArrayList<WidgetGroup> r10, int r11) {
        int r12 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        WidgetGroup r14 = r10.get(r13);
        if (r11 == r14.id) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r14;
    L8:
        return null;
    }

    public static boolean simpleSolvingPass(ConstraintWidgetContainer r16, BasicMeasure.Measurer r17) {
        ArrayList<ConstraintWidget> r10 = r16.getChildren();
        int r11 = r10.size();
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L11;
        ConstraintWidget r14 = r10.get(r13);
        if (validInGroup(r16.getHorizontalDimensionBehaviour(), r16.getVerticalDimensionBehaviour(), r14.getHorizontalDimensionBehaviour(), r14.getVerticalDimensionBehaviour()) == false) goto L6;
        if ((r14 instanceof Flow) == true) goto L9;
        r13 = r13 + 1;
        goto L3
    L9:
        return false;
    L6:
        return false;
    L11:
        Metrics r15 = r16.mMetrics;
        if (r15 == null) goto L14;
        r15.grouping++;
    L14:
        int r18 = 0;
        ArrayList r19 = null;
        ArrayList r20 = null;
        ArrayList r21 = null;
        ArrayList r22 = null;
        ArrayList r110 = null;
        ArrayList r111 = null;
    L15:
        if (r18 >= r11) goto L75;
        ConstraintWidget r112 = r10.get(r18);
        if (validInGroup(r16.getHorizontalDimensionBehaviour(), r16.getVerticalDimensionBehaviour(), r112.getHorizontalDimensionBehaviour(), r112.getVerticalDimensionBehaviour()) == true) goto L20;
        ConstraintWidgetContainer.measure(r12, r112, r17, r16.mMeasure, BasicMeasure.Measure.SELF_DIMENSIONS);
    L20:
        boolean r23 = r112 instanceof Guideline;
        if (r23 == false) goto L33;
        Guideline r113 = (Guideline) r112;
        if (r113.getOrientation() != 0) goto L28;
        if (r21 != null) goto L26;
        r21 = new ArrayList();
    L26:
        r21.add(r113);
    L28:
        if (r113.getOrientation() != 1) goto L33;
        if (r19 != null) goto L31;
        r19 = new ArrayList();
    L31:
        r19.add(r113);
    L33:
        if ((r112 instanceof HelperWidget) == false) goto L53;
        if ((r112 instanceof Barrier) == false) goto L45;
        Barrier r24 = (Barrier) r112;
        if (r24.getOrientation() != 0) goto L41;
        if (r20 != null) goto L40;
        r20 = new ArrayList();
    L40:
        r20.add(r24);
    L41:
        int r114 = r24.getOrientation();
        Object r25 = r24;
        if (r114 != 1) goto L53;
        if (r22 != null) goto L51;
        r22 = new ArrayList();
        r25 = r24;
    L51:
        r22.add(r25);
        goto L53
    L45:
        HelperWidget r26 = (HelperWidget) r112;
        if (r20 != null) goto L48;
        r20 = new ArrayList();
    L48:
        r20.add(r26);
        r25 = r26;
        if (r22 != null) goto L51;
        r22 = new ArrayList();
        r25 = r26;
    L53:
        if (r112.mLeft.mTarget != null) goto L63;
        if (r112.mRight.mTarget != null) goto L63;
        if (r23 == true) goto L63;
        if ((r112 instanceof Barrier) == true) goto L63;
        if (r110 != null) goto L61;
        r110 = new ArrayList();
    L61:
        r110.add(r112);
    L63:
        if (r112.mTop.mTarget != null) goto L74;
        if (r112.mBottom.mTarget != null) goto L74;
        if (r112.mBaseline.mTarget != null) goto L74;
        if (r23 == true) goto L74;
        if ((r112 instanceof Barrier) == true) goto L74;
        if (r111 != null) goto L73;
        r111 = new ArrayList();
    L73:
        r111.add(r112);
    L74:
        r18 = r18 + 1;
        r12 = 0;
        goto L15
    L75:
        ArrayList<WidgetGroup> r27 = new ArrayList();
        if (r19 == null) goto L81;
        Iterator r28 = r19.iterator();
    L79:
        if (r28.hasNext() == false) goto L81;
        findDependents((Guideline) r28.next(), 0, r27, null);
    L81:
        int r29 = 0;
        WidgetGroup r115 = null;
        if (r20 == null) goto L87;
        Iterator r30 = r20.iterator();
    L85:
        if (r30.hasNext() == false) goto L87;
        HelperWidget r31 = (HelperWidget) r30.next();
        WidgetGroup r32 = findDependents(r31, r29, r27, r115);
        r31.addDependents(r27, r29, r32);
        r32.cleanup(r27);
        r29 = 0;
        r115 = null;
    L87:
        ConstraintAnchor r33 = r16.getAnchor(ConstraintAnchor.Type.LEFT);
        if (r33.getDependents() == null) goto L93;
        Iterator<ConstraintAnchor> r34 = r33.getDependents().iterator();
    L91:
        if (r34.hasNext() == false) goto L93;
        findDependents(r34.next().mOwner, 0, r27, null);
    L93:
        ConstraintAnchor r35 = r16.getAnchor(ConstraintAnchor.Type.RIGHT);
        if (r35.getDependents() == null) goto L99;
        Iterator<ConstraintAnchor> r36 = r35.getDependents().iterator();
    L97:
        if (r36.hasNext() == false) goto L99;
        findDependents(r36.next().mOwner, 0, r27, null);
    L99:
        ConstraintAnchor r37 = r16.getAnchor(ConstraintAnchor.Type.CENTER);
        if (r37.getDependents() == null) goto L105;
        Iterator<ConstraintAnchor> r38 = r37.getDependents().iterator();
    L103:
        if (r38.hasNext() == false) goto L105;
        findDependents(r38.next().mOwner, 0, r27, null);
    L105:
        WidgetGroup r39 = null;
        if (r110 == null) goto L111;
        Iterator r40 = r110.iterator();
    L109:
        if (r40.hasNext() == false) goto L111;
        findDependents((ConstraintWidget) r40.next(), 0, r27, null);
    L111:
        if (r21 == null) goto L116;
        Iterator r41 = r21.iterator();
    L114:
        if (r41.hasNext() == false) goto L116;
        findDependents((Guideline) r41.next(), 1, r27, null);
    L116:
        int r42 = 1;
        if (r22 == null) goto L122;
        Iterator r43 = r22.iterator();
    L120:
        if (r43.hasNext() == false) goto L122;
        HelperWidget r44 = (HelperWidget) r43.next();
        WidgetGroup r45 = findDependents(r44, r42, r27, r39);
        r44.addDependents(r27, r42, r45);
        r45.cleanup(r27);
        r42 = 1;
        r39 = null;
    L122:
        ConstraintAnchor r46 = r16.getAnchor(ConstraintAnchor.Type.TOP);
        if (r46.getDependents() == null) goto L128;
        Iterator<ConstraintAnchor> r47 = r46.getDependents().iterator();
    L126:
        if (r47.hasNext() == false) goto L128;
        findDependents(r47.next().mOwner, 1, r27, null);
    L128:
        ConstraintAnchor r48 = r16.getAnchor(ConstraintAnchor.Type.BASELINE);
        if (r48.getDependents() == null) goto L134;
        Iterator<ConstraintAnchor> r49 = r48.getDependents().iterator();
    L132:
        if (r49.hasNext() == false) goto L134;
        findDependents(r49.next().mOwner, 1, r27, null);
    L134:
        ConstraintAnchor r50 = r16.getAnchor(ConstraintAnchor.Type.BOTTOM);
        if (r50.getDependents() == null) goto L140;
        Iterator<ConstraintAnchor> r51 = r50.getDependents().iterator();
    L138:
        if (r51.hasNext() == false) goto L140;
        findDependents(r51.next().mOwner, 1, r27, null);
    L140:
        ConstraintAnchor r52 = r16.getAnchor(ConstraintAnchor.Type.CENTER);
        if (r52.getDependents() == null) goto L147;
        Iterator<ConstraintAnchor> r53 = r52.getDependents().iterator();
    L144:
        if (r53.hasNext() == false) goto L147;
        findDependents(r53.next().mOwner, 1, r27, null);
    L147:
        if (r111 == null) goto L152;
        Iterator r54 = r111.iterator();
    L150:
        if (r54.hasNext() == false) goto L152;
        findDependents((ConstraintWidget) r54.next(), 1, r27, null);
    L152:
        int r55 = 0;
    L153:
        if (r55 >= r11) goto L162;
        ConstraintWidget r56 = r10.get(r55);
        if (r56.oppositeDimensionsTied() == false) goto L160;
        WidgetGroup r57 = findGroup(r27, r56.horizontalGroup);
        WidgetGroup r58 = findGroup(r27, r56.verticalGroup);
        if (r57 == null) goto L160;
        if (r58 == null) goto L160;
        r57.moveTo(0, r58);
        r58.setOrientation(2);
        r27.remove(r57);
    L160:
        r55 = r55 + 1;
        goto L153
    L162:
        if (r27.size() > 1) goto L166;
        return false;
    L166:
        if (r16.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L178;
        Iterator<WidgetGroup> r59 = r27.iterator();
        WidgetGroup r60 = null;
        int r61 = 0;
    L169:
        if (r59.hasNext() == false) goto L176;
        WidgetGroup r62 = r59.next();
        if (r62.getOrientation() == 1) goto L169;
        r62.setAuthoritative(false);
        int r63 = r62.measureWrap(r16.getSystem(), 0);
        if (r63 <= r61) goto L169;
        r60 = r62;
        r61 = r63;
        goto L169
    L176:
        if (r60 == null) goto L178;
        r16.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r16.setWidth(r61);
        r60.setAuthoritative(true);
    L180:
        if (r16.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L193;
        Iterator<WidgetGroup> r64 = r27.iterator();
        WidgetGroup r65 = null;
        int r66 = 0;
    L183:
        if (r64.hasNext() == false) goto L190;
        WidgetGroup r67 = r64.next();
        if (r67.getOrientation() == 0) goto L183;
        r67.setAuthoritative(false);
        int r68 = r67.measureWrap(r16.getSystem(), 1);
        if (r68 <= r66) goto L183;
        r65 = r67;
        r66 = r68;
        goto L183
    L190:
        boolean r69 = false;
        boolean r70 = true;
        if (r65 == null) goto L194;
        r16.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r16.setHeight(r66);
        r65.setAuthoritative(true);
        WidgetGroup r71 = r65;
    L195:
        if (r60 != null) goto L200;
        if (r71 != null) goto L200;
        return r69;
    L200:
        return r70;
    L194:
        r71 = null;
        goto L195
    L193:
        r69 = false;
        r70 = true;
    L178:
        r60 = null;
        goto L180
    }

    public static boolean validInGroup(ConstraintWidget.DimensionBehaviour r10, ConstraintWidget.DimensionBehaviour r11, ConstraintWidget.DimensionBehaviour r12, ConstraintWidget.DimensionBehaviour r13) {
        ConstraintWidget.DimensionBehaviour r14 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r12 == r14) goto L11;
        ConstraintWidget.DimensionBehaviour r15 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r12 == r15) goto L11;
        if (r12 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L10;
        if (r10 != r15) goto L11;
    L10:
        boolean r16 = false;
    L12:
        if (r13 == r14) goto L20;
        ConstraintWidget.DimensionBehaviour r17 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r13 == r17) goto L20;
        if (r13 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L19;
        if (r11 != r17) goto L20;
    L19:
        boolean r18 = false;
    L21:
        if (r16 == true) goto L25;
        if (r18 == true) goto L25;
        return false;
    L25:
        return true;
    L20:
        r18 = true;
    L11:
        r16 = true;
        goto L12
    }
}
