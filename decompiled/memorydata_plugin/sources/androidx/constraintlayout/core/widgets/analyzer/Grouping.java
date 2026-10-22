package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Flow;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class Grouping {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_GROUPING = false;

    public Grouping() {
    }

    public static WidgetGroup findDependents(ConstraintWidget r7, int r8, ArrayList<WidgetGroup> r9, WidgetGroup r10) {
        if (r8 != 0) goto L4;
        int r0 = r7.horizontalGroup;
    L5:
        int r1 = 0;
        if (r0 == (-1)) goto L19;
        if (r10 != null) goto L9;
    L10:
        int r4 = 0;
    L12:
        if (r4 >= r9.size()) goto L21;
        WidgetGroup r5 = (WidgetGroup) ZeusTransformUtils.preCheckCast(r9.get(r4), WidgetGroup.class, "com.obric.memorydata.plugin");
        if (r5.getId() == r0) goto L15;
        r4 = r4 + 1;
        goto L12
    L15:
        if (r10 == null) goto L17;
        r10.moveTo(r8, r5);
        r9.remove(r10);
    L17:
        r10 = r5;
    L21:
        if (r10 != null) goto L37;
        if (ZeusTransformUtils.instanceOf(r7, HelperWidget.class) == false) goto L33;
        int r2 = ((HelperWidget) ZeusTransformUtils.preCheckCast(r7, HelperWidget.class, "com.obric.memorydata.plugin")).findGroupInDependents(r8);
        if (r2 == (-1)) goto L33;
        int r3 = 0;
    L28:
        if (r3 >= r9.size()) goto L33;
        WidgetGroup r6 = (WidgetGroup) ZeusTransformUtils.preCheckCast(r9.get(r3), WidgetGroup.class, "com.obric.memorydata.plugin");
        if (r6.getId() == r2) goto L31;
        r3 = r3 + 1;
        goto L28
    L31:
        r10 = r6;
    L33:
        if (r10 != null) goto L35;
        r10 = new WidgetGroup(r8);
    L35:
        r9.add(r10);
    L37:
        if (r10.add(r7) == true) goto L39;
    L49:
        return r10;
    L39:
        if (ZeusTransformUtils.instanceOf(r7, Guideline.class) == false) goto L44;
        Guideline r11 = (Guideline) ZeusTransformUtils.preCheckCast(r7, Guideline.class, "com.obric.memorydata.plugin");
        ConstraintAnchor r12 = r11.getAnchor();
        if (r11.getOrientation() != 0) goto L43;
        r1 = 1;
    L43:
        r12.findDependents(r1, r9, r10);
    L44:
        int r13 = r10.getId();
        if (r8 != 0) goto L47;
        r7.horizontalGroup = r13;
        r7.mLeft.findDependents(r8, r9, r10);
        ConstraintAnchor r14 = r7.mRight;
    L48:
        r14.findDependents(r8, r9, r10);
        r7.mCenter.findDependents(r8, r9, r10);
        goto L49
    L47:
        r7.verticalGroup = r13;
        r7.mTop.findDependents(r8, r9, r10);
        r7.mBaseline.findDependents(r8, r9, r10);
        r14 = r7.mBottom;
        goto L48
    L9:
        if (r0 != r10.id) goto L10;
    L19:
        if (r0 == (-1)) goto L21;
        return r10;
    L4:
        r0 = r7.verticalGroup;
        goto L5
    }

    private static WidgetGroup findGroup(ArrayList<WidgetGroup> r5, int r6) {
        int r0 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        WidgetGroup r2 = (WidgetGroup) ZeusTransformUtils.preCheckCast(r5.get(r1), WidgetGroup.class, "com.obric.memorydata.plugin");
        if (r6 == r2.id) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return null;
    }

    public static boolean simpleSolvingPass(ConstraintWidgetContainer r17, BasicMeasure.Measurer r18) {
        BasicMeasure.Measurer r1 = (BasicMeasure.Measurer) ZeusTransformUtils.wrapperContextForParams(r18, BasicMeasure.Measurer.class, "com.obric.memorydata.plugin");
        ArrayList<ConstraintWidget> r3 = r17.getChildren();
        int r4 = r3.size();
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L12;
        ConstraintWidget r7 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r3.get(r6), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (validInGroup(r17.getHorizontalDimensionBehaviour(), r17.getVerticalDimensionBehaviour(), r7.getHorizontalDimensionBehaviour(), r7.getVerticalDimensionBehaviour()) == false) goto L6;
        if (ZeusTransformUtils.instanceOf(r7, Flow.class) == true) goto L9;
        r6 = r6 + 1;
        goto L3
    L9:
        return false;
    L6:
        return false;
    L12:
        if (r17.mMetrics == null) goto L14;
        r17.mMetrics.grouping++;
    L14:
        int r8 = 0;
        ArrayList r9 = null;
        ArrayList r10 = null;
        ArrayList r11 = null;
        ArrayList r12 = null;
        ArrayList r13 = null;
        ArrayList r14 = null;
    L15:
        if (r8 >= r4) goto L76;
        ConstraintWidget r15 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r3.get(r8), ConstraintWidget.class, "com.obric.memorydata.plugin");
        ArrayList<ConstraintWidget> r16 = r3;
        if (validInGroup(r17.getHorizontalDimensionBehaviour(), r17.getVerticalDimensionBehaviour(), r15.getHorizontalDimensionBehaviour(), r15.getVerticalDimensionBehaviour()) == true) goto L20;
        ConstraintWidgetContainer.measure(0, r15, r1, r17.mMeasure, BasicMeasure.Measure.SELF_DIMENSIONS);
    L20:
        if (ZeusTransformUtils.instanceOf(r15, Guideline.class) == false) goto L32;
        Guideline r5 = (Guideline) ZeusTransformUtils.preCheckCast(r15, Guideline.class, "com.obric.memorydata.plugin");
        if (r5.getOrientation() != 0) goto L27;
        if (r11 != null) goto L25;
        r11 = new ArrayList();
    L25:
        r11.add(r5);
    L27:
        if (r5.getOrientation() != 1) goto L32;
        if (r9 != null) goto L30;
        r9 = new ArrayList();
    L30:
        r9.add(r5);
    L32:
        if (ZeusTransformUtils.instanceOf(r15, HelperWidget.class) == false) goto L52;
        if (ZeusTransformUtils.instanceOf(r15, Barrier.class) == false) goto L44;
        Barrier r19 = (Barrier) ZeusTransformUtils.preCheckCast(r15, Barrier.class, "com.obric.memorydata.plugin");
        if (r19.getOrientation() != 0) goto L40;
        if (r10 != null) goto L39;
        r10 = new ArrayList();
    L39:
        r10.add(r19);
    L40:
        int r20 = r19.getOrientation();
        Object r21 = r19;
        if (r20 != 1) goto L52;
        if (r12 != null) goto L50;
        r12 = new ArrayList();
        r21 = r19;
    L50:
        r12.add(r21);
        goto L52
    L44:
        HelperWidget r22 = (HelperWidget) ZeusTransformUtils.preCheckCast(r15, HelperWidget.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L47;
        r10 = new ArrayList();
    L47:
        r10.add(r22);
        r21 = r22;
        if (r12 != null) goto L50;
        r12 = new ArrayList();
        r21 = r22;
    L52:
        if (r15.mLeft.mTarget != null) goto L63;
        if (r15.mRight.mTarget != null) goto L63;
        if (ZeusTransformUtils.instanceOf(r15, Guideline.class) == true) goto L63;
        if (ZeusTransformUtils.instanceOf(r15, Barrier.class) == true) goto L63;
        if (r13 != null) goto L61;
        r13 = new ArrayList();
    L61:
        r13.add(r15);
    L63:
        if (r15.mTop.mTarget != null) goto L75;
        if (r15.mBottom.mTarget != null) goto L75;
        if (r15.mBaseline.mTarget != null) goto L75;
        if (ZeusTransformUtils.instanceOf(r15, Guideline.class) == true) goto L75;
        if (ZeusTransformUtils.instanceOf(r15, Barrier.class) == true) goto L75;
        if (r14 != null) goto L74;
        r14 = new ArrayList();
    L74:
        r14.add(r15);
    L75:
        r8 = r8 + 1;
        r3 = r16;
        goto L15
    L76:
        ArrayList<ConstraintWidget> r110 = r3;
        ArrayList<WidgetGroup> r2 = new ArrayList();
        if (r9 == null) goto L82;
        Iterator r23 = r9.iterator();
    L80:
        if (r23.hasNext() == false) goto L82;
        findDependents((Guideline) ZeusTransformUtils.preCheckCast(r23.next(), Guideline.class, "com.obric.memorydata.plugin"), 0, r2, null);
    L82:
        if (r10 == null) goto L87;
        Iterator r24 = r10.iterator();
    L85:
        if (r24.hasNext() == false) goto L87;
        HelperWidget r25 = (HelperWidget) ZeusTransformUtils.preCheckCast(r24.next(), HelperWidget.class, "com.obric.memorydata.plugin");
        WidgetGroup r26 = findDependents(r25, 0, r2, null);
        r25.addDependents(r2, 0, r26);
        r26.cleanup(r2);
    L87:
        ConstraintAnchor r27 = r17.getAnchor(ConstraintAnchor.Type.LEFT);
        if (r27.getDependents() == null) goto L93;
        Iterator<ConstraintAnchor> r28 = r27.getDependents().iterator();
    L91:
        if (r28.hasNext() == false) goto L93;
        findDependents(((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r28.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).mOwner, 0, r2, null);
    L93:
        ConstraintAnchor r29 = r17.getAnchor(ConstraintAnchor.Type.RIGHT);
        if (r29.getDependents() == null) goto L99;
        Iterator<ConstraintAnchor> r30 = r29.getDependents().iterator();
    L97:
        if (r30.hasNext() == false) goto L99;
        findDependents(((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r30.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).mOwner, 0, r2, null);
    L99:
        ConstraintAnchor r31 = r17.getAnchor(ConstraintAnchor.Type.CENTER);
        if (r31.getDependents() == null) goto L105;
        Iterator<ConstraintAnchor> r32 = r31.getDependents().iterator();
    L103:
        if (r32.hasNext() == false) goto L105;
        findDependents(((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r32.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).mOwner, 0, r2, null);
    L105:
        if (r13 == null) goto L110;
        Iterator r33 = r13.iterator();
    L108:
        if (r33.hasNext() == false) goto L110;
        findDependents((ConstraintWidget) ZeusTransformUtils.preCheckCast(r33.next(), ConstraintWidget.class, "com.obric.memorydata.plugin"), 0, r2, null);
    L110:
        if (r11 == null) goto L115;
        Iterator r34 = r11.iterator();
    L113:
        if (r34.hasNext() == false) goto L115;
        findDependents((Guideline) ZeusTransformUtils.preCheckCast(r34.next(), Guideline.class, "com.obric.memorydata.plugin"), 1, r2, null);
    L115:
        if (r12 == null) goto L120;
        Iterator r35 = r12.iterator();
    L118:
        if (r35.hasNext() == false) goto L120;
        HelperWidget r36 = (HelperWidget) ZeusTransformUtils.preCheckCast(r35.next(), HelperWidget.class, "com.obric.memorydata.plugin");
        WidgetGroup r37 = findDependents(r36, 1, r2, null);
        r36.addDependents(r2, 1, r37);
        r37.cleanup(r2);
    L120:
        ConstraintAnchor r38 = r17.getAnchor(ConstraintAnchor.Type.TOP);
        if (r38.getDependents() == null) goto L126;
        Iterator<ConstraintAnchor> r39 = r38.getDependents().iterator();
    L124:
        if (r39.hasNext() == false) goto L126;
        findDependents(((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r39.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).mOwner, 1, r2, null);
    L126:
        ConstraintAnchor r40 = r17.getAnchor(ConstraintAnchor.Type.BASELINE);
        if (r40.getDependents() == null) goto L132;
        Iterator<ConstraintAnchor> r41 = r40.getDependents().iterator();
    L130:
        if (r41.hasNext() == false) goto L132;
        findDependents(((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r41.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).mOwner, 1, r2, null);
    L132:
        ConstraintAnchor r42 = r17.getAnchor(ConstraintAnchor.Type.BOTTOM);
        if (r42.getDependents() == null) goto L138;
        Iterator<ConstraintAnchor> r43 = r42.getDependents().iterator();
    L136:
        if (r43.hasNext() == false) goto L138;
        findDependents(((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r43.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).mOwner, 1, r2, null);
    L138:
        ConstraintAnchor r44 = r17.getAnchor(ConstraintAnchor.Type.CENTER);
        if (r44.getDependents() == null) goto L144;
        Iterator<ConstraintAnchor> r45 = r44.getDependents().iterator();
    L142:
        if (r45.hasNext() == false) goto L144;
        findDependents(((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r45.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).mOwner, 1, r2, null);
    L144:
        if (r14 == null) goto L149;
        Iterator r46 = r14.iterator();
    L147:
        if (r46.hasNext() == false) goto L149;
        findDependents((ConstraintWidget) ZeusTransformUtils.preCheckCast(r46.next(), ConstraintWidget.class, "com.obric.memorydata.plugin"), 1, r2, null);
    L149:
        int r47 = 0;
    L150:
        if (r47 >= r4) goto L159;
        ArrayList<ConstraintWidget> r48 = r110;
        ConstraintWidget r49 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r48.get(r47), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r49.oppositeDimensionsTied() == false) goto L157;
        WidgetGroup r50 = findGroup(r2, r49.horizontalGroup);
        WidgetGroup r51 = findGroup(r2, r49.verticalGroup);
        if (r50 == null) goto L157;
        if (r51 == null) goto L157;
        r50.moveTo(0, r51);
        r51.setOrientation(2);
        r2.remove(r50);
    L157:
        r47 = r47 + 1;
        r110 = r48;
        goto L150
    L159:
        if (r2.size() > 1) goto L163;
        return false;
    L163:
        if (r17.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L175;
        Iterator<WidgetGroup> r52 = r2.iterator();
        WidgetGroup r53 = null;
        int r111 = 0;
    L166:
        if (r52.hasNext() == false) goto L173;
        WidgetGroup r54 = (WidgetGroup) ZeusTransformUtils.preCheckCast(r52.next(), WidgetGroup.class, "com.obric.memorydata.plugin");
        if (r54.getOrientation() == 1) goto L166;
        r54.setAuthoritative(false);
        int r55 = r54.measureWrap(r17.getSystem(), 0);
        if (r55 <= r111) goto L166;
        r53 = r54;
        r111 = r55;
        goto L166
    L173:
        if (r53 == null) goto L175;
        r17.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r17.setWidth(r111);
        r53.setAuthoritative(true);
    L177:
        if (r17.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L190;
        Iterator<WidgetGroup> r56 = r2.iterator();
        WidgetGroup r57 = null;
        int r112 = 0;
    L180:
        if (r56.hasNext() == false) goto L187;
        WidgetGroup r58 = (WidgetGroup) ZeusTransformUtils.preCheckCast(r56.next(), WidgetGroup.class, "com.obric.memorydata.plugin");
        if (r58.getOrientation() == 0) goto L180;
        r58.setAuthoritative(false);
        int r59 = r58.measureWrap(r17.getSystem(), 1);
        if (r59 <= r112) goto L180;
        r57 = r58;
        r112 = r59;
        goto L180
    L187:
        boolean r60 = false;
        boolean r61 = true;
        if (r57 == null) goto L191;
        r17.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r17.setHeight(r112);
        r57.setAuthoritative(true);
    L192:
        if (r53 != null) goto L197;
        if (r57 != null) goto L197;
        return r60;
    L197:
        return r61;
    L191:
        r57 = null;
        goto L192
    L190:
        r60 = false;
        r61 = true;
    L175:
        r53 = null;
        goto L177
    }

    public static boolean validInGroup(ConstraintWidget.DimensionBehaviour r3, ConstraintWidget.DimensionBehaviour r4, ConstraintWidget.DimensionBehaviour r5, ConstraintWidget.DimensionBehaviour r6) {
        if (r5 != ConstraintWidget.DimensionBehaviour.FIXED) goto L5;
    L12:
        boolean r7 = true;
    L14:
        if (r6 != ConstraintWidget.DimensionBehaviour.FIXED) goto L16;
    L23:
        boolean r8 = true;
    L24:
        if (r7 == true) goto L28;
        if (r8 == true) goto L28;
        return false;
    L28:
        return true;
    L16:
        if (r6 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L23;
        if (r6 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L20;
    L22:
        r8 = false;
        goto L24
    L20:
        if (r4 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L22;
    L5:
        if (r5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L12;
        if (r5 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L9;
    L11:
        r7 = false;
        goto L14
    L9:
        if (r3 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L11;
        goto L11
    }
}
