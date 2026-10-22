package com.lynx.tasm.behavior.ui.list;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class AbsLynxList$$PropsSetter extends UISimpleView$$PropsSetter {
    public AbsLynxList$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void a(LynxBaseUI r10, String r11, y0 r12) {
        AbsLynxList r5 = (AbsLynxList) r10;
        r11.getClass();
        byte r13 = -1;
        switch(r11.hashCode()) {
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
            default: goto L121;
        };
    L121:
        switch(r13) {
            case 0: goto L180;
            case 1: goto L178;
            case 2: goto L176;
            case 3: goto L174;
            case 4: goto L172;
            case 5: goto L170;
            case 6: goto L168;
            case 7: goto L166;
            case 8: goto L164;
            case 9: goto L162;
            case 10: goto L160;
            case 11: goto L158;
            case 12: goto L156;
            case 13: goto L154;
            case 14: goto L152;
            case 15: goto L150;
            case 16: goto L148;
            case 17: goto L146;
            case 18: goto L144;
            case 19: goto L142;
            case 20: goto L140;
            case 21: goto L138;
            case 22: goto L136;
            case 23: goto L134;
            case 24: goto L132;
            case 25: goto L130;
            case 26: goto L128;
            case 27: goto L126;
            case 28: goto L124;
            default: goto L122;
        };
    L122:
        super.a(r10, r11, r12);
        return;
    L124:
        r5.setPagingAlignment(r12.f10815a.getMap(r11));
        return;
    L126:
        r5.setUpdateAnimation(r12.f10815a.getString(r11));
        return;
    L128:
        r5.setScrollStateChangeEventThrottle(r12.f10815a.getString(r11));
        return;
    L130:
        r5.setInternalCellPrepareForReuseNotification(r12.e(r11, false));
        return;
    L132:
        r5.setTouchScroll(r12.f10815a.getDynamic(r11));
        return;
    L134:
        r5.setStickyOffset(r12.f10815a.getDynamic(r11));
        return;
    L136:
        r5.setLowerThresholdItemCount(r12.f10815a.getDynamic(r11));
        return;
    L138:
        r5.setMainAxisGap(r12.b(0.0f, r11));
        return;
    L140:
        r5.setScrollEventThrottle(r12.f10815a.getDynamic(r11));
        return;
    L142:
        r5.setCacheQueueRatio(r12.f10815a.getDynamic(r11));
        return;
    L144:
        r5.setUpperThreshold(r12.f10815a.getDynamic(r11));
        return;
    L146:
        r5.setCrossAxisGap(r12.b(0.0f, r11));
        return;
    L148:
        r5.setOverScroll(r12.f10815a.getDynamic(r11));
        return;
    L150:
        r5.setUpperThresholdItemCount(r12.f10815a.getDynamic(r11));
        return;
    L152:
        r5.setScrollEnable(r12.f10815a.getDynamic(r11));
        return;
    L154:
        r5.setScrollY(r12.f10815a.getDynamic(r11));
        return;
    L156:
        r5.setScrollX(r12.f10815a.getDynamic(r11));
        return;
    L158:
        r5.setInitialScrollIndex(r12.f10815a.getDynamic(r11));
        return;
    L160:
        r5.setInternalCellAppearNotification(r12.e(r11, false));
        return;
    L162:
        r5.setNeedVisibleCells(r12.e(r11, false));
        return;
    L164:
        r5.setEnablePagerSnap(r12.f10815a.getDynamic(r11));
        return;
    L166:
        r5.setComponentInitMeasure(r12.e(r11, false));
        return;
    L168:
        r5.setEnableSticky(r12.f10815a.getDynamic(r11));
        return;
    L170:
        r5.setListType(r12.f10815a.getString(r11));
        return;
    L172:
        r5.setColumnCount(r12.c(r11, 1));
        return;
    L174:
        r5.setLowerThreshold(r12.f10815a.getDynamic(r11));
        return;
    L176:
        r5.setNoInvalidate(r12.e(r11, false));
        return;
    L178:
        r5.setShouldRequestStateRestore(r12.e(r11, false));
        return;
    L180:
        r5.setInternalCellDisappearNotification(r12.e(r11, false));
        return;
    L6:
        if (r11.equals("item-snap") == false) goto L121;
        r13 = 28;
        goto L121
    L10:
        if (r11.equals("update-animation") == false) goto L121;
        r13 = 27;
        goto L121
    L14:
        if (r11.equals("scroll-state-change-event-throttle") == false) goto L121;
        r13 = 26;
        goto L121
    L18:
        if (r11.equals("internal-cell-prepare-for-reuse-notification") == false) goto L121;
        r13 = 25;
        goto L121
    L22:
        if (r11.equals("touch-scroll") == false) goto L121;
        r13 = 24;
        goto L121
    L26:
        if (r11.equals("sticky-offset") == false) goto L121;
        r13 = 23;
        goto L121
    L30:
        if (r11.equals("lower-threshold-item-count") == false) goto L121;
        r13 = 22;
        goto L121
    L34:
        if (r11.equals("list-main-axis-gap") == false) goto L121;
        r13 = 21;
        goto L121
    L38:
        if (r11.equals("scroll-event-throttle") == false) goto L121;
        r13 = 20;
        goto L121
    L42:
        if (r11.equals("cache-queue-ratio") == false) goto L121;
        r13 = 19;
        goto L121
    L46:
        if (r11.equals("upper-threshold") == false) goto L121;
        r13 = 18;
        goto L121
    L50:
        if (r11.equals("list-cross-axis-gap") == false) goto L121;
        r13 = 17;
        goto L121
    L54:
        if (r11.equals("over-scroll") == false) goto L121;
        r13 = 16;
        goto L121
    L58:
        if (r11.equals("upper-threshold-item-count") == false) goto L121;
        r13 = 15;
        goto L121
    L62:
        if (r11.equals("enable-scroll") == false) goto L121;
        r13 = 14;
        goto L121
    L66:
        if (r11.equals("scroll-y") == false) goto L121;
        r13 = 13;
        goto L121
    L70:
        if (r11.equals("scroll-x") == false) goto L121;
        r13 = 12;
        goto L121
    L74:
        if (r11.equals("initial-scroll-index") == false) goto L121;
        r13 = 11;
        goto L121
    L78:
        if (r11.equals("internal-cell-appear-notification") == false) goto L121;
        r13 = 10;
        goto L121
    L82:
        if (r11.equals("needs-visible-cells") == false) goto L121;
        r13 = 9;
        goto L121
    L86:
        if (r11.equals("paging-enabled") == false) goto L121;
        r13 = 8;
        goto L121
    L90:
        if (r11.equals("component-init-measure") == false) goto L121;
        r13 = 7;
        goto L121
    L94:
        if (r11.equals("sticky") == false) goto L121;
        r13 = 6;
        goto L121
    L98:
        if (r11.equals("list-type") == false) goto L121;
        r13 = 5;
        goto L121
    L102:
        if (r11.equals("column-count") == false) goto L121;
        r13 = 4;
        goto L121
    L106:
        if (r11.equals("lower-threshold") == false) goto L121;
        r13 = 3;
        goto L121
    L110:
        if (r11.equals("no-invalidate") == false) goto L121;
        r13 = 2;
        goto L121
    L114:
        if (r11.equals("should-request-state-restore") == false) goto L121;
        r13 = 1;
        goto L121
    L118:
        if (r11.equals("internal-cell-disappear-notification") == false) goto L121;
        r13 = 0;
        goto L121
    }
}
