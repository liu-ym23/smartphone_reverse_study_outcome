package com.lynx.tasm.behavior.ui.list;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AbsLynxList$$PropsSetter extends UISimpleView$$PropsSetter {
    public AbsLynxList$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r6, String r7, x0 r8) {
        AbsLynxList r0 = (AbsLynxList) r6;
        r7.getClass();
        byte r4 = -1;
        switch(r7.hashCode()) {
            case -1910309744: goto L118;
            case -1866276358: goto L114;
            case -1856561977: goto L110;
            case -1571036001: goto L106;
            case -1554128936: goto L102;
            case -1270238455: goto L98;
            case -892259863: goto L94;
            case -656627599: goto L90;
            case -592430592: goto L86;
            case -505303290: goto L82;
            case -447418808: goto L78;
            case -411446853: goto L74;
            case -402166408: goto L70;
            case -402166407: goto L66;
            case -169901481: goto L62;
            case -137292606: goto L58;
            case 10993126: goto L54;
            case 409686694: goto L50;
            case 660290816: goto L46;
            case 693516932: goto L42;
            case 875338749: goto L38;
            case 913884495: goto L34;
            case 1191691203: goto L30;
            case 1296520439: goto L26;
            case 1367907611: goto L22;
            case 1406408041: goto L18;
            case 1861761406: goto L14;
            case 1883148160: goto L10;
            case 2107607620: goto L6;
            default: goto L122;
        };
    L6:
        if (r7.equals("item-snap") == false) goto L122;
        r4 = 28;
        goto L122
    L10:
        if (r7.equals("update-animation") == false) goto L122;
        r4 = 27;
        goto L122
    L14:
        if (r7.equals("scroll-state-change-event-throttle") == false) goto L122;
        r4 = 26;
        goto L122
    L18:
        if (r7.equals("internal-cell-prepare-for-reuse-notification") == false) goto L122;
        r4 = 25;
        goto L122
    L22:
        if (r7.equals("touch-scroll") == false) goto L122;
        r4 = 24;
        goto L122
    L26:
        if (r7.equals("sticky-offset") == false) goto L122;
        r4 = 23;
        goto L122
    L30:
        if (r7.equals("lower-threshold-item-count") == false) goto L122;
        r4 = 22;
        goto L122
    L34:
        if (r7.equals("list-main-axis-gap") == false) goto L122;
        r4 = 21;
        goto L122
    L38:
        if (r7.equals("scroll-event-throttle") == false) goto L122;
        r4 = 20;
        goto L122
    L42:
        if (r7.equals("cache-queue-ratio") == false) goto L122;
        r4 = 19;
        goto L122
    L46:
        if (r7.equals("upper-threshold") == false) goto L122;
        r4 = 18;
        goto L122
    L50:
        if (r7.equals("list-cross-axis-gap") == false) goto L122;
        r4 = 17;
        goto L122
    L54:
        if (r7.equals("over-scroll") == false) goto L122;
        r4 = 16;
        goto L122
    L58:
        if (r7.equals("upper-threshold-item-count") == false) goto L122;
        r4 = 15;
        goto L122
    L62:
        if (r7.equals("enable-scroll") == false) goto L122;
        r4 = 14;
        goto L122
    L66:
        if (r7.equals("scroll-y") == false) goto L122;
        r4 = 13;
        goto L122
    L70:
        if (r7.equals("scroll-x") == false) goto L122;
        r4 = 12;
        goto L122
    L74:
        if (r7.equals("initial-scroll-index") == false) goto L122;
        r4 = 11;
        goto L122
    L78:
        if (r7.equals("internal-cell-appear-notification") == false) goto L122;
        r4 = 10;
        goto L122
    L82:
        if (r7.equals("needs-visible-cells") == false) goto L122;
        r4 = 9;
        goto L122
    L86:
        if (r7.equals("paging-enabled") == false) goto L122;
        r4 = 8;
        goto L122
    L90:
        if (r7.equals("component-init-measure") == false) goto L122;
        r4 = 7;
        goto L122
    L94:
        if (r7.equals("sticky") == false) goto L122;
        r4 = 6;
        goto L122
    L98:
        if (r7.equals("list-type") == false) goto L122;
        r4 = 5;
        goto L122
    L102:
        if (r7.equals("column-count") == false) goto L122;
        r4 = 4;
        goto L122
    L106:
        if (r7.equals("lower-threshold") == false) goto L122;
        r4 = 3;
        goto L122
    L110:
        if (r7.equals("no-invalidate") == false) goto L122;
        r4 = 2;
        goto L122
    L114:
        if (r7.equals("should-request-state-restore") == false) goto L122;
        r4 = 1;
        goto L122
    L118:
        if (r7.equals("internal-cell-disappear-notification") == false) goto L122;
        r4 = 0;
    L122:
        switch(r4) {
            case 0: goto L181;
            case 1: goto L179;
            case 2: goto L177;
            case 3: goto L175;
            case 4: goto L173;
            case 5: goto L171;
            case 6: goto L169;
            case 7: goto L167;
            case 8: goto L165;
            case 9: goto L163;
            case 10: goto L161;
            case 11: goto L159;
            case 12: goto L157;
            case 13: goto L155;
            case 14: goto L153;
            case 15: goto L151;
            case 16: goto L149;
            case 17: goto L147;
            case 18: goto L145;
            case 19: goto L143;
            case 20: goto L141;
            case 21: goto L139;
            case 22: goto L137;
            case 23: goto L135;
            case 24: goto L133;
            case 25: goto L131;
            case 26: goto L129;
            case 27: goto L127;
            case 28: goto L125;
            default: goto L123;
        };
    L123:
        super.setProperty(r6, r7, r8);
        return;
    L125:
        r0.setPagingAlignment(r8.g(r7));
        return;
    L127:
        r0.setUpdateAnimation(r8.h(r7));
        return;
    L129:
        r0.setScrollStateChangeEventThrottle(r8.h(r7));
        return;
    L131:
        r0.setInternalCellPrepareForReuseNotification(r8.b(r7, false));
        return;
    L133:
        r0.setTouchScroll(r8.d(r7));
        return;
    L135:
        r0.setStickyOffset(r8.d(r7));
        return;
    L137:
        r0.setLowerThresholdItemCount(r8.d(r7));
        return;
    L139:
        r0.setMainAxisGap(r8.e(r7, 0.0f));
        return;
    L141:
        r0.setScrollEventThrottle(r8.d(r7));
        return;
    L143:
        r0.setCacheQueueRatio(r8.d(r7));
        return;
    L145:
        r0.setUpperThreshold(r8.d(r7));
        return;
    L147:
        r0.setCrossAxisGap(r8.e(r7, 0.0f));
        return;
    L149:
        r0.setOverScroll(r8.d(r7));
        return;
    L151:
        r0.setUpperThresholdItemCount(r8.d(r7));
        return;
    L153:
        r0.setScrollEnable(r8.d(r7));
        return;
    L155:
        r0.setScrollY(r8.d(r7));
        return;
    L157:
        r0.setScrollX(r8.d(r7));
        return;
    L159:
        r0.setInitialScrollIndex(r8.d(r7));
        return;
    L161:
        r0.setInternalCellAppearNotification(r8.b(r7, false));
        return;
    L163:
        r0.setNeedVisibleCells(r8.b(r7, false));
        return;
    L165:
        r0.setEnablePagerSnap(r8.d(r7));
        return;
    L167:
        r0.setComponentInitMeasure(r8.b(r7, false));
        return;
    L169:
        r0.setEnableSticky(r8.d(r7));
        return;
    L171:
        r0.setListType(r8.h(r7));
        return;
    L173:
        r0.setColumnCount(r8.f(r7, 1));
        return;
    L175:
        r0.setLowerThreshold(r8.d(r7));
        return;
    L177:
        r0.setNoInvalidate(r8.b(r7, false));
        return;
    L179:
        r0.setShouldRequestStateRestore(r8.b(r7, false));
        return;
    L181:
        r0.setInternalCellDisappearNotification(r8.b(r7, false));
    }
}
