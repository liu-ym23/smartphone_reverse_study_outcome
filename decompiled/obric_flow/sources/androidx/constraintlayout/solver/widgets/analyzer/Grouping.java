package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Flow;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.HelperWidget;
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
        int r5 = r10.horizontalGroup;
    L5:
        int r14 = 0;
        if (r5 == (-1)) goto L19;
        if (r13 != null) goto L9;
    L10:
        int r15 = 0;
    L12:
        if (r15 >= r12.size()) goto L21;
        WidgetGroup r16 = r12.get(r15);
        if (r16.getId() == r5) goto L15;
        r15 = r15 + 1;
        goto L12
    L15:
        if (r13 == null) goto L17;
        r13.moveTo(r11, r16);
        r12.remove(r13);
    L17:
        r13 = r16;
    L21:
        if (r13 != null) goto L37;
        if ((r10 instanceof HelperWidget) == false) goto L33;
        int r17 = ((HelperWidget) r10).findGroupInDependents(r11);
        if (r17 == (-1)) goto L33;
        int r18 = 0;
    L28:
        if (r18 >= r12.size()) goto L33;
        WidgetGroup r19 = r12.get(r18);
        if (r19.getId() == r17) goto L31;
        r18 = r18 + 1;
        goto L28
    L31:
        r13 = r19;
    L33:
        if (r13 != null) goto L35;
        r13 = new WidgetGroup(r11);
    L35:
        r12.add(r13);
    L37:
        if (r13.add(r10) == true) goto L39;
    L48:
        return r13;
    L39:
        if ((r10 instanceof Guideline) == false) goto L44;
        Guideline r20 = (Guideline) r10;
        ConstraintAnchor r21 = r20.getAnchor();
        if (r20.getOrientation() != 0) goto L43;
        r14 = 1;
    L43:
        r21.findDependents(r14, r12, r13);
    L44:
        if (r11 != 0) goto L46;
        r10.horizontalGroup = r13.getId();
        r10.mLeft.findDependents(r11, r12, r13);
        r10.mRight.findDependents(r11, r12, r13);
    L47:
        r10.mCenter.findDependents(r11, r12, r13);
        goto L48
    L46:
        r10.verticalGroup = r13.getId();
        r10.mTop.findDependents(r11, r12, r13);
        r10.mBaseline.findDependents(r11, r12, r13);
        r10.mBottom.findDependents(r11, r12, r13);
        goto L47
    L9:
        if (r5 != r13.f440id) goto L10;
    L19:
        if (r5 == (-1)) goto L21;
        return r13;
    L4:
        r5 = r10.verticalGroup;
        goto L5
    }

    private static WidgetGroup findGroup(ArrayList<WidgetGroup> r5, int r10) {
        int r11 = r5.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        WidgetGroup r13 = r5.get(r12);
        if (r10 == r13.f440id) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r13;
    L8:
        return null;
    }

    public static boolean simpleSolvingPass(ConstraintWidgetContainer r16, BasicMeasure.Measurer r17) {
        ArrayList<ConstraintWidget> r5 = r16.getChildren();
        int r10 = r5.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L11;
        ConstraintWidget r12 = r5.get(r11);
        if (validInGroup(r16.getHorizontalDimensionBehaviour(), r16.getVerticalDimensionBehaviour(), r12.getHorizontalDimensionBehaviour(), r12.getVerticalDimensionBehaviour()) == false) goto L6;
        if ((r12 instanceof Flow) == true) goto L9;
        r11 = r11 + 1;
        goto L3
    L9:
        return false;
    L6:
        return false;
    L11:
        Metrics r13 = r16.mMetrics;
        if (r13 == null) goto L14;
        r13.grouping++;
    L14:
        int r14 = 0;
        ArrayList r15 = null;
        ArrayList r18 = null;
        ArrayList r19 = null;
        ArrayList r20 = null;
        ArrayList r110 = null;
        ArrayList r111 = null;
    L16:
        if (r14 >= r10) goto L77;
        ConstraintWidget r112 = r5.get(r14);
        if (validInGroup(r16.getHorizontalDimensionBehaviour(), r16.getVerticalDimensionBehaviour(), r112.getHorizontalDimensionBehaviour(), r112.getVerticalDimensionBehaviour()) == true) goto L21;
        ConstraintWidgetContainer.measure(r112, r17, r16.mMeasure, BasicMeasure.Measure.SELF_DIMENSIONS);
    L21:
        boolean r21 = r112 instanceof Guideline;
        if (r21 == false) goto L34;
        Guideline r22 = (Guideline) r112;
        if (r22.getOrientation() != 0) goto L29;
        if (r19 != null) goto L27;
        r19 = new ArrayList();
    L27:
        r19.add(r22);
    L29:
        if (r22.getOrientation() != 1) goto L34;
        if (r15 != null) goto L32;
        r15 = new ArrayList();
    L32:
        r15.add(r22);
    L34:
        if ((r112 instanceof HelperWidget) == false) goto L55;
        if ((r112 instanceof Barrier) == false) goto L47;
        Barrier r23 = (Barrier) r112;
        if (r23.getOrientation() != 0) goto L43;
        if (r18 != null) goto L41;
        r18 = new ArrayList();
    L41:
        r18.add(r23);
    L43:
        if (r23.getOrientation() != 1) goto L55;
        if (r20 != null) goto L46;
        r20 = new ArrayList();
    L46:
        r20.add(r23);
        goto L55
    L47:
        HelperWidget r24 = (HelperWidget) r112;
        if (r18 != null) goto L50;
        r18 = new ArrayList();
    L50:
        r18.add(r24);
        if (r20 != null) goto L53;
        r20 = new ArrayList();
    L53:
        r20.add(r24);
    L55:
        if (r112.mLeft.mTarget != null) goto L65;
        if (r112.mRight.mTarget != null) goto L65;
        if (r21 == true) goto L65;
        if ((r112 instanceof Barrier) == true) goto L65;
        if (r110 != null) goto L63;
        r110 = new ArrayList();
    L63:
        r110.add(r112);
    L65:
        if (r112.mTop.mTarget != null) goto L76;
        if (r112.mBottom.mTarget != null) goto L76;
        if (r112.mBaseline.mTarget != null) goto L76;
        if (r21 == true) goto L76;
        if ((r112 instanceof Barrier) == true) goto L76;
        if (r111 != null) goto L75;
        r111 = new ArrayList();
    L75:
        r111.add(r112);
    L76:
        r14 = r14 + 1;
        goto L16
    L77:
        ArrayList<WidgetGroup> r25 = new ArrayList();
        if (r15 == null) goto L83;
        Iterator r26 = r15.iterator();
    L81:
        if (r26.hasNext() == false) goto L83;
        findDependents((Guideline) r26.next(), 0, r25, null);
    L83:
        int r27 = 0;
        WidgetGroup r113 = null;
        if (r18 == null) goto L89;
        Iterator r28 = r18.iterator();
    L87:
        if (r28.hasNext() == false) goto L89;
        HelperWidget r29 = (HelperWidget) r28.next();
        WidgetGroup r30 = findDependents(r29, r27, r25, r113);
        r29.addDependents(r25, r27, r30);
        r30.cleanup(r25);
        r27 = 0;
        r113 = null;
    L89:
        ConstraintAnchor r31 = r16.getAnchor(ConstraintAnchor.Type.LEFT);
        if (r31.getDependents() == null) goto L95;
        Iterator<ConstraintAnchor> r32 = r31.getDependents().iterator();
    L93:
        if (r32.hasNext() == false) goto L95;
        findDependents(r32.next().mOwner, 0, r25, null);
    L95:
        ConstraintAnchor r33 = r16.getAnchor(ConstraintAnchor.Type.RIGHT);
        if (r33.getDependents() == null) goto L101;
        Iterator<ConstraintAnchor> r34 = r33.getDependents().iterator();
    L99:
        if (r34.hasNext() == false) goto L101;
        findDependents(r34.next().mOwner, 0, r25, null);
    L101:
        ConstraintAnchor r35 = r16.getAnchor(ConstraintAnchor.Type.CENTER);
        if (r35.getDependents() == null) goto L107;
        Iterator<ConstraintAnchor> r36 = r35.getDependents().iterator();
    L105:
        if (r36.hasNext() == false) goto L107;
        findDependents(r36.next().mOwner, 0, r25, null);
    L107:
        WidgetGroup r37 = null;
        if (r110 == null) goto L113;
        Iterator r38 = r110.iterator();
    L111:
        if (r38.hasNext() == false) goto L113;
        findDependents((ConstraintWidget) r38.next(), 0, r25, null);
    L113:
        if (r19 == null) goto L118;
        Iterator r39 = r19.iterator();
    L116:
        if (r39.hasNext() == false) goto L118;
        findDependents((Guideline) r39.next(), 1, r25, null);
    L118:
        if (r20 == null) goto L123;
        Iterator r40 = r20.iterator();
    L121:
        if (r40.hasNext() == false) goto L123;
        HelperWidget r41 = (HelperWidget) r40.next();
        WidgetGroup r42 = findDependents(r41, 1, r25, r37);
        r41.addDependents(r25, 1, r42);
        r42.cleanup(r25);
        r37 = null;
    L123:
        ConstraintAnchor r43 = r16.getAnchor(ConstraintAnchor.Type.TOP);
        if (r43.getDependents() == null) goto L129;
        Iterator<ConstraintAnchor> r44 = r43.getDependents().iterator();
    L127:
        if (r44.hasNext() == false) goto L129;
        findDependents(r44.next().mOwner, 1, r25, null);
    L129:
        ConstraintAnchor r45 = r16.getAnchor(ConstraintAnchor.Type.BASELINE);
        if (r45.getDependents() == null) goto L135;
        Iterator<ConstraintAnchor> r46 = r45.getDependents().iterator();
    L133:
        if (r46.hasNext() == false) goto L135;
        findDependents(r46.next().mOwner, 1, r25, null);
    L135:
        ConstraintAnchor r47 = r16.getAnchor(ConstraintAnchor.Type.BOTTOM);
        if (r47.getDependents() == null) goto L141;
        Iterator<ConstraintAnchor> r48 = r47.getDependents().iterator();
    L139:
        if (r48.hasNext() == false) goto L141;
        findDependents(r48.next().mOwner, 1, r25, null);
    L141:
        ConstraintAnchor r49 = r16.getAnchor(ConstraintAnchor.Type.CENTER);
        if (r49.getDependents() == null) goto L148;
        Iterator<ConstraintAnchor> r50 = r49.getDependents().iterator();
    L145:
        if (r50.hasNext() == false) goto L148;
        findDependents(r50.next().mOwner, 1, r25, null);
    L148:
        if (r111 == null) goto L153;
        Iterator r51 = r111.iterator();
    L151:
        if (r51.hasNext() == false) goto L153;
        findDependents((ConstraintWidget) r51.next(), 1, r25, null);
    L153:
        int r52 = 0;
    L154:
        if (r52 >= r10) goto L163;
        ConstraintWidget r53 = r5.get(r52);
        if (r53.oppositeDimensionsTied() == false) goto L161;
        WidgetGroup r54 = findGroup(r25, r53.horizontalGroup);
        WidgetGroup r55 = findGroup(r25, r53.verticalGroup);
        if (r54 == null) goto L161;
        if (r55 == null) goto L161;
        r54.moveTo(0, r55);
        r55.setOrientation(2);
        r25.remove(r54);
    L161:
        r52 = r52 + 1;
        goto L154
    L163:
        if (r25.size() > 1) goto L167;
        return false;
    L167:
        if (r16.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L179;
        Iterator<WidgetGroup> r56 = r25.iterator();
        WidgetGroup r57 = null;
        int r58 = 0;
    L170:
        if (r56.hasNext() == false) goto L177;
        WidgetGroup r59 = r56.next();
        if (r59.getOrientation() == 1) goto L170;
        r59.setAuthoritative(false);
        int r60 = r59.measureWrap(r16.getSystem(), 0);
        if (r60 <= r58) goto L170;
        r57 = r59;
        r58 = r60;
        goto L170
    L177:
        if (r57 == null) goto L179;
        r16.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r16.setWidth(r58);
        r57.setAuthoritative(true);
    L181:
        if (r16.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L194;
        Iterator<WidgetGroup> r61 = r25.iterator();
        WidgetGroup r62 = null;
        int r63 = 0;
    L184:
        if (r61.hasNext() == false) goto L191;
        WidgetGroup r64 = r61.next();
        if (r64.getOrientation() == 0) goto L184;
        r64.setAuthoritative(false);
        int r65 = r64.measureWrap(r16.getSystem(), 1);
        if (r65 <= r63) goto L184;
        r62 = r64;
        r63 = r65;
        goto L184
    L191:
        boolean r66 = false;
        if (r62 == null) goto L195;
        r16.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r16.setHeight(r63);
        r62.setAuthoritative(true);
        WidgetGroup r67 = r62;
    L196:
        if (r57 != null) goto L201;
        if (r67 != null) goto L201;
        return r66;
    L201:
        return true;
    L195:
        r67 = null;
        goto L196
    L194:
        r66 = false;
    L179:
        r57 = null;
        goto L181
    }

    public static boolean validInGroup(ConstraintWidget.DimensionBehaviour r5, ConstraintWidget.DimensionBehaviour r10, ConstraintWidget.DimensionBehaviour r11, ConstraintWidget.DimensionBehaviour r12) {
        ConstraintWidget.DimensionBehaviour r13 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r11 == r13) goto L11;
        ConstraintWidget.DimensionBehaviour r14 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r11 == r14) goto L11;
        if (r11 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L10;
        if (r5 != r14) goto L11;
    L10:
        boolean r15 = false;
    L12:
        if (r12 == r13) goto L20;
        ConstraintWidget.DimensionBehaviour r16 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r12 == r16) goto L20;
        if (r12 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L19;
        if (r10 != r16) goto L20;
    L19:
        boolean r17 = false;
    L21:
        if (r15 == true) goto L25;
        if (r17 == true) goto L25;
        return false;
    L25:
        return true;
    L20:
        r17 = true;
    L11:
        r15 = true;
        goto L12
    }
}
